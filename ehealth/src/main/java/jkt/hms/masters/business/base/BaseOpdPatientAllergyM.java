package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_patient_allergy_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_patient_allergy_m"
 */

public abstract class BaseOpdPatientAllergyM  implements Serializable {

	public static String REF = "OpdPatientAllergyM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseOpdPatientAllergyM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPatientAllergyM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> opdPatientAllergyTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="m_id"
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
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: OpdPatientAllergyTs
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> getOpdPatientAllergyTs () {
		return opdPatientAllergyTs;
	}

	/**
	 * Set the value related to the column: OpdPatientAllergyTs
	 * @param opdPatientAllergyTs the OpdPatientAllergyTs value
	 */
	public void setOpdPatientAllergyTs (java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> opdPatientAllergyTs) {
		this.opdPatientAllergyTs = opdPatientAllergyTs;
	}

	public void addToOpdPatientAllergyTs (jkt.hms.masters.business.OpdPatientAllergyT opdPatientAllergyT) {
		if (null == getOpdPatientAllergyTs()) setOpdPatientAllergyTs(new java.util.TreeSet<jkt.hms.masters.business.OpdPatientAllergyT>());
		getOpdPatientAllergyTs().add(opdPatientAllergyT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPatientAllergyM)) return false;
		else {
			jkt.hms.masters.business.OpdPatientAllergyM opdPatientAllergyM = (jkt.hms.masters.business.OpdPatientAllergyM) obj;
			if (null == this.getId() || null == opdPatientAllergyM.getId()) return false;
			else return (this.getId().equals(opdPatientAllergyM.getId()));
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