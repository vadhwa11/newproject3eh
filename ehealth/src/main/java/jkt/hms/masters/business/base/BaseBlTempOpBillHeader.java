package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_temp_op_bill_header
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_temp_op_bill_header"
 */

public abstract class BaseBlTempOpBillHeader implements Serializable {

	public static String REF = "BlTempOpBillHeader";
	public static String PROP_CHARITY = "Charity";
	public static String PROP_CONSULTANT = "Consultant";
	public static String PROP_PAYABLE_AMT = "PayableAmt";
	public static String PROP_DISCOUNT_AMT = "DiscountAmt";
	public static String PROP_TEMP_BILL_TIME = "TempBillTime";
	public static String PROP_BILL_AMT = "BillAmt";
	public static String PROP_ADVANCE_ADJUSTMENT = "AdvanceAdjustment";
	public static String PROP_HIN = "Hin";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_AUTHORIZER = "Authorizer";
	public static String PROP_VISIT = "Visit";
	public static String PROP_BILL_STATUS = "BillStatus";
	public static String PROP_TEMP_BILL_NO = "TempBillNo";
	public static String PROP_DISCOUNT_ON_BILL = "DiscountOnBill";
	public static String PROP_ROUND_OFF = "RoundOff";
	public static String PROP_BILL_TYPE = "BillType";
	public static String PROP_NET_AMT = "NetAmt";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_OUTSTANDING = "Outstanding";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_TEMP_BILL_DATE = "TempBillDate";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlTempOpBillHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlTempOpBillHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tempBillNo;
	private java.math.BigDecimal billAmt;
	private java.math.BigDecimal discountAmt;
	private java.math.BigDecimal outstanding;
	private java.math.BigDecimal roundOff;
	private java.math.BigDecimal discountOnBill;
	private java.math.BigDecimal netAmt;
	private java.util.Date tempBillDate;
	private java.lang.String tempBillTime;
	private java.math.BigDecimal advanceAdjustment;
	private java.math.BigDecimal payableAmt;
	private java.lang.String billStatus;
	private java.lang.String billType;
	private java.math.BigDecimal discount;
	private java.math.BigDecimal charity;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasAuthorizer authorizer;
	private jkt.hms.masters.business.MasEmployee consultant;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlTempOpBillDetails> blTempOpBillDetails;
	private java.util.Set<jkt.hms.masters.business.BlTempBillDispensingDetails> blTempBillDispensingDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="temp_op_bill_header_id"
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
	 * Return the value associated with the column: temp_bill_no
	 */
	public java.lang.String getTempBillNo() {
		return tempBillNo;
	}

	/**
	 * Set the value related to the column: temp_bill_no
	 * 
	 * @param tempBillNo
	 *            the temp_bill_no value
	 */
	public void setTempBillNo(java.lang.String tempBillNo) {
		this.tempBillNo = tempBillNo;
	}

	/**
	 * Return the value associated with the column: bill_amt
	 */
	public java.math.BigDecimal getBillAmt() {
		return billAmt;
	}

	/**
	 * Set the value related to the column: bill_amt
	 * 
	 * @param billAmt
	 *            the bill_amt value
	 */
	public void setBillAmt(java.math.BigDecimal billAmt) {
		this.billAmt = billAmt;
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
	 * Return the value associated with the column: outstanding
	 */
	public java.math.BigDecimal getOutstanding() {
		return outstanding;
	}

	/**
	 * Set the value related to the column: outstanding
	 * 
	 * @param outstanding
	 *            the outstanding value
	 */
	public void setOutstanding(java.math.BigDecimal outstanding) {
		this.outstanding = outstanding;
	}

	/**
	 * Return the value associated with the column: round_off
	 */
	public java.math.BigDecimal getRoundOff() {
		return roundOff;
	}

	/**
	 * Set the value related to the column: round_off
	 * 
	 * @param roundOff
	 *            the round_off value
	 */
	public void setRoundOff(java.math.BigDecimal roundOff) {
		this.roundOff = roundOff;
	}

	/**
	 * Return the value associated with the column: discount_on_bill
	 */
	public java.math.BigDecimal getDiscountOnBill() {
		return discountOnBill;
	}

	/**
	 * Set the value related to the column: discount_on_bill
	 * 
	 * @param discountOnBill
	 *            the discount_on_bill value
	 */
	public void setDiscountOnBill(java.math.BigDecimal discountOnBill) {
		this.discountOnBill = discountOnBill;
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
	 * Return the value associated with the column: advance_adjustment
	 */
	public java.math.BigDecimal getAdvanceAdjustment() {
		return advanceAdjustment;
	}

	/**
	 * Set the value related to the column: advance_adjustment
	 * 
	 * @param advanceAdjustment
	 *            the advance_adjustment value
	 */
	public void setAdvanceAdjustment(java.math.BigDecimal advanceAdjustment) {
		this.advanceAdjustment = advanceAdjustment;
	}

	/**
	 * Return the value associated with the column: payable_amt
	 */
	public java.math.BigDecimal getPayableAmt() {
		return payableAmt;
	}

	/**
	 * Set the value related to the column: payable_amt
	 * 
	 * @param payableAmt
	 *            the payable_amt value
	 */
	public void setPayableAmt(java.math.BigDecimal payableAmt) {
		this.payableAmt = payableAmt;
	}

	/**
	 * Return the value associated with the column: bill_status
	 */
	public java.lang.String getBillStatus() {
		return billStatus;
	}

	/**
	 * Set the value related to the column: bill_status
	 * 
	 * @param billStatus
	 *            the bill_status value
	 */
	public void setBillStatus(java.lang.String billStatus) {
		this.billStatus = billStatus;
	}

	/**
	 * Return the value associated with the column: bill_type
	 */
	public java.lang.String getBillType() {
		return billType;
	}

	/**
	 * Set the value related to the column: bill_type
	 * 
	 * @param billType
	 *            the bill_type value
	 */
	public void setBillType(java.lang.String billType) {
		this.billType = billType;
	}

	/**
	 * Return the value associated with the column: discount
	 */
	public java.math.BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * 
	 * @param discount
	 *            the discount value
	 */
	public void setDiscount(java.math.BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * Return the value associated with the column: charity
	 */
	public java.math.BigDecimal getCharity() {
		return charity;
	}

	/**
	 * Set the value related to the column: charity
	 * 
	 * @param charity
	 *            the charity value
	 */
	public void setCharity(java.math.BigDecimal charity) {
		this.charity = charity;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visit
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}

	/**
	 * Return the value associated with the column: authorizer_id
	 */
	public jkt.hms.masters.business.MasAuthorizer getAuthorizer() {
		return authorizer;
	}

	/**
	 * Set the value related to the column: authorizer_id
	 * 
	 * @param authorizer
	 *            the authorizer_id value
	 */
	public void setAuthorizer(jkt.hms.masters.business.MasAuthorizer authorizer) {
		this.authorizer = authorizer;
	}

	/**
	 * Return the value associated with the column: consultant_id
	 */
	public jkt.hms.masters.business.MasEmployee getConsultant() {
		return consultant;
	}

	/**
	 * Set the value related to the column: consultant_id
	 * 
	 * @param consultant
	 *            the consultant_id value
	 */
	public void setConsultant(jkt.hms.masters.business.MasEmployee consultant) {
		this.consultant = consultant;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	/**
	 * Return the value associated with the column: BlTempOpBillDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlTempOpBillDetails> getBlTempOpBillDetails() {
		return blTempOpBillDetails;
	}

	/**
	 * Set the value related to the column: BlTempOpBillDetails
	 * 
	 * @param blTempOpBillDetails
	 *            the BlTempOpBillDetails value
	 */
	public void setBlTempOpBillDetails(
			java.util.Set<jkt.hms.masters.business.BlTempOpBillDetails> blTempOpBillDetails) {
		this.blTempOpBillDetails = blTempOpBillDetails;
	}

	public void addToBlTempOpBillDetails(
			jkt.hms.masters.business.BlTempOpBillDetails blTempOpBillDetails) {
		if (null == getBlTempOpBillDetails()) {
			setBlTempOpBillDetails(new java.util.TreeSet<jkt.hms.masters.business.BlTempOpBillDetails>());
		}
		getBlTempOpBillDetails().add(blTempOpBillDetails);
	}

	/**
	 * Return the value associated with the column: BlTempBillDispensingDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlTempBillDispensingDetails> getBlTempBillDispensingDetails() {
		return blTempBillDispensingDetails;
	}

	/**
	 * Set the value related to the column: BlTempBillDispensingDetails
	 * 
	 * @param blTempBillDispensingDetails
	 *            the BlTempBillDispensingDetails value
	 */
	public void setBlTempBillDispensingDetails(
			java.util.Set<jkt.hms.masters.business.BlTempBillDispensingDetails> blTempBillDispensingDetails) {
		this.blTempBillDispensingDetails = blTempBillDispensingDetails;
	}

	public void addToBlTempBillDispensingDetails(
			jkt.hms.masters.business.BlTempBillDispensingDetails blTempBillDispensingDetails) {
		if (null == getBlTempBillDispensingDetails()) {
			setBlTempBillDispensingDetails(new java.util.TreeSet<jkt.hms.masters.business.BlTempBillDispensingDetails>());
		}
		getBlTempBillDispensingDetails().add(blTempBillDispensingDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlTempOpBillHeader)) {
			return false;
		} else {
			jkt.hms.masters.business.BlTempOpBillHeader blTempOpBillHeader = (jkt.hms.masters.business.BlTempOpBillHeader) obj;
			if (null == this.getId() || null == blTempOpBillHeader.getId()) {
				return false;
			} else {
				return (this.getId().equals(blTempOpBillHeader.getId()));
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