package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_consent table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_consent"
 */

public abstract class BaseBloodConsent  implements Serializable {

	public static String REF = "BloodConsent";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_CONSENT_CAUSE = "ConsentCause";
	public static String PROP_ID = "Id";
	public static String PROP_PROCEDURE_EXPLIANED = "ProcedureExplianed";
	public static String PROP_HIN = "Hin";
	public static String PROP_RELATION = "Relation";
	public static String PROP_DATE = "Date";
	public static String PROP_NAME = "Name";


	// constructors
	public BaseBloodConsent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodConsent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBloodConsent (
		java.lang.Integer id,
		jkt.hms.masters.business.MasRelation relation) {

		this.setId(id);
		this.setRelation(relation);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String consentCause;
	private java.lang.String address;
	private java.util.Date date;
	private java.lang.String procedureExplianed;

	// many to one
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="consent_id"
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



	/**
	 * Return the value associated with the column: consent_cause
	 */
	public java.lang.String getConsentCause () {
		return consentCause;
	}

	/**
	 * Set the value related to the column: consent_cause
	 * @param consentCause the consent_cause value
	 */
	public void setConsentCause (java.lang.String consentCause) {
		this.consentCause = consentCause;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: procedure_explianed
	 */
	public java.lang.String getProcedureExplianed () {
		return procedureExplianed;
	}

	/**
	 * Set the value related to the column: procedure_explianed
	 * @param procedureExplianed the procedure_explianed value
	 */
	public void setProcedureExplianed (java.lang.String procedureExplianed) {
		this.procedureExplianed = procedureExplianed;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodConsent)) return false;
		else {
			jkt.hms.masters.business.BloodConsent bloodConsent = (jkt.hms.masters.business.BloodConsent) obj;
			if (null == this.getId() || null == bloodConsent.getId()) return false;
			else return (this.getId().equals(bloodConsent.getId()));
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