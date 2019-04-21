package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_stock_taking_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_stock_taking_t"
 */

public abstract class BaseStoreStockTakingT  implements Serializable {

	public static String REF = "StoreStockTakingT";
	public static String PROP_BRAND = "Brand";
	public static String PROP_COMPUTED_STOCK = "ComputedStock";
	public static String PROP_STORE_STOCK_SERVICE = "StoreStockService";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_STOCK_SURPLUS = "StockSurplus";
	public static String PROP_ITEM_BATCH_STOCK = "ItemBatchStock";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_ITEM_AVAILABILITY_STATUS = "ItemAvailabilityStatus";
	public static String PROP_ITEM = "Item";
	public static String PROP_ASSET = "Asset";
	public static String PROP_STOCK_TAKING_M = "StockTakingM";
	public static String PROP_NON_AVAILABILITY_REASON = "NonAvailabilityReason";
	public static String PROP_ID = "Id";
	public static String PROP_STORE_STOCK_DEFECTIVE = "StoreStockDefective";
	public static String PROP_STOCK_DEFICIENT = "StockDeficient";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_COST_PRICE = "CostPrice";
	public static String PROP_ITEM_CONDITION = "ItemCondition";


	// constructors
	public BaseStoreStockTakingT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreStockTakingT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String batchNo;
	private java.util.Date expiryDate;
	private java.math.BigDecimal computedStock;
	private java.math.BigDecimal storeStockService;
	private java.math.BigDecimal storeStockDefective;
	private java.lang.String remarks;
	private java.math.BigDecimal stockSurplus;
	private java.math.BigDecimal stockDeficient;
	private java.math.BigDecimal costPrice;
	private java.lang.String itemAvailabilityStatus;
	private java.lang.String itemCondition;
	private java.lang.String nonAvailabilityReason;

	// many to one
	private jkt.hms.masters.business.StoreStockTakingM stockTakingM;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.PrqAssetDetails asset;
	private jkt.hms.masters.business.StoreItemBatchStock itemBatchStock;



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
	 * Return the value associated with the column: computed_stock
	 */
	public java.math.BigDecimal getComputedStock () {
		return computedStock;
	}

	/**
	 * Set the value related to the column: computed_stock
	 * @param computedStock the computed_stock value
	 */
	public void setComputedStock (java.math.BigDecimal computedStock) {
		this.computedStock = computedStock;
	}



	/**
	 * Return the value associated with the column: store_stock_service
	 */
	public java.math.BigDecimal getStoreStockService () {
		return storeStockService;
	}

	/**
	 * Set the value related to the column: store_stock_service
	 * @param storeStockService the store_stock_service value
	 */
	public void setStoreStockService (java.math.BigDecimal storeStockService) {
		this.storeStockService = storeStockService;
	}



	/**
	 * Return the value associated with the column: store_stock_defective
	 */
	public java.math.BigDecimal getStoreStockDefective () {
		return storeStockDefective;
	}

	/**
	 * Set the value related to the column: store_stock_defective
	 * @param storeStockDefective the store_stock_defective value
	 */
	public void setStoreStockDefective (java.math.BigDecimal storeStockDefective) {
		this.storeStockDefective = storeStockDefective;
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
	 * Return the value associated with the column: stock_surplus
	 */
	public java.math.BigDecimal getStockSurplus () {
		return stockSurplus;
	}

	/**
	 * Set the value related to the column: stock_surplus
	 * @param stockSurplus the stock_surplus value
	 */
	public void setStockSurplus (java.math.BigDecimal stockSurplus) {
		this.stockSurplus = stockSurplus;
	}



	/**
	 * Return the value associated with the column: stock_deficient
	 */
	public java.math.BigDecimal getStockDeficient () {
		return stockDeficient;
	}

	/**
	 * Set the value related to the column: stock_deficient
	 * @param stockDeficient the stock_deficient value
	 */
	public void setStockDeficient (java.math.BigDecimal stockDeficient) {
		this.stockDeficient = stockDeficient;
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
	 * Return the value associated with the column: item_availability_status
	 */
	public java.lang.String getItemAvailabilityStatus () {
		return itemAvailabilityStatus;
	}

	/**
	 * Set the value related to the column: item_availability_status
	 * @param itemAvailabilityStatus the item_availability_status value
	 */
	public void setItemAvailabilityStatus (java.lang.String itemAvailabilityStatus) {
		this.itemAvailabilityStatus = itemAvailabilityStatus;
	}



	/**
	 * Return the value associated with the column: item_condition
	 */
	public java.lang.String getItemCondition () {
		return itemCondition;
	}

	/**
	 * Set the value related to the column: item_condition
	 * @param itemCondition the item_condition value
	 */
	public void setItemCondition (java.lang.String itemCondition) {
		this.itemCondition = itemCondition;
	}



	/**
	 * Return the value associated with the column: non_availability_reason
	 */
	public java.lang.String getNonAvailabilityReason () {
		return nonAvailabilityReason;
	}

	/**
	 * Set the value related to the column: non_availability_reason
	 * @param nonAvailabilityReason the non_availability_reason value
	 */
	public void setNonAvailabilityReason (java.lang.String nonAvailabilityReason) {
		this.nonAvailabilityReason = nonAvailabilityReason;
	}



	/**
	 * Return the value associated with the column: stock_taking_m_id
	 */
	public jkt.hms.masters.business.StoreStockTakingM getStockTakingM () {
		return stockTakingM;
	}

	/**
	 * Set the value related to the column: stock_taking_m_id
	 * @param stockTakingM the stock_taking_m_id value
	 */
	public void setStockTakingM (jkt.hms.masters.business.StoreStockTakingM stockTakingM) {
		this.stockTakingM = stockTakingM;
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
	 * Return the value associated with the column: asset_id
	 */
	public jkt.hms.masters.business.PrqAssetDetails getAsset () {
		return asset;
	}

	/**
	 * Set the value related to the column: asset_id
	 * @param asset the asset_id value
	 */
	public void setAsset (jkt.hms.masters.business.PrqAssetDetails asset) {
		this.asset = asset;
	}



	/**
	 * Return the value associated with the column: store_item_batch_stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getItemBatchStock () {
		return itemBatchStock;
	}

	/**
	 * Set the value related to the column: store_item_batch_stock_id
	 * @param itemBatchStock the store_item_batch_stock_id value
	 */
	public void setItemBatchStock (jkt.hms.masters.business.StoreItemBatchStock itemBatchStock) {
		this.itemBatchStock = itemBatchStock;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreStockTakingT)) return false;
		else {
			jkt.hms.masters.business.StoreStockTakingT storeStockTakingT = (jkt.hms.masters.business.StoreStockTakingT) obj;
			if (null == this.getId() || null == storeStockTakingT.getId()) return false;
			else return (this.getId().equals(storeStockTakingT.getId()));
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