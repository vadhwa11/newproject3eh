package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_oral_medicine_dental_tissue table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_oral_medicine_dental_tissue"
 */

public abstract class BaseOpdOralMedicineDentalTissue  implements Serializable {

	public static String REF = "OpdOralMedicineDentalTissue";
	public static String PROP_SYMPTOMS = "Symptoms";
	public static String PROP_TEMPLATE_NAME = "TemplateName";
	public static String PROP_WHITE_STRIAE = "WhiteStriae";
	public static String PROP_ROUGHNESS = "Roughness";
	public static String PROP_MEDICINE_PATHOLOGY = "MedicinePathology";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BURNING_SENSATION = "BurningSensation";
	public static String PROP_ORAL_MEDICINE = "OralMedicine";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SWELLING = "Swelling";
	public static String PROP_HYPER_PIGMENTATION = "HyperPigmentation";
	public static String PROP_RED_PATCHES_SCRAPABLE = "RedPatchesScrapable";
	public static String PROP_WHITE_PATCHES_NON_SCRAPABLE = "WhitePatchesNonScrapable";
	public static String PROP_ULCERS = "Ulcers";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_HIN = "Hin";
	public static String PROP_WHITE_PATCHES_SCRAPABLE = "WhitePatchesScrapable";
	public static String PROP_RED_PATCHES_NON_SCRAPABLE = "RedPatchesNonScrapable";


	// constructors
	public BaseOpdOralMedicineDentalTissue () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOralMedicineDentalTissue (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String symptoms;
	private java.lang.String burningSensation;
	private java.lang.String hyperPigmentation;
	private java.lang.String redPatchesScrapable;
	private java.lang.String redPatchesNonScrapable;
	private java.lang.String whitePatchesScrapable;
	private java.lang.String whitePatchesNonScrapable;
	private java.lang.String whiteStriae;
	private java.lang.String swelling;
	private java.lang.String ulcers;
	private java.lang.String roughness;
	private java.lang.String templateName;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.OpdOralMedicineDental oralMedicine;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdOralMedicinePathology medicinePathology;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="oral_medicine_tissue_id"
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
	 * Return the value associated with the column: symptoms
	 */
	public java.lang.String getSymptoms () {
		return symptoms;
	}

	/**
	 * Set the value related to the column: symptoms
	 * @param symptoms the symptoms value
	 */
	public void setSymptoms (java.lang.String symptoms) {
		this.symptoms = symptoms;
	}



	/**
	 * Return the value associated with the column: burning_sensation
	 */
	public java.lang.String getBurningSensation () {
		return burningSensation;
	}

	/**
	 * Set the value related to the column: burning_sensation
	 * @param burningSensation the burning_sensation value
	 */
	public void setBurningSensation (java.lang.String burningSensation) {
		this.burningSensation = burningSensation;
	}



	/**
	 * Return the value associated with the column: hyper_pigmentation
	 */
	public java.lang.String getHyperPigmentation () {
		return hyperPigmentation;
	}

	/**
	 * Set the value related to the column: hyper_pigmentation
	 * @param hyperPigmentation the hyper_pigmentation value
	 */
	public void setHyperPigmentation (java.lang.String hyperPigmentation) {
		this.hyperPigmentation = hyperPigmentation;
	}



	/**
	 * Return the value associated with the column: red_patches_scrapable
	 */
	public java.lang.String getRedPatchesScrapable () {
		return redPatchesScrapable;
	}

	/**
	 * Set the value related to the column: red_patches_scrapable
	 * @param redPatchesScrapable the red_patches_scrapable value
	 */
	public void setRedPatchesScrapable (java.lang.String redPatchesScrapable) {
		this.redPatchesScrapable = redPatchesScrapable;
	}



	/**
	 * Return the value associated with the column: red_patches_non_scrapable
	 */
	public java.lang.String getRedPatchesNonScrapable () {
		return redPatchesNonScrapable;
	}

	/**
	 * Set the value related to the column: red_patches_non_scrapable
	 * @param redPatchesNonScrapable the red_patches_non_scrapable value
	 */
	public void setRedPatchesNonScrapable (java.lang.String redPatchesNonScrapable) {
		this.redPatchesNonScrapable = redPatchesNonScrapable;
	}



	/**
	 * Return the value associated with the column: white_patches_scrapable
	 */
	public java.lang.String getWhitePatchesScrapable () {
		return whitePatchesScrapable;
	}

	/**
	 * Set the value related to the column: white_patches_scrapable
	 * @param whitePatchesScrapable the white_patches_scrapable value
	 */
	public void setWhitePatchesScrapable (java.lang.String whitePatchesScrapable) {
		this.whitePatchesScrapable = whitePatchesScrapable;
	}



	/**
	 * Return the value associated with the column: white_patches_non_scrapable
	 */
	public java.lang.String getWhitePatchesNonScrapable () {
		return whitePatchesNonScrapable;
	}

	/**
	 * Set the value related to the column: white_patches_non_scrapable
	 * @param whitePatchesNonScrapable the white_patches_non_scrapable value
	 */
	public void setWhitePatchesNonScrapable (java.lang.String whitePatchesNonScrapable) {
		this.whitePatchesNonScrapable = whitePatchesNonScrapable;
	}



	/**
	 * Return the value associated with the column: white_striae
	 */
	public java.lang.String getWhiteStriae () {
		return whiteStriae;
	}

	/**
	 * Set the value related to the column: white_striae
	 * @param whiteStriae the white_striae value
	 */
	public void setWhiteStriae (java.lang.String whiteStriae) {
		this.whiteStriae = whiteStriae;
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
	 * Return the value associated with the column: ulcers
	 */
	public java.lang.String getUlcers () {
		return ulcers;
	}

	/**
	 * Set the value related to the column: ulcers
	 * @param ulcers the ulcers value
	 */
	public void setUlcers (java.lang.String ulcers) {
		this.ulcers = ulcers;
	}



	/**
	 * Return the value associated with the column: roughness
	 */
	public java.lang.String getRoughness () {
		return roughness;
	}

	/**
	 * Set the value related to the column: roughness
	 * @param roughness the roughness value
	 */
	public void setRoughness (java.lang.String roughness) {
		this.roughness = roughness;
	}



	/**
	 * Return the value associated with the column: template_name
	 */
	public java.lang.String getTemplateName () {
		return templateName;
	}

	/**
	 * Set the value related to the column: template_name
	 * @param templateName the template_name value
	 */
	public void setTemplateName (java.lang.String templateName) {
		this.templateName = templateName;
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
	 * Return the value associated with the column: oral_medicine_id
	 */
	public jkt.hms.masters.business.OpdOralMedicineDental getOralMedicine () {
		return oralMedicine;
	}

	/**
	 * Set the value related to the column: oral_medicine_id
	 * @param oralMedicine the oral_medicine_id value
	 */
	public void setOralMedicine (jkt.hms.masters.business.OpdOralMedicineDental oralMedicine) {
		this.oralMedicine = oralMedicine;
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
	 * Return the value associated with the column: medicine_pathology_id
	 */
	public jkt.hms.masters.business.OpdOralMedicinePathology getMedicinePathology () {
		return medicinePathology;
	}

	/**
	 * Set the value related to the column: medicine_pathology_id
	 * @param medicinePathology the medicine_pathology_id value
	 */
	public void setMedicinePathology (jkt.hms.masters.business.OpdOralMedicinePathology medicinePathology) {
		this.medicinePathology = medicinePathology;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOralMedicineDentalTissue)) return false;
		else {
			jkt.hms.masters.business.OpdOralMedicineDentalTissue opdOralMedicineDentalTissue = (jkt.hms.masters.business.OpdOralMedicineDentalTissue) obj;
			if (null == this.getId() || null == opdOralMedicineDentalTissue.getId()) return false;
			else return (this.getId().equals(opdOralMedicineDentalTissue.getId()));
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