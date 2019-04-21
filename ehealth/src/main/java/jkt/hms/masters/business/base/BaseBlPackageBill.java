package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_package_bill table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_package_bill"
 */

public abstract class BaseBlPackageBill implements Serializable {

	public static String REF = "BlPackageBill";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CONSULTANT = "Consultant";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OUTSTANDING_AMT = "OutstandingAmt";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_PACKAGE = "Package";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_PKG_DISCOUNT_AMT = "PkgDiscountAmt";
	public static String PROP_ADV_ADJUSTMENT_AMT = "AdvAdjustmentAmt";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ROUND_OFF = "RoundOff";
	public static String PROP_PACKAGE_BILL_NO = "PackageBillNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PACKAGE_AMT = "PackageAmt";
	public static String PROP_NET_PKG_AMT = "NetPkgAmt";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlPackageBill() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPackageBill(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String packageBillNo;
	private java.math.BigDecimal packageAmt;
	private java.math.BigDecimal pkgDiscountAmt;
	private java.math.BigDecimal netPkgAmt;
	private java.math.BigDecimal outstandingAmt;
	private java.math.BigDecimal advAdjustmentAmt;
	private java.math.BigDecimal roundOff;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.BlPackageHeader m_package;
	private jkt.hms.masters.business.MasEmployee consultant;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> blChargeSlipMains;
	private java.util.Set<jkt.hms.masters.business.BlReceiptHeader> blReceiptHeaders;
	private java.util.Set<jkt.hms.masters.business.BlDispensingHeader> blDispensingHeaders;
	private java.util.Set<jkt.hms.masters.business.BlOpBillHeader> blOpBillHeaders;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="bl_package_bill_id"
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
	 * Return the value associated with the column: package_bill_no
	 */
	public java.lang.String getPackageBillNo() {
		return packageBillNo;
	}

	/**
	 * Set the value related to the column: package_bill_no
	 * 
	 * @param packageBillNo
	 *            the package_bill_no value
	 */
	public void setPackageBillNo(java.lang.String packageBillNo) {
		this.packageBillNo = packageBillNo;
	}

	/**
	 * Return the value associated with the column: package_amt
	 */
	public java.math.BigDecimal getPackageAmt() {
		return packageAmt;
	}

	/**
	 * Set the value related to the column: package_amt
	 * 
	 * @param packageAmt
	 *            the package_amt value
	 */
	public void setPackageAmt(java.math.BigDecimal packageAmt) {
		this.packageAmt = packageAmt;
	}

	/**
	 * Return the value associated with the column: pkg_discount_amt
	 */
	public java.math.BigDecimal getPkgDiscountAmt() {
		return pkgDiscountAmt;
	}

	/**
	 * Set the value related to the column: pkg_discount_amt
	 * 
	 * @param pkgDiscountAmt
	 *            the pkg_discount_amt value
	 */
	public void setPkgDiscountAmt(java.math.BigDecimal pkgDiscountAmt) {
		this.pkgDiscountAmt = pkgDiscountAmt;
	}

	/**
	 * Return the value associated with the column: net_pkg_amt
	 */
	public java.math.BigDecimal getNetPkgAmt() {
		return netPkgAmt;
	}

	/**
	 * Set the value related to the column: net_pkg_amt
	 * 
	 * @param netPkgAmt
	 *            the net_pkg_amt value
	 */
	public void setNetPkgAmt(java.math.BigDecimal netPkgAmt) {
		this.netPkgAmt = netPkgAmt;
	}

	/**
	 * Return the value associated with the column: outstanding_amt
	 */
	public java.math.BigDecimal getOutstandingAmt() {
		return outstandingAmt;
	}

	/**
	 * Set the value related to the column: outstanding_amt
	 * 
	 * @param outstandingAmt
	 *            the outstanding_amt value
	 */
	public void setOutstandingAmt(java.math.BigDecimal outstandingAmt) {
		this.outstandingAmt = outstandingAmt;
	}

	/**
	 * Return the value associated with the column: adv_adjustment_amt
	 */
	public java.math.BigDecimal getAdvAdjustmentAmt() {
		return advAdjustmentAmt;
	}

	/**
	 * Set the value related to the column: adv_adjustment_amt
	 * 
	 * @param advAdjustmentAmt
	 *            the adv_adjustment_amt value
	 */
	public void setAdvAdjustmentAmt(java.math.BigDecimal advAdjustmentAmt) {
		this.advAdjustmentAmt = advAdjustmentAmt;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: package_id
	 */
	public jkt.hms.masters.business.BlPackageHeader getPackage() {
		return m_package;
	}

	/**
	 * Set the value related to the column: package_id
	 * 
	 * @param m_package
	 *            the package_id value
	 */
	public void setPackage(jkt.hms.masters.business.BlPackageHeader m_package) {
		this.m_package = m_package;
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
	 * Return the value associated with the column: BlChargeSlipMains
	 */
	public java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> getBlChargeSlipMains() {
		return blChargeSlipMains;
	}

	/**
	 * Set the value related to the column: BlChargeSlipMains
	 * 
	 * @param blChargeSlipMains
	 *            the BlChargeSlipMains value
	 */
	public void setBlChargeSlipMains(
			java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> blChargeSlipMains) {
		this.blChargeSlipMains = blChargeSlipMains;
	}

	public void addToBlChargeSlipMains(
			jkt.hms.masters.business.BlChargeSlipMain blChargeSlipMain) {
		if (null == getBlChargeSlipMains()) {
			setBlChargeSlipMains(new java.util.TreeSet<jkt.hms.masters.business.BlChargeSlipMain>());
		}
		getBlChargeSlipMains().add(blChargeSlipMain);
	}

	/**
	 * Return the value associated with the column: BlReceiptHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlReceiptHeader> getBlReceiptHeaders() {
		return blReceiptHeaders;
	}

	/**
	 * Set the value related to the column: BlReceiptHeaders
	 * 
	 * @param blReceiptHeaders
	 *            the BlReceiptHeaders value
	 */
	public void setBlReceiptHeaders(
			java.util.Set<jkt.hms.masters.business.BlReceiptHeader> blReceiptHeaders) {
		this.blReceiptHeaders = blReceiptHeaders;
	}

	public void addToBlReceiptHeaders(
			jkt.hms.masters.business.BlReceiptHeader blReceiptHeader) {
		if (null == getBlReceiptHeaders()) {
			setBlReceiptHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlReceiptHeader>());
		}
		getBlReceiptHeaders().add(blReceiptHeader);
	}

	/**
	 * Return the value associated with the column: BlDispensingHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlDispensingHeader> getBlDispensingHeaders() {
		return blDispensingHeaders;
	}

	/**
	 * Set the value related to the column: BlDispensingHeaders
	 * 
	 * @param blDispensingHeaders
	 *            the BlDispensingHeaders value
	 */
	public void setBlDispensingHeaders(
			java.util.Set<jkt.hms.masters.business.BlDispensingHeader> blDispensingHeaders) {
		this.blDispensingHeaders = blDispensingHeaders;
	}

	public void addToBlDispensingHeaders(
			jkt.hms.masters.business.BlDispensingHeader blDispensingHeader) {
		if (null == getBlDispensingHeaders()) {
			setBlDispensingHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlDispensingHeader>());
		}
		getBlDispensingHeaders().add(blDispensingHeader);
	}

	/**
	 * Return the value associated with the column: BlOpBillHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlOpBillHeader> getBlOpBillHeaders() {
		return blOpBillHeaders;
	}

	/**
	 * Set the value related to the column: BlOpBillHeaders
	 * 
	 * @param blOpBillHeaders
	 *            the BlOpBillHeaders value
	 */
	public void setBlOpBillHeaders(
			java.util.Set<jkt.hms.masters.business.BlOpBillHeader> blOpBillHeaders) {
		this.blOpBillHeaders = blOpBillHeaders;
	}

	public void addToBlOpBillHeaders(
			jkt.hms.masters.business.BlOpBillHeader blOpBillHeader) {
		if (null == getBlOpBillHeaders()) {
			setBlOpBillHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlOpBillHeader>());
		}
		getBlOpBillHeaders().add(blOpBillHeader);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlPackageBill)) {
			return false;
		} else {
			jkt.hms.masters.business.BlPackageBill blPackageBill = (jkt.hms.masters.business.BlPackageBill) obj;
			if (null == this.getId() || null == blPackageBill.getId()) {
				return false;
			} else {
				return (this.getId().equals(blPackageBill.getId()));
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