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
	public static String PROP_PATIENT_OLD_DATE_OF_BIRTH = "PatientOldDateOfBirth";
	public static String PROP_TIME_OF_UPDATE = "TimeOfUpdate";
	public static String PROP_PATIENT_OLD_INCOME_REMARKS = "PatientOldIncomeRemarks";
	public static String PROP_DATE_OF_UPDATE = "DateOfUpdate";
	public static String PROP_PATIENT_OLD_AGE = "PatientOldAge";
	public static String PROP_EMPLOYEE_DEPT_NO = "EmployeeDeptNo";
	public static String PROP_PATIENT_OLD_NAME = "PatientOldName";
	public static String PROP_PATIENT_OLD_GENDER = "PatientOldGender";
	public static String PROP_PATIENT_OLD_DISTRICT = "PatientOldDistrict";
	public static String PROP_PATIENT_OLD_RELATION = "PatientOldRelation";
	public static String PROP_PATIENT_PATIENT_LOG_UPDATE_HIN = "PatientPatientLogUpdateHin";
	public static String PROP_ID = "Id";
	public static String PROP_PATIENT_OLD_AREA = "PatientOldArea";
	public static String PROP_PATIENT_OLD_MONTHLY_INCOME = "PatientOldMonthlyIncome";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";


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
	private java.lang.String employeeId;
	private java.lang.String employeeDeptNo;
	private java.util.Date dateOfUpdate;
	private java.lang.String timeOfUpdate;

	// many to one
	private jkt.hms.masters.business.Patient patientPatientLogUpdateHin;



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
	 * Return the value associated with the column: employee_id
	 */
	public java.lang.String getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (java.lang.String employeeId) {
		this.employeeId = employeeId;
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