package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the one_to_one table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="one_to_one"
 */

public abstract class BaseOneToOne  implements Serializable {

	public static String REF = "OneToOne";
	public static String PROP_SENT_DATE = "SentDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_MESSAGE = "Message";
	public static String PROP_TYPE = "Type";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SENT_TIME = "SentTime";
	public static String PROP_ID = "Id";
	public static String PROP_MOBILE_NO = "MobileNo";


	// constructors
	public BaseOneToOne () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOneToOne (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOneToOne (
		java.lang.Integer id,
		java.lang.String mobileNo,
		java.lang.String message,
		java.lang.String status,
		java.lang.String type,
		java.lang.String sentTime,
		java.util.Date sentDate) {

		this.setId(id);
		this.setMobileNo(mobileNo);
		this.setMessage(message);
		this.setStatus(status);
		this.setType(type);
		this.setSentTime(sentTime);
		this.setSentDate(sentDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mobileNo;
	private java.lang.String message;
	private java.lang.String status;
	private java.lang.String type;
	private java.lang.String sentTime;
	private java.util.Date sentDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



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
	 * Return the value associated with the column: mobileNo
	 */
	public java.lang.String getMobileNo () {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: mobileNo
	 * @param mobileNo the mobileNo value
	 */
	public void setMobileNo (java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}



	/**
	 * Return the value associated with the column: message
	 */
	public java.lang.String getMessage () {
		return message;
	}

	/**
	 * Set the value related to the column: message
	 * @param message the message value
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
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OneToOne)) return false;
		else {
			jkt.hms.masters.business.OneToOne oneToOne = (jkt.hms.masters.business.OneToOne) obj;
			if (null == this.getId() || null == oneToOne.getId()) return false;
			else return (this.getId().equals(oneToOne.getId()));
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