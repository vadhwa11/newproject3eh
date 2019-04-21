package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_proc_check_in_out table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_proc_check_in_out"
 */

public abstract class BaseTempProcCheckInOut  implements Serializable {

	public static String REF = "TempProcCheckInOut";
	public static String PROP_CHECKTIME = "Checktime";
	public static String PROP_NAME = "Name";
	public static String PROP_DATES = "Dates";
	public static String PROP_MONTHS = "Months";
	public static String PROP_DAYS = "Days";
	public static String PROP_TIMES = "Times";
	public static String PROP_YEARS = "Years";
	public static String PROP_ID = "Id";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_CHECKTYPE = "Checktype";


	// constructors
	public BaseTempProcCheckInOut () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempProcCheckInOut (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer userId;
	private java.lang.String name;
	private java.lang.String checktime;
	private java.lang.Integer department;
	private java.lang.String years;
	private java.lang.String months;
	private java.lang.String dates;
	private java.lang.String days;
	private java.lang.String times;
	private java.lang.String checktype;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: userId
	 */
	public java.lang.Integer getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: userId
	 * @param userId the userId value
	 */
	public void setUserId (java.lang.Integer userId) {
		this.userId = userId;
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
	 * Return the value associated with the column: checktime
	 */
	public java.lang.String getChecktime () {
		return checktime;
	}

	/**
	 * Set the value related to the column: checktime
	 * @param checktime the checktime value
	 */
	public void setChecktime (java.lang.String checktime) {
		this.checktime = checktime;
	}



	/**
	 * Return the value associated with the column: DEFAULTDEPTID
	 */
	public java.lang.Integer getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEFAULTDEPTID
	 * @param department the DEFAULTDEPTID value
	 */
	public void setDepartment (java.lang.Integer department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: years
	 */
	public java.lang.String getYears () {
		return years;
	}

	/**
	 * Set the value related to the column: years
	 * @param years the years value
	 */
	public void setYears (java.lang.String years) {
		this.years = years;
	}



	/**
	 * Return the value associated with the column: months
	 */
	public java.lang.String getMonths () {
		return months;
	}

	/**
	 * Set the value related to the column: months
	 * @param months the months value
	 */
	public void setMonths (java.lang.String months) {
		this.months = months;
	}



	/**
	 * Return the value associated with the column: dates
	 */
	public java.lang.String getDates () {
		return dates;
	}

	/**
	 * Set the value related to the column: dates
	 * @param dates the dates value
	 */
	public void setDates (java.lang.String dates) {
		this.dates = dates;
	}



	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.String getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.String days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: times
	 */
	public java.lang.String getTimes () {
		return times;
	}

	/**
	 * Set the value related to the column: times
	 * @param times the times value
	 */
	public void setTimes (java.lang.String times) {
		this.times = times;
	}



	/**
	 * Return the value associated with the column: checktype
	 */
	public java.lang.String getChecktype () {
		return checktype;
	}

	/**
	 * Set the value related to the column: checktype
	 * @param checktype the checktype value
	 */
	public void setChecktype (java.lang.String checktype) {
		this.checktype = checktype;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TempProcCheckInOut)) return false;
		else {
			jkt.hms.masters.business.TempProcCheckInOut tempProcCheckInOut = (jkt.hms.masters.business.TempProcCheckInOut) obj;
			if (null == this.getId() || null == tempProcCheckInOut.getId()) return false;
			else return (this.getId().equals(tempProcCheckInOut.getId()));
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