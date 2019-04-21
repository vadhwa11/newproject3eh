package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumepersonaldetails
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumepersonaldetails"
 */

public abstract class BaseHrResumepersonaldetails implements Serializable {

	public static String REF = "HrResumepersonaldetails";
	public static String PROP_ADD_BY = "AddBy";
	public static String PROP_CITY_ID = "CityId";
	public static String PROP_OWNERSHIP_CHANGED_ON = "OwnershipChangedOn";
	public static String PROP_UPDATED_ON = "UpdatedOn";
	public static String PROP_DU_ID = "DuId";
	public static String PROP_NAME_OF_SOURCE = "NameOfSource";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_PASSPORT_STATUS = "PassportStatus";
	public static String PROP_OTHER_PHONE = "OtherPhone";
	public static String PROP_EXPERIENCE_YEAR = "ExperienceYear";
	public static String PROP_ADD_ON = "AddOn";
	public static String PROP_DOMAIN_KNOWLEDGE = "DomainKnowledge";
	public static String PROP_STATE_ID = "StateId";
	public static String PROP_MOBILE = "Mobile";
	public static String PROP_VISA_REMARKS = "VisaRemarks";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_RESIDENCE_PHONE = "ResidencePhone";
	public static String PROP_RESOURCE_REQUISITION_ID = "ResourceRequisitionId";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_CURRENT_CTC = "CurrentCtc";
	public static String PROP_CURRENT_DESIGNATION = "CurrentDesignation";
	public static String PROP_OTHER_CITY = "OtherCity";
	public static String PROP_EXPERIENCE_MONTH = "ExperienceMonth";
	public static String PROP_JOB_PROFILE = "JobProfile";
	public static String PROP_REFERENCE_BY = "ReferenceBy";
	public static String PROP_ASSIGNED_TO = "AssignedTo";
	public static String PROP_EXPECTED_CTC = "ExpectedCtc";
	public static String PROP_PASSPORT_EXPIRYDATE = "PassportExpirydate";
	public static String PROP_INSTITUTION = "Institution";
	public static String PROP_TITLE = "Title";
	public static String PROP_PREVIOUS_EMPLOYER = "PreviousEmployer";
	public static String PROP_JOINING_PERIOD = "JoiningPeriod";
	public static String PROP_ACTIVE = "Active";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_YEARPASSING = "Yearpassing";
	public static String PROP_EDUCATION = "Education";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ON_SITE_AVAILABILITY = "OnSiteAvailability";
	public static String PROP_COUNTRY_ID = "CountryId";
	public static String PROP_RESUME_THROUGH = "ResumeThrough";
	public static String PROP_ID = "Id";
	public static String PROP_PASSPORT_NO = "PassportNo";
	public static String PROP_PROJECT_ID = "ProjectId";
	public static String PROP_CURRENT_EMPLOYER = "CurrentEmployer";
	public static String PROP_SALARY_REMARKS = "SalaryRemarks";

	// constructors
	public BaseHrResumepersonaldetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrResumepersonaldetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrResumepersonaldetails(java.lang.Integer id,
			jkt.hms.masters.business.MasTitle title,
			boolean onSiteAvailability, boolean active) {

		this.setId(id);
		this.setTitle(title);
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
	private java.lang.String lastName;
	private java.lang.String middleName;
	private java.lang.String dateOfBirth;
	private java.lang.String emailId;
	private java.lang.String mobile;
	private java.lang.String residencePhone;
	private java.lang.String otherPhone;
	private java.lang.Integer countryId;
	private java.lang.Integer stateId;
	private java.lang.Integer cityId;
	private java.lang.String passportStatus;
	private java.lang.String passportNo;
	private java.lang.String passportExpirydate;
	private java.lang.String visaRemarks;
	private java.lang.String education;
	private java.lang.Integer yearpassing;
	private java.lang.String institution;
	private java.lang.Integer experienceYear;
	private java.lang.Integer experienceMonth;
	private java.lang.String currentEmployer;
	private java.lang.String previousEmployer;
	private java.lang.String domainKnowledge;
	private java.lang.Integer jobProfile;
	private java.lang.String currentCtc;
	private java.lang.String expectedCtc;
	private java.lang.String salaryRemarks;
	private java.lang.Integer duId;
	private java.lang.Integer projectId;
	private java.lang.Integer joiningPeriod;
	private java.lang.String resumeThrough;
	private java.lang.String currentDesignation;
	private boolean onSiteAvailability;
	private java.lang.Integer addBy;
	private java.lang.Integer assignedTo;
	private java.util.Date addOn;
	private java.util.Date ownershipChangedOn;
	private java.util.Date updatedOn;
	private boolean active;
	private java.lang.String nameOfSource;
	private java.lang.String referenceBy;
	private java.lang.String otherCity;
	private java.lang.Integer resourceRequisitionId;
	private java.lang.String address;

	// many to one
	private jkt.hms.masters.business.MasTitle title;

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
	public java.lang.String getPassportExpirydate() {
		return passportExpirydate;
	}

	/**
	 * Set the value related to the column: passport_expirydate
	 * 
	 * @param passportExpirydate
	 *            the passport_expirydate value
	 */
	public void setPassportExpirydate(java.lang.String passportExpirydate) {
		this.passportExpirydate = passportExpirydate;
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
	public java.lang.Integer getJobProfile() {
		return jobProfile;
	}

	/**
	 * Set the value related to the column: job_profile
	 * 
	 * @param jobProfile
	 *            the job_profile value
	 */
	public void setJobProfile(java.lang.Integer jobProfile) {
		this.jobProfile = jobProfile;
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
	public java.lang.Integer getDuId() {
		return duId;
	}

	/**
	 * Set the value related to the column: du_id
	 * 
	 * @param duId
	 *            the du_id value
	 */
	public void setDuId(java.lang.Integer duId) {
		this.duId = duId;
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
	public java.util.Date getOwnershipChangedOn() {
		return ownershipChangedOn;
	}

	/**
	 * Set the value related to the column: Ownership_Changed_On
	 * 
	 * @param ownershipChangedOn
	 *            the Ownership_Changed_On value
	 */
	public void setOwnershipChangedOn(java.util.Date ownershipChangedOn) {
		this.ownershipChangedOn = ownershipChangedOn;
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
	 * Return the value associated with the column: reference_by
	 */
	public java.lang.String getReferenceBy() {
		return referenceBy;
	}

	/**
	 * Set the value related to the column: reference_by
	 * 
	 * @param referenceBy
	 *            the reference_by value
	 */
	public void setReferenceBy(java.lang.String referenceBy) {
		this.referenceBy = referenceBy;
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
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * 
	 * @param address
	 *            the address value
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
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

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.HrResumepersonaldetails)) {
			return false;
		} else {
			jkt.hms.masters.business.HrResumepersonaldetails hrResumepersonaldetails = (jkt.hms.masters.business.HrResumepersonaldetails) obj;
			if (null == this.getId() || null == hrResumepersonaldetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrResumepersonaldetails.getId()));
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