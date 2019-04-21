package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_gestation table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_gestation"
 */

public abstract class BaseMasGestation implements Serializable {

	public static String REF = "MasGestation";
	public static String PROP_GESTATION_CODE = "GestationCode";
	public static String PROP_ID = "Id";
	public static String PROP_GESTATION_NAME = "GestationName";

	// constructors
	public BaseMasGestation() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasGestation(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String gestationCode;
	private java.lang.String gestationName;

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
	 * Return the value associated with the column: gestation_code
	 */
	public java.lang.String getGestationCode() {
		return gestationCode;
	}

	/**
	 * Set the value related to the column: gestation_code
	 * 
	 * @param gestationCode
	 *            the gestation_code value
	 */
	public void setGestationCode(java.lang.String gestationCode) {
		this.gestationCode = gestationCode;
	}

	/**
	 * Return the value associated with the column: gestation_name
	 */
	public java.lang.String getGestationName() {
		return gestationName;
	}

	/**
	 * Set the value related to the column: gestation_name
	 * 
	 * @param gestationName
	 *            the gestation_name value
	 */
	public void setGestationName(java.lang.String gestationName) {
		this.gestationName = gestationName;
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
		if (!(obj instanceof jkt.hms.masters.business.MasGestation)) {
			return false;
		} else {
			jkt.hms.masters.business.MasGestation masGestation = (jkt.hms.masters.business.MasGestation) obj;
			if (null == this.getId() || null == masGestation.getId()) {
				return false;
			} else {
				return (this.getId().equals(masGestation.getId()));
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