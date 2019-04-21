package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_scheme_sanction_amount table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_scheme_sanction_amount"
 */

public abstract class BaseFaSchemeSanctionAmount  implements Serializable {

	public static String REF = "FaSchemeSanctionAmount";
	public static String PROP_SCHEME = "Scheme";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_AMOUNT = "TotalAmount";
	public static String PROP_F_YEAR = "FYear";


	// constructors
	public BaseFaSchemeSanctionAmount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaSchemeSanctionAmount (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal totalAmount;

	// many to one
	private jkt.hms.masters.business.MasStoreFinancial fYear;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasScheme scheme;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="scheme_wise_amount_id"
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
	 * Return the value associated with the column: total_amount
	 */
	public java.math.BigDecimal getTotalAmount () {
		return totalAmount;
	}

	/**
	 * Set the value related to the column: total_amount
	 * @param totalAmount the total_amount value
	 */
	public void setTotalAmount (java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}



	/**
	 * Return the value associated with the column: f_year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFYear () {
		return fYear;
	}

	/**
	 * Set the value related to the column: f_year_id
	 * @param fYear the f_year_id value
	 */
	public void setFYear (jkt.hms.masters.business.MasStoreFinancial fYear) {
		this.fYear = fYear;
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
	 * Return the value associated with the column: scheme_id
	 */
	public jkt.hms.masters.business.MasScheme getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme_id
	 * @param scheme the scheme_id value
	 */
	public void setScheme (jkt.hms.masters.business.MasScheme scheme) {
		this.scheme = scheme;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaSchemeSanctionAmount)) return false;
		else {
			jkt.hms.masters.business.FaSchemeSanctionAmount faSchemeSanctionAmount = (jkt.hms.masters.business.FaSchemeSanctionAmount) obj;
			if (null == this.getId() || null == faSchemeSanctionAmount.getId()) return false;
			else return (this.getId().equals(faSchemeSanctionAmount.getId()));
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