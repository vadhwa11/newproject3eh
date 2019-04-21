package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_main_lab_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_main_lab_info"
 */

public abstract class BasePatientMainLabInfo  implements Serializable {

	public static String REF = "PatientMainLabInfo";
	public static String PROP_STATUS = "Status";
	public static String PROP_TIME = "Time";
	public static String PROP_MACHINE_CODE = "MachineCode";
	public static String PROP_T_DATE = "TDate";
	public static String PROP_DIAG_NO = "DiagNo";
	public static String PROP_ID = "Id";
	public static String PROP_SAMPLE_NO = "SampleNo";
	public static String PROP_HOSPITAL = "Hospital";

	// constructors
	public BasePatientMainLabInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientMainLabInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sampleNo;
	private java.lang.String status;
	private java.lang.String diagNo;
	private java.lang.String machineCode;
	private java.lang.String tDate;
	private java.lang.String time;
 
	private jkt.hms.masters.business.MasHospital hospital;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: sample_no
	 */
	public java.lang.String getSampleNo () {
		return sampleNo;
	}

	/**
	 * Set the value related to the column: sample_no
	 * @param sampleNo the sample_no value
	 */
	public void setSampleNo (java.lang.String sampleNo) {
		this.sampleNo = sampleNo;
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
	 * Return the value associated with the column: diag_no
	 */
	public java.lang.String getDiagNo () {
		return diagNo;
	}

	/**
	 * Set the value related to the column: diag_no
	 * @param diagNo the diag_no value
	 */
	public void setDiagNo (java.lang.String diagNo) {
		this.diagNo = diagNo;
	}



	/**
	 * Return the value associated with the column: machine_code
	 */
	public java.lang.String getMachineCode () {
		return machineCode;
	}

	/**
	 * Set the value related to the column: machine_code
	 * @param machineCode the machine_code value
	 */
	public void setMachineCode (java.lang.String machineCode) {
		this.machineCode = machineCode;
	}



	/**
	 * Return the value associated with the column: t_date
	 */
	public java.lang.String getTDate () {
		return tDate;
	}

	/**
	 * Set the value related to the column: t_date
	 * @param tDate the t_date value
	 */
	public void setTDate (java.lang.String tDate) {
		this.tDate = tDate;
	}



	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getTime () {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * @param time the time value
	 */
	public void setTime (java.lang.String time) {
		this.time = time;
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientMainLabInfo)) return false;
		else {
			jkt.hms.masters.business.PatientMainLabInfo patientMainLabInfo = (jkt.hms.masters.business.PatientMainLabInfo) obj;
			if (null == this.getId() || null == patientMainLabInfo.getId()) return false;
			else return (this.getId().equals(patientMainLabInfo.getId()));
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