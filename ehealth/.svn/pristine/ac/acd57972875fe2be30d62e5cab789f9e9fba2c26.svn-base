package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the symptom_related_name table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="symptom_related_name"
 */

public abstract class BaseSymptomRelatedName  implements Serializable {

	public static String REF = "SymptomRelatedName";
	public static String PROP_SYMP_NAMES = "SympNames";
	public static String PROP_ID = "Id";
	public static String PROP_MAIN_SYMP_ID = "MainSympId";


	// constructors
	public BaseSymptomRelatedName () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptomRelatedName (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long mainSympId;
	private java.lang.String sympNames;



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
	 * Return the value associated with the column: main_symp_id
	 */
	public java.lang.Long getMainSympId () {
		return mainSympId;
	}

	/**
	 * Set the value related to the column: main_symp_id
	 * @param mainSympId the main_symp_id value
	 */
	public void setMainSympId (java.lang.Long mainSympId) {
		this.mainSympId = mainSympId;
	}



	/**
	 * Return the value associated with the column: symp_names
	 */
	public java.lang.String getSympNames () {
		return sympNames;
	}

	/**
	 * Set the value related to the column: symp_names
	 * @param sympNames the symp_names value
	 */
	public void setSympNames (java.lang.String sympNames) {
		this.sympNames = sympNames;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SymptomRelatedName)) return false;
		else {
			jkt.hms.masters.business.SymptomRelatedName symptomRelatedName = (jkt.hms.masters.business.SymptomRelatedName) obj;
			if (null == this.getId() || null == symptomRelatedName.getId()) return false;
			else return (this.getId().equals(symptomRelatedName.getId()));
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