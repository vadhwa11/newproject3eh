package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the online_patient_portal table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="online_patient_portal"
 */

public abstract class BaseOnlinePatientPortal  implements Serializable {

	public static String REF = "OnlinePatientPortal";
	public static String PROP_NEXT_OF_KIN_ADDRESS = "NextOfKinAddress";
	public static String PROP_NEXT_OF_KIN_NAME = "NextOfKinName";
	public static String PROP_REF_DOCTOR = "RefDoctor";
	public static String PROP_COMPANY_ID = "CompanyId";
	public static String PROP_CDA_ACCOUNT_NO = "CdaAccountNo";
	public static String PROP_NATIONAL_DOB_STATUS = "NationalDobStatus";
	public static String PROP_BLOOD_GROUP_ID = "BloodGroupId";
	public static String PROP_DISTRICT_ID = "DistrictId";
	public static String PROP_TRADE_ID = "TradeId";
	public static String PROP_REGISTRATION_TYPE = "RegistrationType";
	public static String PROP_SOURCETYPE_STATUS = "SourcetypeStatus";
	public static String PROP_MONTHLY_INCOME = "MonthlyIncome";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_OLD_HIN_NO = "OldHinNo";
	public static String PROP_REG_TYPE = "RegType";
	public static String PROP_P_LAST_NAME = "PLastName";
	public static String PROP_PATIENT_TYPE_ID = "PatientTypeId";
	public static String PROP_DOB_OTHER_CARD_ID = "DobOtherCardId";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_P_FIRST_NAME = "PFirstName";
	public static String PROP_NATIVITY_TYPE = "NativityType";
	public static String PROP_ID_NO = "IdNo";
	public static String PROP_ELECTRICITY_POLL_NO = "ElectricityPollNo";
	public static String PROP_PURPOSE = "Purpose";
	public static String PROP_PASSPORT_NO = "PassportNo";
	public static String PROP_INPATIENT_NO = "InpatientNo";
	public static String PROP_EMP_ID = "EmpId";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_REG_TIME = "RegTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_FORMATION = "Formation";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_STATION = "Station";
	public static String PROP_RELATION_ID = "RelationId";
	public static String PROP_TEMP_ADDRESS_ID_PROOF_NUM = "TempAddressIdProofNum";
	public static String PROP_NEXT_OF_KIN_RELATION_ID = "NextOfKinRelationId";
	public static String PROP_YEAR_OF_BIRTH = "YearOfBirth";
	public static String PROP_DEATH_CERTIFICATE_PRINT_STATUS = "DeathCertificatePrintStatus";
	public static String PROP_SERVICE_CARD_VALIDITY_DATE = "ServiceCardValidityDate";
	public static String PROP_S_FIRST_NAME = "SFirstName";
	public static String PROP_EHR_ACCESS_DETAIL = "EhrAccessDetail";
	public static String PROP_FULL_NAME = "FullName";
	public static String PROP_PAST_DUE = "PastDue";
	public static String PROP_S_MIDDLE_NAME = "SMiddleName";
	public static String PROP_TOTAL_SERVICE_PERIOD = "TotalServicePeriod";
	public static String PROP_RELIGION_ID = "ReligionId";
	public static String PROP_CURRENT_VISIT_NO = "CurrentVisitNo";
	public static String PROP_ECHS_NO = "EchsNo";
	public static String PROP_BPL_STATUS = "BplStatus";
	public static String PROP_NEW_BORN_BABY = "NewBornBaby";
	public static String PROP_MARITAL_STATUS_ID = "MaritalStatusId";
	public static String PROP_TEM_ADDRESS_ID_PROOF = "TemAddressIdProof";
	public static String PROP_PATIENT_STATUS = "PatientStatus";
	public static String PROP_PATIENT_CATEGORY = "PatientCategory";
	public static String PROP_SERVICE_YEARS = "ServiceYears";
	public static String PROP_SECONDARY_EMAIL_ID = "SecondaryEmailId";
	public static String PROP_EMP_DEPENDENT_ID = "EmpDependentId";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_OCCUPATION_ID = "OccupationId";
	public static String PROP_CARD_VALID_DATE = "CardValidDate";
	public static String PROP_PATIENT_AGE = "PatientAge";
	public static String PROP_RANK_ID = "RankId";
	public static String PROP_MOTHER_HIN_NO = "MotherHinNo";
	public static String PROP_CASTE = "Caste";
	public static String PROP_S_LAST_NAME = "SLastName";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_NATIVITY = "Nativity";
	public static String PROP_BPL_NUMBER = "BplNumber";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_OTP_NUMBER = "OtpNumber";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_FAMILY_ID = "FamilyId";
	public static String PROP_AADHAAR_NO = "AadhaarNo";
	public static String PROP_SUFFIX = "Suffix";
	public static String PROP_DEPENDENT_CARD_ISSUE_DATE = "DependentCardIssueDate";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_RSBY_CARD_NO = "RsbyCardNo";
	public static String PROP_NATIVE_PLACE_ID = "NativePlaceId";
	public static String PROP_AB64_AVAILABLE = "Ab64Available";
	public static String PROP_MIGRANT = "Migrant";
	public static String PROP_DOB_OTHER_CARD_NUMBER = "DobOtherCardNumber";
	public static String PROP_SERVICE_CARD_STATUS = "ServiceCardStatus";
	public static String PROP_SERVICE_STATUS_ID = "ServiceStatusId";
	public static String PROP_COUNTRY_ID = "CountryId";
	public static String PROP_ID = "Id";
	public static String PROP_RSBY_NO = "RsbyNo";
	public static String PROP_VISA_TYPE = "VisaType";
	public static String PROP_TITLE_ID = "TitleId";
	public static String PROP_SERVICE_TYPE_ID = "ServiceTypeId";
	public static String PROP_AGE = "Age";
	public static String PROP_NEXT_OF_KIN_MOBILE_NUMBER = "NextOfKinMobileNumber";
	public static String PROP_VISA_FROM = "VisaFrom";
	public static String PROP_VISA_TO = "VisaTo";
	public static String PROP_STATE_ID = "StateId";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_MOBILE_NUMBER = "MobileNumber";
	public static String PROP_NEXT_OF_KIN_PHONE_NUMBER = "NextOfKinPhoneNumber";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_NET_AMOUNT = "NetAmount";
	public static String PROP_FATHER_MOTHER_NAME = "FatherMotherName";
	public static String PROP_ID_CARD = "IdCard";
	public static String PROP_SEX_ID = "SexId";
	public static String PROP_SECONDARY_MOBILE_NO = "SecondaryMobileNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_EDUCATION = "Education";
	public static String PROP_INSURANCE_AMT = "InsuranceAmt";
	public static String PROP_RECORD_OFFICE_ADDRESS_ID = "RecordOfficeAddressId";
	public static String PROP_P_MIDDLE_NAME = "PMiddleName";
	public static String PROP_REFERENCE_ID = "ReferenceId";


	// constructors
	public BaseOnlinePatientPortal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOnlinePatientPortal (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOnlinePatientPortal (
		java.lang.Integer id,
		java.lang.String hinNo) {

		this.setId(id);
		this.setHinNo(hinNo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.Integer serviceTypeId;
	private java.lang.Integer relationId;
	private java.lang.String hinNo;
	private java.lang.Integer hospitalId;
	private java.lang.Integer rankId;
	private java.lang.Integer unitId;
	private java.lang.Integer titleId;
	private java.lang.String pFirstName;
	private java.lang.String pMiddleName;
	private java.lang.String pLastName;
	private java.lang.String sFirstName;
	private java.lang.String sMiddleName;
	private java.lang.String sLastName;
	private java.lang.Integer sexId;
	private java.util.Date dateOfBirth;
	private java.lang.Integer maritalStatusId;
	private java.lang.Integer tradeId;
	private java.math.BigDecimal serviceYears;
	private java.lang.Integer religionId;
	private java.lang.String station;
	private java.lang.String formation;
	private java.lang.String ab64Available;
	private java.lang.String cdaAccountNo;
	private java.lang.Integer referenceId;
	private java.lang.Integer bloodGroupId;
	private java.lang.Integer currentVisitNo;
	private java.lang.Integer inpatientNo;
	private java.lang.String emailId;
	private java.lang.Integer recordOfficeAddressId;
	private java.lang.Integer occupationId;
	private java.lang.String phoneNumber;
	private java.lang.String mobileNumber;
	private java.lang.String nextOfKinName;
	private java.lang.String nextOfKinAddress;
	private java.lang.String nextOfKinPhoneNumber;
	private java.lang.String nextOfKinMobileNumber;
	private java.lang.Integer nextOfKinRelationId;
	private java.lang.String remarks;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String patientStatus;
	private java.lang.String status;
	private java.lang.String motherHinNo;
	private java.util.Date serviceCardValidityDate;
	private java.util.Date dependentCardIssueDate;
	private java.lang.String serviceCardStatus;
	private java.util.Date regDate;
	private java.lang.String regTime;
	private java.lang.String suffix;
	private java.lang.Integer serviceStatusId;
	private java.lang.String oldHinNo;
	private java.lang.String age;
	private java.lang.String totalServicePeriod;
	private java.lang.String prefix;
	private java.lang.String echsNo;
	private java.lang.Integer patientTypeId;
	private java.lang.Integer companyId;
	private java.lang.String insuranceAmt;
	private java.lang.String pastDue;
	private java.lang.Integer empId;
	private java.lang.Integer empDependentId;
	private java.lang.Long billNo;
	private java.lang.Integer regType;
	private java.lang.Integer refDoctor;
	private java.lang.Long amount;
	private java.lang.Long discount;
	private java.lang.Long netAmount;
	private java.lang.Integer caste;
	private java.lang.String bplStatus;
	private java.lang.String registrationType;
	private java.util.Date cardValidDate;
	private java.lang.Integer nativePlaceId;
	private java.lang.String newBornBaby;
	private java.lang.Long aadhaarNo;
	private java.lang.Integer idCard;
	private java.lang.String idNo;
	private java.lang.String fullName;
	private java.lang.String yearOfBirth;
	private java.lang.String fatherMotherName;
	private java.lang.String migrant;
	private java.lang.String electricityPollNo;
	private java.lang.String secondaryEmailId;
	private java.lang.String secondaryMobileNo;
	private java.lang.Integer patientCategory;
	private java.lang.String nativityType;
	private java.lang.String nativity;
	private java.lang.Integer countryId;
	private java.lang.Integer stateId;
	private java.lang.Integer districtId;
	private java.lang.String purpose;
	private java.lang.String passportNo;
	private java.lang.Integer visaType;
	private java.util.Date visaFrom;
	private java.util.Date visaTo;
	private java.lang.Integer education;
	private java.lang.Integer familyId;
	private java.lang.Integer memberId;
	private java.lang.String password;
	private java.lang.String nationalDobStatus;
	private java.lang.Long otpNumber;
	private java.lang.Integer temAddressIdProof;
	private java.lang.String tempAddressIdProofNum;
	private java.lang.Integer dobOtherCardId;
	private java.lang.String dobOtherCardNumber;
	private java.math.BigDecimal monthlyIncome;
	private java.lang.String deathCertificatePrintStatus;
	private java.lang.String rsbyNo;
	private java.lang.String ehrAccessDetail;
	private java.lang.String rsbyCardNo;
	private java.lang.String bplNumber;
	private java.lang.Integer patientAge;
	private java.lang.String sourcetypeStatus;

	// collections
	private java.util.Set<jkt.hms.masters.business.OnlinePatientVisit> onlinePatientVisits;
	private java.util.Set<jkt.hms.masters.business.OnlinePatientAddress> onlinePatientAddress;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="hin_id"
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
	 * Return the value associated with the column: relation_id
	 */
	public java.lang.Integer getRelationId () {
		return relationId;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relationId the relation_id value
	 */
	public void setRelationId (java.lang.Integer relationId) {
		this.relationId = relationId;
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
	 * Return the value associated with the column: rank_id
	 */
	public java.lang.Integer getRankId () {
		return rankId;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rankId the rank_id value
	 */
	public void setRankId (java.lang.Integer rankId) {
		this.rankId = rankId;
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
	 * Return the value associated with the column: title_id
	 */
	public java.lang.Integer getTitleId () {
		return titleId;
	}

	/**
	 * Set the value related to the column: title_id
	 * @param titleId the title_id value
	 */
	public void setTitleId (java.lang.Integer titleId) {
		this.titleId = titleId;
	}



	/**
	 * Return the value associated with the column: p_first_name
	 */
	public java.lang.String getPFirstName () {
		return pFirstName;
	}

	/**
	 * Set the value related to the column: p_first_name
	 * @param pFirstName the p_first_name value
	 */
	public void setPFirstName (java.lang.String pFirstName) {
		this.pFirstName = pFirstName;
	}



	/**
	 * Return the value associated with the column: p_middle_name
	 */
	public java.lang.String getPMiddleName () {
		return pMiddleName;
	}

	/**
	 * Set the value related to the column: p_middle_name
	 * @param pMiddleName the p_middle_name value
	 */
	public void setPMiddleName (java.lang.String pMiddleName) {
		this.pMiddleName = pMiddleName;
	}



	/**
	 * Return the value associated with the column: p_last_name
	 */
	public java.lang.String getPLastName () {
		return pLastName;
	}

	/**
	 * Set the value related to the column: p_last_name
	 * @param pLastName the p_last_name value
	 */
	public void setPLastName (java.lang.String pLastName) {
		this.pLastName = pLastName;
	}



	/**
	 * Return the value associated with the column: s_first_name
	 */
	public java.lang.String getSFirstName () {
		return sFirstName;
	}

	/**
	 * Set the value related to the column: s_first_name
	 * @param sFirstName the s_first_name value
	 */
	public void setSFirstName (java.lang.String sFirstName) {
		this.sFirstName = sFirstName;
	}



	/**
	 * Return the value associated with the column: s_middle_name
	 */
	public java.lang.String getSMiddleName () {
		return sMiddleName;
	}

	/**
	 * Set the value related to the column: s_middle_name
	 * @param sMiddleName the s_middle_name value
	 */
	public void setSMiddleName (java.lang.String sMiddleName) {
		this.sMiddleName = sMiddleName;
	}



	/**
	 * Return the value associated with the column: s_last_name
	 */
	public java.lang.String getSLastName () {
		return sLastName;
	}

	/**
	 * Set the value related to the column: s_last_name
	 * @param sLastName the s_last_name value
	 */
	public void setSLastName (java.lang.String sLastName) {
		this.sLastName = sLastName;
	}



	/**
	 * Return the value associated with the column: sex_id
	 */
	public java.lang.Integer getSexId () {
		return sexId;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sexId the sex_id value
	 */
	public void setSexId (java.lang.Integer sexId) {
		this.sexId = sexId;
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
	 * Return the value associated with the column: marital_status_id
	 */
	public java.lang.Integer getMaritalStatusId () {
		return maritalStatusId;
	}

	/**
	 * Set the value related to the column: marital_status_id
	 * @param maritalStatusId the marital_status_id value
	 */
	public void setMaritalStatusId (java.lang.Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}



	/**
	 * Return the value associated with the column: trade_id
	 */
	public java.lang.Integer getTradeId () {
		return tradeId;
	}

	/**
	 * Set the value related to the column: trade_id
	 * @param tradeId the trade_id value
	 */
	public void setTradeId (java.lang.Integer tradeId) {
		this.tradeId = tradeId;
	}



	/**
	 * Return the value associated with the column: service_years
	 */
	public java.math.BigDecimal getServiceYears () {
		return serviceYears;
	}

	/**
	 * Set the value related to the column: service_years
	 * @param serviceYears the service_years value
	 */
	public void setServiceYears (java.math.BigDecimal serviceYears) {
		this.serviceYears = serviceYears;
	}



	/**
	 * Return the value associated with the column: religion_id
	 */
	public java.lang.Integer getReligionId () {
		return religionId;
	}

	/**
	 * Set the value related to the column: religion_id
	 * @param religionId the religion_id value
	 */
	public void setReligionId (java.lang.Integer religionId) {
		this.religionId = religionId;
	}



	/**
	 * Return the value associated with the column: station
	 */
	public java.lang.String getStation () {
		return station;
	}

	/**
	 * Set the value related to the column: station
	 * @param station the station value
	 */
	public void setStation (java.lang.String station) {
		this.station = station;
	}



	/**
	 * Return the value associated with the column: formation
	 */
	public java.lang.String getFormation () {
		return formation;
	}

	/**
	 * Set the value related to the column: formation
	 * @param formation the formation value
	 */
	public void setFormation (java.lang.String formation) {
		this.formation = formation;
	}



	/**
	 * Return the value associated with the column: ab_64_available
	 */
	public java.lang.String getAb64Available () {
		return ab64Available;
	}

	/**
	 * Set the value related to the column: ab_64_available
	 * @param ab64Available the ab_64_available value
	 */
	public void setAb64Available (java.lang.String ab64Available) {
		this.ab64Available = ab64Available;
	}



	/**
	 * Return the value associated with the column: cda_account_no
	 */
	public java.lang.String getCdaAccountNo () {
		return cdaAccountNo;
	}

	/**
	 * Set the value related to the column: cda_account_no
	 * @param cdaAccountNo the cda_account_no value
	 */
	public void setCdaAccountNo (java.lang.String cdaAccountNo) {
		this.cdaAccountNo = cdaAccountNo;
	}



	/**
	 * Return the value associated with the column: reference_id
	 */
	public java.lang.Integer getReferenceId () {
		return referenceId;
	}

	/**
	 * Set the value related to the column: reference_id
	 * @param referenceId the reference_id value
	 */
	public void setReferenceId (java.lang.Integer referenceId) {
		this.referenceId = referenceId;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public java.lang.Integer getBloodGroupId () {
		return bloodGroupId;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroupId the blood_group_id value
	 */
	public void setBloodGroupId (java.lang.Integer bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}



	/**
	 * Return the value associated with the column: current_visit_no
	 */
	public java.lang.Integer getCurrentVisitNo () {
		return currentVisitNo;
	}

	/**
	 * Set the value related to the column: current_visit_no
	 * @param currentVisitNo the current_visit_no value
	 */
	public void setCurrentVisitNo (java.lang.Integer currentVisitNo) {
		this.currentVisitNo = currentVisitNo;
	}



	/**
	 * Return the value associated with the column: inpatient_no
	 */
	public java.lang.Integer getInpatientNo () {
		return inpatientNo;
	}

	/**
	 * Set the value related to the column: inpatient_no
	 * @param inpatientNo the inpatient_no value
	 */
	public void setInpatientNo (java.lang.Integer inpatientNo) {
		this.inpatientNo = inpatientNo;
	}



	/**
	 * Return the value associated with the column: email_id
	 */
	public java.lang.String getEmailId () {
		return emailId;
	}

	/**
	 * Set the value related to the column: email_id
	 * @param emailId the email_id value
	 */
	public void setEmailId (java.lang.String emailId) {
		this.emailId = emailId;
	}



	/**
	 * Return the value associated with the column: record_office_address_id
	 */
	public java.lang.Integer getRecordOfficeAddressId () {
		return recordOfficeAddressId;
	}

	/**
	 * Set the value related to the column: record_office_address_id
	 * @param recordOfficeAddressId the record_office_address_id value
	 */
	public void setRecordOfficeAddressId (java.lang.Integer recordOfficeAddressId) {
		this.recordOfficeAddressId = recordOfficeAddressId;
	}



	/**
	 * Return the value associated with the column: occupation_id
	 */
	public java.lang.Integer getOccupationId () {
		return occupationId;
	}

	/**
	 * Set the value related to the column: occupation_id
	 * @param occupationId the occupation_id value
	 */
	public void setOccupationId (java.lang.Integer occupationId) {
		this.occupationId = occupationId;
	}



	/**
	 * Return the value associated with the column: phone_number
	 */
	public java.lang.String getPhoneNumber () {
		return phoneNumber;
	}

	/**
	 * Set the value related to the column: phone_number
	 * @param phoneNumber the phone_number value
	 */
	public void setPhoneNumber (java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	/**
	 * Return the value associated with the column: mobile_number
	 */
	public java.lang.String getMobileNumber () {
		return mobileNumber;
	}

	/**
	 * Set the value related to the column: mobile_number
	 * @param mobileNumber the mobile_number value
	 */
	public void setMobileNumber (java.lang.String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	/**
	 * Return the value associated with the column: next_of_kin_name
	 */
	public java.lang.String getNextOfKinName () {
		return nextOfKinName;
	}

	/**
	 * Set the value related to the column: next_of_kin_name
	 * @param nextOfKinName the next_of_kin_name value
	 */
	public void setNextOfKinName (java.lang.String nextOfKinName) {
		this.nextOfKinName = nextOfKinName;
	}



	/**
	 * Return the value associated with the column: next_of_kin_address
	 */
	public java.lang.String getNextOfKinAddress () {
		return nextOfKinAddress;
	}

	/**
	 * Set the value related to the column: next_of_kin_address
	 * @param nextOfKinAddress the next_of_kin_address value
	 */
	public void setNextOfKinAddress (java.lang.String nextOfKinAddress) {
		this.nextOfKinAddress = nextOfKinAddress;
	}



	/**
	 * Return the value associated with the column: next_of_kin_phone_number
	 */
	public java.lang.String getNextOfKinPhoneNumber () {
		return nextOfKinPhoneNumber;
	}

	/**
	 * Set the value related to the column: next_of_kin_phone_number
	 * @param nextOfKinPhoneNumber the next_of_kin_phone_number value
	 */
	public void setNextOfKinPhoneNumber (java.lang.String nextOfKinPhoneNumber) {
		this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
	}



	/**
	 * Return the value associated with the column: next_of_kin_mobile_number
	 */
	public java.lang.String getNextOfKinMobileNumber () {
		return nextOfKinMobileNumber;
	}

	/**
	 * Set the value related to the column: next_of_kin_mobile_number
	 * @param nextOfKinMobileNumber the next_of_kin_mobile_number value
	 */
	public void setNextOfKinMobileNumber (java.lang.String nextOfKinMobileNumber) {
		this.nextOfKinMobileNumber = nextOfKinMobileNumber;
	}



	/**
	 * Return the value associated with the column: next_of_kin_relation_id
	 */
	public java.lang.Integer getNextOfKinRelationId () {
		return nextOfKinRelationId;
	}

	/**
	 * Set the value related to the column: next_of_kin_relation_id
	 * @param nextOfKinRelationId the next_of_kin_relation_id value
	 */
	public void setNextOfKinRelationId (java.lang.Integer nextOfKinRelationId) {
		this.nextOfKinRelationId = nextOfKinRelationId;
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
	 * Return the value associated with the column: patient_status
	 */
	public java.lang.String getPatientStatus () {
		return patientStatus;
	}

	/**
	 * Set the value related to the column: patient_status
	 * @param patientStatus the patient_status value
	 */
	public void setPatientStatus (java.lang.String patientStatus) {
		this.patientStatus = patientStatus;
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
	 * Return the value associated with the column: mother_hin_no
	 */
	public java.lang.String getMotherHinNo () {
		return motherHinNo;
	}

	/**
	 * Set the value related to the column: mother_hin_no
	 * @param motherHinNo the mother_hin_no value
	 */
	public void setMotherHinNo (java.lang.String motherHinNo) {
		this.motherHinNo = motherHinNo;
	}



	/**
	 * Return the value associated with the column: service_card_validity_date
	 */
	public java.util.Date getServiceCardValidityDate () {
		return serviceCardValidityDate;
	}

	/**
	 * Set the value related to the column: service_card_validity_date
	 * @param serviceCardValidityDate the service_card_validity_date value
	 */
	public void setServiceCardValidityDate (java.util.Date serviceCardValidityDate) {
		this.serviceCardValidityDate = serviceCardValidityDate;
	}



	/**
	 * Return the value associated with the column: dependent_card_issue_date
	 */
	public java.util.Date getDependentCardIssueDate () {
		return dependentCardIssueDate;
	}

	/**
	 * Set the value related to the column: dependent_card_issue_date
	 * @param dependentCardIssueDate the dependent_card_issue_date value
	 */
	public void setDependentCardIssueDate (java.util.Date dependentCardIssueDate) {
		this.dependentCardIssueDate = dependentCardIssueDate;
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
	 * Return the value associated with the column: reg_date
	 */
	public java.util.Date getRegDate () {
		return regDate;
	}

	/**
	 * Set the value related to the column: reg_date
	 * @param regDate the reg_date value
	 */
	public void setRegDate (java.util.Date regDate) {
		this.regDate = regDate;
	}



	/**
	 * Return the value associated with the column: reg_time
	 */
	public java.lang.String getRegTime () {
		return regTime;
	}

	/**
	 * Set the value related to the column: reg_time
	 * @param regTime the reg_time value
	 */
	public void setRegTime (java.lang.String regTime) {
		this.regTime = regTime;
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
	 * Return the value associated with the column: service_status_id
	 */
	public java.lang.Integer getServiceStatusId () {
		return serviceStatusId;
	}

	/**
	 * Set the value related to the column: service_status_id
	 * @param serviceStatusId the service_status_id value
	 */
	public void setServiceStatusId (java.lang.Integer serviceStatusId) {
		this.serviceStatusId = serviceStatusId;
	}



	/**
	 * Return the value associated with the column: old_hin_no
	 */
	public java.lang.String getOldHinNo () {
		return oldHinNo;
	}

	/**
	 * Set the value related to the column: old_hin_no
	 * @param oldHinNo the old_hin_no value
	 */
	public void setOldHinNo (java.lang.String oldHinNo) {
		this.oldHinNo = oldHinNo;
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
	 * Return the value associated with the column: total_service_period
	 */
	public java.lang.String getTotalServicePeriod () {
		return totalServicePeriod;
	}

	/**
	 * Set the value related to the column: total_service_period
	 * @param totalServicePeriod the total_service_period value
	 */
	public void setTotalServicePeriod (java.lang.String totalServicePeriod) {
		this.totalServicePeriod = totalServicePeriod;
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
	 * Return the value associated with the column: echs_no
	 */
	public java.lang.String getEchsNo () {
		return echsNo;
	}

	/**
	 * Set the value related to the column: echs_no
	 * @param echsNo the echs_no value
	 */
	public void setEchsNo (java.lang.String echsNo) {
		this.echsNo = echsNo;
	}



	/**
	 * Return the value associated with the column: patient_type_id
	 */
	public java.lang.Integer getPatientTypeId () {
		return patientTypeId;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * @param patientTypeId the patient_type_id value
	 */
	public void setPatientTypeId (java.lang.Integer patientTypeId) {
		this.patientTypeId = patientTypeId;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public java.lang.Integer getCompanyId () {
		return companyId;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param companyId the company_id value
	 */
	public void setCompanyId (java.lang.Integer companyId) {
		this.companyId = companyId;
	}



	/**
	 * Return the value associated with the column: insurance_amt
	 */
	public java.lang.String getInsuranceAmt () {
		return insuranceAmt;
	}

	/**
	 * Set the value related to the column: insurance_amt
	 * @param insuranceAmt the insurance_amt value
	 */
	public void setInsuranceAmt (java.lang.String insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
	}



	/**
	 * Return the value associated with the column: past_due
	 */
	public java.lang.String getPastDue () {
		return pastDue;
	}

	/**
	 * Set the value related to the column: past_due
	 * @param pastDue the past_due value
	 */
	public void setPastDue (java.lang.String pastDue) {
		this.pastDue = pastDue;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public java.lang.Integer getEmpId () {
		return empId;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param empId the emp_id value
	 */
	public void setEmpId (java.lang.Integer empId) {
		this.empId = empId;
	}



	/**
	 * Return the value associated with the column: emp_dependent_id
	 */
	public java.lang.Integer getEmpDependentId () {
		return empDependentId;
	}

	/**
	 * Set the value related to the column: emp_dependent_id
	 * @param empDependentId the emp_dependent_id value
	 */
	public void setEmpDependentId (java.lang.Integer empDependentId) {
		this.empDependentId = empDependentId;
	}



	/**
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.Long getBillNo () {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * @param billNo the bill_no value
	 */
	public void setBillNo (java.lang.Long billNo) {
		this.billNo = billNo;
	}



	/**
	 * Return the value associated with the column: reg_type
	 */
	public java.lang.Integer getRegType () {
		return regType;
	}

	/**
	 * Set the value related to the column: reg_type
	 * @param regType the reg_type value
	 */
	public void setRegType (java.lang.Integer regType) {
		this.regType = regType;
	}



	/**
	 * Return the value associated with the column: ref_doctor
	 */
	public java.lang.Integer getRefDoctor () {
		return refDoctor;
	}

	/**
	 * Set the value related to the column: ref_doctor
	 * @param refDoctor the ref_doctor value
	 */
	public void setRefDoctor (java.lang.Integer refDoctor) {
		this.refDoctor = refDoctor;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.lang.Long getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.lang.Long amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: discount
	 */
	public java.lang.Long getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * @param discount the discount value
	 */
	public void setDiscount (java.lang.Long discount) {
		this.discount = discount;
	}



	/**
	 * Return the value associated with the column: net_amount
	 */
	public java.lang.Long getNetAmount () {
		return netAmount;
	}

	/**
	 * Set the value related to the column: net_amount
	 * @param netAmount the net_amount value
	 */
	public void setNetAmount (java.lang.Long netAmount) {
		this.netAmount = netAmount;
	}



	/**
	 * Return the value associated with the column: caste
	 */
	public java.lang.Integer getCaste () {
		return caste;
	}

	/**
	 * Set the value related to the column: caste
	 * @param caste the caste value
	 */
	public void setCaste (java.lang.Integer caste) {
		this.caste = caste;
	}



	/**
	 * Return the value associated with the column: bpl_status
	 */
	public java.lang.String getBplStatus () {
		return bplStatus;
	}

	/**
	 * Set the value related to the column: bpl_status
	 * @param bplStatus the bpl_status value
	 */
	public void setBplStatus (java.lang.String bplStatus) {
		this.bplStatus = bplStatus;
	}



	/**
	 * Return the value associated with the column: registration_type
	 */
	public java.lang.String getRegistrationType () {
		return registrationType;
	}

	/**
	 * Set the value related to the column: registration_type
	 * @param registrationType the registration_type value
	 */
	public void setRegistrationType (java.lang.String registrationType) {
		this.registrationType = registrationType;
	}



	/**
	 * Return the value associated with the column: card_valid_date
	 */
	public java.util.Date getCardValidDate () {
		return cardValidDate;
	}

	/**
	 * Set the value related to the column: card_valid_date
	 * @param cardValidDate the card_valid_date value
	 */
	public void setCardValidDate (java.util.Date cardValidDate) {
		this.cardValidDate = cardValidDate;
	}



	/**
	 * Return the value associated with the column: native_place_id
	 */
	public java.lang.Integer getNativePlaceId () {
		return nativePlaceId;
	}

	/**
	 * Set the value related to the column: native_place_id
	 * @param nativePlaceId the native_place_id value
	 */
	public void setNativePlaceId (java.lang.Integer nativePlaceId) {
		this.nativePlaceId = nativePlaceId;
	}



	/**
	 * Return the value associated with the column: new_born_baby
	 */
	public java.lang.String getNewBornBaby () {
		return newBornBaby;
	}

	/**
	 * Set the value related to the column: new_born_baby
	 * @param newBornBaby the new_born_baby value
	 */
	public void setNewBornBaby (java.lang.String newBornBaby) {
		this.newBornBaby = newBornBaby;
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
	 * Return the value associated with the column: id_card
	 */
	public java.lang.Integer getIdCard () {
		return idCard;
	}

	/**
	 * Set the value related to the column: id_card
	 * @param idCard the id_card value
	 */
	public void setIdCard (java.lang.Integer idCard) {
		this.idCard = idCard;
	}



	/**
	 * Return the value associated with the column: id_no
	 */
	public java.lang.String getIdNo () {
		return idNo;
	}

	/**
	 * Set the value related to the column: id_no
	 * @param idNo the id_no value
	 */
	public void setIdNo (java.lang.String idNo) {
		this.idNo = idNo;
	}



	/**
	 * Return the value associated with the column: full_name
	 */
	public java.lang.String getFullName () {
		return fullName;
	}

	/**
	 * Set the value related to the column: full_name
	 * @param fullName the full_name value
	 */
	public void setFullName (java.lang.String fullName) {
		this.fullName = fullName;
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
	 * Return the value associated with the column: father_mother_name
	 */
	public java.lang.String getFatherMotherName () {
		return fatherMotherName;
	}

	/**
	 * Set the value related to the column: father_mother_name
	 * @param fatherMotherName the father_mother_name value
	 */
	public void setFatherMotherName (java.lang.String fatherMotherName) {
		this.fatherMotherName = fatherMotherName;
	}



	/**
	 * Return the value associated with the column: migrant
	 */
	public java.lang.String getMigrant () {
		return migrant;
	}

	/**
	 * Set the value related to the column: migrant
	 * @param migrant the migrant value
	 */
	public void setMigrant (java.lang.String migrant) {
		this.migrant = migrant;
	}



	/**
	 * Return the value associated with the column: electricity_poll_no
	 */
	public java.lang.String getElectricityPollNo () {
		return electricityPollNo;
	}

	/**
	 * Set the value related to the column: electricity_poll_no
	 * @param electricityPollNo the electricity_poll_no value
	 */
	public void setElectricityPollNo (java.lang.String electricityPollNo) {
		this.electricityPollNo = electricityPollNo;
	}



	/**
	 * Return the value associated with the column: secondary_email_id
	 */
	public java.lang.String getSecondaryEmailId () {
		return secondaryEmailId;
	}

	/**
	 * Set the value related to the column: secondary_email_id
	 * @param secondaryEmailId the secondary_email_id value
	 */
	public void setSecondaryEmailId (java.lang.String secondaryEmailId) {
		this.secondaryEmailId = secondaryEmailId;
	}



	/**
	 * Return the value associated with the column: secondary_mobile_no
	 */
	public java.lang.String getSecondaryMobileNo () {
		return secondaryMobileNo;
	}

	/**
	 * Set the value related to the column: secondary_mobile_no
	 * @param secondaryMobileNo the secondary_mobile_no value
	 */
	public void setSecondaryMobileNo (java.lang.String secondaryMobileNo) {
		this.secondaryMobileNo = secondaryMobileNo;
	}



	/**
	 * Return the value associated with the column: patient_category
	 */
	public java.lang.Integer getPatientCategory () {
		return patientCategory;
	}

	/**
	 * Set the value related to the column: patient_category
	 * @param patientCategory the patient_category value
	 */
	public void setPatientCategory (java.lang.Integer patientCategory) {
		this.patientCategory = patientCategory;
	}



	/**
	 * Return the value associated with the column: nativity_type
	 */
	public java.lang.String getNativityType () {
		return nativityType;
	}

	/**
	 * Set the value related to the column: nativity_type
	 * @param nativityType the nativity_type value
	 */
	public void setNativityType (java.lang.String nativityType) {
		this.nativityType = nativityType;
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
	 * Return the value associated with the column: country_id
	 */
	public java.lang.Integer getCountryId () {
		return countryId;
	}

	/**
	 * Set the value related to the column: country_id
	 * @param countryId the country_id value
	 */
	public void setCountryId (java.lang.Integer countryId) {
		this.countryId = countryId;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public java.lang.Integer getStateId () {
		return stateId;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param stateId the state_id value
	 */
	public void setStateId (java.lang.Integer stateId) {
		this.stateId = stateId;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public java.lang.Integer getDistrictId () {
		return districtId;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param districtId the district_id value
	 */
	public void setDistrictId (java.lang.Integer districtId) {
		this.districtId = districtId;
	}



	/**
	 * Return the value associated with the column: purpose
	 */
	public java.lang.String getPurpose () {
		return purpose;
	}

	/**
	 * Set the value related to the column: purpose
	 * @param purpose the purpose value
	 */
	public void setPurpose (java.lang.String purpose) {
		this.purpose = purpose;
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
	 * Return the value associated with the column: visa_type
	 */
	public java.lang.Integer getVisaType () {
		return visaType;
	}

	/**
	 * Set the value related to the column: visa_type
	 * @param visaType the visa_type value
	 */
	public void setVisaType (java.lang.Integer visaType) {
		this.visaType = visaType;
	}



	/**
	 * Return the value associated with the column: visa_from
	 */
	public java.util.Date getVisaFrom () {
		return visaFrom;
	}

	/**
	 * Set the value related to the column: visa_from
	 * @param visaFrom the visa_from value
	 */
	public void setVisaFrom (java.util.Date visaFrom) {
		this.visaFrom = visaFrom;
	}



	/**
	 * Return the value associated with the column: visa_to
	 */
	public java.util.Date getVisaTo () {
		return visaTo;
	}

	/**
	 * Set the value related to the column: visa_to
	 * @param visaTo the visa_to value
	 */
	public void setVisaTo (java.util.Date visaTo) {
		this.visaTo = visaTo;
	}



	/**
	 * Return the value associated with the column: education
	 */
	public java.lang.Integer getEducation () {
		return education;
	}

	/**
	 * Set the value related to the column: education
	 * @param education the education value
	 */
	public void setEducation (java.lang.Integer education) {
		this.education = education;
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
	 * Return the value associated with the column: member_id
	 */
	public java.lang.Integer getMemberId () {
		return memberId;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param memberId the member_id value
	 */
	public void setMemberId (java.lang.Integer memberId) {
		this.memberId = memberId;
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
	 * Return the value associated with the column: national_dob_status
	 */
	public java.lang.String getNationalDobStatus () {
		return nationalDobStatus;
	}

	/**
	 * Set the value related to the column: national_dob_status
	 * @param nationalDobStatus the national_dob_status value
	 */
	public void setNationalDobStatus (java.lang.String nationalDobStatus) {
		this.nationalDobStatus = nationalDobStatus;
	}



	/**
	 * Return the value associated with the column: otp_number
	 */
	public java.lang.Long getOtpNumber () {
		return otpNumber;
	}

	/**
	 * Set the value related to the column: otp_number
	 * @param otpNumber the otp_number value
	 */
	public void setOtpNumber (java.lang.Long otpNumber) {
		this.otpNumber = otpNumber;
	}



	/**
	 * Return the value associated with the column: tem_address_id_proof
	 */
	public java.lang.Integer getTemAddressIdProof () {
		return temAddressIdProof;
	}

	/**
	 * Set the value related to the column: tem_address_id_proof
	 * @param temAddressIdProof the tem_address_id_proof value
	 */
	public void setTemAddressIdProof (java.lang.Integer temAddressIdProof) {
		this.temAddressIdProof = temAddressIdProof;
	}



	/**
	 * Return the value associated with the column: temp_address_id_proof_num
	 */
	public java.lang.String getTempAddressIdProofNum () {
		return tempAddressIdProofNum;
	}

	/**
	 * Set the value related to the column: temp_address_id_proof_num
	 * @param tempAddressIdProofNum the temp_address_id_proof_num value
	 */
	public void setTempAddressIdProofNum (java.lang.String tempAddressIdProofNum) {
		this.tempAddressIdProofNum = tempAddressIdProofNum;
	}



	/**
	 * Return the value associated with the column: dob_other_card_id
	 */
	public java.lang.Integer getDobOtherCardId () {
		return dobOtherCardId;
	}

	/**
	 * Set the value related to the column: dob_other_card_id
	 * @param dobOtherCardId the dob_other_card_id value
	 */
	public void setDobOtherCardId (java.lang.Integer dobOtherCardId) {
		this.dobOtherCardId = dobOtherCardId;
	}



	/**
	 * Return the value associated with the column: dob_other_card_number
	 */
	public java.lang.String getDobOtherCardNumber () {
		return dobOtherCardNumber;
	}

	/**
	 * Set the value related to the column: dob_other_card_number
	 * @param dobOtherCardNumber the dob_other_card_number value
	 */
	public void setDobOtherCardNumber (java.lang.String dobOtherCardNumber) {
		this.dobOtherCardNumber = dobOtherCardNumber;
	}



	/**
	 * Return the value associated with the column: monthly_income
	 */
	public java.math.BigDecimal getMonthlyIncome () {
		return monthlyIncome;
	}

	/**
	 * Set the value related to the column: monthly_income
	 * @param monthlyIncome the monthly_income value
	 */
	public void setMonthlyIncome (java.math.BigDecimal monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}



	/**
	 * Return the value associated with the column: death_certificate_print_status
	 */
	public java.lang.String getDeathCertificatePrintStatus () {
		return deathCertificatePrintStatus;
	}

	/**
	 * Set the value related to the column: death_certificate_print_status
	 * @param deathCertificatePrintStatus the death_certificate_print_status value
	 */
	public void setDeathCertificatePrintStatus (java.lang.String deathCertificatePrintStatus) {
		this.deathCertificatePrintStatus = deathCertificatePrintStatus;
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
	 * Return the value associated with the column: ehr_access_detail
	 */
	public java.lang.String getEhrAccessDetail () {
		return ehrAccessDetail;
	}

	/**
	 * Set the value related to the column: ehr_access_detail
	 * @param ehrAccessDetail the ehr_access_detail value
	 */
	public void setEhrAccessDetail (java.lang.String ehrAccessDetail) {
		this.ehrAccessDetail = ehrAccessDetail;
	}



	/**
	 * Return the value associated with the column: rsby_card_no
	 */
	public java.lang.String getRsbyCardNo () {
		return rsbyCardNo;
	}

	/**
	 * Set the value related to the column: rsby_card_no
	 * @param rsbyCardNo the rsby_card_no value
	 */
	public void setRsbyCardNo (java.lang.String rsbyCardNo) {
		this.rsbyCardNo = rsbyCardNo;
	}



	/**
	 * Return the value associated with the column: bpl_number
	 */
	public java.lang.String getBplNumber () {
		return bplNumber;
	}

	/**
	 * Set the value related to the column: bpl_number
	 * @param bplNumber the bpl_number value
	 */
	public void setBplNumber (java.lang.String bplNumber) {
		this.bplNumber = bplNumber;
	}



	/**
	 * Return the value associated with the column: patient_age
	 */
	public java.lang.Integer getPatientAge () {
		return patientAge;
	}

	/**
	 * Set the value related to the column: patient_age
	 * @param patientAge the patient_age value
	 */
	public void setPatientAge (java.lang.Integer patientAge) {
		this.patientAge = patientAge;
	}



	/**
	 * Return the value associated with the column: sourcetype_status
	 */
	public java.lang.String getSourcetypeStatus () {
		return sourcetypeStatus;
	}

	/**
	 * Set the value related to the column: sourcetype_status
	 * @param sourcetypeStatus the sourcetype_status value
	 */
	public void setSourcetypeStatus (java.lang.String sourcetypeStatus) {
		this.sourcetypeStatus = sourcetypeStatus;
	}



	/**
	 * Return the value associated with the column: OnlinePatientVisits
	 */
	public java.util.Set<jkt.hms.masters.business.OnlinePatientVisit> getOnlinePatientVisits () {
		return onlinePatientVisits;
	}

	/**
	 * Set the value related to the column: OnlinePatientVisits
	 * @param onlinePatientVisits the OnlinePatientVisits value
	 */
	public void setOnlinePatientVisits (java.util.Set<jkt.hms.masters.business.OnlinePatientVisit> onlinePatientVisits) {
		this.onlinePatientVisits = onlinePatientVisits;
	}

	public void addToOnlinePatientVisits (jkt.hms.masters.business.OnlinePatientVisit onlinePatientVisit) {
		if (null == getOnlinePatientVisits()) setOnlinePatientVisits(new java.util.TreeSet<jkt.hms.masters.business.OnlinePatientVisit>());
		getOnlinePatientVisits().add(onlinePatientVisit);
	}



	/**
	 * Return the value associated with the column: OnlinePatientAddress
	 */
	public java.util.Set<jkt.hms.masters.business.OnlinePatientAddress> getOnlinePatientAddress () {
		return onlinePatientAddress;
	}

	/**
	 * Set the value related to the column: OnlinePatientAddress
	 * @param onlinePatientAddress the OnlinePatientAddress value
	 */
	public void setOnlinePatientAddress (java.util.Set<jkt.hms.masters.business.OnlinePatientAddress> onlinePatientAddress) {
		this.onlinePatientAddress = onlinePatientAddress;
	}

	public void addToOnlinePatientAddress (jkt.hms.masters.business.OnlinePatientAddress onlinePatientAddress) {
		if (null == getOnlinePatientAddress()) setOnlinePatientAddress(new java.util.TreeSet<jkt.hms.masters.business.OnlinePatientAddress>());
		getOnlinePatientAddress().add(onlinePatientAddress);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OnlinePatientPortal)) return false;
		else {
			jkt.hms.masters.business.OnlinePatientPortal onlinePatientPortal = (jkt.hms.masters.business.OnlinePatientPortal) obj;
			if (null == this.getId() || null == onlinePatientPortal.getId()) return false;
			else return (this.getId().equals(onlinePatientPortal.getId()));
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