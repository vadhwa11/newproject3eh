package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prq_insurance_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prq_insurance_details"
 */

public abstract class BasePrqInsuranceDetails  implements Serializable {

	public static String REF = "PrqInsuranceDetails";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_POLICY_NO = "PolicyNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_INSURANCE_COMPANY = "InsuranceCompany";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_INSURANCE_TYPE = "InsuranceType";
	public static String PROP_INSURANCE_START_DATE = "InsuranceStartDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_INSURANCE_DATE = "InsuranceDate";
	public static String PROP_INSURANCE_END_DATE = "InsuranceEndDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ASSET = "Asset";
	public static String PROP_ID = "Id";
	public static String PROP_PREMIUM_AMOUNT = "PremiumAmount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePrqInsuranceDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrqInsuranceDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String policyNo;
	private java.lang.String insuranceType;
	private java.lang.String address;
	private java.lang.Long contactNo;
	private java.util.Date insuranceDate;
	private java.util.Date insuranceStartDate;
	private java.util.Date insuranceEndDate;
	private java.math.BigDecimal premiumAmount;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.PrqAssetDetails asset;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasInsuranceCompany insuranceCompany;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="insurance_id"
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
	 * Return the value associated with the column: policy_no
	 */
	public java.lang.String getPolicyNo () {
		return policyNo;
	}

	/**
	 * Set the value related to the column: policy_no
	 * @param policyNo the policy_no value
	 */
	public void setPolicyNo (java.lang.String policyNo) {
		this.policyNo = policyNo;
	}



	/**
	 * Return the value associated with the column: insurance_type
	 */
	public java.lang.String getInsuranceType () {
		return insuranceType;
	}

	/**
	 * Set the value related to the column: insurance_type
	 * @param insuranceType the insurance_type value
	 */
	public void setInsuranceType (java.lang.String insuranceType) {
		this.insuranceType = insuranceType;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.Long getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.Long contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: insurance_date
	 */
	public java.util.Date getInsuranceDate () {
		return insuranceDate;
	}

	/**
	 * Set the value related to the column: insurance_date
	 * @param insuranceDate the insurance_date value
	 */
	public void setInsuranceDate (java.util.Date insuranceDate) {
		this.insuranceDate = insuranceDate;
	}



	/**
	 * Return the value associated with the column: insurance_start_date
	 */
	public java.util.Date getInsuranceStartDate () {
		return insuranceStartDate;
	}

	/**
	 * Set the value related to the column: insurance_start_date
	 * @param insuranceStartDate the insurance_start_date value
	 */
	public void setInsuranceStartDate (java.util.Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}



	/**
	 * Return the value associated with the column: insurance_end_date
	 */
	public java.util.Date getInsuranceEndDate () {
		return insuranceEndDate;
	}

	/**
	 * Set the value related to the column: insurance_end_date
	 * @param insuranceEndDate the insurance_end_date value
	 */
	public void setInsuranceEndDate (java.util.Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}



	/**
	 * Return the value associated with the column: premium_amount
	 */
	public java.math.BigDecimal getPremiumAmount () {
		return premiumAmount;
	}

	/**
	 * Set the value related to the column: premium_amount
	 * @param premiumAmount the premium_amount value
	 */
	public void setPremiumAmount (java.math.BigDecimal premiumAmount) {
		this.premiumAmount = premiumAmount;
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
	 * Return the value associated with the column: asset_id
	 */
	public jkt.hms.masters.business.PrqAssetDetails getAsset () {
		return asset;
	}

	/**
	 * Set the value related to the column: asset_id
	 * @param asset the asset_id value
	 */
	public void setAsset (jkt.hms.masters.business.PrqAssetDetails asset) {
		this.asset = asset;
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
	 * Return the value associated with the column: insurance_company
	 */
	public jkt.hms.masters.business.MasInsuranceCompany getInsuranceCompany () {
		return insuranceCompany;
	}

	/**
	 * Set the value related to the column: insurance_company
	 * @param insuranceCompany the insurance_company value
	 */
	public void setInsuranceCompany (jkt.hms.masters.business.MasInsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PrqInsuranceDetails)) return false;
		else {
			jkt.hms.masters.business.PrqInsuranceDetails prqInsuranceDetails = (jkt.hms.masters.business.PrqInsuranceDetails) obj;
			if (null == this.getId() || null == prqInsuranceDetails.getId()) return false;
			else return (this.getId().equals(prqInsuranceDetails.getId()));
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