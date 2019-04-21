package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bud_minor_sub_head table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bud_minor_sub_head"
 */

public abstract class BaseBudMinorSubHead  implements Serializable {

	public static String REF = "BudMinorSubHead";
	public static String PROP_MINOR_SUB_HEAD_CODE = "MinorSubHeadCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_MINOR_SUB_HEAD_NAME = "MinorSubHeadName";
	public static String PROP_ID = "Id";
	public static String PROP_MINOR_HEAD_ID = "MinorHeadId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SEQUENCE_NO = "SequenceNo";


	// constructors
	public BaseBudMinorSubHead () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudMinorSubHead (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String minorSubHeadCode;
	private java.lang.String minorSubHeadName;
	private java.lang.Integer sequenceNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.BudMinorHead minorHeadId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="minor_sub_head_id"
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
	 * Return the value associated with the column: minor_sub_head_code
	 */
	public java.lang.String getMinorSubHeadCode () {
		return minorSubHeadCode;
	}

	/**
	 * Set the value related to the column: minor_sub_head_code
	 * @param minorSubHeadCode the minor_sub_head_code value
	 */
	public void setMinorSubHeadCode (java.lang.String minorSubHeadCode) {
		this.minorSubHeadCode = minorSubHeadCode;
	}



	/**
	 * Return the value associated with the column: minor_sub_head_name
	 */
	public java.lang.String getMinorSubHeadName () {
		return minorSubHeadName;
	}

	/**
	 * Set the value related to the column: minor_sub_head_name
	 * @param minorSubHeadName the minor_sub_head_name value
	 */
	public void setMinorSubHeadName (java.lang.String minorSubHeadName) {
		this.minorSubHeadName = minorSubHeadName;
	}



	/**
	 * Return the value associated with the column: sequence_no
	 */
	public java.lang.Integer getSequenceNo () {
		return sequenceNo;
	}

	/**
	 * Set the value related to the column: sequence_no
	 * @param sequenceNo the sequence_no value
	 */
	public void setSequenceNo (java.lang.Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
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
	 * Return the value associated with the column: minor_head_id
	 */
	public jkt.hms.masters.business.BudMinorHead getMinorHeadId () {
		return minorHeadId;
	}

	/**
	 * Set the value related to the column: minor_head_id
	 * @param minorHeadId the minor_head_id value
	 */
	public void setMinorHeadId (jkt.hms.masters.business.BudMinorHead minorHeadId) {
		this.minorHeadId = minorHeadId;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudMinorSubHead)) return false;
		else {
			jkt.hms.masters.business.BudMinorSubHead budMinorSubHead = (jkt.hms.masters.business.BudMinorSubHead) obj;
			if (null == this.getId() || null == budMinorSubHead.getId()) return false;
			else return (this.getId().equals(budMinorSubHead.getId()));
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