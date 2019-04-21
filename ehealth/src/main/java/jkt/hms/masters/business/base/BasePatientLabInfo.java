package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_lab_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_lab_info"
 */

public abstract class BasePatientLabInfo  implements Serializable {

	public static String REF = "PatientLabInfo";
	public static String PROP_MACHINE_CODE = "MachineCode";
	public static String PROP_T_DATE = "TDate";
	public static String PROP_MEASUREMENT_VALUE = "MeasurementValue";
	public static String PROP_ID = "Id";
	public static String PROP_PARAMETER_NAME = "ParameterName";
	public static String PROP_UNIT = "Unit";
	public static String PROP_SAMPLE_NO = "SampleNo";
	public static String PROP_HOSPITAL = "Hospital";
	
		// constructors
	public BasePatientLabInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientLabInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sampleNo;
	private java.lang.String parameterName;
	private java.lang.String measurementValue;
	private java.lang.String unit;
	private java.lang.String tDate;
	private java.lang.String machineCode;

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
	 * Return the value associated with the column: parameter_name
	 */
	public java.lang.String getParameterName () {
		return parameterName;
	}

	/**
	 * Set the value related to the column: parameter_name
	 * @param parameterName the parameter_name value
	 */
	public void setParameterName (java.lang.String parameterName) {
		this.parameterName = parameterName;
	}



	/**
	 * Return the value associated with the column: measurement_value
	 */
	public java.lang.String getMeasurementValue () {
		return measurementValue;
	}

	/**
	 * Set the value related to the column: measurement_value
	 * @param measurementValue the measurement_value value
	 */
	public void setMeasurementValue (java.lang.String measurementValue) {
		this.measurementValue = measurementValue;
	}



	/**
	 * Return the value associated with the column: unit
	 */
	public java.lang.String getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit
	 * @param unit the unit value
	 */
	public void setUnit (java.lang.String unit) {
		this.unit = unit;
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
		if (!(obj instanceof jkt.hms.masters.business.PatientLabInfo)) return false;
		else {
			jkt.hms.masters.business.PatientLabInfo patientLabInfo = (jkt.hms.masters.business.PatientLabInfo) obj;
			if (null == this.getId() || null == patientLabInfo.getId()) return false;
			else return (this.getId().equals(patientLabInfo.getId()));
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