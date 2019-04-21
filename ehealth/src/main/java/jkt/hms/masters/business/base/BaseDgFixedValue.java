package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_fixed_value table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_fixed_value"
 */

public abstract class BaseDgFixedValue  implements Serializable {

	public static String REF = "DgFixedValue";
	public static String PROP_SUB_INVESTIGATION = "SubInvestigation";
	public static String PROP_FIXED_VALUE = "FixedValue";
	public static String PROP_NORMAL_VALUE = "NormalValue";
	public static String PROP_ID = "Id";


	// constructors
	public BaseDgFixedValue () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgFixedValue (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fixedValue;
	private java.lang.String normalValue;

	// many to one
	private jkt.hms.masters.business.DgSubMasInvestigation subInvestigation;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="fixed_id"
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
	 * Return the value associated with the column: fixed_value
	 */
	public java.lang.String getFixedValue () {
		return fixedValue;
	}

	/**
	 * Set the value related to the column: fixed_value
	 * @param fixedValue the fixed_value value
	 */
	public void setFixedValue (java.lang.String fixedValue) {
		this.fixedValue = fixedValue;
	}



	/**
	 * Return the value associated with the column: normal_value
	 */
	public java.lang.String getNormalValue () {
		return normalValue;
	}

	/**
	 * Set the value related to the column: normal_value
	 * @param normalValue the normal_value value
	 */
	public void setNormalValue (java.lang.String normalValue) {
		this.normalValue = normalValue;
	}



	/**
	 * Return the value associated with the column: sub_investigation_id
	 */
	public jkt.hms.masters.business.DgSubMasInvestigation getSubInvestigation () {
		return subInvestigation;
	}

	/**
	 * Set the value related to the column: sub_investigation_id
	 * @param subInvestigation the sub_investigation_id value
	 */
	public void setSubInvestigation (jkt.hms.masters.business.DgSubMasInvestigation subInvestigation) {
		this.subInvestigation = subInvestigation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgFixedValue)) return false;
		else {
			jkt.hms.masters.business.DgFixedValue dgFixedValue = (jkt.hms.masters.business.DgFixedValue) obj;
			if (null == this.getId() || null == dgFixedValue.getId()) return false;
			else return (this.getId().equals(dgFixedValue.getId()));
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