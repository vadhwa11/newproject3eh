package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lean_server_result_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lean_server_result_data"
 */

public abstract class BaseLeanServerResultData  implements Serializable {

	public static String REF = "LeanServerResultData";
	public static String PROP_RESULT_DATA = "ResultData";
	public static String PROP_STATUS = "Status";
	public static String PROP_CENTRAL_RESULT_ID = "CentralResultId";
	public static String PROP_LEAN_RESULT_ID = "LeanResultId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseLeanServerResultData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLeanServerResultData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String resultData;
	private java.lang.Long leanResultId;
	private java.lang.Long centralResultId;
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
	 * Return the value associated with the column: result_data
	 */
	public java.lang.String getResultData () {
		return resultData;
	}

	/**
	 * Set the value related to the column: result_data
	 * @param resultData the result_data value
	 */
	public void setResultData (java.lang.String resultData) {
		this.resultData = resultData;
	}



	/**
	 * Return the value associated with the column: lean_result_id
	 */
	public java.lang.Long getLeanResultId () {
		return leanResultId;
	}

	/**
	 * Set the value related to the column: lean_result_id
	 * @param leanResultId the lean_result_id value
	 */
	public void setLeanResultId (java.lang.Long leanResultId) {
		this.leanResultId = leanResultId;
	}



	/**
	 * Return the value associated with the column: central_result_id
	 */
	public java.lang.Long getCentralResultId () {
		return centralResultId;
	}

	/**
	 * Set the value related to the column: central_result_id
	 * @param centralResultId the central_result_id value
	 */
	public void setCentralResultId (java.lang.Long centralResultId) {
		this.centralResultId = centralResultId;
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
		if (!(obj instanceof jkt.hms.masters.business.LeanServerResultData)) return false;
		else {
			jkt.hms.masters.business.LeanServerResultData leanServerResultData = (jkt.hms.masters.business.LeanServerResultData) obj;
			if (null == this.getId() || null == leanServerResultData.getId()) return false;
			else return (this.getId().equals(leanServerResultData.getId()));
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