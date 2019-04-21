package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_table_comorbidity table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_table_comorbidity"
 */

public abstract class BaseTempTableComorbidity  implements Serializable {

	public static String REF = "TempTableComorbidity";
	public static String PROP_ICD = "Icd";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_VISIT = "Visit";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseTempTableComorbidity () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempTableComorbidity (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date addEditTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasIcd icd;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="tempid"
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
	 * Return the value associated with the column: addEditTime
	 */
	public java.util.Date getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: addEditTime
	 * @param addEditTime the addEditTime value
	 */
	public void setAddEditTime (java.util.Date addEditTime) {
		this.addEditTime = addEditTime;
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



	/**
	 * Return the value associated with the column: icd_id
	 */
	public jkt.hms.masters.business.MasIcd getIcd () {
		return icd;
	}

	/**
	 * Set the value related to the column: icd_id
	 * @param icd the icd_id value
	 */
	public void setIcd (jkt.hms.masters.business.MasIcd icd) {
		this.icd = icd;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TempTableComorbidity)) return false;
		else {
			jkt.hms.masters.business.TempTableComorbidity tempTableComorbidity = (jkt.hms.masters.business.TempTableComorbidity) obj;
			if (null == this.getId() || null == tempTableComorbidity.getId()) return false;
			else return (this.getId().equals(tempTableComorbidity.getId()));
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