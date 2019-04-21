package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bud_sub_major_head table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bud_sub_major_head"
 */

public abstract class BaseBudSubMajorHead  implements Serializable {

	public static String REF = "BudSubMajorHead";
	public static String PROP_STATUS = "Status";
	public static String PROP_SUB_MAJOR_HEAD_NAME = "SubMajorHeadName";
	public static String PROP_MAJOR_HEAD_ID = "MajorHeadId";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SUB_MAJOR_HEAD_CODE = "SubMajorHeadCode";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SEQUENCE_NO = "SequenceNo";


	// constructors
	public BaseBudSubMajorHead () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudSubMajorHead (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subMajorHeadCode;
	private java.lang.String subMajorHeadName;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer sequenceNo;
	private java.lang.Integer hospitalId;

	// many to one
	private jkt.hms.masters.business.BudMajorHead majorHeadId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="sub_major_head_id"
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
	 * Return the value associated with the column: sub_major_head_code
	 */
	public java.lang.String getSubMajorHeadCode () {
		return subMajorHeadCode;
	}

	/**
	 * Set the value related to the column: sub_major_head_code
	 * @param subMajorHeadCode the sub_major_head_code value
	 */
	public void setSubMajorHeadCode (java.lang.String subMajorHeadCode) {
		this.subMajorHeadCode = subMajorHeadCode;
	}



	/**
	 * Return the value associated with the column: sub_major_head_name
	 */
	public java.lang.String getSubMajorHeadName () {
		return subMajorHeadName;
	}

	/**
	 * Set the value related to the column: sub_major_head_name
	 * @param subMajorHeadName the sub_major_head_name value
	 */
	public void setSubMajorHeadName (java.lang.String subMajorHeadName) {
		this.subMajorHeadName = subMajorHeadName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudSubMajorHead)) return false;
		else {
			jkt.hms.masters.business.BudSubMajorHead budSubMajorHead = (jkt.hms.masters.business.BudSubMajorHead) obj;
			if (null == this.getId() || null == budSubMajorHead.getId()) return false;
			else return (this.getId().equals(budSubMajorHead.getId()));
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