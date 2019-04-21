package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_duration_type table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_duration_type"
 */

public abstract class BaseMasDurationType implements Serializable {

	public static String REF = "MasDurationType";
	public static String PROP_STATUS = "Status";
	public static String PROP_DURATION_TYPE_NAME = "DurationTypeName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DURATION_TYPE_CODE = "DurationTypeCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasDurationType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDurationType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String durationTypeCode;
	private java.lang.String durationTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hrms.masters.business.ApplicantEducation> applicantEducations;

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
	 * Return the value associated with the column: duration_type_code
	 */
	public java.lang.String getDurationTypeCode() {
		return durationTypeCode;
	}

	/**
	 * Set the value related to the column: duration_type_code
	 * 
	 * @param durationTypeCode
	 *            the duration_type_code value
	 */
	public void setDurationTypeCode(java.lang.String durationTypeCode) {
		this.durationTypeCode = durationTypeCode;
	}

	/**
	 * Return the value associated with the column: duration_type_name
	 */
	public java.lang.String getDurationTypeName() {
		return durationTypeName;
	}

	/**
	 * Set the value related to the column: duration_type_name
	 * 
	 * @param durationTypeName
	 *            the duration_type_name value
	 */
	public void setDurationTypeName(java.lang.String durationTypeName) {
		this.durationTypeName = durationTypeName;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: ApplicantEducations
	 */
	public java.util.Set<jkt.hrms.masters.business.ApplicantEducation> getApplicantEducations() {
		return applicantEducations;
	}

	/**
	 * Set the value related to the column: ApplicantEducations
	 * 
	 * @param applicantEducations
	 *            the ApplicantEducations value
	 */
	public void setApplicantEducations(
			java.util.Set<jkt.hrms.masters.business.ApplicantEducation> applicantEducations) {
		this.applicantEducations = applicantEducations;
	}

	public void addToApplicantEducations(
			jkt.hrms.masters.business.ApplicantEducation applicantEducation) {
		if (null == getApplicantEducations()) {
			setApplicantEducations(new java.util.TreeSet<jkt.hrms.masters.business.ApplicantEducation>());
		}
		getApplicantEducations().add(applicantEducation);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasDurationType)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasDurationType masDurationType = (jkt.hrms.masters.business.MasDurationType) obj;
			if (null == this.getId() || null == masDurationType.getId()) {
				return false;
			} else {
				return (this.getId().equals(masDurationType.getId()));
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