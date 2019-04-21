package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumestatushistory
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumestatushistory"
 */

public abstract class BaseResumestatushistory implements Serializable {

	public static String REF = "Resumestatushistory";
	public static String PROP_RELOCATION_REIMBURSEMENT = "RelocationReimbursement";
	public static String PROP_CURRENT_C_T_C = "CurrentCTC";
	public static String PROP_PROBATION_PERIOD = "ProbationPeriod";
	public static String PROP_LOCATION = "Location";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_RESUME_STATUS = "ResumeStatus";
	public static String PROP_DATE_OF_JOIN = "DateOfJoin";
	public static String PROP_CTC = "Ctc";
	public static String PROP_PROJECT_ASSIGN = "ProjectAssign";
	public static String PROP_EXPECTED_C_T_C = "ExpectedCTC";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_DATE = "Date";
	public static String PROP_ID = "Id";
	public static String PROP_RESUMESTATUSMASTER = "Resumestatusmaster";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_RESUME_ID = "ResumeId";
	public static String PROP_NOTICE_PERIOD = "NoticePeriod";
	public static String PROP_SALARY_REMARKS = "SalaryRemarks";

	// constructors
	public BaseResumestatushistory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumestatushistory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer statusId;
	private java.lang.Integer resumeId;
	private java.lang.String dateOfJoin;
	private java.lang.String projectAssign;
	private java.lang.String ctc;
	private java.lang.String currentCTC;
	private java.lang.String expectedCTC;
	private java.lang.String salaryRemarks;
	private java.lang.String currency;
	private java.lang.String location;
	private java.lang.String remarks;
	private java.util.Date date;
	private java.lang.Integer relocationReimbursement;
	private java.lang.Integer noticePeriod;
	private java.lang.Integer probationPeriod;

	// many to one
	private jkt.hrms.recruitment.masters.business.Resumestatusmaster resumestatusmaster;
	private jkt.hrms.recruitment.masters.business.Resumepersonaldetails resumeStatus;
	private jkt.hms.masters.business.MasRank designation;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="id"
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
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Return the value associated with the column: resume_id
	 */
	public java.lang.Integer getResumeId() {
		return resumeId;
	}

	/**
	 * Set the value related to the column: resume_id
	 * 
	 * @param resumeId
	 *            the resume_id value
	 */
	public void setResumeId(java.lang.Integer resumeId) {
		this.resumeId = resumeId;
	}

	/**
	 * Return the value associated with the column: date_of_join
	 */
	public java.lang.String getDateOfJoin() {
		return dateOfJoin;
	}

	/**
	 * Set the value related to the column: date_of_join
	 * 
	 * @param dateOfJoin
	 *            the date_of_join value
	 */
	public void setDateOfJoin(java.lang.String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	/**
	 * Return the value associated with the column: project_assign
	 */
	public java.lang.String getProjectAssign() {
		return projectAssign;
	}

	/**
	 * Set the value related to the column: project_assign
	 * 
	 * @param projectAssign
	 *            the project_assign value
	 */
	public void setProjectAssign(java.lang.String projectAssign) {
		this.projectAssign = projectAssign;
	}

	/**
	 * Return the value associated with the column: CTC
	 */
	public java.lang.String getCtc() {
		return ctc;
	}

	/**
	 * Set the value related to the column: CTC
	 * 
	 * @param ctc
	 *            the CTC value
	 */
	public void setCtc(java.lang.String ctc) {
		this.ctc = ctc;
	}

	/**
	 * Return the value associated with the column: current_ctc
	 */
	public java.lang.String getCurrentCTC() {
		return currentCTC;
	}

	/**
	 * Set the value related to the column: current_ctc
	 * 
	 * @param currentCTC
	 *            the current_ctc value
	 */
	public void setCurrentCTC(java.lang.String currentCTC) {
		this.currentCTC = currentCTC;
	}

	/**
	 * Return the value associated with the column: expected_ctc
	 */
	public java.lang.String getExpectedCTC() {
		return expectedCTC;
	}

	/**
	 * Set the value related to the column: expected_ctc
	 * 
	 * @param expectedCTC
	 *            the expected_ctc value
	 */
	public void setExpectedCTC(java.lang.String expectedCTC) {
		this.expectedCTC = expectedCTC;
	}

	/**
	 * Return the value associated with the column: salary_remarks
	 */
	public java.lang.String getSalaryRemarks() {
		return salaryRemarks;
	}

	/**
	 * Set the value related to the column: salary_remarks
	 * 
	 * @param salaryRemarks
	 *            the salary_remarks value
	 */
	public void setSalaryRemarks(java.lang.String salaryRemarks) {
		this.salaryRemarks = salaryRemarks;
	}

	/**
	 * Return the value associated with the column: currency
	 */
	public java.lang.String getCurrency() {
		return currency;
	}

	/**
	 * Set the value related to the column: currency
	 * 
	 * @param currency
	 *            the currency value
	 */
	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}

	/**
	 * Return the value associated with the column: location
	 */
	public java.lang.String getLocation() {
		return location;
	}

	/**
	 * Set the value related to the column: location
	 * 
	 * @param location
	 *            the location value
	 */
	public void setLocation(java.lang.String location) {
		this.location = location;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: relocation_reimbursement
	 */
	public java.lang.Integer getRelocationReimbursement() {
		return relocationReimbursement;
	}

	/**
	 * Set the value related to the column: relocation_reimbursement
	 * 
	 * @param relocationReimbursement
	 *            the relocation_reimbursement value
	 */
	public void setRelocationReimbursement(
			java.lang.Integer relocationReimbursement) {
		this.relocationReimbursement = relocationReimbursement;
	}

	/**
	 * Return the value associated with the column: notice_period
	 */
	public java.lang.Integer getNoticePeriod() {
		return noticePeriod;
	}

	/**
	 * Set the value related to the column: notice_period
	 * 
	 * @param noticePeriod
	 *            the notice_period value
	 */
	public void setNoticePeriod(java.lang.Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	/**
	 * Return the value associated with the column: probation_period
	 */
	public java.lang.Integer getProbationPeriod() {
		return probationPeriod;
	}

	/**
	 * Set the value related to the column: probation_period
	 * 
	 * @param probationPeriod
	 *            the probation_period value
	 */
	public void setProbationPeriod(java.lang.Integer probationPeriod) {
		this.probationPeriod = probationPeriod;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public jkt.hrms.recruitment.masters.business.Resumestatusmaster getResumestatusmaster() {
		return resumestatusmaster;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param resumestatusmaster
	 *            the status_id value
	 */
	public void setResumestatusmaster(
			jkt.hrms.recruitment.masters.business.Resumestatusmaster resumestatusmaster) {
		this.resumestatusmaster = resumestatusmaster;
	}

	/**
	 * Return the value associated with the column: resume_id
	 */
	public jkt.hrms.recruitment.masters.business.Resumepersonaldetails getResumeStatus() {
		return resumeStatus;
	}

	/**
	 * Set the value related to the column: resume_id
	 * 
	 * @param resumeStatus
	 *            the resume_id value
	 */
	public void setResumeStatus(
			jkt.hrms.recruitment.masters.business.Resumepersonaldetails resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	/**
	 * Return the value associated with the column: designation_id
	 */
	public jkt.hms.masters.business.MasRank getDesignation() {
		return designation;
	}

	/**
	 * Set the value related to the column: designation_id
	 * 
	 * @param designation
	 *            the designation_id value
	 */
	public void setDesignation(jkt.hms.masters.business.MasRank designation) {
		this.designation = designation;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumestatushistory)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumestatushistory resumestatushistory = (jkt.hrms.recruitment.masters.business.Resumestatushistory) obj;
			if (null == this.getId() || null == resumestatushistory.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumestatushistory.getId()));
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