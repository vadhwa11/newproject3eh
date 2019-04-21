package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_final_bill_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_final_bill_details"
 */

public abstract class BaseBlFinalBillDetails  implements Serializable {

	public static String REF = "BlFinalBillDetails";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_PAID_AMT = "PaidAmt";
	public static String PROP_CHARITY_TYPE = "CharityType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FINAL_BILL_DATE = "FinalBillDate";
	public static String PROP_ADVANCE_TRANSFER = "AdvanceTransfer";
	public static String PROP_FINAL_SETTLEMENT_CHARITY = "FinalSettlementCharity";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GROSS_AMT = "GrossAmt";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_FINAL_BILL_CHARITY = "FinalBillCharity";
	public static String PROP_COMPANY = "Company";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_FINAL_BILL_NO = "FinalBillNo";
	public static String PROP_AUTHORIZER = "Authorizer";
	public static String PROP_SETTLED_AMT = "SettledAmt";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_STATUS = "Status";
	public static String PROP_SERVICE_CHRG_PERCENT = "ServiceChrgPercent";
	public static String PROP_ADV_AMT = "AdvAmt";
	public static String PROP_ROUND_OFF = "RoundOff";
	public static String PROP_ID = "Id";
	public static String PROP_SERVICE_CHRG_AMT = "ServiceChrgAmt";
	public static String PROP_HIN = "Hin";
	public static String PROP_NET_AMT = "NetAmt";


	// constructors
	public BaseBlFinalBillDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlFinalBillDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlFinalBillDetails (
		java.lang.Integer id,
		java.math.BigDecimal advanceTransfer) {

		this.setId(id);
		this.setAdvanceTransfer(advanceTransfer);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String finalBillNo;
	private java.math.BigDecimal paidAmt;
	private java.math.BigDecimal grossAmt;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal netAmt;
	private java.math.BigDecimal serviceChrgPercent;
	private java.math.BigDecimal serviceChrgAmt;
	private java.math.BigDecimal advAmt;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal settledAmt;
	private java.math.BigDecimal roundOff;
	private java.util.Date finalBillDate;
	private java.math.BigDecimal finalBillCharity;
	private java.math.BigDecimal finalSettlementCharity;
	private java.math.BigDecimal advanceTransfer;

	// many to one
	private jkt.hms.masters.business.MasPatientType patientType;
	private jkt.hms.masters.business.MasCompany company;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasCharityType charityType;
	private jkt.hms.masters.business.MasAuthorizer authorizer;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlReceiptHeader> blReceiptHeaders;
	private java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="final_bill_details_id"
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
	 * Return the value associated with the column: final_bill_no
	 */
	public java.lang.String getFinalBillNo () {
		return finalBillNo;
	}

	/**
	 * Set the value related to the column: final_bill_no
	 * @param finalBillNo the final_bill_no value
	 */
	public void setFinalBillNo (java.lang.String finalBillNo) {
		this.finalBillNo = finalBillNo;
	}



	/**
	 * Return the value associated with the column: paid_amt
	 */
	public java.math.BigDecimal getPaidAmt () {
		return paidAmt;
	}

	/**
	 * Set the value related to the column: paid_amt
	 * @param paidAmt the paid_amt value
	 */
	public void setPaidAmt (java.math.BigDecimal paidAmt) {
		this.paidAmt = paidAmt;
	}



	/**
	 * Return the value associated with the column: gross_amt
	 */
	public java.math.BigDecimal getGrossAmt () {
		return grossAmt;
	}

	/**
	 * Set the value related to the column: gross_amt
	 * @param grossAmt the gross_amt value
	 */
	public void setGrossAmt (java.math.BigDecimal grossAmt) {
		this.grossAmt = grossAmt;
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
	 * Return the value associated with the column: service_chrg_percent
	 */
	public java.math.BigDecimal getServiceChrgPercent () {
		return serviceChrgPercent;
	}

	/**
	 * Set the value related to the column: service_chrg_percent
	 * @param serviceChrgPercent the service_chrg_percent value
	 */
	public void setServiceChrgPercent (java.math.BigDecimal serviceChrgPercent) {
		this.serviceChrgPercent = serviceChrgPercent;
	}



	/**
	 * Return the value associated with the column: service_chrg_amt
	 */
	public java.math.BigDecimal getServiceChrgAmt () {
		return serviceChrgAmt;
	}

	/**
	 * Set the value related to the column: service_chrg_amt
	 * @param serviceChrgAmt the service_chrg_amt value
	 */
	public void setServiceChrgAmt (java.math.BigDecimal serviceChrgAmt) {
		this.serviceChrgAmt = serviceChrgAmt;
	}



	/**
	 * Return the value associated with the column: adv_amt
	 */
	public java.math.BigDecimal getAdvAmt () {
		return advAmt;
	}

	/**
	 * Set the value related to the column: adv_amt
	 * @param advAmt the adv_amt value
	 */
	public void setAdvAmt (java.math.BigDecimal advAmt) {
		this.advAmt = advAmt;
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
	 * Return the value associated with the column: settled_amt
	 */
	public java.math.BigDecimal getSettledAmt () {
		return settledAmt;
	}

	/**
	 * Set the value related to the column: settled_amt
	 * @param settledAmt the settled_amt value
	 */
	public void setSettledAmt (java.math.BigDecimal settledAmt) {
		this.settledAmt = settledAmt;
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
	 * Return the value associated with the column: final_bill_date
	 */
	public java.util.Date getFinalBillDate () {
		return finalBillDate;
	}

	/**
	 * Set the value related to the column: final_bill_date
	 * @param finalBillDate the final_bill_date value
	 */
	public void setFinalBillDate (java.util.Date finalBillDate) {
		this.finalBillDate = finalBillDate;
	}



	/**
	 * Return the value associated with the column: final_bill_charity
	 */
	public java.math.BigDecimal getFinalBillCharity () {
		return finalBillCharity;
	}

	/**
	 * Set the value related to the column: final_bill_charity
	 * @param finalBillCharity the final_bill_charity value
	 */
	public void setFinalBillCharity (java.math.BigDecimal finalBillCharity) {
		this.finalBillCharity = finalBillCharity;
	}



	/**
	 * Return the value associated with the column: final_settlement_charity
	 */
	public java.math.BigDecimal getFinalSettlementCharity () {
		return finalSettlementCharity;
	}

	/**
	 * Set the value related to the column: final_settlement_charity
	 * @param finalSettlementCharity the final_settlement_charity value
	 */
	public void setFinalSettlementCharity (java.math.BigDecimal finalSettlementCharity) {
		this.finalSettlementCharity = finalSettlementCharity;
	}



	/**
	 * Return the value associated with the column: advance_transfer
	 */
	public java.math.BigDecimal getAdvanceTransfer () {
		return advanceTransfer;
	}

	/**
	 * Set the value related to the column: advance_transfer
	 * @param advanceTransfer the advance_transfer value
	 */
	public void setAdvanceTransfer (java.math.BigDecimal advanceTransfer) {
		this.advanceTransfer = advanceTransfer;
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
	 * Return the value associated with the column: charity_type_id
	 */
	public jkt.hms.masters.business.MasCharityType getCharityType () {
		return charityType;
	}

	/**
	 * Set the value related to the column: charity_type_id
	 * @param charityType the charity_type_id value
	 */
	public void setCharityType (jkt.hms.masters.business.MasCharityType charityType) {
		this.charityType = charityType;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlFinalBillDetails)) return false;
		else {
			jkt.hms.masters.business.BlFinalBillDetails blFinalBillDetails = (jkt.hms.masters.business.BlFinalBillDetails) obj;
			if (null == this.getId() || null == blFinalBillDetails.getId()) return false;
			else return (this.getId().equals(blFinalBillDetails.getId()));
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