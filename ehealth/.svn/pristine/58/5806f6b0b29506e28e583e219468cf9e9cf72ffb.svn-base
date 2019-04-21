package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prq_quotation_item_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prq_quotation_item_details"
 */

public abstract class BasePrqQuotationItemDetails  implements Serializable {

	public static String REF = "PrqQuotationItemDetails";
	public static String PROP_VENDOR_DETAILS = "VendorDetails";
	public static String PROP_MANUFACTURED_BY = "ManufacturedBy";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_L_CATEGORY = "LCategory";
	public static String PROP_TECH_SPECS = "TechSpecs";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_NEW_VAT = "NewVat";
	public static String PROP_REQ_QTY = "ReqQty";
	public static String PROP_NEW_TOTAL_AMOUNT = "NewTotalAmount";
	public static String PROP_ITEM = "Item";
	public static String PROP_NEW_AMOUNT = "NewAmount";
	public static String PROP_NEW_NET_AMOUNT = "NewNetAmount";
	public static String PROP_NEW_DISCOUNT_ON_RATE = "NewDiscountOnRate";
	public static String PROP_RATE = "Rate";
	public static String PROP_APPROVED_QTY = "ApprovedQty";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_NEW_TAX = "NewTax";
	public static String PROP_VENDOR_FLAG = "VendorFlag";
	public static String PROP_NET_AMOUNT = "NetAmount";
	public static String PROP_TAX = "Tax";
	public static String PROP_NEW_EXCISE_DUTY_TYPE = "NewExciseDutyType";
	public static String PROP_NEW_EXCISE_DUTY = "NewExciseDuty";
	public static String PROP_NEW_ITEM_RATE = "NewItemRate";
	public static String PROP_VAT = "Vat";
	public static String PROP_ITEM_STATUS = "ItemStatus";
	public static String PROP_EXCISE_DUTY_TYPE = "ExciseDutyType";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_AMOUNT = "TotalAmount";
	public static String PROP_NEW_QTY = "NewQty";
	public static String PROP_EXCISE_DUTY_AMOUNT = "ExciseDutyAmount";


	// constructors
	public BasePrqQuotationItemDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrqQuotationItemDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePrqQuotationItemDetails (
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
	private java.math.BigDecimal rate;
	private java.math.BigDecimal quantity;
	private java.math.BigDecimal reqQty;
	private java.math.BigDecimal approvedQty;
	private java.math.BigDecimal amount;
	private java.math.BigDecimal discountPercent;
	private java.math.BigDecimal netAmount;
	private java.lang.String exciseDutyType;
	private java.math.BigDecimal exciseDutyAmount;
	private java.math.BigDecimal tax;
	private java.math.BigDecimal vat;
	private java.math.BigDecimal totalAmount;
	private java.lang.String remarks;
	private java.lang.String techSpecs;
	private java.math.BigDecimal newItemRate;
	private java.math.BigDecimal newQty;
	private java.math.BigDecimal newAmount;
	private java.math.BigDecimal newDiscountOnRate;
	private java.math.BigDecimal newNetAmount;
	private java.lang.String vendorFlag;
	private java.math.BigDecimal newExciseDuty;
	private java.math.BigDecimal newVat;
	private java.math.BigDecimal newTax;
	private java.math.BigDecimal newTotalAmount;
	private java.lang.String newExciseDutyType;
	private java.lang.Integer lCategory;

	// many to one
	private jkt.hms.masters.business.PrqQuotationVendorDetails vendorDetails;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MmMasRequestStatus itemStatus;
	private jkt.hms.masters.business.MasManufacturer manufacturedBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="item_details_id"
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
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param rate the rate value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.math.BigDecimal getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: req_qty
	 */
	public java.math.BigDecimal getReqQty () {
		return reqQty;
	}

	/**
	 * Set the value related to the column: req_qty
	 * @param reqQty the req_qty value
	 */
	public void setReqQty (java.math.BigDecimal reqQty) {
		this.reqQty = reqQty;
	}



	/**
	 * Return the value associated with the column: approved_qty
	 */
	public java.math.BigDecimal getApprovedQty () {
		return approvedQty;
	}

	/**
	 * Set the value related to the column: approved_qty
	 * @param approvedQty the approved_qty value
	 */
	public void setApprovedQty (java.math.BigDecimal approvedQty) {
		this.approvedQty = approvedQty;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: discount_percent
	 */
	public java.math.BigDecimal getDiscountPercent () {
		return discountPercent;
	}

	/**
	 * Set the value related to the column: discount_percent
	 * @param discountPercent the discount_percent value
	 */
	public void setDiscountPercent (java.math.BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}



	/**
	 * Return the value associated with the column: net_amount
	 */
	public java.math.BigDecimal getNetAmount () {
		return netAmount;
	}

	/**
	 * Set the value related to the column: net_amount
	 * @param netAmount the net_amount value
	 */
	public void setNetAmount (java.math.BigDecimal netAmount) {
		this.netAmount = netAmount;
	}



	/**
	 * Return the value associated with the column: excise_duty_type
	 */
	public java.lang.String getExciseDutyType () {
		return exciseDutyType;
	}

	/**
	 * Set the value related to the column: excise_duty_type
	 * @param exciseDutyType the excise_duty_type value
	 */
	public void setExciseDutyType (java.lang.String exciseDutyType) {
		this.exciseDutyType = exciseDutyType;
	}



	/**
	 * Return the value associated with the column: excise_duty_amount
	 */
	public java.math.BigDecimal getExciseDutyAmount () {
		return exciseDutyAmount;
	}

	/**
	 * Set the value related to the column: excise_duty_amount
	 * @param exciseDutyAmount the excise_duty_amount value
	 */
	public void setExciseDutyAmount (java.math.BigDecimal exciseDutyAmount) {
		this.exciseDutyAmount = exciseDutyAmount;
	}



	/**
	 * Return the value associated with the column: tax
	 */
	public java.math.BigDecimal getTax () {
		return tax;
	}

	/**
	 * Set the value related to the column: tax
	 * @param tax the tax value
	 */
	public void setTax (java.math.BigDecimal tax) {
		this.tax = tax;
	}



	/**
	 * Return the value associated with the column: vat
	 */
	public java.math.BigDecimal getVat () {
		return vat;
	}

	/**
	 * Set the value related to the column: vat
	 * @param vat the vat value
	 */
	public void setVat (java.math.BigDecimal vat) {
		this.vat = vat;
	}



	/**
	 * Return the value associated with the column: total_amount
	 */
	public java.math.BigDecimal getTotalAmount () {
		return totalAmount;
	}

	/**
	 * Set the value related to the column: total_amount
	 * @param totalAmount the total_amount value
	 */
	public void setTotalAmount (java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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
	 * Return the value associated with the column: tech_specs
	 */
	public java.lang.String getTechSpecs () {
		return techSpecs;
	}

	/**
	 * Set the value related to the column: tech_specs
	 * @param techSpecs the tech_specs value
	 */
	public void setTechSpecs (java.lang.String techSpecs) {
		this.techSpecs = techSpecs;
	}



	/**
	 * Return the value associated with the column: new_item_rate
	 */
	public java.math.BigDecimal getNewItemRate () {
		return newItemRate;
	}

	/**
	 * Set the value related to the column: new_item_rate
	 * @param newItemRate the new_item_rate value
	 */
	public void setNewItemRate (java.math.BigDecimal newItemRate) {
		this.newItemRate = newItemRate;
	}



	/**
	 * Return the value associated with the column: new_qty
	 */
	public java.math.BigDecimal getNewQty () {
		return newQty;
	}

	/**
	 * Set the value related to the column: new_qty
	 * @param newQty the new_qty value
	 */
	public void setNewQty (java.math.BigDecimal newQty) {
		this.newQty = newQty;
	}



	/**
	 * Return the value associated with the column: new_amount
	 */
	public java.math.BigDecimal getNewAmount () {
		return newAmount;
	}

	/**
	 * Set the value related to the column: new_amount
	 * @param newAmount the new_amount value
	 */
	public void setNewAmount (java.math.BigDecimal newAmount) {
		this.newAmount = newAmount;
	}



	/**
	 * Return the value associated with the column: new_discount_on_rate
	 */
	public java.math.BigDecimal getNewDiscountOnRate () {
		return newDiscountOnRate;
	}

	/**
	 * Set the value related to the column: new_discount_on_rate
	 * @param newDiscountOnRate the new_discount_on_rate value
	 */
	public void setNewDiscountOnRate (java.math.BigDecimal newDiscountOnRate) {
		this.newDiscountOnRate = newDiscountOnRate;
	}



	/**
	 * Return the value associated with the column: new_net_amount
	 */
	public java.math.BigDecimal getNewNetAmount () {
		return newNetAmount;
	}

	/**
	 * Set the value related to the column: new_net_amount
	 * @param newNetAmount the new_net_amount value
	 */
	public void setNewNetAmount (java.math.BigDecimal newNetAmount) {
		this.newNetAmount = newNetAmount;
	}



	/**
	 * Return the value associated with the column: vendor_flag
	 */
	public java.lang.String getVendorFlag () {
		return vendorFlag;
	}

	/**
	 * Set the value related to the column: vendor_flag
	 * @param vendorFlag the vendor_flag value
	 */
	public void setVendorFlag (java.lang.String vendorFlag) {
		this.vendorFlag = vendorFlag;
	}



	/**
	 * Return the value associated with the column: new_excise_duty
	 */
	public java.math.BigDecimal getNewExciseDuty () {
		return newExciseDuty;
	}

	/**
	 * Set the value related to the column: new_excise_duty
	 * @param newExciseDuty the new_excise_duty value
	 */
	public void setNewExciseDuty (java.math.BigDecimal newExciseDuty) {
		this.newExciseDuty = newExciseDuty;
	}



	/**
	 * Return the value associated with the column: new_vat
	 */
	public java.math.BigDecimal getNewVat () {
		return newVat;
	}

	/**
	 * Set the value related to the column: new_vat
	 * @param newVat the new_vat value
	 */
	public void setNewVat (java.math.BigDecimal newVat) {
		this.newVat = newVat;
	}



	/**
	 * Return the value associated with the column: new_tax
	 */
	public java.math.BigDecimal getNewTax () {
		return newTax;
	}

	/**
	 * Set the value related to the column: new_tax
	 * @param newTax the new_tax value
	 */
	public void setNewTax (java.math.BigDecimal newTax) {
		this.newTax = newTax;
	}



	/**
	 * Return the value associated with the column: new_total_amount
	 */
	public java.math.BigDecimal getNewTotalAmount () {
		return newTotalAmount;
	}

	/**
	 * Set the value related to the column: new_total_amount
	 * @param newTotalAmount the new_total_amount value
	 */
	public void setNewTotalAmount (java.math.BigDecimal newTotalAmount) {
		this.newTotalAmount = newTotalAmount;
	}



	/**
	 * Return the value associated with the column: new_excise_duty_type
	 */
	public java.lang.String getNewExciseDutyType () {
		return newExciseDutyType;
	}

	/**
	 * Set the value related to the column: new_excise_duty_type
	 * @param newExciseDutyType the new_excise_duty_type value
	 */
	public void setNewExciseDutyType (java.lang.String newExciseDutyType) {
		this.newExciseDutyType = newExciseDutyType;
	}



	/**
	 * Return the value associated with the column: l_category
	 */
	public java.lang.Integer getLCategory () {
		return lCategory;
	}

	/**
	 * Set the value related to the column: l_category
	 * @param lCategory the l_category value
	 */
	public void setLCategory (java.lang.Integer lCategory) {
		this.lCategory = lCategory;
	}



	/**
	 * Return the value associated with the column: vendor_details_id
	 */
	public jkt.hms.masters.business.PrqQuotationVendorDetails getVendorDetails () {
		return vendorDetails;
	}

	/**
	 * Set the value related to the column: vendor_details_id
	 * @param vendorDetails the vendor_details_id value
	 */
	public void setVendorDetails (jkt.hms.masters.business.PrqQuotationVendorDetails vendorDetails) {
		this.vendorDetails = vendorDetails;
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
	 * Return the value associated with the column: item_status
	 */
	public jkt.hms.masters.business.MmMasRequestStatus getItemStatus () {
		return itemStatus;
	}

	/**
	 * Set the value related to the column: item_status
	 * @param itemStatus the item_status value
	 */
	public void setItemStatus (jkt.hms.masters.business.MmMasRequestStatus itemStatus) {
		this.itemStatus = itemStatus;
	}



	/**
	 * Return the value associated with the column: manufactured_by
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturedBy () {
		return manufacturedBy;
	}

	/**
	 * Set the value related to the column: manufactured_by
	 * @param manufacturedBy the manufactured_by value
	 */
	public void setManufacturedBy (jkt.hms.masters.business.MasManufacturer manufacturedBy) {
		this.manufacturedBy = manufacturedBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PrqQuotationItemDetails)) return false;
		else {
			jkt.hms.masters.business.PrqQuotationItemDetails prqQuotationItemDetails = (jkt.hms.masters.business.PrqQuotationItemDetails) obj;
			if (null == this.getId() || null == prqQuotationItemDetails.getId()) return false;
			else return (this.getId().equals(prqQuotationItemDetails.getId()));
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