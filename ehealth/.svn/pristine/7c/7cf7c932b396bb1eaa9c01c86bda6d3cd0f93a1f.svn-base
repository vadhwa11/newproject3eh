package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_item_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_item_details"
 */

public abstract class BaseMasStoreItemDetails  implements Serializable {

	public static String REF = "MasStoreItemDetails";
	public static String PROP_NON_MOVING_DAYS = "NonMovingDays";
	public static String PROP_SLOW_MOVING_DAYS = "SlowMovingDays";
	public static String PROP_ROL = "Rol";
	public static String PROP_FAST_MOVING_DAYS = "FastMovingDays";
	public static String PROP_ITEM = "Item";
	public static String PROP_MAX_STOCK = "MaxStock";
	public static String PROP_MIN_STOCK = "MinStock";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ABC = "Abc";
	public static String PROP_VED = "Ved";
	public static String PROP_ID = "Id";
	public static String PROP_LEAD_TIME = "LeadTime";


	// constructors
	public BaseMasStoreItemDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreItemDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal minStock;
	private java.math.BigDecimal maxStock;
	private java.lang.String leadTime;
	private java.lang.Integer slowMovingDays;
	private java.lang.Integer fastMovingDays;
	private java.lang.Integer nonMovingDays;
	private java.lang.String ved;
	private java.lang.String abc;
	private java.lang.String rol;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="store_item_details_id"
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
	 * Return the value associated with the column: min_stock
	 */
	public java.math.BigDecimal getMinStock () {
		return minStock;
	}

	/**
	 * Set the value related to the column: min_stock
	 * @param minStock the min_stock value
	 */
	public void setMinStock (java.math.BigDecimal minStock) {
		this.minStock = minStock;
	}



	/**
	 * Return the value associated with the column: max_stock
	 */
	public java.math.BigDecimal getMaxStock () {
		return maxStock;
	}

	/**
	 * Set the value related to the column: max_stock
	 * @param maxStock the max_stock value
	 */
	public void setMaxStock (java.math.BigDecimal maxStock) {
		this.maxStock = maxStock;
	}



	/**
	 * Return the value associated with the column: lead_time
	 */
	public java.lang.String getLeadTime () {
		return leadTime;
	}

	/**
	 * Set the value related to the column: lead_time
	 * @param leadTime the lead_time value
	 */
	public void setLeadTime (java.lang.String leadTime) {
		this.leadTime = leadTime;
	}



	/**
	 * Return the value associated with the column: slow_moving_days
	 */
	public java.lang.Integer getSlowMovingDays () {
		return slowMovingDays;
	}

	/**
	 * Set the value related to the column: slow_moving_days
	 * @param slowMovingDays the slow_moving_days value
	 */
	public void setSlowMovingDays (java.lang.Integer slowMovingDays) {
		this.slowMovingDays = slowMovingDays;
	}



	/**
	 * Return the value associated with the column: fast_moving_days
	 */
	public java.lang.Integer getFastMovingDays () {
		return fastMovingDays;
	}

	/**
	 * Set the value related to the column: fast_moving_days
	 * @param fastMovingDays the fast_moving_days value
	 */
	public void setFastMovingDays (java.lang.Integer fastMovingDays) {
		this.fastMovingDays = fastMovingDays;
	}



	/**
	 * Return the value associated with the column: non_moving_days
	 */
	public java.lang.Integer getNonMovingDays () {
		return nonMovingDays;
	}

	/**
	 * Set the value related to the column: non_moving_days
	 * @param nonMovingDays the non_moving_days value
	 */
	public void setNonMovingDays (java.lang.Integer nonMovingDays) {
		this.nonMovingDays = nonMovingDays;
	}



	/**
	 * Return the value associated with the column: ved
	 */
	public java.lang.String getVed () {
		return ved;
	}

	/**
	 * Set the value related to the column: ved
	 * @param ved the ved value
	 */
	public void setVed (java.lang.String ved) {
		this.ved = ved;
	}



	/**
	 * Return the value associated with the column: abc
	 */
	public java.lang.String getAbc () {
		return abc;
	}

	/**
	 * Set the value related to the column: abc
	 * @param abc the abc value
	 */
	public void setAbc (java.lang.String abc) {
		this.abc = abc;
	}



	/**
	 * Return the value associated with the column: rol
	 */
	public java.lang.String getRol () {
		return rol;
	}

	/**
	 * Set the value related to the column: rol
	 * @param rol the rol value
	 */
	public void setRol (java.lang.String rol) {
		this.rol = rol;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreItemDetails)) return false;
		else {
			jkt.hms.masters.business.MasStoreItemDetails masStoreItemDetails = (jkt.hms.masters.business.MasStoreItemDetails) obj;
			if (null == this.getId() || null == masStoreItemDetails.getId()) return false;
			else return (this.getId().equals(masStoreItemDetails.getId()));
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