package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_hospital table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_hospital"
 */

public abstract class BaseMasHospital  implements Serializable {

	public static String REF = "MasHospital";
	public static String PROP_CONTACT_PERSON_DESIG = "ContactPersonDesig";
	public static String PROP_ADD2_STREET = "Add2Street";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CONTACT_PERSON_NAME = "ContactPersonName";
	public static String PROP_IMERGENCY_NUMBER = "ImergencyNumber";
	public static String PROP_REGISTRATION_YEAR = "RegistrationYear";
	public static String PROP_DY_SUPERINTENDENT = "DySuperintendent";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_POST_OFFICE = "PostOffice";
	public static String PROP_BLOOD_BANK = "BloodBank";
	public static String PROP_CONTACT_NUMBER = "ContactNumber";
	public static String PROP_HOSPITAL_TYPE = "HospitalType";
	public static String PROP_ADD3_LOCALITY = "Add3Locality";
	public static String PROP_HOSPITAL_TYPE_CHANGE_COUNT = "HospitalTypeChangeCount";
	public static String PROP_LAYOUT_MAP = "LayoutMap";
	public static String PROP_LSG_NAME = "LsgName";
	public static String PROP_DISTRICT = "District";
	public static String PROP_SHORT_NAME = "ShortName";
	public static String PROP_ID = "Id";
	public static String PROP_LONGITUDE = "Longitude";
	public static String PROP_LEVEL_THREE_EMPLOYEE = "LevelThreeEmployee";
	public static String PROP_CLOSING_TIME = "ClosingTime";
	public static String PROP_HOW_TO_REACH = "HowToReach";
	public static String PROP_LEVEL_ONE_DESINATION = "LevelOneDesination";
	public static String PROP_LSG_TYPE = "LsgType";
	public static String PROP_KMSCL_CATEGORY = "KmsclCategory";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_PRO = "Pro";
	public static String PROP_WARD = "Ward";
	public static String PROP_BB_AVAILABLE = "BbAvailable";
	public static String PROP_HOSPITAL_NAME_CHANGE_COUNT = "HospitalNameChangeCount";
	public static String PROP_LEVEL_FOUR_DESINATION = "LevelFourDesination";
	public static String PROP_PARLIAMENT = "Parliament";
	public static String PROP_KMSCL_INSTITUTE_CODE = "KmsclInstituteCode";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_LEVEL_TWO_DESINATION = "LevelTwoDesination";
	public static String PROP_FORMATION = "Formation";
	public static String PROP_OPENING_TIME = "OpeningTime";
	public static String PROP_ELECTRICAL_SECTION = "ElectricalSection";
	public static String PROP_LEVEL_ONE_EMPLOYEE = "LevelOneEmployee";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LEVEL_THREE_DESINATION = "LevelThreeDesination";
	public static String PROP_BB_WEEKLY_OFF = "BbWeeklyOff";
	public static String PROP_LATITUDE = "Latitude";
	public static String PROP_HOSPITAL_CODE = "HospitalCode";
	public static String PROP_PARENT_INSTITUTE = "ParentInstitute";
	public static String PROP_JURISDICTION_MAP = "JurisdictionMap";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_TALUK = "Taluk";
	public static String PROP_CONTACT_PERSON_MOBILE = "ContactPersonMobile";
	public static String PROP_ASSEMBLY = "Assembly";
	public static String PROP_BB_REGISTRATION_NUMBER = "BbRegistrationNumber";
	public static String PROP_LEVEL_FOUR_EMPLOYEE = "LevelFourEmployee";
	public static String PROP_SPARK_ID = "SparkId";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_HOD = "Hod";
	public static String PROP_RMO = "Rmo";
	public static String PROP_AUTH_LEVEL = "AuthLevel";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_LEVEL_TWO_EMPLOYEE = "LevelTwoEmployee";
	public static String PROP_SANCTION_BED = "SanctionBed";
	public static String PROP_ABOUT_HOSPITAL = "AboutHospital";
	public static String PROP_SUPERINTENDENT = "Superintendent";


	// constructors
	public BaseMasHospital () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasHospital (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasHospital (
		java.lang.Integer id,
		java.lang.String status,
		java.lang.String contactNumber) {

		this.setId(id);
		this.setStatus(status);
		this.setContactNumber(contactNumber);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String hospitalCode;
	private java.lang.String hospitalName;
	private java.lang.String status;
	private java.lang.String address;
	private java.lang.String contactNumber;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String imergencyNumber;
	private java.lang.String sparkId;
	private java.lang.String shortName;
	private java.lang.Integer hospitalNameChangeCount;
	private java.lang.Integer hospitalTypeChangeCount;
	private java.lang.String add2Street;
	private java.lang.String lsgType;
	private java.lang.String lsgName;
	private java.lang.Integer pinCode;
	private java.lang.String longitude;
	private java.lang.String latitude;
	private java.lang.String emailId;
	private java.lang.String contactPersonName;
	private java.lang.String contactPersonDesig;
	private java.lang.String contactPersonMobile;
	private java.lang.Integer sanctionBed;
	private java.lang.String bloodBank;
	private java.lang.String openingTime;
	private java.lang.String registrationYear;
	private java.lang.String closingTime;
	private java.lang.String bbAvailable;
	private java.lang.String formation;
	private java.lang.String aboutHospital;
	private java.lang.String howToReach;
	private java.lang.String jurisdictionMap;
	private java.lang.String layoutMap;
	private java.lang.Long superintendent;
	private java.lang.Long dySuperintendent;
	private java.lang.String rmo;
	private java.lang.String pro;
	private java.lang.String bbRegistrationNumber;
	private java.lang.String bbWeeklyOff;
	private java.lang.String kmsclInstituteCode;
	private java.lang.String kmsclCategory;
	private java.lang.String levelOneDesination;
	private java.lang.String levelTwoDesination;
	private java.lang.String levelThreeDesination;
	private java.lang.String levelFourDesination;
	private java.lang.Integer authLevel;

	// many to one
	private jkt.hms.masters.business.PhMasParliyamentAssembly parliament;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasVillage village;
	private jkt.hms.masters.business.MasHospital parentInstitute;
	private jkt.hms.masters.business.MasPostCode postOffice;
	private jkt.hms.masters.business.PhMasParliyamentAssembly assembly;
	private jkt.hms.masters.business.PhMasElectricalSection electricalSection;
	private jkt.hms.masters.business.MasTaluk taluk;
	private jkt.hms.masters.business.MasHospitalType hospitalType;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasWard ward;
	private jkt.hms.masters.business.PhMasLocality add3Locality;
	private jkt.hms.masters.business.MasEmployee hod;
	private jkt.hms.masters.business.MasEmployee levelOneEmployee;
	private jkt.hms.masters.business.MasEmployee levelTwoEmployee;
	private jkt.hms.masters.business.MasEmployee levelThreeEmployee;
	private jkt.hms.masters.business.MasEmployee levelFourEmployee;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.OpdCardiologyDepartmentDetails> opdCardiologyDepartmentDetails;
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoos;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs;
	private java.util.Set<jkt.hms.masters.business.OpdOphRetinalHeader> opdOphRetinalHeaders;
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipMain> blChargeSlipMains;
	private java.util.Set<jkt.hms.masters.business.UserStatusHospital> userStatusHospitals;
	private java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers;
	private java.util.Set<jkt.hms.masters.business.StoreTenderProposal> storeTenderProposals;
	private java.util.Set<jkt.hms.masters.business.StoreBalanceM> storeBalanceMs;
	private java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries;
	private java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisHeader> opdOphDiagnosisHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdInstructionTreatment> opdInstructionTreatments;
	private java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs;
	private java.util.Set<jkt.hms.masters.business.UsergroupHospital> usergroupHospitals;
	private java.util.Set<jkt.hms.masters.business.StoreStockTakingM> storeStockTakingMs;
	private java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs;
	private java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals;
	private java.util.Set<jkt.hms.masters.business.StoreCondemnationM> storeCondemnationMs;
	private java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails;
	private java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments;
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;
	private java.util.Set<jkt.hms.masters.business.AppPatientAppointments> appPatientAppointments;
	private java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMs;
	private java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles;
	private java.util.Set<jkt.hms.masters.business.BlDepositHeader> blDepositHeaders;
	private java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> storeMmfDepartmentMs;
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;
	private java.util.Set<jkt.hms.masters.business.AppInvestigationAppointments> appInvestigationAppointments;
	private java.util.Set<jkt.hms.masters.business.BlVoucherDetails> blVoucherDetails;
	private java.util.Set<jkt.hms.masters.business.BlRefundDetails> blRefundDetails;
	private java.util.Set<jkt.hms.masters.business.OpdPatientHistory> opdPatientHistories;
	private java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs;
	private java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMs;
	private java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans;
	private java.util.Set<jkt.hms.masters.business.BlVoucherHeader> blVoucherHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdHoliday> opdHolidaies;
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> blChargeSlipDetails;
	private java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> storeWorkOrderMs;
	private java.util.Set<jkt.hms.masters.business.DietExtraItemFormula> dietExtraItemFormulas;
	private java.util.Set<jkt.hms.masters.business.PatientInvestigationHeader> patientInvestigationHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdCaseSheet> opdCaseSheets;
	private java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets;
	private java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails;
	private java.util.Set<jkt.hms.masters.business.StoreBosM> storeBosMs;
	private java.util.Set<jkt.hms.masters.business.BlPatientLedger> blPatientLedgers;
	private java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMs;
	private java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> appInvestigationSetups;
	private java.util.Set<jkt.hms.masters.business.AppEquipmentMaster> appEquipmentMasters;
	private java.util.Set<jkt.hms.masters.business.StoreQuaterReturnM> storeQuaterReturnMs;
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs;
	private java.util.Set<jkt.hms.masters.business.BlDepositDetails> blDepositDetails;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs;
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> storeDefectiveDrugMs;
	private java.util.Set<jkt.hms.masters.business.OpdPatientDetails> opdPatientDetails;
	private java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> usergroupAccessrightsHospitals;
	private java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> storeRepairCivilFirms;
	private java.util.Set<jkt.hms.masters.business.OpdObg> opdObgs;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts;
	private java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts;
	private java.util.Set<jkt.hms.masters.business.MasAccount> masAccounts;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.OpdEnt> opdEnts;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals;
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMs;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.PatientAllergicDrugsHd> patientAllergicDrugsHds;
	private java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> storeTenderTechnicalBidMs;
	private java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings;
	private java.util.Set<jkt.hms.masters.business.BlRefundHeader> blRefundHeaders;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs;
	private java.util.Set<jkt.hms.masters.business.StoreDisposalM> storeDisposalMs;
	private java.util.Set<jkt.hms.masters.business.StoreTenderM> storeTenderMs;
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdOphFollowUp> opdOphFollowUps;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfers;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.AppSetup> appSetups;
	private java.util.Set<jkt.hms.masters.business.DietMenuItemFormula> dietMenuItemFormulas;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyEndoscopy> opdGastroEnterologyEndoscopys;
	private java.util.Set<jkt.hms.masters.business.OpdGastroEnterologyColonoscopy> opdGastroEnterologyColonoscopys;
	private java.util.Set<jkt.hms.masters.business.OpdAntenatalCard> opdAntenatalCards;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramHtn> opdGravidagramHtns;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne> opdGravidagramGestationalDiabitiesOnes;
	private java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> opdGravidagramGestationalDiabitiesTwos;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="hospital_id"
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
	 * Return the value associated with the column: hospital_code
	 */
	public java.lang.String getHospitalCode () {
		return hospitalCode;
	}

	/**
	 * Set the value related to the column: hospital_code
	 * @param hospitalCode the hospital_code value
	 */
	public void setHospitalCode (java.lang.String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}



	/**
	 * Return the value associated with the column: hospital_name
	 */
	public java.lang.String getHospitalName () {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: hospital_name
	 * @param hospitalName the hospital_name value
	 */
	public void setHospitalName (java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
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
	 * Return the value associated with the column: contact_number
	 */
	public java.lang.String getContactNumber () {
		return contactNumber;
	}

	/**
	 * Set the value related to the column: contact_number
	 * @param contactNumber the contact_number value
	 */
	public void setContactNumber (java.lang.String contactNumber) {
		this.contactNumber = contactNumber;
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
	 * Return the value associated with the column: imergency_number
	 */
	public java.lang.String getImergencyNumber () {
		return imergencyNumber;
	}

	/**
	 * Set the value related to the column: imergency_number
	 * @param imergencyNumber the imergency_number value
	 */
	public void setImergencyNumber (java.lang.String imergencyNumber) {
		this.imergencyNumber = imergencyNumber;
	}



	/**
	 * Return the value associated with the column: spark_id
	 */
	public java.lang.String getSparkId () {
		return sparkId;
	}

	/**
	 * Set the value related to the column: spark_id
	 * @param sparkId the spark_id value
	 */
	public void setSparkId (java.lang.String sparkId) {
		this.sparkId = sparkId;
	}



	/**
	 * Return the value associated with the column: short_name
	 */
	public java.lang.String getShortName () {
		return shortName;
	}

	/**
	 * Set the value related to the column: short_name
	 * @param shortName the short_name value
	 */
	public void setShortName (java.lang.String shortName) {
		this.shortName = shortName;
	}



	/**
	 * Return the value associated with the column: hospital_name_change_count
	 */
	public java.lang.Integer getHospitalNameChangeCount () {
		return hospitalNameChangeCount;
	}

	/**
	 * Set the value related to the column: hospital_name_change_count
	 * @param hospitalNameChangeCount the hospital_name_change_count value
	 */
	public void setHospitalNameChangeCount (java.lang.Integer hospitalNameChangeCount) {
		this.hospitalNameChangeCount = hospitalNameChangeCount;
	}



	/**
	 * Return the value associated with the column: hospital_type_change_count
	 */
	public java.lang.Integer getHospitalTypeChangeCount () {
		return hospitalTypeChangeCount;
	}

	/**
	 * Set the value related to the column: hospital_type_change_count
	 * @param hospitalTypeChangeCount the hospital_type_change_count value
	 */
	public void setHospitalTypeChangeCount (java.lang.Integer hospitalTypeChangeCount) {
		this.hospitalTypeChangeCount = hospitalTypeChangeCount;
	}



	/**
	 * Return the value associated with the column: add2_street
	 */
	public java.lang.String getAdd2Street () {
		return add2Street;
	}

	/**
	 * Set the value related to the column: add2_street
	 * @param add2Street the add2_street value
	 */
	public void setAdd2Street (java.lang.String add2Street) {
		this.add2Street = add2Street;
	}



	/**
	 * Return the value associated with the column: lsg_type
	 */
	public java.lang.String getLsgType () {
		return lsgType;
	}

	/**
	 * Set the value related to the column: lsg_type
	 * @param lsgType the lsg_type value
	 */
	public void setLsgType (java.lang.String lsgType) {
		this.lsgType = lsgType;
	}



	/**
	 * Return the value associated with the column: lsg_name
	 */
	public java.lang.String getLsgName () {
		return lsgName;
	}

	/**
	 * Set the value related to the column: lsg_name
	 * @param lsgName the lsg_name value
	 */
	public void setLsgName (java.lang.String lsgName) {
		this.lsgName = lsgName;
	}



	/**
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.Integer getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * @param pinCode the pin_code value
	 */
	public void setPinCode (java.lang.Integer pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * Return the value associated with the column: longitude
	 */
	public java.lang.String getLongitude () {
		return longitude;
	}

	/**
	 * Set the value related to the column: longitude
	 * @param longitude the longitude value
	 */
	public void setLongitude (java.lang.String longitude) {
		this.longitude = longitude;
	}



	/**
	 * Return the value associated with the column: latitude
	 */
	public java.lang.String getLatitude () {
		return latitude;
	}

	/**
	 * Set the value related to the column: latitude
	 * @param latitude the latitude value
	 */
	public void setLatitude (java.lang.String latitude) {
		this.latitude = latitude;
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
	 * Return the value associated with the column: contact_person_name
	 */
	public java.lang.String getContactPersonName () {
		return contactPersonName;
	}

	/**
	 * Set the value related to the column: contact_person_name
	 * @param contactPersonName the contact_person_name value
	 */
	public void setContactPersonName (java.lang.String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}



	/**
	 * Return the value associated with the column: contact_person_desig
	 */
	public java.lang.String getContactPersonDesig () {
		return contactPersonDesig;
	}

	/**
	 * Set the value related to the column: contact_person_desig
	 * @param contactPersonDesig the contact_person_desig value
	 */
	public void setContactPersonDesig (java.lang.String contactPersonDesig) {
		this.contactPersonDesig = contactPersonDesig;
	}



	/**
	 * Return the value associated with the column: contact_person_mobile
	 */
	public java.lang.String getContactPersonMobile () {
		return contactPersonMobile;
	}

	/**
	 * Set the value related to the column: contact_person_mobile
	 * @param contactPersonMobile the contact_person_mobile value
	 */
	public void setContactPersonMobile (java.lang.String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}



	/**
	 * Return the value associated with the column: sanction_bed
	 */
	public java.lang.Integer getSanctionBed () {
		return sanctionBed;
	}

	/**
	 * Set the value related to the column: sanction_bed
	 * @param sanctionBed the sanction_bed value
	 */
	public void setSanctionBed (java.lang.Integer sanctionBed) {
		this.sanctionBed = sanctionBed;
	}



	/**
	 * Return the value associated with the column: blood_bank
	 */
	public java.lang.String getBloodBank () {
		return bloodBank;
	}

	/**
	 * Set the value related to the column: blood_bank
	 * @param bloodBank the blood_bank value
	 */
	public void setBloodBank (java.lang.String bloodBank) {
		this.bloodBank = bloodBank;
	}



	/**
	 * Return the value associated with the column: opening_time
	 */
	public java.lang.String getOpeningTime () {
		return openingTime;
	}

	/**
	 * Set the value related to the column: opening_time
	 * @param openingTime the opening_time value
	 */
	public void setOpeningTime (java.lang.String openingTime) {
		this.openingTime = openingTime;
	}



	/**
	 * Return the value associated with the column: registration_year
	 */
	public java.lang.String getRegistrationYear () {
		return registrationYear;
	}

	/**
	 * Set the value related to the column: registration_year
	 * @param registrationYear the registration_year value
	 */
	public void setRegistrationYear (java.lang.String registrationYear) {
		this.registrationYear = registrationYear;
	}



	/**
	 * Return the value associated with the column: closing_time
	 */
	public java.lang.String getClosingTime () {
		return closingTime;
	}

	/**
	 * Set the value related to the column: closing_time
	 * @param closingTime the closing_time value
	 */
	public void setClosingTime (java.lang.String closingTime) {
		this.closingTime = closingTime;
	}



	/**
	 * Return the value associated with the column: bb_available
	 */
	public java.lang.String getBbAvailable () {
		return bbAvailable;
	}

	/**
	 * Set the value related to the column: bb_available
	 * @param bbAvailable the bb_available value
	 */
	public void setBbAvailable (java.lang.String bbAvailable) {
		this.bbAvailable = bbAvailable;
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
	 * Return the value associated with the column: about_hospital
	 */
	public java.lang.String getAboutHospital () {
		return aboutHospital;
	}

	/**
	 * Set the value related to the column: about_hospital
	 * @param aboutHospital the about_hospital value
	 */
	public void setAboutHospital (java.lang.String aboutHospital) {
		this.aboutHospital = aboutHospital;
	}



	/**
	 * Return the value associated with the column: how_to_reach
	 */
	public java.lang.String getHowToReach () {
		return howToReach;
	}

	/**
	 * Set the value related to the column: how_to_reach
	 * @param howToReach the how_to_reach value
	 */
	public void setHowToReach (java.lang.String howToReach) {
		this.howToReach = howToReach;
	}



	/**
	 * Return the value associated with the column: jurisdiction_map
	 */
	public java.lang.String getJurisdictionMap () {
		return jurisdictionMap;
	}

	/**
	 * Set the value related to the column: jurisdiction_map
	 * @param jurisdictionMap the jurisdiction_map value
	 */
	public void setJurisdictionMap (java.lang.String jurisdictionMap) {
		this.jurisdictionMap = jurisdictionMap;
	}



	/**
	 * Return the value associated with the column: layout_map
	 */
	public java.lang.String getLayoutMap () {
		return layoutMap;
	}

	/**
	 * Set the value related to the column: layout_map
	 * @param layoutMap the layout_map value
	 */
	public void setLayoutMap (java.lang.String layoutMap) {
		this.layoutMap = layoutMap;
	}



	/**
	 * Return the value associated with the column: superintendent
	 */
	public java.lang.Long getSuperintendent () {
		return superintendent;
	}

	/**
	 * Set the value related to the column: superintendent
	 * @param superintendent the superintendent value
	 */
	public void setSuperintendent (java.lang.Long superintendent) {
		this.superintendent = superintendent;
	}



	/**
	 * Return the value associated with the column: dy_superintendent
	 */
	public java.lang.Long getDySuperintendent () {
		return dySuperintendent;
	}

	/**
	 * Set the value related to the column: dy_superintendent
	 * @param dySuperintendent the dy_superintendent value
	 */
	public void setDySuperintendent (java.lang.Long dySuperintendent) {
		this.dySuperintendent = dySuperintendent;
	}



	/**
	 * Return the value associated with the column: rmo
	 */
	public java.lang.String getRmo () {
		return rmo;
	}

	/**
	 * Set the value related to the column: rmo
	 * @param rmo the rmo value
	 */
	public void setRmo (java.lang.String rmo) {
		this.rmo = rmo;
	}



	/**
	 * Return the value associated with the column: pro
	 */
	public java.lang.String getPro () {
		return pro;
	}

	/**
	 * Set the value related to the column: pro
	 * @param pro the pro value
	 */
	public void setPro (java.lang.String pro) {
		this.pro = pro;
	}



	/**
	 * Return the value associated with the column: bb_registration_number
	 */
	public java.lang.String getBbRegistrationNumber () {
		return bbRegistrationNumber;
	}

	/**
	 * Set the value related to the column: bb_registration_number
	 * @param bbRegistrationNumber the bb_registration_number value
	 */
	public void setBbRegistrationNumber (java.lang.String bbRegistrationNumber) {
		this.bbRegistrationNumber = bbRegistrationNumber;
	}



	/**
	 * Return the value associated with the column: bb_weekly_off
	 */
	public java.lang.String getBbWeeklyOff () {
		return bbWeeklyOff;
	}

	/**
	 * Set the value related to the column: bb_weekly_off
	 * @param bbWeeklyOff the bb_weekly_off value
	 */
	public void setBbWeeklyOff (java.lang.String bbWeeklyOff) {
		this.bbWeeklyOff = bbWeeklyOff;
	}



	/**
	 * Return the value associated with the column: kmscl_institute_code
	 */
	public java.lang.String getKmsclInstituteCode () {
		return kmsclInstituteCode;
	}

	/**
	 * Set the value related to the column: kmscl_institute_code
	 * @param kmsclInstituteCode the kmscl_institute_code value
	 */
	public void setKmsclInstituteCode (java.lang.String kmsclInstituteCode) {
		this.kmsclInstituteCode = kmsclInstituteCode;
	}



	/**
	 * Return the value associated with the column: kmscl_category
	 */
	public java.lang.String getKmsclCategory () {
		return kmsclCategory;
	}

	/**
	 * Set the value related to the column: kmscl_category
	 * @param kmsclCategory the kmscl_category value
	 */
	public void setKmsclCategory (java.lang.String kmsclCategory) {
		this.kmsclCategory = kmsclCategory;
	}



	/**
	 * Return the value associated with the column: level_one_desination
	 */
	public java.lang.String getLevelOneDesination () {
		return levelOneDesination;
	}

	/**
	 * Set the value related to the column: level_one_desination
	 * @param levelOneDesination the level_one_desination value
	 */
	public void setLevelOneDesination (java.lang.String levelOneDesination) {
		this.levelOneDesination = levelOneDesination;
	}



	/**
	 * Return the value associated with the column: level_two_desination
	 */
	public java.lang.String getLevelTwoDesination () {
		return levelTwoDesination;
	}

	/**
	 * Set the value related to the column: level_two_desination
	 * @param levelTwoDesination the level_two_desination value
	 */
	public void setLevelTwoDesination (java.lang.String levelTwoDesination) {
		this.levelTwoDesination = levelTwoDesination;
	}



	/**
	 * Return the value associated with the column: level_three_desination
	 */
	public java.lang.String getLevelThreeDesination () {
		return levelThreeDesination;
	}

	/**
	 * Set the value related to the column: level_three_desination
	 * @param levelThreeDesination the level_three_desination value
	 */
	public void setLevelThreeDesination (java.lang.String levelThreeDesination) {
		this.levelThreeDesination = levelThreeDesination;
	}



	/**
	 * Return the value associated with the column: level_four_desination
	 */
	public java.lang.String getLevelFourDesination () {
		return levelFourDesination;
	}

	/**
	 * Set the value related to the column: level_four_desination
	 * @param levelFourDesination the level_four_desination value
	 */
	public void setLevelFourDesination (java.lang.String levelFourDesination) {
		this.levelFourDesination = levelFourDesination;
	}



	/**
	 * Return the value associated with the column: auth_level
	 */
	public java.lang.Integer getAuthLevel () {
		return authLevel;
	}

	/**
	 * Set the value related to the column: auth_level
	 * @param authLevel the auth_level value
	 */
	public void setAuthLevel (java.lang.Integer authLevel) {
		this.authLevel = authLevel;
	}



	/**
	 * Return the value associated with the column: parliament
	 */
	public jkt.hms.masters.business.PhMasParliyamentAssembly getParliament () {
		return parliament;
	}

	/**
	 * Set the value related to the column: parliament
	 * @param parliament the parliament value
	 */
	public void setParliament (jkt.hms.masters.business.PhMasParliyamentAssembly parliament) {
		this.parliament = parliament;
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
	 * Return the value associated with the column: village_id
	 */
	public jkt.hms.masters.business.MasVillage getVillage () {
		return village;
	}

	/**
	 * Set the value related to the column: village_id
	 * @param village the village_id value
	 */
	public void setVillage (jkt.hms.masters.business.MasVillage village) {
		this.village = village;
	}



	/**
	 * Return the value associated with the column: parent_institute_id
	 */
	public jkt.hms.masters.business.MasHospital getParentInstitute () {
		return parentInstitute;
	}

	/**
	 * Set the value related to the column: parent_institute_id
	 * @param parentInstitute the parent_institute_id value
	 */
	public void setParentInstitute (jkt.hms.masters.business.MasHospital parentInstitute) {
		this.parentInstitute = parentInstitute;
	}



	/**
	 * Return the value associated with the column: post_office
	 */
	public jkt.hms.masters.business.MasPostCode getPostOffice () {
		return postOffice;
	}

	/**
	 * Set the value related to the column: post_office
	 * @param postOffice the post_office value
	 */
	public void setPostOffice (jkt.hms.masters.business.MasPostCode postOffice) {
		this.postOffice = postOffice;
	}



	/**
	 * Return the value associated with the column: assembly
	 */
	public jkt.hms.masters.business.PhMasParliyamentAssembly getAssembly () {
		return assembly;
	}

	/**
	 * Set the value related to the column: assembly
	 * @param assembly the assembly value
	 */
	public void setAssembly (jkt.hms.masters.business.PhMasParliyamentAssembly assembly) {
		this.assembly = assembly;
	}



	/**
	 * Return the value associated with the column: electrical_section_id
	 */
	public jkt.hms.masters.business.PhMasElectricalSection getElectricalSection () {
		return electricalSection;
	}

	/**
	 * Set the value related to the column: electrical_section_id
	 * @param electricalSection the electrical_section_id value
	 */
	public void setElectricalSection (jkt.hms.masters.business.PhMasElectricalSection electricalSection) {
		this.electricalSection = electricalSection;
	}



	/**
	 * Return the value associated with the column: taluk_id
	 */
	public jkt.hms.masters.business.MasTaluk getTaluk () {
		return taluk;
	}

	/**
	 * Set the value related to the column: taluk_id
	 * @param taluk the taluk_id value
	 */
	public void setTaluk (jkt.hms.masters.business.MasTaluk taluk) {
		this.taluk = taluk;
	}



	/**
	 * Return the value associated with the column: hospital_type_id
	 */
	public jkt.hms.masters.business.MasHospitalType getHospitalType () {
		return hospitalType;
	}

	/**
	 * Set the value related to the column: hospital_type_id
	 * @param hospitalType the hospital_type_id value
	 */
	public void setHospitalType (jkt.hms.masters.business.MasHospitalType hospitalType) {
		this.hospitalType = hospitalType;
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
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasWard getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasWard ward) {
		this.ward = ward;
	}



	/**
	 * Return the value associated with the column: add3_locality
	 */
	public jkt.hms.masters.business.PhMasLocality getAdd3Locality () {
		return add3Locality;
	}

	/**
	 * Set the value related to the column: add3_locality
	 * @param add3Locality the add3_locality value
	 */
	public void setAdd3Locality (jkt.hms.masters.business.PhMasLocality add3Locality) {
		this.add3Locality = add3Locality;
	}



	/**
	 * Return the value associated with the column: hod
	 */
	public jkt.hms.masters.business.MasEmployee getHod () {
		return hod;
	}

	/**
	 * Set the value related to the column: hod
	 * @param hod the hod value
	 */
	public void setHod (jkt.hms.masters.business.MasEmployee hod) {
		this.hod = hod;
	}



	/**
	 * Return the value associated with the column: leve_one_employee 
	 */
	public jkt.hms.masters.business.MasEmployee getLevelOneEmployee () {
		return levelOneEmployee;
	}

	/**
	 * Set the value related to the column: leve_one_employee 
	 * @param levelOneEmployee the leve_one_employee  value
	 */
	public void setLevelOneEmployee (jkt.hms.masters.business.MasEmployee levelOneEmployee) {
		this.levelOneEmployee = levelOneEmployee;
	}



	/**
	 * Return the value associated with the column: level_two_employee 
	 */
	public jkt.hms.masters.business.MasEmployee getLevelTwoEmployee () {
		return levelTwoEmployee;
	}

	/**
	 * Set the value related to the column: level_two_employee 
	 * @param levelTwoEmployee the level_two_employee  value
	 */
	public void setLevelTwoEmployee (jkt.hms.masters.business.MasEmployee levelTwoEmployee) {
		this.levelTwoEmployee = levelTwoEmployee;
	}



	/**
	 * Return the value associated with the column: level_three_employee 
	 */
	public jkt.hms.masters.business.MasEmployee getLevelThreeEmployee () {
		return levelThreeEmployee;
	}

	/**
	 * Set the value related to the column: level_three_employee 
	 * @param levelThreeEmployee the level_three_employee  value
	 */
	public void setLevelThreeEmployee (jkt.hms.masters.business.MasEmployee levelThreeEmployee) {
		this.levelThreeEmployee = levelThreeEmployee;
	}



	/**
	 * Return the value associated with the column: level_four_employee 
	 */
	public jkt.hms.masters.business.MasEmployee getLevelFourEmployee () {
		return levelFourEmployee;
	}

	/**
	 * Set the value related to the column: level_four_employee 
	 * @param levelFourEmployee the level_four_employee  value
	 */
	public void setLevelFourEmployee (jkt.hms.masters.business.MasEmployee levelFourEmployee) {
		this.levelFourEmployee = levelFourEmployee;
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
	 * Return the value associated with the column: StoreBoos
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoos () {
		return storeBoos;
	}

	/**
	 * Set the value related to the column: StoreBoos
	 * @param storeBoos the StoreBoos value
	 */
	public void setStoreBoos (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoos) {
		this.storeBoos = storeBoos;
	}

	public void addToStoreBoos (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoos()) setStoreBoos(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoos().add(storeBoo);
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
	 * Return the value associated with the column: StoreIndentSocTrackers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> getStoreIndentSocTrackers () {
		return storeIndentSocTrackers;
	}

	/**
	 * Set the value related to the column: StoreIndentSocTrackers
	 * @param storeIndentSocTrackers the StoreIndentSocTrackers value
	 */
	public void setStoreIndentSocTrackers (java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers) {
		this.storeIndentSocTrackers = storeIndentSocTrackers;
	}

	public void addToStoreIndentSocTrackers (jkt.hms.masters.business.StoreIndentSocTracker storeIndentSocTracker) {
		if (null == getStoreIndentSocTrackers()) setStoreIndentSocTrackers(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentSocTracker>());
		getStoreIndentSocTrackers().add(storeIndentSocTracker);
	}



	/**
	 * Return the value associated with the column: StoreTenderProposals
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderProposal> getStoreTenderProposals () {
		return storeTenderProposals;
	}

	/**
	 * Set the value related to the column: StoreTenderProposals
	 * @param storeTenderProposals the StoreTenderProposals value
	 */
	public void setStoreTenderProposals (java.util.Set<jkt.hms.masters.business.StoreTenderProposal> storeTenderProposals) {
		this.storeTenderProposals = storeTenderProposals;
	}

	public void addToStoreTenderProposals (jkt.hms.masters.business.StoreTenderProposal storeTenderProposal) {
		if (null == getStoreTenderProposals()) setStoreTenderProposals(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderProposal>());
		getStoreTenderProposals().add(storeTenderProposal);
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
	 * Return the value associated with the column: OpdInstructionTreatments
	 */
	public java.util.Set<jkt.hms.masters.business.OpdInstructionTreatment> getOpdInstructionTreatments () {
		return opdInstructionTreatments;
	}

	/**
	 * Set the value related to the column: OpdInstructionTreatments
	 * @param opdInstructionTreatments the OpdInstructionTreatments value
	 */
	public void setOpdInstructionTreatments (java.util.Set<jkt.hms.masters.business.OpdInstructionTreatment> opdInstructionTreatments) {
		this.opdInstructionTreatments = opdInstructionTreatments;
	}

	public void addToOpdInstructionTreatments (jkt.hms.masters.business.OpdInstructionTreatment opdInstructionTreatment) {
		if (null == getOpdInstructionTreatments()) setOpdInstructionTreatments(new java.util.TreeSet<jkt.hms.masters.business.OpdInstructionTreatment>());
		getOpdInstructionTreatments().add(opdInstructionTreatment);
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
	 * Return the value associated with the column: StoreGrnReturnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> getStoreGrnReturnMs () {
		return storeGrnReturnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnMs
	 * @param storeGrnReturnMs the StoreGrnReturnMs value
	 */
	public void setStoreGrnReturnMs (java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMs) {
		this.storeGrnReturnMs = storeGrnReturnMs;
	}

	public void addToStoreGrnReturnMs (jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM) {
		if (null == getStoreGrnReturnMs()) setStoreGrnReturnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnM>());
		getStoreGrnReturnMs().add(storeGrnReturnM);
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
	 * Return the value associated with the column: UsergroupHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupHospital> getUsergroupHospitals () {
		return usergroupHospitals;
	}

	/**
	 * Set the value related to the column: UsergroupHospitals
	 * @param usergroupHospitals the UsergroupHospitals value
	 */
	public void setUsergroupHospitals (java.util.Set<jkt.hms.masters.business.UsergroupHospital> usergroupHospitals) {
		this.usergroupHospitals = usergroupHospitals;
	}

	public void addToUsergroupHospitals (jkt.hms.masters.business.UsergroupHospital usergroupHospital) {
		if (null == getUsergroupHospitals()) setUsergroupHospitals(new java.util.TreeSet<jkt.hms.masters.business.UsergroupHospital>());
		getUsergroupHospitals().add(usergroupHospital);
	}



	/**
	 * Return the value associated with the column: StoreStockTakingMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreStockTakingM> getStoreStockTakingMs () {
		return storeStockTakingMs;
	}

	/**
	 * Set the value related to the column: StoreStockTakingMs
	 * @param storeStockTakingMs the StoreStockTakingMs value
	 */
	public void setStoreStockTakingMs (java.util.Set<jkt.hms.masters.business.StoreStockTakingM> storeStockTakingMs) {
		this.storeStockTakingMs = storeStockTakingMs;
	}

	public void addToStoreStockTakingMs (jkt.hms.masters.business.StoreStockTakingM storeStockTakingM) {
		if (null == getStoreStockTakingMs()) setStoreStockTakingMs(new java.util.TreeSet<jkt.hms.masters.business.StoreStockTakingM>());
		getStoreStockTakingMs().add(storeStockTakingM);
	}



	/**
	 * Return the value associated with the column: StoreTenderCommBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> getStoreTenderCommBidMs () {
		return storeTenderCommBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderCommBidMs
	 * @param storeTenderCommBidMs the StoreTenderCommBidMs value
	 */
	public void setStoreTenderCommBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs) {
		this.storeTenderCommBidMs = storeTenderCommBidMs;
	}

	public void addToStoreTenderCommBidMs (jkt.hms.masters.business.StoreTenderCommBidM storeTenderCommBidM) {
		if (null == getStoreTenderCommBidMs()) setStoreTenderCommBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderCommBidM>());
		getStoreTenderCommBidMs().add(storeTenderCommBidM);
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
	 * Return the value associated with the column: StoreCondemnationMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreCondemnationM> getStoreCondemnationMs () {
		return storeCondemnationMs;
	}

	/**
	 * Set the value related to the column: StoreCondemnationMs
	 * @param storeCondemnationMs the StoreCondemnationMs value
	 */
	public void setStoreCondemnationMs (java.util.Set<jkt.hms.masters.business.StoreCondemnationM> storeCondemnationMs) {
		this.storeCondemnationMs = storeCondemnationMs;
	}

	public void addToStoreCondemnationMs (jkt.hms.masters.business.StoreCondemnationM storeCondemnationM) {
		if (null == getStoreCondemnationMs()) setStoreCondemnationMs(new java.util.TreeSet<jkt.hms.masters.business.StoreCondemnationM>());
		getStoreCondemnationMs().add(storeCondemnationM);
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
	 * Return the value associated with the column: StoreIndentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentM> getStoreIndentMs () {
		return storeIndentMs;
	}

	/**
	 * Set the value related to the column: StoreIndentMs
	 * @param storeIndentMs the StoreIndentMs value
	 */
	public void setStoreIndentMs (java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMs) {
		this.storeIndentMs = storeIndentMs;
	}

	public void addToStoreIndentMs (jkt.hms.masters.business.StoreIndentM storeIndentM) {
		if (null == getStoreIndentMs()) setStoreIndentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentM>());
		getStoreIndentMs().add(storeIndentM);
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
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees () {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * @param masEmployees the MasEmployees value
	 */
	public void setMasEmployees (java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees (jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees()) setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
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
	 * Return the value associated with the column: BlRefundDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlRefundDetails> getBlRefundDetails () {
		return blRefundDetails;
	}

	/**
	 * Set the value related to the column: BlRefundDetails
	 * @param blRefundDetails the BlRefundDetails value
	 */
	public void setBlRefundDetails (java.util.Set<jkt.hms.masters.business.BlRefundDetails> blRefundDetails) {
		this.blRefundDetails = blRefundDetails;
	}

	public void addToBlRefundDetails (jkt.hms.masters.business.BlRefundDetails blRefundDetails) {
		if (null == getBlRefundDetails()) setBlRefundDetails(new java.util.TreeSet<jkt.hms.masters.business.BlRefundDetails>());
		getBlRefundDetails().add(blRefundDetails);
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
	 * Return the value associated with the column: StoreAdjustmentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> getStoreAdjustmentMs () {
		return storeAdjustmentMs;
	}

	/**
	 * Set the value related to the column: StoreAdjustmentMs
	 * @param storeAdjustmentMs the StoreAdjustmentMs value
	 */
	public void setStoreAdjustmentMs (java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs) {
		this.storeAdjustmentMs = storeAdjustmentMs;
	}

	public void addToStoreAdjustmentMs (jkt.hms.masters.business.StoreAdjustmentM storeAdjustmentM) {
		if (null == getStoreAdjustmentMs()) setStoreAdjustmentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreAdjustmentM>());
		getStoreAdjustmentMs().add(storeAdjustmentM);
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
	 * Return the value associated with the column: StoreInternalReturnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> getStoreInternalReturnMs () {
		return storeInternalReturnMs;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnMs
	 * @param storeInternalReturnMs the StoreInternalReturnMs value
	 */
	public void setStoreInternalReturnMs (java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMs) {
		this.storeInternalReturnMs = storeInternalReturnMs;
	}

	public void addToStoreInternalReturnMs (jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM) {
		if (null == getStoreInternalReturnMs()) setStoreInternalReturnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnM>());
		getStoreInternalReturnMs().add(storeInternalReturnM);
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
	 * Return the value associated with the column: BlVoucherHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BlVoucherHeader> getBlVoucherHeaders () {
		return blVoucherHeaders;
	}

	/**
	 * Set the value related to the column: BlVoucherHeaders
	 * @param blVoucherHeaders the BlVoucherHeaders value
	 */
	public void setBlVoucherHeaders (java.util.Set<jkt.hms.masters.business.BlVoucherHeader> blVoucherHeaders) {
		this.blVoucherHeaders = blVoucherHeaders;
	}

	public void addToBlVoucherHeaders (jkt.hms.masters.business.BlVoucherHeader blVoucherHeader) {
		if (null == getBlVoucherHeaders()) setBlVoucherHeaders(new java.util.TreeSet<jkt.hms.masters.business.BlVoucherHeader>());
		getBlVoucherHeaders().add(blVoucherHeader);
	}



	/**
	 * Return the value associated with the column: OpdHolidaies
	 */
	public java.util.Set<jkt.hms.masters.business.OpdHoliday> getOpdHolidaies () {
		return opdHolidaies;
	}

	/**
	 * Set the value related to the column: OpdHolidaies
	 * @param opdHolidaies the OpdHolidaies value
	 */
	public void setOpdHolidaies (java.util.Set<jkt.hms.masters.business.OpdHoliday> opdHolidaies) {
		this.opdHolidaies = opdHolidaies;
	}

	public void addToOpdHolidaies (jkt.hms.masters.business.OpdHoliday opdHoliday) {
		if (null == getOpdHolidaies()) setOpdHolidaies(new java.util.TreeSet<jkt.hms.masters.business.OpdHoliday>());
		getOpdHolidaies().add(opdHoliday);
	}



	/**
	 * Return the value associated with the column: BlChargeSlipDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> getBlChargeSlipDetails () {
		return blChargeSlipDetails;
	}

	/**
	 * Set the value related to the column: BlChargeSlipDetails
	 * @param blChargeSlipDetails the BlChargeSlipDetails value
	 */
	public void setBlChargeSlipDetails (java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> blChargeSlipDetails) {
		this.blChargeSlipDetails = blChargeSlipDetails;
	}

	public void addToBlChargeSlipDetails (jkt.hms.masters.business.BlChargeSlipDetail blChargeSlipDetail) {
		if (null == getBlChargeSlipDetails()) setBlChargeSlipDetails(new java.util.TreeSet<jkt.hms.masters.business.BlChargeSlipDetail>());
		getBlChargeSlipDetails().add(blChargeSlipDetail);
	}



	/**
	 * Return the value associated with the column: StoreWorkOrderMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> getStoreWorkOrderMs () {
		return storeWorkOrderMs;
	}

	/**
	 * Set the value related to the column: StoreWorkOrderMs
	 * @param storeWorkOrderMs the StoreWorkOrderMs value
	 */
	public void setStoreWorkOrderMs (java.util.Set<jkt.hms.masters.business.StoreWorkOrderM> storeWorkOrderMs) {
		this.storeWorkOrderMs = storeWorkOrderMs;
	}

	public void addToStoreWorkOrderMs (jkt.hms.masters.business.StoreWorkOrderM storeWorkOrderM) {
		if (null == getStoreWorkOrderMs()) setStoreWorkOrderMs(new java.util.TreeSet<jkt.hms.masters.business.StoreWorkOrderM>());
		getStoreWorkOrderMs().add(storeWorkOrderM);
	}



	/**
	 * Return the value associated with the column: DietExtraItemFormulas
	 */
	public java.util.Set<jkt.hms.masters.business.DietExtraItemFormula> getDietExtraItemFormulas () {
		return dietExtraItemFormulas;
	}

	/**
	 * Set the value related to the column: DietExtraItemFormulas
	 * @param dietExtraItemFormulas the DietExtraItemFormulas value
	 */
	public void setDietExtraItemFormulas (java.util.Set<jkt.hms.masters.business.DietExtraItemFormula> dietExtraItemFormulas) {
		this.dietExtraItemFormulas = dietExtraItemFormulas;
	}

	public void addToDietExtraItemFormulas (jkt.hms.masters.business.DietExtraItemFormula dietExtraItemFormula) {
		if (null == getDietExtraItemFormulas()) setDietExtraItemFormulas(new java.util.TreeSet<jkt.hms.masters.business.DietExtraItemFormula>());
		getDietExtraItemFormulas().add(dietExtraItemFormula);
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
	 * Return the value associated with the column: EmpAfmsfDets
	 */
	public java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> getEmpAfmsfDets () {
		return empAfmsfDets;
	}

	/**
	 * Set the value related to the column: EmpAfmsfDets
	 * @param empAfmsfDets the EmpAfmsfDets value
	 */
	public void setEmpAfmsfDets (java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets) {
		this.empAfmsfDets = empAfmsfDets;
	}

	public void addToEmpAfmsfDets (jkt.hms.masters.business.EmpAfmsfDet empAfmsfDet) {
		if (null == getEmpAfmsfDets()) setEmpAfmsfDets(new java.util.TreeSet<jkt.hms.masters.business.EmpAfmsfDet>());
		getEmpAfmsfDets().add(empAfmsfDet);
	}



	/**
	 * Return the value associated with the column: StoreMeScaleDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> getStoreMeScaleDetails () {
		return storeMeScaleDetails;
	}

	/**
	 * Set the value related to the column: StoreMeScaleDetails
	 * @param storeMeScaleDetails the StoreMeScaleDetails value
	 */
	public void setStoreMeScaleDetails (java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails) {
		this.storeMeScaleDetails = storeMeScaleDetails;
	}

	public void addToStoreMeScaleDetails (jkt.hms.masters.business.StoreMeScaleDetails storeMeScaleDetails) {
		if (null == getStoreMeScaleDetails()) setStoreMeScaleDetails(new java.util.TreeSet<jkt.hms.masters.business.StoreMeScaleDetails>());
		getStoreMeScaleDetails().add(storeMeScaleDetails);
	}



	/**
	 * Return the value associated with the column: StoreBosMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBosM> getStoreBosMs () {
		return storeBosMs;
	}

	/**
	 * Set the value related to the column: StoreBosMs
	 * @param storeBosMs the StoreBosMs value
	 */
	public void setStoreBosMs (java.util.Set<jkt.hms.masters.business.StoreBosM> storeBosMs) {
		this.storeBosMs = storeBosMs;
	}

	public void addToStoreBosMs (jkt.hms.masters.business.StoreBosM storeBosM) {
		if (null == getStoreBosMs()) setStoreBosMs(new java.util.TreeSet<jkt.hms.masters.business.StoreBosM>());
		getStoreBosMs().add(storeBosM);
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
	 * Return the value associated with the column: StoreTenderLocalPurchaseMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> getStoreTenderLocalPurchaseMs () {
		return storeTenderLocalPurchaseMs;
	}

	/**
	 * Set the value related to the column: StoreTenderLocalPurchaseMs
	 * @param storeTenderLocalPurchaseMs the StoreTenderLocalPurchaseMs value
	 */
	public void setStoreTenderLocalPurchaseMs (java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMs) {
		this.storeTenderLocalPurchaseMs = storeTenderLocalPurchaseMs;
	}

	public void addToStoreTenderLocalPurchaseMs (jkt.hms.masters.business.StoreTenderLocalPurchaseM storeTenderLocalPurchaseM) {
		if (null == getStoreTenderLocalPurchaseMs()) setStoreTenderLocalPurchaseMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderLocalPurchaseM>());
		getStoreTenderLocalPurchaseMs().add(storeTenderLocalPurchaseM);
	}



	/**
	 * Return the value associated with the column: AppInvestigationSetups
	 */
	public java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> getAppInvestigationSetups () {
		return appInvestigationSetups;
	}

	/**
	 * Set the value related to the column: AppInvestigationSetups
	 * @param appInvestigationSetups the AppInvestigationSetups value
	 */
	public void setAppInvestigationSetups (java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> appInvestigationSetups) {
		this.appInvestigationSetups = appInvestigationSetups;
	}

	public void addToAppInvestigationSetups (jkt.hms.masters.business.AppInvestigationSetup appInvestigationSetup) {
		if (null == getAppInvestigationSetups()) setAppInvestigationSetups(new java.util.TreeSet<jkt.hms.masters.business.AppInvestigationSetup>());
		getAppInvestigationSetups().add(appInvestigationSetup);
	}



	/**
	 * Return the value associated with the column: AppEquipmentMasters
	 */
	public java.util.Set<jkt.hms.masters.business.AppEquipmentMaster> getAppEquipmentMasters () {
		return appEquipmentMasters;
	}

	/**
	 * Set the value related to the column: AppEquipmentMasters
	 * @param appEquipmentMasters the AppEquipmentMasters value
	 */
	public void setAppEquipmentMasters (java.util.Set<jkt.hms.masters.business.AppEquipmentMaster> appEquipmentMasters) {
		this.appEquipmentMasters = appEquipmentMasters;
	}

	public void addToAppEquipmentMasters (jkt.hms.masters.business.AppEquipmentMaster appEquipmentMaster) {
		if (null == getAppEquipmentMasters()) setAppEquipmentMasters(new java.util.TreeSet<jkt.hms.masters.business.AppEquipmentMaster>());
		getAppEquipmentMasters().add(appEquipmentMaster);
	}



	/**
	 * Return the value associated with the column: StoreQuaterReturnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuaterReturnM> getStoreQuaterReturnMs () {
		return storeQuaterReturnMs;
	}

	/**
	 * Set the value related to the column: StoreQuaterReturnMs
	 * @param storeQuaterReturnMs the StoreQuaterReturnMs value
	 */
	public void setStoreQuaterReturnMs (java.util.Set<jkt.hms.masters.business.StoreQuaterReturnM> storeQuaterReturnMs) {
		this.storeQuaterReturnMs = storeQuaterReturnMs;
	}

	public void addToStoreQuaterReturnMs (jkt.hms.masters.business.StoreQuaterReturnM storeQuaterReturnM) {
		if (null == getStoreQuaterReturnMs()) setStoreQuaterReturnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuaterReturnM>());
		getStoreQuaterReturnMs().add(storeQuaterReturnM);
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
	 * Return the value associated with the column: BlDepositDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlDepositDetails> getBlDepositDetails () {
		return blDepositDetails;
	}

	/**
	 * Set the value related to the column: BlDepositDetails
	 * @param blDepositDetails the BlDepositDetails value
	 */
	public void setBlDepositDetails (java.util.Set<jkt.hms.masters.business.BlDepositDetails> blDepositDetails) {
		this.blDepositDetails = blDepositDetails;
	}

	public void addToBlDepositDetails (jkt.hms.masters.business.BlDepositDetails blDepositDetails) {
		if (null == getBlDepositDetails()) setBlDepositDetails(new java.util.TreeSet<jkt.hms.masters.business.BlDepositDetails>());
		getBlDepositDetails().add(blDepositDetails);
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
	 * Return the value associated with the column: StoreDefectiveDrugMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> getStoreDefectiveDrugMs () {
		return storeDefectiveDrugMs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugMs
	 * @param storeDefectiveDrugMs the StoreDefectiveDrugMs value
	 */
	public void setStoreDefectiveDrugMs (java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugM> storeDefectiveDrugMs) {
		this.storeDefectiveDrugMs = storeDefectiveDrugMs;
	}

	public void addToStoreDefectiveDrugMs (jkt.hms.masters.business.StoreDefectiveDrugM storeDefectiveDrugM) {
		if (null == getStoreDefectiveDrugMs()) setStoreDefectiveDrugMs(new java.util.TreeSet<jkt.hms.masters.business.StoreDefectiveDrugM>());
		getStoreDefectiveDrugMs().add(storeDefectiveDrugM);
	}



	/**
	 * Return the value associated with the column: OpdPatientDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientDetails> getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: OpdPatientDetails
	 * @param opdPatientDetails the OpdPatientDetails value
	 */
	public void setOpdPatientDetails (java.util.Set<jkt.hms.masters.business.OpdPatientDetails> opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}

	public void addToOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		if (null == getOpdPatientDetails()) setOpdPatientDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdPatientDetails>());
		getOpdPatientDetails().add(opdPatientDetails);
	}



	/**
	 * Return the value associated with the column: UsergroupAccessrightsHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> getUsergroupAccessrightsHospitals () {
		return usergroupAccessrightsHospitals;
	}

	/**
	 * Set the value related to the column: UsergroupAccessrightsHospitals
	 * @param usergroupAccessrightsHospitals the UsergroupAccessrightsHospitals value
	 */
	public void setUsergroupAccessrightsHospitals (java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> usergroupAccessrightsHospitals) {
		this.usergroupAccessrightsHospitals = usergroupAccessrightsHospitals;
	}

	public void addToUsergroupAccessrightsHospitals (jkt.hms.masters.business.UsergroupAccessrightsHospital usergroupAccessrightsHospital) {
		if (null == getUsergroupAccessrightsHospitals()) setUsergroupAccessrightsHospitals(new java.util.TreeSet<jkt.hms.masters.business.UsergroupAccessrightsHospital>());
		getUsergroupAccessrightsHospitals().add(usergroupAccessrightsHospital);
	}



	/**
	 * Return the value associated with the column: StoreRepairCivilFirms
	 */
	public java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> getStoreRepairCivilFirms () {
		return storeRepairCivilFirms;
	}

	/**
	 * Set the value related to the column: StoreRepairCivilFirms
	 * @param storeRepairCivilFirms the StoreRepairCivilFirms value
	 */
	public void setStoreRepairCivilFirms (java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> storeRepairCivilFirms) {
		this.storeRepairCivilFirms = storeRepairCivilFirms;
	}

	public void addToStoreRepairCivilFirms (jkt.hms.masters.business.StoreRepairCivilFirm storeRepairCivilFirm) {
		if (null == getStoreRepairCivilFirms()) setStoreRepairCivilFirms(new java.util.TreeSet<jkt.hms.masters.business.StoreRepairCivilFirm>());
		getStoreRepairCivilFirms().add(storeRepairCivilFirm);
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
	 * Return the value associated with the column: MasAccounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasAccount> getMasAccounts () {
		return masAccounts;
	}

	/**
	 * Set the value related to the column: MasAccounts
	 * @param masAccounts the MasAccounts value
	 */
	public void setMasAccounts (java.util.Set<jkt.hms.masters.business.MasAccount> masAccounts) {
		this.masAccounts = masAccounts;
	}

	public void addToMasAccounts (jkt.hms.masters.business.MasAccount masAccount) {
		if (null == getMasAccounts()) setMasAccounts(new java.util.TreeSet<jkt.hms.masters.business.MasAccount>());
		getMasAccounts().add(masAccount);
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
	 * Return the value associated with the column: StoreInternalIndentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> getStoreInternalIndentMs () {
		return storeInternalIndentMs;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentMs
	 * @param storeInternalIndentMs the StoreInternalIndentMs value
	 */
	public void setStoreInternalIndentMs (java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMs) {
		this.storeInternalIndentMs = storeInternalIndentMs;
	}

	public void addToStoreInternalIndentMs (jkt.hms.masters.business.StoreInternalIndentM storeInternalIndentM) {
		if (null == getStoreInternalIndentMs()) setStoreInternalIndentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentM>());
		getStoreInternalIndentMs().add(storeInternalIndentM);
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
	 * Return the value associated with the column: StoreTenderTechnicalBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> getStoreTenderTechnicalBidMs () {
		return storeTenderTechnicalBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderTechnicalBidMs
	 * @param storeTenderTechnicalBidMs the StoreTenderTechnicalBidMs value
	 */
	public void setStoreTenderTechnicalBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> storeTenderTechnicalBidMs) {
		this.storeTenderTechnicalBidMs = storeTenderTechnicalBidMs;
	}

	public void addToStoreTenderTechnicalBidMs (jkt.hms.masters.business.StoreTenderTechnicalBidM storeTenderTechnicalBidM) {
		if (null == getStoreTenderTechnicalBidMs()) setStoreTenderTechnicalBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderTechnicalBidM>());
		getStoreTenderTechnicalBidMs().add(storeTenderTechnicalBidM);
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
	 * Return the value associated with the column: StoreLoaninMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninM> getStoreLoaninMs () {
		return storeLoaninMs;
	}

	/**
	 * Set the value related to the column: StoreLoaninMs
	 * @param storeLoaninMs the StoreLoaninMs value
	 */
	public void setStoreLoaninMs (java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs) {
		this.storeLoaninMs = storeLoaninMs;
	}

	public void addToStoreLoaninMs (jkt.hms.masters.business.StoreLoaninM storeLoaninM) {
		if (null == getStoreLoaninMs()) setStoreLoaninMs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninM>());
		getStoreLoaninMs().add(storeLoaninM);
	}



	/**
	 * Return the value associated with the column: StoreDisposalMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDisposalM> getStoreDisposalMs () {
		return storeDisposalMs;
	}

	/**
	 * Set the value related to the column: StoreDisposalMs
	 * @param storeDisposalMs the StoreDisposalMs value
	 */
	public void setStoreDisposalMs (java.util.Set<jkt.hms.masters.business.StoreDisposalM> storeDisposalMs) {
		this.storeDisposalMs = storeDisposalMs;
	}

	public void addToStoreDisposalMs (jkt.hms.masters.business.StoreDisposalM storeDisposalM) {
		if (null == getStoreDisposalMs()) setStoreDisposalMs(new java.util.TreeSet<jkt.hms.masters.business.StoreDisposalM>());
		getStoreDisposalMs().add(storeDisposalM);
	}



	/**
	 * Return the value associated with the column: StoreTenderMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderM> getStoreTenderMs () {
		return storeTenderMs;
	}

	/**
	 * Set the value related to the column: StoreTenderMs
	 * @param storeTenderMs the StoreTenderMs value
	 */
	public void setStoreTenderMs (java.util.Set<jkt.hms.masters.business.StoreTenderM> storeTenderMs) {
		this.storeTenderMs = storeTenderMs;
	}

	public void addToStoreTenderMs (jkt.hms.masters.business.StoreTenderM storeTenderM) {
		if (null == getStoreTenderMs()) setStoreTenderMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderM>());
		getStoreTenderMs().add(storeTenderM);
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
	 * Return the value associated with the column: AppSetups
	 */
	public java.util.Set<jkt.hms.masters.business.AppSetup> getAppSetups () {
		return appSetups;
	}

	/**
	 * Set the value related to the column: AppSetups
	 * @param appSetups the AppSetups value
	 */
	public void setAppSetups (java.util.Set<jkt.hms.masters.business.AppSetup> appSetups) {
		this.appSetups = appSetups;
	}

	public void addToAppSetups (jkt.hms.masters.business.AppSetup appSetup) {
		if (null == getAppSetups()) setAppSetups(new java.util.TreeSet<jkt.hms.masters.business.AppSetup>());
		getAppSetups().add(appSetup);
	}



	/**
	 * Return the value associated with the column: DietMenuItemFormulas
	 */
	public java.util.Set<jkt.hms.masters.business.DietMenuItemFormula> getDietMenuItemFormulas () {
		return dietMenuItemFormulas;
	}

	/**
	 * Set the value related to the column: DietMenuItemFormulas
	 * @param dietMenuItemFormulas the DietMenuItemFormulas value
	 */
	public void setDietMenuItemFormulas (java.util.Set<jkt.hms.masters.business.DietMenuItemFormula> dietMenuItemFormulas) {
		this.dietMenuItemFormulas = dietMenuItemFormulas;
	}

	public void addToDietMenuItemFormulas (jkt.hms.masters.business.DietMenuItemFormula dietMenuItemFormula) {
		if (null == getDietMenuItemFormulas()) setDietMenuItemFormulas(new java.util.TreeSet<jkt.hms.masters.business.DietMenuItemFormula>());
		getDietMenuItemFormulas().add(dietMenuItemFormula);
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
	 * Return the value associated with the column: OpdGravidagramGestationalDiabitiesTwos
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> getOpdGravidagramGestationalDiabitiesTwos () {
		return opdGravidagramGestationalDiabitiesTwos;
	}

	/**
	 * Set the value related to the column: OpdGravidagramGestationalDiabitiesTwos
	 * @param opdGravidagramGestationalDiabitiesTwos the OpdGravidagramGestationalDiabitiesTwos value
	 */
	public void setOpdGravidagramGestationalDiabitiesTwos (java.util.Set<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo> opdGravidagramGestationalDiabitiesTwos) {
		this.opdGravidagramGestationalDiabitiesTwos = opdGravidagramGestationalDiabitiesTwos;
	}

	public void addToOpdGravidagramGestationalDiabitiesTwos (jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo opdGravidagramGestationalDiabitiesTwo) {
		if (null == getOpdGravidagramGestationalDiabitiesTwos()) setOpdGravidagramGestationalDiabitiesTwos(new java.util.TreeSet<jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo>());
		getOpdGravidagramGestationalDiabitiesTwos().add(opdGravidagramGestationalDiabitiesTwo);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasHospital)) return false;
		else {
			jkt.hms.masters.business.MasHospital masHospital = (jkt.hms.masters.business.MasHospital) obj;
			if (null == this.getId() || null == masHospital.getId()) return false;
			else return (this.getId().equals(masHospital.getId()));
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