package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_training_requisition table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_training_requisition"
 */

public abstract class BaseHrTrainingRequisition  implements Serializable {

	public static String REF = "HrTrainingRequisition";
	public static String PROP_TRAINING_STATUS = "TrainingStatus";
	public static String PROP_REQUISITION_DATE = "RequisitionDate";
	public static String PROP_TO_BE_APPROVED = "ToBeApproved";
	public static String PROP_TRAINING_REQUISITION_STATUS = "TrainingRequisitionStatus";
	public static String PROP_TRAINING = "Training";
	public static String PROP_TRAINING_DATE = "TrainingDate";
	public static String PROP_CONTRIBUTING_TRAINING = "ContributingTraining";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_STATUS = "Status";
	public static String PROP_HR_TRAINING_APPROVAL_STATUS = "HrTrainingApprovalStatus";
	public static String PROP_SCHEDULE_ID = "ScheduleId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TRAINING_STATUS_DESC = "TrainingStatusDesc";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DESIGNATION = "Designation";


	// constructors
	public BaseHrTrainingRequisition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTrainingRequisition (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date requisitionDate;
	private java.util.Date trainingDate;
	private java.lang.String remarks;
	private java.lang.String trainingRequisitionStatus;
	private java.lang.String trainingStatusDesc;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// one to one
	private jkt.hrms.masters.business.HrTrainingApprovalStatus hrTrainingApprovalStatus;

	// many to one
	private jkt.hrms.masters.business.HrMasTrainingStatus trainingStatus;
	private jkt.hrms.masters.business.HrMasTraining contributingTraining;
	private jkt.hrms.masters.business.HrMasTraining training;
	private jkt.hms.masters.business.MasRank designation;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasEmployee toBeApproved;
	private jkt.hrms.masters.business.HrTrainingSchedule scheduleId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: requisition_date
	 */
	public java.util.Date getRequisitionDate () {
		return requisitionDate;
	}

	/**
	 * Set the value related to the column: requisition_date
	 * @param requisitionDate the requisition_date value
	 */
	public void setRequisitionDate (java.util.Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}



	/**
	 * Return the value associated with the column: training_date
	 */
	public java.util.Date getTrainingDate () {
		return trainingDate;
	}

	/**
	 * Set the value related to the column: training_date
	 * @param trainingDate the training_date value
	 */
	public void setTrainingDate (java.util.Date trainingDate) {
		this.trainingDate = trainingDate;
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
	 * Return the value associated with the column: training_requisition_status
	 */
	public java.lang.String getTrainingRequisitionStatus () {
		return trainingRequisitionStatus;
	}

	/**
	 * Set the value related to the column: training_requisition_status
	 * @param trainingRequisitionStatus the training_requisition_status value
	 */
	public void setTrainingRequisitionStatus (java.lang.String trainingRequisitionStatus) {
		this.trainingRequisitionStatus = trainingRequisitionStatus;
	}



	/**
	 * Return the value associated with the column: training_status
	 */
	public java.lang.String getTrainingStatusDesc () {
		return trainingStatusDesc;
	}

	/**
	 * Set the value related to the column: training_status
	 * @param trainingStatusDesc the training_status value
	 */
	public void setTrainingStatusDesc (java.lang.String trainingStatusDesc) {
		this.trainingStatusDesc = trainingStatusDesc;
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
	 * Return the value associated with the column: HrTrainingApprovalStatus
	 */
	public jkt.hrms.masters.business.HrTrainingApprovalStatus getHrTrainingApprovalStatus () {
		return hrTrainingApprovalStatus;
	}

	/**
	 * Set the value related to the column: HrTrainingApprovalStatus
	 * @param hrTrainingApprovalStatus the HrTrainingApprovalStatus value
	 */
	public void setHrTrainingApprovalStatus (jkt.hrms.masters.business.HrTrainingApprovalStatus hrTrainingApprovalStatus) {
		this.hrTrainingApprovalStatus = hrTrainingApprovalStatus;
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
	 * Return the value associated with the column: contributing_training_id
	 */
	public jkt.hrms.masters.business.HrMasTraining getContributingTraining () {
		return contributingTraining;
	}

	/**
	 * Set the value related to the column: contributing_training_id
	 * @param contributingTraining the contributing_training_id value
	 */
	public void setContributingTraining (jkt.hrms.masters.business.HrMasTraining contributingTraining) {
		this.contributingTraining = contributingTraining;
	}



	/**
	 * Return the value associated with the column: training_id
	 */
	public jkt.hrms.masters.business.HrMasTraining getTraining () {
		return training;
	}

	/**
	 * Set the value related to the column: training_id
	 * @param training the training_id value
	 */
	public void setTraining (jkt.hrms.masters.business.HrMasTraining training) {
		this.training = training;
	}



	/**
	 * Return the value associated with the column: designation_id
	 */
	public jkt.hms.masters.business.MasRank getDesignation () {
		return designation;
	}

	/**
	 * Set the value related to the column: designation_id
	 * @param designation the designation_id value
	 */
	public void setDesignation (jkt.hms.masters.business.MasRank designation) {
		this.designation = designation;
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



	/**
	 * Return the value associated with the column: to_be_approved
	 */
	public jkt.hms.masters.business.MasEmployee getToBeApproved () {
		return toBeApproved;
	}

	/**
	 * Set the value related to the column: to_be_approved
	 * @param toBeApproved the to_be_approved value
	 */
	public void setToBeApproved (jkt.hms.masters.business.MasEmployee toBeApproved) {
		this.toBeApproved = toBeApproved;
	}



	/**
	 * Return the value associated with the column: training_schedule_id
	 */
	public jkt.hrms.masters.business.HrTrainingSchedule getScheduleId () {
		return scheduleId;
	}

	/**
	 * Set the value related to the column: training_schedule_id
	 * @param scheduleId the training_schedule_id value
	 */
	public void setScheduleId (jkt.hrms.masters.business.HrTrainingSchedule scheduleId) {
		this.scheduleId = scheduleId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrTrainingRequisition)) return false;
		else {
			jkt.hrms.masters.business.HrTrainingRequisition hrTrainingRequisition = (jkt.hrms.masters.business.HrTrainingRequisition) obj;
			if (null == this.getId() || null == hrTrainingRequisition.getId()) return false;
			else return (this.getId().equals(hrTrainingRequisition.getId()));
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