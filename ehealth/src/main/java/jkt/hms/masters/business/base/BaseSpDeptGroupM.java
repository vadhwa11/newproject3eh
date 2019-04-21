package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sp_dept_group_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sp_dept_group_m"
 */

public abstract class BaseSpDeptGroupM  implements Serializable {

	public static String REF = "SpDeptGroupM";
	public static String PROP_STATUS = "Status";
	public static String PROP_SP_GROUP = "SpGroup";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SP_PARAMETER = "SpParameter";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseSpDeptGroupM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSpDeptGroupM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasSpecialityGroup spGroup;
	private jkt.hms.masters.business.MasSpecialityParameter spParameter;

	// collections
	private java.util.Set<jkt.hms.masters.business.SpDeptGroupT> spDeptGroupTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="dept_group_m_id"
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
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: sp_group_id
	 */
	public jkt.hms.masters.business.MasSpecialityGroup getSpGroup () {
		return spGroup;
	}

	/**
	 * Set the value related to the column: sp_group_id
	 * @param spGroup the sp_group_id value
	 */
	public void setSpGroup (jkt.hms.masters.business.MasSpecialityGroup spGroup) {
		this.spGroup = spGroup;
	}



	/**
	 * Return the value associated with the column: sp_parameter_id
	 */
	public jkt.hms.masters.business.MasSpecialityParameter getSpParameter () {
		return spParameter;
	}

	/**
	 * Set the value related to the column: sp_parameter_id
	 * @param spParameter the sp_parameter_id value
	 */
	public void setSpParameter (jkt.hms.masters.business.MasSpecialityParameter spParameter) {
		this.spParameter = spParameter;
	}



	/**
	 * Return the value associated with the column: SpDeptGroupTs
	 */
	public java.util.Set<jkt.hms.masters.business.SpDeptGroupT> getSpDeptGroupTs () {
		return spDeptGroupTs;
	}

	/**
	 * Set the value related to the column: SpDeptGroupTs
	 * @param spDeptGroupTs the SpDeptGroupTs value
	 */
	public void setSpDeptGroupTs (java.util.Set<jkt.hms.masters.business.SpDeptGroupT> spDeptGroupTs) {
		this.spDeptGroupTs = spDeptGroupTs;
	}

	public void addToSpDeptGroupTs (jkt.hms.masters.business.SpDeptGroupT spDeptGroupT) {
		if (null == getSpDeptGroupTs()) setSpDeptGroupTs(new java.util.TreeSet<jkt.hms.masters.business.SpDeptGroupT>());
		getSpDeptGroupTs().add(spDeptGroupT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SpDeptGroupM)) return false;
		else {
			jkt.hms.masters.business.SpDeptGroupM spDeptGroupM = (jkt.hms.masters.business.SpDeptGroupM) obj;
			if (null == this.getId() || null == spDeptGroupM.getId()) return false;
			else return (this.getId().equals(spDeptGroupM.getId()));
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