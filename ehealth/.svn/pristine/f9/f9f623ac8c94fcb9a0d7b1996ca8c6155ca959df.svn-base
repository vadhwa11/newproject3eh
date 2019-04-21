package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the differential_diagnosis_temp table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="differential_diagnosis_temp"
 */

public abstract class BaseDifferentialDiagnosisTemp  implements Serializable {

	public static String REF = "DifferentialDiagnosisTemp";
	public static String PROP_LABEL_TERM = "LabelTerm";
	public static String PROP_TERM_ID = "TermId";
	public static String PROP_CONDITION_TERM = "ConditionTerm";
	public static String PROP_ATTRIB_TERM = "AttribTerm";
	public static String PROP_ATTRIB_ID = "AttribId";
	public static String PROP_ID = "Id";
	public static String PROP_CONDITION_ID = "ConditionId";
	public static String PROP_USER_ID = "UserId";


	// constructors
	public BaseDifferentialDiagnosisTemp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDifferentialDiagnosisTemp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long termId;
	private java.lang.String labelTerm;
	private java.lang.Long attribId;
	private java.lang.String attribTerm;
	private java.lang.Long conditionId;
	private java.lang.String conditionTerm;
	private java.lang.String userId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: term_id
	 */
	public java.lang.Long getTermId () {
		return termId;
	}

	/**
	 * Set the value related to the column: term_id
	 * @param termId the term_id value
	 */
	public void setTermId (java.lang.Long termId) {
		this.termId = termId;
	}



	/**
	 * Return the value associated with the column: label_term
	 */
	public java.lang.String getLabelTerm () {
		return labelTerm;
	}

	/**
	 * Set the value related to the column: label_term
	 * @param labelTerm the label_term value
	 */
	public void setLabelTerm (java.lang.String labelTerm) {
		this.labelTerm = labelTerm;
	}



	/**
	 * Return the value associated with the column: attrib_id
	 */
	public java.lang.Long getAttribId () {
		return attribId;
	}

	/**
	 * Set the value related to the column: attrib_id
	 * @param attribId the attrib_id value
	 */
	public void setAttribId (java.lang.Long attribId) {
		this.attribId = attribId;
	}



	/**
	 * Return the value associated with the column: attrib_term
	 */
	public java.lang.String getAttribTerm () {
		return attribTerm;
	}

	/**
	 * Set the value related to the column: attrib_term
	 * @param attribTerm the attrib_term value
	 */
	public void setAttribTerm (java.lang.String attribTerm) {
		this.attribTerm = attribTerm;
	}



	/**
	 * Return the value associated with the column: condition_id
	 */
	public java.lang.Long getConditionId () {
		return conditionId;
	}

	/**
	 * Set the value related to the column: condition_id
	 * @param conditionId the condition_id value
	 */
	public void setConditionId (java.lang.Long conditionId) {
		this.conditionId = conditionId;
	}



	/**
	 * Return the value associated with the column: condition_term
	 */
	public java.lang.String getConditionTerm () {
		return conditionTerm;
	}

	/**
	 * Set the value related to the column: condition_term
	 * @param conditionTerm the condition_term value
	 */
	public void setConditionTerm (java.lang.String conditionTerm) {
		this.conditionTerm = conditionTerm;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public java.lang.String getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param userId the user_id value
	 */
	public void setUserId (java.lang.String userId) {
		this.userId = userId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DifferentialDiagnosisTemp)) return false;
		else {
			jkt.hms.masters.business.DifferentialDiagnosisTemp differentialDiagnosisTemp = (jkt.hms.masters.business.DifferentialDiagnosisTemp) obj;
			if (null == this.getId() || null == differentialDiagnosisTemp.getId()) return false;
			else return (this.getId().equals(differentialDiagnosisTemp.getId()));
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