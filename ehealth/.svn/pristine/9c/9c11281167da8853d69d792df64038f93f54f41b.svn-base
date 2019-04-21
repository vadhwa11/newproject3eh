package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_unit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_unit"
 */

public abstract class BaseMasStoreUnit  implements Serializable {

	public static String REF = "MasStoreUnit";
	public static String PROP_UNIT_NAME = "UnitName";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasStoreUnit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreUnit (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String unitName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> masStoreItemConversionsByPurchaseUnit;
	private java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> masStoreItemConversionsByIssueUnit;
	private java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> masStoreItemConversionsByIntermediateUnit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="unit_id"
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
	 * Return the value associated with the column: unit_name
	 */
	public java.lang.String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: unit_name
	 * @param unitName the unit_name value
	 */
	public void setUnitName (java.lang.String unitName) {
		this.unitName = unitName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: MasStoreItemConversionsByPurchaseUnit
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> getMasStoreItemConversionsByPurchaseUnit () {
		return masStoreItemConversionsByPurchaseUnit;
	}

	/**
	 * Set the value related to the column: MasStoreItemConversionsByPurchaseUnit
	 * @param masStoreItemConversionsByPurchaseUnit the MasStoreItemConversionsByPurchaseUnit value
	 */
	public void setMasStoreItemConversionsByPurchaseUnit (java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> masStoreItemConversionsByPurchaseUnit) {
		this.masStoreItemConversionsByPurchaseUnit = masStoreItemConversionsByPurchaseUnit;
	}

	public void addToMasStoreItemConversionsByPurchaseUnit (jkt.hms.masters.business.MasStoreItemConversion masStoreItemConversion) {
		if (null == getMasStoreItemConversionsByPurchaseUnit()) setMasStoreItemConversionsByPurchaseUnit(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItemConversion>());
		getMasStoreItemConversionsByPurchaseUnit().add(masStoreItemConversion);
	}



	/**
	 * Return the value associated with the column: MasStoreItemConversionsByIssueUnit
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> getMasStoreItemConversionsByIssueUnit () {
		return masStoreItemConversionsByIssueUnit;
	}

	/**
	 * Set the value related to the column: MasStoreItemConversionsByIssueUnit
	 * @param masStoreItemConversionsByIssueUnit the MasStoreItemConversionsByIssueUnit value
	 */
	public void setMasStoreItemConversionsByIssueUnit (java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> masStoreItemConversionsByIssueUnit) {
		this.masStoreItemConversionsByIssueUnit = masStoreItemConversionsByIssueUnit;
	}

	public void addToMasStoreItemConversionsByIssueUnit (jkt.hms.masters.business.MasStoreItemConversion masStoreItemConversion) {
		if (null == getMasStoreItemConversionsByIssueUnit()) setMasStoreItemConversionsByIssueUnit(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItemConversion>());
		getMasStoreItemConversionsByIssueUnit().add(masStoreItemConversion);
	}



	/**
	 * Return the value associated with the column: MasStoreItemConversionsByIntermediateUnit
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> getMasStoreItemConversionsByIntermediateUnit () {
		return masStoreItemConversionsByIntermediateUnit;
	}

	/**
	 * Set the value related to the column: MasStoreItemConversionsByIntermediateUnit
	 * @param masStoreItemConversionsByIntermediateUnit the MasStoreItemConversionsByIntermediateUnit value
	 */
	public void setMasStoreItemConversionsByIntermediateUnit (java.util.Set<jkt.hms.masters.business.MasStoreItemConversion> masStoreItemConversionsByIntermediateUnit) {
		this.masStoreItemConversionsByIntermediateUnit = masStoreItemConversionsByIntermediateUnit;
	}

	public void addToMasStoreItemConversionsByIntermediateUnit (jkt.hms.masters.business.MasStoreItemConversion masStoreItemConversion) {
		if (null == getMasStoreItemConversionsByIntermediateUnit()) setMasStoreItemConversionsByIntermediateUnit(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItemConversion>());
		getMasStoreItemConversionsByIntermediateUnit().add(masStoreItemConversion);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreUnit)) return false;
		else {
			jkt.hms.masters.business.MasStoreUnit masStoreUnit = (jkt.hms.masters.business.MasStoreUnit) obj;
			if (null == this.getId() || null == masStoreUnit.getId()) return false;
			else return (this.getId().equals(masStoreUnit.getId()));
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