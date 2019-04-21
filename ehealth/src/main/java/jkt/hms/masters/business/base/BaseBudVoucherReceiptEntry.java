package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bud_voucher_receipt_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bud_voucher_receipt_entry"
 */

public abstract class BaseBudVoucherReceiptEntry  implements Serializable {

	public static String REF = "BudVoucherReceiptEntry";
	public static String PROP_FINANCIAL = "Financial";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_MINOR_SUB_HEAD = "MinorSubHead";
	public static String PROP_MINORB_HEAD = "MinorbHead";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OBJECT_HEAD = "ObjectHead";
	public static String PROP_BUDGET_ESTIMATE = "BudgetEstimate";
	public static String PROP_RECEIPT_NO = "ReceiptNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_MAJOR_SUB_HEAD = "MajorSubHead";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RECEIPT_DATE = "ReceiptDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MAJOR_HEAD = "MajorHead";
	public static String PROP_SECTOR_TYPE = "SectorType";


	// constructors
	public BaseBudVoucherReceiptEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudVoucherReceiptEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBudVoucherReceiptEntry (
		java.lang.Integer id,
		jkt.hms.masters.business.BudMajorHead majorHead,
		jkt.hms.masters.business.BudSubMajorHead majorSubHead,
		jkt.hms.masters.business.BudMinorHead minorbHead,
		jkt.hms.masters.business.BudMinorSubHead minorSubHead,
		jkt.hms.masters.business.BudObjectHead objectHead,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.BudEstimateEntry budgetEstimate,
		jkt.hrms.masters.business.HrMasFinancialYear financial) {

		this.setId(id);
		this.setMajorHead(majorHead);
		this.setMajorSubHead(majorSubHead);
		this.setMinorbHead(minorbHead);
		this.setMinorSubHead(minorSubHead);
		this.setObjectHead(objectHead);
		this.setHospital(hospital);
		this.setBudgetEstimate(budgetEstimate);
		this.setFinancial(financial);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String receiptNo;
	private java.util.Date receiptDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String sectorType;
	private java.math.BigDecimal amount;

	// many to one
	private jkt.hms.masters.business.BudMajorHead majorHead;
	private jkt.hms.masters.business.BudSubMajorHead majorSubHead;
	private jkt.hms.masters.business.BudMinorHead minorbHead;
	private jkt.hms.masters.business.BudMinorSubHead minorSubHead;
	private jkt.hms.masters.business.BudObjectHead objectHead;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.BudEstimateEntry budgetEstimate;
	private jkt.hrms.masters.business.HrMasFinancialYear financial;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="bud_receipt_id"
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
	 * Return the value associated with the column: receipt_No
	 */
	public java.lang.String getReceiptNo () {
		return receiptNo;
	}

	/**
	 * Set the value related to the column: receipt_No
	 * @param receiptNo the receipt_No value
	 */
	public void setReceiptNo (java.lang.String receiptNo) {
		this.receiptNo = receiptNo;
	}



	/**
	 * Return the value associated with the column: receipt_date
	 */
	public java.util.Date getReceiptDate () {
		return receiptDate;
	}

	/**
	 * Set the value related to the column: receipt_date
	 * @param receiptDate the receipt_date value
	 */
	public void setReceiptDate (java.util.Date receiptDate) {
		this.receiptDate = receiptDate;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: sector_type
	 */
	public java.lang.String getSectorType () {
		return sectorType;
	}

	/**
	 * Set the value related to the column: sector_type
	 * @param sectorType the sector_type value
	 */
	public void setSectorType (java.lang.String sectorType) {
		this.sectorType = sectorType;
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
	 * Return the value associated with the column: major_head_id
	 */
	public jkt.hms.masters.business.BudMajorHead getMajorHead () {
		return majorHead;
	}

	/**
	 * Set the value related to the column: major_head_id
	 * @param majorHead the major_head_id value
	 */
	public void setMajorHead (jkt.hms.masters.business.BudMajorHead majorHead) {
		this.majorHead = majorHead;
	}



	/**
	 * Return the value associated with the column: major_sub_head_id
	 */
	public jkt.hms.masters.business.BudSubMajorHead getMajorSubHead () {
		return majorSubHead;
	}

	/**
	 * Set the value related to the column: major_sub_head_id
	 * @param majorSubHead the major_sub_head_id value
	 */
	public void setMajorSubHead (jkt.hms.masters.business.BudSubMajorHead majorSubHead) {
		this.majorSubHead = majorSubHead;
	}



	/**
	 * Return the value associated with the column: minor_head_id
	 */
	public jkt.hms.masters.business.BudMinorHead getMinorbHead () {
		return minorbHead;
	}

	/**
	 * Set the value related to the column: minor_head_id
	 * @param minorbHead the minor_head_id value
	 */
	public void setMinorbHead (jkt.hms.masters.business.BudMinorHead minorbHead) {
		this.minorbHead = minorbHead;
	}



	/**
	 * Return the value associated with the column: minor_sub_head_id
	 */
	public jkt.hms.masters.business.BudMinorSubHead getMinorSubHead () {
		return minorSubHead;
	}

	/**
	 * Set the value related to the column: minor_sub_head_id
	 * @param minorSubHead the minor_sub_head_id value
	 */
	public void setMinorSubHead (jkt.hms.masters.business.BudMinorSubHead minorSubHead) {
		this.minorSubHead = minorSubHead;
	}



	/**
	 * Return the value associated with the column: object_head_id
	 */
	public jkt.hms.masters.business.BudObjectHead getObjectHead () {
		return objectHead;
	}

	/**
	 * Set the value related to the column: object_head_id
	 * @param objectHead the object_head_id value
	 */
	public void setObjectHead (jkt.hms.masters.business.BudObjectHead objectHead) {
		this.objectHead = objectHead;
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
	 * Return the value associated with the column: budget_id
	 */
	public jkt.hms.masters.business.BudEstimateEntry getBudgetEstimate () {
		return budgetEstimate;
	}

	/**
	 * Set the value related to the column: budget_id
	 * @param budgetEstimate the budget_id value
	 */
	public void setBudgetEstimate (jkt.hms.masters.business.BudEstimateEntry budgetEstimate) {
		this.budgetEstimate = budgetEstimate;
	}



	/**
	 * Return the value associated with the column: financial_id
	 */
	public jkt.hrms.masters.business.HrMasFinancialYear getFinancial () {
		return financial;
	}

	/**
	 * Set the value related to the column: financial_id
	 * @param financial the financial_id value
	 */
	public void setFinancial (jkt.hrms.masters.business.HrMasFinancialYear financial) {
		this.financial = financial;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudVoucherReceiptEntry)) return false;
		else {
			jkt.hms.masters.business.BudVoucherReceiptEntry budVoucherReceiptEntry = (jkt.hms.masters.business.BudVoucherReceiptEntry) obj;
			if (null == this.getId() || null == budVoucherReceiptEntry.getId()) return false;
			else return (this.getId().equals(budVoucherReceiptEntry.getId()));
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