package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_frequency table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_frequency"
 */

public abstract class BaseMasFrequency  implements Serializable {

	public static String REF = "MasFrequency";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FREQUENCY_NAME = "FrequencyName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FREQUENCY_TYPE = "FrequencyType";
	public static String PROP_FREQUENCY_CODE = "FrequencyCode";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY_COUNT = "FrequencyCount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasFrequency () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasFrequency (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasFrequency (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String frequencyCode;
	private java.lang.String frequencyName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private int frequencyCount;
	private java.lang.String frequencyType;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisDetails> opdOphDiagnosisDetails;
	private java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups;
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="frequency_id"
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
	 * Return the value associated with the column: frequency_code
	 */
	public java.lang.String getFrequencyCode () {
		return frequencyCode;
	}

	/**
	 * Set the value related to the column: frequency_code
	 * @param frequencyCode the frequency_code value
	 */
	public void setFrequencyCode (java.lang.String frequencyCode) {
		this.frequencyCode = frequencyCode;
	}



	/**
	 * Return the value associated with the column: frequency_name
	 */
	public java.lang.String getFrequencyName () {
		return frequencyName;
	}

	/**
	 * Set the value related to the column: frequency_name
	 * @param frequencyName the frequency_name value
	 */
	public void setFrequencyName (java.lang.String frequencyName) {
		this.frequencyName = frequencyName;
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
	 * Return the value associated with the column: frequency_count
	 */
	public int getFrequencyCount () {
		return frequencyCount;
	}

	/**
	 * Set the value related to the column: frequency_count
	 * @param frequencyCount the frequency_count value
	 */
	public void setFrequencyCount (int frequencyCount) {
		this.frequencyCount = frequencyCount;
	}



	/**
	 * Return the value associated with the column: frequency_type
	 */
	public java.lang.String getFrequencyType () {
		return frequencyType;
	}

	/**
	 * Set the value related to the column: frequency_type
	 * @param frequencyType the frequency_type value
	 */
	public void setFrequencyType (java.lang.String frequencyType) {
		this.frequencyType = frequencyType;
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
	 * Return the value associated with the column: OpdOphDiagnosisDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisDetails> getOpdOphDiagnosisDetails () {
		return opdOphDiagnosisDetails;
	}

	/**
	 * Set the value related to the column: OpdOphDiagnosisDetails
	 * @param opdOphDiagnosisDetails the OpdOphDiagnosisDetails value
	 */
	public void setOpdOphDiagnosisDetails (java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisDetails> opdOphDiagnosisDetails) {
		this.opdOphDiagnosisDetails = opdOphDiagnosisDetails;
	}

	public void addToOpdOphDiagnosisDetails (jkt.hms.masters.business.OpdOphDiagnosisDetails opdOphDiagnosisDetails) {
		if (null == getOpdOphDiagnosisDetails()) setOpdOphDiagnosisDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdOphDiagnosisDetails>());
		getOpdOphDiagnosisDetails().add(opdOphDiagnosisDetails);
	}



	/**
	 * Return the value associated with the column: NursingcareSetups
	 */
	public java.util.Set<jkt.hms.masters.business.NursingcareSetup> getNursingcareSetups () {
		return nursingcareSetups;
	}

	/**
	 * Set the value related to the column: NursingcareSetups
	 * @param nursingcareSetups the NursingcareSetups value
	 */
	public void setNursingcareSetups (java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups) {
		this.nursingcareSetups = nursingcareSetups;
	}

	public void addToNursingcareSetups (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		if (null == getNursingcareSetups()) setNursingcareSetups(new java.util.TreeSet<jkt.hms.masters.business.NursingcareSetup>());
		getNursingcareSetups().add(nursingcareSetup);
	}



	/**
	 * Return the value associated with the column: PatientPrescriptionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionDetails
	 * @param patientPrescriptionDetails the PatientPrescriptionDetails value
	 */
	public void setPatientPrescriptionDetails (java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
	}

	public void addToPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		if (null == getPatientPrescriptionDetails()) setPatientPrescriptionDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionDetails>());
		getPatientPrescriptionDetails().add(patientPrescriptionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasFrequency)) return false;
		else {
			jkt.hms.masters.business.MasFrequency masFrequency = (jkt.hms.masters.business.MasFrequency) obj;
			if (null == this.getId() || null == masFrequency.getId()) return false;
			else return (this.getId().equals(masFrequency.getId()));
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