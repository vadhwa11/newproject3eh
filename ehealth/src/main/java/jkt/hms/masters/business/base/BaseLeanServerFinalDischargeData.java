package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lean_server_final_discharge_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lean_server_final_discharge_data"
 */

public abstract class BaseLeanServerFinalDischargeData  implements Serializable {

	public static String REF = "LeanServerFinalDischargeData";
	public static String PROP_STATUS = "Status";
	public static String PROP_FINAL_DISCHARGE_DATA = "FinalDischargeData";
	public static String PROP_CENTRAL_IP_ID = "CentralIpId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_LEAN_IP_ID = "LeanIpId";


	// constructors
	public BaseLeanServerFinalDischargeData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLeanServerFinalDischargeData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String finalDischargeData;
	private java.lang.Long centralIpId;
	private java.lang.String status;
	private java.lang.Integer hospitalId;
	private java.lang.Long leanIpId;



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
	 * Return the value associated with the column: final_discharge_data
	 */
	public java.lang.String getFinalDischargeData () {
		return finalDischargeData;
	}

	/**
	 * Set the value related to the column: final_discharge_data
	 * @param finalDischargeData the final_discharge_data value
	 */
	public void setFinalDischargeData (java.lang.String finalDischargeData) {
		this.finalDischargeData = finalDischargeData;
	}



	/**
	 * Return the value associated with the column: central_ip_id
	 */
	public java.lang.Long getCentralIpId () {
		return centralIpId;
	}

	/**
	 * Set the value related to the column: central_ip_id
	 * @param centralIpId the central_ip_id value
	 */
	public void setCentralIpId (java.lang.Long centralIpId) {
		this.centralIpId = centralIpId;
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
	public java.lang.Integer getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: lean_ip_id
	 */
	public java.lang.Long getLeanIpId () {
		return leanIpId;
	}

	/**
	 * Set the value related to the column: lean_ip_id
	 * @param leanIpId the lean_ip_id value
	 */
	public void setLeanIpId (java.lang.Long leanIpId) {
		this.leanIpId = leanIpId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LeanServerFinalDischargeData)) return false;
		else {
			jkt.hms.masters.business.LeanServerFinalDischargeData leanServerFinalDischargeData = (jkt.hms.masters.business.LeanServerFinalDischargeData) obj;
			if (null == this.getId() || null == leanServerFinalDischargeData.getId()) return false;
			else return (this.getId().equals(leanServerFinalDischargeData.getId()));
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