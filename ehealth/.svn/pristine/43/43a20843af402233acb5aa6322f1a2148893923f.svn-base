package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the loinc_snomed table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="loinc_snomed"
 */

public abstract class BaseLoincSnomed  implements Serializable {

	public static String REF = "LoincSnomed";
	public static String PROP_SNOMED = "Snomed";
	public static String PROP_ID = "Id";
	public static String PROP_LOINC = "Loinc";


	// constructors
	public BaseLoincSnomed () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLoincSnomed (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String loinc;
	private java.lang.String snomed;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: loinc
	 */
	public java.lang.String getLoinc () {
		return loinc;
	}

	/**
	 * Set the value related to the column: loinc
	 * @param loinc the loinc value
	 */
	public void setLoinc (java.lang.String loinc) {
		this.loinc = loinc;
	}



	/**
	 * Return the value associated with the column: snomed
	 */
	public java.lang.String getSnomed () {
		return snomed;
	}

	/**
	 * Set the value related to the column: snomed
	 * @param snomed the snomed value
	 */
	public void setSnomed (java.lang.String snomed) {
		this.snomed = snomed;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LoincSnomed)) return false;
		else {
			jkt.hms.masters.business.LoincSnomed loincSnomed = (jkt.hms.masters.business.LoincSnomed) obj;
			if (null == this.getId() || null == loincSnomed.getId()) return false;
			else return (this.getId().equals(loincSnomed.getId()));
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