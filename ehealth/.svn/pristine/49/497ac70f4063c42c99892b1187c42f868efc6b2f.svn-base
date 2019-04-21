package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * bl_package_services_details table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_package_services_details"
 */

public abstract class BaseBlPackageServicesDetails implements Serializable {

	public static String REF = "BlPackageServicesDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_DISCOUNT_AMOUNT = "DiscountAmount";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CHARGE_AMOUNT = "ChargeAmount";
	public static String PROP_PKG_DISC_TYPE = "PkgDiscType";
	public static String PROP_NET_CHARGE_AMT = "NetChargeAmt";
	public static String PROP_PKG_DISC_TRF_AMOUNT = "PkgDiscTrfAmount";
	public static String PROP_PKG_DISC_TRF_PERCENT = "PkgDiscTrfPercent";
	public static String PROP_PACKAGE_HEADER = "PackageHeader";
	public static String PROP_DISCOUNT_TYPE = "DiscountType";
	public static String PROP_ID = "Id";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_RATE = "Rate";

	// constructors
	public BaseBlPackageServicesDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPackageServicesDetails(java.lang.Integer id) {
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
	private java.math.BigDecimal chargeAmount;
	private java.lang.String discountType;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal discountAmount;
	private java.math.BigDecimal netChargeAmt;
	private java.lang.String pkgDiscType;
	private java.math.BigDecimal pkgDiscTrfPercent;
	private java.math.BigDecimal pkgDiscTrfAmount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.BlPackageHeader packageHeader;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasChargeCode chargeCode;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="package_services_details_id"
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
	 * Return the value associated with the column: charge_amount
	 */
	public java.math.BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	/**
	 * Set the value related to the column: charge_amount
	 * 
	 * @param chargeAmount
	 *            the charge_amount value
	 */
	public void setChargeAmount(java.math.BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	/**
	 * Return the value associated with the column: discount_type
	 */
	public java.lang.String getDiscountType() {
		return discountType;
	}

	/**
	 * Set the value related to the column: discount_type
	 * 
	 * @param discountType
	 *            the discount_type value
	 */
	public void setDiscountType(java.lang.String discountType) {
		this.discountType = discountType;
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
	 * Return the value associated with the column: discount_amount
	 */
	public java.math.BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * Set the value related to the column: discount_amount
	 * 
	 * @param discountAmount
	 *            the discount_amount value
	 */
	public void setDiscountAmount(java.math.BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	/**
	 * Return the value associated with the column: net_charge_amt
	 */
	public java.math.BigDecimal getNetChargeAmt() {
		return netChargeAmt;
	}

	/**
	 * Set the value related to the column: net_charge_amt
	 * 
	 * @param netChargeAmt
	 *            the net_charge_amt value
	 */
	public void setNetChargeAmt(java.math.BigDecimal netChargeAmt) {
		this.netChargeAmt = netChargeAmt;
	}

	/**
	 * Return the value associated with the column: pkg_disc_type
	 */
	public java.lang.String getPkgDiscType() {
		return pkgDiscType;
	}

	/**
	 * Set the value related to the column: pkg_disc_type
	 * 
	 * @param pkgDiscType
	 *            the pkg_disc_type value
	 */
	public void setPkgDiscType(java.lang.String pkgDiscType) {
		this.pkgDiscType = pkgDiscType;
	}

	/**
	 * Return the value associated with the column: pkg_disc_trf_percent
	 */
	public java.math.BigDecimal getPkgDiscTrfPercent() {
		return pkgDiscTrfPercent;
	}

	/**
	 * Set the value related to the column: pkg_disc_trf_percent
	 * 
	 * @param pkgDiscTrfPercent
	 *            the pkg_disc_trf_percent value
	 */
	public void setPkgDiscTrfPercent(java.math.BigDecimal pkgDiscTrfPercent) {
		this.pkgDiscTrfPercent = pkgDiscTrfPercent;
	}

	/**
	 * Return the value associated with the column: pkg_disc_trf_amount
	 */
	public java.math.BigDecimal getPkgDiscTrfAmount() {
		return pkgDiscTrfAmount;
	}

	/**
	 * Set the value related to the column: pkg_disc_trf_amount
	 * 
	 * @param pkgDiscTrfAmount
	 *            the pkg_disc_trf_amount value
	 */
	public void setPkgDiscTrfAmount(java.math.BigDecimal pkgDiscTrfAmount) {
		this.pkgDiscTrfAmount = pkgDiscTrfAmount;
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
	 * Return the value associated with the column: package_header_id
	 */
	public jkt.hms.masters.business.BlPackageHeader getPackageHeader() {
		return packageHeader;
	}

	/**
	 * Set the value related to the column: package_header_id
	 * 
	 * @param packageHeader
	 *            the package_header_id value
	 */
	public void setPackageHeader(
			jkt.hms.masters.business.BlPackageHeader packageHeader) {
		this.packageHeader = packageHeader;
	}

	/**
	 * Return the value associated with the column: last_chg_by_id
	 */
	public jkt.hms.masters.business.Users getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by_id
	 * 
	 * @param lastChgBy
	 *            the last_chg_by_id value
	 */
	public void setLastChgBy(jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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
		if (!(obj instanceof jkt.hms.masters.business.BlPackageServicesDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.BlPackageServicesDetails blPackageServicesDetails = (jkt.hms.masters.business.BlPackageServicesDetails) obj;
			if (null == this.getId()
					|| null == blPackageServicesDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(blPackageServicesDetails.getId()));
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