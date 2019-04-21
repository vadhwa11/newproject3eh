package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bulk_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bulk_details"
 */

public abstract class BaseBulkDetails  implements Serializable {

	public static String REF = "BulkDetails";
	public static String PROP_USER = "User";
	public static String PROP_NAME = "Name";
	public static String PROP_SENT_DATE = "SentDate";
	public static String PROP_SYSTEM_TIME = "SystemTime";
	public static String PROP_SYSTEM_DATE = "SystemDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_MAIN = "Main";
	public static String PROP_SENT_TIME = "SentTime";
	public static String PROP_HOURS = "Hours";
	public static String PROP_ID = "Id";
	public static String PROP_MINUTES = "Minutes";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_MOBILE_NO = "MobileNo";


	// constructors
	public BaseBulkDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBulkDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.lang.String name;
	private java.util.Date systemDate;
	private java.lang.String systemTime;
	private java.lang.String mobileNo;
	private java.lang.Integer hours;
	private java.lang.Integer minutes;
	private java.util.Date sentDate;
	private java.lang.String sentTime;
	private java.lang.Integer priority;

	// many to one
	private jkt.hms.masters.business.BulkMain main;
	private jkt.hms.masters.business.Users user;



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
	 * Return the value associated with the column: system_date
	 */
	public java.util.Date getSystemDate () {
		return systemDate;
	}

	/**
	 * Set the value related to the column: system_date
	 * @param systemDate the system_date value
	 */
	public void setSystemDate (java.util.Date systemDate) {
		this.systemDate = systemDate;
	}



	/**
	 * Return the value associated with the column: system_time
	 */
	public java.lang.String getSystemTime () {
		return systemTime;
	}

	/**
	 * Set the value related to the column: system_time
	 * @param systemTime the system_time value
	 */
	public void setSystemTime (java.lang.String systemTime) {
		this.systemTime = systemTime;
	}



	/**
	 * Return the value associated with the column: mobile_no
	 */
	public java.lang.String getMobileNo () {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: mobile_no
	 * @param mobileNo the mobile_no value
	 */
	public void setMobileNo (java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}



	/**
	 * Return the value associated with the column: hours
	 */
	public java.lang.Integer getHours () {
		return hours;
	}

	/**
	 * Set the value related to the column: hours
	 * @param hours the hours value
	 */
	public void setHours (java.lang.Integer hours) {
		this.hours = hours;
	}



	/**
	 * Return the value associated with the column: minutes
	 */
	public java.lang.Integer getMinutes () {
		return minutes;
	}

	/**
	 * Set the value related to the column: minutes
	 * @param minutes the minutes value
	 */
	public void setMinutes (java.lang.Integer minutes) {
		this.minutes = minutes;
	}



	/**
	 * Return the value associated with the column: sent_date
	 */
	public java.util.Date getSentDate () {
		return sentDate;
	}

	/**
	 * Set the value related to the column: sent_date
	 * @param sentDate the sent_date value
	 */
	public void setSentDate (java.util.Date sentDate) {
		this.sentDate = sentDate;
	}



	/**
	 * Return the value associated with the column: sent_time
	 */
	public java.lang.String getSentTime () {
		return sentTime;
	}

	/**
	 * Set the value related to the column: sent_time
	 * @param sentTime the sent_time value
	 */
	public void setSentTime (java.lang.String sentTime) {
		this.sentTime = sentTime;
	}



	/**
	 * Return the value associated with the column: priority
	 */
	public java.lang.Integer getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.Integer priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: group_main_id
	 */
	public jkt.hms.masters.business.BulkMain getMain () {
		return main;
	}

	/**
	 * Set the value related to the column: group_main_id
	 * @param main the group_main_id value
	 */
	public void setMain (jkt.hms.masters.business.BulkMain main) {
		this.main = main;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public jkt.hms.masters.business.Users getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (jkt.hms.masters.business.Users user) {
		this.user = user;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BulkDetails)) return false;
		else {
			jkt.hms.masters.business.BulkDetails bulkDetails = (jkt.hms.masters.business.BulkDetails) obj;
			if (null == this.getId() || null == bulkDetails.getId()) return false;
			else return (this.getId().equals(bulkDetails.getId()));
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