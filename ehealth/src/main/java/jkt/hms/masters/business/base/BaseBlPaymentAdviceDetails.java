package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_payment_advice_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_payment_advice_details"
 */

public abstract class BaseBlPaymentAdviceDetails implements Serializable {

	public static String REF = "BlPaymentAdviceDetails";
	public static String PROP_ADVICE_QTY = "AdviceQty";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_REFUNDED = "Refunded";
	public static String PROP_ADVICE_AMT = "AdviceAmt";
	public static String PROP_PAYMENT_ADVICE_HEADER = "PaymentAdviceHeader";
	public static String PROP_ADVICE_CHARITY_AMT = "AdviceCharityAmt";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlPaymentAdviceDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPaymentAdviceDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer adviceQty;
	private java.math.BigDecimal adviceAmt;
	private java.math.BigDecimal adviceCharityAmt;
	private java.lang.String refunded;

	// many to one
	private jkt.hms.masters.business.MasChargeCode charge;
	private jkt.hms.masters.business.BlPaymentAdviceHeader paymentAdviceHeader;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="payment_advice_details_id"
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
	 * Return the value associated with the column: advice_qty
	 */
	public java.lang.Integer getAdviceQty() {
		return adviceQty;
	}

	/**
	 * Set the value related to the column: advice_qty
	 * 
	 * @param adviceQty
	 *            the advice_qty value
	 */
	public void setAdviceQty(java.lang.Integer adviceQty) {
		this.adviceQty = adviceQty;
	}

	/**
	 * Return the value associated with the column: advice_amt
	 */
	public java.math.BigDecimal getAdviceAmt() {
		return adviceAmt;
	}

	/**
	 * Set the value related to the column: advice_amt
	 * 
	 * @param adviceAmt
	 *            the advice_amt value
	 */
	public void setAdviceAmt(java.math.BigDecimal adviceAmt) {
		this.adviceAmt = adviceAmt;
	}

	/**
	 * Return the value associated with the column: advice_charity_amt
	 */
	public java.math.BigDecimal getAdviceCharityAmt() {
		return adviceCharityAmt;
	}

	/**
	 * Set the value related to the column: advice_charity_amt
	 * 
	 * @param adviceCharityAmt
	 *            the advice_charity_amt value
	 */
	public void setAdviceCharityAmt(java.math.BigDecimal adviceCharityAmt) {
		this.adviceCharityAmt = adviceCharityAmt;
	}

	/**
	 * Return the value associated with the column: refunded
	 */
	public java.lang.String getRefunded() {
		return refunded;
	}

	/**
	 * Set the value related to the column: refunded
	 * 
	 * @param refunded
	 *            the refunded value
	 */
	public void setRefunded(java.lang.String refunded) {
		this.refunded = refunded;
	}

	/**
	 * Return the value associated with the column: charge_id
	 */
	public jkt.hms.masters.business.MasChargeCode getCharge() {
		return charge;
	}

	/**
	 * Set the value related to the column: charge_id
	 * 
	 * @param charge
	 *            the charge_id value
	 */
	public void setCharge(jkt.hms.masters.business.MasChargeCode charge) {
		this.charge = charge;
	}

	/**
	 * Return the value associated with the column: payment_advice_header_id
	 */
	public jkt.hms.masters.business.BlPaymentAdviceHeader getPaymentAdviceHeader() {
		return paymentAdviceHeader;
	}

	/**
	 * Set the value related to the column: payment_advice_header_id
	 * 
	 * @param paymentAdviceHeader
	 *            the payment_advice_header_id value
	 */
	public void setPaymentAdviceHeader(
			jkt.hms.masters.business.BlPaymentAdviceHeader paymentAdviceHeader) {
		this.paymentAdviceHeader = paymentAdviceHeader;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlPaymentAdviceDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.BlPaymentAdviceDetails blPaymentAdviceDetails = (jkt.hms.masters.business.BlPaymentAdviceDetails) obj;
			if (null == this.getId() || null == blPaymentAdviceDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(blPaymentAdviceDetails.getId()));
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