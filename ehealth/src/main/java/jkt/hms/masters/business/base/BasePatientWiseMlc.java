package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_wise_mlc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_wise_mlc"
 */

public abstract class BasePatientWiseMlc  implements Serializable {

	public static String REF = "PatientWiseMlc";
	public static String PROP_OPD_PATIENT_DETAIL = "OpdPatientDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_MLC_TYPE = "MlcType";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";


	// constructors
	public BasePatientWiseMlc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientWiseMlc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mlcType;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetail;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;



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
	 * Return the value associated with the column: mlc_type
	 */
	public java.lang.String getMlcType () {
		return mlcType;
	}

	/**
	 * Set the value related to the column: mlc_type
	 * @param mlcType the mlc_type value
	 */
	public void setMlcType (java.lang.String mlcType) {
		this.mlcType = mlcType;
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
	 * Return the value associated with the column: opd_patient_detail_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetail () {
		return opdPatientDetail;
	}

	/**
	 * Set the value related to the column: opd_patient_detail_id
	 * @param opdPatientDetail the opd_patient_detail_id value
	 */
	public void setOpdPatientDetail (jkt.hms.masters.business.OpdPatientDetails opdPatientDetail) {
		this.opdPatientDetail = opdPatientDetail;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientWiseMlc)) return false;
		else {
			jkt.hms.masters.business.PatientWiseMlc patientWiseMlc = (jkt.hms.masters.business.PatientWiseMlc) obj;
			if (null == this.getId() || null == patientWiseMlc.getId()) return false;
			else return (this.getId().equals(patientWiseMlc.getId()));
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