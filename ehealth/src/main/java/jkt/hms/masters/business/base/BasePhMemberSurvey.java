package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_member_survey table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_member_survey"
 */

public abstract class BasePhMemberSurvey  implements Serializable {
	public static String REF = "PhMemberSurvey";
	public static String PROP_STREET_NAME = "StreetName";
	public static String PROP_SOURCE_COUNTRY = "SourceCountry";
	public static String PROP_MAJOR_HEALTH_ISSUE = "MajorHealthIssue";
	public static String PROP_INCOME = "Income";
	public static String PROP_ENTRY_FLAG = "EntryFlag";
	public static String PROP_AADHAAR_ADDRESS_FLAG = "AadhaarAddressFlag";
	public static String PROP_ALCOHOL_USE = "AlcoholUse";
	public static String PROP_GENDER = "Gender";
	public static String PROP_DEATH_STATUS = "DeathStatus";
	public static String PROP_OTHER_MEMBER_STATUS = "OtherMemberStatus";
	public static String PROP_RATION_CARD_FLAG = "RationCardFlag";
	public static String PROP_NAME = "Name";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_EDUCATION = "Education";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_YEAR_OF_BIRTH = "YearOfBirth";
	public static String PROP_MEMBER_SURVEY_DATE = "MemberSurveyDate";
	public static String PROP_RSBY_FLAG = "RsbyFlag";
	public static String PROP_UHID_NO = "UhidNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_AADHAAR_ADDRESS = "AadhaarAddress";
	public static String PROP_AADHAAR_DISTRICT = "AadhaarDistrict";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_HOF_STATUS = "HofStatus";
	public static String PROP_SOURCE_STATE = "SourceState";
	public static String PROP_HOUSE_NAME = "HouseName";
	public static String PROP_RSBY_NO = "RsbyNo";
	public static String PROP_DRIVING_LICENSE_NO = "DrivingLicenseNo";
	public static String PROP_HOUSE = "House";
	public static String PROP_TOBACCO_TYPE = "TobaccoType";
	public static String PROP_MARITAL_STATUS = "MaritalStatus";
	public static String PROP_DIET = "Diet";
	public static String PROP_RELATIONSHIP_NAME = "RelationshipName";
	public static String PROP_ID = "Id";
	public static String PROP_AADHAAR_STATE = "AadhaarState";
	public static String PROP_NOTIONAL_DOB = "NotionalDob";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_CONT_NO_CONTRACTOR = "ContNoContractor";
	public static String PROP_NATIVITY = "Nativity";
	public static String PROP_EXP_PERIOD_STAY = "ExpPeriodStay";
	public static String PROP_OTHER_MEMBER_DATE = "OtherMemberDate";
	public static String PROP_MEMBER_SURVEY_BY = "MemberSurveyBy";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_SOURCE_DISTRICT = "SourceDistrict";
	public static String PROP_VOTER_CARD_NO = "VoterCardNo";
	public static String PROP_INSURANCE_STATUS = "InsuranceStatus";
	public static String PROP_TRANSFER_STATUS = "TransferStatus";
	public static String PROP_TOBACCO_USE = "TobaccoUse";
	public static String PROP_PERSON_NAME = "PersonName";
	public static String PROP_SOCIAL_CATEGORY = "SocialCategory";
	public static String PROP_TYPE_OF_DISABILITY = "TypeOfDisability";
	public static String PROP_RELIGION = "Religion";
	public static String PROP_RATION_CARD_NO = "RationCardNo";
	public static String PROP_RESIDENTIAL_STATUS = "ResidentialStatus";
	public static String PROP_WORK_NATURE = "WorkNature";
	public static String PROP_AADHAAR_NO = "AadhaarNo";
	public static String PROP_OCCUPATION = "Occupation";
	public static String PROP_IMMUNIZATION_STATUS = "ImmunizationStatus";
	public static String PROP_FAMILY_ID = "FamilyId";
	public static String PROP_PASSPORT_NO = "PassportNo";
	public static String PROP_MEMBER_STATUS = "MemberStatus";




	// constructors
	public BasePhMemberSurvey () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhMemberSurvey (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhMemberSurvey (
		java.lang.Integer id,
		java.lang.Long memberId) {

		this.setId(id);
		this.setMemberId(memberId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long memberId;
	private java.lang.Integer familyId;
	private java.lang.String name;
	private java.util.Date dateOfBirth;
	private java.lang.String education;
	private java.math.BigDecimal income;
	private java.lang.String houseName;
	private java.lang.String streetName;
	private java.lang.String yearOfBirth;
	private java.lang.String typeOfDisability;
	private java.lang.String majorHealthIssue;
	private java.lang.String immunizationStatus;
	private java.lang.String tobaccoUse;
	private java.lang.String tobaccoType;
	private java.lang.String alcoholUse;
	private java.lang.String diet;
	private java.lang.String contactNo;
	private java.lang.String drivingLicenseNo;
	private java.lang.String nativity;
	private java.lang.String residentialStatus;
	private java.lang.String expPeriodStay;
	private java.lang.String contNoContractor;
	private java.lang.String workNature;
	private java.lang.String voterCardNo;
	private java.lang.Long aadhaarNo;
	private java.lang.String passportNo;
	private java.util.Date memberSurveyDate;
	private java.lang.String remarks;
	private java.lang.String relationshipName;
	private java.lang.String personName;
	private java.lang.String category;
	private java.lang.String otherMemberStatus;
	private java.util.Date otherMemberDate;
	private java.lang.String aadhaarAddress;
	private java.lang.String aadhaarAddressFlag;
	private java.lang.String bloodGroup;
	private java.lang.String insuranceStatus;
	private java.lang.String hofStatus;
	private java.lang.String rsbyNo;
	private java.lang.String rsbyFlag;
	private java.lang.String rationCardNo;
	private java.lang.String rationCardFlag;
	private java.lang.String entryFlag;
	private java.util.Date notionalDob;
	private java.lang.String memberStatus;
	private java.lang.String deathStatus;
	private java.lang.String transferStatus;
	private java.lang.String uhidNo;

	// many to one
	private jkt.hms.masters.business.MasReligion religion;
	private jkt.hms.masters.business.MasOccupation occupation;
	private jkt.hms.masters.business.MasCategory socialCategory;
	private jkt.hms.masters.business.MasState aadhaarState;
	private jkt.hms.masters.business.MasDistrict sourceDistrict;
	private jkt.hms.masters.business.MasCountry sourceCountry;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDistrict aadhaarDistrict;
	private jkt.hms.masters.business.Users memberSurveyBy;
	private jkt.hms.masters.business.MasAdministrativeSex gender;
	private jkt.hms.masters.business.MasMaritalStatus maritalStatus;
	private jkt.hms.masters.business.PhHouseSurvey house;
	private jkt.hms.masters.business.MasState sourceState;

	// collections
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.PhMembersRelationship> phMembersRelationshipsByMember1;
	private java.util.Set<jkt.hms.masters.business.PhMembersRelationship> phMembersRelationshipsByMember2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="survey_id"
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
	 * Return the value associated with the column: member_id
	 */
	public java.lang.Long getMemberId () {
		return memberId;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param memberId the member_id value
	 */
	public void setMemberId (java.lang.Long memberId) {
		this.memberId = memberId;
	}



	/**
	 * Return the value associated with the column: family_id
	 */
	public java.lang.Integer getFamilyId () {
		return familyId;
	}

	/**
	 * Set the value related to the column: family_id
	 * @param familyId the family_id value
	 */
	public void setFamilyId (java.lang.Integer familyId) {
		this.familyId = familyId;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
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
	 * Return the value associated with the column: education
	 */
	public java.lang.String getEducation () {
		return education;
	}

	/**
	 * Set the value related to the column: education
	 * @param education the education value
	 */
	public void setEducation (java.lang.String education) {
		this.education = education;
	}



	/**
	 * Return the value associated with the column: income
	 */
	public java.math.BigDecimal getIncome () {
		return income;
	}

	/**
	 * Set the value related to the column: income
	 * @param income the income value
	 */
	public void setIncome (java.math.BigDecimal income) {
		this.income = income;
	}



	/**
	 * Return the value associated with the column: house_name
	 */
	public java.lang.String getHouseName () {
		return houseName;
	}

	/**
	 * Set the value related to the column: house_name
	 * @param houseName the house_name value
	 */
	public void setHouseName (java.lang.String houseName) {
		this.houseName = houseName;
	}



	/**
	 * Return the value associated with the column: street_name
	 */
	public java.lang.String getStreetName () {
		return streetName;
	}

	/**
	 * Set the value related to the column: street_name
	 * @param streetName the street_name value
	 */
	public void setStreetName (java.lang.String streetName) {
		this.streetName = streetName;
	}



	/**
	 * Return the value associated with the column: year_of_birth
	 */
	public java.lang.String getYearOfBirth () {
		return yearOfBirth;
	}

	/**
	 * Set the value related to the column: year_of_birth
	 * @param yearOfBirth the year_of_birth value
	 */
	public void setYearOfBirth (java.lang.String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}



	/**
	 * Return the value associated with the column: type_of_disability
	 */
	public java.lang.String getTypeOfDisability () {
		return typeOfDisability;
	}

	/**
	 * Set the value related to the column: type_of_disability
	 * @param typeOfDisability the type_of_disability value
	 */
	public void setTypeOfDisability (java.lang.String typeOfDisability) {
		this.typeOfDisability = typeOfDisability;
	}



	/**
	 * Return the value associated with the column: major_health_issue
	 */
	public java.lang.String getMajorHealthIssue () {
		return majorHealthIssue;
	}

	/**
	 * Set the value related to the column: major_health_issue
	 * @param majorHealthIssue the major_health_issue value
	 */
	public void setMajorHealthIssue (java.lang.String majorHealthIssue) {
		this.majorHealthIssue = majorHealthIssue;
	}



	/**
	 * Return the value associated with the column: immunization_status
	 */
	public java.lang.String getImmunizationStatus () {
		return immunizationStatus;
	}

	/**
	 * Set the value related to the column: immunization_status
	 * @param immunizationStatus the immunization_status value
	 */
	public void setImmunizationStatus (java.lang.String immunizationStatus) {
		this.immunizationStatus = immunizationStatus;
	}



	/**
	 * Return the value associated with the column: tobacco_use
	 */
	public java.lang.String getTobaccoUse () {
		return tobaccoUse;
	}

	/**
	 * Set the value related to the column: tobacco_use
	 * @param tobaccoUse the tobacco_use value
	 */
	public void setTobaccoUse (java.lang.String tobaccoUse) {
		this.tobaccoUse = tobaccoUse;
	}



	/**
	 * Return the value associated with the column: tobacco_type
	 */
	public java.lang.String getTobaccoType () {
		return tobaccoType;
	}

	/**
	 * Set the value related to the column: tobacco_type
	 * @param tobaccoType the tobacco_type value
	 */
	public void setTobaccoType (java.lang.String tobaccoType) {
		this.tobaccoType = tobaccoType;
	}



	/**
	 * Return the value associated with the column: alcohol_use
	 */
	public java.lang.String getAlcoholUse () {
		return alcoholUse;
	}

	/**
	 * Set the value related to the column: alcohol_use
	 * @param alcoholUse the alcohol_use value
	 */
	public void setAlcoholUse (java.lang.String alcoholUse) {
		this.alcoholUse = alcoholUse;
	}



	/**
	 * Return the value associated with the column: diet
	 */
	public java.lang.String getDiet () {
		return diet;
	}

	/**
	 * Set the value related to the column: diet
	 * @param diet the diet value
	 */
	public void setDiet (java.lang.String diet) {
		this.diet = diet;
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
	 * Return the value associated with the column: driving_license_no
	 */
	public java.lang.String getDrivingLicenseNo () {
		return drivingLicenseNo;
	}

	/**
	 * Set the value related to the column: driving_license_no
	 * @param drivingLicenseNo the driving_license_no value
	 */
	public void setDrivingLicenseNo (java.lang.String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}



	/**
	 * Return the value associated with the column: nativity
	 */
	public java.lang.String getNativity () {
		return nativity;
	}

	/**
	 * Set the value related to the column: nativity
	 * @param nativity the nativity value
	 */
	public void setNativity (java.lang.String nativity) {
		this.nativity = nativity;
	}



	/**
	 * Return the value associated with the column: residential_status
	 */
	public java.lang.String getResidentialStatus () {
		return residentialStatus;
	}

	/**
	 * Set the value related to the column: residential_status
	 * @param residentialStatus the residential_status value
	 */
	public void setResidentialStatus (java.lang.String residentialStatus) {
		this.residentialStatus = residentialStatus;
	}



	/**
	 * Return the value associated with the column: exp_period_stay
	 */
	public java.lang.String getExpPeriodStay () {
		return expPeriodStay;
	}

	/**
	 * Set the value related to the column: exp_period_stay
	 * @param expPeriodStay the exp_period_stay value
	 */
	public void setExpPeriodStay (java.lang.String expPeriodStay) {
		this.expPeriodStay = expPeriodStay;
	}



	/**
	 * Return the value associated with the column: cont_no_contractor
	 */
	public java.lang.String getContNoContractor () {
		return contNoContractor;
	}

	/**
	 * Set the value related to the column: cont_no_contractor
	 * @param contNoContractor the cont_no_contractor value
	 */
	public void setContNoContractor (java.lang.String contNoContractor) {
		this.contNoContractor = contNoContractor;
	}



	/**
	 * Return the value associated with the column: work_nature
	 */
	public java.lang.String getWorkNature () {
		return workNature;
	}

	/**
	 * Set the value related to the column: work_nature
	 * @param workNature the work_nature value
	 */
	public void setWorkNature (java.lang.String workNature) {
		this.workNature = workNature;
	}



	/**
	 * Return the value associated with the column: voter_card_no
	 */
	public java.lang.String getVoterCardNo () {
		return voterCardNo;
	}

	/**
	 * Set the value related to the column: voter_card_no
	 * @param voterCardNo the voter_card_no value
	 */
	public void setVoterCardNo (java.lang.String voterCardNo) {
		this.voterCardNo = voterCardNo;
	}



	/**
	 * Return the value associated with the column: aadhaar_no
	 */
	public java.lang.Long getAadhaarNo () {
		return aadhaarNo;
	}

	/**
	 * Set the value related to the column: aadhaar_no
	 * @param aadhaarNo the aadhaar_no value
	 */
	public void setAadhaarNo (java.lang.Long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}



	/**
	 * Return the value associated with the column: passport_no
	 */
	public java.lang.String getPassportNo () {
		return passportNo;
	}

	/**
	 * Set the value related to the column: passport_no
	 * @param passportNo the passport_no value
	 */
	public void setPassportNo (java.lang.String passportNo) {
		this.passportNo = passportNo;
	}



	/**
	 * Return the value associated with the column: member_survey_date
	 */
	public java.util.Date getMemberSurveyDate () {
		return memberSurveyDate;
	}

	/**
	 * Set the value related to the column: member_survey_date
	 * @param memberSurveyDate the member_survey_date value
	 */
	public void setMemberSurveyDate (java.util.Date memberSurveyDate) {
		this.memberSurveyDate = memberSurveyDate;
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
	 * Return the value associated with the column: relationship_name
	 */
	public java.lang.String getRelationshipName () {
		return relationshipName;
	}

	/**
	 * Set the value related to the column: relationship_name
	 * @param relationshipName the relationship_name value
	 */
	public void setRelationshipName (java.lang.String relationshipName) {
		this.relationshipName = relationshipName;
	}



	/**
	 * Return the value associated with the column: person_name
	 */
	public java.lang.String getPersonName () {
		return personName;
	}

	/**
	 * Set the value related to the column: person_name
	 * @param personName the person_name value
	 */
	public void setPersonName (java.lang.String personName) {
		this.personName = personName;
	}



	/**
	 * Return the value associated with the column: category
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: other_member_status
	 */
	public java.lang.String getOtherMemberStatus () {
		return otherMemberStatus;
	}

	/**
	 * Set the value related to the column: other_member_status
	 * @param otherMemberStatus the other_member_status value
	 */
	public void setOtherMemberStatus (java.lang.String otherMemberStatus) {
		this.otherMemberStatus = otherMemberStatus;
	}



	/**
	 * Return the value associated with the column: other_member_date
	 */
	public java.util.Date getOtherMemberDate () {
		return otherMemberDate;
	}

	/**
	 * Set the value related to the column: other_member_date
	 * @param otherMemberDate the other_member_date value
	 */
	public void setOtherMemberDate (java.util.Date otherMemberDate) {
		this.otherMemberDate = otherMemberDate;
	}



	/**
	 * Return the value associated with the column: aadhaar_address
	 */
	public java.lang.String getAadhaarAddress () {
		return aadhaarAddress;
	}

	/**
	 * Set the value related to the column: aadhaar_address
	 * @param aadhaarAddress the aadhaar_address value
	 */
	public void setAadhaarAddress (java.lang.String aadhaarAddress) {
		this.aadhaarAddress = aadhaarAddress;
	}



	/**
	 * Return the value associated with the column: aadhaar_address_flag
	 */
	public java.lang.String getAadhaarAddressFlag () {
		return aadhaarAddressFlag;
	}

	/**
	 * Set the value related to the column: aadhaar_address_flag
	 * @param aadhaarAddressFlag the aadhaar_address_flag value
	 */
	public void setAadhaarAddressFlag (java.lang.String aadhaarAddressFlag) {
		this.aadhaarAddressFlag = aadhaarAddressFlag;
	}



	/**
	 * Return the value associated with the column: blood_group
	 */
	public java.lang.String getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group
	 * @param bloodGroup the blood_group value
	 */
	public void setBloodGroup (java.lang.String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: insurance_status
	 */
	public java.lang.String getInsuranceStatus () {
		return insuranceStatus;
	}

	/**
	 * Set the value related to the column: insurance_status
	 * @param insuranceStatus the insurance_status value
	 */
	public void setInsuranceStatus (java.lang.String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}



	/**
	 * Return the value associated with the column: hof_status
	 */
	public java.lang.String getHofStatus () {
		return hofStatus;
	}

	/**
	 * Set the value related to the column: hof_status
	 * @param hofStatus the hof_status value
	 */
	public void setHofStatus (java.lang.String hofStatus) {
		this.hofStatus = hofStatus;
	}



	/**
	 * Return the value associated with the column: rsby_no
	 */
	public java.lang.String getRsbyNo () {
		return rsbyNo;
	}

	/**
	 * Set the value related to the column: rsby_no
	 * @param rsbyNo the rsby_no value
	 */
	public void setRsbyNo (java.lang.String rsbyNo) {
		this.rsbyNo = rsbyNo;
	}



	/**
	 * Return the value associated with the column: rsby_flag
	 */
	public java.lang.String getRsbyFlag () {
		return rsbyFlag;
	}

	/**
	 * Set the value related to the column: rsby_flag
	 * @param rsbyFlag the rsby_flag value
	 */
	public void setRsbyFlag (java.lang.String rsbyFlag) {
		this.rsbyFlag = rsbyFlag;
	}



	/**
	 * Return the value associated with the column: ration_card_no
	 */
	public java.lang.String getRationCardNo () {
		return rationCardNo;
	}

	/**
	 * Set the value related to the column: ration_card_no
	 * @param rationCardNo the ration_card_no value
	 */
	public void setRationCardNo (java.lang.String rationCardNo) {
		this.rationCardNo = rationCardNo;
	}



	/**
	 * Return the value associated with the column: ration_card_flag
	 */
	public java.lang.String getRationCardFlag () {
		return rationCardFlag;
	}

	/**
	 * Set the value related to the column: ration_card_flag
	 * @param rationCardFlag the ration_card_flag value
	 */
	public void setRationCardFlag (java.lang.String rationCardFlag) {
		this.rationCardFlag = rationCardFlag;
	}



	/**
	 * Return the value associated with the column: entry_flag
	 */
	public java.lang.String getEntryFlag () {
		return entryFlag;
	}

	/**
	 * Set the value related to the column: entry_flag
	 * @param entryFlag the entry_flag value
	 */
	public void setEntryFlag (java.lang.String entryFlag) {
		this.entryFlag = entryFlag;
	}



	/**
	 * Return the value associated with the column: notional_dob
	 */
	public java.util.Date getNotionalDob () {
		return notionalDob;
	}

	/**
	 * Set the value related to the column: notional_dob
	 * @param notionalDob the notional_dob value
	 */
	public void setNotionalDob (java.util.Date notionalDob) {
		this.notionalDob = notionalDob;
	}



	/**
	 * Return the value associated with the column: member_status
	 */
	public java.lang.String getMemberStatus () {
		return memberStatus;
	}

	/**
	 * Set the value related to the column: member_status
	 * @param memberStatus the member_status value
	 */
	public void setMemberStatus (java.lang.String memberStatus) {
		this.memberStatus = memberStatus;
	}



	/**
	 * Return the value associated with the column: death_status
	 */
	public java.lang.String getDeathStatus () {
		return deathStatus;
	}

	/**
	 * Set the value related to the column: death_status
	 * @param deathStatus the death_status value
	 */
	public void setDeathStatus (java.lang.String deathStatus) {
		this.deathStatus = deathStatus;
	}



	/**
	 * Return the value associated with the column: transfer_status
	 */
	public java.lang.String getTransferStatus () {
		return transferStatus;
	}

	/**
	 * Set the value related to the column: transfer_status
	 * @param transferStatus the transfer_status value
	 */
	public void setTransferStatus (java.lang.String transferStatus) {
		this.transferStatus = transferStatus;
	}



	/**
	 * Return the value associated with the column: UHID_NO
	 */
	public java.lang.String getUhidNo () {
		return uhidNo;
	}

	/**
	 * Set the value related to the column: UHID_NO
	 * @param uhidNo the UHID_NO value
	 */
	public void setUhidNo (java.lang.String uhidNo) {
		this.uhidNo = uhidNo;
	}



	/**
	 * Return the value associated with the column: religion
	 */
	public jkt.hms.masters.business.MasReligion getReligion () {
		return religion;
	}

	/**
	 * Set the value related to the column: religion
	 * @param religion the religion value
	 */
	public void setReligion (jkt.hms.masters.business.MasReligion religion) {
		this.religion = religion;
	}



	/**
	 * Return the value associated with the column: occupation
	 */
	public jkt.hms.masters.business.MasOccupation getOccupation () {
		return occupation;
	}

	/**
	 * Set the value related to the column: occupation
	 * @param occupation the occupation value
	 */
	public void setOccupation (jkt.hms.masters.business.MasOccupation occupation) {
		this.occupation = occupation;
	}



	/**
	 * Return the value associated with the column: social_category
	 */
	public jkt.hms.masters.business.MasCategory getSocialCategory () {
		return socialCategory;
	}

	/**
	 * Set the value related to the column: social_category
	 * @param socialCategory the social_category value
	 */
	public void setSocialCategory (jkt.hms.masters.business.MasCategory socialCategory) {
		this.socialCategory = socialCategory;
	}



	/**
	 * Return the value associated with the column: aadhaar_state
	 */
	public jkt.hms.masters.business.MasState getAadhaarState () {
		return aadhaarState;
	}

	/**
	 * Set the value related to the column: aadhaar_state
	 * @param aadhaarState the aadhaar_state value
	 */
	public void setAadhaarState (jkt.hms.masters.business.MasState aadhaarState) {
		this.aadhaarState = aadhaarState;
	}



	/**
	 * Return the value associated with the column: source_district
	 */
	public jkt.hms.masters.business.MasDistrict getSourceDistrict () {
		return sourceDistrict;
	}

	/**
	 * Set the value related to the column: source_district
	 * @param sourceDistrict the source_district value
	 */
	public void setSourceDistrict (jkt.hms.masters.business.MasDistrict sourceDistrict) {
		this.sourceDistrict = sourceDistrict;
	}



	/**
	 * Return the value associated with the column: source_country
	 */
	public jkt.hms.masters.business.MasCountry getSourceCountry () {
		return sourceCountry;
	}

	/**
	 * Set the value related to the column: source_country
	 * @param sourceCountry the source_country value
	 */
	public void setSourceCountry (jkt.hms.masters.business.MasCountry sourceCountry) {
		this.sourceCountry = sourceCountry;
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
	 * Return the value associated with the column: aadhaar_district
	 */
	public jkt.hms.masters.business.MasDistrict getAadhaarDistrict () {
		return aadhaarDistrict;
	}

	/**
	 * Set the value related to the column: aadhaar_district
	 * @param aadhaarDistrict the aadhaar_district value
	 */
	public void setAadhaarDistrict (jkt.hms.masters.business.MasDistrict aadhaarDistrict) {
		this.aadhaarDistrict = aadhaarDistrict;
	}



	/**
	 * Return the value associated with the column: member_survey_by
	 */
	public jkt.hms.masters.business.Users getMemberSurveyBy () {
		return memberSurveyBy;
	}

	/**
	 * Set the value related to the column: member_survey_by
	 * @param memberSurveyBy the member_survey_by value
	 */
	public void setMemberSurveyBy (jkt.hms.masters.business.Users memberSurveyBy) {
		this.memberSurveyBy = memberSurveyBy;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: marital_status
	 */
	public jkt.hms.masters.business.MasMaritalStatus getMaritalStatus () {
		return maritalStatus;
	}

	/**
	 * Set the value related to the column: marital_status
	 * @param maritalStatus the marital_status value
	 */
	public void setMaritalStatus (jkt.hms.masters.business.MasMaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	/**
	 * Return the value associated with the column: house_id
	 */
	public jkt.hms.masters.business.PhHouseSurvey getHouse () {
		return house;
	}

	/**
	 * Set the value related to the column: house_id
	 * @param house the house_id value
	 */
	public void setHouse (jkt.hms.masters.business.PhHouseSurvey house) {
		this.house = house;
	}



	/**
	 * Return the value associated with the column: source_state
	 */
	public jkt.hms.masters.business.MasState getSourceState () {
		return sourceState;
	}

	/**
	 * Set the value related to the column: source_state
	 * @param sourceState the source_state value
	 */
	public void setSourceState (jkt.hms.masters.business.MasState sourceState) {
		this.sourceState = sourceState;
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
	 * Return the value associated with the column: PhMembersRelationshipsByMember1
	 */
	public java.util.Set<jkt.hms.masters.business.PhMembersRelationship> getPhMembersRelationshipsByMember1 () {
		return phMembersRelationshipsByMember1;
	}

	/**
	 * Set the value related to the column: PhMembersRelationshipsByMember1
	 * @param phMembersRelationshipsByMember1 the PhMembersRelationshipsByMember1 value
	 */
	public void setPhMembersRelationshipsByMember1 (java.util.Set<jkt.hms.masters.business.PhMembersRelationship> phMembersRelationshipsByMember1) {
		this.phMembersRelationshipsByMember1 = phMembersRelationshipsByMember1;
	}

	public void addToPhMembersRelationshipsByMember1 (jkt.hms.masters.business.PhMembersRelationship phMembersRelationship) {
		if (null == getPhMembersRelationshipsByMember1()) setPhMembersRelationshipsByMember1(new java.util.TreeSet<jkt.hms.masters.business.PhMembersRelationship>());
		getPhMembersRelationshipsByMember1().add(phMembersRelationship);
	}



	/**
	 * Return the value associated with the column: PhMembersRelationshipsByMember2
	 */
	public java.util.Set<jkt.hms.masters.business.PhMembersRelationship> getPhMembersRelationshipsByMember2 () {
		return phMembersRelationshipsByMember2;
	}

	/**
	 * Set the value related to the column: PhMembersRelationshipsByMember2
	 * @param phMembersRelationshipsByMember2 the PhMembersRelationshipsByMember2 value
	 */
	public void setPhMembersRelationshipsByMember2 (java.util.Set<jkt.hms.masters.business.PhMembersRelationship> phMembersRelationshipsByMember2) {
		this.phMembersRelationshipsByMember2 = phMembersRelationshipsByMember2;
	}

	public void addToPhMembersRelationshipsByMember2 (jkt.hms.masters.business.PhMembersRelationship phMembersRelationship) {
		if (null == getPhMembersRelationshipsByMember2()) setPhMembersRelationshipsByMember2(new java.util.TreeSet<jkt.hms.masters.business.PhMembersRelationship>());
		getPhMembersRelationshipsByMember2().add(phMembersRelationship);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhMemberSurvey)) return false;
		else {
			jkt.hms.masters.business.PhMemberSurvey phMemberSurvey = (jkt.hms.masters.business.PhMemberSurvey) obj;
			if (null == this.getId() || null == phMemberSurvey.getId()) return false;
			else return (this.getId().equals(phMemberSurvey.getId()));
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