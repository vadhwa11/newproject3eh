package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_patient_category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_patient_category"
 */

public abstract class BaseMasPatientCategory  implements Serializable {

	public static String REF = "MasPatientCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PATIENT_CATEGORY_NAME = "PatientCategoryName";
	public static String PROP_PATIENT_CATEGORY_CODE = "PatientCategoryCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VALIDITY = "Validity";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DISCHARGE_WITHOUT_SETTLEMENT = "DischargeWithoutSettlement";


	// constructors
	public BaseMasPatientCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPatientCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patientCategoryCode;
	private java.lang.String patientCategoryName;
	private java.lang.String dischargeWithoutSettlement;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Long validity;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="patient_category_id"
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
	 * Return the value associated with the column: patient_category_code
	 */
	public java.lang.String getPatientCategoryCode () {
		return patientCategoryCode;
	}

	/**
	 * Set the value related to the column: patient_category_code
	 * @param patientCategoryCode the patient_category_code value
	 */
	public void setPatientCategoryCode (java.lang.String patientCategoryCode) {
		this.patientCategoryCode = patientCategoryCode;
	}



	/**
	 * Return the value associated with the column: patient_category_name
	 */
	public java.lang.String getPatientCategoryName () {
		return patientCategoryName;
	}

	/**
	 * Set the value related to the column: patient_category_name
	 * @param patientCategoryName the patient_category_name value
	 */
	public void setPatientCategoryName (java.lang.String patientCategoryName) {
		this.patientCategoryName = patientCategoryName;
	}



	/**
	 * Return the value associated with the column: discharge_without_settlement
	 */
	public java.lang.String getDischargeWithoutSettlement () {
		return dischargeWithoutSettlement;
	}

	/**
	 * Set the value related to the column: discharge_without_settlement
	 * @param dischargeWithoutSettlement the discharge_without_settlement value
	 */
	public void setDischargeWithoutSettlement (java.lang.String dischargeWithoutSettlement) {
		this.dischargeWithoutSettlement = dischargeWithoutSettlement;
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
	 * Return the value associated with the column: validity
	 */
	public java.lang.Long getValidity () {
		return validity;
	}

	/**
	 * Set the value related to the column: validity
	 * @param validity the validity value
	 */
	public void setValidity (java.lang.Long validity) {
		this.validity = validity;
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
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}



	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients () {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * @param inpatients the Inpatients value
	 */
	public void setInpatients (java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients (jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients()) setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPatientCategory)) return false;
		else {
			jkt.hms.masters.business.MasPatientCategory masPatientCategory = (jkt.hms.masters.business.MasPatientCategory) obj;
			if (null == this.getId() || null == masPatientCategory.getId()) return false;
			else return (this.getId().equals(masPatientCategory.getId()));
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