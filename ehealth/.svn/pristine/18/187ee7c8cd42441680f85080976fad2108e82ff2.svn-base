package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_sign_out_item_consume table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_sign_out_item_consume"
 */

public abstract class BaseOtSignOutItemConsume  implements Serializable {

	public static String REF = "OtSignOutItemConsume";
	public static String PROP_OT_SIGN_OUT = "OtSignOut";
	public static String PROP_ITEM = "Item";
	public static String PROP_ID = "Id";
	public static String PROP_QTY_USED = "QtyUsed";


	// constructors
	public BaseOtSignOutItemConsume () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtSignOutItemConsume (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String qtyUsed;

	// many to one
	private jkt.hms.masters.business.OtSignOut otSignOut;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ot_sign_out_consump_item_id"
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
	 * Return the value associated with the column: qty_used
	 */
	public java.lang.String getQtyUsed () {
		return qtyUsed;
	}

	/**
	 * Set the value related to the column: qty_used
	 * @param qtyUsed the qty_used value
	 */
	public void setQtyUsed (java.lang.String qtyUsed) {
		this.qtyUsed = qtyUsed;
	}



	/**
	 * Return the value associated with the column: ot_sign_out_id
	 */
	public jkt.hms.masters.business.OtSignOut getOtSignOut () {
		return otSignOut;
	}

	/**
	 * Set the value related to the column: ot_sign_out_id
	 * @param otSignOut the ot_sign_out_id value
	 */
	public void setOtSignOut (jkt.hms.masters.business.OtSignOut otSignOut) {
		this.otSignOut = otSignOut;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtSignOutItemConsume)) return false;
		else {
			jkt.hms.masters.business.OtSignOutItemConsume otSignOutItemConsume = (jkt.hms.masters.business.OtSignOutItemConsume) obj;
			if (null == this.getId() || null == otSignOutItemConsume.getId()) return false;
			else return (this.getId().equals(otSignOutItemConsume.getId()));
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