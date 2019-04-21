package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the fa_parameter table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="fa_parameter"
 */

public abstract class BaseFaParameter implements Serializable {

	public static String REF = "FaParameter";
	public static String PROP_VOUCHER_TYPE = "VoucherType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CRITERIA = "Criteria";
	public static String PROP_SEQ_NO = "SeqNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseFaParameter() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaParameter(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer seqNo;
	private java.lang.String voucherType;
	private java.lang.String criteria;
	private java.lang.String prefix;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="fa_param_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: seq_no
	 */
	public java.lang.Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * Set the value related to the column: seq_no
	 * 
	 * @param seqNo
	 *            the seq_no value
	 */
	public void setSeqNo(java.lang.Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * Return the value associated with the column: voucher_type
	 */
	public java.lang.String getVoucherType() {
		return voucherType;
	}

	/**
	 * Set the value related to the column: voucher_type
	 * 
	 * @param voucherType
	 *            the voucher_type value
	 */
	public void setVoucherType(java.lang.String voucherType) {
		this.voucherType = voucherType;
	}

	/**
	 * Return the value associated with the column: criteria
	 */
	public java.lang.String getCriteria() {
		return criteria;
	}

	/**
	 * Set the value related to the column: criteria
	 * 
	 * @param criteria
	 *            the criteria value
	 */
	public void setCriteria(java.lang.String criteria) {
		this.criteria = criteria;
	}

	/**
	 * Return the value associated with the column: prefix
	 */
	public java.lang.String getPrefix() {
		return prefix;
	}

	/**
	 * Set the value related to the column: prefix
	 * 
	 * @param prefix
	 *            the prefix value
	 */
	public void setPrefix(java.lang.String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.FaParameter)) {
			return false;
		} else {
			jkt.hms.masters.business.FaParameter faParameter = (jkt.hms.masters.business.FaParameter) obj;
			if (null == this.getId() || null == faParameter.getId()) {
				return false;
			} else {
				return (this.getId().equals(faParameter.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}