package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_dispensing_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_dispensing_header"
 */

public abstract class BaseBlDispensingHeader  implements Serializable {

	public static String REF = "BlDispensingHeader";
	public static String PROP_ACTUAL_COLLECTED_AMT = "ActualCollectedAmt";
	public static String PROP_AGE = "Age";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_IP_FINAL_BILL = "IpFinalBill";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_BILL_TIME = "BillTime";
	public static String PROP_CONSULTANT_NAME = "ConsultantName";
	public static String PROP_BILL_AMT = "BillAmt";
	public static String PROP_ADV_ADJUSTMENT = "AdvAdjustment";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_PAYABLE_AMT = "PayableAmt";
	public static String PROP_PACKAGE_BILL = "PackageBill";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_COMPANY = "Company";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SEX = "Sex";
	public static String PROP_OUTSTANDING = "Outstanding";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_CHARITY = "Charity";
	public static String PROP_AUTHORIZER = "Authorizer";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_DISCOUNT_ON_BILL = "DiscountOnBill";
	public static String PROP_STATUS = "Status";
	public static String PROP_PATIENT_STATUS = "PatientStatus";
	public static String PROP_ROUND_OFF = "RoundOff";
	public static String PROP_CONSULTANT = "Consultant";
	public static String PROP_ID = "Id";
	public static String PROP_BILL_DATE = "BillDate";
	public static String PROP_HIN = "Hin";
	public static String PROP_NET_AMT = "NetAmt";
	public static String PROP_VOUCHER_NO = "VoucherNo";


	// constructors
	public BaseBlDispensingHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlDispensingHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patientName;
	private java.lang.String age;
	private java.lang.String hinNo;
	private java.lang.String adNo;
	private java.lang.String consultantName;
	private java.lang.String billNo;
	private java.math.BigDecimal billAmt;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal outstanding;
	private java.math.BigDecimal roundOff;
	private java.math.BigDecimal discountOnBill;
	private java.math.BigDecimal netAmt;
	private java.math.BigDecimal advAdjustment;
	private java.math.BigDecimal payableAmt;
	private java.util.Date billDate;
	private java.lang.String billTime;
	private java.lang.String patientStatus;
	private java.lang.String status;
	private java.math.BigDecimal actualCollectedAmt;
	private java.math.BigDecimal discount;
	private java.math.BigDecimal charity;
	private java.lang.String voucherNo;
	public java.lang.String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(java.lang.String voucherNo) {
		this.voucherNo = voucherNo;
	}



	// many to one
	private jkt.hms.masters.business.MasPatientType patientType;
	private jkt.hms.masters.business.MasCompany company;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.BlPackageBill packageBill;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.BlFinalBillDetails ipFinalBill;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee consultant;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasAuthorizer authorizer;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlDispensingDetails> blDispensingDetails;
	private java.util.Set<jkt.hms.masters.business.BlReceiptHeader> blReceiptHeaders;
	private java.util.Set<jkt.hms.masters.business.FaVoucherHeader> faVoucherHeaders;
	private java.util.Set<jkt.hms.masters.business.BlPymntAdviceDispHeader> blPymntAdviceDispHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="dispensing_header_id"
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
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * @param patientName the patient_name value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: hin_no
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: hin_no
	 * @param hinNo the hin_no value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: consultant_name
	 */
	public java.lang.String getConsultantName () {
		return consultantName;
	}

	/**
	 * Set the value related to the column: consultant_name
	 * @param consultantName the consultant_name value
	 */
	public void setConsultantName (java.lang.String consultantName) {
		this.consultantName = consultantName;
	}



	/**
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.String getBillNo () {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * @param billNo the bill_no value
	 */
	public void setBillNo (java.lang.String billNo) {
		this.billNo = billNo;
	}



	/**
	 * Return the value associated with the column: bill_amt
	 */
	public java.math.BigDecimal getBillAmt () {
		return billAmt;
	}

	/**
	 * Set the value related to the column: bill_amt
	 * @param billAmt the bill_amt value
	 */
	public void setBillAmt (java.math.BigDecimal billAmt) {
		this.billAmt = billAmt;
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
	 * Return the value associated with the column: outstanding
	 */
	public java.math.BigDecimal getOutstanding () {
		return outstanding;
	}

	/**
	 * Set the value related to the column: outstanding
	 * @param outstanding the outstanding value
	 */
	public void setOutstanding (java.math.BigDecimal outstanding) {
		this.outstanding = outstanding;
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
	 * Return the value associated with the column: discount_on_bill
	 */
	public java.math.BigDecimal getDiscountOnBill () {
		return discountOnBill;
	}

	/**
	 * Set the value related to the column: discount_on_bill
	 * @param discountOnBill the discount_on_bill value
	 */
	public void setDiscountOnBill (java.math.BigDecimal discountOnBill) {
		this.discountOnBill = discountOnBill;
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
	 * Return the value associated with the column: adv_adjustment
	 */
	public java.math.BigDecimal getAdvAdjustment () {
		return advAdjustment;
	}

	/**
	 * Set the value related to the column: adv_adjustment
	 * @param advAdjustment the adv_adjustment value
	 */
	public void setAdvAdjustment (java.math.BigDecimal advAdjustment) {
		this.advAdjustment = advAdjustment;
	}



	/**
	 * Return the value associated with the column: payable_amt
	 */
	public java.math.BigDecimal getPayableAmt () {
		return payableAmt;
	}

	/**
	 * Set the value related to the column: payable_amt
	 * @param payableAmt the payable_amt value
	 */
	public void setPayableAmt (java.math.BigDecimal payableAmt) {
		this.payableAmt = payableAmt;
	}



	/**
	 * Return the value associated with the column: bill_date
	 */
	public java.util.Date getBillDate () {
		return billDate;
	}

	/**
	 * Set the value related to the column: bill_date
	 * @param billDate the bill_date value
	 */
	public void setBillDate (java.util.Date billDate) {
		this.billDate = billDate;
	}



	/**
	 * Return the value associated with the column: bill_time
	 */
	public java.lang.String getBillTime () {
		return billTime;
	}

	/**
	 * Set the value related to the column: bill_time
	 * @param billTime the bill_time value
	 */
	public void setBillTime (java.lang.String billTime) {
		this.billTime = billTime;
	}



	/**
	 * Return the value associated with the column: patient_status
	 */
	public java.lang.String getPatientStatus () {
		return patientStatus;
	}

	/**
	 * Set the value related to the column: patient_status
	 * @param patientStatus the patient_status value
	 */
	public void setPatientStatus (java.lang.String patientStatus) {
		this.patientStatus = patientStatus;
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
	 * Return the value associated with the column: actual_collected_amt
	 */
	public java.math.BigDecimal getActualCollectedAmt () {
		return actualCollectedAmt;
	}

	/**
	 * Set the value related to the column: actual_collected_amt
	 * @param actualCollectedAmt the actual_collected_amt value
	 */
	public void setActualCollectedAmt (java.math.BigDecimal actualCollectedAmt) {
		this.actualCollectedAmt = actualCollectedAmt;
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
	 * Return the value associated with the column: changed_by
	 */
	public jkt.hms.masters.business.Users getChangedBy () {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * @param changedBy the changed_by value
	 */
	public void setChangedBy (jkt.hms.masters.business.Users changedBy) {
		this.changedBy = changedBy;
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
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sex the sex_id value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: ip_final_bill_id
	 */
	public jkt.hms.masters.business.BlFinalBillDetails getIpFinalBill () {
		return ipFinalBill;
	}

	/**
	 * Set the value related to the column: ip_final_bill_id
	 * @param ipFinalBill the ip_final_bill_id value
	 */
	public void setIpFinalBill (jkt.hms.masters.business.BlFinalBillDetails ipFinalBill) {
		this.ipFinalBill = ipFinalBill;
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
	 * Return the value associated with the column: BlDispensingDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlDispensingDetails> getBlDispensingDetails () {
		return blDispensingDetails;
	}

	/**
	 * Set the value related to the column: BlDispensingDetails
	 * @param blDispensingDetails the BlDispensingDetails value
	 */
	public void setBlDispensingDetails (java.util.Set<jkt.hms.masters.business.BlDispensingDetails> blDispensingDetails) {
		this.blDispensingDetails = blDispensingDetails;
	}

	public void addToBlDispensingDetails (jkt.hms.masters.business.BlDispensingDetails blDispensingDetails) {
		if (null == getBlDispensingDetails()) setBlDispensingDetails(new java.util.TreeSet<jkt.hms.masters.business.BlDispensingDetails>());
		getBlDispensingDetails().add(blDispensingDetails);
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
	 * Return the value associated with the column: FaVoucherHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.FaVoucherHeader> getFaVoucherHeaders () {
		return faVoucherHeaders;
	}

	/**
	 * Set the value related to the column: FaVoucherHeaders
	 * @param faVoucherHeaders the FaVoucherHeaders value
	 */
	public void setFaVoucherHeaders (java.util.Set<jkt.hms.masters.business.FaVoucherHeader> faVoucherHeaders) {
		this.faVoucherHeaders = faVoucherHeaders;
	}

	public void addToFaVoucherHeaders (jkt.hms.masters.business.FaVoucherHeader faVoucherHeader) {
		if (null == getFaVoucherHeaders()) setFaVoucherHeaders(new java.util.TreeSet<jkt.hms.masters.business.FaVoucherHeader>());
		getFaVoucherHeaders().add(faVoucherHeader);
	}



	/**
	 * Return the value associated with the column: BlPymntAdviceDispHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlPymntAdviceDispHeader> getBlPymntAdviceDispHeaders () {
		return blPymntAdviceDispHeaders;
	}

	/**
	 * Set the value related to the column: BlPymntAdviceDispHeaders
	 * @param blPymntAdviceDispHeaders the BlPymntAdviceDispHeaders value
	 */
	public void setBlPymntAdviceDispHeaders (java.util.Set<jkt.hms.masters.business.BlPymntAdviceDispHeader> blPymntAdviceDispHeaders) {
		this.blPymntAdviceDispHeaders = blPymntAdviceDispHeaders;
	}

	public void addToBlPymntAdviceDispHeaders (jkt.hms.masters.business.BlPymntAdviceDispHeader blPymntAdviceDispHeader) {
		if (null == getBlPymntAdviceDispHeaders()) setBlPymntAdviceDispHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlPymntAdviceDispHeader>());
		getBlPymntAdviceDispHeaders().add(blPymntAdviceDispHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlDispensingHeader)) return false;
		else {
			jkt.hms.masters.business.BlDispensingHeader blDispensingHeader = (jkt.hms.masters.business.BlDispensingHeader) obj;
			if (null == this.getId() || null == blDispensingHeader.getId()) return false;
			else return (this.getId().equals(blDispensingHeader.getId()));
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