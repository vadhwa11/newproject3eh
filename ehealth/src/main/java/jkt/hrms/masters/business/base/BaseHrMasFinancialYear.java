package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_financial_year table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_financial_year"
 */

public abstract class BaseHrMasFinancialYear  implements Serializable {

	public static String REF = "HrMasFinancialYear";
	public static String PROP_STATUS = "Status";
	public static String PROP_FY_STATUS = "FyStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_YEAR_DESCRIPTION = "YearDescription";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_YEAR_FROM_DATE = "YearFromDate";
	public static String PROP_YEAR_TO_DATE = "YearToDate";


	// constructors
	public BaseHrMasFinancialYear () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasFinancialYear (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String yearDescription;
	private java.util.Date yearFromDate;
	private java.util.Date yearToDate;
	private java.lang.String financialYear;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String fyStatus;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



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
	 * Return the value associated with the column: year_description
	 */
	public java.lang.String getYearDescription () {
		return yearDescription;
	}

	/**
	 * Set the value related to the column: year_description
	 * @param yearDescription the year_description value
	 */
	public void setYearDescription (java.lang.String yearDescription) {
		this.yearDescription = yearDescription;
	}



	/**
	 * Return the value associated with the column: year_from_date
	 */
	public java.util.Date getYearFromDate () {
		return yearFromDate;
	}

	/**
	 * Set the value related to the column: year_from_date
	 * @param yearFromDate the year_from_date value
	 */
	public void setYearFromDate (java.util.Date yearFromDate) {
		this.yearFromDate = yearFromDate;
	}



	/**
	 * Return the value associated with the column: year_to_date
	 */
	public java.util.Date getYearToDate () {
		return yearToDate;
	}

	/**
	 * Set the value related to the column: year_to_date
	 * @param yearToDate the year_to_date value
	 */
	public void setYearToDate (java.util.Date yearToDate) {
		this.yearToDate = yearToDate;
	}



	/**
	 * Return the value associated with the column: financial_year
	 */
	public java.lang.String getFinancialYear () {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year
	 * @param financialYear the financial_year value
	 */
	public void setFinancialYear (java.lang.String financialYear) {
		this.financialYear = financialYear;
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
	 * Return the value associated with the column: fy_status
	 */
	public java.lang.String getFyStatus () {
		return fyStatus;
	}

	/**
	 * Set the value related to the column: fy_status
	 * @param fyStatus the fy_status value
	 */
	public void setFyStatus (java.lang.String fyStatus) {
		this.fyStatus = fyStatus;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrMasFinancialYear)) return false;
		else {
			jkt.hrms.masters.business.HrMasFinancialYear hrMasFinancialYear = (jkt.hrms.masters.business.HrMasFinancialYear) obj;
			if (null == this.getId() || null == hrMasFinancialYear.getId()) return false;
			else return (this.getId().equals(hrMasFinancialYear.getId()));
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