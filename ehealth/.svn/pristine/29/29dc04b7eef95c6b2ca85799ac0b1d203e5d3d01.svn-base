package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bud_voucher_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bud_voucher_detail"
 */

public abstract class BaseBudVoucherDetail  implements Serializable {

	public static String REF = "BudVoucherDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SUBVOUCHER_NO = "SubvoucherNo";
	public static String PROP_BUD_VOUCHER_HEADER = "BudVoucherHeader";
	public static String PROP_CHARGE_DESCRIPTION = "ChargeDescription";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseBudVoucherDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudVoucherDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subvoucherNo;
	private java.lang.String chargeDescription;
	private java.math.BigDecimal amount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.BudVoucherHeader budVoucherHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="bud_vocher_detail_id"
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
	 * Return the value associated with the column: subvoucher_no
	 */
	public java.lang.String getSubvoucherNo () {
		return subvoucherNo;
	}

	/**
	 * Set the value related to the column: subvoucher_no
	 * @param subvoucherNo the subvoucher_no value
	 */
	public void setSubvoucherNo (java.lang.String subvoucherNo) {
		this.subvoucherNo = subvoucherNo;
	}



	/**
	 * Return the value associated with the column: charge_description
	 */
	public java.lang.String getChargeDescription () {
		return chargeDescription;
	}

	/**
	 * Set the value related to the column: charge_description
	 * @param chargeDescription the charge_description value
	 */
	public void setChargeDescription (java.lang.String chargeDescription) {
		this.chargeDescription = chargeDescription;
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: bud_voucher_header_id
	 */
	public jkt.hms.masters.business.BudVoucherHeader getBudVoucherHeader () {
		return budVoucherHeader;
	}

	/**
	 * Set the value related to the column: bud_voucher_header_id
	 * @param budVoucherHeader the bud_voucher_header_id value
	 */
	public void setBudVoucherHeader (jkt.hms.masters.business.BudVoucherHeader budVoucherHeader) {
		this.budVoucherHeader = budVoucherHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudVoucherDetail)) return false;
		else {
			jkt.hms.masters.business.BudVoucherDetail budVoucherDetail = (jkt.hms.masters.business.BudVoucherDetail) obj;
			if (null == this.getId() || null == budVoucherDetail.getId()) return false;
			else return (this.getId().equals(budVoucherDetail.getId()));
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