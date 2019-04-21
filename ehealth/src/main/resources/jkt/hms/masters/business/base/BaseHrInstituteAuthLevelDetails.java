package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_institute_auth_level_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_institute_auth_level_details"
 */

public abstract class BaseHrInstituteAuthLevelDetails  implements Serializable {

	public static String REF = "HrInstituteAuthLevelDetails";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_HR_INSTITUTE_AUTH_LEVEL = "HrInstituteAuthLevel";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";


	// constructors
	public BaseHrInstituteAuthLevelDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrInstituteAuthLevelDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrInstituteAuthLevelDetails (
		java.lang.Integer id,
		java.lang.Integer id) {

		this.setId(id);
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer id;
	private java.lang.String designation;
	private java.lang.Integer slNo;
	private java.lang.Integer employeeId;
//	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.HrInstituteAuthLevel hrInstituteAuthLevel;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Users lastChgBy;



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
	 * Return the value associated with the column: id
	 */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the value related to the column: id
	 * @param id the id value
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: designation
	 */
	public java.lang.String getDesignation () {
		return designation;
	}

	/**
	 * Set the value related to the column: designation
	 * @param designation the designation value
	 */
	public void setDesignation (java.lang.String designation) {
		this.designation = designation;
	}



	/**
	 * Return the value associated with the column: sl_no
	 */
	public java.lang.Integer getSlNo () {
		return slNo;
	}

	/**
	 * Set the value related to the column: sl_no
	 * @param slNo the sl_no value
	 */
	public void setSlNo (java.lang.Integer slNo) {
		this.slNo = slNo;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public java.lang.Integer getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (java.lang.Integer employeeId) {
		this.employeeId = employeeId;
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
	 * Return the value associated with the column: hr_institute_auth_level_id
	 */
	public jkt.hms.masters.business.HrInstituteAuthLevel getHrInstituteAuthLevel () {
		return hrInstituteAuthLevel;
	}

	/**
	 * Set the value related to the column: hr_institute_auth_level_id
	 * @param hrInstituteAuthLevel the hr_institute_auth_level_id value
	 */
	public void setHrInstituteAuthLevel (jkt.hms.masters.business.HrInstituteAuthLevel hrInstituteAuthLevel) {
		this.hrInstituteAuthLevel = hrInstituteAuthLevel;
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
		if (!(obj instanceof jkt.hms.masters.business.HrInstituteAuthLevelDetails)) return false;
		else {
			jkt.hms.masters.business.HrInstituteAuthLevelDetails hrInstituteAuthLevelDetails = (jkt.hms.masters.business.HrInstituteAuthLevelDetails) obj;
			if (null == this.getId() || null == hrInstituteAuthLevelDetails.getId()) return false;
			else return (this.getId().equals(hrInstituteAuthLevelDetails.getId()));
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