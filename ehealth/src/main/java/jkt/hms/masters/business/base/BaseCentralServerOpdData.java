package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the central_server_opd_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="central_server_opd_data"
 */

public abstract class BaseCentralServerOpdData  implements Serializable {

	public static String REF = "CentralServerOpdData";
	public static String PROP_STATUS = "Status";
	public static String PROP_CENTRAL_OPD_ID = "CentralOpdId";
	public static String PROP_OPD_DATA = "OpdData";
	public static String PROP_ID = "Id";
	public static String PROP_LEAN_OPD_ID = "LeanOpdId";


	// constructors
	public BaseCentralServerOpdData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCentralServerOpdData (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCentralServerOpdData (
		java.lang.Integer id,
		java.lang.Long leanOpdId) {

		this.setId(id);
		this.setLeanOpdId(leanOpdId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String opdData;
	private java.lang.String status;
	private java.lang.Long leanOpdId;
	private java.lang.Long centralOpdId;
	private java.lang.Long hospitalId;



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
	 * Return the value associated with the column: opd_data
	 */
	public java.lang.String getOpdData () {
		return opdData;
	}

	/**
	 * Set the value related to the column: opd_data
	 * @param opdData the opd_data value
	 */
	public void setOpdData (java.lang.String opdData) {
		this.opdData = opdData;
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
	 * Return the value associated with the column: lean_opd_id
	 */
	public java.lang.Long getLeanOpdId () {
		return leanOpdId;
	}

	/**
	 * Set the value related to the column: lean_opd_id
	 * @param leanOpdId the lean_opd_id value
	 */
	public void setLeanOpdId (java.lang.Long leanOpdId) {
		this.leanOpdId = leanOpdId;
	}



	/**
	 * Return the value associated with the column: central_opd_id
	 */
	public java.lang.Long getCentralOpdId () {
		return centralOpdId;
	}

	/**
	 * Set the value related to the column: central_opd_id
	 * @param centralOpdId the central_opd_id value
	 */
	public void setCentralOpdId (java.lang.Long centralOpdId) {
		this.centralOpdId = centralOpdId;
	}




	public java.lang.Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(java.lang.Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CentralServerOpdData)) return false;
		else {
			jkt.hms.masters.business.CentralServerOpdData centralServerOpdData = (jkt.hms.masters.business.CentralServerOpdData) obj;
			if (null == this.getId() || null == centralServerOpdData.getId()) return false;
			else return (this.getId().equals(centralServerOpdData.getId()));
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