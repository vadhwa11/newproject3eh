package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_kit_issue_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_kit_issue_details"
 */

public abstract class BaseIpdKitIssueDetails  implements Serializable {

	public static String REF = "IpdKitIssueDetails";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ITEM = "Item";
	public static String PROP_HEADER = "Header";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_ID = "Id";


	// constructors
	public BaseIpdKitIssueDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdKitIssueDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String itemName;
	private java.lang.Integer quantity;

	// many to one
	private jkt.hms.masters.business.IpdKitIssueHeader header;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="details_id"
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
	 * Return the value associated with the column: item_name
	 */
	public java.lang.String getItemName () {
		return itemName;
	}

	/**
	 * Set the value related to the column: item_name
	 * @param itemName the item_name value
	 */
	public void setItemName (java.lang.String itemName) {
		this.itemName = itemName;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: header_id
	 */
	public jkt.hms.masters.business.IpdKitIssueHeader getHeader () {
		return header;
	}

	/**
	 * Set the value related to the column: header_id
	 * @param header the header_id value
	 */
	public void setHeader (jkt.hms.masters.business.IpdKitIssueHeader header) {
		this.header = header;
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
		if (!(obj instanceof jkt.hms.masters.business.IpdKitIssueDetails)) return false;
		else {
			jkt.hms.masters.business.IpdKitIssueDetails ipdKitIssueDetails = (jkt.hms.masters.business.IpdKitIssueDetails) obj;
			if (null == this.getId() || null == ipdKitIssueDetails.getId()) return false;
			else return (this.getId().equals(ipdKitIssueDetails.getId()));
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