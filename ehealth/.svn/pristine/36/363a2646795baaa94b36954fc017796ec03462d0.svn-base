package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_fixed_prosthodontics_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_fixed_prosthodontics_header"
 */

public abstract class BaseOpdFixedProsthodonticsHeader  implements Serializable {

	public static String REF = "OpdFixedProsthodonticsHeader";
	public static String PROP_CONTINUITY_OF_LAMINA_DURA = "ContinuityOfLaminaDura";
	public static String PROP_DEVIATION_VALUE = "DeviationValue";
	public static String PROP_CROWN_ROOT_RATIO_VALUE = "CrownRootRatioValue";
	public static String PROP_RESIDUAL_ROOTS_VALUE = "ResidualRootsValue";
	public static String PROP_VERTICAL_HORIZONTAL = "VerticalHorizontal";
	public static String PROP_PAIN = "Pain";
	public static String PROP_CONTOUR_OF_GINGIVA = "ContourOfGingiva";
	public static String PROP_CONDITION_OF_PERIODONTIUM = "ConditionOfPeriodontium";
	public static String PROP_PERIAPICAL_STATUS = "PeriapicalStatus";
	public static String PROP_MEDICAL_HISTORY = "MedicalHistory";
	public static String PROP_RESIDUAL_ROOTS = "ResidualRoots";
	public static String PROP_COLOR_OF_GINGIVA = "ColorOfGingiva";
	public static String PROP_DENTAL_HISTORY = "DentalHistory";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_TREATMENT_PLANNING = "TreatmentPlanning";
	public static String PROP_PAIN_VALUE = "PainValue";
	public static String PROP_CLICKING = "Clicking";
	public static String PROP_PERIAPICAL_STATUS_VALUE = "PeriapicalStatusValue";
	public static String PROP_CROWN_ROOT_RATIO = "CrownRootRatio";
	public static String PROP_TYPE_OF_GUIDANCE = "TypeOfGuidance";
	public static String PROP_ORAL_HYGIENE_STATUS = "OralHygieneStatus";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HISTORY_OF_ALLERGY_VALUE = "HistoryOfAllergyValue";
	public static String PROP_DEVIATION = "Deviation";
	public static String PROP_VISIT = "Visit";
	public static String PROP_CONTINUITY_OF_LAMINA_DURA_VALUE = "ContinuityOfLaminaDuraValue";
	public static String PROP_ROOT_RESORPTION_VALUE = "RootResorptionValue";
	public static String PROP_CLICKING_VALUE = "ClickingValue";
	public static String PROP_ID = "Id";
	public static String PROP_HISTORY_OF_ALLERGY = "HistoryOfAllergy";
	public static String PROP_ROOT_RESORPTION = "RootResorption";
	public static String PROP_HIN = "Hin";
	public static String PROP_EXAMINATION_OF_RIDGE = "ExaminationOfRidge";
	public static String PROP_INTERFERENCES_IN_MOVEMENTS = "InterferencesInMovements";
	public static String PROP_VERTICAL_HORIZONTAL_VALUE = "VerticalHorizontalValue";


	// constructors
	public BaseOpdFixedProsthodonticsHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdFixedProsthodonticsHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String medicalHistory;
	private java.lang.String historyOfAllergy;
	private java.lang.String historyOfAllergyValue;
	private java.lang.String dentalHistory;
	private java.lang.String oralHygieneStatus;
	private java.lang.String conditionOfPeriodontium;
	private java.lang.String colorOfGingiva;
	private java.lang.String contourOfGingiva;
	private java.lang.String clicking;
	private java.lang.String clickingValue;
	private java.lang.String painValue;
	private java.lang.String pain;
	private java.lang.String deviationValue;
	private java.lang.String deviation;
	private java.lang.String typeOfGuidance;
	private java.lang.String interferencesInMovements;
	private java.lang.String residualRoots;
	private java.lang.String residualRootsValue;
	private java.lang.String periapicalStatus;
	private java.lang.String periapicalStatusValue;
	private java.lang.String rootResorption;
	private java.lang.String rootResorptionValue;
	private java.lang.String crownRootRatio;
	private java.lang.String crownRootRatioValue;
	private java.lang.String continuityOfLaminaDura;
	private java.lang.String continuityOfLaminaDuraValue;
	private java.lang.String verticalHorizontal;
	private java.lang.String verticalHorizontalValue;
	private java.lang.String examinationOfRidge;
	private java.lang.String treatmentPlanning;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdPreAssessmentClinicDental> opdPreAssessmentClinicDentals;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="fixed_prosthodontics_header_id"
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
	 * Return the value associated with the column: medical_history
	 */
	public java.lang.String getMedicalHistory () {
		return medicalHistory;
	}

	/**
	 * Set the value related to the column: medical_history
	 * @param medicalHistory the medical_history value
	 */
	public void setMedicalHistory (java.lang.String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}



	/**
	 * Return the value associated with the column: history_of_allergy
	 */
	public java.lang.String getHistoryOfAllergy () {
		return historyOfAllergy;
	}

	/**
	 * Set the value related to the column: history_of_allergy
	 * @param historyOfAllergy the history_of_allergy value
	 */
	public void setHistoryOfAllergy (java.lang.String historyOfAllergy) {
		this.historyOfAllergy = historyOfAllergy;
	}



	/**
	 * Return the value associated with the column: history_of_allergy_value
	 */
	public java.lang.String getHistoryOfAllergyValue () {
		return historyOfAllergyValue;
	}

	/**
	 * Set the value related to the column: history_of_allergy_value
	 * @param historyOfAllergyValue the history_of_allergy_value value
	 */
	public void setHistoryOfAllergyValue (java.lang.String historyOfAllergyValue) {
		this.historyOfAllergyValue = historyOfAllergyValue;
	}



	/**
	 * Return the value associated with the column: dental_history
	 */
	public java.lang.String getDentalHistory () {
		return dentalHistory;
	}

	/**
	 * Set the value related to the column: dental_history
	 * @param dentalHistory the dental_history value
	 */
	public void setDentalHistory (java.lang.String dentalHistory) {
		this.dentalHistory = dentalHistory;
	}



	/**
	 * Return the value associated with the column: oral_hygiene_status
	 */
	public java.lang.String getOralHygieneStatus () {
		return oralHygieneStatus;
	}

	/**
	 * Set the value related to the column: oral_hygiene_status
	 * @param oralHygieneStatus the oral_hygiene_status value
	 */
	public void setOralHygieneStatus (java.lang.String oralHygieneStatus) {
		this.oralHygieneStatus = oralHygieneStatus;
	}



	/**
	 * Return the value associated with the column: condition_of_periodontium
	 */
	public java.lang.String getConditionOfPeriodontium () {
		return conditionOfPeriodontium;
	}

	/**
	 * Set the value related to the column: condition_of_periodontium
	 * @param conditionOfPeriodontium the condition_of_periodontium value
	 */
	public void setConditionOfPeriodontium (java.lang.String conditionOfPeriodontium) {
		this.conditionOfPeriodontium = conditionOfPeriodontium;
	}



	/**
	 * Return the value associated with the column: color_of_gingiva
	 */
	public java.lang.String getColorOfGingiva () {
		return colorOfGingiva;
	}

	/**
	 * Set the value related to the column: color_of_gingiva
	 * @param colorOfGingiva the color_of_gingiva value
	 */
	public void setColorOfGingiva (java.lang.String colorOfGingiva) {
		this.colorOfGingiva = colorOfGingiva;
	}



	/**
	 * Return the value associated with the column: contour_of_gingiva
	 */
	public java.lang.String getContourOfGingiva () {
		return contourOfGingiva;
	}

	/**
	 * Set the value related to the column: contour_of_gingiva
	 * @param contourOfGingiva the contour_of_gingiva value
	 */
	public void setContourOfGingiva (java.lang.String contourOfGingiva) {
		this.contourOfGingiva = contourOfGingiva;
	}



	/**
	 * Return the value associated with the column: clicking
	 */
	public java.lang.String getClicking () {
		return clicking;
	}

	/**
	 * Set the value related to the column: clicking
	 * @param clicking the clicking value
	 */
	public void setClicking (java.lang.String clicking) {
		this.clicking = clicking;
	}



	/**
	 * Return the value associated with the column: clicking_value
	 */
	public java.lang.String getClickingValue () {
		return clickingValue;
	}

	/**
	 * Set the value related to the column: clicking_value
	 * @param clickingValue the clicking_value value
	 */
	public void setClickingValue (java.lang.String clickingValue) {
		this.clickingValue = clickingValue;
	}



	/**
	 * Return the value associated with the column: pain_value
	 */
	public java.lang.String getPainValue () {
		return painValue;
	}

	/**
	 * Set the value related to the column: pain_value
	 * @param painValue the pain_value value
	 */
	public void setPainValue (java.lang.String painValue) {
		this.painValue = painValue;
	}



	/**
	 * Return the value associated with the column: pain
	 */
	public java.lang.String getPain () {
		return pain;
	}

	/**
	 * Set the value related to the column: pain
	 * @param pain the pain value
	 */
	public void setPain (java.lang.String pain) {
		this.pain = pain;
	}



	/**
	 * Return the value associated with the column: deviation_value
	 */
	public java.lang.String getDeviationValue () {
		return deviationValue;
	}

	/**
	 * Set the value related to the column: deviation_value
	 * @param deviationValue the deviation_value value
	 */
	public void setDeviationValue (java.lang.String deviationValue) {
		this.deviationValue = deviationValue;
	}



	/**
	 * Return the value associated with the column: deviation
	 */
	public java.lang.String getDeviation () {
		return deviation;
	}

	/**
	 * Set the value related to the column: deviation
	 * @param deviation the deviation value
	 */
	public void setDeviation (java.lang.String deviation) {
		this.deviation = deviation;
	}



	/**
	 * Return the value associated with the column: type_of_guidance
	 */
	public java.lang.String getTypeOfGuidance () {
		return typeOfGuidance;
	}

	/**
	 * Set the value related to the column: type_of_guidance
	 * @param typeOfGuidance the type_of_guidance value
	 */
	public void setTypeOfGuidance (java.lang.String typeOfGuidance) {
		this.typeOfGuidance = typeOfGuidance;
	}



	/**
	 * Return the value associated with the column: interferences_in_movements
	 */
	public java.lang.String getInterferencesInMovements () {
		return interferencesInMovements;
	}

	/**
	 * Set the value related to the column: interferences_in_movements
	 * @param interferencesInMovements the interferences_in_movements value
	 */
	public void setInterferencesInMovements (java.lang.String interferencesInMovements) {
		this.interferencesInMovements = interferencesInMovements;
	}



	/**
	 * Return the value associated with the column: residual_roots
	 */
	public java.lang.String getResidualRoots () {
		return residualRoots;
	}

	/**
	 * Set the value related to the column: residual_roots
	 * @param residualRoots the residual_roots value
	 */
	public void setResidualRoots (java.lang.String residualRoots) {
		this.residualRoots = residualRoots;
	}



	/**
	 * Return the value associated with the column: residual_roots_value
	 */
	public java.lang.String getResidualRootsValue () {
		return residualRootsValue;
	}

	/**
	 * Set the value related to the column: residual_roots_value
	 * @param residualRootsValue the residual_roots_value value
	 */
	public void setResidualRootsValue (java.lang.String residualRootsValue) {
		this.residualRootsValue = residualRootsValue;
	}



	/**
	 * Return the value associated with the column: periapical_status
	 */
	public java.lang.String getPeriapicalStatus () {
		return periapicalStatus;
	}

	/**
	 * Set the value related to the column: periapical_status
	 * @param periapicalStatus the periapical_status value
	 */
	public void setPeriapicalStatus (java.lang.String periapicalStatus) {
		this.periapicalStatus = periapicalStatus;
	}



	/**
	 * Return the value associated with the column: periapical_status_value
	 */
	public java.lang.String getPeriapicalStatusValue () {
		return periapicalStatusValue;
	}

	/**
	 * Set the value related to the column: periapical_status_value
	 * @param periapicalStatusValue the periapical_status_value value
	 */
	public void setPeriapicalStatusValue (java.lang.String periapicalStatusValue) {
		this.periapicalStatusValue = periapicalStatusValue;
	}



	/**
	 * Return the value associated with the column: root_resorption
	 */
	public java.lang.String getRootResorption () {
		return rootResorption;
	}

	/**
	 * Set the value related to the column: root_resorption
	 * @param rootResorption the root_resorption value
	 */
	public void setRootResorption (java.lang.String rootResorption) {
		this.rootResorption = rootResorption;
	}



	/**
	 * Return the value associated with the column: root_resorption_value
	 */
	public java.lang.String getRootResorptionValue () {
		return rootResorptionValue;
	}

	/**
	 * Set the value related to the column: root_resorption_value
	 * @param rootResorptionValue the root_resorption_value value
	 */
	public void setRootResorptionValue (java.lang.String rootResorptionValue) {
		this.rootResorptionValue = rootResorptionValue;
	}



	/**
	 * Return the value associated with the column: crown_root_ratio
	 */
	public java.lang.String getCrownRootRatio () {
		return crownRootRatio;
	}

	/**
	 * Set the value related to the column: crown_root_ratio
	 * @param crownRootRatio the crown_root_ratio value
	 */
	public void setCrownRootRatio (java.lang.String crownRootRatio) {
		this.crownRootRatio = crownRootRatio;
	}



	/**
	 * Return the value associated with the column: crown_root_ratio_value
	 */
	public java.lang.String getCrownRootRatioValue () {
		return crownRootRatioValue;
	}

	/**
	 * Set the value related to the column: crown_root_ratio_value
	 * @param crownRootRatioValue the crown_root_ratio_value value
	 */
	public void setCrownRootRatioValue (java.lang.String crownRootRatioValue) {
		this.crownRootRatioValue = crownRootRatioValue;
	}



	/**
	 * Return the value associated with the column: continuity_of_lamina_dura
	 */
	public java.lang.String getContinuityOfLaminaDura () {
		return continuityOfLaminaDura;
	}

	/**
	 * Set the value related to the column: continuity_of_lamina_dura
	 * @param continuityOfLaminaDura the continuity_of_lamina_dura value
	 */
	public void setContinuityOfLaminaDura (java.lang.String continuityOfLaminaDura) {
		this.continuityOfLaminaDura = continuityOfLaminaDura;
	}



	/**
	 * Return the value associated with the column: continuity_of_lamina_dura_value
	 */
	public java.lang.String getContinuityOfLaminaDuraValue () {
		return continuityOfLaminaDuraValue;
	}

	/**
	 * Set the value related to the column: continuity_of_lamina_dura_value
	 * @param continuityOfLaminaDuraValue the continuity_of_lamina_dura_value value
	 */
	public void setContinuityOfLaminaDuraValue (java.lang.String continuityOfLaminaDuraValue) {
		this.continuityOfLaminaDuraValue = continuityOfLaminaDuraValue;
	}



	/**
	 * Return the value associated with the column: vertical_horizontal
	 */
	public java.lang.String getVerticalHorizontal () {
		return verticalHorizontal;
	}

	/**
	 * Set the value related to the column: vertical_horizontal
	 * @param verticalHorizontal the vertical_horizontal value
	 */
	public void setVerticalHorizontal (java.lang.String verticalHorizontal) {
		this.verticalHorizontal = verticalHorizontal;
	}



	/**
	 * Return the value associated with the column: vertical_horizontal_value
	 */
	public java.lang.String getVerticalHorizontalValue () {
		return verticalHorizontalValue;
	}

	/**
	 * Set the value related to the column: vertical_horizontal_value
	 * @param verticalHorizontalValue the vertical_horizontal_value value
	 */
	public void setVerticalHorizontalValue (java.lang.String verticalHorizontalValue) {
		this.verticalHorizontalValue = verticalHorizontalValue;
	}



	/**
	 * Return the value associated with the column: examination_of_ridge
	 */
	public java.lang.String getExaminationOfRidge () {
		return examinationOfRidge;
	}

	/**
	 * Set the value related to the column: examination_of_ridge
	 * @param examinationOfRidge the examination_of_ridge value
	 */
	public void setExaminationOfRidge (java.lang.String examinationOfRidge) {
		this.examinationOfRidge = examinationOfRidge;
	}



	/**
	 * Return the value associated with the column: treatment_planning
	 */
	public java.lang.String getTreatmentPlanning () {
		return treatmentPlanning;
	}

	/**
	 * Set the value related to the column: treatment_planning
	 * @param treatmentPlanning the treatment_planning value
	 */
	public void setTreatmentPlanning (java.lang.String treatmentPlanning) {
		this.treatmentPlanning = treatmentPlanning;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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



	/**
	 * Return the value associated with the column: OpdPreAssessmentClinicDentals
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPreAssessmentClinicDental> getOpdPreAssessmentClinicDentals () {
		return opdPreAssessmentClinicDentals;
	}

	/**
	 * Set the value related to the column: OpdPreAssessmentClinicDentals
	 * @param opdPreAssessmentClinicDentals the OpdPreAssessmentClinicDentals value
	 */
	public void setOpdPreAssessmentClinicDentals (java.util.Set<jkt.hms.masters.business.OpdPreAssessmentClinicDental> opdPreAssessmentClinicDentals) {
		this.opdPreAssessmentClinicDentals = opdPreAssessmentClinicDentals;
	}

	public void addToOpdPreAssessmentClinicDentals (jkt.hms.masters.business.OpdPreAssessmentClinicDental opdPreAssessmentClinicDental) {
		if (null == getOpdPreAssessmentClinicDentals()) setOpdPreAssessmentClinicDentals(new java.util.TreeSet<jkt.hms.masters.business.OpdPreAssessmentClinicDental>());
		getOpdPreAssessmentClinicDentals().add(opdPreAssessmentClinicDental);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdFixedProsthodonticsHeader)) return false;
		else {
			jkt.hms.masters.business.OpdFixedProsthodonticsHeader opdFixedProsthodonticsHeader = (jkt.hms.masters.business.OpdFixedProsthodonticsHeader) obj;
			if (null == this.getId() || null == opdFixedProsthodonticsHeader.getId()) return false;
			else return (this.getId().equals(opdFixedProsthodonticsHeader.getId()));
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