package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_mas_charge_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_mas_charge_details"
 */

public abstract class BaseOtMasChargeDetails  implements Serializable {

	public static String REF = "OtMasChargeDetails";
	public static String PROP_CHARGE_TYPE = "ChargeType";
	public static String PROP_OT = "Ot";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OT_CHARGE_TYPE = "OtChargeType";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_APPROX_DURATION = "ApproxDuration";


	// constructors
	public BaseOtMasChargeDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtMasChargeDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String otChargeType;
	private java.lang.String approxDuration;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasChargeType chargeType;
	private jkt.hms.masters.business.MasOt ot;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ot_charge_details_id"
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
	 * Return the value associated with the column: ot_charge_type
	 */
	public java.lang.String getOtChargeType () {
		return otChargeType;
	}

	/**
	 * Set the value related to the column: ot_charge_type
	 * @param otChargeType the ot_charge_type value
	 */
	public void setOtChargeType (java.lang.String otChargeType) {
		this.otChargeType = otChargeType;
	}



	/**
	 * Return the value associated with the column: approx_duration
	 */
	public java.lang.String getApproxDuration () {
		return approxDuration;
	}

	/**
	 * Set the value related to the column: approx_duration
	 * @param approxDuration the approx_duration value
	 */
	public void setApproxDuration (java.lang.String approxDuration) {
		this.approxDuration = approxDuration;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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
	 * Return the value associated with the column: charge_type_id
	 */
	public jkt.hms.masters.business.MasChargeType getChargeType () {
		return chargeType;
	}

	/**
	 * Set the value related to the column: charge_type_id
	 * @param chargeType the charge_type_id value
	 */
	public void setChargeType (jkt.hms.masters.business.MasChargeType chargeType) {
		this.chargeType = chargeType;
	}



	/**
	 * Return the value associated with the column: ot_id
	 */
	public jkt.hms.masters.business.MasOt getOt () {
		return ot;
	}

	/**
	 * Set the value related to the column: ot_id
	 * @param ot the ot_id value
	 */
	public void setOt (jkt.hms.masters.business.MasOt ot) {
		this.ot = ot;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtMasChargeDetails)) return false;
		else {
			jkt.hms.masters.business.OtMasChargeDetails otMasChargeDetails = (jkt.hms.masters.business.OtMasChargeDetails) obj;
			if (null == this.getId() || null == otMasChargeDetails.getId()) return false;
			else return (this.getId().equals(otMasChargeDetails.getId()));
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