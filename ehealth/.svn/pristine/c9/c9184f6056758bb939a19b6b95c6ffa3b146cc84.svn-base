package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bud_major_head table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bud_major_head"
 */

public abstract class BaseBudMajorHead  implements Serializable {

	public static String REF = "BudMajorHead";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_MAJOR_HEAD_CODE = "MajorHeadCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_LAST_CHGE_BY = "LastChgeBy";
	public static String PROP_SEQUENCE_NO = "SequenceNo";
	public static String PROP_MAJOR_HEAD_NAME = "MajorHeadName";


	// constructors
	public BaseBudMajorHead () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudMajorHead (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String majorHeadCode;
	private java.lang.String majorHeadName;
	private java.lang.Integer sequenceNo;
	private java.lang.String lastChgeBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String financialYear;
	private java.lang.Integer hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="major_head_id"
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
	 * Return the value associated with the column: major_head_code
	 */
	public java.lang.String getMajorHeadCode () {
		return majorHeadCode;
	}

	/**
	 * Set the value related to the column: major_head_code
	 * @param majorHeadCode the major_head_code value
	 */
	public void setMajorHeadCode (java.lang.String majorHeadCode) {
		this.majorHeadCode = majorHeadCode;
	}



	/**
	 * Return the value associated with the column: major_head_name
	 */
	public java.lang.String getMajorHeadName () {
		return majorHeadName;
	}

	/**
	 * Set the value related to the column: major_head_name
	 * @param majorHeadName the major_head_name value
	 */
	public void setMajorHeadName (java.lang.String majorHeadName) {
		this.majorHeadName = majorHeadName;
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
	 * Return the value associated with the column: last_chge_by
	 */
	public java.lang.String getLastChgeBy () {
		return lastChgeBy;
	}

	/**
	 * Set the value related to the column: last_chge_by
	 * @param lastChgeBy the last_chge_by value
	 */
	public void setLastChgeBy (java.lang.String lastChgeBy) {
		this.lastChgeBy = lastChgeBy;
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
	 * Return the value associated with the column: financial_year
	 */
	public java.lang.String getFinancialYear () {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year
	 * @param financialYear the financial_year value
	 */
	public void setFinancialYear (java.lang.String financialYear) {
		this.financialYear = financialYear;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudMajorHead)) return false;
		else {
			jkt.hms.masters.business.BudMajorHead budMajorHead = (jkt.hms.masters.business.BudMajorHead) obj;
			if (null == this.getId() || null == budMajorHead.getId()) return false;
			else return (this.getId().equals(budMajorHead.getId()));
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