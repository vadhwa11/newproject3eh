package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_maxillofacial_trauma_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_maxillofacial_trauma_header"
 */

public abstract class BaseOpdMaxillofacialTraumaHeader  implements Serializable {

	public static String REF = "OpdMaxillofacialTraumaHeader";
	public static String PROP_DIFFICULTY_IN_MASTICATION = "DifficultyInMastication";
	public static String PROP_MANDIBLE_FRACTURE = "MandibleFracture";
	public static String PROP_EAR_BLEED = "EarBleed";
	public static String PROP_CASE_OF_INJURY = "CaseOfInjury";
	public static String PROP_SUBLINGUAL_HEMATOMA = "sublingualHematoma";
	public static String PROP_SWELLING = "Swelling";
	public static String PROP_MAXILLA_FRACTURE = "MaxillaFracture";
	public static String PROP_LATERAL_JAW_MOVEMENTS = "LateralJawMovements";
	public static String PROP_MOUTH_OPENING = "MouthOpening";
	public static String PROP_DERANGED_OCCLUSION_RADIO = "DerangedOcclusionRadio";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LOSS_OF_TEETH = "LossOfTeeth";
	public static String PROP_CREPITUS_RADIO = "CrepitusRadio";
	public static String PROP_PAIN_AT_REST = "PainAtRest";
	public static String PROP_RADIO_GRAPHIC_DIAGNOSIS = "RadioGraphicDiagnosis";
	public static String PROP_SITE_OF_FRACTURE = "SiteOfFracture";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CREPITUS = "Crepitus";
	public static String PROP_OTHER_RADIGRAPHIC_VALUE = "OtherRadigraphicValue";
	public static String PROP_SUBLINGUAL_HEMATOMA_RADIO = "SublingualHematomaRadio";
	public static String PROP_LACERATION = "Laceration";
	public static String PROP_VISIT = "Visit";
	public static String PROP_BROKEN_TEETH = "BrokenTeeth";
	public static String PROP_STEP_DEFECT_ON_PALPATION = "StepDefectOnPalpation";
	public static String PROP_INTRA_ORAL_BLEED = "IntraOralBleed";
	public static String PROP_DERANGED_OCCLUSION = "DerangedOcclusion";
	public static String PROP_CLINICAL_FEATURES = "ClinicalFeatures";
	public static String PROP_PAIN_ON_MOUTH_OPENING = "PainOnMouthOpening";
	public static String PROP_TENDERNESS = "Tenderness";
	public static String PROP_ID = "Id";
	public static String PROP_TRISMUS = "Trismus";
	public static String PROP_STEP_DEFECT_RADIO = "StepDefectRadio";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOpdMaxillofacialTraumaHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdMaxillofacialTraumaHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String caseOfInjury;
	private java.lang.String clinicalFeatures;
	private java.lang.String maxillaFracture;
	private java.lang.String mandibleFracture;
	private java.lang.String difficultyInMastication;
	private java.lang.String earBleed;
	private java.lang.String sublingualHematoma;
	private java.lang.String stepDefectOnPalpation;
	private java.lang.String derangedOcclusion;
	private java.lang.String crepitus;
	private java.lang.String painAtRest;
	private java.lang.String painOnMouthOpening;
	private java.lang.String swelling;
	private java.lang.String laceration;
	private java.lang.String intraOralBleed;
	private java.lang.String trismus;
	private java.lang.String brokenTeeth;
	private java.lang.String lossOfTeeth;
	private java.lang.String tenderness;
	private java.lang.String mouthOpening;
	private java.lang.String lateralJawMovements;
	private java.lang.String stepDefectRadio;
	private java.lang.String derangedOcclusionRadio;
	private java.lang.String crepitusRadio;
	private java.lang.String sublingualHematomaRadio;
	private java.lang.String otherRadigraphicValue;
	private java.lang.String siteOfFracture;
	private java.lang.String radioGraphicDiagnosis;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="maxillofacial_trauma_header_id"
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
	 * Return the value associated with the column: case_of_injury
	 */
	public java.lang.String getCaseOfInjury () {
		return caseOfInjury;
	}

	/**
	 * Set the value related to the column: case_of_injury
	 * @param caseOfInjury the case_of_injury value
	 */
	public void setCaseOfInjury (java.lang.String caseOfInjury) {
		this.caseOfInjury = caseOfInjury;
	}



	/**
	 * Return the value associated with the column: clinical_features
	 */
	public java.lang.String getClinicalFeatures () {
		return clinicalFeatures;
	}

	/**
	 * Set the value related to the column: clinical_features
	 * @param clinicalFeatures the clinical_features value
	 */
	public void setClinicalFeatures (java.lang.String clinicalFeatures) {
		this.clinicalFeatures = clinicalFeatures;
	}



	/**
	 * Return the value associated with the column: maxilla_fracture
	 */
	public java.lang.String getMaxillaFracture () {
		return maxillaFracture;
	}

	/**
	 * Set the value related to the column: maxilla_fracture
	 * @param maxillaFracture the maxilla_fracture value
	 */
	public void setMaxillaFracture (java.lang.String maxillaFracture) {
		this.maxillaFracture = maxillaFracture;
	}



	/**
	 * Return the value associated with the column: mandible_fracture
	 */
	public java.lang.String getMandibleFracture () {
		return mandibleFracture;
	}

	/**
	 * Set the value related to the column: mandible_fracture
	 * @param mandibleFracture the mandible_fracture value
	 */
	public void setMandibleFracture (java.lang.String mandibleFracture) {
		this.mandibleFracture = mandibleFracture;
	}



	/**
	 * Return the value associated with the column: difficulty_in_mastication
	 */
	public java.lang.String getDifficultyInMastication () {
		return difficultyInMastication;
	}

	/**
	 * Set the value related to the column: difficulty_in_mastication
	 * @param difficultyInMastication the difficulty_in_mastication value
	 */
	public void setDifficultyInMastication (java.lang.String difficultyInMastication) {
		this.difficultyInMastication = difficultyInMastication;
	}



	/**
	 * Return the value associated with the column: ear_bleed
	 */
	public java.lang.String getEarBleed () {
		return earBleed;
	}

	/**
	 * Set the value related to the column: ear_bleed
	 * @param earBleed the ear_bleed value
	 */
	public void setEarBleed (java.lang.String earBleed) {
		this.earBleed = earBleed;
	}



	/**
	 * Return the value associated with the column: sublingual_hematoma
	 */
	public java.lang.String getSublingualHematoma () {
		return sublingualHematoma;
	}

	/**
	 * Set the value related to the column: sublingual_hematoma
	 * @param sublingualHematoma the sublingual_hematoma value
	 */
	public void setSublingualHematoma (java.lang.String sublingualHematoma) {
		this.sublingualHematoma = sublingualHematoma;
	}



	/**
	 * Return the value associated with the column: step_defect_on_palpation
	 */
	public java.lang.String getStepDefectOnPalpation () {
		return stepDefectOnPalpation;
	}

	/**
	 * Set the value related to the column: step_defect_on_palpation
	 * @param stepDefectOnPalpation the step_defect_on_palpation value
	 */
	public void setStepDefectOnPalpation (java.lang.String stepDefectOnPalpation) {
		this.stepDefectOnPalpation = stepDefectOnPalpation;
	}



	/**
	 * Return the value associated with the column: deranged_occlusion
	 */
	public java.lang.String getDerangedOcclusion () {
		return derangedOcclusion;
	}

	/**
	 * Set the value related to the column: deranged_occlusion
	 * @param derangedOcclusion the deranged_occlusion value
	 */
	public void setDerangedOcclusion (java.lang.String derangedOcclusion) {
		this.derangedOcclusion = derangedOcclusion;
	}



	/**
	 * Return the value associated with the column: crepitus
	 */
	public java.lang.String getCrepitus () {
		return crepitus;
	}

	/**
	 * Set the value related to the column: crepitus
	 * @param crepitus the crepitus value
	 */
	public void setCrepitus (java.lang.String crepitus) {
		this.crepitus = crepitus;
	}



	/**
	 * Return the value associated with the column: pain_at_rest
	 */
	public java.lang.String getPainAtRest () {
		return painAtRest;
	}

	/**
	 * Set the value related to the column: pain_at_rest
	 * @param painAtRest the pain_at_rest value
	 */
	public void setPainAtRest (java.lang.String painAtRest) {
		this.painAtRest = painAtRest;
	}



	/**
	 * Return the value associated with the column: pain_on_mouth_opening
	 */
	public java.lang.String getPainOnMouthOpening () {
		return painOnMouthOpening;
	}

	/**
	 * Set the value related to the column: pain_on_mouth_opening
	 * @param painOnMouthOpening the pain_on_mouth_opening value
	 */
	public void setPainOnMouthOpening (java.lang.String painOnMouthOpening) {
		this.painOnMouthOpening = painOnMouthOpening;
	}



	/**
	 * Return the value associated with the column: swelling
	 */
	public java.lang.String getSwelling () {
		return swelling;
	}

	/**
	 * Set the value related to the column: swelling
	 * @param swelling the swelling value
	 */
	public void setSwelling (java.lang.String swelling) {
		this.swelling = swelling;
	}



	/**
	 * Return the value associated with the column: laceration
	 */
	public java.lang.String getLaceration () {
		return laceration;
	}

	/**
	 * Set the value related to the column: laceration
	 * @param laceration the laceration value
	 */
	public void setLaceration (java.lang.String laceration) {
		this.laceration = laceration;
	}



	/**
	 * Return the value associated with the column: intra_oral_bleed
	 */
	public java.lang.String getIntraOralBleed () {
		return intraOralBleed;
	}

	/**
	 * Set the value related to the column: intra_oral_bleed
	 * @param intraOralBleed the intra_oral_bleed value
	 */
	public void setIntraOralBleed (java.lang.String intraOralBleed) {
		this.intraOralBleed = intraOralBleed;
	}



	/**
	 * Return the value associated with the column: trismus
	 */
	public java.lang.String getTrismus () {
		return trismus;
	}

	/**
	 * Set the value related to the column: trismus
	 * @param trismus the trismus value
	 */
	public void setTrismus (java.lang.String trismus) {
		this.trismus = trismus;
	}



	/**
	 * Return the value associated with the column: broken_teeth
	 */
	public java.lang.String getBrokenTeeth () {
		return brokenTeeth;
	}

	/**
	 * Set the value related to the column: broken_teeth
	 * @param brokenTeeth the broken_teeth value
	 */
	public void setBrokenTeeth (java.lang.String brokenTeeth) {
		this.brokenTeeth = brokenTeeth;
	}



	/**
	 * Return the value associated with the column: loss_of_teeth
	 */
	public java.lang.String getLossOfTeeth () {
		return lossOfTeeth;
	}

	/**
	 * Set the value related to the column: loss_of_teeth
	 * @param lossOfTeeth the loss_of_teeth value
	 */
	public void setLossOfTeeth (java.lang.String lossOfTeeth) {
		this.lossOfTeeth = lossOfTeeth;
	}



	/**
	 * Return the value associated with the column: tenderness
	 */
	public java.lang.String getTenderness () {
		return tenderness;
	}

	/**
	 * Set the value related to the column: tenderness
	 * @param tenderness the tenderness value
	 */
	public void setTenderness (java.lang.String tenderness) {
		this.tenderness = tenderness;
	}



	/**
	 * Return the value associated with the column: mouth_opening
	 */
	public java.lang.String getMouthOpening () {
		return mouthOpening;
	}

	/**
	 * Set the value related to the column: mouth_opening
	 * @param mouthOpening the mouth_opening value
	 */
	public void setMouthOpening (java.lang.String mouthOpening) {
		this.mouthOpening = mouthOpening;
	}



	/**
	 * Return the value associated with the column: lateral_jaw_movements
	 */
	public java.lang.String getLateralJawMovements () {
		return lateralJawMovements;
	}

	/**
	 * Set the value related to the column: lateral_jaw_movements
	 * @param lateralJawMovements the lateral_jaw_movements value
	 */
	public void setLateralJawMovements (java.lang.String lateralJawMovements) {
		this.lateralJawMovements = lateralJawMovements;
	}



	/**
	 * Return the value associated with the column: step_defect_radio
	 */
	public java.lang.String getStepDefectRadio () {
		return stepDefectRadio;
	}

	/**
	 * Set the value related to the column: step_defect_radio
	 * @param stepDefectRadio the step_defect_radio value
	 */
	public void setStepDefectRadio (java.lang.String stepDefectRadio) {
		this.stepDefectRadio = stepDefectRadio;
	}



	/**
	 * Return the value associated with the column: deranged_occlusion_radio
	 */
	public java.lang.String getDerangedOcclusionRadio () {
		return derangedOcclusionRadio;
	}

	/**
	 * Set the value related to the column: deranged_occlusion_radio
	 * @param derangedOcclusionRadio the deranged_occlusion_radio value
	 */
	public void setDerangedOcclusionRadio (java.lang.String derangedOcclusionRadio) {
		this.derangedOcclusionRadio = derangedOcclusionRadio;
	}



	/**
	 * Return the value associated with the column: crepitus_radio
	 */
	public java.lang.String getCrepitusRadio () {
		return crepitusRadio;
	}

	/**
	 * Set the value related to the column: crepitus_radio
	 * @param crepitusRadio the crepitus_radio value
	 */
	public void setCrepitusRadio (java.lang.String crepitusRadio) {
		this.crepitusRadio = crepitusRadio;
	}



	/**
	 * Return the value associated with the column: sublingual_hematoma_radio
	 */
	public java.lang.String getSublingualHematomaRadio () {
		return sublingualHematomaRadio;
	}

	/**
	 * Set the value related to the column: sublingual_hematoma_radio
	 * @param sublingualHematomaRadio the sublingual_hematoma_radio value
	 */
	public void setSublingualHematomaRadio (java.lang.String sublingualHematomaRadio) {
		this.sublingualHematomaRadio = sublingualHematomaRadio;
	}



	/**
	 * Return the value associated with the column: other_radigraphic_value
	 */
	public java.lang.String getOtherRadigraphicValue () {
		return otherRadigraphicValue;
	}

	/**
	 * Set the value related to the column: other_radigraphic_value
	 * @param otherRadigraphicValue the other_radigraphic_value value
	 */
	public void setOtherRadigraphicValue (java.lang.String otherRadigraphicValue) {
		this.otherRadigraphicValue = otherRadigraphicValue;
	}



	/**
	 * Return the value associated with the column: site_of_fracture
	 */
	public java.lang.String getSiteOfFracture () {
		return siteOfFracture;
	}

	/**
	 * Set the value related to the column: site_of_fracture
	 * @param siteOfFracture the site_of_fracture value
	 */
	public void setSiteOfFracture (java.lang.String siteOfFracture) {
		this.siteOfFracture = siteOfFracture;
	}



	/**
	 * Return the value associated with the column: radio_graphic_diagnosis
	 */
	public java.lang.String getRadioGraphicDiagnosis () {
		return radioGraphicDiagnosis;
	}

	/**
	 * Set the value related to the column: radio_graphic_diagnosis
	 * @param radioGraphicDiagnosis the radio_graphic_diagnosis value
	 */
	public void setRadioGraphicDiagnosis (java.lang.String radioGraphicDiagnosis) {
		this.radioGraphicDiagnosis = radioGraphicDiagnosis;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdMaxillofacialTraumaHeader)) return false;
		else {
			jkt.hms.masters.business.OpdMaxillofacialTraumaHeader opdMaxillofacialTraumaHeader = (jkt.hms.masters.business.OpdMaxillofacialTraumaHeader) obj;
			if (null == this.getId() || null == opdMaxillofacialTraumaHeader.getId()) return false;
			else return (this.getId().equals(opdMaxillofacialTraumaHeader.getId()));
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