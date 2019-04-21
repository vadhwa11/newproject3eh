package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lean_server_visit_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lean_server_visit_data"
 */

public abstract class BaseLeanServerVisitData  implements Serializable {

	public static String REF = "LeanServerVisitData";
	public static String PROP_VISIT_DATA = "VisitData";
	public static String PROP_STATUS = "Status";
	public static String PROP_LEAN_VISIT_ID = "LeanVisitId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_CENTRAL_VISIT_ID = "CentralVisitId";


	// constructors
	public BaseLeanServerVisitData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLeanServerVisitData (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String visitData;
	private java.lang.Long centralVisitId;
	private java.lang.String status;
	private java.lang.Long hospitalId;
	private java.lang.Long leanVisitId;



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
	 * Return the value associated with the column: visit_data
	 */
	public java.lang.String getVisitData () {
		return visitData;
	}

	/**
	 * Set the value related to the column: visit_data
	 * @param visitData the visit_data value
	 */
	public void setVisitData (java.lang.String visitData) {
		this.visitData = visitData;
	}



	/**
	 * Return the value associated with the column: central_visit_id
	 */
	public java.lang.Long getCentralVisitId () {
		return centralVisitId;
	}

	/**
	 * Set the value related to the column: central_visit_id
	 * @param centralVisitId the central_visit_id value
	 */
	public void setCentralVisitId (java.lang.Long centralVisitId) {
		this.centralVisitId = centralVisitId;
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
	 * Return the value associated with the column: lean_visit_id
	 */
	public java.lang.Long getLeanVisitId () {
		return leanVisitId;
	}

	/**
	 * Set the value related to the column: lean_visit_id
	 * @param leanVisitId the lean_visit_id value
	 */
	public void setLeanVisitId (java.lang.Long leanVisitId) {
		this.leanVisitId = leanVisitId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LeanServerVisitData)) return false;
		else {
			jkt.hms.masters.business.LeanServerVisitData leanServerVisitData = (jkt.hms.masters.business.LeanServerVisitData) obj;
			if (null == this.getId() || null == leanServerVisitData.getId()) return false;
			else return (this.getId().equals(leanServerVisitData.getId()));
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