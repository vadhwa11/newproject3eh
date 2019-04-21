package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_internal_indent_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_internal_indent_t"
 */

public abstract class BaseStoreInternalIndentT  implements Serializable {

	public static String REF = "StoreInternalIndentT";
	public static String PROP_ISSUED_BATCHID_AND_QTY = "IssuedBatchidAndQty";
	public static String PROP_QTY_REQUEST = "QtyRequest";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_MIN_NO = "MinNo";
	public static String PROP_PREV_TO_PREV_YEAR_IND_QTY = "PrevToPrevYearIndQty";
	public static String PROP_STOCK_IN_HAND = "StockInHand";
	public static String PROP_PENDING_INDENT_QTY = "PendingIndentQty";
	public static String PROP_QUATATION_QTY = "QuatationQty";
	public static String PROP_ADDITIONAL_QTY = "AdditionalQty";
	public static String PROP_ITEM = "Item";
	public static String PROP_PREV_YEAR_IND_QTY = "PrevYearIndQty";
	public static String PROP_INTERNAL = "Internal";
	public static String PROP_NAC_STATUS = "NacStatus";
	public static String PROP_ACTUAL_REQUESTED_QTY = "ActualRequestedQty";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_PROCUREMENT_STATUS = "ProcurementStatus";
	public static String PROP_LEAD_TIME = "LeadTime";
	public static String PROP_RETURN_REMARKS = "ReturnRemarks";
	public static String PROP_PREV_YEAR_CONSM_QTY = "PrevYearConsmQty";
	public static String PROP_INDENTED_QTY = "IndentedQty";
	public static String PROP_ITEM_STATUS = "ItemStatus";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_MMF_QTY = "MmfQty";
	public static String PROP_INCREMENTAL_PERCENTAGE = "IncrementalPercentage";
	public static String PROP_INCREMENTAL_QUANTITY = "IncrementalQuantity";
	public static String PROP_CONS_IN_LEAD_TIME = "ConsInLeadTime";
	public static String PROP_ID = "Id";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_REQUIRED_QTY = "RequiredQty";


	// constructors
	public BaseStoreInternalIndentT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreInternalIndentT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.Integer stockInHand;
	private java.lang.Integer mmfQty;
	private java.lang.Integer qtyRequest;
	private java.lang.Integer qtyIssued;
	private java.lang.String issuedBatchidAndQty;
	private java.lang.Integer actualRequestedQty;
	private java.lang.String remarks;
	private java.lang.String returnRemarks;
	private java.math.BigDecimal indentedQty;
	private java.math.BigDecimal prevToPrevYearIndQty;
	private java.math.BigDecimal prevYearIndQty;
	private java.math.BigDecimal requiredQty;
	private java.math.BigDecimal additionalQty;
	private java.math.BigDecimal pendingIndentQty;
	private java.math.BigDecimal prevYearConsmQty;
	private java.lang.String itemStatus;
	private java.lang.String procurementStatus;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.math.BigDecimal incrementalPercentage;
	private java.math.BigDecimal incrementalQuantity;
	private java.lang.Integer leadTime;
	private java.math.BigDecimal consInLeadTime;
	private java.lang.String minNo;
	private java.math.BigDecimal quatationQty;
	private java.lang.String nacStatus;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.StoreInternalIndentM internal;



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
	 * Return the value associated with the column: stock_in_hand
	 */
	public java.lang.Integer getStockInHand () {
		return stockInHand;
	}

	/**
	 * Set the value related to the column: stock_in_hand
	 * @param stockInHand the stock_in_hand value
	 */
	public void setStockInHand (java.lang.Integer stockInHand) {
		this.stockInHand = stockInHand;
	}



	/**
	 * Return the value associated with the column: mmf_qty
	 */
	public java.lang.Integer getMmfQty () {
		return mmfQty;
	}

	/**
	 * Set the value related to the column: mmf_qty
	 * @param mmfQty the mmf_qty value
	 */
	public void setMmfQty (java.lang.Integer mmfQty) {
		this.mmfQty = mmfQty;
	}



	/**
	 * Return the value associated with the column: qty_request
	 */
	public java.lang.Integer getQtyRequest () {
		return qtyRequest;
	}

	/**
	 * Set the value related to the column: qty_request
	 * @param qtyRequest the qty_request value
	 */
	public void setQtyRequest (java.lang.Integer qtyRequest) {
		this.qtyRequest = qtyRequest;
	}



	/**
	 * Return the value associated with the column: qty_issued
	 */
	public java.lang.Integer getQtyIssued () {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * @param qtyIssued the qty_issued value
	 */
	public void setQtyIssued (java.lang.Integer qtyIssued) {
		this.qtyIssued = qtyIssued;
	}



	/**
	 * Return the value associated with the column: issued_batchid_and_qty
	 */
	public java.lang.String getIssuedBatchidAndQty () {
		return issuedBatchidAndQty;
	}

	/**
	 * Set the value related to the column: issued_batchid_and_qty
	 * @param issuedBatchidAndQty the issued_batchid_and_qty value
	 */
	public void setIssuedBatchidAndQty (java.lang.String issuedBatchidAndQty) {
		this.issuedBatchidAndQty = issuedBatchidAndQty;
	}



	/**
	 * Return the value associated with the column: actual_requested_qty
	 */
	public java.lang.Integer getActualRequestedQty () {
		return actualRequestedQty;
	}

	/**
	 * Set the value related to the column: actual_requested_qty
	 * @param actualRequestedQty the actual_requested_qty value
	 */
	public void setActualRequestedQty (java.lang.Integer actualRequestedQty) {
		this.actualRequestedQty = actualRequestedQty;
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
	 * Return the value associated with the column: return_remarks
	 */
	public java.lang.String getReturnRemarks () {
		return returnRemarks;
	}

	/**
	 * Set the value related to the column: return_remarks
	 * @param returnRemarks the return_remarks value
	 */
	public void setReturnRemarks (java.lang.String returnRemarks) {
		this.returnRemarks = returnRemarks;
	}



	/**
	 * Return the value associated with the column: indented_qty
	 */
	public java.math.BigDecimal getIndentedQty () {
		return indentedQty;
	}

	/**
	 * Set the value related to the column: indented_qty
	 * @param indentedQty the indented_qty value
	 */
	public void setIndentedQty (java.math.BigDecimal indentedQty) {
		this.indentedQty = indentedQty;
	}



	/**
	 * Return the value associated with the column: prev_to_prev_year_ind_qty
	 */
	public java.math.BigDecimal getPrevToPrevYearIndQty () {
		return prevToPrevYearIndQty;
	}

	/**
	 * Set the value related to the column: prev_to_prev_year_ind_qty
	 * @param prevToPrevYearIndQty the prev_to_prev_year_ind_qty value
	 */
	public void setPrevToPrevYearIndQty (java.math.BigDecimal prevToPrevYearIndQty) {
		this.prevToPrevYearIndQty = prevToPrevYearIndQty;
	}



	/**
	 * Return the value associated with the column: prev_year_ind_qty
	 */
	public java.math.BigDecimal getPrevYearIndQty () {
		return prevYearIndQty;
	}

	/**
	 * Set the value related to the column: prev_year_ind_qty
	 * @param prevYearIndQty the prev_year_ind_qty value
	 */
	public void setPrevYearIndQty (java.math.BigDecimal prevYearIndQty) {
		this.prevYearIndQty = prevYearIndQty;
	}



	/**
	 * Return the value associated with the column: required_qty
	 */
	public java.math.BigDecimal getRequiredQty () {
		return requiredQty;
	}

	/**
	 * Set the value related to the column: required_qty
	 * @param requiredQty the required_qty value
	 */
	public void setRequiredQty (java.math.BigDecimal requiredQty) {
		this.requiredQty = requiredQty;
	}



	/**
	 * Return the value associated with the column: additional_qty
	 */
	public java.math.BigDecimal getAdditionalQty () {
		return additionalQty;
	}

	/**
	 * Set the value related to the column: additional_qty
	 * @param additionalQty the additional_qty value
	 */
	public void setAdditionalQty (java.math.BigDecimal additionalQty) {
		this.additionalQty = additionalQty;
	}



	/**
	 * Return the value associated with the column: pending_indent_qty
	 */
	public java.math.BigDecimal getPendingIndentQty () {
		return pendingIndentQty;
	}

	/**
	 * Set the value related to the column: pending_indent_qty
	 * @param pendingIndentQty the pending_indent_qty value
	 */
	public void setPendingIndentQty (java.math.BigDecimal pendingIndentQty) {
		this.pendingIndentQty = pendingIndentQty;
	}



	/**
	 * Return the value associated with the column: prev_year_consm_qty
	 */
	public java.math.BigDecimal getPrevYearConsmQty () {
		return prevYearConsmQty;
	}

	/**
	 * Set the value related to the column: prev_year_consm_qty
	 * @param prevYearConsmQty the prev_year_consm_qty value
	 */
	public void setPrevYearConsmQty (java.math.BigDecimal prevYearConsmQty) {
		this.prevYearConsmQty = prevYearConsmQty;
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
	 * Return the value associated with the column: procurement_status
	 */
	public java.lang.String getProcurementStatus () {
		return procurementStatus;
	}

	/**
	 * Set the value related to the column: procurement_status
	 * @param procurementStatus the procurement_status value
	 */
	public void setProcurementStatus (java.lang.String procurementStatus) {
		this.procurementStatus = procurementStatus;
	}



	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
	}



	/**
	 * Return the value associated with the column: incremental_percentage
	 */
	public java.math.BigDecimal getIncrementalPercentage () {
		return incrementalPercentage;
	}

	/**
	 * Set the value related to the column: incremental_percentage
	 * @param incrementalPercentage the incremental_percentage value
	 */
	public void setIncrementalPercentage (java.math.BigDecimal incrementalPercentage) {
		this.incrementalPercentage = incrementalPercentage;
	}



	/**
	 * Return the value associated with the column: incremental_quantity
	 */
	public java.math.BigDecimal getIncrementalQuantity () {
		return incrementalQuantity;
	}

	/**
	 * Set the value related to the column: incremental_quantity
	 * @param incrementalQuantity the incremental_quantity value
	 */
	public void setIncrementalQuantity (java.math.BigDecimal incrementalQuantity) {
		this.incrementalQuantity = incrementalQuantity;
	}



	/**
	 * Return the value associated with the column: lead_time
	 */
	public java.lang.Integer getLeadTime () {
		return leadTime;
	}

	/**
	 * Set the value related to the column: lead_time
	 * @param leadTime the lead_time value
	 */
	public void setLeadTime (java.lang.Integer leadTime) {
		this.leadTime = leadTime;
	}



	/**
	 * Return the value associated with the column: cons_in_lead_time
	 */
	public java.math.BigDecimal getConsInLeadTime () {
		return consInLeadTime;
	}

	/**
	 * Set the value related to the column: cons_in_lead_time
	 * @param consInLeadTime the cons_in_lead_time value
	 */
	public void setConsInLeadTime (java.math.BigDecimal consInLeadTime) {
		this.consInLeadTime = consInLeadTime;
	}



	/**
	 * Return the value associated with the column: min_no
	 */
	public java.lang.String getMinNo () {
		return minNo;
	}

	/**
	 * Set the value related to the column: min_no
	 * @param minNo the min_no value
	 */
	public void setMinNo (java.lang.String minNo) {
		this.minNo = minNo;
	}



	/**
	 * Return the value associated with the column: quatation_qty
	 */
	public java.math.BigDecimal getQuatationQty () {
		return quatationQty;
	}

	/**
	 * Set the value related to the column: quatation_qty
	 * @param quatationQty the quatation_qty value
	 */
	public void setQuatationQty (java.math.BigDecimal quatationQty) {
		this.quatationQty = quatationQty;
	}



	/**
	 * Return the value associated with the column: nac_status
	 */
	public java.lang.String getNacStatus () {
		return nacStatus;
	}

	/**
	 * Set the value related to the column: nac_status
	 * @param nacStatus the nac_status value
	 */
	public void setNacStatus (java.lang.String nacStatus) {
		this.nacStatus = nacStatus;
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



	/**
	 * Return the value associated with the column: internal_id
	 */
	public jkt.hms.masters.business.StoreInternalIndentM getInternal () {
		return internal;
	}

	/**
	 * Set the value related to the column: internal_id
	 * @param internal the internal_id value
	 */
	public void setInternal (jkt.hms.masters.business.StoreInternalIndentM internal) {
		this.internal = internal;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreInternalIndentT)) return false;
		else {
			jkt.hms.masters.business.StoreInternalIndentT storeInternalIndentT = (jkt.hms.masters.business.StoreInternalIndentT) obj;
			if (null == this.getId() || null == storeInternalIndentT.getId()) return false;
			else return (this.getId().equals(storeInternalIndentT.getId()));
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