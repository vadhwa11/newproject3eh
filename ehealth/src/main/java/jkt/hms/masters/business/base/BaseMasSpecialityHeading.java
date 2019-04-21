package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_speciality_heading table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_speciality_heading"
 */

public abstract class BaseMasSpecialityHeading  implements Serializable {

	public static String REF = "MasSpecialityHeading";
	public static String PROP_STATUS = "Status";
	public static String PROP_SP_HEADING_TWO = "SpHeadingTwo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_SP_COMMON_HEADING = "SpCommonHeading";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SP_HEADING_ONE = "SpHeadingOne";


	// constructors
	public BaseMasSpecialityHeading () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSpecialityHeading (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String spHeadingOne;
	private java.lang.String spHeadingTwo;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String spCommonHeading;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="sp_heading_id"
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
	 * Return the value associated with the column: sp_heading_one
	 */
	public java.lang.String getSpHeadingOne () {
		return spHeadingOne;
	}

	/**
	 * Set the value related to the column: sp_heading_one
	 * @param spHeadingOne the sp_heading_one value
	 */
	public void setSpHeadingOne (java.lang.String spHeadingOne) {
		this.spHeadingOne = spHeadingOne;
	}



	/**
	 * Return the value associated with the column: sp_heading_two
	 */
	public java.lang.String getSpHeadingTwo () {
		return spHeadingTwo;
	}

	/**
	 * Set the value related to the column: sp_heading_two
	 * @param spHeadingTwo the sp_heading_two value
	 */
	public void setSpHeadingTwo (java.lang.String spHeadingTwo) {
		this.spHeadingTwo = spHeadingTwo;
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
	 * Return the value associated with the column: sp_common_heading
	 */
	public java.lang.String getSpCommonHeading () {
		return spCommonHeading;
	}

	/**
	 * Set the value related to the column: sp_common_heading
	 * @param spCommonHeading the sp_common_heading value
	 */
	public void setSpCommonHeading (java.lang.String spCommonHeading) {
		this.spCommonHeading = spCommonHeading;
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
		if (!(obj instanceof jkt.hms.masters.business.MasSpecialityHeading)) return false;
		else {
			jkt.hms.masters.business.MasSpecialityHeading masSpecialityHeading = (jkt.hms.masters.business.MasSpecialityHeading) obj;
			if (null == this.getId() || null == masSpecialityHeading.getId()) return false;
			else return (this.getId().equals(masSpecialityHeading.getId()));
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