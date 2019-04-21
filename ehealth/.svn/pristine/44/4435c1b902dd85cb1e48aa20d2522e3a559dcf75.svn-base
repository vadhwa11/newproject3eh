package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_discount_diagnosis table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_discount_diagnosis"
 */

public abstract class BaseMasDiscountDiagnosis  implements Serializable {

	public static String REF = "MasDiscountDiagnosis";
	public static String PROP_ICD = "Icd";
	public static String PROP_STATUS = "Status";
	public static String PROP_ID = "Id";
	public static String PROP_DISCOUNT = "Discount";


	// constructors
	public BaseMasDiscountDiagnosis () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDiscountDiagnosis (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDiscount discount;
	private jkt.hms.masters.business.MasIcd icd;



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
	 * Return the value associated with the column: discount_id
	 */
	public jkt.hms.masters.business.MasDiscount getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount_id
	 * @param discount the discount_id value
	 */
	public void setDiscount (jkt.hms.masters.business.MasDiscount discount) {
		this.discount = discount;
	}



	/**
	 * Return the value associated with the column: icd_id
	 */
	public jkt.hms.masters.business.MasIcd getIcd () {
		return icd;
	}

	/**
	 * Set the value related to the column: icd_id
	 * @param icd the icd_id value
	 */
	public void setIcd (jkt.hms.masters.business.MasIcd icd) {
		this.icd = icd;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDiscountDiagnosis)) return false;
		else {
			jkt.hms.masters.business.MasDiscountDiagnosis masDiscountDiagnosis = (jkt.hms.masters.business.MasDiscountDiagnosis) obj;
			if (null == this.getId() || null == masDiscountDiagnosis.getId()) return false;
			else return (this.getId().equals(masDiscountDiagnosis.getId()));
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