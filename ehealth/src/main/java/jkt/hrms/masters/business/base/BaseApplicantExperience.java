package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the applicant_experience
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="applicant_experience"
 */

public abstract class BaseApplicantExperience implements Serializable {

	public static String REF = "ApplicantExperience";
	public static String PROP_CUR_SER_END_DATE = "CurSerEndDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PRE_EMPLOYER = "PreEmployer";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_CUR_EMPLOYER = "CurEmployer";
	public static String PROP_PRE_DESIGNATION = "PreDesignation";
	public static String PROP_CUR_END_REASON = "CurEndReason";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CITY = "City";
	public static String PROP_APPLICANT = "Applicant";
	public static String PROP_TOTAL_EXPERIENCE = "TotalExperience";
	public static String PROP_SKILLS = "Skills";
	public static String PROP_PRE_SERVICE_END_DATE = "PreServiceEndDate";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_PRE_CITY = "PreCity";
	public static String PROP_PRE_STATE = "PreState";
	public static String PROP_STATE = "State";
	public static String PROP_AWARDS = "Awards";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_JOB_RESPONSIBILITY = "JobResponsibility";
	public static String PROP_CUR_SER_START_DATE = "CurSerStartDate";
	public static String PROP_PRE_ADDRESS = "PreAddress";
	public static String PROP_PRE_COUNTRY = "PreCountry";
	public static String PROP_DURATION_TYPE = "DurationType";
	public static String PROP_PRE_END_REASON = "PreEndReason";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_PRE_SERVICE_START_DATE = "PreServiceStartDate";
	public static String PROP_ID = "Id";

	// constructors
	public BaseApplicantExperience() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApplicantExperience(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Float totalExperience;
	private java.util.Date preServiceStartDate;
	private java.util.Date preServiceEndDate;
	private java.lang.String preEmployer;
	private java.lang.String designation;
	private java.lang.String awards;
	private java.lang.String skills;
	private java.lang.String jobResponsibility;
	private java.lang.String address;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date curSerStartDate;
	private java.util.Date curSerEndDate;
	private java.lang.String curEmployer;
	private java.lang.String preDesignation;
	private java.lang.String preAddress;
	private java.lang.String curEndReason;
	private java.lang.String preEndReason;

	// many to one
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasCountry preCountry;
	private jkt.hms.masters.business.MasState preState;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hrms.masters.business.MasDurationType durationType;
	private jkt.hrms.masters.business.MasApplicant applicant;
	private jkt.hms.masters.business.MasDistrict preCity;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: total_experience
	 */
	public java.lang.Float getTotalExperience() {
		return totalExperience;
	}

	/**
	 * Set the value related to the column: total_experience
	 * 
	 * @param totalExperience
	 *            the total_experience value
	 */
	public void setTotalExperience(java.lang.Float totalExperience) {
		this.totalExperience = totalExperience;
	}

	/**
	 * Return the value associated with the column: pre_service_start_date
	 */
	public java.util.Date getPreServiceStartDate() {
		return preServiceStartDate;
	}

	/**
	 * Set the value related to the column: pre_service_start_date
	 * 
	 * @param preServiceStartDate
	 *            the pre_service_start_date value
	 */
	public void setPreServiceStartDate(java.util.Date preServiceStartDate) {
		this.preServiceStartDate = preServiceStartDate;
	}

	/**
	 * Return the value associated with the column: pre_service_end_date
	 */
	public java.util.Date getPreServiceEndDate() {
		return preServiceEndDate;
	}

	/**
	 * Set the value related to the column: pre_service_end_date
	 * 
	 * @param preServiceEndDate
	 *            the pre_service_end_date value
	 */
	public void setPreServiceEndDate(java.util.Date preServiceEndDate) {
		this.preServiceEndDate = preServiceEndDate;
	}

	/**
	 * Return the value associated with the column: pre_employer
	 */
	public java.lang.String getPreEmployer() {
		return preEmployer;
	}

	/**
	 * Set the value related to the column: pre_employer
	 * 
	 * @param preEmployer
	 *            the pre_employer value
	 */
	public void setPreEmployer(java.lang.String preEmployer) {
		this.preEmployer = preEmployer;
	}

	/**
	 * Return the value associated with the column: designation
	 */
	public java.lang.String getDesignation() {
		return designation;
	}

	/**
	 * Set the value related to the column: designation
	 * 
	 * @param designation
	 *            the designation value
	 */
	public void setDesignation(java.lang.String designation) {
		this.designation = designation;
	}

	/**
	 * Return the value associated with the column: awards
	 */
	public java.lang.String getAwards() {
		return awards;
	}

	/**
	 * Set the value related to the column: awards
	 * 
	 * @param awards
	 *            the awards value
	 */
	public void setAwards(java.lang.String awards) {
		this.awards = awards;
	}

	/**
	 * Return the value associated with the column: skills
	 */
	public java.lang.String getSkills() {
		return skills;
	}

	/**
	 * Set the value related to the column: skills
	 * 
	 * @param skills
	 *            the skills value
	 */
	public void setSkills(java.lang.String skills) {
		this.skills = skills;
	}

	/**
	 * Return the value associated with the column: job_responsibility
	 */
	public java.lang.String getJobResponsibility() {
		return jobResponsibility;
	}

	/**
	 * Set the value related to the column: job_responsibility
	 * 
	 * @param jobResponsibility
	 *            the job_responsibility value
	 */
	public void setJobResponsibility(java.lang.String jobResponsibility) {
		this.jobResponsibility = jobResponsibility;
	}

	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * 
	 * @param address
	 *            the address value
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: cur_ser_start_date
	 */
	public java.util.Date getCurSerStartDate() {
		return curSerStartDate;
	}

	/**
	 * Set the value related to the column: cur_ser_start_date
	 * 
	 * @param curSerStartDate
	 *            the cur_ser_start_date value
	 */
	public void setCurSerStartDate(java.util.Date curSerStartDate) {
		this.curSerStartDate = curSerStartDate;
	}

	/**
	 * Return the value associated with the column: cur_ser_end_date
	 */
	public java.util.Date getCurSerEndDate() {
		return curSerEndDate;
	}

	/**
	 * Set the value related to the column: cur_ser_end_date
	 * 
	 * @param curSerEndDate
	 *            the cur_ser_end_date value
	 */
	public void setCurSerEndDate(java.util.Date curSerEndDate) {
		this.curSerEndDate = curSerEndDate;
	}

	/**
	 * Return the value associated with the column: cur_employer
	 */
	public java.lang.String getCurEmployer() {
		return curEmployer;
	}

	/**
	 * Set the value related to the column: cur_employer
	 * 
	 * @param curEmployer
	 *            the cur_employer value
	 */
	public void setCurEmployer(java.lang.String curEmployer) {
		this.curEmployer = curEmployer;
	}

	/**
	 * Return the value associated with the column: pre_designation
	 */
	public java.lang.String getPreDesignation() {
		return preDesignation;
	}

	/**
	 * Set the value related to the column: pre_designation
	 * 
	 * @param preDesignation
	 *            the pre_designation value
	 */
	public void setPreDesignation(java.lang.String preDesignation) {
		this.preDesignation = preDesignation;
	}

	/**
	 * Return the value associated with the column: pre_address
	 */
	public java.lang.String getPreAddress() {
		return preAddress;
	}

	/**
	 * Set the value related to the column: pre_address
	 * 
	 * @param preAddress
	 *            the pre_address value
	 */
	public void setPreAddress(java.lang.String preAddress) {
		this.preAddress = preAddress;
	}

	/**
	 * Return the value associated with the column: cur_end_reason
	 */
	public java.lang.String getCurEndReason() {
		return curEndReason;
	}

	/**
	 * Set the value related to the column: cur_end_reason
	 * 
	 * @param curEndReason
	 *            the cur_end_reason value
	 */
	public void setCurEndReason(java.lang.String curEndReason) {
		this.curEndReason = curEndReason;
	}

	/**
	 * Return the value associated with the column: pre_end_reason
	 */
	public java.lang.String getPreEndReason() {
		return preEndReason;
	}

	/**
	 * Set the value related to the column: pre_end_reason
	 * 
	 * @param preEndReason
	 *            the pre_end_reason value
	 */
	public void setPreEndReason(java.lang.String preEndReason) {
		this.preEndReason = preEndReason;
	}

	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState() {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * 
	 * @param state
	 *            the state_id value
	 */
	public void setState(jkt.hms.masters.business.MasState state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: pre_country_id
	 */
	public jkt.hms.masters.business.MasCountry getPreCountry() {
		return preCountry;
	}

	/**
	 * Set the value related to the column: pre_country_id
	 * 
	 * @param preCountry
	 *            the pre_country_id value
	 */
	public void setPreCountry(jkt.hms.masters.business.MasCountry preCountry) {
		this.preCountry = preCountry;
	}

	/**
	 * Return the value associated with the column: pre_state_id
	 */
	public jkt.hms.masters.business.MasState getPreState() {
		return preState;
	}

	/**
	 * Set the value related to the column: pre_state_id
	 * 
	 * @param preState
	 *            the pre_state_id value
	 */
	public void setPreState(jkt.hms.masters.business.MasState preState) {
		this.preState = preState;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: country_id
	 */
	public jkt.hms.masters.business.MasCountry getCountry() {
		return country;
	}

	/**
	 * Set the value related to the column: country_id
	 * 
	 * @param country
	 *            the country_id value
	 */
	public void setCountry(jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}

	/**
	 * Return the value associated with the column: city_id
	 */
	public jkt.hms.masters.business.MasDistrict getCity() {
		return city;
	}

	/**
	 * Set the value related to the column: city_id
	 * 
	 * @param city
	 *            the city_id value
	 */
	public void setCity(jkt.hms.masters.business.MasDistrict city) {
		this.city = city;
	}

	/**
	 * Return the value associated with the column: duration_type_id
	 */
	public jkt.hrms.masters.business.MasDurationType getDurationType() {
		return durationType;
	}

	/**
	 * Set the value related to the column: duration_type_id
	 * 
	 * @param durationType
	 *            the duration_type_id value
	 */
	public void setDurationType(
			jkt.hrms.masters.business.MasDurationType durationType) {
		this.durationType = durationType;
	}

	/**
	 * Return the value associated with the column: applicant_id
	 */
	public jkt.hrms.masters.business.MasApplicant getApplicant() {
		return applicant;
	}

	/**
	 * Set the value related to the column: applicant_id
	 * 
	 * @param applicant
	 *            the applicant_id value
	 */
	public void setApplicant(jkt.hrms.masters.business.MasApplicant applicant) {
		this.applicant = applicant;
	}

	/**
	 * Return the value associated with the column: pre_city_id
	 */
	public jkt.hms.masters.business.MasDistrict getPreCity() {
		return preCity;
	}

	/**
	 * Set the value related to the column: pre_city_id
	 * 
	 * @param preCity
	 *            the pre_city_id value
	 */
	public void setPreCity(jkt.hms.masters.business.MasDistrict preCity) {
		this.preCity = preCity;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.ApplicantExperience)) {
			return false;
		} else {
			jkt.hrms.masters.business.ApplicantExperience applicantExperience = (jkt.hrms.masters.business.ApplicantExperience) obj;
			if (null == this.getId() || null == applicantExperience.getId()) {
				return false;
			} else {
				return (this.getId().equals(applicantExperience.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}