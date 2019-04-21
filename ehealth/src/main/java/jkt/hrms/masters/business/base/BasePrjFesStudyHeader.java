package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_fes_study_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_fes_study_header"
 */

public abstract class BasePrjFesStudyHeader  implements Serializable {

	public static String REF = "PrjFesStudyHeader";
	public static String PROP_SQ_APPROVER_EMP = "SqApproverEmp";
	public static String PROP_PRJ = "Prj";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SQ_APPROVER_DATE = "SqApproverDate";
	public static String PROP_QA_APPROVAL_STATUS = "QaApprovalStatus";
	public static String PROP_SQ_APPROVAL_STATUS = "SqApprovalStatus";
	public static String PROP_GREEN_SIGNAL_DATE = "GreenSignalDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SQ_SUB_DATE = "SqSubDate";
	public static String PROP_DELEGATE_EMP = "DelegateEmp";
	public static String PROP_QA_APPROVER = "QaApprover";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PI_HEADER = "PiHeader";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_QA_APPROVER_COMMENTS = "QaApproverComments";
	public static String PROP_SQ_REPORT = "SqReport";
	public static String PROP_SQ_VISIT = "SqVisit";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ACTUA_VISIT_DATE = "ActuaVisitDate";
	public static String PROP_QA_APPROVAL_DATE = "QaApprovalDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_SITE_INITIATE_DATE = "SiteInitiateDate";
	public static String PROP_PLANNED_VISIT_DATE = "PlannedVisitDate";
	public static String PROP_SQ_VISIT_STATUS = "SqVisitStatus";
	public static String PROP_PI_STATUS = "PiStatus";
	public static String PROP_ID = "Id";
	public static String PROP_SQ_APPROVER_COMMENTS = "SqApproverComments";
	public static String PROP_SITE_HEADER = "SiteHeader";


	// constructors
	public BasePrjFesStudyHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjFesStudyHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sqVisit;
	private java.util.Date actuaVisitDate;
	private java.lang.String comments;
	private java.lang.String sqReport;
	private java.util.Date plannedVisitDate;
	private java.lang.String sqApprovalStatus;
	private java.util.Date greenSignalDate;
	private java.util.Date siteInitiateDate;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String qaApproverComments;
	private java.lang.String qaApprovalStatus;
	private java.lang.String sqApproverComments;
	private java.util.Date sqApproverDate;
	private java.util.Date sqSubDate;
	private java.lang.String status;
	private java.lang.String piStatus;
	private java.lang.String sqVisitStatus;
	private java.util.Date qaApprovalDate;

	// many to one
	private jkt.hms.masters.business.MasEmployee delegateEmp;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee qaApprover;
	private jkt.hrms.masters.business.MstrPiHeader piHeader;
	private jkt.hrms.masters.business.MstrSiteHeader siteHeader;
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hms.masters.business.MasEmployee sqApproverEmp;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjFesStudyDetail> prjFesStudyDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="fes_study_header_id"
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
	 * Return the value associated with the column: sq_visit
	 */
	public java.lang.String getSqVisit () {
		return sqVisit;
	}

	/**
	 * Set the value related to the column: sq_visit
	 * @param sqVisit the sq_visit value
	 */
	public void setSqVisit (java.lang.String sqVisit) {
		this.sqVisit = sqVisit;
	}



	/**
	 * Return the value associated with the column: actua_visit_date
	 */
	public java.util.Date getActuaVisitDate () {
		return actuaVisitDate;
	}

	/**
	 * Set the value related to the column: actua_visit_date
	 * @param actuaVisitDate the actua_visit_date value
	 */
	public void setActuaVisitDate (java.util.Date actuaVisitDate) {
		this.actuaVisitDate = actuaVisitDate;
	}



	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param comments the comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
	}



	/**
	 * Return the value associated with the column: sq_report
	 */
	public java.lang.String getSqReport () {
		return sqReport;
	}

	/**
	 * Set the value related to the column: sq_report
	 * @param sqReport the sq_report value
	 */
	public void setSqReport (java.lang.String sqReport) {
		this.sqReport = sqReport;
	}



	/**
	 * Return the value associated with the column: planned_visit_date
	 */
	public java.util.Date getPlannedVisitDate () {
		return plannedVisitDate;
	}

	/**
	 * Set the value related to the column: planned_visit_date
	 * @param plannedVisitDate the planned_visit_date value
	 */
	public void setPlannedVisitDate (java.util.Date plannedVisitDate) {
		this.plannedVisitDate = plannedVisitDate;
	}



	/**
	 * Return the value associated with the column: sq_approval_status
	 */
	public java.lang.String getSqApprovalStatus () {
		return sqApprovalStatus;
	}

	/**
	 * Set the value related to the column: sq_approval_status
	 * @param sqApprovalStatus the sq_approval_status value
	 */
	public void setSqApprovalStatus (java.lang.String sqApprovalStatus) {
		this.sqApprovalStatus = sqApprovalStatus;
	}



	/**
	 * Return the value associated with the column: green_signal_date_
	 */
	public java.util.Date getGreenSignalDate () {
		return greenSignalDate;
	}

	/**
	 * Set the value related to the column: green_signal_date_
	 * @param greenSignalDate the green_signal_date_ value
	 */
	public void setGreenSignalDate (java.util.Date greenSignalDate) {
		this.greenSignalDate = greenSignalDate;
	}



	/**
	 * Return the value associated with the column: site_initiate_date
	 */
	public java.util.Date getSiteInitiateDate () {
		return siteInitiateDate;
	}

	/**
	 * Set the value related to the column: site_initiate_date
	 * @param siteInitiateDate the site_initiate_date value
	 */
	public void setSiteInitiateDate (java.util.Date siteInitiateDate) {
		this.siteInitiateDate = siteInitiateDate;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: qa_approver_comments
	 */
	public java.lang.String getQaApproverComments () {
		return qaApproverComments;
	}

	/**
	 * Set the value related to the column: qa_approver_comments
	 * @param qaApproverComments the qa_approver_comments value
	 */
	public void setQaApproverComments (java.lang.String qaApproverComments) {
		this.qaApproverComments = qaApproverComments;
	}



	/**
	 * Return the value associated with the column: qa_approval_status
	 */
	public java.lang.String getQaApprovalStatus () {
		return qaApprovalStatus;
	}

	/**
	 * Set the value related to the column: qa_approval_status
	 * @param qaApprovalStatus the qa_approval_status value
	 */
	public void setQaApprovalStatus (java.lang.String qaApprovalStatus) {
		this.qaApprovalStatus = qaApprovalStatus;
	}



	/**
	 * Return the value associated with the column: sq_approver_comments
	 */
	public java.lang.String getSqApproverComments () {
		return sqApproverComments;
	}

	/**
	 * Set the value related to the column: sq_approver_comments
	 * @param sqApproverComments the sq_approver_comments value
	 */
	public void setSqApproverComments (java.lang.String sqApproverComments) {
		this.sqApproverComments = sqApproverComments;
	}



	/**
	 * Return the value associated with the column: sq_approver_date
	 */
	public java.util.Date getSqApproverDate () {
		return sqApproverDate;
	}

	/**
	 * Set the value related to the column: sq_approver_date
	 * @param sqApproverDate the sq_approver_date value
	 */
	public void setSqApproverDate (java.util.Date sqApproverDate) {
		this.sqApproverDate = sqApproverDate;
	}



	/**
	 * Return the value associated with the column: sq_sub_date
	 */
	public java.util.Date getSqSubDate () {
		return sqSubDate;
	}

	/**
	 * Set the value related to the column: sq_sub_date
	 * @param sqSubDate the sq_sub_date value
	 */
	public void setSqSubDate (java.util.Date sqSubDate) {
		this.sqSubDate = sqSubDate;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: pi_status
	 */
	public java.lang.String getPiStatus () {
		return piStatus;
	}

	/**
	 * Set the value related to the column: pi_status
	 * @param piStatus the pi_status value
	 */
	public void setPiStatus (java.lang.String piStatus) {
		this.piStatus = piStatus;
	}



	/**
	 * Return the value associated with the column: sq_visit_status
	 */
	public java.lang.String getSqVisitStatus () {
		return sqVisitStatus;
	}

	/**
	 * Set the value related to the column: sq_visit_status
	 * @param sqVisitStatus the sq_visit_status value
	 */
	public void setSqVisitStatus (java.lang.String sqVisitStatus) {
		this.sqVisitStatus = sqVisitStatus;
	}



	/**
	 * Return the value associated with the column: qa_approval_date
	 */
	public java.util.Date getQaApprovalDate () {
		return qaApprovalDate;
	}

	/**
	 * Set the value related to the column: qa_approval_date
	 * @param qaApprovalDate the qa_approval_date value
	 */
	public void setQaApprovalDate (java.util.Date qaApprovalDate) {
		this.qaApprovalDate = qaApprovalDate;
	}



	/**
	 * Return the value associated with the column: delegate_emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getDelegateEmp () {
		return delegateEmp;
	}

	/**
	 * Set the value related to the column: delegate_emp_id
	 * @param delegateEmp the delegate_emp_id value
	 */
	public void setDelegateEmp (jkt.hms.masters.business.MasEmployee delegateEmp) {
		this.delegateEmp = delegateEmp;
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
	 * Return the value associated with the column: qa_approver_id
	 */
	public jkt.hms.masters.business.MasEmployee getQaApprover () {
		return qaApprover;
	}

	/**
	 * Set the value related to the column: qa_approver_id
	 * @param qaApprover the qa_approver_id value
	 */
	public void setQaApprover (jkt.hms.masters.business.MasEmployee qaApprover) {
		this.qaApprover = qaApprover;
	}



	/**
	 * Return the value associated with the column: pi_header_id
	 */
	public jkt.hrms.masters.business.MstrPiHeader getPiHeader () {
		return piHeader;
	}

	/**
	 * Set the value related to the column: pi_header_id
	 * @param piHeader the pi_header_id value
	 */
	public void setPiHeader (jkt.hrms.masters.business.MstrPiHeader piHeader) {
		this.piHeader = piHeader;
	}



	/**
	 * Return the value associated with the column: site_header_id
	 */
	public jkt.hrms.masters.business.MstrSiteHeader getSiteHeader () {
		return siteHeader;
	}

	/**
	 * Set the value related to the column: site_header_id
	 * @param siteHeader the site_header_id value
	 */
	public void setSiteHeader (jkt.hrms.masters.business.MstrSiteHeader siteHeader) {
		this.siteHeader = siteHeader;
	}



	/**
	 * Return the value associated with the column: Prj_id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: Prj_id
	 * @param prj the Prj_id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}



	/**
	 * Return the value associated with the column: sq_approver_emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getSqApproverEmp () {
		return sqApproverEmp;
	}

	/**
	 * Set the value related to the column: sq_approver_emp_id
	 * @param sqApproverEmp the sq_approver_emp_id value
	 */
	public void setSqApproverEmp (jkt.hms.masters.business.MasEmployee sqApproverEmp) {
		this.sqApproverEmp = sqApproverEmp;
	}



	/**
	 * Return the value associated with the column: PrjFesStudyDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjFesStudyDetail> getPrjFesStudyDetails () {
		return prjFesStudyDetails;
	}

	/**
	 * Set the value related to the column: PrjFesStudyDetails
	 * @param prjFesStudyDetails the PrjFesStudyDetails value
	 */
	public void setPrjFesStudyDetails (java.util.Set<jkt.hrms.masters.business.PrjFesStudyDetail> prjFesStudyDetails) {
		this.prjFesStudyDetails = prjFesStudyDetails;
	}

	public void addToPrjFesStudyDetails (jkt.hrms.masters.business.PrjFesStudyDetail prjFesStudyDetail) {
		if (null == getPrjFesStudyDetails()) setPrjFesStudyDetails(new java.util.TreeSet<jkt.hrms.masters.business.PrjFesStudyDetail>());
		getPrjFesStudyDetails().add(prjFesStudyDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjFesStudyHeader)) return false;
		else {
			jkt.hrms.masters.business.PrjFesStudyHeader prjFesStudyHeader = (jkt.hrms.masters.business.PrjFesStudyHeader) obj;
			if (null == this.getId() || null == prjFesStudyHeader.getId()) return false;
			else return (this.getId().equals(prjFesStudyHeader.getId()));
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