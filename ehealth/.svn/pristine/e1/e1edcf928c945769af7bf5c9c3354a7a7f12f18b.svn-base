package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_charge_code_rates table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_charge_code_rates"
 */

public abstract class BaseMasChargeCodeRates  implements Serializable {

	public static String REF = "MasChargeCodeRates";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_EFFECTIVE_TO_DATE = "EffectiveToDate";
	public static String PROP_EFFECTIVE_FROM_DATE = "EffectiveFromDate";
	public static String PROP_RATE = "Rate";


	// constructors
	public BaseMasChargeCodeRates () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasChargeCodeRates (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal rate;
	private java.util.Date effectiveFromDate;
	private java.util.Date effectiveToDate;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="mas_charge_code_rates_id"
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
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param rate the rate value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: effective_from_date
	 */
	public java.util.Date getEffectiveFromDate () {
		return effectiveFromDate;
	}

	/**
	 * Set the value related to the column: effective_from_date
	 * @param effectiveFromDate the effective_from_date value
	 */
	public void setEffectiveFromDate (java.util.Date effectiveFromDate) {
		this.effectiveFromDate = effectiveFromDate;
	}



	/**
	 * Return the value associated with the column: effective_to_date
	 */
	public java.util.Date getEffectiveToDate () {
		return effectiveToDate;
	}

	/**
	 * Set the value related to the column: effective_to_date
	 * @param effectiveToDate the effective_to_date value
	 */
	public void setEffectiveToDate (java.util.Date effectiveToDate) {
		this.effectiveToDate = effectiveToDate;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasChargeCodeRates)) return false;
		else {
			jkt.hms.masters.business.MasChargeCodeRates masChargeCodeRates = (jkt.hms.masters.business.MasChargeCodeRates) obj;
			if (null == this.getId() || null == masChargeCodeRates.getId()) return false;
			else return (this.getId().equals(masChargeCodeRates.getId()));
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