package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_dermatological_family_history_leprosy table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_dermatological_family_history_leprosy"
 */

public abstract class BaseOpdDermatologicalFamilyHistoryLeprosy  implements Serializable {

	public static String REF = "OpdDermatologicalFamilyHistoryLeprosy";
	public static String PROP_RELATION = "Relation";
	public static String PROP_FAMILY_HISTORY_OTHER_PARAMETER_VALUE = "familyHistoryOtherParameterValue";
	public static String PROP_ID = "Id";
	public static String PROP_LEPROSY_TYPE = "LeprosyType";
	public static String PROP_LEPROSY_PROFORMA = "LeprosyProforma";


	// constructors
	public BaseOpdDermatologicalFamilyHistoryLeprosy () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdDermatologicalFamilyHistoryLeprosy (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String relation;
	private java.lang.String leprosyType;
	private java.lang.String familyHistoryOtherParameterValue;

	// many to one
	private jkt.hms.masters.business.OpdDermatologyLeprosyProforma leprosyProforma;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="family_history_leprosy_id"
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
	 * Return the value associated with the column: relation
	 */
	public java.lang.String getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation
	 * @param relation the relation value
	 */
	public void setRelation (java.lang.String relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: leprosy_type
	 */
	public java.lang.String getLeprosyType () {
		return leprosyType;
	}

	/**
	 * Set the value related to the column: leprosy_type
	 * @param leprosyType the leprosy_type value
	 */
	public void setLeprosyType (java.lang.String leprosyType) {
		this.leprosyType = leprosyType;
	}



	/**
	 * Return the value associated with the column: family_history_other_parameter_value
	 */
	public java.lang.String getFamilyHistoryOtherParameterValue () {
		return familyHistoryOtherParameterValue;
	}

	/**
	 * Set the value related to the column: family_history_other_parameter_value
	 * @param familyHistoryOtherParameterValue the family_history_other_parameter_value value
	 */
	public void setFamilyHistoryOtherParameterValue (java.lang.String familyHistoryOtherParameterValue) {
		this.familyHistoryOtherParameterValue = familyHistoryOtherParameterValue;
	}



	/**
	 * Return the value associated with the column: leprosy_proforma_id
	 */
	public jkt.hms.masters.business.OpdDermatologyLeprosyProforma getLeprosyProforma () {
		return leprosyProforma;
	}

	/**
	 * Set the value related to the column: leprosy_proforma_id
	 * @param leprosyProforma the leprosy_proforma_id value
	 */
	public void setLeprosyProforma (jkt.hms.masters.business.OpdDermatologyLeprosyProforma leprosyProforma) {
		this.leprosyProforma = leprosyProforma;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdDermatologicalFamilyHistoryLeprosy)) return false;
		else {
			jkt.hms.masters.business.OpdDermatologicalFamilyHistoryLeprosy opdDermatologicalFamilyHistoryLeprosy = (jkt.hms.masters.business.OpdDermatologicalFamilyHistoryLeprosy) obj;
			if (null == this.getId() || null == opdDermatologicalFamilyHistoryLeprosy.getId()) return false;
			else return (this.getId().equals(opdDermatologicalFamilyHistoryLeprosy.getId()));
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