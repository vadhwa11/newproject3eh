package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_cs_indication table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_cs_indication"
 */

public abstract class BaseMasCsIndication implements Serializable {

	public static String REF = "MasCsIndication";
	public static String PROP_INDICATION_CODE = "IndicationCode";
	public static String PROP_INDICATION_NAME = "IndicationName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasCsIndication() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCsIndication(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String indicationCode;
	private java.lang.String indicationName;

	// collections
	private java.util.Set<jkt.hms.masters.business.BabyDetails> babyDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="id"
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
	 * Return the value associated with the column: indication_code
	 */
	public java.lang.String getIndicationCode() {
		return indicationCode;
	}

	/**
	 * Set the value related to the column: indication_code
	 * 
	 * @param indicationCode
	 *            the indication_code value
	 */
	public void setIndicationCode(java.lang.String indicationCode) {
		this.indicationCode = indicationCode;
	}

	/**
	 * Return the value associated with the column: indication_name
	 */
	public java.lang.String getIndicationName() {
		return indicationName;
	}

	/**
	 * Set the value related to the column: indication_name
	 * 
	 * @param indicationName
	 *            the indication_name value
	 */
	public void setIndicationName(java.lang.String indicationName) {
		this.indicationName = indicationName;
	}

	/**
	 * Return the value associated with the column: BabyDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BabyDetails> getBabyDetails() {
		return babyDetails;
	}

	/**
	 * Set the value related to the column: BabyDetails
	 * 
	 * @param babyDetails
	 *            the BabyDetails value
	 */
	public void setBabyDetails(
			java.util.Set<jkt.hms.masters.business.BabyDetails> babyDetails) {
		this.babyDetails = babyDetails;
	}

	public void addToBabyDetails(
			jkt.hms.masters.business.BabyDetails babyDetails) {
		if (null == getBabyDetails()) {
			setBabyDetails(new java.util.TreeSet<jkt.hms.masters.business.BabyDetails>());
		}
		getBabyDetails().add(babyDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.MasCsIndication)) {
			return false;
		} else {
			jkt.hms.masters.business.MasCsIndication masCsIndication = (jkt.hms.masters.business.MasCsIndication) obj;
			if (null == this.getId() || null == masCsIndication.getId()) {
				return false;
			} else {
				return (this.getId().equals(masCsIndication.getId()));
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