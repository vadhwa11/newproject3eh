package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the drug_usage_previous_attempts table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="drug_usage_previous_attempts"
 */

public abstract class BaseDrugUsagePreviousAttempts  implements Serializable {

	public static String REF = "DrugUsagePreviousAttempts";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICATION_HELP = "MedicationHelp";
	public static String PROP_ID = "Id";
	public static String PROP_TIME_PERIOD = "TimePeriod";
	public static String PROP_VISIT = "Visit";
	public static String PROP_PERIOD_WEEKS = "PeriodWeeks";


	// constructors
	public BaseDrugUsagePreviousAttempts () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDrugUsagePreviousAttempts (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.lang.Integer timePeriod;
	private java.lang.Integer periodWeeks;
	private java.lang.String medicationHelp;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="drug_usage_previous_attempts_id"
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
	 * Return the value associated with the column: time_period
	 */
	public java.lang.Integer getTimePeriod () {
		return timePeriod;
	}

	/**
	 * Set the value related to the column: time_period
	 * @param timePeriod the time_period value
	 */
	public void setTimePeriod (java.lang.Integer timePeriod) {
		this.timePeriod = timePeriod;
	}



	/**
	 * Return the value associated with the column: period_weeks
	 */
	public java.lang.Integer getPeriodWeeks () {
		return periodWeeks;
	}

	/**
	 * Set the value related to the column: period_weeks
	 * @param periodWeeks the period_weeks value
	 */
	public void setPeriodWeeks (java.lang.Integer periodWeeks) {
		this.periodWeeks = periodWeeks;
	}



	/**
	 * Return the value associated with the column: medication_help
	 */
	public java.lang.String getMedicationHelp () {
		return medicationHelp;
	}

	/**
	 * Set the value related to the column: medication_help
	 * @param medicationHelp the medication_help value
	 */
	public void setMedicationHelp (java.lang.String medicationHelp) {
		this.medicationHelp = medicationHelp;
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
		if (!(obj instanceof jkt.hms.masters.business.DrugUsagePreviousAttempts)) return false;
		else {
			jkt.hms.masters.business.DrugUsagePreviousAttempts drugUsagePreviousAttempts = (jkt.hms.masters.business.DrugUsagePreviousAttempts) obj;
			if (null == this.getId() || null == drugUsagePreviousAttempts.getId()) return false;
			else return (this.getId().equals(drugUsagePreviousAttempts.getId()));
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