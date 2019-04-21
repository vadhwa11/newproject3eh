package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_implant_planning_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_implant_planning_header"
 */

public abstract class BaseOpdImplantPlanningHeader  implements Serializable {

	public static String REF = "OpdImplantPlanningHeader";
	public static String PROP_TMJ_FUNCTION = "TmjFunction";
	public static String PROP_SOFT_HARD_TISSUE = "SoftHardTissue";
	public static String PROP_OSTEOPLASTIES = "Osteoplasties";
	public static String PROP_GRAFTS = "Grafts";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HISTORY_OF_ALLERGY_VALUE = "HistoryOfAllergyValue";
	public static String PROP_ADJACENT_SOFT_TISSUES = "AdjacentSoftTissues";
	public static String PROP_EDENTULOUS_RIDGE = "EdentulousRidge";
	public static String PROP_AMOUNT_OF_RESORPTION = "AmountOfResorption";
	public static String PROP_VISIT = "Visit";
	public static String PROP_MEDICAL_HISTORY = "MedicalHistory";
	public static String PROP_NUMBER_VALUE = "NumberValue";
	public static String PROP_SUITABILITY_FOR_IMPLANTS = "SuitabilityForImplants";
	public static String PROP_PARAFUNCTIONAL_HABITS = "ParafunctionalHabits";
	public static String PROP_PLACEMENT_POSITION = "PlacementPosition";
	public static String PROP_BONE_QUANTITY = "BoneQuantity";
	public static String PROP_RADIOGRAPHIC_EVALUATION = "RadiographicEvaluation";
	public static String PROP_ID = "Id";
	public static String PROP_HISTORY_OF_ALLERGY = "HistoryOfAllergy";
	public static String PROP_DENTAL_HISTORY = "DentalHistory";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_TYPE_VALUE = "TypeValue";
	public static String PROP_HIN = "Hin";
	public static String PROP_GINGIVOPLASTIES = "Gingivoplasties";


	// constructors
	public BaseOpdImplantPlanningHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdImplantPlanningHeader (java.lang.Integer id) {
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
	private java.lang.String adjacentSoftTissues;
	private java.lang.String tmjFunction;
	private java.lang.String parafunctionalHabits;
	private java.lang.String edentulousRidge;
	private java.lang.String amountOfResorption;
	private java.lang.String softHardTissue;
	private java.lang.String suitabilityForImplants;
	private java.lang.String radiographicEvaluation;
	private java.lang.String boneQuantity;
	private java.lang.String grafts;
	private java.lang.String osteoplasties;
	private java.lang.String gingivoplasties;
	private java.lang.String typeValue;
	private java.lang.String numberValue;
	private java.lang.String placementPosition;

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
     *  column="implant_planning_header_id"
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
	 * Return the value associated with the column: adjacent_soft_tissues
	 */
	public java.lang.String getAdjacentSoftTissues () {
		return adjacentSoftTissues;
	}

	/**
	 * Set the value related to the column: adjacent_soft_tissues
	 * @param adjacentSoftTissues the adjacent_soft_tissues value
	 */
	public void setAdjacentSoftTissues (java.lang.String adjacentSoftTissues) {
		this.adjacentSoftTissues = adjacentSoftTissues;
	}



	/**
	 * Return the value associated with the column: tmj_function
	 */
	public java.lang.String getTmjFunction () {
		return tmjFunction;
	}

	/**
	 * Set the value related to the column: tmj_function
	 * @param tmjFunction the tmj_function value
	 */
	public void setTmjFunction (java.lang.String tmjFunction) {
		this.tmjFunction = tmjFunction;
	}



	/**
	 * Return the value associated with the column: parafunctional_habits
	 */
	public java.lang.String getParafunctionalHabits () {
		return parafunctionalHabits;
	}

	/**
	 * Set the value related to the column: parafunctional_habits
	 * @param parafunctionalHabits the parafunctional_habits value
	 */
	public void setParafunctionalHabits (java.lang.String parafunctionalHabits) {
		this.parafunctionalHabits = parafunctionalHabits;
	}



	/**
	 * Return the value associated with the column: edentulous_ridge
	 */
	public java.lang.String getEdentulousRidge () {
		return edentulousRidge;
	}

	/**
	 * Set the value related to the column: edentulous_ridge
	 * @param edentulousRidge the edentulous_ridge value
	 */
	public void setEdentulousRidge (java.lang.String edentulousRidge) {
		this.edentulousRidge = edentulousRidge;
	}



	/**
	 * Return the value associated with the column: amount_of_resorption
	 */
	public java.lang.String getAmountOfResorption () {
		return amountOfResorption;
	}

	/**
	 * Set the value related to the column: amount_of_resorption
	 * @param amountOfResorption the amount_of_resorption value
	 */
	public void setAmountOfResorption (java.lang.String amountOfResorption) {
		this.amountOfResorption = amountOfResorption;
	}



	/**
	 * Return the value associated with the column: soft_hard_tissue
	 */
	public java.lang.String getSoftHardTissue () {
		return softHardTissue;
	}

	/**
	 * Set the value related to the column: soft_hard_tissue
	 * @param softHardTissue the soft_hard_tissue value
	 */
	public void setSoftHardTissue (java.lang.String softHardTissue) {
		this.softHardTissue = softHardTissue;
	}



	/**
	 * Return the value associated with the column: suitability_for_implants
	 */
	public java.lang.String getSuitabilityForImplants () {
		return suitabilityForImplants;
	}

	/**
	 * Set the value related to the column: suitability_for_implants
	 * @param suitabilityForImplants the suitability_for_implants value
	 */
	public void setSuitabilityForImplants (java.lang.String suitabilityForImplants) {
		this.suitabilityForImplants = suitabilityForImplants;
	}



	/**
	 * Return the value associated with the column: radiographic_evaluation
	 */
	public java.lang.String getRadiographicEvaluation () {
		return radiographicEvaluation;
	}

	/**
	 * Set the value related to the column: radiographic_evaluation
	 * @param radiographicEvaluation the radiographic_evaluation value
	 */
	public void setRadiographicEvaluation (java.lang.String radiographicEvaluation) {
		this.radiographicEvaluation = radiographicEvaluation;
	}



	/**
	 * Return the value associated with the column: bone_quantity
	 */
	public java.lang.String getBoneQuantity () {
		return boneQuantity;
	}

	/**
	 * Set the value related to the column: bone_quantity
	 * @param boneQuantity the bone_quantity value
	 */
	public void setBoneQuantity (java.lang.String boneQuantity) {
		this.boneQuantity = boneQuantity;
	}



	/**
	 * Return the value associated with the column: grafts
	 */
	public java.lang.String getGrafts () {
		return grafts;
	}

	/**
	 * Set the value related to the column: grafts
	 * @param grafts the grafts value
	 */
	public void setGrafts (java.lang.String grafts) {
		this.grafts = grafts;
	}



	/**
	 * Return the value associated with the column: osteoplasties
	 */
	public java.lang.String getOsteoplasties () {
		return osteoplasties;
	}

	/**
	 * Set the value related to the column: osteoplasties
	 * @param osteoplasties the osteoplasties value
	 */
	public void setOsteoplasties (java.lang.String osteoplasties) {
		this.osteoplasties = osteoplasties;
	}



	/**
	 * Return the value associated with the column: gingivoplasties
	 */
	public java.lang.String getGingivoplasties () {
		return gingivoplasties;
	}

	/**
	 * Set the value related to the column: gingivoplasties
	 * @param gingivoplasties the gingivoplasties value
	 */
	public void setGingivoplasties (java.lang.String gingivoplasties) {
		this.gingivoplasties = gingivoplasties;
	}



	/**
	 * Return the value associated with the column: type_value
	 */
	public java.lang.String getTypeValue () {
		return typeValue;
	}

	/**
	 * Set the value related to the column: type_value
	 * @param typeValue the type_value value
	 */
	public void setTypeValue (java.lang.String typeValue) {
		this.typeValue = typeValue;
	}



	/**
	 * Return the value associated with the column: number_value
	 */
	public java.lang.String getNumberValue () {
		return numberValue;
	}

	/**
	 * Set the value related to the column: number_value
	 * @param numberValue the number_value value
	 */
	public void setNumberValue (java.lang.String numberValue) {
		this.numberValue = numberValue;
	}



	/**
	 * Return the value associated with the column: placement_position
	 */
	public java.lang.String getPlacementPosition () {
		return placementPosition;
	}

	/**
	 * Set the value related to the column: placement_position
	 * @param placementPosition the placement_position value
	 */
	public void setPlacementPosition (java.lang.String placementPosition) {
		this.placementPosition = placementPosition;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdImplantPlanningHeader)) return false;
		else {
			jkt.hms.masters.business.OpdImplantPlanningHeader opdImplantPlanningHeader = (jkt.hms.masters.business.OpdImplantPlanningHeader) obj;
			if (null == this.getId() || null == opdImplantPlanningHeader.getId()) return false;
			else return (this.getId().equals(opdImplantPlanningHeader.getId()));
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