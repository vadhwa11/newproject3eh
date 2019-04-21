package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the drug_related_problem table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="drug_related_problem"
 */

public abstract class BaseDrugRelatedProblem  implements Serializable {

	public static String REF = "DrugRelatedProblem";
	public static String PROP_PHYSICAL_EXAMINATION = "PhysicalExamination";
	public static String PROP_PSYCHO_SOCIAL_DIVORCE_CURRENT = "PsychoSocialDivorceCurrent";
	public static String PROP_GASTRITIC_PAST = "GastriticPast";
	public static String PROP_PSYCHO_SOCIAL_FINANCIAL_LOSS_PAST = "PsychoSocialFinancialLossPast";
	public static String PROP_OTHERS_CURRENT = "OthersCurrent";
	public static String PROP_PSYCHIATRIC_STATUS_AMNESTY_DISORDER_CURRENT = "PsychiatricStatusAmnestyDisorderCurrent";
	public static String PROP_PSYCHIATRIC_STATUS_AMNESTY_DISORDER_PAST = "PsychiatricStatusAmnestyDisorderPast";
	public static String PROP_PSYCHO_SOCIAL_FRIEND_LOSS_PAST = "PsychoSocialFriendLossPast";
	public static String PROP_PSYCHIATRIC_STATUS_ANNXIETY_DISORDER_PAST = "PsychiatricStatusAnnxietyDisorderPast";
	public static String PROP_FORMULA_PLAN = "FormulaPlan";
	public static String PROP_PSYCHIATRIC_STATUS_SLEEP_DISORDER_PAST = "PsychiatricStatusSleepDisorderPast";
	public static String PROP_HEART_DISEASE_PAST = "HeartDiseasePast";
	public static String PROP_TREATMENT_REASON = "TreatmentReason";
	public static String PROP_PSYCHIATRIC_STATUS_DEMENTIA_PAST = "PsychiatricStatusDementiaPast";
	public static String PROP_PSYCHO_SOCIAL_FAMILY_FIGHT_CURRENT = "PsychoSocialFamilyFightCurrent";
	public static String PROP_PSYCHIATRIC_STATUS_SLEEP_DISORDER_CURRENT = "PsychiatricStatusSleepDisorderCurrent";
	public static String PROP_PSYCHIATRIC_STATUS_ANNXIETY_DISORDER_CURRENT = "PsychiatricStatusAnnxietyDisorderCurrent";
	public static String PROP_POLICE_CASE_CURRENT = "PoliceCaseCurrent";
	public static String PROP_PSYCHO_SOCIAL_SEPARATED_CURRENT = "PsychoSocialSeparatedCurrent";
	public static String PROP_HAEMATAMOSIS_PAST = "HaematamosisPast";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_PSYCHIATRIC_STATUS_PSYCHOTIC_DISORDER_CURRENT = "PsychiatricStatusPsychoticDisorderCurrent";
	public static String PROP_JOBLESS_CURRENT = "JoblessCurrent";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PERIPHERAL_NEURITIS_CURRENT = "PeripheralNeuritisCurrent";
	public static String PROP_PNEUMONIA_CURRENT = "PneumoniaCurrent";
	public static String PROP_VISIT = "Visit";
	public static String PROP_JAUNDICE_PAST = "JaundicePast";
	public static String PROP_PSYCHO_SOCIAL_SEPARATED_PAST = "PsychoSocialSeparatedPast";
	public static String PROP_PNEUMONIA_PAST = "PneumoniaPast";
	public static String PROP_OTHERS_PAST = "OthersPast";
	public static String PROP_ANEMIA_CURRENT = "AnemiaCurrent";
	public static String PROP_PORTAL_HTN_CURRENT = "PortalHtnCurrent";
	public static String PROP_JOB_SHIFTING_PAST = "JobShiftingPast";
	public static String PROP_ARREST_PAST = "ArrestPast";
	public static String PROP_CIRRHOSIS_PAST = "CirrhosisPast";
	public static String PROP_POLICE_CASE_PAST = "PoliceCasePast";
	public static String PROP_PSYCHIATRIC_STATUS_DELIRIUM_TREMENS_CURRENT = "PsychiatricStatusDeliriumTremensCurrent";
	public static String PROP_PSYCHO_SOCIAL_DIVORCE_PAST = "PsychoSocialDivorcePast";
	public static String PROP_ID = "Id";
	public static String PROP_ARREST_CURRENT = "ArrestCurrent";
	public static String PROP_OTHERS_PAST_VALUE = "OthersPastValue";
	public static String PROP_ASCITES_PAST = "AscitesPast";
	public static String PROP_FIGHTS_WORK_PLACE_PAST = "FightsWorkPlacePast";
	public static String PROP_HEART_DISEASE_CURRENT = "HeartDiseaseCurrent";
	public static String PROP_PORTAL_HTN_PAST = "PortalHtnPast";
	public static String PROP_PRIMARY_DRUG_ABUSE = "PrimaryDrugAbuse";
	public static String PROP_OTHERS = "Others";
	public static String PROP_FIGHTS_WORK_PLACE_CURRENT = "FightsWorkPlaceCurrent";
	public static String PROP_CIRRCHOSIS_CURRENT = "CirrchosisCurrent";
	public static String PROP_PSYCHIATRIC_STATUS_MOOD_DISORDER_CURRENT = "PsychiatricStatusMoodDisorderCurrent";
	public static String PROP_PSYCHO_SOCIAL_ACADEMIC_DETERIORATION_PAST = "PsychoSocialAcademicDeteriorationPast";
	public static String PROP_PSYCHO_SOCIAL_FINANCIAL_LOSS_CURRENT = "PsychoSocialFinancialLossCurrent";
	public static String PROP_PSYCHIATRIC_STATUS_SEXUAL_DYSFUNCTION_PAST = "PsychiatricStatusSexualDysfunctionPast";
	public static String PROP_PSYCHIATRIC_STATUS_MOOD_DISORDER_PAST = "PsychiatricStatusMoodDisorderPast";
	public static String PROP_ASCITES_CURRENT = "AscitesCurrent";
	public static String PROP_JOBLESS_PAST = "JoblessPast";
	public static String PROP_PSYCHO_SOCIAL_FAMILY_FIGHT_PAST = "PsychoSocialFamilyFightPast";
	public static String PROP_FAMILY_HISTORY_SELECT = "FamilyHistorySelect";
	public static String PROP_PSYCHIATRIC_STATUS_PSYCHOTIC_DISORDER_PAST = "PsychiatricStatusPsychoticDisorderPast";
	public static String PROP_SECONDARY_ABUSE = "SecondaryAbuse";
	public static String PROP_ANEMIA_PAST = "AnemiaPast";
	public static String PROP_OTHERS_CURRENT_VALUE = "OthersCurrentValue";
	public static String PROP_BRONCHITIS_PAST = "BronchitisPast";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_PSYCHO_SOCIAL_ACADEMIC_DETERIORATION_CURRENT = "PsychoSocialAcademicDeteriorationCurrent";
	public static String PROP_PSYCHIATRIC_STATUS_SEXUAL_DYSFUNCTION_CURRENT = "PsychiatricStatusSexualDysfunctionCurrent";
	public static String PROP_PSYCHIATRIC_STATUS_DEMENTIA_CURRENT = "PsychiatricStatusDementiaCurrent";
	public static String PROP_HAEMATAMOSIS_CURRENT = "HaematamosisCurrent";
	public static String PROP_PERIPHERAL_NEURITIS_PAST = "PeripheralNeuritisPast";
	public static String PROP_JAUNDICE_CURRENT = "JaundiceCurrent";
	public static String PROP_PREVIOUS_ATTEMPTS = "PreviousAttempts";
	public static String PROP_TXT_PREVIOUS_ATTEMPTS = "TxtPreviousAttempts";
	public static String PROP_PSYCHIATRIC_STATUS_DELIRIUM_TREMENS_PAST = "PsychiatricStatusDeliriumTremensPast";
	public static String PROP_GASTRITIS_CURRENT = "GastritisCurrent";
	public static String PROP_MENTAL_STATUS_EXAMINATION = "MentalStatusExamination";
	public static String PROP_PREMORBID_PERSONALITY = "PremorbidPersonality";
	public static String PROP_BRONCHITIS_CURRENT = "BronchitisCurrent";
	public static String PROP_PSYCHO_SOCIAL_FRIEND_LOSS_CURRENT = "PsychoSocialFriendLossCurrent";
	public static String PROP_JOB_SHITFING_CURRENT = "JobShitfingCurrent";


	// constructors
	public BaseDrugRelatedProblem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDrugRelatedProblem (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String gastritisCurrent;
	private java.lang.String gastriticPast;
	private java.lang.String jaundiceCurrent;
	private java.lang.String jaundicePast;
	private java.lang.String haematamosisCurrent;
	private java.lang.String haematamosisPast;
	private java.lang.String cirrchosisCurrent;
	private java.lang.String cirrhosisPast;
	private java.lang.String bronchitisCurrent;
	private java.lang.String bronchitisPast;
	private java.lang.String heartDiseaseCurrent;
	private java.lang.String heartDiseasePast;
	private java.lang.String anemiaCurrent;
	private java.lang.String anemiaPast;
	private java.lang.String peripheralNeuritisCurrent;
	private java.lang.String peripheralNeuritisPast;
	private java.lang.String othersPast;
	private java.lang.String othersPastValue;
	private java.lang.String others;
	private java.lang.String othersCurrent;
	private java.lang.String othersCurrentValue;
	private java.lang.String fightsWorkPlaceCurrent;
	private java.lang.String fightsWorkPlacePast;
	private java.lang.String joblessCurrent;
	private java.lang.String joblessPast;
	private java.lang.String jobShitfingCurrent;
	private java.lang.String jobShiftingPast;
	private java.lang.String policeCaseCurrent;
	private java.lang.String policeCasePast;
	private java.lang.String arrestCurrent;
	private java.lang.String arrestPast;
	private java.lang.String psychoSocialFamilyFightCurrent;
	private java.lang.String psychoSocialFamilyFightPast;
	private java.lang.String psychoSocialFriendLossCurrent;
	private java.lang.String psychoSocialFriendLossPast;
	private java.lang.String psychoSocialAcademicDeteriorationCurrent;
	private java.lang.String psychoSocialAcademicDeteriorationPast;
	private java.lang.String psychoSocialSeparatedCurrent;
	private java.lang.String psychoSocialSeparatedPast;
	private java.lang.String psychoSocialFinancialLossCurrent;
	private java.lang.String psychoSocialFinancialLossPast;
	private java.lang.String psychiatricStatusDeliriumTremensCurrent;
	private java.lang.String psychiatricStatusMoodDisorderCurrent;
	private java.lang.String psychiatricStatusSexualDysfunctionCurrent;
	private java.lang.String psychiatricStatusPsychoticDisorderCurrent;
	private java.lang.String psychiatricStatusAnnxietyDisorderCurrent;
	private java.lang.String psychiatricStatusAmnestyDisorderCurrent;
	private java.lang.String psychiatricStatusSleepDisorderCurrent;
	private java.lang.String familyHistory;
	private java.lang.String premorbidPersonality;
	private java.lang.String mentalStatusExamination;
	private java.lang.String physicalExamination;
	private java.lang.String investigation;
	private java.lang.String treatmentReason;
	private java.lang.String formulaPlan;
	private java.lang.String psychiatricStatusDeliriumTremensPast;
	private java.lang.String psychiatricStatusMoodDisorderPast;
	private java.lang.String psychiatricStatusSexualDysfunctionPast;
	private java.lang.String psychiatricStatusPsychoticDisorderPast;
	private java.lang.String psychiatricStatusAnnxietyDisorderPast;
	private java.lang.String psychiatricStatusAmnestyDisorderPast;
	private java.lang.String psychiatricStatusSleepDisorderPast;
	private java.lang.String psychiatricStatusDementiaCurrent;
	private java.lang.String psychiatricStatusDementiaPast;
	private java.lang.String psychoSocialDivorceCurrent;
	private java.lang.String psychoSocialDivorcePast;
	private java.lang.String portalHtnCurrent;
	private java.lang.String portalHtnPast;
	private java.lang.String previousAttempts;
	private java.lang.String txtPreviousAttempts;
	private java.lang.String pneumoniaCurrent;
	private java.lang.String pneumoniaPast;
	private java.lang.String ascitesCurrent;
	private java.lang.String ascitesPast;
	private java.lang.String primaryDrugAbuse;
	private java.lang.String secondaryAbuse;
	private java.lang.String familyHistorySelect;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="drug_related_problem_id"
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
	 * Return the value associated with the column: gastritis_current
	 */
	public java.lang.String getGastritisCurrent () {
		return gastritisCurrent;
	}

	/**
	 * Set the value related to the column: gastritis_current
	 * @param gastritisCurrent the gastritis_current value
	 */
	public void setGastritisCurrent (java.lang.String gastritisCurrent) {
		this.gastritisCurrent = gastritisCurrent;
	}



	/**
	 * Return the value associated with the column: gastritic_past
	 */
	public java.lang.String getGastriticPast () {
		return gastriticPast;
	}

	/**
	 * Set the value related to the column: gastritic_past
	 * @param gastriticPast the gastritic_past value
	 */
	public void setGastriticPast (java.lang.String gastriticPast) {
		this.gastriticPast = gastriticPast;
	}



	/**
	 * Return the value associated with the column: jaundice_current
	 */
	public java.lang.String getJaundiceCurrent () {
		return jaundiceCurrent;
	}

	/**
	 * Set the value related to the column: jaundice_current
	 * @param jaundiceCurrent the jaundice_current value
	 */
	public void setJaundiceCurrent (java.lang.String jaundiceCurrent) {
		this.jaundiceCurrent = jaundiceCurrent;
	}



	/**
	 * Return the value associated with the column: jaundice_past
	 */
	public java.lang.String getJaundicePast () {
		return jaundicePast;
	}

	/**
	 * Set the value related to the column: jaundice_past
	 * @param jaundicePast the jaundice_past value
	 */
	public void setJaundicePast (java.lang.String jaundicePast) {
		this.jaundicePast = jaundicePast;
	}



	/**
	 * Return the value associated with the column: haematamosis_current
	 */
	public java.lang.String getHaematamosisCurrent () {
		return haematamosisCurrent;
	}

	/**
	 * Set the value related to the column: haematamosis_current
	 * @param haematamosisCurrent the haematamosis_current value
	 */
	public void setHaematamosisCurrent (java.lang.String haematamosisCurrent) {
		this.haematamosisCurrent = haematamosisCurrent;
	}



	/**
	 * Return the value associated with the column: haematamosis_past
	 */
	public java.lang.String getHaematamosisPast () {
		return haematamosisPast;
	}

	/**
	 * Set the value related to the column: haematamosis_past
	 * @param haematamosisPast the haematamosis_past value
	 */
	public void setHaematamosisPast (java.lang.String haematamosisPast) {
		this.haematamosisPast = haematamosisPast;
	}



	/**
	 * Return the value associated with the column: cirrchosis_current
	 */
	public java.lang.String getCirrchosisCurrent () {
		return cirrchosisCurrent;
	}

	/**
	 * Set the value related to the column: cirrchosis_current
	 * @param cirrchosisCurrent the cirrchosis_current value
	 */
	public void setCirrchosisCurrent (java.lang.String cirrchosisCurrent) {
		this.cirrchosisCurrent = cirrchosisCurrent;
	}



	/**
	 * Return the value associated with the column: cirrhosis_past
	 */
	public java.lang.String getCirrhosisPast () {
		return cirrhosisPast;
	}

	/**
	 * Set the value related to the column: cirrhosis_past
	 * @param cirrhosisPast the cirrhosis_past value
	 */
	public void setCirrhosisPast (java.lang.String cirrhosisPast) {
		this.cirrhosisPast = cirrhosisPast;
	}



	/**
	 * Return the value associated with the column: bronchitis_current
	 */
	public java.lang.String getBronchitisCurrent () {
		return bronchitisCurrent;
	}

	/**
	 * Set the value related to the column: bronchitis_current
	 * @param bronchitisCurrent the bronchitis_current value
	 */
	public void setBronchitisCurrent (java.lang.String bronchitisCurrent) {
		this.bronchitisCurrent = bronchitisCurrent;
	}



	/**
	 * Return the value associated with the column: bronchitis_past
	 */
	public java.lang.String getBronchitisPast () {
		return bronchitisPast;
	}

	/**
	 * Set the value related to the column: bronchitis_past
	 * @param bronchitisPast the bronchitis_past value
	 */
	public void setBronchitisPast (java.lang.String bronchitisPast) {
		this.bronchitisPast = bronchitisPast;
	}



	/**
	 * Return the value associated with the column: heart_disease_current
	 */
	public java.lang.String getHeartDiseaseCurrent () {
		return heartDiseaseCurrent;
	}

	/**
	 * Set the value related to the column: heart_disease_current
	 * @param heartDiseaseCurrent the heart_disease_current value
	 */
	public void setHeartDiseaseCurrent (java.lang.String heartDiseaseCurrent) {
		this.heartDiseaseCurrent = heartDiseaseCurrent;
	}



	/**
	 * Return the value associated with the column: heart_disease_past
	 */
	public java.lang.String getHeartDiseasePast () {
		return heartDiseasePast;
	}

	/**
	 * Set the value related to the column: heart_disease_past
	 * @param heartDiseasePast the heart_disease_past value
	 */
	public void setHeartDiseasePast (java.lang.String heartDiseasePast) {
		this.heartDiseasePast = heartDiseasePast;
	}



	/**
	 * Return the value associated with the column: anemia_current
	 */
	public java.lang.String getAnemiaCurrent () {
		return anemiaCurrent;
	}

	/**
	 * Set the value related to the column: anemia_current
	 * @param anemiaCurrent the anemia_current value
	 */
	public void setAnemiaCurrent (java.lang.String anemiaCurrent) {
		this.anemiaCurrent = anemiaCurrent;
	}



	/**
	 * Return the value associated with the column: anemia_past
	 */
	public java.lang.String getAnemiaPast () {
		return anemiaPast;
	}

	/**
	 * Set the value related to the column: anemia_past
	 * @param anemiaPast the anemia_past value
	 */
	public void setAnemiaPast (java.lang.String anemiaPast) {
		this.anemiaPast = anemiaPast;
	}



	/**
	 * Return the value associated with the column: peripheral_neuritis_current
	 */
	public java.lang.String getPeripheralNeuritisCurrent () {
		return peripheralNeuritisCurrent;
	}

	/**
	 * Set the value related to the column: peripheral_neuritis_current
	 * @param peripheralNeuritisCurrent the peripheral_neuritis_current value
	 */
	public void setPeripheralNeuritisCurrent (java.lang.String peripheralNeuritisCurrent) {
		this.peripheralNeuritisCurrent = peripheralNeuritisCurrent;
	}



	/**
	 * Return the value associated with the column: peripheral_neuritis_past
	 */
	public java.lang.String getPeripheralNeuritisPast () {
		return peripheralNeuritisPast;
	}

	/**
	 * Set the value related to the column: peripheral_neuritis_past
	 * @param peripheralNeuritisPast the peripheral_neuritis_past value
	 */
	public void setPeripheralNeuritisPast (java.lang.String peripheralNeuritisPast) {
		this.peripheralNeuritisPast = peripheralNeuritisPast;
	}



	/**
	 * Return the value associated with the column: others_past
	 */
	public java.lang.String getOthersPast () {
		return othersPast;
	}

	/**
	 * Set the value related to the column: others_past
	 * @param othersPast the others_past value
	 */
	public void setOthersPast (java.lang.String othersPast) {
		this.othersPast = othersPast;
	}



	/**
	 * Return the value associated with the column: others_past_value
	 */
	public java.lang.String getOthersPastValue () {
		return othersPastValue;
	}

	/**
	 * Set the value related to the column: others_past_value
	 * @param othersPastValue the others_past_value value
	 */
	public void setOthersPastValue (java.lang.String othersPastValue) {
		this.othersPastValue = othersPastValue;
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
	 * Return the value associated with the column: others_current
	 */
	public java.lang.String getOthersCurrent () {
		return othersCurrent;
	}

	/**
	 * Set the value related to the column: others_current
	 * @param othersCurrent the others_current value
	 */
	public void setOthersCurrent (java.lang.String othersCurrent) {
		this.othersCurrent = othersCurrent;
	}



	/**
	 * Return the value associated with the column: others_current_value
	 */
	public java.lang.String getOthersCurrentValue () {
		return othersCurrentValue;
	}

	/**
	 * Set the value related to the column: others_current_value
	 * @param othersCurrentValue the others_current_value value
	 */
	public void setOthersCurrentValue (java.lang.String othersCurrentValue) {
		this.othersCurrentValue = othersCurrentValue;
	}



	/**
	 * Return the value associated with the column: fights_work_place_current
	 */
	public java.lang.String getFightsWorkPlaceCurrent () {
		return fightsWorkPlaceCurrent;
	}

	/**
	 * Set the value related to the column: fights_work_place_current
	 * @param fightsWorkPlaceCurrent the fights_work_place_current value
	 */
	public void setFightsWorkPlaceCurrent (java.lang.String fightsWorkPlaceCurrent) {
		this.fightsWorkPlaceCurrent = fightsWorkPlaceCurrent;
	}



	/**
	 * Return the value associated with the column: fights_work_place_past
	 */
	public java.lang.String getFightsWorkPlacePast () {
		return fightsWorkPlacePast;
	}

	/**
	 * Set the value related to the column: fights_work_place_past
	 * @param fightsWorkPlacePast the fights_work_place_past value
	 */
	public void setFightsWorkPlacePast (java.lang.String fightsWorkPlacePast) {
		this.fightsWorkPlacePast = fightsWorkPlacePast;
	}



	/**
	 * Return the value associated with the column: jobless_current
	 */
	public java.lang.String getJoblessCurrent () {
		return joblessCurrent;
	}

	/**
	 * Set the value related to the column: jobless_current
	 * @param joblessCurrent the jobless_current value
	 */
	public void setJoblessCurrent (java.lang.String joblessCurrent) {
		this.joblessCurrent = joblessCurrent;
	}



	/**
	 * Return the value associated with the column: jobless_past
	 */
	public java.lang.String getJoblessPast () {
		return joblessPast;
	}

	/**
	 * Set the value related to the column: jobless_past
	 * @param joblessPast the jobless_past value
	 */
	public void setJoblessPast (java.lang.String joblessPast) {
		this.joblessPast = joblessPast;
	}



	/**
	 * Return the value associated with the column: job_shitfing_current
	 */
	public java.lang.String getJobShitfingCurrent () {
		return jobShitfingCurrent;
	}

	/**
	 * Set the value related to the column: job_shitfing_current
	 * @param jobShitfingCurrent the job_shitfing_current value
	 */
	public void setJobShitfingCurrent (java.lang.String jobShitfingCurrent) {
		this.jobShitfingCurrent = jobShitfingCurrent;
	}



	/**
	 * Return the value associated with the column: job_shifting_past
	 */
	public java.lang.String getJobShiftingPast () {
		return jobShiftingPast;
	}

	/**
	 * Set the value related to the column: job_shifting_past
	 * @param jobShiftingPast the job_shifting_past value
	 */
	public void setJobShiftingPast (java.lang.String jobShiftingPast) {
		this.jobShiftingPast = jobShiftingPast;
	}



	/**
	 * Return the value associated with the column: police_case_current
	 */
	public java.lang.String getPoliceCaseCurrent () {
		return policeCaseCurrent;
	}

	/**
	 * Set the value related to the column: police_case_current
	 * @param policeCaseCurrent the police_case_current value
	 */
	public void setPoliceCaseCurrent (java.lang.String policeCaseCurrent) {
		this.policeCaseCurrent = policeCaseCurrent;
	}



	/**
	 * Return the value associated with the column: police_case_past
	 */
	public java.lang.String getPoliceCasePast () {
		return policeCasePast;
	}

	/**
	 * Set the value related to the column: police_case_past
	 * @param policeCasePast the police_case_past value
	 */
	public void setPoliceCasePast (java.lang.String policeCasePast) {
		this.policeCasePast = policeCasePast;
	}



	/**
	 * Return the value associated with the column: arrest_current
	 */
	public java.lang.String getArrestCurrent () {
		return arrestCurrent;
	}

	/**
	 * Set the value related to the column: arrest_current
	 * @param arrestCurrent the arrest_current value
	 */
	public void setArrestCurrent (java.lang.String arrestCurrent) {
		this.arrestCurrent = arrestCurrent;
	}



	/**
	 * Return the value associated with the column: arrest_past
	 */
	public java.lang.String getArrestPast () {
		return arrestPast;
	}

	/**
	 * Set the value related to the column: arrest_past
	 * @param arrestPast the arrest_past value
	 */
	public void setArrestPast (java.lang.String arrestPast) {
		this.arrestPast = arrestPast;
	}



	/**
	 * Return the value associated with the column: psycho_social_family_fight_current
	 */
	public java.lang.String getPsychoSocialFamilyFightCurrent () {
		return psychoSocialFamilyFightCurrent;
	}

	/**
	 * Set the value related to the column: psycho_social_family_fight_current
	 * @param psychoSocialFamilyFightCurrent the psycho_social_family_fight_current value
	 */
	public void setPsychoSocialFamilyFightCurrent (java.lang.String psychoSocialFamilyFightCurrent) {
		this.psychoSocialFamilyFightCurrent = psychoSocialFamilyFightCurrent;
	}



	/**
	 * Return the value associated with the column: psycho_social_family_fight_past
	 */
	public java.lang.String getPsychoSocialFamilyFightPast () {
		return psychoSocialFamilyFightPast;
	}

	/**
	 * Set the value related to the column: psycho_social_family_fight_past
	 * @param psychoSocialFamilyFightPast the psycho_social_family_fight_past value
	 */
	public void setPsychoSocialFamilyFightPast (java.lang.String psychoSocialFamilyFightPast) {
		this.psychoSocialFamilyFightPast = psychoSocialFamilyFightPast;
	}



	/**
	 * Return the value associated with the column: psycho_social_friend_loss_current
	 */
	public java.lang.String getPsychoSocialFriendLossCurrent () {
		return psychoSocialFriendLossCurrent;
	}

	/**
	 * Set the value related to the column: psycho_social_friend_loss_current
	 * @param psychoSocialFriendLossCurrent the psycho_social_friend_loss_current value
	 */
	public void setPsychoSocialFriendLossCurrent (java.lang.String psychoSocialFriendLossCurrent) {
		this.psychoSocialFriendLossCurrent = psychoSocialFriendLossCurrent;
	}



	/**
	 * Return the value associated with the column: psycho_social_friend_loss_past
	 */
	public java.lang.String getPsychoSocialFriendLossPast () {
		return psychoSocialFriendLossPast;
	}

	/**
	 * Set the value related to the column: psycho_social_friend_loss_past
	 * @param psychoSocialFriendLossPast the psycho_social_friend_loss_past value
	 */
	public void setPsychoSocialFriendLossPast (java.lang.String psychoSocialFriendLossPast) {
		this.psychoSocialFriendLossPast = psychoSocialFriendLossPast;
	}



	/**
	 * Return the value associated with the column: psycho_social_academic_deterioration_current
	 */
	public java.lang.String getPsychoSocialAcademicDeteriorationCurrent () {
		return psychoSocialAcademicDeteriorationCurrent;
	}

	/**
	 * Set the value related to the column: psycho_social_academic_deterioration_current
	 * @param psychoSocialAcademicDeteriorationCurrent the psycho_social_academic_deterioration_current value
	 */
	public void setPsychoSocialAcademicDeteriorationCurrent (java.lang.String psychoSocialAcademicDeteriorationCurrent) {
		this.psychoSocialAcademicDeteriorationCurrent = psychoSocialAcademicDeteriorationCurrent;
	}



	/**
	 * Return the value associated with the column: psycho_social_academic_deterioration_past
	 */
	public java.lang.String getPsychoSocialAcademicDeteriorationPast () {
		return psychoSocialAcademicDeteriorationPast;
	}

	/**
	 * Set the value related to the column: psycho_social_academic_deterioration_past
	 * @param psychoSocialAcademicDeteriorationPast the psycho_social_academic_deterioration_past value
	 */
	public void setPsychoSocialAcademicDeteriorationPast (java.lang.String psychoSocialAcademicDeteriorationPast) {
		this.psychoSocialAcademicDeteriorationPast = psychoSocialAcademicDeteriorationPast;
	}



	/**
	 * Return the value associated with the column: psycho_social_separated_current
	 */
	public java.lang.String getPsychoSocialSeparatedCurrent () {
		return psychoSocialSeparatedCurrent;
	}

	/**
	 * Set the value related to the column: psycho_social_separated_current
	 * @param psychoSocialSeparatedCurrent the psycho_social_separated_current value
	 */
	public void setPsychoSocialSeparatedCurrent (java.lang.String psychoSocialSeparatedCurrent) {
		this.psychoSocialSeparatedCurrent = psychoSocialSeparatedCurrent;
	}



	/**
	 * Return the value associated with the column: psycho_social_separated_past
	 */
	public java.lang.String getPsychoSocialSeparatedPast () {
		return psychoSocialSeparatedPast;
	}

	/**
	 * Set the value related to the column: psycho_social_separated_past
	 * @param psychoSocialSeparatedPast the psycho_social_separated_past value
	 */
	public void setPsychoSocialSeparatedPast (java.lang.String psychoSocialSeparatedPast) {
		this.psychoSocialSeparatedPast = psychoSocialSeparatedPast;
	}



	/**
	 * Return the value associated with the column: psycho_social_financial_loss_current
	 */
	public java.lang.String getPsychoSocialFinancialLossCurrent () {
		return psychoSocialFinancialLossCurrent;
	}

	/**
	 * Set the value related to the column: psycho_social_financial_loss_current
	 * @param psychoSocialFinancialLossCurrent the psycho_social_financial_loss_current value
	 */
	public void setPsychoSocialFinancialLossCurrent (java.lang.String psychoSocialFinancialLossCurrent) {
		this.psychoSocialFinancialLossCurrent = psychoSocialFinancialLossCurrent;
	}



	/**
	 * Return the value associated with the column: psycho_social_financial_loss_past
	 */
	public java.lang.String getPsychoSocialFinancialLossPast () {
		return psychoSocialFinancialLossPast;
	}

	/**
	 * Set the value related to the column: psycho_social_financial_loss_past
	 * @param psychoSocialFinancialLossPast the psycho_social_financial_loss_past value
	 */
	public void setPsychoSocialFinancialLossPast (java.lang.String psychoSocialFinancialLossPast) {
		this.psychoSocialFinancialLossPast = psychoSocialFinancialLossPast;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_delirium_tremens_current
	 */
	public java.lang.String getPsychiatricStatusDeliriumTremensCurrent () {
		return psychiatricStatusDeliriumTremensCurrent;
	}

	/**
	 * Set the value related to the column: psychiatric_status_delirium_tremens_current
	 * @param psychiatricStatusDeliriumTremensCurrent the psychiatric_status_delirium_tremens_current value
	 */
	public void setPsychiatricStatusDeliriumTremensCurrent (java.lang.String psychiatricStatusDeliriumTremensCurrent) {
		this.psychiatricStatusDeliriumTremensCurrent = psychiatricStatusDeliriumTremensCurrent;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_mood_disorder_current
	 */
	public java.lang.String getPsychiatricStatusMoodDisorderCurrent () {
		return psychiatricStatusMoodDisorderCurrent;
	}

	/**
	 * Set the value related to the column: psychiatric_status_mood_disorder_current
	 * @param psychiatricStatusMoodDisorderCurrent the psychiatric_status_mood_disorder_current value
	 */
	public void setPsychiatricStatusMoodDisorderCurrent (java.lang.String psychiatricStatusMoodDisorderCurrent) {
		this.psychiatricStatusMoodDisorderCurrent = psychiatricStatusMoodDisorderCurrent;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_sexual_dysfunction_current
	 */
	public java.lang.String getPsychiatricStatusSexualDysfunctionCurrent () {
		return psychiatricStatusSexualDysfunctionCurrent;
	}

	/**
	 * Set the value related to the column: psychiatric_status_sexual_dysfunction_current
	 * @param psychiatricStatusSexualDysfunctionCurrent the psychiatric_status_sexual_dysfunction_current value
	 */
	public void setPsychiatricStatusSexualDysfunctionCurrent (java.lang.String psychiatricStatusSexualDysfunctionCurrent) {
		this.psychiatricStatusSexualDysfunctionCurrent = psychiatricStatusSexualDysfunctionCurrent;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_psychotic_disorder_current
	 */
	public java.lang.String getPsychiatricStatusPsychoticDisorderCurrent () {
		return psychiatricStatusPsychoticDisorderCurrent;
	}

	/**
	 * Set the value related to the column: psychiatric_status_psychotic_disorder_current
	 * @param psychiatricStatusPsychoticDisorderCurrent the psychiatric_status_psychotic_disorder_current value
	 */
	public void setPsychiatricStatusPsychoticDisorderCurrent (java.lang.String psychiatricStatusPsychoticDisorderCurrent) {
		this.psychiatricStatusPsychoticDisorderCurrent = psychiatricStatusPsychoticDisorderCurrent;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_annxiety_disorder_current
	 */
	public java.lang.String getPsychiatricStatusAnnxietyDisorderCurrent () {
		return psychiatricStatusAnnxietyDisorderCurrent;
	}

	/**
	 * Set the value related to the column: psychiatric_status_annxiety_disorder_current
	 * @param psychiatricStatusAnnxietyDisorderCurrent the psychiatric_status_annxiety_disorder_current value
	 */
	public void setPsychiatricStatusAnnxietyDisorderCurrent (java.lang.String psychiatricStatusAnnxietyDisorderCurrent) {
		this.psychiatricStatusAnnxietyDisorderCurrent = psychiatricStatusAnnxietyDisorderCurrent;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_amnesty_disorder_current
	 */
	public java.lang.String getPsychiatricStatusAmnestyDisorderCurrent () {
		return psychiatricStatusAmnestyDisorderCurrent;
	}

	/**
	 * Set the value related to the column: psychiatric_status_amnesty_disorder_current
	 * @param psychiatricStatusAmnestyDisorderCurrent the psychiatric_status_amnesty_disorder_current value
	 */
	public void setPsychiatricStatusAmnestyDisorderCurrent (java.lang.String psychiatricStatusAmnestyDisorderCurrent) {
		this.psychiatricStatusAmnestyDisorderCurrent = psychiatricStatusAmnestyDisorderCurrent;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_sleep_disorder_current
	 */
	public java.lang.String getPsychiatricStatusSleepDisorderCurrent () {
		return psychiatricStatusSleepDisorderCurrent;
	}

	/**
	 * Set the value related to the column: psychiatric_status_sleep_disorder_current
	 * @param psychiatricStatusSleepDisorderCurrent the psychiatric_status_sleep_disorder_current value
	 */
	public void setPsychiatricStatusSleepDisorderCurrent (java.lang.String psychiatricStatusSleepDisorderCurrent) {
		this.psychiatricStatusSleepDisorderCurrent = psychiatricStatusSleepDisorderCurrent;
	}



	/**
	 * Return the value associated with the column: family_history
	 */
	public java.lang.String getFamilyHistory () {
		return familyHistory;
	}

	/**
	 * Set the value related to the column: family_history
	 * @param familyHistory the family_history value
	 */
	public void setFamilyHistory (java.lang.String familyHistory) {
		this.familyHistory = familyHistory;
	}



	/**
	 * Return the value associated with the column: premorbid_personality
	 */
	public java.lang.String getPremorbidPersonality () {
		return premorbidPersonality;
	}

	/**
	 * Set the value related to the column: premorbid_personality
	 * @param premorbidPersonality the premorbid_personality value
	 */
	public void setPremorbidPersonality (java.lang.String premorbidPersonality) {
		this.premorbidPersonality = premorbidPersonality;
	}



	/**
	 * Return the value associated with the column: mental_status_examination
	 */
	public java.lang.String getMentalStatusExamination () {
		return mentalStatusExamination;
	}

	/**
	 * Set the value related to the column: mental_status_examination
	 * @param mentalStatusExamination the mental_status_examination value
	 */
	public void setMentalStatusExamination (java.lang.String mentalStatusExamination) {
		this.mentalStatusExamination = mentalStatusExamination;
	}



	/**
	 * Return the value associated with the column: physical_examination
	 */
	public java.lang.String getPhysicalExamination () {
		return physicalExamination;
	}

	/**
	 * Set the value related to the column: physical_examination
	 * @param physicalExamination the physical_examination value
	 */
	public void setPhysicalExamination (java.lang.String physicalExamination) {
		this.physicalExamination = physicalExamination;
	}



	/**
	 * Return the value associated with the column: investigation
	 */
	public java.lang.String getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation
	 * @param investigation the investigation value
	 */
	public void setInvestigation (java.lang.String investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: treatment_reason
	 */
	public java.lang.String getTreatmentReason () {
		return treatmentReason;
	}

	/**
	 * Set the value related to the column: treatment_reason
	 * @param treatmentReason the treatment_reason value
	 */
	public void setTreatmentReason (java.lang.String treatmentReason) {
		this.treatmentReason = treatmentReason;
	}



	/**
	 * Return the value associated with the column: formula_plan
	 */
	public java.lang.String getFormulaPlan () {
		return formulaPlan;
	}

	/**
	 * Set the value related to the column: formula_plan
	 * @param formulaPlan the formula_plan value
	 */
	public void setFormulaPlan (java.lang.String formulaPlan) {
		this.formulaPlan = formulaPlan;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_delirium_tremens_past
	 */
	public java.lang.String getPsychiatricStatusDeliriumTremensPast () {
		return psychiatricStatusDeliriumTremensPast;
	}

	/**
	 * Set the value related to the column: psychiatric_status_delirium_tremens_past
	 * @param psychiatricStatusDeliriumTremensPast the psychiatric_status_delirium_tremens_past value
	 */
	public void setPsychiatricStatusDeliriumTremensPast (java.lang.String psychiatricStatusDeliriumTremensPast) {
		this.psychiatricStatusDeliriumTremensPast = psychiatricStatusDeliriumTremensPast;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_mood_disorder_past
	 */
	public java.lang.String getPsychiatricStatusMoodDisorderPast () {
		return psychiatricStatusMoodDisorderPast;
	}

	/**
	 * Set the value related to the column: psychiatric_status_mood_disorder_past
	 * @param psychiatricStatusMoodDisorderPast the psychiatric_status_mood_disorder_past value
	 */
	public void setPsychiatricStatusMoodDisorderPast (java.lang.String psychiatricStatusMoodDisorderPast) {
		this.psychiatricStatusMoodDisorderPast = psychiatricStatusMoodDisorderPast;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_sexual_dysfunction_past
	 */
	public java.lang.String getPsychiatricStatusSexualDysfunctionPast () {
		return psychiatricStatusSexualDysfunctionPast;
	}

	/**
	 * Set the value related to the column: psychiatric_status_sexual_dysfunction_past
	 * @param psychiatricStatusSexualDysfunctionPast the psychiatric_status_sexual_dysfunction_past value
	 */
	public void setPsychiatricStatusSexualDysfunctionPast (java.lang.String psychiatricStatusSexualDysfunctionPast) {
		this.psychiatricStatusSexualDysfunctionPast = psychiatricStatusSexualDysfunctionPast;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_psychotic_disorder_past
	 */
	public java.lang.String getPsychiatricStatusPsychoticDisorderPast () {
		return psychiatricStatusPsychoticDisorderPast;
	}

	/**
	 * Set the value related to the column: psychiatric_status_psychotic_disorder_past
	 * @param psychiatricStatusPsychoticDisorderPast the psychiatric_status_psychotic_disorder_past value
	 */
	public void setPsychiatricStatusPsychoticDisorderPast (java.lang.String psychiatricStatusPsychoticDisorderPast) {
		this.psychiatricStatusPsychoticDisorderPast = psychiatricStatusPsychoticDisorderPast;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_annxiety_disorder_past
	 */
	public java.lang.String getPsychiatricStatusAnnxietyDisorderPast () {
		return psychiatricStatusAnnxietyDisorderPast;
	}

	/**
	 * Set the value related to the column: psychiatric_status_annxiety_disorder_past
	 * @param psychiatricStatusAnnxietyDisorderPast the psychiatric_status_annxiety_disorder_past value
	 */
	public void setPsychiatricStatusAnnxietyDisorderPast (java.lang.String psychiatricStatusAnnxietyDisorderPast) {
		this.psychiatricStatusAnnxietyDisorderPast = psychiatricStatusAnnxietyDisorderPast;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_amnesty_disorder_past
	 */
	public java.lang.String getPsychiatricStatusAmnestyDisorderPast () {
		return psychiatricStatusAmnestyDisorderPast;
	}

	/**
	 * Set the value related to the column: psychiatric_status_amnesty_disorder_past
	 * @param psychiatricStatusAmnestyDisorderPast the psychiatric_status_amnesty_disorder_past value
	 */
	public void setPsychiatricStatusAmnestyDisorderPast (java.lang.String psychiatricStatusAmnestyDisorderPast) {
		this.psychiatricStatusAmnestyDisorderPast = psychiatricStatusAmnestyDisorderPast;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_sleep_disorder_past
	 */
	public java.lang.String getPsychiatricStatusSleepDisorderPast () {
		return psychiatricStatusSleepDisorderPast;
	}

	/**
	 * Set the value related to the column: psychiatric_status_sleep_disorder_past
	 * @param psychiatricStatusSleepDisorderPast the psychiatric_status_sleep_disorder_past value
	 */
	public void setPsychiatricStatusSleepDisorderPast (java.lang.String psychiatricStatusSleepDisorderPast) {
		this.psychiatricStatusSleepDisorderPast = psychiatricStatusSleepDisorderPast;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_dementia_current
	 */
	public java.lang.String getPsychiatricStatusDementiaCurrent () {
		return psychiatricStatusDementiaCurrent;
	}

	/**
	 * Set the value related to the column: psychiatric_status_dementia_current
	 * @param psychiatricStatusDementiaCurrent the psychiatric_status_dementia_current value
	 */
	public void setPsychiatricStatusDementiaCurrent (java.lang.String psychiatricStatusDementiaCurrent) {
		this.psychiatricStatusDementiaCurrent = psychiatricStatusDementiaCurrent;
	}



	/**
	 * Return the value associated with the column: psychiatric_status_dementia_past
	 */
	public java.lang.String getPsychiatricStatusDementiaPast () {
		return psychiatricStatusDementiaPast;
	}

	/**
	 * Set the value related to the column: psychiatric_status_dementia_past
	 * @param psychiatricStatusDementiaPast the psychiatric_status_dementia_past value
	 */
	public void setPsychiatricStatusDementiaPast (java.lang.String psychiatricStatusDementiaPast) {
		this.psychiatricStatusDementiaPast = psychiatricStatusDementiaPast;
	}



	/**
	 * Return the value associated with the column: psycho_social_divorce_current
	 */
	public java.lang.String getPsychoSocialDivorceCurrent () {
		return psychoSocialDivorceCurrent;
	}

	/**
	 * Set the value related to the column: psycho_social_divorce_current
	 * @param psychoSocialDivorceCurrent the psycho_social_divorce_current value
	 */
	public void setPsychoSocialDivorceCurrent (java.lang.String psychoSocialDivorceCurrent) {
		this.psychoSocialDivorceCurrent = psychoSocialDivorceCurrent;
	}



	/**
	 * Return the value associated with the column: psycho_social_divorce_past
	 */
	public java.lang.String getPsychoSocialDivorcePast () {
		return psychoSocialDivorcePast;
	}

	/**
	 * Set the value related to the column: psycho_social_divorce_past
	 * @param psychoSocialDivorcePast the psycho_social_divorce_past value
	 */
	public void setPsychoSocialDivorcePast (java.lang.String psychoSocialDivorcePast) {
		this.psychoSocialDivorcePast = psychoSocialDivorcePast;
	}



	/**
	 * Return the value associated with the column: portal_htn_current
	 */
	public java.lang.String getPortalHtnCurrent () {
		return portalHtnCurrent;
	}

	/**
	 * Set the value related to the column: portal_htn_current
	 * @param portalHtnCurrent the portal_htn_current value
	 */
	public void setPortalHtnCurrent (java.lang.String portalHtnCurrent) {
		this.portalHtnCurrent = portalHtnCurrent;
	}



	/**
	 * Return the value associated with the column: portal_htn_past
	 */
	public java.lang.String getPortalHtnPast () {
		return portalHtnPast;
	}

	/**
	 * Set the value related to the column: portal_htn_past
	 * @param portalHtnPast the portal_htn_past value
	 */
	public void setPortalHtnPast (java.lang.String portalHtnPast) {
		this.portalHtnPast = portalHtnPast;
	}



	/**
	 * Return the value associated with the column: previous_attempts
	 */
	public java.lang.String getPreviousAttempts () {
		return previousAttempts;
	}

	/**
	 * Set the value related to the column: previous_attempts
	 * @param previousAttempts the previous_attempts value
	 */
	public void setPreviousAttempts (java.lang.String previousAttempts) {
		this.previousAttempts = previousAttempts;
	}



	/**
	 * Return the value associated with the column: txt_previous_attempts
	 */
	public java.lang.String getTxtPreviousAttempts () {
		return txtPreviousAttempts;
	}

	/**
	 * Set the value related to the column: txt_previous_attempts
	 * @param txtPreviousAttempts the txt_previous_attempts value
	 */
	public void setTxtPreviousAttempts (java.lang.String txtPreviousAttempts) {
		this.txtPreviousAttempts = txtPreviousAttempts;
	}



	/**
	 * Return the value associated with the column: pneumonia_current
	 */
	public java.lang.String getPneumoniaCurrent () {
		return pneumoniaCurrent;
	}

	/**
	 * Set the value related to the column: pneumonia_current
	 * @param pneumoniaCurrent the pneumonia_current value
	 */
	public void setPneumoniaCurrent (java.lang.String pneumoniaCurrent) {
		this.pneumoniaCurrent = pneumoniaCurrent;
	}



	/**
	 * Return the value associated with the column: pneumonia_past
	 */
	public java.lang.String getPneumoniaPast () {
		return pneumoniaPast;
	}

	/**
	 * Set the value related to the column: pneumonia_past
	 * @param pneumoniaPast the pneumonia_past value
	 */
	public void setPneumoniaPast (java.lang.String pneumoniaPast) {
		this.pneumoniaPast = pneumoniaPast;
	}



	/**
	 * Return the value associated with the column: ascites_current
	 */
	public java.lang.String getAscitesCurrent () {
		return ascitesCurrent;
	}

	/**
	 * Set the value related to the column: ascites_current
	 * @param ascitesCurrent the ascites_current value
	 */
	public void setAscitesCurrent (java.lang.String ascitesCurrent) {
		this.ascitesCurrent = ascitesCurrent;
	}



	/**
	 * Return the value associated with the column: ascites_past
	 */
	public java.lang.String getAscitesPast () {
		return ascitesPast;
	}

	/**
	 * Set the value related to the column: ascites_past
	 * @param ascitesPast the ascites_past value
	 */
	public void setAscitesPast (java.lang.String ascitesPast) {
		this.ascitesPast = ascitesPast;
	}



	/**
	 * Return the value associated with the column: primary_drug_abuse
	 */
	public java.lang.String getPrimaryDrugAbuse () {
		return primaryDrugAbuse;
	}

	/**
	 * Set the value related to the column: primary_drug_abuse
	 * @param primaryDrugAbuse the primary_drug_abuse value
	 */
	public void setPrimaryDrugAbuse (java.lang.String primaryDrugAbuse) {
		this.primaryDrugAbuse = primaryDrugAbuse;
	}



	/**
	 * Return the value associated with the column: secondary_abuse
	 */
	public java.lang.String getSecondaryAbuse () {
		return secondaryAbuse;
	}

	/**
	 * Set the value related to the column: secondary_abuse
	 * @param secondaryAbuse the secondary_abuse value
	 */
	public void setSecondaryAbuse (java.lang.String secondaryAbuse) {
		this.secondaryAbuse = secondaryAbuse;
	}



	/**
	 * Return the value associated with the column: family_history_select
	 */
	public java.lang.String getFamilyHistorySelect () {
		return familyHistorySelect;
	}

	/**
	 * Set the value related to the column: family_history_select
	 * @param familyHistorySelect the family_history_select value
	 */
	public void setFamilyHistorySelect (java.lang.String familyHistorySelect) {
		this.familyHistorySelect = familyHistorySelect;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DrugRelatedProblem)) return false;
		else {
			jkt.hms.masters.business.DrugRelatedProblem drugRelatedProblem = (jkt.hms.masters.business.DrugRelatedProblem) obj;
			if (null == this.getId() || null == drugRelatedProblem.getId()) return false;
			else return (this.getId().equals(drugRelatedProblem.getId()));
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