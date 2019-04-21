package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ft_relation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ft_relation"
 */

public abstract class BaseFtRelation  implements Serializable {

	public static String REF = "FtRelation";
	public static String PROP_RELATION_CODE = "RelationCode";
	public static String PROP_GENDER = "Gender";
	public static String PROP_REL_NAME = "RelName";
	public static String PROP_ID = "Id";


	// constructors
	public BaseFtRelation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFtRelation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String relName;
	private java.lang.String relationCode;
	private java.lang.String gender;



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
	 * Return the value associated with the column: relation_code
	 */
	public java.lang.String getRelationCode () {
		return relationCode;
	}

	/**
	 * Set the value related to the column: relation_code
	 * @param relationCode the relation_code value
	 */
	public void setRelationCode (java.lang.String relationCode) {
		this.relationCode = relationCode;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FtRelation)) return false;
		else {
			jkt.hms.masters.business.FtRelation ftRelation = (jkt.hms.masters.business.FtRelation) obj;
			if (null == this.getId() || null == ftRelation.getId()) return false;
			else return (this.getId().equals(ftRelation.getId()));
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