package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_disease_registration_follow table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_disease_registration_follow"
 */

public abstract class BasePhDiseaseRegistrationFollow  implements Serializable {

	public static String REF = "PhDiseaseRegistrationFollow";
	public static String PROP_INPATIENT_NO = "InpatientNo";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_HOSPITAZID = "Hospitazid";
	public static String PROP_BP_FLAG = "BpFlag";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ALCOHAL = "Alcohal";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SYNDROMIC_SURVEILLANCE = "SyndromicSurveillance";
	public static String PROP_BP_MIN = "BpMin";
	public static String PROP_SUSPECTED_NCD = "SuspectedNcd";
	public static String PROP_BP_MAX = "BpMax";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_BMI = "Bmi";
	public static String PROP_SMOKING = "Smoking";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_SUGER_FLAG = "SugerFlag";
	public static String PROP_HEALTH_EDUCATION = "HealthEducation";
	public static String PROP_NCD_REG_STATUS = "NcdRegStatus";
	public static String PROP_FOLLOW_DATE = "FollowDate";
	public static String PROP_SUGER_VALUE = "SugerValue";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_FOLLOW_TIME = "FollowTime";
	public static String PROP_TABACCO_CHEWING = "TabaccoChewing";
	public static String PROP_SERVER_PK = "ServerPk";
	public static String PROP_INSTITUTION_NAME = "InstitutionName";
	public static String PROP_PATIENT_CONDITION = "PatientCondition";
	public static String PROP_ID = "Id";
	public static String PROP_DISEASE_REG = "DiseaseReg";
	public static String PROP_INSTITUTION_TYPE = "InstitutionType";
	public static String PROP_DIAGNOSIS_DATE = "DiagnosisDate";
	public static String PROP_MEDICINE_SYSTEM = "MedicineSystem";
	public static String PROP_DISCHARGE_DATE = "DischargeDate";
	public static String PROP_FOLLOWUP_TYPE = "FollowupType";
    
	public static String PROP_HEIGHT = "Height";
	public static String PROP_HIP = "Hip";
	public static String PROP_CHECKEDSTATUS = "CheckedStatus";
	public static String PROP_WAIST = "Waist";
	public static String PROP_WAISTHIPRATIO = "Waisthipratio";
	public static String PROP_NEXTFOLLOWDATE = "NextFollowDate";

	// constructors
	public BasePhDiseaseRegistrationFollow () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhDiseaseRegistrationFollow (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhDiseaseRegistrationFollow (
		java.lang.Integer id,
		jkt.hms.masters.business.PhDiseaseRegistration diseaseReg,
		java.util.Date followDate) {
         String diseaseReg1=diseaseReg.toString();
		this.setId(id);
		this.setDiseaseReg(diseaseReg1);
		this.setFollowDate(followDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date followDate;
	private java.util.Date nextFollowDate;
	private java.lang.String followTime;
	private java.lang.String memberId;
	private java.lang.String inpatientNo;
	private java.util.Date diagnosisDate;
	private java.util.Date dischargeDate;
	private java.lang.String patientCondition;
	private java.lang.String medicineSystem;
	private java.lang.String remarks;
	private java.lang.String syndromicSurveillance;
	private java.lang.String actionTaken;
	private java.lang.String institutionType;
	private java.lang.String institutionName;
	private java.lang.String hospitazid;
	private java.lang.String followupType;
	private java.lang.String suspectedNcd;
	private java.lang.String ncdRegStatus;
	private java.lang.String bpFlag;
	private java.lang.Long bpMin;
	private java.lang.Long bpMax;
	private java.lang.String sugerFlag;
	private java.lang.String sugerValue;
	private java.math.BigDecimal weight;
	private java.lang.String bmi;
	private java.lang.String smoking;
	private java.lang.String tabaccoChewing;
	private java.lang.String alcohal;
	private java.lang.String healthEducation;
	private java.lang.String complications;
	private java.lang.Long hospitalId;
	private java.lang.Long serverPk;
	private java.lang.String diseaseReg;
	
	private java.math.BigDecimal height;
	private java.lang.String hip;
	private java.lang.String waist;
	private java.lang.String waisthipratio;
	private java.lang.String checkedStatus;
	
	// many to one
	//private jkt.hms.masters.business.PhDiseaseRegistration diseaseReg;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="follow_id"
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
	 * Return the value associated with the column: follow_date
	 */
	public java.util.Date getFollowDate () {
		return followDate;
	}

	/**
	 * Set the value related to the column: follow_date
	 * @param followDate the follow_date value
	 */
	public void setFollowDate (java.util.Date followDate) {
		this.followDate = followDate;
	}



	/**
	 * Return the value associated with the column: follow_time
	 */
	public java.lang.String getFollowTime () {
		return followTime;
	}

	/**
	 * Set the value related to the column: follow_time
	 * @param followTime the follow_time value
	 */
	public void setFollowTime (java.lang.String followTime) {
		this.followTime = followTime;
	}



	/**
	 * Return the value associated with the column: member_id
	 */
	public java.lang.String getMemberId () {
		return memberId;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param memberId the member_id value
	 */
	public void setMemberId (java.lang.String memberId) {
		this.memberId = memberId;
	}



	/**
	 * Return the value associated with the column: inpatient_no
	 */
	public java.lang.String getInpatientNo () {
		return inpatientNo;
	}

	/**
	 * Set the value related to the column: inpatient_no
	 * @param inpatientNo the inpatient_no value
	 */
	public void setInpatientNo (java.lang.String inpatientNo) {
		this.inpatientNo = inpatientNo;
	}



	/**
	 * Return the value associated with the column: diagnosis_date
	 */
	public java.util.Date getDiagnosisDate () {
		return diagnosisDate;
	}

	/**
	 * Set the value related to the column: diagnosis_date
	 * @param diagnosisDate the diagnosis_date value
	 */
	public void setDiagnosisDate (java.util.Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}



	/**
	 * Return the value associated with the column: discharge_date
	 */
	public java.util.Date getDischargeDate () {
		return dischargeDate;
	}

	/**
	 * Set the value related to the column: discharge_date
	 * @param dischargeDate the discharge_date value
	 */
	public void setDischargeDate (java.util.Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}



	/**
	 * Return the value associated with the column: patient_condition
	 */
	public java.lang.String getPatientCondition () {
		return patientCondition;
	}

	/**
	 * Set the value related to the column: patient_condition
	 * @param patientCondition the patient_condition value
	 */
	public void setPatientCondition (java.lang.String patientCondition) {
		this.patientCondition = patientCondition;
	}



	/**
	 * Return the value associated with the column: medicine_system
	 */
	public java.lang.String getMedicineSystem () {
		return medicineSystem;
	}

	/**
	 * Set the value related to the column: medicine_system
	 * @param medicineSystem the medicine_system value
	 */
	public void setMedicineSystem (java.lang.String medicineSystem) {
		this.medicineSystem = medicineSystem;
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
	 * Return the value associated with the column: syndromic_surveillance
	 */
	public java.lang.String getSyndromicSurveillance () {
		return syndromicSurveillance;
	}

	/**
	 * Set the value related to the column: syndromic_surveillance
	 * @param syndromicSurveillance the syndromic_surveillance value
	 */
	public void setSyndromicSurveillance (java.lang.String syndromicSurveillance) {
		this.syndromicSurveillance = syndromicSurveillance;
	}



	/**
	 * Return the value associated with the column: action_taken
	 */
	public java.lang.String getActionTaken () {
		return actionTaken;
	}

	/**
	 * Set the value related to the column: action_taken
	 * @param actionTaken the action_taken value
	 */
	public void setActionTaken (java.lang.String actionTaken) {
		this.actionTaken = actionTaken;
	}



	/**
	 * Return the value associated with the column: institution_type
	 */
	public java.lang.String getInstitutionType () {
		return institutionType;
	}

	/**
	 * Set the value related to the column: institution_type
	 * @param institutionType the institution_type value
	 */
	public void setInstitutionType (java.lang.String institutionType) {
		this.institutionType = institutionType;
	}



	/**
	 * Return the value associated with the column: institution_name
	 */
	public java.lang.String getInstitutionName () {
		return institutionName;
	}

	/**
	 * Set the value related to the column: institution_name
	 * @param institutionName the institution_name value
	 */
	public void setInstitutionName (java.lang.String institutionName) {
		this.institutionName = institutionName;
	}



	/**
	 * Return the value associated with the column: hospitazid
	 */
	public java.lang.String getHospitazid () {
		return hospitazid;
	}

	/**
	 * Set the value related to the column: hospitazid
	 * @param hospitazid the hospitazid value
	 */
	public void setHospitazid (java.lang.String hospitazid) {
		this.hospitazid = hospitazid;
	}



	/**
	 * Return the value associated with the column: followup_type
	 */
	public java.lang.String getFollowupType () {
		return followupType;
	}

	/**
	 * Set the value related to the column: followup_type
	 * @param followupType the followup_type value
	 */
	public void setFollowupType (java.lang.String followupType) {
		this.followupType = followupType;
	}



	/**
	 * Return the value associated with the column: suspected_ncd
	 */
	public java.lang.String getSuspectedNcd () {
		return suspectedNcd;
	}

	/**
	 * Set the value related to the column: suspected_ncd
	 * @param suspectedNcd the suspected_ncd value
	 */
	public void setSuspectedNcd (java.lang.String suspectedNcd) {
		this.suspectedNcd = suspectedNcd;
	}



	/**
	 * Return the value associated with the column: ncd_reg_status
	 */
	public java.lang.String getNcdRegStatus () {
		return ncdRegStatus;
	}

	/**
	 * Set the value related to the column: ncd_reg_status
	 * @param ncdRegStatus the ncd_reg_status value
	 */
	public void setNcdRegStatus (java.lang.String ncdRegStatus) {
		this.ncdRegStatus = ncdRegStatus;
	}



	/**
	 * Return the value associated with the column: bp_flag
	 */
	public java.lang.String getBpFlag () {
		return bpFlag;
	}

	/**
	 * Set the value related to the column: bp_flag
	 * @param bpFlag the bp_flag value
	 */
	public void setBpFlag (java.lang.String bpFlag) {
		this.bpFlag = bpFlag;
	}



	/**
	 * Return the value associated with the column: bp_min
	 */
	public java.lang.Long getBpMin () {
		return bpMin;
	}

	/**
	 * Set the value related to the column: bp_min
	 * @param bpMin the bp_min value
	 */
	public void setBpMin (java.lang.Long bpMin) {
		this.bpMin = bpMin;
	}



	/**
	 * Return the value associated with the column: bp_max
	 */
	public java.lang.Long getBpMax () {
		return bpMax;
	}

	/**
	 * Set the value related to the column: bp_max
	 * @param bpMax the bp_max value
	 */
	public void setBpMax (java.lang.Long bpMax) {
		this.bpMax = bpMax;
	}



	/**
	 * Return the value associated with the column: suger_flag
	 */
	public java.lang.String getSugerFlag () {
		return sugerFlag;
	}

	/**
	 * Set the value related to the column: suger_flag
	 * @param sugerFlag the suger_flag value
	 */
	public void setSugerFlag (java.lang.String sugerFlag) {
		this.sugerFlag = sugerFlag;
	}



	/**
	 * Return the value associated with the column: suger_value
	 */
	public java.lang.String getSugerValue () {
		return sugerValue;
	}

	/**
	 * Set the value related to the column: suger_value
	 * @param sugerValue the suger_value value
	 */
	public void setSugerValue (java.lang.String sugerValue) {
		this.sugerValue = sugerValue;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.math.BigDecimal weight) {
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
	 * Return the value associated with the column: tabacco_chewing
	 */
	public java.lang.String getTabaccoChewing () {
		return tabaccoChewing;
	}

	/**
	 * Set the value related to the column: tabacco_chewing
	 * @param tabaccoChewing the tabacco_chewing value
	 */
	public void setTabaccoChewing (java.lang.String tabaccoChewing) {
		this.tabaccoChewing = tabaccoChewing;
	}



	/**
	 * Return the value associated with the column: alcohal
	 */
	public java.lang.String getAlcohal () {
		return alcohal;
	}

	/**
	 * Set the value related to the column: alcohal
	 * @param alcohal the alcohal value
	 */
	public void setAlcohal (java.lang.String alcohal) {
		this.alcohal = alcohal;
	}



	/**
	 * Return the value associated with the column: health_education
	 */
	public java.lang.String getHealthEducation () {
		return healthEducation;
	}

	/**
	 * Set the value related to the column: health_education
	 * @param healthEducation the health_education value
	 */
	public void setHealthEducation (java.lang.String healthEducation) {
		this.healthEducation = healthEducation;
	}



	/**
	 * Return the value associated with the column: complications
	 */
	public java.lang.String getComplications () {
		return complications;
	}

	/**
	 * Set the value related to the column: complications
	 * @param complications the complications value
	 */
	public void setComplications (java.lang.String complications) {
		this.complications = complications;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Long getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Long hospitalId) {
		this.hospitalId = hospitalId;
	}



	public java.util.Date getNextFollowDate() {
		return nextFollowDate;
	}

	public void setNextFollowDate(java.util.Date nextFollowDate) {
		this.nextFollowDate = nextFollowDate;
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
	 * Return the value associated with the column: disease_reg_id
	 */
	/*public jkt.hms.masters.business.PhDiseaseRegistration getDiseaseReg () {
		return diseaseReg;
	}

	*//**
	 * Set the value related to the column: disease_reg_id
	 * @param diseaseReg the disease_reg_id value
	 *//*
	public void setDiseaseReg (jkt.hms.masters.business.PhDiseaseRegistration diseaseReg) {
		this.diseaseReg = diseaseReg;
	}*/




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhDiseaseRegistrationFollow)) return false;
		else {
			jkt.hms.masters.business.PhDiseaseRegistrationFollow phDiseaseRegistrationFollow = (jkt.hms.masters.business.PhDiseaseRegistrationFollow) obj;
			if (null == this.getId() || null == phDiseaseRegistrationFollow.getId()) return false;
			else return (this.getId().equals(phDiseaseRegistrationFollow.getId()));
		}
	}

	public java.lang.String getDiseaseReg() {
		return diseaseReg;
	}

	public void setDiseaseReg(java.lang.String diseaseReg) {
		this.diseaseReg = diseaseReg;
	}

	public java.math.BigDecimal getHeight() {
		return height;
	}

	public void setHeight(java.math.BigDecimal height) {
		this.height = height;
	}

	public java.lang.String getHip() {
		return hip;
	}

	public void setHip(java.lang.String hip) {
		this.hip = hip;
	}

	public java.lang.String getWaist() {
		return waist;
	}

	public void setWaist(java.lang.String waist) {
		this.waist = waist;
	}

	public java.lang.String getWaisthipratio() {
		return waisthipratio;
	}

	public void setWaisthipratio(java.lang.String waisthipratio) {
		this.waisthipratio = waisthipratio;
	}

	public java.lang.String getCheckedStatus() {
		return checkedStatus;
	}

	public void setCheckedStatus(java.lang.String checkedStatus) {
		this.checkedStatus = checkedStatus;
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