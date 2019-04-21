package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_shift table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_shift"
 */

public abstract class BaseMasShift implements Serializable {

	public static String REF = "MasShift";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SHIFT_START_TIME = "ShiftStartTime";
	public static String PROP_SHIFT_CODES = "ShiftCodes";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SHIFT_END_TIME = "ShiftEndTime";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasShift() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasShift(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String shiftStartTime;
	private java.lang.String shiftEndTime;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hrms.masters.business.MasShiftCodes shiftCodes;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="shift_id"
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
	 * Return the value associated with the column: shift_start_time
	 */
	public java.lang.String getShiftStartTime() {
		return shiftStartTime;
	}

	/**
	 * Set the value related to the column: shift_start_time
	 * 
	 * @param shiftStartTime
	 *            the shift_start_time value
	 */
	public void setShiftStartTime(java.lang.String shiftStartTime) {
		this.shiftStartTime = shiftStartTime;
	}

	/**
	 * Return the value associated with the column: shift_end_time
	 */
	public java.lang.String getShiftEndTime() {
		return shiftEndTime;
	}

	/**
	 * Set the value related to the column: shift_end_time
	 * 
	 * @param shiftEndTime
	 *            the shift_end_time value
	 */
	public void setShiftEndTime(java.lang.String shiftEndTime) {
		this.shiftEndTime = shiftEndTime;
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
	 * Return the value associated with the column: shift_codes_id
	 */
	public jkt.hrms.masters.business.MasShiftCodes getShiftCodes() {
		return shiftCodes;
	}

	/**
	 * Set the value related to the column: shift_codes_id
	 * 
	 * @param shiftCodes
	 *            the shift_codes_id value
	 */
	public void setShiftCodes(jkt.hrms.masters.business.MasShiftCodes shiftCodes) {
		this.shiftCodes = shiftCodes;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasShift)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasShift masShift = (jkt.hrms.masters.business.MasShift) obj;
			if (null == this.getId() || null == masShift.getId()) {
				return false;
			} else {
				return (this.getId().equals(masShift.getId()));
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