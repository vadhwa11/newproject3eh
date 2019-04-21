package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_transfer_notification table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_transfer_notification"
 */

public abstract class BaseHrMasTransferNotification  implements Serializable {

	public static String REF = "HrMasTransferNotification";
	public static String PROP_NOTIFICATION_NO = "NotificationNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_APPLICABLE_TO_DATE = "ApplicableToDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_APPLICABLE_FROM_DATE = "ApplicableFromDate";
	public static String PROP_RELEASE_DATE = "ReleaseDate";


	// constructors
	public BaseHrMasTransferNotification () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasTransferNotification (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrMasTransferNotification (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String notificationNo;
	private java.util.Date releaseDate;
	private java.util.Date applicableFromDate;
	private java.util.Date applicableToDate;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="notification_id"
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
	 * Return the value associated with the column: notification_no
	 */
	public java.lang.String getNotificationNo () {
		return notificationNo;
	}

	/**
	 * Set the value related to the column: notification_no
	 * @param notificationNo the notification_no value
	 */
	public void setNotificationNo (java.lang.String notificationNo) {
		this.notificationNo = notificationNo;
	}



	/**
	 * Return the value associated with the column: release_date
	 */
	public java.util.Date getReleaseDate () {
		return releaseDate;
	}

	/**
	 * Set the value related to the column: release_date
	 * @param releaseDate the release_date value
	 */
	public void setReleaseDate (java.util.Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	/**
	 * Return the value associated with the column: applicable_from_date
	 */
	public java.util.Date getApplicableFromDate () {
		return applicableFromDate;
	}

	/**
	 * Set the value related to the column: applicable_from_date
	 * @param applicableFromDate the applicable_from_date value
	 */
	public void setApplicableFromDate (java.util.Date applicableFromDate) {
		this.applicableFromDate = applicableFromDate;
	}



	/**
	 * Return the value associated with the column: applicable_to_date
	 */
	public java.util.Date getApplicableToDate () {
		return applicableToDate;
	}

	/**
	 * Set the value related to the column: applicable_to_date
	 * @param applicableToDate the applicable_to_date value
	 */
	public void setApplicableToDate (java.util.Date applicableToDate) {
		this.applicableToDate = applicableToDate;
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
		if (!(obj instanceof jkt.hms.masters.business.HrMasTransferNotification)) return false;
		else {
			jkt.hms.masters.business.HrMasTransferNotification hrMasTransferNotification = (jkt.hms.masters.business.HrMasTransferNotification) obj;
			if (null == this.getId() || null == hrMasTransferNotification.getId()) return false;
			else return (this.getId().equals(hrMasTransferNotification.getId()));
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