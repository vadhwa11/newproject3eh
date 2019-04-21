package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the drug_uasge_pattern table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="drug_uasge_pattern"
 */

public abstract class BaseDrugUasgePattern  implements Serializable {

	public static String REF = "DrugUasgePattern";
	public static String PROP_DATE_DRUG = "DateDrug";
	public static String PROP_FLAG = "Flag";
	public static String PROP_DRUG_WITHDRAWAL_SYMPTOMS = "DrugWithdrawalSymptoms";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DRUG_NAME = "DrugName";
	public static String PROP_PRIMARY_DRUG_OF_ABUSE = "PrimaryDrugOfAbuse";
	public static String PROP_DRUG_HEAVY_CONSUMPTION_ONEDAY = "DrugHeavyConsumptionOneday";
	public static String PROP_ID = "Id";
	public static String PROP_DRUG_AMOUNT_USED = "DrugAmountUsed";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SECONDARY_DRUG_OF_ABUSE = "SecondaryDrugOfAbuse";
	public static String PROP_DRUG_FREQUENCY_CONSUMPTION = "DrugFrequencyConsumption";


	// constructors
	public BaseDrugUasgePattern () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDrugUasgePattern (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String drugName;
	private java.lang.Double drugFrequencyConsumption;
	private java.lang.Double drugAmountUsed;
	private java.lang.Integer drugHeavyConsumptionOneday;
	private java.lang.String drugWithdrawalSymptoms;
	private java.lang.String primaryDrugOfAbuse;
	private java.lang.String secondaryDrugOfAbuse;
	private java.util.Date dateDrug;
	private java.lang.String flag;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="drug_usage_pattern_id"
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
	 * Return the value associated with the column: drug_name
	 */
	public java.lang.String getDrugName () {
		return drugName;
	}

	/**
	 * Set the value related to the column: drug_name
	 * @param drugName the drug_name value
	 */
	public void setDrugName (java.lang.String drugName) {
		this.drugName = drugName;
	}



	/**
	 * Return the value associated with the column: drug_frequency_consumption
	 */
	public java.lang.Double getDrugFrequencyConsumption () {
		return drugFrequencyConsumption;
	}

	/**
	 * Set the value related to the column: drug_frequency_consumption
	 * @param drugFrequencyConsumption the drug_frequency_consumption value
	 */
	public void setDrugFrequencyConsumption (java.lang.Double drugFrequencyConsumption) {
		this.drugFrequencyConsumption = drugFrequencyConsumption;
	}



	/**
	 * Return the value associated with the column: drug_amount_used
	 */
	public java.lang.Double getDrugAmountUsed () {
		return drugAmountUsed;
	}

	/**
	 * Set the value related to the column: drug_amount_used
	 * @param drugAmountUsed the drug_amount_used value
	 */
	public void setDrugAmountUsed (java.lang.Double drugAmountUsed) {
		this.drugAmountUsed = drugAmountUsed;
	}



	/**
	 * Return the value associated with the column: drug_heavy_consumption_oneday
	 */
	public java.lang.Integer getDrugHeavyConsumptionOneday () {
		return drugHeavyConsumptionOneday;
	}

	/**
	 * Set the value related to the column: drug_heavy_consumption_oneday
	 * @param drugHeavyConsumptionOneday the drug_heavy_consumption_oneday value
	 */
	public void setDrugHeavyConsumptionOneday (java.lang.Integer drugHeavyConsumptionOneday) {
		this.drugHeavyConsumptionOneday = drugHeavyConsumptionOneday;
	}



	/**
	 * Return the value associated with the column: drug_withdrawal_symptoms
	 */
	public java.lang.String getDrugWithdrawalSymptoms () {
		return drugWithdrawalSymptoms;
	}

	/**
	 * Set the value related to the column: drug_withdrawal_symptoms
	 * @param drugWithdrawalSymptoms the drug_withdrawal_symptoms value
	 */
	public void setDrugWithdrawalSymptoms (java.lang.String drugWithdrawalSymptoms) {
		this.drugWithdrawalSymptoms = drugWithdrawalSymptoms;
	}



	/**
	 * Return the value associated with the column: primary_drug_of_abuse
	 */
	public java.lang.String getPrimaryDrugOfAbuse () {
		return primaryDrugOfAbuse;
	}

	/**
	 * Set the value related to the column: primary_drug_of_abuse
	 * @param primaryDrugOfAbuse the primary_drug_of_abuse value
	 */
	public void setPrimaryDrugOfAbuse (java.lang.String primaryDrugOfAbuse) {
		this.primaryDrugOfAbuse = primaryDrugOfAbuse;
	}



	/**
	 * Return the value associated with the column: secondary_drug_of_abuse
	 */
	public java.lang.String getSecondaryDrugOfAbuse () {
		return secondaryDrugOfAbuse;
	}

	/**
	 * Set the value related to the column: secondary_drug_of_abuse
	 * @param secondaryDrugOfAbuse the secondary_drug_of_abuse value
	 */
	public void setSecondaryDrugOfAbuse (java.lang.String secondaryDrugOfAbuse) {
		this.secondaryDrugOfAbuse = secondaryDrugOfAbuse;
	}



	/**
	 * Return the value associated with the column: date_drug
	 */
	public java.util.Date getDateDrug () {
		return dateDrug;
	}

	/**
	 * Set the value related to the column: date_drug
	 * @param dateDrug the date_drug value
	 */
	public void setDateDrug (java.util.Date dateDrug) {
		this.dateDrug = dateDrug;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DrugUasgePattern)) return false;
		else {
			jkt.hms.masters.business.DrugUasgePattern drugUasgePattern = (jkt.hms.masters.business.DrugUasgePattern) obj;
			if (null == this.getId() || null == drugUasgePattern.getId()) return false;
			else return (this.getId().equals(drugUasgePattern.getId()));
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