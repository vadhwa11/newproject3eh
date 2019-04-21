package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_post_anaesthisia_pain_management table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_post_anaesthisia_pain_management"
 */

public abstract class BaseOtPostAnaesthisiaPainManagement  implements Serializable {

	public static String REF = "OtPostAnaesthisiaPainManagement";
	public static String PROP_PERIOD = "Period";
	public static String PROP_TIME_OF_UPDATE = "TimeOfUpdate";
	public static String PROP_OT_POST_ANAESTHISIA_PROCEDURE = "OtPostAnaesthisiaProcedure";
	public static String PROP_DATE_OF_UPDATE = "DateOfUpdate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_PERISCOPE_NAME = "PeriscopeName";
	public static String PROP_PATIENT_ADMIT_STATUS = "PatientAdmitStatus";
	public static String PROP_PART_NAME = "PartName";
	public static String PROP_ID = "Id";
	public static String PROP_STATUS_OF_READING = "StatusOfReading";
	public static String PROP_PERISCOPE_VALUE = "PeriscopeValue";


	// constructors
	public BaseOtPostAnaesthisiaPainManagement () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPostAnaesthisiaPainManagement (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String partName;
	private java.lang.Integer periscopeValue;
	private java.lang.String periscopeName;
	private java.lang.String timeOfUpdate;
	private java.util.Date dateOfUpdate;
	private java.lang.Integer period;
	private java.lang.String statusOfReading;
	private java.lang.String patientAdmitStatus;

	// many to one
	private jkt.hms.masters.business.OtBooking otPostAnaesthisiaProcedure;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee addEditBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opn_id"
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
	 * Return the value associated with the column: part_name
	 */
	public java.lang.String getPartName () {
		return partName;
	}

	/**
	 * Set the value related to the column: part_name
	 * @param partName the part_name value
	 */
	public void setPartName (java.lang.String partName) {
		this.partName = partName;
	}



	/**
	 * Return the value associated with the column: periscope_value
	 */
	public java.lang.Integer getPeriscopeValue () {
		return periscopeValue;
	}

	/**
	 * Set the value related to the column: periscope_value
	 * @param periscopeValue the periscope_value value
	 */
	public void setPeriscopeValue (java.lang.Integer periscopeValue) {
		this.periscopeValue = periscopeValue;
	}



	/**
	 * Return the value associated with the column: periscope_name
	 */
	public java.lang.String getPeriscopeName () {
		return periscopeName;
	}

	/**
	 * Set the value related to the column: periscope_name
	 * @param periscopeName the periscope_name value
	 */
	public void setPeriscopeName (java.lang.String periscopeName) {
		this.periscopeName = periscopeName;
	}



	/**
	 * Return the value associated with the column: time_of_update
	 */
	public java.lang.String getTimeOfUpdate () {
		return timeOfUpdate;
	}

	/**
	 * Set the value related to the column: time_of_update
	 * @param timeOfUpdate the time_of_update value
	 */
	public void setTimeOfUpdate (java.lang.String timeOfUpdate) {
		this.timeOfUpdate = timeOfUpdate;
	}



	/**
	 * Return the value associated with the column: date_of_update
	 */
	public java.util.Date getDateOfUpdate () {
		return dateOfUpdate;
	}

	/**
	 * Set the value related to the column: date_of_update
	 * @param dateOfUpdate the date_of_update value
	 */
	public void setDateOfUpdate (java.util.Date dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}



	/**
	 * Return the value associated with the column: period
	 */
	public java.lang.Integer getPeriod () {
		return period;
	}

	/**
	 * Set the value related to the column: period
	 * @param period the period value
	 */
	public void setPeriod (java.lang.Integer period) {
		this.period = period;
	}



	/**
	 * Return the value associated with the column: status_of_reading
	 */
	public java.lang.String getStatusOfReading () {
		return statusOfReading;
	}

	/**
	 * Set the value related to the column: status_of_reading
	 * @param statusOfReading the status_of_reading value
	 */
	public void setStatusOfReading (java.lang.String statusOfReading) {
		this.statusOfReading = statusOfReading;
	}



	/**
	 * Return the value associated with the column: patient_admit_status
	 */
	public java.lang.String getPatientAdmitStatus () {
		return patientAdmitStatus;
	}

	/**
	 * Set the value related to the column: patient_admit_status
	 * @param patientAdmitStatus the patient_admit_status value
	 */
	public void setPatientAdmitStatus (java.lang.String patientAdmitStatus) {
		this.patientAdmitStatus = patientAdmitStatus;
	}



	/**
	 * Return the value associated with the column: ot_post_anaesthisia_procedure_id
	 */
	public jkt.hms.masters.business.OtBooking getOtPostAnaesthisiaProcedure () {
		return otPostAnaesthisiaProcedure;
	}

	/**
	 * Set the value related to the column: ot_post_anaesthisia_procedure_id
	 * @param otPostAnaesthisiaProcedure the ot_post_anaesthisia_procedure_id value
	 */
	public void setOtPostAnaesthisiaProcedure (jkt.hms.masters.business.OtBooking otPostAnaesthisiaProcedure) {
		this.otPostAnaesthisiaProcedure = otPostAnaesthisiaProcedure;
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
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.MasEmployee getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.MasEmployee addEditBy) {
		this.addEditBy = addEditBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPostAnaesthisiaPainManagement)) return false;
		else {
			jkt.hms.masters.business.OtPostAnaesthisiaPainManagement otPostAnaesthisiaPainManagement = (jkt.hms.masters.business.OtPostAnaesthisiaPainManagement) obj;
			if (null == this.getId() || null == otPostAnaesthisiaPainManagement.getId()) return false;
			else return (this.getId().equals(otPostAnaesthisiaPainManagement.getId()));
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