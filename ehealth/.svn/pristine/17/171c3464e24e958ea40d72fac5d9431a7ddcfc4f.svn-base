package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the central_server_medicine_dispense_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_server_medicine_dispense_data"
 */

public abstract class BaseCentralServerMedicineDispenseData  implements Serializable {

	public static String REF = "CentralServerMedicineDispenseData";
	public static String PROP_STATUS = "Status";
	public static String PROP_MEDICINE_DISPENSE_DATA = "MedicineDispenseData";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_CENTRAL_MEDICINE_DISPENSE_ID = "CentralMedicineDispenseId";
	public static String PROP_ID = "Id";
	public static String PROP_LEAN_MEDICINE_DISPENSE_ID = "LeanMedicineDispenseId";


	// constructors
	public BaseCentralServerMedicineDispenseData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralServerMedicineDispenseData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String medicineDispenseData;
	private java.lang.Long leanMedicineDispenseId;
	private java.lang.Long centralMedicineDispenseId;
	private java.lang.String status;
	private java.lang.Long hospitalId;



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
	 * Return the value associated with the column: medicine_dispense_data
	 */
	public java.lang.String getMedicineDispenseData () {
		return medicineDispenseData;
	}

	/**
	 * Set the value related to the column: medicine_dispense_data
	 * @param medicineDispenseData the medicine_dispense_data value
	 */
	public void setMedicineDispenseData (java.lang.String medicineDispenseData) {
		this.medicineDispenseData = medicineDispenseData;
	}



	/**
	 * Return the value associated with the column: lean_medicine_dispense_id
	 */
	public java.lang.Long getLeanMedicineDispenseId () {
		return leanMedicineDispenseId;
	}

	/**
	 * Set the value related to the column: lean_medicine_dispense_id
	 * @param leanMedicineDispenseId the lean_medicine_dispense_id value
	 */
	public void setLeanMedicineDispenseId (java.lang.Long leanMedicineDispenseId) {
		this.leanMedicineDispenseId = leanMedicineDispenseId;
	}



	/**
	 * Return the value associated with the column: central_medicine_dispense_id
	 */
	public java.lang.Long getCentralMedicineDispenseId () {
		return centralMedicineDispenseId;
	}

	/**
	 * Set the value related to the column: central_medicine_dispense_id
	 * @param centralMedicineDispenseId the central_medicine_dispense_id value
	 */
	public void setCentralMedicineDispenseId (java.lang.Long centralMedicineDispenseId) {
		this.centralMedicineDispenseId = centralMedicineDispenseId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CentralServerMedicineDispenseData)) return false;
		else {
			jkt.hms.masters.business.CentralServerMedicineDispenseData centralServerMedicineDispenseData = (jkt.hms.masters.business.CentralServerMedicineDispenseData) obj;
			if (null == this.getId() || null == centralServerMedicineDispenseData.getId()) return false;
			else return (this.getId().equals(centralServerMedicineDispenseData.getId()));
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