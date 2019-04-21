package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the nephrology_case_sheet table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="nephrology_case_sheet"
 */

public abstract class BaseNephrologyCaseSheet  implements Serializable {

	public static String REF = "NephrologyCaseSheet";
	public static String PROP_FITNESS_PROCEDURE_DETAILS = "FitnessProcedureDetails";
	public static String PROP_ABDOMINAL_PAIN_DETAILS = "AbdominalPainDetails";
	public static String PROP_P_A_REMARLKS = "PARemarlks";
	public static String PROP_HERMATURIA_COFFEE_COLOURED_DURATION = "HermaturiaCoffeeColouredDuration";
	public static String PROP_EDEMA = "Edema";
	public static String PROP_CHRONIC_NOT_ON_MHD = "ChronicNotOnMhd";
	public static String PROP_VOMATING_BILIOUS_DETAILS = "VomatingBiliousDetails";
	public static String PROP_LUTS_OBSTRUCTED_DURATION = "LutsObstructedDuration";
	public static String PROP_BMI = "Bmi";
	public static String PROP_FITNESS_PROCEDURE_DURATION = "FitnessProcedureDuration";
	public static String PROP_PAST_HISTORY = "PastHistory";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_OLIGURIA_DETAILS = "OliguriaDetails";
	public static String PROP_VOMATING_BLOOD_VOMITUS_DURATION = "VomatingBloodVomitusDuration";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ABDOMINAL_PAIN_DURATION = "AbdominalPainDuration";
	public static String PROP_CAPD = "Capd";
	public static String PROP_HEMOPTYSIS_DETAILS = "HemoptysisDetails";
	public static String PROP_RESPIRATORY_RATE = "RespiratoryRate";
	public static String PROP_BREATHLESSNESS_NYHA_CLASS = "BreathlessnessNyhaClass";
	public static String PROP_EDMA_FACIAL_DETAILS = "EdmaFacialDetails";
	public static String PROP_WAIST_CIRCUM = "WaistCircum";
	public static String PROP_LUTS_NOCTURIA_DETAILS = "LutsNocturiaDetails";
	public static String PROP_FROTHING_DETAILS = "FrothingDetails";
	public static String PROP_VISUAL_SYMPTOMS_DURATION = "VisualSymptomsDuration";
	public static String PROP_PERSONAL_HISTORY_REMARK = "PersonalHistoryRemark";
	public static String PROP_LUTS_OBSTRUCTED_DETAILS = "LutsObstructedDetails";
	public static String PROP_CHEST_REMARK = "ChestRemark";
	public static String PROP_DERANGED_RFT_DURATION = "DerangedRftDuration";
	public static String PROP_LUTS_URGENCY_DURATION = "LutsUrgencyDuration";
	public static String PROP_LITHURIA_DURATION = "LithuriaDuration";
	public static String PROP_HEADACHE_DETAILS = "HeadacheDetails";
	public static String PROP_VISUAL_SYMPTOMS_DETAILS = "VisualSymptomsDetails";
	public static String PROP_OTHERS = "Others";
	public static String PROP_LITHURIA_DETAILS = "LithuriaDetails";
	public static String PROP_CLUBBING = "Clubbing";
	public static String PROP_BREATHLESSNESS_NYHA_CLASS_ORTHOPNEA = "BreathlessnessNyhaClassOrthopnea";
	public static String PROP_BREATHLESSNESS_NYHA_CLASS_DURATION = "BreathlessnessNyhaClassDuration";
	public static String PROP_HERMATURIA_COFFEE_COLOURED_DETAILS = "HermaturiaCoffeeColouredDetails";
	public static String PROP_HEMOPTYSIS_DURATION = "HemoptysisDuration";
	public static String PROP_CHRONIC_ON_MHD = "ChronicOnMhd";
	public static String PROP_JAUNDICE = "Jaundice";
	public static String PROP_LUTS_URGENCY_DETAILS = "LutsUrgencyDetails";
	public static String PROP_VOMATING_BLOOD_VOMITUS_DETAILS = "VomatingBloodVomitusDetails";
	public static String PROP_EDMA_PEDAL_DURATION = "EdmaPedalDuration";
	public static String PROP_MENORRHAGIA_REMARKS = "MenorrhagiaRemarks";
	public static String PROP_HERMATURIA_PAINFUL_DURATION = "HermaturiaPainfulDuration";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_DERANGED_RFT_DETAILS = "DerangedRftDetails";
	public static String PROP_CVS_REMARK = "CvsRemark";
	public static String PROP_LYMPHADENOPATHY = "Lymphadenopathy";
	public static String PROP_COUGH_DURATION = "CoughDuration";
	public static String PROP_PRESENTING_ILLNESS_OTHERS = "PresentingIllnessOthers";
	public static String PROP_HYPERTENSION_DETAILS = "HypertensionDetails";
	public static String PROP_CKD_DETAILS = "CkdDetails";
	public static String PROP_FEVER_INTERMITTENT_DURATION = "FeverIntermittentDuration";
	public static String PROP_PA = "PA";
	public static String PROP_NEPHROLOGY_CASE_SHEET_ID = "NephrologyCaseSheetId";
	public static String PROP_FAMILY_HISTORY_CHRONIC_LIVER_DISEASE = "FamilyHistoryChronicLiverDisease";
	public static String PROP_HERMATURIA_PAINFUL_DETAILS = "HermaturiaPainfulDetails";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OLIGURIA_DURATION = "OliguriaDuration";
	public static String PROP_CHEST_PAIN_DURATION = "ChestPainDuration";
	public static String PROP_FAMILY_HISTORY_CHRONIC_KIDENY_DISEASE = "FamilyHistoryChronicKidenyDisease";
	public static String PROP_FEVER_INTERMITTENT_DETAILS = "FeverIntermittentDetails";
	public static String PROP_VISIT_ID = "VisitId";
	public static String PROP_CYANOSIS = "Cyanosis";
	public static String PROP_JVP = "Jvp";
	public static String PROP_JVP_RAISED = "JvpRaised";
	public static String PROP_HYPERTENSION_DURATION = "HypertensionDuration";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_EDMA_FACIAL_DURATION = "EdmaFacialDuration";
	public static String PROP_SR_CREATININE = "SrCreatinine";
	public static String PROP_OPTIC_FUNDS = "OpticFunds";
	public static String PROP_PRURITUS_DURATION = "PruritusDuration";
	public static String PROP_COUGH_DETAILS = "CoughDetails";
	public static String PROP_HEADACHE_DURATION = "HeadacheDuration";
	public static String PROP_PERSONAL_HISTORY = "PersonalHistory";
	public static String PROP_BREATHLESSNESS_NYHA_CLASS_DETAILS = "BreathlessnessNyhaClassDetails";
	public static String PROP_VOMATING_BILIOUS_DURATION = "VomatingBiliousDuration";
	public static String PROP_CHEST_PAIN_DETAILS = "ChestPainDetails";
	public static String PROP_CNS_FINDINGS = "CnsFindings";
	public static String PROP_CHEST = "Chest";
	public static String PROP_LUTS_FREQUENCY_DURATION = "LutsFrequencyDuration";
	public static String PROP_LUTS_FREQUENCY_DETAILS = "LutsFrequencyDetails";
	public static String PROP_PRURITUS_DETAILS = "PruritusDetails";
	public static String PROP_DYSURIA_DURATION = "DysuriaDuration";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LUTS_NOCTURIA_DURATION = "LutsNocturiaDuration";
	public static String PROP_DYSURIA_DETAILS = "DysuriaDetails";
	public static String PROP_DYSMENORRHEA_REMARKS = "DysmenorrheaRemarks";
	public static String PROP_FROTHING_DURATON = "FrothingDuraton";
	public static String PROP_HIN_ID = "HinId";
	public static String PROP_PRESENTING_ILLNESS_OTHERS_REMARK = "PresentingIllnessOthersRemark";
	public static String PROP_CKD_DUARTION = "CkdDuartion";
	public static String PROP_CVS = "Cvs";
	public static String PROP_TRANSPLANTATION = "Transplantation";
	public static String PROP_FAMILY_HISTORY_CHRONIC_KIDNEY_DISEASE_REMARK = "FamilyHistoryChronicKidneyDiseaseRemark";
	public static String PROP_ANAMIA = "Anamia";
	public static String PROP_EDMA_PEDAL_DETAILS = "EdmaPedalDetails";
	public static String PROP_FEVER_CHILLS_RIGORS_DURATION = "FeverChillsRigorsDuration";
	public static String PROP_PAST_HISTORY_REMARK = "PastHistoryRemark";
	public static String PROP_BP = "Bp";
	public static String PROP_FEVER_CHILLS_RIGORS_DETAILS = "FeverChillsRigorsDetails";


	// constructors
	public BaseNephrologyCaseSheet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNephrologyCaseSheet (java.lang.Integer nephrologyCaseSheetId) {
		this.setNephrologyCaseSheetId(nephrologyCaseSheetId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer nephrologyCaseSheetId;

	// fields
	private java.lang.Integer hinId;
	private java.lang.Integer visitId;
	private java.lang.String derangedRftDuration;
	private java.lang.String derangedRftDetails;
	private java.lang.String edmaFacialDuration;
	private java.lang.String edmaFacialDetails;
	private java.lang.String edmaPedalDuration;
	private java.lang.String edmaPedalDetails;
	private java.lang.String breathlessnessNyhaClass;
	private java.lang.String breathlessnessNyhaClassDuration;
	private java.lang.String breathlessnessNyhaClassDetails;
	private java.lang.String breathlessnessNyhaClassOrthopnea;
	private java.lang.String vomatingBloodVomitusDetails;
	private java.lang.String vomatingBloodVomitusDuration;
	private java.lang.String vomatingBiliousDuration;
	private java.lang.String vomatingBiliousDetails;
	private java.lang.String hermaturiaCoffeeColouredDuration;
	private java.lang.String hermaturiaCoffeeColouredDetails;
	private java.lang.String hermaturiaPainfulDuration;
	private java.lang.String hermaturiaPainfulDetails;
	private java.lang.String frothingDuraton;
	private java.lang.String frothingDetails;
	private java.lang.String oliguriaDuration;
	private java.lang.String oliguriaDetails;
	private java.lang.String dysuriaDuration;
	private java.lang.String dysuriaDetails;
	private java.lang.String chestPainDuration;
	private java.lang.String chestPainDetails;
	private java.lang.String abdominalPainDuration;
	private java.lang.String abdominalPainDetails;
	private java.lang.String feverIntermittentDuration;
	private java.lang.String feverIntermittentDetails;
	private java.lang.String feverChillsRigorsDuration;
	private java.lang.String feverChillsRigorsDetails;
	private java.lang.String fitnessProcedureDetails;
	private java.lang.String fitnessProcedureDuration;
	private java.lang.String pruritusDuration;
	private java.lang.String pruritusDetails;
	private java.lang.String headacheDuration;
	private java.lang.String headacheDetails;
	private java.lang.String hypertensionDuration;
	private java.lang.String hypertensionDetails;
	private java.lang.String lithuriaDuration;
	private java.lang.String lithuriaDetails;
	private java.lang.String visualSymptomsDuration;
	private java.lang.String visualSymptomsDetails;
	private java.lang.String presentingIllnessOthers;
	private java.lang.String presentingIllnessOthersRemark;
	private java.lang.String pastHistory;
	private java.lang.String pastHistoryRemark;
	private java.lang.String personalHistory;
	private java.lang.String personalHistoryRemark;
	private java.lang.String familyHistoryChronicKidenyDisease;
	private java.lang.String familyHistoryChronicKidneyDiseaseRemark;
	private java.lang.String familyHistoryChronicLiverDisease;
	private java.lang.String menorrhagiaRemarks;
	private java.lang.String dysmenorrheaRemarks;
	private java.lang.String height;
	private java.lang.String weight;
	private java.lang.String bmi;
	private java.lang.String waistCircum;
	private java.lang.String bp;
	private java.lang.String temperature;
	private java.lang.String respiratoryRate;
	private java.lang.String anamia;
	private java.lang.String cyanosis;
	private java.lang.String jaundice;
	private java.lang.String clubbing;
	private java.lang.String edema;
	private java.lang.String lymphadenopathy;
	private java.lang.String jvp;
	private java.lang.String jvpRaised;
	private java.lang.String chest;
	private java.lang.String chestRemark;
	private java.lang.String cvs;
	private java.lang.String cvsRemark;
	private java.lang.String pA;
	private java.lang.String pARemarlks;
	private java.lang.String opticFunds;
	private java.lang.String cnsFindings;
	private java.lang.String others;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String lutsFrequencyDuration;
	private java.lang.String lutsFrequencyDetails;
	private java.lang.String lutsUrgencyDuration;
	private java.lang.String lutsUrgencyDetails;
	private java.lang.String lutsObstructedDuration;
	private java.lang.String lutsObstructedDetails;
	private java.lang.String lutsNocturiaDuration;
	private java.lang.String lutsNocturiaDetails;
	private java.lang.String ckdDuartion;
	private java.lang.String ckdDetails;
	private java.lang.String hemoptysisDuration;
	private java.lang.String hemoptysisDetails;
	private java.lang.String chronicOnMhd;
	private java.lang.String chronicNotOnMhd;
	private java.lang.String capd;
	private java.lang.String transplantation;
	private java.lang.String coughDuration;
	private java.lang.String coughDetails;
	private java.lang.String srCreatinine;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="nephrology_case_sheet_id"
     */
	public java.lang.Integer getNephrologyCaseSheetId () {
		return nephrologyCaseSheetId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param nephrologyCaseSheetId the new ID
	 */
	public void setNephrologyCaseSheetId (java.lang.Integer nephrologyCaseSheetId) {
		this.nephrologyCaseSheetId = nephrologyCaseSheetId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: hin_id
	 */
	public java.lang.Integer getHinId () {
		return hinId;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hinId the hin_id value
	 */
	public void setHinId (java.lang.Integer hinId) {
		this.hinId = hinId;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public java.lang.Integer getVisitId () {
		return visitId;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visitId the visit_id value
	 */
	public void setVisitId (java.lang.Integer visitId) {
		this.visitId = visitId;
	}



	/**
	 * Return the value associated with the column: deranged_rft_duration
	 */
	public java.lang.String getDerangedRftDuration () {
		return derangedRftDuration;
	}

	/**
	 * Set the value related to the column: deranged_rft_duration
	 * @param derangedRftDuration the deranged_rft_duration value
	 */
	public void setDerangedRftDuration (java.lang.String derangedRftDuration) {
		this.derangedRftDuration = derangedRftDuration;
	}



	/**
	 * Return the value associated with the column: deranged_rft_details
	 */
	public java.lang.String getDerangedRftDetails () {
		return derangedRftDetails;
	}

	/**
	 * Set the value related to the column: deranged_rft_details
	 * @param derangedRftDetails the deranged_rft_details value
	 */
	public void setDerangedRftDetails (java.lang.String derangedRftDetails) {
		this.derangedRftDetails = derangedRftDetails;
	}



	/**
	 * Return the value associated with the column: edma_facial_duration
	 */
	public java.lang.String getEdmaFacialDuration () {
		return edmaFacialDuration;
	}

	/**
	 * Set the value related to the column: edma_facial_duration
	 * @param edmaFacialDuration the edma_facial_duration value
	 */
	public void setEdmaFacialDuration (java.lang.String edmaFacialDuration) {
		this.edmaFacialDuration = edmaFacialDuration;
	}



	/**
	 * Return the value associated with the column: edma_facial_details
	 */
	public java.lang.String getEdmaFacialDetails () {
		return edmaFacialDetails;
	}

	/**
	 * Set the value related to the column: edma_facial_details
	 * @param edmaFacialDetails the edma_facial_details value
	 */
	public void setEdmaFacialDetails (java.lang.String edmaFacialDetails) {
		this.edmaFacialDetails = edmaFacialDetails;
	}



	/**
	 * Return the value associated with the column: edma_pedal_duration
	 */
	public java.lang.String getEdmaPedalDuration () {
		return edmaPedalDuration;
	}

	/**
	 * Set the value related to the column: edma_pedal_duration
	 * @param edmaPedalDuration the edma_pedal_duration value
	 */
	public void setEdmaPedalDuration (java.lang.String edmaPedalDuration) {
		this.edmaPedalDuration = edmaPedalDuration;
	}



	/**
	 * Return the value associated with the column: edma_pedal_details
	 */
	public java.lang.String getEdmaPedalDetails () {
		return edmaPedalDetails;
	}

	/**
	 * Set the value related to the column: edma_pedal_details
	 * @param edmaPedalDetails the edma_pedal_details value
	 */
	public void setEdmaPedalDetails (java.lang.String edmaPedalDetails) {
		this.edmaPedalDetails = edmaPedalDetails;
	}



	/**
	 * Return the value associated with the column: breathlessness_nyha_class
	 */
	public java.lang.String getBreathlessnessNyhaClass () {
		return breathlessnessNyhaClass;
	}

	/**
	 * Set the value related to the column: breathlessness_nyha_class
	 * @param breathlessnessNyhaClass the breathlessness_nyha_class value
	 */
	public void setBreathlessnessNyhaClass (java.lang.String breathlessnessNyhaClass) {
		this.breathlessnessNyhaClass = breathlessnessNyhaClass;
	}



	/**
	 * Return the value associated with the column: breathlessness_nyha_class_duration
	 */
	public java.lang.String getBreathlessnessNyhaClassDuration () {
		return breathlessnessNyhaClassDuration;
	}

	/**
	 * Set the value related to the column: breathlessness_nyha_class_duration
	 * @param breathlessnessNyhaClassDuration the breathlessness_nyha_class_duration value
	 */
	public void setBreathlessnessNyhaClassDuration (java.lang.String breathlessnessNyhaClassDuration) {
		this.breathlessnessNyhaClassDuration = breathlessnessNyhaClassDuration;
	}



	/**
	 * Return the value associated with the column: breathlessness_nyha_class_details
	 */
	public java.lang.String getBreathlessnessNyhaClassDetails () {
		return breathlessnessNyhaClassDetails;
	}

	/**
	 * Set the value related to the column: breathlessness_nyha_class_details
	 * @param breathlessnessNyhaClassDetails the breathlessness_nyha_class_details value
	 */
	public void setBreathlessnessNyhaClassDetails (java.lang.String breathlessnessNyhaClassDetails) {
		this.breathlessnessNyhaClassDetails = breathlessnessNyhaClassDetails;
	}



	/**
	 * Return the value associated with the column: breathlessness_nyha_class_orthopnea
	 */
	public java.lang.String getBreathlessnessNyhaClassOrthopnea () {
		return breathlessnessNyhaClassOrthopnea;
	}

	/**
	 * Set the value related to the column: breathlessness_nyha_class_orthopnea
	 * @param breathlessnessNyhaClassOrthopnea the breathlessness_nyha_class_orthopnea value
	 */
	public void setBreathlessnessNyhaClassOrthopnea (java.lang.String breathlessnessNyhaClassOrthopnea) {
		this.breathlessnessNyhaClassOrthopnea = breathlessnessNyhaClassOrthopnea;
	}



	/**
	 * Return the value associated with the column: vomating_blood_vomitus_details
	 */
	public java.lang.String getVomatingBloodVomitusDetails () {
		return vomatingBloodVomitusDetails;
	}

	/**
	 * Set the value related to the column: vomating_blood_vomitus_details
	 * @param vomatingBloodVomitusDetails the vomating_blood_vomitus_details value
	 */
	public void setVomatingBloodVomitusDetails (java.lang.String vomatingBloodVomitusDetails) {
		this.vomatingBloodVomitusDetails = vomatingBloodVomitusDetails;
	}



	/**
	 * Return the value associated with the column: vomating_blood_vomitus_duration
	 */
	public java.lang.String getVomatingBloodVomitusDuration () {
		return vomatingBloodVomitusDuration;
	}

	/**
	 * Set the value related to the column: vomating_blood_vomitus_duration
	 * @param vomatingBloodVomitusDuration the vomating_blood_vomitus_duration value
	 */
	public void setVomatingBloodVomitusDuration (java.lang.String vomatingBloodVomitusDuration) {
		this.vomatingBloodVomitusDuration = vomatingBloodVomitusDuration;
	}



	/**
	 * Return the value associated with the column: vomating_bilious_duration
	 */
	public java.lang.String getVomatingBiliousDuration () {
		return vomatingBiliousDuration;
	}

	/**
	 * Set the value related to the column: vomating_bilious_duration
	 * @param vomatingBiliousDuration the vomating_bilious_duration value
	 */
	public void setVomatingBiliousDuration (java.lang.String vomatingBiliousDuration) {
		this.vomatingBiliousDuration = vomatingBiliousDuration;
	}



	/**
	 * Return the value associated with the column: vomating_bilious_details
	 */
	public java.lang.String getVomatingBiliousDetails () {
		return vomatingBiliousDetails;
	}

	/**
	 * Set the value related to the column: vomating_bilious_details
	 * @param vomatingBiliousDetails the vomating_bilious_details value
	 */
	public void setVomatingBiliousDetails (java.lang.String vomatingBiliousDetails) {
		this.vomatingBiliousDetails = vomatingBiliousDetails;
	}



	/**
	 * Return the value associated with the column: hermaturia_coffee_coloured_duration
	 */
	public java.lang.String getHermaturiaCoffeeColouredDuration () {
		return hermaturiaCoffeeColouredDuration;
	}

	/**
	 * Set the value related to the column: hermaturia_coffee_coloured_duration
	 * @param hermaturiaCoffeeColouredDuration the hermaturia_coffee_coloured_duration value
	 */
	public void setHermaturiaCoffeeColouredDuration (java.lang.String hermaturiaCoffeeColouredDuration) {
		this.hermaturiaCoffeeColouredDuration = hermaturiaCoffeeColouredDuration;
	}



	/**
	 * Return the value associated with the column: hermaturia_coffee_coloured_details
	 */
	public java.lang.String getHermaturiaCoffeeColouredDetails () {
		return hermaturiaCoffeeColouredDetails;
	}

	/**
	 * Set the value related to the column: hermaturia_coffee_coloured_details
	 * @param hermaturiaCoffeeColouredDetails the hermaturia_coffee_coloured_details value
	 */
	public void setHermaturiaCoffeeColouredDetails (java.lang.String hermaturiaCoffeeColouredDetails) {
		this.hermaturiaCoffeeColouredDetails = hermaturiaCoffeeColouredDetails;
	}



	/**
	 * Return the value associated with the column: hermaturia_painful_duration
	 */
	public java.lang.String getHermaturiaPainfulDuration () {
		return hermaturiaPainfulDuration;
	}

	/**
	 * Set the value related to the column: hermaturia_painful_duration
	 * @param hermaturiaPainfulDuration the hermaturia_painful_duration value
	 */
	public void setHermaturiaPainfulDuration (java.lang.String hermaturiaPainfulDuration) {
		this.hermaturiaPainfulDuration = hermaturiaPainfulDuration;
	}



	/**
	 * Return the value associated with the column: hermaturia_painful_details
	 */
	public java.lang.String getHermaturiaPainfulDetails () {
		return hermaturiaPainfulDetails;
	}

	/**
	 * Set the value related to the column: hermaturia_painful_details
	 * @param hermaturiaPainfulDetails the hermaturia_painful_details value
	 */
	public void setHermaturiaPainfulDetails (java.lang.String hermaturiaPainfulDetails) {
		this.hermaturiaPainfulDetails = hermaturiaPainfulDetails;
	}



	/**
	 * Return the value associated with the column: frothing_duraton
	 */
	public java.lang.String getFrothingDuraton () {
		return frothingDuraton;
	}

	/**
	 * Set the value related to the column: frothing_duraton
	 * @param frothingDuraton the frothing_duraton value
	 */
	public void setFrothingDuraton (java.lang.String frothingDuraton) {
		this.frothingDuraton = frothingDuraton;
	}



	/**
	 * Return the value associated with the column: frothing_details
	 */
	public java.lang.String getFrothingDetails () {
		return frothingDetails;
	}

	/**
	 * Set the value related to the column: frothing_details
	 * @param frothingDetails the frothing_details value
	 */
	public void setFrothingDetails (java.lang.String frothingDetails) {
		this.frothingDetails = frothingDetails;
	}



	/**
	 * Return the value associated with the column: oliguria_duration
	 */
	public java.lang.String getOliguriaDuration () {
		return oliguriaDuration;
	}

	/**
	 * Set the value related to the column: oliguria_duration
	 * @param oliguriaDuration the oliguria_duration value
	 */
	public void setOliguriaDuration (java.lang.String oliguriaDuration) {
		this.oliguriaDuration = oliguriaDuration;
	}



	/**
	 * Return the value associated with the column: oliguria_details
	 */
	public java.lang.String getOliguriaDetails () {
		return oliguriaDetails;
	}

	/**
	 * Set the value related to the column: oliguria_details
	 * @param oliguriaDetails the oliguria_details value
	 */
	public void setOliguriaDetails (java.lang.String oliguriaDetails) {
		this.oliguriaDetails = oliguriaDetails;
	}



	/**
	 * Return the value associated with the column: dysuria_duration
	 */
	public java.lang.String getDysuriaDuration () {
		return dysuriaDuration;
	}

	/**
	 * Set the value related to the column: dysuria_duration
	 * @param dysuriaDuration the dysuria_duration value
	 */
	public void setDysuriaDuration (java.lang.String dysuriaDuration) {
		this.dysuriaDuration = dysuriaDuration;
	}



	/**
	 * Return the value associated with the column: dysuria_details
	 */
	public java.lang.String getDysuriaDetails () {
		return dysuriaDetails;
	}

	/**
	 * Set the value related to the column: dysuria_details
	 * @param dysuriaDetails the dysuria_details value
	 */
	public void setDysuriaDetails (java.lang.String dysuriaDetails) {
		this.dysuriaDetails = dysuriaDetails;
	}



	/**
	 * Return the value associated with the column: chest_pain_duration
	 */
	public java.lang.String getChestPainDuration () {
		return chestPainDuration;
	}

	/**
	 * Set the value related to the column: chest_pain_duration
	 * @param chestPainDuration the chest_pain_duration value
	 */
	public void setChestPainDuration (java.lang.String chestPainDuration) {
		this.chestPainDuration = chestPainDuration;
	}



	/**
	 * Return the value associated with the column: chest_pain_details
	 */
	public java.lang.String getChestPainDetails () {
		return chestPainDetails;
	}

	/**
	 * Set the value related to the column: chest_pain_details
	 * @param chestPainDetails the chest_pain_details value
	 */
	public void setChestPainDetails (java.lang.String chestPainDetails) {
		this.chestPainDetails = chestPainDetails;
	}



	/**
	 * Return the value associated with the column: abdominal_pain_duration
	 */
	public java.lang.String getAbdominalPainDuration () {
		return abdominalPainDuration;
	}

	/**
	 * Set the value related to the column: abdominal_pain_duration
	 * @param abdominalPainDuration the abdominal_pain_duration value
	 */
	public void setAbdominalPainDuration (java.lang.String abdominalPainDuration) {
		this.abdominalPainDuration = abdominalPainDuration;
	}



	/**
	 * Return the value associated with the column: abdominal_pain_details
	 */
	public java.lang.String getAbdominalPainDetails () {
		return abdominalPainDetails;
	}

	/**
	 * Set the value related to the column: abdominal_pain_details
	 * @param abdominalPainDetails the abdominal_pain_details value
	 */
	public void setAbdominalPainDetails (java.lang.String abdominalPainDetails) {
		this.abdominalPainDetails = abdominalPainDetails;
	}



	/**
	 * Return the value associated with the column: fever_intermittent_duration
	 */
	public java.lang.String getFeverIntermittentDuration () {
		return feverIntermittentDuration;
	}

	/**
	 * Set the value related to the column: fever_intermittent_duration
	 * @param feverIntermittentDuration the fever_intermittent_duration value
	 */
	public void setFeverIntermittentDuration (java.lang.String feverIntermittentDuration) {
		this.feverIntermittentDuration = feverIntermittentDuration;
	}



	/**
	 * Return the value associated with the column: fever_intermittent_details
	 */
	public java.lang.String getFeverIntermittentDetails () {
		return feverIntermittentDetails;
	}

	/**
	 * Set the value related to the column: fever_intermittent_details
	 * @param feverIntermittentDetails the fever_intermittent_details value
	 */
	public void setFeverIntermittentDetails (java.lang.String feverIntermittentDetails) {
		this.feverIntermittentDetails = feverIntermittentDetails;
	}



	/**
	 * Return the value associated with the column: fever_chills_rigors_duration
	 */
	public java.lang.String getFeverChillsRigorsDuration () {
		return feverChillsRigorsDuration;
	}

	/**
	 * Set the value related to the column: fever_chills_rigors_duration
	 * @param feverChillsRigorsDuration the fever_chills_rigors_duration value
	 */
	public void setFeverChillsRigorsDuration (java.lang.String feverChillsRigorsDuration) {
		this.feverChillsRigorsDuration = feverChillsRigorsDuration;
	}



	/**
	 * Return the value associated with the column: fever_chills_rigors_details
	 */
	public java.lang.String getFeverChillsRigorsDetails () {
		return feverChillsRigorsDetails;
	}

	/**
	 * Set the value related to the column: fever_chills_rigors_details
	 * @param feverChillsRigorsDetails the fever_chills_rigors_details value
	 */
	public void setFeverChillsRigorsDetails (java.lang.String feverChillsRigorsDetails) {
		this.feverChillsRigorsDetails = feverChillsRigorsDetails;
	}



	/**
	 * Return the value associated with the column: fitness_procedure_details
	 */
	public java.lang.String getFitnessProcedureDetails () {
		return fitnessProcedureDetails;
	}

	/**
	 * Set the value related to the column: fitness_procedure_details
	 * @param fitnessProcedureDetails the fitness_procedure_details value
	 */
	public void setFitnessProcedureDetails (java.lang.String fitnessProcedureDetails) {
		this.fitnessProcedureDetails = fitnessProcedureDetails;
	}



	/**
	 * Return the value associated with the column: fitness_procedure_duration
	 */
	public java.lang.String getFitnessProcedureDuration () {
		return fitnessProcedureDuration;
	}

	/**
	 * Set the value related to the column: fitness_procedure_duration
	 * @param fitnessProcedureDuration the fitness_procedure_duration value
	 */
	public void setFitnessProcedureDuration (java.lang.String fitnessProcedureDuration) {
		this.fitnessProcedureDuration = fitnessProcedureDuration;
	}



	/**
	 * Return the value associated with the column: pruritus_duration
	 */
	public java.lang.String getPruritusDuration () {
		return pruritusDuration;
	}

	/**
	 * Set the value related to the column: pruritus_duration
	 * @param pruritusDuration the pruritus_duration value
	 */
	public void setPruritusDuration (java.lang.String pruritusDuration) {
		this.pruritusDuration = pruritusDuration;
	}



	/**
	 * Return the value associated with the column: pruritus_details
	 */
	public java.lang.String getPruritusDetails () {
		return pruritusDetails;
	}

	/**
	 * Set the value related to the column: pruritus_details
	 * @param pruritusDetails the pruritus_details value
	 */
	public void setPruritusDetails (java.lang.String pruritusDetails) {
		this.pruritusDetails = pruritusDetails;
	}



	/**
	 * Return the value associated with the column: headache_duration
	 */
	public java.lang.String getHeadacheDuration () {
		return headacheDuration;
	}

	/**
	 * Set the value related to the column: headache_duration
	 * @param headacheDuration the headache_duration value
	 */
	public void setHeadacheDuration (java.lang.String headacheDuration) {
		this.headacheDuration = headacheDuration;
	}



	/**
	 * Return the value associated with the column: headache_details
	 */
	public java.lang.String getHeadacheDetails () {
		return headacheDetails;
	}

	/**
	 * Set the value related to the column: headache_details
	 * @param headacheDetails the headache_details value
	 */
	public void setHeadacheDetails (java.lang.String headacheDetails) {
		this.headacheDetails = headacheDetails;
	}



	/**
	 * Return the value associated with the column: hypertension_duration
	 */
	public java.lang.String getHypertensionDuration () {
		return hypertensionDuration;
	}

	/**
	 * Set the value related to the column: hypertension_duration
	 * @param hypertensionDuration the hypertension_duration value
	 */
	public void setHypertensionDuration (java.lang.String hypertensionDuration) {
		this.hypertensionDuration = hypertensionDuration;
	}



	/**
	 * Return the value associated with the column: hypertension_details
	 */
	public java.lang.String getHypertensionDetails () {
		return hypertensionDetails;
	}

	/**
	 * Set the value related to the column: hypertension_details
	 * @param hypertensionDetails the hypertension_details value
	 */
	public void setHypertensionDetails (java.lang.String hypertensionDetails) {
		this.hypertensionDetails = hypertensionDetails;
	}



	/**
	 * Return the value associated with the column: lithuria_duration
	 */
	public java.lang.String getLithuriaDuration () {
		return lithuriaDuration;
	}

	/**
	 * Set the value related to the column: lithuria_duration
	 * @param lithuriaDuration the lithuria_duration value
	 */
	public void setLithuriaDuration (java.lang.String lithuriaDuration) {
		this.lithuriaDuration = lithuriaDuration;
	}



	/**
	 * Return the value associated with the column: lithuria_details
	 */
	public java.lang.String getLithuriaDetails () {
		return lithuriaDetails;
	}

	/**
	 * Set the value related to the column: lithuria_details
	 * @param lithuriaDetails the lithuria_details value
	 */
	public void setLithuriaDetails (java.lang.String lithuriaDetails) {
		this.lithuriaDetails = lithuriaDetails;
	}



	/**
	 * Return the value associated with the column: visual_symptoms_duration
	 */
	public java.lang.String getVisualSymptomsDuration () {
		return visualSymptomsDuration;
	}

	/**
	 * Set the value related to the column: visual_symptoms_duration
	 * @param visualSymptomsDuration the visual_symptoms_duration value
	 */
	public void setVisualSymptomsDuration (java.lang.String visualSymptomsDuration) {
		this.visualSymptomsDuration = visualSymptomsDuration;
	}



	/**
	 * Return the value associated with the column: visual_symptoms_details
	 */
	public java.lang.String getVisualSymptomsDetails () {
		return visualSymptomsDetails;
	}

	/**
	 * Set the value related to the column: visual_symptoms_details
	 * @param visualSymptomsDetails the visual_symptoms_details value
	 */
	public void setVisualSymptomsDetails (java.lang.String visualSymptomsDetails) {
		this.visualSymptomsDetails = visualSymptomsDetails;
	}



	/**
	 * Return the value associated with the column: presenting_illness_others
	 */
	public java.lang.String getPresentingIllnessOthers () {
		return presentingIllnessOthers;
	}

	/**
	 * Set the value related to the column: presenting_illness_others
	 * @param presentingIllnessOthers the presenting_illness_others value
	 */
	public void setPresentingIllnessOthers (java.lang.String presentingIllnessOthers) {
		this.presentingIllnessOthers = presentingIllnessOthers;
	}



	/**
	 * Return the value associated with the column: presenting_illness_others_remark
	 */
	public java.lang.String getPresentingIllnessOthersRemark () {
		return presentingIllnessOthersRemark;
	}

	/**
	 * Set the value related to the column: presenting_illness_others_remark
	 * @param presentingIllnessOthersRemark the presenting_illness_others_remark value
	 */
	public void setPresentingIllnessOthersRemark (java.lang.String presentingIllnessOthersRemark) {
		this.presentingIllnessOthersRemark = presentingIllnessOthersRemark;
	}



	/**
	 * Return the value associated with the column: past_history
	 */
	public java.lang.String getPastHistory () {
		return pastHistory;
	}

	/**
	 * Set the value related to the column: past_history
	 * @param pastHistory the past_history value
	 */
	public void setPastHistory (java.lang.String pastHistory) {
		this.pastHistory = pastHistory;
	}



	/**
	 * Return the value associated with the column: past_history_remark
	 */
	public java.lang.String getPastHistoryRemark () {
		return pastHistoryRemark;
	}

	/**
	 * Set the value related to the column: past_history_remark
	 * @param pastHistoryRemark the past_history_remark value
	 */
	public void setPastHistoryRemark (java.lang.String pastHistoryRemark) {
		this.pastHistoryRemark = pastHistoryRemark;
	}



	/**
	 * Return the value associated with the column: personal_history
	 */
	public java.lang.String getPersonalHistory () {
		return personalHistory;
	}

	/**
	 * Set the value related to the column: personal_history
	 * @param personalHistory the personal_history value
	 */
	public void setPersonalHistory (java.lang.String personalHistory) {
		this.personalHistory = personalHistory;
	}



	/**
	 * Return the value associated with the column: personal_history_remark
	 */
	public java.lang.String getPersonalHistoryRemark () {
		return personalHistoryRemark;
	}

	/**
	 * Set the value related to the column: personal_history_remark
	 * @param personalHistoryRemark the personal_history_remark value
	 */
	public void setPersonalHistoryRemark (java.lang.String personalHistoryRemark) {
		this.personalHistoryRemark = personalHistoryRemark;
	}



	/**
	 * Return the value associated with the column: family_history_chronic_kideny_disease
	 */
	public java.lang.String getFamilyHistoryChronicKidenyDisease () {
		return familyHistoryChronicKidenyDisease;
	}

	/**
	 * Set the value related to the column: family_history_chronic_kideny_disease
	 * @param familyHistoryChronicKidenyDisease the family_history_chronic_kideny_disease value
	 */
	public void setFamilyHistoryChronicKidenyDisease (java.lang.String familyHistoryChronicKidenyDisease) {
		this.familyHistoryChronicKidenyDisease = familyHistoryChronicKidenyDisease;
	}



	/**
	 * Return the value associated with the column: family_history_chronic_kidney_disease_remark
	 */
	public java.lang.String getFamilyHistoryChronicKidneyDiseaseRemark () {
		return familyHistoryChronicKidneyDiseaseRemark;
	}

	/**
	 * Set the value related to the column: family_history_chronic_kidney_disease_remark
	 * @param familyHistoryChronicKidneyDiseaseRemark the family_history_chronic_kidney_disease_remark value
	 */
	public void setFamilyHistoryChronicKidneyDiseaseRemark (java.lang.String familyHistoryChronicKidneyDiseaseRemark) {
		this.familyHistoryChronicKidneyDiseaseRemark = familyHistoryChronicKidneyDiseaseRemark;
	}



	/**
	 * Return the value associated with the column: family_history_chronic_liver_disease
	 */
	public java.lang.String getFamilyHistoryChronicLiverDisease () {
		return familyHistoryChronicLiverDisease;
	}

	/**
	 * Set the value related to the column: family_history_chronic_liver_disease
	 * @param familyHistoryChronicLiverDisease the family_history_chronic_liver_disease value
	 */
	public void setFamilyHistoryChronicLiverDisease (java.lang.String familyHistoryChronicLiverDisease) {
		this.familyHistoryChronicLiverDisease = familyHistoryChronicLiverDisease;
	}



	/**
	 * Return the value associated with the column: menorrhagia_remarks
	 */
	public java.lang.String getMenorrhagiaRemarks () {
		return menorrhagiaRemarks;
	}

	/**
	 * Set the value related to the column: menorrhagia_remarks
	 * @param menorrhagiaRemarks the menorrhagia_remarks value
	 */
	public void setMenorrhagiaRemarks (java.lang.String menorrhagiaRemarks) {
		this.menorrhagiaRemarks = menorrhagiaRemarks;
	}



	/**
	 * Return the value associated with the column: dysmenorrhea_remarks
	 */
	public java.lang.String getDysmenorrheaRemarks () {
		return dysmenorrheaRemarks;
	}

	/**
	 * Set the value related to the column: dysmenorrhea_remarks
	 * @param dysmenorrheaRemarks the dysmenorrhea_remarks value
	 */
	public void setDysmenorrheaRemarks (java.lang.String dysmenorrheaRemarks) {
		this.dysmenorrheaRemarks = dysmenorrheaRemarks;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.String height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.String getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.String weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: bmi
	 */
	public java.lang.String getBmi () {
		return bmi;
	}

	/**
	 * Set the value related to the column: bmi
	 * @param bmi the bmi value
	 */
	public void setBmi (java.lang.String bmi) {
		this.bmi = bmi;
	}



	/**
	 * Return the value associated with the column: waist_circum
	 */
	public java.lang.String getWaistCircum () {
		return waistCircum;
	}

	/**
	 * Set the value related to the column: waist_circum
	 * @param waistCircum the waist_circum value
	 */
	public void setWaistCircum (java.lang.String waistCircum) {
		this.waistCircum = waistCircum;
	}



	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.String getBp () {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * @param bp the bp value
	 */
	public void setBp (java.lang.String bp) {
		this.bp = bp;
	}



	/**
	 * Return the value associated with the column: temperature
	 */
	public java.lang.String getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * @param temperature the temperature value
	 */
	public void setTemperature (java.lang.String temperature) {
		this.temperature = temperature;
	}



	/**
	 * Return the value associated with the column: respiratory_rate
	 */
	public java.lang.String getRespiratoryRate () {
		return respiratoryRate;
	}

	/**
	 * Set the value related to the column: respiratory_rate
	 * @param respiratoryRate the respiratory_rate value
	 */
	public void setRespiratoryRate (java.lang.String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}



	/**
	 * Return the value associated with the column: anamia
	 */
	public java.lang.String getAnamia () {
		return anamia;
	}

	/**
	 * Set the value related to the column: anamia
	 * @param anamia the anamia value
	 */
	public void setAnamia (java.lang.String anamia) {
		this.anamia = anamia;
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
	 * Return the value associated with the column: jaundice
	 */
	public java.lang.String getJaundice () {
		return jaundice;
	}

	/**
	 * Set the value related to the column: jaundice
	 * @param jaundice the jaundice value
	 */
	public void setJaundice (java.lang.String jaundice) {
		this.jaundice = jaundice;
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
	 * Return the value associated with the column: edema
	 */
	public java.lang.String getEdema () {
		return edema;
	}

	/**
	 * Set the value related to the column: edema
	 * @param edema the edema value
	 */
	public void setEdema (java.lang.String edema) {
		this.edema = edema;
	}



	/**
	 * Return the value associated with the column: lymphadenopathy
	 */
	public java.lang.String getLymphadenopathy () {
		return lymphadenopathy;
	}

	/**
	 * Set the value related to the column: lymphadenopathy
	 * @param lymphadenopathy the lymphadenopathy value
	 */
	public void setLymphadenopathy (java.lang.String lymphadenopathy) {
		this.lymphadenopathy = lymphadenopathy;
	}



	/**
	 * Return the value associated with the column: jvp
	 */
	public java.lang.String getJvp () {
		return jvp;
	}

	/**
	 * Set the value related to the column: jvp
	 * @param jvp the jvp value
	 */
	public void setJvp (java.lang.String jvp) {
		this.jvp = jvp;
	}



	/**
	 * Return the value associated with the column: jvp_raised
	 */
	public java.lang.String getJvpRaised () {
		return jvpRaised;
	}

	/**
	 * Set the value related to the column: jvp_raised
	 * @param jvpRaised the jvp_raised value
	 */
	public void setJvpRaised (java.lang.String jvpRaised) {
		this.jvpRaised = jvpRaised;
	}



	/**
	 * Return the value associated with the column: chest
	 */
	public java.lang.String getChest () {
		return chest;
	}

	/**
	 * Set the value related to the column: chest
	 * @param chest the chest value
	 */
	public void setChest (java.lang.String chest) {
		this.chest = chest;
	}



	/**
	 * Return the value associated with the column: chest_remark
	 */
	public java.lang.String getChestRemark () {
		return chestRemark;
	}

	/**
	 * Set the value related to the column: chest_remark
	 * @param chestRemark the chest_remark value
	 */
	public void setChestRemark (java.lang.String chestRemark) {
		this.chestRemark = chestRemark;
	}



	/**
	 * Return the value associated with the column: cvs
	 */
	public java.lang.String getCvs () {
		return cvs;
	}

	/**
	 * Set the value related to the column: cvs
	 * @param cvs the cvs value
	 */
	public void setCvs (java.lang.String cvs) {
		this.cvs = cvs;
	}



	/**
	 * Return the value associated with the column: cvs_remark
	 */
	public java.lang.String getCvsRemark () {
		return cvsRemark;
	}

	/**
	 * Set the value related to the column: cvs_remark
	 * @param cvsRemark the cvs_remark value
	 */
	public void setCvsRemark (java.lang.String cvsRemark) {
		this.cvsRemark = cvsRemark;
	}



	/**
	 * Return the value associated with the column: p_a
	 */
	public java.lang.String getPA () {
		return pA;
	}

	/**
	 * Set the value related to the column: p_a
	 * @param pA the p_a value
	 */
	public void setPA (java.lang.String pA) {
		this.pA = pA;
	}



	/**
	 * Return the value associated with the column: p_a_remarlks
	 */
	public java.lang.String getPARemarlks () {
		return pARemarlks;
	}

	/**
	 * Set the value related to the column: p_a_remarlks
	 * @param pARemarlks the p_a_remarlks value
	 */
	public void setPARemarlks (java.lang.String pARemarlks) {
		this.pARemarlks = pARemarlks;
	}



	/**
	 * Return the value associated with the column: optic_funds
	 */
	public java.lang.String getOpticFunds () {
		return opticFunds;
	}

	/**
	 * Set the value related to the column: optic_funds
	 * @param opticFunds the optic_funds value
	 */
	public void setOpticFunds (java.lang.String opticFunds) {
		this.opticFunds = opticFunds;
	}



	/**
	 * Return the value associated with the column: cns_findings
	 */
	public java.lang.String getCnsFindings () {
		return cnsFindings;
	}

	/**
	 * Set the value related to the column: cns_findings
	 * @param cnsFindings the cns_findings value
	 */
	public void setCnsFindings (java.lang.String cnsFindings) {
		this.cnsFindings = cnsFindings;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: luts_frequency_duration
	 */
	public java.lang.String getLutsFrequencyDuration () {
		return lutsFrequencyDuration;
	}

	/**
	 * Set the value related to the column: luts_frequency_duration
	 * @param lutsFrequencyDuration the luts_frequency_duration value
	 */
	public void setLutsFrequencyDuration (java.lang.String lutsFrequencyDuration) {
		this.lutsFrequencyDuration = lutsFrequencyDuration;
	}



	/**
	 * Return the value associated with the column: luts_frequency_details
	 */
	public java.lang.String getLutsFrequencyDetails () {
		return lutsFrequencyDetails;
	}

	/**
	 * Set the value related to the column: luts_frequency_details
	 * @param lutsFrequencyDetails the luts_frequency_details value
	 */
	public void setLutsFrequencyDetails (java.lang.String lutsFrequencyDetails) {
		this.lutsFrequencyDetails = lutsFrequencyDetails;
	}



	/**
	 * Return the value associated with the column: luts_urgency_duration
	 */
	public java.lang.String getLutsUrgencyDuration () {
		return lutsUrgencyDuration;
	}

	/**
	 * Set the value related to the column: luts_urgency_duration
	 * @param lutsUrgencyDuration the luts_urgency_duration value
	 */
	public void setLutsUrgencyDuration (java.lang.String lutsUrgencyDuration) {
		this.lutsUrgencyDuration = lutsUrgencyDuration;
	}



	/**
	 * Return the value associated with the column: luts_urgency_details
	 */
	public java.lang.String getLutsUrgencyDetails () {
		return lutsUrgencyDetails;
	}

	/**
	 * Set the value related to the column: luts_urgency_details
	 * @param lutsUrgencyDetails the luts_urgency_details value
	 */
	public void setLutsUrgencyDetails (java.lang.String lutsUrgencyDetails) {
		this.lutsUrgencyDetails = lutsUrgencyDetails;
	}



	/**
	 * Return the value associated with the column: luts_obstructed_duration
	 */
	public java.lang.String getLutsObstructedDuration () {
		return lutsObstructedDuration;
	}

	/**
	 * Set the value related to the column: luts_obstructed_duration
	 * @param lutsObstructedDuration the luts_obstructed_duration value
	 */
	public void setLutsObstructedDuration (java.lang.String lutsObstructedDuration) {
		this.lutsObstructedDuration = lutsObstructedDuration;
	}



	/**
	 * Return the value associated with the column: luts_obstructed_details
	 */
	public java.lang.String getLutsObstructedDetails () {
		return lutsObstructedDetails;
	}

	/**
	 * Set the value related to the column: luts_obstructed_details
	 * @param lutsObstructedDetails the luts_obstructed_details value
	 */
	public void setLutsObstructedDetails (java.lang.String lutsObstructedDetails) {
		this.lutsObstructedDetails = lutsObstructedDetails;
	}



	/**
	 * Return the value associated with the column: luts_nocturia_duration
	 */
	public java.lang.String getLutsNocturiaDuration () {
		return lutsNocturiaDuration;
	}

	/**
	 * Set the value related to the column: luts_nocturia_duration
	 * @param lutsNocturiaDuration the luts_nocturia_duration value
	 */
	public void setLutsNocturiaDuration (java.lang.String lutsNocturiaDuration) {
		this.lutsNocturiaDuration = lutsNocturiaDuration;
	}



	/**
	 * Return the value associated with the column: luts_nocturia_details
	 */
	public java.lang.String getLutsNocturiaDetails () {
		return lutsNocturiaDetails;
	}

	/**
	 * Set the value related to the column: luts_nocturia_details
	 * @param lutsNocturiaDetails the luts_nocturia_details value
	 */
	public void setLutsNocturiaDetails (java.lang.String lutsNocturiaDetails) {
		this.lutsNocturiaDetails = lutsNocturiaDetails;
	}



	/**
	 * Return the value associated with the column: ckd_duartion
	 */
	public java.lang.String getCkdDuartion () {
		return ckdDuartion;
	}

	/**
	 * Set the value related to the column: ckd_duartion
	 * @param ckdDuartion the ckd_duartion value
	 */
	public void setCkdDuartion (java.lang.String ckdDuartion) {
		this.ckdDuartion = ckdDuartion;
	}



	/**
	 * Return the value associated with the column: ckd_details
	 */
	public java.lang.String getCkdDetails () {
		return ckdDetails;
	}

	/**
	 * Set the value related to the column: ckd_details
	 * @param ckdDetails the ckd_details value
	 */
	public void setCkdDetails (java.lang.String ckdDetails) {
		this.ckdDetails = ckdDetails;
	}



	/**
	 * Return the value associated with the column: hemoptysis_duration
	 */
	public java.lang.String getHemoptysisDuration () {
		return hemoptysisDuration;
	}

	/**
	 * Set the value related to the column: hemoptysis_duration
	 * @param hemoptysisDuration the hemoptysis_duration value
	 */
	public void setHemoptysisDuration (java.lang.String hemoptysisDuration) {
		this.hemoptysisDuration = hemoptysisDuration;
	}



	/**
	 * Return the value associated with the column: hemoptysis_details
	 */
	public java.lang.String getHemoptysisDetails () {
		return hemoptysisDetails;
	}

	/**
	 * Set the value related to the column: hemoptysis_details
	 * @param hemoptysisDetails the hemoptysis_details value
	 */
	public void setHemoptysisDetails (java.lang.String hemoptysisDetails) {
		this.hemoptysisDetails = hemoptysisDetails;
	}



	/**
	 * Return the value associated with the column: chronic_on_mhd
	 */
	public java.lang.String getChronicOnMhd () {
		return chronicOnMhd;
	}

	/**
	 * Set the value related to the column: chronic_on_mhd
	 * @param chronicOnMhd the chronic_on_mhd value
	 */
	public void setChronicOnMhd (java.lang.String chronicOnMhd) {
		this.chronicOnMhd = chronicOnMhd;
	}



	/**
	 * Return the value associated with the column: chronic_not_on_mhd
	 */
	public java.lang.String getChronicNotOnMhd () {
		return chronicNotOnMhd;
	}

	/**
	 * Set the value related to the column: chronic_not_on_mhd
	 * @param chronicNotOnMhd the chronic_not_on_mhd value
	 */
	public void setChronicNotOnMhd (java.lang.String chronicNotOnMhd) {
		this.chronicNotOnMhd = chronicNotOnMhd;
	}



	/**
	 * Return the value associated with the column: capd
	 */
	public java.lang.String getCapd () {
		return capd;
	}

	/**
	 * Set the value related to the column: capd
	 * @param capd the capd value
	 */
	public void setCapd (java.lang.String capd) {
		this.capd = capd;
	}



	/**
	 * Return the value associated with the column: transplantation
	 */
	public java.lang.String getTransplantation () {
		return transplantation;
	}

	/**
	 * Set the value related to the column: transplantation
	 * @param transplantation the transplantation value
	 */
	public void setTransplantation (java.lang.String transplantation) {
		this.transplantation = transplantation;
	}



	/**
	 * Return the value associated with the column: cough_duration
	 */
	public java.lang.String getCoughDuration () {
		return coughDuration;
	}

	/**
	 * Set the value related to the column: cough_duration
	 * @param coughDuration the cough_duration value
	 */
	public void setCoughDuration (java.lang.String coughDuration) {
		this.coughDuration = coughDuration;
	}



	/**
	 * Return the value associated with the column: cough_details
	 */
	public java.lang.String getCoughDetails () {
		return coughDetails;
	}

	/**
	 * Set the value related to the column: cough_details
	 * @param coughDetails the cough_details value
	 */
	public void setCoughDetails (java.lang.String coughDetails) {
		this.coughDetails = coughDetails;
	}



	/**
	 * Return the value associated with the column: sr_creatinine
	 */
	public java.lang.String getSrCreatinine () {
		return srCreatinine;
	}

	/**
	 * Set the value related to the column: sr_creatinine
	 * @param srCreatinine the sr_creatinine value
	 */
	public void setSrCreatinine (java.lang.String srCreatinine) {
		this.srCreatinine = srCreatinine;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.NephrologyCaseSheet)) return false;
		else {
			jkt.hms.masters.business.NephrologyCaseSheet nephrologyCaseSheet = (jkt.hms.masters.business.NephrologyCaseSheet) obj;
			if (null == this.getNephrologyCaseSheetId() || null == nephrologyCaseSheet.getNephrologyCaseSheetId()) return false;
			else return (this.getNephrologyCaseSheetId().equals(nephrologyCaseSheet.getNephrologyCaseSheetId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getNephrologyCaseSheetId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getNephrologyCaseSheetId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}