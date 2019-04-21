package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the queue_managment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="queue_managment"
 */

public abstract class BaseQueueManagment  implements Serializable {

	public static String REF = "QueueManagment";
	public static String PROP_PRIORITY_NUMBER = "PriorityNumber";
	public static String PROP_LS_CNG_TIME = "LsCngTime";
	public static String PROP_OP_VISIT_TIME = "OpVisitTime";
	public static String PROP_VISIT = "Visit";
	public static String PROP_INITIAL_DR = "InitialDr";
	public static String PROP_TRANSFER_TO_COMMON_POOL_COUNT = "TransferToCommonPoolCount";
	public static String PROP_HIN = "Hin";
	public static String PROP_SKIP_COUNT = "SkipCount";
	public static String PROP_TRANSFER_TO_OTHER_DOCTOR_COUNT = "TransferToOtherDoctorCount";
	public static String PROP_TOKEN_NO = "TokenNo";
	public static String PROP_TOTAL_HOSPITAL_VISIT = "TotalHospitalVisit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_TOKEN_STATUS = "TokenStatus";
	public static String PROP_DOCOTOR = "Docotor";
	public static String PROP_LS_CNG_DATE = "LsCngDate";
	public static String PROP_PATIENT_SPECIAL_CATEGORY = "PatientSpecialCategory";
	public static String PROP_REFER_BACK = "ReferBack";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ASSIGNED_DOCTOR_ID = "AssignedDoctorId";


	// constructors
	public BaseQueueManagment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseQueueManagment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer tokenNo;
	private java.lang.String tokenStatus;
	private java.lang.Integer priorityNumber;
	private java.lang.Integer totalHospitalVisit;
	private java.lang.Integer skipCount;
	private java.util.Date lsCngDate;
	private java.lang.String lsCngTime;
	private java.lang.String opVisitTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String patientSpecialCategory;
	private java.lang.Integer assignedDoctorId;
	private java.lang.Integer transferToCommonPoolCount;
	private java.lang.Integer transferToOtherDoctorCount;
	private java.lang.String referBack;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee docotor;
	private jkt.hms.masters.business.MasEmployee initialDr;



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
	 * Return the value associated with the column: token_status
	 */
	public java.lang.String getTokenStatus () {
		return tokenStatus;
	}

	/**
	 * Set the value related to the column: token_status
	 * @param tokenStatus the token_status value
	 */
	public void setTokenStatus (java.lang.String tokenStatus) {
		this.tokenStatus = tokenStatus;
	}



	/**
	 * Return the value associated with the column: priority_number
	 */
	public java.lang.Integer getPriorityNumber () {
		return priorityNumber;
	}

	/**
	 * Set the value related to the column: priority_number
	 * @param priorityNumber the priority_number value
	 */
	public void setPriorityNumber (java.lang.Integer priorityNumber) {
		this.priorityNumber = priorityNumber;
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
	 * Return the value associated with the column: skip_count
	 */
	public java.lang.Integer getSkipCount () {
		return skipCount;
	}

	/**
	 * Set the value related to the column: skip_count
	 * @param skipCount the skip_count value
	 */
	public void setSkipCount (java.lang.Integer skipCount) {
		this.skipCount = skipCount;
	}



	/**
	 * Return the value associated with the column: ls_cng_date
	 */
	public java.util.Date getLsCngDate () {
		return lsCngDate;
	}

	/**
	 * Set the value related to the column: ls_cng_date
	 * @param lsCngDate the ls_cng_date value
	 */
	public void setLsCngDate (java.util.Date lsCngDate) {
		this.lsCngDate = lsCngDate;
	}



	/**
	 * Return the value associated with the column: ls_cng_time
	 */
	public java.lang.String getLsCngTime () {
		return lsCngTime;
	}

	/**
	 * Set the value related to the column: ls_cng_time
	 * @param lsCngTime the ls_cng_time value
	 */
	public void setLsCngTime (java.lang.String lsCngTime) {
		this.lsCngTime = lsCngTime;
	}



	/**
	 * Return the value associated with the column: op_visit_time
	 */
	public java.lang.String getOpVisitTime () {
		return opVisitTime;
	}

	/**
	 * Set the value related to the column: op_visit_time
	 * @param opVisitTime the op_visit_time value
	 */
	public void setOpVisitTime (java.lang.String opVisitTime) {
		this.opVisitTime = opVisitTime;
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
	 * Return the value associated with the column: patient_special_category
	 */
	public java.lang.String getPatientSpecialCategory () {
		return patientSpecialCategory;
	}

	/**
	 * Set the value related to the column: patient_special_category
	 * @param patientSpecialCategory the patient_special_category value
	 */
	public void setPatientSpecialCategory (java.lang.String patientSpecialCategory) {
		this.patientSpecialCategory = patientSpecialCategory;
	}



	/**
	 * Return the value associated with the column: assigned_doctor_id
	 */
	public java.lang.Integer getAssignedDoctorId () {
		return assignedDoctorId;
	}

	/**
	 * Set the value related to the column: assigned_doctor_id
	 * @param assignedDoctorId the assigned_doctor_id value
	 */
	public void setAssignedDoctorId (java.lang.Integer assignedDoctorId) {
		this.assignedDoctorId = assignedDoctorId;
	}



	/**
	 * Return the value associated with the column: transfer_to_common_pool_count
	 */
	public java.lang.Integer getTransferToCommonPoolCount () {
		return transferToCommonPoolCount;
	}

	/**
	 * Set the value related to the column: transfer_to_common_pool_count
	 * @param transferToCommonPoolCount the transfer_to_common_pool_count value
	 */
	public void setTransferToCommonPoolCount (java.lang.Integer transferToCommonPoolCount) {
		this.transferToCommonPoolCount = transferToCommonPoolCount;
	}



	/**
	 * Return the value associated with the column: transfer_to_other_doctor_count
	 */
	public java.lang.Integer getTransferToOtherDoctorCount () {
		return transferToOtherDoctorCount;
	}

	/**
	 * Set the value related to the column: transfer_to_other_doctor_count
	 * @param transferToOtherDoctorCount the transfer_to_other_doctor_count value
	 */
	public void setTransferToOtherDoctorCount (java.lang.Integer transferToOtherDoctorCount) {
		this.transferToOtherDoctorCount = transferToOtherDoctorCount;
	}



	/**
	 * Return the value associated with the column: refer_back
	 */
	public java.lang.String getReferBack () {
		return referBack;
	}

	/**
	 * Set the value related to the column: refer_back
	 * @param referBack the refer_back value
	 */
	public void setReferBack (java.lang.String referBack) {
		this.referBack = referBack;
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
	 * Return the value associated with the column: docotor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDocotor () {
		return docotor;
	}

	/**
	 * Set the value related to the column: docotor_id
	 * @param docotor the docotor_id value
	 */
	public void setDocotor (jkt.hms.masters.business.MasEmployee docotor) {
		this.docotor = docotor;
	}



	/**
	 * Return the value associated with the column: initial_dr_id
	 */
	public jkt.hms.masters.business.MasEmployee getInitialDr () {
		return initialDr;
	}

	/**
	 * Set the value related to the column: initial_dr_id
	 * @param initialDr the initial_dr_id value
	 */
	public void setInitialDr (jkt.hms.masters.business.MasEmployee initialDr) {
		this.initialDr = initialDr;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.QueueManagment)) return false;
		else {
			jkt.hms.masters.business.QueueManagment queueManagment = (jkt.hms.masters.business.QueueManagment) obj;
			if (null == this.getId() || null == queueManagment.getId()) return false;
			else return (this.getId().equals(queueManagment.getId()));
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