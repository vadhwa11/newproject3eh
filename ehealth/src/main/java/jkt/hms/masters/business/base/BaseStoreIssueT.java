package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_issue_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_issue_t"
 */

public abstract class BaseStoreIssueT  implements Serializable {

	public static String REF = "StoreIssueT";
	public static String PROP_ISSUED = "Issued";
	public static String PROP_QTY_REQUEST = "QtyRequest";
	public static String PROP_RECEIVED_BY = "ReceivedBy";
	public static String PROP_PRESCRIPTION = "Prescription";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ITEM_REPLACED_TO_PHARMACY = "ItemReplacedToPharmacy";
	public static String PROP_VISIT = "Visit";
	public static String PROP_STOCK = "Stock";
	public static String PROP_ISSUE_TYPE_STATUS = "IssueTypeStatus";
	public static String PROP_BRAND_ID = "BrandId";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_ITEM_FROM_INDENT = "ItemFromIndent";
	public static String PROP_ITEM_ORDER = "ItemOrder";
	public static String PROP_ITEM = "Item";
	public static String PROP_QTY_RETURNED = "QtyReturned";
	public static String PROP_ITEM_ISSUED = "ItemIssued";
	public static String PROP_ID = "Id";
	public static String PROP_ISSUE_M = "IssueM";
	public static String PROP_EMP_REQUESTED_QTY = "EmpRequestedQty";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_COST_PRICE = "CostPrice";
	public static String PROP_ACK_DATE = "AckDate";


	// constructors
	public BaseStoreIssueT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreIssueT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreIssueT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item,
		jkt.hms.masters.business.StoreIssueM issueM,
		jkt.hms.masters.business.StoreItemBatchStock stock) {

		this.setId(id);
		this.setItem(item);
		this.setIssueM(issueM);
		this.setStock(stock);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal qtyRequest;
	private java.lang.Integer itemIssued;
	private java.lang.String batchNo;
	private java.math.BigDecimal qtyIssued;
	private java.lang.String remarks;
	private java.util.Date expiryDate;
	private java.lang.Integer brandId;
	private java.lang.Integer srNo;
	private java.math.BigDecimal qtyReturned;
	private java.lang.String issued;
	private java.lang.String itemFromIndent;
	private java.lang.String itemOrder;
	private java.util.Date ackDate;
	private java.math.BigDecimal costPrice;
	private java.math.BigDecimal empRequestedQty;
	private java.lang.String issueTypeStatus;
	private java.lang.String itemReplacedToPharmacy;

	// many to one
	private jkt.hms.masters.business.MasEmployee receivedBy;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.StoreIssueM issueM;
	private jkt.hms.masters.business.StoreItemBatchStock stock;
	private jkt.hms.masters.business.PatientPrescriptionDetails prescription;



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
	 * Return the value associated with the column: qty_request
	 */
	public java.math.BigDecimal getQtyRequest () {
		return qtyRequest;
	}

	/**
	 * Set the value related to the column: qty_request
	 * @param qtyRequest the qty_request value
	 */
	public void setQtyRequest (java.math.BigDecimal qtyRequest) {
		this.qtyRequest = qtyRequest;
	}



	/**
	 * Return the value associated with the column: item_issued
	 */
	public java.lang.Integer getItemIssued () {
		return itemIssued;
	}

	/**
	 * Set the value related to the column: item_issued
	 * @param itemIssued the item_issued value
	 */
	public void setItemIssued (java.lang.Integer itemIssued) {
		this.itemIssued = itemIssued;
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
	 * Return the value associated with the column: qty_issued
	 */
	public java.math.BigDecimal getQtyIssued () {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * @param qtyIssued the qty_issued value
	 */
	public void setQtyIssued (java.math.BigDecimal qtyIssued) {
		this.qtyIssued = qtyIssued;
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
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * @param expiryDate the expiry_date value
	 */
	public void setExpiryDate (java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: brand_id
	 */
	public java.lang.Integer getBrandId () {
		return brandId;
	}

	/**
	 * Set the value related to the column: brand_id
	 * @param brandId the brand_id value
	 */
	public void setBrandId (java.lang.Integer brandId) {
		this.brandId = brandId;
	}



	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: qty_returned
	 */
	public java.math.BigDecimal getQtyReturned () {
		return qtyReturned;
	}

	/**
	 * Set the value related to the column: qty_returned
	 * @param qtyReturned the qty_returned value
	 */
	public void setQtyReturned (java.math.BigDecimal qtyReturned) {
		this.qtyReturned = qtyReturned;
	}



	/**
	 * Return the value associated with the column: issued
	 */
	public java.lang.String getIssued () {
		return issued;
	}

	/**
	 * Set the value related to the column: issued
	 * @param issued the issued value
	 */
	public void setIssued (java.lang.String issued) {
		this.issued = issued;
	}



	/**
	 * Return the value associated with the column: item_from_indent
	 */
	public java.lang.String getItemFromIndent () {
		return itemFromIndent;
	}

	/**
	 * Set the value related to the column: item_from_indent
	 * @param itemFromIndent the item_from_indent value
	 */
	public void setItemFromIndent (java.lang.String itemFromIndent) {
		this.itemFromIndent = itemFromIndent;
	}



	/**
	 * Return the value associated with the column: item_order
	 */
	public java.lang.String getItemOrder () {
		return itemOrder;
	}

	/**
	 * Set the value related to the column: item_order
	 * @param itemOrder the item_order value
	 */
	public void setItemOrder (java.lang.String itemOrder) {
		this.itemOrder = itemOrder;
	}



	/**
	 * Return the value associated with the column: ack_date
	 */
	public java.util.Date getAckDate () {
		return ackDate;
	}

	/**
	 * Set the value related to the column: ack_date
	 * @param ackDate the ack_date value
	 */
	public void setAckDate (java.util.Date ackDate) {
		this.ackDate = ackDate;
	}



	/**
	 * Return the value associated with the column: cost_price
	 */
	public java.math.BigDecimal getCostPrice () {
		return costPrice;
	}

	/**
	 * Set the value related to the column: cost_price
	 * @param costPrice the cost_price value
	 */
	public void setCostPrice (java.math.BigDecimal costPrice) {
		this.costPrice = costPrice;
	}



	/**
	 * Return the value associated with the column: emp_requested_qty
	 */
	public java.math.BigDecimal getEmpRequestedQty () {
		return empRequestedQty;
	}

	/**
	 * Set the value related to the column: emp_requested_qty
	 * @param empRequestedQty the emp_requested_qty value
	 */
	public void setEmpRequestedQty (java.math.BigDecimal empRequestedQty) {
		this.empRequestedQty = empRequestedQty;
	}



	/**
	 * Return the value associated with the column: issue_type_status
	 */
	public java.lang.String getIssueTypeStatus () {
		return issueTypeStatus;
	}

	/**
	 * Set the value related to the column: issue_type_status
	 * @param issueTypeStatus the issue_type_status value
	 */
	public void setIssueTypeStatus (java.lang.String issueTypeStatus) {
		this.issueTypeStatus = issueTypeStatus;
	}



	/**
	 * Return the value associated with the column: item_replaced_to_pharmacy
	 */
	public java.lang.String getItemReplacedToPharmacy () {
		return itemReplacedToPharmacy;
	}

	/**
	 * Set the value related to the column: item_replaced_to_pharmacy
	 * @param itemReplacedToPharmacy the item_replaced_to_pharmacy value
	 */
	public void setItemReplacedToPharmacy (java.lang.String itemReplacedToPharmacy) {
		this.itemReplacedToPharmacy = itemReplacedToPharmacy;
	}



	/**
	 * Return the value associated with the column: received_by
	 */
	public jkt.hms.masters.business.MasEmployee getReceivedBy () {
		return receivedBy;
	}

	/**
	 * Set the value related to the column: received_by
	 * @param receivedBy the received_by value
	 */
	public void setReceivedBy (jkt.hms.masters.business.MasEmployee receivedBy) {
		this.receivedBy = receivedBy;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: issue_m_id
	 */
	public jkt.hms.masters.business.StoreIssueM getIssueM () {
		return issueM;
	}

	/**
	 * Set the value related to the column: issue_m_id
	 * @param issueM the issue_m_id value
	 */
	public void setIssueM (jkt.hms.masters.business.StoreIssueM issueM) {
		this.issueM = issueM;
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
	 * Return the value associated with the column: pres_id
	 */
	public jkt.hms.masters.business.PatientPrescriptionDetails getPrescription () {
		return prescription;
	}

	/**
	 * Set the value related to the column: pres_id
	 * @param prescription the pres_id value
	 */
	public void setPrescription (jkt.hms.masters.business.PatientPrescriptionDetails prescription) {
		this.prescription = prescription;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreIssueT)) return false;
		else {
			jkt.hms.masters.business.StoreIssueT storeIssueT = (jkt.hms.masters.business.StoreIssueT) obj;
			if (null == this.getId() || null == storeIssueT.getId()) return false;
			else return (this.getId().equals(storeIssueT.getId()));
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