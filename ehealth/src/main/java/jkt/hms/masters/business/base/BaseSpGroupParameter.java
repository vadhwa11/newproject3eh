package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sp_group_parameter_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sp_group_parameter_m"
 */

public abstract class BaseSpGroupParameter  implements Serializable {

	public static String REF = "SpGroupParameter";
	public static String PROP_STATUS = "Status";
	public static String PROP_SP_GROUP = "SpGroup";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SP_PARAMETER = "SpParameter";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseSpGroupParameter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSpGroupParameter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasSpecialityGroup spGroup;
	private jkt.hms.masters.business.MasSpecialityParameter spParameter;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="group_parameter_m_id"
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
	 * Return the value associated with the column: sp_group_id
	 */
	public jkt.hms.masters.business.MasSpecialityGroup getSpGroup () {
		return spGroup;
	}

	/**
	 * Set the value related to the column: sp_group_id
	 * @param spGroup the sp_group_id value
	 */
	public void setSpGroup (jkt.hms.masters.business.MasSpecialityGroup spGroup) {
		this.spGroup = spGroup;
	}



	/**
	 * Return the value associated with the column: sp_parameter_id
	 */
	public jkt.hms.masters.business.MasSpecialityParameter getSpParameter () {
		return spParameter;
	}

	/**
	 * Set the value related to the column: sp_parameter_id
	 * @param spParameter the sp_parameter_id value
	 */
	public void setSpParameter (jkt.hms.masters.business.MasSpecialityParameter spParameter) {
		this.spParameter = spParameter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SpGroupParameter)) return false;
		else {
			jkt.hms.masters.business.SpGroupParameter spGroupParameter = (jkt.hms.masters.business.SpGroupParameter) obj;
			if (null == this.getId() || null == spGroupParameter.getId()) return false;
			else return (this.getId().equals(spGroupParameter.getId()));
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