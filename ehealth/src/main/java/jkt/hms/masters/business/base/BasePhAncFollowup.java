package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_anc_followup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_anc_followup"
 */

public abstract class BasePhAncFollowup  implements Serializable {

	public static String REF = "PhAncFollowup";
	public static String PROP_AGE = "Age";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BOOSTER = "Booster";
	public static String PROP_ABNORMAL_MOVEMENT_DAYS = "AbnormalMovementDays";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_FOLLOWUP_DATE = "FollowupDate";
	public static String PROP_VALIDATION = "Validation";
	public static String PROP_TT2 = "Tt2";
	public static String PROP_TT1 = "Tt1";
	public static String PROP_BLOOD_SUGAR = "BloodSugar";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_REFER_TO_TYPE = "ReferToType";
	public static String PROP_HB = "Hb";
	public static String PROP_IRON_FOLIC_QTY = "IronFolicQty";
	public static String PROP_BLOOD_PRESSURE_MIN = "BloodPressureMin";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_SERVER_PK = "ServerPk";
	public static String PROP_URINE_SUGAR = "UrineSugar";
	public static String PROP_ANC_FOL_ID = "AncFolId";
	public static String PROP_ANC_REG_ID = "AncRegId";
	public static String PROP_PALLOR = "Pallor";
	public static String PROP_ABNORMAL_MOVEMENT = "AbnormalMovement";
	public static String PROP_ISSUE_STAGE = "IssueStage";
	public static String PROP_ID = "Id";
	public static String PROP_URINE_ALBUMIN = "UrineAlbumin";
	public static String PROP_BLOOD_PRESSURE_MAX = "BloodPressureMax";
	public static String PROP_REFER_TO_HOSPITAL = "ReferToHospital";
	public static String PROP_FOLLOWUP_STATUS = "FollowupStatus";


	// constructors
	public BasePhAncFollowup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhAncFollowup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long serverPk;
	private java.lang.String ancRegId;
	private java.util.Date followupDate;
	private java.lang.Long age;
	private java.lang.String pallor;
	private java.math.BigDecimal height;
	private java.math.BigDecimal weight;
	private java.lang.Long bloodPressureMin;
	private java.lang.Long bloodPressureMax;
	private java.math.BigDecimal hb;
	private java.lang.String urineSugar;
	private java.lang.String urineAlbumin;
	private java.lang.String bloodSugar;
	private java.lang.String abnormalMovement;
	private java.lang.Long abnormalMovementDays;
	private java.lang.Long referToType;
	private java.lang.String referToHospital;
	private java.util.Date tt1;
	private java.util.Date tt2;
	private java.lang.String ironFolicQty;
	private java.lang.String issueStage;
	private java.lang.String validation;
	private java.lang.String remarks;
	private java.lang.String followupStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date booster;
	private java.lang.String ancFolId;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



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
	 * Return the value associated with the column: anc_reg_id
	 */
	public java.lang.String getAncRegId () {
		return ancRegId;
	}

	/**
	 * Set the value related to the column: anc_reg_id
	 * @param ancRegId the anc_reg_id value
	 */
	public void setAncRegId (java.lang.String ancRegId) {
		this.ancRegId = ancRegId;
	}



	/**
	 * Return the value associated with the column: followup_date
	 */
	public java.util.Date getFollowupDate () {
		return followupDate;
	}

	/**
	 * Set the value related to the column: followup_date
	 * @param followupDate the followup_date value
	 */
	public void setFollowupDate (java.util.Date followupDate) {
		this.followupDate = followupDate;
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
	 * Return the value associated with the column: blood_pressure_min
	 */
	public java.lang.Long getBloodPressureMin () {
		return bloodPressureMin;
	}

	/**
	 * Set the value related to the column: blood_pressure_min
	 * @param bloodPressureMin the blood_pressure_min value
	 */
	public void setBloodPressureMin (java.lang.Long bloodPressureMin) {
		this.bloodPressureMin = bloodPressureMin;
	}



	/**
	 * Return the value associated with the column: blood_pressure_max
	 */
	public java.lang.Long getBloodPressureMax () {
		return bloodPressureMax;
	}

	/**
	 * Set the value related to the column: blood_pressure_max
	 * @param bloodPressureMax the blood_pressure_max value
	 */
	public void setBloodPressureMax (java.lang.Long bloodPressureMax) {
		this.bloodPressureMax = bloodPressureMax;
	}



	/**
	 * Return the value associated with the column: hb
	 */
	public java.math.BigDecimal getHb () {
		return hb;
	}

	/**
	 * Set the value related to the column: hb
	 * @param hb the hb value
	 */
	public void setHb (java.math.BigDecimal hb) {
		this.hb = hb;
	}



	/**
	 * Return the value associated with the column: urine_sugar
	 */
	public java.lang.String getUrineSugar () {
		return urineSugar;
	}

	/**
	 * Set the value related to the column: urine_sugar
	 * @param urineSugar the urine_sugar value
	 */
	public void setUrineSugar (java.lang.String urineSugar) {
		this.urineSugar = urineSugar;
	}



	/**
	 * Return the value associated with the column: urine_albumin
	 */
	public java.lang.String getUrineAlbumin () {
		return urineAlbumin;
	}

	/**
	 * Set the value related to the column: urine_albumin
	 * @param urineAlbumin the urine_albumin value
	 */
	public void setUrineAlbumin (java.lang.String urineAlbumin) {
		this.urineAlbumin = urineAlbumin;
	}



	/**
	 * Return the value associated with the column: blood_sugar
	 */
	public java.lang.String getBloodSugar () {
		return bloodSugar;
	}

	/**
	 * Set the value related to the column: blood_sugar
	 * @param bloodSugar the blood_sugar value
	 */
	public void setBloodSugar (java.lang.String bloodSugar) {
		this.bloodSugar = bloodSugar;
	}



	/**
	 * Return the value associated with the column: abnormal_movement
	 */
	public java.lang.String getAbnormalMovement () {
		return abnormalMovement;
	}

	/**
	 * Set the value related to the column: abnormal_movement
	 * @param abnormalMovement the abnormal_movement value
	 */
	public void setAbnormalMovement (java.lang.String abnormalMovement) {
		this.abnormalMovement = abnormalMovement;
	}



	/**
	 * Return the value associated with the column: abnormal_movement_days
	 */
	public java.lang.Long getAbnormalMovementDays () {
		return abnormalMovementDays;
	}

	/**
	 * Set the value related to the column: abnormal_movement_days
	 * @param abnormalMovementDays the abnormal_movement_days value
	 */
	public void setAbnormalMovementDays (java.lang.Long abnormalMovementDays) {
		this.abnormalMovementDays = abnormalMovementDays;
	}



	/**
	 * Return the value associated with the column: refer_to_type
	 */
	public java.lang.Long getReferToType () {
		return referToType;
	}

	/**
	 * Set the value related to the column: refer_to_type
	 * @param referToType the refer_to_type value
	 */
	public void setReferToType (java.lang.Long referToType) {
		this.referToType = referToType;
	}



	/**
	 * Return the value associated with the column: refer_to_hospital
	 */
	public java.lang.String getReferToHospital () {
		return referToHospital;
	}

	/**
	 * Set the value related to the column: refer_to_hospital
	 * @param referToHospital the refer_to_hospital value
	 */
	public void setReferToHospital (java.lang.String referToHospital) {
		this.referToHospital = referToHospital;
	}



	/**
	 * Return the value associated with the column: tt1
	 */
	public java.util.Date getTt1 () {
		return tt1;
	}

	/**
	 * Set the value related to the column: tt1
	 * @param tt1 the tt1 value
	 */
	public void setTt1 (java.util.Date tt1) {
		this.tt1 = tt1;
	}



	/**
	 * Return the value associated with the column: tt2
	 */
	public java.util.Date getTt2 () {
		return tt2;
	}

	/**
	 * Set the value related to the column: tt2
	 * @param tt2 the tt2 value
	 */
	public void setTt2 (java.util.Date tt2) {
		this.tt2 = tt2;
	}



	/**
	 * Return the value associated with the column: iron_folic_qty
	 */
	public java.lang.String getIronFolicQty () {
		return ironFolicQty;
	}

	/**
	 * Set the value related to the column: iron_folic_qty
	 * @param ironFolicQty the iron_folic_qty value
	 */
	public void setIronFolicQty (java.lang.String ironFolicQty) {
		this.ironFolicQty = ironFolicQty;
	}



	/**
	 * Return the value associated with the column: issue_stage
	 */
	public java.lang.String getIssueStage () {
		return issueStage;
	}

	/**
	 * Set the value related to the column: issue_stage
	 * @param issueStage the issue_stage value
	 */
	public void setIssueStage (java.lang.String issueStage) {
		this.issueStage = issueStage;
	}



	/**
	 * Return the value associated with the column: validation
	 */
	public java.lang.String getValidation () {
		return validation;
	}

	/**
	 * Set the value related to the column: validation
	 * @param validation the validation value
	 */
	public void setValidation (java.lang.String validation) {
		this.validation = validation;
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
	 * Return the value associated with the column: followup_status
	 */
	public java.lang.String getFollowupStatus () {
		return followupStatus;
	}

	/**
	 * Set the value related to the column: followup_status
	 * @param followupStatus the followup_status value
	 */
	public void setFollowupStatus (java.lang.String followupStatus) {
		this.followupStatus = followupStatus;
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
	 * Return the value associated with the column: booster
	 */
	public java.util.Date getBooster () {
		return booster;
	}

	/**
	 * Set the value related to the column: booster
	 * @param booster the booster value
	 */
	public void setBooster (java.util.Date booster) {
		this.booster = booster;
	}



	/**
	 * Return the value associated with the column: anc_fol_id
	 */
	public java.lang.String getAncFolId () {
		return ancFolId;
	}

	/**
	 * Set the value related to the column: anc_fol_id
	 * @param ancFolId the anc_fol_id value
	 */
	public void setAncFolId (java.lang.String ancFolId) {
		this.ancFolId = ancFolId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhAncFollowup)) return false;
		else {
			jkt.hms.masters.business.PhAncFollowup phAncFollowup = (jkt.hms.masters.business.PhAncFollowup) obj;
			if (null == this.getId() || null == phAncFollowup.getId()) return false;
			else return (this.getId().equals(phAncFollowup.getId()));
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