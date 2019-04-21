package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ft table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ft"
 */

public abstract class BaseFt  implements Serializable {

	public static String REF = "Ft";
	public static String PROP_STATUS = "Status";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_GENDER = "Gender";
	public static String PROP_REL_NAME = "RelName";
	public static String PROP_MOTHER = "Mother";
	public static String PROP_ID = "Id";
	public static String PROP_REL = "Rel";
	public static String PROP_FATHER = "Father";
	public static String PROP_HIN = "Hin";
	public static String PROP_SPOUSE = "Spouse";


	// constructors
	public BaseFt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String relName;
	private java.lang.String gender;
	private java.lang.String status;
	private java.lang.String diagnosis;

	// many to one
	private jkt.hms.masters.business.Ft mother;
	private jkt.hms.masters.business.Ft father;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.FtRelation rel;
	private jkt.hms.masters.business.Ft spouse;



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
	 * Return the value associated with the column: rel_name
	 */
	public java.lang.String getRelName () {
		return relName;
	}

	/**
	 * Set the value related to the column: rel_name
	 * @param relName the rel_name value
	 */
	public void setRelName (java.lang.String relName) {
		this.relName = relName;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (java.lang.String gender) {
		this.gender = gender;
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
	 * Return the value associated with the column: diagnosis
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis
	 * @param diagnosis the diagnosis value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: mother_id
	 */
	public jkt.hms.masters.business.Ft getMother () {
		return mother;
	}

	/**
	 * Set the value related to the column: mother_id
	 * @param mother the mother_id value
	 */
	public void setMother (jkt.hms.masters.business.Ft mother) {
		this.mother = mother;
	}



	/**
	 * Return the value associated with the column: father_id
	 */
	public jkt.hms.masters.business.Ft getFather () {
		return father;
	}

	/**
	 * Set the value related to the column: father_id
	 * @param father the father_id value
	 */
	public void setFather (jkt.hms.masters.business.Ft father) {
		this.father = father;
	}



	/**
	 * Return the value associated with the column: hin
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin
	 * @param hin the hin value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: rel
	 */
	public jkt.hms.masters.business.FtRelation getRel () {
		return rel;
	}

	/**
	 * Set the value related to the column: rel
	 * @param rel the rel value
	 */
	public void setRel (jkt.hms.masters.business.FtRelation rel) {
		this.rel = rel;
	}



	/**
	 * Return the value associated with the column: spouse_id
	 */
	public jkt.hms.masters.business.Ft getSpouse () {
		return spouse;
	}

	/**
	 * Set the value related to the column: spouse_id
	 * @param spouse the spouse_id value
	 */
	public void setSpouse (jkt.hms.masters.business.Ft spouse) {
		this.spouse = spouse;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Ft)) return false;
		else {
			jkt.hms.masters.business.Ft ft = (jkt.hms.masters.business.Ft) obj;
			if (null == this.getId() || null == ft.getId()) return false;
			else return (this.getId().equals(ft.getId()));
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