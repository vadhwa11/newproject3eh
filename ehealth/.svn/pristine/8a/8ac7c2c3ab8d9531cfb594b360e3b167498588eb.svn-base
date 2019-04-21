package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_op_patient_issue_t
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_op_patient_issue_t"
 */

public abstract class BaseStoreOpPatientIssueT implements Serializable {

	public static String REF = "StoreOpPatientIssueT";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_BRAND = "Brand";
	public static String PROP_ITEM_ID_REQUIRE = "ItemIdRequire";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_OP_ISSUE = "OpIssue";
	public static String PROP_ITEM_ID_ISSUE = "ItemIdIssue";
	public static String PROP_ID = "Id";
	public static String PROP_TAX = "Tax";
	public static String PROP_RATE = "Rate";

	// constructors
	public BaseStoreOpPatientIssueT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreOpPatientIssueT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreOpPatientIssueT(java.lang.Integer id,
			jkt.hms.masters.business.MasStoreItem itemIdRequire,
			jkt.hms.masters.business.MasStoreItem itemIdIssue,
			jkt.hms.masters.business.StoreOpPatientIssueM opIssue,
			jkt.hms.masters.business.MasStoreBrand brand,
			java.lang.String batchNo, java.util.Date expiryDate,
			java.math.BigDecimal qtyIssued) {

		this.setId(id);
		this.setItemIdRequire(itemIdRequire);
		this.setItemIdIssue(itemIdIssue);
		this.setOpIssue(opIssue);
		this.setBrand(brand);
		this.setBatchNo(batchNo);
		this.setExpiryDate(expiryDate);
		this.setQtyIssued(qtyIssued);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String batchNo;
	private java.util.Date expiryDate;
	private java.math.BigDecimal qtyIssued;
	private java.math.BigDecimal rate;
	private java.math.BigDecimal tax;
	private java.math.BigDecimal amount;

	// many to one
	private jkt.hms.masters.business.MasStoreItem itemIdRequire;
	private jkt.hms.masters.business.MasStoreItem itemIdIssue;
	private jkt.hms.masters.business.StoreOpPatientIssueM opIssue;
	private jkt.hms.masters.business.MasStoreBrand brand;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo() {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * 
	 * @param batchNo
	 *            the batch_no value
	 */
	public void setBatchNo(java.lang.String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * 
	 * @param expiryDate
	 *            the expiry_date value
	 */
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * Return the value associated with the column: qty_issued
	 */
	public java.math.BigDecimal getQtyIssued() {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * 
	 * @param qtyIssued
	 *            the qty_issued value
	 */
	public void setQtyIssued(java.math.BigDecimal qtyIssued) {
		this.qtyIssued = qtyIssued;
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
	 * Return the value associated with the column: tax
	 */
	public java.math.BigDecimal getTax() {
		return tax;
	}

	/**
	 * Set the value related to the column: tax
	 * 
	 * @param tax
	 *            the tax value
	 */
	public void setTax(java.math.BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * 
	 * @param amount
	 *            the amount value
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Return the value associated with the column: item_id_require
	 */
	public jkt.hms.masters.business.MasStoreItem getItemIdRequire() {
		return itemIdRequire;
	}

	/**
	 * Set the value related to the column: item_id_require
	 * 
	 * @param itemIdRequire
	 *            the item_id_require value
	 */
	public void setItemIdRequire(
			jkt.hms.masters.business.MasStoreItem itemIdRequire) {
		this.itemIdRequire = itemIdRequire;
	}

	/**
	 * Return the value associated with the column: item_id_issue
	 */
	public jkt.hms.masters.business.MasStoreItem getItemIdIssue() {
		return itemIdIssue;
	}

	/**
	 * Set the value related to the column: item_id_issue
	 * 
	 * @param itemIdIssue
	 *            the item_id_issue value
	 */
	public void setItemIdIssue(jkt.hms.masters.business.MasStoreItem itemIdIssue) {
		this.itemIdIssue = itemIdIssue;
	}

	/**
	 * Return the value associated with the column: op_issue_id
	 */
	public jkt.hms.masters.business.StoreOpPatientIssueM getOpIssue() {
		return opIssue;
	}

	/**
	 * Set the value related to the column: op_issue_id
	 * 
	 * @param opIssue
	 *            the op_issue_id value
	 */
	public void setOpIssue(jkt.hms.masters.business.StoreOpPatientIssueM opIssue) {
		this.opIssue = opIssue;
	}

	/**
	 * Return the value associated with the column: brand_id
	 */
	public jkt.hms.masters.business.MasStoreBrand getBrand() {
		return brand;
	}

	/**
	 * Set the value related to the column: brand_id
	 * 
	 * @param brand
	 *            the brand_id value
	 */
	public void setBrand(jkt.hms.masters.business.MasStoreBrand brand) {
		this.brand = brand;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.StoreOpPatientIssueT)) {
			return false;
		} else {
			jkt.hms.masters.business.StoreOpPatientIssueT storeOpPatientIssueT = (jkt.hms.masters.business.StoreOpPatientIssueT) obj;
			if (null == this.getId() || null == storeOpPatientIssueT.getId()) {
				return false;
			} else {
				return (this.getId().equals(storeOpPatientIssueT.getId()));
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