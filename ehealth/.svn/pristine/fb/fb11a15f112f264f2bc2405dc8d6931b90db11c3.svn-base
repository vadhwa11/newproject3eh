package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_dermatological_leprosy_examination table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_dermatological_leprosy_examination"
 */

public abstract class BaseOpdDermatologicalLeprosyExamination  implements Serializable {

	public static String REF = "OpdDermatologicalLeprosyExamination";
	public static String PROP_UPPER_LIMB = "UpperLimb";
	public static String PROP_POSTERIOR_TRUNK = "PosteriorTrunk";
	public static String PROP_EAR_LOBE = "EarLobe";
	public static String PROP_LOWER_LIMB = "LowerLimb";
	public static String PROP_LESION = "Lesion";
	public static String PROP_ID = "Id";
	public static String PROP_MADAROSIS = "Madarosis";
	public static String PROP_FACE = "Face";
	public static String PROP_LEPROSY_PROFORMA = "LeprosyProforma";
	public static String PROP_ANTERIOR_TRUNK = "AnteriorTrunk";


	// constructors
	public BaseOpdDermatologicalLeprosyExamination () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdDermatologicalLeprosyExamination (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lesion;
	private java.lang.String earLobe;
	private java.lang.String madarosis;
	private java.lang.String face;
	private java.lang.String upperLimb;
	private java.lang.String anteriorTrunk;
	private java.lang.String posteriorTrunk;
	private java.lang.String lowerLimb;

	// many to one
	private jkt.hms.masters.business.OpdDermatologyLeprosyProforma leprosyProforma;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="examination_id"
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
	 * Return the value associated with the column: lesion
	 */
	public java.lang.String getLesion () {
		return lesion;
	}

	/**
	 * Set the value related to the column: lesion
	 * @param lesion the lesion value
	 */
	public void setLesion (java.lang.String lesion) {
		this.lesion = lesion;
	}



	/**
	 * Return the value associated with the column: ear_lobe
	 */
	public java.lang.String getEarLobe () {
		return earLobe;
	}

	/**
	 * Set the value related to the column: ear_lobe
	 * @param earLobe the ear_lobe value
	 */
	public void setEarLobe (java.lang.String earLobe) {
		this.earLobe = earLobe;
	}



	/**
	 * Return the value associated with the column: madarosis
	 */
	public java.lang.String getMadarosis () {
		return madarosis;
	}

	/**
	 * Set the value related to the column: madarosis
	 * @param madarosis the madarosis value
	 */
	public void setMadarosis (java.lang.String madarosis) {
		this.madarosis = madarosis;
	}



	/**
	 * Return the value associated with the column: face
	 */
	public java.lang.String getFace () {
		return face;
	}

	/**
	 * Set the value related to the column: face
	 * @param face the face value
	 */
	public void setFace (java.lang.String face) {
		this.face = face;
	}



	/**
	 * Return the value associated with the column: upper_limb
	 */
	public java.lang.String getUpperLimb () {
		return upperLimb;
	}

	/**
	 * Set the value related to the column: upper_limb
	 * @param upperLimb the upper_limb value
	 */
	public void setUpperLimb (java.lang.String upperLimb) {
		this.upperLimb = upperLimb;
	}



	/**
	 * Return the value associated with the column: anterior_trunk
	 */
	public java.lang.String getAnteriorTrunk () {
		return anteriorTrunk;
	}

	/**
	 * Set the value related to the column: anterior_trunk
	 * @param anteriorTrunk the anterior_trunk value
	 */
	public void setAnteriorTrunk (java.lang.String anteriorTrunk) {
		this.anteriorTrunk = anteriorTrunk;
	}



	/**
	 * Return the value associated with the column: posterior_trunk
	 */
	public java.lang.String getPosteriorTrunk () {
		return posteriorTrunk;
	}

	/**
	 * Set the value related to the column: posterior_trunk
	 * @param posteriorTrunk the posterior_trunk value
	 */
	public void setPosteriorTrunk (java.lang.String posteriorTrunk) {
		this.posteriorTrunk = posteriorTrunk;
	}



	/**
	 * Return the value associated with the column: lower_limb
	 */
	public java.lang.String getLowerLimb () {
		return lowerLimb;
	}

	/**
	 * Set the value related to the column: lower_limb
	 * @param lowerLimb the lower_limb value
	 */
	public void setLowerLimb (java.lang.String lowerLimb) {
		this.lowerLimb = lowerLimb;
	}



	/**
	 * Return the value associated with the column: leprosy_proforma_id
	 */
	public jkt.hms.masters.business.OpdDermatologyLeprosyProforma getLeprosyProforma () {
		return leprosyProforma;
	}

	/**
	 * Set the value related to the column: leprosy_proforma_id
	 * @param leprosyProforma the leprosy_proforma_id value
	 */
	public void setLeprosyProforma (jkt.hms.masters.business.OpdDermatologyLeprosyProforma leprosyProforma) {
		this.leprosyProforma = leprosyProforma;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdDermatologicalLeprosyExamination)) return false;
		else {
			jkt.hms.masters.business.OpdDermatologicalLeprosyExamination opdDermatologicalLeprosyExamination = (jkt.hms.masters.business.OpdDermatologicalLeprosyExamination) obj;
			if (null == this.getId() || null == opdDermatologicalLeprosyExamination.getId()) return false;
			else return (this.getId().equals(opdDermatologicalLeprosyExamination.getId()));
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