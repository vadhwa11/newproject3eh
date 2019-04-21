package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_disease_registration_screening table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_disease_registration_screening"
 */

public abstract class BasePhDiseaseRegistrationScreening  implements Serializable {

	public static String REF = "PhDiseaseRegistrationScreening";
	public static String PROP_WAIST_HIP_RATIO = "WaistHipRatio";
	public static String PROP_REG_FOLLOWUP_ID = "RegFollowupId";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SUSPECTED_NCD = "SuspectedNcd";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_BMI = "Bmi";
	public static String PROP_DISEASE_REG_ID = "DiseaseRegId";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_BLOOD_PRE_MIN = "BloodPreMin";
	public static String PROP_BLOOD_PRE_MAX = "BloodPreMax";
	public static String PROP_BLOOD_SUGAR_RBS = "BloodSugarRbs";
	public static String PROP_FOLLOW_DATE = "FollowDate";
	public static String PROP_FOLLOW_UP_TYPE = "FollowUpType";
	public static String PROP_FOLLOW_TIME = "FollowTime";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_INVESTIGATION_NAME = "InvestigationName";
	public static String PROP_INSTITUTION_NAME = "InstitutionName";
	public static String PROP_WAIST = "Waist";
	public static String PROP_ID = "Id";
	public static String PROP_INSTITUTION_TYPE = "InstitutionType";
	public static String PROP_FOLLOWUP_TYPE = "FollowupType";
	public static String PROP_HIP = "Hip";
	public static String PROP_CHECKED_STATUS ="CheckedStatus";

	// constructors
	public BasePhDiseaseRegistrationScreening () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhDiseaseRegistrationScreening (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhDiseaseRegistrationScreening (
		java.lang.Integer id,
		java.util.Date followDate) {

		this.setId(id);
		this.setFollowDate(followDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date followDate;
	private java.lang.String followTime;
	private java.lang.String diseaseRegId;
	private java.lang.String remarks;
	private java.lang.Long institutionType;
	private java.lang.Long institutionName;
	private java.lang.String followupType;
	private java.lang.String suspectedNcd;
	private java.math.BigDecimal height;
	private java.lang.String followUpType;
	private java.lang.Long waist;
	private java.lang.String checkedStatus;
	private java.lang.String bmi;
	private java.lang.String investigationName;
	private java.lang.Long bloodPreMax;
	private java.lang.Long bloodPreMin;
	private java.util.Date regDate;
	private java.lang.String regFollowupId;
	private java.lang.String hip;
	private java.lang.String weight;
	private java.lang.String bloodSugarRbs;
	private java.lang.String waistHipRatio;
	private java.lang.Long memberId;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



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



	public java.lang.String getCheckedStatus() {
		return checkedStatus;
	}

	public void setCheckedStatus(java.lang.String checkedStatus) {
		this.checkedStatus = checkedStatus;
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
	 * Return the value associated with the column: institution_type
	 */
	public java.lang.Long getInstitutionType () {
		return institutionType;
	}

	/**
	 * Set the value related to the column: institution_type
	 * @param institutionType the institution_type value
	 */
	public void setInstitutionType (java.lang.Long institutionType) {
		this.institutionType = institutionType;
	}



	/**
	 * Return the value associated with the column: institution_name
	 */
	public java.lang.Long getInstitutionName () {
		return institutionName;
	}

	/**
	 * Set the value related to the column: institution_name
	 * @param institutionName the institution_name value
	 */
	public void setInstitutionName (java.lang.Long institutionName) {
		this.institutionName = institutionName;
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
	 * Return the value associated with the column: height
	 */
	public java.math.BigDecimal getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.math.BigDecimal height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: follow_up_type
	 */
	public java.lang.String getFollowUpType () {
		return followUpType;
	}

	/**
	 * Set the value related to the column: follow_up_type
	 * @param followUpType the follow_up_type value
	 */
	public void setFollowUpType (java.lang.String followUpType) {
		this.followUpType = followUpType;
	}



	/**
	 * Return the value associated with the column: waist
	 */
	public java.lang.Long getWaist () {
		return waist;
	}

	/**
	 * Set the value related to the column: waist
	 * @param waist the waist value
	 */
	public void setWaist (java.lang.Long waist) {
		this.waist = waist;
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
	 * Return the value associated with the column: investigation_name
	 */
	public java.lang.String getInvestigationName () {
		return investigationName;
	}

	/**
	 * Set the value related to the column: investigation_name
	 * @param investigationName the investigation_name value
	 */
	public void setInvestigationName (java.lang.String investigationName) {
		this.investigationName = investigationName;
	}



	/**
	 * Return the value associated with the column: blood_pre_max
	 */
	public java.lang.Long getBloodPreMax () {
		return bloodPreMax;
	}

	/**
	 * Set the value related to the column: blood_pre_max
	 * @param bloodPreMax the blood_pre_max value
	 */
	public void setBloodPreMax (java.lang.Long bloodPreMax) {
		this.bloodPreMax = bloodPreMax;
	}



	/**
	 * Return the value associated with the column: blood_pre_min
	 */
	public java.lang.Long getBloodPreMin () {
		return bloodPreMin;
	}

	/**
	 * Set the value related to the column: blood_pre_min
	 * @param bloodPreMin the blood_pre_min value
	 */
	public void setBloodPreMin (java.lang.Long bloodPreMin) {
		this.bloodPreMin = bloodPreMin;
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
	 * Return the value associated with the column: reg_followup_id
	 */
	public java.lang.String getRegFollowupId () {
		return regFollowupId;
	}

	/**
	 * Set the value related to the column: reg_followup_id
	 * @param regFollowupId the reg_followup_id value
	 */
	public void setRegFollowupId (java.lang.String regFollowupId) {
		this.regFollowupId = regFollowupId;
	}



	/**
	 * Return the value associated with the column: hip
	 */
	public java.lang.String getHip () {
		return hip;
	}

	/**
	 * Set the value related to the column: hip
	 * @param hip the hip value
	 */
	public void setHip (java.lang.String hip) {
		this.hip = hip;
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
	 * Return the value associated with the column: blood_sugar_rbs
	 */
	public java.lang.String getBloodSugarRbs () {
		return bloodSugarRbs;
	}

	/**
	 * Set the value related to the column: blood_sugar_rbs
	 * @param bloodSugarRbs the blood_sugar_rbs value
	 */
	public void setBloodSugarRbs (java.lang.String bloodSugarRbs) {
		this.bloodSugarRbs = bloodSugarRbs;
	}



	/**
	 * Return the value associated with the column: waist_hip_ratio
	 */
	public java.lang.String getWaistHipRatio () {
		return waistHipRatio;
	}

	/**
	 * Set the value related to the column: waist_hip_ratio
	 * @param waistHipRatio the waist_hip_ratio value
	 */
	public void setWaistHipRatio (java.lang.String waistHipRatio) {
		this.waistHipRatio = waistHipRatio;
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
		if (!(obj instanceof jkt.hms.masters.business.PhDiseaseRegistrationScreening)) return false;
		else {
			jkt.hms.masters.business.PhDiseaseRegistrationScreening phDiseaseRegistrationScreening = (jkt.hms.masters.business.PhDiseaseRegistrationScreening) obj;
			if (null == this.getId() || null == phDiseaseRegistrationScreening.getId()) return false;
			else return (this.getId().equals(phDiseaseRegistrationScreening.getId()));
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