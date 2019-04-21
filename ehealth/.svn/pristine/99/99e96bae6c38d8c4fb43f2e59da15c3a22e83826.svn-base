package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_refrigerator_allocation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_refrigerator_allocation"
 */

public abstract class BaseStoreRefrigeratorAllocation  implements Serializable {

	public static String REF = "StoreRefrigeratorAllocation";
	public static String PROP_MAX_TEMP = "MaxTemp";
	public static String PROP_MIN_TEMP = "MinTemp";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_GRN_QTY = "GrnQty";
	public static String PROP_REFRIGERATOR_NO = "RefrigeratorNo";
	public static String PROP_STOCK = "Stock";
	public static String PROP_PENDING_QTY = "PendingQty";
	public static String PROP_TRANSFER = "Transfer";
	public static String PROP_STATUS = "Status";
	public static String PROP_REF_BATCH_NO = "RefBatchNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_STORED_QTY = "StoredQty";
	public static String PROP_ID = "Id";
	public static String PROP_DISCARD_RETAIN = "Discard_Retain";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseStoreRefrigeratorAllocation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreRefrigeratorAllocation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal grnQty;
	private java.math.BigDecimal storedQty;
	private java.math.BigDecimal pendingQty;
	private java.math.BigDecimal minTemp;
	private java.math.BigDecimal maxTemp;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String discard_Retain;
	private java.lang.String refBatchNo;
	private java.lang.String transfer;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem refrigeratorNo;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreItemBatchStock stock;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="allocation_id"
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
	 * Return the value associated with the column: grn_qty
	 */
	public java.math.BigDecimal getGrnQty () {
		return grnQty;
	}

	/**
	 * Set the value related to the column: grn_qty
	 * @param grnQty the grn_qty value
	 */
	public void setGrnQty (java.math.BigDecimal grnQty) {
		this.grnQty = grnQty;
	}



	/**
	 * Return the value associated with the column: stored_qty
	 */
	public java.math.BigDecimal getStoredQty () {
		return storedQty;
	}

	/**
	 * Set the value related to the column: stored_qty
	 * @param storedQty the stored_qty value
	 */
	public void setStoredQty (java.math.BigDecimal storedQty) {
		this.storedQty = storedQty;
	}



	/**
	 * Return the value associated with the column: pending_qty
	 */
	public java.math.BigDecimal getPendingQty () {
		return pendingQty;
	}

	/**
	 * Set the value related to the column: pending_qty
	 * @param pendingQty the pending_qty value
	 */
	public void setPendingQty (java.math.BigDecimal pendingQty) {
		this.pendingQty = pendingQty;
	}



	/**
	 * Return the value associated with the column: min_temp
	 */
	public java.math.BigDecimal getMinTemp () {
		return minTemp;
	}

	/**
	 * Set the value related to the column: min_temp
	 * @param minTemp the min_temp value
	 */
	public void setMinTemp (java.math.BigDecimal minTemp) {
		this.minTemp = minTemp;
	}



	/**
	 * Return the value associated with the column: max_temp
	 */
	public java.math.BigDecimal getMaxTemp () {
		return maxTemp;
	}

	/**
	 * Set the value related to the column: max_temp
	 * @param maxTemp the max_temp value
	 */
	public void setMaxTemp (java.math.BigDecimal maxTemp) {
		this.maxTemp = maxTemp;
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
	 * Return the value associated with the column: discard_retain
	 */
	public java.lang.String getDiscard_Retain () {
		return discard_Retain;
	}

	/**
	 * Set the value related to the column: discard_retain
	 * @param discard_Retain the discard_retain value
	 */
	public void setDiscard_Retain (java.lang.String discard_Retain) {
		this.discard_Retain = discard_Retain;
	}



	/**
	 * Return the value associated with the column: ref_batch_no
	 */
	public java.lang.String getRefBatchNo () {
		return refBatchNo;
	}

	/**
	 * Set the value related to the column: ref_batch_no
	 * @param refBatchNo the ref_batch_no value
	 */
	public void setRefBatchNo (java.lang.String refBatchNo) {
		this.refBatchNo = refBatchNo;
	}



	/**
	 * Return the value associated with the column: transfer
	 */
	public java.lang.String getTransfer () {
		return transfer;
	}

	/**
	 * Set the value related to the column: transfer
	 * @param transfer the transfer value
	 */
	public void setTransfer (java.lang.String transfer) {
		this.transfer = transfer;
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
	 * Return the value associated with the column: refrigerator_no
	 */
	public jkt.hms.masters.business.MasStoreItem getRefrigeratorNo () {
		return refrigeratorNo;
	}

	/**
	 * Set the value related to the column: refrigerator_no
	 * @param refrigeratorNo the refrigerator_no value
	 */
	public void setRefrigeratorNo (jkt.hms.masters.business.MasStoreItem refrigeratorNo) {
		this.refrigeratorNo = refrigeratorNo;
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
	 * Return the value associated with the column: stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getStock () {
		return stock;
	}

	/**
	 * Set the value related to the column: stock_id
	 * @param stock the stock_id value
	 */
	public void setStock (jkt.hms.masters.business.StoreItemBatchStock stock) {
		this.stock = stock;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreRefrigeratorAllocation)) return false;
		else {
			jkt.hms.masters.business.StoreRefrigeratorAllocation storeRefrigeratorAllocation = (jkt.hms.masters.business.StoreRefrigeratorAllocation) obj;
			if (null == this.getId() || null == storeRefrigeratorAllocation.getId()) return false;
			else return (this.getId().equals(storeRefrigeratorAllocation.getId()));
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