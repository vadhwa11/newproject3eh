package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_patient_diet table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_patient_diet"
 */

public abstract class BaseIpdPatientDiet  implements Serializable {

	public static String REF = "IpdPatientDiet";
	public static String PROP_SUGGESTED_BY = "SuggestedBy";
	public static String PROP_STATUS = "Status";
	public static String PROP_DIET_GIVEN_BY = "DietGivenBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_SPL_INSTRUCTIONS = "SplInstructions";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DIET = "Diet";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DIET_TIME = "DietTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_DIET_DATE = "DietDate";


	// constructors
	public BaseIpdPatientDiet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdPatientDiet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dietDate;
	private java.lang.String dietTime;
	private java.lang.String splInstructions;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee dietGivenBy;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee suggestedBy;
	private jkt.hms.masters.business.MasDiet diet;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: diet_date
	 */
	public java.util.Date getDietDate () {
		return dietDate;
	}

	/**
	 * Set the value related to the column: diet_date
	 * @param dietDate the diet_date value
	 */
	public void setDietDate (java.util.Date dietDate) {
		this.dietDate = dietDate;
	}



	/**
	 * Return the value associated with the column: diet_time
	 */
	public java.lang.String getDietTime () {
		return dietTime;
	}

	/**
	 * Set the value related to the column: diet_time
	 * @param dietTime the diet_time value
	 */
	public void setDietTime (java.lang.String dietTime) {
		this.dietTime = dietTime;
	}



	/**
	 * Return the value associated with the column: spl_instructions
	 */
	public java.lang.String getSplInstructions () {
		return splInstructions;
	}

	/**
	 * Set the value related to the column: spl_instructions
	 * @param splInstructions the spl_instructions value
	 */
	public void setSplInstructions (java.lang.String splInstructions) {
		this.splInstructions = splInstructions;
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
	 * Return the value associated with the column: diet_given_by
	 */
	public jkt.hms.masters.business.MasEmployee getDietGivenBy () {
		return dietGivenBy;
	}

	/**
	 * Set the value related to the column: diet_given_by
	 * @param dietGivenBy the diet_given_by value
	 */
	public void setDietGivenBy (jkt.hms.masters.business.MasEmployee dietGivenBy) {
		this.dietGivenBy = dietGivenBy;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: suggested_by
	 */
	public jkt.hms.masters.business.MasEmployee getSuggestedBy () {
		return suggestedBy;
	}

	/**
	 * Set the value related to the column: suggested_by
	 * @param suggestedBy the suggested_by value
	 */
	public void setSuggestedBy (jkt.hms.masters.business.MasEmployee suggestedBy) {
		this.suggestedBy = suggestedBy;
	}



	/**
	 * Return the value associated with the column: diet_id
	 */
	public jkt.hms.masters.business.MasDiet getDiet () {
		return diet;
	}

	/**
	 * Set the value related to the column: diet_id
	 * @param diet the diet_id value
	 */
	public void setDiet (jkt.hms.masters.business.MasDiet diet) {
		this.diet = diet;
	}



	/**
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdPatientDiet)) return false;
		else {
			jkt.hms.masters.business.IpdPatientDiet ipdPatientDiet = (jkt.hms.masters.business.IpdPatientDiet) obj;
			if (null == this.getId() || null == ipdPatientDiet.getId()) return false;
			else return (this.getId().equals(ipdPatientDiet.getId()));
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