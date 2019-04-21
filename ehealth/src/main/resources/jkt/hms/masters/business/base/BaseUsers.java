package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the users table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="users"
 */

public abstract class BaseUsers  implements Serializable {

	public static String REF = "Users";
	public static String PROP_USER_TYPE = "UserType";
	public static String PROP_LOGIN_NAME = "LoginName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_USER_NAME = "UserName";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_REPORT_TO_ADMIN = "ReportToAdmin";
	public static String PROP_LOGIN_COUNT = "LoginCount";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_SUCCESSFUL_LOGIN_TIME = "LastSuccessfulLoginTime";
	public static String PROP_LAST_SUCCESSFUL_LOGIN_DATE = "LastSuccessfulLoginDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SIM_SERIAL_NO = "SimSerialNo";
	public static String PROP_EMAIL_ADDRESS = "EmailAddress";
	public static String PROP_SUPERUSER = "Superuser";
	public static String PROP_ID = "Id";
	public static String PROP_WIPSE_STATUS = "WipseStatus";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_IMEI_NO = "ImeiNo";


	// constructors
	public BaseUsers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUsers (
		java.lang.Integer id,
		java.lang.String loginName,
		java.lang.String userName,
		java.lang.String password,
		java.lang.String status,
		java.lang.String superuser) {

		this.setId(id);
		this.setLoginName(loginName);
		this.setUserName(userName);
		this.setPassword(password);
		this.setStatus(status);
		this.setSuperuser(superuser);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String loginName;
	private java.lang.String userName;
	private java.lang.String password;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String emailAddress;
	private java.util.Date lastSuccessfulLoginDate;
	private java.lang.String lastSuccessfulLoginTime;
	private java.lang.Integer loginCount;
	private java.lang.String reportToAdmin;
	private java.lang.String superuser;
	private java.lang.Integer userType;
	private java.lang.String simSerialNo;
	private java.lang.Long imeiNo;
	private java.lang.String wipseStatus;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;
	private java.util.Set<jkt.hms.masters.business.UserStatusHospital> userStatusHospitals;
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals;
	private java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments;
	private java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles;
	private java.util.Set<jkt.hms.masters.business.UserDepartment> userDepartments;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> userUsergroupApplications;
	private java.util.Set<jkt.hms.masters.business.Visit> visits;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfers;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> userUsergroupHospitals;
	private java.util.Set<jkt.hms.masters.business.UserHospital> userHospitals;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="user_id"
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
	 * Return the value associated with the column: login_name
	 */
	public java.lang.String getLoginName () {
		return loginName;
	}

	/**
	 * Set the value related to the column: login_name
	 * @param loginName the login_name value
	 */
	public void setLoginName (java.lang.String loginName) {
		this.loginName = loginName;
	}



	/**
	 * Return the value associated with the column: user_name
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: user_name
	 * @param userName the user_name value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
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
	 * Return the value associated with the column: email_address
	 */
	public java.lang.String getEmailAddress () {
		return emailAddress;
	}

	/**
	 * Set the value related to the column: email_address
	 * @param emailAddress the email_address value
	 */
	public void setEmailAddress (java.lang.String emailAddress) {
		this.emailAddress = emailAddress;
	}



	/**
	 * Return the value associated with the column: last_successful_login_date
	 */
	public java.util.Date getLastSuccessfulLoginDate () {
		return lastSuccessfulLoginDate;
	}

	/**
	 * Set the value related to the column: last_successful_login_date
	 * @param lastSuccessfulLoginDate the last_successful_login_date value
	 */
	public void setLastSuccessfulLoginDate (java.util.Date lastSuccessfulLoginDate) {
		this.lastSuccessfulLoginDate = lastSuccessfulLoginDate;
	}



	/**
	 * Return the value associated with the column: last_successful_login_time
	 */
	public java.lang.String getLastSuccessfulLoginTime () {
		return lastSuccessfulLoginTime;
	}

	/**
	 * Set the value related to the column: last_successful_login_time
	 * @param lastSuccessfulLoginTime the last_successful_login_time value
	 */
	public void setLastSuccessfulLoginTime (java.lang.String lastSuccessfulLoginTime) {
		this.lastSuccessfulLoginTime = lastSuccessfulLoginTime;
	}



	/**
	 * Return the value associated with the column: login_count
	 */
	public java.lang.Integer getLoginCount () {
		return loginCount;
	}

	/**
	 * Set the value related to the column: login_count
	 * @param loginCount the login_count value
	 */
	public void setLoginCount (java.lang.Integer loginCount) {
		this.loginCount = loginCount;
	}



	/**
	 * Return the value associated with the column: report_to_admin
	 */
	public java.lang.String getReportToAdmin () {
		return reportToAdmin;
	}

	/**
	 * Set the value related to the column: report_to_admin
	 * @param reportToAdmin the report_to_admin value
	 */
	public void setReportToAdmin (java.lang.String reportToAdmin) {
		this.reportToAdmin = reportToAdmin;
	}



	/**
	 * Return the value associated with the column: superuser
	 */
	public java.lang.String getSuperuser () {
		return superuser;
	}

	/**
	 * Set the value related to the column: superuser
	 * @param superuser the superuser value
	 */
	public void setSuperuser (java.lang.String superuser) {
		this.superuser = superuser;
	}



	/**
	 * Return the value associated with the column: user_type
	 */
	public java.lang.Integer getUserType () {
		return userType;
	}

	/**
	 * Set the value related to the column: user_type
	 * @param userType the user_type value
	 */
	public void setUserType (java.lang.Integer userType) {
		this.userType = userType;
	}



	/**
	 * Return the value associated with the column: sim_serial_no
	 */
	public java.lang.String getSimSerialNo () {
		return simSerialNo;
	}

	/**
	 * Set the value related to the column: sim_serial_no
	 * @param simSerialNo the sim_serial_no value
	 */
	public void setSimSerialNo (java.lang.String simSerialNo) {
		this.simSerialNo = simSerialNo;
	}



	/**
	 * Return the value associated with the column: imei_no
	 */
	public java.lang.Long getImeiNo () {
		return imeiNo;
	}

	/**
	 * Set the value related to the column: imei_no
	 * @param imeiNo the imei_no value
	 */
	public void setImeiNo (java.lang.Long imeiNo) {
		this.imeiNo = imeiNo;
	}



	/**
	 * Return the value associated with the column: wipse_status
	 */
	public java.lang.String getWipseStatus () {
		return wipseStatus;
	}

	/**
	 * Set the value related to the column: wipse_status
	 * @param wipseStatus the wipse_status value
	 */
	public void setWipseStatus (java.lang.String wipseStatus) {
		this.wipseStatus = wipseStatus;
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
	 * Return the value associated with the column: MlcCases
	 */
	public java.util.Set<jkt.hms.masters.business.MlcCase> getMlcCases () {
		return mlcCases;
	}

	/**
	 * Set the value related to the column: MlcCases
	 * @param mlcCases the MlcCases value
	 */
	public void setMlcCases (java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases) {
		this.mlcCases = mlcCases;
	}

	public void addToMlcCases (jkt.hms.masters.business.MlcCase mlcCase) {
		if (null == getMlcCases()) setMlcCases(new java.util.TreeSet<jkt.hms.masters.business.MlcCase>());
		getMlcCases().add(mlcCase);
	}



	/**
	 * Return the value associated with the column: UserStatusHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserStatusHospital> getUserStatusHospitals () {
		return userStatusHospitals;
	}

	/**
	 * Set the value related to the column: UserStatusHospitals
	 * @param userStatusHospitals the UserStatusHospitals value
	 */
	public void setUserStatusHospitals (java.util.Set<jkt.hms.masters.business.UserStatusHospital> userStatusHospitals) {
		this.userStatusHospitals = userStatusHospitals;
	}

	public void addToUserStatusHospitals (jkt.hms.masters.business.UserStatusHospital userStatusHospital) {
		if (null == getUserStatusHospitals()) setUserStatusHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserStatusHospital>());
		getUserStatusHospitals().add(userStatusHospital);
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
	 * Return the value associated with the column: UserAccessrightsHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> getUserAccessrightsHospitals () {
		return userAccessrightsHospitals;
	}

	/**
	 * Set the value related to the column: UserAccessrightsHospitals
	 * @param userAccessrightsHospitals the UserAccessrightsHospitals value
	 */
	public void setUserAccessrightsHospitals (java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals) {
		this.userAccessrightsHospitals = userAccessrightsHospitals;
	}

	public void addToUserAccessrightsHospitals (jkt.hms.masters.business.UserAccessrightsHospital userAccessrightsHospital) {
		if (null == getUserAccessrightsHospitals()) setUserAccessrightsHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserAccessrightsHospital>());
		getUserAccessrightsHospitals().add(userAccessrightsHospital);
	}



	/**
	 * Return the value associated with the column: UserHospitalDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> getUserHospitalDepartments () {
		return userHospitalDepartments;
	}

	/**
	 * Set the value related to the column: UserHospitalDepartments
	 * @param userHospitalDepartments the UserHospitalDepartments value
	 */
	public void setUserHospitalDepartments (java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments) {
		this.userHospitalDepartments = userHospitalDepartments;
	}

	public void addToUserHospitalDepartments (jkt.hms.masters.business.UserHospitalDepartment userHospitalDepartment) {
		if (null == getUserHospitalDepartments()) setUserHospitalDepartments(new java.util.TreeSet<jkt.hms.masters.business.UserHospitalDepartment>());
		getUserHospitalDepartments().add(userHospitalDepartment);
	}



	/**
	 * Return the value associated with the column: UserHospitalRoles
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospitalRole> getUserHospitalRoles () {
		return userHospitalRoles;
	}

	/**
	 * Set the value related to the column: UserHospitalRoles
	 * @param userHospitalRoles the UserHospitalRoles value
	 */
	public void setUserHospitalRoles (java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles) {
		this.userHospitalRoles = userHospitalRoles;
	}

	public void addToUserHospitalRoles (jkt.hms.masters.business.UserHospitalRole userHospitalRole) {
		if (null == getUserHospitalRoles()) setUserHospitalRoles(new java.util.TreeSet<jkt.hms.masters.business.UserHospitalRole>());
		getUserHospitalRoles().add(userHospitalRole);
	}



	/**
	 * Return the value associated with the column: UserDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.UserDepartment> getUserDepartments () {
		return userDepartments;
	}

	/**
	 * Set the value related to the column: UserDepartments
	 * @param userDepartments the UserDepartments value
	 */
	public void setUserDepartments (java.util.Set<jkt.hms.masters.business.UserDepartment> userDepartments) {
		this.userDepartments = userDepartments;
	}

	public void addToUserDepartments (jkt.hms.masters.business.UserDepartment userDepartment) {
		if (null == getUserDepartments()) setUserDepartments(new java.util.TreeSet<jkt.hms.masters.business.UserDepartment>());
		getUserDepartments().add(userDepartment);
	}



	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}



	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set<jkt.hms.masters.business.AttachInpatient> getAttachInpatients () {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * @param attachInpatients the AttachInpatients value
	 */
	public void setAttachInpatients (java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients (jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients()) setAttachInpatients(new java.util.TreeSet<jkt.hms.masters.business.AttachInpatient>());
		getAttachInpatients().add(attachInpatient);
	}



	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients () {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * @param inpatients the Inpatients value
	 */
	public void setInpatients (java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients (jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients()) setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}



	/**
	 * Return the value associated with the column: UserUsergroupApplications
	 */
	public java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> getUserUsergroupApplications () {
		return userUsergroupApplications;
	}

	/**
	 * Set the value related to the column: UserUsergroupApplications
	 * @param userUsergroupApplications the UserUsergroupApplications value
	 */
	public void setUserUsergroupApplications (java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> userUsergroupApplications) {
		this.userUsergroupApplications = userUsergroupApplications;
	}

	public void addToUserUsergroupApplications (jkt.hms.masters.business.UserUsergroupApplication userUsergroupApplication) {
		if (null == getUserUsergroupApplications()) setUserUsergroupApplications(new java.util.TreeSet<jkt.hms.masters.business.UserUsergroupApplication>());
		getUserUsergroupApplications().add(userUsergroupApplication);
	}



	/**
	 * Return the value associated with the column: Visits
	 */
	public java.util.Set<jkt.hms.masters.business.Visit> getVisits () {
		return visits;
	}

	/**
	 * Set the value related to the column: Visits
	 * @param visits the Visits value
	 */
	public void setVisits (java.util.Set<jkt.hms.masters.business.Visit> visits) {
		this.visits = visits;
	}

	public void addToVisits (jkt.hms.masters.business.Visit visit) {
		if (null == getVisits()) setVisits(new java.util.TreeSet<jkt.hms.masters.business.Visit>());
		getVisits().add(visit);
	}



	/**
	 * Return the value associated with the column: Transfers
	 */
	public java.util.Set<jkt.hms.masters.business.Transfer> getTransfers () {
		return transfers;
	}

	/**
	 * Set the value related to the column: Transfers
	 * @param transfers the Transfers value
	 */
	public void setTransfers (java.util.Set<jkt.hms.masters.business.Transfer> transfers) {
		this.transfers = transfers;
	}

	public void addToTransfers (jkt.hms.masters.business.Transfer transfer) {
		if (null == getTransfers()) setTransfers(new java.util.TreeSet<jkt.hms.masters.business.Transfer>());
		getTransfers().add(transfer);
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
	 * Return the value associated with the column: UserUsergroupHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> getUserUsergroupHospitals () {
		return userUsergroupHospitals;
	}

	/**
	 * Set the value related to the column: UserUsergroupHospitals
	 * @param userUsergroupHospitals the UserUsergroupHospitals value
	 */
	public void setUserUsergroupHospitals (java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> userUsergroupHospitals) {
		this.userUsergroupHospitals = userUsergroupHospitals;
	}

	public void addToUserUsergroupHospitals (jkt.hms.masters.business.UserUsergroupHospital userUsergroupHospital) {
		if (null == getUserUsergroupHospitals()) setUserUsergroupHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserUsergroupHospital>());
		getUserUsergroupHospitals().add(userUsergroupHospital);
	}



	/**
	 * Return the value associated with the column: UserHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospital> getUserHospitals () {
		return userHospitals;
	}

	/**
	 * Set the value related to the column: UserHospitals
	 * @param userHospitals the UserHospitals value
	 */
	public void setUserHospitals (java.util.Set<jkt.hms.masters.business.UserHospital> userHospitals) {
		this.userHospitals = userHospitals;
	}

	public void addToUserHospitals (jkt.hms.masters.business.UserHospital userHospital) {
		if (null == getUserHospitals()) setUserHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserHospital>());
		getUserHospitals().add(userHospital);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Users)) return false;
		else {
			jkt.hms.masters.business.Users users = (jkt.hms.masters.business.Users) obj;
			if (null == this.getId() || null == users.getId()) return false;
			else return (this.getId().equals(users.getId()));
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