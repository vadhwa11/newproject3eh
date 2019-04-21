package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_template_treatment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_template_treatment"
 */

public abstract class BaseOpdTemplateTreatment  implements Serializable {

	public static String REF = "OpdTemplateTreatment";
	public static String PROP_GE_SNOMED_CODE = "GeSnomedCode";
	public static String PROP_GENERAL_EXAMINATION = "GeneralExamination";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRESENT_COMPLAINT_HISTORY = "PresentComplaintHistory";
	public static String PROP_MEDICATION_HISTORY = "MedicationHistory";
	public static String PROP_OPD_INSTRUCTION_TREATMENT = "OpdInstructionTreatment";
	public static String PROP_FAMILY_HIS_SNOMED_CODE = "FamilyHisSnomedCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_DURATION = "Duration";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_NOOFDAYS = "Noofdays";
	public static String PROP_ROUTE = "Route";
	public static String PROP_MEDICATION_HIS_SNOMED_CODE = "MedicationHisSnomedCode";
	public static String PROP_TEMPLATE = "Template";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_PAST_ILLNESS_HISTORY = "PastIllnessHistory";
	public static String PROP_SYS_SNOMED_CODE = "SysSnomedCode";
	public static String PROP_PERSONAL_HIS_SNOMED_CODE = "PersonalHisSnomedCode";
	public static String PROP_SYSTEMIC_EXAMINATION = "SystemicExamination";
	public static String PROP_STATUS = "Status";
	public static String PROP_PRESENT_COMPLAINT_SNOMED_CODE = "PresentComplaintSnomedCode";
	public static String PROP_DOSAGE = "Dosage";
	public static String PROP_LOCAL_EXAMINATION = "LocalExamination";
	public static String PROP_PAST_ILLNEST_SNOMED_CODE = "PastIllnestSnomedCode";
	public static String PROP_SPL_INSTRUCTION = "SplInstruction";
	public static String PROP_ID = "Id";
	public static String PROP_PERSONAL_HISTORY = "PersonalHistory";
	public static String PROP_LOCAL_EXAM_SNOMED_CODE = "LocalExamSnomedCode";
	public static String PROP_TOTAL = "Total";


	// constructors
	public BaseOpdTemplateTreatment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdTemplateTreatment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dosage;
	private java.lang.Integer noofdays;
	private java.lang.Integer total;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String generalExamination;
	private java.lang.String systemicExamination;
	private java.lang.String presentComplaintHistory;
	private java.lang.String pastIllnessHistory;
	private java.lang.String personalHistory;
	private java.lang.String familyHistory;
	private java.lang.String medicationHistory;
	private java.lang.String localExamination;
	private java.lang.String splInstruction;
	private java.lang.Long geSnomedCode;
	private java.lang.Long sysSnomedCode;
	private java.lang.Long presentComplaintSnomedCode;
	private java.lang.Long pastIllnestSnomedCode;
	private java.lang.Long personalHisSnomedCode;
	private java.lang.Long familyHisSnomedCode;
	private java.lang.Long medicationHisSnomedCode;
	private java.lang.Long localExamSnomedCode;
	private java.lang.String duration;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.RouteOfAdministration route;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.OpdTemplate template;
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.OpdInstructionTreatment opdInstructionTreatment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="treatment_template_id"
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
	 * Return the value associated with the column: dosage
	 */
	public java.lang.String getDosage () {
		return dosage;
	}

	/**
	 * Set the value related to the column: dosage
	 * @param dosage the dosage value
	 */
	public void setDosage (java.lang.String dosage) {
		this.dosage = dosage;
	}



	/**
	 * Return the value associated with the column: noofdays
	 */
	public java.lang.Integer getNoofdays () {
		return noofdays;
	}

	/**
	 * Set the value related to the column: noofdays
	 * @param noofdays the noofdays value
	 */
	public void setNoofdays (java.lang.Integer noofdays) {
		this.noofdays = noofdays;
	}



	/**
	 * Return the value associated with the column: total
	 */
	public java.lang.Integer getTotal () {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * @param total the total value
	 */
	public void setTotal (java.lang.Integer total) {
		this.total = total;
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
	 * Return the value associated with the column: general_examination
	 */
	public java.lang.String getGeneralExamination () {
		return generalExamination;
	}

	/**
	 * Set the value related to the column: general_examination
	 * @param generalExamination the general_examination value
	 */
	public void setGeneralExamination (java.lang.String generalExamination) {
		this.generalExamination = generalExamination;
	}



	/**
	 * Return the value associated with the column: systemic_examination
	 */
	public java.lang.String getSystemicExamination () {
		return systemicExamination;
	}

	/**
	 * Set the value related to the column: systemic_examination
	 * @param systemicExamination the systemic_examination value
	 */
	public void setSystemicExamination (java.lang.String systemicExamination) {
		this.systemicExamination = systemicExamination;
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
	 * Return the value associated with the column: personal_history
	 */
	public java.lang.String getPersonalHistory () {
		return personalHistory;
	}

	/**
	 * Set the value related to the column: personal_history
	 * @param personalHistory the personal_history value
	 */
	public void setPersonalHistory (java.lang.String personalHistory) {
		this.personalHistory = personalHistory;
	}



	/**
	 * Return the value associated with the column: family_history
	 */
	public java.lang.String getFamilyHistory () {
		return familyHistory;
	}

	/**
	 * Set the value related to the column: family_history
	 * @param familyHistory the family_history value
	 */
	public void setFamilyHistory (java.lang.String familyHistory) {
		this.familyHistory = familyHistory;
	}



	/**
	 * Return the value associated with the column: medication_history
	 */
	public java.lang.String getMedicationHistory () {
		return medicationHistory;
	}

	/**
	 * Set the value related to the column: medication_history
	 * @param medicationHistory the medication_history value
	 */
	public void setMedicationHistory (java.lang.String medicationHistory) {
		this.medicationHistory = medicationHistory;
	}



	/**
	 * Return the value associated with the column: local_examination
	 */
	public java.lang.String getLocalExamination () {
		return localExamination;
	}

	/**
	 * Set the value related to the column: local_examination
	 * @param localExamination the local_examination value
	 */
	public void setLocalExamination (java.lang.String localExamination) {
		this.localExamination = localExamination;
	}



	/**
	 * Return the value associated with the column: spl_instruction
	 */
	public java.lang.String getSplInstruction () {
		return splInstruction;
	}

	/**
	 * Set the value related to the column: spl_instruction
	 * @param splInstruction the spl_instruction value
	 */
	public void setSplInstruction (java.lang.String splInstruction) {
		this.splInstruction = splInstruction;
	}



	/**
	 * Return the value associated with the column: ge_snomed_code
	 */
	public java.lang.Long getGeSnomedCode () {
		return geSnomedCode;
	}

	/**
	 * Set the value related to the column: ge_snomed_code
	 * @param geSnomedCode the ge_snomed_code value
	 */
	public void setGeSnomedCode (java.lang.Long geSnomedCode) {
		this.geSnomedCode = geSnomedCode;
	}



	/**
	 * Return the value associated with the column: sys_snomed_code
	 */
	public java.lang.Long getSysSnomedCode () {
		return sysSnomedCode;
	}

	/**
	 * Set the value related to the column: sys_snomed_code
	 * @param sysSnomedCode the sys_snomed_code value
	 */
	public void setSysSnomedCode (java.lang.Long sysSnomedCode) {
		this.sysSnomedCode = sysSnomedCode;
	}



	/**
	 * Return the value associated with the column: present_complaint_snomed_code
	 */
	public java.lang.Long getPresentComplaintSnomedCode () {
		return presentComplaintSnomedCode;
	}

	/**
	 * Set the value related to the column: present_complaint_snomed_code
	 * @param presentComplaintSnomedCode the present_complaint_snomed_code value
	 */
	public void setPresentComplaintSnomedCode (java.lang.Long presentComplaintSnomedCode) {
		this.presentComplaintSnomedCode = presentComplaintSnomedCode;
	}



	/**
	 * Return the value associated with the column: past_illnest_snomed_code
	 */
	public java.lang.Long getPastIllnestSnomedCode () {
		return pastIllnestSnomedCode;
	}

	/**
	 * Set the value related to the column: past_illnest_snomed_code
	 * @param pastIllnestSnomedCode the past_illnest_snomed_code value
	 */
	public void setPastIllnestSnomedCode (java.lang.Long pastIllnestSnomedCode) {
		this.pastIllnestSnomedCode = pastIllnestSnomedCode;
	}



	/**
	 * Return the value associated with the column: personal_his_snomed_code
	 */
	public java.lang.Long getPersonalHisSnomedCode () {
		return personalHisSnomedCode;
	}

	/**
	 * Set the value related to the column: personal_his_snomed_code
	 * @param personalHisSnomedCode the personal_his_snomed_code value
	 */
	public void setPersonalHisSnomedCode (java.lang.Long personalHisSnomedCode) {
		this.personalHisSnomedCode = personalHisSnomedCode;
	}



	/**
	 * Return the value associated with the column: family_his_snomed_code
	 */
	public java.lang.Long getFamilyHisSnomedCode () {
		return familyHisSnomedCode;
	}

	/**
	 * Set the value related to the column: family_his_snomed_code
	 * @param familyHisSnomedCode the family_his_snomed_code value
	 */
	public void setFamilyHisSnomedCode (java.lang.Long familyHisSnomedCode) {
		this.familyHisSnomedCode = familyHisSnomedCode;
	}



	/**
	 * Return the value associated with the column: medication_his_snomed_code
	 */
	public java.lang.Long getMedicationHisSnomedCode () {
		return medicationHisSnomedCode;
	}

	/**
	 * Set the value related to the column: medication_his_snomed_code
	 * @param medicationHisSnomedCode the medication_his_snomed_code value
	 */
	public void setMedicationHisSnomedCode (java.lang.Long medicationHisSnomedCode) {
		this.medicationHisSnomedCode = medicationHisSnomedCode;
	}



	/**
	 * Return the value associated with the column: local_exam_snomed_code
	 */
	public java.lang.Long getLocalExamSnomedCode () {
		return localExamSnomedCode;
	}

	/**
	 * Set the value related to the column: local_exam_snomed_code
	 * @param localExamSnomedCode the local_exam_snomed_code value
	 */
	public void setLocalExamSnomedCode (java.lang.Long localExamSnomedCode) {
		this.localExamSnomedCode = localExamSnomedCode;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
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
	 * Return the value associated with the column: route_id
	 */
	public jkt.hms.masters.business.RouteOfAdministration getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: route_id
	 * @param route the route_id value
	 */
	public void setRoute (jkt.hms.masters.business.RouteOfAdministration route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
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
	 * Return the value associated with the column: template_id
	 */
	public jkt.hms.masters.business.OpdTemplate getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param template the template_id value
	 */
	public void setTemplate (jkt.hms.masters.business.OpdTemplate template) {
		this.template = template;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: opd_instruction_treatment_id
	 */
	public jkt.hms.masters.business.OpdInstructionTreatment getOpdInstructionTreatment () {
		return opdInstructionTreatment;
	}

	/**
	 * Set the value related to the column: opd_instruction_treatment_id
	 * @param opdInstructionTreatment the opd_instruction_treatment_id value
	 */
	public void setOpdInstructionTreatment (jkt.hms.masters.business.OpdInstructionTreatment opdInstructionTreatment) {
		this.opdInstructionTreatment = opdInstructionTreatment;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdTemplateTreatment)) return false;
		else {
			jkt.hms.masters.business.OpdTemplateTreatment opdTemplateTreatment = (jkt.hms.masters.business.OpdTemplateTreatment) obj;
			if (null == this.getId() || null == opdTemplateTreatment.getId()) return false;
			else return (this.getId().equals(opdTemplateTreatment.getId()));
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