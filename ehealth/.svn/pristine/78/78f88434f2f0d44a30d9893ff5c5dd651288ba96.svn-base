package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the inpatient table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="inpatient"
 */

public abstract class BaseInpatient  implements Serializable {

	public static String REF = "Inpatient";
	public static String PROP_PATIENT_EPISODE = "PatientEpisode";
	public static String PROP_SCHEME = "Scheme";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_MLC = "Mlc";
	public static String PROP_PATIENT_CONDITION = "PatientCondition";
	public static String PROP_POSTPAID_STATUS = "PostpaidStatus";
	public static String PROP_FRW_ISSUED = "FrwIssued";
	public static String PROP_LIST_DATE = "ListDate";
	public static String PROP_CRITICAL_CONDITION = "CriticalCondition";
	public static String PROP_DOCUMENT = "Document";
	public static String PROP_TIME_OF_ADDMISSION = "TimeOfAddmission";
	public static String PROP_ATTACHED_PATIENT = "AttachedPatient";
	public static String PROP_OUTSIDE_TREATMENT = "OutsideTreatment";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_ADMITTING_DOCTOR = "AdmittingDoctor";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_DISCHARGE_DATE = "DischargeDate";
	public static String PROP_FRW_SL_NO = "FrwSlNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ICD_ID = "IcdId";
	public static String PROP_AUTHORIZER = "Authorizer";
	public static String PROP_LIST = "List";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_STAFF_SL_NO = "StaffSlNo";
	public static String PROP_PARENT_AD_NO = "ParentAdNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LIST_TIME = "ListTime";
	public static String PROP_BED_ALLOCATION_TIME = "BedAllocationTime";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_PLACE_OF_ISSUE = "PlaceOfIssue";
	public static String PROP_INIT_DIAGNOSIS = "InitDiagnosis";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_DIET = "Diet";
	public static String PROP_AT_OR_DT = "AtOrDt";
	public static String PROP_CASE_TYPE = "CaseType";
	public static String PROP_DOCUMENTS = "Documents";
	public static String PROP_HSR_RECEIPT_NO = "HsrReceiptNo";
	public static String PROP_ID = "Id";
	public static String PROP_REFERENCE_NO = "ReferenceNo";
	public static String PROP_POSTPAID_BY = "PostpaidBy";
	public static String PROP_AD_NO_TYPE = "AdNoType";
	public static String PROP_UNIT_M = "UnitM";
	public static String PROP_ADMITTING_DEPARTMET = "AdmittingDepartmet";
	public static String PROP_AD_WARD = "AdWard";
	public static String PROP_DIET_TYPE = "DietType";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_BED_ALLOCATION_DATE = "BedAllocationDate";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_DEPENDENT_NAME = "DependentName";
	public static String PROP_PREVIOUS_AD_NO = "PreviousAdNo";
	public static String PROP_RELATION = "Relation";
	public static String PROP_HSR_AMOUNT = "HsrAmount";
	public static String PROP_MOTHER_AD_NO = "MotherAdNo";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_COMPLAINT = "Complaint";
	public static String PROP_RECORD_OFFICE_ADDRESS = "RecordOfficeAddress";
	public static String PROP_AD_STATUS = "AdStatus";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";
	public static String PROP_DEPENDENT_STATUS = "DependentStatus";
	public static String PROP_AGE = "Age";
	public static String PROP_SERVICE_CARD_STATUS = "ServiceCardStatus";
	public static String PROP_ADMISSION_TYPE = "AdmissionType";
	public static String PROP_BED = "Bed";
	public static String PROP_DISCHARGE_TIME = "DischargeTime";
	public static String PROP_DATE_OF_ADDMISSION = "DateOfAddmission";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_HIN = "Hin";
	public static String PROP_TRANS_FROM = "TransFrom";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_SECTION_LIMIT = "SectionLimit";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_CONDITION_STATUS = "ConditionStatus";
	public static String PROP_VIP = "Vip";
	public static String PROP_PATIENT_CATEGORY = "PatientCategory";
	public static String PROP_CASH_RECEIVED_STATUS = "CashReceivedStatus";
	public static String PROP_CASH_NOT_RECEIVED_REASON = "CashNotReceivedReason";
	public static String PROP_DISCHARGE_SUMMARY_STATUS = "DischargeSummaryStatus";


	// constructors
	public BaseInpatient () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInpatient (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseInpatient (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.Patient hin) {

		this.setId(id);
		this.setDepartment(department);
		this.setHospital(hospital);
		this.setHin(hin);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.String age;
	private java.util.Date dateOfAddmission;
	private java.lang.String timeOfAddmission;
	private java.lang.String dietType;
	private java.lang.String priority;
	private java.lang.String list;
	private java.lang.String mlc;
	private java.util.Date dischargeDate;
	private java.lang.String dischargeTime;
	private java.lang.String serviceCardStatus;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String adStatus;
	private java.lang.String status;
	private java.lang.String patientCondition;
	private java.lang.String motherAdNo;
	private java.lang.String conditionStatus;
	private java.lang.String hinNo;
	private java.lang.String frwIssued;
	private java.lang.String frwSlNo;
	private java.lang.String placeOfIssue;
	private java.util.Date listDate;
	private java.lang.String listTime;
	private java.lang.String vip;
	private java.lang.Integer staffSlNo;
	private java.lang.String hsrReceiptNo;
	private java.math.BigDecimal hsrAmount;
	private java.lang.String parentAdNo;
	private java.lang.String attachedPatient;
	private java.lang.String atOrDt;
	private java.lang.String remarks;
	private java.lang.String transFrom;
	private java.lang.String previousAdNo;
	private java.lang.String initDiagnosis;
	private java.lang.String adNoType;
	private java.lang.Integer employeeId;
	private java.lang.Integer icdId;
	private java.lang.Integer userId;
	private java.lang.String referenceNo;
	private java.lang.String dependentStatus;
	private java.lang.String dependentName;
	private java.lang.String contactNo;
	private java.lang.String address;
	private java.lang.String criticalCondition;
	private java.lang.String postpaidStatus;
	private java.math.BigDecimal sectionLimit;
	private java.util.Date bedAllocationDate;
	private java.lang.String bedAllocationTime;
	private java.lang.String documents;
	private java.lang.String cashReceivedStatus;
	private java.lang.String cashNotReceivedReason;
	private java.lang.String dischargeSummaryStatus;

	// many to one
	private jkt.hms.masters.business.MasDepartment admittingDepartmet;
	private jkt.hms.masters.business.MasDocument document;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasAuthorizer authorizer;
	private jkt.hms.masters.business.MasComplaint complaint;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.MasOutsideTreatment outsideTreatment;
	private jkt.hms.masters.business.MasScheme scheme;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.HospitalDoctorUnitM unitM;
	private jkt.hms.masters.business.MasEmployee admittingDoctor;
	private jkt.hms.masters.business.MasBed bed;
	private jkt.hms.masters.business.MasAdmissionType admissionType;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDiet diet;
	private jkt.hms.masters.business.PatientEpisode patientEpisode;
	private jkt.hms.masters.business.MasEmployee postpaidBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasPatientCategory patientCategory;
	private jkt.hms.masters.business.MasIcd diagnosis;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasRecordOfficeAddress recordOfficeAddress;
	private jkt.hms.masters.business.MasDepartment adWard;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasCaseType caseType;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> blChargeSlipMains;
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs;
	private java.util.Set<jkt.hms.masters.business.BlDepositHeader> blDepositHeaders;
	private java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables;
	private java.util.Set<jkt.hms.masters.business.DietDetails> dietDetails;
	private java.util.Set<jkt.hms.masters.business.BlPatientLedger> blPatientLedgers;
	private java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.InpatientDocument> inpatientDocuments;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeaders;
	private java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings;
	private java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.BlFinalBillDetails> blFinalBillDetails;
	private java.util.Set<jkt.hms.masters.business.BlReceiptHeader> blReceiptHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="inpatient_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
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
	 * Return the value associated with the column: date_of_addmission
	 */
	public java.util.Date getDateOfAddmission () {
		return dateOfAddmission;
	}

	/**
	 * Set the value related to the column: date_of_addmission
	 * @param dateOfAddmission the date_of_addmission value
	 */
	public void setDateOfAddmission (java.util.Date dateOfAddmission) {
		this.dateOfAddmission = dateOfAddmission;
	}



	/**
	 * Return the value associated with the column: time_of_addmission
	 */
	public java.lang.String getTimeOfAddmission () {
		return timeOfAddmission;
	}

	/**
	 * Set the value related to the column: time_of_addmission
	 * @param timeOfAddmission the time_of_addmission value
	 */
	public void setTimeOfAddmission (java.lang.String timeOfAddmission) {
		this.timeOfAddmission = timeOfAddmission;
	}



	/**
	 * Return the value associated with the column: diet_type
	 */
	public java.lang.String getDietType () {
		return dietType;
	}

	/**
	 * Set the value related to the column: diet_type
	 * @param dietType the diet_type value
	 */
	public void setDietType (java.lang.String dietType) {
		this.dietType = dietType;
	}



	/**
	 * Return the value associated with the column: priority
	 */
	public java.lang.String getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (java.lang.String priority) {
		this.priority = priority;
	}



	/**
	 * Return the value associated with the column: list
	 */
	public java.lang.String getList () {
		return list;
	}

	/**
	 * Set the value related to the column: list
	 * @param list the list value
	 */
	public void setList (java.lang.String list) {
		this.list = list;
	}



	/**
	 * Return the value associated with the column: mlc
	 */
	public java.lang.String getMlc () {
		return mlc;
	}

	/**
	 * Set the value related to the column: mlc
	 * @param mlc the mlc value
	 */
	public void setMlc (java.lang.String mlc) {
		this.mlc = mlc;
	}



	/**
	 * Return the value associated with the column: discharge_date
	 */
	public java.util.Date getDischargeDate () {
		return dischargeDate;
	}

	/**
	 * Set the value related to the column: discharge_date
	 * @param dischargeDate the discharge_date value
	 */
	public void setDischargeDate (java.util.Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}



	/**
	 * Return the value associated with the column: discharge_time
	 */
	public java.lang.String getDischargeTime () {
		return dischargeTime;
	}

	/**
	 * Set the value related to the column: discharge_time
	 * @param dischargeTime the discharge_time value
	 */
	public void setDischargeTime (java.lang.String dischargeTime) {
		this.dischargeTime = dischargeTime;
	}



	/**
	 * Return the value associated with the column: service_card_status
	 */
	public java.lang.String getServiceCardStatus () {
		return serviceCardStatus;
	}

	/**
	 * Set the value related to the column: service_card_status
	 * @param serviceCardStatus the service_card_status value
	 */
	public void setServiceCardStatus (java.lang.String serviceCardStatus) {
		this.serviceCardStatus = serviceCardStatus;
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
	 * Return the value associated with the column: ad_status
	 */
	public java.lang.String getAdStatus () {
		return adStatus;
	}

	/**
	 * Set the value related to the column: ad_status
	 * @param adStatus the ad_status value
	 */
	public void setAdStatus (java.lang.String adStatus) {
		this.adStatus = adStatus;
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
	 * Return the value associated with the column: patient_condition
	 */
	public java.lang.String getPatientCondition () {
		return patientCondition;
	}

	/**
	 * Set the value related to the column: patient_condition
	 * @param patientCondition the patient_condition value
	 */
	public void setPatientCondition (java.lang.String patientCondition) {
		this.patientCondition = patientCondition;
	}



	/**
	 * Return the value associated with the column: mother_ad_no
	 */
	public java.lang.String getMotherAdNo () {
		return motherAdNo;
	}

	/**
	 * Set the value related to the column: mother_ad_no
	 * @param motherAdNo the mother_ad_no value
	 */
	public void setMotherAdNo (java.lang.String motherAdNo) {
		this.motherAdNo = motherAdNo;
	}



	/**
	 * Return the value associated with the column: condition_status
	 */
	public java.lang.String getConditionStatus () {
		return conditionStatus;
	}

	/**
	 * Set the value related to the column: condition_status
	 * @param conditionStatus the condition_status value
	 */
	public void setConditionStatus (java.lang.String conditionStatus) {
		this.conditionStatus = conditionStatus;
	}



	/**
	 * Return the value associated with the column: hin_no
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: hin_no
	 * @param hinNo the hin_no value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: frw_issued
	 */
	public java.lang.String getFrwIssued () {
		return frwIssued;
	}

	/**
	 * Set the value related to the column: frw_issued
	 * @param frwIssued the frw_issued value
	 */
	public void setFrwIssued (java.lang.String frwIssued) {
		this.frwIssued = frwIssued;
	}



	/**
	 * Return the value associated with the column: frw_sl_no
	 */
	public java.lang.String getFrwSlNo () {
		return frwSlNo;
	}

	/**
	 * Set the value related to the column: frw_sl_no
	 * @param frwSlNo the frw_sl_no value
	 */
	public void setFrwSlNo (java.lang.String frwSlNo) {
		this.frwSlNo = frwSlNo;
	}



	/**
	 * Return the value associated with the column: place_of_issue
	 */
	public java.lang.String getPlaceOfIssue () {
		return placeOfIssue;
	}

	/**
	 * Set the value related to the column: place_of_issue
	 * @param placeOfIssue the place_of_issue value
	 */
	public void setPlaceOfIssue (java.lang.String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}



	/**
	 * Return the value associated with the column: list_date
	 */
	public java.util.Date getListDate () {
		return listDate;
	}

	/**
	 * Set the value related to the column: list_date
	 * @param listDate the list_date value
	 */
	public void setListDate (java.util.Date listDate) {
		this.listDate = listDate;
	}



	/**
	 * Return the value associated with the column: list_time
	 */
	public java.lang.String getListTime () {
		return listTime;
	}

	/**
	 * Set the value related to the column: list_time
	 * @param listTime the list_time value
	 */
	public void setListTime (java.lang.String listTime) {
		this.listTime = listTime;
	}



	/**
	 * Return the value associated with the column: vip
	 */
	public java.lang.String getVip () {
		return vip;
	}

	/**
	 * Set the value related to the column: vip
	 * @param vip the vip value
	 */
	public void setVip (java.lang.String vip) {
		this.vip = vip;
	}



	/**
	 * Return the value associated with the column: staff_sl_no
	 */
	public java.lang.Integer getStaffSlNo () {
		return staffSlNo;
	}

	/**
	 * Set the value related to the column: staff_sl_no
	 * @param staffSlNo the staff_sl_no value
	 */
	public void setStaffSlNo (java.lang.Integer staffSlNo) {
		this.staffSlNo = staffSlNo;
	}



	/**
	 * Return the value associated with the column: hsr_receipt_no
	 */
	public java.lang.String getHsrReceiptNo () {
		return hsrReceiptNo;
	}

	/**
	 * Set the value related to the column: hsr_receipt_no
	 * @param hsrReceiptNo the hsr_receipt_no value
	 */
	public void setHsrReceiptNo (java.lang.String hsrReceiptNo) {
		this.hsrReceiptNo = hsrReceiptNo;
	}



	/**
	 * Return the value associated with the column: hsr_amount
	 */
	public java.math.BigDecimal getHsrAmount () {
		return hsrAmount;
	}

	/**
	 * Set the value related to the column: hsr_amount
	 * @param hsrAmount the hsr_amount value
	 */
	public void setHsrAmount (java.math.BigDecimal hsrAmount) {
		this.hsrAmount = hsrAmount;
	}



	/**
	 * Return the value associated with the column: parent_ad_no
	 */
	public java.lang.String getParentAdNo () {
		return parentAdNo;
	}

	/**
	 * Set the value related to the column: parent_ad_no
	 * @param parentAdNo the parent_ad_no value
	 */
	public void setParentAdNo (java.lang.String parentAdNo) {
		this.parentAdNo = parentAdNo;
	}



	/**
	 * Return the value associated with the column: attached_patient
	 */
	public java.lang.String getAttachedPatient () {
		return attachedPatient;
	}

	/**
	 * Set the value related to the column: attached_patient
	 * @param attachedPatient the attached_patient value
	 */
	public void setAttachedPatient (java.lang.String attachedPatient) {
		this.attachedPatient = attachedPatient;
	}



	/**
	 * Return the value associated with the column: at_or_dt
	 */
	public java.lang.String getAtOrDt () {
		return atOrDt;
	}

	/**
	 * Set the value related to the column: at_or_dt
	 * @param atOrDt the at_or_dt value
	 */
	public void setAtOrDt (java.lang.String atOrDt) {
		this.atOrDt = atOrDt;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: trans_from
	 */
	public java.lang.String getTransFrom () {
		return transFrom;
	}

	/**
	 * Set the value related to the column: trans_from
	 * @param transFrom the trans_from value
	 */
	public void setTransFrom (java.lang.String transFrom) {
		this.transFrom = transFrom;
	}



	/**
	 * Return the value associated with the column: previous_ad_no
	 */
	public java.lang.String getPreviousAdNo () {
		return previousAdNo;
	}

	/**
	 * Set the value related to the column: previous_ad_no
	 * @param previousAdNo the previous_ad_no value
	 */
	public void setPreviousAdNo (java.lang.String previousAdNo) {
		this.previousAdNo = previousAdNo;
	}



	/**
	 * Return the value associated with the column: init_diagnosis
	 */
	public java.lang.String getInitDiagnosis () {
		return initDiagnosis;
	}

	/**
	 * Set the value related to the column: init_diagnosis
	 * @param initDiagnosis the init_diagnosis value
	 */
	public void setInitDiagnosis (java.lang.String initDiagnosis) {
		this.initDiagnosis = initDiagnosis;
	}



	/**
	 * Return the value associated with the column: ad_no_type
	 */
	public java.lang.String getAdNoType () {
		return adNoType;
	}

	/**
	 * Set the value related to the column: ad_no_type
	 * @param adNoType the ad_no_type value
	 */
	public void setAdNoType (java.lang.String adNoType) {
		this.adNoType = adNoType;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public java.lang.Integer getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (java.lang.Integer employeeId) {
		this.employeeId = employeeId;
	}



	/**
	 * Return the value associated with the column: icd_id
	 */
	public java.lang.Integer getIcdId () {
		return icdId;
	}

	/**
	 * Set the value related to the column: icd_id
	 * @param icdId the icd_id value
	 */
	public void setIcdId (java.lang.Integer icdId) {
		this.icdId = icdId;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public java.lang.Integer getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param userId the user_id value
	 */
	public void setUserId (java.lang.Integer userId) {
		this.userId = userId;
	}



	/**
	 * Return the value associated with the column: reference_no
	 */
	public java.lang.String getReferenceNo () {
		return referenceNo;
	}

	/**
	 * Set the value related to the column: reference_no
	 * @param referenceNo the reference_no value
	 */
	public void setReferenceNo (java.lang.String referenceNo) {
		this.referenceNo = referenceNo;
	}



	/**
	 * Return the value associated with the column: dependent_status
	 */
	public java.lang.String getDependentStatus () {
		return dependentStatus;
	}

	/**
	 * Set the value related to the column: dependent_status
	 * @param dependentStatus the dependent_status value
	 */
	public void setDependentStatus (java.lang.String dependentStatus) {
		this.dependentStatus = dependentStatus;
	}



	/**
	 * Return the value associated with the column: dependent_name
	 */
	public java.lang.String getDependentName () {
		return dependentName;
	}

	/**
	 * Set the value related to the column: dependent_name
	 * @param dependentName the dependent_name value
	 */
	public void setDependentName (java.lang.String dependentName) {
		this.dependentName = dependentName;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: critical_condition
	 */
	public java.lang.String getCriticalCondition () {
		return criticalCondition;
	}

	/**
	 * Set the value related to the column: critical_condition
	 * @param criticalCondition the critical_condition value
	 */
	public void setCriticalCondition (java.lang.String criticalCondition) {
		this.criticalCondition = criticalCondition;
	}



	/**
	 * Return the value associated with the column: postpaid_status
	 */
	public java.lang.String getPostpaidStatus () {
		return postpaidStatus;
	}

	/**
	 * Set the value related to the column: postpaid_status
	 * @param postpaidStatus the postpaid_status value
	 */
	public void setPostpaidStatus (java.lang.String postpaidStatus) {
		this.postpaidStatus = postpaidStatus;
	}



	/**
	 * Return the value associated with the column: section_limit
	 */
	public java.math.BigDecimal getSectionLimit () {
		return sectionLimit;
	}

	/**
	 * Set the value related to the column: section_limit
	 * @param sectionLimit the section_limit value
	 */
	public void setSectionLimit (java.math.BigDecimal sectionLimit) {
		this.sectionLimit = sectionLimit;
	}



	/**
	 * Return the value associated with the column: bed_allocation_date
	 */
	public java.util.Date getBedAllocationDate () {
		return bedAllocationDate;
	}

	/**
	 * Set the value related to the column: bed_allocation_date
	 * @param bedAllocationDate the bed_allocation_date value
	 */
	public void setBedAllocationDate (java.util.Date bedAllocationDate) {
		this.bedAllocationDate = bedAllocationDate;
	}



	/**
	 * Return the value associated with the column: bed_allocation_time
	 */
	public java.lang.String getBedAllocationTime () {
		return bedAllocationTime;
	}

	/**
	 * Set the value related to the column: bed_allocation_time
	 * @param bedAllocationTime the bed_allocation_time value
	 */
	public void setBedAllocationTime (java.lang.String bedAllocationTime) {
		this.bedAllocationTime = bedAllocationTime;
	}



	/**
	 * Return the value associated with the column: documents
	 */
	public java.lang.String getDocuments () {
		return documents;
	}

	/**
	 * Set the value related to the column: documents
	 * @param documents the documents value
	 */
	public void setDocuments (java.lang.String documents) {
		this.documents = documents;
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
	 * Return the value associated with the column: cash_not_received_reason
	 */
	public java.lang.String getCashNotReceivedReason () {
		return cashNotReceivedReason;
	}

	/**
	 * Set the value related to the column: cash_not_received_reason
	 * @param cashNotReceivedReason the cash_not_received_reason value
	 */
	public void setCashNotReceivedReason (java.lang.String cashNotReceivedReason) {
		this.cashNotReceivedReason = cashNotReceivedReason;
	}

	/**
	 * Return the value associated with the column: discharge_summary_status
	 */
	public java.lang.String getDischargeSummaryStatus() {
		return dischargeSummaryStatus;
	}

	/**
	 * Set the value related to the column: discharge_summary_status
	 * @param dischargeSummaryStatus the discharge_summary_status value
	 */
	public void setDischargeSummaryStatus(java.lang.String dischargeSummaryStatus) {
		this.dischargeSummaryStatus = dischargeSummaryStatus;
	}

	/**
	 * Return the value associated with the column: admitting_departmet_id
	 */
	public jkt.hms.masters.business.MasDepartment getAdmittingDepartmet () {
		return admittingDepartmet;
	}

	/**
	 * Set the value related to the column: admitting_departmet_id
	 * @param admittingDepartmet the admitting_departmet_id value
	 */
	public void setAdmittingDepartmet (jkt.hms.masters.business.MasDepartment admittingDepartmet) {
		this.admittingDepartmet = admittingDepartmet;
	}



	/**
	 * Return the value associated with the column: document_id
	 */
	public jkt.hms.masters.business.MasDocument getDocument () {
		return document;
	}

	/**
	 * Set the value related to the column: document_id
	 * @param document the document_id value
	 */
	public void setDocument (jkt.hms.masters.business.MasDocument document) {
		this.document = document;
	}



	/**
	 * Return the value associated with the column: relation
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation
	 * @param relation the relation value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: authorizer_id
	 */
	public jkt.hms.masters.business.MasAuthorizer getAuthorizer () {
		return authorizer;
	}

	/**
	 * Set the value related to the column: authorizer_id
	 * @param authorizer the authorizer_id value
	 */
	public void setAuthorizer (jkt.hms.masters.business.MasAuthorizer authorizer) {
		this.authorizer = authorizer;
	}



	/**
	 * Return the value associated with the column: complaint_id
	 */
	public jkt.hms.masters.business.MasComplaint getComplaint () {
		return complaint;
	}

	/**
	 * Set the value related to the column: complaint_id
	 * @param complaint the complaint_id value
	 */
	public void setComplaint (jkt.hms.masters.business.MasComplaint complaint) {
		this.complaint = complaint;
	}



	/**
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
	}



	/**
	 * Return the value associated with the column: outside_treatment_id
	 */
	public jkt.hms.masters.business.MasOutsideTreatment getOutsideTreatment () {
		return outsideTreatment;
	}

	/**
	 * Set the value related to the column: outside_treatment_id
	 * @param outsideTreatment the outside_treatment_id value
	 */
	public void setOutsideTreatment (jkt.hms.masters.business.MasOutsideTreatment outsideTreatment) {
		this.outsideTreatment = outsideTreatment;
	}



	/**
	 * Return the value associated with the column: scheme_id
	 */
	public jkt.hms.masters.business.MasScheme getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme_id
	 * @param scheme the scheme_id value
	 */
	public void setScheme (jkt.hms.masters.business.MasScheme scheme) {
		this.scheme = scheme;
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
	 * Return the value associated with the column: unit_m_id
	 */
	public jkt.hms.masters.business.HospitalDoctorUnitM getUnitM () {
		return unitM;
	}

	/**
	 * Set the value related to the column: unit_m_id
	 * @param unitM the unit_m_id value
	 */
	public void setUnitM (jkt.hms.masters.business.HospitalDoctorUnitM unitM) {
		this.unitM = unitM;
	}



	/**
	 * Return the value associated with the column: admitting_doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getAdmittingDoctor () {
		return admittingDoctor;
	}

	/**
	 * Set the value related to the column: admitting_doctor_id
	 * @param admittingDoctor the admitting_doctor_id value
	 */
	public void setAdmittingDoctor (jkt.hms.masters.business.MasEmployee admittingDoctor) {
		this.admittingDoctor = admittingDoctor;
	}



	/**
	 * Return the value associated with the column: bed_id
	 */
	public jkt.hms.masters.business.MasBed getBed () {
		return bed;
	}

	/**
	 * Set the value related to the column: bed_id
	 * @param bed the bed_id value
	 */
	public void setBed (jkt.hms.masters.business.MasBed bed) {
		this.bed = bed;
	}



	/**
	 * Return the value associated with the column: admission_type_id
	 */
	public jkt.hms.masters.business.MasAdmissionType getAdmissionType () {
		return admissionType;
	}

	/**
	 * Set the value related to the column: admission_type_id
	 * @param admissionType the admission_type_id value
	 */
	public void setAdmissionType (jkt.hms.masters.business.MasAdmissionType admissionType) {
		this.admissionType = admissionType;
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
	 * Return the value associated with the column: diet_id
	 */
	public jkt.hms.masters.business.MasDiet getDiet () {
		return diet;
	}

	/**
	 * Set the value related to the column: diet_id
	 * @param diet the diet_id value
	 */
	public void setDiet (jkt.hms.masters.business.MasDiet diet) {
		this.diet = diet;
	}



	/**
	 * Return the value associated with the column: patient_episode_id
	 */
	public jkt.hms.masters.business.PatientEpisode getPatientEpisode () {
		return patientEpisode;
	}

	/**
	 * Set the value related to the column: patient_episode_id
	 * @param patientEpisode the patient_episode_id value
	 */
	public void setPatientEpisode (jkt.hms.masters.business.PatientEpisode patientEpisode) {
		this.patientEpisode = patientEpisode;
	}



	/**
	 * Return the value associated with the column: postpaid_by
	 */
	public jkt.hms.masters.business.MasEmployee getPostpaidBy () {
		return postpaidBy;
	}

	/**
	 * Set the value related to the column: postpaid_by
	 * @param postpaidBy the postpaid_by value
	 */
	public void setPostpaidBy (jkt.hms.masters.business.MasEmployee postpaidBy) {
		this.postpaidBy = postpaidBy;
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
	 * Return the value associated with the column: patient_category_id
	 */
	public jkt.hms.masters.business.MasPatientCategory getPatientCategory () {
		return patientCategory;
	}

	/**
	 * Set the value related to the column: patient_category_id
	 * @param patientCategory the patient_category_id value
	 */
	public void setPatientCategory (jkt.hms.masters.business.MasPatientCategory patientCategory) {
		this.patientCategory = patientCategory;
	}



	/**
	 * Return the value associated with the column: diagnosis_id
	 */
	public jkt.hms.masters.business.MasIcd getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis_id
	 * @param diagnosis the diagnosis_id value
	 */
	public void setDiagnosis (jkt.hms.masters.business.MasIcd diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
	}



	/**
	 * Return the value associated with the column: record_office_address_id
	 */
	public jkt.hms.masters.business.MasRecordOfficeAddress getRecordOfficeAddress () {
		return recordOfficeAddress;
	}

	/**
	 * Set the value related to the column: record_office_address_id
	 * @param recordOfficeAddress the record_office_address_id value
	 */
	public void setRecordOfficeAddress (jkt.hms.masters.business.MasRecordOfficeAddress recordOfficeAddress) {
		this.recordOfficeAddress = recordOfficeAddress;
	}



	/**
	 * Return the value associated with the column: ad_ward_id
	 */
	public jkt.hms.masters.business.MasDepartment getAdWard () {
		return adWard;
	}

	/**
	 * Set the value related to the column: ad_ward_id
	 * @param adWard the ad_ward_id value
	 */
	public void setAdWard (jkt.hms.masters.business.MasDepartment adWard) {
		this.adWard = adWard;
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
	 * Return the value associated with the column: case_type_id
	 */
	public jkt.hms.masters.business.MasCaseType getCaseType () {
		return caseType;
	}

	/**
	 * Set the value related to the column: case_type_id
	 * @param caseType the case_type_id value
	 */
	public void setCaseType (jkt.hms.masters.business.MasCaseType caseType) {
		this.caseType = caseType;
	}



	/**
	 * Return the value associated with the column: Discharges
	 */
	public java.util.Set<jkt.hms.masters.business.Discharge> getDischarges () {
		return discharges;
	}

	/**
	 * Set the value related to the column: Discharges
	 * @param discharges the Discharges value
	 */
	public void setDischarges (java.util.Set<jkt.hms.masters.business.Discharge> discharges) {
		this.discharges = discharges;
	}

	public void addToDischarges (jkt.hms.masters.business.Discharge discharge) {
		if (null == getDischarges()) setDischarges(new java.util.TreeSet<jkt.hms.masters.business.Discharge>());
		getDischarges().add(discharge);
	}



	/**
	 * Return the value associated with the column: BlChargeSlipMains
	 */
	public java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> getBlChargeSlipMains () {
		return blChargeSlipMains;
	}

	/**
	 * Set the value related to the column: BlChargeSlipMains
	 * @param blChargeSlipMains the BlChargeSlipMains value
	 */
	public void setBlChargeSlipMains (java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> blChargeSlipMains) {
		this.blChargeSlipMains = blChargeSlipMains;
	}

	public void addToBlChargeSlipMains (jkt.hms.masters.business.BlChargeSlipMain blChargeSlipMain) {
		if (null == getBlChargeSlipMains()) setBlChargeSlipMains(new java.util.TreeSet<jkt.hms.masters.business.BlChargeSlipMain>());
		getBlChargeSlipMains().add(blChargeSlipMain);
	}



	/**
	 * Return the value associated with the column: DischargeIcdCodes
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeIcdCode> getDischargeIcdCodes () {
		return dischargeIcdCodes;
	}

	/**
	 * Set the value related to the column: DischargeIcdCodes
	 * @param dischargeIcdCodes the DischargeIcdCodes value
	 */
	public void setDischargeIcdCodes (java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes) {
		this.dischargeIcdCodes = dischargeIcdCodes;
	}

	public void addToDischargeIcdCodes (jkt.hms.masters.business.DischargeIcdCode dischargeIcdCode) {
		if (null == getDischargeIcdCodes()) setDischargeIcdCodes(new java.util.TreeSet<jkt.hms.masters.business.DischargeIcdCode>());
		getDischargeIcdCodes().add(dischargeIcdCode);
	}



	/**
	 * Return the value associated with the column: Birthdeathregs
	 */
	public java.util.Set<jkt.hms.masters.business.Birthdeathreg> getBirthdeathregs () {
		return birthdeathregs;
	}

	/**
	 * Set the value related to the column: Birthdeathregs
	 * @param birthdeathregs the Birthdeathregs value
	 */
	public void setBirthdeathregs (java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs) {
		this.birthdeathregs = birthdeathregs;
	}

	public void addToBirthdeathregs (jkt.hms.masters.business.Birthdeathreg birthdeathreg) {
		if (null == getBirthdeathregs()) setBirthdeathregs(new java.util.TreeSet<jkt.hms.masters.business.Birthdeathreg>());
		getBirthdeathregs().add(birthdeathreg);
	}



	/**
	 * Return the value associated with the column: BlDepositHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlDepositHeader> getBlDepositHeaders () {
		return blDepositHeaders;
	}

	/**
	 * Set the value related to the column: BlDepositHeaders
	 * @param blDepositHeaders the BlDepositHeaders value
	 */
	public void setBlDepositHeaders (java.util.Set<jkt.hms.masters.business.BlDepositHeader> blDepositHeaders) {
		this.blDepositHeaders = blDepositHeaders;
	}

	public void addToBlDepositHeaders (jkt.hms.masters.business.BlDepositHeader blDepositHeader) {
		if (null == getBlDepositHeaders()) setBlDepositHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlDepositHeader>());
		getBlDepositHeaders().add(blDepositHeader);
	}



	/**
	 * Return the value associated with the column: MisNotifiables
	 */
	public java.util.Set<jkt.hms.masters.business.MisNotifiable> getMisNotifiables () {
		return misNotifiables;
	}

	/**
	 * Set the value related to the column: MisNotifiables
	 * @param misNotifiables the MisNotifiables value
	 */
	public void setMisNotifiables (java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables) {
		this.misNotifiables = misNotifiables;
	}

	public void addToMisNotifiables (jkt.hms.masters.business.MisNotifiable misNotifiable) {
		if (null == getMisNotifiables()) setMisNotifiables(new java.util.TreeSet<jkt.hms.masters.business.MisNotifiable>());
		getMisNotifiables().add(misNotifiable);
	}



	/**
	 * Return the value associated with the column: DietDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DietDetails> getDietDetails () {
		return dietDetails;
	}

	/**
	 * Set the value related to the column: DietDetails
	 * @param dietDetails the DietDetails value
	 */
	public void setDietDetails (java.util.Set<jkt.hms.masters.business.DietDetails> dietDetails) {
		this.dietDetails = dietDetails;
	}

	public void addToDietDetails (jkt.hms.masters.business.DietDetails dietDetails) {
		if (null == getDietDetails()) setDietDetails(new java.util.TreeSet<jkt.hms.masters.business.DietDetails>());
		getDietDetails().add(dietDetails);
	}



	/**
	 * Return the value associated with the column: BlPatientLedgers
	 */
	public java.util.Set<jkt.hms.masters.business.BlPatientLedger> getBlPatientLedgers () {
		return blPatientLedgers;
	}

	/**
	 * Set the value related to the column: BlPatientLedgers
	 * @param blPatientLedgers the BlPatientLedgers value
	 */
	public void setBlPatientLedgers (java.util.Set<jkt.hms.masters.business.BlPatientLedger> blPatientLedgers) {
		this.blPatientLedgers = blPatientLedgers;
	}

	public void addToBlPatientLedgers (jkt.hms.masters.business.BlPatientLedger blPatientLedger) {
		if (null == getBlPatientLedgers()) setBlPatientLedgers(new java.util.TreeSet<jkt.hms.masters.business.BlPatientLedger>());
		getBlPatientLedgers().add(blPatientLedger);
	}



	/**
	 * Return the value associated with the column: NursingcareSetups
	 */
	public java.util.Set<jkt.hms.masters.business.NursingcareSetup> getNursingcareSetups () {
		return nursingcareSetups;
	}

	/**
	 * Set the value related to the column: NursingcareSetups
	 * @param nursingcareSetups the NursingcareSetups value
	 */
	public void setNursingcareSetups (java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups) {
		this.nursingcareSetups = nursingcareSetups;
	}

	public void addToNursingcareSetups (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		if (null == getNursingcareSetups()) setNursingcareSetups(new java.util.TreeSet<jkt.hms.masters.business.NursingcareSetup>());
		getNursingcareSetups().add(nursingcareSetup);
	}



	/**
	 * Return the value associated with the column: DgOrderhds
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderhd> getDgOrderhds () {
		return dgOrderhds;
	}

	/**
	 * Set the value related to the column: DgOrderhds
	 * @param dgOrderhds the DgOrderhds value
	 */
	public void setDgOrderhds (java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds) {
		this.dgOrderhds = dgOrderhds;
	}

	public void addToDgOrderhds (jkt.hms.masters.business.DgOrderhd dgOrderhd) {
		if (null == getDgOrderhds()) setDgOrderhds(new java.util.TreeSet<jkt.hms.masters.business.DgOrderhd>());
		getDgOrderhds().add(dgOrderhd);
	}



	/**
	 * Return the value associated with the column: InpatientDocuments
	 */
	public java.util.Set<jkt.hms.masters.business.InpatientDocument> getInpatientDocuments () {
		return inpatientDocuments;
	}

	/**
	 * Set the value related to the column: InpatientDocuments
	 * @param inpatientDocuments the InpatientDocuments value
	 */
	public void setInpatientDocuments (java.util.Set<jkt.hms.masters.business.InpatientDocument> inpatientDocuments) {
		this.inpatientDocuments = inpatientDocuments;
	}

	public void addToInpatientDocuments (jkt.hms.masters.business.InpatientDocument inpatientDocument) {
		if (null == getInpatientDocuments()) setInpatientDocuments(new java.util.TreeSet<jkt.hms.masters.business.InpatientDocument>());
		getInpatientDocuments().add(inpatientDocument);
	}



	/**
	 * Return the value associated with the column: OpdSurgeryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> getOpdSurgeryHeaders () {
		return opdSurgeryHeaders;
	}

	/**
	 * Set the value related to the column: OpdSurgeryHeaders
	 * @param opdSurgeryHeaders the OpdSurgeryHeaders value
	 */
	public void setOpdSurgeryHeaders (java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeaders) {
		this.opdSurgeryHeaders = opdSurgeryHeaders;
	}

	public void addToOpdSurgeryHeaders (jkt.hms.masters.business.OpdSurgeryHeader opdSurgeryHeader) {
		if (null == getOpdSurgeryHeaders()) setOpdSurgeryHeaders(new java.util.TreeSet<jkt.hms.masters.business.OpdSurgeryHeader>());
		getOpdSurgeryHeaders().add(opdSurgeryHeader);
	}



	/**
	 * Return the value associated with the column: MisFatalTrackings
	 */
	public java.util.Set<jkt.hms.masters.business.MisFatalTracking> getMisFatalTrackings () {
		return misFatalTrackings;
	}

	/**
	 * Set the value related to the column: MisFatalTrackings
	 * @param misFatalTrackings the MisFatalTrackings value
	 */
	public void setMisFatalTrackings (java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings) {
		this.misFatalTrackings = misFatalTrackings;
	}

	public void addToMisFatalTrackings (jkt.hms.masters.business.MisFatalTracking misFatalTracking) {
		if (null == getMisFatalTrackings()) setMisFatalTrackings(new java.util.TreeSet<jkt.hms.masters.business.MisFatalTracking>());
		getMisFatalTrackings().add(misFatalTracking);
	}



	/**
	 * Return the value associated with the column: BlRefundHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlRefundHeader> getBlRefundHeaders () {
		return blRefundHeaders;
	}

	/**
	 * Set the value related to the column: BlRefundHeaders
	 * @param blRefundHeaders the BlRefundHeaders value
	 */
	public void setBlRefundHeaders (java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders) {
		this.blRefundHeaders = blRefundHeaders;
	}

	public void addToBlRefundHeaders (jkt.hms.masters.business.BlRefundHeader blRefundHeader) {
		if (null == getBlRefundHeaders()) setBlRefundHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlRefundHeader>());
		getBlRefundHeaders().add(blRefundHeader);
	}



	/**
	 * Return the value associated with the column: DgResultEntryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> getDgResultEntryHeaders () {
		return dgResultEntryHeaders;
	}

	/**
	 * Set the value related to the column: DgResultEntryHeaders
	 * @param dgResultEntryHeaders the DgResultEntryHeaders value
	 */
	public void setDgResultEntryHeaders (java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders) {
		this.dgResultEntryHeaders = dgResultEntryHeaders;
	}

	public void addToDgResultEntryHeaders (jkt.hms.masters.business.DgResultEntryHeader dgResultEntryHeader) {
		if (null == getDgResultEntryHeaders()) setDgResultEntryHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryHeader>());
		getDgResultEntryHeaders().add(dgResultEntryHeader);
	}



	/**
	 * Return the value associated with the column: SilDilStatus
	 */
	public java.util.Set<jkt.hms.masters.business.SilDilStatus> getSilDilStatus () {
		return silDilStatus;
	}

	/**
	 * Set the value related to the column: SilDilStatus
	 * @param silDilStatus the SilDilStatus value
	 */
	public void setSilDilStatus (java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus) {
		this.silDilStatus = silDilStatus;
	}

	public void addToSilDilStatus (jkt.hms.masters.business.SilDilStatus silDilStatus) {
		if (null == getSilDilStatus()) setSilDilStatus(new java.util.TreeSet<jkt.hms.masters.business.SilDilStatus>());
		getSilDilStatus().add(silDilStatus);
	}



	/**
	 * Return the value associated with the column: DgSampleCollectionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> getDgSampleCollectionHeaders () {
		return dgSampleCollectionHeaders;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionHeaders
	 * @param dgSampleCollectionHeaders the DgSampleCollectionHeaders value
	 */
	public void setDgSampleCollectionHeaders (java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders) {
		this.dgSampleCollectionHeaders = dgSampleCollectionHeaders;
	}

	public void addToDgSampleCollectionHeaders (jkt.hms.masters.business.DgSampleCollectionHeader dgSampleCollectionHeader) {
		if (null == getDgSampleCollectionHeaders()) setDgSampleCollectionHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionHeader>());
		getDgSampleCollectionHeaders().add(dgSampleCollectionHeader);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}



	/**
	 * Return the value associated with the column: BlFinalBillDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlFinalBillDetails> getBlFinalBillDetails () {
		return blFinalBillDetails;
	}

	/**
	 * Set the value related to the column: BlFinalBillDetails
	 * @param blFinalBillDetails the BlFinalBillDetails value
	 */
	public void setBlFinalBillDetails (java.util.Set<jkt.hms.masters.business.BlFinalBillDetails> blFinalBillDetails) {
		this.blFinalBillDetails = blFinalBillDetails;
	}

	public void addToBlFinalBillDetails (jkt.hms.masters.business.BlFinalBillDetails blFinalBillDetails) {
		if (null == getBlFinalBillDetails()) setBlFinalBillDetails(new java.util.TreeSet<jkt.hms.masters.business.BlFinalBillDetails>());
		getBlFinalBillDetails().add(blFinalBillDetails);
	}



	/**
	 * Return the value associated with the column: BlReceiptHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlReceiptHeader> getBlReceiptHeaders () {
		return blReceiptHeaders;
	}

	/**
	 * Set the value related to the column: BlReceiptHeaders
	 * @param blReceiptHeaders the BlReceiptHeaders value
	 */
	public void setBlReceiptHeaders (java.util.Set<jkt.hms.masters.business.BlReceiptHeader> blReceiptHeaders) {
		this.blReceiptHeaders = blReceiptHeaders;
	}

	public void addToBlReceiptHeaders (jkt.hms.masters.business.BlReceiptHeader blReceiptHeader) {
		if (null == getBlReceiptHeaders()) setBlReceiptHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlReceiptHeader>());
		getBlReceiptHeaders().add(blReceiptHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Inpatient)) return false;
		else {
			jkt.hms.masters.business.Inpatient inpatient = (jkt.hms.masters.business.Inpatient) obj;
			if (null == this.getId() || null == inpatient.getId()) return false;
			else return (this.getId().equals(inpatient.getId()));
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