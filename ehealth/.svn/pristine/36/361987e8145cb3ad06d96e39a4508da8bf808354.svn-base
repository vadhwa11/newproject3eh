package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_bank_reconsillation_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_bank_reconsillation_details"
 */

public abstract class BaseFaBankReconsillationDetails  implements Serializable {

	public static String REF = "FaBankReconsillationDetails";
	public static String PROP_VOUCHER_HEADER_ID = "VoucherHeaderId";
	public static String PROP_CHEQUE_STATUS = "ChequeStatus";
	public static String PROP_CHEQUE_DATE = "ChequeDate";
	public static String PROP_CHEQUE_AMOUNT = "ChequeAmount";
	public static String PROP_CHEQUE_NO = "ChequeNo";
	public static String PROP_ID = "Id";
	public static String PROP_BANK_RECONSILLATION_HEADER_ID = "BankReconsillationHeaderId";
	public static String PROP_CHEQUE_TYPE = "ChequeType";


	// constructors
	public BaseFaBankReconsillationDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaBankReconsillationDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer bankReconsillationHeaderId;
	private java.util.Date chequeDate;
	private java.lang.String chequeType;
	private java.lang.Integer chequeNo;
	private java.math.BigDecimal chequeAmount;
	private java.lang.String chequeStatus;
	private java.lang.Integer voucherHeaderId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="bank_reconsillation_details_id"
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
	 * Return the value associated with the column: bank_reconsillation_header_id
	 */
	public java.lang.Integer getBankReconsillationHeaderId () {
		return bankReconsillationHeaderId;
	}

	/**
	 * Set the value related to the column: bank_reconsillation_header_id
	 * @param bankReconsillationHeaderId the bank_reconsillation_header_id value
	 */
	public void setBankReconsillationHeaderId (java.lang.Integer bankReconsillationHeaderId) {
		this.bankReconsillationHeaderId = bankReconsillationHeaderId;
	}



	/**
	 * Return the value associated with the column: cheque_date
	 */
	public java.util.Date getChequeDate () {
		return chequeDate;
	}

	/**
	 * Set the value related to the column: cheque_date
	 * @param chequeDate the cheque_date value
	 */
	public void setChequeDate (java.util.Date chequeDate) {
		this.chequeDate = chequeDate;
	}



	/**
	 * Return the value associated with the column: cheque_type
	 */
	public java.lang.String getChequeType () {
		return chequeType;
	}

	/**
	 * Set the value related to the column: cheque_type
	 * @param chequeType the cheque_type value
	 */
	public void setChequeType (java.lang.String chequeType) {
		this.chequeType = chequeType;
	}



	/**
	 * Return the value associated with the column: cheque_no
	 */
	public java.lang.Integer getChequeNo () {
		return chequeNo;
	}

	/**
	 * Set the value related to the column: cheque_no
	 * @param chequeNo the cheque_no value
	 */
	public void setChequeNo (java.lang.Integer chequeNo) {
		this.chequeNo = chequeNo;
	}



	/**
	 * Return the value associated with the column: cheque_amount
	 */
	public java.math.BigDecimal getChequeAmount () {
		return chequeAmount;
	}

	/**
	 * Set the value related to the column: cheque_amount
	 * @param chequeAmount the cheque_amount value
	 */
	public void setChequeAmount (java.math.BigDecimal chequeAmount) {
		this.chequeAmount = chequeAmount;
	}



	/**
	 * Return the value associated with the column: cheque_status
	 */
	public java.lang.String getChequeStatus () {
		return chequeStatus;
	}

	/**
	 * Set the value related to the column: cheque_status
	 * @param chequeStatus the cheque_status value
	 */
	public void setChequeStatus (java.lang.String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}



	/**
	 * Return the value associated with the column: voucher_header_id
	 */
	public java.lang.Integer getVoucherHeaderId () {
		return voucherHeaderId;
	}

	/**
	 * Set the value related to the column: voucher_header_id
	 * @param voucherHeaderId the voucher_header_id value
	 */
	public void setVoucherHeaderId (java.lang.Integer voucherHeaderId) {
		this.voucherHeaderId = voucherHeaderId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaBankReconsillationDetails)) return false;
		else {
			jkt.hms.masters.business.FaBankReconsillationDetails faBankReconsillationDetails = (jkt.hms.masters.business.FaBankReconsillationDetails) obj;
			if (null == this.getId() || null == faBankReconsillationDetails.getId()) return false;
			else return (this.getId().equals(faBankReconsillationDetails.getId()));
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