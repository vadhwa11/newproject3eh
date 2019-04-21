package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_orderdt table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_orderdt"
 */

public abstract class BaseDgOrderdt  implements Serializable {

	public static String REF = "DgOrderdt";
	public static String PROP_NOT_APPLICABLE = "NotApplicable";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_ORDER_STATUS = "OrderStatus";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PACS_STATUS = "PacsStatus";
	public static String PROP_SUB_CHARGEID = "SubChargeid";
	public static String PROP_MSG_SENT = "MsgSent";
	public static String PROP_BILL = "Bill";
	public static String PROP_ORDER_CANCEL_STATUS = "OrderCancelStatus";
	public static String PROP_ORDER_QTY = "OrderQty";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_PACS_ERROR_MESSAGE = "PacsErrorMessage";
	public static String PROP_CHARGE_SLIP = "ChargeSlip";
	public static String PROP_ORDERHD = "Orderhd";
	public static String PROP_ID = "Id";
	public static String PROP_PACS_MESSAGE = "PacsMessage";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PAYMENT_MADE = "PaymentMade";
	public static String PROP_PACS_ERROR_CODE = "PacsErrorCode";
	public static String PROP_IN_PKG_FLAG = "InPkgFlag";
	public static String PROP_OUT_SIDE_LAB = "OutsideLab";
	public static String PROP_OUT_SIDE_LAB_NAME = "OutsideLabName";
	public static String PROP_OUT_SIDE_LAB_VALUES = "OutsideLabValues";


	// constructors
	public BaseDgOrderdt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgOrderdt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer orderQty;
	private java.lang.String orderStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String paymentMade;
	private java.math.BigDecimal amount;
	private java.lang.String msgSent;
	private java.lang.String pacsStatus;
	private java.lang.String pacsErrorMessage;
	private java.lang.String pacsErrorCode;
	private java.lang.String pacsMessage;
	private java.lang.String orderCancelStatus;
	private java.lang.String notApplicable;
	private java.lang.String inPkgFlag;
	private java.lang.String outsideLab;
	private java.lang.String outsideLabName;
	private java.lang.String outsideLabValues;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.BlChargeSlipMain chargeSlip;
	private jkt.hms.masters.business.DgOrderhd orderhd;
	private jkt.hms.masters.business.BlOpBillHeader bill;
	private jkt.hms.masters.business.MasSubChargecode subChargeid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="orderdt_id"
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
	 * Return the value associated with the column: order_qty
	 */
	public java.lang.Integer getOrderQty () {
		return orderQty;
	}

	/**
	 * Set the value related to the column: order_qty
	 * @param orderQty the order_qty value
	 */
	public void setOrderQty (java.lang.Integer orderQty) {
		this.orderQty = orderQty;
	}



	/**
	 * Return the value associated with the column: order_status
	 */
	public java.lang.String getOrderStatus () {
		return orderStatus;
	}

	/**
	 * Set the value related to the column: order_status
	 * @param orderStatus the order_status value
	 */
	public void setOrderStatus (java.lang.String orderStatus) {
		this.orderStatus = orderStatus;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: payment_made
	 */
	public java.lang.String getPaymentMade () {
		return paymentMade;
	}

	/**
	 * Set the value related to the column: payment_made
	 * @param paymentMade the payment_made value
	 */
	public void setPaymentMade (java.lang.String paymentMade) {
		this.paymentMade = paymentMade;
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
	 * Return the value associated with the column: msg_sent
	 */
	public java.lang.String getMsgSent () {
		return msgSent;
	}

	/**
	 * Set the value related to the column: msg_sent
	 * @param msgSent the msg_sent value
	 */
	public void setMsgSent (java.lang.String msgSent) {
		this.msgSent = msgSent;
	}



	/**
	 * Return the value associated with the column: pacs_status
	 */
	public java.lang.String getPacsStatus () {
		return pacsStatus;
	}

	/**
	 * Set the value related to the column: pacs_status
	 * @param pacsStatus the pacs_status value
	 */
	public void setPacsStatus (java.lang.String pacsStatus) {
		this.pacsStatus = pacsStatus;
	}



	/**
	 * Return the value associated with the column: pacs_error_message
	 */
	public java.lang.String getPacsErrorMessage () {
		return pacsErrorMessage;
	}

	/**
	 * Set the value related to the column: pacs_error_message
	 * @param pacsErrorMessage the pacs_error_message value
	 */
	public void setPacsErrorMessage (java.lang.String pacsErrorMessage) {
		this.pacsErrorMessage = pacsErrorMessage;
	}



	/**
	 * Return the value associated with the column: pacs_error_code
	 */
	public java.lang.String getPacsErrorCode () {
		return pacsErrorCode;
	}

	/**
	 * Set the value related to the column: pacs_error_code
	 * @param pacsErrorCode the pacs_error_code value
	 */
	public void setPacsErrorCode (java.lang.String pacsErrorCode) {
		this.pacsErrorCode = pacsErrorCode;
	}



	/**
	 * Return the value associated with the column: pacs_message
	 */
	public java.lang.String getPacsMessage () {
		return pacsMessage;
	}

	/**
	 * Set the value related to the column: pacs_message
	 * @param pacsMessage the pacs_message value
	 */
	public void setPacsMessage (java.lang.String pacsMessage) {
		this.pacsMessage = pacsMessage;
	}



	/**
	 * Return the value associated with the column: order_cancel_status
	 */
	public java.lang.String getOrderCancelStatus () {
		return orderCancelStatus;
	}

	/**
	 * Set the value related to the column: order_cancel_status
	 * @param orderCancelStatus the order_cancel_status value
	 */
	public void setOrderCancelStatus (java.lang.String orderCancelStatus) {
		this.orderCancelStatus = orderCancelStatus;
	}



	/**
	 * Return the value associated with the column: not_applicable
	 */
	public java.lang.String getNotApplicable () {
		return notApplicable;
	}

	/**
	 * Set the value related to the column: not_applicable
	 * @param notApplicable the not_applicable value
	 */
	public void setNotApplicable (java.lang.String notApplicable) {
		this.notApplicable = notApplicable;
	}



	/**
	 * Return the value associated with the column: in_pkg_flag
	 */
	public java.lang.String getInPkgFlag () {
		return inPkgFlag;
	}

	/**
	 * Set the value related to the column: in_pkg_flag
	 * @param inPkgFlag the in_pkg_flag value
	 */
	public void setInPkgFlag (java.lang.String inPkgFlag) {
		this.inPkgFlag = inPkgFlag;
	}


	/**
	 * Return the value associated with the column: outside_lab
	 */
	public java.lang.String getOutsideLab() {
		return outsideLab;
	}
	/**
	 * Set the value related to the column: outside_lab
	 * @param outsideLab the outside_lab value
	 */
	public void setOutsideLab(java.lang.String outsideLab) {
		this.outsideLab = outsideLab;
	}
	/**
	 * Return the value associated with the column: outside_lab_name
	 */
	public java.lang.String getOutsideLabName() {
		return outsideLabName;
	}
	/**
	 * Set the value related to the column: outside_lab_name
	 * @param outsideLabName the outside_lab_name value
	 */
	public void setOutsideLabName(java.lang.String outsideLabName) {
		this.outsideLabName = outsideLabName;
	}
	/**
	 * Return the value associated with the column: outside_lab_values
	 */
	public java.lang.String getOutsideLabValues() {
		return outsideLabValues;
	}
	/**
	 * Set the value related to the column: outside_lab_values
	 * @param outsideLabValues the outside_lab_values value
	 */
	public void setOutsideLabValues(java.lang.String outsideLabValues) {
		this.outsideLabValues = outsideLabValues;
	}

	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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
	 * Return the value associated with the column: main_chargecode_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainChargecode () {
		return mainChargecode;
	}

	/**
	 * Set the value related to the column: main_chargecode_id
	 * @param mainChargecode the main_chargecode_id value
	 */
	public void setMainChargecode (jkt.hms.masters.business.MasMainChargecode mainChargecode) {
		this.mainChargecode = mainChargecode;
	}



	/**
	 * Return the value associated with the column: charge_slip_id
	 */
	public jkt.hms.masters.business.BlChargeSlipMain getChargeSlip () {
		return chargeSlip;
	}

	/**
	 * Set the value related to the column: charge_slip_id
	 * @param chargeSlip the charge_slip_id value
	 */
	public void setChargeSlip (jkt.hms.masters.business.BlChargeSlipMain chargeSlip) {
		this.chargeSlip = chargeSlip;
	}



	/**
	 * Return the value associated with the column: orderhd_id
	 */
	public jkt.hms.masters.business.DgOrderhd getOrderhd () {
		return orderhd;
	}

	/**
	 * Set the value related to the column: orderhd_id
	 * @param orderhd the orderhd_id value
	 */
	public void setOrderhd (jkt.hms.masters.business.DgOrderhd orderhd) {
		this.orderhd = orderhd;
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
	 * Return the value associated with the column: sub_chargeid
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubChargeid () {
		return subChargeid;
	}

	/**
	 * Set the value related to the column: sub_chargeid
	 * @param subChargeid the sub_chargeid value
	 */
	public void setSubChargeid (jkt.hms.masters.business.MasSubChargecode subChargeid) {
		this.subChargeid = subChargeid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgOrderdt)) return false;
		else {
			jkt.hms.masters.business.DgOrderdt dgOrderdt = (jkt.hms.masters.business.DgOrderdt) obj;
			if (null == this.getId() || null == dgOrderdt.getId()) return false;
			else return (this.getId().equals(dgOrderdt.getId()));
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