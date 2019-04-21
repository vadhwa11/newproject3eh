package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the smsout table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="smsout"
 */

public abstract class BaseSmsout  implements Serializable {

	public static String REF = "Smsout";
	public static String PROP_SENT_DATE = "SentDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_MESSAGE = "Message";
	public static String PROP_SENT_TIME = "SentTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_MOBILE_NO = "MobileNo";


	// constructors
	public BaseSmsout () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSmsout (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSmsout (
		java.lang.Integer id,
		java.lang.String message,
		java.lang.String status,
		java.lang.String sentTime,
		java.util.Date sentDate,
		java.lang.String mobileNo) {

		this.setId(id);
		this.setMessage(message);
		this.setStatus(status);
		this.setSentTime(sentTime);
		this.setSentDate(sentDate);
		this.setMobileNo(mobileNo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String message;
	private java.lang.String status;
	private java.lang.String sentTime;
	private java.util.Date sentDate;
	private java.lang.String mobileNo;
	private java.lang.String remarks;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ID"
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
	 * Return the value associated with the column: MESSAGE
	 */
	public java.lang.String getMessage () {
		return message;
	}

	/**
	 * Set the value related to the column: MESSAGE
	 * @param message the MESSAGE value
	 */
	public void setMessage (java.lang.String message) {
		this.message = message;
	}



	/**
	 * Return the value associated with the column: Status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: Status
	 * @param status the Status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: SENT_DATE
	 */
	public java.util.Date getSentDate () {
		return sentDate;
	}

	/**
	 * Set the value related to the column: SENT_DATE
	 * @param sentDate the SENT_DATE value
	 */
	public void setSentDate (java.util.Date sentDate) {
		this.sentDate = sentDate;
	}



	/**
	 * Return the value associated with the column: MOBILE_NO
	 */
	public java.lang.String getMobileNo () {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: MOBILE_NO
	 * @param mobileNo the MOBILE_NO value
	 */
	public void setMobileNo (java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Smsout)) return false;
		else {
			jkt.hms.masters.business.Smsout smsout = (jkt.hms.masters.business.Smsout) obj;
			if (null == this.getId() || null == smsout.getId()) return false;
			else return (this.getId().equals(smsout.getId()));
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