package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_consent table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_consent"
 */

public abstract class BaseOtConsent  implements Serializable {

	public static String REF = "OtConsent";
	public static String PROP_NAME = "Name";
	public static String PROP_PROCEDURE_EXPLIANED = "ProcedureExplianed";
	public static String PROP_RALATION = "Ralation";
	public static String PROP_PHONE = "Phone";
	public static String PROP_DATE = "Date";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_PROCEDURE_TEMPLATE = "ProcedureTemplate";


	// constructors
	public BaseOtConsent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtConsent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOtConsent (
		java.lang.Integer id,
		jkt.hms.masters.business.MasRelation ralation) {

		this.setId(id);
		this.setRalation(ralation);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String phone;
	private java.lang.String address;
	private java.util.Date date;
	private java.lang.String procedureExplianed;
	private java.lang.String procedureTemplate;

	// many to one
	private jkt.hms.masters.business.MasRelation ralation;
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
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
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
	 * Return the value associated with the column: procedure_template
	 */
	public java.lang.String getProcedureTemplate () {
		return procedureTemplate;
	}

	/**
	 * Set the value related to the column: procedure_template
	 * @param procedureTemplate the procedure_template value
	 */
	public void setProcedureTemplate (java.lang.String procedureTemplate) {
		this.procedureTemplate = procedureTemplate;
	}



	/**
	 * Return the value associated with the column: ralation_id
	 */
	public jkt.hms.masters.business.MasRelation getRalation () {
		return ralation;
	}

	/**
	 * Set the value related to the column: ralation_id
	 * @param ralation the ralation_id value
	 */
	public void setRalation (jkt.hms.masters.business.MasRelation ralation) {
		this.ralation = ralation;
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
		if (!(obj instanceof jkt.hms.masters.business.OtConsent)) return false;
		else {
			jkt.hms.masters.business.OtConsent otConsent = (jkt.hms.masters.business.OtConsent) obj;
			if (null == this.getId() || null == otConsent.getId()) return false;
			else return (this.getId().equals(otConsent.getId()));
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