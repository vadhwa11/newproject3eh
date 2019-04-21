package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_condemnation_commitee table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_condemnation_commitee"
 */

public abstract class BaseMmCondemnationCommitee  implements Serializable {

	public static String REF = "MmCondemnationCommitee";
	public static String PROP_NAME = "Name";
	public static String PROP_FORM_NO = "FormNo";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMmCondemnationCommitee () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmCondemnationCommitee (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String formNo;
	private java.lang.String name;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="codemnation_commitee_id"
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
	 * Return the value associated with the column: form_no
	 */
	public java.lang.String getFormNo () {
		return formNo;
	}

	/**
	 * Set the value related to the column: form_no
	 * @param formNo the form_no value
	 */
	public void setFormNo (java.lang.String formNo) {
		this.formNo = formNo;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmCondemnationCommitee)) return false;
		else {
			jkt.hms.masters.business.MmCondemnationCommitee mmCondemnationCommitee = (jkt.hms.masters.business.MmCondemnationCommitee) obj;
			if (null == this.getId() || null == mmCondemnationCommitee.getId()) return false;
			else return (this.getId().equals(mmCondemnationCommitee.getId()));
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