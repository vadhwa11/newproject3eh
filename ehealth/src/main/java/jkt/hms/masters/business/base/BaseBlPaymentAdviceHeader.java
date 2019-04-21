package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_payment_advice_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_payment_advice_header"
 */

public abstract class BaseBlPaymentAdviceHeader  implements Serializable {

	public static String REF = "BlPaymentAdviceHeader";
	public static String PROP_PAYMENT_ADVICE_TIME = "PaymentAdviceTime";
	public static String PROP_CASH_ADVICE_AMT = "CashAdviceAmt";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PAYMENT_ADVICE_NO = "PaymentAdviceNo";
	public static String PROP_TOTAL_ADVICE_AMT = "TotalAdviceAmt";
	public static String PROP_PAYMENT_ADVICE_DATE = "PaymentAdviceDate";
	public static String PROP_TOTAL_ADVICE_CHARITY_AMT = "TotalAdviceCharityAmt";
	public static String PROP_REFUNDED = "Refunded";
	public static String PROP_BILL = "Bill";
	public static String PROP_CHARGE_SLIP_MAIN = "ChargeSlipMain";
	public static String PROP_ON_ACCOUNT_AMT = "OnAccountAmt";
	public static String PROP_ID = "Id";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseBlPaymentAdviceHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPaymentAdviceHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String paymentAdviceNo;
	private java.math.BigDecimal totalAdviceAmt;
	private java.math.BigDecimal cashAdviceAmt;
	private java.math.BigDecimal onAccountAmt;
	private java.util.Date paymentAdviceDate;
	private java.lang.String paymentAdviceTime;
	private java.math.BigDecimal totalAdviceCharityAmt;
	private java.lang.String refunded;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.BlChargeSlipMain chargeSlipMain;
	private jkt.hms.masters.business.BlOpBillHeader bill;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders;
	private java.util.Set<jkt.hms.masters.business.BlPaymentAdviceDetails> blPaymentAdviceDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="payment_advice_header_id"
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
	 * Return the value associated with the column: payment_advice_no
	 */
	public java.lang.String getPaymentAdviceNo () {
		return paymentAdviceNo;
	}

	/**
	 * Set the value related to the column: payment_advice_no
	 * @param paymentAdviceNo the payment_advice_no value
	 */
	public void setPaymentAdviceNo (java.lang.String paymentAdviceNo) {
		this.paymentAdviceNo = paymentAdviceNo;
	}



	/**
	 * Return the value associated with the column: total_advice_amt
	 */
	public java.math.BigDecimal getTotalAdviceAmt () {
		return totalAdviceAmt;
	}

	/**
	 * Set the value related to the column: total_advice_amt
	 * @param totalAdviceAmt the total_advice_amt value
	 */
	public void setTotalAdviceAmt (java.math.BigDecimal totalAdviceAmt) {
		this.totalAdviceAmt = totalAdviceAmt;
	}



	/**
	 * Return the value associated with the column: cash_advice_amt
	 */
	public java.math.BigDecimal getCashAdviceAmt () {
		return cashAdviceAmt;
	}

	/**
	 * Set the value related to the column: cash_advice_amt
	 * @param cashAdviceAmt the cash_advice_amt value
	 */
	public void setCashAdviceAmt (java.math.BigDecimal cashAdviceAmt) {
		this.cashAdviceAmt = cashAdviceAmt;
	}



	/**
	 * Return the value associated with the column: on_account_amt
	 */
	public java.math.BigDecimal getOnAccountAmt () {
		return onAccountAmt;
	}

	/**
	 * Set the value related to the column: on_account_amt
	 * @param onAccountAmt the on_account_amt value
	 */
	public void setOnAccountAmt (java.math.BigDecimal onAccountAmt) {
		this.onAccountAmt = onAccountAmt;
	}



	/**
	 * Return the value associated with the column: payment_advice_date
	 */
	public java.util.Date getPaymentAdviceDate () {
		return paymentAdviceDate;
	}

	/**
	 * Set the value related to the column: payment_advice_date
	 * @param paymentAdviceDate the payment_advice_date value
	 */
	public void setPaymentAdviceDate (java.util.Date paymentAdviceDate) {
		this.paymentAdviceDate = paymentAdviceDate;
	}



	/**
	 * Return the value associated with the column: payment_advice_time
	 */
	public java.lang.String getPaymentAdviceTime () {
		return paymentAdviceTime;
	}

	/**
	 * Set the value related to the column: payment_advice_time
	 * @param paymentAdviceTime the payment_advice_time value
	 */
	public void setPaymentAdviceTime (java.lang.String paymentAdviceTime) {
		this.paymentAdviceTime = paymentAdviceTime;
	}



	/**
	 * Return the value associated with the column: total_advice_charity_amt
	 */
	public java.math.BigDecimal getTotalAdviceCharityAmt () {
		return totalAdviceCharityAmt;
	}

	/**
	 * Set the value related to the column: total_advice_charity_amt
	 * @param totalAdviceCharityAmt the total_advice_charity_amt value
	 */
	public void setTotalAdviceCharityAmt (java.math.BigDecimal totalAdviceCharityAmt) {
		this.totalAdviceCharityAmt = totalAdviceCharityAmt;
	}



	/**
	 * Return the value associated with the column: refunded
	 */
	public java.lang.String getRefunded () {
		return refunded;
	}

	/**
	 * Set the value related to the column: refunded
	 * @param refunded the refunded value
	 */
	public void setRefunded (java.lang.String refunded) {
		this.refunded = refunded;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: charge_slip_main_id
	 */
	public jkt.hms.masters.business.BlChargeSlipMain getChargeSlipMain () {
		return chargeSlipMain;
	}

	/**
	 * Set the value related to the column: charge_slip_main_id
	 * @param chargeSlipMain the charge_slip_main_id value
	 */
	public void setChargeSlipMain (jkt.hms.masters.business.BlChargeSlipMain chargeSlipMain) {
		this.chargeSlipMain = chargeSlipMain;
	}



	/**
	 * Return the value associated with the column: bill_id
	 */
	public jkt.hms.masters.business.BlOpBillHeader getBill () {
		return bill;
	}

	/**
	 * Set the value related to the column: bill_id
	 * @param bill the bill_id value
	 */
	public void setBill (jkt.hms.masters.business.BlOpBillHeader bill) {
		this.bill = bill;
	}



	/**
	 * Return the value associated with the column: BlRefundHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlRefundHeader> getBlRefundHeaders () {
		return blRefundHeaders;
	}

	/**
	 * Set the value related to the column: BlRefundHeaders
	 * @param blRefundHeaders the BlRefundHeaders value
	 */
	public void setBlRefundHeaders (java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders) {
		this.blRefundHeaders = blRefundHeaders;
	}

	public void addToBlRefundHeaders (jkt.hms.masters.business.BlRefundHeader blRefundHeader) {
		if (null == getBlRefundHeaders()) setBlRefundHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlRefundHeader>());
		getBlRefundHeaders().add(blRefundHeader);
	}



	/**
	 * Return the value associated with the column: BlPaymentAdviceDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlPaymentAdviceDetails> getBlPaymentAdviceDetails () {
		return blPaymentAdviceDetails;
	}

	/**
	 * Set the value related to the column: BlPaymentAdviceDetails
	 * @param blPaymentAdviceDetails the BlPaymentAdviceDetails value
	 */
	public void setBlPaymentAdviceDetails (java.util.Set<jkt.hms.masters.business.BlPaymentAdviceDetails> blPaymentAdviceDetails) {
		this.blPaymentAdviceDetails = blPaymentAdviceDetails;
	}

	public void addToBlPaymentAdviceDetails (jkt.hms.masters.business.BlPaymentAdviceDetails blPaymentAdviceDetails) {
		if (null == getBlPaymentAdviceDetails()) setBlPaymentAdviceDetails(new java.util.TreeSet<jkt.hms.masters.business.BlPaymentAdviceDetails>());
		getBlPaymentAdviceDetails().add(blPaymentAdviceDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlPaymentAdviceHeader)) return false;
		else {
			jkt.hms.masters.business.BlPaymentAdviceHeader blPaymentAdviceHeader = (jkt.hms.masters.business.BlPaymentAdviceHeader) obj;
			if (null == this.getId() || null == blPaymentAdviceHeader.getId()) return false;
			else return (this.getId().equals(blPaymentAdviceHeader.getId()));
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