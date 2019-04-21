package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_account_type table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="bl_account_type"
 */

public abstract class BaseBlAccountType implements Serializable {

	public static String REF = "BlAccountType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BL_ACCOUNT_TYPE_NAME = "BlAccountTypeName";
	public static String PROP_FA_MAS_ACCOUNT = "FaMasAccount";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BL_ACCOUNT_TYPE_CODE = "BlAccountTypeCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBlAccountType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlAccountType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String blAccountTypeCode;
	private java.lang.String blAccountTypeName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.FaMasAccount faMasAccount;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="bl_account_type_id"
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
	 * Return the value associated with the column: bl_account_type_code
	 */
	public java.lang.String getBlAccountTypeCode() {
		return blAccountTypeCode;
	}

	/**
	 * Set the value related to the column: bl_account_type_code
	 * 
	 * @param blAccountTypeCode
	 *            the bl_account_type_code value
	 */
	public void setBlAccountTypeCode(java.lang.String blAccountTypeCode) {
		this.blAccountTypeCode = blAccountTypeCode;
	}

	/**
	 * Return the value associated with the column: bl_account_type_name
	 */
	public java.lang.String getBlAccountTypeName() {
		return blAccountTypeName;
	}

	/**
	 * Set the value related to the column: bl_account_type_name
	 * 
	 * @param blAccountTypeName
	 *            the bl_account_type_name value
	 */
	public void setBlAccountTypeName(java.lang.String blAccountTypeName) {
		this.blAccountTypeName = blAccountTypeName;
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

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: fa_mas_account_id
	 */
	public jkt.hms.masters.business.FaMasAccount getFaMasAccount() {
		return faMasAccount;
	}

	/**
	 * Set the value related to the column: fa_mas_account_id
	 * 
	 * @param faMasAccount
	 *            the fa_mas_account_id value
	 */
	public void setFaMasAccount(
			jkt.hms.masters.business.FaMasAccount faMasAccount) {
		this.faMasAccount = faMasAccount;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.BlAccountType)) {
			return false;
		} else {
			jkt.hms.masters.business.BlAccountType blAccountType = (jkt.hms.masters.business.BlAccountType) obj;
			if (null == this.getId() || null == blAccountType.getId()) {
				return false;
			} else {
				return (this.getId().equals(blAccountType.getId()));
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