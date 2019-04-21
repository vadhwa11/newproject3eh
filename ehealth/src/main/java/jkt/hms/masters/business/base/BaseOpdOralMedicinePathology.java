package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_oral_medicine_pathology table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_oral_medicine_pathology"
 */

public abstract class BaseOpdOralMedicinePathology  implements Serializable {

	public static String REF = "OpdOralMedicinePathology";
	public static String PROP_SMOKELESS_DAILY_PAST = "SmokelessDailyPast";
	public static String PROP_SMOKING_VISITED_DOCTOR_FROMER = "SmokingVisitedDoctorFromer";
	public static String PROP_SMOKING_DOCTOR_ASK_FROMER = "SmokingDoctorAskFromer";
	public static String PROP_SMOKELESS_QUIT_PERIOD = "SmokelessQuitPeriod";
	public static String PROP_ORAL_EYES = "OralEyes";
	public static String PROP_SMOKING_QUIT_PERIOD = "SmokingQuitPeriod";
	public static String PROP_SMOKING_QUIT_TOBACOO_FROMER = "SmokingQuitTobacooFromer";
	public static String PROP_SMOKING_LESS_DAILY_PRODUCT = "SmokingLessDailyProduct";
	public static String PROP_SMOKELESS_LESS_DAILY_START_AGE = "SmokelessLessDailyStartAge";
	public static String PROP_SMOKING_TRY_STOP = "SmokingTryStop";
	public static String PROP_ALCOHOL_QUIT_ANY_FROMER = "AlcoholQuitAnyFromer";
	public static String PROP_SMOKING_TRY_QUITTING = "SmokingTryQuitting";
	public static String PROP_DENTITION_STATUS = "DentitionStatus";
	public static String PROP_ALCOHOL_DAILY_START_YEAR_FORMER = "AlcoholDailyStartYearFormer";
	public static String PROP_GEN_NUTRITIONAL = "GenNutritional";
	public static String PROP_GEN_NAILS = "GenNails";
	public static String PROP_SMOKING_DAILY_START_YEAR = "SmokingDailyStartYear";
	public static String PROP_GEN_DEVELOPMENTAL = "GenDevelopmental";
	public static String PROP_SMOKELESS_FREQUENCY_PAST = "SmokelessFrequencyPast";
	public static String PROP_ORAL_HYGIENE_STATUS = "OralHygieneStatus";
	public static String PROP_SMOKING_NO_VISITED_DOCTOR_FROMER = "SmokingNoVisitedDoctorFromer";
	public static String PROP_SMOKELESS_QUIT_ANY_FROMER = "SmokelessQuitAnyFromer";
	public static String PROP_ALCOHOL_STOP_YEAR_FORMER = "AlcoholStopYearFormer";
	public static String PROP_HIGH_JUGULAR = "HighJugular";
	public static String PROP_ALCOHOL_LESS_DAILY_START_AGE = "AlcoholLessDailyStartAge";
	public static String PROP_SMOKELESS_AFTER_WAKEUP = "SmokelessAfterWakeup";
	public static String PROP_ORAL_SKIN = "OralSkin";
	public static String PROP_CASE_SUMMARY = "CaseSummary";
	public static String PROP_GEN_EYES = "GenEyes";
	public static String PROP_MID_JUGULAR = "MidJugular";
	public static String PROP_SMOKING_DAILY_PAST = "SmokingDailyPast";
	public static String PROP_GEN_NOSE = "GenNose";
	public static String PROP_GEN_HAIR = "GenHair";
	public static String PROP_ORAL_NOSE = "OralNose";
	public static String PROP_SMOKELESS_NO_VISITED_DOCTOR_FROMER = "SmokelessNoVisitedDoctorFromer";
	public static String PROP_SUBMENTAL_SUBMANDIBULAR = "SubmentalSubmandibular";
	public static String PROP_SMOKING_DAILY_START_AGE = "SmokingDailyStartAge";
	public static String PROP_SMOKELESS_TRY_QUITTING = "SmokelessTryQuitting";
	public static String PROP_POSTERIOR_JUGULAR = "PosteriorJugular";
	public static String PROP_SMOKING_DAILY_START_YEAR_FORMER = "SmokingDailyStartYearFormer";
	public static String PROP_SMOKING_AFTER_WAKEUP = "SmokingAfterWakeup";
	public static String PROP_ORAL_THROAT = "OralThroat";
	public static String PROP_SMOKING_DAILY_PRODUCT = "SmokingDailyProduct";
	public static String PROP_MOUTH_OPENING = "MouthOpening";
	public static String PROP_HISTORY_PRESENTING_COMPLAINT = "HistoryPresentingComplaint";
	public static String PROP_ALCOHOL_LESS_DAILY_PRODUCT = "AlcoholLessDailyProduct";
	public static String PROP_LOW_JUGULAR = "LowJugular";
	public static String PROP_SMOKELESS_TRY_STOP = "SmokelessTryStop";
	public static String PROP_BRUSHING_HABBITS = "BrushingHabbits";
	public static String PROP_SUPERIOR_MEDIASTINAL = "SuperiorMediastinal";
	public static String PROP_ORAL_TMJ = "OralTmj";
	public static String PROP_SMOKING_DAILY_START_AGE_FORMER = "SmokingDailyStartAgeFormer";
	public static String PROP_SMOKELESS_DAILY_PRODUCT = "SmokelessDailyProduct";
	public static String PROP_SMOKELESS_CURRENTLY = "SmokelessCurrently";
	public static String PROP_ORAL_EAR = "OralEar";
	public static String PROP_ALCOHOL_DAILY_PRODUCT = "AlcoholDailyProduct";
	public static String PROP_ALCOHOL_DAILY_PAST = "AlcoholDailyPast";
	public static String PROP_PRESENTING_COMPLAINTS = "PresentingComplaints";
	public static String PROP_GEN_SKIN = "GenSkin";
	public static String PROP_CARDIOVASCULAR_SYSTEM = "CardiovascularSystem";
	public static String PROP_ALCOHOL_CURRENTLY = "AlcoholCurrently";
	public static String PROP_SMOKELESS_VISITED_DOCTOR_FROMER = "SmokelessVisitedDoctorFromer";
	public static String PROP_ALIMENTARY_SYSTEM = "AlimentarySystem";
	public static String PROP_LATERAL_BORDER = "LateralBorder";
	public static String PROP_ALCOHOL_DAILY_START_YEAR = "AlcoholDailyStartYear";
	public static String PROP_ALCOHOL_TRY_STOP = "AlcoholTryStop";
	public static String PROP_SMOKELESS_DAILY_START_AGE_FORMER = "SmokelessDailyStartAgeFormer";
	public static String PROP_ORAL_FACIAL_FORM = "OralFacialForm";
	public static String PROP_PERSONAL_SOCIAL_HISTORY = "PersonalSocialHistory";
	public static String PROP_ALCOHOL_AFTER_WAKEUP = "AlcoholAfterWakeup";
	public static String PROP_ORAL_NECK = "OralNeck";
	public static String PROP_SMOKELESS_STOP_YEAR_FORMER = "SmokelessStopYearFormer";
	public static String PROP_LOCAL_EXAMINATION_FINDINGS = "LocalExaminationFindings";
	public static String PROP_ALCOHOL_NO_VISITED_DOCTOR_FROMER = "AlcoholNoVisitedDoctorFromer";
	public static String PROP_RESPIRATORY_SYSTEM = "RespiratorySystem";
	public static String PROP_DORSUM = "Dorsum";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SMOKELESS_LESS_DAILY_PRODUCT = "SmokelessLessDailyProduct";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SMOKELESS_DOCTOR_ASK_FROMER = "SmokelessDoctorAskFromer";
	public static String PROP_GENITOURINARY_SYSTEM = "GenitourinarySystem";
	public static String PROP_ALCOHOL_QUIT_TOBACOO_FROMER = "AlcoholQuitTobacooFromer";
	public static String PROP_ALCOHOL_DAILY_START_AGE = "AlcoholDailyStartAge";
	public static String PROP_SMOKELESS_QUIT_TOBACOO_FROMER = "SmokelessQuitTobacooFromer";
	public static String PROP_CENTRAL_NERVOUS_SYSTEM = "CentralNervousSystem";
	public static String PROP_LATERAL_BORDER_DETAILS = "LateralBorderDetails";
	public static String PROP_SMOKING_LESS_DAILY_START_YEAR = "SmokingLessDailyStartYear";
	public static String PROP_SMOKELESS_DAILY_START_AGE = "SmokelessDailyStartAge";
	public static String PROP_TONGUE_INSPECTION = "TongueInspection";
	public static String PROP_SMOKING_FREQUENCY_PAST = "SmokingFrequencyPast";
	public static String PROP_GEN_SKULL = "GenSkull";
	public static String PROP_ID = "Id";
	public static String PROP_SMOKING_STOP_YEAR_FORMER = "SmokingStopYearFormer";
	public static String PROP_GEN_EARS = "GenEars";
	public static String PROP_ORAL_HEAD = "OralHead";
	public static String PROP_TRACHEO_OESOPHAGEAL = "TracheoOesophageal";
	public static String PROP_SMOKELESS_DAILY_START_YEAR_FORMER = "SmokelessDailyStartYearFormer";
	public static String PROP_ALCOHOL_TRY_STOP_USING = "AlcoholTryStopUsing";
	public static String PROP_MUSCULOSKELETAL_SYSTEM = "MusculoskeletalSystem";
	public static String PROP_ALCOHOL_QUIT_PERIOD = "AlcoholQuitPeriod";
	public static String PROP_SMOKELESS_DAILY_START_YEAR = "SmokelessDailyStartYear";
	public static String PROP_VENTRAL_SURFACE = "VentralSurface";
	public static String PROP_ORAL_SALIVARY_GLANDS_PALPABLE = "OralSalivaryGlandsPalpable";
	public static String PROP_SMOKELESS_LESS_DAILY_START_YEAR = "SmokelessLessDailyStartYear";
	public static String PROP_ORAL_HAIR = "OralHair";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ALCOHOL_VISITED_DOCTOR_FROMER = "AlcoholVisitedDoctorFromer";
	public static String PROP_PAST_MEDICAL_DENTAL_HISTORY = "PastMedicalDentalHistory";
	public static String PROP_SMOKING_CURRENTLY = "SmokingCurrently";
	public static String PROP_ALCOHOL_DAILY_START_AGE_FORMER = "AlcoholDailyStartAgeFormer";
	public static String PROP_ORAL_SALIVARY_GLANDS = "OralSalivaryGlands";
	public static String PROP_SMOKING_QUIT_ANY_FROMER = "SmokingQuitAnyFromer";
	public static String PROP_ALCOHOL_TRY_QUITTING = "AlcoholTryQuitting";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_DIETARY_HABBITS = "DietaryHabbits";
	public static String PROP_GEN_LYMPH_NODES = "GenLymphNodes";
	public static String PROP_SMOKELESS_TRY_STOP_USING = "SmokelessTryStopUsing";
	public static String PROP_ALCOHOL_LESS_DAILY_START_YEAR = "AlcoholLessDailyStartYear";
	public static String PROP_ORAL_CRANIAL_NERVES_EXAMINATION = "OralCranialNervesExamination";
	public static String PROP_SMOKING_LESS_DAILY_START_AGE = "SmokingLessDailyStartAge";
	public static String PROP_SMOKING_TRY_STOP_USING = "SmokingTryStopUsing";
	public static String PROP_ALCOHOL_DOCTOR_ASK_FROMER = "AlcoholDoctorAskFromer";
	public static String PROP_HIN = "Hin";
	public static String PROP_ALCOHOL_FREQUENCY_PAST = "AlcoholFrequencyPast";
	public static String PROP_GEN_HEAD = "GenHead";


	// constructors
	public BaseOpdOralMedicinePathology () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOralMedicinePathology (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String presentingComplaints;
	private java.lang.String historyPresentingComplaint;
	private java.lang.String pastMedicalDentalHistory;
	private java.lang.String familyHistory;
	private java.lang.String personalSocialHistory;
	private java.lang.String dietaryHabbits;
	private java.lang.String brushingHabbits;
	private java.lang.String smokingCurrently;
	private java.lang.String smokelessCurrently;
	private java.lang.String alcoholCurrently;
	private java.lang.String smokingDailyPast;
	private java.lang.String smokelessDailyPast;
	private java.lang.String alcoholDailyPast;
	private java.lang.String smokingFrequencyPast;
	private java.lang.String smokelessFrequencyPast;
	private java.lang.String alcoholFrequencyPast;
	private java.lang.Integer smokingDailyStartAge;
	private java.lang.Integer smokelessDailyStartAge;
	private java.lang.Integer alcoholDailyStartAge;
	private java.lang.Integer smokingDailyStartYear;
	private java.lang.Integer smokelessDailyStartYear;
	private java.lang.Integer alcoholDailyStartYear;
	private java.lang.Integer smokingDailyProduct;
	private java.lang.Integer smokelessDailyProduct;
	private java.lang.Integer alcoholDailyProduct;
	private java.lang.Integer smokingAfterWakeup;
	private java.lang.Integer smokelessAfterWakeup;
	private java.lang.Integer alcoholAfterWakeup;
	private java.lang.Integer smokingLessDailyStartAge;
	private java.lang.Integer smokelessLessDailyStartAge;
	private java.lang.Integer alcoholLessDailyStartAge;
	private java.lang.Integer smokingLessDailyStartYear;
	private java.lang.Integer smokelessLessDailyStartYear;
	private java.lang.Integer alcoholLessDailyStartYear;
	private java.lang.Integer smokingLessDailyProduct;
	private java.lang.Integer smokelessLessDailyProduct;
	private java.lang.Integer alcoholLessDailyProduct;
	private java.lang.Integer smokingDailyStartAgeFormer;
	private java.lang.Integer smokelessDailyStartAgeFormer;
	private java.lang.Integer alcoholDailyStartAgeFormer;
	private java.lang.Integer smokingDailyStartYearFormer;
	private java.lang.Integer smokelessDailyStartYearFormer;
	private java.lang.Integer alcoholDailyStartYearFormer;
	private java.lang.Integer smokingStopYearFormer;
	private java.lang.Integer smokelessStopYearFormer;
	private java.lang.Integer alcoholStopYearFormer;
	private java.lang.String smokingVisitedDoctorFromer;
	private java.lang.String smokelessVisitedDoctorFromer;
	private java.lang.String alcoholVisitedDoctorFromer;
	private java.lang.Integer smokingNoVisitedDoctorFromer;
	private java.lang.Integer smokelessNoVisitedDoctorFromer;
	private java.lang.Integer alcoholNoVisitedDoctorFromer;
	private java.lang.String smokingDoctorAskFromer;
	private java.lang.String smokelessDoctorAskFromer;
	private java.lang.String alcoholDoctorAskFromer;
	private java.lang.String smokingQuitTobacooFromer;
	private java.lang.String smokelessQuitTobacooFromer;
	private java.lang.String alcoholQuitTobacooFromer;
	private java.lang.String smokingQuitAnyFromer;
	private java.lang.String smokelessQuitAnyFromer;
	private java.lang.String alcoholQuitAnyFromer;
	private java.lang.String smokingTryStop;
	private java.lang.String smokelessTryStop;
	private java.lang.String alcoholTryStop;
	private java.lang.Integer smokingQuitPeriod;
	private java.lang.Integer smokelessQuitPeriod;
	private java.lang.Integer alcoholQuitPeriod;
	private java.lang.String smokingTryStopUsing;
	private java.lang.String smokelessTryStopUsing;
	private java.lang.String alcoholTryStopUsing;
	private java.lang.String smokingTryQuitting;
	private java.lang.String smokelessTryQuitting;
	private java.lang.String alcoholTryQuitting;
	private java.lang.String genDevelopmental;
	private java.lang.String genNutritional;
	private java.lang.String genHead;
	private java.lang.String genSkull;
	private java.lang.String genEyes;
	private java.lang.String genEars;
	private java.lang.String genNose;
	private java.lang.String genSkin;
	private java.lang.String genHair;
	private java.lang.String genNails;
	private java.lang.String genLymphNodes;
	private java.lang.String alimentarySystem;
	private java.lang.String respiratorySystem;
	private java.lang.String cardiovascularSystem;
	private java.lang.String centralNervousSystem;
	private java.lang.String musculoskeletalSystem;
	private java.lang.String genitourinarySystem;
	private java.lang.String oralHead;
	private java.lang.String oralFacialForm;
	private java.lang.String oralHair;
	private java.lang.String oralSkin;
	private java.lang.String oralEyes;
	private java.lang.String oralEar;
	private java.lang.String oralNose;
	private java.lang.String oralThroat;
	private java.lang.String oralSalivaryGlands;
	private java.lang.String oralSalivaryGlandsPalpable;
	private java.lang.String oralCranialNervesExamination;
	private java.lang.String oralNeck;
	private java.lang.String oralTmj;
	private java.lang.String submentalSubmandibular;
	private java.lang.String highJugular;
	private java.lang.String midJugular;
	private java.lang.String lowJugular;
	private java.lang.String posteriorJugular;
	private java.lang.String tracheoOesophageal;
	private java.lang.String superiorMediastinal;
	private java.lang.String mouthOpening;
	private java.lang.String oralHygieneStatus;
	private java.lang.String dentitionStatus;
	private java.lang.String tongueInspection;
	private java.lang.String dorsum;
	private java.lang.String ventralSurface;
	private java.lang.String lateralBorder;
	private java.lang.String lateralBorderDetails;
	private java.lang.String localExaminationFindings;
	private java.lang.String caseSummary;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="medicine_pathology_id"
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
	 * Return the value associated with the column: presenting_complaints
	 */
	public java.lang.String getPresentingComplaints () {
		return presentingComplaints;
	}

	/**
	 * Set the value related to the column: presenting_complaints
	 * @param presentingComplaints the presenting_complaints value
	 */
	public void setPresentingComplaints (java.lang.String presentingComplaints) {
		this.presentingComplaints = presentingComplaints;
	}



	/**
	 * Return the value associated with the column: history_presenting_complaint
	 */
	public java.lang.String getHistoryPresentingComplaint () {
		return historyPresentingComplaint;
	}

	/**
	 * Set the value related to the column: history_presenting_complaint
	 * @param historyPresentingComplaint the history_presenting_complaint value
	 */
	public void setHistoryPresentingComplaint (java.lang.String historyPresentingComplaint) {
		this.historyPresentingComplaint = historyPresentingComplaint;
	}



	/**
	 * Return the value associated with the column: past_medical_dental_history
	 */
	public java.lang.String getPastMedicalDentalHistory () {
		return pastMedicalDentalHistory;
	}

	/**
	 * Set the value related to the column: past_medical_dental_history
	 * @param pastMedicalDentalHistory the past_medical_dental_history value
	 */
	public void setPastMedicalDentalHistory (java.lang.String pastMedicalDentalHistory) {
		this.pastMedicalDentalHistory = pastMedicalDentalHistory;
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
	 * Return the value associated with the column: personal_social_history
	 */
	public java.lang.String getPersonalSocialHistory () {
		return personalSocialHistory;
	}

	/**
	 * Set the value related to the column: personal_social_history
	 * @param personalSocialHistory the personal_social_history value
	 */
	public void setPersonalSocialHistory (java.lang.String personalSocialHistory) {
		this.personalSocialHistory = personalSocialHistory;
	}



	/**
	 * Return the value associated with the column: dietary_habbits
	 */
	public java.lang.String getDietaryHabbits () {
		return dietaryHabbits;
	}

	/**
	 * Set the value related to the column: dietary_habbits
	 * @param dietaryHabbits the dietary_habbits value
	 */
	public void setDietaryHabbits (java.lang.String dietaryHabbits) {
		this.dietaryHabbits = dietaryHabbits;
	}



	/**
	 * Return the value associated with the column: brushing_habbits
	 */
	public java.lang.String getBrushingHabbits () {
		return brushingHabbits;
	}

	/**
	 * Set the value related to the column: brushing_habbits
	 * @param brushingHabbits the brushing_habbits value
	 */
	public void setBrushingHabbits (java.lang.String brushingHabbits) {
		this.brushingHabbits = brushingHabbits;
	}



	/**
	 * Return the value associated with the column: smoking_currently
	 */
	public java.lang.String getSmokingCurrently () {
		return smokingCurrently;
	}

	/**
	 * Set the value related to the column: smoking_currently
	 * @param smokingCurrently the smoking_currently value
	 */
	public void setSmokingCurrently (java.lang.String smokingCurrently) {
		this.smokingCurrently = smokingCurrently;
	}



	/**
	 * Return the value associated with the column: smokeless_currently
	 */
	public java.lang.String getSmokelessCurrently () {
		return smokelessCurrently;
	}

	/**
	 * Set the value related to the column: smokeless_currently
	 * @param smokelessCurrently the smokeless_currently value
	 */
	public void setSmokelessCurrently (java.lang.String smokelessCurrently) {
		this.smokelessCurrently = smokelessCurrently;
	}



	/**
	 * Return the value associated with the column: alcohol_currently
	 */
	public java.lang.String getAlcoholCurrently () {
		return alcoholCurrently;
	}

	/**
	 * Set the value related to the column: alcohol_currently
	 * @param alcoholCurrently the alcohol_currently value
	 */
	public void setAlcoholCurrently (java.lang.String alcoholCurrently) {
		this.alcoholCurrently = alcoholCurrently;
	}



	/**
	 * Return the value associated with the column: smoking_daily_past
	 */
	public java.lang.String getSmokingDailyPast () {
		return smokingDailyPast;
	}

	/**
	 * Set the value related to the column: smoking_daily_past
	 * @param smokingDailyPast the smoking_daily_past value
	 */
	public void setSmokingDailyPast (java.lang.String smokingDailyPast) {
		this.smokingDailyPast = smokingDailyPast;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_past
	 */
	public java.lang.String getSmokelessDailyPast () {
		return smokelessDailyPast;
	}

	/**
	 * Set the value related to the column: smokeless_daily_past
	 * @param smokelessDailyPast the smokeless_daily_past value
	 */
	public void setSmokelessDailyPast (java.lang.String smokelessDailyPast) {
		this.smokelessDailyPast = smokelessDailyPast;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_past
	 */
	public java.lang.String getAlcoholDailyPast () {
		return alcoholDailyPast;
	}

	/**
	 * Set the value related to the column: alcohol_daily_past
	 * @param alcoholDailyPast the alcohol_daily_past value
	 */
	public void setAlcoholDailyPast (java.lang.String alcoholDailyPast) {
		this.alcoholDailyPast = alcoholDailyPast;
	}



	/**
	 * Return the value associated with the column: smoking_frequency_past
	 */
	public java.lang.String getSmokingFrequencyPast () {
		return smokingFrequencyPast;
	}

	/**
	 * Set the value related to the column: smoking_frequency_past
	 * @param smokingFrequencyPast the smoking_frequency_past value
	 */
	public void setSmokingFrequencyPast (java.lang.String smokingFrequencyPast) {
		this.smokingFrequencyPast = smokingFrequencyPast;
	}



	/**
	 * Return the value associated with the column: smokeless_frequency_past
	 */
	public java.lang.String getSmokelessFrequencyPast () {
		return smokelessFrequencyPast;
	}

	/**
	 * Set the value related to the column: smokeless_frequency_past
	 * @param smokelessFrequencyPast the smokeless_frequency_past value
	 */
	public void setSmokelessFrequencyPast (java.lang.String smokelessFrequencyPast) {
		this.smokelessFrequencyPast = smokelessFrequencyPast;
	}



	/**
	 * Return the value associated with the column: alcohol_frequency_past
	 */
	public java.lang.String getAlcoholFrequencyPast () {
		return alcoholFrequencyPast;
	}

	/**
	 * Set the value related to the column: alcohol_frequency_past
	 * @param alcoholFrequencyPast the alcohol_frequency_past value
	 */
	public void setAlcoholFrequencyPast (java.lang.String alcoholFrequencyPast) {
		this.alcoholFrequencyPast = alcoholFrequencyPast;
	}



	/**
	 * Return the value associated with the column: smoking_daily_start_age
	 */
	public java.lang.Integer getSmokingDailyStartAge () {
		return smokingDailyStartAge;
	}

	/**
	 * Set the value related to the column: smoking_daily_start_age
	 * @param smokingDailyStartAge the smoking_daily_start_age value
	 */
	public void setSmokingDailyStartAge (java.lang.Integer smokingDailyStartAge) {
		this.smokingDailyStartAge = smokingDailyStartAge;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_start_age
	 */
	public java.lang.Integer getSmokelessDailyStartAge () {
		return smokelessDailyStartAge;
	}

	/**
	 * Set the value related to the column: smokeless_daily_start_age
	 * @param smokelessDailyStartAge the smokeless_daily_start_age value
	 */
	public void setSmokelessDailyStartAge (java.lang.Integer smokelessDailyStartAge) {
		this.smokelessDailyStartAge = smokelessDailyStartAge;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_start_age
	 */
	public java.lang.Integer getAlcoholDailyStartAge () {
		return alcoholDailyStartAge;
	}

	/**
	 * Set the value related to the column: alcohol_daily_start_age
	 * @param alcoholDailyStartAge the alcohol_daily_start_age value
	 */
	public void setAlcoholDailyStartAge (java.lang.Integer alcoholDailyStartAge) {
		this.alcoholDailyStartAge = alcoholDailyStartAge;
	}



	/**
	 * Return the value associated with the column: smoking_daily_start_year
	 */
	public java.lang.Integer getSmokingDailyStartYear () {
		return smokingDailyStartYear;
	}

	/**
	 * Set the value related to the column: smoking_daily_start_year
	 * @param smokingDailyStartYear the smoking_daily_start_year value
	 */
	public void setSmokingDailyStartYear (java.lang.Integer smokingDailyStartYear) {
		this.smokingDailyStartYear = smokingDailyStartYear;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_start_year
	 */
	public java.lang.Integer getSmokelessDailyStartYear () {
		return smokelessDailyStartYear;
	}

	/**
	 * Set the value related to the column: smokeless_daily_start_year
	 * @param smokelessDailyStartYear the smokeless_daily_start_year value
	 */
	public void setSmokelessDailyStartYear (java.lang.Integer smokelessDailyStartYear) {
		this.smokelessDailyStartYear = smokelessDailyStartYear;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_start_year
	 */
	public java.lang.Integer getAlcoholDailyStartYear () {
		return alcoholDailyStartYear;
	}

	/**
	 * Set the value related to the column: alcohol_daily_start_year
	 * @param alcoholDailyStartYear the alcohol_daily_start_year value
	 */
	public void setAlcoholDailyStartYear (java.lang.Integer alcoholDailyStartYear) {
		this.alcoholDailyStartYear = alcoholDailyStartYear;
	}



	/**
	 * Return the value associated with the column: smoking_daily_product
	 */
	public java.lang.Integer getSmokingDailyProduct () {
		return smokingDailyProduct;
	}

	/**
	 * Set the value related to the column: smoking_daily_product
	 * @param smokingDailyProduct the smoking_daily_product value
	 */
	public void setSmokingDailyProduct (java.lang.Integer smokingDailyProduct) {
		this.smokingDailyProduct = smokingDailyProduct;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_product
	 */
	public java.lang.Integer getSmokelessDailyProduct () {
		return smokelessDailyProduct;
	}

	/**
	 * Set the value related to the column: smokeless_daily_product
	 * @param smokelessDailyProduct the smokeless_daily_product value
	 */
	public void setSmokelessDailyProduct (java.lang.Integer smokelessDailyProduct) {
		this.smokelessDailyProduct = smokelessDailyProduct;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_product
	 */
	public java.lang.Integer getAlcoholDailyProduct () {
		return alcoholDailyProduct;
	}

	/**
	 * Set the value related to the column: alcohol_daily_product
	 * @param alcoholDailyProduct the alcohol_daily_product value
	 */
	public void setAlcoholDailyProduct (java.lang.Integer alcoholDailyProduct) {
		this.alcoholDailyProduct = alcoholDailyProduct;
	}



	/**
	 * Return the value associated with the column: smoking_after_wakeup
	 */
	public java.lang.Integer getSmokingAfterWakeup () {
		return smokingAfterWakeup;
	}

	/**
	 * Set the value related to the column: smoking_after_wakeup
	 * @param smokingAfterWakeup the smoking_after_wakeup value
	 */
	public void setSmokingAfterWakeup (java.lang.Integer smokingAfterWakeup) {
		this.smokingAfterWakeup = smokingAfterWakeup;
	}



	/**
	 * Return the value associated with the column: smokeless_after_wakeup
	 */
	public java.lang.Integer getSmokelessAfterWakeup () {
		return smokelessAfterWakeup;
	}

	/**
	 * Set the value related to the column: smokeless_after_wakeup
	 * @param smokelessAfterWakeup the smokeless_after_wakeup value
	 */
	public void setSmokelessAfterWakeup (java.lang.Integer smokelessAfterWakeup) {
		this.smokelessAfterWakeup = smokelessAfterWakeup;
	}



	/**
	 * Return the value associated with the column: alcohol_after_wakeup
	 */
	public java.lang.Integer getAlcoholAfterWakeup () {
		return alcoholAfterWakeup;
	}

	/**
	 * Set the value related to the column: alcohol_after_wakeup
	 * @param alcoholAfterWakeup the alcohol_after_wakeup value
	 */
	public void setAlcoholAfterWakeup (java.lang.Integer alcoholAfterWakeup) {
		this.alcoholAfterWakeup = alcoholAfterWakeup;
	}



	/**
	 * Return the value associated with the column: smoking_less_daily_start_age
	 */
	public java.lang.Integer getSmokingLessDailyStartAge () {
		return smokingLessDailyStartAge;
	}

	/**
	 * Set the value related to the column: smoking_less_daily_start_age
	 * @param smokingLessDailyStartAge the smoking_less_daily_start_age value
	 */
	public void setSmokingLessDailyStartAge (java.lang.Integer smokingLessDailyStartAge) {
		this.smokingLessDailyStartAge = smokingLessDailyStartAge;
	}



	/**
	 * Return the value associated with the column: smokeless_less_daily_start_age
	 */
	public java.lang.Integer getSmokelessLessDailyStartAge () {
		return smokelessLessDailyStartAge;
	}

	/**
	 * Set the value related to the column: smokeless_less_daily_start_age
	 * @param smokelessLessDailyStartAge the smokeless_less_daily_start_age value
	 */
	public void setSmokelessLessDailyStartAge (java.lang.Integer smokelessLessDailyStartAge) {
		this.smokelessLessDailyStartAge = smokelessLessDailyStartAge;
	}



	/**
	 * Return the value associated with the column: alcohol_less_daily_start_age
	 */
	public java.lang.Integer getAlcoholLessDailyStartAge () {
		return alcoholLessDailyStartAge;
	}

	/**
	 * Set the value related to the column: alcohol_less_daily_start_age
	 * @param alcoholLessDailyStartAge the alcohol_less_daily_start_age value
	 */
	public void setAlcoholLessDailyStartAge (java.lang.Integer alcoholLessDailyStartAge) {
		this.alcoholLessDailyStartAge = alcoholLessDailyStartAge;
	}



	/**
	 * Return the value associated with the column: smoking_less_daily_start_year
	 */
	public java.lang.Integer getSmokingLessDailyStartYear () {
		return smokingLessDailyStartYear;
	}

	/**
	 * Set the value related to the column: smoking_less_daily_start_year
	 * @param smokingLessDailyStartYear the smoking_less_daily_start_year value
	 */
	public void setSmokingLessDailyStartYear (java.lang.Integer smokingLessDailyStartYear) {
		this.smokingLessDailyStartYear = smokingLessDailyStartYear;
	}



	/**
	 * Return the value associated with the column: smokeless_less_daily_start_year
	 */
	public java.lang.Integer getSmokelessLessDailyStartYear () {
		return smokelessLessDailyStartYear;
	}

	/**
	 * Set the value related to the column: smokeless_less_daily_start_year
	 * @param smokelessLessDailyStartYear the smokeless_less_daily_start_year value
	 */
	public void setSmokelessLessDailyStartYear (java.lang.Integer smokelessLessDailyStartYear) {
		this.smokelessLessDailyStartYear = smokelessLessDailyStartYear;
	}



	/**
	 * Return the value associated with the column: alcohol_less_daily_start_year
	 */
	public java.lang.Integer getAlcoholLessDailyStartYear () {
		return alcoholLessDailyStartYear;
	}

	/**
	 * Set the value related to the column: alcohol_less_daily_start_year
	 * @param alcoholLessDailyStartYear the alcohol_less_daily_start_year value
	 */
	public void setAlcoholLessDailyStartYear (java.lang.Integer alcoholLessDailyStartYear) {
		this.alcoholLessDailyStartYear = alcoholLessDailyStartYear;
	}



	/**
	 * Return the value associated with the column: smoking_less_daily_product
	 */
	public java.lang.Integer getSmokingLessDailyProduct () {
		return smokingLessDailyProduct;
	}

	/**
	 * Set the value related to the column: smoking_less_daily_product
	 * @param smokingLessDailyProduct the smoking_less_daily_product value
	 */
	public void setSmokingLessDailyProduct (java.lang.Integer smokingLessDailyProduct) {
		this.smokingLessDailyProduct = smokingLessDailyProduct;
	}



	/**
	 * Return the value associated with the column: smokeless_less_daily_product
	 */
	public java.lang.Integer getSmokelessLessDailyProduct () {
		return smokelessLessDailyProduct;
	}

	/**
	 * Set the value related to the column: smokeless_less_daily_product
	 * @param smokelessLessDailyProduct the smokeless_less_daily_product value
	 */
	public void setSmokelessLessDailyProduct (java.lang.Integer smokelessLessDailyProduct) {
		this.smokelessLessDailyProduct = smokelessLessDailyProduct;
	}



	/**
	 * Return the value associated with the column: alcohol_less_daily_product
	 */
	public java.lang.Integer getAlcoholLessDailyProduct () {
		return alcoholLessDailyProduct;
	}

	/**
	 * Set the value related to the column: alcohol_less_daily_product
	 * @param alcoholLessDailyProduct the alcohol_less_daily_product value
	 */
	public void setAlcoholLessDailyProduct (java.lang.Integer alcoholLessDailyProduct) {
		this.alcoholLessDailyProduct = alcoholLessDailyProduct;
	}



	/**
	 * Return the value associated with the column: smoking_daily_start_age_former
	 */
	public java.lang.Integer getSmokingDailyStartAgeFormer () {
		return smokingDailyStartAgeFormer;
	}

	/**
	 * Set the value related to the column: smoking_daily_start_age_former
	 * @param smokingDailyStartAgeFormer the smoking_daily_start_age_former value
	 */
	public void setSmokingDailyStartAgeFormer (java.lang.Integer smokingDailyStartAgeFormer) {
		this.smokingDailyStartAgeFormer = smokingDailyStartAgeFormer;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_start_age_former
	 */
	public java.lang.Integer getSmokelessDailyStartAgeFormer () {
		return smokelessDailyStartAgeFormer;
	}

	/**
	 * Set the value related to the column: smokeless_daily_start_age_former
	 * @param smokelessDailyStartAgeFormer the smokeless_daily_start_age_former value
	 */
	public void setSmokelessDailyStartAgeFormer (java.lang.Integer smokelessDailyStartAgeFormer) {
		this.smokelessDailyStartAgeFormer = smokelessDailyStartAgeFormer;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_start_age_former
	 */
	public java.lang.Integer getAlcoholDailyStartAgeFormer () {
		return alcoholDailyStartAgeFormer;
	}

	/**
	 * Set the value related to the column: alcohol_daily_start_age_former
	 * @param alcoholDailyStartAgeFormer the alcohol_daily_start_age_former value
	 */
	public void setAlcoholDailyStartAgeFormer (java.lang.Integer alcoholDailyStartAgeFormer) {
		this.alcoholDailyStartAgeFormer = alcoholDailyStartAgeFormer;
	}



	/**
	 * Return the value associated with the column: smoking_daily_start_year_former
	 */
	public java.lang.Integer getSmokingDailyStartYearFormer () {
		return smokingDailyStartYearFormer;
	}

	/**
	 * Set the value related to the column: smoking_daily_start_year_former
	 * @param smokingDailyStartYearFormer the smoking_daily_start_year_former value
	 */
	public void setSmokingDailyStartYearFormer (java.lang.Integer smokingDailyStartYearFormer) {
		this.smokingDailyStartYearFormer = smokingDailyStartYearFormer;
	}



	/**
	 * Return the value associated with the column: smokeless_daily_start_year_former
	 */
	public java.lang.Integer getSmokelessDailyStartYearFormer () {
		return smokelessDailyStartYearFormer;
	}

	/**
	 * Set the value related to the column: smokeless_daily_start_year_former
	 * @param smokelessDailyStartYearFormer the smokeless_daily_start_year_former value
	 */
	public void setSmokelessDailyStartYearFormer (java.lang.Integer smokelessDailyStartYearFormer) {
		this.smokelessDailyStartYearFormer = smokelessDailyStartYearFormer;
	}



	/**
	 * Return the value associated with the column: alcohol_daily_start_year_former
	 */
	public java.lang.Integer getAlcoholDailyStartYearFormer () {
		return alcoholDailyStartYearFormer;
	}

	/**
	 * Set the value related to the column: alcohol_daily_start_year_former
	 * @param alcoholDailyStartYearFormer the alcohol_daily_start_year_former value
	 */
	public void setAlcoholDailyStartYearFormer (java.lang.Integer alcoholDailyStartYearFormer) {
		this.alcoholDailyStartYearFormer = alcoholDailyStartYearFormer;
	}



	/**
	 * Return the value associated with the column: smoking_stop_year_former
	 */
	public java.lang.Integer getSmokingStopYearFormer () {
		return smokingStopYearFormer;
	}

	/**
	 * Set the value related to the column: smoking_stop_year_former
	 * @param smokingStopYearFormer the smoking_stop_year_former value
	 */
	public void setSmokingStopYearFormer (java.lang.Integer smokingStopYearFormer) {
		this.smokingStopYearFormer = smokingStopYearFormer;
	}



	/**
	 * Return the value associated with the column: smokeless_stop_year_former
	 */
	public java.lang.Integer getSmokelessStopYearFormer () {
		return smokelessStopYearFormer;
	}

	/**
	 * Set the value related to the column: smokeless_stop_year_former
	 * @param smokelessStopYearFormer the smokeless_stop_year_former value
	 */
	public void setSmokelessStopYearFormer (java.lang.Integer smokelessStopYearFormer) {
		this.smokelessStopYearFormer = smokelessStopYearFormer;
	}



	/**
	 * Return the value associated with the column: alcohol_stop_year_former
	 */
	public java.lang.Integer getAlcoholStopYearFormer () {
		return alcoholStopYearFormer;
	}

	/**
	 * Set the value related to the column: alcohol_stop_year_former
	 * @param alcoholStopYearFormer the alcohol_stop_year_former value
	 */
	public void setAlcoholStopYearFormer (java.lang.Integer alcoholStopYearFormer) {
		this.alcoholStopYearFormer = alcoholStopYearFormer;
	}



	/**
	 * Return the value associated with the column: smoking_visited_doctor_fromer
	 */
	public java.lang.String getSmokingVisitedDoctorFromer () {
		return smokingVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: smoking_visited_doctor_fromer
	 * @param smokingVisitedDoctorFromer the smoking_visited_doctor_fromer value
	 */
	public void setSmokingVisitedDoctorFromer (java.lang.String smokingVisitedDoctorFromer) {
		this.smokingVisitedDoctorFromer = smokingVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_visited_doctor_fromer
	 */
	public java.lang.String getSmokelessVisitedDoctorFromer () {
		return smokelessVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: smokeless_visited_doctor_fromer
	 * @param smokelessVisitedDoctorFromer the smokeless_visited_doctor_fromer value
	 */
	public void setSmokelessVisitedDoctorFromer (java.lang.String smokelessVisitedDoctorFromer) {
		this.smokelessVisitedDoctorFromer = smokelessVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_visited_doctor_fromer
	 */
	public java.lang.String getAlcoholVisitedDoctorFromer () {
		return alcoholVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: alcohol_visited_doctor_fromer
	 * @param alcoholVisitedDoctorFromer the alcohol_visited_doctor_fromer value
	 */
	public void setAlcoholVisitedDoctorFromer (java.lang.String alcoholVisitedDoctorFromer) {
		this.alcoholVisitedDoctorFromer = alcoholVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: smoking_no_visited_doctor_fromer
	 */
	public java.lang.Integer getSmokingNoVisitedDoctorFromer () {
		return smokingNoVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: smoking_no_visited_doctor_fromer
	 * @param smokingNoVisitedDoctorFromer the smoking_no_visited_doctor_fromer value
	 */
	public void setSmokingNoVisitedDoctorFromer (java.lang.Integer smokingNoVisitedDoctorFromer) {
		this.smokingNoVisitedDoctorFromer = smokingNoVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_no_visited_doctor_fromer
	 */
	public java.lang.Integer getSmokelessNoVisitedDoctorFromer () {
		return smokelessNoVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: smokeless_no_visited_doctor_fromer
	 * @param smokelessNoVisitedDoctorFromer the smokeless_no_visited_doctor_fromer value
	 */
	public void setSmokelessNoVisitedDoctorFromer (java.lang.Integer smokelessNoVisitedDoctorFromer) {
		this.smokelessNoVisitedDoctorFromer = smokelessNoVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_no_visited_doctor_fromer
	 */
	public java.lang.Integer getAlcoholNoVisitedDoctorFromer () {
		return alcoholNoVisitedDoctorFromer;
	}

	/**
	 * Set the value related to the column: alcohol_no_visited_doctor_fromer
	 * @param alcoholNoVisitedDoctorFromer the alcohol_no_visited_doctor_fromer value
	 */
	public void setAlcoholNoVisitedDoctorFromer (java.lang.Integer alcoholNoVisitedDoctorFromer) {
		this.alcoholNoVisitedDoctorFromer = alcoholNoVisitedDoctorFromer;
	}



	/**
	 * Return the value associated with the column: smoking_doctor_ask_fromer
	 */
	public java.lang.String getSmokingDoctorAskFromer () {
		return smokingDoctorAskFromer;
	}

	/**
	 * Set the value related to the column: smoking_doctor_ask_fromer
	 * @param smokingDoctorAskFromer the smoking_doctor_ask_fromer value
	 */
	public void setSmokingDoctorAskFromer (java.lang.String smokingDoctorAskFromer) {
		this.smokingDoctorAskFromer = smokingDoctorAskFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_doctor_ask_fromer
	 */
	public java.lang.String getSmokelessDoctorAskFromer () {
		return smokelessDoctorAskFromer;
	}

	/**
	 * Set the value related to the column: smokeless_doctor_ask_fromer
	 * @param smokelessDoctorAskFromer the smokeless_doctor_ask_fromer value
	 */
	public void setSmokelessDoctorAskFromer (java.lang.String smokelessDoctorAskFromer) {
		this.smokelessDoctorAskFromer = smokelessDoctorAskFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_doctor_ask_fromer
	 */
	public java.lang.String getAlcoholDoctorAskFromer () {
		return alcoholDoctorAskFromer;
	}

	/**
	 * Set the value related to the column: alcohol_doctor_ask_fromer
	 * @param alcoholDoctorAskFromer the alcohol_doctor_ask_fromer value
	 */
	public void setAlcoholDoctorAskFromer (java.lang.String alcoholDoctorAskFromer) {
		this.alcoholDoctorAskFromer = alcoholDoctorAskFromer;
	}



	/**
	 * Return the value associated with the column: smoking_quit_tobacoo_fromer
	 */
	public java.lang.String getSmokingQuitTobacooFromer () {
		return smokingQuitTobacooFromer;
	}

	/**
	 * Set the value related to the column: smoking_quit_tobacoo_fromer
	 * @param smokingQuitTobacooFromer the smoking_quit_tobacoo_fromer value
	 */
	public void setSmokingQuitTobacooFromer (java.lang.String smokingQuitTobacooFromer) {
		this.smokingQuitTobacooFromer = smokingQuitTobacooFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_quit_tobacoo_fromer
	 */
	public java.lang.String getSmokelessQuitTobacooFromer () {
		return smokelessQuitTobacooFromer;
	}

	/**
	 * Set the value related to the column: smokeless_quit_tobacoo_fromer
	 * @param smokelessQuitTobacooFromer the smokeless_quit_tobacoo_fromer value
	 */
	public void setSmokelessQuitTobacooFromer (java.lang.String smokelessQuitTobacooFromer) {
		this.smokelessQuitTobacooFromer = smokelessQuitTobacooFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_quit_tobacoo_fromer
	 */
	public java.lang.String getAlcoholQuitTobacooFromer () {
		return alcoholQuitTobacooFromer;
	}

	/**
	 * Set the value related to the column: alcohol_quit_tobacoo_fromer
	 * @param alcoholQuitTobacooFromer the alcohol_quit_tobacoo_fromer value
	 */
	public void setAlcoholQuitTobacooFromer (java.lang.String alcoholQuitTobacooFromer) {
		this.alcoholQuitTobacooFromer = alcoholQuitTobacooFromer;
	}



	/**
	 * Return the value associated with the column: smoking_quit_any_fromer
	 */
	public java.lang.String getSmokingQuitAnyFromer () {
		return smokingQuitAnyFromer;
	}

	/**
	 * Set the value related to the column: smoking_quit_any_fromer
	 * @param smokingQuitAnyFromer the smoking_quit_any_fromer value
	 */
	public void setSmokingQuitAnyFromer (java.lang.String smokingQuitAnyFromer) {
		this.smokingQuitAnyFromer = smokingQuitAnyFromer;
	}



	/**
	 * Return the value associated with the column: smokeless_quit_any_fromer
	 */
	public java.lang.String getSmokelessQuitAnyFromer () {
		return smokelessQuitAnyFromer;
	}

	/**
	 * Set the value related to the column: smokeless_quit_any_fromer
	 * @param smokelessQuitAnyFromer the smokeless_quit_any_fromer value
	 */
	public void setSmokelessQuitAnyFromer (java.lang.String smokelessQuitAnyFromer) {
		this.smokelessQuitAnyFromer = smokelessQuitAnyFromer;
	}



	/**
	 * Return the value associated with the column: alcohol_quit_any_fromer
	 */
	public java.lang.String getAlcoholQuitAnyFromer () {
		return alcoholQuitAnyFromer;
	}

	/**
	 * Set the value related to the column: alcohol_quit_any_fromer
	 * @param alcoholQuitAnyFromer the alcohol_quit_any_fromer value
	 */
	public void setAlcoholQuitAnyFromer (java.lang.String alcoholQuitAnyFromer) {
		this.alcoholQuitAnyFromer = alcoholQuitAnyFromer;
	}



	/**
	 * Return the value associated with the column: smoking_try_stop
	 */
	public java.lang.String getSmokingTryStop () {
		return smokingTryStop;
	}

	/**
	 * Set the value related to the column: smoking_try_stop
	 * @param smokingTryStop the smoking_try_stop value
	 */
	public void setSmokingTryStop (java.lang.String smokingTryStop) {
		this.smokingTryStop = smokingTryStop;
	}



	/**
	 * Return the value associated with the column: smokeless_try_stop
	 */
	public java.lang.String getSmokelessTryStop () {
		return smokelessTryStop;
	}

	/**
	 * Set the value related to the column: smokeless_try_stop
	 * @param smokelessTryStop the smokeless_try_stop value
	 */
	public void setSmokelessTryStop (java.lang.String smokelessTryStop) {
		this.smokelessTryStop = smokelessTryStop;
	}



	/**
	 * Return the value associated with the column: alcohol_try_stop
	 */
	public java.lang.String getAlcoholTryStop () {
		return alcoholTryStop;
	}

	/**
	 * Set the value related to the column: alcohol_try_stop
	 * @param alcoholTryStop the alcohol_try_stop value
	 */
	public void setAlcoholTryStop (java.lang.String alcoholTryStop) {
		this.alcoholTryStop = alcoholTryStop;
	}



	/**
	 * Return the value associated with the column: smoking_quit_period
	 */
	public java.lang.Integer getSmokingQuitPeriod () {
		return smokingQuitPeriod;
	}

	/**
	 * Set the value related to the column: smoking_quit_period
	 * @param smokingQuitPeriod the smoking_quit_period value
	 */
	public void setSmokingQuitPeriod (java.lang.Integer smokingQuitPeriod) {
		this.smokingQuitPeriod = smokingQuitPeriod;
	}



	/**
	 * Return the value associated with the column: smokeless_quit_period
	 */
	public java.lang.Integer getSmokelessQuitPeriod () {
		return smokelessQuitPeriod;
	}

	/**
	 * Set the value related to the column: smokeless_quit_period
	 * @param smokelessQuitPeriod the smokeless_quit_period value
	 */
	public void setSmokelessQuitPeriod (java.lang.Integer smokelessQuitPeriod) {
		this.smokelessQuitPeriod = smokelessQuitPeriod;
	}



	/**
	 * Return the value associated with the column: alcohol_quit_period
	 */
	public java.lang.Integer getAlcoholQuitPeriod () {
		return alcoholQuitPeriod;
	}

	/**
	 * Set the value related to the column: alcohol_quit_period
	 * @param alcoholQuitPeriod the alcohol_quit_period value
	 */
	public void setAlcoholQuitPeriod (java.lang.Integer alcoholQuitPeriod) {
		this.alcoholQuitPeriod = alcoholQuitPeriod;
	}



	/**
	 * Return the value associated with the column: smoking_try_stop_using
	 */
	public java.lang.String getSmokingTryStopUsing () {
		return smokingTryStopUsing;
	}

	/**
	 * Set the value related to the column: smoking_try_stop_using
	 * @param smokingTryStopUsing the smoking_try_stop_using value
	 */
	public void setSmokingTryStopUsing (java.lang.String smokingTryStopUsing) {
		this.smokingTryStopUsing = smokingTryStopUsing;
	}



	/**
	 * Return the value associated with the column: smokeless_try_stop_using
	 */
	public java.lang.String getSmokelessTryStopUsing () {
		return smokelessTryStopUsing;
	}

	/**
	 * Set the value related to the column: smokeless_try_stop_using
	 * @param smokelessTryStopUsing the smokeless_try_stop_using value
	 */
	public void setSmokelessTryStopUsing (java.lang.String smokelessTryStopUsing) {
		this.smokelessTryStopUsing = smokelessTryStopUsing;
	}



	/**
	 * Return the value associated with the column: alcohol_try_stop_using
	 */
	public java.lang.String getAlcoholTryStopUsing () {
		return alcoholTryStopUsing;
	}

	/**
	 * Set the value related to the column: alcohol_try_stop_using
	 * @param alcoholTryStopUsing the alcohol_try_stop_using value
	 */
	public void setAlcoholTryStopUsing (java.lang.String alcoholTryStopUsing) {
		this.alcoholTryStopUsing = alcoholTryStopUsing;
	}



	/**
	 * Return the value associated with the column: smoking_try_quitting
	 */
	public java.lang.String getSmokingTryQuitting () {
		return smokingTryQuitting;
	}

	/**
	 * Set the value related to the column: smoking_try_quitting
	 * @param smokingTryQuitting the smoking_try_quitting value
	 */
	public void setSmokingTryQuitting (java.lang.String smokingTryQuitting) {
		this.smokingTryQuitting = smokingTryQuitting;
	}



	/**
	 * Return the value associated with the column: smokeless_try_quitting
	 */
	public java.lang.String getSmokelessTryQuitting () {
		return smokelessTryQuitting;
	}

	/**
	 * Set the value related to the column: smokeless_try_quitting
	 * @param smokelessTryQuitting the smokeless_try_quitting value
	 */
	public void setSmokelessTryQuitting (java.lang.String smokelessTryQuitting) {
		this.smokelessTryQuitting = smokelessTryQuitting;
	}



	/**
	 * Return the value associated with the column: alcohol_try_quitting
	 */
	public java.lang.String getAlcoholTryQuitting () {
		return alcoholTryQuitting;
	}

	/**
	 * Set the value related to the column: alcohol_try_quitting
	 * @param alcoholTryQuitting the alcohol_try_quitting value
	 */
	public void setAlcoholTryQuitting (java.lang.String alcoholTryQuitting) {
		this.alcoholTryQuitting = alcoholTryQuitting;
	}



	/**
	 * Return the value associated with the column: gen_developmental
	 */
	public java.lang.String getGenDevelopmental () {
		return genDevelopmental;
	}

	/**
	 * Set the value related to the column: gen_developmental
	 * @param genDevelopmental the gen_developmental value
	 */
	public void setGenDevelopmental (java.lang.String genDevelopmental) {
		this.genDevelopmental = genDevelopmental;
	}



	/**
	 * Return the value associated with the column: gen_nutritional
	 */
	public java.lang.String getGenNutritional () {
		return genNutritional;
	}

	/**
	 * Set the value related to the column: gen_nutritional
	 * @param genNutritional the gen_nutritional value
	 */
	public void setGenNutritional (java.lang.String genNutritional) {
		this.genNutritional = genNutritional;
	}



	/**
	 * Return the value associated with the column: gen_head
	 */
	public java.lang.String getGenHead () {
		return genHead;
	}

	/**
	 * Set the value related to the column: gen_head
	 * @param genHead the gen_head value
	 */
	public void setGenHead (java.lang.String genHead) {
		this.genHead = genHead;
	}



	/**
	 * Return the value associated with the column: gen_skull
	 */
	public java.lang.String getGenSkull () {
		return genSkull;
	}

	/**
	 * Set the value related to the column: gen_skull
	 * @param genSkull the gen_skull value
	 */
	public void setGenSkull (java.lang.String genSkull) {
		this.genSkull = genSkull;
	}



	/**
	 * Return the value associated with the column: gen_eyes
	 */
	public java.lang.String getGenEyes () {
		return genEyes;
	}

	/**
	 * Set the value related to the column: gen_eyes
	 * @param genEyes the gen_eyes value
	 */
	public void setGenEyes (java.lang.String genEyes) {
		this.genEyes = genEyes;
	}



	/**
	 * Return the value associated with the column: gen_ears
	 */
	public java.lang.String getGenEars () {
		return genEars;
	}

	/**
	 * Set the value related to the column: gen_ears
	 * @param genEars the gen_ears value
	 */
	public void setGenEars (java.lang.String genEars) {
		this.genEars = genEars;
	}



	/**
	 * Return the value associated with the column: gen_nose
	 */
	public java.lang.String getGenNose () {
		return genNose;
	}

	/**
	 * Set the value related to the column: gen_nose
	 * @param genNose the gen_nose value
	 */
	public void setGenNose (java.lang.String genNose) {
		this.genNose = genNose;
	}



	/**
	 * Return the value associated with the column: gen_skin
	 */
	public java.lang.String getGenSkin () {
		return genSkin;
	}

	/**
	 * Set the value related to the column: gen_skin
	 * @param genSkin the gen_skin value
	 */
	public void setGenSkin (java.lang.String genSkin) {
		this.genSkin = genSkin;
	}



	/**
	 * Return the value associated with the column: gen_hair
	 */
	public java.lang.String getGenHair () {
		return genHair;
	}

	/**
	 * Set the value related to the column: gen_hair
	 * @param genHair the gen_hair value
	 */
	public void setGenHair (java.lang.String genHair) {
		this.genHair = genHair;
	}



	/**
	 * Return the value associated with the column: gen_nails
	 */
	public java.lang.String getGenNails () {
		return genNails;
	}

	/**
	 * Set the value related to the column: gen_nails
	 * @param genNails the gen_nails value
	 */
	public void setGenNails (java.lang.String genNails) {
		this.genNails = genNails;
	}



	/**
	 * Return the value associated with the column: gen_lymph_nodes
	 */
	public java.lang.String getGenLymphNodes () {
		return genLymphNodes;
	}

	/**
	 * Set the value related to the column: gen_lymph_nodes
	 * @param genLymphNodes the gen_lymph_nodes value
	 */
	public void setGenLymphNodes (java.lang.String genLymphNodes) {
		this.genLymphNodes = genLymphNodes;
	}



	/**
	 * Return the value associated with the column: alimentary_system
	 */
	public java.lang.String getAlimentarySystem () {
		return alimentarySystem;
	}

	/**
	 * Set the value related to the column: alimentary_system
	 * @param alimentarySystem the alimentary_system value
	 */
	public void setAlimentarySystem (java.lang.String alimentarySystem) {
		this.alimentarySystem = alimentarySystem;
	}



	/**
	 * Return the value associated with the column: respiratory_system
	 */
	public java.lang.String getRespiratorySystem () {
		return respiratorySystem;
	}

	/**
	 * Set the value related to the column: respiratory_system
	 * @param respiratorySystem the respiratory_system value
	 */
	public void setRespiratorySystem (java.lang.String respiratorySystem) {
		this.respiratorySystem = respiratorySystem;
	}



	/**
	 * Return the value associated with the column: cardiovascular_system
	 */
	public java.lang.String getCardiovascularSystem () {
		return cardiovascularSystem;
	}

	/**
	 * Set the value related to the column: cardiovascular_system
	 * @param cardiovascularSystem the cardiovascular_system value
	 */
	public void setCardiovascularSystem (java.lang.String cardiovascularSystem) {
		this.cardiovascularSystem = cardiovascularSystem;
	}



	/**
	 * Return the value associated with the column: central_nervous_system
	 */
	public java.lang.String getCentralNervousSystem () {
		return centralNervousSystem;
	}

	/**
	 * Set the value related to the column: central_nervous_system
	 * @param centralNervousSystem the central_nervous_system value
	 */
	public void setCentralNervousSystem (java.lang.String centralNervousSystem) {
		this.centralNervousSystem = centralNervousSystem;
	}



	/**
	 * Return the value associated with the column: musculoskeletal_system
	 */
	public java.lang.String getMusculoskeletalSystem () {
		return musculoskeletalSystem;
	}

	/**
	 * Set the value related to the column: musculoskeletal_system
	 * @param musculoskeletalSystem the musculoskeletal_system value
	 */
	public void setMusculoskeletalSystem (java.lang.String musculoskeletalSystem) {
		this.musculoskeletalSystem = musculoskeletalSystem;
	}



	/**
	 * Return the value associated with the column: genitourinary_system
	 */
	public java.lang.String getGenitourinarySystem () {
		return genitourinarySystem;
	}

	/**
	 * Set the value related to the column: genitourinary_system
	 * @param genitourinarySystem the genitourinary_system value
	 */
	public void setGenitourinarySystem (java.lang.String genitourinarySystem) {
		this.genitourinarySystem = genitourinarySystem;
	}



	/**
	 * Return the value associated with the column: oral_head
	 */
	public java.lang.String getOralHead () {
		return oralHead;
	}

	/**
	 * Set the value related to the column: oral_head
	 * @param oralHead the oral_head value
	 */
	public void setOralHead (java.lang.String oralHead) {
		this.oralHead = oralHead;
	}



	/**
	 * Return the value associated with the column: oral_facial_form
	 */
	public java.lang.String getOralFacialForm () {
		return oralFacialForm;
	}

	/**
	 * Set the value related to the column: oral_facial_form
	 * @param oralFacialForm the oral_facial_form value
	 */
	public void setOralFacialForm (java.lang.String oralFacialForm) {
		this.oralFacialForm = oralFacialForm;
	}



	/**
	 * Return the value associated with the column: oral_hair
	 */
	public java.lang.String getOralHair () {
		return oralHair;
	}

	/**
	 * Set the value related to the column: oral_hair
	 * @param oralHair the oral_hair value
	 */
	public void setOralHair (java.lang.String oralHair) {
		this.oralHair = oralHair;
	}



	/**
	 * Return the value associated with the column: oral_skin
	 */
	public java.lang.String getOralSkin () {
		return oralSkin;
	}

	/**
	 * Set the value related to the column: oral_skin
	 * @param oralSkin the oral_skin value
	 */
	public void setOralSkin (java.lang.String oralSkin) {
		this.oralSkin = oralSkin;
	}



	/**
	 * Return the value associated with the column: oral_eyes
	 */
	public java.lang.String getOralEyes () {
		return oralEyes;
	}

	/**
	 * Set the value related to the column: oral_eyes
	 * @param oralEyes the oral_eyes value
	 */
	public void setOralEyes (java.lang.String oralEyes) {
		this.oralEyes = oralEyes;
	}



	/**
	 * Return the value associated with the column: oral_ear
	 */
	public java.lang.String getOralEar () {
		return oralEar;
	}

	/**
	 * Set the value related to the column: oral_ear
	 * @param oralEar the oral_ear value
	 */
	public void setOralEar (java.lang.String oralEar) {
		this.oralEar = oralEar;
	}



	/**
	 * Return the value associated with the column: oral_nose
	 */
	public java.lang.String getOralNose () {
		return oralNose;
	}

	/**
	 * Set the value related to the column: oral_nose
	 * @param oralNose the oral_nose value
	 */
	public void setOralNose (java.lang.String oralNose) {
		this.oralNose = oralNose;
	}



	/**
	 * Return the value associated with the column: oral_throat
	 */
	public java.lang.String getOralThroat () {
		return oralThroat;
	}

	/**
	 * Set the value related to the column: oral_throat
	 * @param oralThroat the oral_throat value
	 */
	public void setOralThroat (java.lang.String oralThroat) {
		this.oralThroat = oralThroat;
	}



	/**
	 * Return the value associated with the column: oral_salivary_glands
	 */
	public java.lang.String getOralSalivaryGlands () {
		return oralSalivaryGlands;
	}

	/**
	 * Set the value related to the column: oral_salivary_glands
	 * @param oralSalivaryGlands the oral_salivary_glands value
	 */
	public void setOralSalivaryGlands (java.lang.String oralSalivaryGlands) {
		this.oralSalivaryGlands = oralSalivaryGlands;
	}



	/**
	 * Return the value associated with the column: oral_salivary_glands_palpable
	 */
	public java.lang.String getOralSalivaryGlandsPalpable () {
		return oralSalivaryGlandsPalpable;
	}

	/**
	 * Set the value related to the column: oral_salivary_glands_palpable
	 * @param oralSalivaryGlandsPalpable the oral_salivary_glands_palpable value
	 */
	public void setOralSalivaryGlandsPalpable (java.lang.String oralSalivaryGlandsPalpable) {
		this.oralSalivaryGlandsPalpable = oralSalivaryGlandsPalpable;
	}



	/**
	 * Return the value associated with the column: oral_cranial_nerves_examination
	 */
	public java.lang.String getOralCranialNervesExamination () {
		return oralCranialNervesExamination;
	}

	/**
	 * Set the value related to the column: oral_cranial_nerves_examination
	 * @param oralCranialNervesExamination the oral_cranial_nerves_examination value
	 */
	public void setOralCranialNervesExamination (java.lang.String oralCranialNervesExamination) {
		this.oralCranialNervesExamination = oralCranialNervesExamination;
	}



	/**
	 * Return the value associated with the column: oral_neck
	 */
	public java.lang.String getOralNeck () {
		return oralNeck;
	}

	/**
	 * Set the value related to the column: oral_neck
	 * @param oralNeck the oral_neck value
	 */
	public void setOralNeck (java.lang.String oralNeck) {
		this.oralNeck = oralNeck;
	}



	/**
	 * Return the value associated with the column: oral_tmj
	 */
	public java.lang.String getOralTmj () {
		return oralTmj;
	}

	/**
	 * Set the value related to the column: oral_tmj
	 * @param oralTmj the oral_tmj value
	 */
	public void setOralTmj (java.lang.String oralTmj) {
		this.oralTmj = oralTmj;
	}



	/**
	 * Return the value associated with the column: submental_submandibular
	 */
	public java.lang.String getSubmentalSubmandibular () {
		return submentalSubmandibular;
	}

	/**
	 * Set the value related to the column: submental_submandibular
	 * @param submentalSubmandibular the submental_submandibular value
	 */
	public void setSubmentalSubmandibular (java.lang.String submentalSubmandibular) {
		this.submentalSubmandibular = submentalSubmandibular;
	}



	/**
	 * Return the value associated with the column: high_jugular
	 */
	public java.lang.String getHighJugular () {
		return highJugular;
	}

	/**
	 * Set the value related to the column: high_jugular
	 * @param highJugular the high_jugular value
	 */
	public void setHighJugular (java.lang.String highJugular) {
		this.highJugular = highJugular;
	}



	/**
	 * Return the value associated with the column: mid_jugular
	 */
	public java.lang.String getMidJugular () {
		return midJugular;
	}

	/**
	 * Set the value related to the column: mid_jugular
	 * @param midJugular the mid_jugular value
	 */
	public void setMidJugular (java.lang.String midJugular) {
		this.midJugular = midJugular;
	}



	/**
	 * Return the value associated with the column: low_jugular
	 */
	public java.lang.String getLowJugular () {
		return lowJugular;
	}

	/**
	 * Set the value related to the column: low_jugular
	 * @param lowJugular the low_jugular value
	 */
	public void setLowJugular (java.lang.String lowJugular) {
		this.lowJugular = lowJugular;
	}



	/**
	 * Return the value associated with the column: posterior_jugular
	 */
	public java.lang.String getPosteriorJugular () {
		return posteriorJugular;
	}

	/**
	 * Set the value related to the column: posterior_jugular
	 * @param posteriorJugular the posterior_jugular value
	 */
	public void setPosteriorJugular (java.lang.String posteriorJugular) {
		this.posteriorJugular = posteriorJugular;
	}



	/**
	 * Return the value associated with the column: tracheo_oesophageal
	 */
	public java.lang.String getTracheoOesophageal () {
		return tracheoOesophageal;
	}

	/**
	 * Set the value related to the column: tracheo_oesophageal
	 * @param tracheoOesophageal the tracheo_oesophageal value
	 */
	public void setTracheoOesophageal (java.lang.String tracheoOesophageal) {
		this.tracheoOesophageal = tracheoOesophageal;
	}



	/**
	 * Return the value associated with the column: superior_mediastinal
	 */
	public java.lang.String getSuperiorMediastinal () {
		return superiorMediastinal;
	}

	/**
	 * Set the value related to the column: superior_mediastinal
	 * @param superiorMediastinal the superior_mediastinal value
	 */
	public void setSuperiorMediastinal (java.lang.String superiorMediastinal) {
		this.superiorMediastinal = superiorMediastinal;
	}



	/**
	 * Return the value associated with the column: mouth_opening
	 */
	public java.lang.String getMouthOpening () {
		return mouthOpening;
	}

	/**
	 * Set the value related to the column: mouth_opening
	 * @param mouthOpening the mouth_opening value
	 */
	public void setMouthOpening (java.lang.String mouthOpening) {
		this.mouthOpening = mouthOpening;
	}



	/**
	 * Return the value associated with the column: oral_hygiene_status
	 */
	public java.lang.String getOralHygieneStatus () {
		return oralHygieneStatus;
	}

	/**
	 * Set the value related to the column: oral_hygiene_status
	 * @param oralHygieneStatus the oral_hygiene_status value
	 */
	public void setOralHygieneStatus (java.lang.String oralHygieneStatus) {
		this.oralHygieneStatus = oralHygieneStatus;
	}



	/**
	 * Return the value associated with the column: dentition_status
	 */
	public java.lang.String getDentitionStatus () {
		return dentitionStatus;
	}

	/**
	 * Set the value related to the column: dentition_status
	 * @param dentitionStatus the dentition_status value
	 */
	public void setDentitionStatus (java.lang.String dentitionStatus) {
		this.dentitionStatus = dentitionStatus;
	}



	/**
	 * Return the value associated with the column: tongue_inspection
	 */
	public java.lang.String getTongueInspection () {
		return tongueInspection;
	}

	/**
	 * Set the value related to the column: tongue_inspection
	 * @param tongueInspection the tongue_inspection value
	 */
	public void setTongueInspection (java.lang.String tongueInspection) {
		this.tongueInspection = tongueInspection;
	}



	/**
	 * Return the value associated with the column: dorsum
	 */
	public java.lang.String getDorsum () {
		return dorsum;
	}

	/**
	 * Set the value related to the column: dorsum
	 * @param dorsum the dorsum value
	 */
	public void setDorsum (java.lang.String dorsum) {
		this.dorsum = dorsum;
	}



	/**
	 * Return the value associated with the column: ventral_surface
	 */
	public java.lang.String getVentralSurface () {
		return ventralSurface;
	}

	/**
	 * Set the value related to the column: ventral_surface
	 * @param ventralSurface the ventral_surface value
	 */
	public void setVentralSurface (java.lang.String ventralSurface) {
		this.ventralSurface = ventralSurface;
	}



	/**
	 * Return the value associated with the column: lateral_border
	 */
	public java.lang.String getLateralBorder () {
		return lateralBorder;
	}

	/**
	 * Set the value related to the column: lateral_border
	 * @param lateralBorder the lateral_border value
	 */
	public void setLateralBorder (java.lang.String lateralBorder) {
		this.lateralBorder = lateralBorder;
	}



	/**
	 * Return the value associated with the column: lateral_border_details
	 */
	public java.lang.String getLateralBorderDetails () {
		return lateralBorderDetails;
	}

	/**
	 * Set the value related to the column: lateral_border_details
	 * @param lateralBorderDetails the lateral_border_details value
	 */
	public void setLateralBorderDetails (java.lang.String lateralBorderDetails) {
		this.lateralBorderDetails = lateralBorderDetails;
	}



	/**
	 * Return the value associated with the column: local_examination_findings
	 */
	public java.lang.String getLocalExaminationFindings () {
		return localExaminationFindings;
	}

	/**
	 * Set the value related to the column: local_examination_findings
	 * @param localExaminationFindings the local_examination_findings value
	 */
	public void setLocalExaminationFindings (java.lang.String localExaminationFindings) {
		this.localExaminationFindings = localExaminationFindings;
	}



	/**
	 * Return the value associated with the column: case_summary
	 */
	public java.lang.String getCaseSummary () {
		return caseSummary;
	}

	/**
	 * Set the value related to the column: case_summary
	 * @param caseSummary the case_summary value
	 */
	public void setCaseSummary (java.lang.String caseSummary) {
		this.caseSummary = caseSummary;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdOralMedicinePathology)) return false;
		else {
			jkt.hms.masters.business.OpdOralMedicinePathology opdOralMedicinePathology = (jkt.hms.masters.business.OpdOralMedicinePathology) obj;
			if (null == this.getId() || null == opdOralMedicinePathology.getId()) return false;
			else return (this.getId().equals(opdOralMedicinePathology.getId()));
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