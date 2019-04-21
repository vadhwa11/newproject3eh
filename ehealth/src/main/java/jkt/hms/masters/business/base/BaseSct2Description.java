package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sct2_description table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sct2_description"
 */

public abstract class BaseSct2Description  implements Serializable {

	public static String REF = "Sct2Description";
	public static String PROP_ACTIVE = "Active";
	public static String PROP_MODULEID = "Moduleid";
	public static String PROP_CONCEPTID = "Conceptid";
	public static String PROP_CASESIGNIFICANCEID = "Casesignificanceid";
	public static String PROP_TYPEID = "Typeid";
	public static String PROP_ID = "Id";
	public static String PROP_LANGUAGECODE = "Languagecode";
	public static String PROP_TERM = "Term";


	// constructors
	public BaseSct2Description () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSct2Description (jkt.hms.masters.business.Sct2DescriptionPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSct2Description (
		jkt.hms.masters.business.Sct2DescriptionPK id,
		java.lang.Integer active,
		java.lang.Long moduleid,
		java.lang.Long conceptid,
		java.lang.String languagecode,
		java.lang.Long typeid,
		java.lang.String term,
		java.lang.Long casesignificanceid) {

		this.setId(id);
		this.setActive(active);
		this.setModuleid(moduleid);
		this.setConceptid(conceptid);
		this.setLanguagecode(languagecode);
		this.setTypeid(typeid);
		this.setTerm(term);
		this.setCasesignificanceid(casesignificanceid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private jkt.hms.masters.business.Sct2DescriptionPK id;

	// fields
	private java.lang.Integer active;
	private java.lang.Long moduleid;
	private java.lang.Long conceptid;
	private java.lang.String languagecode;
	private java.lang.Long typeid;
	private java.lang.String term;
	private java.lang.Long casesignificanceid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public jkt.hms.masters.business.Sct2DescriptionPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (jkt.hms.masters.business.Sct2DescriptionPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: active
	 */
	public java.lang.Integer getActive () {
		return active;
	}

	/**
	 * Set the value related to the column: active
	 * @param active the active value
	 */
	public void setActive (java.lang.Integer active) {
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
	 * Return the value associated with the column: conceptid
	 */
	public java.lang.Long getConceptid () {
		return conceptid;
	}

	/**
	 * Set the value related to the column: conceptid
	 * @param conceptid the conceptid value
	 */
	public void setConceptid (java.lang.Long conceptid) {
		this.conceptid = conceptid;
	}



	/**
	 * Return the value associated with the column: languagecode
	 */
	public java.lang.String getLanguagecode () {
		return languagecode;
	}

	/**
	 * Set the value related to the column: languagecode
	 * @param languagecode the languagecode value
	 */
	public void setLanguagecode (java.lang.String languagecode) {
		this.languagecode = languagecode;
	}



	/**
	 * Return the value associated with the column: typeid
	 */
	public java.lang.Long getTypeid () {
		return typeid;
	}

	/**
	 * Set the value related to the column: typeid
	 * @param typeid the typeid value
	 */
	public void setTypeid (java.lang.Long typeid) {
		this.typeid = typeid;
	}



	/**
	 * Return the value associated with the column: term
	 */
	public java.lang.String getTerm () {
		return term;
	}

	/**
	 * Set the value related to the column: term
	 * @param term the term value
	 */
	public void setTerm (java.lang.String term) {
		this.term = term;
	}



	/**
	 * Return the value associated with the column: casesignificanceid
	 */
	public java.lang.Long getCasesignificanceid () {
		return casesignificanceid;
	}

	/**
	 * Set the value related to the column: casesignificanceid
	 * @param casesignificanceid the casesignificanceid value
	 */
	public void setCasesignificanceid (java.lang.Long casesignificanceid) {
		this.casesignificanceid = casesignificanceid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Sct2Description)) return false;
		else {
			jkt.hms.masters.business.Sct2Description sct2Description = (jkt.hms.masters.business.Sct2Description) obj;
			if (null == this.getId() || null == sct2Description.getId()) return false;
			else return (this.getId().equals(sct2Description.getId()));
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