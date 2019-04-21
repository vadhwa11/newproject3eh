package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bud_object_head table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bud_object_head"
 */

public abstract class BaseBudObjectHead  implements Serializable {

	public static String REF = "BudObjectHead";
	public static String PROP_MAJOR_SUB_HEAD_ID = "MajorSubHeadId";
	public static String PROP_MAJOR_HEAD_ID = "MajorHeadId";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_FUND_ALLOCATED_OFFICER = "FundAllocatedOfficer";
	public static String PROP_MINOR_HEAD_ID = "MinorHeadId";
	public static String PROP_STATUS = "Status";
	public static String PROP_OBJECT_HEAD_NAME = "ObjectHeadName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MINOR_SUB_HEAD_ID = "MinorSubHeadId";
	public static String PROP_ID = "Id";
	public static String PROP_OBJECT_HEAD_CODE = "ObjectHeadCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SEQUENCE_NO = "SequenceNo";
	public static String PROP_BUDGET_ID = "BudgetId";


	// constructors
	public BaseBudObjectHead () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudObjectHead (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String objectHeadCode;
	private java.lang.String objectHeadName;
	private java.lang.Integer sequenceNo;
	private java.lang.String fundAllocatedOfficer;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer hospitalId;
	private java.lang.Integer budgetId;

	// many to one
	private jkt.hms.masters.business.BudSubMajorHead majorSubHeadId;
	private jkt.hms.masters.business.BudMinorSubHead minorSubHeadId;
	private jkt.hms.masters.business.BudMajorHead majorHeadId;
	private jkt.hms.masters.business.BudMinorHead minorHeadId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Object_head_id"
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
	 * Return the value associated with the column: object_head_code
	 */
	public java.lang.String getObjectHeadCode () {
		return objectHeadCode;
	}

	/**
	 * Set the value related to the column: object_head_code
	 * @param objectHeadCode the object_head_code value
	 */
	public void setObjectHeadCode (java.lang.String objectHeadCode) {
		this.objectHeadCode = objectHeadCode;
	}



	/**
	 * Return the value associated with the column: object_head_name
	 */
	public java.lang.String getObjectHeadName () {
		return objectHeadName;
	}

	/**
	 * Set the value related to the column: object_head_name
	 * @param objectHeadName the object_head_name value
	 */
	public void setObjectHeadName (java.lang.String objectHeadName) {
		this.objectHeadName = objectHeadName;
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
	 * Return the value associated with the column: fund_allocated_officer
	 */
	public java.lang.String getFundAllocatedOfficer () {
		return fundAllocatedOfficer;
	}

	/**
	 * Set the value related to the column: fund_allocated_officer
	 * @param fundAllocatedOfficer the fund_allocated_officer value
	 */
	public void setFundAllocatedOfficer (java.lang.String fundAllocatedOfficer) {
		this.fundAllocatedOfficer = fundAllocatedOfficer;
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



	/**
	 * Return the value associated with the column: budget_id
	 */
	public java.lang.Integer getBudgetId () {
		return budgetId;
	}

	/**
	 * Set the value related to the column: budget_id
	 * @param budgetId the budget_id value
	 */
	public void setBudgetId (java.lang.Integer budgetId) {
		this.budgetId = budgetId;
	}



	/**
	 * Return the value associated with the column: sub_major_head_id
	 */
	public jkt.hms.masters.business.BudSubMajorHead getMajorSubHeadId () {
		return majorSubHeadId;
	}

	/**
	 * Set the value related to the column: sub_major_head_id
	 * @param majorSubHeadId the sub_major_head_id value
	 */
	public void setMajorSubHeadId (jkt.hms.masters.business.BudSubMajorHead majorSubHeadId) {
		this.majorSubHeadId = majorSubHeadId;
	}



	/**
	 * Return the value associated with the column: minor_sub_head_id
	 */
	public jkt.hms.masters.business.BudMinorSubHead getMinorSubHeadId () {
		return minorSubHeadId;
	}

	/**
	 * Set the value related to the column: minor_sub_head_id
	 * @param minorSubHeadId the minor_sub_head_id value
	 */
	public void setMinorSubHeadId (jkt.hms.masters.business.BudMinorSubHead minorSubHeadId) {
		this.minorSubHeadId = minorSubHeadId;
	}



	/**
	 * Return the value associated with the column: major_head_id
	 */
	public jkt.hms.masters.business.BudMajorHead getMajorHeadId () {
		return majorHeadId;
	}

	/**
	 * Set the value related to the column: major_head_id
	 * @param majorHeadId the major_head_id value
	 */
	public void setMajorHeadId (jkt.hms.masters.business.BudMajorHead majorHeadId) {
		this.majorHeadId = majorHeadId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudObjectHead)) return false;
		else {
			jkt.hms.masters.business.BudObjectHead budObjectHead = (jkt.hms.masters.business.BudObjectHead) obj;
			if (null == this.getId() || null == budObjectHead.getId()) return false;
			else return (this.getId().equals(budObjectHead.getId()));
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