package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * bl_company_settlement_details table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_company_settlement_details"
 */

public abstract class BaseBlCompanySettlementDetails implements Serializable {

	public static String REF = "BlCompanySettlementDetails";
	public static String PROP_OP_BILL_HEADER = "OpBillHeader";
	public static String PROP_DISPENSING_HEADER = "DispensingHeader";
	public static String PROP_IP_FINAL_BILL_DETAILS = "IpFinalBillDetails";
	public static String PROP_SETTLED_AMOUNT = "SettledAmount";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY_SETTLEMENT_HEADER = "CompanySettlementHeader";

	// constructors
	public BaseBlCompanySettlementDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlCompanySettlementDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal settledAmount;

	// many to one
	private jkt.hms.masters.business.BlOpBillHeader opBillHeader;
	private jkt.hms.masters.business.BlCompanySettlementHeader companySettlementHeader;
	private jkt.hms.masters.business.BlDispensingHeader dispensingHeader;
	private jkt.hms.masters.business.BlFinalBillDetails ipFinalBillDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="company_settlement_details_id"
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
	 * Return the value associated with the column: settled_amount
	 */
	public java.math.BigDecimal getSettledAmount() {
		return settledAmount;
	}

	/**
	 * Set the value related to the column: settled_amount
	 * 
	 * @param settledAmount
	 *            the settled_amount value
	 */
	public void setSettledAmount(java.math.BigDecimal settledAmount) {
		this.settledAmount = settledAmount;
	}

	/**
	 * Return the value associated with the column: op_bill_header_id
	 */
	public jkt.hms.masters.business.BlOpBillHeader getOpBillHeader() {
		return opBillHeader;
	}

	/**
	 * Set the value related to the column: op_bill_header_id
	 * 
	 * @param opBillHeader
	 *            the op_bill_header_id value
	 */
	public void setOpBillHeader(
			jkt.hms.masters.business.BlOpBillHeader opBillHeader) {
		this.opBillHeader = opBillHeader;
	}

	/**
	 * Return the value associated with the column: company_settlement_header_id
	 */
	public jkt.hms.masters.business.BlCompanySettlementHeader getCompanySettlementHeader() {
		return companySettlementHeader;
	}

	/**
	 * Set the value related to the column: company_settlement_header_id
	 * 
	 * @param companySettlementHeader
	 *            the company_settlement_header_id value
	 */
	public void setCompanySettlementHeader(
			jkt.hms.masters.business.BlCompanySettlementHeader companySettlementHeader) {
		this.companySettlementHeader = companySettlementHeader;
	}

	/**
	 * Return the value associated with the column: dispensing_header_id
	 */
	public jkt.hms.masters.business.BlDispensingHeader getDispensingHeader() {
		return dispensingHeader;
	}

	/**
	 * Set the value related to the column: dispensing_header_id
	 * 
	 * @param dispensingHeader
	 *            the dispensing_header_id value
	 */
	public void setDispensingHeader(
			jkt.hms.masters.business.BlDispensingHeader dispensingHeader) {
		this.dispensingHeader = dispensingHeader;
	}

	/**
	 * Return the value associated with the column: ip_final_bill_details_id
	 */
	public jkt.hms.masters.business.BlFinalBillDetails getIpFinalBillDetails() {
		return ipFinalBillDetails;
	}

	/**
	 * Set the value related to the column: ip_final_bill_details_id
	 * 
	 * @param ipFinalBillDetails
	 *            the ip_final_bill_details_id value
	 */
	public void setIpFinalBillDetails(
			jkt.hms.masters.business.BlFinalBillDetails ipFinalBillDetails) {
		this.ipFinalBillDetails = ipFinalBillDetails;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlCompanySettlementDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.BlCompanySettlementDetails blCompanySettlementDetails = (jkt.hms.masters.business.BlCompanySettlementDetails) obj;
			if (null == this.getId()
					|| null == blCompanySettlementDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(blCompanySettlementDetails.getId()));
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