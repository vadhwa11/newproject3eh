package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_item_batch_stock table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_item_batch_stock"
 */

public abstract class BaseStoreItemBatchStock  implements Serializable {

	public static String REF = "StoreItemBatchStock";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_ISSUE_QTY = "IssueQty";
	public static String PROP_UNBLOCK_ORDER_NO = "UnblockOrderNo";
	public static String PROP_MANUFACTURE_DATE = "ManufactureDate";
	public static String PROP_BLOCK_REASON = "BlockReason";
	public static String PROP_BLOCKED_QTY = "BlockedQty";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_DONATED_ITEM = "DonatedItem";
	public static String PROP_OPENING_BALANCE_AMOUNT = "OpeningBalanceAmount";
	public static String PROP_MRP = "Mrp";
	public static String PROP_BLOCK_DATE = "BlockDate";
	public static String PROP_SALES_TAX = "SalesTax";
	public static String PROP_ITEM = "Item";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LOAN_OUT_QTY = "LoanOutQty";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_COST_PRICE = "CostPrice";
	public static String PROP_FREE_ITEM = "FreeItem";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ADJUST_QTY = "AdjustQty";
	public static String PROP_BLOCK_ORDER_DATE = "BlockOrderDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BLOCK_STATUS = "BlockStatus";
	public static String PROP_RESERVED_QTY = "ReservedQty";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CLOSING_STOCK = "ClosingStock";
	public static String PROP_DISPENCING_PRICE = "DispencingPrice";
	public static String PROP_RECEIVED_QTY = "ReceivedQty";
	public static String PROP_RECEIPT_RETURN_NONRETURNABLE = "ReceiptReturnNonreturnable";
	public static String PROP_EQUIPMENT_DETAIL_STATUS = "EquipmentDetailStatus";
	public static String PROP_UNBLOCK_ORDER_DATE = "UnblockOrderDate";
	public static String PROP_ISSUE_RETURN = "IssueReturn";
	public static String PROP_BRAND = "Brand";
	public static String PROP_LOT_NO = "LotNo";
	public static String PROP_OPENING_BALANCE_QTY = "OpeningBalanceQty";
	public static String PROP_REFRIGERATOR_STATUS = "RefrigeratorStatus";
	public static String PROP_SUPPLIER_NAME = "SupplierName";
	public static String PROP_BARCODE_NO = "BarcodeNo";
	public static String PROP_BLOCK_ORDER_NO = "BlockOrderNo";
	public static String PROP_RECEIPT_RETURN_RETURNABLE = "ReceiptReturnReturnable";
	public static String PROP_ID = "Id";
	public static String PROP_OPENING_BALANCE_DATE = "OpeningBalanceDate";
	public static String PROP_LOAN_IN_QTY = "LoanInQty";
	public static String PROP_OUT_TW_NO = "OutTwNo";


	// constructors
	public BaseStoreItemBatchStock () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreItemBatchStock (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreItemBatchStock (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item) {

		this.setId(id);
		this.setItem(item);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String batchNo;
	private java.util.Date expiryDate;
	private java.util.Date openingBalanceDate;
	private java.math.BigDecimal openingBalanceQty;
	private java.math.BigDecimal openingBalanceAmount;
	private java.math.BigDecimal receivedQty;
	private java.math.BigDecimal issueQty;
	private java.math.BigDecimal adjustQty;
	private java.math.BigDecimal receiptReturnReturnable;
	private java.math.BigDecimal receiptReturnNonreturnable;
	private java.math.BigDecimal issueReturn;
	private java.math.BigDecimal closingStock;
	private java.math.BigDecimal costPrice;
	private java.math.BigDecimal mrp;
	private java.math.BigDecimal salesTax;
	private java.lang.String freeItem;
	private java.lang.String donatedItem;
	private java.math.BigDecimal loanInQty;
	private java.math.BigDecimal loanOutQty;
	private java.lang.String lotNo;
	private java.math.BigDecimal blockedQty;
	private java.math.BigDecimal dispencingPrice;
	private java.lang.String barcodeNo;
	private java.util.Date lastChgDate;
	private java.util.Date manufactureDate;
	private java.util.Date blockDate;
	private java.lang.String blockStatus;
	private java.lang.String blockReason;
	private java.math.BigDecimal reservedQty;
	private java.lang.String blockOrderNo;
	private java.util.Date blockOrderDate;
	private java.lang.String unblockOrderNo;
	private java.util.Date unblockOrderDate;
	private java.lang.String refrigeratorStatus;
	private java.lang.String equipmentDetailStatus;
	private java.lang.String supplierName;
	private java.lang.Long outTwNo;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasManufacturer manufacturer;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="stock_id"
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
	 * Return the value associated with the column: opening_balance_date
	 */
	public java.util.Date getOpeningBalanceDate () {
		return openingBalanceDate;
	}

	/**
	 * Set the value related to the column: opening_balance_date
	 * @param openingBalanceDate the opening_balance_date value
	 */
	public void setOpeningBalanceDate (java.util.Date openingBalanceDate) {
		this.openingBalanceDate = openingBalanceDate;
	}



	/**
	 * Return the value associated with the column: opening_balance_qty
	 */
	public java.math.BigDecimal getOpeningBalanceQty () {
		return openingBalanceQty;
	}

	/**
	 * Set the value related to the column: opening_balance_qty
	 * @param openingBalanceQty the opening_balance_qty value
	 */
	public void setOpeningBalanceQty (java.math.BigDecimal openingBalanceQty) {
		this.openingBalanceQty = openingBalanceQty;
	}



	/**
	 * Return the value associated with the column: opening_balance_amount
	 */
	public java.math.BigDecimal getOpeningBalanceAmount () {
		return openingBalanceAmount;
	}

	/**
	 * Set the value related to the column: opening_balance_amount
	 * @param openingBalanceAmount the opening_balance_amount value
	 */
	public void setOpeningBalanceAmount (java.math.BigDecimal openingBalanceAmount) {
		this.openingBalanceAmount = openingBalanceAmount;
	}



	/**
	 * Return the value associated with the column: received_qty
	 */
	public java.math.BigDecimal getReceivedQty () {
		return receivedQty;
	}

	/**
	 * Set the value related to the column: received_qty
	 * @param receivedQty the received_qty value
	 */
	public void setReceivedQty (java.math.BigDecimal receivedQty) {
		this.receivedQty = receivedQty;
	}



	/**
	 * Return the value associated with the column: issue_qty
	 */
	public java.math.BigDecimal getIssueQty () {
		return issueQty;
	}

	/**
	 * Set the value related to the column: issue_qty
	 * @param issueQty the issue_qty value
	 */
	public void setIssueQty (java.math.BigDecimal issueQty) {
		this.issueQty = issueQty;
	}



	/**
	 * Return the value associated with the column: adjust_qty
	 */
	public java.math.BigDecimal getAdjustQty () {
		return adjustQty;
	}

	/**
	 * Set the value related to the column: adjust_qty
	 * @param adjustQty the adjust_qty value
	 */
	public void setAdjustQty (java.math.BigDecimal adjustQty) {
		this.adjustQty = adjustQty;
	}



	/**
	 * Return the value associated with the column: receipt_return_returnable
	 */
	public java.math.BigDecimal getReceiptReturnReturnable () {
		return receiptReturnReturnable;
	}

	/**
	 * Set the value related to the column: receipt_return_returnable
	 * @param receiptReturnReturnable the receipt_return_returnable value
	 */
	public void setReceiptReturnReturnable (java.math.BigDecimal receiptReturnReturnable) {
		this.receiptReturnReturnable = receiptReturnReturnable;
	}



	/**
	 * Return the value associated with the column: receipt_return_nonreturnable
	 */
	public java.math.BigDecimal getReceiptReturnNonreturnable () {
		return receiptReturnNonreturnable;
	}

	/**
	 * Set the value related to the column: receipt_return_nonreturnable
	 * @param receiptReturnNonreturnable the receipt_return_nonreturnable value
	 */
	public void setReceiptReturnNonreturnable (java.math.BigDecimal receiptReturnNonreturnable) {
		this.receiptReturnNonreturnable = receiptReturnNonreturnable;
	}



	/**
	 * Return the value associated with the column: issue_return
	 */
	public java.math.BigDecimal getIssueReturn () {
		return issueReturn;
	}

	/**
	 * Set the value related to the column: issue_return
	 * @param issueReturn the issue_return value
	 */
	public void setIssueReturn (java.math.BigDecimal issueReturn) {
		this.issueReturn = issueReturn;
	}



	/**
	 * Return the value associated with the column: closing_stock
	 */
	public java.math.BigDecimal getClosingStock () {
		return closingStock;
	}

	/**
	 * Set the value related to the column: closing_stock
	 * @param closingStock the closing_stock value
	 */
	public void setClosingStock (java.math.BigDecimal closingStock) {
		this.closingStock = closingStock;
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
	 * Return the value associated with the column: mrp
	 */
	public java.math.BigDecimal getMrp () {
		return mrp;
	}

	/**
	 * Set the value related to the column: mrp
	 * @param mrp the mrp value
	 */
	public void setMrp (java.math.BigDecimal mrp) {
		this.mrp = mrp;
	}



	/**
	 * Return the value associated with the column: sales_tax
	 */
	public java.math.BigDecimal getSalesTax () {
		return salesTax;
	}

	/**
	 * Set the value related to the column: sales_tax
	 * @param salesTax the sales_tax value
	 */
	public void setSalesTax (java.math.BigDecimal salesTax) {
		this.salesTax = salesTax;
	}



	/**
	 * Return the value associated with the column: free_item
	 */
	public java.lang.String getFreeItem () {
		return freeItem;
	}

	/**
	 * Set the value related to the column: free_item
	 * @param freeItem the free_item value
	 */
	public void setFreeItem (java.lang.String freeItem) {
		this.freeItem = freeItem;
	}



	/**
	 * Return the value associated with the column: donated_item
	 */
	public java.lang.String getDonatedItem () {
		return donatedItem;
	}

	/**
	 * Set the value related to the column: donated_item
	 * @param donatedItem the donated_item value
	 */
	public void setDonatedItem (java.lang.String donatedItem) {
		this.donatedItem = donatedItem;
	}



	/**
	 * Return the value associated with the column: loan_in_qty
	 */
	public java.math.BigDecimal getLoanInQty () {
		return loanInQty;
	}

	/**
	 * Set the value related to the column: loan_in_qty
	 * @param loanInQty the loan_in_qty value
	 */
	public void setLoanInQty (java.math.BigDecimal loanInQty) {
		this.loanInQty = loanInQty;
	}



	/**
	 * Return the value associated with the column: loan_out_qty
	 */
	public java.math.BigDecimal getLoanOutQty () {
		return loanOutQty;
	}

	/**
	 * Set the value related to the column: loan_out_qty
	 * @param loanOutQty the loan_out_qty value
	 */
	public void setLoanOutQty (java.math.BigDecimal loanOutQty) {
		this.loanOutQty = loanOutQty;
	}



	/**
	 * Return the value associated with the column: lot_no
	 */
	public java.lang.String getLotNo () {
		return lotNo;
	}

	/**
	 * Set the value related to the column: lot_no
	 * @param lotNo the lot_no value
	 */
	public void setLotNo (java.lang.String lotNo) {
		this.lotNo = lotNo;
	}



	/**
	 * Return the value associated with the column: blocked_qty
	 */
	public java.math.BigDecimal getBlockedQty () {
		return blockedQty;
	}

	/**
	 * Set the value related to the column: blocked_qty
	 * @param blockedQty the blocked_qty value
	 */
	public void setBlockedQty (java.math.BigDecimal blockedQty) {
		this.blockedQty = blockedQty;
	}



	/**
	 * Return the value associated with the column: dispencing_price
	 */
	public java.math.BigDecimal getDispencingPrice () {
		return dispencingPrice;
	}

	/**
	 * Set the value related to the column: dispencing_price
	 * @param dispencingPrice the dispencing_price value
	 */
	public void setDispencingPrice (java.math.BigDecimal dispencingPrice) {
		this.dispencingPrice = dispencingPrice;
	}



	/**
	 * Return the value associated with the column: barcode_no
	 */
	public java.lang.String getBarcodeNo () {
		return barcodeNo;
	}

	/**
	 * Set the value related to the column: barcode_no
	 * @param barcodeNo the barcode_no value
	 */
	public void setBarcodeNo (java.lang.String barcodeNo) {
		this.barcodeNo = barcodeNo;
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
	 * Return the value associated with the column: manufacture_date
	 */
	public java.util.Date getManufactureDate () {
		return manufactureDate;
	}

	/**
	 * Set the value related to the column: manufacture_date
	 * @param manufactureDate the manufacture_date value
	 */
	public void setManufactureDate (java.util.Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}



	/**
	 * Return the value associated with the column: block_date
	 */
	public java.util.Date getBlockDate () {
		return blockDate;
	}

	/**
	 * Set the value related to the column: block_date
	 * @param blockDate the block_date value
	 */
	public void setBlockDate (java.util.Date blockDate) {
		this.blockDate = blockDate;
	}



	/**
	 * Return the value associated with the column: block_status
	 */
	public java.lang.String getBlockStatus () {
		return blockStatus;
	}

	/**
	 * Set the value related to the column: block_status
	 * @param blockStatus the block_status value
	 */
	public void setBlockStatus (java.lang.String blockStatus) {
		this.blockStatus = blockStatus;
	}



	/**
	 * Return the value associated with the column: block_reason
	 */
	public java.lang.String getBlockReason () {
		return blockReason;
	}

	/**
	 * Set the value related to the column: block_reason
	 * @param blockReason the block_reason value
	 */
	public void setBlockReason (java.lang.String blockReason) {
		this.blockReason = blockReason;
	}



	/**
	 * Return the value associated with the column: reserved_qty
	 */
	public java.math.BigDecimal getReservedQty () {
		return reservedQty;
	}

	/**
	 * Set the value related to the column: reserved_qty
	 * @param reservedQty the reserved_qty value
	 */
	public void setReservedQty (java.math.BigDecimal reservedQty) {
		this.reservedQty = reservedQty;
	}



	/**
	 * Return the value associated with the column: block_order_no
	 */
	public java.lang.String getBlockOrderNo () {
		return blockOrderNo;
	}

	/**
	 * Set the value related to the column: block_order_no
	 * @param blockOrderNo the block_order_no value
	 */
	public void setBlockOrderNo (java.lang.String blockOrderNo) {
		this.blockOrderNo = blockOrderNo;
	}



	/**
	 * Return the value associated with the column: block_order_date
	 */
	public java.util.Date getBlockOrderDate () {
		return blockOrderDate;
	}

	/**
	 * Set the value related to the column: block_order_date
	 * @param blockOrderDate the block_order_date value
	 */
	public void setBlockOrderDate (java.util.Date blockOrderDate) {
		this.blockOrderDate = blockOrderDate;
	}



	/**
	 * Return the value associated with the column: unblock_order_no
	 */
	public java.lang.String getUnblockOrderNo () {
		return unblockOrderNo;
	}

	/**
	 * Set the value related to the column: unblock_order_no
	 * @param unblockOrderNo the unblock_order_no value
	 */
	public void setUnblockOrderNo (java.lang.String unblockOrderNo) {
		this.unblockOrderNo = unblockOrderNo;
	}



	/**
	 * Return the value associated with the column: unblock_order_date
	 */
	public java.util.Date getUnblockOrderDate () {
		return unblockOrderDate;
	}

	/**
	 * Set the value related to the column: unblock_order_date
	 * @param unblockOrderDate the unblock_order_date value
	 */
	public void setUnblockOrderDate (java.util.Date unblockOrderDate) {
		this.unblockOrderDate = unblockOrderDate;
	}



	/**
	 * Return the value associated with the column: refrigerator_status
	 */
	public java.lang.String getRefrigeratorStatus () {
		return refrigeratorStatus;
	}

	/**
	 * Set the value related to the column: refrigerator_status
	 * @param refrigeratorStatus the refrigerator_status value
	 */
	public void setRefrigeratorStatus (java.lang.String refrigeratorStatus) {
		this.refrigeratorStatus = refrigeratorStatus;
	}



	/**
	 * Return the value associated with the column: equipment_detail_status
	 */
	public java.lang.String getEquipmentDetailStatus () {
		return equipmentDetailStatus;
	}

	/**
	 * Set the value related to the column: equipment_detail_status
	 * @param equipmentDetailStatus the equipment_detail_status value
	 */
	public void setEquipmentDetailStatus (java.lang.String equipmentDetailStatus) {
		this.equipmentDetailStatus = equipmentDetailStatus;
	}



	/**
	 * Return the value associated with the column: supplier_name
	 */
	public java.lang.String getSupplierName () {
		return supplierName;
	}

	/**
	 * Set the value related to the column: supplier_name
	 * @param supplierName the supplier_name value
	 */
	public void setSupplierName (java.lang.String supplierName) {
		this.supplierName = supplierName;
	}
	
	/**
	 * Return the value associated with the column: out_tw_no
	 */
	public java.lang.Long getOutTwNo () {
		return outTwNo;
	}

	/**
	 * Set the value related to the column: out_tw_no
	 * @param outTwNo the out_tw_no value
	 */
	public void setOutTwNo (java.lang.Long outTwNo) {
		this.outTwNo = outTwNo;
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
	 * Return the value associated with the column: brand_id
	 */
	public jkt.hms.masters.business.MasStoreBrand getBrand () {
		return brand;
	}

	/**
	 * Set the value related to the column: brand_id
	 * @param brand the brand_id value
	 */
	public void setBrand (jkt.hms.masters.business.MasStoreBrand brand) {
		this.brand = brand;
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
	 * Return the value associated with the column: manufacturer_id
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturer () {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer_id
	 * @param manufacturer the manufacturer_id value
	 */
	public void setManufacturer (jkt.hms.masters.business.MasManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}



	/**
	 * Return the value associated with the column: StoreGrnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnT> getStoreGrnTs () {
		return storeGrnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnTs
	 * @param storeGrnTs the StoreGrnTs value
	 */
	public void setStoreGrnTs (java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs) {
		this.storeGrnTs = storeGrnTs;
	}

	public void addToStoreGrnTs (jkt.hms.masters.business.StoreGrnT storeGrnT) {
		if (null == getStoreGrnTs()) setStoreGrnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnT>());
		getStoreGrnTs().add(storeGrnT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreItemBatchStock)) return false;
		else {
			jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock = (jkt.hms.masters.business.StoreItemBatchStock) obj;
			if (null == this.getId() || null == storeItemBatchStock.getId()) return false;
			else return (this.getId().equals(storeItemBatchStock.getId()));
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