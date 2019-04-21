package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_prescription_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_prescription_header"
 */

public abstract class BasePatientPrescriptionHeader  implements Serializable {

	public static String REF = "PatientPrescriptionHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_PRESCRIPTION_NO = "PrescriptionNo";
	public static String PROP_REMARKS_FOR_CT = "RemarksForCt";
	public static String PROP_VISIT = "Visit";
	public static String PROP_DISCHARGE_MEDICATION_STATUS = "DischargeMedicationStatus";
	public static String PROP_HIN = "Hin";
	public static String PROP_PRESCRIPTION_BY = "PrescriptionBy";
	public static String PROP_OTHER_PRESCRIPTION = "OtherPrescription";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_PHARMACY_LAB_QUEUE = "PharmacyLabQueue";
	public static String PROP_PRESCRIPTION_DATE = "PrescriptionDate";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_OPD_PATIENT_DETAIL = "OpdPatientDetail";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_ISSUED_STATUS = "IssuedStatus";
	public static String PROP_PRESCRIPTION_TIME = "PrescriptionTime";
	public static String PROP_DISPENCING_DATE = "DispencingDate";


	// constructors
	public BasePatientPrescriptionHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientPrescriptionHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date prescriptionDate;
	private java.lang.String prescriptionTime;
	private java.lang.String prescriptionNo;
	private java.lang.String otherPrescription;
	private java.lang.String issuedStatus;
	private java.util.Date dispencingDate;
	private java.lang.String remarksForCt;
	private java.lang.String dischargeMedicationStatus;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetail;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee prescriptionBy;
	private jkt.hms.masters.business.PharmacyLabQueue pharmacyLabQueue;

	// collections
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="prescription_id"
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
	 * Return the value associated with the column: prescription_date
	 */
	public java.util.Date getPrescriptionDate () {
		return prescriptionDate;
	}

	/**
	 * Set the value related to the column: prescription_date
	 * @param prescriptionDate the prescription_date value
	 */
	public void setPrescriptionDate (java.util.Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}



	/**
	 * Return the value associated with the column: prescription_time
	 */
	public java.lang.String getPrescriptionTime () {
		return prescriptionTime;
	}

	/**
	 * Set the value related to the column: prescription_time
	 * @param prescriptionTime the prescription_time value
	 */
	public void setPrescriptionTime (java.lang.String prescriptionTime) {
		this.prescriptionTime = prescriptionTime;
	}



	/**
	 * Return the value associated with the column: prescription_no
	 */
	public java.lang.String getPrescriptionNo () {
		return prescriptionNo;
	}

	/**
	 * Set the value related to the column: prescription_no
	 * @param prescriptionNo the prescription_no value
	 */
	public void setPrescriptionNo (java.lang.String prescriptionNo) {
		this.prescriptionNo = prescriptionNo;
	}



	/**
	 * Return the value associated with the column: other_prescription
	 */
	public java.lang.String getOtherPrescription () {
		return otherPrescription;
	}

	/**
	 * Set the value related to the column: other_prescription
	 * @param otherPrescription the other_prescription value
	 */
	public void setOtherPrescription (java.lang.String otherPrescription) {
		this.otherPrescription = otherPrescription;
	}



	/**
	 * Return the value associated with the column: issued_status
	 */
	public java.lang.String getIssuedStatus () {
		return issuedStatus;
	}

	/**
	 * Set the value related to the column: issued_status
	 * @param issuedStatus the issued_status value
	 */
	public void setIssuedStatus (java.lang.String issuedStatus) {
		this.issuedStatus = issuedStatus;
	}



	/**
	 * Return the value associated with the column: dispencing_date
	 */
	public java.util.Date getDispencingDate () {
		return dispencingDate;
	}

	/**
	 * Set the value related to the column: dispencing_date
	 * @param dispencingDate the dispencing_date value
	 */
	public void setDispencingDate (java.util.Date dispencingDate) {
		this.dispencingDate = dispencingDate;
	}



	/**
	 * Return the value associated with the column: remarks_for_ct
	 */
	public java.lang.String getRemarksForCt () {
		return remarksForCt;
	}

	/**
	 * Set the value related to the column: remarks_for_ct
	 * @param remarksForCt the remarks_for_ct value
	 */
	public void setRemarksForCt (java.lang.String remarksForCt) {
		this.remarksForCt = remarksForCt;
	}



	/**
	 * Return the value associated with the column: discharge_medication_status
	 */
	public java.lang.String getDischargeMedicationStatus () {
		return dischargeMedicationStatus;
	}

	/**
	 * Set the value related to the column: discharge_medication_status
	 * @param dischargeMedicationStatus the discharge_medication_status value
	 */
	public void setDischargeMedicationStatus (java.lang.String dischargeMedicationStatus) {
		this.dischargeMedicationStatus = dischargeMedicationStatus;
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
	 * Return the value associated with the column: prescription_by
	 */
	public jkt.hms.masters.business.MasEmployee getPrescriptionBy () {
		return prescriptionBy;
	}

	/**
	 * Set the value related to the column: prescription_by
	 * @param prescriptionBy the prescription_by value
	 */
	public void setPrescriptionBy (jkt.hms.masters.business.MasEmployee prescriptionBy) {
		this.prescriptionBy = prescriptionBy;
	}



	/**
	 * Return the value associated with the column: pharmacy_lab_queue_id
	 */
	public jkt.hms.masters.business.PharmacyLabQueue getPharmacyLabQueue () {
		return pharmacyLabQueue;
	}

	/**
	 * Set the value related to the column: pharmacy_lab_queue_id
	 * @param pharmacyLabQueue the pharmacy_lab_queue_id value
	 */
	public void setPharmacyLabQueue (jkt.hms.masters.business.PharmacyLabQueue pharmacyLabQueue) {
		this.pharmacyLabQueue = pharmacyLabQueue;
	}



	/**
	 * Return the value associated with the column: PatientPrescriptionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionDetails
	 * @param patientPrescriptionDetails the PatientPrescriptionDetails value
	 */
	public void setPatientPrescriptionDetails (java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
	}

	public void addToPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		if (null == getPatientPrescriptionDetails()) setPatientPrescriptionDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionDetails>());
		getPatientPrescriptionDetails().add(patientPrescriptionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientPrescriptionHeader)) return false;
		else {
			jkt.hms.masters.business.PatientPrescriptionHeader patientPrescriptionHeader = (jkt.hms.masters.business.PatientPrescriptionHeader) obj;
			if (null == this.getId() || null == patientPrescriptionHeader.getId()) return false;
			else return (this.getId().equals(patientPrescriptionHeader.getId()));
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