package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the central_server_patient_appointment_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_server_patient_appointment_data"
 */

public abstract class BaseCentralServerPatientAppointmentData  implements Serializable {

	public static String REF = "CentralServerPatientAppointmentData";
	public static String PROP_STATUS = "Status";
	public static String PROP_PAITENT_APPOINTMENT_DATA = "PaitentAppointmentData";
	public static String PROP_CENTRAL_APPOINTMENT_ID = "CentralAppointmentId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCentralServerPatientAppointmentData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralServerPatientAppointmentData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String paitentAppointmentData;
	private java.lang.Long hospitalId;
	private java.lang.Integer centralAppointmentId;
	private java.lang.String status;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: paitent_appointment_data
	 */
	public java.lang.String getPaitentAppointmentData () {
		return paitentAppointmentData;
	}

	/**
	 * Set the value related to the column: paitent_appointment_data
	 * @param paitentAppointmentData the paitent_appointment_data value
	 */
	public void setPaitentAppointmentData (java.lang.String paitentAppointmentData) {
		this.paitentAppointmentData = paitentAppointmentData;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Long getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Long hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: central_appointment_id
	 */
	public java.lang.Integer getCentralAppointmentId () {
		return centralAppointmentId;
	}

	/**
	 * Set the value related to the column: central_appointment_id
	 * @param centralAppointmentId the central_appointment_id value
	 */
	public void setCentralAppointmentId (java.lang.Integer centralAppointmentId) {
		this.centralAppointmentId = centralAppointmentId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CentralServerPatientAppointmentData)) return false;
		else {
			jkt.hms.masters.business.CentralServerPatientAppointmentData centralServerPatientAppointmentData = (jkt.hms.masters.business.CentralServerPatientAppointmentData) obj;
			if (null == this.getId() || null == centralServerPatientAppointmentData.getId()) return false;
			else return (this.getId().equals(centralServerPatientAppointmentData.getId()));
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