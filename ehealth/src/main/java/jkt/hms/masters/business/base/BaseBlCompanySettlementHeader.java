package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * bl_company_settlement_header table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_company_settlement_header"
 */

public abstract class BaseBlCompanySettlementHeader implements Serializable {

	public static String REF = "BlCompanySettlementHeader";
	public static String PROP_SETTLEMENT_TIME = "SettlementTime";
	public static String PROP_SETTLEMENT_DATE = "SettlementDate";
	public static String PROP_SETTLEMENT_AMOUNT = "SettlementAmount";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PATIENT_CATEGORY = "PatientCategory";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ID = "Id";
	public static String PROP_CHANGED_BY = "ChangedBy";

	// constructors
	public BaseBlCompanySettlementHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlCompanySettlementHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal settlementAmount;
	private java.lang.String patientCategory;
	private java.util.Date settlementDate;
	private java.lang.String settlementTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.MasCompany company;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlCompanySettlementDetails> blCompanySettlementDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="company_settlement_header_id"
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
	 * Return the value associated with the column: settlement_amount
	 */
	public java.math.BigDecimal getSettlementAmount() {
		return settlementAmount;
	}

	/**
	 * Set the value related to the column: settlement_amount
	 * 
	 * @param settlementAmount
	 *            the settlement_amount value
	 */
	public void setSettlementAmount(java.math.BigDecimal settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	/**
	 * Return the value associated with the column: patient_category
	 */
	public java.lang.String getPatientCategory() {
		return patientCategory;
	}

	/**
	 * Set the value related to the column: patient_category
	 * 
	 * @param patientCategory
	 *            the patient_category value
	 */
	public void setPatientCategory(java.lang.String patientCategory) {
		this.patientCategory = patientCategory;
	}

	/**
	 * Return the value associated with the column: settlement_date
	 */
	public java.util.Date getSettlementDate() {
		return settlementDate;
	}

	/**
	 * Set the value related to the column: settlement_date
	 * 
	 * @param settlementDate
	 *            the settlement_date value
	 */
	public void setSettlementDate(java.util.Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	/**
	 * Return the value associated with the column: settlement_time
	 */
	public java.lang.String getSettlementTime() {
		return settlementTime;
	}

	/**
	 * Set the value related to the column: settlement_time
	 * 
	 * @param settlementTime
	 *            the settlement_time value
	 */
	public void setSettlementTime(java.lang.String settlementTime) {
		this.settlementTime = settlementTime;
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
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasCompany getCompany() {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * 
	 * @param company
	 *            the company_id value
	 */
	public void setCompany(jkt.hms.masters.business.MasCompany company) {
		this.company = company;
	}

	/**
	 * Return the value associated with the column: BlCompanySettlementDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlCompanySettlementDetails> getBlCompanySettlementDetails() {
		return blCompanySettlementDetails;
	}

	/**
	 * Set the value related to the column: BlCompanySettlementDetails
	 * 
	 * @param blCompanySettlementDetails
	 *            the BlCompanySettlementDetails value
	 */
	public void setBlCompanySettlementDetails(
			java.util.Set<jkt.hms.masters.business.BlCompanySettlementDetails> blCompanySettlementDetails) {
		this.blCompanySettlementDetails = blCompanySettlementDetails;
	}

	public void addToBlCompanySettlementDetails(
			jkt.hms.masters.business.BlCompanySettlementDetails blCompanySettlementDetails) {
		if (null == getBlCompanySettlementDetails()) {
			setBlCompanySettlementDetails(new java.util.TreeSet<jkt.hms.masters.business.BlCompanySettlementDetails>());
		}
		getBlCompanySettlementDetails().add(blCompanySettlementDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlCompanySettlementHeader)) {
			return false;
		} else {
			jkt.hms.masters.business.BlCompanySettlementHeader blCompanySettlementHeader = (jkt.hms.masters.business.BlCompanySettlementHeader) obj;
			if (null == this.getId()
					|| null == blCompanySettlementHeader.getId()) {
				return false;
			} else {
				return (this.getId().equals(blCompanySettlementHeader.getId()));
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