package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_medical_record table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_medical_record"
 */

public abstract class BaseHrMedicalRecord  implements Serializable {

	public static String REF = "HrMedicalRecord";
	public static String PROP_FIT_UNFIT_REMARKS = "FitUnfitRemarks";
	public static String PROP_OTHERS = "Others";
	public static String PROP_BLOOD_PRESSURE = "BloodPressure";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_SKIN_CONDITION = "SkinCondition";
	public static String PROP_PAST_HISTORY = "PastHistory";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_NERVOUS_SYSTEM = "NervousSystem";
	public static String PROP_RESPIRATORY_SYSTEM = "RespiratorySystem";
	public static String PROP_EMP_NAME = "EmpName";
	public static String PROP_GENITO_URINARY_SYSTEM = "GenitoUrinarySystem";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMP_CODE = "EmpCode";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_DOC_OBSERVATION_DATE = "DocObservationDate";
	public static String PROP_FIT_UNFIT = "FitUnfit";
	public static String PROP_EYESIGHT = "Eyesight";
	public static String PROP_COLOR_VISION = "ColorVision";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_ABDOMEN = "Abdomen";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_EXAM_TYPE = "ExamType";
	public static String PROP_LAST_CG_DATE = "LastCgDate";
	public static String PROP_MASCULO_GENITAL_SYSTEM = "MasculoGenitalSystem";
	public static String PROP_IDENTIFICATION_MARK = "IdentificationMark";
	public static String PROP_PATHO_EXAM_DATE = "PathoExamDate";
	public static String PROP_CHEST_X_RAY = "ChestXRay";
	public static String PROP_MOUTH_EAR_THROAT = "MouthEarThroat";
	public static String PROP_DATE_OF_BIRTH = "dateOfBirth";
	public static String PROP_ADDL_REMARKS = "AddlRemarks";
	public static String PROP_BLOOD = "Blood";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_URINE = "Urine";
	public static String PROP_CARDIOVASCULAR_SYSTEM = "CardiovascularSystem";
	public static String PROP_PRESENT_COMPLAIN = "PresentComplain";
	public static String PROP_ID = "Id";
	public static String PROP_PHYSICAL_EXAM_DATE = "PhysicalExamDate";
	public static String PROP_ANY_OTHER_TEST = "AnyOtherTest";
	public static String PROP_PERSONAL_HABITS = "PersonalHabits";


	// constructors
	public BaseHrMedicalRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMedicalRecord (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrMedicalRecord (
		java.lang.Integer id,
		jkt.hms.masters.business.MasBloodGroup bloodGroup,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasEmployee doctor,
		jkt.hms.masters.business.MasHospital hospitalId,
		java.lang.Integer examType,
		java.lang.String empName) {

		this.setId(id);
		this.setBloodGroup(bloodGroup);
		this.setDepartment(department);
		this.setDoctor(doctor);
		this.setHospitalId(hospitalId);
		this.setExamType(examType);
		this.setEmpName(empName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer examType;
	private java.lang.String empName;
	private java.lang.String empCode;
	private java.lang.String height;
	private java.lang.String identificationMark;
	private java.util.Date physicalExamDate;
	private java.lang.String pastHistory;
	private java.lang.String personalHabits;
	private java.lang.String familyHistory;
	private java.lang.String presentComplain;
	private java.lang.Integer weight;
	private java.lang.String eyesight;
	private java.lang.String colorVision;
	private java.lang.String others;
	private java.lang.String mouthEarThroat;
	private java.lang.String skinCondition;
	private java.lang.String respiratorySystem;
	private java.lang.String cardiovascularSystem;
	private java.lang.String bloodPressure;
	private java.lang.String abdomen;
	private java.lang.String genitoUrinarySystem;
	private java.lang.String masculoGenitalSystem;
	private java.lang.String nervousSystem;
	private java.util.Date pathoExamDate;
	private java.lang.String chestXRay;
	private java.lang.String blood;
	private java.lang.String urine;
	private java.lang.String anyOtherTest;
	private java.util.Date docObservationDate;
	private java.lang.String addlRemarks;
	private java.lang.Integer fitUnfit;
	private java.lang.String fitUnfitRemarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastCgDate;
	private java.lang.String lastChgTime;
	private java.util.Date dateOfBirth;

	// many to one
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="hr_medical_record_id"
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
	 * Return the value associated with the column: exam_type
	 */
	public java.lang.Integer getExamType () {
		return examType;
	}

	/**
	 * Set the value related to the column: exam_type
	 * @param examType the exam_type value
	 */
	public void setExamType (java.lang.Integer examType) {
		this.examType = examType;
	}



	/**
	 * Return the value associated with the column: empName
	 */
	public java.lang.String getEmpName () {
		return empName;
	}

	/**
	 * Set the value related to the column: empName
	 * @param empName the empName value
	 */
	public void setEmpName (java.lang.String empName) {
		this.empName = empName;
	}



	/**
	 * Return the value associated with the column: empCode
	 */
	public java.lang.String getEmpCode () {
		return empCode;
	}

	/**
	 * Set the value related to the column: empCode
	 * @param empCode the empCode value
	 */
	public void setEmpCode (java.lang.String empCode) {
		this.empCode = empCode;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.String height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: identification_mark
	 */
	public java.lang.String getIdentificationMark () {
		return identificationMark;
	}

	/**
	 * Set the value related to the column: identification_mark
	 * @param identificationMark the identification_mark value
	 */
	public void setIdentificationMark (java.lang.String identificationMark) {
		this.identificationMark = identificationMark;
	}



	/**
	 * Return the value associated with the column: physical_exam_date
	 */
	public java.util.Date getPhysicalExamDate () {
		return physicalExamDate;
	}

	/**
	 * Set the value related to the column: physical_exam_date
	 * @param physicalExamDate the physical_exam_date value
	 */
	public void setPhysicalExamDate (java.util.Date physicalExamDate) {
		this.physicalExamDate = physicalExamDate;
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
	 * Return the value associated with the column: personal_habits
	 */
	public java.lang.String getPersonalHabits () {
		return personalHabits;
	}

	/**
	 * Set the value related to the column: personal_habits
	 * @param personalHabits the personal_habits value
	 */
	public void setPersonalHabits (java.lang.String personalHabits) {
		this.personalHabits = personalHabits;
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
	 * Return the value associated with the column: weight
	 */
	public java.lang.Integer getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.Integer weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: eyesight
	 */
	public java.lang.String getEyesight () {
		return eyesight;
	}

	/**
	 * Set the value related to the column: eyesight
	 * @param eyesight the eyesight value
	 */
	public void setEyesight (java.lang.String eyesight) {
		this.eyesight = eyesight;
	}



	/**
	 * Return the value associated with the column: color_vision
	 */
	public java.lang.String getColorVision () {
		return colorVision;
	}

	/**
	 * Set the value related to the column: color_vision
	 * @param colorVision the color_vision value
	 */
	public void setColorVision (java.lang.String colorVision) {
		this.colorVision = colorVision;
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
	 * Return the value associated with the column: mouth_ear_throat
	 */
	public java.lang.String getMouthEarThroat () {
		return mouthEarThroat;
	}

	/**
	 * Set the value related to the column: mouth_ear_throat
	 * @param mouthEarThroat the mouth_ear_throat value
	 */
	public void setMouthEarThroat (java.lang.String mouthEarThroat) {
		this.mouthEarThroat = mouthEarThroat;
	}



	/**
	 * Return the value associated with the column: skin_condition
	 */
	public java.lang.String getSkinCondition () {
		return skinCondition;
	}

	/**
	 * Set the value related to the column: skin_condition
	 * @param skinCondition the skin_condition value
	 */
	public void setSkinCondition (java.lang.String skinCondition) {
		this.skinCondition = skinCondition;
	}



	/**
	 * Return the value associated with the column: respiratory_system
	 */
	public java.lang.String getRespiratorySystem () {
		return respiratorySystem;
	}

	/**
	 * Set the value related to the column: respiratory_system
	 * @param respiratorySystem the respiratory_system value
	 */
	public void setRespiratorySystem (java.lang.String respiratorySystem) {
		this.respiratorySystem = respiratorySystem;
	}



	/**
	 * Return the value associated with the column: cardiovascular_system
	 */
	public java.lang.String getCardiovascularSystem () {
		return cardiovascularSystem;
	}

	/**
	 * Set the value related to the column: cardiovascular_system
	 * @param cardiovascularSystem the cardiovascular_system value
	 */
	public void setCardiovascularSystem (java.lang.String cardiovascularSystem) {
		this.cardiovascularSystem = cardiovascularSystem;
	}



	/**
	 * Return the value associated with the column: blood_pressure
	 */
	public java.lang.String getBloodPressure () {
		return bloodPressure;
	}

	/**
	 * Set the value related to the column: blood_pressure
	 * @param bloodPressure the blood_pressure value
	 */
	public void setBloodPressure (java.lang.String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}



	/**
	 * Return the value associated with the column: abdomen
	 */
	public java.lang.String getAbdomen () {
		return abdomen;
	}

	/**
	 * Set the value related to the column: abdomen
	 * @param abdomen the abdomen value
	 */
	public void setAbdomen (java.lang.String abdomen) {
		this.abdomen = abdomen;
	}



	/**
	 * Return the value associated with the column: genito_urinary_system
	 */
	public java.lang.String getGenitoUrinarySystem () {
		return genitoUrinarySystem;
	}

	/**
	 * Set the value related to the column: genito_urinary_system
	 * @param genitoUrinarySystem the genito_urinary_system value
	 */
	public void setGenitoUrinarySystem (java.lang.String genitoUrinarySystem) {
		this.genitoUrinarySystem = genitoUrinarySystem;
	}



	/**
	 * Return the value associated with the column: masculo_genital_system
	 */
	public java.lang.String getMasculoGenitalSystem () {
		return masculoGenitalSystem;
	}

	/**
	 * Set the value related to the column: masculo_genital_system
	 * @param masculoGenitalSystem the masculo_genital_system value
	 */
	public void setMasculoGenitalSystem (java.lang.String masculoGenitalSystem) {
		this.masculoGenitalSystem = masculoGenitalSystem;
	}



	/**
	 * Return the value associated with the column: nervous_system
	 */
	public java.lang.String getNervousSystem () {
		return nervousSystem;
	}

	/**
	 * Set the value related to the column: nervous_system
	 * @param nervousSystem the nervous_system value
	 */
	public void setNervousSystem (java.lang.String nervousSystem) {
		this.nervousSystem = nervousSystem;
	}



	/**
	 * Return the value associated with the column: patho_exam_date
	 */
	public java.util.Date getPathoExamDate () {
		return pathoExamDate;
	}

	/**
	 * Set the value related to the column: patho_exam_date
	 * @param pathoExamDate the patho_exam_date value
	 */
	public void setPathoExamDate (java.util.Date pathoExamDate) {
		this.pathoExamDate = pathoExamDate;
	}



	/**
	 * Return the value associated with the column: chest_x_ray
	 */
	public java.lang.String getChestXRay () {
		return chestXRay;
	}

	/**
	 * Set the value related to the column: chest_x_ray
	 * @param chestXRay the chest_x_ray value
	 */
	public void setChestXRay (java.lang.String chestXRay) {
		this.chestXRay = chestXRay;
	}



	/**
	 * Return the value associated with the column: blood
	 */
	public java.lang.String getBlood () {
		return blood;
	}

	/**
	 * Set the value related to the column: blood
	 * @param blood the blood value
	 */
	public void setBlood (java.lang.String blood) {
		this.blood = blood;
	}



	/**
	 * Return the value associated with the column: urine
	 */
	public java.lang.String getUrine () {
		return urine;
	}

	/**
	 * Set the value related to the column: urine
	 * @param urine the urine value
	 */
	public void setUrine (java.lang.String urine) {
		this.urine = urine;
	}



	/**
	 * Return the value associated with the column: any_other_test
	 */
	public java.lang.String getAnyOtherTest () {
		return anyOtherTest;
	}

	/**
	 * Set the value related to the column: any_other_test
	 * @param anyOtherTest the any_other_test value
	 */
	public void setAnyOtherTest (java.lang.String anyOtherTest) {
		this.anyOtherTest = anyOtherTest;
	}



	/**
	 * Return the value associated with the column: doc_observation_date
	 */
	public java.util.Date getDocObservationDate () {
		return docObservationDate;
	}

	/**
	 * Set the value related to the column: doc_observation_date
	 * @param docObservationDate the doc_observation_date value
	 */
	public void setDocObservationDate (java.util.Date docObservationDate) {
		this.docObservationDate = docObservationDate;
	}



	/**
	 * Return the value associated with the column: addl_remarks
	 */
	public java.lang.String getAddlRemarks () {
		return addlRemarks;
	}

	/**
	 * Set the value related to the column: addl_remarks
	 * @param addlRemarks the addl_remarks value
	 */
	public void setAddlRemarks (java.lang.String addlRemarks) {
		this.addlRemarks = addlRemarks;
	}



	/**
	 * Return the value associated with the column: fit_unfit
	 */
	public java.lang.Integer getFitUnfit () {
		return fitUnfit;
	}

	/**
	 * Set the value related to the column: fit_unfit
	 * @param fitUnfit the fit_unfit value
	 */
	public void setFitUnfit (java.lang.Integer fitUnfit) {
		this.fitUnfit = fitUnfit;
	}



	/**
	 * Return the value associated with the column: fit_unfit_remarks
	 */
	public java.lang.String getFitUnfitRemarks () {
		return fitUnfitRemarks;
	}

	/**
	 * Set the value related to the column: fit_unfit_remarks
	 * @param fitUnfitRemarks the fit_unfit_remarks value
	 */
	public void setFitUnfitRemarks (java.lang.String fitUnfitRemarks) {
		this.fitUnfitRemarks = fitUnfitRemarks;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_cg_date
	 */
	public java.util.Date getLastCgDate () {
		return lastCgDate;
	}

	/**
	 * Set the value related to the column: last_cg_date
	 * @param lastCgDate the last_cg_date value
	 */
	public void setLastCgDate (java.util.Date lastCgDate) {
		this.lastCgDate = lastCgDate;
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
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMedicalRecord)) return false;
		else {
			jkt.hms.masters.business.HrMedicalRecord hrMedicalRecord = (jkt.hms.masters.business.HrMedicalRecord) obj;
			if (null == this.getId() || null == hrMedicalRecord.getId()) return false;
			else return (this.getId().equals(hrMedicalRecord.getId()));
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