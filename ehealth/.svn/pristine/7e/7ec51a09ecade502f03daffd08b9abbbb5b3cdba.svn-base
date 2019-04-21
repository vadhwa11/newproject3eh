package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_training_approval_status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_training_approval_status"
 */

public abstract class BaseHrTrainingApprovalStatus  implements Serializable {

	public static String REF = "HrTrainingApprovalStatus";
	public static String PROP_TRAINING_STATUS = "TrainingStatus";
	public static String PROP_STATUS_DATE = "StatusDate";
	public static String PROP_TO_BE_APPROVED = "ToBeApproved";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_HR_TRAINING_REQUISITION = "HrTrainingRequisition";
	public static String PROP_CURRENT_LEVEL = "CurrentLevel";
	public static String PROP_STATUS_REASON = "StatusReason";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";


	// constructors
	public BaseHrTrainingApprovalStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTrainingApprovalStatus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer currentLevel;
	private java.util.Date statusDate;
	private java.lang.String statusReason;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// one to one
	private jkt.hrms.masters.business.HrTrainingRequisition hrTrainingRequisition;

	// many to one
	private jkt.hrms.masters.business.HrMasTrainingStatus trainingStatus;
	private jkt.hms.masters.business.MasEmployee toBeApproved;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="training_requisition_id"
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
	 * Return the value associated with the column: current_level
	 */
	public java.lang.Integer getCurrentLevel () {
		return currentLevel;
	}

	/**
	 * Set the value related to the column: current_level
	 * @param currentLevel the current_level value
	 */
	public void setCurrentLevel (java.lang.Integer currentLevel) {
		this.currentLevel = currentLevel;
	}



	/**
	 * Return the value associated with the column: status_date
	 */
	public java.util.Date getStatusDate () {
		return statusDate;
	}

	/**
	 * Set the value related to the column: status_date
	 * @param statusDate the status_date value
	 */
	public void setStatusDate (java.util.Date statusDate) {
		this.statusDate = statusDate;
	}



	/**
	 * Return the value associated with the column: status_reason
	 */
	public java.lang.String getStatusReason () {
		return statusReason;
	}

	/**
	 * Set the value related to the column: status_reason
	 * @param statusReason the status_reason value
	 */
	public void setStatusReason (java.lang.String statusReason) {
		this.statusReason = statusReason;
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
	 * Return the value associated with the column: HrTrainingRequisition
	 */
	public jkt.hrms.masters.business.HrTrainingRequisition getHrTrainingRequisition () {
		return hrTrainingRequisition;
	}

	/**
	 * Set the value related to the column: HrTrainingRequisition
	 * @param hrTrainingRequisition the HrTrainingRequisition value
	 */
	public void setHrTrainingRequisition (jkt.hrms.masters.business.HrTrainingRequisition hrTrainingRequisition) {
		this.hrTrainingRequisition = hrTrainingRequisition;
	}



	/**
	 * Return the value associated with the column: training_status_id
	 */
	public jkt.hrms.masters.business.HrMasTrainingStatus getTrainingStatus () {
		return trainingStatus;
	}

	/**
	 * Set the value related to the column: training_status_id
	 * @param trainingStatus the training_status_id value
	 */
	public void setTrainingStatus (jkt.hrms.masters.business.HrMasTrainingStatus trainingStatus) {
		this.trainingStatus = trainingStatus;
	}



	/**
	 * Return the value associated with the column: to_be_approved_id
	 */
	public jkt.hms.masters.business.MasEmployee getToBeApproved () {
		return toBeApproved;
	}

	/**
	 * Set the value related to the column: to_be_approved_id
	 * @param toBeApproved the to_be_approved_id value
	 */
	public void setToBeApproved (jkt.hms.masters.business.MasEmployee toBeApproved) {
		this.toBeApproved = toBeApproved;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrTrainingApprovalStatus)) return false;
		else {
			jkt.hrms.masters.business.HrTrainingApprovalStatus hrTrainingApprovalStatus = (jkt.hrms.masters.business.HrTrainingApprovalStatus) obj;
			if (null == this.getId() || null == hrTrainingApprovalStatus.getId()) return false;
			else return (this.getId().equals(hrTrainingApprovalStatus.getId()));
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