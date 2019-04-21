package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the immunization_card_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="immunization_card_detail"
 */

public abstract class BaseImmunizationCardDetail  implements Serializable {

	public static String REF = "ImmunizationCardDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_IM_ID = "ImId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VISIT_ID = "VisitId";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_GIVENDATE = "Givendate";
	public static String PROP_ICM_ID = "IcmId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseImmunizationCardDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseImmunizationCardDetail (java.lang.Integer imId) {
		this.setImId(imId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer imId;

	// fields
	private java.util.Date givendate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer serialNo;

	// many to one
	private jkt.hms.masters.business.ImmunizationCardMaster icmId;
	private jkt.hms.masters.business.Visit visitId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="im_id"
     */
	public java.lang.Integer getImId () {
		return imId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param imId the new ID
	 */
	public void setImId (java.lang.Integer imId) {
		this.imId = imId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: givendate
	 */
	public java.util.Date getGivendate () {
		return givendate;
	}

	/**
	 * Set the value related to the column: givendate
	 * @param givendate the givendate value
	 */
	public void setGivendate (java.util.Date givendate) {
		this.givendate = givendate;
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.Integer getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: icm_id
	 */
	public jkt.hms.masters.business.ImmunizationCardMaster getIcmId () {
		return icmId;
	}

	/**
	 * Set the value related to the column: icm_id
	 * @param icmId the icm_id value
	 */
	public void setIcmId (jkt.hms.masters.business.ImmunizationCardMaster icmId) {
		this.icmId = icmId;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisitId () {
		return visitId;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visitId the visit_id value
	 */
	public void setVisitId (jkt.hms.masters.business.Visit visitId) {
		this.visitId = visitId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ImmunizationCardDetail)) return false;
		else {
			jkt.hms.masters.business.ImmunizationCardDetail immunizationCardDetail = (jkt.hms.masters.business.ImmunizationCardDetail) obj;
			if (null == this.getImId() || null == immunizationCardDetail.getImId()) return false;
			else return (this.getImId().equals(immunizationCardDetail.getImId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getImId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getImId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}