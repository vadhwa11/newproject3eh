package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mlc_material_objects table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mlc_material_objects"
 */

public abstract class BaseMlcMaterialObjects  implements Serializable {

	public static String REF = "MlcMaterialObjects";
	public static String PROP_MORTUARY_REG = "MortuaryReg";
	public static String PROP_CHEMICAL_ANALYSIS = "ChemicalAnalysis";
	public static String PROP_MEDICO_LEGAL_DETAILS = "MedicoLegalDetails";
	public static String PROP_MATERIAL_OBJECTS = "MaterialObjects";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMlcMaterialObjects () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMlcMaterialObjects (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String materialObjects;
	private java.lang.String chemicalAnalysis;

	// many to one
	private jkt.hms.masters.business.MortuaryRegisterDetails mortuaryReg;
	private jkt.hms.masters.business.MedicoLegalDetails medicoLegalDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="mlc_material_objects_id"
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
	 * Return the value associated with the column: material_objects
	 */
	public java.lang.String getMaterialObjects () {
		return materialObjects;
	}

	/**
	 * Set the value related to the column: material_objects
	 * @param materialObjects the material_objects value
	 */
	public void setMaterialObjects (java.lang.String materialObjects) {
		this.materialObjects = materialObjects;
	}



	/**
	 * Return the value associated with the column: chemical_analysis
	 */
	public java.lang.String getChemicalAnalysis () {
		return chemicalAnalysis;
	}

	/**
	 * Set the value related to the column: chemical_analysis
	 * @param chemicalAnalysis the chemical_analysis value
	 */
	public void setChemicalAnalysis (java.lang.String chemicalAnalysis) {
		this.chemicalAnalysis = chemicalAnalysis;
	}



	/**
	 * Return the value associated with the column: mortuary_reg_id
	 */
	public jkt.hms.masters.business.MortuaryRegisterDetails getMortuaryReg () {
		return mortuaryReg;
	}

	/**
	 * Set the value related to the column: mortuary_reg_id
	 * @param mortuaryReg the mortuary_reg_id value
	 */
	public void setMortuaryReg (jkt.hms.masters.business.MortuaryRegisterDetails mortuaryReg) {
		this.mortuaryReg = mortuaryReg;
	}



	/**
	 * Return the value associated with the column: medico_legal_details_id
	 */
	public jkt.hms.masters.business.MedicoLegalDetails getMedicoLegalDetails () {
		return medicoLegalDetails;
	}

	/**
	 * Set the value related to the column: medico_legal_details_id
	 * @param medicoLegalDetails the medico_legal_details_id value
	 */
	public void setMedicoLegalDetails (jkt.hms.masters.business.MedicoLegalDetails medicoLegalDetails) {
		this.medicoLegalDetails = medicoLegalDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MlcMaterialObjects)) return false;
		else {
			jkt.hms.masters.business.MlcMaterialObjects mlcMaterialObjects = (jkt.hms.masters.business.MlcMaterialObjects) obj;
			if (null == this.getId() || null == mlcMaterialObjects.getId()) return false;
			else return (this.getId().equals(mlcMaterialObjects.getId()));
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