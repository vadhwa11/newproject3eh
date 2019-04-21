package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the attendance_loader table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="attendance_loader"
 */

public abstract class BaseAttendanceLoader implements Serializable {

	public static String REF = "AttendanceLoader";
	public static String PROP_TIME_IN = "TimeIn";
	public static String PROP_TIME_OUT = "TimeOut";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REMARK = "Remark";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DATE = "Date";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VERIFIED = "Verified";
	public static String PROP_VALIDATE = "Validate";
	public static String PROP_ID = "Id";

	// constructors
	public BaseAttendanceLoader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAttendanceLoader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date date;
	private java.lang.String timeIn;
	private java.lang.String timeOut;
	private java.lang.String verified;
	private java.lang.String validate;
	private java.lang.String remark;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="attendance_loader_id"
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
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: time_in
	 */
	public java.lang.String getTimeIn() {
		return timeIn;
	}

	/**
	 * Set the value related to the column: time_in
	 * 
	 * @param timeIn
	 *            the time_in value
	 */
	public void setTimeIn(java.lang.String timeIn) {
		this.timeIn = timeIn;
	}

	/**
	 * Return the value associated with the column: time_out
	 */
	public java.lang.String getTimeOut() {
		return timeOut;
	}

	/**
	 * Set the value related to the column: time_out
	 * 
	 * @param timeOut
	 *            the time_out value
	 */
	public void setTimeOut(java.lang.String timeOut) {
		this.timeOut = timeOut;
	}

	/**
	 * Return the value associated with the column: verified
	 */
	public java.lang.String getVerified() {
		return verified;
	}

	/**
	 * Set the value related to the column: verified
	 * 
	 * @param verified
	 *            the verified value
	 */
	public void setVerified(java.lang.String verified) {
		this.verified = verified;
	}

	/**
	 * Return the value associated with the column: validate
	 */
	public java.lang.String getValidate() {
		return validate;
	}

	/**
	 * Set the value related to the column: validate
	 * 
	 * @param validate
	 *            the validate value
	 */
	public void setValidate(java.lang.String validate) {
		this.validate = validate;
	}

	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * 
	 * @param remark
	 *            the remark value
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
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

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.AttendanceLoader)) {
			return false;
		} else {
			jkt.hrms.masters.business.AttendanceLoader attendanceLoader = (jkt.hrms.masters.business.AttendanceLoader) obj;
			if (null == this.getId() || null == attendanceLoader.getId()) {
				return false;
			} else {
				return (this.getId().equals(attendanceLoader.getId()));
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