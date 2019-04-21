package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the employee_shift_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="employee_shift_details"
 */

public abstract class BaseEmployeeShiftDetails implements Serializable {

	public static String REF = "EmployeeShiftDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_FRIDAY_SHIFT = "FridayShift";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_THURSDAY_SHIFT = "ThursdayShift";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SHIFT_END_DATE = "ShiftEndDate";
	public static String PROP_SATURDAY_SHIFT = "SaturdayShift";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_WEDNESDAY_SHIFT = "WednesdayShift";
	public static String PROP_MONDAY_SHIFT = "MondayShift";
	public static String PROP_SHIFT_START_DATE = "ShiftStartDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_TUESDAY_SHIFT = "TuesdayShift";
	public static String PROP_SUNDAY_SHIFT = "SundayShift";

	// constructors
	public BaseEmployeeShiftDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployeeShiftDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date shiftStartDate;
	private java.util.Date shiftEndDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hrms.masters.business.MasShiftCodes sundayShift;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MasShiftCodes mondayShift;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hrms.masters.business.MasShiftCodes thursdayShift;
	private jkt.hrms.masters.business.MasShiftCodes wednesdayShift;
	private jkt.hrms.masters.business.MasShiftCodes saturdayShift;
	private jkt.hrms.masters.business.MasShiftCodes fridayShift;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hrms.masters.business.MasShiftCodes tuesdayShift;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="shift_details_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: shift_start_date
	 */
	public java.util.Date getShiftStartDate() {
		return shiftStartDate;
	}

	/**
	 * Set the value related to the column: shift_start_date
	 * 
	 * @param shiftStartDate
	 *            the shift_start_date value
	 */
	public void setShiftStartDate(java.util.Date shiftStartDate) {
		this.shiftStartDate = shiftStartDate;
	}

	/**
	 * Return the value associated with the column: shift_end_date
	 */
	public java.util.Date getShiftEndDate() {
		return shiftEndDate;
	}

	/**
	 * Set the value related to the column: shift_end_date
	 * 
	 * @param shiftEndDate
	 *            the shift_end_date value
	 */
	public void setShiftEndDate(java.util.Date shiftEndDate) {
		this.shiftEndDate = shiftEndDate;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: sunday_shift_id
	 */
	public jkt.hrms.masters.business.MasShiftCodes getSundayShift() {
		return sundayShift;
	}

	/**
	 * Set the value related to the column: sunday_shift_id
	 * 
	 * @param sundayShift
	 *            the sunday_shift_id value
	 */
	public void setSundayShift(
			jkt.hrms.masters.business.MasShiftCodes sundayShift) {
		this.sundayShift = sundayShift;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: monday_shift_id
	 */
	public jkt.hrms.masters.business.MasShiftCodes getMondayShift() {
		return mondayShift;
	}

	/**
	 * Set the value related to the column: monday_shift_id
	 * 
	 * @param mondayShift
	 *            the monday_shift_id value
	 */
	public void setMondayShift(
			jkt.hrms.masters.business.MasShiftCodes mondayShift) {
		this.mondayShift = mondayShift;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: thursday_shift_id
	 */
	public jkt.hrms.masters.business.MasShiftCodes getThursdayShift() {
		return thursdayShift;
	}

	/**
	 * Set the value related to the column: thursday_shift_id
	 * 
	 * @param thursdayShift
	 *            the thursday_shift_id value
	 */
	public void setThursdayShift(
			jkt.hrms.masters.business.MasShiftCodes thursdayShift) {
		this.thursdayShift = thursdayShift;
	}

	/**
	 * Return the value associated with the column: wednesday_shift_id
	 */
	public jkt.hrms.masters.business.MasShiftCodes getWednesdayShift() {
		return wednesdayShift;
	}

	/**
	 * Set the value related to the column: wednesday_shift_id
	 * 
	 * @param wednesdayShift
	 *            the wednesday_shift_id value
	 */
	public void setWednesdayShift(
			jkt.hrms.masters.business.MasShiftCodes wednesdayShift) {
		this.wednesdayShift = wednesdayShift;
	}

	/**
	 * Return the value associated with the column: saturday_shift_id
	 */
	public jkt.hrms.masters.business.MasShiftCodes getSaturdayShift() {
		return saturdayShift;
	}

	/**
	 * Set the value related to the column: saturday_shift_id
	 * 
	 * @param saturdayShift
	 *            the saturday_shift_id value
	 */
	public void setSaturdayShift(
			jkt.hrms.masters.business.MasShiftCodes saturdayShift) {
		this.saturdayShift = saturdayShift;
	}

	/**
	 * Return the value associated with the column: friday_shift_id
	 */
	public jkt.hrms.masters.business.MasShiftCodes getFridayShift() {
		return fridayShift;
	}

	/**
	 * Set the value related to the column: friday_shift_id
	 * 
	 * @param fridayShift
	 *            the friday_shift_id value
	 */
	public void setFridayShift(
			jkt.hrms.masters.business.MasShiftCodes fridayShift) {
		this.fridayShift = fridayShift;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	/**
	 * Return the value associated with the column: tuesday_shift_id
	 */
	public jkt.hrms.masters.business.MasShiftCodes getTuesdayShift() {
		return tuesdayShift;
	}

	/**
	 * Set the value related to the column: tuesday_shift_id
	 * 
	 * @param tuesdayShift
	 *            the tuesday_shift_id value
	 */
	public void setTuesdayShift(
			jkt.hrms.masters.business.MasShiftCodes tuesdayShift) {
		this.tuesdayShift = tuesdayShift;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.EmployeeShiftDetails)) {
			return false;
		} else {
			jkt.hrms.masters.business.EmployeeShiftDetails employeeShiftDetails = (jkt.hrms.masters.business.EmployeeShiftDetails) obj;
			if (null == this.getId() || null == employeeShiftDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(employeeShiftDetails.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}