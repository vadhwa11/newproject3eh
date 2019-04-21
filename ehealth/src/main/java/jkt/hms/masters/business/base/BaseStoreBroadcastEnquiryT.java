package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_broadcast_enquiry_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_broadcast_enquiry_t"
 */

public abstract class BaseStoreBroadcastEnquiryT  implements Serializable {

	public static String REF = "StoreBroadcastEnquiryT";
	public static String PROP_BROADCAST_STATUS = "BroadcastStatus";
	public static String PROP_ITEM = "Item";
	public static String PROP_ENQUIRY_M = "EnquiryM";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_DEMANDED_QTY_EXCESS_QTY = "DemandedQtyExcessQty";
	public static String PROP_STOCK = "Stock";


	// constructors
	public BaseStoreBroadcastEnquiryT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBroadcastEnquiryT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal demandedQtyExcessQty;
	private java.lang.String remarks;
	private java.math.BigDecimal stock;
	private java.lang.String broadcastStatus;

	// many to one
	private jkt.hms.masters.business.StoreBroadcastEnquiryM enquiryM;
	private jkt.hms.masters.business.MasStoreItem item;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="enquiry_t_id"
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
	 * Return the value associated with the column: demanded_qty_excess_qty
	 */
	public java.math.BigDecimal getDemandedQtyExcessQty () {
		return demandedQtyExcessQty;
	}

	/**
	 * Set the value related to the column: demanded_qty_excess_qty
	 * @param demandedQtyExcessQty the demanded_qty_excess_qty value
	 */
	public void setDemandedQtyExcessQty (java.math.BigDecimal demandedQtyExcessQty) {
		this.demandedQtyExcessQty = demandedQtyExcessQty;
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
	 * Return the value associated with the column: stock
	 */
	public java.math.BigDecimal getStock () {
		return stock;
	}

	/**
	 * Set the value related to the column: stock
	 * @param stock the stock value
	 */
	public void setStock (java.math.BigDecimal stock) {
		this.stock = stock;
	}



	/**
	 * Return the value associated with the column: broadcast_status
	 */
	public java.lang.String getBroadcastStatus () {
		return broadcastStatus;
	}

	/**
	 * Set the value related to the column: broadcast_status
	 * @param broadcastStatus the broadcast_status value
	 */
	public void setBroadcastStatus (java.lang.String broadcastStatus) {
		this.broadcastStatus = broadcastStatus;
	}



	/**
	 * Return the value associated with the column: enquiry_m_id
	 */
	public jkt.hms.masters.business.StoreBroadcastEnquiryM getEnquiryM () {
		return enquiryM;
	}

	/**
	 * Set the value related to the column: enquiry_m_id
	 * @param enquiryM the enquiry_m_id value
	 */
	public void setEnquiryM (jkt.hms.masters.business.StoreBroadcastEnquiryM enquiryM) {
		this.enquiryM = enquiryM;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreBroadcastEnquiryT)) return false;
		else {
			jkt.hms.masters.business.StoreBroadcastEnquiryT storeBroadcastEnquiryT = (jkt.hms.masters.business.StoreBroadcastEnquiryT) obj;
			if (null == this.getId() || null == storeBroadcastEnquiryT.getId()) return false;
			else return (this.getId().equals(storeBroadcastEnquiryT.getId()));
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