package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the online_patient_visit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="online_patient_visit"
 */

public abstract class BaseOnlinePatientVisit  implements Serializable {

	public static String REF = "OnlinePatientVisit";
	public static String PROP_HOSPITAL_STAFF = "HospitalStaff";
	public static String PROP_OP_SESSION = "OpSession";
	public static String PROP_OP_CALL_COUNT = "OpCallCount";
	public static String PROP_TOKEN_STATUS = "TokenStatus";
	public static String PROP_VISIT_TIME = "VisitTime";
	public static String PROP_ED_DAYS = "EdDays";
	public static String PROP_SECOND_OPINION_COMMENTS = "SecondOpinionComments";
	public static String PROP_CASE_TYPE_ID = "CaseTypeId";
	public static String PROP_PRIORITY_NUMBER = "PriorityNumber";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_ED_START_DATE = "EdStartDate";
	public static String PROP_LD_START_DATE = "LdStartDate";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_VISIT_NO = "VisitNo";
	public static String PROP_EMPANELLED_VISIT_FLAG = "EmpanelledVisitFlag";
	public static String PROP_OPENBY = "Openby";
	public static String PROP_CASH_RECEIVED_STATUS = "CashReceivedStatus";
	public static String PROP_RESULT_ENTRY_STATUS = "ResultEntryStatus";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_COMPLAINT_ID = "ComplaintId";
	public static String PROP_LD_DAYS = "LdDays";
	public static String PROP_WAITING_POSITION = "WaitingPosition";
	public static String PROP_DISPLAY_TOKEN = "DisplayToken";
	public static String PROP_APPOINTMENT_TYPE = "AppointmentType";
	public static String PROP_ID = "Id";
	public static String PROP_AGE = "Age";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_VISIT_SESSION = "VisitSession";
	public static String PROP_ED_DATE2 = "EdDate2";
	public static String PROP_VISIT_STATUS = "VisitStatus";
	public static String PROP_ED_DATE1 = "EdDate1";
	public static String PROP_ED_DATE3 = "EdDate3";
	public static String PROP_DIAGNOSIS_NAME = "DiagnosisName";
	public static String PROP_CUR_PHAR_VISIT_STATUS = "CurPharVisitStatus";
	public static String PROP_ED_STATUS = "EdStatus";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_DOCTOR_ID = "DoctorId";
	public static String PROP_DISPOSAL_ID = "DisposalId";
	public static String PROP_UNSERVICESED_PHAR_VISIT_STATUS = "UnservicesedPharVisitStatus";
	public static String PROP_TOKEN_NO = "TokenNo";
	public static String PROP_TOTAL_HOSPITAL_VISIT = "TotalHospitalVisit";
	public static String PROP_VISIT_DATE = "VisitDate";
	public static String PROP_DIAGNOSIS_ID = "DiagnosisId";
	public static String PROP_TRIAGE_CATEGORY = "TriageCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_PATIENT_HIN_ID = "PatientHinId";
	public static String PROP_ED_DISPOSE = "EdDispose";
	public static String PROP_OPENAT = "Openat";
	public static String PROP_HIN = "Hin";
	public static String PROP_OP_VISIT_TIME = "OpVisitTime";


	// constructors
	public BaseOnlinePatientVisit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOnlinePatientVisit (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer addEditById;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String age;
	private java.lang.String appointmentType;
	private java.lang.Integer caseTypeId;
	private java.lang.String cashReceivedStatus;
	private java.lang.Integer complaintId;
	private java.lang.String curPharVisitStatus;
	private java.lang.Integer departmentId;
	private java.lang.Integer diagnosisId;
	private java.lang.String diagnosisName;
	private java.lang.Integer displayToken;
	private java.lang.Integer disposalId;
	private java.lang.Integer doctorId;
	private java.util.Date edDate1;
	private java.util.Date edDate2;
	private java.util.Date edDate3;
	private java.lang.Integer edDays;
	private java.lang.String edDispose;
	private java.util.Date edStartDate;
	private java.lang.String edStatus;
	private java.lang.String empanelledVisitFlag;
	private java.lang.Integer hospitalId;
	private java.lang.String hospitalStaff;
	private java.lang.Integer ldDays;
	private java.util.Date ldStartDate;
	private java.lang.Integer opCallCount;
	private java.lang.Integer opSession;
	private java.lang.String opVisitTime;
	private java.lang.String openat;
	private java.lang.Integer openby;
	private java.lang.Integer patientHinId;
	private java.lang.Integer priorityNumber;
	private java.lang.String resultEntryStatus;
	private java.lang.String secondOpinionComments;
	private java.lang.String status;
	private java.lang.Integer tokenNo;
	private java.lang.String tokenStatus;
	private java.lang.Integer totalHospitalVisit;
	private java.lang.Integer triageCategory;
	private java.lang.Integer unitId;
	private java.lang.String unservicesedPharVisitStatus;
	private java.util.Date visitDate;
	private java.lang.Integer visitNo;
	private java.lang.Integer visitSession;
	private java.lang.String visitStatus;
	private java.lang.String visitTime;
	private java.lang.Integer waitingPosition;
	private java.lang.Integer weight;

	// many to one
	private jkt.hms.masters.business.OnlinePatientPortal hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="visit_id"
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
	 * Return the value associated with the column: add_edit_by_id
	 */
	public java.lang.Integer getAddEditById () {
		return addEditById;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditById the add_edit_by_id value
	 */
	public void setAddEditById (java.lang.Integer addEditById) {
		this.addEditById = addEditById;
	}



	/**
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate () {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * @param addEditDate the add_edit_date value
	 */
	public void setAddEditDate (java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}



	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * @param addEditTime the add_edit_time value
	 */
	public void setAddEditTime (java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: appointment_type
	 */
	public java.lang.String getAppointmentType () {
		return appointmentType;
	}

	/**
	 * Set the value related to the column: appointment_type
	 * @param appointmentType the appointment_type value
	 */
	public void setAppointmentType (java.lang.String appointmentType) {
		this.appointmentType = appointmentType;
	}



	/**
	 * Return the value associated with the column: case_type_id
	 */
	public java.lang.Integer getCaseTypeId () {
		return caseTypeId;
	}

	/**
	 * Set the value related to the column: case_type_id
	 * @param caseTypeId the case_type_id value
	 */
	public void setCaseTypeId (java.lang.Integer caseTypeId) {
		this.caseTypeId = caseTypeId;
	}



	/**
	 * Return the value associated with the column: cash_received_status
	 */
	public java.lang.String getCashReceivedStatus () {
		return cashReceivedStatus;
	}

	/**
	 * Set the value related to the column: cash_received_status
	 * @param cashReceivedStatus the cash_received_status value
	 */
	public void setCashReceivedStatus (java.lang.String cashReceivedStatus) {
		this.cashReceivedStatus = cashReceivedStatus;
	}



	/**
	 * Return the value associated with the column: complaint_id
	 */
	public java.lang.Integer getComplaintId () {
		return complaintId;
	}

	/**
	 * Set the value related to the column: complaint_id
	 * @param complaintId the complaint_id value
	 */
	public void setComplaintId (java.lang.Integer complaintId) {
		this.complaintId = complaintId;
	}



	/**
	 * Return the value associated with the column: cur_phar_visit_status
	 */
	public java.lang.String getCurPharVisitStatus () {
		return curPharVisitStatus;
	}

	/**
	 * Set the value related to the column: cur_phar_visit_status
	 * @param curPharVisitStatus the cur_phar_visit_status value
	 */
	public void setCurPharVisitStatus (java.lang.String curPharVisitStatus) {
		this.curPharVisitStatus = curPharVisitStatus;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public java.lang.Integer getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departmentId the department_id value
	 */
	public void setDepartmentId (java.lang.Integer departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: diagnosis_id
	 */
	public java.lang.Integer getDiagnosisId () {
		return diagnosisId;
	}

	/**
	 * Set the value related to the column: diagnosis_id
	 * @param diagnosisId the diagnosis_id value
	 */
	public void setDiagnosisId (java.lang.Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}



	/**
	 * Return the value associated with the column: diagnosis_name
	 */
	public java.lang.String getDiagnosisName () {
		return diagnosisName;
	}

	/**
	 * Set the value related to the column: diagnosis_name
	 * @param diagnosisName the diagnosis_name value
	 */
	public void setDiagnosisName (java.lang.String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}



	/**
	 * Return the value associated with the column: display_token
	 */
	public java.lang.Integer getDisplayToken () {
		return displayToken;
	}

	/**
	 * Set the value related to the column: display_token
	 * @param displayToken the display_token value
	 */
	public void setDisplayToken (java.lang.Integer displayToken) {
		this.displayToken = displayToken;
	}



	/**
	 * Return the value associated with the column: disposal_id
	 */
	public java.lang.Integer getDisposalId () {
		return disposalId;
	}

	/**
	 * Set the value related to the column: disposal_id
	 * @param disposalId the disposal_id value
	 */
	public void setDisposalId (java.lang.Integer disposalId) {
		this.disposalId = disposalId;
	}



	/**
	 * Return the value associated with the column: doctor_id
	 */
	public java.lang.Integer getDoctorId () {
		return doctorId;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctorId the doctor_id value
	 */
	public void setDoctorId (java.lang.Integer doctorId) {
		this.doctorId = doctorId;
	}



	/**
	 * Return the value associated with the column: ed_date1
	 */
	public java.util.Date getEdDate1 () {
		return edDate1;
	}

	/**
	 * Set the value related to the column: ed_date1
	 * @param edDate1 the ed_date1 value
	 */
	public void setEdDate1 (java.util.Date edDate1) {
		this.edDate1 = edDate1;
	}



	/**
	 * Return the value associated with the column: ed_date2
	 */
	public java.util.Date getEdDate2 () {
		return edDate2;
	}

	/**
	 * Set the value related to the column: ed_date2
	 * @param edDate2 the ed_date2 value
	 */
	public void setEdDate2 (java.util.Date edDate2) {
		this.edDate2 = edDate2;
	}



	/**
	 * Return the value associated with the column: ed_date3
	 */
	public java.util.Date getEdDate3 () {
		return edDate3;
	}

	/**
	 * Set the value related to the column: ed_date3
	 * @param edDate3 the ed_date3 value
	 */
	public void setEdDate3 (java.util.Date edDate3) {
		this.edDate3 = edDate3;
	}



	/**
	 * Return the value associated with the column: ed_days
	 */
	public java.lang.Integer getEdDays () {
		return edDays;
	}

	/**
	 * Set the value related to the column: ed_days
	 * @param edDays the ed_days value
	 */
	public void setEdDays (java.lang.Integer edDays) {
		this.edDays = edDays;
	}



	/**
	 * Return the value associated with the column: ed_dispose
	 */
	public java.lang.String getEdDispose () {
		return edDispose;
	}

	/**
	 * Set the value related to the column: ed_dispose
	 * @param edDispose the ed_dispose value
	 */
	public void setEdDispose (java.lang.String edDispose) {
		this.edDispose = edDispose;
	}



	/**
	 * Return the value associated with the column: ed_start_date
	 */
	public java.util.Date getEdStartDate () {
		return edStartDate;
	}

	/**
	 * Set the value related to the column: ed_start_date
	 * @param edStartDate the ed_start_date value
	 */
	public void setEdStartDate (java.util.Date edStartDate) {
		this.edStartDate = edStartDate;
	}



	/**
	 * Return the value associated with the column: ed_status
	 */
	public java.lang.String getEdStatus () {
		return edStatus;
	}

	/**
	 * Set the value related to the column: ed_status
	 * @param edStatus the ed_status value
	 */
	public void setEdStatus (java.lang.String edStatus) {
		this.edStatus = edStatus;
	}



	/**
	 * Return the value associated with the column: empanelled_visit_flag
	 */
	public java.lang.String getEmpanelledVisitFlag () {
		return empanelledVisitFlag;
	}

	/**
	 * Set the value related to the column: empanelled_visit_flag
	 * @param empanelledVisitFlag the empanelled_visit_flag value
	 */
	public void setEmpanelledVisitFlag (java.lang.String empanelledVisitFlag) {
		this.empanelledVisitFlag = empanelledVisitFlag;
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
	 * Return the value associated with the column: hospital_staff
	 */
	public java.lang.String getHospitalStaff () {
		return hospitalStaff;
	}

	/**
	 * Set the value related to the column: hospital_staff
	 * @param hospitalStaff the hospital_staff value
	 */
	public void setHospitalStaff (java.lang.String hospitalStaff) {
		this.hospitalStaff = hospitalStaff;
	}



	/**
	 * Return the value associated with the column: ld_days
	 */
	public java.lang.Integer getLdDays () {
		return ldDays;
	}

	/**
	 * Set the value related to the column: ld_days
	 * @param ldDays the ld_days value
	 */
	public void setLdDays (java.lang.Integer ldDays) {
		this.ldDays = ldDays;
	}



	/**
	 * Return the value associated with the column: ld_start_date
	 */
	public java.util.Date getLdStartDate () {
		return ldStartDate;
	}

	/**
	 * Set the value related to the column: ld_start_date
	 * @param ldStartDate the ld_start_date value
	 */
	public void setLdStartDate (java.util.Date ldStartDate) {
		this.ldStartDate = ldStartDate;
	}



	/**
	 * Return the value associated with the column: op_call_count
	 */
	public java.lang.Integer getOpCallCount () {
		return opCallCount;
	}

	/**
	 * Set the value related to the column: op_call_count
	 * @param opCallCount the op_call_count value
	 */
	public void setOpCallCount (java.lang.Integer opCallCount) {
		this.opCallCount = opCallCount;
	}



	/**
	 * Return the value associated with the column: op_session
	 */
	public java.lang.Integer getOpSession () {
		return opSession;
	}

	/**
	 * Set the value related to the column: op_session
	 * @param opSession the op_session value
	 */
	public void setOpSession (java.lang.Integer opSession) {
		this.opSession = opSession;
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
	 * Return the value associated with the column: openat
	 */
	public java.lang.String getOpenat () {
		return openat;
	}

	/**
	 * Set the value related to the column: openat
	 * @param openat the openat value
	 */
	public void setOpenat (java.lang.String openat) {
		this.openat = openat;
	}



	/**
	 * Return the value associated with the column: openby
	 */
	public java.lang.Integer getOpenby () {
		return openby;
	}

	/**
	 * Set the value related to the column: openby
	 * @param openby the openby value
	 */
	public void setOpenby (java.lang.Integer openby) {
		this.openby = openby;
	}



	/**
	 * Return the value associated with the column: patient_hin_id
	 */
	public java.lang.Integer getPatientHinId () {
		return patientHinId;
	}

	/**
	 * Set the value related to the column: patient_hin_id
	 * @param patientHinId the patient_hin_id value
	 */
	public void setPatientHinId (java.lang.Integer patientHinId) {
		this.patientHinId = patientHinId;
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
	 * Return the value associated with the column: result_entry_status
	 */
	public java.lang.String getResultEntryStatus () {
		return resultEntryStatus;
	}

	/**
	 * Set the value related to the column: result_entry_status
	 * @param resultEntryStatus the result_entry_status value
	 */
	public void setResultEntryStatus (java.lang.String resultEntryStatus) {
		this.resultEntryStatus = resultEntryStatus;
	}



	/**
	 * Return the value associated with the column: second_opinion_comments
	 */
	public java.lang.String getSecondOpinionComments () {
		return secondOpinionComments;
	}

	/**
	 * Set the value related to the column: second_opinion_comments
	 * @param secondOpinionComments the second_opinion_comments value
	 */
	public void setSecondOpinionComments (java.lang.String secondOpinionComments) {
		this.secondOpinionComments = secondOpinionComments;
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
	 * Return the value associated with the column: triage_category
	 */
	public java.lang.Integer getTriageCategory () {
		return triageCategory;
	}

	/**
	 * Set the value related to the column: triage_category
	 * @param triageCategory the triage_category value
	 */
	public void setTriageCategory (java.lang.Integer triageCategory) {
		this.triageCategory = triageCategory;
	}



	/**
	 * Return the value associated with the column: unit_id
	 */
	public java.lang.Integer getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unitId the unit_id value
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
	}



	/**
	 * Return the value associated with the column: unservicesed_phar_visit_status
	 */
	public java.lang.String getUnservicesedPharVisitStatus () {
		return unservicesedPharVisitStatus;
	}

	/**
	 * Set the value related to the column: unservicesed_phar_visit_status
	 * @param unservicesedPharVisitStatus the unservicesed_phar_visit_status value
	 */
	public void setUnservicesedPharVisitStatus (java.lang.String unservicesedPharVisitStatus) {
		this.unservicesedPharVisitStatus = unservicesedPharVisitStatus;
	}



	/**
	 * Return the value associated with the column: visit_date
	 */
	public java.util.Date getVisitDate () {
		return visitDate;
	}

	/**
	 * Set the value related to the column: visit_date
	 * @param visitDate the visit_date value
	 */
	public void setVisitDate (java.util.Date visitDate) {
		this.visitDate = visitDate;
	}



	/**
	 * Return the value associated with the column: visit_no
	 */
	public java.lang.Integer getVisitNo () {
		return visitNo;
	}

	/**
	 * Set the value related to the column: visit_no
	 * @param visitNo the visit_no value
	 */
	public void setVisitNo (java.lang.Integer visitNo) {
		this.visitNo = visitNo;
	}



	/**
	 * Return the value associated with the column: visit_session
	 */
	public java.lang.Integer getVisitSession () {
		return visitSession;
	}

	/**
	 * Set the value related to the column: visit_session
	 * @param visitSession the visit_session value
	 */
	public void setVisitSession (java.lang.Integer visitSession) {
		this.visitSession = visitSession;
	}



	/**
	 * Return the value associated with the column: visit_status
	 */
	public java.lang.String getVisitStatus () {
		return visitStatus;
	}

	/**
	 * Set the value related to the column: visit_status
	 * @param visitStatus the visit_status value
	 */
	public void setVisitStatus (java.lang.String visitStatus) {
		this.visitStatus = visitStatus;
	}



	/**
	 * Return the value associated with the column: visit_time
	 */
	public java.lang.String getVisitTime () {
		return visitTime;
	}

	/**
	 * Set the value related to the column: visit_time
	 * @param visitTime the visit_time value
	 */
	public void setVisitTime (java.lang.String visitTime) {
		this.visitTime = visitTime;
	}



	/**
	 * Return the value associated with the column: waiting_position
	 */
	public java.lang.Integer getWaitingPosition () {
		return waitingPosition;
	}

	/**
	 * Set the value related to the column: waiting_position
	 * @param waitingPosition the waiting_position value
	 */
	public void setWaitingPosition (java.lang.Integer waitingPosition) {
		this.waitingPosition = waitingPosition;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.Integer getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.Integer weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.OnlinePatientPortal getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.OnlinePatientPortal hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OnlinePatientVisit)) return false;
		else {
			jkt.hms.masters.business.OnlinePatientVisit onlinePatientVisit = (jkt.hms.masters.business.OnlinePatientVisit) obj;
			if (null == this.getId() || null == onlinePatientVisit.getId()) return false;
			else return (this.getId().equals(onlinePatientVisit.getId()));
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