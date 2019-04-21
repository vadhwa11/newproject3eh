package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tbltimesheet table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tbltimesheet"
 */

public abstract class BaseTbltimesheet  implements Serializable {

	public static String REF = "Tbltimesheet";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_COMPANY_I_D = "CompanyID";
	public static String PROP_EMP_ID = "EmpId";
	public static String PROP_LAST_SUBMISSION_DATE = "LastSubmissionDate";
	public static String PROP_OTHER_APPROVER_ID = "OtherApproverId";
	public static String PROP_TASK_I_D = "TaskID";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_APP_COMMENTS = "AppComments";
	public static String PROP_APPROVER_ID = "ApproverId";
	public static String PROP_MODIFIED_DATE = "ModifiedDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_HRS_WORKED = "HrsWorked";
	public static String PROP_TOTAL_MIN = "TotalMin";
	public static String PROP_SUBMT_DATE = "SubmtDate";
	public static String PROP_SCH_DATE = "SchDate";
	public static String PROP_ID = "Id";
	public static String PROP_TASK_TYPE = "TaskType";
	public static String PROP_SITE_I_D = "SiteID";
	public static String PROP_DEPARTMENT_I_D = "DepartmentID";
	public static String PROP_PROJECT_I_D = "ProjectID";


	// constructors
	public BaseTbltimesheet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTbltimesheet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTbltimesheet (
		java.lang.Integer id,
		java.math.BigDecimal hrsWorked,
		java.lang.Integer totalMin) {

		this.setId(id);
		this.setHrsWorked(hrsWorked);
		this.setTotalMin(totalMin);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date entryDate;
	private java.util.Date submtDate;
	private java.util.Date modifiedDate;
	private java.lang.String taskType;
	private java.util.Date schDate;
	private java.math.BigDecimal hrsWorked;
	private java.lang.String status;
	private java.lang.String comments;
	private java.lang.String appComments;
	private java.lang.Integer totalMin;
	private java.util.Date lastSubmissionDate;

	// many to one
	private jkt.hms.masters.business.MasEmployee empId;
	private jkt.hrms.masters.business.MstrTask taskID;
	private jkt.hms.masters.business.MasDepartment departmentID;
	private jkt.hrms.masters.business.MstrSiteHeader siteID;
	private jkt.hrms.masters.business.MstrProject projectID;
	private jkt.hms.masters.business.MasHospital companyID;
	private jkt.hms.masters.business.MasEmployee approverId;
	private jkt.hms.masters.business.MasEmployee otherApproverId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Tmsht_id"
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
	 * Return the value associated with the column: EntryDate
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: EntryDate
	 * @param entryDate the EntryDate value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: SubmtDate
	 */
	public java.util.Date getSubmtDate () {
		return submtDate;
	}

	/**
	 * Set the value related to the column: SubmtDate
	 * @param submtDate the SubmtDate value
	 */
	public void setSubmtDate (java.util.Date submtDate) {
		this.submtDate = submtDate;
	}



	/**
	 * Return the value associated with the column: ModifiedDate
	 */
	public java.util.Date getModifiedDate () {
		return modifiedDate;
	}

	/**
	 * Set the value related to the column: ModifiedDate
	 * @param modifiedDate the ModifiedDate value
	 */
	public void setModifiedDate (java.util.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}



	/**
	 * Return the value associated with the column: TaskType
	 */
	public java.lang.String getTaskType () {
		return taskType;
	}

	/**
	 * Set the value related to the column: TaskType
	 * @param taskType the TaskType value
	 */
	public void setTaskType (java.lang.String taskType) {
		this.taskType = taskType;
	}



	/**
	 * Return the value associated with the column: SchDate
	 */
	public java.util.Date getSchDate () {
		return schDate;
	}

	/**
	 * Set the value related to the column: SchDate
	 * @param schDate the SchDate value
	 */
	public void setSchDate (java.util.Date schDate) {
		this.schDate = schDate;
	}



	/**
	 * Return the value associated with the column: HrsWorked
	 */
	public java.math.BigDecimal getHrsWorked () {
		return hrsWorked;
	}

	/**
	 * Set the value related to the column: HrsWorked
	 * @param hrsWorked the HrsWorked value
	 */
	public void setHrsWorked (java.math.BigDecimal hrsWorked) {
		this.hrsWorked = hrsWorked;
	}



	/**
	 * Return the value associated with the column: Status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: Status
	 * @param status the Status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: Comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: Comments
	 * @param comments the Comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
	}



	/**
	 * Return the value associated with the column: App_Comments
	 */
	public java.lang.String getAppComments () {
		return appComments;
	}

	/**
	 * Set the value related to the column: App_Comments
	 * @param appComments the App_Comments value
	 */
	public void setAppComments (java.lang.String appComments) {
		this.appComments = appComments;
	}



	/**
	 * Return the value associated with the column: TotalMin
	 */
	public java.lang.Integer getTotalMin () {
		return totalMin;
	}

	/**
	 * Set the value related to the column: TotalMin
	 * @param totalMin the TotalMin value
	 */
	public void setTotalMin (java.lang.Integer totalMin) {
		this.totalMin = totalMin;
	}



	/**
	 * Return the value associated with the column: last_submission_date
	 */
	public java.util.Date getLastSubmissionDate () {
		return lastSubmissionDate;
	}

	/**
	 * Set the value related to the column: last_submission_date
	 * @param lastSubmissionDate the last_submission_date value
	 */
	public void setLastSubmissionDate (java.util.Date lastSubmissionDate) {
		this.lastSubmissionDate = lastSubmissionDate;
	}



	/**
	 * Return the value associated with the column: Emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmpId () {
		return empId;
	}

	/**
	 * Set the value related to the column: Emp_id
	 * @param empId the Emp_id value
	 */
	public void setEmpId (jkt.hms.masters.business.MasEmployee empId) {
		this.empId = empId;
	}



	/**
	 * Return the value associated with the column: TaskID
	 */
	public jkt.hrms.masters.business.MstrTask getTaskID () {
		return taskID;
	}

	/**
	 * Set the value related to the column: TaskID
	 * @param taskID the TaskID value
	 */
	public void setTaskID (jkt.hrms.masters.business.MstrTask taskID) {
		this.taskID = taskID;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentID () {
		return departmentID;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departmentID the department_id value
	 */
	public void setDepartmentID (jkt.hms.masters.business.MasDepartment departmentID) {
		this.departmentID = departmentID;
	}



	/**
	 * Return the value associated with the column: SiteID
	 */
	public jkt.hrms.masters.business.MstrSiteHeader getSiteID () {
		return siteID;
	}

	/**
	 * Set the value related to the column: SiteID
	 * @param siteID the SiteID value
	 */
	public void setSiteID (jkt.hrms.masters.business.MstrSiteHeader siteID) {
		this.siteID = siteID;
	}



	/**
	 * Return the value associated with the column: ProjectID
	 */
	public jkt.hrms.masters.business.MstrProject getProjectID () {
		return projectID;
	}

	/**
	 * Set the value related to the column: ProjectID
	 * @param projectID the ProjectID value
	 */
	public void setProjectID (jkt.hrms.masters.business.MstrProject projectID) {
		this.projectID = projectID;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompanyID () {
		return companyID;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param companyID the company_id value
	 */
	public void setCompanyID (jkt.hms.masters.business.MasHospital companyID) {
		this.companyID = companyID;
	}



	/**
	 * Return the value associated with the column: approver_id
	 */
	public jkt.hms.masters.business.MasEmployee getApproverId () {
		return approverId;
	}

	/**
	 * Set the value related to the column: approver_id
	 * @param approverId the approver_id value
	 */
	public void setApproverId (jkt.hms.masters.business.MasEmployee approverId) {
		this.approverId = approverId;
	}



	/**
	 * Return the value associated with the column: other_approver_id
	 */
	public jkt.hms.masters.business.MasEmployee getOtherApproverId () {
		return otherApproverId;
	}

	/**
	 * Set the value related to the column: other_approver_id
	 * @param otherApproverId the other_approver_id value
	 */
	public void setOtherApproverId (jkt.hms.masters.business.MasEmployee otherApproverId) {
		this.otherApproverId = otherApproverId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.Tbltimesheet)) return false;
		else {
			jkt.hrms.masters.business.Tbltimesheet tbltimesheet = (jkt.hrms.masters.business.Tbltimesheet) obj;
			if (null == this.getId() || null == tbltimesheet.getId()) return false;
			else return (this.getId().equals(tbltimesheet.getId()));
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