package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the immunization_card_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="immunization_card_master"
 */

public abstract class BaseImmunizationCardMaster  implements Serializable {

	public static String REF = "ImmunizationCardMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DUE_DATE = "DueDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DURATION = "Duration";
	public static String PROP_DAYS = "Days";
	public static String PROP_ICM_ID = "IcmId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DETAILS_NAME = "DetailsName";


	// constructors
	public BaseImmunizationCardMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseImmunizationCardMaster (java.lang.Integer icmId) {
		this.setIcmId(icmId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer icmId;

	// fields
	private java.lang.String detailsName;
	private java.lang.String duration;
	private java.lang.Integer days;
	private java.util.Date dueDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="icm_id"
     */
	public java.lang.Integer getIcmId () {
		return icmId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param icmId the new ID
	 */
	public void setIcmId (java.lang.Integer icmId) {
		this.icmId = icmId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: details_name
	 */
	public java.lang.String getDetailsName () {
		return detailsName;
	}

	/**
	 * Set the value related to the column: details_name
	 * @param detailsName the details_name value
	 */
	public void setDetailsName (java.lang.String detailsName) {
		this.detailsName = detailsName;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.Integer getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.Integer days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: due_date
	 */
	public java.util.Date getDueDate () {
		return dueDate;
	}

	/**
	 * Set the value related to the column: due_date
	 * @param dueDate the due_date value
	 */
	public void setDueDate (java.util.Date dueDate) {
		this.dueDate = dueDate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ImmunizationCardMaster)) return false;
		else {
			jkt.hms.masters.business.ImmunizationCardMaster immunizationCardMaster = (jkt.hms.masters.business.ImmunizationCardMaster) obj;
			if (null == this.getIcmId() || null == immunizationCardMaster.getIcmId()) return false;
			else return (this.getIcmId().equals(immunizationCardMaster.getIcmId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIcmId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIcmId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}