package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the drug_usage_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="drug_usage_history"
 */

public abstract class BaseDrugUsageHistory  implements Serializable {

	public static String REF = "DrugUsageHistory";
	public static String PROP_SPECIFY_OTHERS = "SpecifyOthers";
	public static String PROP_ENVIRONMENT_NAME = "EnvironmentName";
	public static String PROP_YEARS_OF_REGULAR_USE = "YearsOfRegularUse";
	public static String PROP_ENVIRONMENT_STATUS = "EnvironmentStatus";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DRUG_NAME = "DrugName";
	public static String PROP_ID = "Id";
	public static String PROP_ROUTE_CODE = "RouteCode";
	public static String PROP_VISIT = "Visit";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_DRUG_CURRENT_USE = "DrugCurrentUse";
	public static String PROP_OTHER_DRUG_NAME = "OtherDrugName";


	// constructors
	public BaseDrugUsageHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDrugUsageHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String drugName;
	private java.lang.String drugCurrentUse;
	private java.lang.Integer yearsOfRegularUse;
	private java.lang.String routeCode;
	private java.lang.String environmentStatus;
	private java.lang.String environmentName;
	private java.lang.String specifyOthers;
	private java.lang.String otherDrugName;
	private java.lang.Integer noOfDays;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="deaadiction_centre_id"
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
	 * Return the value associated with the column: drug_current_use
	 */
	public java.lang.String getDrugCurrentUse () {
		return drugCurrentUse;
	}

	/**
	 * Set the value related to the column: drug_current_use
	 * @param drugCurrentUse the drug_current_use value
	 */
	public void setDrugCurrentUse (java.lang.String drugCurrentUse) {
		this.drugCurrentUse = drugCurrentUse;
	}



	/**
	 * Return the value associated with the column: years_of_regular_use
	 */
	public java.lang.Integer getYearsOfRegularUse () {
		return yearsOfRegularUse;
	}

	/**
	 * Set the value related to the column: years_of_regular_use
	 * @param yearsOfRegularUse the years_of_regular_use value
	 */
	public void setYearsOfRegularUse (java.lang.Integer yearsOfRegularUse) {
		this.yearsOfRegularUse = yearsOfRegularUse;
	}



	/**
	 * Return the value associated with the column: route_code
	 */
	public java.lang.String getRouteCode () {
		return routeCode;
	}

	/**
	 * Set the value related to the column: route_code
	 * @param routeCode the route_code value
	 */
	public void setRouteCode (java.lang.String routeCode) {
		this.routeCode = routeCode;
	}



	/**
	 * Return the value associated with the column: environment_status
	 */
	public java.lang.String getEnvironmentStatus () {
		return environmentStatus;
	}

	/**
	 * Set the value related to the column: environment_status
	 * @param environmentStatus the environment_status value
	 */
	public void setEnvironmentStatus (java.lang.String environmentStatus) {
		this.environmentStatus = environmentStatus;
	}



	/**
	 * Return the value associated with the column: environment_name
	 */
	public java.lang.String getEnvironmentName () {
		return environmentName;
	}

	/**
	 * Set the value related to the column: environment_name
	 * @param environmentName the environment_name value
	 */
	public void setEnvironmentName (java.lang.String environmentName) {
		this.environmentName = environmentName;
	}



	/**
	 * Return the value associated with the column: specify_others
	 */
	public java.lang.String getSpecifyOthers () {
		return specifyOthers;
	}

	/**
	 * Set the value related to the column: specify_others
	 * @param specifyOthers the specify_others value
	 */
	public void setSpecifyOthers (java.lang.String specifyOthers) {
		this.specifyOthers = specifyOthers;
	}



	/**
	 * Return the value associated with the column: others_drug_name
	 */
	public java.lang.String getOtherDrugName () {
		return otherDrugName;
	}

	/**
	 * Set the value related to the column: others_drug_name
	 * @param otherDrugName the others_drug_name value
	 */
	public void setOtherDrugName (java.lang.String otherDrugName) {
		this.otherDrugName = otherDrugName;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
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
		if (!(obj instanceof jkt.hms.masters.business.DrugUsageHistory)) return false;
		else {
			jkt.hms.masters.business.DrugUsageHistory drugUsageHistory = (jkt.hms.masters.business.DrugUsageHistory) obj;
			if (null == this.getId() || null == drugUsageHistory.getId()) return false;
			else return (this.getId().equals(drugUsageHistory.getId()));
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