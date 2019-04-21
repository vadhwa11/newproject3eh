package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_category_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_category_details"
 */

public abstract class BasePatientCategoryDetails  implements Serializable {

	public static String REF = "PatientCategoryDetails";
	public static String PROP_OTHER_CATEGORY = "OtherCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";


	// constructors
	public BasePatientCategoryDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientCategoryDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePatientCategoryDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.MasPatientType otherCategory) {

		this.setId(id);
		this.setHin(hin);
		this.setOtherCategory(otherCategory);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasPatientType otherCategory;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="category_details_id"
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: other_category_id
	 */
	public jkt.hms.masters.business.MasPatientType getOtherCategory () {
		return otherCategory;
	}

	/**
	 * Set the value related to the column: other_category_id
	 * @param otherCategory the other_category_id value
	 */
	public void setOtherCategory (jkt.hms.masters.business.MasPatientType otherCategory) {
		this.otherCategory = otherCategory;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientCategoryDetails)) return false;
		else {
			jkt.hms.masters.business.PatientCategoryDetails patientCategoryDetails = (jkt.hms.masters.business.PatientCategoryDetails) obj;
			if (null == this.getId() || null == patientCategoryDetails.getId()) return false;
			else return (this.getId().equals(patientCategoryDetails.getId()));
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