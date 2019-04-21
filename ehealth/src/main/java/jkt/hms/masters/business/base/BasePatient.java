package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient"
 */

public abstract class BasePatient  implements Serializable {

	public static String REF = "Patient";
	public static String PROP_NEXT_OF_KIN_NAME = "NextOfKinName";
	public static String PROP_NEXT_OF_KIN_ADDRESS = "NextOfKinAddress";
	public static String PROP_TRADE = "Trade";
	public static String PROP_REF_DOCTOR = "RefDoctor";
	public static String PROP_CDA_ACCOUNT_NO = "CdaAccountNo";
	public static String PROP_NEXT_OF_KIN_RELATION = "NextOfKinRelation";
	public static String PROP_REGISTRATION_TYPE = "RegistrationType";
	public static String PROP_MONTHLY_INCOME = "MonthlyIncome";
	public static String PROP_REG_TYPE = "RegType";
	public static String PROP_OLD_HIN_NO = "OldHinNo";
	public static String PROP_P_LAST_NAME = "PLastName";
	public static String PROP_RELIGION = "Religion";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_REG_SOURCE_TYPE = "RegSourceType";
	public static String PROP_DISTRICT = "District";
	public static String PROP_P_FIRST_NAME = "PFirstName";
	public static String PROP_NATIVITY_TYPE = "NativityType";
	public static String PROP_ID_NO = "IdNo";
	public static String PROP_ELECTRICITY_POLL_NO = "ElectricityPollNo";
	public static String PROP_PURPOSE = "Purpose";
	public static String PROP_PASSPORT_NO = "PassportNo";
	public static String PROP_NOTIONAL_DOB_STATUS = "NotionalDobStatus";
	public static String PROP_BPLNUMBER = "Bplnumber";
	public static String PROP_INPATIENT_NO = "InpatientNo";
	public static String PROP_MEMBER = "Member";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_REG_TIME = "RegTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_FORMATION = "Formation";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_UNIT = "Unit";
	public static String PROP_STATION = "Station";
	public static String PROP_TEMP_ADDRESS_ID_PROOF_NUM = "TempAddressIdProofNum";
	public static String PROP_YEAR_OF_BIRTH = "YearOfBirth";
	public static String PROP_SERVICE_CARD_VALIDITY_DATE = "ServiceCardValidityDate";
	public static String PROP_S_FIRST_NAME = "SFirstName";
	public static String PROP_DEATH_CERTIFICATE_PRINT_STATUS = "DeathCertificatePrintStatus";
	public static String PROP_OCCUPATION = "Occupation";
	public static String PROP_FULL_NAME = "FullName";
	public static String PROP_EHR_ACCESS_DETAIL = "EhrAccessDetail";
	public static String PROP_PAST_DUE = "PastDue";
	public static String PROP_S_MIDDLE_NAME = "SMiddleName";
	public static String PROP_TOTAL_SERVICE_PERIOD = "TotalServicePeriod";
	public static String PROP_SCHEME = "Scheme";
	public static String PROP_CURRENT_VISIT_NO = "CurrentVisitNo";
	public static String PROP_BPL_STATUS = "BplStatus";
	public static String PROP_ECHS_NO = "EchsNo";
	public static String PROP_TITLE = "Title";
	public static String PROP_NEW_BORN_BABY = "NewBornBaby";
	public static String PROP_TEM_ADDRESS_ID_PROOF = "TemAddressIdProof";
	public static String PROP_PATIENT_STATUS = "PatientStatus";
	public static String PROP_FAMILY = "Family";
	public static String PROP_PATIENT_CATEGORY = "PatientCategory";
	public static String PROP_SERVICE_YEARS = "ServiceYears";
	public static String PROP_RANK = "Rank";
	public static String PROP_SECONDARY_EMAIL_ID = "SecondaryEmailId";
	public static String PROP_INCOME_UPDATE_REMARKS = "incomeUpdateRemarks";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_CARD_VALID_DATE = "CardValidDate";
	public static String PROP_PATIENT_OLD_NAME = "PatientOldName";
	public static String PROP_PATIENT_IMAGE = "PatientImage";
	public static String PROP_PATIENT_AGE = "PatientAge";
	public static String PROP_VERBAL_STATUS = "VerbalStatus";
	public static String PROP_MOTHER_HIN_NO = "MotherHinNo";
	public static String PROP_EMP = "Emp";
	public static String PROP_CASTE = "Caste";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_S_LAST_NAME = "SLastName";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_NATIVITY = "Nativity";
	public static String PROP_SEX = "Sex";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_OTP_NUMBER = "OtpNumber";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_RECORD_OFFICE_ADDRESS = "RecordOfficeAddress";
	public static String PROP_AADHAAR_NO = "AadhaarNo";
	public static String PROP_SUFFIX = "Suffix";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPENDENT_CARD_ISSUE_DATE = "DependentCardIssueDate";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_SERVICE_STATUS = "ServiceStatus";
	public static String PROP_RSBY_CARD_NO = "RsbyCardNo";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_AB64_AVAILABLE = "Ab64Available";
	public static String PROP_MIGRANT = "Migrant";
	public static String PROP_BLOOD_GROUP_VALUE = "BloodGroupValue";
	public static String PROP_SERVICE_CARD_STATUS = "ServiceCardStatus";
	public static String PROP_DOB_OTHER_CARD_NUMBER = "DobOtherCardNumber";
	public static String PROP_ID = "Id";
	public static String PROP_REFERENCE = "Reference";
	public static String PROP_AADHAAR_VERIFY_STATUS = "AadhaarVerifyStatus";
	public static String PROP_VISA_TYPE = "VisaType";
	public static String PROP_AGE = "Age";
	public static String PROP_NEXT_OF_KIN_MOBILE_NUMBER = "NextOfKinMobileNumber";
	public static String PROP_VISA_FROM = "VisaFrom";
	public static String PROP_EMP_DEPENDENT = "EmpDependent";
	public static String PROP_VISA_TO = "VisaTo";
	public static String PROP_PATIENT_ADDRESS = "PatientAddress";
	public static String PROP_MARITAL_STATUS = "MaritalStatus";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_COMPANY = "Company";
	public static String PROP_MOBILE_NUMBER = "MobileNumber";
	public static String PROP_RELATION = "Relation";
	public static String PROP_NEXT_OF_KIN_PHONE_NUMBER = "NextOfKinPhoneNumber";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_NET_AMOUNT = "NetAmount";
	public static String PROP_FATHER_MOTHER_NAME = "FatherMotherName";
	public static String PROP_ID_CARD = "IdCard";
	public static String PROP_SECONDARY_MOBILE_NO = "SecondaryMobileNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_EDUCATION = "Education";
	public static String PROP_INSURANCE_AMT = "InsuranceAmt";
	public static String PROP_STATE = "State";
	public static String PROP_DOB_OTHER_CARD = "DobOtherCard";
	public static String PROP_NATIVE_PLACE = "NativePlace";
	public static String PROP_CONFIRMED_STATUS = "ConfirmedStatus";
	public static String PROP_P_MIDDLE_NAME = "PMiddleName";


	// constructors
	public BasePatient () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatient (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePatient (
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
	private java.lang.String hinNo;
	private java.lang.String pFirstName;
	private java.lang.String pMiddleName;
	private java.lang.String pLastName;
	private java.lang.String sFirstName;
	private java.lang.String sMiddleName;
	private java.lang.String sLastName;
	private java.util.Date dateOfBirth;
	private java.math.BigDecimal serviceYears;
	private java.lang.String station;
	private java.lang.String formation;
	private java.lang.String ab64Available;
	private java.lang.String cdaAccountNo;
	private java.lang.Integer currentVisitNo;
	private java.lang.Integer inpatientNo;
	private java.lang.String emailId;
	private java.lang.String phoneNumber;
	private java.lang.String mobileNumber;
	private java.lang.String nextOfKinName;
	private java.lang.String nextOfKinAddress;
	private java.lang.String nextOfKinPhoneNumber;
	private java.lang.String nextOfKinMobileNumber;
	private java.lang.String remarks;
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
	private java.lang.String oldHinNo;
	private java.lang.String age;
	private java.lang.String totalServicePeriod;
	private java.lang.String prefix;
	private java.lang.String echsNo;
	private java.lang.String insuranceAmt;
	private java.lang.String pastDue;
	private java.lang.Integer billNo;
	private java.lang.Integer amount;
	private java.lang.Integer discount;
	private java.lang.Integer netAmount;
	private java.lang.String bplStatus;
	private java.lang.String registrationType;
	private java.util.Date cardValidDate;
	private byte[] patientImage;
	private java.lang.String newBornBaby;
	private java.lang.Long aadhaarNo;
	private java.lang.String idNo;
	private java.lang.String fullName;
	private java.lang.String yearOfBirth;
	private java.lang.String fatherMotherName;
	private java.lang.String migrant;
	private java.lang.String electricityPollNo;
	private java.lang.String secondaryEmailId;
	private java.lang.String secondaryMobileNo;
	private java.lang.String nativityType;
	private java.lang.String nativity;
	private java.lang.String purpose;
	private java.lang.String passportNo;
	private java.util.Date visaFrom;
	private java.util.Date visaTo;
	private java.lang.String password;
	private java.lang.String notionalDobStatus;
	private java.lang.Integer otpNumber;
	private java.lang.String tempAddressIdProofNum;
	private java.lang.String dobOtherCardNumber;
	private java.math.BigDecimal monthlyIncome;
	private java.lang.String deathCertificatePrintStatus;
	private java.lang.String rsbyCardNo;
	private java.lang.String ehrAccessDetail;
	private java.lang.String incomeUpdateRemarks;
	private java.lang.Integer patientAge;
	private java.lang.String regSourceType;
	private java.lang.String aadhaarVerifyStatus;
	private java.lang.String patientAddress;
	private java.lang.String bloodGroupValue;
	private java.lang.String confirmedStatus;
	private java.lang.String verbalStatus;
	private java.lang.String bplnumber;
	private java.lang.String patientOldName;

	// many to one
	private jkt.hms.masters.business.MasIdCard dobOtherCard;
	private jkt.hms.masters.business.MasState nativePlace;
	private jkt.hms.masters.business.MasCompany company;
	private jkt.hms.masters.business.MasPatientCategory patientCategory;
	private jkt.hms.masters.business.MasServiceStatus serviceStatus;
	private jkt.hms.masters.business.PhFamilySurvey family;
	private jkt.hms.masters.business.MasMaritalStatus maritalStatus;
	private jkt.hms.masters.business.MasCaste caste;
	private jkt.hms.masters.business.MasRelation nextOfKinRelation;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasIdCard idCard;
	private jkt.hrms.masters.business.MasQualification education;
	private jkt.hms.masters.business.MasChargeCode regType;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasPatientType patientType;
	private jkt.hms.masters.business.MasReligion religion;
	private jkt.hms.masters.business.MasRecordOfficeAddress recordOfficeAddress;
	private jkt.hms.masters.business.MasVisaType visaType;
	private jkt.hms.masters.business.MasOccupation occupation;
	private jkt.hms.masters.business.MasReference reference;
	private jkt.hms.masters.business.MasEmployeeDependent empDependent;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasIdCard temAddressIdProof;
	private jkt.hms.masters.business.MasAuthorizer refDoctor;
	private jkt.hms.masters.business.PhMemberSurvey member;
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasTitle title;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasTrade trade;
	private jkt.hms.masters.business.MasScheme scheme;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs;
	private java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> opdOphRetinalHeaders;
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> blChargeSlipMains;
	private java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries;
	private java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> opdOphDiagnosisHeaders;
	private java.util.Set<jkt.hms.masters.business.DiagnosticsOrderHeader> diagnosticsOrderHeaders;
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs;
	private java.util.Set<jkt.hms.masters.business.MisFrw> misFrws;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs;
	private java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails;
	private java.util.Set<jkt.hms.masters.business.AppPatientAppointments> appPatientAppointments;
	private java.util.Set<jkt.hms.masters.business.BlDepositHeader> blDepositHeaders;
	private java.util.Set<jkt.hms.masters.business.AppInvestigationAppointments> appInvestigationAppointments;
	private java.util.Set<jkt.hms.masters.business.BlVoucherDetails> blVoucherDetails;
	private java.util.Set<jkt.hms.masters.business.OpdPatientHistory> opdPatientHistories;
	private java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables;
	private java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans;
	private java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets;
	private java.util.Set<jkt.hms.masters.business.BlPatientLedger> blPatientLedgers;
	private java.util.Set<jkt.hms.masters.business.OpdOphthalmology> opdOphthalmologies;
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs;
	private java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs;
	private java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts;
	private java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts;
	private java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts;
	private java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds;
	private java.util.Set<jkt.hms.masters.business.Visit> visits;
	private java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings;
	private java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders;
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> opdOphFollowUps;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfers;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopys;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopys;
	private java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryHeader> opdSurgeryHeaders;
	private java.util.Set<jkt.hms.masters.business.PatientCategoryDetails> patientCategoryDetails;



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
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.Integer getBillNo () {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * @param billNo the bill_no value
	 */
	public void setBillNo (java.lang.Integer billNo) {
		this.billNo = billNo;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.lang.Integer getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.lang.Integer amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: discount
	 */
	public java.lang.Integer getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * @param discount the discount value
	 */
	public void setDiscount (java.lang.Integer discount) {
		this.discount = discount;
	}



	/**
	 * Return the value associated with the column: net_amount
	 */
	public java.lang.Integer getNetAmount () {
		return netAmount;
	}

	/**
	 * Set the value related to the column: net_amount
	 * @param netAmount the net_amount value
	 */
	public void setNetAmount (java.lang.Integer netAmount) {
		this.netAmount = netAmount;
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
	 * Return the value associated with the column: patient_image
	 */
	public byte[] getPatientImage () {
		return patientImage;
	}

	/**
	 * Set the value related to the column: patient_image
	 * @param patientImage the patient_image value
	 */
	public void setPatientImage (byte[] patientImage) {
		this.patientImage = patientImage;
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
	 * Return the value associated with the column: notional_dob_status
	 */
	public java.lang.String getNotionalDobStatus () {
		return notionalDobStatus;
	}

	/**
	 * Set the value related to the column: notional_dob_status
	 * @param notionalDobStatus the notional_dob_status value
	 */
	public void setNotionalDobStatus (java.lang.String notionalDobStatus) {
		this.notionalDobStatus = notionalDobStatus;
	}



	/**
	 * Return the value associated with the column: otp_number
	 */
	public java.lang.Integer getOtpNumber () {
		return otpNumber;
	}

	/**
	 * Set the value related to the column: otp_number
	 * @param otpNumber the otp_number value
	 */
	public void setOtpNumber (java.lang.Integer otpNumber) {
		this.otpNumber = otpNumber;
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
	 * Return the value associated with the column: income_update_remark
	 */
	public java.lang.String getIncomeUpdateRemarks () {
		return incomeUpdateRemarks;
	}

	/**
	 * Set the value related to the column: income_update_remark
	 * @param incomeUpdateRemarks the income_update_remark value
	 */
	public void setIncomeUpdateRemarks (java.lang.String incomeUpdateRemarks) {
		this.incomeUpdateRemarks = incomeUpdateRemarks;
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
	 * Return the value associated with the column: reg_source_type
	 */
	public java.lang.String getRegSourceType () {
		return regSourceType;
	}

	/**
	 * Set the value related to the column: reg_source_type
	 * @param regSourceType the reg_source_type value
	 */
	public void setRegSourceType (java.lang.String regSourceType) {
		this.regSourceType = regSourceType;
	}



	/**
	 * Return the value associated with the column: aadhaar_verify_status
	 */
	public java.lang.String getAadhaarVerifyStatus () {
		return aadhaarVerifyStatus;
	}

	/**
	 * Set the value related to the column: aadhaar_verify_status
	 * @param aadhaarVerifyStatus the aadhaar_verify_status value
	 */
	public void setAadhaarVerifyStatus (java.lang.String aadhaarVerifyStatus) {
		this.aadhaarVerifyStatus = aadhaarVerifyStatus;
	}



	/**
	 * Return the value associated with the column: patient_address
	 */
	public java.lang.String getPatientAddress () {
		return patientAddress;
	}

	/**
	 * Set the value related to the column: patient_address
	 * @param patientAddress the patient_address value
	 */
	public void setPatientAddress (java.lang.String patientAddress) {
		this.patientAddress = patientAddress;
	}



	/**
	 * Return the value associated with the column: blood_group_value
	 */
	public java.lang.String getBloodGroupValue () {
		return bloodGroupValue;
	}

	/**
	 * Set the value related to the column: blood_group_value
	 * @param bloodGroupValue the blood_group_value value
	 */
	public void setBloodGroupValue (java.lang.String bloodGroupValue) {
		this.bloodGroupValue = bloodGroupValue;
	}



	/**
	 * Return the value associated with the column: confirmed_status
	 */
	public java.lang.String getConfirmedStatus () {
		return confirmedStatus;
	}

	/**
	 * Set the value related to the column: confirmed_status
	 * @param confirmedStatus the confirmed_status value
	 */
	public void setConfirmedStatus (java.lang.String confirmedStatus) {
		this.confirmedStatus = confirmedStatus;
	}



	/**
	 * Return the value associated with the column: verbal_status
	 */
	public java.lang.String getVerbalStatus () {
		return verbalStatus;
	}

	/**
	 * Set the value related to the column: verbal_status
	 * @param verbalStatus the verbal_status value
	 */
	public void setVerbalStatus (java.lang.String verbalStatus) {
		this.verbalStatus = verbalStatus;
	}



	/**
	 * Return the value associated with the column: bpl_number
	 */
	public java.lang.String getBplnumber () {
		return bplnumber;
	}

	/**
	 * Set the value related to the column: bpl_number
	 * @param bplnumber the bpl_number value
	 */
	public void setBplnumber (java.lang.String bplnumber) {
		this.bplnumber = bplnumber;
	}



	/**
	 * Return the value associated with the column: patient_old_name
	 */
	public java.lang.String getPatientOldName () {
		return patientOldName;
	}

	/**
	 * Set the value related to the column: patient_old_name
	 * @param patientOldName the patient_old_name value
	 */
	public void setPatientOldName (java.lang.String patientOldName) {
		this.patientOldName = patientOldName;
	}



	/**
	 * Return the value associated with the column: dob_other_card_id
	 */
	public jkt.hms.masters.business.MasIdCard getDobOtherCard () {
		return dobOtherCard;
	}

	/**
	 * Set the value related to the column: dob_other_card_id
	 * @param dobOtherCard the dob_other_card_id value
	 */
	public void setDobOtherCard (jkt.hms.masters.business.MasIdCard dobOtherCard) {
		this.dobOtherCard = dobOtherCard;
	}



	/**
	 * Return the value associated with the column: native_place_id
	 */
	public jkt.hms.masters.business.MasState getNativePlace () {
		return nativePlace;
	}

	/**
	 * Set the value related to the column: native_place_id
	 * @param nativePlace the native_place_id value
	 */
	public void setNativePlace (jkt.hms.masters.business.MasState nativePlace) {
		this.nativePlace = nativePlace;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasCompany getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasCompany company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: patient_category
	 */
	public jkt.hms.masters.business.MasPatientCategory getPatientCategory () {
		return patientCategory;
	}

	/**
	 * Set the value related to the column: patient_category
	 * @param patientCategory the patient_category value
	 */
	public void setPatientCategory (jkt.hms.masters.business.MasPatientCategory patientCategory) {
		this.patientCategory = patientCategory;
	}



	/**
	 * Return the value associated with the column: service_status_id
	 */
	public jkt.hms.masters.business.MasServiceStatus getServiceStatus () {
		return serviceStatus;
	}

	/**
	 * Set the value related to the column: service_status_id
	 * @param serviceStatus the service_status_id value
	 */
	public void setServiceStatus (jkt.hms.masters.business.MasServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}



	/**
	 * Return the value associated with the column: family_id
	 */
	public jkt.hms.masters.business.PhFamilySurvey getFamily () {
		return family;
	}

	/**
	 * Set the value related to the column: family_id
	 * @param family the family_id value
	 */
	public void setFamily (jkt.hms.masters.business.PhFamilySurvey family) {
		this.family = family;
	}



	/**
	 * Return the value associated with the column: marital_status_id
	 */
	public jkt.hms.masters.business.MasMaritalStatus getMaritalStatus () {
		return maritalStatus;
	}

	/**
	 * Set the value related to the column: marital_status_id
	 * @param maritalStatus the marital_status_id value
	 */
	public void setMaritalStatus (jkt.hms.masters.business.MasMaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	/**
	 * Return the value associated with the column: caste
	 */
	public jkt.hms.masters.business.MasCaste getCaste () {
		return caste;
	}

	/**
	 * Set the value related to the column: caste
	 * @param caste the caste value
	 */
	public void setCaste (jkt.hms.masters.business.MasCaste caste) {
		this.caste = caste;
	}



	/**
	 * Return the value associated with the column: next_of_kin_relation_id
	 */
	public jkt.hms.masters.business.MasRelation getNextOfKinRelation () {
		return nextOfKinRelation;
	}

	/**
	 * Set the value related to the column: next_of_kin_relation_id
	 * @param nextOfKinRelation the next_of_kin_relation_id value
	 */
	public void setNextOfKinRelation (jkt.hms.masters.business.MasRelation nextOfKinRelation) {
		this.nextOfKinRelation = nextOfKinRelation;
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
	 * Return the value associated with the column: id_card
	 */
	public jkt.hms.masters.business.MasIdCard getIdCard () {
		return idCard;
	}

	/**
	 * Set the value related to the column: id_card
	 * @param idCard the id_card value
	 */
	public void setIdCard (jkt.hms.masters.business.MasIdCard idCard) {
		this.idCard = idCard;
	}



	/**
	 * Return the value associated with the column: education
	 */
	public jkt.hrms.masters.business.MasQualification getEducation () {
		return education;
	}

	/**
	 * Set the value related to the column: education
	 * @param education the education value
	 */
	public void setEducation (jkt.hrms.masters.business.MasQualification education) {
		this.education = education;
	}



	/**
	 * Return the value associated with the column: reg_type
	 */
	public jkt.hms.masters.business.MasChargeCode getRegType () {
		return regType;
	}

	/**
	 * Set the value related to the column: reg_type
	 * @param regType the reg_type value
	 */
	public void setRegType (jkt.hms.masters.business.MasChargeCode regType) {
		this.regType = regType;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param state the state_id value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: patient_type_id
	 */
	public jkt.hms.masters.business.MasPatientType getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * @param patientType the patient_type_id value
	 */
	public void setPatientType (jkt.hms.masters.business.MasPatientType patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: religion_id
	 */
	public jkt.hms.masters.business.MasReligion getReligion () {
		return religion;
	}

	/**
	 * Set the value related to the column: religion_id
	 * @param religion the religion_id value
	 */
	public void setReligion (jkt.hms.masters.business.MasReligion religion) {
		this.religion = religion;
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
	 * Return the value associated with the column: visa_type
	 */
	public jkt.hms.masters.business.MasVisaType getVisaType () {
		return visaType;
	}

	/**
	 * Set the value related to the column: visa_type
	 * @param visaType the visa_type value
	 */
	public void setVisaType (jkt.hms.masters.business.MasVisaType visaType) {
		this.visaType = visaType;
	}



	/**
	 * Return the value associated with the column: occupation_id
	 */
	public jkt.hms.masters.business.MasOccupation getOccupation () {
		return occupation;
	}

	/**
	 * Set the value related to the column: occupation_id
	 * @param occupation the occupation_id value
	 */
	public void setOccupation (jkt.hms.masters.business.MasOccupation occupation) {
		this.occupation = occupation;
	}



	/**
	 * Return the value associated with the column: reference_id
	 */
	public jkt.hms.masters.business.MasReference getReference () {
		return reference;
	}

	/**
	 * Set the value related to the column: reference_id
	 * @param reference the reference_id value
	 */
	public void setReference (jkt.hms.masters.business.MasReference reference) {
		this.reference = reference;
	}



	/**
	 * Return the value associated with the column: emp_dependent_id
	 */
	public jkt.hms.masters.business.MasEmployeeDependent getEmpDependent () {
		return empDependent;
	}

	/**
	 * Set the value related to the column: emp_dependent_id
	 * @param empDependent the emp_dependent_id value
	 */
	public void setEmpDependent (jkt.hms.masters.business.MasEmployeeDependent empDependent) {
		this.empDependent = empDependent;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroup the blood_group_id value
	 */
	public void setBloodGroup (jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp () {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param emp the emp_id value
	 */
	public void setEmp (jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}



	/**
	 * Return the value associated with the column: country_id
	 */
	public jkt.hms.masters.business.MasCountry getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country_id
	 * @param country the country_id value
	 */
	public void setCountry (jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}



	/**
	 * Return the value associated with the column: tem_address_id_proof
	 */
	public jkt.hms.masters.business.MasIdCard getTemAddressIdProof () {
		return temAddressIdProof;
	}

	/**
	 * Set the value related to the column: tem_address_id_proof
	 * @param temAddressIdProof the tem_address_id_proof value
	 */
	public void setTemAddressIdProof (jkt.hms.masters.business.MasIdCard temAddressIdProof) {
		this.temAddressIdProof = temAddressIdProof;
	}



	/**
	 * Return the value associated with the column: ref_doctor
	 */
	public jkt.hms.masters.business.MasAuthorizer getRefDoctor () {
		return refDoctor;
	}

	/**
	 * Set the value related to the column: ref_doctor
	 * @param refDoctor the ref_doctor value
	 */
	public void setRefDoctor (jkt.hms.masters.business.MasAuthorizer refDoctor) {
		this.refDoctor = refDoctor;
	}



	/**
	 * Return the value associated with the column: member_id
	 */
	public jkt.hms.masters.business.PhMemberSurvey getMember () {
		return member;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param member the member_id value
	 */
	public void setMember (jkt.hms.masters.business.PhMemberSurvey member) {
		this.member = member;
	}



	/**
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType () {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceType the service_type_id value
	 */
	public void setServiceType (jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
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
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sex the sex_id value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
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
	 * Return the value associated with the column: OpdCardiologyDepartmentDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> getOpdCardiologyDepartmentDetails () {
		return opdCardiologyDepartmentDetails;
	}

	/**
	 * Set the value related to the column: OpdCardiologyDepartmentDetails
	 * @param opdCardiologyDepartmentDetails the OpdCardiologyDepartmentDetails value
	 */
	public void setOpdCardiologyDepartmentDetails (java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails) {
		this.opdCardiologyDepartmentDetails = opdCardiologyDepartmentDetails;
	}

	public void addToOpdCardiologyDepartmentDetails (jkt.hms.masters.business.OpdCardiologyDepartmentDetails opdCardiologyDepartmentDetails) {
		if (null == getOpdCardiologyDepartmentDetails()) setOpdCardiologyDepartmentDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdCardiologyDepartmentDetails>());
		getOpdCardiologyDepartmentDetails().add(opdCardiologyDepartmentDetails);
	}



	/**
	 * Return the value associated with the column: IpdIntakeOutputs
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> getIpdIntakeOutputs () {
		return ipdIntakeOutputs;
	}

	/**
	 * Set the value related to the column: IpdIntakeOutputs
	 * @param ipdIntakeOutputs the IpdIntakeOutputs value
	 */
	public void setIpdIntakeOutputs (java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs) {
		this.ipdIntakeOutputs = ipdIntakeOutputs;
	}

	public void addToIpdIntakeOutputs (jkt.hms.masters.business.IpdIntakeOutput ipdIntakeOutput) {
		if (null == getIpdIntakeOutputs()) setIpdIntakeOutputs(new java.util.TreeSet<jkt.hms.masters.business.IpdIntakeOutput>());
		getIpdIntakeOutputs().add(ipdIntakeOutput);
	}



	/**
	 * Return the value associated with the column: OpdOphRetinalHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> getOpdOphRetinalHeaders () {
		return opdOphRetinalHeaders;
	}

	/**
	 * Set the value related to the column: OpdOphRetinalHeaders
	 * @param opdOphRetinalHeaders the OpdOphRetinalHeaders value
	 */
	public void setOpdOphRetinalHeaders (java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> opdOphRetinalHeaders) {
		this.opdOphRetinalHeaders = opdOphRetinalHeaders;
	}

	public void addToOpdOphRetinalHeaders (jkt.hms.masters.business.OpdOphRetinalHeader opdOphRetinalHeader) {
		if (null == getOpdOphRetinalHeaders()) setOpdOphRetinalHeaders(new java.util.TreeSet<jkt.hms.masters.business.OpdOphRetinalHeader>());
		getOpdOphRetinalHeaders().add(opdOphRetinalHeader);
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
	 * Return the value associated with the column: DischargeSummaries
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeSummary> getDischargeSummaries () {
		return dischargeSummaries;
	}

	/**
	 * Set the value related to the column: DischargeSummaries
	 * @param dischargeSummaries the DischargeSummaries value
	 */
	public void setDischargeSummaries (java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries) {
		this.dischargeSummaries = dischargeSummaries;
	}

	public void addToDischargeSummaries (jkt.hms.masters.business.DischargeSummary dischargeSummary) {
		if (null == getDischargeSummaries()) setDischargeSummaries(new java.util.TreeSet<jkt.hms.masters.business.DischargeSummary>());
		getDischargeSummaries().add(dischargeSummary);
	}



	/**
	 * Return the value associated with the column: OpdOphDiagnosisHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> getOpdOphDiagnosisHeaders () {
		return opdOphDiagnosisHeaders;
	}

	/**
	 * Set the value related to the column: OpdOphDiagnosisHeaders
	 * @param opdOphDiagnosisHeaders the OpdOphDiagnosisHeaders value
	 */
	public void setOpdOphDiagnosisHeaders (java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> opdOphDiagnosisHeaders) {
		this.opdOphDiagnosisHeaders = opdOphDiagnosisHeaders;
	}

	public void addToOpdOphDiagnosisHeaders (jkt.hms.masters.business.OpdOphDiagnosisHeader opdOphDiagnosisHeader) {
		if (null == getOpdOphDiagnosisHeaders()) setOpdOphDiagnosisHeaders(new java.util.TreeSet<jkt.hms.masters.business.OpdOphDiagnosisHeader>());
		getOpdOphDiagnosisHeaders().add(opdOphDiagnosisHeader);
	}



	/**
	 * Return the value associated with the column: DiagnosticsOrderHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DiagnosticsOrderHeader> getDiagnosticsOrderHeaders () {
		return diagnosticsOrderHeaders;
	}

	/**
	 * Set the value related to the column: DiagnosticsOrderHeaders
	 * @param diagnosticsOrderHeaders the DiagnosticsOrderHeaders value
	 */
	public void setDiagnosticsOrderHeaders (java.util.Set<jkt.hms.masters.business.DiagnosticsOrderHeader> diagnosticsOrderHeaders) {
		this.diagnosticsOrderHeaders = diagnosticsOrderHeaders;
	}

	public void addToDiagnosticsOrderHeaders (jkt.hms.masters.business.DiagnosticsOrderHeader diagnosticsOrderHeader) {
		if (null == getDiagnosticsOrderHeaders()) setDiagnosticsOrderHeaders(new java.util.TreeSet<jkt.hms.masters.business.DiagnosticsOrderHeader>());
		getDiagnosticsOrderHeaders().add(diagnosticsOrderHeader);
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
	 * Return the value associated with the column: MisFrws
	 */
	public java.util.Set<jkt.hms.masters.business.MisFrw> getMisFrws () {
		return misFrws;
	}

	/**
	 * Set the value related to the column: MisFrws
	 * @param misFrws the MisFrws value
	 */
	public void setMisFrws (java.util.Set<jkt.hms.masters.business.MisFrw> misFrws) {
		this.misFrws = misFrws;
	}

	public void addToMisFrws (jkt.hms.masters.business.MisFrw misFrw) {
		if (null == getMisFrws()) setMisFrws(new java.util.TreeSet<jkt.hms.masters.business.MisFrw>());
		getMisFrws().add(misFrw);
	}



	/**
	 * Return the value associated with the column: StoreIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMs () {
		return storeIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIssueMs
	 * @param storeIssueMs the StoreIssueMs value
	 */
	public void setStoreIssueMs (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs) {
		this.storeIssueMs = storeIssueMs;
	}

	public void addToStoreIssueMs (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMs()) setStoreIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMs().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: Ipdcaredetails
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdcaredetail> getIpdcaredetails () {
		return ipdcaredetails;
	}

	/**
	 * Set the value related to the column: Ipdcaredetails
	 * @param ipdcaredetails the Ipdcaredetails value
	 */
	public void setIpdcaredetails (java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails) {
		this.ipdcaredetails = ipdcaredetails;
	}

	public void addToIpdcaredetails (jkt.hms.masters.business.Ipdcaredetail ipdcaredetail) {
		if (null == getIpdcaredetails()) setIpdcaredetails(new java.util.TreeSet<jkt.hms.masters.business.Ipdcaredetail>());
		getIpdcaredetails().add(ipdcaredetail);
	}



	/**
	 * Return the value associated with the column: AppPatientAppointments
	 */
	public java.util.Set<jkt.hms.masters.business.AppPatientAppointments> getAppPatientAppointments () {
		return appPatientAppointments;
	}

	/**
	 * Set the value related to the column: AppPatientAppointments
	 * @param appPatientAppointments the AppPatientAppointments value
	 */
	public void setAppPatientAppointments (java.util.Set<jkt.hms.masters.business.AppPatientAppointments> appPatientAppointments) {
		this.appPatientAppointments = appPatientAppointments;
	}

	public void addToAppPatientAppointments (jkt.hms.masters.business.AppPatientAppointments appPatientAppointments) {
		if (null == getAppPatientAppointments()) setAppPatientAppointments(new java.util.TreeSet<jkt.hms.masters.business.AppPatientAppointments>());
		getAppPatientAppointments().add(appPatientAppointments);
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
	 * Return the value associated with the column: AppInvestigationAppointments
	 */
	public java.util.Set<jkt.hms.masters.business.AppInvestigationAppointments> getAppInvestigationAppointments () {
		return appInvestigationAppointments;
	}

	/**
	 * Set the value related to the column: AppInvestigationAppointments
	 * @param appInvestigationAppointments the AppInvestigationAppointments value
	 */
	public void setAppInvestigationAppointments (java.util.Set<jkt.hms.masters.business.AppInvestigationAppointments> appInvestigationAppointments) {
		this.appInvestigationAppointments = appInvestigationAppointments;
	}

	public void addToAppInvestigationAppointments (jkt.hms.masters.business.AppInvestigationAppointments appInvestigationAppointments) {
		if (null == getAppInvestigationAppointments()) setAppInvestigationAppointments(new java.util.TreeSet<jkt.hms.masters.business.AppInvestigationAppointments>());
		getAppInvestigationAppointments().add(appInvestigationAppointments);
	}



	/**
	 * Return the value associated with the column: BlVoucherDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlVoucherDetails> getBlVoucherDetails () {
		return blVoucherDetails;
	}

	/**
	 * Set the value related to the column: BlVoucherDetails
	 * @param blVoucherDetails the BlVoucherDetails value
	 */
	public void setBlVoucherDetails (java.util.Set<jkt.hms.masters.business.BlVoucherDetails> blVoucherDetails) {
		this.blVoucherDetails = blVoucherDetails;
	}

	public void addToBlVoucherDetails (jkt.hms.masters.business.BlVoucherDetails blVoucherDetails) {
		if (null == getBlVoucherDetails()) setBlVoucherDetails(new java.util.TreeSet<jkt.hms.masters.business.BlVoucherDetails>());
		getBlVoucherDetails().add(blVoucherDetails);
	}



	/**
	 * Return the value associated with the column: OpdPatientHistories
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientHistory> getOpdPatientHistories () {
		return opdPatientHistories;
	}

	/**
	 * Set the value related to the column: OpdPatientHistories
	 * @param opdPatientHistories the OpdPatientHistories value
	 */
	public void setOpdPatientHistories (java.util.Set<jkt.hms.masters.business.OpdPatientHistory> opdPatientHistories) {
		this.opdPatientHistories = opdPatientHistories;
	}

	public void addToOpdPatientHistories (jkt.hms.masters.business.OpdPatientHistory opdPatientHistory) {
		if (null == getOpdPatientHistories()) setOpdPatientHistories(new java.util.TreeSet<jkt.hms.masters.business.OpdPatientHistory>());
		getOpdPatientHistories().add(opdPatientHistory);
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
	 * Return the value associated with the column: OpdVaccinationPlans
	 */
	public java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> getOpdVaccinationPlans () {
		return opdVaccinationPlans;
	}

	/**
	 * Set the value related to the column: OpdVaccinationPlans
	 * @param opdVaccinationPlans the OpdVaccinationPlans value
	 */
	public void setOpdVaccinationPlans (java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans) {
		this.opdVaccinationPlans = opdVaccinationPlans;
	}

	public void addToOpdVaccinationPlans (jkt.hms.masters.business.OpdVaccinationPlan opdVaccinationPlan) {
		if (null == getOpdVaccinationPlans()) setOpdVaccinationPlans(new java.util.TreeSet<jkt.hms.masters.business.OpdVaccinationPlan>());
		getOpdVaccinationPlans().add(opdVaccinationPlan);
	}



	/**
	 * Return the value associated with the column: PatientInvestigationHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> getPatientInvestigationHeaders () {
		return patientInvestigationHeaders;
	}

	/**
	 * Set the value related to the column: PatientInvestigationHeaders
	 * @param patientInvestigationHeaders the PatientInvestigationHeaders value
	 */
	public void setPatientInvestigationHeaders (java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders) {
		this.patientInvestigationHeaders = patientInvestigationHeaders;
	}

	public void addToPatientInvestigationHeaders (jkt.hms.masters.business.PatientInvestigationHeader patientInvestigationHeader) {
		if (null == getPatientInvestigationHeaders()) setPatientInvestigationHeaders(new java.util.TreeSet<jkt.hms.masters.business.PatientInvestigationHeader>());
		getPatientInvestigationHeaders().add(patientInvestigationHeader);
	}



	/**
	 * Return the value associated with the column: OpdCaseSheets
	 */
	public java.util.Set<jkt.hms.masters.business.OpdCaseSheet> getOpdCaseSheets () {
		return opdCaseSheets;
	}

	/**
	 * Set the value related to the column: OpdCaseSheets
	 * @param opdCaseSheets the OpdCaseSheets value
	 */
	public void setOpdCaseSheets (java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets) {
		this.opdCaseSheets = opdCaseSheets;
	}

	public void addToOpdCaseSheets (jkt.hms.masters.business.OpdCaseSheet opdCaseSheet) {
		if (null == getOpdCaseSheets()) setOpdCaseSheets(new java.util.TreeSet<jkt.hms.masters.business.OpdCaseSheet>());
		getOpdCaseSheets().add(opdCaseSheet);
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
	 * Return the value associated with the column: OpdOphthalmologies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphthalmology> getOpdOphthalmologies () {
		return opdOphthalmologies;
	}

	/**
	 * Set the value related to the column: OpdOphthalmologies
	 * @param opdOphthalmologies the OpdOphthalmologies value
	 */
	public void setOpdOphthalmologies (java.util.Set<jkt.hms.masters.business.OpdOphthalmology> opdOphthalmologies) {
		this.opdOphthalmologies = opdOphthalmologies;
	}

	public void addToOpdOphthalmologies (jkt.hms.masters.business.OpdOphthalmology opdOphthalmology) {
		if (null == getOpdOphthalmologies()) setOpdOphthalmologies(new java.util.TreeSet<jkt.hms.masters.business.OpdOphthalmology>());
		getOpdOphthalmologies().add(opdOphthalmology);
	}



	/**
	 * Return the value associated with the column: StoreIpIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIpIssueM> getStoreIpIssueMs () {
		return storeIpIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIpIssueMs
	 * @param storeIpIssueMs the StoreIpIssueMs value
	 */
	public void setStoreIpIssueMs (java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs) {
		this.storeIpIssueMs = storeIpIssueMs;
	}

	public void addToStoreIpIssueMs (jkt.hms.masters.business.StoreIpIssueM storeIpIssueM) {
		if (null == getStoreIpIssueMs()) setStoreIpIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIpIssueM>());
		getStoreIpIssueMs().add(storeIpIssueM);
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
	 * Return the value associated with the column: StoreOpPatientIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> getStoreOpPatientIssueMs () {
		return storeOpPatientIssueMs;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueMs
	 * @param storeOpPatientIssueMs the StoreOpPatientIssueMs value
	 */
	public void setStoreOpPatientIssueMs (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs) {
		this.storeOpPatientIssueMs = storeOpPatientIssueMs;
	}

	public void addToStoreOpPatientIssueMs (jkt.hms.masters.business.StoreOpPatientIssueM storeOpPatientIssueM) {
		if (null == getStoreOpPatientIssueMs()) setStoreOpPatientIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueM>());
		getStoreOpPatientIssueMs().add(storeOpPatientIssueM);
	}



	/**
	 * Return the value associated with the column: OpdObgs
	 */
	public java.util.Set<jkt.hms.masters.business.OpdObg> getOpdObgs () {
		return opdObgs;
	}

	/**
	 * Set the value related to the column: OpdObgs
	 * @param opdObgs the OpdObgs value
	 */
	public void setOpdObgs (java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs) {
		this.opdObgs = opdObgs;
	}

	public void addToOpdObgs (jkt.hms.masters.business.OpdObg opdObg) {
		if (null == getOpdObgs()) setOpdObgs(new java.util.TreeSet<jkt.hms.masters.business.OpdObg>());
		getOpdObgs().add(opdObg);
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
	 * Return the value associated with the column: IpdIntakeOutputCharts
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> getIpdIntakeOutputCharts () {
		return ipdIntakeOutputCharts;
	}

	/**
	 * Set the value related to the column: IpdIntakeOutputCharts
	 * @param ipdIntakeOutputCharts the IpdIntakeOutputCharts value
	 */
	public void setIpdIntakeOutputCharts (java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts) {
		this.ipdIntakeOutputCharts = ipdIntakeOutputCharts;
	}

	public void addToIpdIntakeOutputCharts (jkt.hms.masters.business.IpdIntakeOutputChart ipdIntakeOutputChart) {
		if (null == getIpdIntakeOutputCharts()) setIpdIntakeOutputCharts(new java.util.TreeSet<jkt.hms.masters.business.IpdIntakeOutputChart>());
		getIpdIntakeOutputCharts().add(ipdIntakeOutputChart);
	}



	/**
	 * Return the value associated with the column: IpdClinicalCharts
	 */
	public java.util.Set<jkt.hms.masters.business.IpdClinicalChart> getIpdClinicalCharts () {
		return ipdClinicalCharts;
	}

	/**
	 * Set the value related to the column: IpdClinicalCharts
	 * @param ipdClinicalCharts the IpdClinicalCharts value
	 */
	public void setIpdClinicalCharts (java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts) {
		this.ipdClinicalCharts = ipdClinicalCharts;
	}

	public void addToIpdClinicalCharts (jkt.hms.masters.business.IpdClinicalChart ipdClinicalChart) {
		if (null == getIpdClinicalCharts()) setIpdClinicalCharts(new java.util.TreeSet<jkt.hms.masters.business.IpdClinicalChart>());
		getIpdClinicalCharts().add(ipdClinicalChart);
	}



	/**
	 * Return the value associated with the column: OpdEnts
	 */
	public java.util.Set<jkt.hms.masters.business.OpdEnt> getOpdEnts () {
		return opdEnts;
	}

	/**
	 * Set the value related to the column: OpdEnts
	 * @param opdEnts the OpdEnts value
	 */
	public void setOpdEnts (java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts) {
		this.opdEnts = opdEnts;
	}

	public void addToOpdEnts (jkt.hms.masters.business.OpdEnt opdEnt) {
		if (null == getOpdEnts()) setOpdEnts(new java.util.TreeSet<jkt.hms.masters.business.OpdEnt>());
		getOpdEnts().add(opdEnt);
	}



	/**
	 * Return the value associated with the column: Ipdclinicals
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdclinical> getIpdclinicals () {
		return ipdclinicals;
	}

	/**
	 * Set the value related to the column: Ipdclinicals
	 * @param ipdclinicals the Ipdclinicals value
	 */
	public void setIpdclinicals (java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals) {
		this.ipdclinicals = ipdclinicals;
	}

	public void addToIpdclinicals (jkt.hms.masters.business.Ipdclinical ipdclinical) {
		if (null == getIpdclinicals()) setIpdclinicals(new java.util.TreeSet<jkt.hms.masters.business.Ipdclinical>());
		getIpdclinicals().add(ipdclinical);
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
	 * Return the value associated with the column: PatientAllergicDrugsHds
	 */
	public java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> getPatientAllergicDrugsHds () {
		return patientAllergicDrugsHds;
	}

	/**
	 * Set the value related to the column: PatientAllergicDrugsHds
	 * @param patientAllergicDrugsHds the PatientAllergicDrugsHds value
	 */
	public void setPatientAllergicDrugsHds (java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds) {
		this.patientAllergicDrugsHds = patientAllergicDrugsHds;
	}

	public void addToPatientAllergicDrugsHds (jkt.hms.masters.business.PatientAllergicDrugsHd patientAllergicDrugsHd) {
		if (null == getPatientAllergicDrugsHds()) setPatientAllergicDrugsHds(new java.util.TreeSet<jkt.hms.masters.business.PatientAllergicDrugsHd>());
		getPatientAllergicDrugsHds().add(patientAllergicDrugsHd);
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
	 * Return the value associated with the column: PatientPrescriptionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> getPatientPrescriptionHeaders () {
		return patientPrescriptionHeaders;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionHeaders
	 * @param patientPrescriptionHeaders the PatientPrescriptionHeaders value
	 */
	public void setPatientPrescriptionHeaders (java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders) {
		this.patientPrescriptionHeaders = patientPrescriptionHeaders;
	}

	public void addToPatientPrescriptionHeaders (jkt.hms.masters.business.PatientPrescriptionHeader patientPrescriptionHeader) {
		if (null == getPatientPrescriptionHeaders()) setPatientPrescriptionHeaders(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionHeader>());
		getPatientPrescriptionHeaders().add(patientPrescriptionHeader);
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
	 * Return the value associated with the column: OpdOphFollowUps
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> getOpdOphFollowUps () {
		return opdOphFollowUps;
	}

	/**
	 * Set the value related to the column: OpdOphFollowUps
	 * @param opdOphFollowUps the OpdOphFollowUps value
	 */
	public void setOpdOphFollowUps (java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> opdOphFollowUps) {
		this.opdOphFollowUps = opdOphFollowUps;
	}

	public void addToOpdOphFollowUps (jkt.hms.masters.business.OpdOphFollowUp opdOphFollowUp) {
		if (null == getOpdOphFollowUps()) setOpdOphFollowUps(new java.util.TreeSet<jkt.hms.masters.business.OpdOphFollowUp>());
		getOpdOphFollowUps().add(opdOphFollowUp);
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
	 * Return the value associated with the column: OpdGastroEnterologyEndoscopys
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> getOpdGastroEnterologyEndoscopys () {
		return opdGastroEnterologyEndoscopys;
	}

	/**
	 * Set the value related to the column: OpdGastroEnterologyEndoscopys
	 * @param opdGastroEnterologyEndoscopys the OpdGastroEnterologyEndoscopys value
	 */
	public void setOpdGastroEnterologyEndoscopys (java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopys) {
		this.opdGastroEnterologyEndoscopys = opdGastroEnterologyEndoscopys;
	}

	public void addToOpdGastroEnterologyEndoscopys (jkt.hms.masters.business.OpdGastroEnterologyEndoscopy opdGastroEnterologyEndoscopy) {
		if (null == getOpdGastroEnterologyEndoscopys()) setOpdGastroEnterologyEndoscopys(new java.util.TreeSet<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy>());
		getOpdGastroEnterologyEndoscopys().add(opdGastroEnterologyEndoscopy);
	}



	/**
	 * Return the value associated with the column: OpdGastroEnterologyColonoscopys
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> getOpdGastroEnterologyColonoscopys () {
		return opdGastroEnterologyColonoscopys;
	}

	/**
	 * Set the value related to the column: OpdGastroEnterologyColonoscopys
	 * @param opdGastroEnterologyColonoscopys the OpdGastroEnterologyColonoscopys value
	 */
	public void setOpdGastroEnterologyColonoscopys (java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopys) {
		this.opdGastroEnterologyColonoscopys = opdGastroEnterologyColonoscopys;
	}

	public void addToOpdGastroEnterologyColonoscopys (jkt.hms.masters.business.OpdGastroEnterologyColonoscopy opdGastroEnterologyColonoscopy) {
		if (null == getOpdGastroEnterologyColonoscopys()) setOpdGastroEnterologyColonoscopys(new java.util.TreeSet<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy>());
		getOpdGastroEnterologyColonoscopys().add(opdGastroEnterologyColonoscopy);
	}



	/**
	 * Return the value associated with the column: OpdAntenatalCards
	 */
	public java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> getOpdAntenatalCards () {
		return opdAntenatalCards;
	}

	/**
	 * Set the value related to the column: OpdAntenatalCards
	 * @param opdAntenatalCards the OpdAntenatalCards value
	 */
	public void setOpdAntenatalCards (java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards) {
		this.opdAntenatalCards = opdAntenatalCards;
	}

	public void addToOpdAntenatalCards (jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard) {
		if (null == getOpdAntenatalCards()) setOpdAntenatalCards(new java.util.TreeSet<jkt.hms.masters.business.OpdAntenatalCard>());
		getOpdAntenatalCards().add(opdAntenatalCard);
	}



	/**
	 * Return the value associated with the column: OpdGravidagramHtns
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> getOpdGravidagramHtns () {
		return opdGravidagramHtns;
	}

	/**
	 * Set the value related to the column: OpdGravidagramHtns
	 * @param opdGravidagramHtns the OpdGravidagramHtns value
	 */
	public void setOpdGravidagramHtns (java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns) {
		this.opdGravidagramHtns = opdGravidagramHtns;
	}

	public void addToOpdGravidagramHtns (jkt.hms.masters.business.OpdGravidagramHtn opdGravidagramHtn) {
		if (null == getOpdGravidagramHtns()) setOpdGravidagramHtns(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramHtn>());
		getOpdGravidagramHtns().add(opdGravidagramHtn);
	}



	/**
	 * Return the value associated with the column: OpdGravidagramGestationalDiabitiesOnes
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> getOpdGravidagramGestationalDiabitiesOnes () {
		return opdGravidagramGestationalDiabitiesOnes;
	}

	/**
	 * Set the value related to the column: OpdGravidagramGestationalDiabitiesOnes
	 * @param opdGravidagramGestationalDiabitiesOnes the OpdGravidagramGestationalDiabitiesOnes value
	 */
	public void setOpdGravidagramGestationalDiabitiesOnes (java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes) {
		this.opdGravidagramGestationalDiabitiesOnes = opdGravidagramGestationalDiabitiesOnes;
	}

	public void addToOpdGravidagramGestationalDiabitiesOnes (jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne opdGravidagramGestationalDiabitiesOne) {
		if (null == getOpdGravidagramGestationalDiabitiesOnes()) setOpdGravidagramGestationalDiabitiesOnes(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne>());
		getOpdGravidagramGestationalDiabitiesOnes().add(opdGravidagramGestationalDiabitiesOne);
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
	 * Return the value associated with the column: PatientCategoryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientCategoryDetails> getPatientCategoryDetails () {
		return patientCategoryDetails;
	}

	/**
	 * Set the value related to the column: PatientCategoryDetails
	 * @param patientCategoryDetails the PatientCategoryDetails value
	 */
	public void setPatientCategoryDetails (java.util.Set<jkt.hms.masters.business.PatientCategoryDetails> patientCategoryDetails) {
		this.patientCategoryDetails = patientCategoryDetails;
	}

	public void addToPatientCategoryDetails (jkt.hms.masters.business.PatientCategoryDetails patientCategoryDetails) {
		if (null == getPatientCategoryDetails()) setPatientCategoryDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientCategoryDetails>());
		getPatientCategoryDetails().add(patientCategoryDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Patient)) return false;
		else {
			jkt.hms.masters.business.Patient patient = (jkt.hms.masters.business.Patient) obj;
			if (null == this.getId() || null == patient.getId()) return false;
			else return (this.getId().equals(patient.getId()));
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