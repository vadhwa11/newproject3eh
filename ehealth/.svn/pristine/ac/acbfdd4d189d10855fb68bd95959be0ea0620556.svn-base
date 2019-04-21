package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the drug_usage table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="drug_usage"
 */

public abstract class BaseDrugUsage  implements Serializable {

	public static String REF = "DrugUsage";
	public static String PROP_DRUG_AGE_INITIATION = "DrugAgeInitiation";
	public static String PROP_DRUG_REGULAR_USE_DURATION = "DrugRegularUseDuration";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DRUG_REGULARUSE_AGE = "DrugRegularuseAge";
	public static String PROP_DRUG_NAME = "DrugName";
	public static String PROP_DRUG_DEPENDENCE_AGE = "DrugDependenceAge";
	public static String PROP_ID = "Id";
	public static String PROP_VISIT = "Visit";


	// constructors
	public BaseDrugUsage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDrugUsage (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String drugName;
	private java.lang.Integer drugAgeInitiation;
	private java.lang.Integer drugRegularuseAge;
	private java.lang.Integer drugRegularUseDuration;
	private java.lang.Integer drugDependenceAge;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="drug_usage_id"
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
	 * Return the value associated with the column: drug_age_initiation
	 */
	public java.lang.Integer getDrugAgeInitiation () {
		return drugAgeInitiation;
	}

	/**
	 * Set the value related to the column: drug_age_initiation
	 * @param drugAgeInitiation the drug_age_initiation value
	 */
	public void setDrugAgeInitiation (java.lang.Integer drugAgeInitiation) {
		this.drugAgeInitiation = drugAgeInitiation;
	}



	/**
	 * Return the value associated with the column: drug_regularuse_age
	 */
	public java.lang.Integer getDrugRegularuseAge () {
		return drugRegularuseAge;
	}

	/**
	 * Set the value related to the column: drug_regularuse_age
	 * @param drugRegularuseAge the drug_regularuse_age value
	 */
	public void setDrugRegularuseAge (java.lang.Integer drugRegularuseAge) {
		this.drugRegularuseAge = drugRegularuseAge;
	}



	/**
	 * Return the value associated with the column: drug_regular_use_duration
	 */
	public java.lang.Integer getDrugRegularUseDuration () {
		return drugRegularUseDuration;
	}

	/**
	 * Set the value related to the column: drug_regular_use_duration
	 * @param drugRegularUseDuration the drug_regular_use_duration value
	 */
	public void setDrugRegularUseDuration (java.lang.Integer drugRegularUseDuration) {
		this.drugRegularUseDuration = drugRegularUseDuration;
	}



	/**
	 * Return the value associated with the column: drug_dependence_age
	 */
	public java.lang.Integer getDrugDependenceAge () {
		return drugDependenceAge;
	}

	/**
	 * Set the value related to the column: drug_dependence_age
	 * @param drugDependenceAge the drug_dependence_age value
	 */
	public void setDrugDependenceAge (java.lang.Integer drugDependenceAge) {
		this.drugDependenceAge = drugDependenceAge;
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
		if (!(obj instanceof jkt.hms.masters.business.DrugUsage)) return false;
		else {
			jkt.hms.masters.business.DrugUsage drugUsage = (jkt.hms.masters.business.DrugUsage) obj;
			if (null == this.getId() || null == drugUsage.getId()) return false;
			else return (this.getId().equals(drugUsage.getId()));
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