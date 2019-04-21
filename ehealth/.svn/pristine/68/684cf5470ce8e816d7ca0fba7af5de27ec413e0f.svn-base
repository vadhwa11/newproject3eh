package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_dept_task_map table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_dept_task_map"
 */

public abstract class BaseMstrDeptTaskMap  implements Serializable {

	public static String REF = "MstrDeptTaskMap";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TASK = "Task";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMstrDeptTaskMap () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrDeptTaskMap (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMstrDeptTaskMap (
		java.lang.Integer id,
		jkt.hrms.masters.business.MstrTask task) {

		this.setId(id);
		this.setTask(task);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hrms.masters.business.MstrTask task;

	// collections
	private java.util.Set<jkt.hrms.masters.business.MstrRoleTaskMap> mstrRoleTaskMaps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Id"
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
	 * Return the value associated with the column: task_id
	 */
	public jkt.hrms.masters.business.MstrTask getTask () {
		return task;
	}

	/**
	 * Set the value related to the column: task_id
	 * @param task the task_id value
	 */
	public void setTask (jkt.hrms.masters.business.MstrTask task) {
		this.task = task;
	}



	/**
	 * Return the value associated with the column: MstrRoleTaskMaps
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrRoleTaskMap> getMstrRoleTaskMaps () {
		return mstrRoleTaskMaps;
	}

	/**
	 * Set the value related to the column: MstrRoleTaskMaps
	 * @param mstrRoleTaskMaps the MstrRoleTaskMaps value
	 */
	public void setMstrRoleTaskMaps (java.util.Set<jkt.hrms.masters.business.MstrRoleTaskMap> mstrRoleTaskMaps) {
		this.mstrRoleTaskMaps = mstrRoleTaskMaps;
	}

	public void addToMstrRoleTaskMaps (jkt.hrms.masters.business.MstrRoleTaskMap mstrRoleTaskMap) {
		if (null == getMstrRoleTaskMaps()) setMstrRoleTaskMaps(new java.util.TreeSet<jkt.hrms.masters.business.MstrRoleTaskMap>());
		getMstrRoleTaskMaps().add(mstrRoleTaskMap);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrDeptTaskMap)) return false;
		else {
			jkt.hrms.masters.business.MstrDeptTaskMap mstrDeptTaskMap = (jkt.hrms.masters.business.MstrDeptTaskMap) obj;
			if (null == this.getId() || null == mstrDeptTaskMap.getId()) return false;
			else return (this.getId().equals(mstrDeptTaskMap.getId()));
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