package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * bl_temp_bill_dispensing_details table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="bl_temp_bill_dispensing_details"
 */

public abstract class BaseBlTempBillDispensingDetails implements Serializable {

	public static String REF = "BlTempBillDispensingDetails";
	public static String PROP_QTY = "Qty";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_PROPORTIONAL_DIS_AMT = "ProportionalDisAmt";
	public static String PROP_BATCH = "Batch";
	public static String PROP_ITEM = "Item";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_TEMP_BILL_TIME = "TempBillTime";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_NET_AMT = "NetAmt";
	public static String PROP_SALES_TAX_AMT = "SalesTaxAmt";
	public static String PROP_TEMP_BILL_DATE = "TempBillDate";
	public static String PROP_ID = "Id";
	public static String PROP_TEMP_OP_BILL_HEADER = "TempOpBillHeader";

	// constructors
	public BaseBlTempBillDispensingDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlTempBillDispensingDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

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
	private java.util.Date tempBillDate;
	private java.lang.String tempBillTime;

	// many to one
	private jkt.hms.masters.business.StoreItemBatchStock batch;
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.BlTempOpBillHeader tempOpBillHeader;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="temp_bill_dispensing_details_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: qty
	 */
	public java.math.BigDecimal getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.math.BigDecimal qty) {
		this.qty = qty;
	}

	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * 
	 * @param amount
	 *            the amount value
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Return the value associated with the column: discount_percent
	 */
	public java.math.BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * Set the value related to the column: discount_percent
	 * 
	 * @param discountPercent
	 *            the discount_percent value
	 */
	public void setDiscountPercent(java.math.BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * Return the value associated with the column: discount_amt
	 */
	public java.math.BigDecimal getDiscountAmt() {
		return discountAmt;
	}

	/**
	 * Set the value related to the column: discount_amt
	 * 
	 * @param discountAmt
	 *            the discount_amt value
	 */
	public void setDiscountAmt(java.math.BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}

	/**
	 * Return the value associated with the column: proportional_dis_amt
	 */
	public java.math.BigDecimal getProportionalDisAmt() {
		return proportionalDisAmt;
	}

	/**
	 * Set the value related to the column: proportional_dis_amt
	 * 
	 * @param proportionalDisAmt
	 *            the proportional_dis_amt value
	 */
	public void setProportionalDisAmt(java.math.BigDecimal proportionalDisAmt) {
		this.proportionalDisAmt = proportionalDisAmt;
	}

	/**
	 * Return the value associated with the column: sales_tax_amt
	 */
	public java.math.BigDecimal getSalesTaxAmt() {
		return salesTaxAmt;
	}

	/**
	 * Set the value related to the column: sales_tax_amt
	 * 
	 * @param salesTaxAmt
	 *            the sales_tax_amt value
	 */
	public void setSalesTaxAmt(java.math.BigDecimal salesTaxAmt) {
		this.salesTaxAmt = salesTaxAmt;
	}

	/**
	 * Return the value associated with the column: net_amt
	 */
	public java.math.BigDecimal getNetAmt() {
		return netAmt;
	}

	/**
	 * Set the value related to the column: net_amt
	 * 
	 * @param netAmt
	 *            the net_amt value
	 */
	public void setNetAmt(java.math.BigDecimal netAmt) {
		this.netAmt = netAmt;
	}

	/**
	 * Return the value associated with the column: temp_bill_date
	 */
	public java.util.Date getTempBillDate() {
		return tempBillDate;
	}

	/**
	 * Set the value related to the column: temp_bill_date
	 * 
	 * @param tempBillDate
	 *            the temp_bill_date value
	 */
	public void setTempBillDate(java.util.Date tempBillDate) {
		this.tempBillDate = tempBillDate;
	}

	/**
	 * Return the value associated with the column: temp_bill_time
	 */
	public java.lang.String getTempBillTime() {
		return tempBillTime;
	}

	/**
	 * Set the value related to the column: temp_bill_time
	 * 
	 * @param tempBillTime
	 *            the temp_bill_time value
	 */
	public void setTempBillTime(java.lang.String tempBillTime) {
		this.tempBillTime = tempBillTime;
	}

	/**
	 * Return the value associated with the column: batch_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getBatch() {
		return batch;
	}

	/**
	 * Set the value related to the column: batch_id
	 * 
	 * @param batch
	 *            the batch_id value
	 */
	public void setBatch(jkt.hms.masters.business.StoreItemBatchStock batch) {
		this.batch = batch;
	}

	/**
	 * Return the value associated with the column: changed_by
	 */
	public jkt.hms.masters.business.Users getChangedBy() {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * 
	 * @param changedBy
	 *            the changed_by value
	 */
	public void setChangedBy(jkt.hms.masters.business.Users changedBy) {
		this.changedBy = changedBy;
	}

	/**
	 * Return the value associated with the column: temp_op_bill_header_id
	 */
	public jkt.hms.masters.business.BlTempOpBillHeader getTempOpBillHeader() {
		return tempOpBillHeader;
	}

	/**
	 * Set the value related to the column: temp_op_bill_header_id
	 * 
	 * @param tempOpBillHeader
	 *            the temp_op_bill_header_id value
	 */
	public void setTempOpBillHeader(
			jkt.hms.masters.business.BlTempOpBillHeader tempOpBillHeader) {
		this.tempOpBillHeader = tempOpBillHeader;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlTempBillDispensingDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.BlTempBillDispensingDetails blTempBillDispensingDetails = (jkt.hms.masters.business.BlTempBillDispensingDetails) obj;
			if (null == this.getId()
					|| null == blTempBillDispensingDetails.getId()) {
				return false;
			} else {
				return (this.getId()
						.equals(blTempBillDispensingDetails.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}