package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the procedure_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="procedure_header"
 */

public abstract class BaseProcedureHeader  implements Serializable {

	public static String REF = "ProcedureHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NEW_VISIT = "NewVisit";
	public static String PROP_PROCEDURE_HOSPITAL_NAME = "ProcedureHospitalName";
	public static String PROP_VISIT = "Visit";
	public static String PROP_HIN = "Hin";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_REQUISITION_DATE = "RequisitionDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseProcedureHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProcedureHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date requisitionDate;
	private java.lang.String status;
	private java.lang.String procedureHospitalName;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.Visit newVisit;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.ProcedureDetails> procedureDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="procedure_header_id"
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
	 * Return the value associated with the column: requisition_date
	 */
	public java.util.Date getRequisitionDate () {
		return requisitionDate;
	}

	/**
	 * Set the value related to the column: requisition_date
	 * @param requisitionDate the requisition_date value
	 */
	public void setRequisitionDate (java.util.Date requisitionDate) {
		this.requisitionDate = requisitionDate;
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
	 * Return the value associated with the column: procedure_hospital_name
	 */
	public java.lang.String getProcedureHospitalName () {
		return procedureHospitalName;
	}

	/**
	 * Set the value related to the column: procedure_hospital_name
	 * @param procedureHospitalName the procedure_hospital_name value
	 */
	public void setProcedureHospitalName (java.lang.String procedureHospitalName) {
		this.procedureHospitalName = procedureHospitalName;
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
	 * Return the value associated with the column: new_visit_id
	 */
	public jkt.hms.masters.business.Visit getNewVisit () {
		return newVisit;
	}

	/**
	 * Set the value related to the column: new_visit_id
	 * @param newVisit the new_visit_id value
	 */
	public void setNewVisit (jkt.hms.masters.business.Visit newVisit) {
		this.newVisit = newVisit;
	}



	/**
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
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
	 * Return the value associated with the column: medical_officer_id
	 */
	public jkt.hms.masters.business.MasEmployee getMedicalOfficer () {
		return medicalOfficer;
	}

	/**
	 * Set the value related to the column: medical_officer_id
	 * @param medicalOfficer the medical_officer_id value
	 */
	public void setMedicalOfficer (jkt.hms.masters.business.MasEmployee medicalOfficer) {
		this.medicalOfficer = medicalOfficer;
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
	 * Return the value associated with the column: ProcedureDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ProcedureDetails> getProcedureDetails () {
		return procedureDetails;
	}

	/**
	 * Set the value related to the column: ProcedureDetails
	 * @param procedureDetails the ProcedureDetails value
	 */
	public void setProcedureDetails (java.util.Set<jkt.hms.masters.business.ProcedureDetails> procedureDetails) {
		this.procedureDetails = procedureDetails;
	}

	public void addToProcedureDetails (jkt.hms.masters.business.ProcedureDetails procedureDetails) {
		if (null == getProcedureDetails()) setProcedureDetails(new java.util.TreeSet<jkt.hms.masters.business.ProcedureDetails>());
		getProcedureDetails().add(procedureDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ProcedureHeader)) return false;
		else {
			jkt.hms.masters.business.ProcedureHeader procedureHeader = (jkt.hms.masters.business.ProcedureHeader) obj;
			if (null == this.getId() || null == procedureHeader.getId()) return false;
			else return (this.getId().equals(procedureHeader.getId()));
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