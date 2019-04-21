package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_community_oral_health_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_community_oral_health_header"
 */

public abstract class BaseOpdCommunityOralHealthHeader  implements Serializable {

	public static String REF = "OpdCommunityOralHealthHeader";
	public static String PROP_PROMPT_TREATMENT = "PromptTreatment";
	public static String PROP_PREVENTIVE = "Preventive";
	public static String PROP_FRACTURED_NON_VITALTOOTH = "FracturedNonVitaltooth";
	public static String PROP_DISABILITY_LIMITATIONS = "DisabilityLimitations";
	public static String PROP_FILLED_TEETH = "FilledTeeth";
	public static String PROP_DENTAL_DEPOSITS = "DentalDeposits";
	public static String PROP_GAIT = "Gait";
	public static String PROP_HABITS_RELATED = "HabitsRelated";
	public static String PROP_MALOCCLUSION = "Malocclusion";
	public static String PROP_ALCOHOLIC_DURATION = "AlcoholicDuration";
	public static String PROP_ENAMEL_HYPOLASIA = "EnamelHypolasia";
	public static String PROP_CLEANING_BRUSHING_ONCE = "CleaningBrushingOnce";
	public static String PROP_BUCCAL_MUCOSA = "BuccalMucosa";
	public static String PROP_ORAL_MOUTH_RINSE = "OralMouthRinse";
	public static String PROP_DIETARY = "Dietary";
	public static String PROP_WASTING_DISEASE = "WastingDisease";
	public static String PROP_MATERIALS_CHARCOAL = "MaterialsCharcoal";
	public static String PROP_ALCOHOLIC_FREQUENCY = "AlcoholicFrequency";
	public static String PROP_SMOKING_FREQUENCY = "SmokingFrequency";
	public static String PROP_GINGIVITIS = "Gingivitis";
	public static String PROP_SNUFF_DURATION_VALUE = "SnuffDurationValue";
	public static String PROP_GUTKA_DURATION = "GutkaDuration";
	public static String PROP_PERIODONTAL_POCKET = "PeriodontalPocket";
	public static String PROP_CLEANING_BRUSHING_THRICE = "CleaningBrushingThrice";
	public static String PROP_SMOKING_NUMBER = "SmokingNumber";
	public static String PROP_ALCOHOLIC_DURATION_VALUE = "AlcoholicDurationValue";
	public static String PROP_TOBACO_CHEWING_FREQUENCY = "TobacoChewingFrequency";
	public static String PROP_SNUFF_NUMBER = "SnuffNumber";
	public static String PROP_FLOSSING_INTER = "FlossingInter";
	public static String PROP_TEETH_ABSENT_REASONLOSS = "TeethAbsentReasonloss";
	public static String PROP_TEMPOROMANDIBULAR_JOINT = "TemporomandibularJoint";
	public static String PROP_PROMOTIVE = "Promotive";
	public static String PROP_BETEL_NUT_CHEWING_DURATION = "BetelNutChewingDuration";
	public static String PROP_SNUFF_FREQUENCY = "SnuffFrequency";
	public static String PROP_MEDICAL_HISTORY_VALUE = "MedicalHistoryValue";
	public static String PROP_BETEL_NUT_CHEWING_NUMBER = "BetelNutChewingNumber";
	public static String PROP_WATER_SOURCE = "WaterSource";
	public static String PROP_OCCUPATION = "Occupation";
	public static String PROP_LYMPH_NODES = "LymphNodes";
	public static String PROP_TYPE_OF_DEFINITION = "TypeOfDefinition";
	public static String PROP_GUTKA_NUMBER = "GutkaNumber";
	public static String PROP_DENTAL_HISTORY = "DentalHistory";
	public static String PROP_MATERIALS_POWDER = "MaterialsPowder";
	public static String PROP_DRUGS_FREQUENCY = "DrugsFrequency";
	public static String PROP_PAN_CHEWING_DURATION_VALUE = "PanChewingDurationValue";
	public static String PROP_REHABILITATION = "Rehabilitation";
	public static String PROP_LABICAL_MUCOSA = "LabicalMucosa";
	public static String PROP_GINGIVA = "Gingiva";
	public static String PROP_SNUFF_DURATION = "SnuffDuration";
	public static String PROP_GUTKA_DURATION_VALUE = "GutkaDurationValue";
	public static String PROP_TYPE_OF_CLEANING_ANY_OTHER = "TypeOfCleaningAnyOther";
	public static String PROP_MAINTENANCE = "Maintenance";
	public static String PROP_DRUGS_DURATION_VALUE = "DrugsDurationValue";
	public static String PROP_CONTINUOUS_RESIDENCE = "ContinuousResidence";
	public static String PROP_TYPE_OF_CLEANING_FINGER = "TypeOfCleaningFinger";
	public static String PROP_TYPE_OF_CLEANING_STICK = "TypeOfCleaningStick";
	public static String PROP_HISTORY_OF_PESENT_ILLNESS = "HistoryOfPesentIllness";
	public static String PROP_BETEL_NUT_CHEWING_FREQUENCY = "BetelNutChewingFrequency";
	public static String PROP_NUMBER_OF_TEETH_PRESENT = "NumberOfTeethPresent";
	public static String PROP_SOCIO_ECONOMIC_STATUS = "SocioEconomicStatus";
	public static String PROP_DENTAL_CARIES = "DentalCaries";
	public static String PROP_HEALTH_PROMOTION = "HealthPromotion";
	public static String PROP_METHOD_OF_CLEANING_HORIZONTAL = "MethodOfCleaningHorizontal";
	public static String PROP_BUILT = "Built";
	public static String PROP_STAINS = "Stains";
	public static String PROP_EMERGENCY = "Emergency";
	public static String PROP_MATERIALS_TOOTH_PASTE = "MaterialsToothPaste";
	public static String PROP_LIP = "Lip";
	public static String PROP_ANY_PROSTHESIS = "AnyProsthesis";
	public static String PROP_SYMMETRY_OF_FACE = "SymmetryOfFace";
	public static String PROP_TYPE_OF_CLEANING_BRUSH = "TypeOfCleaningBrush";
	public static String PROP_DRUGS_NUMBER = "DrugsNumber";
	public static String PROP_TOBACO_CHEWING_NUMBER = "TobacoChewingNumber";
	public static String PROP_NOURISHMENT = "Nourishment";
	public static String PROP_HABITS_RELATED_VALUE = "HabitsRelatedValue";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_OCCLUSAL_TRAUMATISM = "OcclusalTraumatism";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SMOKING_DURATION_VALUE = "SmokingDurationValue";
	public static String PROP_METHOD_OF_CLEANING_CIRCULAR = "MethodOfCleaningCircular";
	public static String PROP_METHOD_OF_CLEANING_VERTICAL = "MethodOfCleaningVertical";
	public static String PROP_PER_CAPITA_INCOME = "PerCapitaIncome";
	public static String PROP_MOBILITY_OF_TEETH = "MobilityOfTeeth";
	public static String PROP_PAN_CHEWING_FREQUENCY = "PanChewingFrequency";
	public static String PROP_CLEANING_BRUSHING_TWICE = "CleaningBrushingTwice";
	public static String PROP_ID = "Id";
	public static String PROP_DENTAL_HISTORY_VALUE = "DentalHistoryValue";
	public static String PROP_POSTURE = "Posture";
	public static String PROP_SPECIFIC_PROTECTION = "SpecificProtection";
	public static String PROP_BETEL_NUT_CHEWING_DURATION_VALUE = "BetelNutChewingDurationValue";
	public static String PROP_SUPERNUMERARY_TEETH = "SupernumeraryTeeth";
	public static String PROP_CURATIVE = "Curative";
	public static String PROP_PAN_CHEWING_DURATION = "PanChewingDuration";
	public static String PROP_CLEANING_BRUSHING_IMMEDIATELY = "CleaningBrushingImmediately";
	public static String PROP_PALATE = "Palate";
	public static String PROP_ALCOHOLIC_NUMBER = "AlcoholicNumber";
	public static String PROP_MEDICAL_HISTORY = "MedicalHistory";
	public static String PROP_MATERIALS_ANY_OTHER = "MaterialsAnyOther";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_TOBACO_CHEWING_DURATION = "TobacoChewingDuration";
	public static String PROP_REHABILITATIVE = "Rehabilitative";
	public static String PROP_DRUGS_DURATION = "DrugsDuration";
	public static String PROP_TOUNGE = "Tounge";
	public static String PROP_PLACE_OF_BIRTH = "PlaceOfBirth";
	public static String PROP_FLOOR_OF_THE_MOUTH = "FloorOfTheMouth";
	public static String PROP_EDUCATION = "Education";
	public static String PROP_SMOKING_DURATION = "SmokingDuration";
	public static String PROP_TOBACO_CHEWING_DURATION_VALUE = "TobacoChewingDurationValue";
	public static String PROP_CHIEF_COMPLAINT = "ChiefComplaint";
	public static String PROP_GUTKA_FREQUENCY = "GutkaFrequency";
	public static String PROP_HIN = "Hin";
	public static String PROP_PAN_CHEWING_NUMBER = "PanChewingNumber";


	// constructors
	public BaseOpdCommunityOralHealthHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdCommunityOralHealthHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String education;
	private java.lang.String occupation;
	private java.lang.String perCapitaIncome;
	private java.lang.String socioEconomicStatus;
	private java.lang.String placeOfBirth;
	private java.lang.String continuousResidence;
	private java.lang.String waterSource;
	private java.lang.String chiefComplaint;
	private java.lang.String historyOfPesentIllness;
	private java.lang.String medicalHistory;
	private java.lang.String medicalHistoryValue;
	private java.lang.String dentalHistory;
	private java.lang.String dentalHistoryValue;
	private java.lang.String smokingNumber;
	private java.lang.String smokingFrequency;
	private java.lang.String smokingDuration;
	private java.lang.String smokingDurationValue;
	private java.lang.String tobacoChewingNumber;
	private java.lang.String tobacoChewingFrequency;
	private java.lang.String tobacoChewingDuration;
	private java.lang.String tobacoChewingDurationValue;
	private java.lang.String panChewingNumber;
	private java.lang.String panChewingFrequency;
	private java.lang.String panChewingDuration;
	private java.lang.String panChewingDurationValue;
	private java.lang.String gutkaNumber;
	private java.lang.String gutkaFrequency;
	private java.lang.String gutkaDuration;
	private java.lang.String gutkaDurationValue;
	private java.lang.String snuffNumber;
	private java.lang.String snuffFrequency;
	private java.lang.String snuffDuration;
	private java.lang.String snuffDurationValue;
	private java.lang.String betelNutChewingNumber;
	private java.lang.String betelNutChewingFrequency;
	private java.lang.String betelNutChewingDuration;
	private java.lang.String betelNutChewingDurationValue;
	private java.lang.String alcoholicNumber;
	private java.lang.String alcoholicFrequency;
	private java.lang.String alcoholicDuration;
	private java.lang.String alcoholicDurationValue;
	private java.lang.String drugsNumber;
	private java.lang.String drugsFrequency;
	private java.lang.String drugsDuration;
	private java.lang.String drugsDurationValue;
	private java.lang.String habitsRelated;
	private java.lang.String habitsRelatedValue;
	private java.lang.String typeOfCleaningBrush;
	private java.lang.String typeOfCleaningFinger;
	private java.lang.String typeOfCleaningStick;
	private java.lang.String typeOfCleaningAnyOther;
	private java.lang.String methodOfCleaningVertical;
	private java.lang.String methodOfCleaningHorizontal;
	private java.lang.String methodOfCleaningCircular;
	private java.lang.String materialsToothPaste;
	private java.lang.String materialsPowder;
	private java.lang.String materialsCharcoal;
	private java.lang.String materialsAnyOther;
	private java.lang.String cleaningBrushingOnce;
	private java.lang.String cleaningBrushingTwice;
	private java.lang.String cleaningBrushingThrice;
	private java.lang.String cleaningBrushingImmediately;
	private java.lang.String flossingInter;
	private java.lang.String oralMouthRinse;
	private java.lang.String dietary;
	private java.lang.String gait;
	private java.lang.String posture;
	private java.lang.String built;
	private java.lang.String nourishment;
	private java.lang.String symmetryOfFace;
	private java.lang.String temporomandibularJoint;
	private java.lang.String lymphNodes;
	private java.lang.String lip;
	private java.lang.String labicalMucosa;
	private java.lang.String buccalMucosa;
	private java.lang.String floorOfTheMouth;
	private java.lang.String tounge;
	private java.lang.String gingiva;
	private java.lang.String palate;
	private java.lang.String typeOfDefinition;
	private java.lang.String numberOfTeethPresent;
	private java.lang.String teethAbsentReasonloss;
	private java.lang.String dentalCaries;
	private java.lang.String filledTeeth;
	private java.lang.String anyProsthesis;
	private java.lang.String wastingDisease;
	private java.lang.String enamelHypolasia;
	private java.lang.String supernumeraryTeeth;
	private java.lang.String malocclusion;
	private java.lang.String occlusalTraumatism;
	private java.lang.String fracturedNonVitaltooth;
	private java.lang.String stains;
	private java.lang.String dentalDeposits;
	private java.lang.String gingivitis;
	private java.lang.String periodontalPocket;
	private java.lang.String mobilityOfTeeth;
	private java.lang.String emergency;
	private java.lang.String promotive;
	private java.lang.String preventive;
	private java.lang.String curative;
	private java.lang.String rehabilitative;
	private java.lang.String maintenance;
	private java.lang.String healthPromotion;
	private java.lang.String specificProtection;
	private java.lang.String promptTreatment;
	private java.lang.String disabilityLimitations;
	private java.lang.String rehabilitation;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdCommunityOralHealthDetail> opdCommunityOralHealthDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="community_oral_health_header_id"
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
	 * Return the value associated with the column: education
	 */
	public java.lang.String getEducation () {
		return education;
	}

	/**
	 * Set the value related to the column: education
	 * @param education the education value
	 */
	public void setEducation (java.lang.String education) {
		this.education = education;
	}



	/**
	 * Return the value associated with the column: occupation
	 */
	public java.lang.String getOccupation () {
		return occupation;
	}

	/**
	 * Set the value related to the column: occupation
	 * @param occupation the occupation value
	 */
	public void setOccupation (java.lang.String occupation) {
		this.occupation = occupation;
	}



	/**
	 * Return the value associated with the column: per_capita_income
	 */
	public java.lang.String getPerCapitaIncome () {
		return perCapitaIncome;
	}

	/**
	 * Set the value related to the column: per_capita_income
	 * @param perCapitaIncome the per_capita_income value
	 */
	public void setPerCapitaIncome (java.lang.String perCapitaIncome) {
		this.perCapitaIncome = perCapitaIncome;
	}



	/**
	 * Return the value associated with the column: socio_economic_status
	 */
	public java.lang.String getSocioEconomicStatus () {
		return socioEconomicStatus;
	}

	/**
	 * Set the value related to the column: socio_economic_status
	 * @param socioEconomicStatus the socio_economic_status value
	 */
	public void setSocioEconomicStatus (java.lang.String socioEconomicStatus) {
		this.socioEconomicStatus = socioEconomicStatus;
	}



	/**
	 * Return the value associated with the column: place_of_birth
	 */
	public java.lang.String getPlaceOfBirth () {
		return placeOfBirth;
	}

	/**
	 * Set the value related to the column: place_of_birth
	 * @param placeOfBirth the place_of_birth value
	 */
	public void setPlaceOfBirth (java.lang.String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}



	/**
	 * Return the value associated with the column: continuous_residence
	 */
	public java.lang.String getContinuousResidence () {
		return continuousResidence;
	}

	/**
	 * Set the value related to the column: continuous_residence
	 * @param continuousResidence the continuous_residence value
	 */
	public void setContinuousResidence (java.lang.String continuousResidence) {
		this.continuousResidence = continuousResidence;
	}



	/**
	 * Return the value associated with the column: water_source
	 */
	public java.lang.String getWaterSource () {
		return waterSource;
	}

	/**
	 * Set the value related to the column: water_source
	 * @param waterSource the water_source value
	 */
	public void setWaterSource (java.lang.String waterSource) {
		this.waterSource = waterSource;
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
	 * Return the value associated with the column: history_of_pesent_illness
	 */
	public java.lang.String getHistoryOfPesentIllness () {
		return historyOfPesentIllness;
	}

	/**
	 * Set the value related to the column: history_of_pesent_illness
	 * @param historyOfPesentIllness the history_of_pesent_illness value
	 */
	public void setHistoryOfPesentIllness (java.lang.String historyOfPesentIllness) {
		this.historyOfPesentIllness = historyOfPesentIllness;
	}



	/**
	 * Return the value associated with the column: medical_history
	 */
	public java.lang.String getMedicalHistory () {
		return medicalHistory;
	}

	/**
	 * Set the value related to the column: medical_history
	 * @param medicalHistory the medical_history value
	 */
	public void setMedicalHistory (java.lang.String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}



	/**
	 * Return the value associated with the column: medical_history_value
	 */
	public java.lang.String getMedicalHistoryValue () {
		return medicalHistoryValue;
	}

	/**
	 * Set the value related to the column: medical_history_value
	 * @param medicalHistoryValue the medical_history_value value
	 */
	public void setMedicalHistoryValue (java.lang.String medicalHistoryValue) {
		this.medicalHistoryValue = medicalHistoryValue;
	}



	/**
	 * Return the value associated with the column: dental_history
	 */
	public java.lang.String getDentalHistory () {
		return dentalHistory;
	}

	/**
	 * Set the value related to the column: dental_history
	 * @param dentalHistory the dental_history value
	 */
	public void setDentalHistory (java.lang.String dentalHistory) {
		this.dentalHistory = dentalHistory;
	}



	/**
	 * Return the value associated with the column: dental_history_value
	 */
	public java.lang.String getDentalHistoryValue () {
		return dentalHistoryValue;
	}

	/**
	 * Set the value related to the column: dental_history_value
	 * @param dentalHistoryValue the dental_history_value value
	 */
	public void setDentalHistoryValue (java.lang.String dentalHistoryValue) {
		this.dentalHistoryValue = dentalHistoryValue;
	}



	/**
	 * Return the value associated with the column: smoking_number
	 */
	public java.lang.String getSmokingNumber () {
		return smokingNumber;
	}

	/**
	 * Set the value related to the column: smoking_number
	 * @param smokingNumber the smoking_number value
	 */
	public void setSmokingNumber (java.lang.String smokingNumber) {
		this.smokingNumber = smokingNumber;
	}



	/**
	 * Return the value associated with the column: smoking_frequency
	 */
	public java.lang.String getSmokingFrequency () {
		return smokingFrequency;
	}

	/**
	 * Set the value related to the column: smoking_frequency
	 * @param smokingFrequency the smoking_frequency value
	 */
	public void setSmokingFrequency (java.lang.String smokingFrequency) {
		this.smokingFrequency = smokingFrequency;
	}



	/**
	 * Return the value associated with the column: smoking_duration
	 */
	public java.lang.String getSmokingDuration () {
		return smokingDuration;
	}

	/**
	 * Set the value related to the column: smoking_duration
	 * @param smokingDuration the smoking_duration value
	 */
	public void setSmokingDuration (java.lang.String smokingDuration) {
		this.smokingDuration = smokingDuration;
	}



	/**
	 * Return the value associated with the column: smoking_duration_value
	 */
	public java.lang.String getSmokingDurationValue () {
		return smokingDurationValue;
	}

	/**
	 * Set the value related to the column: smoking_duration_value
	 * @param smokingDurationValue the smoking_duration_value value
	 */
	public void setSmokingDurationValue (java.lang.String smokingDurationValue) {
		this.smokingDurationValue = smokingDurationValue;
	}



	/**
	 * Return the value associated with the column: tobaco_chewing_number
	 */
	public java.lang.String getTobacoChewingNumber () {
		return tobacoChewingNumber;
	}

	/**
	 * Set the value related to the column: tobaco_chewing_number
	 * @param tobacoChewingNumber the tobaco_chewing_number value
	 */
	public void setTobacoChewingNumber (java.lang.String tobacoChewingNumber) {
		this.tobacoChewingNumber = tobacoChewingNumber;
	}



	/**
	 * Return the value associated with the column: tobaco_chewing_frequency
	 */
	public java.lang.String getTobacoChewingFrequency () {
		return tobacoChewingFrequency;
	}

	/**
	 * Set the value related to the column: tobaco_chewing_frequency
	 * @param tobacoChewingFrequency the tobaco_chewing_frequency value
	 */
	public void setTobacoChewingFrequency (java.lang.String tobacoChewingFrequency) {
		this.tobacoChewingFrequency = tobacoChewingFrequency;
	}



	/**
	 * Return the value associated with the column: tobaco_chewing_duration
	 */
	public java.lang.String getTobacoChewingDuration () {
		return tobacoChewingDuration;
	}

	/**
	 * Set the value related to the column: tobaco_chewing_duration
	 * @param tobacoChewingDuration the tobaco_chewing_duration value
	 */
	public void setTobacoChewingDuration (java.lang.String tobacoChewingDuration) {
		this.tobacoChewingDuration = tobacoChewingDuration;
	}



	/**
	 * Return the value associated with the column: tobaco_chewing_duration_value
	 */
	public java.lang.String getTobacoChewingDurationValue () {
		return tobacoChewingDurationValue;
	}

	/**
	 * Set the value related to the column: tobaco_chewing_duration_value
	 * @param tobacoChewingDurationValue the tobaco_chewing_duration_value value
	 */
	public void setTobacoChewingDurationValue (java.lang.String tobacoChewingDurationValue) {
		this.tobacoChewingDurationValue = tobacoChewingDurationValue;
	}



	/**
	 * Return the value associated with the column: pan_chewing_number
	 */
	public java.lang.String getPanChewingNumber () {
		return panChewingNumber;
	}

	/**
	 * Set the value related to the column: pan_chewing_number
	 * @param panChewingNumber the pan_chewing_number value
	 */
	public void setPanChewingNumber (java.lang.String panChewingNumber) {
		this.panChewingNumber = panChewingNumber;
	}



	/**
	 * Return the value associated with the column: pan_chewing_frequency
	 */
	public java.lang.String getPanChewingFrequency () {
		return panChewingFrequency;
	}

	/**
	 * Set the value related to the column: pan_chewing_frequency
	 * @param panChewingFrequency the pan_chewing_frequency value
	 */
	public void setPanChewingFrequency (java.lang.String panChewingFrequency) {
		this.panChewingFrequency = panChewingFrequency;
	}



	/**
	 * Return the value associated with the column: pan_chewing_duration
	 */
	public java.lang.String getPanChewingDuration () {
		return panChewingDuration;
	}

	/**
	 * Set the value related to the column: pan_chewing_duration
	 * @param panChewingDuration the pan_chewing_duration value
	 */
	public void setPanChewingDuration (java.lang.String panChewingDuration) {
		this.panChewingDuration = panChewingDuration;
	}



	/**
	 * Return the value associated with the column: pan_chewing_duration_value
	 */
	public java.lang.String getPanChewingDurationValue () {
		return panChewingDurationValue;
	}

	/**
	 * Set the value related to the column: pan_chewing_duration_value
	 * @param panChewingDurationValue the pan_chewing_duration_value value
	 */
	public void setPanChewingDurationValue (java.lang.String panChewingDurationValue) {
		this.panChewingDurationValue = panChewingDurationValue;
	}



	/**
	 * Return the value associated with the column: gutka_number
	 */
	public java.lang.String getGutkaNumber () {
		return gutkaNumber;
	}

	/**
	 * Set the value related to the column: gutka_number
	 * @param gutkaNumber the gutka_number value
	 */
	public void setGutkaNumber (java.lang.String gutkaNumber) {
		this.gutkaNumber = gutkaNumber;
	}



	/**
	 * Return the value associated with the column: gutka_frequency
	 */
	public java.lang.String getGutkaFrequency () {
		return gutkaFrequency;
	}

	/**
	 * Set the value related to the column: gutka_frequency
	 * @param gutkaFrequency the gutka_frequency value
	 */
	public void setGutkaFrequency (java.lang.String gutkaFrequency) {
		this.gutkaFrequency = gutkaFrequency;
	}



	/**
	 * Return the value associated with the column: gutka_duration
	 */
	public java.lang.String getGutkaDuration () {
		return gutkaDuration;
	}

	/**
	 * Set the value related to the column: gutka_duration
	 * @param gutkaDuration the gutka_duration value
	 */
	public void setGutkaDuration (java.lang.String gutkaDuration) {
		this.gutkaDuration = gutkaDuration;
	}



	/**
	 * Return the value associated with the column: gutka_duration_value
	 */
	public java.lang.String getGutkaDurationValue () {
		return gutkaDurationValue;
	}

	/**
	 * Set the value related to the column: gutka_duration_value
	 * @param gutkaDurationValue the gutka_duration_value value
	 */
	public void setGutkaDurationValue (java.lang.String gutkaDurationValue) {
		this.gutkaDurationValue = gutkaDurationValue;
	}



	/**
	 * Return the value associated with the column: snuff_number
	 */
	public java.lang.String getSnuffNumber () {
		return snuffNumber;
	}

	/**
	 * Set the value related to the column: snuff_number
	 * @param snuffNumber the snuff_number value
	 */
	public void setSnuffNumber (java.lang.String snuffNumber) {
		this.snuffNumber = snuffNumber;
	}



	/**
	 * Return the value associated with the column: snuff_frequency
	 */
	public java.lang.String getSnuffFrequency () {
		return snuffFrequency;
	}

	/**
	 * Set the value related to the column: snuff_frequency
	 * @param snuffFrequency the snuff_frequency value
	 */
	public void setSnuffFrequency (java.lang.String snuffFrequency) {
		this.snuffFrequency = snuffFrequency;
	}



	/**
	 * Return the value associated with the column: snuff_duration
	 */
	public java.lang.String getSnuffDuration () {
		return snuffDuration;
	}

	/**
	 * Set the value related to the column: snuff_duration
	 * @param snuffDuration the snuff_duration value
	 */
	public void setSnuffDuration (java.lang.String snuffDuration) {
		this.snuffDuration = snuffDuration;
	}



	/**
	 * Return the value associated with the column: snuff_duration_value
	 */
	public java.lang.String getSnuffDurationValue () {
		return snuffDurationValue;
	}

	/**
	 * Set the value related to the column: snuff_duration_value
	 * @param snuffDurationValue the snuff_duration_value value
	 */
	public void setSnuffDurationValue (java.lang.String snuffDurationValue) {
		this.snuffDurationValue = snuffDurationValue;
	}



	/**
	 * Return the value associated with the column: betel_nut_chewing_number
	 */
	public java.lang.String getBetelNutChewingNumber () {
		return betelNutChewingNumber;
	}

	/**
	 * Set the value related to the column: betel_nut_chewing_number
	 * @param betelNutChewingNumber the betel_nut_chewing_number value
	 */
	public void setBetelNutChewingNumber (java.lang.String betelNutChewingNumber) {
		this.betelNutChewingNumber = betelNutChewingNumber;
	}



	/**
	 * Return the value associated with the column: betel_nut_chewing_frequency
	 */
	public java.lang.String getBetelNutChewingFrequency () {
		return betelNutChewingFrequency;
	}

	/**
	 * Set the value related to the column: betel_nut_chewing_frequency
	 * @param betelNutChewingFrequency the betel_nut_chewing_frequency value
	 */
	public void setBetelNutChewingFrequency (java.lang.String betelNutChewingFrequency) {
		this.betelNutChewingFrequency = betelNutChewingFrequency;
	}



	/**
	 * Return the value associated with the column: betel_nut_chewing_duration
	 */
	public java.lang.String getBetelNutChewingDuration () {
		return betelNutChewingDuration;
	}

	/**
	 * Set the value related to the column: betel_nut_chewing_duration
	 * @param betelNutChewingDuration the betel_nut_chewing_duration value
	 */
	public void setBetelNutChewingDuration (java.lang.String betelNutChewingDuration) {
		this.betelNutChewingDuration = betelNutChewingDuration;
	}



	/**
	 * Return the value associated with the column: betel_nut_chewing_duration_value
	 */
	public java.lang.String getBetelNutChewingDurationValue () {
		return betelNutChewingDurationValue;
	}

	/**
	 * Set the value related to the column: betel_nut_chewing_duration_value
	 * @param betelNutChewingDurationValue the betel_nut_chewing_duration_value value
	 */
	public void setBetelNutChewingDurationValue (java.lang.String betelNutChewingDurationValue) {
		this.betelNutChewingDurationValue = betelNutChewingDurationValue;
	}



	/**
	 * Return the value associated with the column: alcoholic_number
	 */
	public java.lang.String getAlcoholicNumber () {
		return alcoholicNumber;
	}

	/**
	 * Set the value related to the column: alcoholic_number
	 * @param alcoholicNumber the alcoholic_number value
	 */
	public void setAlcoholicNumber (java.lang.String alcoholicNumber) {
		this.alcoholicNumber = alcoholicNumber;
	}



	/**
	 * Return the value associated with the column: alcoholic_frequency
	 */
	public java.lang.String getAlcoholicFrequency () {
		return alcoholicFrequency;
	}

	/**
	 * Set the value related to the column: alcoholic_frequency
	 * @param alcoholicFrequency the alcoholic_frequency value
	 */
	public void setAlcoholicFrequency (java.lang.String alcoholicFrequency) {
		this.alcoholicFrequency = alcoholicFrequency;
	}



	/**
	 * Return the value associated with the column: alcoholic_duration
	 */
	public java.lang.String getAlcoholicDuration () {
		return alcoholicDuration;
	}

	/**
	 * Set the value related to the column: alcoholic_duration
	 * @param alcoholicDuration the alcoholic_duration value
	 */
	public void setAlcoholicDuration (java.lang.String alcoholicDuration) {
		this.alcoholicDuration = alcoholicDuration;
	}



	/**
	 * Return the value associated with the column: alcoholic_duration_value
	 */
	public java.lang.String getAlcoholicDurationValue () {
		return alcoholicDurationValue;
	}

	/**
	 * Set the value related to the column: alcoholic_duration_value
	 * @param alcoholicDurationValue the alcoholic_duration_value value
	 */
	public void setAlcoholicDurationValue (java.lang.String alcoholicDurationValue) {
		this.alcoholicDurationValue = alcoholicDurationValue;
	}



	/**
	 * Return the value associated with the column: drugs_number
	 */
	public java.lang.String getDrugsNumber () {
		return drugsNumber;
	}

	/**
	 * Set the value related to the column: drugs_number
	 * @param drugsNumber the drugs_number value
	 */
	public void setDrugsNumber (java.lang.String drugsNumber) {
		this.drugsNumber = drugsNumber;
	}



	/**
	 * Return the value associated with the column: drugs_frequency
	 */
	public java.lang.String getDrugsFrequency () {
		return drugsFrequency;
	}

	/**
	 * Set the value related to the column: drugs_frequency
	 * @param drugsFrequency the drugs_frequency value
	 */
	public void setDrugsFrequency (java.lang.String drugsFrequency) {
		this.drugsFrequency = drugsFrequency;
	}



	/**
	 * Return the value associated with the column: drugs_duration
	 */
	public java.lang.String getDrugsDuration () {
		return drugsDuration;
	}

	/**
	 * Set the value related to the column: drugs_duration
	 * @param drugsDuration the drugs_duration value
	 */
	public void setDrugsDuration (java.lang.String drugsDuration) {
		this.drugsDuration = drugsDuration;
	}



	/**
	 * Return the value associated with the column: drugs_duration_value
	 */
	public java.lang.String getDrugsDurationValue () {
		return drugsDurationValue;
	}

	/**
	 * Set the value related to the column: drugs_duration_value
	 * @param drugsDurationValue the drugs_duration_value value
	 */
	public void setDrugsDurationValue (java.lang.String drugsDurationValue) {
		this.drugsDurationValue = drugsDurationValue;
	}



	/**
	 * Return the value associated with the column: habits_related
	 */
	public java.lang.String getHabitsRelated () {
		return habitsRelated;
	}

	/**
	 * Set the value related to the column: habits_related
	 * @param habitsRelated the habits_related value
	 */
	public void setHabitsRelated (java.lang.String habitsRelated) {
		this.habitsRelated = habitsRelated;
	}



	/**
	 * Return the value associated with the column: habits_related_value
	 */
	public java.lang.String getHabitsRelatedValue () {
		return habitsRelatedValue;
	}

	/**
	 * Set the value related to the column: habits_related_value
	 * @param habitsRelatedValue the habits_related_value value
	 */
	public void setHabitsRelatedValue (java.lang.String habitsRelatedValue) {
		this.habitsRelatedValue = habitsRelatedValue;
	}



	/**
	 * Return the value associated with the column: type_of_cleaning_brush
	 */
	public java.lang.String getTypeOfCleaningBrush () {
		return typeOfCleaningBrush;
	}

	/**
	 * Set the value related to the column: type_of_cleaning_brush
	 * @param typeOfCleaningBrush the type_of_cleaning_brush value
	 */
	public void setTypeOfCleaningBrush (java.lang.String typeOfCleaningBrush) {
		this.typeOfCleaningBrush = typeOfCleaningBrush;
	}



	/**
	 * Return the value associated with the column: type_of_cleaning_finger
	 */
	public java.lang.String getTypeOfCleaningFinger () {
		return typeOfCleaningFinger;
	}

	/**
	 * Set the value related to the column: type_of_cleaning_finger
	 * @param typeOfCleaningFinger the type_of_cleaning_finger value
	 */
	public void setTypeOfCleaningFinger (java.lang.String typeOfCleaningFinger) {
		this.typeOfCleaningFinger = typeOfCleaningFinger;
	}



	/**
	 * Return the value associated with the column: type_of_cleaning_stick
	 */
	public java.lang.String getTypeOfCleaningStick () {
		return typeOfCleaningStick;
	}

	/**
	 * Set the value related to the column: type_of_cleaning_stick
	 * @param typeOfCleaningStick the type_of_cleaning_stick value
	 */
	public void setTypeOfCleaningStick (java.lang.String typeOfCleaningStick) {
		this.typeOfCleaningStick = typeOfCleaningStick;
	}



	/**
	 * Return the value associated with the column: type_of_cleaning_any_other
	 */
	public java.lang.String getTypeOfCleaningAnyOther () {
		return typeOfCleaningAnyOther;
	}

	/**
	 * Set the value related to the column: type_of_cleaning_any_other
	 * @param typeOfCleaningAnyOther the type_of_cleaning_any_other value
	 */
	public void setTypeOfCleaningAnyOther (java.lang.String typeOfCleaningAnyOther) {
		this.typeOfCleaningAnyOther = typeOfCleaningAnyOther;
	}



	/**
	 * Return the value associated with the column: method_of_cleaning_vertical
	 */
	public java.lang.String getMethodOfCleaningVertical () {
		return methodOfCleaningVertical;
	}

	/**
	 * Set the value related to the column: method_of_cleaning_vertical
	 * @param methodOfCleaningVertical the method_of_cleaning_vertical value
	 */
	public void setMethodOfCleaningVertical (java.lang.String methodOfCleaningVertical) {
		this.methodOfCleaningVertical = methodOfCleaningVertical;
	}



	/**
	 * Return the value associated with the column: method_of_cleaning_horizontal
	 */
	public java.lang.String getMethodOfCleaningHorizontal () {
		return methodOfCleaningHorizontal;
	}

	/**
	 * Set the value related to the column: method_of_cleaning_horizontal
	 * @param methodOfCleaningHorizontal the method_of_cleaning_horizontal value
	 */
	public void setMethodOfCleaningHorizontal (java.lang.String methodOfCleaningHorizontal) {
		this.methodOfCleaningHorizontal = methodOfCleaningHorizontal;
	}



	/**
	 * Return the value associated with the column: method_of_cleaning_circular
	 */
	public java.lang.String getMethodOfCleaningCircular () {
		return methodOfCleaningCircular;
	}

	/**
	 * Set the value related to the column: method_of_cleaning_circular
	 * @param methodOfCleaningCircular the method_of_cleaning_circular value
	 */
	public void setMethodOfCleaningCircular (java.lang.String methodOfCleaningCircular) {
		this.methodOfCleaningCircular = methodOfCleaningCircular;
	}



	/**
	 * Return the value associated with the column: materials_tooth_paste
	 */
	public java.lang.String getMaterialsToothPaste () {
		return materialsToothPaste;
	}

	/**
	 * Set the value related to the column: materials_tooth_paste
	 * @param materialsToothPaste the materials_tooth_paste value
	 */
	public void setMaterialsToothPaste (java.lang.String materialsToothPaste) {
		this.materialsToothPaste = materialsToothPaste;
	}



	/**
	 * Return the value associated with the column: materials_powder
	 */
	public java.lang.String getMaterialsPowder () {
		return materialsPowder;
	}

	/**
	 * Set the value related to the column: materials_powder
	 * @param materialsPowder the materials_powder value
	 */
	public void setMaterialsPowder (java.lang.String materialsPowder) {
		this.materialsPowder = materialsPowder;
	}



	/**
	 * Return the value associated with the column: materials_charcoal
	 */
	public java.lang.String getMaterialsCharcoal () {
		return materialsCharcoal;
	}

	/**
	 * Set the value related to the column: materials_charcoal
	 * @param materialsCharcoal the materials_charcoal value
	 */
	public void setMaterialsCharcoal (java.lang.String materialsCharcoal) {
		this.materialsCharcoal = materialsCharcoal;
	}



	/**
	 * Return the value associated with the column: materials_any_other
	 */
	public java.lang.String getMaterialsAnyOther () {
		return materialsAnyOther;
	}

	/**
	 * Set the value related to the column: materials_any_other
	 * @param materialsAnyOther the materials_any_other value
	 */
	public void setMaterialsAnyOther (java.lang.String materialsAnyOther) {
		this.materialsAnyOther = materialsAnyOther;
	}



	/**
	 * Return the value associated with the column: cleaning_brushing_once
	 */
	public java.lang.String getCleaningBrushingOnce () {
		return cleaningBrushingOnce;
	}

	/**
	 * Set the value related to the column: cleaning_brushing_once
	 * @param cleaningBrushingOnce the cleaning_brushing_once value
	 */
	public void setCleaningBrushingOnce (java.lang.String cleaningBrushingOnce) {
		this.cleaningBrushingOnce = cleaningBrushingOnce;
	}



	/**
	 * Return the value associated with the column: cleaning_brushing_twice
	 */
	public java.lang.String getCleaningBrushingTwice () {
		return cleaningBrushingTwice;
	}

	/**
	 * Set the value related to the column: cleaning_brushing_twice
	 * @param cleaningBrushingTwice the cleaning_brushing_twice value
	 */
	public void setCleaningBrushingTwice (java.lang.String cleaningBrushingTwice) {
		this.cleaningBrushingTwice = cleaningBrushingTwice;
	}



	/**
	 * Return the value associated with the column: cleaning_brushing_thrice
	 */
	public java.lang.String getCleaningBrushingThrice () {
		return cleaningBrushingThrice;
	}

	/**
	 * Set the value related to the column: cleaning_brushing_thrice
	 * @param cleaningBrushingThrice the cleaning_brushing_thrice value
	 */
	public void setCleaningBrushingThrice (java.lang.String cleaningBrushingThrice) {
		this.cleaningBrushingThrice = cleaningBrushingThrice;
	}



	/**
	 * Return the value associated with the column: cleaning_brushing_immediately
	 */
	public java.lang.String getCleaningBrushingImmediately () {
		return cleaningBrushingImmediately;
	}

	/**
	 * Set the value related to the column: cleaning_brushing_immediately
	 * @param cleaningBrushingImmediately the cleaning_brushing_immediately value
	 */
	public void setCleaningBrushingImmediately (java.lang.String cleaningBrushingImmediately) {
		this.cleaningBrushingImmediately = cleaningBrushingImmediately;
	}



	/**
	 * Return the value associated with the column: flossing_inter
	 */
	public java.lang.String getFlossingInter () {
		return flossingInter;
	}

	/**
	 * Set the value related to the column: flossing_inter
	 * @param flossingInter the flossing_inter value
	 */
	public void setFlossingInter (java.lang.String flossingInter) {
		this.flossingInter = flossingInter;
	}



	/**
	 * Return the value associated with the column: oral_mouth_rinse
	 */
	public java.lang.String getOralMouthRinse () {
		return oralMouthRinse;
	}

	/**
	 * Set the value related to the column: oral_mouth_rinse
	 * @param oralMouthRinse the oral_mouth_rinse value
	 */
	public void setOralMouthRinse (java.lang.String oralMouthRinse) {
		this.oralMouthRinse = oralMouthRinse;
	}



	/**
	 * Return the value associated with the column: dietary
	 */
	public java.lang.String getDietary () {
		return dietary;
	}

	/**
	 * Set the value related to the column: dietary
	 * @param dietary the dietary value
	 */
	public void setDietary (java.lang.String dietary) {
		this.dietary = dietary;
	}



	/**
	 * Return the value associated with the column: gait
	 */
	public java.lang.String getGait () {
		return gait;
	}

	/**
	 * Set the value related to the column: gait
	 * @param gait the gait value
	 */
	public void setGait (java.lang.String gait) {
		this.gait = gait;
	}



	/**
	 * Return the value associated with the column: posture
	 */
	public java.lang.String getPosture () {
		return posture;
	}

	/**
	 * Set the value related to the column: posture
	 * @param posture the posture value
	 */
	public void setPosture (java.lang.String posture) {
		this.posture = posture;
	}



	/**
	 * Return the value associated with the column: built
	 */
	public java.lang.String getBuilt () {
		return built;
	}

	/**
	 * Set the value related to the column: built
	 * @param built the built value
	 */
	public void setBuilt (java.lang.String built) {
		this.built = built;
	}



	/**
	 * Return the value associated with the column: nourishment
	 */
	public java.lang.String getNourishment () {
		return nourishment;
	}

	/**
	 * Set the value related to the column: nourishment
	 * @param nourishment the nourishment value
	 */
	public void setNourishment (java.lang.String nourishment) {
		this.nourishment = nourishment;
	}



	/**
	 * Return the value associated with the column: symmetry_of_face
	 */
	public java.lang.String getSymmetryOfFace () {
		return symmetryOfFace;
	}

	/**
	 * Set the value related to the column: symmetry_of_face
	 * @param symmetryOfFace the symmetry_of_face value
	 */
	public void setSymmetryOfFace (java.lang.String symmetryOfFace) {
		this.symmetryOfFace = symmetryOfFace;
	}



	/**
	 * Return the value associated with the column: temporomandibular_joint
	 */
	public java.lang.String getTemporomandibularJoint () {
		return temporomandibularJoint;
	}

	/**
	 * Set the value related to the column: temporomandibular_joint
	 * @param temporomandibularJoint the temporomandibular_joint value
	 */
	public void setTemporomandibularJoint (java.lang.String temporomandibularJoint) {
		this.temporomandibularJoint = temporomandibularJoint;
	}



	/**
	 * Return the value associated with the column: lymph_nodes
	 */
	public java.lang.String getLymphNodes () {
		return lymphNodes;
	}

	/**
	 * Set the value related to the column: lymph_nodes
	 * @param lymphNodes the lymph_nodes value
	 */
	public void setLymphNodes (java.lang.String lymphNodes) {
		this.lymphNodes = lymphNodes;
	}



	/**
	 * Return the value associated with the column: lip
	 */
	public java.lang.String getLip () {
		return lip;
	}

	/**
	 * Set the value related to the column: lip
	 * @param lip the lip value
	 */
	public void setLip (java.lang.String lip) {
		this.lip = lip;
	}



	/**
	 * Return the value associated with the column: labical_mucosa
	 */
	public java.lang.String getLabicalMucosa () {
		return labicalMucosa;
	}

	/**
	 * Set the value related to the column: labical_mucosa
	 * @param labicalMucosa the labical_mucosa value
	 */
	public void setLabicalMucosa (java.lang.String labicalMucosa) {
		this.labicalMucosa = labicalMucosa;
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
	 * Return the value associated with the column: floor_of_the_mouth
	 */
	public java.lang.String getFloorOfTheMouth () {
		return floorOfTheMouth;
	}

	/**
	 * Set the value related to the column: floor_of_the_mouth
	 * @param floorOfTheMouth the floor_of_the_mouth value
	 */
	public void setFloorOfTheMouth (java.lang.String floorOfTheMouth) {
		this.floorOfTheMouth = floorOfTheMouth;
	}



	/**
	 * Return the value associated with the column: tounge
	 */
	public java.lang.String getTounge () {
		return tounge;
	}

	/**
	 * Set the value related to the column: tounge
	 * @param tounge the tounge value
	 */
	public void setTounge (java.lang.String tounge) {
		this.tounge = tounge;
	}



	/**
	 * Return the value associated with the column: gingiva
	 */
	public java.lang.String getGingiva () {
		return gingiva;
	}

	/**
	 * Set the value related to the column: gingiva
	 * @param gingiva the gingiva value
	 */
	public void setGingiva (java.lang.String gingiva) {
		this.gingiva = gingiva;
	}



	/**
	 * Return the value associated with the column: palate
	 */
	public java.lang.String getPalate () {
		return palate;
	}

	/**
	 * Set the value related to the column: palate
	 * @param palate the palate value
	 */
	public void setPalate (java.lang.String palate) {
		this.palate = palate;
	}



	/**
	 * Return the value associated with the column: type_of_definition
	 */
	public java.lang.String getTypeOfDefinition () {
		return typeOfDefinition;
	}

	/**
	 * Set the value related to the column: type_of_definition
	 * @param typeOfDefinition the type_of_definition value
	 */
	public void setTypeOfDefinition (java.lang.String typeOfDefinition) {
		this.typeOfDefinition = typeOfDefinition;
	}



	/**
	 * Return the value associated with the column: number_of_teeth_present
	 */
	public java.lang.String getNumberOfTeethPresent () {
		return numberOfTeethPresent;
	}

	/**
	 * Set the value related to the column: number_of_teeth_present
	 * @param numberOfTeethPresent the number_of_teeth_present value
	 */
	public void setNumberOfTeethPresent (java.lang.String numberOfTeethPresent) {
		this.numberOfTeethPresent = numberOfTeethPresent;
	}



	/**
	 * Return the value associated with the column: teeth_absent_reasonloss
	 */
	public java.lang.String getTeethAbsentReasonloss () {
		return teethAbsentReasonloss;
	}

	/**
	 * Set the value related to the column: teeth_absent_reasonloss
	 * @param teethAbsentReasonloss the teeth_absent_reasonloss value
	 */
	public void setTeethAbsentReasonloss (java.lang.String teethAbsentReasonloss) {
		this.teethAbsentReasonloss = teethAbsentReasonloss;
	}



	/**
	 * Return the value associated with the column: dental_caries
	 */
	public java.lang.String getDentalCaries () {
		return dentalCaries;
	}

	/**
	 * Set the value related to the column: dental_caries
	 * @param dentalCaries the dental_caries value
	 */
	public void setDentalCaries (java.lang.String dentalCaries) {
		this.dentalCaries = dentalCaries;
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
	 * Return the value associated with the column: any_prosthesis
	 */
	public java.lang.String getAnyProsthesis () {
		return anyProsthesis;
	}

	/**
	 * Set the value related to the column: any_prosthesis
	 * @param anyProsthesis the any_prosthesis value
	 */
	public void setAnyProsthesis (java.lang.String anyProsthesis) {
		this.anyProsthesis = anyProsthesis;
	}



	/**
	 * Return the value associated with the column: wasting_disease
	 */
	public java.lang.String getWastingDisease () {
		return wastingDisease;
	}

	/**
	 * Set the value related to the column: wasting_disease
	 * @param wastingDisease the wasting_disease value
	 */
	public void setWastingDisease (java.lang.String wastingDisease) {
		this.wastingDisease = wastingDisease;
	}



	/**
	 * Return the value associated with the column: enamel_hypolasia
	 */
	public java.lang.String getEnamelHypolasia () {
		return enamelHypolasia;
	}

	/**
	 * Set the value related to the column: enamel_hypolasia
	 * @param enamelHypolasia the enamel_hypolasia value
	 */
	public void setEnamelHypolasia (java.lang.String enamelHypolasia) {
		this.enamelHypolasia = enamelHypolasia;
	}



	/**
	 * Return the value associated with the column: supernumerary_teeth
	 */
	public java.lang.String getSupernumeraryTeeth () {
		return supernumeraryTeeth;
	}

	/**
	 * Set the value related to the column: supernumerary_teeth
	 * @param supernumeraryTeeth the supernumerary_teeth value
	 */
	public void setSupernumeraryTeeth (java.lang.String supernumeraryTeeth) {
		this.supernumeraryTeeth = supernumeraryTeeth;
	}



	/**
	 * Return the value associated with the column: malocclusion
	 */
	public java.lang.String getMalocclusion () {
		return malocclusion;
	}

	/**
	 * Set the value related to the column: malocclusion
	 * @param malocclusion the malocclusion value
	 */
	public void setMalocclusion (java.lang.String malocclusion) {
		this.malocclusion = malocclusion;
	}



	/**
	 * Return the value associated with the column: occlusal_traumatism
	 */
	public java.lang.String getOcclusalTraumatism () {
		return occlusalTraumatism;
	}

	/**
	 * Set the value related to the column: occlusal_traumatism
	 * @param occlusalTraumatism the occlusal_traumatism value
	 */
	public void setOcclusalTraumatism (java.lang.String occlusalTraumatism) {
		this.occlusalTraumatism = occlusalTraumatism;
	}



	/**
	 * Return the value associated with the column: fractured_non_vitaltooth
	 */
	public java.lang.String getFracturedNonVitaltooth () {
		return fracturedNonVitaltooth;
	}

	/**
	 * Set the value related to the column: fractured_non_vitaltooth
	 * @param fracturedNonVitaltooth the fractured_non_vitaltooth value
	 */
	public void setFracturedNonVitaltooth (java.lang.String fracturedNonVitaltooth) {
		this.fracturedNonVitaltooth = fracturedNonVitaltooth;
	}



	/**
	 * Return the value associated with the column: stains
	 */
	public java.lang.String getStains () {
		return stains;
	}

	/**
	 * Set the value related to the column: stains
	 * @param stains the stains value
	 */
	public void setStains (java.lang.String stains) {
		this.stains = stains;
	}



	/**
	 * Return the value associated with the column: dental_deposits
	 */
	public java.lang.String getDentalDeposits () {
		return dentalDeposits;
	}

	/**
	 * Set the value related to the column: dental_deposits
	 * @param dentalDeposits the dental_deposits value
	 */
	public void setDentalDeposits (java.lang.String dentalDeposits) {
		this.dentalDeposits = dentalDeposits;
	}



	/**
	 * Return the value associated with the column: gingivitis
	 */
	public java.lang.String getGingivitis () {
		return gingivitis;
	}

	/**
	 * Set the value related to the column: gingivitis
	 * @param gingivitis the gingivitis value
	 */
	public void setGingivitis (java.lang.String gingivitis) {
		this.gingivitis = gingivitis;
	}



	/**
	 * Return the value associated with the column: periodontal_pocket
	 */
	public java.lang.String getPeriodontalPocket () {
		return periodontalPocket;
	}

	/**
	 * Set the value related to the column: periodontal_pocket
	 * @param periodontalPocket the periodontal_pocket value
	 */
	public void setPeriodontalPocket (java.lang.String periodontalPocket) {
		this.periodontalPocket = periodontalPocket;
	}



	/**
	 * Return the value associated with the column: mobility_of_teeth
	 */
	public java.lang.String getMobilityOfTeeth () {
		return mobilityOfTeeth;
	}

	/**
	 * Set the value related to the column: mobility_of_teeth
	 * @param mobilityOfTeeth the mobility_of_teeth value
	 */
	public void setMobilityOfTeeth (java.lang.String mobilityOfTeeth) {
		this.mobilityOfTeeth = mobilityOfTeeth;
	}



	/**
	 * Return the value associated with the column: emergency
	 */
	public java.lang.String getEmergency () {
		return emergency;
	}

	/**
	 * Set the value related to the column: emergency
	 * @param emergency the emergency value
	 */
	public void setEmergency (java.lang.String emergency) {
		this.emergency = emergency;
	}



	/**
	 * Return the value associated with the column: promotive
	 */
	public java.lang.String getPromotive () {
		return promotive;
	}

	/**
	 * Set the value related to the column: promotive
	 * @param promotive the promotive value
	 */
	public void setPromotive (java.lang.String promotive) {
		this.promotive = promotive;
	}



	/**
	 * Return the value associated with the column: preventive
	 */
	public java.lang.String getPreventive () {
		return preventive;
	}

	/**
	 * Set the value related to the column: preventive
	 * @param preventive the preventive value
	 */
	public void setPreventive (java.lang.String preventive) {
		this.preventive = preventive;
	}



	/**
	 * Return the value associated with the column: curative
	 */
	public java.lang.String getCurative () {
		return curative;
	}

	/**
	 * Set the value related to the column: curative
	 * @param curative the curative value
	 */
	public void setCurative (java.lang.String curative) {
		this.curative = curative;
	}



	/**
	 * Return the value associated with the column: rehabilitative
	 */
	public java.lang.String getRehabilitative () {
		return rehabilitative;
	}

	/**
	 * Set the value related to the column: rehabilitative
	 * @param rehabilitative the rehabilitative value
	 */
	public void setRehabilitative (java.lang.String rehabilitative) {
		this.rehabilitative = rehabilitative;
	}



	/**
	 * Return the value associated with the column: maintenance
	 */
	public java.lang.String getMaintenance () {
		return maintenance;
	}

	/**
	 * Set the value related to the column: maintenance
	 * @param maintenance the maintenance value
	 */
	public void setMaintenance (java.lang.String maintenance) {
		this.maintenance = maintenance;
	}



	/**
	 * Return the value associated with the column: health_promotion
	 */
	public java.lang.String getHealthPromotion () {
		return healthPromotion;
	}

	/**
	 * Set the value related to the column: health_promotion
	 * @param healthPromotion the health_promotion value
	 */
	public void setHealthPromotion (java.lang.String healthPromotion) {
		this.healthPromotion = healthPromotion;
	}



	/**
	 * Return the value associated with the column: specific_protection
	 */
	public java.lang.String getSpecificProtection () {
		return specificProtection;
	}

	/**
	 * Set the value related to the column: specific_protection
	 * @param specificProtection the specific_protection value
	 */
	public void setSpecificProtection (java.lang.String specificProtection) {
		this.specificProtection = specificProtection;
	}



	/**
	 * Return the value associated with the column: prompt_treatment
	 */
	public java.lang.String getPromptTreatment () {
		return promptTreatment;
	}

	/**
	 * Set the value related to the column: prompt_treatment
	 * @param promptTreatment the prompt_treatment value
	 */
	public void setPromptTreatment (java.lang.String promptTreatment) {
		this.promptTreatment = promptTreatment;
	}



	/**
	 * Return the value associated with the column: disability_limitations
	 */
	public java.lang.String getDisabilityLimitations () {
		return disabilityLimitations;
	}

	/**
	 * Set the value related to the column: disability_limitations
	 * @param disabilityLimitations the disability_limitations value
	 */
	public void setDisabilityLimitations (java.lang.String disabilityLimitations) {
		this.disabilityLimitations = disabilityLimitations;
	}



	/**
	 * Return the value associated with the column: rehabilitation
	 */
	public java.lang.String getRehabilitation () {
		return rehabilitation;
	}

	/**
	 * Set the value related to the column: rehabilitation
	 * @param rehabilitation the rehabilitation value
	 */
	public void setRehabilitation (java.lang.String rehabilitation) {
		this.rehabilitation = rehabilitation;
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



	/**
	 * Return the value associated with the column: OpdCommunityOralHealthDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCommunityOralHealthDetail> getOpdCommunityOralHealthDetails () {
		return opdCommunityOralHealthDetails;
	}

	/**
	 * Set the value related to the column: OpdCommunityOralHealthDetails
	 * @param opdCommunityOralHealthDetails the OpdCommunityOralHealthDetails value
	 */
	public void setOpdCommunityOralHealthDetails (java.util.Set<jkt.hms.masters.business.OpdCommunityOralHealthDetail> opdCommunityOralHealthDetails) {
		this.opdCommunityOralHealthDetails = opdCommunityOralHealthDetails;
	}

	public void addToOpdCommunityOralHealthDetails (jkt.hms.masters.business.OpdCommunityOralHealthDetail opdCommunityOralHealthDetail) {
		if (null == getOpdCommunityOralHealthDetails()) setOpdCommunityOralHealthDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdCommunityOralHealthDetail>());
		getOpdCommunityOralHealthDetails().add(opdCommunityOralHealthDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdCommunityOralHealthHeader)) return false;
		else {
			jkt.hms.masters.business.OpdCommunityOralHealthHeader opdCommunityOralHealthHeader = (jkt.hms.masters.business.OpdCommunityOralHealthHeader) obj;
			if (null == this.getId() || null == opdCommunityOralHealthHeader.getId()) return false;
			else return (this.getId().equals(opdCommunityOralHealthHeader.getId()));
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