package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_discount_exclude table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_discount_exclude"
 */

public abstract class BaseMasDiscountExclude  implements Serializable {

	public static String REF = "MasDiscountExclude";
	public static String PROP_STATUS = "Status";
	public static String PROP_ITEM = "Item";
	public static String PROP_ID = "Id";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_CHARGE = "Charge";


	// constructors
	public BaseMasDiscountExclude () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDiscountExclude (java.lang.Integer id) {
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
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasChargeCode charge;
	private jkt.hms.masters.business.MasDiscount discount;



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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: charge_id
	 */
	public jkt.hms.masters.business.MasChargeCode getCharge () {
		return charge;
	}

	/**
	 * Set the value related to the column: charge_id
	 * @param charge the charge_id value
	 */
	public void setCharge (jkt.hms.masters.business.MasChargeCode charge) {
		this.charge = charge;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDiscountExclude)) return false;
		else {
			jkt.hms.masters.business.MasDiscountExclude masDiscountExclude = (jkt.hms.masters.business.MasDiscountExclude) obj;
			if (null == this.getId() || null == masDiscountExclude.getId()) return false;
			else return (this.getId().equals(masDiscountExclude.getId()));
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