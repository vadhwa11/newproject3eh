package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * bl_package_medicine_details table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_package_medicine_details"
 */

public abstract class BaseBlPackageMedicineDetails implements Serializable {

	public static String REF = "BlPackageMedicineDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_ITEM_AMOUNT = "ItemAmount";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_DISCOUNT_AMOUNT = "DiscountAmount";
	public static String PROP_ITEM = "Item";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PKG_DISC_TYPE = "PkgDiscType";
	public static String PROP_NET_ITEM_AMT = "NetItemAmt";
	public static String PROP_PKG_DISC_TRF_AMOUNT = "PkgDiscTrfAmount";
	public static String PROP_PKG_DISC_TRF_PERCENT = "PkgDiscTrfPercent";
	public static String PROP_DISPENSING_PRICE = "DispensingPrice";
	public static String PROP_PACKAGE_HEADER = "PackageHeader";
	public static String PROP_DISCOUNT_TYPE = "DiscountType";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_QUANTITY = "Quantity";

	// constructors
	public BaseBlPackageMedicineDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPackageMedicineDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal quantity;
	private java.math.BigDecimal dispensingPrice;
	private java.math.BigDecimal itemAmount;
	private java.lang.String discountType;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal discountAmount;
	private java.math.BigDecimal netItemAmt;
	private java.lang.String pkgDiscType;
	private java.math.BigDecimal pkgDiscTrfPercent;
	private java.math.BigDecimal pkgDiscTrfAmount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.BlPackageHeader packageHeader;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="package_medicine_details_id"
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
	public java.math.BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * 
	 * @param quantity
	 *            the quantity value
	 */
	public void setQuantity(java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * Return the value associated with the column: dispensing_price
	 */
	public java.math.BigDecimal getDispensingPrice() {
		return dispensingPrice;
	}

	/**
	 * Set the value related to the column: dispensing_price
	 * 
	 * @param dispensingPrice
	 *            the dispensing_price value
	 */
	public void setDispensingPrice(java.math.BigDecimal dispensingPrice) {
		this.dispensingPrice = dispensingPrice;
	}

	/**
	 * Return the value associated with the column: item_amount
	 */
	public java.math.BigDecimal getItemAmount() {
		return itemAmount;
	}

	/**
	 * Set the value related to the column: item_amount
	 * 
	 * @param itemAmount
	 *            the item_amount value
	 */
	public void setItemAmount(java.math.BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
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
	 * Return the value associated with the column: net_item_amt
	 */
	public java.math.BigDecimal getNetItemAmt() {
		return netItemAmt;
	}

	/**
	 * Set the value related to the column: net_item_amt
	 * 
	 * @param netItemAmt
	 *            the net_item_amt value
	 */
	public void setNetItemAmt(java.math.BigDecimal netItemAmt) {
		this.netItemAmt = netItemAmt;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlPackageMedicineDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.BlPackageMedicineDetails blPackageMedicineDetails = (jkt.hms.masters.business.BlPackageMedicineDetails) obj;
			if (null == this.getId()
					|| null == blPackageMedicineDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(blPackageMedicineDetails.getId()));
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