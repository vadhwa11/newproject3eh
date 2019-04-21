package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_charge_slip_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_charge_slip_main"
 */

public abstract class BaseBlChargeSlipMain  implements Serializable {

	public static String REF = "BlChargeSlipMain";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_CHARITY_RCVD = "CharityRcvd";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RECEIPT_AMT = "ReceiptAmt";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AUTO_PROCESSED = "AutoProcessed";
	public static String PROP_PACKAGE_BILL = "PackageBill";
	public static String PROP_ADJUSTED_AMT = "AdjustedAmt";
	public static String PROP_PACKAGE = "Package";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_CHARGE_SLIP_NO = "ChargeSlipNo";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_OS_AMT = "OsAmt";
	public static String PROP_CHARITY = "Charity";
	public static String PROP_AUTHORIZER = "Authorizer";
	public static String PROP_ROOM_PROCESSED = "RoomProcessed";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_CHG_SLP_AMT = "ChgSlpAmt";
	public static String PROP_RECEIPT_ID = "ReceiptId";
	public static String PROP_STATUS = "Status";
	public static String PROP_PAY_STATUS = "PayStatus";
	public static String PROP_ROUND_OFF = "RoundOff";
	public static String PROP_CHG_SLP_TIME = "ChgSlpTime";
	public static String PROP_CHG_SLP_DATE = "ChgSlpDate";
	public static String PROP_CONSULTANT = "Consultant";
	public static String PROP_ID = "Id";
	public static String PROP_FINAL_BILL = "FinalBill";
	public static String PROP_HIN = "Hin";
	public static String PROP_NET_AMT = "NetAmt";
	public static String PROP_SCHEME = "Scheme";

	// constructors
	public BaseBlChargeSlipMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlChargeSlipMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer chargeSlipNo;
	private java.math.BigDecimal chgSlpAmt;
	private java.math.BigDecimal receiptAmt;
	private java.math.BigDecimal osAmt;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal netAmt;
	private java.lang.Long receiptId;
	private java.util.Date chgSlpDate;
	private java.lang.String chgSlpTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.math.BigDecimal roundOff;
	private java.math.BigDecimal discount;
	private java.math.BigDecimal charity;
	private java.lang.String autoProcessed;
	private java.lang.String roomProcessed;
	private java.math.BigDecimal adjustedAmt;
	private java.lang.String payStatus;
	private java.math.BigDecimal charityRcvd;

	// many to one
	private jkt.hms.masters.business.MasPatientType patientType;
	private jkt.hms.masters.business.MasCompany company;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.BlPackageBill packageBill;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee consultant;
	private jkt.hms.masters.business.BlPackageHeader m_package;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasAuthorizer authorizer;
	private jkt.hms.masters.business.BlFinalBillDetails finalBill;
	private jkt.hms.masters.business.MasScheme scheme;
	// collections
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> blChargeSlipDetails;
	private java.util.Set<jkt.hms.masters.business.BlReceiptHeader> blReceiptHeaders;
	private java.util.Set<jkt.hms.masters.business.BlPaymentAdviceHeader> blPaymentAdviceHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="charge_slip_main_id"
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
	 * Return the value associated with the column: charge_slip_no
	 */
	public java.lang.Integer getChargeSlipNo () {
		return chargeSlipNo;
	}

	/**
	 * Set the value related to the column: charge_slip_no
	 * @param chargeSlipNo the charge_slip_no value
	 */
	public void setChargeSlipNo (java.lang.Integer chargeSlipNo) {
		this.chargeSlipNo = chargeSlipNo;
	}



	/**
	 * Return the value associated with the column: chg_slp_amt
	 */
	public java.math.BigDecimal getChgSlpAmt () {
		return chgSlpAmt;
	}

	/**
	 * Set the value related to the column: chg_slp_amt
	 * @param chgSlpAmt the chg_slp_amt value
	 */
	public void setChgSlpAmt (java.math.BigDecimal chgSlpAmt) {
		this.chgSlpAmt = chgSlpAmt;
	}



	/**
	 * Return the value associated with the column: receipt_amt
	 */
	public java.math.BigDecimal getReceiptAmt () {
		return receiptAmt;
	}

	/**
	 * Set the value related to the column: receipt_amt
	 * @param receiptAmt the receipt_amt value
	 */
	public void setReceiptAmt (java.math.BigDecimal receiptAmt) {
		this.receiptAmt = receiptAmt;
	}



	/**
	 * Return the value associated with the column: os_amt
	 */
	public java.math.BigDecimal getOsAmt () {
		return osAmt;
	}

	/**
	 * Set the value related to the column: os_amt
	 * @param osAmt the os_amt value
	 */
	public void setOsAmt (java.math.BigDecimal osAmt) {
		this.osAmt = osAmt;
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
	 * Return the value associated with the column: receipt_id
	 */
	public java.lang.Long getReceiptId () {
		return receiptId;
	}

	/**
	 * Set the value related to the column: receipt_id
	 * @param receiptId the receipt_id value
	 */
	public void setReceiptId (java.lang.Long receiptId) {
		this.receiptId = receiptId;
	}



	/**
	 * Return the value associated with the column: chg_slp_date
	 */
	public java.util.Date getChgSlpDate () {
		return chgSlpDate;
	}

	/**
	 * Set the value related to the column: chg_slp_date
	 * @param chgSlpDate the chg_slp_date value
	 */
	public void setChgSlpDate (java.util.Date chgSlpDate) {
		this.chgSlpDate = chgSlpDate;
	}



	/**
	 * Return the value associated with the column: chg_slp_time
	 */
	public java.lang.String getChgSlpTime () {
		return chgSlpTime;
	}

	/**
	 * Set the value related to the column: chg_slp_time
	 * @param chgSlpTime the chg_slp_time value
	 */
	public void setChgSlpTime (java.lang.String chgSlpTime) {
		this.chgSlpTime = chgSlpTime;
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
	 * Return the value associated with the column: round_off
	 */
	public java.math.BigDecimal getRoundOff () {
		return roundOff;
	}

	/**
	 * Set the value related to the column: round_off
	 * @param roundOff the round_off value
	 */
	public void setRoundOff (java.math.BigDecimal roundOff) {
		this.roundOff = roundOff;
	}



	/**
	 * Return the value associated with the column: discount
	 */
	public java.math.BigDecimal getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * @param discount the discount value
	 */
	public void setDiscount (java.math.BigDecimal discount) {
		this.discount = discount;
	}



	/**
	 * Return the value associated with the column: charity
	 */
	public java.math.BigDecimal getCharity () {
		return charity;
	}

	/**
	 * Set the value related to the column: charity
	 * @param charity the charity value
	 */
	public void setCharity (java.math.BigDecimal charity) {
		this.charity = charity;
	}



	/**
	 * Return the value associated with the column: auto_processed
	 */
	public java.lang.String getAutoProcessed () {
		return autoProcessed;
	}

	/**
	 * Set the value related to the column: auto_processed
	 * @param autoProcessed the auto_processed value
	 */
	public void setAutoProcessed (java.lang.String autoProcessed) {
		this.autoProcessed = autoProcessed;
	}



	/**
	 * Return the value associated with the column: room_processed
	 */
	public java.lang.String getRoomProcessed () {
		return roomProcessed;
	}

	/**
	 * Set the value related to the column: room_processed
	 * @param roomProcessed the room_processed value
	 */
	public void setRoomProcessed (java.lang.String roomProcessed) {
		this.roomProcessed = roomProcessed;
	}



	/**
	 * Return the value associated with the column: adjusted_amt
	 */
	public java.math.BigDecimal getAdjustedAmt () {
		return adjustedAmt;
	}

	/**
	 * Set the value related to the column: adjusted_amt
	 * @param adjustedAmt the adjusted_amt value
	 */
	public void setAdjustedAmt (java.math.BigDecimal adjustedAmt) {
		this.adjustedAmt = adjustedAmt;
	}



	/**
	 * Return the value associated with the column: pay_status
	 */
	public java.lang.String getPayStatus () {
		return payStatus;
	}

	/**
	 * Set the value related to the column: pay_status
	 * @param payStatus the pay_status value
	 */
	public void setPayStatus (java.lang.String payStatus) {
		this.payStatus = payStatus;
	}



	/**
	 * Return the value associated with the column: charity_rcvd
	 */
	public java.math.BigDecimal getCharityRcvd () {
		return charityRcvd;
	}

	/**
	 * Set the value related to the column: charity_rcvd
	 * @param charityRcvd the charity_rcvd value
	 */
	public void setCharityRcvd (java.math.BigDecimal charityRcvd) {
		this.charityRcvd = charityRcvd;
	}



	/**
	 * Return the value associated with the column: patient_type_id
	 */
	public jkt.hms.masters.business.MasPatientType getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * @param patientType the patient_type_id value
	 */
	public void setPatientType (jkt.hms.masters.business.MasPatientType patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasCompany getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasCompany company) {
		this.company = company;
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
	 * Return the value associated with the column: package_bill_id
	 */
	public jkt.hms.masters.business.BlPackageBill getPackageBill () {
		return packageBill;
	}

	/**
	 * Set the value related to the column: package_bill_id
	 * @param packageBill the package_bill_id value
	 */
	public void setPackageBill (jkt.hms.masters.business.BlPackageBill packageBill) {
		this.packageBill = packageBill;
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
	 * Return the value associated with the column: consultant_id
	 */
	public jkt.hms.masters.business.MasEmployee getConsultant () {
		return consultant;
	}

	/**
	 * Set the value related to the column: consultant_id
	 * @param consultant the consultant_id value
	 */
	public void setConsultant (jkt.hms.masters.business.MasEmployee consultant) {
		this.consultant = consultant;
	}



	/**
	 * Return the value associated with the column: package_id
	 */
	public jkt.hms.masters.business.BlPackageHeader getPackage () {
		return m_package;
	}

	/**
	 * Set the value related to the column: package_id
	 * @param m_package the package_id value
	 */
	public void setPackage (jkt.hms.masters.business.BlPackageHeader m_package) {
		this.m_package = m_package;
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
	 * Return the value associated with the column: authorizer_id
	 */
	public jkt.hms.masters.business.MasAuthorizer getAuthorizer () {
		return authorizer;
	}

	/**
	 * Set the value related to the column: authorizer_id
	 * @param authorizer the authorizer_id value
	 */
	public void setAuthorizer (jkt.hms.masters.business.MasAuthorizer authorizer) {
		this.authorizer = authorizer;
	}



	/**
	 * Return the value associated with the column: final_bill_id
	 */
	public jkt.hms.masters.business.BlFinalBillDetails getFinalBill () {
		return finalBill;
	}

	/**
	 * Set the value related to the column: final_bill_id
	 * @param finalBill the final_bill_id value
	 */
	public void setFinalBill (jkt.hms.masters.business.BlFinalBillDetails finalBill) {
		this.finalBill = finalBill;
	}


	/**
	 * Return the value associated with the column: scheme_id
	 */
	public jkt.hms.masters.business.MasScheme getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme_id
	 * @param scheme the scheme_id value
	 */
	public void setScheme (jkt.hms.masters.business.MasScheme scheme) {
		this.scheme = scheme;
	}
	/**
	 * Return the value associated with the column: BlChargeSlipDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> getBlChargeSlipDetails () {
		return blChargeSlipDetails;
	}

	/**
	 * Set the value related to the column: BlChargeSlipDetails
	 * @param blChargeSlipDetails the BlChargeSlipDetails value
	 */
	public void setBlChargeSlipDetails (java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> blChargeSlipDetails) {
		this.blChargeSlipDetails = blChargeSlipDetails;
	}

	public void addToBlChargeSlipDetails (jkt.hms.masters.business.BlChargeSlipDetail blChargeSlipDetail) {
		if (null == getBlChargeSlipDetails()) setBlChargeSlipDetails(new java.util.TreeSet<jkt.hms.masters.business.BlChargeSlipDetail>());
		getBlChargeSlipDetails().add(blChargeSlipDetail);
	}



	/**
	 * Return the value associated with the column: BlReceiptHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlReceiptHeader> getBlReceiptHeaders () {
		return blReceiptHeaders;
	}

	/**
	 * Set the value related to the column: BlReceiptHeaders
	 * @param blReceiptHeaders the BlReceiptHeaders value
	 */
	public void setBlReceiptHeaders (java.util.Set<jkt.hms.masters.business.BlReceiptHeader> blReceiptHeaders) {
		this.blReceiptHeaders = blReceiptHeaders;
	}

	public void addToBlReceiptHeaders (jkt.hms.masters.business.BlReceiptHeader blReceiptHeader) {
		if (null == getBlReceiptHeaders()) setBlReceiptHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlReceiptHeader>());
		getBlReceiptHeaders().add(blReceiptHeader);
	}



	/**
	 * Return the value associated with the column: BlPaymentAdviceHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlPaymentAdviceHeader> getBlPaymentAdviceHeaders () {
		return blPaymentAdviceHeaders;
	}

	/**
	 * Set the value related to the column: BlPaymentAdviceHeaders
	 * @param blPaymentAdviceHeaders the BlPaymentAdviceHeaders value
	 */
	public void setBlPaymentAdviceHeaders (java.util.Set<jkt.hms.masters.business.BlPaymentAdviceHeader> blPaymentAdviceHeaders) {
		this.blPaymentAdviceHeaders = blPaymentAdviceHeaders;
	}

	public void addToBlPaymentAdviceHeaders (jkt.hms.masters.business.BlPaymentAdviceHeader blPaymentAdviceHeader) {
		if (null == getBlPaymentAdviceHeaders()) setBlPaymentAdviceHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlPaymentAdviceHeader>());
		getBlPaymentAdviceHeaders().add(blPaymentAdviceHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlChargeSlipMain)) return false;
		else {
			jkt.hms.masters.business.BlChargeSlipMain blChargeSlipMain = (jkt.hms.masters.business.BlChargeSlipMain) obj;
			if (null == this.getId() || null == blChargeSlipMain.getId()) return false;
			else return (this.getId().equals(blChargeSlipMain.getId()));
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