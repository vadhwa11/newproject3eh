package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_request_config table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_request_config"
 */

public abstract class BaseMmRequestConfig  implements Serializable {

	public static String REF = "MmRequestConfig";
	public static String PROP_STATUS = "Status";
	public static String PROP_FROM_DAY = "FromDay";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DESIGNATION_LEVEL = "DesignationLevel";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TO_DAY = "ToDay";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseMmRequestConfig () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmRequestConfig (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMmRequestConfig (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer designationLevel;
	private java.lang.Integer fromDay;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer toDay;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="config_id"
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
	 * Return the value associated with the column: designation_level
	 */
	public java.lang.Integer getDesignationLevel () {
		return designationLevel;
	}

	/**
	 * Set the value related to the column: designation_level
	 * @param designationLevel the designation_level value
	 */
	public void setDesignationLevel (java.lang.Integer designationLevel) {
		this.designationLevel = designationLevel;
	}



	/**
	 * Return the value associated with the column: from_day
	 */
	public java.lang.Integer getFromDay () {
		return fromDay;
	}

	/**
	 * Set the value related to the column: from_day
	 * @param fromDay the from_day value
	 */
	public void setFromDay (java.lang.Integer fromDay) {
		this.fromDay = fromDay;
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
	 * Return the value associated with the column: to_day
	 */
	public java.lang.Integer getToDay () {
		return toDay;
	}

	/**
	 * Set the value related to the column: to_day
	 * @param toDay the to_day value
	 */
	public void setToDay (java.lang.Integer toDay) {
		this.toDay = toDay;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmRequestConfig)) return false;
		else {
			jkt.hms.masters.business.MmRequestConfig mmRequestConfig = (jkt.hms.masters.business.MmRequestConfig) obj;
			if (null == this.getId() || null == mmRequestConfig.getId()) return false;
			else return (this.getId().equals(mmRequestConfig.getId()));
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