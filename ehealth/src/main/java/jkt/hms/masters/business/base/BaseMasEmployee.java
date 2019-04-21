package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_employee table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_employee"
 */

public abstract class BaseMasEmployee  implements Serializable {

	public static String REF = "MasEmployee";
	public static String PROP_IFSC_CODE = "IfscCode";
	public static String PROP_TRADE = "Trade";
	public static String PROP_PROBATION_PERIOD = "ProbationPeriod";
	public static String PROP_MONEY_DRAWN_FROM = "MoneyDrawnFrom";
	public static String PROP_BLOOD_GROUP_ID = "BloodGroupId";
	public static String PROP_INSURANCE_COMPANY = "InsuranceCompany";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_EMPLOYEE_PHOTO = "EmployeePhoto";
	public static String PROP_CARD_NO = "CardNo";
	public static String PROP_EMPLOYEE_DEPARTMENT = "EmployeeDepartment";
	public static String PROP_BANK_ACCOUNT_CODE = "BankAccountCode";
	public static String PROP_RESUMEPERSONALDETAILS = "Resumepersonaldetails";
	public static String PROP_URL = "Url";
	public static String PROP_EMPLOYEE_STATUS = "EmployeeStatus";
	public static String PROP_RATION_DRAWN_FROM = "RationDrawnFrom";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TORS = "Tors";
	public static String PROP_MAS_CATEGORY = "MasCategory";
	public static String PROP_EMP_CATEGORY = "EmpCategory";
	public static String PROP_PREMIUM = "Premium";
	public static String PROP_EMP_RELIGION = "EmpReligion";
	public static String PROP_VISIT_TIME_UPTO = "VisitTimeUpto";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_BANK_ACCOUNT_NUMBER = "BankAccountNumber";
	public static String PROP_COST_CENTER = "CostCenter";
	public static String PROP_EMAIL = "Email";
	public static String PROP_ARRIVAL_COMPLETED = "ArrivalCompleted";
	public static String PROP_LIVINGINOUT = "Livinginout";
	public static String PROP_TEL_NO_RESIDENCE = "TelNoResidence";
	public static String PROP_EMPLOYEE_TYPE = "EmployeeType";
	public static String PROP_LOCAL_ADDRESS = "LocalAddress";
	public static String PROP_LINE_MANAGER = "LineManager";
	public static String PROP_ARRIVAL_REPORT = "ArrivalReport";
	public static String PROP_JOB_CODE = "JobCode";
	public static String PROP_TRIP = "Trip";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LIVING_IN_DATE = "LivingInDate";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_RESUME_ID = "ResumeId";
	public static String PROP_EMPLOYEE_NAME = "EmployeeName";
	public static String PROP_CLASSIFICATION_ID = "ClassificationId";
	public static String PROP_PERMANENT_ADDRESS = "PermanentAddress";
	public static String PROP_EMP_SUB_CASTE = "EmpSubCaste";
	public static String PROP_TITLE = "Title";
	public static String PROP_UHID = "UHID";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_DATE_OF_RESIGNATION = "DateOfResignation";
	public static String PROP_REPORTING_RANK = "ReportingRank";
	public static String PROP_EMP_CASTE = "EmpCaste";
	public static String PROP_RANK = "Rank";
	public static String PROP_VIDE = "Vide";
	public static String PROP_RESIDENTIAL_ADDRESS = "ResidentialAddress";
	public static String PROP_ROOM_NO = "RoomNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TEL_NO_EMERGENCY = "TelNoEmergency";
	public static String PROP_DUTY_EXEMPTION_TO = "DutyExemptionTo";
	public static String PROP_DISCIPLINE_REMARKS = "DisciplineRemarks";
	public static String PROP_ON_PRC = "OnPrc";
	public static String PROP_INSURANCE_END_DATE = "InsuranceEndDate";
	public static String PROP_JOIN_DATE = "JoinDate";
	public static String PROP_JOB_ID = "JobId";
	public static String PROP_BANK_BRANCH = "BankBranch";
	public static String PROP_PF_NO = "PfNo";
	public static String PROP_FATHER_HUSBAND_NAME = "FatherHusbandName";
	public static String PROP_SUFFIX = "Suffix";
	public static String PROP_ACCOUNT_HEAD = "AccountHead";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_EMPLOYEE_CODE = "EmployeeCode";
	public static String PROP_HANDICAP_STATUS = "HandicapStatus";
	public static String PROP_GENDER_ID = "GenderId";
	public static String PROP_EMP_STATUS_ID = "EmpStatusId";
	public static String PROP_POSTED_OUT_ID = "PostedOutId";
	public static String PROP_INSURANCE_START_DATE = "InsuranceStartDate";
	public static String PROP_PAYMENT_MODE = "PaymentMode";
	public static String PROP_POSTEDDATE = "Posteddate";
	public static String PROP_ID = "Id";
	public static String PROP_PERSONAL_DETAILS = "PersonalDetails";
	public static String PROP_LAST_WORKING_DAY = "LastWorkingDay";
	public static String PROP_MOVEMENT_IN_STATUS = "MovementInStatus";
	public static String PROP_LIVING_OUT_DATE = "LivingOutDate";
	public static String PROP_SERVICE_TYPE_ID = "ServiceTypeId";
	public static String PROP_POSTED_UNIT_ID = "PostedUnitId";
	public static String PROP_AGE = "Age";
	public static String PROP_ACTIVITY_ID = "ActivityId";
	public static String PROP_RATION_MONEY_DRAWN = "RationMoneyDrawn";
	public static String PROP_SALARY_STATUS = "SalaryStatus";
	public static String PROP_MEDICAL_REMARKS = "MedicalRemarks";
	public static String PROP_PEN = "PEN";
	public static String PROP_MOVEMENT_OUT_STATUS = "MovementOutStatus";
	public static String PROP_TEL_NO_OFFICE = "TelNoOffice";
	public static String PROP_SPECIALITY_ID = "SpecialityId";
	public static String PROP_INSURANCE_TYPE = "InsuranceType";
	public static String PROP_PORSLNO = "Porslno";
	public static String PROP_LOCAL_UNIT = "LocalUnit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRADE = "Grade";
	public static String PROP_DUTY_EXEMPTION_FROM = "DutyExemptionFrom";
	public static String PROP_BANK_CODE = "BankCode";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_DATE_OF_MARRIAGE = "DateOfMarriage";
	public static String PROP_DEPENDENT_UNIT = "DependentUnit";
	public static String PROP_MAX_CLAIM_AMOUNT = "MaxClaimAmount";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_LEAVE_CHOICE1 = "LeaveChoice1";
	public static String PROP_LEAVE_CHOICE2 = "LeaveChoice2";
	public static String PROP_EMPLOYEE_IMAGE = "EmployeeImage";
	public static String PROP_DISCIPLINE_PENDING = "DisciplinePending";
	public static String PROP_CONFIRMATION_DUE_DATE = "ConfirmationDueDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_CONSULTATION_ROOM = "ConsultationRoom";
	public static String PROP_CELL_NO_EMERGENCY = "CellNoEmergency";
	public static String PROP_EQUIVALENT_DESIGNATION = "EquivalentDesignation";
	public static String PROP_MESS_ID = "MessId";


	// constructors
	public BaseMasEmployee () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmployee (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String employeeCode;
	private java.lang.String firstName;
	private java.lang.String lastName;
	private java.lang.String middleName;
	private java.lang.String employeePhoto;
	private java.lang.String jobCode;
	private java.util.Date appointmentDate;
	private java.lang.Integer empStatusId;
	private java.lang.String telNoEmergency;
	private java.lang.String cellNoEmergency;
	private java.lang.String telNoResidence;
	private java.lang.String email;
	private java.lang.String url;
	private java.lang.String telNoOffice;
	private java.lang.String bankCode;
	private java.lang.String accountHead;
	private java.util.Date joinDate;
	private java.lang.String bankAccountCode;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String bankAccountNumber;
	private java.lang.String serviceNo;
	private java.lang.String consultationRoom;
	private java.lang.String equivalentDesignation;
	private java.lang.String leaveChoice1;
	private java.lang.String leaveChoice2;
	private java.lang.String vide;
	private java.util.Date posteddate;
	private java.util.Date tors;
	private java.lang.String porslno;
	private java.lang.String livinginout;
	private java.util.Date livingInDate;
	private java.util.Date livingOutDate;
	private java.lang.String rationMoneyDrawn;
	private java.util.Date rationDrawnFrom;
	private java.util.Date moneyDrawnFrom;
	private java.lang.String onPrc;
	private java.lang.String arrivalReport;
	private java.util.Date dutyExemptionFrom;
	private java.util.Date dutyExemptionTo;
	private java.lang.String disciplinePending;
	private java.lang.String disciplineRemarks;
	private java.lang.String movementInStatus;
	private java.lang.String movementOutStatus;
	private java.lang.String suffix;
	private java.lang.String prefix;
	private java.math.BigDecimal localUnit;
	private java.math.BigDecimal dependentUnit;
	private java.math.BigDecimal classificationId;
	private java.lang.Integer serviceTypeId;
	private java.math.BigDecimal postedUnitId;
	private java.math.BigDecimal messId;
	private java.math.BigDecimal specialityId;
	private java.util.Date arrivalCompleted;
	private java.math.BigDecimal postedOutId;
	private java.util.Date dateOfBirth;
	private java.util.Date dateOfMarriage;
	private java.math.BigDecimal bloodGroupId;
	private java.lang.String localAddress;
	private java.math.BigDecimal roomNo;
	private java.math.BigDecimal genderId;
	private java.lang.String age;
	private java.lang.Integer activityId;
	private java.lang.String permanentAddress;
	private java.lang.String residentialAddress;
	private java.lang.Integer jobId;
	private java.math.BigDecimal maxClaimAmount;
	private java.lang.Integer resumeId;
	private java.lang.String cardNo;
	private java.lang.String salaryStatus;
	private java.lang.String probationPeriod;
	private java.util.Date confirmationDueDate;
	private java.util.Date lastWorkingDay;
	private java.util.Date dateOfResignation;
	private java.lang.String pfNo;
	private java.lang.String paymentMode;
	private java.lang.String handicapStatus;
	private java.lang.String insuranceType;
	private java.lang.String insuranceCompany;
	private java.util.Date insuranceStartDate;
	private java.util.Date insuranceEndDate;
	private java.lang.String premium;
	private java.lang.String medicalRemarks;
	private java.lang.String fatherHusbandName;
	private java.lang.String employeeName;
	private java.lang.String pEN;
	private java.lang.String bankBranch;
	private java.lang.String ifscCode;
	private java.lang.String uHID;
	private java.util.Date visitTimeUpto;
	private byte[] employeeImage;

	// one to one
	private jkt.hrms.recruitment.masters.business.Resumepersonaldetails resumepersonaldetails;

	// many to one
	private jkt.hms.masters.business.MasEmpStatus employeeStatus;
	private jkt.hms.masters.business.MasReligion empReligion;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hrms.masters.business.HrMasTrip trip;
	private jkt.hms.masters.business.MasCostCenter costCenter;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasRank reportingRank;
	private jkt.hms.masters.business.MasTitle title;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasTrade trade;
	private jkt.hrms.masters.business.MasEmployeeType employeeType;
	private jkt.hms.masters.business.MasEmployee lineManager;
	private jkt.hms.masters.business.MasEmployeeCaste empCaste;
	private jkt.hms.masters.business.MasEmployeeSubCaste empSubCaste;
	private jkt.hms.masters.business.MasCategory masCategory;
	private jkt.hms.masters.business.MasGrade grade;
	private jkt.hrms.masters.business.HrEmployeePersonelDetails personalDetails;
	private jkt.hms.masters.business.MasEmpCategory empCategory;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployeeDepartment employeeDepartment;

	// collections
	private java.util.Set<jkt.hms.masters.business.EmpScMapping> empScMappings;
	private java.util.Set<jkt.hrms.masters.business.HrMasEmployeeEducation> employeeEducation;
	private java.util.Set<jkt.hrms.masters.business.HrEmployeeExperience> employeeExperience;
	private java.util.Set<jkt.hrms.masters.business.HrItaxCalculate> itaxCalculate;
	private java.util.Set<jkt.hms.masters.business.StoreBalanceM> storeBalanceMs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMsByApprovedBy;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMsByReturnBy;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByApprovedBy;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByIssuedBy;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByRequestBy;
	private java.util.Set<jkt.hms.masters.business.Users> users;
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;
	private java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> storeMmfDepartmentMs;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;
	private java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> masEmployeeDependents;
	private java.util.Set<jkt.hrms.masters.business.MasEmployeeContract> masEmployeeContract;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByReturnBy;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByReceivedBy;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTs;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders;
	private java.util.Set<jkt.hrms.masters.business.UserManager> userManager;
	private java.util.Set<jkt.hrms.masters.business.HrEmployeePayStructure> payStructure;
	private java.util.Set<jkt.hrms.masters.business.HrEmployeePayElements> payElements;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="employee_id"
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
	 * Return the value associated with the column: employee_code
	 */
	public java.lang.String getEmployeeCode () {
		return employeeCode;
	}

	/**
	 * Set the value related to the column: employee_code
	 * @param employeeCode the employee_code value
	 */
	public void setEmployeeCode (java.lang.String employeeCode) {
		this.employeeCode = employeeCode;
	}



	/**
	 * Return the value associated with the column: first_name
	 */
	public java.lang.String getFirstName () {
		return firstName;
	}

	/**
	 * Set the value related to the column: first_name
	 * @param firstName the first_name value
	 */
	public void setFirstName (java.lang.String firstName) {
		this.firstName = firstName;
	}



	/**
	 * Return the value associated with the column: last_name
	 */
	public java.lang.String getLastName () {
		return lastName;
	}

	/**
	 * Set the value related to the column: last_name
	 * @param lastName the last_name value
	 */
	public void setLastName (java.lang.String lastName) {
		this.lastName = lastName;
	}



	/**
	 * Return the value associated with the column: middle_name
	 */
	public java.lang.String getMiddleName () {
		return middleName;
	}

	/**
	 * Set the value related to the column: middle_name
	 * @param middleName the middle_name value
	 */
	public void setMiddleName (java.lang.String middleName) {
		this.middleName = middleName;
	}



	/**
	 * Return the value associated with the column: employee_photo
	 */
	public java.lang.String getEmployeePhoto () {
		return employeePhoto;
	}

	/**
	 * Set the value related to the column: employee_photo
	 * @param employeePhoto the employee_photo value
	 */
	public void setEmployeePhoto (java.lang.String employeePhoto) {
		this.employeePhoto = employeePhoto;
	}



	/**
	 * Return the value associated with the column: job_code
	 */
	public java.lang.String getJobCode () {
		return jobCode;
	}

	/**
	 * Set the value related to the column: job_code
	 * @param jobCode the job_code value
	 */
	public void setJobCode (java.lang.String jobCode) {
		this.jobCode = jobCode;
	}



	/**
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * @param appointmentDate the appointment_date value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	/**
	 * Return the value associated with the column: emp_status_id
	 */
	public java.lang.Integer getEmpStatusId () {
		return empStatusId;
	}

	/**
	 * Set the value related to the column: emp_status_id
	 * @param empStatusId the emp_status_id value
	 */
	public void setEmpStatusId (java.lang.Integer empStatusId) {
		this.empStatusId = empStatusId;
	}



	/**
	 * Return the value associated with the column: tel_no_emergency
	 */
	public java.lang.String getTelNoEmergency () {
		return telNoEmergency;
	}

	/**
	 * Set the value related to the column: tel_no_emergency
	 * @param telNoEmergency the tel_no_emergency value
	 */
	public void setTelNoEmergency (java.lang.String telNoEmergency) {
		this.telNoEmergency = telNoEmergency;
	}



	/**
	 * Return the value associated with the column: cell_no_emergency
	 */
	public java.lang.String getCellNoEmergency () {
		return cellNoEmergency;
	}

	/**
	 * Set the value related to the column: cell_no_emergency
	 * @param cellNoEmergency the cell_no_emergency value
	 */
	public void setCellNoEmergency (java.lang.String cellNoEmergency) {
		this.cellNoEmergency = cellNoEmergency;
	}



	/**
	 * Return the value associated with the column: tel_no_residence
	 */
	public java.lang.String getTelNoResidence () {
		return telNoResidence;
	}

	/**
	 * Set the value related to the column: tel_no_residence
	 * @param telNoResidence the tel_no_residence value
	 */
	public void setTelNoResidence (java.lang.String telNoResidence) {
		this.telNoResidence = telNoResidence;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: tel_no_office
	 */
	public java.lang.String getTelNoOffice () {
		return telNoOffice;
	}

	/**
	 * Set the value related to the column: tel_no_office
	 * @param telNoOffice the tel_no_office value
	 */
	public void setTelNoOffice (java.lang.String telNoOffice) {
		this.telNoOffice = telNoOffice;
	}



	/**
	 * Return the value associated with the column: bank_code
	 */
	public java.lang.String getBankCode () {
		return bankCode;
	}

	/**
	 * Set the value related to the column: bank_code
	 * @param bankCode the bank_code value
	 */
	public void setBankCode (java.lang.String bankCode) {
		this.bankCode = bankCode;
	}



	/**
	 * Return the value associated with the column: account_head
	 */
	public java.lang.String getAccountHead () {
		return accountHead;
	}

	/**
	 * Set the value related to the column: account_head
	 * @param accountHead the account_head value
	 */
	public void setAccountHead (java.lang.String accountHead) {
		this.accountHead = accountHead;
	}



	/**
	 * Return the value associated with the column: join_date
	 */
	public java.util.Date getJoinDate () {
		return joinDate;
	}

	/**
	 * Set the value related to the column: join_date
	 * @param joinDate the join_date value
	 */
	public void setJoinDate (java.util.Date joinDate) {
		this.joinDate = joinDate;
	}



	/**
	 * Return the value associated with the column: bank_account_code
	 */
	public java.lang.String getBankAccountCode () {
		return bankAccountCode;
	}

	/**
	 * Set the value related to the column: bank_account_code
	 * @param bankAccountCode the bank_account_code value
	 */
	public void setBankAccountCode (java.lang.String bankAccountCode) {
		this.bankAccountCode = bankAccountCode;
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
	 * Return the value associated with the column: bank_account_number
	 */
	public java.lang.String getBankAccountNumber () {
		return bankAccountNumber;
	}

	/**
	 * Set the value related to the column: bank_account_number
	 * @param bankAccountNumber the bank_account_number value
	 */
	public void setBankAccountNumber (java.lang.String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}



	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: consultation_room
	 */
	public java.lang.String getConsultationRoom () {
		return consultationRoom;
	}

	/**
	 * Set the value related to the column: consultation_room
	 * @param consultationRoom the consultation_room value
	 */
	public void setConsultationRoom (java.lang.String consultationRoom) {
		this.consultationRoom = consultationRoom;
	}



	/**
	 * Return the value associated with the column: equivalent_designation
	 */
	public java.lang.String getEquivalentDesignation () {
		return equivalentDesignation;
	}

	/**
	 * Set the value related to the column: equivalent_designation
	 * @param equivalentDesignation the equivalent_designation value
	 */
	public void setEquivalentDesignation (java.lang.String equivalentDesignation) {
		this.equivalentDesignation = equivalentDesignation;
	}



	/**
	 * Return the value associated with the column: leave_choice1
	 */
	public java.lang.String getLeaveChoice1 () {
		return leaveChoice1;
	}

	/**
	 * Set the value related to the column: leave_choice1
	 * @param leaveChoice1 the leave_choice1 value
	 */
	public void setLeaveChoice1 (java.lang.String leaveChoice1) {
		this.leaveChoice1 = leaveChoice1;
	}



	/**
	 * Return the value associated with the column: leave_choice2
	 */
	public java.lang.String getLeaveChoice2 () {
		return leaveChoice2;
	}

	/**
	 * Set the value related to the column: leave_choice2
	 * @param leaveChoice2 the leave_choice2 value
	 */
	public void setLeaveChoice2 (java.lang.String leaveChoice2) {
		this.leaveChoice2 = leaveChoice2;
	}



	/**
	 * Return the value associated with the column: vide
	 */
	public java.lang.String getVide () {
		return vide;
	}

	/**
	 * Set the value related to the column: vide
	 * @param vide the vide value
	 */
	public void setVide (java.lang.String vide) {
		this.vide = vide;
	}



	/**
	 * Return the value associated with the column: posteddate
	 */
	public java.util.Date getPosteddate () {
		return posteddate;
	}

	/**
	 * Set the value related to the column: posteddate
	 * @param posteddate the posteddate value
	 */
	public void setPosteddate (java.util.Date posteddate) {
		this.posteddate = posteddate;
	}



	/**
	 * Return the value associated with the column: tors
	 */
	public java.util.Date getTors () {
		return tors;
	}

	/**
	 * Set the value related to the column: tors
	 * @param tors the tors value
	 */
	public void setTors (java.util.Date tors) {
		this.tors = tors;
	}



	/**
	 * Return the value associated with the column: porslno
	 */
	public java.lang.String getPorslno () {
		return porslno;
	}

	/**
	 * Set the value related to the column: porslno
	 * @param porslno the porslno value
	 */
	public void setPorslno (java.lang.String porslno) {
		this.porslno = porslno;
	}



	/**
	 * Return the value associated with the column: livinginout
	 */
	public java.lang.String getLivinginout () {
		return livinginout;
	}

	/**
	 * Set the value related to the column: livinginout
	 * @param livinginout the livinginout value
	 */
	public void setLivinginout (java.lang.String livinginout) {
		this.livinginout = livinginout;
	}



	/**
	 * Return the value associated with the column: living_in_date
	 */
	public java.util.Date getLivingInDate () {
		return livingInDate;
	}

	/**
	 * Set the value related to the column: living_in_date
	 * @param livingInDate the living_in_date value
	 */
	public void setLivingInDate (java.util.Date livingInDate) {
		this.livingInDate = livingInDate;
	}



	/**
	 * Return the value associated with the column: living_out_date
	 */
	public java.util.Date getLivingOutDate () {
		return livingOutDate;
	}

	/**
	 * Set the value related to the column: living_out_date
	 * @param livingOutDate the living_out_date value
	 */
	public void setLivingOutDate (java.util.Date livingOutDate) {
		this.livingOutDate = livingOutDate;
	}



	/**
	 * Return the value associated with the column: ration_money_drawn
	 */
	public java.lang.String getRationMoneyDrawn () {
		return rationMoneyDrawn;
	}

	/**
	 * Set the value related to the column: ration_money_drawn
	 * @param rationMoneyDrawn the ration_money_drawn value
	 */
	public void setRationMoneyDrawn (java.lang.String rationMoneyDrawn) {
		this.rationMoneyDrawn = rationMoneyDrawn;
	}



	/**
	 * Return the value associated with the column: ration_drawn_from
	 */
	public java.util.Date getRationDrawnFrom () {
		return rationDrawnFrom;
	}

	/**
	 * Set the value related to the column: ration_drawn_from
	 * @param rationDrawnFrom the ration_drawn_from value
	 */
	public void setRationDrawnFrom (java.util.Date rationDrawnFrom) {
		this.rationDrawnFrom = rationDrawnFrom;
	}



	/**
	 * Return the value associated with the column: money_drawn_from
	 */
	public java.util.Date getMoneyDrawnFrom () {
		return moneyDrawnFrom;
	}

	/**
	 * Set the value related to the column: money_drawn_from
	 * @param moneyDrawnFrom the money_drawn_from value
	 */
	public void setMoneyDrawnFrom (java.util.Date moneyDrawnFrom) {
		this.moneyDrawnFrom = moneyDrawnFrom;
	}



	/**
	 * Return the value associated with the column: on_prc
	 */
	public java.lang.String getOnPrc () {
		return onPrc;
	}

	/**
	 * Set the value related to the column: on_prc
	 * @param onPrc the on_prc value
	 */
	public void setOnPrc (java.lang.String onPrc) {
		this.onPrc = onPrc;
	}



	/**
	 * Return the value associated with the column: arrival_report
	 */
	public java.lang.String getArrivalReport () {
		return arrivalReport;
	}

	/**
	 * Set the value related to the column: arrival_report
	 * @param arrivalReport the arrival_report value
	 */
	public void setArrivalReport (java.lang.String arrivalReport) {
		this.arrivalReport = arrivalReport;
	}



	/**
	 * Return the value associated with the column: duty_exemption_from
	 */
	public java.util.Date getDutyExemptionFrom () {
		return dutyExemptionFrom;
	}

	/**
	 * Set the value related to the column: duty_exemption_from
	 * @param dutyExemptionFrom the duty_exemption_from value
	 */
	public void setDutyExemptionFrom (java.util.Date dutyExemptionFrom) {
		this.dutyExemptionFrom = dutyExemptionFrom;
	}



	/**
	 * Return the value associated with the column: duty_exemption_to
	 */
	public java.util.Date getDutyExemptionTo () {
		return dutyExemptionTo;
	}

	/**
	 * Set the value related to the column: duty_exemption_to
	 * @param dutyExemptionTo the duty_exemption_to value
	 */
	public void setDutyExemptionTo (java.util.Date dutyExemptionTo) {
		this.dutyExemptionTo = dutyExemptionTo;
	}



	/**
	 * Return the value associated with the column: discipline_pending
	 */
	public java.lang.String getDisciplinePending () {
		return disciplinePending;
	}

	/**
	 * Set the value related to the column: discipline_pending
	 * @param disciplinePending the discipline_pending value
	 */
	public void setDisciplinePending (java.lang.String disciplinePending) {
		this.disciplinePending = disciplinePending;
	}



	/**
	 * Return the value associated with the column: discipline_remarks
	 */
	public java.lang.String getDisciplineRemarks () {
		return disciplineRemarks;
	}

	/**
	 * Set the value related to the column: discipline_remarks
	 * @param disciplineRemarks the discipline_remarks value
	 */
	public void setDisciplineRemarks (java.lang.String disciplineRemarks) {
		this.disciplineRemarks = disciplineRemarks;
	}



	/**
	 * Return the value associated with the column: movement_in_status
	 */
	public java.lang.String getMovementInStatus () {
		return movementInStatus;
	}

	/**
	 * Set the value related to the column: movement_in_status
	 * @param movementInStatus the movement_in_status value
	 */
	public void setMovementInStatus (java.lang.String movementInStatus) {
		this.movementInStatus = movementInStatus;
	}



	/**
	 * Return the value associated with the column: movement_out_status
	 */
	public java.lang.String getMovementOutStatus () {
		return movementOutStatus;
	}

	/**
	 * Set the value related to the column: movement_out_status
	 * @param movementOutStatus the movement_out_status value
	 */
	public void setMovementOutStatus (java.lang.String movementOutStatus) {
		this.movementOutStatus = movementOutStatus;
	}



	/**
	 * Return the value associated with the column: suffix
	 */
	public java.lang.String getSuffix () {
		return suffix;
	}

	/**
	 * Set the value related to the column: suffix
	 * @param suffix the suffix value
	 */
	public void setSuffix (java.lang.String suffix) {
		this.suffix = suffix;
	}



	/**
	 * Return the value associated with the column: prefix
	 */
	public java.lang.String getPrefix () {
		return prefix;
	}

	/**
	 * Set the value related to the column: prefix
	 * @param prefix the prefix value
	 */
	public void setPrefix (java.lang.String prefix) {
		this.prefix = prefix;
	}



	/**
	 * Return the value associated with the column: local_unit
	 */
	public java.math.BigDecimal getLocalUnit () {
		return localUnit;
	}

	/**
	 * Set the value related to the column: local_unit
	 * @param localUnit the local_unit value
	 */
	public void setLocalUnit (java.math.BigDecimal localUnit) {
		this.localUnit = localUnit;
	}



	/**
	 * Return the value associated with the column: dependent_unit
	 */
	public java.math.BigDecimal getDependentUnit () {
		return dependentUnit;
	}

	/**
	 * Set the value related to the column: dependent_unit
	 * @param dependentUnit the dependent_unit value
	 */
	public void setDependentUnit (java.math.BigDecimal dependentUnit) {
		this.dependentUnit = dependentUnit;
	}



	/**
	 * Return the value associated with the column: classification_id
	 */
	public java.math.BigDecimal getClassificationId () {
		return classificationId;
	}

	/**
	 * Set the value related to the column: classification_id
	 * @param classificationId the classification_id value
	 */
	public void setClassificationId (java.math.BigDecimal classificationId) {
		this.classificationId = classificationId;
	}



	/**
	 * Return the value associated with the column: service_type_id
	 */
	public java.lang.Integer getServiceTypeId () {
		return serviceTypeId;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceTypeId the service_type_id value
	 */
	public void setServiceTypeId (java.lang.Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}



	/**
	 * Return the value associated with the column: posted_unit_id
	 */
	public java.math.BigDecimal getPostedUnitId () {
		return postedUnitId;
	}

	/**
	 * Set the value related to the column: posted_unit_id
	 * @param postedUnitId the posted_unit_id value
	 */
	public void setPostedUnitId (java.math.BigDecimal postedUnitId) {
		this.postedUnitId = postedUnitId;
	}



	/**
	 * Return the value associated with the column: mess_id
	 */
	public java.math.BigDecimal getMessId () {
		return messId;
	}

	/**
	 * Set the value related to the column: mess_id
	 * @param messId the mess_id value
	 */
	public void setMessId (java.math.BigDecimal messId) {
		this.messId = messId;
	}



	/**
	 * Return the value associated with the column: speciality_id
	 */
	public java.math.BigDecimal getSpecialityId () {
		return specialityId;
	}

	/**
	 * Set the value related to the column: speciality_id
	 * @param specialityId the speciality_id value
	 */
	public void setSpecialityId (java.math.BigDecimal specialityId) {
		this.specialityId = specialityId;
	}



	/**
	 * Return the value associated with the column: arrival_completed
	 */
	public java.util.Date getArrivalCompleted () {
		return arrivalCompleted;
	}

	/**
	 * Set the value related to the column: arrival_completed
	 * @param arrivalCompleted the arrival_completed value
	 */
	public void setArrivalCompleted (java.util.Date arrivalCompleted) {
		this.arrivalCompleted = arrivalCompleted;
	}



	/**
	 * Return the value associated with the column: posted_out_id
	 */
	public java.math.BigDecimal getPostedOutId () {
		return postedOutId;
	}

	/**
	 * Set the value related to the column: posted_out_id
	 * @param postedOutId the posted_out_id value
	 */
	public void setPostedOutId (java.math.BigDecimal postedOutId) {
		this.postedOutId = postedOutId;
	}



	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * @param dateOfBirth the date_of_birth value
	 */
	public void setDateOfBirth (java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	/**
	 * Return the value associated with the column: date_of_marriage
	 */
	public java.util.Date getDateOfMarriage () {
		return dateOfMarriage;
	}

	/**
	 * Set the value related to the column: date_of_marriage
	 * @param dateOfMarriage the date_of_marriage value
	 */
	public void setDateOfMarriage (java.util.Date dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public java.math.BigDecimal getBloodGroupId () {
		return bloodGroupId;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroupId the blood_group_id value
	 */
	public void setBloodGroupId (java.math.BigDecimal bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}



	/**
	 * Return the value associated with the column: local_address
	 */
	public java.lang.String getLocalAddress () {
		return localAddress;
	}

	/**
	 * Set the value related to the column: local_address
	 * @param localAddress the local_address value
	 */
	public void setLocalAddress (java.lang.String localAddress) {
		this.localAddress = localAddress;
	}



	/**
	 * Return the value associated with the column: room_no
	 */
	public java.math.BigDecimal getRoomNo () {
		return roomNo;
	}

	/**
	 * Set the value related to the column: room_no
	 * @param roomNo the room_no value
	 */
	public void setRoomNo (java.math.BigDecimal roomNo) {
		this.roomNo = roomNo;
	}



	/**
	 * Return the value associated with the column: gender_id
	 */
	public java.math.BigDecimal getGenderId () {
		return genderId;
	}

	/**
	 * Set the value related to the column: gender_id
	 * @param genderId the gender_id value
	 */
	public void setGenderId (java.math.BigDecimal genderId) {
		this.genderId = genderId;
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
	 * Return the value associated with the column: activity_id
	 */
	public java.lang.Integer getActivityId () {
		return activityId;
	}

	/**
	 * Set the value related to the column: activity_id
	 * @param activityId the activity_id value
	 */
	public void setActivityId (java.lang.Integer activityId) {
		this.activityId = activityId;
	}



	/**
	 * Return the value associated with the column: permanent_address
	 */
	public java.lang.String getPermanentAddress () {
		return permanentAddress;
	}

	/**
	 * Set the value related to the column: permanent_address
	 * @param permanentAddress the permanent_address value
	 */
	public void setPermanentAddress (java.lang.String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}



	/**
	 * Return the value associated with the column: residential_address
	 */
	public java.lang.String getResidentialAddress () {
		return residentialAddress;
	}

	/**
	 * Set the value related to the column: residential_address
	 * @param residentialAddress the residential_address value
	 */
	public void setResidentialAddress (java.lang.String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}



	/**
	 * Return the value associated with the column: job_id
	 */
	public java.lang.Integer getJobId () {
		return jobId;
	}

	/**
	 * Set the value related to the column: job_id
	 * @param jobId the job_id value
	 */
	public void setJobId (java.lang.Integer jobId) {
		this.jobId = jobId;
	}



	/**
	 * Return the value associated with the column: max_claim_amount
	 */
	public java.math.BigDecimal getMaxClaimAmount () {
		return maxClaimAmount;
	}

	/**
	 * Set the value related to the column: max_claim_amount
	 * @param maxClaimAmount the max_claim_amount value
	 */
	public void setMaxClaimAmount (java.math.BigDecimal maxClaimAmount) {
		this.maxClaimAmount = maxClaimAmount;
	}



	/**
	 * Return the value associated with the column: resume_id
	 */
	public java.lang.Integer getResumeId () {
		return resumeId;
	}

	/**
	 * Set the value related to the column: resume_id
	 * @param resumeId the resume_id value
	 */
	public void setResumeId (java.lang.Integer resumeId) {
		this.resumeId = resumeId;
	}



	/**
	 * Return the value associated with the column: card_no
	 */
	public java.lang.String getCardNo () {
		return cardNo;
	}

	/**
	 * Set the value related to the column: card_no
	 * @param cardNo the card_no value
	 */
	public void setCardNo (java.lang.String cardNo) {
		this.cardNo = cardNo;
	}



	/**
	 * Return the value associated with the column: salary_status
	 */
	public java.lang.String getSalaryStatus () {
		return salaryStatus;
	}

	/**
	 * Set the value related to the column: salary_status
	 * @param salaryStatus the salary_status value
	 */
	public void setSalaryStatus (java.lang.String salaryStatus) {
		this.salaryStatus = salaryStatus;
	}



	/**
	 * Return the value associated with the column: probation_period
	 */
	public java.lang.String getProbationPeriod () {
		return probationPeriod;
	}

	/**
	 * Set the value related to the column: probation_period
	 * @param probationPeriod the probation_period value
	 */
	public void setProbationPeriod (java.lang.String probationPeriod) {
		this.probationPeriod = probationPeriod;
	}



	/**
	 * Return the value associated with the column: confirmation_due_date
	 */
	public java.util.Date getConfirmationDueDate () {
		return confirmationDueDate;
	}

	/**
	 * Set the value related to the column: confirmation_due_date
	 * @param confirmationDueDate the confirmation_due_date value
	 */
	public void setConfirmationDueDate (java.util.Date confirmationDueDate) {
		this.confirmationDueDate = confirmationDueDate;
	}



	/**
	 * Return the value associated with the column: last_working_day
	 */
	public java.util.Date getLastWorkingDay () {
		return lastWorkingDay;
	}

	/**
	 * Set the value related to the column: last_working_day
	 * @param lastWorkingDay the last_working_day value
	 */
	public void setLastWorkingDay (java.util.Date lastWorkingDay) {
		this.lastWorkingDay = lastWorkingDay;
	}



	/**
	 * Return the value associated with the column: date_of_resignation
	 */
	public java.util.Date getDateOfResignation () {
		return dateOfResignation;
	}

	/**
	 * Set the value related to the column: date_of_resignation
	 * @param dateOfResignation the date_of_resignation value
	 */
	public void setDateOfResignation (java.util.Date dateOfResignation) {
		this.dateOfResignation = dateOfResignation;
	}



	/**
	 * Return the value associated with the column: pf_no
	 */
	public java.lang.String getPfNo () {
		return pfNo;
	}

	/**
	 * Set the value related to the column: pf_no
	 * @param pfNo the pf_no value
	 */
	public void setPfNo (java.lang.String pfNo) {
		this.pfNo = pfNo;
	}



	/**
	 * Return the value associated with the column: payment_mode
	 */
	public java.lang.String getPaymentMode () {
		return paymentMode;
	}

	/**
	 * Set the value related to the column: payment_mode
	 * @param paymentMode the payment_mode value
	 */
	public void setPaymentMode (java.lang.String paymentMode) {
		this.paymentMode = paymentMode;
	}



	/**
	 * Return the value associated with the column: handicap_status
	 */
	public java.lang.String getHandicapStatus () {
		return handicapStatus;
	}

	/**
	 * Set the value related to the column: handicap_status
	 * @param handicapStatus the handicap_status value
	 */
	public void setHandicapStatus (java.lang.String handicapStatus) {
		this.handicapStatus = handicapStatus;
	}



	/**
	 * Return the value associated with the column: insurance_type
	 */
	public java.lang.String getInsuranceType () {
		return insuranceType;
	}

	/**
	 * Set the value related to the column: insurance_type
	 * @param insuranceType the insurance_type value
	 */
	public void setInsuranceType (java.lang.String insuranceType) {
		this.insuranceType = insuranceType;
	}



	/**
	 * Return the value associated with the column: insurance_company
	 */
	public java.lang.String getInsuranceCompany () {
		return insuranceCompany;
	}

	/**
	 * Set the value related to the column: insurance_company
	 * @param insuranceCompany the insurance_company value
	 */
	public void setInsuranceCompany (java.lang.String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}



	/**
	 * Return the value associated with the column: insurance_start_date
	 */
	public java.util.Date getInsuranceStartDate () {
		return insuranceStartDate;
	}

	/**
	 * Set the value related to the column: insurance_start_date
	 * @param insuranceStartDate the insurance_start_date value
	 */
	public void setInsuranceStartDate (java.util.Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}



	/**
	 * Return the value associated with the column: insurance_end_date
	 */
	public java.util.Date getInsuranceEndDate () {
		return insuranceEndDate;
	}

	/**
	 * Set the value related to the column: insurance_end_date
	 * @param insuranceEndDate the insurance_end_date value
	 */
	public void setInsuranceEndDate (java.util.Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}



	/**
	 * Return the value associated with the column: insurance_premium
	 */
	public java.lang.String getPremium () {
		return premium;
	}

	/**
	 * Set the value related to the column: insurance_premium
	 * @param premium the insurance_premium value
	 */
	public void setPremium (java.lang.String premium) {
		this.premium = premium;
	}



	/**
	 * Return the value associated with the column: medical_remarks
	 */
	public java.lang.String getMedicalRemarks () {
		return medicalRemarks;
	}

	/**
	 * Set the value related to the column: medical_remarks
	 * @param medicalRemarks the medical_remarks value
	 */
	public void setMedicalRemarks (java.lang.String medicalRemarks) {
		this.medicalRemarks = medicalRemarks;
	}



	/**
	 * Return the value associated with the column: father_husband_name
	 */
	public java.lang.String getFatherHusbandName () {
		return fatherHusbandName;
	}

	/**
	 * Set the value related to the column: father_husband_name
	 * @param fatherHusbandName the father_husband_name value
	 */
	public void setFatherHusbandName (java.lang.String fatherHusbandName) {
		this.fatherHusbandName = fatherHusbandName;
	}



	/**
	 * Return the value associated with the column: emp_name
	 */
	public java.lang.String getEmployeeName () {
		return employeeName;
	}

	/**
	 * Set the value related to the column: emp_name
	 * @param employeeName the emp_name value
	 */
	public void setEmployeeName (java.lang.String employeeName) {
		this.employeeName = employeeName;
	}



	/**
	 * Return the value associated with the column: pe_no
	 */
	public java.lang.String getPEN () {
		return pEN;
	}

	/**
	 * Set the value related to the column: pe_no
	 * @param pEN the pe_no value
	 */
	public void setPEN (java.lang.String pEN) {
		this.pEN = pEN;
	}



	/**
	 * Return the value associated with the column: bank_branch
	 */
	public java.lang.String getBankBranch () {
		return bankBranch;
	}

	/**
	 * Set the value related to the column: bank_branch
	 * @param bankBranch the bank_branch value
	 */
	public void setBankBranch (java.lang.String bankBranch) {
		this.bankBranch = bankBranch;
	}



	/**
	 * Return the value associated with the column: ifsc_code
	 */
	public java.lang.String getIfscCode () {
		return ifscCode;
	}

	/**
	 * Set the value related to the column: ifsc_code
	 * @param ifscCode the ifsc_code value
	 */
	public void setIfscCode (java.lang.String ifscCode) {
		this.ifscCode = ifscCode;
	}



	/**
	 * Return the value associated with the column: uhid
	 */
	public java.lang.String getUHID () {
		return uHID;
	}

	/**
	 * Set the value related to the column: uhid
	 * @param uHID the uhid value
	 */
	public void setUHID (java.lang.String uHID) {
		this.uHID = uHID;
	}



	/**
	 * Return the value associated with the column: visit_time_upto
	 */
	public java.util.Date getVisitTimeUpto () {
		return visitTimeUpto;
	}

	/**
	 * Set the value related to the column: visit_time_upto
	 * @param visitTimeUpto the visit_time_upto value
	 */
	public void setVisitTimeUpto (java.util.Date visitTimeUpto) {
		this.visitTimeUpto = visitTimeUpto;
	}



	/**
	 * Return the value associated with the column: employee_image
	 */
	public byte[] getEmployeeImage () {
		return employeeImage;
	}

	/**
	 * Set the value related to the column: employee_image
	 * @param employeeImage the employee_image value
	 */
	public void setEmployeeImage (byte[] employeeImage) {
		this.employeeImage = employeeImage;
	}



	/**
	 * Return the value associated with the column: Resumepersonaldetails
	 */
	public jkt.hrms.recruitment.masters.business.Resumepersonaldetails getResumepersonaldetails () {
		return resumepersonaldetails;
	}

	/**
	 * Set the value related to the column: Resumepersonaldetails
	 * @param resumepersonaldetails the Resumepersonaldetails value
	 */
	public void setResumepersonaldetails (jkt.hrms.recruitment.masters.business.Resumepersonaldetails resumepersonaldetails) {
		this.resumepersonaldetails = resumepersonaldetails;
	}



	/**
	 * Return the value associated with the column: employee_status_id
	 */
	public jkt.hms.masters.business.MasEmpStatus getEmployeeStatus () {
		return employeeStatus;
	}

	/**
	 * Set the value related to the column: employee_status_id
	 * @param employeeStatus the employee_status_id value
	 */
	public void setEmployeeStatus (jkt.hms.masters.business.MasEmpStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}



	/**
	 * Return the value associated with the column: emp_religion
	 */
	public jkt.hms.masters.business.MasReligion getEmpReligion () {
		return empReligion;
	}

	/**
	 * Set the value related to the column: emp_religion
	 * @param empReligion the emp_religion value
	 */
	public void setEmpReligion (jkt.hms.masters.business.MasReligion empReligion) {
		this.empReligion = empReligion;
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
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: trip_id
	 */
	public jkt.hrms.masters.business.HrMasTrip getTrip () {
		return trip;
	}

	/**
	 * Set the value related to the column: trip_id
	 * @param trip the trip_id value
	 */
	public void setTrip (jkt.hrms.masters.business.HrMasTrip trip) {
		this.trip = trip;
	}



	/**
	 * Return the value associated with the column: cost_center_id
	 */
	public jkt.hms.masters.business.MasCostCenter getCostCenter () {
		return costCenter;
	}

	/**
	 * Set the value related to the column: cost_center_id
	 * @param costCenter the cost_center_id value
	 */
	public void setCostCenter (jkt.hms.masters.business.MasCostCenter costCenter) {
		this.costCenter = costCenter;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: reporting_rank_id
	 */
	public jkt.hms.masters.business.MasRank getReportingRank () {
		return reportingRank;
	}

	/**
	 * Set the value related to the column: reporting_rank_id
	 * @param reportingRank the reporting_rank_id value
	 */
	public void setReportingRank (jkt.hms.masters.business.MasRank reportingRank) {
		this.reportingRank = reportingRank;
	}



	/**
	 * Return the value associated with the column: title_id
	 */
	public jkt.hms.masters.business.MasTitle getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title_id
	 * @param title the title_id value
	 */
	public void setTitle (jkt.hms.masters.business.MasTitle title) {
		this.title = title;
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
	 * Return the value associated with the column: trade_id
	 */
	public jkt.hms.masters.business.MasTrade getTrade () {
		return trade;
	}

	/**
	 * Set the value related to the column: trade_id
	 * @param trade the trade_id value
	 */
	public void setTrade (jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}



	/**
	 * Return the value associated with the column: employee_type_id
	 */
	public jkt.hrms.masters.business.MasEmployeeType getEmployeeType () {
		return employeeType;
	}

	/**
	 * Set the value related to the column: employee_type_id
	 * @param employeeType the employee_type_id value
	 */
	public void setEmployeeType (jkt.hrms.masters.business.MasEmployeeType employeeType) {
		this.employeeType = employeeType;
	}



	/**
	 * Return the value associated with the column: line_manager_id
	 */
	public jkt.hms.masters.business.MasEmployee getLineManager () {
		return lineManager;
	}

	/**
	 * Set the value related to the column: line_manager_id
	 * @param lineManager the line_manager_id value
	 */
	public void setLineManager (jkt.hms.masters.business.MasEmployee lineManager) {
		this.lineManager = lineManager;
	}



	/**
	 * Return the value associated with the column: emp_cast
	 */
	public jkt.hms.masters.business.MasEmployeeCaste getEmpCaste () {
		return empCaste;
	}

	/**
	 * Set the value related to the column: emp_cast
	 * @param empCaste the emp_cast value
	 */
	public void setEmpCaste (jkt.hms.masters.business.MasEmployeeCaste empCaste) {
		this.empCaste = empCaste;
	}



	/**
	 * Return the value associated with the column: emp_sub_cast
	 */
	public jkt.hms.masters.business.MasEmployeeSubCaste getEmpSubCaste () {
		return empSubCaste;
	}

	/**
	 * Set the value related to the column: emp_sub_cast
	 * @param empSubCaste the emp_sub_cast value
	 */
	public void setEmpSubCaste (jkt.hms.masters.business.MasEmployeeSubCaste empSubCaste) {
		this.empSubCaste = empSubCaste;
	}



	/**
	 * Return the value associated with the column: emp_category
	 */
	public jkt.hms.masters.business.MasCategory getMasCategory () {
		return masCategory;
	}

	/**
	 * Set the value related to the column: emp_category
	 * @param masCategory the emp_category value
	 */
	public void setMasCategory (jkt.hms.masters.business.MasCategory masCategory) {
		this.masCategory = masCategory;
	}



	/**
	 * Return the value associated with the column: grade_id
	 */
	public jkt.hms.masters.business.MasGrade getGrade () {
		return grade;
	}

	/**
	 * Set the value related to the column: grade_id
	 * @param grade the grade_id value
	 */
	public void setGrade (jkt.hms.masters.business.MasGrade grade) {
		this.grade = grade;
	}



	/**
	 * Return the value associated with the column: personal_details_id
	 */
	public jkt.hrms.masters.business.HrEmployeePersonelDetails getPersonalDetails () {
		return personalDetails;
	}

	/**
	 * Set the value related to the column: personal_details_id
	 * @param personalDetails the personal_details_id value
	 */
	public void setPersonalDetails (jkt.hrms.masters.business.HrEmployeePersonelDetails personalDetails) {
		this.personalDetails = personalDetails;
	}



	/**
	 * Return the value associated with the column: emp_category_id
	 */
	public jkt.hms.masters.business.MasEmpCategory getEmpCategory () {
		return empCategory;
	}

	/**
	 * Set the value related to the column: emp_category_id
	 * @param empCategory the emp_category_id value
	 */
	public void setEmpCategory (jkt.hms.masters.business.MasEmpCategory empCategory) {
		this.empCategory = empCategory;
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
	 * Return the value associated with the column: employee_department_id
	 */
	public jkt.hms.masters.business.MasEmployeeDepartment getEmployeeDepartment () {
		return employeeDepartment;
	}

	/**
	 * Set the value related to the column: employee_department_id
	 * @param employeeDepartment the employee_department_id value
	 */
	public void setEmployeeDepartment (jkt.hms.masters.business.MasEmployeeDepartment employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}



	/**
	 * Return the value associated with the column: EmpScMappings
	 */
	public java.util.Set<jkt.hms.masters.business.EmpScMapping> getEmpScMappings () {
		return empScMappings;
	}

	/**
	 * Set the value related to the column: EmpScMappings
	 * @param empScMappings the EmpScMappings value
	 */
	public void setEmpScMappings (java.util.Set<jkt.hms.masters.business.EmpScMapping> empScMappings) {
		this.empScMappings = empScMappings;
	}

	public void addToEmpScMappings (jkt.hms.masters.business.EmpScMapping empScMapping) {
		if (null == getEmpScMappings()) setEmpScMappings(new java.util.TreeSet<jkt.hms.masters.business.EmpScMapping>());
		getEmpScMappings().add(empScMapping);
	}



	/**
	 * Return the value associated with the column: EmployeeEducation
	 */
	public java.util.Set<jkt.hrms.masters.business.HrMasEmployeeEducation> getEmployeeEducation () {
		return employeeEducation;
	}

	/**
	 * Set the value related to the column: EmployeeEducation
	 * @param employeeEducation the EmployeeEducation value
	 */
	public void setEmployeeEducation (java.util.Set<jkt.hrms.masters.business.HrMasEmployeeEducation> employeeEducation) {
		this.employeeEducation = employeeEducation;
	}



	/**
	 * Return the value associated with the column: EmployeeExperience
	 */
	public java.util.Set<jkt.hrms.masters.business.HrEmployeeExperience> getEmployeeExperience () {
		return employeeExperience;
	}

	/**
	 * Set the value related to the column: EmployeeExperience
	 * @param employeeExperience the EmployeeExperience value
	 */
	public void setEmployeeExperience (java.util.Set<jkt.hrms.masters.business.HrEmployeeExperience> employeeExperience) {
		this.employeeExperience = employeeExperience;
	}



	/**
	 * Return the value associated with the column: ItaxCalculate
	 */
	public java.util.Set<jkt.hrms.masters.business.HrItaxCalculate> getItaxCalculate () {
		return itaxCalculate;
	}

	/**
	 * Set the value related to the column: ItaxCalculate
	 * @param itaxCalculate the ItaxCalculate value
	 */
	public void setItaxCalculate (java.util.Set<jkt.hrms.masters.business.HrItaxCalculate> itaxCalculate) {
		this.itaxCalculate = itaxCalculate;
	}



	/**
	 * Return the value associated with the column: StoreBalanceMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBalanceM> getStoreBalanceMs () {
		return storeBalanceMs;
	}

	/**
	 * Set the value related to the column: StoreBalanceMs
	 * @param storeBalanceMs the StoreBalanceMs value
	 */
	public void setStoreBalanceMs (java.util.Set<jkt.hms.masters.business.StoreBalanceM> storeBalanceMs) {
		this.storeBalanceMs = storeBalanceMs;
	}

	public void addToStoreBalanceMs (jkt.hms.masters.business.StoreBalanceM storeBalanceM) {
		if (null == getStoreBalanceMs()) setStoreBalanceMs(new java.util.TreeSet<jkt.hms.masters.business.StoreBalanceM>());
		getStoreBalanceMs().add(storeBalanceM);
	}



	/**
	 * Return the value associated with the column: StoreGrnReturnMsByApprovedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> getStoreGrnReturnMsByApprovedBy () {
		return storeGrnReturnMsByApprovedBy;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnMsByApprovedBy
	 * @param storeGrnReturnMsByApprovedBy the StoreGrnReturnMsByApprovedBy value
	 */
	public void setStoreGrnReturnMsByApprovedBy (java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMsByApprovedBy) {
		this.storeGrnReturnMsByApprovedBy = storeGrnReturnMsByApprovedBy;
	}

	public void addToStoreGrnReturnMsByApprovedBy (jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM) {
		if (null == getStoreGrnReturnMsByApprovedBy()) setStoreGrnReturnMsByApprovedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnM>());
		getStoreGrnReturnMsByApprovedBy().add(storeGrnReturnM);
	}



	/**
	 * Return the value associated with the column: StoreGrnReturnMsByReturnBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> getStoreGrnReturnMsByReturnBy () {
		return storeGrnReturnMsByReturnBy;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnMsByReturnBy
	 * @param storeGrnReturnMsByReturnBy the StoreGrnReturnMsByReturnBy value
	 */
	public void setStoreGrnReturnMsByReturnBy (java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMsByReturnBy) {
		this.storeGrnReturnMsByReturnBy = storeGrnReturnMsByReturnBy;
	}

	public void addToStoreGrnReturnMsByReturnBy (jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM) {
		if (null == getStoreGrnReturnMsByReturnBy()) setStoreGrnReturnMsByReturnBy(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnM>());
		getStoreGrnReturnMsByReturnBy().add(storeGrnReturnM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByApprovedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByApprovedBy () {
		return storeIssueMsByApprovedBy;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByApprovedBy
	 * @param storeIssueMsByApprovedBy the StoreIssueMsByApprovedBy value
	 */
	public void setStoreIssueMsByApprovedBy (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByApprovedBy) {
		this.storeIssueMsByApprovedBy = storeIssueMsByApprovedBy;
	}

	public void addToStoreIssueMsByApprovedBy (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByApprovedBy()) setStoreIssueMsByApprovedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByApprovedBy().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByIssuedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByIssuedBy () {
		return storeIssueMsByIssuedBy;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByIssuedBy
	 * @param storeIssueMsByIssuedBy the StoreIssueMsByIssuedBy value
	 */
	public void setStoreIssueMsByIssuedBy (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByIssuedBy) {
		this.storeIssueMsByIssuedBy = storeIssueMsByIssuedBy;
	}

	public void addToStoreIssueMsByIssuedBy (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByIssuedBy()) setStoreIssueMsByIssuedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByIssuedBy().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByRequestBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByRequestBy () {
		return storeIssueMsByRequestBy;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByRequestBy
	 * @param storeIssueMsByRequestBy the StoreIssueMsByRequestBy value
	 */
	public void setStoreIssueMsByRequestBy (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByRequestBy) {
		this.storeIssueMsByRequestBy = storeIssueMsByRequestBy;
	}

	public void addToStoreIssueMsByRequestBy (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByRequestBy()) setStoreIssueMsByRequestBy(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByRequestBy().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: Users
	 */
	public java.util.Set<jkt.hms.masters.business.Users> getUsers () {
		return users;
	}

	/**
	 * Set the value related to the column: Users
	 * @param users the Users value
	 */
	public void setUsers (java.util.Set<jkt.hms.masters.business.Users> users) {
		this.users = users;
	}

	public void addToUsers (jkt.hms.masters.business.Users users) {
		if (null == getUsers()) setUsers(new java.util.TreeSet<jkt.hms.masters.business.Users>());
		getUsers().add(users);
	}



	/**
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts () {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * @param masDiscounts the MasDiscounts value
	 */
	public void setMasDiscounts (java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts (jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts()) setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}



	/**
	 * Return the value associated with the column: StoreMmfDepartmentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> getStoreMmfDepartmentMs () {
		return storeMmfDepartmentMs;
	}

	/**
	 * Set the value related to the column: StoreMmfDepartmentMs
	 * @param storeMmfDepartmentMs the StoreMmfDepartmentMs value
	 */
	public void setStoreMmfDepartmentMs (java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> storeMmfDepartmentMs) {
		this.storeMmfDepartmentMs = storeMmfDepartmentMs;
	}

	public void addToStoreMmfDepartmentMs (jkt.hms.masters.business.StoreMmfDepartmentM storeMmfDepartmentM) {
		if (null == getStoreMmfDepartmentMs()) setStoreMmfDepartmentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreMmfDepartmentM>());
		getStoreMmfDepartmentMs().add(storeMmfDepartmentM);
	}



	/**
	 * Return the value associated with the column: DgSampleCollectionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> getDgSampleCollectionDetails () {
		return dgSampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionDetails
	 * @param dgSampleCollectionDetails the DgSampleCollectionDetails value
	 */
	public void setDgSampleCollectionDetails (java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails) {
		this.dgSampleCollectionDetails = dgSampleCollectionDetails;
	}

	public void addToDgSampleCollectionDetails (jkt.hms.masters.business.DgSampleCollectionDetails dgSampleCollectionDetails) {
		if (null == getDgSampleCollectionDetails()) setDgSampleCollectionDetails(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionDetails>());
		getDgSampleCollectionDetails().add(dgSampleCollectionDetails);
	}



	/**
	 * Return the value associated with the column: MasEmployeeDependents
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> getMasEmployeeDependents () {
		return masEmployeeDependents;
	}

	/**
	 * Set the value related to the column: MasEmployeeDependents
	 * @param masEmployeeDependents the MasEmployeeDependents value
	 */
	public void setMasEmployeeDependents (java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> masEmployeeDependents) {
		this.masEmployeeDependents = masEmployeeDependents;
	}

	public void addToMasEmployeeDependents (jkt.hms.masters.business.MasEmployeeDependent masEmployeeDependent) {
		if (null == getMasEmployeeDependents()) setMasEmployeeDependents(new java.util.TreeSet<jkt.hms.masters.business.MasEmployeeDependent>());
		getMasEmployeeDependents().add(masEmployeeDependent);
	}



	/**
	 * Return the value associated with the column: MasEmployeeContract
	 */
	public java.util.Set<jkt.hrms.masters.business.MasEmployeeContract> getMasEmployeeContract () {
		return masEmployeeContract;
	}

	/**
	 * Set the value related to the column: MasEmployeeContract
	 * @param masEmployeeContract the MasEmployeeContract value
	 */
	public void setMasEmployeeContract (java.util.Set<jkt.hrms.masters.business.MasEmployeeContract> masEmployeeContract) {
		this.masEmployeeContract = masEmployeeContract;
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnMsByReturnBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> getStoreInternalReturnMsByReturnBy () {
		return storeInternalReturnMsByReturnBy;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnMsByReturnBy
	 * @param storeInternalReturnMsByReturnBy the StoreInternalReturnMsByReturnBy value
	 */
	public void setStoreInternalReturnMsByReturnBy (java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByReturnBy) {
		this.storeInternalReturnMsByReturnBy = storeInternalReturnMsByReturnBy;
	}

	public void addToStoreInternalReturnMsByReturnBy (jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM) {
		if (null == getStoreInternalReturnMsByReturnBy()) setStoreInternalReturnMsByReturnBy(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnM>());
		getStoreInternalReturnMsByReturnBy().add(storeInternalReturnM);
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnMsByReceivedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> getStoreInternalReturnMsByReceivedBy () {
		return storeInternalReturnMsByReceivedBy;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnMsByReceivedBy
	 * @param storeInternalReturnMsByReceivedBy the StoreInternalReturnMsByReceivedBy value
	 */
	public void setStoreInternalReturnMsByReceivedBy (java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByReceivedBy) {
		this.storeInternalReturnMsByReceivedBy = storeInternalReturnMsByReceivedBy;
	}

	public void addToStoreInternalReturnMsByReceivedBy (jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM) {
		if (null == getStoreInternalReturnMsByReceivedBy()) setStoreInternalReturnMsByReceivedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnM>());
		getStoreInternalReturnMsByReceivedBy().add(storeInternalReturnM);
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
	 * Return the value associated with the column: StoreGrnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnM> getStoreGrnMs () {
		return storeGrnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnMs
	 * @param storeGrnMs the StoreGrnMs value
	 */
	public void setStoreGrnMs (java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs) {
		this.storeGrnMs = storeGrnMs;
	}

	public void addToStoreGrnMs (jkt.hms.masters.business.StoreGrnM storeGrnM) {
		if (null == getStoreGrnMs()) setStoreGrnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnM>());
		getStoreGrnMs().add(storeGrnM);
	}



	/**
	 * Return the value associated with the column: StoreIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueT> getStoreIssueTs () {
		return storeIssueTs;
	}

	/**
	 * Set the value related to the column: StoreIssueTs
	 * @param storeIssueTs the StoreIssueTs value
	 */
	public void setStoreIssueTs (java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTs) {
		this.storeIssueTs = storeIssueTs;
	}

	public void addToStoreIssueTs (jkt.hms.masters.business.StoreIssueT storeIssueT) {
		if (null == getStoreIssueTs()) setStoreIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueT>());
		getStoreIssueTs().add(storeIssueT);
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
	 * Return the value associated with the column: UserManager
	 */
	public java.util.Set<jkt.hrms.masters.business.UserManager> getUserManager () {
		return userManager;
	}

	/**
	 * Set the value related to the column: UserManager
	 * @param userManager the UserManager value
	 */
	public void setUserManager (java.util.Set<jkt.hrms.masters.business.UserManager> userManager) {
		this.userManager = userManager;
	}



	/**
	 * Return the value associated with the column: PayStructure
	 */
	public java.util.Set<jkt.hrms.masters.business.HrEmployeePayStructure> getPayStructure () {
		return payStructure;
	}

	/**
	 * Set the value related to the column: PayStructure
	 * @param payStructure the PayStructure value
	 */
	public void setPayStructure (java.util.Set<jkt.hrms.masters.business.HrEmployeePayStructure> payStructure) {
		this.payStructure = payStructure;
	}



	/**
	 * Return the value associated with the column: PayElements
	 */
	public java.util.Set<jkt.hrms.masters.business.HrEmployeePayElements> getPayElements () {
		return payElements;
	}

	/**
	 * Set the value related to the column: PayElements
	 * @param payElements the PayElements value
	 */
	public void setPayElements (java.util.Set<jkt.hrms.masters.business.HrEmployeePayElements> payElements) {
		this.payElements = payElements;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasEmployee)) return false;
		else {
			jkt.hms.masters.business.MasEmployee masEmployee = (jkt.hms.masters.business.MasEmployee) obj;
			if (null == this.getId() || null == masEmployee.getId()) return false;
			else return (this.getId().equals(masEmployee.getId()));
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