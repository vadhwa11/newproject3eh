package jkt.hms.masters.business.base;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jkt.hms.masters.business.ExternalLabReportCommon;


/**
 * This is an object that contains data related to the ot_pre_anesthesia_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_pre_anesthesia_details"
 */

public abstract class BaseOtPreAnesthesiaDetails  implements Serializable {

	public static String REF = "OtPreAnesthesiaDetails";
	public static String PROP_S2 = "S2";
	public static String PROP_S1 = "S1";
	public static String PROP_BED_ARRANGEMENT = "BedArrangement";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_CARE_OF = "CareOf";
	public static String PROP_CYANOSIS = "Cyanosis";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_PENDING_DOC = "PendingDoc";
	public static String PROP_NOURISHMENT = "Nourishment";
	public static String PROP_ANASHTEIC_DETAILS = "AnashteicDetails";
	public static String PROP_ABDOMEN = "Abdomen";
	public static String PROP_OEDEMA = "Oedema";
	public static String PROP_CHANGED_TIME = "ChangedTime";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BED_FLAG = "BedFlag";
	public static String PROP_THYROID = "Thyroid";
	public static String PROP_HAIR_PIN = "HairPin";
	public static String PROP_ICETRUS = "Icetrus";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_DIET_CATEGORY = "DietCategory";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SMOKING_ALCOHOL = "SmokingAlcohol";
	public static String PROP_ADV_SOUND = "AdvSound";
	public static String PROP_SUMMARY = "Summary";
	public static String PROP_CONSENT_STATUS = "ConsentStatus";
	public static String PROP_INSTRUCTIONS = "Instructions";
	public static String PROP_ID = "Id";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_ASA_GRADE = "AsaGrade";
	public static String PROP_ANESTHETIC = "Anesthetic";
	public static String PROP_JEWEL_STATUS = "JewelStatus";
	public static String PROP_WARD = "Ward";
	public static String PROP_BREATH_SOUND = "BreathSound";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PRE_OPERATIVE_STATUS = "PreOperativeStatus";
	public static String PROP_CLUBBING = "Clubbing";
	public static String PROP_UNIT = "Unit";
	public static String PROP_REMARKS_BED_ARRANGEMENT = "RemarksBedArrangement";
	public static String PROP_FIT_FOR_SURGERY = "FitForSurgery";
	public static String PROP_AIRWAY = "Airway";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_PREV_TREATMENT_SURGERY = "PrevTreatmentSurgery";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_ANESTHTIC_TECHNIQUE = "AnesthticTechnique";
	public static String PROP_SPLEEN = "Spleen";
	public static String PROP_PATIENT_POSITION = "PatientPosition";
	public static String PROP_CHANGED_DATE = "ChangedDate";
	public static String PROP_S3 = "S3";
	public static String PROP_DRUG_TREATMENT = "DrugTreatment";
	public static String PROP_BLOOD = "Blood";
	public static String PROP_S4 = "S4";
	public static String PROP_VENOUS_ACCESS = "VenousAccess";
	public static String PROP_SPINE = "Spine";
	public static String PROP_PALLOR = "Pallor";
	public static String PROP_LIVER = "Liver";
	public static String PROP_BP = "Bp";
	public static String PROP_PAC_DATE = "PacDate";
	public static String PROP_HIN = "Hin";
	
	
	public static String PROP_ALLERGY = "Allergy";
	public static String PROP_DIABETES = "Diabetes";
	public static String PROP_PSYCHIATRICILLNESS = "PsychiatricIllness";
	public static String PROP_MENSTRUATION = "Menstruation";
	public static String PROP_ASTHMA = "Asthma";
	public static String PROP_EPILEPSY = "Epilepsy";
	public static String PROP_TUBERCULOSIS = "Tuberculosis";
	public static String PROP_CHILD_BIRTH = "ChildBirth";
	public static String PROP_CHEST_PAIN = "ChestPain";
	public static String PROP_EXERCISEINTOLERANCE = "ExerciseIntolerance";
	public static String PROP_PREVIOUS_SURGERIES = "PreviousSurgeries";
	public static String PROP_SMOKING = "Smoking";
	public static String PROP_COUGH = "Cough";
	public static String PROP_HYPERTENSION = "Hypertension";
	public static String PROP_PREVIOUS_ANESTHETIC = "PreviousAnesthetic";
	public static String PROP_ALCOHOLISM = "Alcoholism";
	public static String PROP_DYSPNOEA = "Dyspnoea";
	public static String PROP_HEARTDISEASE = "HeartDisease";
	public static String PROP_GENERAL_ANESTHESIA = "GeneralAnesthesia";
	public static String PROP_DENTURES = "Dentures";
	public static String PROP_DYSPHAGIA = "Dysphagia";
	public static String PROP_HOARSENESS = "Hoarseness";
	public static String PROP_SPINAL_ANESTHESIA = "SpinalAnesthesia";
	public static String PROP_CONTACTLENS = "ContactLens";
	public static String PROP_DYSPEPSIA = "Dyspepsia";
	public static String PROP_IHD = "Ihd";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_HEARINGAIDS = "HearingAids";
	public static String PROP_ACID_PEPTIC_DISORDERS = "AcidPepticDisorders";
	public static String PROP_JAUNDICE = "Jaundice";
	public static String PROP_PONV = "Ponv";
	public static String PROP_HISTORYREMARKS = "HistoryRemarks";
	public static String PROP_ANTIALLEGERIC = "Antiallegeric";
	public static String PROP_CEBS = "Cebs";
	public static String PROP_ANTIPLATELETS = "Antiplatelets";
	
	
	
	public static String PROP_ANTIHYPERTENSIVES = "Antihypertensives";
	public static String PROP_ANTIANGINALS = "Antianginals";
	public static String PROP_ANTITUBERCULOUS = "Antituberculous";
	public static String PROP_ANTIASTHMATICS = "Antiasthmatics";
	public static String PROP_ANTIDIABETICS = "Antidiabetics";
	public static String PROP_ANTIMALIGNANCY = "Antimalignancy";
	public static String PROP_DIURETICS = "Diuretics";
	public static String PROP_ANTIEPILEPTICS = "Antiepileptics";
	public static String PROP_ANTITHYROID = "Antithyroid";
	public static String PROP_DIGOXIN = "Digoxin";
	public static String PROP_ANTIPSYCHOTICS = "Antipsychotics";
	public static String PROP_ANTACID = "Antacid";
	public static String PROP_BETA_BLOCKERS = "BetaBlockers";
	public static String PROP_STEROIDS = "Steroids";
	public static String PROP_H2_BLOCKERS = "H2Blockers";
	public static String PROP_DRUG_HISTORY_OTHERS = "DrugHistoryOthers";
	public static String PROP_DRUG_HISTORY_REMARKS = "DrugHistoryRemarks";
	public static String PROP_MOUTH_OPENING = "MouthOpening";
	public static String PROP_TMJ = "Tmj";
	public static String PROP_NECK_MOVEMENTS = "NeckMovements";
	public static String PROP_TOOTH = "Tooth";
	public static String PROP_MALLAMPATTI_CLASS = "MallampattiClass";
	public static String PROP_ALLENS_TEST = "AllensTest";
	public static String PROP_RESPIRATORY_SYSTEM = "RespiratorySystem";
	public static String PROP_TRACHEA = "Trachea";
	public static String PROP_LUNGS = "Lungs";
	public static String PROP_CARDIO_VASCULAR_SYSTEM = "CardioVascularSystem";
	public static String PROP_CENTRAL_NERVOUS_SYSTEM = "CentralNervousSystem";
	public static String PROP_GASTROINTESTINAL_SYSTEM = "GastrointestinalSystem";
	public static String PROP_PHYSICALEXAMINATION = "PhysicalExamination";
	public static String PROP_AAC_ACCEPTANCE = "AacAcceptance";
	

	// constructors
	public BaseOtPreAnesthesiaDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPreAnesthesiaDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String abdomen;
	private java.lang.String advSound;
	private java.lang.String airway;
	private java.lang.String anashteicDetails;
	private java.lang.String anesthticTechnique;
	private java.lang.String asaGrade;
	private java.lang.String bedArrangement;
	private java.lang.String bedFlag;
	private java.lang.String blood;
	private java.lang.String bp;
	private java.lang.String breathSound;
	private java.lang.String careOf;
	private java.util.Date changedDate;
	private java.lang.String changedTime;
	private java.lang.String clubbing;
	private java.lang.String consentStatus;
	private java.lang.String cyanosis;
	private java.lang.String dietCategory;
	private java.lang.String drugTreatment;
	private java.lang.String fitForSurgery;
	private java.lang.Integer hairPin;
	private java.lang.String icetrus;
	private java.lang.String instructions;
	private java.lang.Integer jewelStatus;
	private java.lang.String liver;
	private java.lang.String nourishment;
	private java.lang.String oedema;
	private java.lang.Integer orderNo;
	private java.util.Date pacDate;
	private java.lang.String pallor;
	private java.lang.String patientPosition;
	private java.lang.String patientType;
	private java.lang.String preOperativeStatus;
	private java.lang.String prevTreatmentSurgery;
	private java.lang.String pulse;
	private java.lang.String remarks;
	private java.lang.String remarksBedArrangement;
	private java.lang.String s1;
	private java.lang.String s2;
	private java.lang.String s3;
	private java.lang.String s4;
	private java.lang.String smokingAlcohol;
	private java.lang.String spine;
	private java.lang.String spleen;
	private java.lang.String summary;
	private java.lang.String thyroid;
	private java.lang.Integer unit;
	private java.lang.String venousAccess;
	
	private java.lang.String allergy;
	private java.lang.String diabetes;
	private java.lang.String psychiatricIllness;
	private java.lang.String menstruation;
	private java.lang.String asthma;
	private java.lang.String epilepsy;
	private java.lang.String tuberculosis;
	private java.lang.String childBirth;
	private java.lang.String chestPain;
	private java.lang.String exerciseIntolerance;
	private java.lang.String previousSurgeries;
	private java.lang.String smoking;
	private java.lang.String cough;
	private java.lang.String hypertension;
	private java.lang.String previousAnesthetic;
	private java.lang.String alcoholism;
	private java.lang.String dyspnoea;
	private java.lang.String heartDisease;
	private java.lang.String generalAnesthesia;
	private java.lang.String dentures;
	private java.lang.String dysphagia;
	private java.lang.String hoarseness;
	private java.lang.String spinalAnesthesia;
	private java.lang.String contactLens;
	private java.lang.String dyspepsia;
	private java.lang.String ihd;
	private java.lang.String complications;
	private java.lang.String hearingAids;
	private java.lang.String acidPepticDisorders;
	private java.lang.String jaundice;
	private java.lang.String ponv;
	private java.lang.String historyRemarks;
	private java.lang.String antiallegeric;
	private java.lang.String cebs;
	private java.lang.String antiplatelets;
	private java.lang.String antihypertensives;
	private java.lang.String antianginals;
	private java.lang.String antituberculous;
	private java.lang.String antiasthmatics;
	private java.lang.String antidiabetics;
	private java.lang.String antimalignancy;
	private java.lang.String diuretics;
	private java.lang.String antiepileptics;
	private java.lang.String antithyroid;
	private java.lang.String digoxin;
	private java.lang.String antipsychotics;
	private java.lang.String antacid;
	private java.lang.String betaBlockers;
	private java.lang.String steroids;
	private java.lang.String h2Blockers;
	private java.lang.String drugHistoryOthers;
	private java.lang.String drugHistoryRemarks;
	private java.lang.String mouthOpening;
	private java.lang.String tmj;
	private java.lang.String neckMovements;
	private java.lang.String tooth;
	private java.lang.String mallampattiClass;
	private java.lang.String allensTest;
	private java.lang.String respiratorySystem;
	private java.lang.String trachea;
	private java.lang.String lungs;
	private java.lang.String cardioVascularSystem;
	private java.lang.String centralNervousSystem;
	private java.lang.String gastrointestinalSystem;
	private java.lang.String physicalExamination;

	// many to one
	private jkt.hms.masters.business.MasEmployee anesthetic;
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee pendingDoc;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment ward;
	
	private jkt.hms.masters.business.AacAcceptance aacAcceptance;
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: adv_sound
	 */
	public java.lang.String getAdvSound () {
		return advSound;
	}

	/**
	 * Set the value related to the column: adv_sound
	 * @param advSound the adv_sound value
	 */
	public void setAdvSound (java.lang.String advSound) {
		this.advSound = advSound;
	}



	/**
	 * Return the value associated with the column: airway
	 */
	public java.lang.String getAirway () {
		return airway;
	}

	/**
	 * Set the value related to the column: airway
	 * @param airway the airway value
	 */
	public void setAirway (java.lang.String airway) {
		this.airway = airway;
	}



	/**
	 * Return the value associated with the column: anashteic_details
	 */
	public java.lang.String getAnashteicDetails () {
		return anashteicDetails;
	}

	/**
	 * Set the value related to the column: anashteic_details
	 * @param anashteicDetails the anashteic_details value
	 */
	public void setAnashteicDetails (java.lang.String anashteicDetails) {
		this.anashteicDetails = anashteicDetails;
	}



	/**
	 * Return the value associated with the column: anesthtic_technique
	 */
	public java.lang.String getAnesthticTechnique () {
		return anesthticTechnique;
	}

	/**
	 * Set the value related to the column: anesthtic_technique
	 * @param anesthticTechnique the anesthtic_technique value
	 */
	public void setAnesthticTechnique (java.lang.String anesthticTechnique) {
		this.anesthticTechnique = anesthticTechnique;
	}



	/**
	 * Return the value associated with the column: asa_grade
	 */
	public java.lang.String getAsaGrade () {
		return asaGrade;
	}

	/**
	 * Set the value related to the column: asa_grade
	 * @param asaGrade the asa_grade value
	 */
	public void setAsaGrade (java.lang.String asaGrade) {
		this.asaGrade = asaGrade;
	}



	/**
	 * Return the value associated with the column: bed_arrangement
	 */
	public java.lang.String getBedArrangement () {
		return bedArrangement;
	}

	/**
	 * Set the value related to the column: bed_arrangement
	 * @param bedArrangement the bed_arrangement value
	 */
	public void setBedArrangement (java.lang.String bedArrangement) {
		this.bedArrangement = bedArrangement;
	}



	/**
	 * Return the value associated with the column: bed_flag
	 */
	public java.lang.String getBedFlag () {
		return bedFlag;
	}

	/**
	 * Set the value related to the column: bed_flag
	 * @param bedFlag the bed_flag value
	 */
	public void setBedFlag (java.lang.String bedFlag) {
		this.bedFlag = bedFlag;
	}



	/**
	 * Return the value associated with the column: blood
	 */
	public java.lang.String getBlood () {
		return blood;
	}

	/**
	 * Set the value related to the column: blood
	 * @param blood the blood value
	 */
	public void setBlood (java.lang.String blood) {
		this.blood = blood;
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
	 * Return the value associated with the column: breath_sound
	 */
	public java.lang.String getBreathSound () {
		return breathSound;
	}

	/**
	 * Set the value related to the column: breath_sound
	 * @param breathSound the breath_sound value
	 */
	public void setBreathSound (java.lang.String breathSound) {
		this.breathSound = breathSound;
	}



	/**
	 * Return the value associated with the column: care_of
	 */
	public java.lang.String getCareOf () {
		return careOf;
	}

	/**
	 * Set the value related to the column: care_of
	 * @param careOf the care_of value
	 */
	public void setCareOf (java.lang.String careOf) {
		this.careOf = careOf;
	}



	/**
	 * Return the value associated with the column: changed_date
	 */
	public java.util.Date getChangedDate () {
		return changedDate;
	}

	/**
	 * Set the value related to the column: changed_date
	 * @param changedDate the changed_date value
	 */
	public void setChangedDate (java.util.Date changedDate) {
		this.changedDate = changedDate;
	}



	/**
	 * Return the value associated with the column: changed_time
	 */
	public java.lang.String getChangedTime () {
		return changedTime;
	}

	/**
	 * Set the value related to the column: changed_time
	 * @param changedTime the changed_time value
	 */
	public void setChangedTime (java.lang.String changedTime) {
		this.changedTime = changedTime;
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
	 * Return the value associated with the column: consent_status
	 */
	public java.lang.String getConsentStatus () {
		return consentStatus;
	}

	/**
	 * Set the value related to the column: consent_status
	 * @param consentStatus the consent_status value
	 */
	public void setConsentStatus (java.lang.String consentStatus) {
		this.consentStatus = consentStatus;
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
	 * Return the value associated with the column: diet_category
	 */
	public java.lang.String getDietCategory () {
		return dietCategory;
	}

	/**
	 * Set the value related to the column: diet_category
	 * @param dietCategory the diet_category value
	 */
	public void setDietCategory (java.lang.String dietCategory) {
		this.dietCategory = dietCategory;
	}



	/**
	 * Return the value associated with the column: drug_treatment
	 */
	public java.lang.String getDrugTreatment () {
		return drugTreatment;
	}

	/**
	 * Set the value related to the column: drug_treatment
	 * @param drugTreatment the drug_treatment value
	 */
	public void setDrugTreatment (java.lang.String drugTreatment) {
		this.drugTreatment = drugTreatment;
	}



	/**
	 * Return the value associated with the column: fit_for_surgery
	 */
	public java.lang.String getFitForSurgery () {
		return fitForSurgery;
	}

	/**
	 * Set the value related to the column: fit_for_surgery
	 * @param fitForSurgery the fit_for_surgery value
	 */
	public void setFitForSurgery (java.lang.String fitForSurgery) {
		this.fitForSurgery = fitForSurgery;
	}



	/**
	 * Return the value associated with the column: hair_pin
	 */
	public java.lang.Integer getHairPin () {
		return hairPin;
	}

	/**
	 * Set the value related to the column: hair_pin
	 * @param hairPin the hair_pin value
	 */
	public void setHairPin (java.lang.Integer hairPin) {
		this.hairPin = hairPin;
	}



	/**
	 * Return the value associated with the column: icetrus
	 */
	public java.lang.String getIcetrus () {
		return icetrus;
	}

	/**
	 * Set the value related to the column: icetrus
	 * @param icetrus the icetrus value
	 */
	public void setIcetrus (java.lang.String icetrus) {
		this.icetrus = icetrus;
	}



	/**
	 * Return the value associated with the column: instructions
	 */
	public java.lang.String getInstructions () {
		return instructions;
	}

	/**
	 * Set the value related to the column: instructions
	 * @param instructions the instructions value
	 */
	public void setInstructions (java.lang.String instructions) {
		this.instructions = instructions;
	}



	/**
	 * Return the value associated with the column: jewel_status
	 */
	public java.lang.Integer getJewelStatus () {
		return jewelStatus;
	}

	/**
	 * Set the value related to the column: jewel_status
	 * @param jewelStatus the jewel_status value
	 */
	public void setJewelStatus (java.lang.Integer jewelStatus) {
		this.jewelStatus = jewelStatus;
	}



	/**
	 * Return the value associated with the column: liver
	 */
	public java.lang.String getLiver () {
		return liver;
	}

	/**
	 * Set the value related to the column: liver
	 * @param liver the liver value
	 */
	public void setLiver (java.lang.String liver) {
		this.liver = liver;
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
	 * Return the value associated with the column: oedema
	 */
	public java.lang.String getOedema () {
		return oedema;
	}

	/**
	 * Set the value related to the column: oedema
	 * @param oedema the oedema value
	 */
	public void setOedema (java.lang.String oedema) {
		this.oedema = oedema;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: pac_date
	 */
	public java.util.Date getPacDate () {
		return pacDate;
	}

	/**
	 * Set the value related to the column: pac_date
	 * @param pacDate the pac_date value
	 */
	public void setPacDate (java.util.Date pacDate) {
		this.pacDate = pacDate;
	}



	/**
	 * Return the value associated with the column: pallor
	 */
	public java.lang.String getPallor () {
		return pallor;
	}

	/**
	 * Set the value related to the column: pallor
	 * @param pallor the pallor value
	 */
	public void setPallor (java.lang.String pallor) {
		this.pallor = pallor;
	}



	/**
	 * Return the value associated with the column: patient_position
	 */
	public java.lang.String getPatientPosition () {
		return patientPosition;
	}

	/**
	 * Set the value related to the column: patient_position
	 * @param patientPosition the patient_position value
	 */
	public void setPatientPosition (java.lang.String patientPosition) {
		this.patientPosition = patientPosition;
	}



	/**
	 * Return the value associated with the column: patient_type
	 */
	public java.lang.String getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type
	 * @param patientType the patient_type value
	 */
	public void setPatientType (java.lang.String patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: pre_operative_status
	 */
	public java.lang.String getPreOperativeStatus () {
		return preOperativeStatus;
	}

	/**
	 * Set the value related to the column: pre_operative_status
	 * @param preOperativeStatus the pre_operative_status value
	 */
	public void setPreOperativeStatus (java.lang.String preOperativeStatus) {
		this.preOperativeStatus = preOperativeStatus;
	}



	/**
	 * Return the value associated with the column: prev_treatment_surgery
	 */
	public java.lang.String getPrevTreatmentSurgery () {
		return prevTreatmentSurgery;
	}

	/**
	 * Set the value related to the column: prev_treatment_surgery
	 * @param prevTreatmentSurgery the prev_treatment_surgery value
	 */
	public void setPrevTreatmentSurgery (java.lang.String prevTreatmentSurgery) {
		this.prevTreatmentSurgery = prevTreatmentSurgery;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.String getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.String pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: remarks_bed_arrangement
	 */
	public java.lang.String getRemarksBedArrangement () {
		return remarksBedArrangement;
	}

	/**
	 * Set the value related to the column: remarks_bed_arrangement
	 * @param remarksBedArrangement the remarks_bed_arrangement value
	 */
	public void setRemarksBedArrangement (java.lang.String remarksBedArrangement) {
		this.remarksBedArrangement = remarksBedArrangement;
	}



	/**
	 * Return the value associated with the column: s1
	 */
	public java.lang.String getS1 () {
		return s1;
	}

	/**
	 * Set the value related to the column: s1
	 * @param s1 the s1 value
	 */
	public void setS1 (java.lang.String s1) {
		this.s1 = s1;
	}



	/**
	 * Return the value associated with the column: s2
	 */
	public java.lang.String getS2 () {
		return s2;
	}

	/**
	 * Set the value related to the column: s2
	 * @param s2 the s2 value
	 */
	public void setS2 (java.lang.String s2) {
		this.s2 = s2;
	}



	/**
	 * Return the value associated with the column: s3
	 */
	public java.lang.String getS3 () {
		return s3;
	}

	/**
	 * Set the value related to the column: s3
	 * @param s3 the s3 value
	 */
	public void setS3 (java.lang.String s3) {
		this.s3 = s3;
	}



	/**
	 * Return the value associated with the column: s4
	 */
	public java.lang.String getS4 () {
		return s4;
	}

	/**
	 * Set the value related to the column: s4
	 * @param s4 the s4 value
	 */
	public void setS4 (java.lang.String s4) {
		this.s4 = s4;
	}



	/**
	 * Return the value associated with the column: smoking_alcohol
	 */
	public java.lang.String getSmokingAlcohol () {
		return smokingAlcohol;
	}

	/**
	 * Set the value related to the column: smoking_alcohol
	 * @param smokingAlcohol the smoking_alcohol value
	 */
	public void setSmokingAlcohol (java.lang.String smokingAlcohol) {
		this.smokingAlcohol = smokingAlcohol;
	}



	/**
	 * Return the value associated with the column: spine
	 */
	public java.lang.String getSpine () {
		return spine;
	}

	/**
	 * Set the value related to the column: spine
	 * @param spine the spine value
	 */
	public void setSpine (java.lang.String spine) {
		this.spine = spine;
	}



	/**
	 * Return the value associated with the column: spleen
	 */
	public java.lang.String getSpleen () {
		return spleen;
	}

	/**
	 * Set the value related to the column: spleen
	 * @param spleen the spleen value
	 */
	public void setSpleen (java.lang.String spleen) {
		this.spleen = spleen;
	}



	/**
	 * Return the value associated with the column: summary
	 */
	public java.lang.String getSummary () {
		return summary;
	}

	/**
	 * Set the value related to the column: summary
	 * @param summary the summary value
	 */
	public void setSummary (java.lang.String summary) {
		this.summary = summary;
	}



	/**
	 * Return the value associated with the column: thyroid
	 */
	public java.lang.String getThyroid () {
		return thyroid;
	}

	/**
	 * Set the value related to the column: thyroid
	 * @param thyroid the thyroid value
	 */
	public void setThyroid (java.lang.String thyroid) {
		this.thyroid = thyroid;
	}



	/**
	 * Return the value associated with the column: unit
	 */
	public java.lang.Integer getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit
	 * @param unit the unit value
	 */
	public void setUnit (java.lang.Integer unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: venous_access
	 */
	public java.lang.String getVenousAccess () {
		return venousAccess;
	}

	/**
	 * Set the value related to the column: venous_access
	 * @param venousAccess the venous_access value
	 */
	public void setVenousAccess (java.lang.String venousAccess) {
		this.venousAccess = venousAccess;
	}

    

	public java.lang.String getAllergy() {
		return allergy;
	}

	public void setAllergy(java.lang.String allergy) {
		this.allergy = allergy;
	}

	public java.lang.String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(java.lang.String diabetes) {
		this.diabetes = diabetes;
	}

	public java.lang.String getPsychiatricIllness() {
		return psychiatricIllness;
	}

	public void setPsychiatricIllness(java.lang.String psychiatricIllness) {
		this.psychiatricIllness = psychiatricIllness;
	}

	public java.lang.String getMenstruation() {
		return menstruation;
	}

	public void setMenstruation(java.lang.String menstruation) {
		this.menstruation = menstruation;
	}

	public java.lang.String getAsthma() {
		return asthma;
	}

	public void setAsthma(java.lang.String asthma) {
		this.asthma = asthma;
	}

	public java.lang.String getEpilepsy() {
		return epilepsy;
	}

	public void setEpilepsy(java.lang.String epilepsy) {
		this.epilepsy = epilepsy;
	}

	public java.lang.String getTuberculosis() {
		return tuberculosis;
	}

	public void setTuberculosis(java.lang.String tuberculosis) {
		this.tuberculosis = tuberculosis;
	}

	public java.lang.String getChildBirth() {
		return childBirth;
	}

	public void setChildBirth(java.lang.String childBirth) {
		this.childBirth = childBirth;
	}

	public java.lang.String getChestPain() {
		return chestPain;
	}

	public void setChestPain(java.lang.String chestPain) {
		this.chestPain = chestPain;
	}

	public java.lang.String getExerciseIntolerance() {
		return exerciseIntolerance;
	}

	public void setExerciseIntolerance(java.lang.String exerciseIntolerance) {
		this.exerciseIntolerance = exerciseIntolerance;
	}

	public java.lang.String getPreviousSurgeries() {
		return previousSurgeries;
	}

	public void setPreviousSurgeries(java.lang.String previousSurgeries) {
		this.previousSurgeries = previousSurgeries;
	}

	public java.lang.String getSmoking() {
		return smoking;
	}

	public void setSmoking(java.lang.String smoking) {
		this.smoking = smoking;
	}

	public java.lang.String getCough() {
		return cough;
	}

	public void setCough(java.lang.String cough) {
		this.cough = cough;
	}

	public java.lang.String getHypertension() {
		return hypertension;
	}

	public void setHypertension(java.lang.String hypertension) {
		this.hypertension = hypertension;
	}

	public java.lang.String getPreviousAnesthetic() {
		return previousAnesthetic;
	}

	public void setPreviousAnesthetic(java.lang.String previousAnesthetic) { 
		this.previousAnesthetic = previousAnesthetic;
	}

	public java.lang.String getAlcoholism() {
		return alcoholism;
	}

	public void setAlcoholism(java.lang.String alcoholism) {
		this.alcoholism = alcoholism;
	}

	public java.lang.String getDyspnoea() {
		return dyspnoea;
	}

	public void setDyspnoea(java.lang.String dyspnoea) {
		this.dyspnoea = dyspnoea;
	}

	public java.lang.String getHeartDisease() {
		return heartDisease;
	}

	public void setHeartDisease(java.lang.String heartDisease) {
		this.heartDisease = heartDisease;
	}

	public java.lang.String getGeneralAnesthesia() {
		return generalAnesthesia;
	}

	public void setGeneralAnesthesia(java.lang.String generalAnesthesia) {
		this.generalAnesthesia = generalAnesthesia;
	}

	public java.lang.String getDentures() {
		return dentures;
	}

	public void setDentures(java.lang.String dentures) {
		this.dentures = dentures;
	}

	public java.lang.String getDysphagia() {
		return dysphagia;
	}

	public void setDysphagia(java.lang.String dysphagia) {
		this.dysphagia = dysphagia;
	}

	public java.lang.String getHoarseness() {
		return hoarseness;
	}

	public void setHoarseness(java.lang.String hoarseness) {
		this.hoarseness = hoarseness;
	}

	public java.lang.String getSpinalAnesthesia() {
		return spinalAnesthesia;
	}

	public void setSpinalAnesthesia(java.lang.String spinalAnesthesia) {
		this.spinalAnesthesia = spinalAnesthesia;
	}

	public java.lang.String getContactLens() {
		return contactLens;
	}

	public void setContactLens(java.lang.String contactLens) {
		this.contactLens = contactLens;
	}

	public java.lang.String getDyspepsia() {
		return dyspepsia;
	}

	public void setDyspepsia(java.lang.String dyspepsia) {
		this.dyspepsia = dyspepsia;
	}

	public java.lang.String getIhd() {
		return ihd;
	}

	public void setIhd(java.lang.String ihd) {
		this.ihd = ihd;
	}

	public java.lang.String getComplications() {
		return complications;
	}

	public void setComplications(java.lang.String complications) {
		this.complications = complications;
	}

	public java.lang.String getHearingAids() {
		return hearingAids;
	}

	public void setHearingAids(java.lang.String hearingAids) {
		this.hearingAids = hearingAids;
	}

	public java.lang.String getAcidPepticDisorders() {
		return acidPepticDisorders;
	}

	public void setAcidPepticDisorders(java.lang.String acidPepticDisorders) {
		this.acidPepticDisorders = acidPepticDisorders;
	}

	public java.lang.String getJaundice() {
		return jaundice;
	}

	public void setJaundice(java.lang.String jaundice) {
		this.jaundice = jaundice;
	}

	public java.lang.String getPonv() {
		return ponv;
	}

	public void setPonv(java.lang.String ponv) {
		this.ponv = ponv;
	}

	public java.lang.String getHistoryRemarks() {
		return historyRemarks;
	}

	public void setHistoryRemarks(java.lang.String historyRemarks) {
		this.historyRemarks = historyRemarks;
	}

	public java.lang.String getAntiallegeric() {
		return antiallegeric;
	}

	public void setAntiallegeric(java.lang.String antiallegeric) {
		this.antiallegeric = antiallegeric;
	}

	public java.lang.String getCebs() {
		return cebs;
	}

	public void setCebs(java.lang.String cebs) {
		this.cebs = cebs;
	}

	public java.lang.String getAntiplatelets() {
		return antiplatelets;
	}

	public void setAntiplatelets(java.lang.String antiplatelets) {
		this.antiplatelets = antiplatelets;
	}

	public java.lang.String getAntihypertensives() {
		return antihypertensives;
	}

	public void setAntihypertensives(java.lang.String antihypertensives) {
		this.antihypertensives = antihypertensives;
	}

	public java.lang.String getAntianginals() {
		return antianginals;
	}

	public void setAntianginals(java.lang.String antianginals) {
		this.antianginals = antianginals;
	}

	public java.lang.String getAntituberculous() {
		return antituberculous;
	}

	public void setAntituberculous(java.lang.String antituberculous) {
		this.antituberculous = antituberculous;
	}

	public java.lang.String getAntiasthmatics() {
		return antiasthmatics;
	}

	public void setAntiasthmatics(java.lang.String antiasthmatics) {
		this.antiasthmatics = antiasthmatics;
	}

	public java.lang.String getAntidiabetics() {
		return antidiabetics;
	}

	public void setAntidiabetics(java.lang.String antidiabetics) {
		this.antidiabetics = antidiabetics;
	}

	public java.lang.String getAntimalignancy() {
		return antimalignancy;
	}

	public void setAntimalignancy(java.lang.String antimalignancy) {
		this.antimalignancy = antimalignancy;
	}

	public java.lang.String getDiuretics() {
		return diuretics;
	}

	public void setDiuretics(java.lang.String diuretics) {
		this.diuretics = diuretics;
	}

	public java.lang.String getAntiepileptics() {
		return antiepileptics;
	}

	public void setAntiepileptics(java.lang.String antiepileptics) {
		this.antiepileptics = antiepileptics;
	}

	public java.lang.String getAntithyroid() {
		return antithyroid;
	}

	public void setAntithyroid(java.lang.String antithyroid) {
		this.antithyroid = antithyroid;
	}

	public java.lang.String getDigoxin() {
		return digoxin;
	}

	public void setDigoxin(java.lang.String digoxin) {
		this.digoxin = digoxin;
	}

	public java.lang.String getAntipsychotics() {
		return antipsychotics;
	}

	public void setAntipsychotics(java.lang.String antipsychotics) {
		this.antipsychotics = antipsychotics;
	}

	public java.lang.String getAntacid() {
		return antacid;
	}

	public void setAntacid(java.lang.String antacid) {
		this.antacid = antacid;
	}

	public java.lang.String getBetaBlockers() {
		return betaBlockers;
	}

	public void setBetaBlockers(java.lang.String betaBlockers) {
		this.betaBlockers = betaBlockers;
	}

	public java.lang.String getSteroids() {
		return steroids;
	}

	public void setSteroids(java.lang.String steroids) {
		this.steroids = steroids;
	}

	public java.lang.String getH2Blockers() {
		return h2Blockers;
	}

	public void setH2Blockers(java.lang.String h2Blockers) {
		this.h2Blockers = h2Blockers;
	}

	public java.lang.String getDrugHistoryOthers() {
		return drugHistoryOthers;
	}

	public void setDrugHistoryOthers(java.lang.String drugHistoryOthers) {
		this.drugHistoryOthers = drugHistoryOthers;
	}

	public java.lang.String getDrugHistoryRemarks() {
		return drugHistoryRemarks;
	}

	public void setDrugHistoryRemarks(java.lang.String drugHistoryRemarks) {
		this.drugHistoryRemarks = drugHistoryRemarks;
	}

	public java.lang.String getMouthOpening() {
		return mouthOpening;
	}

	public void setMouthOpening(java.lang.String mouthOpening) {
		this.mouthOpening = mouthOpening;
	}

	public java.lang.String getTmj() {
		return tmj;
	}

	public void setTmj(java.lang.String tmj) {
		this.tmj = tmj;
	}

	public java.lang.String getNeckMovements() {
		return neckMovements;
	}

	public void setNeckMovements(java.lang.String neckMovements) {
		this.neckMovements = neckMovements;
	}

	public java.lang.String getTooth() {
		return tooth;
	}

	public void setTooth(java.lang.String tooth) {
		this.tooth = tooth;
	}

	public java.lang.String getMallampattiClass() {
		return mallampattiClass;
	}

	public void setMallampattiClass(java.lang.String mallampattiClass) {
		this.mallampattiClass = mallampattiClass;
	}

	public java.lang.String getAllensTest() {
		return allensTest;
	}

	public void setAllensTest(java.lang.String allensTest) {
		this.allensTest = allensTest;
	}

	public java.lang.String getRespiratorySystem() {
		return respiratorySystem;
	}

	public void setRespiratorySystem(java.lang.String respiratorySystem) {
		this.respiratorySystem = respiratorySystem;
	}

	public java.lang.String getTrachea() {
		return trachea;
	}

	public void setTrachea(java.lang.String trachea) {
		this.trachea = trachea;
	}

	public java.lang.String getLungs() {
		return lungs;
	}

	public void setLungs(java.lang.String lungs) {
		this.lungs = lungs;
	}

	public java.lang.String getCardioVascularSystem() {
		return cardioVascularSystem;
	}

	public void setCardioVascularSystem(java.lang.String cardioVascularSystem) {
		this.cardioVascularSystem = cardioVascularSystem;
	}

	public java.lang.String getCentralNervousSystem() {
		return centralNervousSystem;
	}

	public void setCentralNervousSystem(java.lang.String centralNervousSystem) {
		this.centralNervousSystem = centralNervousSystem;
	}

	public java.lang.String getGastrointestinalSystem() {
		return gastrointestinalSystem;
	}

	public void setGastrointestinalSystem(java.lang.String gastrointestinalSystem) {
		this.gastrointestinalSystem = gastrointestinalSystem;
	}

	public java.lang.String getPhysicalExamination() {
		return physicalExamination;
	}

	public void setPhysicalExamination(java.lang.String physicalExamination) {
		this.physicalExamination = physicalExamination;
	}

	/**
	 * Return the value associated with the column: anesthetic_id
	 */
	public jkt.hms.masters.business.MasEmployee getAnesthetic () {
		return anesthetic;
	}

	/**
	 * Set the value related to the column: anesthetic_id
	 * @param anesthetic the anesthetic_id value
	 */
	public void setAnesthetic (jkt.hms.masters.business.MasEmployee anesthetic) {
		this.anesthetic = anesthetic;
	}



	/**
	 * Return the value associated with the column: changed_by
	 */
	public jkt.hms.masters.business.Users getChangedBy () {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * @param changedBy the changed_by value
	 */
	public void setChangedBy (jkt.hms.masters.business.Users changedBy) {
		this.changedBy = changedBy;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: pending_doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getPendingDoc () {
		return pendingDoc;
	}

	/**
	 * Set the value related to the column: pending_doctor_id
	 * @param pendingDoc the pending_doctor_id value
	 */
	public void setPendingDoc (jkt.hms.masters.business.MasEmployee pendingDoc) {
		this.pendingDoc = pendingDoc;
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
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasDepartment getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasDepartment ward) {
		this.ward = ward;
	}

	

	public jkt.hms.masters.business.AacAcceptance getAacAcceptance() {
		return aacAcceptance;
	}

	public void setAacAcceptance(
			jkt.hms.masters.business.AacAcceptance aacAcceptance) {
		this.aacAcceptance = aacAcceptance;
	}
	
	

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPreAnesthesiaDetails)) return false;
		else {
			jkt.hms.masters.business.OtPreAnesthesiaDetails otPreAnesthesiaDetails = (jkt.hms.masters.business.OtPreAnesthesiaDetails) obj;
			if (null == this.getId() || null == otPreAnesthesiaDetails.getId()) return false;
			else return (this.getId().equals(otPreAnesthesiaDetails.getId()));
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