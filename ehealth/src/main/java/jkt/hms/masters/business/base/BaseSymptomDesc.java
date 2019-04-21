package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the symptom_desc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="symptom_desc"
 */

public abstract class BaseSymptomDesc  implements Serializable {

	public static String REF = "SymptomDesc";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_MAIN_COMPLAINT_ID = "MainComplaintId";
	public static String PROP_ID = "Id";


	// constructors
	public BaseSymptomDesc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptomDesc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long mainComplaintId;
	private java.lang.String description;



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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SymptomDesc)) return false;
		else {
			jkt.hms.masters.business.SymptomDesc symptomDesc = (jkt.hms.masters.business.SymptomDesc) obj;
			if (null == this.getId() || null == symptomDesc.getId()) return false;
			else return (this.getId().equals(symptomDesc.getId()));
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