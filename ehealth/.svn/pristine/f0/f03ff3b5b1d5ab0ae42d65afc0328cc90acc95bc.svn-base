package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_po_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_po_header"
 */

public abstract class BaseStorePoHeader  implements Serializable {

	public static String REF = "StorePoHeader";
	public static String PROP_VENDOR_DETAILS = "VendorDetails";
	public static String PROP_PAY_TERMS = "PayTerms";
	public static String PROP_PO_NUMBER = "PoNumber";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PO_GENRATED_THROUGH = "PoGenratedThrough";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SIGNING_AUTHORITY = "SigningAuthority";
	public static String PROP_GROUP = "Group";
	public static String PROP_PO_TIME = "PoTime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRN_MASTER = "GrnMaster";
	public static String PROP_TENDER = "Tender";
	public static String PROP_DELIVERY_TO = "DeliveryTo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PROPOSAL_ID = "ProposalId";
	public static String PROP_DELIVERY_DATE = "DeliveryDate";
	public static String PROP_FLAG = "Flag";
	public static String PROP_NET_AMOUNT = "NetAmount";
	public static String PROP_DELIVERY_ADDRESS = "DeliveryAddress";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PO_DATE = "PoDate";
	public static String PROP_QUOTATION_DATE = "QuotationDate";
	public static String PROP_DELIVERY_TERMS = "DeliveryTerms";
	public static String PROP_APPROVAL_AUTHORITY = "ApprovalAuthority";
	public static String PROP_STATUS = "Status";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_ID = "Id";
	public static String PROP_QUOTATION_NUMBER = "QuotationNumber";


	// constructors
	public BaseStorePoHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStorePoHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date poDate;
	private java.lang.String poTime;
	private java.lang.String quotationNumber;
	private java.util.Date deliveryDate;
	private java.math.BigDecimal netAmount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String payTerms;
	private java.util.Date quotationDate;
	private java.lang.String deliveryTerms;
	private java.lang.String poNumber;
	private java.lang.String approvalAuthority;
	private java.lang.String signingAuthority;
	private java.lang.String flag;
	private java.lang.Long proposalId;
	private java.lang.String poGenratedThrough;
	private java.lang.String deliveryAddress;

	// many to one
	private jkt.hms.masters.business.PrqQuotationVendorDetails vendorDetails;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StoreGrnM grnMaster;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MmMasRequestStatus status;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreGroup group;
	private jkt.hms.masters.business.StoreTenderM tender;
	private jkt.hms.masters.business.MasHospital deliveryTo;

	// collections
	private java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="po_id"
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
	 * Return the value associated with the column: po_date
	 */
	public java.util.Date getPoDate () {
		return poDate;
	}

	/**
	 * Set the value related to the column: po_date
	 * @param poDate the po_date value
	 */
	public void setPoDate (java.util.Date poDate) {
		this.poDate = poDate;
	}



	/**
	 * Return the value associated with the column: po_time
	 */
	public java.lang.String getPoTime () {
		return poTime;
	}

	/**
	 * Set the value related to the column: po_time
	 * @param poTime the po_time value
	 */
	public void setPoTime (java.lang.String poTime) {
		this.poTime = poTime;
	}



	/**
	 * Return the value associated with the column: quotation_number
	 */
	public java.lang.String getQuotationNumber () {
		return quotationNumber;
	}

	/**
	 * Set the value related to the column: quotation_number
	 * @param quotationNumber the quotation_number value
	 */
	public void setQuotationNumber (java.lang.String quotationNumber) {
		this.quotationNumber = quotationNumber;
	}



	/**
	 * Return the value associated with the column: delivery_date
	 */
	public java.util.Date getDeliveryDate () {
		return deliveryDate;
	}

	/**
	 * Set the value related to the column: delivery_date
	 * @param deliveryDate the delivery_date value
	 */
	public void setDeliveryDate (java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
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
	 * Return the value associated with the column: pay_terms
	 */
	public java.lang.String getPayTerms () {
		return payTerms;
	}

	/**
	 * Set the value related to the column: pay_terms
	 * @param payTerms the pay_terms value
	 */
	public void setPayTerms (java.lang.String payTerms) {
		this.payTerms = payTerms;
	}



	/**
	 * Return the value associated with the column: quotation_date
	 */
	public java.util.Date getQuotationDate () {
		return quotationDate;
	}

	/**
	 * Set the value related to the column: quotation_date
	 * @param quotationDate the quotation_date value
	 */
	public void setQuotationDate (java.util.Date quotationDate) {
		this.quotationDate = quotationDate;
	}



	/**
	 * Return the value associated with the column: delivery_terms
	 */
	public java.lang.String getDeliveryTerms () {
		return deliveryTerms;
	}

	/**
	 * Set the value related to the column: delivery_terms
	 * @param deliveryTerms the delivery_terms value
	 */
	public void setDeliveryTerms (java.lang.String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}



	/**
	 * Return the value associated with the column: po_number
	 */
	public java.lang.String getPoNumber () {
		return poNumber;
	}

	/**
	 * Set the value related to the column: po_number
	 * @param poNumber the po_number value
	 */
	public void setPoNumber (java.lang.String poNumber) {
		this.poNumber = poNumber;
	}



	/**
	 * Return the value associated with the column: approval_authority
	 */
	public java.lang.String getApprovalAuthority () {
		return approvalAuthority;
	}

	/**
	 * Set the value related to the column: approval_authority
	 * @param approvalAuthority the approval_authority value
	 */
	public void setApprovalAuthority (java.lang.String approvalAuthority) {
		this.approvalAuthority = approvalAuthority;
	}



	/**
	 * Return the value associated with the column: signing_authority
	 */
	public java.lang.String getSigningAuthority () {
		return signingAuthority;
	}

	/**
	 * Set the value related to the column: signing_authority
	 * @param signingAuthority the signing_authority value
	 */
	public void setSigningAuthority (java.lang.String signingAuthority) {
		this.signingAuthority = signingAuthority;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: proposal_id
	 */
	public java.lang.Long getProposalId () {
		return proposalId;
	}

	/**
	 * Set the value related to the column: proposal_id
	 * @param proposalId the proposal_id value
	 */
	public void setProposalId (java.lang.Long proposalId) {
		this.proposalId = proposalId;
	}



	/**
	 * Return the value associated with the column: po_genrated_through
	 */
	public java.lang.String getPoGenratedThrough () {
		return poGenratedThrough;
	}

	/**
	 * Set the value related to the column: po_genrated_through
	 * @param poGenratedThrough the po_genrated_through value
	 */
	public void setPoGenratedThrough (java.lang.String poGenratedThrough) {
		this.poGenratedThrough = poGenratedThrough;
	}



	/**
	 * Return the value associated with the column: delivery_address
	 */
	public java.lang.String getDeliveryAddress () {
		return deliveryAddress;
	}

	/**
	 * Set the value related to the column: delivery_address
	 * @param deliveryAddress the delivery_address value
	 */
	public void setDeliveryAddress (java.lang.String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
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
	 * Return the value associated with the column: grn_master_id
	 */
	public jkt.hms.masters.business.StoreGrnM getGrnMaster () {
		return grnMaster;
	}

	/**
	 * Set the value related to the column: grn_master_id
	 * @param grnMaster the grn_master_id value
	 */
	public void setGrnMaster (jkt.hms.masters.business.StoreGrnM grnMaster) {
		this.grnMaster = grnMaster;
	}



	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * @param supplier the supplier_id value
	 */
	public void setSupplier (jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public jkt.hms.masters.business.MmMasRequestStatus getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (jkt.hms.masters.business.MmMasRequestStatus status) {
		this.status = status;
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
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.MasStoreGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param group the group_id value
	 */
	public void setGroup (jkt.hms.masters.business.MasStoreGroup group) {
		this.group = group;
	}



	/**
	 * Return the value associated with the column: tender_id
	 */
	public jkt.hms.masters.business.StoreTenderM getTender () {
		return tender;
	}

	/**
	 * Set the value related to the column: tender_id
	 * @param tender the tender_id value
	 */
	public void setTender (jkt.hms.masters.business.StoreTenderM tender) {
		this.tender = tender;
	}



	/**
	 * Return the value associated with the column: delivery_to
	 */
	public jkt.hms.masters.business.MasHospital getDeliveryTo () {
		return deliveryTo;
	}

	/**
	 * Set the value related to the column: delivery_to
	 * @param deliveryTo the delivery_to value
	 */
	public void setDeliveryTo (jkt.hms.masters.business.MasHospital deliveryTo) {
		this.deliveryTo = deliveryTo;
	}



	/**
	 * Return the value associated with the column: StorePoDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoDetail> getStorePoDetails () {
		return storePoDetails;
	}

	/**
	 * Set the value related to the column: StorePoDetails
	 * @param storePoDetails the StorePoDetails value
	 */
	public void setStorePoDetails (java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails) {
		this.storePoDetails = storePoDetails;
	}

	public void addToStorePoDetails (jkt.hms.masters.business.StorePoDetail storePoDetail) {
		if (null == getStorePoDetails()) setStorePoDetails(new java.util.TreeSet<jkt.hms.masters.business.StorePoDetail>());
		getStorePoDetails().add(storePoDetail);
	}



	/**
	 * Return the value associated with the column: StoreGrnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnM> getStoreGrnMs () {
		return storeGrnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnMs
	 * @param storeGrnMs the StoreGrnMs value
	 */
	public void setStoreGrnMs (java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs) {
		this.storeGrnMs = storeGrnMs;
	}

	public void addToStoreGrnMs (jkt.hms.masters.business.StoreGrnM storeGrnM) {
		if (null == getStoreGrnMs()) setStoreGrnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnM>());
		getStoreGrnMs().add(storeGrnM);
	}



	/**
	 * Return the value associated with the column: StoreLoaninMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninM> getStoreLoaninMs () {
		return storeLoaninMs;
	}

	/**
	 * Set the value related to the column: StoreLoaninMs
	 * @param storeLoaninMs the StoreLoaninMs value
	 */
	public void setStoreLoaninMs (java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs) {
		this.storeLoaninMs = storeLoaninMs;
	}

	public void addToStoreLoaninMs (jkt.hms.masters.business.StoreLoaninM storeLoaninM) {
		if (null == getStoreLoaninMs()) setStoreLoaninMs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninM>());
		getStoreLoaninMs().add(storeLoaninM);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StorePoHeader)) return false;
		else {
			jkt.hms.masters.business.StorePoHeader storePoHeader = (jkt.hms.masters.business.StorePoHeader) obj;
			if (null == this.getId() || null == storePoHeader.getId()) return false;
			else return (this.getId().equals(storePoHeader.getId()));
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