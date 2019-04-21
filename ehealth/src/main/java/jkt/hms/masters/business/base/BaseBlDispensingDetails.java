package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_dispensing_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_dispensing_details"
 */

public abstract class BaseBlDispensingDetails  implements Serializable {

	public static String REF = "BlDispensingDetails";
	public static String PROP_REFUNDABLE_STATUS = "RefundableStatus";
	public static String PROP_PROPORTIONAL_DIS_AMT = "ProportionalDisAmt";
	public static String PROP_QTY = "Qty";
	public static String PROP_BATCH = "Batch";
	public static String PROP_ISSUED = "Issued";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_ITEM = "Item";
	public static String PROP_SALES_TAX_AMT = "SalesTaxAmt";
	public static String PROP_REFUNDED_AMT = "RefundedAmt";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_ID = "Id";
	public static String PROP_DISPENSING_HEADER = "DispensingHeader";
	public static String PROP_NET_AMT = "NetAmt";


	// constructors
	public BaseBlDispensingDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlDispensingDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal qty;
	private java.math.BigDecimal amount;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal proportionalDisAmt;
	private java.math.BigDecimal salesTaxAmt;
	private java.math.BigDecimal netAmt;
	private java.math.BigDecimal refundedAmt;
	private java.lang.String refundableStatus;
	private java.lang.String issued;

	// many to one
	private jkt.hms.masters.business.StoreItemBatchStock batch;
	private jkt.hms.masters.business.BlDispensingHeader dispensingHeader;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="dispensing_details_id"
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
	 * Return the value associated with the column: qty
	 */
	public java.math.BigDecimal getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.math.BigDecimal qty) {
		this.qty = qty;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: discount_percent
	 */
	public java.math.BigDecimal getDiscountPercent () {
		return discountPercent;
	}

	/**
	 * Set the value related to the column: discount_percent
	 * @param discountPercent the discount_percent value
	 */
	public void setDiscountPercent (java.math.BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}



	/**
	 * Return the value associated with the column: discount_amt
	 */
	public java.math.BigDecimal getDiscountAmt () {
		return discountAmt;
	}

	/**
	 * Set the value related to the column: discount_amt
	 * @param discountAmt the discount_amt value
	 */
	public void setDiscountAmt (java.math.BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}



	/**
	 * Return the value associated with the column: proportional_dis_amt
	 */
	public java.math.BigDecimal getProportionalDisAmt () {
		return proportionalDisAmt;
	}

	/**
	 * Set the value related to the column: proportional_dis_amt
	 * @param proportionalDisAmt the proportional_dis_amt value
	 */
	public void setProportionalDisAmt (java.math.BigDecimal proportionalDisAmt) {
		this.proportionalDisAmt = proportionalDisAmt;
	}



	/**
	 * Return the value associated with the column: sales_tax_amt
	 */
	public java.math.BigDecimal getSalesTaxAmt () {
		return salesTaxAmt;
	}

	/**
	 * Set the value related to the column: sales_tax_amt
	 * @param salesTaxAmt the sales_tax_amt value
	 */
	public void setSalesTaxAmt (java.math.BigDecimal salesTaxAmt) {
		this.salesTaxAmt = salesTaxAmt;
	}



	/**
	 * Return the value associated with the column: net_amt
	 */
	public java.math.BigDecimal getNetAmt () {
		return netAmt;
	}

	/**
	 * Set the value related to the column: net_amt
	 * @param netAmt the net_amt value
	 */
	public void setNetAmt (java.math.BigDecimal netAmt) {
		this.netAmt = netAmt;
	}



	/**
	 * Return the value associated with the column: refunded_amt
	 */
	public java.math.BigDecimal getRefundedAmt () {
		return refundedAmt;
	}

	/**
	 * Set the value related to the column: refunded_amt
	 * @param refundedAmt the refunded_amt value
	 */
	public void setRefundedAmt (java.math.BigDecimal refundedAmt) {
		this.refundedAmt = refundedAmt;
	}



	/**
	 * Return the value associated with the column: refundable_status
	 */
	public java.lang.String getRefundableStatus () {
		return refundableStatus;
	}

	/**
	 * Set the value related to the column: refundable_status
	 * @param refundableStatus the refundable_status value
	 */
	public void setRefundableStatus (java.lang.String refundableStatus) {
		this.refundableStatus = refundableStatus;
	}



	/**
	 * Return the value associated with the column: issued
	 */
	public java.lang.String getIssued () {
		return issued;
	}

	/**
	 * Set the value related to the column: issued
	 * @param issued the issued value
	 */
	public void setIssued (java.lang.String issued) {
		this.issued = issued;
	}



	/**
	 * Return the value associated with the column: batch_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getBatch () {
		return batch;
	}

	/**
	 * Set the value related to the column: batch_id
	 * @param batch the batch_id value
	 */
	public void setBatch (jkt.hms.masters.business.StoreItemBatchStock batch) {
		this.batch = batch;
	}



	/**
	 * Return the value associated with the column: dispensing_header_id
	 */
	public jkt.hms.masters.business.BlDispensingHeader getDispensingHeader () {
		return dispensingHeader;
	}

	/**
	 * Set the value related to the column: dispensing_header_id
	 * @param dispensingHeader the dispensing_header_id value
	 */
	public void setDispensingHeader (jkt.hms.masters.business.BlDispensingHeader dispensingHeader) {
		this.dispensingHeader = dispensingHeader;
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
		if (!(obj instanceof jkt.hms.masters.business.BlDispensingDetails)) return false;
		else {
			jkt.hms.masters.business.BlDispensingDetails blDispensingDetails = (jkt.hms.masters.business.BlDispensingDetails) obj;
			if (null == this.getId() || null == blDispensingDetails.getId()) return false;
			else return (this.getId().equals(blDispensingDetails.getId()));
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