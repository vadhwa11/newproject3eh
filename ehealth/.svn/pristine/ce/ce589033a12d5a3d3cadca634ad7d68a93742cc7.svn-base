package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_slow_moving_drugs table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_slow_moving_drugs"
 */

public abstract class BaseStoreSlowMovingDrugs  implements Serializable {

	public static String REF = "StoreSlowMovingDrugs";
	public static String PROP_STATUS = "Status";
	public static String PROP_ITEM_CODE = "ItemCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseStoreSlowMovingDrugs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreSlowMovingDrugs (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreSlowMovingDrugs (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasStoreItem item,
		java.lang.String itemCode,
		java.lang.String itemName) {

		this.setId(id);
		this.setHospital(hospital);
		this.setItem(item);
		this.setItemCode(itemCode);
		this.setItemName(itemName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String itemCode;
	private java.lang.String itemName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: item_code
	 */
	public java.lang.String getItemCode () {
		return itemCode;
	}

	/**
	 * Set the value related to the column: item_code
	 * @param itemCode the item_code value
	 */
	public void setItemCode (java.lang.String itemCode) {
		this.itemCode = itemCode;
	}



	/**
	 * Return the value associated with the column: item_name
	 */
	public java.lang.String getItemName () {
		return itemName;
	}

	/**
	 * Set the value related to the column: item_name
	 * @param itemName the item_name value
	 */
	public void setItemName (java.lang.String itemName) {
		this.itemName = itemName;
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



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreSlowMovingDrugs)) return false;
		else {
			jkt.hms.masters.business.StoreSlowMovingDrugs storeSlowMovingDrugs = (jkt.hms.masters.business.StoreSlowMovingDrugs) obj;
			if (null == this.getId() || null == storeSlowMovingDrugs.getId()) return false;
			else return (this.getId().equals(storeSlowMovingDrugs.getId()));
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