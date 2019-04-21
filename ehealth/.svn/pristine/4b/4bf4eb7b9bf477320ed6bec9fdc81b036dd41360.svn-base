package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bulk_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bulk_main"
 */

public abstract class BaseBulkMain  implements Serializable {

	public static String REF = "BulkMain";
	public static String PROP_USER = "User";
	public static String PROP_REPEAT_FREQUENCY = "RepeatFrequency";
	public static String PROP_SYSTEM_TIME = "SystemTime";
	public static String PROP_REPEAT_DAY_OF_MONTH = "RepeatDayOfMonth";
	public static String PROP_MESSAGE = "Message";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HOURS = "Hours";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_REPEAT_YEAR = "RepeatYear";
	public static String PROP_NAME = "Name";
	public static String PROP_SYSTEM_DATE = "SystemDate";
	public static String PROP_REPEAT_STATUS = "RepeatStatus";
	public static String PROP_ACTIVATE_TIME = "ActivateTime";
	public static String PROP_REPEAT_TIME = "RepeatTime";
	public static String PROP_SCHEDULE_STATUS = "ScheduleStatus";
	public static String PROP_SEND_STATUS = "SendStatus";
	public static String PROP_ID = "Id";
	public static String PROP_ACTIVE_DATE = "ActiveDate";
	public static String PROP_REPEAT_WEEK_DAY = "RepeatWeekDay";
	public static String PROP_MINUTES = "Minutes";
	public static String PROP_EDIT_STATUS = "EditStatus";


	// constructors
	public BaseBulkMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBulkMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.util.Date activeDate;
	private java.lang.String activateTime;
	private java.lang.String editStatus;
	private java.lang.String priority;
	private java.lang.String scheduleStatus;
	private java.lang.String repeatStatus;
	private java.lang.String sendStatus;
	private java.lang.String repeatFrequency;
	private java.lang.String repeatTime;
	private java.lang.String repeatDayOfMonth;
	private java.lang.String repeatWeekDay;
	private java.lang.String repeatYear;
	private java.util.Date systemDate;
	private java.lang.String systemTime;
	private java.lang.String message;
	private java.lang.Long hours;
	private java.lang.Long minutes;

	// many to one
	private jkt.hms.masters.business.Users user;
	private jkt.hms.masters.business.MasHospital hospital;



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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: active_date
	 */
	public java.util.Date getActiveDate () {
		return activeDate;
	}

	/**
	 * Set the value related to the column: active_date
	 * @param activeDate the active_date value
	 */
	public void setActiveDate (java.util.Date activeDate) {
		this.activeDate = activeDate;
	}



	/**
	 * Return the value associated with the column: activate_time
	 */
	public java.lang.String getActivateTime () {
		return activateTime;
	}

	/**
	 * Set the value related to the column: activate_time
	 * @param activateTime the activate_time value
	 */
	public void setActivateTime (java.lang.String activateTime) {
		this.activateTime = activateTime;
	}



	/**
	 * Return the value associated with the column: edit_status
	 */
	public java.lang.String getEditStatus () {
		return editStatus;
	}

	/**
	 * Set the value related to the column: edit_status
	 * @param editStatus the edit_status value
	 */
	public void setEditStatus (java.lang.String editStatus) {
		this.editStatus = editStatus;
	}



	/**
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: schedule_status
	 */
	public java.lang.String getScheduleStatus () {
		return scheduleStatus;
	}

	/**
	 * Set the value related to the column: schedule_status
	 * @param scheduleStatus the schedule_status value
	 */
	public void setScheduleStatus (java.lang.String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}



	/**
	 * Return the value associated with the column: repeat_status
	 */
	public java.lang.String getRepeatStatus () {
		return repeatStatus;
	}

	/**
	 * Set the value related to the column: repeat_status
	 * @param repeatStatus the repeat_status value
	 */
	public void setRepeatStatus (java.lang.String repeatStatus) {
		this.repeatStatus = repeatStatus;
	}



	/**
	 * Return the value associated with the column: send_status
	 */
	public java.lang.String getSendStatus () {
		return sendStatus;
	}

	/**
	 * Set the value related to the column: send_status
	 * @param sendStatus the send_status value
	 */
	public void setSendStatus (java.lang.String sendStatus) {
		this.sendStatus = sendStatus;
	}



	/**
	 * Return the value associated with the column: repeat_frequency
	 */
	public java.lang.String getRepeatFrequency () {
		return repeatFrequency;
	}

	/**
	 * Set the value related to the column: repeat_frequency
	 * @param repeatFrequency the repeat_frequency value
	 */
	public void setRepeatFrequency (java.lang.String repeatFrequency) {
		this.repeatFrequency = repeatFrequency;
	}



	/**
	 * Return the value associated with the column: repeat_time
	 */
	public java.lang.String getRepeatTime () {
		return repeatTime;
	}

	/**
	 * Set the value related to the column: repeat_time
	 * @param repeatTime the repeat_time value
	 */
	public void setRepeatTime (java.lang.String repeatTime) {
		this.repeatTime = repeatTime;
	}



	/**
	 * Return the value associated with the column: repeat_day_of_month
	 */
	public java.lang.String getRepeatDayOfMonth () {
		return repeatDayOfMonth;
	}

	/**
	 * Set the value related to the column: repeat_day_of_month
	 * @param repeatDayOfMonth the repeat_day_of_month value
	 */
	public void setRepeatDayOfMonth (java.lang.String repeatDayOfMonth) {
		this.repeatDayOfMonth = repeatDayOfMonth;
	}



	/**
	 * Return the value associated with the column: repeat_week_day
	 */
	public java.lang.String getRepeatWeekDay () {
		return repeatWeekDay;
	}

	/**
	 * Set the value related to the column: repeat_week_day
	 * @param repeatWeekDay the repeat_week_day value
	 */
	public void setRepeatWeekDay (java.lang.String repeatWeekDay) {
		this.repeatWeekDay = repeatWeekDay;
	}



	/**
	 * Return the value associated with the column: repeat_year
	 */
	public java.lang.String getRepeatYear () {
		return repeatYear;
	}

	/**
	 * Set the value related to the column: repeat_year
	 * @param repeatYear the repeat_year value
	 */
	public void setRepeatYear (java.lang.String repeatYear) {
		this.repeatYear = repeatYear;
	}



	/**
	 * Return the value associated with the column: system_date
	 */
	public java.util.Date getSystemDate () {
		return systemDate;
	}

	/**
	 * Set the value related to the column: system_date
	 * @param systemDate the system_date value
	 */
	public void setSystemDate (java.util.Date systemDate) {
		this.systemDate = systemDate;
	}



	/**
	 * Return the value associated with the column: system_time
	 */
	public java.lang.String getSystemTime () {
		return systemTime;
	}

	/**
	 * Set the value related to the column: system_time
	 * @param systemTime the system_time value
	 */
	public void setSystemTime (java.lang.String systemTime) {
		this.systemTime = systemTime;
	}



	/**
	 * Return the value associated with the column: message
	 */
	public java.lang.String getMessage () {
		return message;
	}

	/**
	 * Set the value related to the column: message
	 * @param message the message value
	 */
	public void setMessage (java.lang.String message) {
		this.message = message;
	}



	/**
	 * Return the value associated with the column: hours
	 */
	public java.lang.Long getHours () {
		return hours;
	}

	/**
	 * Set the value related to the column: hours
	 * @param hours the hours value
	 */
	public void setHours (java.lang.Long hours) {
		this.hours = hours;
	}



	/**
	 * Return the value associated with the column: minutes
	 */
	public java.lang.Long getMinutes () {
		return minutes;
	}

	/**
	 * Set the value related to the column: minutes
	 * @param minutes the minutes value
	 */
	public void setMinutes (java.lang.Long minutes) {
		this.minutes = minutes;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public jkt.hms.masters.business.Users getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (jkt.hms.masters.business.Users user) {
		this.user = user;
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
		if (!(obj instanceof jkt.hms.masters.business.BulkMain)) return false;
		else {
			jkt.hms.masters.business.BulkMain bulkMain = (jkt.hms.masters.business.BulkMain) obj;
			if (null == this.getId() || null == bulkMain.getId()) return false;
			else return (this.getId().equals(bulkMain.getId()));
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