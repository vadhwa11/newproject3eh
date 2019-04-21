package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lean_server_ipd_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lean_server_ipd_data"
 */

public abstract class BaseLeanServerIpdData  implements Serializable {

	public static String REF = "LeanServerIpdData";
	public static String PROP_STATUS = "Status";
	public static String PROP_LEAN_IPD_ID = "LeanIpdId";
	public static String PROP_IPD_DATA = "IpdData";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_CENTRAL_IPD_ID = "CentralIpdId";


	// constructors
	public BaseLeanServerIpdData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLeanServerIpdData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String ipdData;
	private java.lang.Long centralIpdId;
	private java.lang.String status;
	private java.lang.Long hospitalId;
	private java.lang.Long leanIpdId;



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
	 * Return the value associated with the column: ipd_data
	 */
	public java.lang.String getIpdData () {
		return ipdData;
	}

	/**
	 * Set the value related to the column: ipd_data
	 * @param ipdData the ipd_data value
	 */
	public void setIpdData (java.lang.String ipdData) {
		this.ipdData = ipdData;
	}



	/**
	 * Return the value associated with the column: central_ipd_id
	 */
	public java.lang.Long getCentralIpdId () {
		return centralIpdId;
	}

	/**
	 * Set the value related to the column: central_ipd_id
	 * @param centralIpdId the central_ipd_id value
	 */
	public void setCentralIpdId (java.lang.Long centralIpdId) {
		this.centralIpdId = centralIpdId;
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
	 * Return the value associated with the column: lean_ipd_id
	 */
	public java.lang.Long getLeanIpdId () {
		return leanIpdId;
	}

	/**
	 * Set the value related to the column: lean_ipd_id
	 * @param leanIpdId the lean_ipd_id value
	 */
	public void setLeanIpdId (java.lang.Long leanIpdId) {
		this.leanIpdId = leanIpdId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LeanServerIpdData)) return false;
		else {
			jkt.hms.masters.business.LeanServerIpdData leanServerIpdData = (jkt.hms.masters.business.LeanServerIpdData) obj;
			if (null == this.getId() || null == leanServerIpdData.getId()) return false;
			else return (this.getId().equals(leanServerIpdData.getId()));
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