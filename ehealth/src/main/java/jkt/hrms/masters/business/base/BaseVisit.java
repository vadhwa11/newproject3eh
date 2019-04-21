package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the visit table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="visit"
 */

public abstract class BaseVisit implements Serializable {

	public static String REF = "Visit";
	public static String PROP_STATUS = "Status";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_ED_DAYS = "EdDays";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_VISIT_TIME = "VisitTime";
	public static String PROP_LD_START_DATE = "LdStartDate";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_LD_DAYS = "LdDays";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_APPOINTMENT_TYPE = "AppointmentType";
	public static String PROP_ED_DATE2 = "EdDate2";
	public static String PROP_VISIT_STATUS = "VisitStatus";
	public static String PROP_VISIT_NO = "VisitNo";
	public static String PROP_ED_DATE1 = "EdDate1";
	public static String PROP_ED_DISPOSE = "EdDispose";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_TOKEN_NO = "TokenNo";
	public static String PROP_DIAGNOSIS_NAME = "DiagnosisName";
	public static String PROP_ED_STATUS = "EdStatus";
	public static String PROP_CASE_TYPE = "CaseType";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_HIN = "Hin";
	public static String PROP_VISIT_DATE = "VisitDate";
	public static String PROP_ED_DATE3 = "EdDate3";
	public static String PROP_AGE = "Age";
	public static String PROP_HOSPITAL_STAFF = "HospitalStaff";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_COMPLAINT = "Complaint";
	public static String PROP_ED_START_DATE = "EdStartDate";
	public static String PROP_ID = "Id";

	// constructors
	public BaseVisit() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVisit(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer visitNo;
	private java.lang.Integer tokenNo;
	private java.lang.String age;
	private java.lang.String hospitalStaff;
	private java.util.Date visitDate;
	private java.lang.String visitTime;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String status;
	private java.lang.Integer edDays;
	private java.lang.String edStatus;
	private java.lang.String edDispose;
	private java.lang.Integer ldDays;
	private java.util.Date ldStartDate;
	private java.util.Date edStartDate;
	private java.util.Date edDate1;
	private java.util.Date edDate2;
	private java.util.Date edDate3;
	private java.lang.String visitStatus;
	private java.lang.String appointmentType;
	private java.lang.String diagnosisName;
	private java.lang.Integer weight;

	// many to one
	private jkt.hms.masters.business.MasCaseType caseType;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.MasDiagnosisConclusion diagnosis;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasComplaint complaint;
	private jkt.hms.masters.business.MasDisposal disposal;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails;
	private java.util.Set<jkt.hms.masters.business.OtPreAnesthesiaDetails> otPreAnesthesiaDetails;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopies;
	private java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> otPreAnaesthesiaProcNotesMains;
	private java.util.Set<jkt.hms.masters.business.OpdGynaecology> opdGynaecologies;
	private java.util.Set<jkt.hms.masters.business.OpdOncology> opdOncologies;
	private java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets;
	private java.util.Set<jkt.hms.masters.business.OpdOphthalmology> opdOphthalmologies;
	private java.util.Set<jkt.hms.masters.business.OpdPatientDetails> opdPatientDetails;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs;
	private java.util.Set<jkt.hms.masters.business.OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedures;
	private java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryHeader> otProcedureNotesEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes;
	private java.util.Set<jkt.hms.masters.business.OtSpecimenDispatchEntry> otSpecimenDispatchEntries;
	private java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns;
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> opdOphFollowUps;
	private java.util.Set<jkt.hms.masters.business.OpdUrology> opdUrologies;
	private java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> opdOphRetinalHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> opdOphDiagnosisHeaders;
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans;
	private java.util.Set<jkt.hms.masters.business.OpdTemplateDepartmentWise> opdTemplateDepartmentWises;
	private java.util.Set<jkt.hms.masters.business.OpdOncosurgeryCaseSheet> opdOncosurgeryCaseSheets;
	private java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> opdGravidagramGestationalDiabitiesTwos;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopies;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards;
	private java.util.Set<jkt.hms.masters.business.OtBooking> otBookings;
	private java.util.Set<jkt.hms.masters.business.UploadDocuments> uploadDocuments;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="visit_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: visit_no
	 */
	public java.lang.Integer getVisitNo() {
		return visitNo;
	}

	/**
	 * Set the value related to the column: visit_no
	 * 
	 * @param visitNo
	 *            the visit_no value
	 */
	public void setVisitNo(java.lang.Integer visitNo) {
		this.visitNo = visitNo;
	}

	/**
	 * Return the value associated with the column: token_no
	 */
	public java.lang.Integer getTokenNo() {
		return tokenNo;
	}

	/**
	 * Set the value related to the column: token_no
	 * 
	 * @param tokenNo
	 *            the token_no value
	 */
	public void setTokenNo(java.lang.Integer tokenNo) {
		this.tokenNo = tokenNo;
	}

	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge() {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * 
	 * @param age
	 *            the age value
	 */
	public void setAge(java.lang.String age) {
		this.age = age;
	}

	/**
	 * Return the value associated with the column: hospital_staff
	 */
	public java.lang.String getHospitalStaff() {
		return hospitalStaff;
	}

	/**
	 * Set the value related to the column: hospital_staff
	 * 
	 * @param hospitalStaff
	 *            the hospital_staff value
	 */
	public void setHospitalStaff(java.lang.String hospitalStaff) {
		this.hospitalStaff = hospitalStaff;
	}

	/**
	 * Return the value associated with the column: visit_date
	 */
	public java.util.Date getVisitDate() {
		return visitDate;
	}

	/**
	 * Set the value related to the column: visit_date
	 * 
	 * @param visitDate
	 *            the visit_date value
	 */
	public void setVisitDate(java.util.Date visitDate) {
		this.visitDate = visitDate;
	}

	/**
	 * Return the value associated with the column: visit_time
	 */
	public java.lang.String getVisitTime() {
		return visitTime;
	}

	/**
	 * Set the value related to the column: visit_time
	 * 
	 * @param visitTime
	 *            the visit_time value
	 */
	public void setVisitTime(java.lang.String visitTime) {
		this.visitTime = visitTime;
	}

	/**
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate() {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * 
	 * @param addEditDate
	 *            the add_edit_date value
	 */
	public void setAddEditDate(java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}

	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime() {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * 
	 * @param addEditTime
	 *            the add_edit_time value
	 */
	public void setAddEditTime(java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: ed_days
	 */
	public java.lang.Integer getEdDays() {
		return edDays;
	}

	/**
	 * Set the value related to the column: ed_days
	 * 
	 * @param edDays
	 *            the ed_days value
	 */
	public void setEdDays(java.lang.Integer edDays) {
		this.edDays = edDays;
	}

	/**
	 * Return the value associated with the column: ed_status
	 */
	public java.lang.String getEdStatus() {
		return edStatus;
	}

	/**
	 * Set the value related to the column: ed_status
	 * 
	 * @param edStatus
	 *            the ed_status value
	 */
	public void setEdStatus(java.lang.String edStatus) {
		this.edStatus = edStatus;
	}

	/**
	 * Return the value associated with the column: ed_dispose
	 */
	public java.lang.String getEdDispose() {
		return edDispose;
	}

	/**
	 * Set the value related to the column: ed_dispose
	 * 
	 * @param edDispose
	 *            the ed_dispose value
	 */
	public void setEdDispose(java.lang.String edDispose) {
		this.edDispose = edDispose;
	}

	/**
	 * Return the value associated with the column: ld_days
	 */
	public java.lang.Integer getLdDays() {
		return ldDays;
	}

	/**
	 * Set the value related to the column: ld_days
	 * 
	 * @param ldDays
	 *            the ld_days value
	 */
	public void setLdDays(java.lang.Integer ldDays) {
		this.ldDays = ldDays;
	}

	/**
	 * Return the value associated with the column: ld_start_date
	 */
	public java.util.Date getLdStartDate() {
		return ldStartDate;
	}

	/**
	 * Set the value related to the column: ld_start_date
	 * 
	 * @param ldStartDate
	 *            the ld_start_date value
	 */
	public void setLdStartDate(java.util.Date ldStartDate) {
		this.ldStartDate = ldStartDate;
	}

	/**
	 * Return the value associated with the column: ed_start_date
	 */
	public java.util.Date getEdStartDate() {
		return edStartDate;
	}

	/**
	 * Set the value related to the column: ed_start_date
	 * 
	 * @param edStartDate
	 *            the ed_start_date value
	 */
	public void setEdStartDate(java.util.Date edStartDate) {
		this.edStartDate = edStartDate;
	}

	/**
	 * Return the value associated with the column: ed_date1
	 */
	public java.util.Date getEdDate1() {
		return edDate1;
	}

	/**
	 * Set the value related to the column: ed_date1
	 * 
	 * @param edDate1
	 *            the ed_date1 value
	 */
	public void setEdDate1(java.util.Date edDate1) {
		this.edDate1 = edDate1;
	}

	/**
	 * Return the value associated with the column: ed_date2
	 */
	public java.util.Date getEdDate2() {
		return edDate2;
	}

	/**
	 * Set the value related to the column: ed_date2
	 * 
	 * @param edDate2
	 *            the ed_date2 value
	 */
	public void setEdDate2(java.util.Date edDate2) {
		this.edDate2 = edDate2;
	}

	/**
	 * Return the value associated with the column: ed_date3
	 */
	public java.util.Date getEdDate3() {
		return edDate3;
	}

	/**
	 * Set the value related to the column: ed_date3
	 * 
	 * @param edDate3
	 *            the ed_date3 value
	 */
	public void setEdDate3(java.util.Date edDate3) {
		this.edDate3 = edDate3;
	}

	/**
	 * Return the value associated with the column: visit_status
	 */
	public java.lang.String getVisitStatus() {
		return visitStatus;
	}

	/**
	 * Set the value related to the column: visit_status
	 * 
	 * @param visitStatus
	 *            the visit_status value
	 */
	public void setVisitStatus(java.lang.String visitStatus) {
		this.visitStatus = visitStatus;
	}

	/**
	 * Return the value associated with the column: appointment_type
	 */
	public java.lang.String getAppointmentType() {
		return appointmentType;
	}

	/**
	 * Set the value related to the column: appointment_type
	 * 
	 * @param appointmentType
	 *            the appointment_type value
	 */
	public void setAppointmentType(java.lang.String appointmentType) {
		this.appointmentType = appointmentType;
	}

	/**
	 * Return the value associated with the column: diagnosis_name
	 */
	public java.lang.String getDiagnosisName() {
		return diagnosisName;
	}

	/**
	 * Set the value related to the column: diagnosis_name
	 * 
	 * @param diagnosisName
	 *            the diagnosis_name value
	 */
	public void setDiagnosisName(java.lang.String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.Integer getWeight() {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * 
	 * @param weight
	 *            the weight value
	 */
	public void setWeight(java.lang.Integer weight) {
		this.weight = weight;
	}

	/**
	 * Return the value associated with the column: case_type_id
	 */
	public jkt.hms.masters.business.MasCaseType getCaseType() {
		return caseType;
	}

	/**
	 * Set the value related to the column: case_type_id
	 * 
	 * @param caseType
	 *            the case_type_id value
	 */
	public void setCaseType(jkt.hms.masters.business.MasCaseType caseType) {
		this.caseType = caseType;
	}

	/**
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor() {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * 
	 * @param doctor
	 *            the doctor_id value
	 */
	public void setDoctor(jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
	}

	/**
	 * Return the value associated with the column: diagnosis_id
	 */
	public jkt.hms.masters.business.MasDiagnosisConclusion getDiagnosis() {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis_id
	 * 
	 * @param diagnosis
	 *            the diagnosis_id value
	 */
	public void setDiagnosis(
			jkt.hms.masters.business.MasDiagnosisConclusion diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy() {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * 
	 * @param addEditBy
	 *            the add_edit_by_id value
	 */
	public void setAddEditBy(jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
	}

	/**
	 * Return the value associated with the column: complaint_id
	 */
	public jkt.hms.masters.business.MasComplaint getComplaint() {
		return complaint;
	}

	/**
	 * Set the value related to the column: complaint_id
	 * 
	 * @param complaint
	 *            the complaint_id value
	 */
	public void setComplaint(jkt.hms.masters.business.MasComplaint complaint) {
		this.complaint = complaint;
	}

	/**
	 * Return the value associated with the column: disposal_id
	 */
	public jkt.hms.masters.business.MasDisposal getDisposal() {
		return disposal;
	}

	/**
	 * Set the value related to the column: disposal_id
	 * 
	 * @param disposal
	 *            the disposal_id value
	 */
	public void setDisposal(jkt.hms.masters.business.MasDisposal disposal) {
		this.disposal = disposal;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	/**
	 * Return the value associated with the column:
	 * OpdCardiologyDepartmentDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> getOpdCardiologyDepartmentDetails() {
		return opdCardiologyDepartmentDetails;
	}

	/**
	 * Set the value related to the column: OpdCardiologyDepartmentDetails
	 * 
	 * @param opdCardiologyDepartmentDetails
	 *            the OpdCardiologyDepartmentDetails value
	 */
	public void setOpdCardiologyDepartmentDetails(
			java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails) {
		this.opdCardiologyDepartmentDetails = opdCardiologyDepartmentDetails;
	}

	/**
	 * Return the value associated with the column: OtPreAnesthesiaDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtPreAnesthesiaDetails> getOtPreAnesthesiaDetails() {
		return otPreAnesthesiaDetails;
	}

	/**
	 * Set the value related to the column: OtPreAnesthesiaDetails
	 * 
	 * @param otPreAnesthesiaDetails
	 *            the OtPreAnesthesiaDetails value
	 */
	public void setOtPreAnesthesiaDetails(
			java.util.Set<jkt.hms.masters.business.OtPreAnesthesiaDetails> otPreAnesthesiaDetails) {
		this.otPreAnesthesiaDetails = otPreAnesthesiaDetails;
	}

	/**
	 * Return the value associated with the column:
	 * OpdGastroEnterologyColonoscopies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> getOpdGastroEnterologyColonoscopies() {
		return opdGastroEnterologyColonoscopies;
	}

	/**
	 * Set the value related to the column: OpdGastroEnterologyColonoscopies
	 * 
	 * @param opdGastroEnterologyColonoscopies
	 *            the OpdGastroEnterologyColonoscopies value
	 */
	public void setOpdGastroEnterologyColonoscopies(
			java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopies) {
		this.opdGastroEnterologyColonoscopies = opdGastroEnterologyColonoscopies;
	}

	/**
	 * Return the value associated with the column:
	 * OtPreAnaesthesiaProcNotesMains
	 */
	public java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> getOtPreAnaesthesiaProcNotesMains() {
		return otPreAnaesthesiaProcNotesMains;
	}

	/**
	 * Set the value related to the column: OtPreAnaesthesiaProcNotesMains
	 * 
	 * @param otPreAnaesthesiaProcNotesMains
	 *            the OtPreAnaesthesiaProcNotesMains value
	 */
	public void setOtPreAnaesthesiaProcNotesMains(
			java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> otPreAnaesthesiaProcNotesMains) {
		this.otPreAnaesthesiaProcNotesMains = otPreAnaesthesiaProcNotesMains;
	}

	/**
	 * Return the value associated with the column: OpdGynaecologies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGynaecology> getOpdGynaecologies() {
		return opdGynaecologies;
	}

	/**
	 * Set the value related to the column: OpdGynaecologies
	 * 
	 * @param opdGynaecologies
	 *            the OpdGynaecologies value
	 */
	public void setOpdGynaecologies(
			java.util.Set<jkt.hms.masters.business.OpdGynaecology> opdGynaecologies) {
		this.opdGynaecologies = opdGynaecologies;
	}

	/**
	 * Return the value associated with the column: OpdOncologies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOncology> getOpdOncologies() {
		return opdOncologies;
	}

	/**
	 * Set the value related to the column: OpdOncologies
	 * 
	 * @param opdOncologies
	 *            the OpdOncologies value
	 */
	public void setOpdOncologies(
			java.util.Set<jkt.hms.masters.business.OpdOncology> opdOncologies) {
		this.opdOncologies = opdOncologies;
	}

	/**
	 * Return the value associated with the column: PatientInvestigationHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> getPatientInvestigationHeaders() {
		return patientInvestigationHeaders;
	}

	/**
	 * Set the value related to the column: PatientInvestigationHeaders
	 * 
	 * @param patientInvestigationHeaders
	 *            the PatientInvestigationHeaders value
	 */
	public void setPatientInvestigationHeaders(
			java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders) {
		this.patientInvestigationHeaders = patientInvestigationHeaders;
	}

	/**
	 * Return the value associated with the column: OpdCaseSheets
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCaseSheet> getOpdCaseSheets() {
		return opdCaseSheets;
	}

	/**
	 * Set the value related to the column: OpdCaseSheets
	 * 
	 * @param opdCaseSheets
	 *            the OpdCaseSheets value
	 */
	public void setOpdCaseSheets(
			java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets) {
		this.opdCaseSheets = opdCaseSheets;
	}

	/**
	 * Return the value associated with the column: OpdOphthalmologies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphthalmology> getOpdOphthalmologies() {
		return opdOphthalmologies;
	}

	/**
	 * Set the value related to the column: OpdOphthalmologies
	 * 
	 * @param opdOphthalmologies
	 *            the OpdOphthalmologies value
	 */
	public void setOpdOphthalmologies(
			java.util.Set<jkt.hms.masters.business.OpdOphthalmology> opdOphthalmologies) {
		this.opdOphthalmologies = opdOphthalmologies;
	}

	/**
	 * Return the value associated with the column: OpdPatientDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientDetails> getOpdPatientDetails() {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: OpdPatientDetails
	 * 
	 * @param opdPatientDetails
	 *            the OpdPatientDetails value
	 */
	public void setOpdPatientDetails(
			java.util.Set<jkt.hms.masters.business.OpdPatientDetails> opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}

	/**
	 * Return the value associated with the column: DgOrderhds
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderhd> getDgOrderhds() {
		return dgOrderhds;
	}

	/**
	 * Set the value related to the column: DgOrderhds
	 * 
	 * @param dgOrderhds
	 *            the DgOrderhds value
	 */
	public void setDgOrderhds(
			java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds) {
		this.dgOrderhds = dgOrderhds;
	}

	/**
	 * Return the value associated with the column: OpdObgs
	 */
	public java.util.Set<jkt.hms.masters.business.OpdObg> getOpdObgs() {
		return opdObgs;
	}

	/**
	 * Set the value related to the column: OpdObgs
	 * 
	 * @param opdObgs
	 *            the OpdObgs value
	 */
	public void setOpdObgs(
			java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs) {
		this.opdObgs = opdObgs;
	}

	/**
	 * Return the value associated with the column: OtPostAnaesthesiaProcedures
	 */
	public java.util.Set<jkt.hms.masters.business.OtPostAnaesthesiaProcedure> getOtPostAnaesthesiaProcedures() {
		return otPostAnaesthesiaProcedures;
	}

	/**
	 * Set the value related to the column: OtPostAnaesthesiaProcedures
	 * 
	 * @param otPostAnaesthesiaProcedures
	 *            the OtPostAnaesthesiaProcedures value
	 */
	public void setOtPostAnaesthesiaProcedures(
			java.util.Set<jkt.hms.masters.business.OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedures) {
		this.otPostAnaesthesiaProcedures = otPostAnaesthesiaProcedures;
	}

	/**
	 * Return the value associated with the column: OtProcedureNotesEntryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryHeader> getOtProcedureNotesEntryHeaders() {
		return otProcedureNotesEntryHeaders;
	}

	/**
	 * Set the value related to the column: OtProcedureNotesEntryHeaders
	 * 
	 * @param otProcedureNotesEntryHeaders
	 *            the OtProcedureNotesEntryHeaders value
	 */
	public void setOtProcedureNotesEntryHeaders(
			java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryHeader> otProcedureNotesEntryHeaders) {
		this.otProcedureNotesEntryHeaders = otProcedureNotesEntryHeaders;
	}

	/**
	 * Return the value associated with the column:
	 * OpdGravidagramGestationalDiabitiesOnes
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> getOpdGravidagramGestationalDiabitiesOnes() {
		return opdGravidagramGestationalDiabitiesOnes;
	}

	/**
	 * Set the value related to the column:
	 * OpdGravidagramGestationalDiabitiesOnes
	 * 
	 * @param opdGravidagramGestationalDiabitiesOnes
	 *            the OpdGravidagramGestationalDiabitiesOnes value
	 */
	public void setOpdGravidagramGestationalDiabitiesOnes(
			java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes) {
		this.opdGravidagramGestationalDiabitiesOnes = opdGravidagramGestationalDiabitiesOnes;
	}

	/**
	 * Return the value associated with the column: OtSpecimenDispatchEntries
	 */
	public java.util.Set<jkt.hms.masters.business.OtSpecimenDispatchEntry> getOtSpecimenDispatchEntries() {
		return otSpecimenDispatchEntries;
	}

	/**
	 * Set the value related to the column: OtSpecimenDispatchEntries
	 * 
	 * @param otSpecimenDispatchEntries
	 *            the OtSpecimenDispatchEntries value
	 */
	public void setOtSpecimenDispatchEntries(
			java.util.Set<jkt.hms.masters.business.OtSpecimenDispatchEntry> otSpecimenDispatchEntries) {
		this.otSpecimenDispatchEntries = otSpecimenDispatchEntries;
	}

	/**
	 * Return the value associated with the column: PatientAllergicDrugsHds
	 */
	public java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> getPatientAllergicDrugsHds() {
		return patientAllergicDrugsHds;
	}

	/**
	 * Set the value related to the column: PatientAllergicDrugsHds
	 * 
	 * @param patientAllergicDrugsHds
	 *            the PatientAllergicDrugsHds value
	 */
	public void setPatientAllergicDrugsHds(
			java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds) {
		this.patientAllergicDrugsHds = patientAllergicDrugsHds;
	}

	/**
	 * Return the value associated with the column: OpdGravidagramHtns
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> getOpdGravidagramHtns() {
		return opdGravidagramHtns;
	}

	/**
	 * Set the value related to the column: OpdGravidagramHtns
	 * 
	 * @param opdGravidagramHtns
	 *            the OpdGravidagramHtns value
	 */
	public void setOpdGravidagramHtns(
			java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns) {
		this.opdGravidagramHtns = opdGravidagramHtns;
	}

	/**
	 * Return the value associated with the column: PatientPrescriptionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> getPatientPrescriptionHeaders() {
		return patientPrescriptionHeaders;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionHeaders
	 * 
	 * @param patientPrescriptionHeaders
	 *            the PatientPrescriptionHeaders value
	 */
	public void setPatientPrescriptionHeaders(
			java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders) {
		this.patientPrescriptionHeaders = patientPrescriptionHeaders;
	}

	/**
	 * Return the value associated with the column: OpdOphFollowUps
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> getOpdOphFollowUps() {
		return opdOphFollowUps;
	}

	/**
	 * Set the value related to the column: OpdOphFollowUps
	 * 
	 * @param opdOphFollowUps
	 *            the OpdOphFollowUps value
	 */
	public void setOpdOphFollowUps(
			java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> opdOphFollowUps) {
		this.opdOphFollowUps = opdOphFollowUps;
	}

	/**
	 * Return the value associated with the column: OpdUrologies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdUrology> getOpdUrologies() {
		return opdUrologies;
	}

	/**
	 * Set the value related to the column: OpdUrologies
	 * 
	 * @param opdUrologies
	 *            the OpdUrologies value
	 */
	public void setOpdUrologies(
			java.util.Set<jkt.hms.masters.business.OpdUrology> opdUrologies) {
		this.opdUrologies = opdUrologies;
	}

	/**
	 * Return the value associated with the column: OpdOphRetinalHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> getOpdOphRetinalHeaders() {
		return opdOphRetinalHeaders;
	}

	/**
	 * Set the value related to the column: OpdOphRetinalHeaders
	 * 
	 * @param opdOphRetinalHeaders
	 *            the OpdOphRetinalHeaders value
	 */
	public void setOpdOphRetinalHeaders(
			java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> opdOphRetinalHeaders) {
		this.opdOphRetinalHeaders = opdOphRetinalHeaders;
	}

	/**
	 * Return the value associated with the column: OpdOphDiagnosisHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> getOpdOphDiagnosisHeaders() {
		return opdOphDiagnosisHeaders;
	}

	/**
	 * Set the value related to the column: OpdOphDiagnosisHeaders
	 * 
	 * @param opdOphDiagnosisHeaders
	 *            the OpdOphDiagnosisHeaders value
	 */
	public void setOpdOphDiagnosisHeaders(
			java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> opdOphDiagnosisHeaders) {
		this.opdOphDiagnosisHeaders = opdOphDiagnosisHeaders;
	}

	/**
	 * Return the value associated with the column: DischargeIcdCodes
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeIcdCode> getDischargeIcdCodes() {
		return dischargeIcdCodes;
	}

	/**
	 * Set the value related to the column: DischargeIcdCodes
	 * 
	 * @param dischargeIcdCodes
	 *            the DischargeIcdCodes value
	 */
	public void setDischargeIcdCodes(
			java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes) {
		this.dischargeIcdCodes = dischargeIcdCodes;
	}

	/**
	 * Return the value associated with the column: OpdVaccinationPlans
	 */
	public java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> getOpdVaccinationPlans() {
		return opdVaccinationPlans;
	}

	/**
	 * Set the value related to the column: OpdVaccinationPlans
	 * 
	 * @param opdVaccinationPlans
	 *            the OpdVaccinationPlans value
	 */
	public void setOpdVaccinationPlans(
			java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans) {
		this.opdVaccinationPlans = opdVaccinationPlans;
	}

	/**
	 * Return the value associated with the column: OpdTemplateDepartmentWises
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateDepartmentWise> getOpdTemplateDepartmentWises() {
		return opdTemplateDepartmentWises;
	}

	/**
	 * Set the value related to the column: OpdTemplateDepartmentWises
	 * 
	 * @param opdTemplateDepartmentWises
	 *            the OpdTemplateDepartmentWises value
	 */
	public void setOpdTemplateDepartmentWises(
			java.util.Set<jkt.hms.masters.business.OpdTemplateDepartmentWise> opdTemplateDepartmentWises) {
		this.opdTemplateDepartmentWises = opdTemplateDepartmentWises;
	}

	/**
	 * Return the value associated with the column: OpdOncosurgeryCaseSheets
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOncosurgeryCaseSheet> getOpdOncosurgeryCaseSheets() {
		return opdOncosurgeryCaseSheets;
	}

	/**
	 * Set the value related to the column: OpdOncosurgeryCaseSheets
	 * 
	 * @param opdOncosurgeryCaseSheets
	 *            the OpdOncosurgeryCaseSheets value
	 */
	public void setOpdOncosurgeryCaseSheets(
			java.util.Set<jkt.hms.masters.business.OpdOncosurgeryCaseSheet> opdOncosurgeryCaseSheets) {
		this.opdOncosurgeryCaseSheets = opdOncosurgeryCaseSheets;
	}

	/**
	 * Return the value associated with the column: OpdEnts
	 */
	public java.util.Set<jkt.hms.masters.business.OpdEnt> getOpdEnts() {
		return opdEnts;
	}

	/**
	 * Set the value related to the column: OpdEnts
	 * 
	 * @param opdEnts
	 *            the OpdEnts value
	 */
	public void setOpdEnts(
			java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts) {
		this.opdEnts = opdEnts;
	}

	/**
	 * Return the value associated with the column:
	 * OpdGravidagramGestationalDiabitiesTwos
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> getOpdGravidagramGestationalDiabitiesTwos() {
		return opdGravidagramGestationalDiabitiesTwos;
	}

	/**
	 * Set the value related to the column:
	 * OpdGravidagramGestationalDiabitiesTwos
	 * 
	 * @param opdGravidagramGestationalDiabitiesTwos
	 *            the OpdGravidagramGestationalDiabitiesTwos value
	 */
	public void setOpdGravidagramGestationalDiabitiesTwos(
			java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> opdGravidagramGestationalDiabitiesTwos) {
		this.opdGravidagramGestationalDiabitiesTwos = opdGravidagramGestationalDiabitiesTwos;
	}

	/**
	 * Return the value associated with the column:
	 * OpdGastroEnterologyEndoscopies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> getOpdGastroEnterologyEndoscopies() {
		return opdGastroEnterologyEndoscopies;
	}

	/**
	 * Set the value related to the column: OpdGastroEnterologyEndoscopies
	 * 
	 * @param opdGastroEnterologyEndoscopies
	 *            the OpdGastroEnterologyEndoscopies value
	 */
	public void setOpdGastroEnterologyEndoscopies(
			java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopies) {
		this.opdGastroEnterologyEndoscopies = opdGastroEnterologyEndoscopies;
	}

	/**
	 * Return the value associated with the column: OpdSurgeryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> getOpdSurgeryHeaders() {
		return opdSurgeryHeaders;
	}

	/**
	 * Set the value related to the column: OpdSurgeryHeaders
	 * 
	 * @param opdSurgeryHeaders
	 *            the OpdSurgeryHeaders value
	 */
	public void setOpdSurgeryHeaders(
			java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeaders) {
		this.opdSurgeryHeaders = opdSurgeryHeaders;
	}

	/**
	 * Return the value associated with the column: OpdAntenatalCards
	 */
	public java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> getOpdAntenatalCards() {
		return opdAntenatalCards;
	}

	/**
	 * Set the value related to the column: OpdAntenatalCards
	 * 
	 * @param opdAntenatalCards
	 *            the OpdAntenatalCards value
	 */
	public void setOpdAntenatalCards(
			java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards) {
		this.opdAntenatalCards = opdAntenatalCards;
	}

	/**
	 * Return the value associated with the column: OtBookings
	 */
	public java.util.Set<jkt.hms.masters.business.OtBooking> getOtBookings() {
		return otBookings;
	}

	/**
	 * Set the value related to the column: OtBookings
	 * 
	 * @param otBookings
	 *            the OtBookings value
	 */
	public void setOtBookings(
			java.util.Set<jkt.hms.masters.business.OtBooking> otBookings) {
		this.otBookings = otBookings;
	}

	/**
	 * Return the value associated with the column: UploadDocuments
	 */
	public java.util.Set<jkt.hms.masters.business.UploadDocuments> getUploadDocuments() {
		return uploadDocuments;
	}

	/**
	 * Set the value related to the column: UploadDocuments
	 * 
	 * @param uploadDocuments
	 *            the UploadDocuments value
	 */
	public void setUploadDocuments(
			java.util.Set<jkt.hms.masters.business.UploadDocuments> uploadDocuments) {
		this.uploadDocuments = uploadDocuments;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.Visit)) {
			return false;
		} else {
			jkt.hms.masters.business.Visit visit = (jkt.hms.masters.business.Visit) obj;
			if (null == this.getId() || null == visit.getId()) {
				return false;
			} else {
				return (this.getId().equals(visit.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}