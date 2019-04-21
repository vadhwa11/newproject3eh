package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_investigation_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_investigation_header"
 */

public abstract class BasePatientInvestigationHeader  implements Serializable {

	public static String REF = "PatientInvestigationHeader";
	public static String PROP_OPD_PATIENT_DETAIL = "OpdPatientDetail";
	public static String PROP_OTHER_INVESTIGATION = "OtherInvestigation";
	public static String PROP_INVESTIGATION_DATE = "InvestigationDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_INVESTIGATION_BY = "InvestigationBy";
	public static String PROP_PRESCRIBED_BY_NURSE = "PrescribedByNurse";
	public static String PROP_VISIT = "Visit";
	public static String PROP_STATUS = "Status";
	public static String PROP_INVESTIGATION_TIME = "InvestigationTime";
	public static String PROP_ID = "Id";
	public static String PROP_REF_VISIT_ID = "RefVisitId";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";


	// constructors
	public BasePatientInvestigationHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientInvestigationHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date investigationDate;
	private java.lang.String investigationTime;
	private java.lang.String otherInvestigation;
	private java.lang.Integer refVisitId;
	private java.lang.String prescribedByNurse;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetail;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee investigationBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> patientInvestigationDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="investigation_header_id"
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
	 * Return the value associated with the column: investigation_date
	 */
	public java.util.Date getInvestigationDate () {
		return investigationDate;
	}

	/**
	 * Set the value related to the column: investigation_date
	 * @param investigationDate the investigation_date value
	 */
	public void setInvestigationDate (java.util.Date investigationDate) {
		this.investigationDate = investigationDate;
	}



	/**
	 * Return the value associated with the column: investigation_time
	 */
	public java.lang.String getInvestigationTime () {
		return investigationTime;
	}

	/**
	 * Set the value related to the column: investigation_time
	 * @param investigationTime the investigation_time value
	 */
	public void setInvestigationTime (java.lang.String investigationTime) {
		this.investigationTime = investigationTime;
	}



	/**
	 * Return the value associated with the column: other_investigation
	 */
	public java.lang.String getOtherInvestigation () {
		return otherInvestigation;
	}

	/**
	 * Set the value related to the column: other_investigation
	 * @param otherInvestigation the other_investigation value
	 */
	public void setOtherInvestigation (java.lang.String otherInvestigation) {
		this.otherInvestigation = otherInvestigation;
	}



	/**
	 * Return the value associated with the column: ref_visit_id
	 */
	public java.lang.Integer getRefVisitId () {
		return refVisitId;
	}

	/**
	 * Set the value related to the column: ref_visit_id
	 * @param refVisitId the ref_visit_id value
	 */
	public void setRefVisitId (java.lang.Integer refVisitId) {
		this.refVisitId = refVisitId;
	}



	/**
	 * Return the value associated with the column: prescribed_by_nurse
	 */
	public java.lang.String getPrescribedByNurse () {
		return prescribedByNurse;
	}

	/**
	 * Set the value related to the column: prescribed_by_nurse
	 * @param prescribedByNurse the prescribed_by_nurse value
	 */
	public void setPrescribedByNurse (java.lang.String prescribedByNurse) {
		this.prescribedByNurse = prescribedByNurse;
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
	 * Return the value associated with the column: opd_patient_detail_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetail () {
		return opdPatientDetail;
	}

	/**
	 * Set the value related to the column: opd_patient_detail_id
	 * @param opdPatientDetail the opd_patient_detail_id value
	 */
	public void setOpdPatientDetail (jkt.hms.masters.business.OpdPatientDetails opdPatientDetail) {
		this.opdPatientDetail = opdPatientDetail;
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
	 * Return the value associated with the column: investigation_by
	 */
	public jkt.hms.masters.business.MasEmployee getInvestigationBy () {
		return investigationBy;
	}

	/**
	 * Set the value related to the column: investigation_by
	 * @param investigationBy the investigation_by value
	 */
	public void setInvestigationBy (jkt.hms.masters.business.MasEmployee investigationBy) {
		this.investigationBy = investigationBy;
	}



	/**
	 * Return the value associated with the column: PatientInvestigationDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> getPatientInvestigationDetails () {
		return patientInvestigationDetails;
	}

	/**
	 * Set the value related to the column: PatientInvestigationDetails
	 * @param patientInvestigationDetails the PatientInvestigationDetails value
	 */
	public void setPatientInvestigationDetails (java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> patientInvestigationDetails) {
		this.patientInvestigationDetails = patientInvestigationDetails;
	}

	public void addToPatientInvestigationDetails (jkt.hms.masters.business.PatientInvestigationDetails patientInvestigationDetails) {
		if (null == getPatientInvestigationDetails()) setPatientInvestigationDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientInvestigationDetails>());
		getPatientInvestigationDetails().add(patientInvestigationDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientInvestigationHeader)) return false;
		else {
			jkt.hms.masters.business.PatientInvestigationHeader patientInvestigationHeader = (jkt.hms.masters.business.PatientInvestigationHeader) obj;
			if (null == this.getId() || null == patientInvestigationHeader.getId()) return false;
			else return (this.getId().equals(patientInvestigationHeader.getId()));
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