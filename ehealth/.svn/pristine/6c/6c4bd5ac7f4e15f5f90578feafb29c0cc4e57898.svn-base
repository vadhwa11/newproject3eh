package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_speciality_group table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_speciality_group"
 */

public abstract class BaseMasSpecialityGroup  implements Serializable {

	public static String REF = "MasSpecialityGroup";
	public static String PROP_STATUS = "Status";
	public static String PROP_SP_GROUP_CODE = "SpGroupCode";
	public static String PROP_SP_HEADING = "SpHeading";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DISPLAY = "Display";
	public static String PROP_SP_GROUP_NAME = "SpGroupName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasSpecialityGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSpecialityGroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String spGroupCode;
	private java.lang.String spGroupName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String display;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasSpecialityHeading spHeading;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="sp_group_id"
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
	 * Return the value associated with the column: sp_group_code
	 */
	public java.lang.String getSpGroupCode () {
		return spGroupCode;
	}

	/**
	 * Set the value related to the column: sp_group_code
	 * @param spGroupCode the sp_group_code value
	 */
	public void setSpGroupCode (java.lang.String spGroupCode) {
		this.spGroupCode = spGroupCode;
	}



	/**
	 * Return the value associated with the column: sp_group_name
	 */
	public java.lang.String getSpGroupName () {
		return spGroupName;
	}

	/**
	 * Set the value related to the column: sp_group_name
	 * @param spGroupName the sp_group_name value
	 */
	public void setSpGroupName (java.lang.String spGroupName) {
		this.spGroupName = spGroupName;
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
	 * Return the value associated with the column: display
	 */
	public java.lang.String getDisplay () {
		return display;
	}

	/**
	 * Set the value related to the column: display
	 * @param display the display value
	 */
	public void setDisplay (java.lang.String display) {
		this.display = display;
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
	 * Return the value associated with the column: sp_heading_id
	 */
	public jkt.hms.masters.business.MasSpecialityHeading getSpHeading () {
		return spHeading;
	}

	/**
	 * Set the value related to the column: sp_heading_id
	 * @param spHeading the sp_heading_id value
	 */
	public void setSpHeading (jkt.hms.masters.business.MasSpecialityHeading spHeading) {
		this.spHeading = spHeading;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSpecialityGroup)) return false;
		else {
			jkt.hms.masters.business.MasSpecialityGroup masSpecialityGroup = (jkt.hms.masters.business.MasSpecialityGroup) obj;
			if (null == this.getId() || null == masSpecialityGroup.getId()) return false;
			else return (this.getId().equals(masSpecialityGroup.getId()));
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