package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_minor_routine_work_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_minor_routine_work_detail"
 */

public abstract class BaseHesMinorRoutineWorkDetail  implements Serializable {

	public static String REF = "HesMinorRoutineWorkDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ITEM = "Item";
	public static String PROP_MINORID = "Minorid";
	public static String PROP_ID = "Id";
	public static String PROP_BATCH_NO = "BatchNo";


	// constructors
	public BaseHesMinorRoutineWorkDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesMinorRoutineWorkDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer quantity;
	private java.lang.String batchNo;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.HesMinorRoutineWork minorid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="detail_id"
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
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
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
	 * Return the value associated with the column: minorid
	 */
	public jkt.hms.masters.business.HesMinorRoutineWork getMinorid () {
		return minorid;
	}

	/**
	 * Set the value related to the column: minorid
	 * @param minorid the minorid value
	 */
	public void setMinorid (jkt.hms.masters.business.HesMinorRoutineWork minorid) {
		this.minorid = minorid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesMinorRoutineWorkDetail)) return false;
		else {
			jkt.hms.masters.business.HesMinorRoutineWorkDetail hesMinorRoutineWorkDetail = (jkt.hms.masters.business.HesMinorRoutineWorkDetail) obj;
			if (null == this.getId() || null == hesMinorRoutineWorkDetail.getId()) return false;
			else return (this.getId().equals(hesMinorRoutineWorkDetail.getId()));
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