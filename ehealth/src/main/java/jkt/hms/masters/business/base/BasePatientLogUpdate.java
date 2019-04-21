package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_log_update table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_log_update"
 */

public abstract class BasePatientLogUpdate  implements Serializable {

	public static String REF = "PatientLogUpdate";
	public static String PROP_PATIENT_NAME_OF_RELATIVE = "PatientNameOfRelative";
	public static String PROP_PATIENT_LSG_HOUSE_NUMBER = "PatientLsgHouseNumber";
	public static String PROP_PATIENT_COLONY_HOUSE_NO = "PatientColonyHouseNo";
	public static String PROP_PATIENT_OLD_NAME = "PatientOldName";
	public static String PROP_PATIENT_NATIVE = "PatientNative";
	public static String PROP_PERMANENT_ADDRESS_AREA = "PermanentAddressArea";
	public static String PROP_PATIENT_OLD_GENDER = "PatientOldGender";
	public static String PROP_PATIENT_TEMPORARY_DISTRICT = "PatientTemporaryDistrict";
	public static String PROP_PATIENT_PATIENT_LOG_UPDATE_HIN = "PatientPatientLogUpdateHin";
	public static String PROP_POSTOFFICE_NAME = "PostofficeName";
	public static String PROP_PATIENT_OLD_AREA = "PatientOldArea";
	public static String PROP_PATIENT_OLD_MONTHLY_INCOME = "PatientOldMonthlyIncome";
	public static String PROP_PATIENT_OLD_DATE_OF_BIRTH = "PatientOldDateOfBirth";
	public static String PROP_TIME_OF_UPDATE = "TimeOfUpdate";
	public static String PROP_PATIENT_HEALTH_HOUSE_ID = "PatientHealthHouseId";
	public static String PROP_PATIENT_OLD_INCOME_REMARKS = "PatientOldIncomeRemarks";
	public static String PROP_DATE_OF_UPDATE = "DateOfUpdate";
	public static String PROP_PATIENT_DOCUMENT_NAME = "PatientDocumentName";
	public static String PROP_PATIENT_OLD_AGE = "PatientOldAge";
	public static String PROP_EMPLOYEE_DEPT_NO = "EmployeeDeptNo";
	public static String PROP_PATIENT_TEMPORARY_WARD = "PatientTemporaryWard";
	public static String PROP_PATIENT_TEMPORARY_LSG_NAME = "PatientTemporaryLsgName";
	public static String PROP_PATIENT_TEMPORARY_TALUK = "PatientTemporaryTaluk";
	public static String PROP_PATIENT_OLD_DISTRICT = "PatientOldDistrict";
	public static String PROP_PATIENT_OLD_RELATION = "PatientOldRelation";
	public static String PROP_PATIENT_POSTOFFICE = "PatientPostoffice";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";
	public static String PROP_BYSTANDER_ADDRESS = "BystanderAddress";
	public static String PROP_BYSTANDER_MOBILE_NO = "BystanderMobileNo";
	public static String PROP_BYSTANDER_RELATION = "BystanderRelation";


	// constructors
	public BasePatientLogUpdate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientLogUpdate (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String patientOldName;
	private java.lang.String patientOldGender;
	private java.lang.String patientOldRelation;
	private java.lang.String patientNameOfRelative;
	private java.util.Date patientOldDateOfBirth;
	private java.lang.String patientOldAge;
	private java.lang.String patientOldDistrict;
	private java.lang.String patientOldArea;
	private java.lang.String patientOldMonthlyIncome;
	private java.lang.String patientOldIncomeRemarks;
	private java.lang.String employeeDeptNo;
	private java.util.Date dateOfUpdate;
	private java.lang.String timeOfUpdate;
	private java.lang.String patientDocumentName;
	private java.lang.String permanentAddressArea;
	private java.lang.String patientTemporaryDistrict;
	private java.lang.String patientTemporaryTaluk;
	private java.lang.String patientTemporaryLsgName;
	private java.lang.String patientTemporaryWard;
	private java.lang.String patientLsgHouseNumber;
	private java.lang.String patientColonyHouseNo;
	private java.lang.Long patientPostoffice;
	private java.lang.String patientHealthHouseId;
	private java.lang.String patientNative;
	private java.lang.String postofficeName;
	private java.lang.Integer employeeId;
	private java.lang.String bystanderMobileNo;
	private java.lang.String bystanderAddress;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Patient patientPatientLogUpdateHin;
	private jkt.hms.masters.business.MasRelation bystanderRelation;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="patient_log_id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: patient_old_gender
	 */
	public java.lang.String getPatientOldGender () {
		return patientOldGender;
	}

	/**
	 * Set the value related to the column: patient_old_gender
	 * @param patientOldGender the patient_old_gender value
	 */
	public void setPatientOldGender (java.lang.String patientOldGender) {
		this.patientOldGender = patientOldGender;
	}



	/**
	 * Return the value associated with the column: patient_old_relation
	 */
	public java.lang.String getPatientOldRelation () {
		return patientOldRelation;
	}

	/**
	 * Set the value related to the column: patient_old_relation
	 * @param patientOldRelation the patient_old_relation value
	 */
	public void setPatientOldRelation (java.lang.String patientOldRelation) {
		this.patientOldRelation = patientOldRelation;
	}



	/**
	 * Return the value associated with the column: patient_name_of_relative
	 */
	public java.lang.String getPatientNameOfRelative () {
		return patientNameOfRelative;
	}

	/**
	 * Set the value related to the column: patient_name_of_relative
	 * @param patientNameOfRelative the patient_name_of_relative value
	 */
	public void setPatientNameOfRelative (java.lang.String patientNameOfRelative) {
		this.patientNameOfRelative = patientNameOfRelative;
	}



	/**
	 * Return the value associated with the column: patient_old_date_of_birth
	 */
	public java.util.Date getPatientOldDateOfBirth () {
		return patientOldDateOfBirth;
	}

	/**
	 * Set the value related to the column: patient_old_date_of_birth
	 * @param patientOldDateOfBirth the patient_old_date_of_birth value
	 */
	public void setPatientOldDateOfBirth (java.util.Date patientOldDateOfBirth) {
		this.patientOldDateOfBirth = patientOldDateOfBirth;
	}



	/**
	 * Return the value associated with the column: patient_old_age
	 */
	public java.lang.String getPatientOldAge () {
		return patientOldAge;
	}

	/**
	 * Set the value related to the column: patient_old_age
	 * @param patientOldAge the patient_old_age value
	 */
	public void setPatientOldAge (java.lang.String patientOldAge) {
		this.patientOldAge = patientOldAge;
	}



	/**
	 * Return the value associated with the column: patient_old_district
	 */
	public java.lang.String getPatientOldDistrict () {
		return patientOldDistrict;
	}

	/**
	 * Set the value related to the column: patient_old_district
	 * @param patientOldDistrict the patient_old_district value
	 */
	public void setPatientOldDistrict (java.lang.String patientOldDistrict) {
		this.patientOldDistrict = patientOldDistrict;
	}



	/**
	 * Return the value associated with the column: patient_old_area
	 */
	public java.lang.String getPatientOldArea () {
		return patientOldArea;
	}

	/**
	 * Set the value related to the column: patient_old_area
	 * @param patientOldArea the patient_old_area value
	 */
	public void setPatientOldArea (java.lang.String patientOldArea) {
		this.patientOldArea = patientOldArea;
	}



	/**
	 * Return the value associated with the column: patient_old_monthly_income
	 */
	public java.lang.String getPatientOldMonthlyIncome () {
		return patientOldMonthlyIncome;
	}

	/**
	 * Set the value related to the column: patient_old_monthly_income
	 * @param patientOldMonthlyIncome the patient_old_monthly_income value
	 */
	public void setPatientOldMonthlyIncome (java.lang.String patientOldMonthlyIncome) {
		this.patientOldMonthlyIncome = patientOldMonthlyIncome;
	}



	/**
	 * Return the value associated with the column: patient_old_income_remarks
	 */
	public java.lang.String getPatientOldIncomeRemarks () {
		return patientOldIncomeRemarks;
	}

	/**
	 * Set the value related to the column: patient_old_income_remarks
	 * @param patientOldIncomeRemarks the patient_old_income_remarks value
	 */
	public void setPatientOldIncomeRemarks (java.lang.String patientOldIncomeRemarks) {
		this.patientOldIncomeRemarks = patientOldIncomeRemarks;
	}



	/**
	 * Return the value associated with the column: employee_dept_no
	 */
	public java.lang.String getEmployeeDeptNo () {
		return employeeDeptNo;
	}

	/**
	 * Set the value related to the column: employee_dept_no
	 * @param employeeDeptNo the employee_dept_no value
	 */
	public void setEmployeeDeptNo (java.lang.String employeeDeptNo) {
		this.employeeDeptNo = employeeDeptNo;
	}



	/**
	 * Return the value associated with the column: date_of_update
	 */
	public java.util.Date getDateOfUpdate () {
		return dateOfUpdate;
	}

	/**
	 * Set the value related to the column: date_of_update
	 * @param dateOfUpdate the date_of_update value
	 */
	public void setDateOfUpdate (java.util.Date dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}



	/**
	 * Return the value associated with the column: time_of_update
	 */
	public java.lang.String getTimeOfUpdate () {
		return timeOfUpdate;
	}

	/**
	 * Set the value related to the column: time_of_update
	 * @param timeOfUpdate the time_of_update value
	 */
	public void setTimeOfUpdate (java.lang.String timeOfUpdate) {
		this.timeOfUpdate = timeOfUpdate;
	}



	/**
	 * Return the value associated with the column: patient_document_name
	 */
	public java.lang.String getPatientDocumentName () {
		return patientDocumentName;
	}

	/**
	 * Set the value related to the column: patient_document_name
	 * @param patientDocumentName the patient_document_name value
	 */
	public void setPatientDocumentName (java.lang.String patientDocumentName) {
		this.patientDocumentName = patientDocumentName;
	}



	/**
	 * Return the value associated with the column: permanent_address_area
	 */
	public java.lang.String getPermanentAddressArea () {
		return permanentAddressArea;
	}

	/**
	 * Set the value related to the column: permanent_address_area
	 * @param permanentAddressArea the permanent_address_area value
	 */
	public void setPermanentAddressArea (java.lang.String permanentAddressArea) {
		this.permanentAddressArea = permanentAddressArea;
	}



	/**
	 * Return the value associated with the column: patient_temporary_district
	 */
	public java.lang.String getPatientTemporaryDistrict () {
		return patientTemporaryDistrict;
	}

	/**
	 * Set the value related to the column: patient_temporary_district
	 * @param patientTemporaryDistrict the patient_temporary_district value
	 */
	public void setPatientTemporaryDistrict (java.lang.String patientTemporaryDistrict) {
		this.patientTemporaryDistrict = patientTemporaryDistrict;
	}



	/**
	 * Return the value associated with the column: patient_temporary_taluk
	 */
	public java.lang.String getPatientTemporaryTaluk () {
		return patientTemporaryTaluk;
	}

	/**
	 * Set the value related to the column: patient_temporary_taluk
	 * @param patientTemporaryTaluk the patient_temporary_taluk value
	 */
	public void setPatientTemporaryTaluk (java.lang.String patientTemporaryTaluk) {
		this.patientTemporaryTaluk = patientTemporaryTaluk;
	}



	/**
	 * Return the value associated with the column: patient_temporary_lsg_name
	 */
	public java.lang.String getPatientTemporaryLsgName () {
		return patientTemporaryLsgName;
	}

	/**
	 * Set the value related to the column: patient_temporary_lsg_name
	 * @param patientTemporaryLsgName the patient_temporary_lsg_name value
	 */
	public void setPatientTemporaryLsgName (java.lang.String patientTemporaryLsgName) {
		this.patientTemporaryLsgName = patientTemporaryLsgName;
	}



	/**
	 * Return the value associated with the column: patient_temporary_ward
	 */
	public java.lang.String getPatientTemporaryWard () {
		return patientTemporaryWard;
	}

	/**
	 * Set the value related to the column: patient_temporary_ward
	 * @param patientTemporaryWard the patient_temporary_ward value
	 */
	public void setPatientTemporaryWard (java.lang.String patientTemporaryWard) {
		this.patientTemporaryWard = patientTemporaryWard;
	}



	/**
	 * Return the value associated with the column: patient_lsg_house_number
	 */
	public java.lang.String getPatientLsgHouseNumber () {
		return patientLsgHouseNumber;
	}

	/**
	 * Set the value related to the column: patient_lsg_house_number
	 * @param patientLsgHouseNumber the patient_lsg_house_number value
	 */
	public void setPatientLsgHouseNumber (java.lang.String patientLsgHouseNumber) {
		this.patientLsgHouseNumber = patientLsgHouseNumber;
	}



	/**
	 * Return the value associated with the column: patient_colony_house_no
	 */
	public java.lang.String getPatientColonyHouseNo () {
		return patientColonyHouseNo;
	}

	/**
	 * Set the value related to the column: patient_colony_house_no
	 * @param patientColonyHouseNo the patient_colony_house_no value
	 */
	public void setPatientColonyHouseNo (java.lang.String patientColonyHouseNo) {
		this.patientColonyHouseNo = patientColonyHouseNo;
	}



	/**
	 * Return the value associated with the column: patient_postoffice
	 */
	public java.lang.Long getPatientPostoffice () {
		return patientPostoffice;
	}

	/**
	 * Set the value related to the column: patient_postoffice
	 * @param patientPostoffice the patient_postoffice value
	 */
	public void setPatientPostoffice (java.lang.Long patientPostoffice) {
		this.patientPostoffice = patientPostoffice;
	}



	/**
	 * Return the value associated with the column: patient_health_house_id
	 */
	public java.lang.String getPatientHealthHouseId () {
		return patientHealthHouseId;
	}

	/**
	 * Set the value related to the column: patient_health_house_id
	 * @param patientHealthHouseId the patient_health_house_id value
	 */
	public void setPatientHealthHouseId (java.lang.String patientHealthHouseId) {
		this.patientHealthHouseId = patientHealthHouseId;
	}



	/**
	 * Return the value associated with the column: patient_native
	 */
	public java.lang.String getPatientNative () {
		return patientNative;
	}

	/**
	 * Set the value related to the column: patient_native
	 * @param patientNative the patient_native value
	 */
	public void setPatientNative (java.lang.String patientNative) {
		this.patientNative = patientNative;
	}



	/**
	 * Return the value associated with the column: postoffice_name
	 */
	public java.lang.String getPostofficeName () {
		return postofficeName;
	}

	/**
	 * Set the value related to the column: postoffice_name
	 * @param postofficeName the postoffice_name value
	 */
	public void setPostofficeName (java.lang.String postofficeName) {
		this.postofficeName = postofficeName;
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
	 * Return the value associated with the column: patient_patient_log_update_hin_id
	 */
	public jkt.hms.masters.business.Patient getPatientPatientLogUpdateHin () {
		return patientPatientLogUpdateHin;
	}

	/**
	 * Set the value related to the column: patient_patient_log_update_hin_id
	 * @param patientPatientLogUpdateHin the patient_patient_log_update_hin_id value
	 */
	public void setPatientPatientLogUpdateHin (jkt.hms.masters.business.Patient patientPatientLogUpdateHin) {
		this.patientPatientLogUpdateHin = patientPatientLogUpdateHin;
	}

	
	/**
	 * Return the value associated with the column: bystander_mobile_no
	 */
	public java.lang.String getBystanderMobileNo () {
		return bystanderMobileNo;
	}

	/**
	 * Set the value related to the column: bystander_mobile_no
	 * @param bystanderMobileNo the bystander_mobile_no value
	 */
	public void setBystanderMobileNo (java.lang.String bystanderMobileNo) {
		this.bystanderMobileNo = bystanderMobileNo;
	}

	
	/**
	 * Return the value associated with the column: bystander_address
	 */
	public java.lang.String getBystanderAddress () {
		return bystanderAddress;
	}

	/**
	 * Set the value related to the column: bystander_address
	 * @param bystanderAddress the bystander_address value
	 */
	public void setBystanderAddress (java.lang.String bystanderAddress) {
		this.bystanderAddress = bystanderAddress;
	}


	/**
	 * Return the value associated with the column: bystander_relation
	 */
	public jkt.hms.masters.business.MasRelation getBystanderRelation () {
		return bystanderRelation;
	}

	/**
	 * Set the value related to the column: bystander_relation
	 * @param bystanderRelation the bystander_relation value
	 */
	public void setBystanderRelation (jkt.hms.masters.business.MasRelation bystanderRelation) {
		this.bystanderRelation = bystanderRelation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientLogUpdate)) return false;
		else {
			jkt.hms.masters.business.PatientLogUpdate patientLogUpdate = (jkt.hms.masters.business.PatientLogUpdate) obj;
			if (null == this.getId() || null == patientLogUpdate.getId()) return false;
			else return (this.getId().equals(patientLogUpdate.getId()));
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