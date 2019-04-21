package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hospital_refer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hospital_refer"
 */

public abstract class BaseHospitalRefer  implements Serializable {

	public static String REF = "HospitalRefer";
	public static String PROP_STATUS = "Status";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_UNIQUE_ID = "UniqueId";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REFER_FROM = "ReferFrom";
	public static String PROP_REF_DATE = "RefDate";
	public static String PROP_ID = "Id";
	public static String PROP_REF_TIME = "RefTime";
	public static String PROP_REF_HOSPITAL = "RefHospital";
	public static String PROP_REF_REASON = "RefReason";


	// constructors
	public BaseHospitalRefer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHospitalRefer (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date refDate;
	private java.lang.String refReason;
	private java.lang.Integer memberId;
	private java.lang.String uniqueId;
	private java.lang.String refTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital refHospital;
	private jkt.hms.masters.business.MasHospital referFrom;



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
	 * Return the value associated with the column: ref_date
	 */
	public java.util.Date getRefDate () {
		return refDate;
	}

	/**
	 * Set the value related to the column: ref_date
	 * @param refDate the ref_date value
	 */
	public void setRefDate (java.util.Date refDate) {
		this.refDate = refDate;
	}



	/**
	 * Return the value associated with the column: ref_reason
	 */
	public java.lang.String getRefReason () {
		return refReason;
	}

	/**
	 * Set the value related to the column: ref_reason
	 * @param refReason the ref_reason value
	 */
	public void setRefReason (java.lang.String refReason) {
		this.refReason = refReason;
	}



	/**
	 * Return the value associated with the column: member_id
	 */
	public java.lang.Integer getMemberId () {
		return memberId;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param memberId the member_id value
	 */
	public void setMemberId (java.lang.Integer memberId) {
		this.memberId = memberId;
	}



	/**
	 * Return the value associated with the column: unique_id
	 */
	public java.lang.String getUniqueId () {
		return uniqueId;
	}

	/**
	 * Set the value related to the column: unique_id
	 * @param uniqueId the unique_id value
	 */
	public void setUniqueId (java.lang.String uniqueId) {
		this.uniqueId = uniqueId;
	}



	/**
	 * Return the value associated with the column: ref_time
	 */
	public java.lang.String getRefTime () {
		return refTime;
	}

	/**
	 * Set the value related to the column: ref_time
	 * @param refTime the ref_time value
	 */
	public void setRefTime (java.lang.String refTime) {
		this.refTime = refTime;
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
	 * Return the value associated with the column: ref_hospital
	 */
	public jkt.hms.masters.business.MasHospital getRefHospital () {
		return refHospital;
	}

	/**
	 * Set the value related to the column: ref_hospital
	 * @param refHospital the ref_hospital value
	 */
	public void setRefHospital (jkt.hms.masters.business.MasHospital refHospital) {
		this.refHospital = refHospital;
	}



	/**
	 * Return the value associated with the column: refer_from
	 */
	public jkt.hms.masters.business.MasHospital getReferFrom () {
		return referFrom;
	}

	/**
	 * Set the value related to the column: refer_from
	 * @param referFrom the refer_from value
	 */
	public void setReferFrom (jkt.hms.masters.business.MasHospital referFrom) {
		this.referFrom = referFrom;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HospitalRefer)) return false;
		else {
			jkt.hms.masters.business.HospitalRefer hospitalRefer = (jkt.hms.masters.business.HospitalRefer) obj;
			if (null == this.getId() || null == hospitalRefer.getId()) return false;
			else return (this.getId().equals(hospitalRefer.getId()));
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