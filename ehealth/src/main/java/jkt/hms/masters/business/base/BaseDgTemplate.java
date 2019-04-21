package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the dg_template table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="dg_template"
 */

public abstract class BaseDgTemplate implements Serializable {

	public static String REF = "DgTemplate";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_RESULT = "Result";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDgTemplate() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgTemplate(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private byte[] result;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.DgMasInvestigation investigation;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="template_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: result
	 */
	public byte[] getResult() {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * 
	 * @param result
	 *            the result value
	 */
	public void setResult(byte[] result) {
		this.result = result;
	}

	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode() {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCode
	 *            the charge_code_id value
	 */
	public void setChargeCode(jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}

	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation() {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * 
	 * @param investigation
	 *            the investigation_id value
	 */
	public void setInvestigation(
			jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.DgTemplate)) {
			return false;
		} else {
			jkt.hms.masters.business.DgTemplate dgTemplate = (jkt.hms.masters.business.DgTemplate) obj;
			if (null == this.getId() || null == dgTemplate.getId()) {
				return false;
			} else {
				return (this.getId().equals(dgTemplate.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}