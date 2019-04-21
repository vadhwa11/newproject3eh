package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the diseases_icd_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="diseases_icd_mapping"
 */

public abstract class BaseDiseasesIcdMapping  implements Serializable {

	public static String REF = "DiseasesIcdMapping";
	public static String PROP_ICD_CODE = "IcdCode";
	public static String PROP_DISEASES_NAME = "DiseasesName";
	public static String PROP_ID = "Id";


	// constructors
	public BaseDiseasesIcdMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDiseasesIcdMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String diseasesName;

	// many to one
	private jkt.hms.masters.business.MasIcd icdCode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="diseases_icd_mapping_id"
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
	 * Return the value associated with the column: diseases_name
	 */
	public java.lang.String getDiseasesName () {
		return diseasesName;
	}

	/**
	 * Set the value related to the column: diseases_name
	 * @param diseasesName the diseases_name value
	 */
	public void setDiseasesName (java.lang.String diseasesName) {
		this.diseasesName = diseasesName;
	}



	/**
	 * Return the value associated with the column: icd_code_id
	 */
	public jkt.hms.masters.business.MasIcd getIcdCode () {
		return icdCode;
	}

	/**
	 * Set the value related to the column: icd_code_id
	 * @param icdCode the icd_code_id value
	 */
	public void setIcdCode (jkt.hms.masters.business.MasIcd icdCode) {
		this.icdCode = icdCode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DiseasesIcdMapping)) return false;
		else {
			jkt.hms.masters.business.DiseasesIcdMapping diseasesIcdMapping = (jkt.hms.masters.business.DiseasesIcdMapping) obj;
			if (null == this.getId() || null == diseasesIcdMapping.getId()) return false;
			else return (this.getId().equals(diseasesIcdMapping.getId()));
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