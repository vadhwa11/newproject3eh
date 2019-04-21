package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the diagnosispro table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="diagnosispro"
 */

public abstract class BaseDiagnosispro  implements Serializable {

	public static String REF = "Diagnosispro";
	public static String PROP_ASSOCIATEDDISEASESRULEOUTS = "Associateddiseasesruleouts";
	public static String PROP_DISEASEPROGRESSION = "Diseaseprogression";
	public static String PROP_NAME = "Name";
	public static String PROP_DIAGNOSTICTESTRESULTS = "Diagnostictestresults";
	public static String PROP_SIGNSSYMPTOMS = "Signssymptoms";
	public static String PROP_ID = "Id";
	public static String PROP_DISEASEMECHANISMCLASSIFICATION = "Diseasemechanismclassification";
	public static String PROP_TREATMENT = "Treatment";


	// constructors
	public BaseDiagnosispro () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDiagnosispro (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String name;
	private java.lang.String signssymptoms;
	private java.lang.String diseaseprogression;
	private java.lang.String diagnostictestresults;
	private java.lang.String associateddiseasesruleouts;
	private java.lang.String diseasemechanismclassification;
	private java.lang.String treatment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="sno"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: signssymptoms
	 */
	public java.lang.String getSignssymptoms () {
		return signssymptoms;
	}

	/**
	 * Set the value related to the column: signssymptoms
	 * @param signssymptoms the signssymptoms value
	 */
	public void setSignssymptoms (java.lang.String signssymptoms) {
		this.signssymptoms = signssymptoms;
	}



	/**
	 * Return the value associated with the column: diseaseprogression
	 */
	public java.lang.String getDiseaseprogression () {
		return diseaseprogression;
	}

	/**
	 * Set the value related to the column: diseaseprogression
	 * @param diseaseprogression the diseaseprogression value
	 */
	public void setDiseaseprogression (java.lang.String diseaseprogression) {
		this.diseaseprogression = diseaseprogression;
	}



	/**
	 * Return the value associated with the column: diagnostictestresults
	 */
	public java.lang.String getDiagnostictestresults () {
		return diagnostictestresults;
	}

	/**
	 * Set the value related to the column: diagnostictestresults
	 * @param diagnostictestresults the diagnostictestresults value
	 */
	public void setDiagnostictestresults (java.lang.String diagnostictestresults) {
		this.diagnostictestresults = diagnostictestresults;
	}



	/**
	 * Return the value associated with the column: associateddiseasesruleouts
	 */
	public java.lang.String getAssociateddiseasesruleouts () {
		return associateddiseasesruleouts;
	}

	/**
	 * Set the value related to the column: associateddiseasesruleouts
	 * @param associateddiseasesruleouts the associateddiseasesruleouts value
	 */
	public void setAssociateddiseasesruleouts (java.lang.String associateddiseasesruleouts) {
		this.associateddiseasesruleouts = associateddiseasesruleouts;
	}



	/**
	 * Return the value associated with the column: diseasemechanismclassification
	 */
	public java.lang.String getDiseasemechanismclassification () {
		return diseasemechanismclassification;
	}

	/**
	 * Set the value related to the column: diseasemechanismclassification
	 * @param diseasemechanismclassification the diseasemechanismclassification value
	 */
	public void setDiseasemechanismclassification (java.lang.String diseasemechanismclassification) {
		this.diseasemechanismclassification = diseasemechanismclassification;
	}



	/**
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * @param treatment the treatment value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Diagnosispro)) return false;
		else {
			jkt.hms.masters.business.Diagnosispro diagnosispro = (jkt.hms.masters.business.Diagnosispro) obj;
			if (null == this.getId() || null == diagnosispro.getId()) return false;
			else return (this.getId().equals(diagnosispro.getId()));
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