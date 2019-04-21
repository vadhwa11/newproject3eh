package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_task table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_task"
 */

public abstract class BaseMstrTask  implements Serializable {

	public static String REF = "MstrTask";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TASK_CODE = "TaskCode";
	public static String PROP_BUDID = "Budid";
	public static String PROP_ID = "Id";
	public static String PROP_TASK_TYPE = "TaskType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TASK_NAME = "TaskName";


	// constructors
	public BaseMstrTask () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrTask (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String taskName;
	private java.lang.String taskCode;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrTaskType taskType;
	private jkt.hrms.masters.business.MstrBudgetSubhead budid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="task_id"
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
	 * Return the value associated with the column: task_name
	 */
	public java.lang.String getTaskName () {
		return taskName;
	}

	/**
	 * Set the value related to the column: task_name
	 * @param taskName the task_name value
	 */
	public void setTaskName (java.lang.String taskName) {
		this.taskName = taskName;
	}



	/**
	 * Return the value associated with the column: task_code
	 */
	public java.lang.String getTaskCode () {
		return taskCode;
	}

	/**
	 * Set the value related to the column: task_code
	 * @param taskCode the task_code value
	 */
	public void setTaskCode (java.lang.String taskCode) {
		this.taskCode = taskCode;
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
	 * Return the value associated with the column: task_type_id
	 */
	public jkt.hrms.masters.business.MstrTaskType getTaskType () {
		return taskType;
	}

	/**
	 * Set the value related to the column: task_type_id
	 * @param taskType the task_type_id value
	 */
	public void setTaskType (jkt.hrms.masters.business.MstrTaskType taskType) {
		this.taskType = taskType;
	}



	/**
	 * Return the value associated with the column: budid
	 */
	public jkt.hrms.masters.business.MstrBudgetSubhead getBudid () {
		return budid;
	}

	/**
	 * Set the value related to the column: budid
	 * @param budid the budid value
	 */
	public void setBudid (jkt.hrms.masters.business.MstrBudgetSubhead budid) {
		this.budid = budid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrTask)) return false;
		else {
			jkt.hrms.masters.business.MstrTask mstrTask = (jkt.hrms.masters.business.MstrTask) obj;
			if (null == this.getId() || null == mstrTask.getId()) return false;
			else return (this.getId().equals(mstrTask.getId()));
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