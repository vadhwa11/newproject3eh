package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pharmacy_lab_queue table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pharmacy_lab_queue"
 */

public abstract class BasePharmacyLabQueue  implements Serializable {

	public static String REF = "PharmacyLabQueue";
	public static String PROP_STATUS = "Status";
	public static String PROP_TOKEN_NO = "TokenNo";
	public static String PROP_TOTAL_HOSPITAL_VISIT = "TotalHospitalVisit";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_DG_ORDERHD_ID = "DgOrderhdId";
	public static String PROP_OPD_TIME = "OpdTime";
	public static String PROP_VISIT = "Visit";
	public static String PROP_PHARMACY_LAB_STATUS = "PharmacyLabStatus";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_OPD_DATE = "OpdDate";


	// constructors
	public BasePharmacyLabQueue () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePharmacyLabQueue (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer tokenNo;
	private java.util.Date opdDate;
	private java.lang.String opdTime;
	private java.lang.String pharmacyLabStatus;
	private java.lang.String status;
	private java.lang.Integer totalHospitalVisit;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.DgOrderhd dgOrderhdId;



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
	 * Return the value associated with the column: token_no
	 */
	public java.lang.Integer getTokenNo () {
		return tokenNo;
	}

	/**
	 * Set the value related to the column: token_no
	 * @param tokenNo the token_no value
	 */
	public void setTokenNo (java.lang.Integer tokenNo) {
		this.tokenNo = tokenNo;
	}



	/**
	 * Return the value associated with the column: opd_date
	 */
	public java.util.Date getOpdDate () {
		return opdDate;
	}

	/**
	 * Set the value related to the column: opd_date
	 * @param opdDate the opd_date value
	 */
	public void setOpdDate (java.util.Date opdDate) {
		this.opdDate = opdDate;
	}



	/**
	 * Return the value associated with the column: opd_time
	 */
	public java.lang.String getOpdTime () {
		return opdTime;
	}

	/**
	 * Set the value related to the column: opd_time
	 * @param opdTime the opd_time value
	 */
	public void setOpdTime (java.lang.String opdTime) {
		this.opdTime = opdTime;
	}



	/**
	 * Return the value associated with the column: pharmacy_lab_status
	 */
	public java.lang.String getPharmacyLabStatus () {
		return pharmacyLabStatus;
	}

	/**
	 * Set the value related to the column: pharmacy_lab_status
	 * @param pharmacyLabStatus the pharmacy_lab_status value
	 */
	public void setPharmacyLabStatus (java.lang.String pharmacyLabStatus) {
		this.pharmacyLabStatus = pharmacyLabStatus;
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
	 * Return the value associated with the column: total_hospital_visit
	 */
	public java.lang.Integer getTotalHospitalVisit () {
		return totalHospitalVisit;
	}

	/**
	 * Set the value related to the column: total_hospital_visit
	 * @param totalHospitalVisit the total_hospital_visit value
	 */
	public void setTotalHospitalVisit (java.lang.Integer totalHospitalVisit) {
		this.totalHospitalVisit = totalHospitalVisit;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: dg_orderhd_id
	 */
	public jkt.hms.masters.business.DgOrderhd getDgOrderhdId () {
		return dgOrderhdId;
	}

	/**
	 * Set the value related to the column: dg_orderhd_id
	 * @param dgOrderhdId the dg_orderhd_id value
	 */
	public void setDgOrderhdId (jkt.hms.masters.business.DgOrderhd dgOrderhdId) {
		this.dgOrderhdId = dgOrderhdId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PharmacyLabQueue)) return false;
		else {
			jkt.hms.masters.business.PharmacyLabQueue pharmacyLabQueue = (jkt.hms.masters.business.PharmacyLabQueue) obj;
			if (null == this.getId() || null == pharmacyLabQueue.getId()) return false;
			else return (this.getId().equals(pharmacyLabQueue.getId()));
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