package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_snomed_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_snomed_details"
 */

public abstract class BasePatientSnomedDetails  implements Serializable {

	public static String REF = "PatientSnomedDetails";
	public static String PROP_SNOMED_CONCEPT_ID = "SnomedConceptId";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_SNOMED_CONCEPT_DESC = "SnomedConceptDesc";
	public static String PROP_FIELD_TYPE = "FieldType";


	// constructors
	public BasePatientSnomedDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientSnomedDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String snomedConceptId;
	private java.lang.String snomedConceptDesc;
	private java.lang.String fieldType;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="patient_snomed_details_id"
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
	 * Return the value associated with the column: snomed_concept_id
	 */
	public java.lang.String getSnomedConceptId () {
		return snomedConceptId;
	}

	/**
	 * Set the value related to the column: snomed_concept_id
	 * @param snomedConceptId the snomed_concept_id value
	 */
	public void setSnomedConceptId (java.lang.String snomedConceptId) {
		this.snomedConceptId = snomedConceptId;
	}



	/**
	 * Return the value associated with the column: snomed_concept_desc
	 */
	public java.lang.String getSnomedConceptDesc () {
		return snomedConceptDesc;
	}

	/**
	 * Set the value related to the column: snomed_concept_desc
	 * @param snomedConceptDesc the snomed_concept_desc value
	 */
	public void setSnomedConceptDesc (java.lang.String snomedConceptDesc) {
		this.snomedConceptDesc = snomedConceptDesc;
	}



	/**
	 * Return the value associated with the column: field_type
	 */
	public java.lang.String getFieldType () {
		return fieldType;
	}

	/**
	 * Set the value related to the column: field_type
	 * @param fieldType the field_type value
	 */
	public void setFieldType (java.lang.String fieldType) {
		this.fieldType = fieldType;
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
		if (!(obj instanceof jkt.hms.masters.business.PatientSnomedDetails)) return false;
		else {
			jkt.hms.masters.business.PatientSnomedDetails patientSnomedDetails = (jkt.hms.masters.business.PatientSnomedDetails) obj;
			if (null == this.getId() || null == patientSnomedDetails.getId()) return false;
			else return (this.getId().equals(patientSnomedDetails.getId()));
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