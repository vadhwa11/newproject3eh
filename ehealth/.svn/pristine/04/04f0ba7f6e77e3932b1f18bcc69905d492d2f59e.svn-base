package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_job table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_job"
 */

public abstract class BaseMasJob implements Serializable {

	public static String REF = "MasJob";
	public static String PROP_JOB_CODE = "JobCode";
	public static String PROP_JOB_CLOSING_DATE = "JobClosingDate";
	public static String PROP_BASIC_QUALIFIC = "BasicQualific";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_JOB_OPENING_DATE = "JobOpeningDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PROFESS_QUALIFIC = "ProfessQualific";
	public static String PROP_SKILLS = "Skills";
	public static String PROP_JOB_STATUS = "JobStatus";
	public static String PROP_JOB_NAME = "JobName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_NO_POSITIONS = "NoPositions";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_PREVIOUS_EXPER = "PreviousExper";

	// constructors
	public BaseMasJob() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasJob(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasJob(java.lang.Integer id, java.lang.String jobCode) {

		this.setId(id);
		this.setJobCode(jobCode);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String jobCode;
	private java.lang.String jobName;
	private java.lang.Integer noPositions;
	private java.lang.String basicQualific;
	private java.lang.String professQualific;
	private java.lang.String skills;
	private java.math.BigDecimal previousExper;
	private java.util.Date jobOpeningDate;
	private java.util.Date jobClosingDate;
	private java.lang.String jobStatus;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="job_id"
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
	 * Return the value associated with the column: job_code
	 */
	public java.lang.String getJobCode() {
		return jobCode;
	}

	/**
	 * Set the value related to the column: job_code
	 * 
	 * @param jobCode
	 *            the job_code value
	 */
	public void setJobCode(java.lang.String jobCode) {
		this.jobCode = jobCode;
	}

	/**
	 * Return the value associated with the column: job_name
	 */
	public java.lang.String getJobName() {
		return jobName;
	}

	/**
	 * Set the value related to the column: job_name
	 * 
	 * @param jobName
	 *            the job_name value
	 */
	public void setJobName(java.lang.String jobName) {
		this.jobName = jobName;
	}

	/**
	 * Return the value associated with the column: no_positions
	 */
	public java.lang.Integer getNoPositions() {
		return noPositions;
	}

	/**
	 * Set the value related to the column: no_positions
	 * 
	 * @param noPositions
	 *            the no_positions value
	 */
	public void setNoPositions(java.lang.Integer noPositions) {
		this.noPositions = noPositions;
	}

	/**
	 * Return the value associated with the column: basic_qualific
	 */
	public java.lang.String getBasicQualific() {
		return basicQualific;
	}

	/**
	 * Set the value related to the column: basic_qualific
	 * 
	 * @param basicQualific
	 *            the basic_qualific value
	 */
	public void setBasicQualific(java.lang.String basicQualific) {
		this.basicQualific = basicQualific;
	}

	/**
	 * Return the value associated with the column: profess_qualific
	 */
	public java.lang.String getProfessQualific() {
		return professQualific;
	}

	/**
	 * Set the value related to the column: profess_qualific
	 * 
	 * @param professQualific
	 *            the profess_qualific value
	 */
	public void setProfessQualific(java.lang.String professQualific) {
		this.professQualific = professQualific;
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
	 * Return the value associated with the column: previous_exper
	 */
	public java.math.BigDecimal getPreviousExper() {
		return previousExper;
	}

	/**
	 * Set the value related to the column: previous_exper
	 * 
	 * @param previousExper
	 *            the previous_exper value
	 */
	public void setPreviousExper(java.math.BigDecimal previousExper) {
		this.previousExper = previousExper;
	}

	/**
	 * Return the value associated with the column: job_opening_date
	 */
	public java.util.Date getJobOpeningDate() {
		return jobOpeningDate;
	}

	/**
	 * Set the value related to the column: job_opening_date
	 * 
	 * @param jobOpeningDate
	 *            the job_opening_date value
	 */
	public void setJobOpeningDate(java.util.Date jobOpeningDate) {
		this.jobOpeningDate = jobOpeningDate;
	}

	/**
	 * Return the value associated with the column: job_closing_date
	 */
	public java.util.Date getJobClosingDate() {
		return jobClosingDate;
	}

	/**
	 * Set the value related to the column: job_closing_date
	 * 
	 * @param jobClosingDate
	 *            the job_closing_date value
	 */
	public void setJobClosingDate(java.util.Date jobClosingDate) {
		this.jobClosingDate = jobClosingDate;
	}

	/**
	 * Return the value associated with the column: job_status
	 */
	public java.lang.String getJobStatus() {
		return jobStatus;
	}

	/**
	 * Set the value related to the column: job_status
	 * 
	 * @param jobStatus
	 *            the job_status value
	 */
	public void setJobStatus(java.lang.String jobStatus) {
		this.jobStatus = jobStatus;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasJob)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasJob masJob = (jkt.hrms.masters.business.MasJob) obj;
			if (null == this.getId() || null == masJob.getId()) {
				return false;
			} else {
				return (this.getId().equals(masJob.getId()));
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