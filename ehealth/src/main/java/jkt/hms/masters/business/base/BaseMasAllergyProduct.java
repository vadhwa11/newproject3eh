package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_allergy_product table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_allergy_product"
 */

public abstract class BaseMasAllergyProduct  implements Serializable {

	public static String REF = "MasAllergyProduct";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PRODUCT_CODE = "ProductCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_PRODUCT_NAME = "ProductName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasAllergyProduct () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAllergyProduct (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String productCode;
	private java.lang.String productName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> opdPatientAllergyTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="product_id"
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
	 * Return the value associated with the column: product_code
	 */
	public java.lang.String getProductCode () {
		return productCode;
	}

	/**
	 * Set the value related to the column: product_code
	 * @param productCode the product_code value
	 */
	public void setProductCode (java.lang.String productCode) {
		this.productCode = productCode;
	}



	/**
	 * Return the value associated with the column: product_name
	 */
	public java.lang.String getProductName () {
		return productName;
	}

	/**
	 * Set the value related to the column: product_name
	 * @param productName the product_name value
	 */
	public void setProductName (java.lang.String productName) {
		this.productName = productName;
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
	 * Return the value associated with the column: OpdPatientAllergyTs
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> getOpdPatientAllergyTs () {
		return opdPatientAllergyTs;
	}

	/**
	 * Set the value related to the column: OpdPatientAllergyTs
	 * @param opdPatientAllergyTs the OpdPatientAllergyTs value
	 */
	public void setOpdPatientAllergyTs (java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> opdPatientAllergyTs) {
		this.opdPatientAllergyTs = opdPatientAllergyTs;
	}

	public void addToOpdPatientAllergyTs (jkt.hms.masters.business.OpdPatientAllergyT opdPatientAllergyT) {
		if (null == getOpdPatientAllergyTs()) setOpdPatientAllergyTs(new java.util.TreeSet<jkt.hms.masters.business.OpdPatientAllergyT>());
		getOpdPatientAllergyTs().add(opdPatientAllergyT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAllergyProduct)) return false;
		else {
			jkt.hms.masters.business.MasAllergyProduct masAllergyProduct = (jkt.hms.masters.business.MasAllergyProduct) obj;
			if (null == this.getId() || null == masAllergyProduct.getId()) return false;
			else return (this.getId().equals(masAllergyProduct.getId()));
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