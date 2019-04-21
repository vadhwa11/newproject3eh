package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_check_in_out table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_check_in_out"
 */

public abstract class BaseTempCheckInOut  implements Serializable {

	public static String REF = "TempCheckInOut";
	public static String PROP_CHECKTIME = "Checktime";
	public static String PROP_DATES = "Dates";
	public static String PROP_MONTHS = "Months";
	public static String PROP_DAYS = "Days";
	public static String PROP_TIMES = "Times";
	public static String PROP_YEARS = "Years";
	public static String PROP_ID = "Id";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_CHECKTYPE = "Checktype";


	// constructors
	public BaseTempCheckInOut () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempCheckInOut (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String checktime;
	private java.lang.String checktype;
	private java.lang.String dates;
	private java.lang.String days;
	private java.lang.String months;
	private java.lang.String times;
	private java.lang.Integer userId;
	private java.lang.String years;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Id"
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TempCheckInOut)) return false;
		else {
			jkt.hms.masters.business.TempCheckInOut tempCheckInOut = (jkt.hms.masters.business.TempCheckInOut) obj;
			if (null == this.getId() || null == tempCheckInOut.getId()) return false;
			else return (this.getId().equals(tempCheckInOut.getId()));
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