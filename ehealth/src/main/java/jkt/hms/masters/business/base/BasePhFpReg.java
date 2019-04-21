package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_fp_reg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_fp_reg"
 */

public abstract class BasePhFpReg  implements Serializable {

	public static String REF = "PhFpReg";
	public static String PROP_HUSBAND_ID = "HusbandId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_REG_ID = "RegId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_ELI_REG_ID = "EliRegId";
	public static String PROP_WIFE_ID = "WifeId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePhFpReg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhFpReg (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date regDate;
	private java.lang.String husbandId;
	private java.lang.String wifeId;
	private java.lang.String regId;
	private java.lang.String eliRegId;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="fp_reg_id"
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
	 * Return the value associated with the column: reg_date
	 */
	public java.util.Date getRegDate () {
		return regDate;
	}

	/**
	 * Set the value related to the column: reg_date
	 * @param regDate the reg_date value
	 */
	public void setRegDate (java.util.Date regDate) {
		this.regDate = regDate;
	}



	/**
	 * Return the value associated with the column: husband_id
	 */
	public java.lang.String getHusbandId () {
		return husbandId;
	}

	/**
	 * Set the value related to the column: husband_id
	 * @param husbandId the husband_id value
	 */
	public void setHusbandId (java.lang.String husbandId) {
		this.husbandId = husbandId;
	}



	/**
	 * Return the value associated with the column: wife_id
	 */
	public java.lang.String getWifeId () {
		return wifeId;
	}

	/**
	 * Set the value related to the column: wife_id
	 * @param wifeId the wife_id value
	 */
	public void setWifeId (java.lang.String wifeId) {
		this.wifeId = wifeId;
	}



	/**
	 * Return the value associated with the column: reg_id
	 */
	public java.lang.String getRegId () {
		return regId;
	}

	/**
	 * Set the value related to the column: reg_id
	 * @param regId the reg_id value
	 */
	public void setRegId (java.lang.String regId) {
		this.regId = regId;
	}



	/**
	 * Return the value associated with the column: eli_reg_id
	 */
	public java.lang.String getEliRegId () {
		return eliRegId;
	}

	/**
	 * Set the value related to the column: eli_reg_id
	 * @param eliRegId the eli_reg_id value
	 */
	public void setEliRegId (java.lang.String eliRegId) {
		this.eliRegId = eliRegId;
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
		if (!(obj instanceof jkt.hms.masters.business.PhFpReg)) return false;
		else {
			jkt.hms.masters.business.PhFpReg phFpReg = (jkt.hms.masters.business.PhFpReg) obj;
			if (null == this.getId() || null == phFpReg.getId()) return false;
			else return (this.getId().equals(phFpReg.getId()));
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