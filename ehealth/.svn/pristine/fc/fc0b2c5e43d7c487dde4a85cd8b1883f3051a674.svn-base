package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_disease_registration table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_disease_registration"
 */

public abstract class BasePhDiseaseRegistration  implements Serializable {

	public static String REF = "PhDiseaseRegistration";
	public static String PROP_AGE = "Age";
	public static String PROP_DISEASE_STATUS = "DiseaseStatus";
	public static String PROP_ADMISSION_DATE = "AdmissionDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_HOSPITALISED = "Hospitalised";
	public static String PROP_DRUG_ABUSE = "DrugAbuse";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_NCD_FAMILY_HISTORY = "NcdFamilyHistory";
	public static String PROP_SMOKING = "Smoking";
	public static String PROP_DISEASE_TYPE = "DiseaseType";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_NCD_FAMILY_DEATH = "NcdFamilyDeath";
	public static String PROP_DISEASE_REG_ID = "DiseaseRegId";
	public static String PROP_TOBACCO = "Tobacco";
	public static String PROP_UNDER_TREATMENT = "UnderTreatment";
	public static String PROP_PHYSIAL_ACTIVITY = "PhysialActivity";
	public static String PROP_DATE_ONSET = "DateOnset";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DIET_FLAG = "DietFlag";
	public static String PROP_ALCOHOL = "Alcohol";
	public static String PROP_MEDICINE_SYSTAM = "MedicineSystam";
	public static String PROP_DIAGNOSIS_TYPE = "DiagnosisType";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_SERVER_PK = "ServerPk";
	public static String PROP_EXERCISE = "Exercise";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_INVESTIGATION_STATUS = "InvestigationStatus";
	public static String PROP_INFECTION_SOURCE = "InfectionSource";
	public static String PROP_ID = "Id";
	public static String PROP_OTHER_DIAGNOSIS = "OtherDiagnosis";


	// constructors
	public BasePhDiseaseRegistration () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhDiseaseRegistration (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String diseaseType;
	private java.util.Date regDate;
	private java.lang.Long serverPk;
	private java.lang.Long memberId;
	private java.lang.String diseaseRegId;
	private java.lang.Long age;
	private java.util.Date dateOnset;
	private java.lang.String hospitalised;
	private java.lang.String hospitalName;
	private java.lang.String medicineSystam;
	private java.util.Date admissionDate;
	private java.lang.String diagnosis;
	private java.lang.String otherDiagnosis;
	private java.lang.String investigationStatus;
	private java.lang.String diagnosisType;
	private java.lang.String infectionSource;
	private java.lang.String remarks;
	private java.lang.String diseaseStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String smoking;
	private java.lang.String tobacco;
	private java.lang.String alcohol;
	private java.lang.String drugAbuse;
	private java.lang.String ncdFamilyHistory;
	private java.lang.String ncdFamilyDeath;
	private java.lang.String underTreatment;
	private java.lang.String exercise;
	private java.lang.String physialActivity;
	private java.lang.String dietFlag;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="disease_id"
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
	 * Return the value associated with the column: disease_type
	 */
	public java.lang.String getDiseaseType () {
		return diseaseType;
	}

	/**
	 * Set the value related to the column: disease_type
	 * @param diseaseType the disease_type value
	 */
	public void setDiseaseType (java.lang.String diseaseType) {
		this.diseaseType = diseaseType;
	}



	/**
	 * Return the value associated with the column: reg_date
	 */
	public java.util.Date getRegDate () {
		return regDate;
	}

	/**
	 * Set the value related to the column: reg_date
	 * @param regDate the reg_date value
	 */
	public void setRegDate (java.util.Date regDate) {
		this.regDate = regDate;
	}



	/**
	 * Return the value associated with the column: server_pk
	 */
	public java.lang.Long getServerPk () {
		return serverPk;
	}

	/**
	 * Set the value related to the column: server_pk
	 * @param serverPk the server_pk value
	 */
	public void setServerPk (java.lang.Long serverPk) {
		this.serverPk = serverPk;
	}



	/**
	 * Return the value associated with the column: member_id
	 */
	public java.lang.Long getMemberId () {
		return memberId;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param memberId the member_id value
	 */
	public void setMemberId (java.lang.Long memberId) {
		this.memberId = memberId;
	}



	/**
	 * Return the value associated with the column: disease_reg_id
	 */
	public java.lang.String getDiseaseRegId () {
		return diseaseRegId;
	}

	/**
	 * Set the value related to the column: disease_reg_id
	 * @param diseaseRegId the disease_reg_id value
	 */
	public void setDiseaseRegId (java.lang.String diseaseRegId) {
		this.diseaseRegId = diseaseRegId;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.Long getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.Long age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: date_onset
	 */
	public java.util.Date getDateOnset () {
		return dateOnset;
	}

	/**
	 * Set the value related to the column: date_onset
	 * @param dateOnset the date_onset value
	 */
	public void setDateOnset (java.util.Date dateOnset) {
		this.dateOnset = dateOnset;
	}



	/**
	 * Return the value associated with the column: hospitalised
	 */
	public java.lang.String getHospitalised () {
		return hospitalised;
	}

	/**
	 * Set the value related to the column: hospitalised
	 * @param hospitalised the hospitalised value
	 */
	public void setHospitalised (java.lang.String hospitalised) {
		this.hospitalised = hospitalised;
	}



	/**
	 * Return the value associated with the column: hospital_name
	 */
	public java.lang.String getHospitalName () {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: hospital_name
	 * @param hospitalName the hospital_name value
	 */
	public void setHospitalName (java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
	}



	/**
	 * Return the value associated with the column: medicine_systam
	 */
	public java.lang.String getMedicineSystam () {
		return medicineSystam;
	}

	/**
	 * Set the value related to the column: medicine_systam
	 * @param medicineSystam the medicine_systam value
	 */
	public void setMedicineSystam (java.lang.String medicineSystam) {
		this.medicineSystam = medicineSystam;
	}



	/**
	 * Return the value associated with the column: admission_date
	 */
	public java.util.Date getAdmissionDate () {
		return admissionDate;
	}

	/**
	 * Set the value related to the column: admission_date
	 * @param admissionDate the admission_date value
	 */
	public void setAdmissionDate (java.util.Date admissionDate) {
		this.admissionDate = admissionDate;
	}



	/**
	 * Return the value associated with the column: diagnosis
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis
	 * @param diagnosis the diagnosis value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: other_diagnosis
	 */
	public java.lang.String getOtherDiagnosis () {
		return otherDiagnosis;
	}

	/**
	 * Set the value related to the column: other_diagnosis
	 * @param otherDiagnosis the other_diagnosis value
	 */
	public void setOtherDiagnosis (java.lang.String otherDiagnosis) {
		this.otherDiagnosis = otherDiagnosis;
	}



	/**
	 * Return the value associated with the column: investigation_status
	 */
	public java.lang.String getInvestigationStatus () {
		return investigationStatus;
	}

	/**
	 * Set the value related to the column: investigation_status
	 * @param investigationStatus the investigation_status value
	 */
	public void setInvestigationStatus (java.lang.String investigationStatus) {
		this.investigationStatus = investigationStatus;
	}



	/**
	 * Return the value associated with the column: diagnosis_type
	 */
	public java.lang.String getDiagnosisType () {
		return diagnosisType;
	}

	/**
	 * Set the value related to the column: diagnosis_type
	 * @param diagnosisType the diagnosis_type value
	 */
	public void setDiagnosisType (java.lang.String diagnosisType) {
		this.diagnosisType = diagnosisType;
	}



	/**
	 * Return the value associated with the column: infection_source
	 */
	public java.lang.String getInfectionSource () {
		return infectionSource;
	}

	/**
	 * Set the value related to the column: infection_source
	 * @param infectionSource the infection_source value
	 */
	public void setInfectionSource (java.lang.String infectionSource) {
		this.infectionSource = infectionSource;
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
	 * Return the value associated with the column: disease_status
	 */
	public java.lang.String getDiseaseStatus () {
		return diseaseStatus;
	}

	/**
	 * Set the value related to the column: disease_status
	 * @param diseaseStatus the disease_status value
	 */
	public void setDiseaseStatus (java.lang.String diseaseStatus) {
		this.diseaseStatus = diseaseStatus;
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
	 * Return the value associated with the column: smoking
	 */
	public java.lang.String getSmoking () {
		return smoking;
	}

	/**
	 * Set the value related to the column: smoking
	 * @param smoking the smoking value
	 */
	public void setSmoking (java.lang.String smoking) {
		this.smoking = smoking;
	}



	/**
	 * Return the value associated with the column: tobacco
	 */
	public java.lang.String getTobacco () {
		return tobacco;
	}

	/**
	 * Set the value related to the column: tobacco
	 * @param tobacco the tobacco value
	 */
	public void setTobacco (java.lang.String tobacco) {
		this.tobacco = tobacco;
	}



	/**
	 * Return the value associated with the column: alcohol
	 */
	public java.lang.String getAlcohol () {
		return alcohol;
	}

	/**
	 * Set the value related to the column: alcohol
	 * @param alcohol the alcohol value
	 */
	public void setAlcohol (java.lang.String alcohol) {
		this.alcohol = alcohol;
	}



	/**
	 * Return the value associated with the column: drug_abuse
	 */
	public java.lang.String getDrugAbuse () {
		return drugAbuse;
	}

	/**
	 * Set the value related to the column: drug_abuse
	 * @param drugAbuse the drug_abuse value
	 */
	public void setDrugAbuse (java.lang.String drugAbuse) {
		this.drugAbuse = drugAbuse;
	}



	/**
	 * Return the value associated with the column: ncd_family_history
	 */
	public java.lang.String getNcdFamilyHistory () {
		return ncdFamilyHistory;
	}

	/**
	 * Set the value related to the column: ncd_family_history
	 * @param ncdFamilyHistory the ncd_family_history value
	 */
	public void setNcdFamilyHistory (java.lang.String ncdFamilyHistory) {
		this.ncdFamilyHistory = ncdFamilyHistory;
	}



	/**
	 * Return the value associated with the column: ncd_family_death
	 */
	public java.lang.String getNcdFamilyDeath () {
		return ncdFamilyDeath;
	}

	/**
	 * Set the value related to the column: ncd_family_death
	 * @param ncdFamilyDeath the ncd_family_death value
	 */
	public void setNcdFamilyDeath (java.lang.String ncdFamilyDeath) {
		this.ncdFamilyDeath = ncdFamilyDeath;
	}



	/**
	 * Return the value associated with the column: under_treatment
	 */
	public java.lang.String getUnderTreatment () {
		return underTreatment;
	}

	/**
	 * Set the value related to the column: under_treatment
	 * @param underTreatment the under_treatment value
	 */
	public void setUnderTreatment (java.lang.String underTreatment) {
		this.underTreatment = underTreatment;
	}



	/**
	 * Return the value associated with the column: exercise
	 */
	public java.lang.String getExercise () {
		return exercise;
	}

	/**
	 * Set the value related to the column: exercise
	 * @param exercise the exercise value
	 */
	public void setExercise (java.lang.String exercise) {
		this.exercise = exercise;
	}



	/**
	 * Return the value associated with the column: physial_activity
	 */
	public java.lang.String getPhysialActivity () {
		return physialActivity;
	}

	/**
	 * Set the value related to the column: physial_activity
	 * @param physialActivity the physial_activity value
	 */
	public void setPhysialActivity (java.lang.String physialActivity) {
		this.physialActivity = physialActivity;
	}



	/**
	 * Return the value associated with the column: diet_flag
	 */
	public java.lang.String getDietFlag () {
		return dietFlag;
	}

	/**
	 * Set the value related to the column: diet_flag
	 * @param dietFlag the diet_flag value
	 */
	public void setDietFlag (java.lang.String dietFlag) {
		this.dietFlag = dietFlag;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhDiseaseRegistration)) return false;
		else {
			jkt.hms.masters.business.PhDiseaseRegistration phDiseaseRegistration = (jkt.hms.masters.business.PhDiseaseRegistration) obj;
			if (null == this.getId() || null == phDiseaseRegistration.getId()) return false;
			else return (this.getId().equals(phDiseaseRegistration.getId()));
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