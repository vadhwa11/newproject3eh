package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_shift table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_shift"
 */

public abstract class BaseHrMasShift  implements Serializable {

	public static String REF = "HrMasShift";
	public static String PROP_STATUS = "Status";
	public static String PROP_SHIFT_END_TIME = "ShiftEndTime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SESSION = "Session";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SHIFT_START_TIME = "ShiftStartTime";
	public static String PROP_ID = "Id";
	public static String PROP_SHIFT_CODES = "ShiftCodes";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_EMPLOYEE_CATEGORY = "EmployeeCategory";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrMasShift () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasShift (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String shiftStartTime;
	private java.lang.String shiftEndTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String session;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmpCategory employeeCategory;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hrms.masters.business.HrMasShiftCodes shiftCodes;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="shift_id"
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
	 * Return the value associated with the column: shift_start_time
	 */
	public java.lang.String getShiftStartTime () {
		return shiftStartTime;
	}

	/**
	 * Set the value related to the column: shift_start_time
	 * @param shiftStartTime the shift_start_time value
	 */
	public void setShiftStartTime (java.lang.String shiftStartTime) {
		this.shiftStartTime = shiftStartTime;
	}



	/**
	 * Return the value associated with the column: shift_end_time
	 */
	public java.lang.String getShiftEndTime () {
		return shiftEndTime;
	}

	/**
	 * Set the value related to the column: shift_end_time
	 * @param shiftEndTime the shift_end_time value
	 */
	public void setShiftEndTime (java.lang.String shiftEndTime) {
		this.shiftEndTime = shiftEndTime;
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
	 * Return the value associated with the column: session
	 */
	public java.lang.String getSession () {
		return session;
	}

	/**
	 * Set the value related to the column: session
	 * @param session the session value
	 */
	public void setSession (java.lang.String session) {
		this.session = session;
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
	 * Return the value associated with the column: employee_category
	 */
	public jkt.hms.masters.business.MasEmpCategory getEmployeeCategory () {
		return employeeCategory;
	}

	/**
	 * Set the value related to the column: employee_category
	 * @param employeeCategory the employee_category value
	 */
	public void setEmployeeCategory (jkt.hms.masters.business.MasEmpCategory employeeCategory) {
		this.employeeCategory = employeeCategory;
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
	 * Return the value associated with the column: shift_codes_id
	 */
	public jkt.hrms.masters.business.HrMasShiftCodes getShiftCodes () {
		return shiftCodes;
	}

	/**
	 * Set the value related to the column: shift_codes_id
	 * @param shiftCodes the shift_codes_id value
	 */
	public void setShiftCodes (jkt.hrms.masters.business.HrMasShiftCodes shiftCodes) {
		this.shiftCodes = shiftCodes;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrMasShift)) return false;
		else {
			jkt.hrms.masters.business.HrMasShift hrMasShift = (jkt.hrms.masters.business.HrMasShift) obj;
			if (null == this.getId() || null == hrMasShift.getId()) return false;
			else return (this.getId().equals(hrMasShift.getId()));
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