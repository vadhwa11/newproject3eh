package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prq_quotation_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prq_quotation_header"
 */

public abstract class BasePrqQuotationHeader  implements Serializable {

	public static String REF = "PrqQuotationHeader";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SUBMISSION_BY = "SubmissionBy";
	public static String PROP_QUOTATION_OPENING_TIME = "QuotationOpeningTime";
	public static String PROP_QUOTATION_DATE = "QuotationDate";
	public static String PROP_APPROVAL_REMARKS = "ApprovalRemarks";
	public static String PROP_APPROVAL_DATE = "ApprovalDate";
	public static String PROP_QUOTATION_STATUS = "QuotationStatus";
	public static String PROP_QUOTATION_NO = "QuotationNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_QUOTATION_DUE_TIME = "QuotationDueTime";
	public static String PROP_NEGOTIATION_DATE = "NegotiationDate";
	public static String PROP_ID = "Id";
	public static String PROP_QUOTATION_BY = "QuotationBy";
	public static String PROP_APPROVAL_BY = "ApprovalBy";
	public static String PROP_QUOTATION_OPENING_DATE = "QuotationOpeningDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_QUOTATION_DUE_DATE = "QuotationDueDate";
	public static String PROP_DATE_UPTO_RATES_REMAIN_SAME = "DateUptoRatesRemainSame";
	public static String PROP_SUBMISSION_DATE = "SubmissionDate";


	// constructors
	public BasePrqQuotationHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrqQuotationHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String quotationNo;
	private java.util.Date quotationDate;
	private java.util.Date quotationDueDate;
	private java.lang.String quotationDueTime;
	private java.util.Date quotationOpeningDate;
	private java.lang.String quotationOpeningTime;
	private java.util.Date dateUptoRatesRemainSame;
	private java.util.Date approvalDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String approvalRemarks;
	private java.util.Date submissionDate;
	private java.util.Date negotiationDate;

	// many to one
	private jkt.hms.masters.business.Users approvalBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee submissionBy;
	private jkt.hms.masters.business.MmMasRequestStatus quotationStatus;
	private jkt.hms.masters.business.Users quotationBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="header_id"
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
	 * Return the value associated with the column: quotation_no
	 */
	public java.lang.String getQuotationNo () {
		return quotationNo;
	}

	/**
	 * Set the value related to the column: quotation_no
	 * @param quotationNo the quotation_no value
	 */
	public void setQuotationNo (java.lang.String quotationNo) {
		this.quotationNo = quotationNo;
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
	 * Return the value associated with the column: quotation_due_date
	 */
	public java.util.Date getQuotationDueDate () {
		return quotationDueDate;
	}

	/**
	 * Set the value related to the column: quotation_due_date
	 * @param quotationDueDate the quotation_due_date value
	 */
	public void setQuotationDueDate (java.util.Date quotationDueDate) {
		this.quotationDueDate = quotationDueDate;
	}



	/**
	 * Return the value associated with the column: quotation_due_time
	 */
	public java.lang.String getQuotationDueTime () {
		return quotationDueTime;
	}

	/**
	 * Set the value related to the column: quotation_due_time
	 * @param quotationDueTime the quotation_due_time value
	 */
	public void setQuotationDueTime (java.lang.String quotationDueTime) {
		this.quotationDueTime = quotationDueTime;
	}



	/**
	 * Return the value associated with the column: quotation_opening_date
	 */
	public java.util.Date getQuotationOpeningDate () {
		return quotationOpeningDate;
	}

	/**
	 * Set the value related to the column: quotation_opening_date
	 * @param quotationOpeningDate the quotation_opening_date value
	 */
	public void setQuotationOpeningDate (java.util.Date quotationOpeningDate) {
		this.quotationOpeningDate = quotationOpeningDate;
	}



	/**
	 * Return the value associated with the column: quotation_opening_time
	 */
	public java.lang.String getQuotationOpeningTime () {
		return quotationOpeningTime;
	}

	/**
	 * Set the value related to the column: quotation_opening_time
	 * @param quotationOpeningTime the quotation_opening_time value
	 */
	public void setQuotationOpeningTime (java.lang.String quotationOpeningTime) {
		this.quotationOpeningTime = quotationOpeningTime;
	}



	/**
	 * Return the value associated with the column: date_upto_rates_remain_same
	 */
	public java.util.Date getDateUptoRatesRemainSame () {
		return dateUptoRatesRemainSame;
	}

	/**
	 * Set the value related to the column: date_upto_rates_remain_same
	 * @param dateUptoRatesRemainSame the date_upto_rates_remain_same value
	 */
	public void setDateUptoRatesRemainSame (java.util.Date dateUptoRatesRemainSame) {
		this.dateUptoRatesRemainSame = dateUptoRatesRemainSame;
	}



	/**
	 * Return the value associated with the column: approval_date
	 */
	public java.util.Date getApprovalDate () {
		return approvalDate;
	}

	/**
	 * Set the value related to the column: approval_date
	 * @param approvalDate the approval_date value
	 */
	public void setApprovalDate (java.util.Date approvalDate) {
		this.approvalDate = approvalDate;
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
	 * Return the value associated with the column: approval_remarks
	 */
	public java.lang.String getApprovalRemarks () {
		return approvalRemarks;
	}

	/**
	 * Set the value related to the column: approval_remarks
	 * @param approvalRemarks the approval_remarks value
	 */
	public void setApprovalRemarks (java.lang.String approvalRemarks) {
		this.approvalRemarks = approvalRemarks;
	}



	/**
	 * Return the value associated with the column: submission_date
	 */
	public java.util.Date getSubmissionDate () {
		return submissionDate;
	}

	/**
	 * Set the value related to the column: submission_date
	 * @param submissionDate the submission_date value
	 */
	public void setSubmissionDate (java.util.Date submissionDate) {
		this.submissionDate = submissionDate;
	}



	/**
	 * Return the value associated with the column: negotiation_date
	 */
	public java.util.Date getNegotiationDate () {
		return negotiationDate;
	}

	/**
	 * Set the value related to the column: negotiation_date
	 * @param negotiationDate the negotiation_date value
	 */
	public void setNegotiationDate (java.util.Date negotiationDate) {
		this.negotiationDate = negotiationDate;
	}



	/**
	 * Return the value associated with the column: approval_by
	 */
	public jkt.hms.masters.business.Users getApprovalBy () {
		return approvalBy;
	}

	/**
	 * Set the value related to the column: approval_by
	 * @param approvalBy the approval_by value
	 */
	public void setApprovalBy (jkt.hms.masters.business.Users approvalBy) {
		this.approvalBy = approvalBy;
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
	 * Return the value associated with the column: submission_by
	 */
	public jkt.hms.masters.business.MasEmployee getSubmissionBy () {
		return submissionBy;
	}

	/**
	 * Set the value related to the column: submission_by
	 * @param submissionBy the submission_by value
	 */
	public void setSubmissionBy (jkt.hms.masters.business.MasEmployee submissionBy) {
		this.submissionBy = submissionBy;
	}



	/**
	 * Return the value associated with the column: quotation_status
	 */
	public jkt.hms.masters.business.MmMasRequestStatus getQuotationStatus () {
		return quotationStatus;
	}

	/**
	 * Set the value related to the column: quotation_status
	 * @param quotationStatus the quotation_status value
	 */
	public void setQuotationStatus (jkt.hms.masters.business.MmMasRequestStatus quotationStatus) {
		this.quotationStatus = quotationStatus;
	}



	/**
	 * Return the value associated with the column: quotation_by
	 */
	public jkt.hms.masters.business.Users getQuotationBy () {
		return quotationBy;
	}

	/**
	 * Set the value related to the column: quotation_by
	 * @param quotationBy the quotation_by value
	 */
	public void setQuotationBy (jkt.hms.masters.business.Users quotationBy) {
		this.quotationBy = quotationBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PrqQuotationHeader)) return false;
		else {
			jkt.hms.masters.business.PrqQuotationHeader prqQuotationHeader = (jkt.hms.masters.business.PrqQuotationHeader) obj;
			if (null == this.getId() || null == prqQuotationHeader.getId()) return false;
			else return (this.getId().equals(prqQuotationHeader.getId()));
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