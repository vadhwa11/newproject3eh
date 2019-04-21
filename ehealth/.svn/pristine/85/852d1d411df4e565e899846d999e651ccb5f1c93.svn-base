package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_role_map table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_role_map"
 */

public abstract class BasePrjRoleMap  implements Serializable {

	public static String REF = "PrjRoleMap";
	public static String PROP_PRJ_ID = "PrjId";
	public static String PROP_ROLE_TASK_ID = "RoleTaskId";
	public static String PROP_ID = "Id";
	public static String PROP_ROLE_ID = "RoleId";


	// constructors
	public BasePrjRoleMap () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjRoleMap (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePrjRoleMap (
		java.lang.Integer id,
		java.lang.Integer prjId,
		java.lang.Integer roleId,
		java.lang.Integer roleTaskId) {

		this.setId(id);
		this.setPrjId(prjId);
		this.setRoleId(roleId);
		this.setRoleTaskId(roleTaskId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer prjId;
	private java.lang.Integer roleId;
	private java.lang.Integer roleTaskId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Prj_Role_Map_id"
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
	 * Return the value associated with the column: Prj_id
	 */
	public java.lang.Integer getPrjId () {
		return prjId;
	}

	/**
	 * Set the value related to the column: Prj_id
	 * @param prjId the Prj_id value
	 */
	public void setPrjId (java.lang.Integer prjId) {
		this.prjId = prjId;
	}



	/**
	 * Return the value associated with the column: Role_id
	 */
	public java.lang.Integer getRoleId () {
		return roleId;
	}

	/**
	 * Set the value related to the column: Role_id
	 * @param roleId the Role_id value
	 */
	public void setRoleId (java.lang.Integer roleId) {
		this.roleId = roleId;
	}



	/**
	 * Return the value associated with the column: Role_task_id
	 */
	public java.lang.Integer getRoleTaskId () {
		return roleTaskId;
	}

	/**
	 * Set the value related to the column: Role_task_id
	 * @param roleTaskId the Role_task_id value
	 */
	public void setRoleTaskId (java.lang.Integer roleTaskId) {
		this.roleTaskId = roleTaskId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjRoleMap)) return false;
		else {
			jkt.hrms.masters.business.PrjRoleMap prjRoleMap = (jkt.hrms.masters.business.PrjRoleMap) obj;
			if (null == this.getId() || null == prjRoleMap.getId()) return false;
			else return (this.getId().equals(prjRoleMap.getId()));
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