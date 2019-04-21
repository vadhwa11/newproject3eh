package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ip_admission_for_lean table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ip_admission_for_lean"
 */

public abstract class BaseIpAdmissionForLean  implements Serializable {

	public static String REF = "IpAdmissionForLean";
	public static String PROP_INPATIENT_ID = "InpatientId";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_IP_BED_ALLOW = "IpBedAllow";
	public static String PROP_IP_ADMISSION = "IpAdmission";


	// constructors
	public BaseIpAdmissionForLean () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpAdmissionForLean (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String ipAdmission;
	private java.lang.String status;
	private java.lang.Integer hospitalId;
	private java.lang.Integer inpatientId;
	private java.lang.String ipBedAllow;



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
	 * Return the value associated with the column: ip_admission
	 */
	public java.lang.String getIpAdmission () {
		return ipAdmission;
	}

	/**
	 * Set the value related to the column: ip_admission
	 * @param ipAdmission the ip_admission value
	 */
	public void setIpAdmission (java.lang.String ipAdmission) {
		this.ipAdmission = ipAdmission;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public java.lang.Integer getInpatientId () {
		return inpatientId;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatientId the inpatient_id value
	 */
	public void setInpatientId (java.lang.Integer inpatientId) {
		this.inpatientId = inpatientId;
	}



	/**
	 * Return the value associated with the column: ip_bed_allow
	 */
	public java.lang.String getIpBedAllow () {
		return ipBedAllow;
	}

	/**
	 * Set the value related to the column: ip_bed_allow
	 * @param ipBedAllow the ip_bed_allow value
	 */
	public void setIpBedAllow (java.lang.String ipBedAllow) {
		this.ipBedAllow = ipBedAllow;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpAdmissionForLean)) return false;
		else {
			jkt.hms.masters.business.IpAdmissionForLean ipAdmissionForLean = (jkt.hms.masters.business.IpAdmissionForLean) obj;
			if (null == this.getId() || null == ipAdmissionForLean.getId()) return false;
			else return (this.getId().equals(ipAdmissionForLean.getId()));
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