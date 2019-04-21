package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_duty_schedule_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_duty_schedule_t"
 */

public abstract class BaseHrDutyScheduleT  implements Serializable {

	public static String REF = "HrDutyScheduleT";
	public static String PROP_TIMEOUT = "Timeout";
	public static String PROP_TIMEIN = "Timein";
	public static String PROP_SCHEDULE_M = "ScheduleM";
	public static String PROP_SHIFT_CODE = "ShiftCode";
	public static String PROP_SCHEDULE_DEPARTMENT = "ScheduleDepartment";
	public static String PROP_SHIFT = "Shift";
	public static String PROP_ID = "Id";
	public static String PROP_DAY = "Day";


	// constructors
	public BaseHrDutyScheduleT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrDutyScheduleT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String day;
	private java.lang.String timein;
	private java.lang.String timeout;

	// many to one
	private jkt.hrms.masters.business.HrMasShift shift;
	private jkt.hrms.masters.business.HrMasShiftCodes shiftCode;
	private jkt.hms.masters.business.HrDutyScheduleM scheduleM;
	private jkt.hms.masters.business.MasDepartment scheduleDepartment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="schedule_t_id"
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
	 * Return the value associated with the column: day
	 */
	public java.lang.String getDay () {
		return day;
	}

	/**
	 * Set the value related to the column: day
	 * @param day the day value
	 */
	public void setDay (java.lang.String day) {
		this.day = day;
	}



	/**
	 * Return the value associated with the column: timein
	 */
	public java.lang.String getTimein () {
		return timein;
	}

	/**
	 * Set the value related to the column: timein
	 * @param timein the timein value
	 */
	public void setTimein (java.lang.String timein) {
		this.timein = timein;
	}



	/**
	 * Return the value associated with the column: timeout
	 */
	public java.lang.String getTimeout () {
		return timeout;
	}

	/**
	 * Set the value related to the column: timeout
	 * @param timeout the timeout value
	 */
	public void setTimeout (java.lang.String timeout) {
		this.timeout = timeout;
	}



	/**
	 * Return the value associated with the column: shift_id
	 */
	public jkt.hrms.masters.business.HrMasShift getShift () {
		return shift;
	}

	/**
	 * Set the value related to the column: shift_id
	 * @param shift the shift_id value
	 */
	public void setShift (jkt.hrms.masters.business.HrMasShift shift) {
		this.shift = shift;
	}



	/**
	 * Return the value associated with the column: shift_codes_id
	 */
	public jkt.hrms.masters.business.HrMasShiftCodes getShiftCode () {
		return shiftCode;
	}

	/**
	 * Set the value related to the column: shift_codes_id
	 * @param shiftCode the shift_codes_id value
	 */
	public void setShiftCode (jkt.hrms.masters.business.HrMasShiftCodes shiftCode) {
		this.shiftCode = shiftCode;
	}



	/**
	 * Return the value associated with the column: schedule_m_id
	 */
	public jkt.hms.masters.business.HrDutyScheduleM getScheduleM () {
		return scheduleM;
	}

	/**
	 * Set the value related to the column: schedule_m_id
	 * @param scheduleM the schedule_m_id value
	 */
	public void setScheduleM (jkt.hms.masters.business.HrDutyScheduleM scheduleM) {
		this.scheduleM = scheduleM;
	}



	/**
	 * Return the value associated with the column: schedule_department
	 */
	public jkt.hms.masters.business.MasDepartment getScheduleDepartment () {
		return scheduleDepartment;
	}

	/**
	 * Set the value related to the column: schedule_department
	 * @param scheduleDepartment the schedule_department value
	 */
	public void setScheduleDepartment (jkt.hms.masters.business.MasDepartment scheduleDepartment) {
		this.scheduleDepartment = scheduleDepartment;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrDutyScheduleT)) return false;
		else {
			jkt.hms.masters.business.HrDutyScheduleT hrDutyScheduleT = (jkt.hms.masters.business.HrDutyScheduleT) obj;
			if (null == this.getId() || null == hrDutyScheduleT.getId()) return false;
			else return (this.getId().equals(hrDutyScheduleT.getId()));
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