package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prq_quotation_vendor_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prq_quotation_vendor_details"
 */

public abstract class BasePrqQuotationVendorDetails  implements Serializable {

	public static String REF = "PrqQuotationVendorDetails";
	public static String PROP_CONSOLIDATED_TOTAL_AMOUNT = "ConsolidatedTotalAmount";
	public static String PROP_CONSOLIDATED_DISCOUNT_PERCENT = "ConsolidatedDiscountPercent";
	public static String PROP_REJECTED_BY = "RejectedBy";
	public static String PROP_VENDOR = "Vendor";
	public static String PROP_HEADER = "Header";
	public static String PROP_REJECT_REASON = "RejectReason";
	public static String PROP_VENDOR_FLAG = "VendorFlag";
	public static String PROP_CONSOLIDATED_DISCOUNT_AMOUNT = "ConsolidatedDiscountAmount";
	public static String PROP_ID = "Id";
	public static String PROP_REJECTED_DATE = "RejectedDate";
	public static String PROP_VENDOR_REMARKS = "VendorRemarks";
	public static String PROP_TOTAL_CONSOLIDATED_AMOUNT = "TotalConsolidatedAmount";


	// constructors
	public BasePrqQuotationVendorDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrqQuotationVendorDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vendorFlag;
	private java.lang.String vendorRemarks;
	private java.lang.String rejectReason;
	private java.math.BigDecimal consolidatedDiscountPercent;
	private java.math.BigDecimal consolidatedDiscountAmount;
	private java.math.BigDecimal totalConsolidatedAmount;
	private java.util.Date rejectedDate;
	private java.math.BigDecimal consolidatedTotalAmount;

	// many to one
	private jkt.hms.masters.business.PrqQuotationHeader header;
	private jkt.hms.masters.business.Users rejectedBy;
	private jkt.hms.masters.business.MasStoreSupplier vendor;

	// collections
	private java.util.Set<jkt.hms.masters.business.PrqQuotationItemDetails> prqQuotationItemDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="vendor_details_id"
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
	 * Return the value associated with the column: vendor_remarks
	 */
	public java.lang.String getVendorRemarks () {
		return vendorRemarks;
	}

	/**
	 * Set the value related to the column: vendor_remarks
	 * @param vendorRemarks the vendor_remarks value
	 */
	public void setVendorRemarks (java.lang.String vendorRemarks) {
		this.vendorRemarks = vendorRemarks;
	}



	/**
	 * Return the value associated with the column: reject_reason
	 */
	public java.lang.String getRejectReason () {
		return rejectReason;
	}

	/**
	 * Set the value related to the column: reject_reason
	 * @param rejectReason the reject_reason value
	 */
	public void setRejectReason (java.lang.String rejectReason) {
		this.rejectReason = rejectReason;
	}



	/**
	 * Return the value associated with the column: consolidated_discount_percent
	 */
	public java.math.BigDecimal getConsolidatedDiscountPercent () {
		return consolidatedDiscountPercent;
	}

	/**
	 * Set the value related to the column: consolidated_discount_percent
	 * @param consolidatedDiscountPercent the consolidated_discount_percent value
	 */
	public void setConsolidatedDiscountPercent (java.math.BigDecimal consolidatedDiscountPercent) {
		this.consolidatedDiscountPercent = consolidatedDiscountPercent;
	}



	/**
	 * Return the value associated with the column: consolidated_discount_amount
	 */
	public java.math.BigDecimal getConsolidatedDiscountAmount () {
		return consolidatedDiscountAmount;
	}

	/**
	 * Set the value related to the column: consolidated_discount_amount
	 * @param consolidatedDiscountAmount the consolidated_discount_amount value
	 */
	public void setConsolidatedDiscountAmount (java.math.BigDecimal consolidatedDiscountAmount) {
		this.consolidatedDiscountAmount = consolidatedDiscountAmount;
	}



	/**
	 * Return the value associated with the column: total_consolidated_amount
	 */
	public java.math.BigDecimal getTotalConsolidatedAmount () {
		return totalConsolidatedAmount;
	}

	/**
	 * Set the value related to the column: total_consolidated_amount
	 * @param totalConsolidatedAmount the total_consolidated_amount value
	 */
	public void setTotalConsolidatedAmount (java.math.BigDecimal totalConsolidatedAmount) {
		this.totalConsolidatedAmount = totalConsolidatedAmount;
	}



	/**
	 * Return the value associated with the column: rejected_date
	 */
	public java.util.Date getRejectedDate () {
		return rejectedDate;
	}

	/**
	 * Set the value related to the column: rejected_date
	 * @param rejectedDate the rejected_date value
	 */
	public void setRejectedDate (java.util.Date rejectedDate) {
		this.rejectedDate = rejectedDate;
	}



	/**
	 * Return the value associated with the column: consolidated_total_amount
	 */
	public java.math.BigDecimal getConsolidatedTotalAmount () {
		return consolidatedTotalAmount;
	}

	/**
	 * Set the value related to the column: consolidated_total_amount
	 * @param consolidatedTotalAmount the consolidated_total_amount value
	 */
	public void setConsolidatedTotalAmount (java.math.BigDecimal consolidatedTotalAmount) {
		this.consolidatedTotalAmount = consolidatedTotalAmount;
	}



	/**
	 * Return the value associated with the column: header_id
	 */
	public jkt.hms.masters.business.PrqQuotationHeader getHeader () {
		return header;
	}

	/**
	 * Set the value related to the column: header_id
	 * @param header the header_id value
	 */
	public void setHeader (jkt.hms.masters.business.PrqQuotationHeader header) {
		this.header = header;
	}



	/**
	 * Return the value associated with the column: rejected_by
	 */
	public jkt.hms.masters.business.Users getRejectedBy () {
		return rejectedBy;
	}

	/**
	 * Set the value related to the column: rejected_by
	 * @param rejectedBy the rejected_by value
	 */
	public void setRejectedBy (jkt.hms.masters.business.Users rejectedBy) {
		this.rejectedBy = rejectedBy;
	}



	/**
	 * Return the value associated with the column: vendor_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getVendor () {
		return vendor;
	}

	/**
	 * Set the value related to the column: vendor_id
	 * @param vendor the vendor_id value
	 */
	public void setVendor (jkt.hms.masters.business.MasStoreSupplier vendor) {
		this.vendor = vendor;
	}



	/**
	 * Return the value associated with the column: PrqQuotationItemDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PrqQuotationItemDetails> getPrqQuotationItemDetails () {
		return prqQuotationItemDetails;
	}

	/**
	 * Set the value related to the column: PrqQuotationItemDetails
	 * @param prqQuotationItemDetails the PrqQuotationItemDetails value
	 */
	public void setPrqQuotationItemDetails (java.util.Set<jkt.hms.masters.business.PrqQuotationItemDetails> prqQuotationItemDetails) {
		this.prqQuotationItemDetails = prqQuotationItemDetails;
	}

	public void addToPrqQuotationItemDetails (jkt.hms.masters.business.PrqQuotationItemDetails prqQuotationItemDetails) {
		if (null == getPrqQuotationItemDetails()) setPrqQuotationItemDetails(new java.util.TreeSet<jkt.hms.masters.business.PrqQuotationItemDetails>());
		getPrqQuotationItemDetails().add(prqQuotationItemDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PrqQuotationVendorDetails)) return false;
		else {
			jkt.hms.masters.business.PrqQuotationVendorDetails prqQuotationVendorDetails = (jkt.hms.masters.business.PrqQuotationVendorDetails) obj;
			if (null == this.getId() || null == prqQuotationVendorDetails.getId()) return false;
			else return (this.getId().equals(prqQuotationVendorDetails.getId()));
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