package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_refund_details table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_refund_details"
 */

public abstract class BaseBlRefundDetails implements Serializable {

	public static String REF = "BlRefundDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_BANK = "Bank";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REFUND_AMOUNT = "RefundAmount";
	public static String PROP_CHEQUE_DATE = "ChequeDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CHEQUE_NO = "ChequeNo";
	public static String PROP_PAYMENT_MODE = "PaymentMode";
	public static String PROP_ID = "Id";
	public static String PROP_REFUND_HEADER = "RefundHeader";

	// constructors
	public BaseBlRefundDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlRefundDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String paymentMode;
	private java.math.BigDecimal refundAmount;
	private java.lang.String chequeNo;
	private java.util.Date chequeDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.BlRefundHeader refundHeader;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="refund_details_id"
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
	 * Return the value associated with the column: payment_mode
	 */
	public java.lang.String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * Set the value related to the column: payment_mode
	 * 
	 * @param paymentMode
	 *            the payment_mode value
	 */
	public void setPaymentMode(java.lang.String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * Return the value associated with the column: refund_amount
	 */
	public java.math.BigDecimal getRefundAmount() {
		return refundAmount;
	}

	/**
	 * Set the value related to the column: refund_amount
	 * 
	 * @param refundAmount
	 *            the refund_amount value
	 */
	public void setRefundAmount(java.math.BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	/**
	 * Return the value associated with the column: cheque_no
	 */
	public java.lang.String getChequeNo() {
		return chequeNo;
	}

	/**
	 * Set the value related to the column: cheque_no
	 * 
	 * @param chequeNo
	 *            the cheque_no value
	 */
	public void setChequeNo(java.lang.String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * Return the value associated with the column: cheque_date
	 */
	public java.util.Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Set the value related to the column: cheque_date
	 * 
	 * @param chequeDate
	 *            the cheque_date value
	 */
	public void setChequeDate(java.util.Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: bank_id
	 */
	public jkt.hms.masters.business.MasBankMaster getBank() {
		return bank;
	}

	/**
	 * Set the value related to the column: bank_id
	 * 
	 * @param bank
	 *            the bank_id value
	 */
	public void setBank(jkt.hms.masters.business.MasBankMaster bank) {
		this.bank = bank;
	}

	/**
	 * Return the value associated with the column: refund_header_id
	 */
	public jkt.hms.masters.business.BlRefundHeader getRefundHeader() {
		return refundHeader;
	}

	/**
	 * Set the value related to the column: refund_header_id
	 * 
	 * @param refundHeader
	 *            the refund_header_id value
	 */
	public void setRefundHeader(
			jkt.hms.masters.business.BlRefundHeader refundHeader) {
		this.refundHeader = refundHeader;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlRefundDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.BlRefundDetails blRefundDetails = (jkt.hms.masters.business.BlRefundDetails) obj;
			if (null == this.getId() || null == blRefundDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(blRefundDetails.getId()));
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