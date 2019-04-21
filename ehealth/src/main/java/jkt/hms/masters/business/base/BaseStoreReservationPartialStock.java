package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_reservation_partial_stock table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_reservation_partial_stock"
 */

public abstract class BaseStoreReservationPartialStock  implements Serializable {

	public static String REF = "StoreReservationPartialStock";
	public static String PROP_QTY = "Qty";
	public static String PROP_ITEM_STATUS = "ItemStatus";
	public static String PROP_ITEM = "Item";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_QTY_IN_DOSES = "QtyInDoses";
	public static String PROP_CAMP_GROUP = "CampGroup";
	public static String PROP_OPEN_DATE = "OpenDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_OPEN_BOTTLE_EXPIRY_DATE = "OpenBottleExpiryDate";


	// constructors
	public BaseStoreReservationPartialStock () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreReservationPartialStock (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date openBottleExpiryDate;
	private java.util.Date openDate;
	private java.math.BigDecimal qty;
	private java.lang.String batchNo;
	private java.lang.String itemStatus;
	private java.math.BigDecimal qtyInDoses;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreReservationCampGroup campGroup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="partial_stock_id"
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
	 * Return the value associated with the column: open_bottle_expiry_date
	 */
	public java.util.Date getOpenBottleExpiryDate () {
		return openBottleExpiryDate;
	}

	/**
	 * Set the value related to the column: open_bottle_expiry_date
	 * @param openBottleExpiryDate the open_bottle_expiry_date value
	 */
	public void setOpenBottleExpiryDate (java.util.Date openBottleExpiryDate) {
		this.openBottleExpiryDate = openBottleExpiryDate;
	}



	/**
	 * Return the value associated with the column: open_date
	 */
	public java.util.Date getOpenDate () {
		return openDate;
	}

	/**
	 * Set the value related to the column: open_date
	 * @param openDate the open_date value
	 */
	public void setOpenDate (java.util.Date openDate) {
		this.openDate = openDate;
	}



	/**
	 * Return the value associated with the column: qty
	 */
	public java.math.BigDecimal getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.math.BigDecimal qty) {
		this.qty = qty;
	}



	/**
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (java.lang.String batchNo) {
		this.batchNo = batchNo;
	}



	/**
	 * Return the value associated with the column: item_status
	 */
	public java.lang.String getItemStatus () {
		return itemStatus;
	}

	/**
	 * Set the value related to the column: item_status
	 * @param itemStatus the item_status value
	 */
	public void setItemStatus (java.lang.String itemStatus) {
		this.itemStatus = itemStatus;
	}



	/**
	 * Return the value associated with the column: qtyInDoses
	 */
	public java.math.BigDecimal getQtyInDoses () {
		return qtyInDoses;
	}

	/**
	 * Set the value related to the column: qtyInDoses
	 * @param qtyInDoses the qtyInDoses value
	 */
	public void setQtyInDoses (java.math.BigDecimal qtyInDoses) {
		this.qtyInDoses = qtyInDoses;
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
	 * Return the value associated with the column: camp_group_id
	 */
	public jkt.hms.masters.business.StoreReservationCampGroup getCampGroup () {
		return campGroup;
	}

	/**
	 * Set the value related to the column: camp_group_id
	 * @param campGroup the camp_group_id value
	 */
	public void setCampGroup (jkt.hms.masters.business.StoreReservationCampGroup campGroup) {
		this.campGroup = campGroup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreReservationPartialStock)) return false;
		else {
			jkt.hms.masters.business.StoreReservationPartialStock storeReservationPartialStock = (jkt.hms.masters.business.StoreReservationPartialStock) obj;
			if (null == this.getId() || null == storeReservationPartialStock.getId()) return false;
			else return (this.getId().equals(storeReservationPartialStock.getId()));
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