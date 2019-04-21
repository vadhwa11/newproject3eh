package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_indent_issue_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_indent_issue_m"
 */

public abstract class BaseBloodIndentIssueM  implements Serializable {

	public static String REF = "BloodIndentIssueM";
	public static String PROP_ACK_STATUS = "AckStatus";
	public static String PROP_REQUEST_HEADER = "RequestHeader";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INDENT_ISSUE_DATE = "IndentIssueDate";


	// constructors
	public BaseBloodIndentIssueM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodIndentIssueM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date indentIssueDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String ackStatus;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.BloodRequestEntryHeader requestHeader;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodIndentIssueT> bloodIndentIssueTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="indent_m_id"
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
	 * Return the value associated with the column: indent_issue_date
	 */
	public java.util.Date getIndentIssueDate () {
		return indentIssueDate;
	}

	/**
	 * Set the value related to the column: indent_issue_date
	 * @param indentIssueDate the indent_issue_date value
	 */
	public void setIndentIssueDate (java.util.Date indentIssueDate) {
		this.indentIssueDate = indentIssueDate;
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
	 * Return the value associated with the column: ack_status
	 */
	public java.lang.String getAckStatus () {
		return ackStatus;
	}

	/**
	 * Set the value related to the column: ack_status
	 * @param ackStatus the ack_status value
	 */
	public void setAckStatus (java.lang.String ackStatus) {
		this.ackStatus = ackStatus;
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



	/**
	 * Return the value associated with the column: request_header_id
	 */
	public jkt.hms.masters.business.BloodRequestEntryHeader getRequestHeader () {
		return requestHeader;
	}

	/**
	 * Set the value related to the column: request_header_id
	 * @param requestHeader the request_header_id value
	 */
	public void setRequestHeader (jkt.hms.masters.business.BloodRequestEntryHeader requestHeader) {
		this.requestHeader = requestHeader;
	}



	/**
	 * Return the value associated with the column: BloodIndentIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.BloodIndentIssueT> getBloodIndentIssueTs () {
		return bloodIndentIssueTs;
	}

	/**
	 * Set the value related to the column: BloodIndentIssueTs
	 * @param bloodIndentIssueTs the BloodIndentIssueTs value
	 */
	public void setBloodIndentIssueTs (java.util.Set<jkt.hms.masters.business.BloodIndentIssueT> bloodIndentIssueTs) {
		this.bloodIndentIssueTs = bloodIndentIssueTs;
	}

	public void addToBloodIndentIssueTs (jkt.hms.masters.business.BloodIndentIssueT bloodIndentIssueT) {
		if (null == getBloodIndentIssueTs()) setBloodIndentIssueTs(new java.util.TreeSet<jkt.hms.masters.business.BloodIndentIssueT>());
		getBloodIndentIssueTs().add(bloodIndentIssueT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodIndentIssueM)) return false;
		else {
			jkt.hms.masters.business.BloodIndentIssueM bloodIndentIssueM = (jkt.hms.masters.business.BloodIndentIssueM) obj;
			if (null == this.getId() || null == bloodIndentIssueM.getId()) return false;
			else return (this.getId().equals(bloodIndentIssueM.getId()));
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