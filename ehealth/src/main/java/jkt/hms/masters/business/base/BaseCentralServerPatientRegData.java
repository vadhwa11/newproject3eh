package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the central_server_patient_reg_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_server_patient_reg_data"
 */

public abstract class BaseCentralServerPatientRegData  implements Serializable {

	public static String REF = "CentralServerPatientRegData";
	public static String PROP_STATUS = "Status";
	public static String PROP_LEAN_REG_ID = "LeanRegId";
	public static String PROP_PAITENT_REG_DATA = "PaitentRegData";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_CENTRAL_REG_ID = "CentralRegId";


	// constructors
	public BaseCentralServerPatientRegData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralServerPatientRegData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String paitentRegData;
	private java.lang.Long leanRegId;
	private java.lang.String status;
	private java.lang.Long hospitalId;
	private java.lang.Long centralRegId;



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
	 * Return the value associated with the column: paitent_reg_data
	 */
	public java.lang.String getPaitentRegData () {
		return paitentRegData;
	}

	/**
	 * Set the value related to the column: paitent_reg_data
	 * @param paitentRegData the paitent_reg_data value
	 */
	public void setPaitentRegData (java.lang.String paitentRegData) {
		this.paitentRegData = paitentRegData;
	}



	/**
	 * Return the value associated with the column: lean_reg_id
	 */
	public java.lang.Long getLeanRegId () {
		return leanRegId;
	}

	/**
	 * Set the value related to the column: lean_reg_id
	 * @param leanRegId the lean_reg_id value
	 */
	public void setLeanRegId (java.lang.Long leanRegId) {
		this.leanRegId = leanRegId;
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



	/**
	 * Return the value associated with the column: central_reg_id
	 */
	public java.lang.Long getCentralRegId () {
		return centralRegId;
	}

	/**
	 * Set the value related to the column: central_reg_id
	 * @param centralRegId the central_reg_id value
	 */
	public void setCentralRegId (java.lang.Long centralRegId) {
		this.centralRegId = centralRegId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CentralServerPatientRegData)) return false;
		else {
			jkt.hms.masters.business.CentralServerPatientRegData centralServerPatientRegData = (jkt.hms.masters.business.CentralServerPatientRegData) obj;
			if (null == this.getId() || null == centralServerPatientRegData.getId()) return false;
			else return (this.getId().equals(centralServerPatientRegData.getId()));
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