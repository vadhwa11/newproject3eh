package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the transaction_sequence table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="transaction_sequence"
 */

public abstract class BaseTransactionSequence  implements Serializable {

	public static String REF = "TransactionSequence";
	public static String PROP_TABLENAME = "Tablename";
	public static String PROP_CREATEDBY = "Createdby";
	public static String PROP_TRANSACTION_SEQUENCE_NAME = "TransactionSequenceName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_FINANICAL_YEAR = "FinanicalYear";
	public static String PROP_TRANSACTION_SEQUENCE_NUMBER = "TransactionSequenceNumber";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_ID_GEN_SEQ = "IdGenSeq";
	public static String PROP_MONTH = "Month";
	public static String PROP_TRANSACTION_SUFFIX = "TransactionSuffix";
	public static String PROP_TRANSACTION_PREFIX = "TransactionPrefix";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CREATED_BY_ID = "CreatedById";
	public static String PROP_ID = "Id";
	public static String PROP_VOUCHER_TYPE = "VoucherType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseTransactionSequence () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTransactionSequence (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer createdById;
	private java.lang.String createdby;
	private java.lang.String finanicalYear;
	private java.lang.String idGenSeq;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer month;
	private java.lang.String status;
	private java.lang.String tablename;
	private java.lang.String transactionPrefix;
	private java.lang.String transactionSequenceName;
	private java.lang.Integer transactionSequenceNumber;
	private java.lang.String transactionSuffix;
	private java.lang.String voucherType;

	// many to one
	private jkt.hms.masters.business.MasStoreFinancial fYear;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasServiceType serviceType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="transaction_sequence_id"
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
	 * Return the value associated with the column: created_by_id
	 */
	public java.lang.Integer getCreatedById () {
		return createdById;
	}

	/**
	 * Set the value related to the column: created_by_id
	 * @param createdById the created_by_id value
	 */
	public void setCreatedById (java.lang.Integer createdById) {
		this.createdById = createdById;
	}



	/**
	 * Return the value associated with the column: createdby
	 */
	public java.lang.String getCreatedby () {
		return createdby;
	}

	/**
	 * Set the value related to the column: createdby
	 * @param createdby the createdby value
	 */
	public void setCreatedby (java.lang.String createdby) {
		this.createdby = createdby;
	}



	/**
	 * Return the value associated with the column: finanical_year
	 */
	public java.lang.String getFinanicalYear () {
		return finanicalYear;
	}

	/**
	 * Set the value related to the column: finanical_year
	 * @param finanicalYear the finanical_year value
	 */
	public void setFinanicalYear (java.lang.String finanicalYear) {
		this.finanicalYear = finanicalYear;
	}



	/**
	 * Return the value associated with the column: id_gen_seq
	 */
	public java.lang.String getIdGenSeq () {
		return idGenSeq;
	}

	/**
	 * Set the value related to the column: id_gen_seq
	 * @param idGenSeq the id_gen_seq value
	 */
	public void setIdGenSeq (java.lang.String idGenSeq) {
		this.idGenSeq = idGenSeq;
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
	 * Return the value associated with the column: month
	 */
	public java.lang.Integer getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * @param month the month value
	 */
	public void setMonth (java.lang.Integer month) {
		this.month = month;
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
	 * Return the value associated with the column: tablename
	 */
	public java.lang.String getTablename () {
		return tablename;
	}

	/**
	 * Set the value related to the column: tablename
	 * @param tablename the tablename value
	 */
	public void setTablename (java.lang.String tablename) {
		this.tablename = tablename;
	}



	/**
	 * Return the value associated with the column: transaction_prefix
	 */
	public java.lang.String getTransactionPrefix () {
		return transactionPrefix;
	}

	/**
	 * Set the value related to the column: transaction_prefix
	 * @param transactionPrefix the transaction_prefix value
	 */
	public void setTransactionPrefix (java.lang.String transactionPrefix) {
		this.transactionPrefix = transactionPrefix;
	}



	/**
	 * Return the value associated with the column: transaction_sequence_name
	 */
	public java.lang.String getTransactionSequenceName () {
		return transactionSequenceName;
	}

	/**
	 * Set the value related to the column: transaction_sequence_name
	 * @param transactionSequenceName the transaction_sequence_name value
	 */
	public void setTransactionSequenceName (java.lang.String transactionSequenceName) {
		this.transactionSequenceName = transactionSequenceName;
	}



	/**
	 * Return the value associated with the column: transaction_sequence_number
	 */
	public java.lang.Integer getTransactionSequenceNumber () {
		return transactionSequenceNumber;
	}

	/**
	 * Set the value related to the column: transaction_sequence_number
	 * @param transactionSequenceNumber the transaction_sequence_number value
	 */
	public void setTransactionSequenceNumber (java.lang.Integer transactionSequenceNumber) {
		this.transactionSequenceNumber = transactionSequenceNumber;
	}



	/**
	 * Return the value associated with the column: transaction_suffix
	 */
	public java.lang.String getTransactionSuffix () {
		return transactionSuffix;
	}

	/**
	 * Set the value related to the column: transaction_suffix
	 * @param transactionSuffix the transaction_suffix value
	 */
	public void setTransactionSuffix (java.lang.String transactionSuffix) {
		this.transactionSuffix = transactionSuffix;
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
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType () {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceType the service_type_id value
	 */
	public void setServiceType (jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TransactionSequence)) return false;
		else {
			jkt.hms.masters.business.TransactionSequence transactionSequence = (jkt.hms.masters.business.TransactionSequence) obj;
			if (null == this.getId() || null == transactionSequence.getId()) return false;
			else return (this.getId().equals(transactionSequence.getId()));
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