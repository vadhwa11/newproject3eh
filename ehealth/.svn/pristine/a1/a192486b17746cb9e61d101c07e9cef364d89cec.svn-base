package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_reservation_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_reservation_t"
 */

public abstract class BaseStoreReservationT  implements Serializable {

	public static String REF = "StoreReservationT";
	public static String PROP_UNRESERVED_STOCK = "UnreservedStock";
	public static String PROP_CONSUMED_QTY = "ConsumedQty";
	public static String PROP_STOCK = "Stock";
	public static String PROP_EXTENSION_DATE = "ExtensionDate";
	public static String PROP_RESERVED_STOCK = "ReservedStock";
	public static String PROP_EXTENSION = "Extension";
	public static String PROP_RETURN_QTY = "ReturnQty";
	public static String PROP_RESERVATION_TILL_DATE = "ReservationTillDate";
	public static String PROP_RESERVATION_M = "ReservationM";
	public static String PROP_ITEM_STATUS = "ItemStatus";
	public static String PROP_ITEM = "Item";
	public static String PROP_ACTUAL_STOCK = "ActualStock";
	public static String PROP_ID = "Id";


	// constructors
	public BaseStoreReservationT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreReservationT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal actualStock;
	private java.math.BigDecimal reservedStock;
	private java.math.BigDecimal unreservedStock;
	private java.lang.String itemStatus;
	private java.util.Date reservationTillDate;
	private java.lang.String extension;
	private java.util.Date extensionDate;
	private java.math.BigDecimal consumedQty;
	private java.math.BigDecimal returnQty;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreItemBatchStock stock;
	private jkt.hms.masters.business.StoreReservationM reservationM;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="reservation_t_id"
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
	 * Return the value associated with the column: actual_stock
	 */
	public java.math.BigDecimal getActualStock () {
		return actualStock;
	}

	/**
	 * Set the value related to the column: actual_stock
	 * @param actualStock the actual_stock value
	 */
	public void setActualStock (java.math.BigDecimal actualStock) {
		this.actualStock = actualStock;
	}



	/**
	 * Return the value associated with the column: reserved_stock
	 */
	public java.math.BigDecimal getReservedStock () {
		return reservedStock;
	}

	/**
	 * Set the value related to the column: reserved_stock
	 * @param reservedStock the reserved_stock value
	 */
	public void setReservedStock (java.math.BigDecimal reservedStock) {
		this.reservedStock = reservedStock;
	}



	/**
	 * Return the value associated with the column: unreserved_stock
	 */
	public java.math.BigDecimal getUnreservedStock () {
		return unreservedStock;
	}

	/**
	 * Set the value related to the column: unreserved_stock
	 * @param unreservedStock the unreserved_stock value
	 */
	public void setUnreservedStock (java.math.BigDecimal unreservedStock) {
		this.unreservedStock = unreservedStock;
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
	 * Return the value associated with the column: reservation_till_date
	 */
	public java.util.Date getReservationTillDate () {
		return reservationTillDate;
	}

	/**
	 * Set the value related to the column: reservation_till_date
	 * @param reservationTillDate the reservation_till_date value
	 */
	public void setReservationTillDate (java.util.Date reservationTillDate) {
		this.reservationTillDate = reservationTillDate;
	}



	/**
	 * Return the value associated with the column: extension
	 */
	public java.lang.String getExtension () {
		return extension;
	}

	/**
	 * Set the value related to the column: extension
	 * @param extension the extension value
	 */
	public void setExtension (java.lang.String extension) {
		this.extension = extension;
	}



	/**
	 * Return the value associated with the column: extension_date
	 */
	public java.util.Date getExtensionDate () {
		return extensionDate;
	}

	/**
	 * Set the value related to the column: extension_date
	 * @param extensionDate the extension_date value
	 */
	public void setExtensionDate (java.util.Date extensionDate) {
		this.extensionDate = extensionDate;
	}



	/**
	 * Return the value associated with the column: consumed_qty
	 */
	public java.math.BigDecimal getConsumedQty () {
		return consumedQty;
	}

	/**
	 * Set the value related to the column: consumed_qty
	 * @param consumedQty the consumed_qty value
	 */
	public void setConsumedQty (java.math.BigDecimal consumedQty) {
		this.consumedQty = consumedQty;
	}



	/**
	 * Return the value associated with the column: return_qty
	 */
	public java.math.BigDecimal getReturnQty () {
		return returnQty;
	}

	/**
	 * Set the value related to the column: return_qty
	 * @param returnQty the return_qty value
	 */
	public void setReturnQty (java.math.BigDecimal returnQty) {
		this.returnQty = returnQty;
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
	 * Return the value associated with the column: reservation_m_id
	 */
	public jkt.hms.masters.business.StoreReservationM getReservationM () {
		return reservationM;
	}

	/**
	 * Set the value related to the column: reservation_m_id
	 * @param reservationM the reservation_m_id value
	 */
	public void setReservationM (jkt.hms.masters.business.StoreReservationM reservationM) {
		this.reservationM = reservationM;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreReservationT)) return false;
		else {
			jkt.hms.masters.business.StoreReservationT storeReservationT = (jkt.hms.masters.business.StoreReservationT) obj;
			if (null == this.getId() || null == storeReservationT.getId()) return false;
			else return (this.getId().equals(storeReservationT.getId()));
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