package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_role_res_mapping_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_role_res_mapping_detail"
 */

public abstract class BasePrjRoleResMappingDetail  implements Serializable {

	public static String REF = "PrjRoleResMappingDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_BILLABLE = "Billable";
	public static String PROP_TASK = "Task";
	public static String PROP_ROLE_RES_MAPPING_HEADER = "RoleResMappingHeader";
	public static String PROP_TYPE_OF_TASK = "TypeOfTask";
	public static String PROP_ID = "Id";
	public static String PROP_TASK_TYPE = "TaskType";


	// constructors
	public BasePrjRoleResMappingDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjRoleResMappingDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String typeOfTask;
	private java.lang.String status;
	private java.lang.String billable;

	// many to one
	private jkt.hrms.masters.business.MstrTaskType taskType;
	private jkt.hrms.masters.business.PrjRoleResMappingHeader roleResMappingHeader;
	private jkt.hrms.masters.business.MstrTask task;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="role_res_mapping_detail_id"
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
	 * Return the value associated with the column: type_of_task
	 */
	public java.lang.String getTypeOfTask () {
		return typeOfTask;
	}

	/**
	 * Set the value related to the column: type_of_task
	 * @param typeOfTask the type_of_task value
	 */
	public void setTypeOfTask (java.lang.String typeOfTask) {
		this.typeOfTask = typeOfTask;
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
	 * Return the value associated with the column: billable
	 */
	public java.lang.String getBillable () {
		return billable;
	}

	/**
	 * Set the value related to the column: billable
	 * @param billable the billable value
	 */
	public void setBillable (java.lang.String billable) {
		this.billable = billable;
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
	 * Return the value associated with the column: role_res_mapping_header_id
	 */
	public jkt.hrms.masters.business.PrjRoleResMappingHeader getRoleResMappingHeader () {
		return roleResMappingHeader;
	}

	/**
	 * Set the value related to the column: role_res_mapping_header_id
	 * @param roleResMappingHeader the role_res_mapping_header_id value
	 */
	public void setRoleResMappingHeader (jkt.hrms.masters.business.PrjRoleResMappingHeader roleResMappingHeader) {
		this.roleResMappingHeader = roleResMappingHeader;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjRoleResMappingDetail)) return false;
		else {
			jkt.hrms.masters.business.PrjRoleResMappingDetail prjRoleResMappingDetail = (jkt.hrms.masters.business.PrjRoleResMappingDetail) obj;
			if (null == this.getId() || null == prjRoleResMappingDetail.getId()) return false;
			else return (this.getId().equals(prjRoleResMappingDetail.getId()));
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