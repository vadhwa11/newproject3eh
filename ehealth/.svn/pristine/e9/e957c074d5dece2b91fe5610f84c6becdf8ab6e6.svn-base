package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_op_session table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_op_session"
 */

public abstract class BaseMasOpSession  implements Serializable {

	public static String REF = "MasOpSession";
	public static String PROP_STATUS = "Status";
	public static String PROP_SESSION_NAME = "SessionName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SESSION_CODE = "SessionCode";


	// constructors
	public BaseMasOpSession () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasOpSession (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasOpSession (
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
	private java.lang.String sessionCode;
	private java.lang.String sessionName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.Visit> visits;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="session_id"
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
	 * Return the value associated with the column: session_code
	 */
	public java.lang.String getSessionCode () {
		return sessionCode;
	}

	/**
	 * Set the value related to the column: session_code
	 * @param sessionCode the session_code value
	 */
	public void setSessionCode (java.lang.String sessionCode) {
		this.sessionCode = sessionCode;
	}



	/**
	 * Return the value associated with the column: session_name
	 */
	public java.lang.String getSessionName () {
		return sessionName;
	}

	/**
	 * Set the value related to the column: session_name
	 * @param sessionName the session_name value
	 */
	public void setSessionName (java.lang.String sessionName) {
		this.sessionName = sessionName;
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



	/**
	 * Return the value associated with the column: Visits
	 */
	public java.util.Set<jkt.hms.masters.business.Visit> getVisits () {
		return visits;
	}

	/**
	 * Set the value related to the column: Visits
	 * @param visits the Visits value
	 */
	public void setVisits (java.util.Set<jkt.hms.masters.business.Visit> visits) {
		this.visits = visits;
	}

	public void addToVisits (jkt.hms.masters.business.Visit visit) {
		if (null == getVisits()) setVisits(new java.util.TreeSet<jkt.hms.masters.business.Visit>());
		getVisits().add(visit);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasOpSession)) return false;
		else {
			jkt.hms.masters.business.MasOpSession masOpSession = (jkt.hms.masters.business.MasOpSession) obj;
			if (null == this.getId() || null == masOpSession.getId()) return false;
			else return (this.getId().equals(masOpSession.getId()));
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