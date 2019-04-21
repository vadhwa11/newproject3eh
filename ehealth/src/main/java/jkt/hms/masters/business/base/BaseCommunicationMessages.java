package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the communication_messages table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="communication_messages"
 */

public abstract class BaseCommunicationMessages  implements Serializable {

	public static String REF = "CommunicationMessages";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TO_EMPLOYEE = "ToEmployee";
	public static String PROP_FROM_EMPLOYEE = "FromEmployee";
	public static String PROP_MESSAGE_DATE = "MessageDate";
	public static String PROP_MESSAGE_TEXT = "MessageText";


	// constructors
	public BaseCommunicationMessages () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCommunicationMessages (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String messageText;
	private java.lang.String status;
	private java.util.Date messageDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee toEmployee;
	private jkt.hms.masters.business.MasEmployee fromEmployee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="message_id"
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
	 * Return the value associated with the column: message_text
	 */
	public java.lang.String getMessageText () {
		return messageText;
	}

	/**
	 * Set the value related to the column: message_text
	 * @param messageText the message_text value
	 */
	public void setMessageText (java.lang.String messageText) {
		this.messageText = messageText;
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
	 * Return the value associated with the column: message_date
	 */
	public java.util.Date getMessageDate () {
		return messageDate;
	}

	/**
	 * Set the value related to the column: message_date
	 * @param messageDate the message_date value
	 */
	public void setMessageDate (java.util.Date messageDate) {
		this.messageDate = messageDate;
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



	/**
	 * Return the value associated with the column: message_to_empid
	 */
	public jkt.hms.masters.business.MasEmployee getToEmployee () {
		return toEmployee;
	}

	/**
	 * Set the value related to the column: message_to_empid
	 * @param toEmployee the message_to_empid value
	 */
	public void setToEmployee (jkt.hms.masters.business.MasEmployee toEmployee) {
		this.toEmployee = toEmployee;
	}



	/**
	 * Return the value associated with the column: message_from_empid
	 */
	public jkt.hms.masters.business.MasEmployee getFromEmployee () {
		return fromEmployee;
	}

	/**
	 * Set the value related to the column: message_from_empid
	 * @param fromEmployee the message_from_empid value
	 */
	public void setFromEmployee (jkt.hms.masters.business.MasEmployee fromEmployee) {
		this.fromEmployee = fromEmployee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CommunicationMessages)) return false;
		else {
			jkt.hms.masters.business.CommunicationMessages communicationMessages = (jkt.hms.masters.business.CommunicationMessages) obj;
			if (null == this.getId() || null == communicationMessages.getId()) return false;
			else return (this.getId().equals(communicationMessages.getId()));
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