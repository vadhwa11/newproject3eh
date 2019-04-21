package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_respiratory_speciality_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_respiratory_speciality_header"
 */

public abstract class BaseOpdRespiratorySpecialityHeader  implements Serializable {

	public static String REF = "OpdRespiratorySpecialityHeader";
	public static String PROP_SHAPE_VALUE = "ShapeValue";
	public static String PROP_DETAILS_OF_EXACERBATION = "DetailsOfExacerbation";
	public static String PROP_IMMUNIZATION_OPTIONAL = "ImmunizationOptional";
	public static String PROP_MOTHER_EDUCATION = "MotherEducation";
	public static String PROP_CURRENT_SYMPTOMS = "CurrentSymptoms";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_NEONATAL_RESPIRATORY_SYMPTOMS = "NeonatalRespiratorySymptoms";
	public static String PROP_CONTACT_WITH_TUBERCULOSIS = "ContactWithTuberculosis";
	public static String PROP_IMMUNIZATION_ROUTINE = "ImmunizationRoutine";
	public static String PROP_ADHERENCE_TO_TREATMENT_PLAN = "AdherenceToTreatmentPlan";
	public static String PROP_GESTATIONAL_AGE = "GestationalAge";
	public static String PROP_ABDOMEN = "Abdomen";
	public static String PROP_BREATH_SOUNDS_VALUE = "BreathSoundsValue";
	public static String PROP_FATHER_NAME = "FatherName";
	public static String PROP_MOTHER_NAME = "MotherName";
	public static String PROP_WORK_OF_BRATHING = "WorkOfBrathing";
	public static String PROP_TRIGGERS_VALUE = "TriggersValue";
	public static String PROP_WHEEZE = "Wheeze";
	public static String PROP_PARTIAL_VALUE = "PartialValue";
	public static String PROP_ID = "Id";
	public static String PROP_ALLERGY_SKIN_TEST = "AllergySkinTest";
	public static String PROP_HOSPITAL_ADMISSIONS = "HospitalAdmissions";
	public static String PROP_CASUALITY_VISITS = "CasualityVisits";
	public static String PROP_ASTHMA_EDUCATION = "AsthmaEducation";
	public static String PROP_FATHER_EDUCATION = "FatherEducation";
	public static String PROP_FATHER_OCCUPATION = "FatherOccupation";
	public static String PROP_ACTION_PLAN = "ActionPlan";
	public static String PROP_SYMTOMS = "Symtoms";
	public static String PROP_CHECK_INHALER_TECHNIQUE = "CheckInhalerTechnique";
	public static String PROP_CONJUNCTIVA = "Conjunctiva";
	public static String PROP_EXPOSURE_TO_PETS = "ExposureToPets";
	public static String PROP_FREQUENCT_OVER_ONE_YEAR = "FrequenctOverOneYear";
	public static String PROP_EAR = "Ear";
	public static String PROP_ASTHMA_DIARY = "AsthmaDiary";
	public static String PROP_CHEST = "Chest";
	public static String PROP_CLUBBING = "Clubbing";
	public static String PROP_NO_OF_EXACERBATIONS = "NoOfExacerbations";
	public static String PROP_EXPOSURE_TO_TRAFFIC_POLLUTION = "ExposureToTrafficPollution";
	public static String PROP_ASTHMA_DIARY_FOLLOWUP = "AsthmaDiaryFollowup";
	public static String PROP_OTHER_ADVENTITIOUS_SOUNDS = "OtherAdventitiousSounds";
	public static String PROP_HEART_RATE = "HeartRate";
	public static String PROP_EXPOSURE_TO_BIOMASS_FUEL = "ExposureToBiomassFuel";
	public static String PROP_BIRTH_WEIGHT = "BirthWeight";
	public static String PROP_CINESES = "Cineses";
	public static String PROP_PAST_HISTORY_VALUE = "PastHistoryValue";
	public static String PROP_THROAT = "Throat";
	public static String PROP_MOTHER_OCCUPATION = "MotherOccupation";
	public static String PROP_ORAL_STEROID_USE = "OralSteroidUse";
	public static String PROP_BREATH_SOUNDS = "BreathSounds";
	public static String PROP_WHEEZE_VALUE = "WheezeValue";
	public static String PROP_CVS = "Cvs";
	public static String PROP_SKIN = "Skin";
	public static String PROP_SEVERITY_AT_DIAGNOSIS = "SeverityAtDiagnosis";
	public static String PROP_INTERVAL_SINCE_LAST_VISIT = "IntervalSinceLastVisit";
	public static String PROP_SHAPE = "Shape";
	public static String PROP_AGE_OF_ONSET_OF_SYMPTOMS = "AgeOfOnsetOfSymptoms";
	public static String PROP_HOSPITAL_ADMISSIONS_FOLLOWUP = "HospitalAdmissionsFollowup";
	public static String PROP_EXPOSURE_TO_CIGARETTE_SMOKE = "ExposureToCigaretteSmoke";
	public static String PROP_PHYSICAL_ACTIVITIES = "PhysicalActivities";
	public static String PROP_ICU_ADMISSIONS = "IcuAdmissions";
	public static String PROP_NOSE = "Nose";
	public static String PROP_HIN = "Hin";
	public static String PROP_FACE = "Face";


	// constructors
	public BaseOpdRespiratorySpecialityHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdRespiratorySpecialityHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fatherName;
	private java.lang.String fatherOccupation;
	private java.lang.String fatherEducation;
	private java.lang.String motherName;
	private java.lang.String motherOccupation;
	private java.lang.String motherEducation;
	private java.lang.String detailsOfExacerbation;
	private java.lang.String frequenctOverOneYear;
	private java.lang.String casualityVisits;
	private java.lang.String hospitalAdmissions;
	private java.lang.String breathSounds;
	private java.lang.String breathSoundsValue;
	private java.lang.String icuAdmissions;
	private java.lang.String gestationalAge;
	private java.lang.String birthWeight;
	private java.lang.String neonatalRespiratorySymptoms;
	private java.lang.String contactWithTuberculosis;
	private java.lang.String immunizationRoutine;
	private java.lang.String immunizationOptional;
	private java.lang.String exposureToCigaretteSmoke;
	private java.lang.String exposureToBiomassFuel;
	private java.lang.String exposureToTrafficPollution;
	private java.lang.String exposureToPets;
	private java.lang.String skin;
	private java.lang.String face;
	private java.lang.String conjunctiva;
	private java.lang.String ear;
	private java.lang.String nose;
	private java.lang.String throat;
	private java.lang.String clubbing;
	private java.lang.String workOfBrathing;
	private java.lang.String chest;
	private java.lang.String shape;
	private java.lang.String shapeValue;
	private java.lang.String wheeze;
	private java.lang.String wheezeValue;
	private java.lang.String otherAdventitiousSounds;
	private java.lang.String abdomen;
	private java.lang.String cvs;
	private java.lang.String allergySkinTest;
	private java.lang.String asthmaEducation;
	private java.lang.String actionPlan;
	private java.lang.String asthmaDiary;
	private java.lang.String triggersValue;
	private java.lang.String ageOfOnsetOfSymptoms;
	private java.lang.String pastHistoryValue;
	private java.lang.String severityAtDiagnosis;
	private java.lang.String intervalSinceLastVisit;
	private java.lang.String symtoms;
	private java.lang.String currentSymptoms;
	private java.lang.String noOfExacerbations;
	private java.lang.String hospitalAdmissionsFollowup;
	private java.lang.String checkInhalerTechnique;
	private java.lang.String adherenceToTreatmentPlan;
	private java.lang.String asthmaDiaryFollowup;
	private java.lang.String heartRate;
	private java.lang.String cineses;
	private java.lang.String oralSteroidUse;
	private java.lang.String physicalActivities;
	private java.lang.String partialValue;

	// many to one
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="respiratory_speciality_id"
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
	 * Return the value associated with the column: father_name
	 */
	public java.lang.String getFatherName () {
		return fatherName;
	}

	/**
	 * Set the value related to the column: father_name
	 * @param fatherName the father_name value
	 */
	public void setFatherName (java.lang.String fatherName) {
		this.fatherName = fatherName;
	}



	/**
	 * Return the value associated with the column: father_occupation
	 */
	public java.lang.String getFatherOccupation () {
		return fatherOccupation;
	}

	/**
	 * Set the value related to the column: father_occupation
	 * @param fatherOccupation the father_occupation value
	 */
	public void setFatherOccupation (java.lang.String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}



	/**
	 * Return the value associated with the column: father_education
	 */
	public java.lang.String getFatherEducation () {
		return fatherEducation;
	}

	/**
	 * Set the value related to the column: father_education
	 * @param fatherEducation the father_education value
	 */
	public void setFatherEducation (java.lang.String fatherEducation) {
		this.fatherEducation = fatherEducation;
	}



	/**
	 * Return the value associated with the column: mother_name
	 */
	public java.lang.String getMotherName () {
		return motherName;
	}

	/**
	 * Set the value related to the column: mother_name
	 * @param motherName the mother_name value
	 */
	public void setMotherName (java.lang.String motherName) {
		this.motherName = motherName;
	}



	/**
	 * Return the value associated with the column: mother_occupation
	 */
	public java.lang.String getMotherOccupation () {
		return motherOccupation;
	}

	/**
	 * Set the value related to the column: mother_occupation
	 * @param motherOccupation the mother_occupation value
	 */
	public void setMotherOccupation (java.lang.String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}



	/**
	 * Return the value associated with the column: mother_education
	 */
	public java.lang.String getMotherEducation () {
		return motherEducation;
	}

	/**
	 * Set the value related to the column: mother_education
	 * @param motherEducation the mother_education value
	 */
	public void setMotherEducation (java.lang.String motherEducation) {
		this.motherEducation = motherEducation;
	}



	/**
	 * Return the value associated with the column: details_of_exacerbation
	 */
	public java.lang.String getDetailsOfExacerbation () {
		return detailsOfExacerbation;
	}

	/**
	 * Set the value related to the column: details_of_exacerbation
	 * @param detailsOfExacerbation the details_of_exacerbation value
	 */
	public void setDetailsOfExacerbation (java.lang.String detailsOfExacerbation) {
		this.detailsOfExacerbation = detailsOfExacerbation;
	}



	/**
	 * Return the value associated with the column: frequenct_over_one_year
	 */
	public java.lang.String getFrequenctOverOneYear () {
		return frequenctOverOneYear;
	}

	/**
	 * Set the value related to the column: frequenct_over_one_year
	 * @param frequenctOverOneYear the frequenct_over_one_year value
	 */
	public void setFrequenctOverOneYear (java.lang.String frequenctOverOneYear) {
		this.frequenctOverOneYear = frequenctOverOneYear;
	}



	/**
	 * Return the value associated with the column: casuality_visits
	 */
	public java.lang.String getCasualityVisits () {
		return casualityVisits;
	}

	/**
	 * Set the value related to the column: casuality_visits
	 * @param casualityVisits the casuality_visits value
	 */
	public void setCasualityVisits (java.lang.String casualityVisits) {
		this.casualityVisits = casualityVisits;
	}



	/**
	 * Return the value associated with the column: hospital_admissions
	 */
	public java.lang.String getHospitalAdmissions () {
		return hospitalAdmissions;
	}

	/**
	 * Set the value related to the column: hospital_admissions
	 * @param hospitalAdmissions the hospital_admissions value
	 */
	public void setHospitalAdmissions (java.lang.String hospitalAdmissions) {
		this.hospitalAdmissions = hospitalAdmissions;
	}



	/**
	 * Return the value associated with the column: breath_sounds
	 */
	public java.lang.String getBreathSounds () {
		return breathSounds;
	}

	/**
	 * Set the value related to the column: breath_sounds
	 * @param breathSounds the breath_sounds value
	 */
	public void setBreathSounds (java.lang.String breathSounds) {
		this.breathSounds = breathSounds;
	}



	/**
	 * Return the value associated with the column: breath_sounds_value
	 */
	public java.lang.String getBreathSoundsValue () {
		return breathSoundsValue;
	}

	/**
	 * Set the value related to the column: breath_sounds_value
	 * @param breathSoundsValue the breath_sounds_value value
	 */
	public void setBreathSoundsValue (java.lang.String breathSoundsValue) {
		this.breathSoundsValue = breathSoundsValue;
	}



	/**
	 * Return the value associated with the column: icu_admissions
	 */
	public java.lang.String getIcuAdmissions () {
		return icuAdmissions;
	}

	/**
	 * Set the value related to the column: icu_admissions
	 * @param icuAdmissions the icu_admissions value
	 */
	public void setIcuAdmissions (java.lang.String icuAdmissions) {
		this.icuAdmissions = icuAdmissions;
	}



	/**
	 * Return the value associated with the column: gestational_age
	 */
	public java.lang.String getGestationalAge () {
		return gestationalAge;
	}

	/**
	 * Set the value related to the column: gestational_age
	 * @param gestationalAge the gestational_age value
	 */
	public void setGestationalAge (java.lang.String gestationalAge) {
		this.gestationalAge = gestationalAge;
	}



	/**
	 * Return the value associated with the column: birth_weight
	 */
	public java.lang.String getBirthWeight () {
		return birthWeight;
	}

	/**
	 * Set the value related to the column: birth_weight
	 * @param birthWeight the birth_weight value
	 */
	public void setBirthWeight (java.lang.String birthWeight) {
		this.birthWeight = birthWeight;
	}



	/**
	 * Return the value associated with the column: neonatal_respiratory_symptoms
	 */
	public java.lang.String getNeonatalRespiratorySymptoms () {
		return neonatalRespiratorySymptoms;
	}

	/**
	 * Set the value related to the column: neonatal_respiratory_symptoms
	 * @param neonatalRespiratorySymptoms the neonatal_respiratory_symptoms value
	 */
	public void setNeonatalRespiratorySymptoms (java.lang.String neonatalRespiratorySymptoms) {
		this.neonatalRespiratorySymptoms = neonatalRespiratorySymptoms;
	}



	/**
	 * Return the value associated with the column: contact_with_tuberculosis
	 */
	public java.lang.String getContactWithTuberculosis () {
		return contactWithTuberculosis;
	}

	/**
	 * Set the value related to the column: contact_with_tuberculosis
	 * @param contactWithTuberculosis the contact_with_tuberculosis value
	 */
	public void setContactWithTuberculosis (java.lang.String contactWithTuberculosis) {
		this.contactWithTuberculosis = contactWithTuberculosis;
	}



	/**
	 * Return the value associated with the column: immunization_routine
	 */
	public java.lang.String getImmunizationRoutine () {
		return immunizationRoutine;
	}

	/**
	 * Set the value related to the column: immunization_routine
	 * @param immunizationRoutine the immunization_routine value
	 */
	public void setImmunizationRoutine (java.lang.String immunizationRoutine) {
		this.immunizationRoutine = immunizationRoutine;
	}



	/**
	 * Return the value associated with the column: immunization_optional
	 */
	public java.lang.String getImmunizationOptional () {
		return immunizationOptional;
	}

	/**
	 * Set the value related to the column: immunization_optional
	 * @param immunizationOptional the immunization_optional value
	 */
	public void setImmunizationOptional (java.lang.String immunizationOptional) {
		this.immunizationOptional = immunizationOptional;
	}



	/**
	 * Return the value associated with the column: exposure_to_cigarette_smoke
	 */
	public java.lang.String getExposureToCigaretteSmoke () {
		return exposureToCigaretteSmoke;
	}

	/**
	 * Set the value related to the column: exposure_to_cigarette_smoke
	 * @param exposureToCigaretteSmoke the exposure_to_cigarette_smoke value
	 */
	public void setExposureToCigaretteSmoke (java.lang.String exposureToCigaretteSmoke) {
		this.exposureToCigaretteSmoke = exposureToCigaretteSmoke;
	}



	/**
	 * Return the value associated with the column: exposure_to_biomass_fuel
	 */
	public java.lang.String getExposureToBiomassFuel () {
		return exposureToBiomassFuel;
	}

	/**
	 * Set the value related to the column: exposure_to_biomass_fuel
	 * @param exposureToBiomassFuel the exposure_to_biomass_fuel value
	 */
	public void setExposureToBiomassFuel (java.lang.String exposureToBiomassFuel) {
		this.exposureToBiomassFuel = exposureToBiomassFuel;
	}



	/**
	 * Return the value associated with the column: exposure_to_traffic_pollution
	 */
	public java.lang.String getExposureToTrafficPollution () {
		return exposureToTrafficPollution;
	}

	/**
	 * Set the value related to the column: exposure_to_traffic_pollution
	 * @param exposureToTrafficPollution the exposure_to_traffic_pollution value
	 */
	public void setExposureToTrafficPollution (java.lang.String exposureToTrafficPollution) {
		this.exposureToTrafficPollution = exposureToTrafficPollution;
	}



	/**
	 * Return the value associated with the column: exposure_to_pets
	 */
	public java.lang.String getExposureToPets () {
		return exposureToPets;
	}

	/**
	 * Set the value related to the column: exposure_to_pets
	 * @param exposureToPets the exposure_to_pets value
	 */
	public void setExposureToPets (java.lang.String exposureToPets) {
		this.exposureToPets = exposureToPets;
	}



	/**
	 * Return the value associated with the column: skin
	 */
	public java.lang.String getSkin () {
		return skin;
	}

	/**
	 * Set the value related to the column: skin
	 * @param skin the skin value
	 */
	public void setSkin (java.lang.String skin) {
		this.skin = skin;
	}



	/**
	 * Return the value associated with the column: face
	 */
	public java.lang.String getFace () {
		return face;
	}

	/**
	 * Set the value related to the column: face
	 * @param face the face value
	 */
	public void setFace (java.lang.String face) {
		this.face = face;
	}



	/**
	 * Return the value associated with the column: conjunctiva
	 */
	public java.lang.String getConjunctiva () {
		return conjunctiva;
	}

	/**
	 * Set the value related to the column: conjunctiva
	 * @param conjunctiva the conjunctiva value
	 */
	public void setConjunctiva (java.lang.String conjunctiva) {
		this.conjunctiva = conjunctiva;
	}



	/**
	 * Return the value associated with the column: ear
	 */
	public java.lang.String getEar () {
		return ear;
	}

	/**
	 * Set the value related to the column: ear
	 * @param ear the ear value
	 */
	public void setEar (java.lang.String ear) {
		this.ear = ear;
	}



	/**
	 * Return the value associated with the column: nose
	 */
	public java.lang.String getNose () {
		return nose;
	}

	/**
	 * Set the value related to the column: nose
	 * @param nose the nose value
	 */
	public void setNose (java.lang.String nose) {
		this.nose = nose;
	}



	/**
	 * Return the value associated with the column: throat
	 */
	public java.lang.String getThroat () {
		return throat;
	}

	/**
	 * Set the value related to the column: throat
	 * @param throat the throat value
	 */
	public void setThroat (java.lang.String throat) {
		this.throat = throat;
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
	 * Return the value associated with the column: work_of_brathing
	 */
	public java.lang.String getWorkOfBrathing () {
		return workOfBrathing;
	}

	/**
	 * Set the value related to the column: work_of_brathing
	 * @param workOfBrathing the work_of_brathing value
	 */
	public void setWorkOfBrathing (java.lang.String workOfBrathing) {
		this.workOfBrathing = workOfBrathing;
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
	 * Return the value associated with the column: shape
	 */
	public java.lang.String getShape () {
		return shape;
	}

	/**
	 * Set the value related to the column: shape
	 * @param shape the shape value
	 */
	public void setShape (java.lang.String shape) {
		this.shape = shape;
	}



	/**
	 * Return the value associated with the column: shape_value
	 */
	public java.lang.String getShapeValue () {
		return shapeValue;
	}

	/**
	 * Set the value related to the column: shape_value
	 * @param shapeValue the shape_value value
	 */
	public void setShapeValue (java.lang.String shapeValue) {
		this.shapeValue = shapeValue;
	}



	/**
	 * Return the value associated with the column: wheeze
	 */
	public java.lang.String getWheeze () {
		return wheeze;
	}

	/**
	 * Set the value related to the column: wheeze
	 * @param wheeze the wheeze value
	 */
	public void setWheeze (java.lang.String wheeze) {
		this.wheeze = wheeze;
	}



	/**
	 * Return the value associated with the column: wheeze_value
	 */
	public java.lang.String getWheezeValue () {
		return wheezeValue;
	}

	/**
	 * Set the value related to the column: wheeze_value
	 * @param wheezeValue the wheeze_value value
	 */
	public void setWheezeValue (java.lang.String wheezeValue) {
		this.wheezeValue = wheezeValue;
	}



	/**
	 * Return the value associated with the column: other_adventitious_sounds
	 */
	public java.lang.String getOtherAdventitiousSounds () {
		return otherAdventitiousSounds;
	}

	/**
	 * Set the value related to the column: other_adventitious_sounds
	 * @param otherAdventitiousSounds the other_adventitious_sounds value
	 */
	public void setOtherAdventitiousSounds (java.lang.String otherAdventitiousSounds) {
		this.otherAdventitiousSounds = otherAdventitiousSounds;
	}



	/**
	 * Return the value associated with the column: abdomen
	 */
	public java.lang.String getAbdomen () {
		return abdomen;
	}

	/**
	 * Set the value related to the column: abdomen
	 * @param abdomen the abdomen value
	 */
	public void setAbdomen (java.lang.String abdomen) {
		this.abdomen = abdomen;
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
	 * Return the value associated with the column: allergy_skin_test
	 */
	public java.lang.String getAllergySkinTest () {
		return allergySkinTest;
	}

	/**
	 * Set the value related to the column: allergy_skin_test
	 * @param allergySkinTest the allergy_skin_test value
	 */
	public void setAllergySkinTest (java.lang.String allergySkinTest) {
		this.allergySkinTest = allergySkinTest;
	}



	/**
	 * Return the value associated with the column: asthma_education
	 */
	public java.lang.String getAsthmaEducation () {
		return asthmaEducation;
	}

	/**
	 * Set the value related to the column: asthma_education
	 * @param asthmaEducation the asthma_education value
	 */
	public void setAsthmaEducation (java.lang.String asthmaEducation) {
		this.asthmaEducation = asthmaEducation;
	}



	/**
	 * Return the value associated with the column: action_plan
	 */
	public java.lang.String getActionPlan () {
		return actionPlan;
	}

	/**
	 * Set the value related to the column: action_plan
	 * @param actionPlan the action_plan value
	 */
	public void setActionPlan (java.lang.String actionPlan) {
		this.actionPlan = actionPlan;
	}



	/**
	 * Return the value associated with the column: asthma_diary
	 */
	public java.lang.String getAsthmaDiary () {
		return asthmaDiary;
	}

	/**
	 * Set the value related to the column: asthma_diary
	 * @param asthmaDiary the asthma_diary value
	 */
	public void setAsthmaDiary (java.lang.String asthmaDiary) {
		this.asthmaDiary = asthmaDiary;
	}



	/**
	 * Return the value associated with the column: triggers_value
	 */
	public java.lang.String getTriggersValue () {
		return triggersValue;
	}

	/**
	 * Set the value related to the column: triggers_value
	 * @param triggersValue the triggers_value value
	 */
	public void setTriggersValue (java.lang.String triggersValue) {
		this.triggersValue = triggersValue;
	}



	/**
	 * Return the value associated with the column: age_of_onset_of_symptoms
	 */
	public java.lang.String getAgeOfOnsetOfSymptoms () {
		return ageOfOnsetOfSymptoms;
	}

	/**
	 * Set the value related to the column: age_of_onset_of_symptoms
	 * @param ageOfOnsetOfSymptoms the age_of_onset_of_symptoms value
	 */
	public void setAgeOfOnsetOfSymptoms (java.lang.String ageOfOnsetOfSymptoms) {
		this.ageOfOnsetOfSymptoms = ageOfOnsetOfSymptoms;
	}



	/**
	 * Return the value associated with the column: past_history_value
	 */
	public java.lang.String getPastHistoryValue () {
		return pastHistoryValue;
	}

	/**
	 * Set the value related to the column: past_history_value
	 * @param pastHistoryValue the past_history_value value
	 */
	public void setPastHistoryValue (java.lang.String pastHistoryValue) {
		this.pastHistoryValue = pastHistoryValue;
	}



	/**
	 * Return the value associated with the column: severity_at_diagnosis
	 */
	public java.lang.String getSeverityAtDiagnosis () {
		return severityAtDiagnosis;
	}

	/**
	 * Set the value related to the column: severity_at_diagnosis
	 * @param severityAtDiagnosis the severity_at_diagnosis value
	 */
	public void setSeverityAtDiagnosis (java.lang.String severityAtDiagnosis) {
		this.severityAtDiagnosis = severityAtDiagnosis;
	}



	/**
	 * Return the value associated with the column: interval_since_last_visit
	 */
	public java.lang.String getIntervalSinceLastVisit () {
		return intervalSinceLastVisit;
	}

	/**
	 * Set the value related to the column: interval_since_last_visit
	 * @param intervalSinceLastVisit the interval_since_last_visit value
	 */
	public void setIntervalSinceLastVisit (java.lang.String intervalSinceLastVisit) {
		this.intervalSinceLastVisit = intervalSinceLastVisit;
	}



	/**
	 * Return the value associated with the column: symtoms
	 */
	public java.lang.String getSymtoms () {
		return symtoms;
	}

	/**
	 * Set the value related to the column: symtoms
	 * @param symtoms the symtoms value
	 */
	public void setSymtoms (java.lang.String symtoms) {
		this.symtoms = symtoms;
	}



	/**
	 * Return the value associated with the column: current_symptoms
	 */
	public java.lang.String getCurrentSymptoms () {
		return currentSymptoms;
	}

	/**
	 * Set the value related to the column: current_symptoms
	 * @param currentSymptoms the current_symptoms value
	 */
	public void setCurrentSymptoms (java.lang.String currentSymptoms) {
		this.currentSymptoms = currentSymptoms;
	}



	/**
	 * Return the value associated with the column: no_of_exacerbations
	 */
	public java.lang.String getNoOfExacerbations () {
		return noOfExacerbations;
	}

	/**
	 * Set the value related to the column: no_of_exacerbations
	 * @param noOfExacerbations the no_of_exacerbations value
	 */
	public void setNoOfExacerbations (java.lang.String noOfExacerbations) {
		this.noOfExacerbations = noOfExacerbations;
	}



	/**
	 * Return the value associated with the column: hospital_admissions_followup
	 */
	public java.lang.String getHospitalAdmissionsFollowup () {
		return hospitalAdmissionsFollowup;
	}

	/**
	 * Set the value related to the column: hospital_admissions_followup
	 * @param hospitalAdmissionsFollowup the hospital_admissions_followup value
	 */
	public void setHospitalAdmissionsFollowup (java.lang.String hospitalAdmissionsFollowup) {
		this.hospitalAdmissionsFollowup = hospitalAdmissionsFollowup;
	}



	/**
	 * Return the value associated with the column: check_inhaler_technique
	 */
	public java.lang.String getCheckInhalerTechnique () {
		return checkInhalerTechnique;
	}

	/**
	 * Set the value related to the column: check_inhaler_technique
	 * @param checkInhalerTechnique the check_inhaler_technique value
	 */
	public void setCheckInhalerTechnique (java.lang.String checkInhalerTechnique) {
		this.checkInhalerTechnique = checkInhalerTechnique;
	}



	/**
	 * Return the value associated with the column: adherence_to_treatment_plan
	 */
	public java.lang.String getAdherenceToTreatmentPlan () {
		return adherenceToTreatmentPlan;
	}

	/**
	 * Set the value related to the column: adherence_to_treatment_plan
	 * @param adherenceToTreatmentPlan the adherence_to_treatment_plan value
	 */
	public void setAdherenceToTreatmentPlan (java.lang.String adherenceToTreatmentPlan) {
		this.adherenceToTreatmentPlan = adherenceToTreatmentPlan;
	}



	/**
	 * Return the value associated with the column: asthma_diary_followup
	 */
	public java.lang.String getAsthmaDiaryFollowup () {
		return asthmaDiaryFollowup;
	}

	/**
	 * Set the value related to the column: asthma_diary_followup
	 * @param asthmaDiaryFollowup the asthma_diary_followup value
	 */
	public void setAsthmaDiaryFollowup (java.lang.String asthmaDiaryFollowup) {
		this.asthmaDiaryFollowup = asthmaDiaryFollowup;
	}



	/**
	 * Return the value associated with the column: heart_rate
	 */
	public java.lang.String getHeartRate () {
		return heartRate;
	}

	/**
	 * Set the value related to the column: heart_rate
	 * @param heartRate the heart_rate value
	 */
	public void setHeartRate (java.lang.String heartRate) {
		this.heartRate = heartRate;
	}



	/**
	 * Return the value associated with the column: cineses
	 */
	public java.lang.String getCineses () {
		return cineses;
	}

	/**
	 * Set the value related to the column: cineses
	 * @param cineses the cineses value
	 */
	public void setCineses (java.lang.String cineses) {
		this.cineses = cineses;
	}



	/**
	 * Return the value associated with the column: oral_steroid_use
	 */
	public java.lang.String getOralSteroidUse () {
		return oralSteroidUse;
	}

	/**
	 * Set the value related to the column: oral_steroid_use
	 * @param oralSteroidUse the oral_steroid_use value
	 */
	public void setOralSteroidUse (java.lang.String oralSteroidUse) {
		this.oralSteroidUse = oralSteroidUse;
	}



	/**
	 * Return the value associated with the column: physical_activities
	 */
	public java.lang.String getPhysicalActivities () {
		return physicalActivities;
	}

	/**
	 * Set the value related to the column: physical_activities
	 * @param physicalActivities the physical_activities value
	 */
	public void setPhysicalActivities (java.lang.String physicalActivities) {
		this.physicalActivities = physicalActivities;
	}



	/**
	 * Return the value associated with the column: partial_value
	 */
	public java.lang.String getPartialValue () {
		return partialValue;
	}

	/**
	 * Set the value related to the column: partial_value
	 * @param partialValue the partial_value value
	 */
	public void setPartialValue (java.lang.String partialValue) {
		this.partialValue = partialValue;
	}



	/**
	 * Return the value associated with the column: opd_patient_details
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details
	 * @param opdPatientDetails the opd_patient_details value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdRespiratorySpecialityHeader)) return false;
		else {
			jkt.hms.masters.business.OpdRespiratorySpecialityHeader opdRespiratorySpecialityHeader = (jkt.hms.masters.business.OpdRespiratorySpecialityHeader) obj;
			if (null == this.getId() || null == opdRespiratorySpecialityHeader.getId()) return false;
			else return (this.getId().equals(opdRespiratorySpecialityHeader.getId()));
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