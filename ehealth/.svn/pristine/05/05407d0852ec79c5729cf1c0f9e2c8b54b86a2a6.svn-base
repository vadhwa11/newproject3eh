package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_patient_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_patient_history"
 */

public abstract class BaseOpdPatientHistory  implements Serializable {

	public static String REF = "OpdPatientHistory";
	public static String PROP_PHYSICAL_EXAMINATION = "PhysicalExamination";
	public static String PROP_SOCIO_ECONOMIC_HISTORY = "SocioEconomicHistory";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRESENT_COMPLAINT_HISTORY = "PresentComplaintHistory";
	public static String PROP_VISIT_INPATIENT_ID = "VisitInpatientId";
	public static String PROP_PERSONAL_OTHER_DETAILS = "PersonalOtherDetails";
	public static String PROP_PATIENT_LAST_ENCOUNTER_DETAILS = "PatientLastEncounterDetails";
	public static String PROP_PAST_HISTORY = "PastHistory";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_MENSTRUAL_HISTORY = "MenstrualHistory";
	public static String PROP_FAMILY_PRESENT_HISTORY = "FamilyPresentHistory";
	public static String PROP_MADICATION_HISTORY = "MadicationHistory";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_FAMILY_PRESENT_MEDICATION = "FamilyPresentMedication";
	public static String PROP_PERSONAL_PRESENT_MEDICATION = "PersonalPresentMedication";
	public static String PROP_FAMILY_PAST_HISTORY = "FamilyPastHistory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PAST_ILLNESS_HISTORY = "PastIllnessHistory";
	public static String PROP_IP_OP_PAC_STATUS = "IpOpPacStatus";
	public static String PROP_ANTENATAL_HISTORY = "AntenatalHistory";
	public static String PROP_OBSTRETIC_HISTORY = "ObstreticHistory";
	public static String PROP_COMORBIDITY_HISTORY = "ComorbidityHistory";
	public static String PROP_PERSONAL_PAST_HISTORY = "PersonalPastHistory";
	public static String PROP_PRESENT_ILLNESS = "PresentIllness";
	public static String PROP_SURGICAL_HISTORY = "SurgicalHistory";
	public static String PROP_STATUS = "Status";
	public static String PROP_DIET_HISTORY = "DietHistory";
	public static String PROP_PRESENT_COMPLAIN = "PresentComplain";
	public static String PROP_ID = "Id";
	public static String PROP_PERSONAL_PRESENT_HISTORY = "PersonalPresentHistory";
	public static String PROP_FAMILY_OTHER_DETAILS = "FamilyOtherDetails";
	public static String PROP_HIN = "Hin";
	public static String PROP_PERMORBID_PERSONALITY = "PermorbidPersonality";
	public static String PROP_DEVELOPMENT_HISTORY = "DevelopmentHistory";


	// constructors
	public BaseOpdPatientHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPatientHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer visitInpatientId;
	private java.lang.String personalPresentHistory;
	private java.lang.String familyPresentHistory;
	private java.lang.String personalPastHistory;
	private java.lang.String familyPastHistory;
	private java.lang.String surgicalHistory;
	private java.lang.String personalPresentMedication;
	private java.lang.String familyPresentMedication;
	private java.lang.String personalOtherDetails;
	private java.lang.String familyOtherDetails;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String ipOpPacStatus;
	private java.lang.String presentComplain;
	private java.lang.String presentIllness;
	private java.lang.String presentComplaintHistory;
	private java.lang.String pastIllnessHistory;
	private java.lang.String madicationHistory;
	private java.lang.String patientLastEncounterDetails;
	private java.lang.String physicalExamination;
	private java.lang.String permorbidPersonality;
	private java.lang.String comorbidityHistory;
	private java.lang.String developmentHistory;
	private java.lang.String dietHistory;
	private java.lang.String socioEconomicHistory;
	private java.lang.String pastHistory;
	private java.lang.String menstrualHistory;
	private java.lang.String obstreticHistory;
	private java.lang.String antenatalHistory;

	// many to one
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_patient_history_id"
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
	 * Return the value associated with the column: visit_inpatient_id
	 */
	public java.lang.Integer getVisitInpatientId () {
		return visitInpatientId;
	}

	/**
	 * Set the value related to the column: visit_inpatient_id
	 * @param visitInpatientId the visit_inpatient_id value
	 */
	public void setVisitInpatientId (java.lang.Integer visitInpatientId) {
		this.visitInpatientId = visitInpatientId;
	}



	/**
	 * Return the value associated with the column: personal_present_history
	 */
	public java.lang.String getPersonalPresentHistory () {
		return personalPresentHistory;
	}

	/**
	 * Set the value related to the column: personal_present_history
	 * @param personalPresentHistory the personal_present_history value
	 */
	public void setPersonalPresentHistory (java.lang.String personalPresentHistory) {
		this.personalPresentHistory = personalPresentHistory;
	}



	/**
	 * Return the value associated with the column: family_present_history
	 */
	public java.lang.String getFamilyPresentHistory () {
		return familyPresentHistory;
	}

	/**
	 * Set the value related to the column: family_present_history
	 * @param familyPresentHistory the family_present_history value
	 */
	public void setFamilyPresentHistory (java.lang.String familyPresentHistory) {
		this.familyPresentHistory = familyPresentHistory;
	}



	/**
	 * Return the value associated with the column: personal_past_history
	 */
	public java.lang.String getPersonalPastHistory () {
		return personalPastHistory;
	}

	/**
	 * Set the value related to the column: personal_past_history
	 * @param personalPastHistory the personal_past_history value
	 */
	public void setPersonalPastHistory (java.lang.String personalPastHistory) {
		this.personalPastHistory = personalPastHistory;
	}



	/**
	 * Return the value associated with the column: family_past_history
	 */
	public java.lang.String getFamilyPastHistory () {
		return familyPastHistory;
	}

	/**
	 * Set the value related to the column: family_past_history
	 * @param familyPastHistory the family_past_history value
	 */
	public void setFamilyPastHistory (java.lang.String familyPastHistory) {
		this.familyPastHistory = familyPastHistory;
	}



	/**
	 * Return the value associated with the column: surgical_history
	 */
	public java.lang.String getSurgicalHistory () {
		return surgicalHistory;
	}

	/**
	 * Set the value related to the column: surgical_history
	 * @param surgicalHistory the surgical_history value
	 */
	public void setSurgicalHistory (java.lang.String surgicalHistory) {
		this.surgicalHistory = surgicalHistory;
	}



	/**
	 * Return the value associated with the column: personal_present_medication
	 */
	public java.lang.String getPersonalPresentMedication () {
		return personalPresentMedication;
	}

	/**
	 * Set the value related to the column: personal_present_medication
	 * @param personalPresentMedication the personal_present_medication value
	 */
	public void setPersonalPresentMedication (java.lang.String personalPresentMedication) {
		this.personalPresentMedication = personalPresentMedication;
	}



	/**
	 * Return the value associated with the column: family_present_medication
	 */
	public java.lang.String getFamilyPresentMedication () {
		return familyPresentMedication;
	}

	/**
	 * Set the value related to the column: family_present_medication
	 * @param familyPresentMedication the family_present_medication value
	 */
	public void setFamilyPresentMedication (java.lang.String familyPresentMedication) {
		this.familyPresentMedication = familyPresentMedication;
	}



	/**
	 * Return the value associated with the column: personal_other_details
	 */
	public java.lang.String getPersonalOtherDetails () {
		return personalOtherDetails;
	}

	/**
	 * Set the value related to the column: personal_other_details
	 * @param personalOtherDetails the personal_other_details value
	 */
	public void setPersonalOtherDetails (java.lang.String personalOtherDetails) {
		this.personalOtherDetails = personalOtherDetails;
	}



	/**
	 * Return the value associated with the column: family_other_details
	 */
	public java.lang.String getFamilyOtherDetails () {
		return familyOtherDetails;
	}

	/**
	 * Set the value related to the column: family_other_details
	 * @param familyOtherDetails the family_other_details value
	 */
	public void setFamilyOtherDetails (java.lang.String familyOtherDetails) {
		this.familyOtherDetails = familyOtherDetails;
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
	 * Return the value associated with the column: ip_op_pac_status
	 */
	public java.lang.String getIpOpPacStatus () {
		return ipOpPacStatus;
	}

	/**
	 * Set the value related to the column: ip_op_pac_status
	 * @param ipOpPacStatus the ip_op_pac_status value
	 */
	public void setIpOpPacStatus (java.lang.String ipOpPacStatus) {
		this.ipOpPacStatus = ipOpPacStatus;
	}



	/**
	 * Return the value associated with the column: present_complain
	 */
	public java.lang.String getPresentComplain () {
		return presentComplain;
	}

	/**
	 * Set the value related to the column: present_complain
	 * @param presentComplain the present_complain value
	 */
	public void setPresentComplain (java.lang.String presentComplain) {
		this.presentComplain = presentComplain;
	}



	/**
	 * Return the value associated with the column: present_illness
	 */
	public java.lang.String getPresentIllness () {
		return presentIllness;
	}

	/**
	 * Set the value related to the column: present_illness
	 * @param presentIllness the present_illness value
	 */
	public void setPresentIllness (java.lang.String presentIllness) {
		this.presentIllness = presentIllness;
	}



	/**
	 * Return the value associated with the column: present_complaint_history
	 */
	public java.lang.String getPresentComplaintHistory () {
		return presentComplaintHistory;
	}

	/**
	 * Set the value related to the column: present_complaint_history
	 * @param presentComplaintHistory the present_complaint_history value
	 */
	public void setPresentComplaintHistory (java.lang.String presentComplaintHistory) {
		this.presentComplaintHistory = presentComplaintHistory;
	}



	/**
	 * Return the value associated with the column: past_illness_history
	 */
	public java.lang.String getPastIllnessHistory () {
		return pastIllnessHistory;
	}

	/**
	 * Set the value related to the column: past_illness_history
	 * @param pastIllnessHistory the past_illness_history value
	 */
	public void setPastIllnessHistory (java.lang.String pastIllnessHistory) {
		this.pastIllnessHistory = pastIllnessHistory;
	}



	/**
	 * Return the value associated with the column: madication_history
	 */
	public java.lang.String getMadicationHistory () {
		return madicationHistory;
	}

	/**
	 * Set the value related to the column: madication_history
	 * @param madicationHistory the madication_history value
	 */
	public void setMadicationHistory (java.lang.String madicationHistory) {
		this.madicationHistory = madicationHistory;
	}



	/**
	 * Return the value associated with the column: patient_last_encounter_details
	 */
	public java.lang.String getPatientLastEncounterDetails () {
		return patientLastEncounterDetails;
	}

	/**
	 * Set the value related to the column: patient_last_encounter_details
	 * @param patientLastEncounterDetails the patient_last_encounter_details value
	 */
	public void setPatientLastEncounterDetails (java.lang.String patientLastEncounterDetails) {
		this.patientLastEncounterDetails = patientLastEncounterDetails;
	}



	/**
	 * Return the value associated with the column: physical_examination
	 */
	public java.lang.String getPhysicalExamination () {
		return physicalExamination;
	}

	/**
	 * Set the value related to the column: physical_examination
	 * @param physicalExamination the physical_examination value
	 */
	public void setPhysicalExamination (java.lang.String physicalExamination) {
		this.physicalExamination = physicalExamination;
	}



	/**
	 * Return the value associated with the column: permorbid_personality
	 */
	public java.lang.String getPermorbidPersonality () {
		return permorbidPersonality;
	}

	/**
	 * Set the value related to the column: permorbid_personality
	 * @param permorbidPersonality the permorbid_personality value
	 */
	public void setPermorbidPersonality (java.lang.String permorbidPersonality) {
		this.permorbidPersonality = permorbidPersonality;
	}



	/**
	 * Return the value associated with the column: comorbidity_history
	 */
	public java.lang.String getComorbidityHistory () {
		return comorbidityHistory;
	}

	/**
	 * Set the value related to the column: comorbidity_history
	 * @param comorbidityHistory the comorbidity_history value
	 */
	public void setComorbidityHistory (java.lang.String comorbidityHistory) {
		this.comorbidityHistory = comorbidityHistory;
	}



	/**
	 * Return the value associated with the column: development_history
	 */
	public java.lang.String getDevelopmentHistory () {
		return developmentHistory;
	}

	/**
	 * Set the value related to the column: development_history
	 * @param developmentHistory the development_history value
	 */
	public void setDevelopmentHistory (java.lang.String developmentHistory) {
		this.developmentHistory = developmentHistory;
	}



	/**
	 * Return the value associated with the column: diet_history
	 */
	public java.lang.String getDietHistory () {
		return dietHistory;
	}

	/**
	 * Set the value related to the column: diet_history
	 * @param dietHistory the diet_history value
	 */
	public void setDietHistory (java.lang.String dietHistory) {
		this.dietHistory = dietHistory;
	}



	/**
	 * Return the value associated with the column: socio_economic_history
	 */
	public java.lang.String getSocioEconomicHistory () {
		return socioEconomicHistory;
	}

	/**
	 * Set the value related to the column: socio_economic_history
	 * @param socioEconomicHistory the socio_economic_history value
	 */
	public void setSocioEconomicHistory (java.lang.String socioEconomicHistory) {
		this.socioEconomicHistory = socioEconomicHistory;
	}



	/**
	 * Return the value associated with the column: past_history
	 */
	public java.lang.String getPastHistory () {
		return pastHistory;
	}

	/**
	 * Set the value related to the column: past_history
	 * @param pastHistory the past_history value
	 */
	public void setPastHistory (java.lang.String pastHistory) {
		this.pastHistory = pastHistory;
	}



	/**
	 * Return the value associated with the column: menstrual_history
	 */
	public java.lang.String getMenstrualHistory () {
		return menstrualHistory;
	}

	/**
	 * Set the value related to the column: menstrual_history
	 * @param menstrualHistory the menstrual_history value
	 */
	public void setMenstrualHistory (java.lang.String menstrualHistory) {
		this.menstrualHistory = menstrualHistory;
	}



	/**
	 * Return the value associated with the column: obstretic_history
	 */
	public java.lang.String getObstreticHistory () {
		return obstreticHistory;
	}

	/**
	 * Set the value related to the column: obstretic_history
	 * @param obstreticHistory the obstretic_history value
	 */
	public void setObstreticHistory (java.lang.String obstreticHistory) {
		this.obstreticHistory = obstreticHistory;
	}



	/**
	 * Return the value associated with the column: antenatal_history
	 */
	public java.lang.String getAntenatalHistory () {
		return antenatalHistory;
	}

	/**
	 * Set the value related to the column: antenatal_history
	 * @param antenatalHistory the antenatal_history value
	 */
	public void setAntenatalHistory (java.lang.String antenatalHistory) {
		this.antenatalHistory = antenatalHistory;
	}



	/**
	 * Return the value associated with the column: opd_patient_details
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details
	 * @param opdPatientDetails the opd_patient_details value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdPatientHistory)) return false;
		else {
			jkt.hms.masters.business.OpdPatientHistory opdPatientHistory = (jkt.hms.masters.business.OpdPatientHistory) obj;
			if (null == this.getId() || null == opdPatientHistory.getId()) return false;
			else return (this.getId().equals(opdPatientHistory.getId()));
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