package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the family_planning_gynecology table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="family_planning_gynecology"
 */

public abstract class BaseFamilyPlanningGynecology  implements Serializable {

	public static String REF = "FamilyPlanningGynecology";
	public static String PROP_MEDICAL_PRACTIONER_REFERRAL = "MedicalPractionerReferral";
	public static String PROP_AGE = "Age";
	public static String PROP_OTHERS = "Others";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RESON_FOR_FAMILY_PLANNING = "ResonForFamilyPlanning";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ADDRESS_FOR_MED_PRACT_REF = "AddressForMedPractRef";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_MEDICAL_PRACTIONER_MTP = "MedicalPractionerMtp";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VISIT_ID = "VisitId";
	public static String PROP_TYPE_OF_TERMINATION_USED = "TypeOfTerminationUsed";
	public static String PROP_GESTATION_AGE = "GestationAge";
	public static String PROP_GENDER = "Gender";
	public static String PROP_DAYS = "Days";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_HIN = "Hin";
	public static String PROP_ADDRESS_FOR_MED_PRACT_MTP = "AddressForMedPractMtp";


	// constructors
	public BaseFamilyPlanningGynecology () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFamilyPlanningGynecology (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer visitId;
	private java.lang.Integer departmentId;
	private java.lang.Integer hospitalId;
	private java.lang.String medicalPractionerReferral;
	private java.lang.String addressForMedPractRef;
	private java.lang.String addressForMedPractMtp;
	private java.lang.String patientName;
	private java.lang.String age;
	private java.lang.String gestationAge;
	private java.lang.String days;
	private java.lang.String gender;
	private java.lang.String resonForFamilyPlanning;
	private java.lang.String typeOfTerminationUsed;
	private java.lang.String others;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String medicalPractionerMtp;

	// many to one
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="family_panning_id"
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
	 * Return the value associated with the column: visit_id
	 */
	public java.lang.Integer getVisitId () {
		return visitId;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visitId the visit_id value
	 */
	public void setVisitId (java.lang.Integer visitId) {
		this.visitId = visitId;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public java.lang.Integer getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departmentId the department_id value
	 */
	public void setDepartmentId (java.lang.Integer departmentId) {
		this.departmentId = departmentId;
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
	 * Return the value associated with the column: medical_practioner_referral
	 */
	public java.lang.String getMedicalPractionerReferral () {
		return medicalPractionerReferral;
	}

	/**
	 * Set the value related to the column: medical_practioner_referral
	 * @param medicalPractionerReferral the medical_practioner_referral value
	 */
	public void setMedicalPractionerReferral (java.lang.String medicalPractionerReferral) {
		this.medicalPractionerReferral = medicalPractionerReferral;
	}



	/**
	 * Return the value associated with the column: address_for_med_pract_ref
	 */
	public java.lang.String getAddressForMedPractRef () {
		return addressForMedPractRef;
	}

	/**
	 * Set the value related to the column: address_for_med_pract_ref
	 * @param addressForMedPractRef the address_for_med_pract_ref value
	 */
	public void setAddressForMedPractRef (java.lang.String addressForMedPractRef) {
		this.addressForMedPractRef = addressForMedPractRef;
	}



	/**
	 * Return the value associated with the column: address_for_med_pract_mtp
	 */
	public java.lang.String getAddressForMedPractMtp () {
		return addressForMedPractMtp;
	}

	/**
	 * Set the value related to the column: address_for_med_pract_mtp
	 * @param addressForMedPractMtp the address_for_med_pract_mtp value
	 */
	public void setAddressForMedPractMtp (java.lang.String addressForMedPractMtp) {
		this.addressForMedPractMtp = addressForMedPractMtp;
	}



	/**
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * @param patientName the patient_name value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
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
	 * Return the value associated with the column: gestation_age
	 */
	public java.lang.String getGestationAge () {
		return gestationAge;
	}

	/**
	 * Set the value related to the column: gestation_age
	 * @param gestationAge the gestation_age value
	 */
	public void setGestationAge (java.lang.String gestationAge) {
		this.gestationAge = gestationAge;
	}



	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.String getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.String days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (java.lang.String gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: reson_for_family_planning
	 */
	public java.lang.String getResonForFamilyPlanning () {
		return resonForFamilyPlanning;
	}

	/**
	 * Set the value related to the column: reson_for_family_planning
	 * @param resonForFamilyPlanning the reson_for_family_planning value
	 */
	public void setResonForFamilyPlanning (java.lang.String resonForFamilyPlanning) {
		this.resonForFamilyPlanning = resonForFamilyPlanning;
	}



	/**
	 * Return the value associated with the column: type_of_termination_used
	 */
	public java.lang.String getTypeOfTerminationUsed () {
		return typeOfTerminationUsed;
	}

	/**
	 * Set the value related to the column: type_of_termination_used
	 * @param typeOfTerminationUsed the type_of_termination_used value
	 */
	public void setTypeOfTerminationUsed (java.lang.String typeOfTerminationUsed) {
		this.typeOfTerminationUsed = typeOfTerminationUsed;
	}



	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.String getOthers () {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * @param others the others value
	 */
	public void setOthers (java.lang.String others) {
		this.others = others;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: medical_practioner_mtp
	 */
	public java.lang.String getMedicalPractionerMtp () {
		return medicalPractionerMtp;
	}

	/**
	 * Set the value related to the column: medical_practioner_mtp
	 * @param medicalPractionerMtp the medical_practioner_mtp value
	 */
	public void setMedicalPractionerMtp (java.lang.String medicalPractionerMtp) {
		this.medicalPractionerMtp = medicalPractionerMtp;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FamilyPlanningGynecology)) return false;
		else {
			jkt.hms.masters.business.FamilyPlanningGynecology familyPlanningGynecology = (jkt.hms.masters.business.FamilyPlanningGynecology) obj;
			if (null == this.getId() || null == familyPlanningGynecology.getId()) return false;
			else return (this.getId().equals(familyPlanningGynecology.getId()));
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