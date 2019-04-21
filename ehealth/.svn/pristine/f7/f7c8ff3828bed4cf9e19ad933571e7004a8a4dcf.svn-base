package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prq_insurance_claim_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prq_insurance_claim_details"
 */

public abstract class BasePrqInsuranceClaimDetails  implements Serializable {

	public static String REF = "PrqInsuranceClaimDetails";
	public static String PROP_DISBURSED_AMOUNT = "DisbursedAmount";
	public static String PROP_CLAIM_DESC = "ClaimDesc";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CLAIM_DISBURSEMENT_DATE = "ClaimDisbursementDate";
	public static String PROP_CLAIM_DATE = "ClaimDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CLAIM_TYPE = "ClaimType";
	public static String PROP_CLAIM_NO = "ClaimNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CLAIM_STATUS = "ClaimStatus";
	public static String PROP_CLAIM_AMOUNT = "ClaimAmount";
	public static String PROP_INSURANCE = "Insurance";


	// constructors
	public BasePrqInsuranceClaimDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrqInsuranceClaimDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePrqInsuranceClaimDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.PrqInsuranceDetails insurance) {

		this.setId(id);
		this.setInsurance(insurance);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String claimNo;
	private java.lang.String claimType;
	private java.lang.String claimDesc;
	private java.math.BigDecimal claimAmount;
	private java.util.Date claimDate;
	private java.util.Date claimDisbursementDate;
	private java.math.BigDecimal disbursedAmount;
	private java.lang.String remarks;
	private java.lang.String claimStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.PrqInsuranceDetails insurance;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="claim_detail_id"
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
	 * Return the value associated with the column: claim_no
	 */
	public java.lang.String getClaimNo () {
		return claimNo;
	}

	/**
	 * Set the value related to the column: claim_no
	 * @param claimNo the claim_no value
	 */
	public void setClaimNo (java.lang.String claimNo) {
		this.claimNo = claimNo;
	}



	/**
	 * Return the value associated with the column: claim_type
	 */
	public java.lang.String getClaimType () {
		return claimType;
	}

	/**
	 * Set the value related to the column: claim_type
	 * @param claimType the claim_type value
	 */
	public void setClaimType (java.lang.String claimType) {
		this.claimType = claimType;
	}



	/**
	 * Return the value associated with the column: claim_desc
	 */
	public java.lang.String getClaimDesc () {
		return claimDesc;
	}

	/**
	 * Set the value related to the column: claim_desc
	 * @param claimDesc the claim_desc value
	 */
	public void setClaimDesc (java.lang.String claimDesc) {
		this.claimDesc = claimDesc;
	}



	/**
	 * Return the value associated with the column: claim_amount
	 */
	public java.math.BigDecimal getClaimAmount () {
		return claimAmount;
	}

	/**
	 * Set the value related to the column: claim_amount
	 * @param claimAmount the claim_amount value
	 */
	public void setClaimAmount (java.math.BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}



	/**
	 * Return the value associated with the column: claim_date
	 */
	public java.util.Date getClaimDate () {
		return claimDate;
	}

	/**
	 * Set the value related to the column: claim_date
	 * @param claimDate the claim_date value
	 */
	public void setClaimDate (java.util.Date claimDate) {
		this.claimDate = claimDate;
	}



	/**
	 * Return the value associated with the column: claim_disbursement_date
	 */
	public java.util.Date getClaimDisbursementDate () {
		return claimDisbursementDate;
	}

	/**
	 * Set the value related to the column: claim_disbursement_date
	 * @param claimDisbursementDate the claim_disbursement_date value
	 */
	public void setClaimDisbursementDate (java.util.Date claimDisbursementDate) {
		this.claimDisbursementDate = claimDisbursementDate;
	}



	/**
	 * Return the value associated with the column: disbursed_amount
	 */
	public java.math.BigDecimal getDisbursedAmount () {
		return disbursedAmount;
	}

	/**
	 * Set the value related to the column: disbursed_amount
	 * @param disbursedAmount the disbursed_amount value
	 */
	public void setDisbursedAmount (java.math.BigDecimal disbursedAmount) {
		this.disbursedAmount = disbursedAmount;
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
	 * Return the value associated with the column: claim_status
	 */
	public java.lang.String getClaimStatus () {
		return claimStatus;
	}

	/**
	 * Set the value related to the column: claim_status
	 * @param claimStatus the claim_status value
	 */
	public void setClaimStatus (java.lang.String claimStatus) {
		this.claimStatus = claimStatus;
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
	 * Return the value associated with the column: insurance_id
	 */
	public jkt.hms.masters.business.PrqInsuranceDetails getInsurance () {
		return insurance;
	}

	/**
	 * Set the value related to the column: insurance_id
	 * @param insurance the insurance_id value
	 */
	public void setInsurance (jkt.hms.masters.business.PrqInsuranceDetails insurance) {
		this.insurance = insurance;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PrqInsuranceClaimDetails)) return false;
		else {
			jkt.hms.masters.business.PrqInsuranceClaimDetails prqInsuranceClaimDetails = (jkt.hms.masters.business.PrqInsuranceClaimDetails) obj;
			if (null == this.getId() || null == prqInsuranceClaimDetails.getId()) return false;
			else return (this.getId().equals(prqInsuranceClaimDetails.getId()));
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