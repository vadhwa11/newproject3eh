package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_bulk_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_bulk_detail"
 */

public abstract class BaseMasBulkDetail  implements Serializable {

	public static String REF = "MasBulkDetail";
	public static String PROP_NAME = "Name";
	public static String PROP_STATUS = "Status";
	public static String PROP_MESS = "Mess";
	public static String PROP_MOBILE = "Mobile";
	public static String PROP_ID = "Id";
	public static String PROP_GROUP = "Group";
	public static String PROP_CHK = "Chk";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";
	public static String PROP_PRIORITY = "Priority";


	// constructors
	public BaseMasBulkDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBulkDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasBulkDetail (
		java.lang.Integer id,
		jkt.hms.masters.business.MasEmployee employeeId,
		jkt.hms.masters.business.MasBulkMain group,
		java.lang.String mobile) {

		this.setId(id);
		this.setEmployeeId(employeeId);
		this.setGroup(group);
		this.setMobile(mobile);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String mobile;
	private java.lang.String chk;
	private java.lang.String mess;
	private java.lang.String status;
	private java.lang.Integer priority;

	// many to one
	private jkt.hms.masters.business.MasEmployee employeeId;
	private jkt.hms.masters.business.MasBulkMain group;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: mobile
	 */
	public java.lang.String getMobile () {
		return mobile;
	}

	/**
	 * Set the value related to the column: mobile
	 * @param mobile the mobile value
	 */
	public void setMobile (java.lang.String mobile) {
		this.mobile = mobile;
	}



	/**
	 * Return the value associated with the column: chk
	 */
	public java.lang.String getChk () {
		return chk;
	}

	/**
	 * Set the value related to the column: chk
	 * @param chk the chk value
	 */
	public void setChk (java.lang.String chk) {
		this.chk = chk;
	}



	/**
	 * Return the value associated with the column: mess
	 */
	public java.lang.String getMess () {
		return mess;
	}

	/**
	 * Set the value related to the column: mess
	 * @param mess the mess value
	 */
	public void setMess (java.lang.String mess) {
		this.mess = mess;
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
	 * Return the value associated with the column: priority
	 */
	public java.lang.Integer getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.Integer priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (jkt.hms.masters.business.MasEmployee employeeId) {
		this.employeeId = employeeId;
	}



	/**
	 * Return the value associated with the column: grp_id
	 */
	public jkt.hms.masters.business.MasBulkMain getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: grp_id
	 * @param group the grp_id value
	 */
	public void setGroup (jkt.hms.masters.business.MasBulkMain group) {
		this.group = group;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBulkDetail)) return false;
		else {
			jkt.hms.masters.business.MasBulkDetail masBulkDetail = (jkt.hms.masters.business.MasBulkDetail) obj;
			if (null == this.getId() || null == masBulkDetail.getId()) return false;
			else return (this.getId().equals(masBulkDetail.getId()));
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