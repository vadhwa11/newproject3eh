package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_probable_pregnancy table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_probable_pregnancy"
 */

public abstract class BasePhProbablePregnancy  implements Serializable {

	public static String REF = "PhProbablePregnancy";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_AADHAAR_NO = "AadhaarNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ANC_SUSPECTED_STATUS = "AncSuspectedStatus";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_URINE_TEST = "UrineTest";
	public static String PROP_NAME_WOMAN = "NameWoman";
	public static String PROP_ULTRASOUND = "Ultrasound";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BasePhProbablePregnancy () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhProbablePregnancy (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long memberId;
	private java.lang.String nameWoman;
	private java.lang.String aadhaarNo;
	private java.lang.String ultrasound;
	private java.lang.String urineTest;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String ancSuspectedStatus;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="survey_id"
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
	 * Return the value associated with the column: member_id
	 */
	public java.lang.Long getMemberId () {
		return memberId;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param memberId the member_id value
	 */
	public void setMemberId (java.lang.Long memberId) {
		this.memberId = memberId;
	}



	/**
	 * Return the value associated with the column: name_woman
	 */
	public java.lang.String getNameWoman () {
		return nameWoman;
	}

	/**
	 * Set the value related to the column: name_woman
	 * @param nameWoman the name_woman value
	 */
	public void setNameWoman (java.lang.String nameWoman) {
		this.nameWoman = nameWoman;
	}



	/**
	 * Return the value associated with the column: aadhaar_no
	 */
	public java.lang.String getAadhaarNo () {
		return aadhaarNo;
	}

	/**
	 * Set the value related to the column: aadhaar_no
	 * @param aadhaarNo the aadhaar_no value
	 */
	public void setAadhaarNo (java.lang.String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}



	/**
	 * Return the value associated with the column: ultrasound
	 */
	public java.lang.String getUltrasound () {
		return ultrasound;
	}

	/**
	 * Set the value related to the column: ultrasound
	 * @param ultrasound the ultrasound value
	 */
	public void setUltrasound (java.lang.String ultrasound) {
		this.ultrasound = ultrasound;
	}



	/**
	 * Return the value associated with the column: urine_test
	 */
	public java.lang.String getUrineTest () {
		return urineTest;
	}

	/**
	 * Set the value related to the column: urine_test
	 * @param urineTest the urine_test value
	 */
	public void setUrineTest (java.lang.String urineTest) {
		this.urineTest = urineTest;
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
	 * Return the value associated with the column: anc_suspected_status
	 */
	public java.lang.String getAncSuspectedStatus () {
		return ancSuspectedStatus;
	}

	/**
	 * Set the value related to the column: anc_suspected_status
	 * @param ancSuspectedStatus the anc_suspected_status value
	 */
	public void setAncSuspectedStatus (java.lang.String ancSuspectedStatus) {
		this.ancSuspectedStatus = ancSuspectedStatus;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhProbablePregnancy)) return false;
		else {
			jkt.hms.masters.business.PhProbablePregnancy phProbablePregnancy = (jkt.hms.masters.business.PhProbablePregnancy) obj;
			if (null == this.getId() || null == phProbablePregnancy.getId()) return false;
			else return (this.getId().equals(phProbablePregnancy.getId()));
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