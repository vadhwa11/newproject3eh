package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_medicine_arterial_blood_pressure table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_medicine_arterial_blood_pressure"
 */

public abstract class BaseOpdMedicineArterialBloodPressure  implements Serializable {

	public static String REF = "OpdMedicineArterialBloodPressure";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_SYSTOLIC = "Systolic";
	public static String PROP_ABP_POSITION = "AbpPosition";
	public static String PROP_ID = "Id";
	public static String PROP_ABP_POSITION_OTHER = "AbpPositionOther";
	public static String PROP_HIN = "Hin";
	public static String PROP_DIASTOLIC = "Diastolic";


	// constructors
	public BaseOpdMedicineArterialBloodPressure () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdMedicineArterialBloodPressure (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String abpPosition;
	private java.lang.String systolic;
	private java.lang.String diastolic;
	private java.lang.String abpPositionOther;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="medicine_arterial_blood_pressure_id"
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
	 * Return the value associated with the column: abp_position
	 */
	public java.lang.String getAbpPosition () {
		return abpPosition;
	}

	/**
	 * Set the value related to the column: abp_position
	 * @param abpPosition the abp_position value
	 */
	public void setAbpPosition (java.lang.String abpPosition) {
		this.abpPosition = abpPosition;
	}



	/**
	 * Return the value associated with the column: systolic
	 */
	public java.lang.String getSystolic () {
		return systolic;
	}

	/**
	 * Set the value related to the column: systolic
	 * @param systolic the systolic value
	 */
	public void setSystolic (java.lang.String systolic) {
		this.systolic = systolic;
	}



	/**
	 * Return the value associated with the column: diastolic
	 */
	public java.lang.String getDiastolic () {
		return diastolic;
	}

	/**
	 * Set the value related to the column: diastolic
	 * @param diastolic the diastolic value
	 */
	public void setDiastolic (java.lang.String diastolic) {
		this.diastolic = diastolic;
	}



	/**
	 * Return the value associated with the column: abp_position_other
	 */
	public java.lang.String getAbpPositionOther () {
		return abpPositionOther;
	}

	/**
	 * Set the value related to the column: abp_position_other
	 * @param abpPositionOther the abp_position_other value
	 */
	public void setAbpPositionOther (java.lang.String abpPositionOther) {
		this.abpPositionOther = abpPositionOther;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdMedicineArterialBloodPressure)) return false;
		else {
			jkt.hms.masters.business.OpdMedicineArterialBloodPressure opdMedicineArterialBloodPressure = (jkt.hms.masters.business.OpdMedicineArterialBloodPressure) obj;
			if (null == this.getId() || null == opdMedicineArterialBloodPressure.getId()) return false;
			else return (this.getId().equals(opdMedicineArterialBloodPressure.getId()));
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