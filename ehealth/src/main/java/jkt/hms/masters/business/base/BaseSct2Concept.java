package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sct2_concept table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sct2_concept"
 */

public abstract class BaseSct2Concept  implements Serializable {

	public static String REF = "Sct2Concept";
	public static String PROP_ACTIVE = "Active";
	public static String PROP_MODULEID = "Moduleid";
	public static String PROP_DEFINITIONSTATUSID = "Definitionstatusid";
	public static String PROP_ID = "Id";


	// constructors
	public BaseSct2Concept () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSct2Concept (jkt.hms.masters.business.Sct2ConceptPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private jkt.hms.masters.business.Sct2ConceptPK id;

	// fields
	private java.lang.Long active;
	private java.lang.Long moduleid;
	private java.lang.Long definitionstatusid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public jkt.hms.masters.business.Sct2ConceptPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (jkt.hms.masters.business.Sct2ConceptPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: active
	 */
	public java.lang.Long getActive () {
		return active;
	}

	/**
	 * Set the value related to the column: active
	 * @param active the active value
	 */
	public void setActive (java.lang.Long active) {
		this.active = active;
	}



	/**
	 * Return the value associated with the column: moduleid
	 */
	public java.lang.Long getModuleid () {
		return moduleid;
	}

	/**
	 * Set the value related to the column: moduleid
	 * @param moduleid the moduleid value
	 */
	public void setModuleid (java.lang.Long moduleid) {
		this.moduleid = moduleid;
	}



	/**
	 * Return the value associated with the column: definitionstatusid
	 */
	public java.lang.Long getDefinitionstatusid () {
		return definitionstatusid;
	}

	/**
	 * Set the value related to the column: definitionstatusid
	 * @param definitionstatusid the definitionstatusid value
	 */
	public void setDefinitionstatusid (java.lang.Long definitionstatusid) {
		this.definitionstatusid = definitionstatusid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Sct2Concept)) return false;
		else {
			jkt.hms.masters.business.Sct2Concept sct2Concept = (jkt.hms.masters.business.Sct2Concept) obj;
			if (null == this.getId() || null == sct2Concept.getId()) return false;
			else return (this.getId().equals(sct2Concept.getId()));
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