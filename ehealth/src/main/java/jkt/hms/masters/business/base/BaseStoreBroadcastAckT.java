package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_broadcast_ack_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_broadcast_ack_t"
 */

public abstract class BaseStoreBroadcastAckT  implements Serializable {

	public static String REF = "StoreBroadcastAckT";
	public static String PROP_ACK_M = "AckM";
	public static String PROP_ITEM = "Item";
	public static String PROP_AVAILABLE_STOCK = "AvailableStock";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_DEMANDED_QTY = "DemandedQty";
	public static String PROP_AVAILABLE_STOCK_FOR_DISPATCH = "AvailableStockForDispatch";


	// constructors
	public BaseStoreBroadcastAckT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBroadcastAckT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal demandedQty;
	private java.math.BigDecimal availableStock;
	private java.math.BigDecimal availableStockForDispatch;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.StoreBroadcastAckM ackM;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ack_t_id"
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
	 * Return the value associated with the column: demanded_qty
	 */
	public java.math.BigDecimal getDemandedQty () {
		return demandedQty;
	}

	/**
	 * Set the value related to the column: demanded_qty
	 * @param demandedQty the demanded_qty value
	 */
	public void setDemandedQty (java.math.BigDecimal demandedQty) {
		this.demandedQty = demandedQty;
	}



	/**
	 * Return the value associated with the column: available_stock
	 */
	public java.math.BigDecimal getAvailableStock () {
		return availableStock;
	}

	/**
	 * Set the value related to the column: available_stock
	 * @param availableStock the available_stock value
	 */
	public void setAvailableStock (java.math.BigDecimal availableStock) {
		this.availableStock = availableStock;
	}



	/**
	 * Return the value associated with the column: available_stock_for_dispatch
	 */
	public java.math.BigDecimal getAvailableStockForDispatch () {
		return availableStockForDispatch;
	}

	/**
	 * Set the value related to the column: available_stock_for_dispatch
	 * @param availableStockForDispatch the available_stock_for_dispatch value
	 */
	public void setAvailableStockForDispatch (java.math.BigDecimal availableStockForDispatch) {
		this.availableStockForDispatch = availableStockForDispatch;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: ack_m_id
	 */
	public jkt.hms.masters.business.StoreBroadcastAckM getAckM () {
		return ackM;
	}

	/**
	 * Set the value related to the column: ack_m_id
	 * @param ackM the ack_m_id value
	 */
	public void setAckM (jkt.hms.masters.business.StoreBroadcastAckM ackM) {
		this.ackM = ackM;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreBroadcastAckT)) return false;
		else {
			jkt.hms.masters.business.StoreBroadcastAckT storeBroadcastAckT = (jkt.hms.masters.business.StoreBroadcastAckT) obj;
			if (null == this.getId() || null == storeBroadcastAckT.getId()) return false;
			else return (this.getId().equals(storeBroadcastAckT.getId()));
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