package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumepersonaldetails
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumepersonaldetails"
 */

public abstract class BaseResumepersonaldetails implements Serializable {

	public static String REF = "Resumepersonaldetails";
	public static String PROP_RESUME_STATUS_HISTORY = "ResumeStatusHistory";
	public static String PROP_JOB_PROFILE_I_D = "JobProfileID";
	public static String PROP_ADD_BY = "AddBy";
	public static String PROP_UPDATED_ON = "UpdatedOn";
	public static String PROP_DU = "DU";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_PASSPORT_STATUS = "PassportStatus";
	public static String PROP_EXPERIENCE_YEAR = "ExperienceYear";
	public static String PROP_ADDRESS3 = "Address3";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_MOBILE = "Mobile";
	public static String PROP_PROJECT = "Project";
	public static String PROP_OWNERSHIP_CHNAGED_ON = "OwnershipChnagedOn";
	public static String PROP_RESOURCE_REQUISITION = "ResourceRequisition";
	public static String PROP_ASSIGNED_RESUME_TO = "AssignedResumeTo";
	public static String PROP_OTHER_CITY = "OtherCity";
	public static String PROP_EXPERIENCE_MONTH = "ExperienceMonth";
	public static String PROP_RESUME_STATUS = "ResumeStatus";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_EXPECTED_CTC = "ExpectedCtc";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_ACTIVE = "Active";
	public static String PROP_COUNTRY_ID = "CountryId";
	public static String PROP_ID = "Id";
	public static String PROP_PASSPORT_NO = "PassportNo";
	public static String PROP_CURRENT_EMPLOYER = "CurrentEmployer";
	public static String PROP_PROJECT_ID = "ProjectId";
	public static String PROP_TITLE_ID = "TitleId";
	public static String PROP_CITY_ID = "CityId";
	public static String PROP_ADD_RESUME_BY = "AddResumeBy";
	public static String PROP_NAME_OF_SOURCE = "NameOfSource";
	public static String PROP_OTHER_PHONE = "OtherPhone";
	public static String PROP_DOMAIN_KNOWLEDGE = "DomainKnowledge";
	public static String PROP_ADD_ON = "AddOn";
	public static String PROP_STATE_ID = "StateId";
	public static String PROP_VISA_REMARKS = "VisaRemarks";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_PASSPORT_EXPIRY_DATE = "PassportExpiryDate";
	public static String PROP_RESIDENCE_PHONE = "ResidencePhone";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_CURRENT_CTC = "CurrentCtc";
	public static String PROP_RESOURCE_REQUISITION_ID = "ResourceRequisitionId";
	public static String PROP_CURRENT_DESIGNATION = "CurrentDesignation";
	public static String PROP_JOB_PROFILE = "JobProfile";
	public static String PROP_DU_I_D = "DuID";
	public static String PROP_ASSIGNED_TO = "AssignedTo";
	public static String PROP_INSTITUTION = "Institution";
	public static String PROP_CITY = "City";
	public static String PROP_PREVIOUS_EMPLOYER = "PreviousEmployer";
	public static String PROP_TITLE = "Title";
	public static String PROP_JOINING_PERIOD = "JoiningPeriod";
	public static String PROP_YEARPASSING = "Yearpassing";
	public static String PROP_EDUCATION = "Education";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_STATE = "State";
	public static String PROP_ON_SITE_AVAILABILITY = "OnSiteAvailability";
	public static String PROP_RESUME_THROUGH = "ResumeThrough";
	public static String PROP_SALARY_REMARKS = "SalaryRemarks";

	// constructors
	public BaseResumepersonaldetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumepersonaldetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseResumepersonaldetails(java.lang.Integer id,
			boolean onSiteAvailability, boolean active) {

		this.setId(id);
		this.setOnSiteAvailability(onSiteAvailability);
		this.setActive(active);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String firstName;
	private int titleId;
	private java.lang.String lastName;
	private java.lang.String middleName;
	private java.lang.String dateOfBirth;
	private java.lang.String address1;
	private java.lang.String address2;
	private java.lang.String address3;
	private java.lang.String emailId;
	private java.lang.String mobile;
	private java.lang.String residencePhone;
	private java.lang.String otherPhone;
	private java.lang.Integer countryId;
	private java.lang.Integer stateId;
	private java.lang.Integer cityId;
	private java.lang.String otherCity;
	private java.lang.String passportStatus;
	private java.lang.String passportNo;
	private java.lang.String passportExpiryDate;
	private java.lang.String visaRemarks;
	private java.lang.String education;
	private java.lang.Integer yearpassing;
	private java.lang.String institution;
	private java.lang.Integer experienceYear;
	private java.lang.Integer experienceMonth;
	private java.lang.String currentEmployer;
	private java.lang.String previousEmployer;
	private java.lang.String domainKnowledge;
	private java.lang.Integer jobProfileID;
	private java.lang.String currentCtc;
	private java.lang.String expectedCtc;
	private java.lang.String salaryRemarks;
	private java.lang.Integer duID;
	private java.lang.Integer projectId;
	private java.lang.Integer joiningPeriod;
	private java.lang.String resumeThrough;
	private java.lang.String nameOfSource;
	private java.lang.String currentDesignation;
	private boolean onSiteAvailability;
	private java.lang.Integer addBy;
	private java.lang.Integer assignedTo;
	private java.util.Date addOn;
	private java.util.Date ownershipChnagedOn;
	private java.util.Date updatedOn;
	private java.lang.Integer resourceRequisitionId;
	private boolean active;

	// one to one
	private jkt.hrms.recruitment.masters.business.Resumestatus resumeStatus;
	private jkt.hrms.recruitment.masters.business.Resumestatushistory resumeStatusHistory;

	// many to one
	private jkt.hms.masters.business.MasTitle title;
	private jkt.hms.masters.business.Users addResumeBy;
	private jkt.hms.masters.business.Users assignedResumeTo;
	private jkt.hms.masters.business.MasRank jobProfile;
	private jkt.hrms.recruitment.masters.business.Resumeprojectsdetail project;
	private jkt.hms.masters.business.MasDepartment dU;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hrms.recruitment.masters.business.ResourceRequisition resourceRequisition;

	// collections
	private java.util.Set<jkt.hrms.recruitment.masters.business.Resumeskill> resumeSkill;
	private java.util.Set<jkt.hrms.recruitment.masters.business.Resumeremarks> resumeRemarks;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="resume_id"
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
	 * Return the value associated with the column: first_name
	 */
	public java.lang.String getFirstName() {
		return firstName;
	}

	/**
	 * Set the value related to the column: first_name
	 * 
	 * @param firstName
	 *            the first_name value
	 */
	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Return the value associated with the column: titleId
	 */
	public int getTitleId() {
		return titleId;
	}

	/**
	 * Set the value related to the column: titleId
	 * 
	 * @param titleId
	 *            the titleId value
	 */
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	/**
	 * Return the value associated with the column: last_name
	 */
	public java.lang.String getLastName() {
		return lastName;
	}

	/**
	 * Set the value related to the column: last_name
	 * 
	 * @param lastName
	 *            the last_name value
	 */
	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return the value associated with the column: middle_name
	 */
	public java.lang.String getMiddleName() {
		return middleName;
	}

	/**
	 * Set the value related to the column: middle_name
	 * 
	 * @param middleName
	 *            the middle_name value
	 */
	public void setMiddleName(java.lang.String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.lang.String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * 
	 * @param dateOfBirth
	 *            the date_of_birth value
	 */
	public void setDateOfBirth(java.lang.String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Return the value associated with the column: address1
	 */
	public java.lang.String getAddress1() {
		return address1;
	}

	/**
	 * Set the value related to the column: address1
	 * 
	 * @param address1
	 *            the address1 value
	 */
	public void setAddress1(java.lang.String address1) {
		this.address1 = address1;
	}

	/**
	 * Return the value associated with the column: address2
	 */
	public java.lang.String getAddress2() {
		return address2;
	}

	/**
	 * Set the value related to the column: address2
	 * 
	 * @param address2
	 *            the address2 value
	 */
	public void setAddress2(java.lang.String address2) {
		this.address2 = address2;
	}

	/**
	 * Return the value associated with the column: address3
	 */
	public java.lang.String getAddress3() {
		return address3;
	}

	/**
	 * Set the value related to the column: address3
	 * 
	 * @param address3
	 *            the address3 value
	 */
	public void setAddress3(java.lang.String address3) {
		this.address3 = address3;
	}

	/**
	 * Return the value associated with the column: email_id
	 */
	public java.lang.String getEmailId() {
		return emailId;
	}

	/**
	 * Set the value related to the column: email_id
	 * 
	 * @param emailId
	 *            the email_id value
	 */
	public void setEmailId(java.lang.String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Return the value associated with the column: mobile
	 */
	public java.lang.String getMobile() {
		return mobile;
	}

	/**
	 * Set the value related to the column: mobile
	 * 
	 * @param mobile
	 *            the mobile value
	 */
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Return the value associated with the column: residence_phone
	 */
	public java.lang.String getResidencePhone() {
		return residencePhone;
	}

	/**
	 * Set the value related to the column: residence_phone
	 * 
	 * @param residencePhone
	 *            the residence_phone value
	 */
	public void setResidencePhone(java.lang.String residencePhone) {
		this.residencePhone = residencePhone;
	}

	/**
	 * Return the value associated with the column: other_phone
	 */
	public java.lang.String getOtherPhone() {
		return otherPhone;
	}

	/**
	 * Set the value related to the column: other_phone
	 * 
	 * @param otherPhone
	 *            the other_phone value
	 */
	public void setOtherPhone(java.lang.String otherPhone) {
		this.otherPhone = otherPhone;
	}

	/**
	 * Return the value associated with the column: countryId
	 */
	public java.lang.Integer getCountryId() {
		return countryId;
	}

	/**
	 * Set the value related to the column: countryId
	 * 
	 * @param countryId
	 *            the countryId value
	 */
	public void setCountryId(java.lang.Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * Return the value associated with the column: stateId
	 */
	public java.lang.Integer getStateId() {
		return stateId;
	}

	/**
	 * Set the value related to the column: stateId
	 * 
	 * @param stateId
	 *            the stateId value
	 */
	public void setStateId(java.lang.Integer stateId) {
		this.stateId = stateId;
	}

	/**
	 * Return the value associated with the column: cityId
	 */
	public java.lang.Integer getCityId() {
		return cityId;
	}

	/**
	 * Set the value related to the column: cityId
	 * 
	 * @param cityId
	 *            the cityId value
	 */
	public void setCityId(java.lang.Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * Return the value associated with the column: otherCity
	 */
	public java.lang.String getOtherCity() {
		return otherCity;
	}

	/**
	 * Set the value related to the column: otherCity
	 * 
	 * @param otherCity
	 *            the otherCity value
	 */
	public void setOtherCity(java.lang.String otherCity) {
		this.otherCity = otherCity;
	}

	/**
	 * Return the value associated with the column: passport_status
	 */
	public java.lang.String getPassportStatus() {
		return passportStatus;
	}

	/**
	 * Set the value related to the column: passport_status
	 * 
	 * @param passportStatus
	 *            the passport_status value
	 */
	public void setPassportStatus(java.lang.String passportStatus) {
		this.passportStatus = passportStatus;
	}

	/**
	 * Return the value associated with the column: passport_no
	 */
	public java.lang.String getPassportNo() {
		return passportNo;
	}

	/**
	 * Set the value related to the column: passport_no
	 * 
	 * @param passportNo
	 *            the passport_no value
	 */
	public void setPassportNo(java.lang.String passportNo) {
		this.passportNo = passportNo;
	}

	/**
	 * Return the value associated with the column: passport_expirydate
	 */
	public java.lang.String getPassportExpiryDate() {
		return passportExpiryDate;
	}

	/**
	 * Set the value related to the column: passport_expirydate
	 * 
	 * @param passportExpiryDate
	 *            the passport_expirydate value
	 */
	public void setPassportExpiryDate(java.lang.String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	/**
	 * Return the value associated with the column: visa_remarks
	 */
	public java.lang.String getVisaRemarks() {
		return visaRemarks;
	}

	/**
	 * Set the value related to the column: visa_remarks
	 * 
	 * @param visaRemarks
	 *            the visa_remarks value
	 */
	public void setVisaRemarks(java.lang.String visaRemarks) {
		this.visaRemarks = visaRemarks;
	}

	/**
	 * Return the value associated with the column: education
	 */
	public java.lang.String getEducation() {
		return education;
	}

	/**
	 * Set the value related to the column: education
	 * 
	 * @param education
	 *            the education value
	 */
	public void setEducation(java.lang.String education) {
		this.education = education;
	}

	/**
	 * Return the value associated with the column: yearpassing
	 */
	public java.lang.Integer getYearpassing() {
		return yearpassing;
	}

	/**
	 * Set the value related to the column: yearpassing
	 * 
	 * @param yearpassing
	 *            the yearpassing value
	 */
	public void setYearpassing(java.lang.Integer yearpassing) {
		this.yearpassing = yearpassing;
	}

	/**
	 * Return the value associated with the column: institution
	 */
	public java.lang.String getInstitution() {
		return institution;
	}

	/**
	 * Set the value related to the column: institution
	 * 
	 * @param institution
	 *            the institution value
	 */
	public void setInstitution(java.lang.String institution) {
		this.institution = institution;
	}

	/**
	 * Return the value associated with the column: experience_year
	 */
	public java.lang.Integer getExperienceYear() {
		return experienceYear;
	}

	/**
	 * Set the value related to the column: experience_year
	 * 
	 * @param experienceYear
	 *            the experience_year value
	 */
	public void setExperienceYear(java.lang.Integer experienceYear) {
		this.experienceYear = experienceYear;
	}

	/**
	 * Return the value associated with the column: experience_month
	 */
	public java.lang.Integer getExperienceMonth() {
		return experienceMonth;
	}

	/**
	 * Set the value related to the column: experience_month
	 * 
	 * @param experienceMonth
	 *            the experience_month value
	 */
	public void setExperienceMonth(java.lang.Integer experienceMonth) {
		this.experienceMonth = experienceMonth;
	}

	/**
	 * Return the value associated with the column: current_employer
	 */
	public java.lang.String getCurrentEmployer() {
		return currentEmployer;
	}

	/**
	 * Set the value related to the column: current_employer
	 * 
	 * @param currentEmployer
	 *            the current_employer value
	 */
	public void setCurrentEmployer(java.lang.String currentEmployer) {
		this.currentEmployer = currentEmployer;
	}

	/**
	 * Return the value associated with the column: previous_employer
	 */
	public java.lang.String getPreviousEmployer() {
		return previousEmployer;
	}

	/**
	 * Set the value related to the column: previous_employer
	 * 
	 * @param previousEmployer
	 *            the previous_employer value
	 */
	public void setPreviousEmployer(java.lang.String previousEmployer) {
		this.previousEmployer = previousEmployer;
	}

	/**
	 * Return the value associated with the column: domain_knowledge
	 */
	public java.lang.String getDomainKnowledge() {
		return domainKnowledge;
	}

	/**
	 * Set the value related to the column: domain_knowledge
	 * 
	 * @param domainKnowledge
	 *            the domain_knowledge value
	 */
	public void setDomainKnowledge(java.lang.String domainKnowledge) {
		this.domainKnowledge = domainKnowledge;
	}

	/**
	 * Return the value associated with the column: job_profile
	 */
	public java.lang.Integer getJobProfileID() {
		return jobProfileID;
	}

	/**
	 * Set the value related to the column: job_profile
	 * 
	 * @param jobProfileID
	 *            the job_profile value
	 */
	public void setJobProfileID(java.lang.Integer jobProfileID) {
		this.jobProfileID = jobProfileID;
	}

	/**
	 * Return the value associated with the column: current_ctc
	 */
	public java.lang.String getCurrentCtc() {
		return currentCtc;
	}

	/**
	 * Set the value related to the column: current_ctc
	 * 
	 * @param currentCtc
	 *            the current_ctc value
	 */
	public void setCurrentCtc(java.lang.String currentCtc) {
		this.currentCtc = currentCtc;
	}

	/**
	 * Return the value associated with the column: expected_ctc
	 */
	public java.lang.String getExpectedCtc() {
		return expectedCtc;
	}

	/**
	 * Set the value related to the column: expected_ctc
	 * 
	 * @param expectedCtc
	 *            the expected_ctc value
	 */
	public void setExpectedCtc(java.lang.String expectedCtc) {
		this.expectedCtc = expectedCtc;
	}

	/**
	 * Return the value associated with the column: salary_remarks
	 */
	public java.lang.String getSalaryRemarks() {
		return salaryRemarks;
	}

	/**
	 * Set the value related to the column: salary_remarks
	 * 
	 * @param salaryRemarks
	 *            the salary_remarks value
	 */
	public void setSalaryRemarks(java.lang.String salaryRemarks) {
		this.salaryRemarks = salaryRemarks;
	}

	/**
	 * Return the value associated with the column: du_id
	 */
	public java.lang.Integer getDuID() {
		return duID;
	}

	/**
	 * Set the value related to the column: du_id
	 * 
	 * @param duID
	 *            the du_id value
	 */
	public void setDuID(java.lang.Integer duID) {
		this.duID = duID;
	}

	/**
	 * Return the value associated with the column: project_id
	 */
	public java.lang.Integer getProjectId() {
		return projectId;
	}

	/**
	 * Set the value related to the column: project_id
	 * 
	 * @param projectId
	 *            the project_id value
	 */
	public void setProjectId(java.lang.Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * Return the value associated with the column: Joining_period
	 */
	public java.lang.Integer getJoiningPeriod() {
		return joiningPeriod;
	}

	/**
	 * Set the value related to the column: Joining_period
	 * 
	 * @param joiningPeriod
	 *            the Joining_period value
	 */
	public void setJoiningPeriod(java.lang.Integer joiningPeriod) {
		this.joiningPeriod = joiningPeriod;
	}

	/**
	 * Return the value associated with the column: resume_through
	 */
	public java.lang.String getResumeThrough() {
		return resumeThrough;
	}

	/**
	 * Set the value related to the column: resume_through
	 * 
	 * @param resumeThrough
	 *            the resume_through value
	 */
	public void setResumeThrough(java.lang.String resumeThrough) {
		this.resumeThrough = resumeThrough;
	}

	/**
	 * Return the value associated with the column: name_of_source
	 */
	public java.lang.String getNameOfSource() {
		return nameOfSource;
	}

	/**
	 * Set the value related to the column: name_of_source
	 * 
	 * @param nameOfSource
	 *            the name_of_source value
	 */
	public void setNameOfSource(java.lang.String nameOfSource) {
		this.nameOfSource = nameOfSource;
	}

	/**
	 * Return the value associated with the column: current_designation
	 */
	public java.lang.String getCurrentDesignation() {
		return currentDesignation;
	}

	/**
	 * Set the value related to the column: current_designation
	 * 
	 * @param currentDesignation
	 *            the current_designation value
	 */
	public void setCurrentDesignation(java.lang.String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}

	/**
	 * Return the value associated with the column: On_Site_Availability
	 */
	public boolean isOnSiteAvailability() {
		return onSiteAvailability;
	}

	/**
	 * Set the value related to the column: On_Site_Availability
	 * 
	 * @param onSiteAvailability
	 *            the On_Site_Availability value
	 */
	public void setOnSiteAvailability(boolean onSiteAvailability) {
		this.onSiteAvailability = onSiteAvailability;
	}

	/**
	 * Return the value associated with the column: add_by
	 */
	public java.lang.Integer getAddBy() {
		return addBy;
	}

	/**
	 * Set the value related to the column: add_by
	 * 
	 * @param addBy
	 *            the add_by value
	 */
	public void setAddBy(java.lang.Integer addBy) {
		this.addBy = addBy;
	}

	/**
	 * Return the value associated with the column: assigned_to
	 */
	public java.lang.Integer getAssignedTo() {
		return assignedTo;
	}

	/**
	 * Set the value related to the column: assigned_to
	 * 
	 * @param assignedTo
	 *            the assigned_to value
	 */
	public void setAssignedTo(java.lang.Integer assignedTo) {
		this.assignedTo = assignedTo;
	}

	/**
	 * Return the value associated with the column: add_on
	 */
	public java.util.Date getAddOn() {
		return addOn;
	}

	/**
	 * Set the value related to the column: add_on
	 * 
	 * @param addOn
	 *            the add_on value
	 */
	public void setAddOn(java.util.Date addOn) {
		this.addOn = addOn;
	}

	/**
	 * Return the value associated with the column: Ownership_Changed_On
	 */
	public java.util.Date getOwnershipChnagedOn() {
		return ownershipChnagedOn;
	}

	/**
	 * Set the value related to the column: Ownership_Changed_On
	 * 
	 * @param ownershipChnagedOn
	 *            the Ownership_Changed_On value
	 */
	public void setOwnershipChnagedOn(java.util.Date ownershipChnagedOn) {
		this.ownershipChnagedOn = ownershipChnagedOn;
	}

	/**
	 * Return the value associated with the column: updated_on
	 */
	public java.util.Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * Set the value related to the column: updated_on
	 * 
	 * @param updatedOn
	 *            the updated_on value
	 */
	public void setUpdatedOn(java.util.Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * Return the value associated with the column: resource_requisition_id
	 */
	public java.lang.Integer getResourceRequisitionId() {
		return resourceRequisitionId;
	}

	/**
	 * Set the value related to the column: resource_requisition_id
	 * 
	 * @param resourceRequisitionId
	 *            the resource_requisition_id value
	 */
	public void setResourceRequisitionId(java.lang.Integer resourceRequisitionId) {
		this.resourceRequisitionId = resourceRequisitionId;
	}

	/**
	 * Return the value associated with the column: active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Set the value related to the column: active
	 * 
	 * @param active
	 *            the active value
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Return the value associated with the column: ResumeStatus
	 */
	public jkt.hrms.recruitment.masters.business.Resumestatus getResumeStatus() {
		return resumeStatus;
	}

	/**
	 * Set the value related to the column: ResumeStatus
	 * 
	 * @param resumeStatus
	 *            the ResumeStatus value
	 */
	public void setResumeStatus(
			jkt.hrms.recruitment.masters.business.Resumestatus resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	/**
	 * Return the value associated with the column: ResumeStatusHistory
	 */
	public jkt.hrms.recruitment.masters.business.Resumestatushistory getResumeStatusHistory() {
		return resumeStatusHistory;
	}

	/**
	 * Set the value related to the column: ResumeStatusHistory
	 * 
	 * @param resumeStatusHistory
	 *            the ResumeStatusHistory value
	 */
	public void setResumeStatusHistory(
			jkt.hrms.recruitment.masters.business.Resumestatushistory resumeStatusHistory) {
		this.resumeStatusHistory = resumeStatusHistory;
	}

	/**
	 * Return the value associated with the column: titleId
	 */
	public jkt.hms.masters.business.MasTitle getTitle() {
		return title;
	}

	/**
	 * Set the value related to the column: titleId
	 * 
	 * @param title
	 *            the titleId value
	 */
	public void setTitle(jkt.hms.masters.business.MasTitle title) {
		this.title = title;
	}

	/**
	 * Return the value associated with the column: add_by
	 */
	public jkt.hms.masters.business.Users getAddResumeBy() {
		return addResumeBy;
	}

	/**
	 * Set the value related to the column: add_by
	 * 
	 * @param addResumeBy
	 *            the add_by value
	 */
	public void setAddResumeBy(jkt.hms.masters.business.Users addResumeBy) {
		this.addResumeBy = addResumeBy;
	}

	/**
	 * Return the value associated with the column: assigned_to
	 */
	public jkt.hms.masters.business.Users getAssignedResumeTo() {
		return assignedResumeTo;
	}

	/**
	 * Set the value related to the column: assigned_to
	 * 
	 * @param assignedResumeTo
	 *            the assigned_to value
	 */
	public void setAssignedResumeTo(
			jkt.hms.masters.business.Users assignedResumeTo) {
		this.assignedResumeTo = assignedResumeTo;
	}

	/**
	 * Return the value associated with the column: job_profile
	 */
	public jkt.hms.masters.business.MasRank getJobProfile() {
		return jobProfile;
	}

	/**
	 * Set the value related to the column: job_profile
	 * 
	 * @param jobProfile
	 *            the job_profile value
	 */
	public void setJobProfile(jkt.hms.masters.business.MasRank jobProfile) {
		this.jobProfile = jobProfile;
	}

	/**
	 * Return the value associated with the column: project_id
	 */
	public jkt.hrms.recruitment.masters.business.Resumeprojectsdetail getProject() {
		return project;
	}

	/**
	 * Set the value related to the column: project_id
	 * 
	 * @param project
	 *            the project_id value
	 */
	public void setProject(
			jkt.hrms.recruitment.masters.business.Resumeprojectsdetail project) {
		this.project = project;
	}

	/**
	 * Return the value associated with the column: du_id
	 */
	public jkt.hms.masters.business.MasDepartment getDU() {
		return dU;
	}

	/**
	 * Set the value related to the column: du_id
	 * 
	 * @param dU
	 *            the du_id value
	 */
	public void setDU(jkt.hms.masters.business.MasDepartment dU) {
		this.dU = dU;
	}

	/**
	 * Return the value associated with the column: countryId
	 */
	public jkt.hms.masters.business.MasCountry getCountry() {
		return country;
	}

	/**
	 * Set the value related to the column: countryId
	 * 
	 * @param country
	 *            the countryId value
	 */
	public void setCountry(jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}

	/**
	 * Return the value associated with the column: stateId
	 */
	public jkt.hms.masters.business.MasState getState() {
		return state;
	}

	/**
	 * Set the value related to the column: stateId
	 * 
	 * @param state
	 *            the stateId value
	 */
	public void setState(jkt.hms.masters.business.MasState state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: cityId
	 */
	public jkt.hms.masters.business.MasDistrict getCity() {
		return city;
	}

	/**
	 * Set the value related to the column: cityId
	 * 
	 * @param city
	 *            the cityId value
	 */
	public void setCity(jkt.hms.masters.business.MasDistrict city) {
		this.city = city;
	}

	/**
	 * Return the value associated with the column: resource_requisition_id
	 */
	public jkt.hrms.recruitment.masters.business.ResourceRequisition getResourceRequisition() {
		return resourceRequisition;
	}

	/**
	 * Set the value related to the column: resource_requisition_id
	 * 
	 * @param resourceRequisition
	 *            the resource_requisition_id value
	 */
	public void setResourceRequisition(
			jkt.hrms.recruitment.masters.business.ResourceRequisition resourceRequisition) {
		this.resourceRequisition = resourceRequisition;
	}

	/**
	 * Return the value associated with the column: ResumeSkill
	 */
	public java.util.Set<jkt.hrms.recruitment.masters.business.Resumeskill> getResumeSkill() {
		return resumeSkill;
	}

	/**
	 * Set the value related to the column: ResumeSkill
	 * 
	 * @param resumeSkill
	 *            the ResumeSkill value
	 */
	public void setResumeSkill(
			java.util.Set<jkt.hrms.recruitment.masters.business.Resumeskill> resumeSkill) {
		this.resumeSkill = resumeSkill;
	}

	public void addToResumeSkill(
			jkt.hrms.recruitment.masters.business.Resumeskill resumeskill) {
		if (null == getResumeSkill()) {
			setResumeSkill(new java.util.TreeSet<jkt.hrms.recruitment.masters.business.Resumeskill>());
		}
		getResumeSkill().add(resumeskill);
	}

	/**
	 * Return the value associated with the column: ResumeRemarks
	 */
	public java.util.Set<jkt.hrms.recruitment.masters.business.Resumeremarks> getResumeRemarks() {
		return resumeRemarks;
	}

	/**
	 * Set the value related to the column: ResumeRemarks
	 * 
	 * @param resumeRemarks
	 *            the ResumeRemarks value
	 */
	public void setResumeRemarks(
			java.util.Set<jkt.hrms.recruitment.masters.business.Resumeremarks> resumeRemarks) {
		this.resumeRemarks = resumeRemarks;
	}

	public void addToResumeRemarks(
			jkt.hrms.recruitment.masters.business.Resumeremarks resumeremarks) {
		if (null == getResumeRemarks()) {
			setResumeRemarks(new java.util.TreeSet<jkt.hrms.recruitment.masters.business.Resumeremarks>());
		}
		getResumeRemarks().add(resumeremarks);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumepersonaldetails)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumepersonaldetails resumepersonaldetails = (jkt.hrms.recruitment.masters.business.Resumepersonaldetails) obj;
			if (null == this.getId() || null == resumepersonaldetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumepersonaldetails.getId()));
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