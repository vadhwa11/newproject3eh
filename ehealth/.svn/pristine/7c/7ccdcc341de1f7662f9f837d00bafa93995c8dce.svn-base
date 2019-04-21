package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the asha_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="asha_mapping"
 */

public abstract class BaseAshaMapping  implements Serializable {

	public static String REF = "AshaMapping";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_ASHA = "Asha";


	// constructors
	public BaseAshaMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAshaMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.AshaWorker asha;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="asha_hospital_id"
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: asha_id
	 */
	public jkt.hms.masters.business.AshaWorker getAsha () {
		return asha;
	}

	/**
	 * Set the value related to the column: asha_id
	 * @param asha the asha_id value
	 */
	public void setAsha (jkt.hms.masters.business.AshaWorker asha) {
		this.asha = asha;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AshaMapping)) return false;
		else {
			jkt.hms.masters.business.AshaMapping ashaMapping = (jkt.hms.masters.business.AshaMapping) obj;
			if (null == this.getId() || null == ashaMapping.getId()) return false;
			else return (this.getId().equals(ashaMapping.getId()));
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