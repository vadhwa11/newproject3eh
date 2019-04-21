package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_examination_of_gingiva table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_examination_of_gingiva"
 */

public abstract class BaseOpdExaminationOfGingiva  implements Serializable {

	public static String REF = "OpdExaminationOfGingiva";
	public static String PROP_CLINICAL_FEATURE = "ClinicalFeature";
	public static String PROP_RIGHT_POSTERIOR = "RightPosterior";
	public static String PROP_FLAG = "Flag";
	public static String PROP_ANTERIOR = "Anterior";
	public static String PROP_CASE_RECORD_PERIODONTICS_HEADER = "CaseRecordPeriodonticsHeader";
	public static String PROP_LEFT_POSTERIOR = "LeftPosterior";
	public static String PROP_ID = "Id";


	// constructors
	public BaseOpdExaminationOfGingiva () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdExaminationOfGingiva (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String flag;
	private java.lang.String clinicalFeature;
	private java.lang.String rightPosterior;
	private java.lang.String anterior;
	private java.lang.String leftPosterior;

	// many to one
	private jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader caseRecordPeriodonticsHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="examination_of_gingiva_id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: clinical_feature
	 */
	public java.lang.String getClinicalFeature () {
		return clinicalFeature;
	}

	/**
	 * Set the value related to the column: clinical_feature
	 * @param clinicalFeature the clinical_feature value
	 */
	public void setClinicalFeature (java.lang.String clinicalFeature) {
		this.clinicalFeature = clinicalFeature;
	}



	/**
	 * Return the value associated with the column: right_posterior
	 */
	public java.lang.String getRightPosterior () {
		return rightPosterior;
	}

	/**
	 * Set the value related to the column: right_posterior
	 * @param rightPosterior the right_posterior value
	 */
	public void setRightPosterior (java.lang.String rightPosterior) {
		this.rightPosterior = rightPosterior;
	}



	/**
	 * Return the value associated with the column: anterior
	 */
	public java.lang.String getAnterior () {
		return anterior;
	}

	/**
	 * Set the value related to the column: anterior
	 * @param anterior the anterior value
	 */
	public void setAnterior (java.lang.String anterior) {
		this.anterior = anterior;
	}



	/**
	 * Return the value associated with the column: left_posterior
	 */
	public java.lang.String getLeftPosterior () {
		return leftPosterior;
	}

	/**
	 * Set the value related to the column: left_posterior
	 * @param leftPosterior the left_posterior value
	 */
	public void setLeftPosterior (java.lang.String leftPosterior) {
		this.leftPosterior = leftPosterior;
	}



	/**
	 * Return the value associated with the column: case_record_periodontics_header_id
	 */
	public jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader getCaseRecordPeriodonticsHeader () {
		return caseRecordPeriodonticsHeader;
	}

	/**
	 * Set the value related to the column: case_record_periodontics_header_id
	 * @param caseRecordPeriodonticsHeader the case_record_periodontics_header_id value
	 */
	public void setCaseRecordPeriodonticsHeader (jkt.hms.masters.business.OpdCaseRecordPeriodonticsHeader caseRecordPeriodonticsHeader) {
		this.caseRecordPeriodonticsHeader = caseRecordPeriodonticsHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdExaminationOfGingiva)) return false;
		else {
			jkt.hms.masters.business.OpdExaminationOfGingiva opdExaminationOfGingiva = (jkt.hms.masters.business.OpdExaminationOfGingiva) obj;
			if (null == this.getId() || null == opdExaminationOfGingiva.getId()) return false;
			else return (this.getId().equals(opdExaminationOfGingiva.getId()));
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