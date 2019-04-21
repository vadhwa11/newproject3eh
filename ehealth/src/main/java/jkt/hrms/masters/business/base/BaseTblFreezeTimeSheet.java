package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tbl_freeze_time_sheet table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tbl_freeze_time_sheet"
 */

public abstract class BaseTblFreezeTimeSheet  implements Serializable {

	public static String REF = "TblFreezeTimeSheet";
	public static String PROP_MIN_TIME = "MinTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NO_OF_SUBMISSION = "NoOfSubmission";
	public static String PROP_WEEK4 = "Week4";
	public static String PROP_WEEK5 = "Week5";
	public static String PROP_MONTH = "Month";
	public static String PROP_WEEK3 = "Week3";
	public static String PROP_YEAR = "Year";
	public static String PROP_WEEK2 = "Week2";
	public static String PROP_WEEK1 = "Week1";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE = "Date";
	public static String PROP_ID = "Id";
	public static String PROP_MAX_TIME = "MaxTime";
	public static String PROP_NO_OF_RECORD_SUBMIT = "NoOfRecordSubmit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseTblFreezeTimeSheet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTblFreezeTimeSheet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String year;
	private java.lang.String month;
	private java.lang.Integer date;
	private java.lang.String minTime;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String maxTime;
	private java.lang.String noOfSubmission;
	private java.lang.Integer week1;
	private java.lang.Integer week2;
	private java.lang.Integer week3;
	private java.lang.Integer week4;
	private java.lang.Integer week5;
	private java.lang.Integer noOfRecordSubmit;



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
	 * Return the value associated with the column: year
	 */
	public java.lang.String getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.String year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: month
	 */
	public java.lang.String getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * @param month the month value
	 */
	public void setMonth (java.lang.String month) {
		this.month = month;
	}



	/**
	 * Return the value associated with the column: date
	 */
	public java.lang.Integer getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.lang.Integer date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: min_time
	 */
	public java.lang.String getMinTime () {
		return minTime;
	}

	/**
	 * Set the value related to the column: min_time
	 * @param minTime the min_time value
	 */
	public void setMinTime (java.lang.String minTime) {
		this.minTime = minTime;
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
	 * Return the value associated with the column: max_time
	 */
	public java.lang.String getMaxTime () {
		return maxTime;
	}

	/**
	 * Set the value related to the column: max_time
	 * @param maxTime the max_time value
	 */
	public void setMaxTime (java.lang.String maxTime) {
		this.maxTime = maxTime;
	}



	/**
	 * Return the value associated with the column: no_of_submission
	 */
	public java.lang.String getNoOfSubmission () {
		return noOfSubmission;
	}

	/**
	 * Set the value related to the column: no_of_submission
	 * @param noOfSubmission the no_of_submission value
	 */
	public void setNoOfSubmission (java.lang.String noOfSubmission) {
		this.noOfSubmission = noOfSubmission;
	}



	/**
	 * Return the value associated with the column: week1
	 */
	public java.lang.Integer getWeek1 () {
		return week1;
	}

	/**
	 * Set the value related to the column: week1
	 * @param week1 the week1 value
	 */
	public void setWeek1 (java.lang.Integer week1) {
		this.week1 = week1;
	}



	/**
	 * Return the value associated with the column: week2
	 */
	public java.lang.Integer getWeek2 () {
		return week2;
	}

	/**
	 * Set the value related to the column: week2
	 * @param week2 the week2 value
	 */
	public void setWeek2 (java.lang.Integer week2) {
		this.week2 = week2;
	}



	/**
	 * Return the value associated with the column: week3
	 */
	public java.lang.Integer getWeek3 () {
		return week3;
	}

	/**
	 * Set the value related to the column: week3
	 * @param week3 the week3 value
	 */
	public void setWeek3 (java.lang.Integer week3) {
		this.week3 = week3;
	}



	/**
	 * Return the value associated with the column: week4
	 */
	public java.lang.Integer getWeek4 () {
		return week4;
	}

	/**
	 * Set the value related to the column: week4
	 * @param week4 the week4 value
	 */
	public void setWeek4 (java.lang.Integer week4) {
		this.week4 = week4;
	}



	/**
	 * Return the value associated with the column: week5
	 */
	public java.lang.Integer getWeek5 () {
		return week5;
	}

	/**
	 * Set the value related to the column: week5
	 * @param week5 the week5 value
	 */
	public void setWeek5 (java.lang.Integer week5) {
		this.week5 = week5;
	}



	/**
	 * Return the value associated with the column: no_of_record_submit
	 */
	public java.lang.Integer getNoOfRecordSubmit () {
		return noOfRecordSubmit;
	}

	/**
	 * Set the value related to the column: no_of_record_submit
	 * @param noOfRecordSubmit the no_of_record_submit value
	 */
	public void setNoOfRecordSubmit (java.lang.Integer noOfRecordSubmit) {
		this.noOfRecordSubmit = noOfRecordSubmit;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.TblFreezeTimeSheet)) return false;
		else {
			jkt.hrms.masters.business.TblFreezeTimeSheet tblFreezeTimeSheet = (jkt.hrms.masters.business.TblFreezeTimeSheet) obj;
			if (null == this.getId() || null == tblFreezeTimeSheet.getId()) return false;
			else return (this.getId().equals(tblFreezeTimeSheet.getId()));
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