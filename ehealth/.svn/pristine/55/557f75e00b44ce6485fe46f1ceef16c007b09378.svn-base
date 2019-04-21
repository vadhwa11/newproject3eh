package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_role_task_map table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_role_task_map"
 */

public abstract class BaseMstrRoleTaskMap  implements Serializable {

	public static String REF = "MstrRoleTaskMap";
	public static String PROP_STATUS = "Status";
	public static String PROP_RANK = "Rank";
	public static String PROP_TASK = "Task";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseMstrRoleTaskMap () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrRoleTaskMap (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMstrRoleTaskMap (
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
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hrms.masters.business.MstrTask task;
	private jkt.hms.masters.business.MasRank rank;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="map_id"
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
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrRoleTaskMap)) return false;
		else {
			jkt.hrms.masters.business.MstrRoleTaskMap mstrRoleTaskMap = (jkt.hrms.masters.business.MstrRoleTaskMap) obj;
			if (null == this.getId() || null == mstrRoleTaskMap.getId()) return false;
			else return (this.getId().equals(mstrRoleTaskMap.getId()));
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