package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the symptom_sub_complains table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="symptom_sub_complains"
 */

public abstract class BaseSymptomSubComplains  implements Serializable {

	public static String REF = "SymptomSubComplains";
	public static String PROP_MAIN_COMPLAINT_ID = "MainComplaintId";
	public static String PROP_ID = "Id";
	public static String PROP_CODE = "Code";
	public static String PROP_SYMPTOM = "Symptom";


	// constructors
	public BaseSymptomSubComplains () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptomSubComplains (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long mainComplaintId;
	private java.lang.Long code;
	private java.lang.String symptom;



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
	 * Return the value associated with the column: main_complaint_id
	 */
	public java.lang.Long getMainComplaintId () {
		return mainComplaintId;
	}

	/**
	 * Set the value related to the column: main_complaint_id
	 * @param mainComplaintId the main_complaint_id value
	 */
	public void setMainComplaintId (java.lang.Long mainComplaintId) {
		this.mainComplaintId = mainComplaintId;
	}



	/**
	 * Return the value associated with the column: code
	 */
	public java.lang.Long getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: code
	 * @param code the code value
	 */
	public void setCode (java.lang.Long code) {
		this.code = code;
	}



	/**
	 * Return the value associated with the column: symptom
	 */
	public java.lang.String getSymptom () {
		return symptom;
	}

	/**
	 * Set the value related to the column: symptom
	 * @param symptom the symptom value
	 */
	public void setSymptom (java.lang.String symptom) {
		this.symptom = symptom;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SymptomSubComplains)) return false;
		else {
			jkt.hms.masters.business.SymptomSubComplains symptomSubComplains = (jkt.hms.masters.business.SymptomSubComplains) obj;
			if (null == this.getId() || null == symptomSubComplains.getId()) return false;
			else return (this.getId().equals(symptomSubComplains.getId()));
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