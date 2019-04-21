package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_temp_op_bill_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_temp_op_bill_details"
 */

public abstract class BaseBlTempOpBillDetails implements Serializable {

	public static String REF = "BlTempOpBillDetails";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_TEMP_BILL_TIME = "TempBillTime";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_PROPORTIONAL_DISCOUNT_AMOUNT = "ProportionalDiscountAmount";
	public static String PROP_NET_AMT = "NetAmt";
	public static String PROP_TEMP_BILL_DATE = "TempBillDate";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ID = "Id";
	public static String PROP_RATE = "Rate";
	public static String PROP_TEMP_OP_BILL_HEADER = "TempOpBillHeader";

	// constructors
	public BaseBlTempOpBillDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlTempOpBillDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer quantity;
	private java.math.BigDecimal rate;
	private java.math.BigDecimal amount;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal proportionalDiscountAmount;
	private java.math.BigDecimal netAmt;
	private java.util.Date tempBillDate;
	private java.lang.String tempBillTime;

	// many to one
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.BlTempOpBillHeader tempOpBillHeader;
	private jkt.hms.masters.business.MasChargeCode chargeCode;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="temp_op_bill_details_id"
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
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity() {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * 
	 * @param quantity
	 *            the quantity value
	 */
	public void setQuantity(java.lang.Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate() {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * 
	 * @param rate
	 *            the rate value
	 */
	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
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
	 * Return the value associated with the column: proportional_discount_amount
	 */
	public java.math.BigDecimal getProportionalDiscountAmount() {
		return proportionalDiscountAmount;
	}

	/**
	 * Set the value related to the column: proportional_discount_amount
	 * 
	 * @param proportionalDiscountAmount
	 *            the proportional_discount_amount value
	 */
	public void setProportionalDiscountAmount(
			java.math.BigDecimal proportionalDiscountAmount) {
		this.proportionalDiscountAmount = proportionalDiscountAmount;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode() {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCode
	 *            the charge_code_id value
	 */
	public void setChargeCode(jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlTempOpBillDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.BlTempOpBillDetails blTempOpBillDetails = (jkt.hms.masters.business.BlTempOpBillDetails) obj;
			if (null == this.getId() || null == blTempOpBillDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(blTempOpBillDetails.getId()));
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