package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_attendance_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_attendance_data"
 */

public abstract class BaseTempAttendanceData  implements Serializable {

	public static String REF = "TempAttendanceData";
	public static String PROP_ATTENDANCE_DATE = "AttendanceDate";
	public static String PROP_ID = "Id";
	public static String PROP_ATTENDANCE_TIME = "AttendanceTime";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseTempAttendanceData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempAttendanceData (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String attendanceTime;
	private java.util.Date attendanceDate;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="attendance_data_id"
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
	 * Return the value associated with the column: attendance_time
	 */
	public java.lang.String getAttendanceTime () {
		return attendanceTime;
	}

	/**
	 * Set the value related to the column: attendance_time
	 * @param attendanceTime the attendance_time value
	 */
	public void setAttendanceTime (java.lang.String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}



	/**
	 * Return the value associated with the column: attendance_date
	 */
	public java.util.Date getAttendanceDate () {
		return attendanceDate;
	}

	/**
	 * Set the value related to the column: attendance_date
	 * @param attendanceDate the attendance_date value
	 */
	public void setAttendanceDate (java.util.Date attendanceDate) {
		this.attendanceDate = attendanceDate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.TempAttendanceData)) return false;
		else {
			jkt.hrms.masters.business.TempAttendanceData tempAttendanceData = (jkt.hrms.masters.business.TempAttendanceData) obj;
			if (null == this.getId() || null == tempAttendanceData.getId()) return false;
			else return (this.getId().equals(tempAttendanceData.getId()));
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