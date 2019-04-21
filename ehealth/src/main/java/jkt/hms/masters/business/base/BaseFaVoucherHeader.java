package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_voucher_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_voucher_header"
 */

public abstract class BaseFaVoucherHeader  implements Serializable {

	public static String REF = "FaVoucherHeader";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_BILL_SERVICING_ID = "BillServicingId";
	public static String PROP_PO_AMOUNT = "PoAmount";
	public static String PROP_INVOICE_DATE = "InvoiceDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CHEQUE_NO = "ChequeNo";
	public static String PROP_VOUCHER_NO = "VoucherNo";
	public static String PROP_NARRATION = "Narration";
	public static String PROP_BANK_NAME = "BankName";
	public static String PROP_CR_AMOUNT = "CrAmount";
	public static String PROP_RECIEPT_ID = "RecieptId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ACCOUNT_SUB_GROUP = "AccountSubGroup";
	public static String PROP_VOUCHER_TIME = "VoucherTime";
	public static String PROP_PO_NO = "PoNo";
	public static String PROP_INVOICE_NO = "InvoiceNo";
	public static String PROP_VOUCHER_TYPE = "VoucherType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SCHEME = "Scheme";
	public static String PROP_DR_AMOUNT = "DrAmount";
	public static String PROP_VOUCHER_DATE = "VoucherDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PO_DATE = "PoDate";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_BRANCH_ID = "BranchId";
	public static String PROP_STATUS = "Status";
	public static String PROP_INVOICE_AMOUNT = "InvoiceAmount";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_COST_CENTER = "CostCenter";
	public static String PROP_ID = "Id";
	public static String PROP_BILL_DISPENSING_ID = "BillDispensingId";


	// constructors
	public BaseFaVoucherHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaVoucherHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String voucherNo;
	private java.util.Date voucherDate;
	private java.lang.String voucherTime;
	private java.lang.String voucherType;
	private java.math.BigDecimal drAmount;
	private java.math.BigDecimal crAmount;
	private java.lang.String narration;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer billServicingId;
	private java.lang.Integer billDispensingId;
	private java.lang.Integer recieptId;
	private java.lang.Integer branchId;
	private java.lang.String bankName;
	private java.lang.String chequeNo;
	private java.util.Date issueDate;
	private java.lang.String poNo;
	private java.util.Date poDate;
	private java.math.BigDecimal poAmount;
	private java.lang.String invoiceNo;
	private java.util.Date invoiceDate;
	private java.math.BigDecimal invoiceAmount;
	private java.lang.String authLevelOne;
	private java.lang.String authLevelTwo;
	private java.lang.String authLevelThree;
	private java.lang.String authLevelFour;
	private java.lang.String rejected;
	private java.lang.String remarksForRejection;
	
	public java.lang.String getRemarksForRejection() {
		return remarksForRejection;
	}

	public void setRemarksForRejection(java.lang.String remarksForRejection) {
		this.remarksForRejection = remarksForRejection;
	}

	public java.lang.String getRejected() {
		return rejected;
	}

	public void setRejected(java.lang.String rejected) {
		this.rejected = rejected;
	}

	public java.lang.String getAuthLevelOne() {
		return authLevelOne;
	}

	public void setAuthLevelOne(java.lang.String authLevelOne) {
		this.authLevelOne = authLevelOne;
	}

	public java.lang.String getAuthLevelTwo() {
		return authLevelTwo;
	}

	public void setAuthLevelTwo(java.lang.String authLevelTwo) {
		this.authLevelTwo = authLevelTwo;
	}

	public java.lang.String getAuthLevelThree() {
		return authLevelThree;
	}

	public void setAuthLevelThree(java.lang.String authLevelThree) {
		this.authLevelThree = authLevelThree;
	}

	public java.lang.String getAuthLevelFour() {
		return authLevelFour;
	}

	public void setAuthLevelFour(java.lang.String authLevelFour) {
		this.authLevelFour = authLevelFour;
	}



	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasCostCenter costCenter;
	private jkt.hms.masters.business.MasStoreFinancial fYear;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.FaMasAccountSubGroup accountSubGroup;
	private jkt.hms.masters.business.MasScheme scheme;
	private jkt.hms.masters.business.MasWard ward;

	public jkt.hms.masters.business.MasWard getWard() {
		return ward;
	}

	public void setWard(jkt.hms.masters.business.MasWard ward) {
		this.ward = ward;
	}



	// collections
	private java.util.Set<jkt.hms.masters.business.FaVoucherDetails> faVoucherDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="voucher_header_id"
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
	 * Return the value associated with the column: voucher_no
	 */
	public java.lang.String getVoucherNo () {
		return voucherNo;
	}

	/**
	 * Set the value related to the column: voucher_no
	 * @param voucherNo the voucher_no value
	 */
	public void setVoucherNo (java.lang.String voucherNo) {
		this.voucherNo = voucherNo;
	}



	/**
	 * Return the value associated with the column: voucher_date
	 */
	public java.util.Date getVoucherDate () {
		return voucherDate;
	}

	/**
	 * Set the value related to the column: voucher_date
	 * @param voucherDate the voucher_date value
	 */
	public void setVoucherDate (java.util.Date voucherDate) {
		this.voucherDate = voucherDate;
	}



	/**
	 * Return the value associated with the column: voucher_time
	 */
	public java.lang.String getVoucherTime () {
		return voucherTime;
	}

	/**
	 * Set the value related to the column: voucher_time
	 * @param voucherTime the voucher_time value
	 */
	public void setVoucherTime (java.lang.String voucherTime) {
		this.voucherTime = voucherTime;
	}



	/**
	 * Return the value associated with the column: voucher_type
	 */
	public java.lang.String getVoucherType () {
		return voucherType;
	}

	/**
	 * Set the value related to the column: voucher_type
	 * @param voucherType the voucher_type value
	 */
	public void setVoucherType (java.lang.String voucherType) {
		this.voucherType = voucherType;
	}



	/**
	 * Return the value associated with the column: dr_amount
	 */
	public java.math.BigDecimal getDrAmount () {
		return drAmount;
	}

	/**
	 * Set the value related to the column: dr_amount
	 * @param drAmount the dr_amount value
	 */
	public void setDrAmount (java.math.BigDecimal drAmount) {
		this.drAmount = drAmount;
	}



	/**
	 * Return the value associated with the column: cr_amount
	 */
	public java.math.BigDecimal getCrAmount () {
		return crAmount;
	}

	/**
	 * Set the value related to the column: cr_amount
	 * @param crAmount the cr_amount value
	 */
	public void setCrAmount (java.math.BigDecimal crAmount) {
		this.crAmount = crAmount;
	}



	/**
	 * Return the value associated with the column: narration
	 */
	public java.lang.String getNarration () {
		return narration;
	}

	/**
	 * Set the value related to the column: narration
	 * @param narration the narration value
	 */
	public void setNarration (java.lang.String narration) {
		this.narration = narration;
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: bill_servicing_id
	 */
	public java.lang.Integer getBillServicingId () {
		return billServicingId;
	}

	/**
	 * Set the value related to the column: bill_servicing_id
	 * @param billServicingId the bill_servicing_id value
	 */
	public void setBillServicingId (java.lang.Integer billServicingId) {
		this.billServicingId = billServicingId;
	}



	/**
	 * Return the value associated with the column: bill_dispensing_id
	 */
	public java.lang.Integer getBillDispensingId () {
		return billDispensingId;
	}

	/**
	 * Set the value related to the column: bill_dispensing_id
	 * @param billDispensingId the bill_dispensing_id value
	 */
	public void setBillDispensingId (java.lang.Integer billDispensingId) {
		this.billDispensingId = billDispensingId;
	}



	/**
	 * Return the value associated with the column: reciept_id
	 */
	public java.lang.Integer getRecieptId () {
		return recieptId;
	}

	/**
	 * Set the value related to the column: reciept_id
	 * @param recieptId the reciept_id value
	 */
	public void setRecieptId (java.lang.Integer recieptId) {
		this.recieptId = recieptId;
	}



	/**
	 * Return the value associated with the column: branch_id
	 */
	public java.lang.Integer getBranchId () {
		return branchId;
	}

	/**
	 * Set the value related to the column: branch_id
	 * @param branchId the branch_id value
	 */
	public void setBranchId (java.lang.Integer branchId) {
		this.branchId = branchId;
	}



	/**
	 * Return the value associated with the column: bank_name
	 */
	public java.lang.String getBankName () {
		return bankName;
	}

	/**
	 * Set the value related to the column: bank_name
	 * @param bankName the bank_name value
	 */
	public void setBankName (java.lang.String bankName) {
		this.bankName = bankName;
	}



	/**
	 * Return the value associated with the column: cheque_no
	 */
	public java.lang.String getChequeNo () {
		return chequeNo;
	}

	/**
	 * Set the value related to the column: cheque_no
	 * @param chequeNo the cheque_no value
	 */
	public void setChequeNo (java.lang.String chequeNo) {
		this.chequeNo = chequeNo;
	}



	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
	}



	/**
	 * Return the value associated with the column: po_no
	 */
	public java.lang.String getPoNo () {
		return poNo;
	}

	/**
	 * Set the value related to the column: po_no
	 * @param poNo the po_no value
	 */
	public void setPoNo (java.lang.String poNo) {
		this.poNo = poNo;
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
	 * Return the value associated with the column: po_amount
	 */
	public java.math.BigDecimal getPoAmount () {
		return poAmount;
	}

	/**
	 * Set the value related to the column: po_amount
	 * @param poAmount the po_amount value
	 */
	public void setPoAmount (java.math.BigDecimal poAmount) {
		this.poAmount = poAmount;
	}



	/**
	 * Return the value associated with the column: invoice_no
	 */
	public java.lang.String getInvoiceNo () {
		return invoiceNo;
	}

	/**
	 * Set the value related to the column: invoice_no
	 * @param invoiceNo the invoice_no value
	 */
	public void setInvoiceNo (java.lang.String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}



	/**
	 * Return the value associated with the column: invoice_date
	 */
	public java.util.Date getInvoiceDate () {
		return invoiceDate;
	}

	/**
	 * Set the value related to the column: invoice_date
	 * @param invoiceDate the invoice_date value
	 */
	public void setInvoiceDate (java.util.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}



	/**
	 * Return the value associated with the column: invoice_amount
	 */
	public java.math.BigDecimal getInvoiceAmount () {
		return invoiceAmount;
	}

	/**
	 * Set the value related to the column: invoice_amount
	 * @param invoiceAmount the invoice_amount value
	 */
	public void setInvoiceAmount (java.math.BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
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
	 * Return the value associated with the column: cost_center_id
	 */
	public jkt.hms.masters.business.MasCostCenter getCostCenter () {
		return costCenter;
	}

	/**
	 * Set the value related to the column: cost_center_id
	 * @param costCenter the cost_center_id value
	 */
	public void setCostCenter (jkt.hms.masters.business.MasCostCenter costCenter) {
		this.costCenter = costCenter;
	}



	/**
	 * Return the value associated with the column: f_year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFYear () {
		return fYear;
	}

	/**
	 * Set the value related to the column: f_year_id
	 * @param fYear the f_year_id value
	 */
	public void setFYear (jkt.hms.masters.business.MasStoreFinancial fYear) {
		this.fYear = fYear;
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
	 * Return the value associated with the column: account_sub_group_id
	 */
	public jkt.hms.masters.business.FaMasAccountSubGroup getAccountSubGroup () {
		return accountSubGroup;
	}

	/**
	 * Set the value related to the column: account_sub_group_id
	 * @param accountSubGroup the account_sub_group_id value
	 */
	public void setAccountSubGroup (jkt.hms.masters.business.FaMasAccountSubGroup accountSubGroup) {
		this.accountSubGroup = accountSubGroup;
	}



	/**
	 * Return the value associated with the column: scheme_id
	 */
	public jkt.hms.masters.business.MasScheme getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme_id
	 * @param scheme the scheme_id value
	 */
	public void setScheme (jkt.hms.masters.business.MasScheme scheme) {
		this.scheme = scheme;
	}



	/**
	 * Return the value associated with the column: FaVoucherDetails
	 */
	public java.util.Set<jkt.hms.masters.business.FaVoucherDetails> getFaVoucherDetails () {
		return faVoucherDetails;
	}

	/**
	 * Set the value related to the column: FaVoucherDetails
	 * @param faVoucherDetails the FaVoucherDetails value
	 */
	public void setFaVoucherDetails (java.util.Set<jkt.hms.masters.business.FaVoucherDetails> faVoucherDetails) {
		this.faVoucherDetails = faVoucherDetails;
	}

	public void addToFaVoucherDetails (jkt.hms.masters.business.FaVoucherDetails faVoucherDetails) {
		if (null == getFaVoucherDetails()) setFaVoucherDetails(new java.util.TreeSet<jkt.hms.masters.business.FaVoucherDetails>());
		getFaVoucherDetails().add(faVoucherDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaVoucherHeader)) return false;
		else {
			jkt.hms.masters.business.FaVoucherHeader faVoucherHeader = (jkt.hms.masters.business.FaVoucherHeader) obj;
			if (null == this.getId() || null == faVoucherHeader.getId()) return false;
			else return (this.getId().equals(faVoucherHeader.getId()));
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