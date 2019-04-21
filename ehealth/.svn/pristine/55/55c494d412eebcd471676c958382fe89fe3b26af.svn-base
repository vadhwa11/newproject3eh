package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lean_server_sample_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lean_server_sample_data"
 */

public abstract class BaseLeanServerSampleData  implements Serializable {

	public static String REF = "LeanServerSampleData";
	public static String PROP_STATUS = "Status";
	public static String PROP_CENTRAL_SAMPLE_ID = "CentralSampleId";
	public static String PROP_LEAN_SAMPLE_ID = "LeanSampleId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_SAMPLE_DATA = "SampleData";


	// constructors
	public BaseLeanServerSampleData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLeanServerSampleData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String sampleData;
	private java.lang.Long leanSampleId;
	private java.lang.Long centralSampleId;
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
	 * Return the value associated with the column: sample_data
	 */
	public java.lang.String getSampleData () {
		return sampleData;
	}

	/**
	 * Set the value related to the column: sample_data
	 * @param sampleData the sample_data value
	 */
	public void setSampleData (java.lang.String sampleData) {
		this.sampleData = sampleData;
	}



	/**
	 * Return the value associated with the column: lean_sample_id
	 */
	public java.lang.Long getLeanSampleId () {
		return leanSampleId;
	}

	/**
	 * Set the value related to the column: lean_sample_id
	 * @param leanSampleId the lean_sample_id value
	 */
	public void setLeanSampleId (java.lang.Long leanSampleId) {
		this.leanSampleId = leanSampleId;
	}



	/**
	 * Return the value associated with the column: central_sample_id
	 */
	public java.lang.Long getCentralSampleId () {
		return centralSampleId;
	}

	/**
	 * Set the value related to the column: central_sample_id
	 * @param centralSampleId the central_sample_id value
	 */
	public void setCentralSampleId (java.lang.Long centralSampleId) {
		this.centralSampleId = centralSampleId;
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
		if (!(obj instanceof jkt.hms.masters.business.LeanServerSampleData)) return false;
		else {
			jkt.hms.masters.business.LeanServerSampleData leanServerSampleData = (jkt.hms.masters.business.LeanServerSampleData) obj;
			if (null == this.getId() || null == leanServerSampleData.getId()) return false;
			else return (this.getId().equals(leanServerSampleData.getId()));
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