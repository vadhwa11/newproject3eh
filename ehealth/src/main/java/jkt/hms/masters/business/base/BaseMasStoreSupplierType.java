package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_supplier_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_supplier_type"
 */

public abstract class BaseMasStoreSupplierType  implements Serializable {

	public static String REF = "MasStoreSupplierType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SUPPLIER_TYPE_NAME = "SupplierTypeName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SUPPLIER_TYPE_CODE = "SupplierTypeCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasStoreSupplierType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreSupplierType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String supplierTypeCode;
	private java.lang.String supplierTypeName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliers;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="supplier_type_id"
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
	 * Return the value associated with the column: supplier_type_code
	 */
	public java.lang.String getSupplierTypeCode () {
		return supplierTypeCode;
	}

	/**
	 * Set the value related to the column: supplier_type_code
	 * @param supplierTypeCode the supplier_type_code value
	 */
	public void setSupplierTypeCode (java.lang.String supplierTypeCode) {
		this.supplierTypeCode = supplierTypeCode;
	}



	/**
	 * Return the value associated with the column: supplier_type_name
	 */
	public java.lang.String getSupplierTypeName () {
		return supplierTypeName;
	}

	/**
	 * Set the value related to the column: supplier_type_name
	 * @param supplierTypeName the supplier_type_name value
	 */
	public void setSupplierTypeName (java.lang.String supplierTypeName) {
		this.supplierTypeName = supplierTypeName;
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
	 * Return the value associated with the column: MasStoreSuppliers
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreSupplier> getMasStoreSuppliers () {
		return masStoreSuppliers;
	}

	/**
	 * Set the value related to the column: MasStoreSuppliers
	 * @param masStoreSuppliers the MasStoreSuppliers value
	 */
	public void setMasStoreSuppliers (java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliers) {
		this.masStoreSuppliers = masStoreSuppliers;
	}

	public void addToMasStoreSuppliers (jkt.hms.masters.business.MasStoreSupplier masStoreSupplier) {
		if (null == getMasStoreSuppliers()) setMasStoreSuppliers(new java.util.TreeSet<jkt.hms.masters.business.MasStoreSupplier>());
		getMasStoreSuppliers().add(masStoreSupplier);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreSupplierType)) return false;
		else {
			jkt.hms.masters.business.MasStoreSupplierType masStoreSupplierType = (jkt.hms.masters.business.MasStoreSupplierType) obj;
			if (null == this.getId() || null == masStoreSupplierType.getId()) return false;
			else return (this.getId().equals(masStoreSupplierType.getId()));
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