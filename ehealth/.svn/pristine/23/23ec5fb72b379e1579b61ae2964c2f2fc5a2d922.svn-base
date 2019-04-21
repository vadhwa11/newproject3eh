package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_calendar table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_calendar"
 */

public abstract class BaseMstrCalendar  implements Serializable {

	public static String REF = "MstrCalendar";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_CALENDAR_CODE = "CalendarCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CALENDAR_NAME = "CalendarName";


	// constructors
	public BaseMstrCalendar () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrCalendar (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String calendarCode;
	private java.lang.String calendarName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hrms.masters.business.ProjectCalendar> projectCalendars;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="calendar_id"
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
	 * Return the value associated with the column: calendar_code
	 */
	public java.lang.String getCalendarCode () {
		return calendarCode;
	}

	/**
	 * Set the value related to the column: calendar_code
	 * @param calendarCode the calendar_code value
	 */
	public void setCalendarCode (java.lang.String calendarCode) {
		this.calendarCode = calendarCode;
	}



	/**
	 * Return the value associated with the column: calendar_name
	 */
	public java.lang.String getCalendarName () {
		return calendarName;
	}

	/**
	 * Set the value related to the column: calendar_name
	 * @param calendarName the calendar_name value
	 */
	public void setCalendarName (java.lang.String calendarName) {
		this.calendarName = calendarName;
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
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: ProjectCalendars
	 */
	public java.util.Set<jkt.hrms.masters.business.ProjectCalendar> getProjectCalendars () {
		return projectCalendars;
	}

	/**
	 * Set the value related to the column: ProjectCalendars
	 * @param projectCalendars the ProjectCalendars value
	 */
	public void setProjectCalendars (java.util.Set<jkt.hrms.masters.business.ProjectCalendar> projectCalendars) {
		this.projectCalendars = projectCalendars;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrCalendar)) return false;
		else {
			jkt.hrms.masters.business.MstrCalendar mstrCalendar = (jkt.hrms.masters.business.MstrCalendar) obj;
			if (null == this.getId() || null == mstrCalendar.getId()) return false;
			else return (this.getId().equals(mstrCalendar.getId()));
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