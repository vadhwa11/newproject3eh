package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_antenatal_card_medical_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_antenatal_card_medical_history"
 */

public abstract class BaseOpdAntenatalCardMedicalHistory  implements Serializable {

	public static String REF = "OpdAntenatalCardMedicalHistory";
	public static String PROP_CHRONIC_DISEASE = "ChronicDisease";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INFECTION_MONTHS = "InfectionMonths";
	public static String PROP_PAST_SURGERY_HOSPITAL = "PastSurgeryHospital";
	public static String PROP_YEARS = "Years";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PAST_SURGERY_NAME = "PastSurgeryName";
	public static String PROP_VISIT = "Visit";
	public static String PROP_INFECTION = "Infection";
	public static String PROP_COMORBIDITY = "Comorbidity";
	public static String PROP_INFECTION_OTHERS = "InfectionOthers";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PAST_SURGERY_REMARKS = "PastSurgeryRemarks";
	public static String PROP_OTHER_DISEASE = "OtherDisease";
	public static String PROP_OPD_ANTENATAL_CARD = "OpdAntenatalCard";
	public static String PROP_MONTHS = "Months";
	public static String PROP_PAST_SURGERY_YEARS = "PastSurgeryYears";
	public static String PROP_ID = "Id";
	public static String PROP_INFECTION_REMARKS = "InfectionRemarks";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INFECTION_YEARS = "InfectionYears";


	// constructors
	public BaseOpdAntenatalCardMedicalHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdAntenatalCardMedicalHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String comorbidity;
	private java.lang.String years;
	private java.lang.String months;
	private java.lang.String remarks;
	private java.lang.String chronicDisease;
	private java.lang.String otherDisease;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String infection;
	private java.lang.String infectionYears;
	private java.lang.String infectionMonths;
	private java.lang.String infectionRemarks;
	private java.lang.String infectionOthers;
	private java.lang.String pastSurgeryName;
	private java.lang.String pastSurgeryYears;
	private java.lang.String pastSurgeryHospital;
	private java.lang.String pastSurgeryRemarks;

	// many to one
	private jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_antenatal_card_medical_history_id"
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
	 * Return the value associated with the column: comorbidity
	 */
	public java.lang.String getComorbidity () {
		return comorbidity;
	}

	/**
	 * Set the value related to the column: comorbidity
	 * @param comorbidity the comorbidity value
	 */
	public void setComorbidity (java.lang.String comorbidity) {
		this.comorbidity = comorbidity;
	}



	/**
	 * Return the value associated with the column: years
	 */
	public java.lang.String getYears () {
		return years;
	}

	/**
	 * Set the value related to the column: years
	 * @param years the years value
	 */
	public void setYears (java.lang.String years) {
		this.years = years;
	}



	/**
	 * Return the value associated with the column: months
	 */
	public java.lang.String getMonths () {
		return months;
	}

	/**
	 * Set the value related to the column: months
	 * @param months the months value
	 */
	public void setMonths (java.lang.String months) {
		this.months = months;
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
	 * Return the value associated with the column: chronic_disease
	 */
	public java.lang.String getChronicDisease () {
		return chronicDisease;
	}

	/**
	 * Set the value related to the column: chronic_disease
	 * @param chronicDisease the chronic_disease value
	 */
	public void setChronicDisease (java.lang.String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}



	/**
	 * Return the value associated with the column: other_disease
	 */
	public java.lang.String getOtherDisease () {
		return otherDisease;
	}

	/**
	 * Set the value related to the column: other_disease
	 * @param otherDisease the other_disease value
	 */
	public void setOtherDisease (java.lang.String otherDisease) {
		this.otherDisease = otherDisease;
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
	 * Return the value associated with the column: infection
	 */
	public java.lang.String getInfection () {
		return infection;
	}

	/**
	 * Set the value related to the column: infection
	 * @param infection the infection value
	 */
	public void setInfection (java.lang.String infection) {
		this.infection = infection;
	}



	/**
	 * Return the value associated with the column: infection_years
	 */
	public java.lang.String getInfectionYears () {
		return infectionYears;
	}

	/**
	 * Set the value related to the column: infection_years
	 * @param infectionYears the infection_years value
	 */
	public void setInfectionYears (java.lang.String infectionYears) {
		this.infectionYears = infectionYears;
	}



	/**
	 * Return the value associated with the column: infection_months
	 */
	public java.lang.String getInfectionMonths () {
		return infectionMonths;
	}

	/**
	 * Set the value related to the column: infection_months
	 * @param infectionMonths the infection_months value
	 */
	public void setInfectionMonths (java.lang.String infectionMonths) {
		this.infectionMonths = infectionMonths;
	}



	/**
	 * Return the value associated with the column: infection_remarks
	 */
	public java.lang.String getInfectionRemarks () {
		return infectionRemarks;
	}

	/**
	 * Set the value related to the column: infection_remarks
	 * @param infectionRemarks the infection_remarks value
	 */
	public void setInfectionRemarks (java.lang.String infectionRemarks) {
		this.infectionRemarks = infectionRemarks;
	}



	/**
	 * Return the value associated with the column: infection_others
	 */
	public java.lang.String getInfectionOthers () {
		return infectionOthers;
	}

	/**
	 * Set the value related to the column: infection_others
	 * @param infectionOthers the infection_others value
	 */
	public void setInfectionOthers (java.lang.String infectionOthers) {
		this.infectionOthers = infectionOthers;
	}



	/**
	 * Return the value associated with the column: past_surgery_name
	 */
	public java.lang.String getPastSurgeryName () {
		return pastSurgeryName;
	}

	/**
	 * Set the value related to the column: past_surgery_name
	 * @param pastSurgeryName the past_surgery_name value
	 */
	public void setPastSurgeryName (java.lang.String pastSurgeryName) {
		this.pastSurgeryName = pastSurgeryName;
	}



	/**
	 * Return the value associated with the column: past_surgery_years
	 */
	public java.lang.String getPastSurgeryYears () {
		return pastSurgeryYears;
	}

	/**
	 * Set the value related to the column: past_surgery_years
	 * @param pastSurgeryYears the past_surgery_years value
	 */
	public void setPastSurgeryYears (java.lang.String pastSurgeryYears) {
		this.pastSurgeryYears = pastSurgeryYears;
	}



	/**
	 * Return the value associated with the column: past_surgery_hospital
	 */
	public java.lang.String getPastSurgeryHospital () {
		return pastSurgeryHospital;
	}

	/**
	 * Set the value related to the column: past_surgery_hospital
	 * @param pastSurgeryHospital the past_surgery_hospital value
	 */
	public void setPastSurgeryHospital (java.lang.String pastSurgeryHospital) {
		this.pastSurgeryHospital = pastSurgeryHospital;
	}



	/**
	 * Return the value associated with the column: past_surgery_remarks
	 */
	public java.lang.String getPastSurgeryRemarks () {
		return pastSurgeryRemarks;
	}

	/**
	 * Set the value related to the column: past_surgery_remarks
	 * @param pastSurgeryRemarks the past_surgery_remarks value
	 */
	public void setPastSurgeryRemarks (java.lang.String pastSurgeryRemarks) {
		this.pastSurgeryRemarks = pastSurgeryRemarks;
	}



	/**
	 * Return the value associated with the column: opd_antenatal_card_id
	 */
	public jkt.hms.masters.business.OpdAntenatalCard getOpdAntenatalCard () {
		return opdAntenatalCard;
	}

	/**
	 * Set the value related to the column: opd_antenatal_card_id
	 * @param opdAntenatalCard the opd_antenatal_card_id value
	 */
	public void setOpdAntenatalCard (jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard) {
		this.opdAntenatalCard = opdAntenatalCard;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdAntenatalCardMedicalHistory)) return false;
		else {
			jkt.hms.masters.business.OpdAntenatalCardMedicalHistory opdAntenatalCardMedicalHistory = (jkt.hms.masters.business.OpdAntenatalCardMedicalHistory) obj;
			if (null == this.getId() || null == opdAntenatalCardMedicalHistory.getId()) return false;
			else return (this.getId().equals(opdAntenatalCardMedicalHistory.getId()));
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