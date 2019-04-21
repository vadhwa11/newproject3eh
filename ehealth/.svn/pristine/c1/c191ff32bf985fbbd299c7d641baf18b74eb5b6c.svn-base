package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_attendance_loader table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_attendance_loader"
 */

public abstract class BaseHrAttendanceLoader  implements Serializable {

	public static String REF = "HrAttendanceLoader";
	public static String PROP_FLAG = "Flag";
	public static String PROP_TOTAL_HOURS = "TotalHours";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VALIDATE = "Validate";
	public static String PROP_OUT_DATE = "OutDate";
	public static String PROP_SHIFT_CODES = "ShiftCodes";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_CARD_NO = "CardNo";
	public static String PROP_AUTHORIZED = "Authorized";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE = "Date";
	public static String PROP_PROCESSED = "Processed";
	public static String PROP_TIME_IN = "TimeIn";
	public static String PROP_ID = "Id";
	public static String PROP_ATTENDANCE_MARK = "AttendanceMark";
	public static String PROP_TIME_OUT = "TimeOut";
	public static String PROP_VERIFIED = "Verified";
	public static String PROP_REMARK = "Remark";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE_NAME = "EmployeeName";


	// constructors
	public BaseHrAttendanceLoader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrAttendanceLoader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



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
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String flag;
	private java.lang.String authorized;
	private java.lang.String processed;
	private java.lang.String attendanceMark;
	private java.util.Date outDate;
	private java.lang.String cardNo;
	private java.lang.String employeeName;
	private java.lang.String totalHours;
	private java.lang.String status;

	// many to one
	
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hrms.masters.business.HrMasShiftCodes shiftCodes;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="attendance_id"
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
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: time_in
	 */
	public java.lang.String getTimeIn () {
		return timeIn;
	}

	/**
	 * Set the value related to the column: time_in
	 * @param timeIn the time_in value
	 */
	public void setTimeIn (java.lang.String timeIn) {
		this.timeIn = timeIn;
	}



	/**
	 * Return the value associated with the column: time_out
	 */
	public java.lang.String getTimeOut () {
		return timeOut;
	}

	/**
	 * Set the value related to the column: time_out
	 * @param timeOut the time_out value
	 */
	public void setTimeOut (java.lang.String timeOut) {
		this.timeOut = timeOut;
	}



	/**
	 * Return the value associated with the column: verified
	 */
	public java.lang.String getVerified () {
		return verified;
	}

	/**
	 * Set the value related to the column: verified
	 * @param verified the verified value
	 */
	public void setVerified (java.lang.String verified) {
		this.verified = verified;
	}



	/**
	 * Return the value associated with the column: validate
	 */
	public java.lang.String getValidate () {
		return validate;
	}

	/**
	 * Set the value related to the column: validate
	 * @param validate the validate value
	 */
	public void setValidate (java.lang.String validate) {
		this.validate = validate;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
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
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: authorized
	 */
	public java.lang.String getAuthorized () {
		return authorized;
	}

	/**
	 * Set the value related to the column: authorized
	 * @param authorized the authorized value
	 */
	public void setAuthorized (java.lang.String authorized) {
		this.authorized = authorized;
	}



	/**
	 * Return the value associated with the column: processed
	 */
	public java.lang.String getProcessed () {
		return processed;
	}

	/**
	 * Set the value related to the column: processed
	 * @param processed the processed value
	 */
	public void setProcessed (java.lang.String processed) {
		this.processed = processed;
	}



	/**
	 * Return the value associated with the column: attendance_mark
	 */
	public java.lang.String getAttendanceMark () {
		return attendanceMark;
	}

	/**
	 * Set the value related to the column: attendance_mark
	 * @param attendanceMark the attendance_mark value
	 */
	public void setAttendanceMark (java.lang.String attendanceMark) {
		this.attendanceMark = attendanceMark;
	}



	/**
	 * Return the value associated with the column: out_date
	 */
	public java.util.Date getOutDate () {
		return outDate;
	}

	/**
	 * Set the value related to the column: out_date
	 * @param outDate the out_date value
	 */
	public void setOutDate (java.util.Date outDate) {
		this.outDate = outDate;
	}



	/**
	 * Return the value associated with the column: card_no
	 */
	public java.lang.String getCardNo () {
		return cardNo;
	}

	/**
	 * Set the value related to the column: card_no
	 * @param cardNo the card_no value
	 */
	public void setCardNo (java.lang.String cardNo) {
		this.cardNo = cardNo;
	}



	/**
	 * Return the value associated with the column: employee_name
	 */
	public java.lang.String getEmployeeName () {
		return employeeName;
	}

	/**
	 * Set the value related to the column: employee_name
	 * @param employeeName the employee_name value
	 */
	public void setEmployeeName (java.lang.String employeeName) {
		this.employeeName = employeeName;
	}



	/**
	 * Return the value associated with the column: total_hr
	 */
	public java.lang.String getTotalHours () {
		return totalHours;
	}

	/**
	 * Set the value related to the column: total_hr
	 * @param totalHours the total_hr value
	 */
	public void setTotalHours (java.lang.String totalHours) {
		this.totalHours = totalHours;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrAttendanceLoader)) return false;
		else {
			jkt.hrms.masters.business.HrAttendanceLoader hrAttendanceLoader = (jkt.hrms.masters.business.HrAttendanceLoader) obj;
			if (null == this.getId() || null == hrAttendanceLoader.getId()) return false;
			else return (this.getId().equals(hrAttendanceLoader.getId()));
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