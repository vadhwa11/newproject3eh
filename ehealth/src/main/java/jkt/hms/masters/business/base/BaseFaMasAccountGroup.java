package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_mas_account_group table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_mas_account_group"
 */

public abstract class BaseFaMasAccountGroup  implements Serializable {

	public static String REF = "FaMasAccountGroup";
	public static String PROP_CL_BALANCE_CR = "ClBalanceCr";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ACCOUNT_GROUP_DESC = "AccountGroupDesc";
	public static String PROP_YTD_AMOUNT_CR = "YtdAmountCr";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OP_BALANCE_CR = "OpBalanceCr";
	public static String PROP_YTD_AMOUNT_DR = "YtdAmountDr";
	public static String PROP_ID = "Id";
	public static String PROP_ACCOUNT_GROUP_CODE = "AccountGroupCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_OP_BALANCE_DR = "OpBalanceDr";
	public static String PROP_CL_BALANCE_DR = "ClBalanceDr";


	// constructors
	public BaseFaMasAccountGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaMasAccountGroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer accountGroupCode;
	private java.lang.String accountGroupDesc;
	private java.math.BigDecimal clBalanceCr;
	private java.math.BigDecimal clBalanceDr;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal opBalanceCr;
	private java.math.BigDecimal opBalanceDr;
	private java.lang.String status;
	private java.math.BigDecimal ytdAmountCr;
	private java.math.BigDecimal ytdAmountDr;

	// many to one
	private jkt.hms.masters.business.MasStoreFinancial fYear;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.FaMasAccountSubGroup> faMasAccountSubGroups;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="account_group_id"
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
	 * Return the value associated with the column: account_group_code
	 */
	public java.lang.Integer getAccountGroupCode () {
		return accountGroupCode;
	}

	/**
	 * Set the value related to the column: account_group_code
	 * @param accountGroupCode the account_group_code value
	 */
	public void setAccountGroupCode (java.lang.Integer accountGroupCode) {
		this.accountGroupCode = accountGroupCode;
	}



	/**
	 * Return the value associated with the column: account_group_desc
	 */
	public java.lang.String getAccountGroupDesc () {
		return accountGroupDesc;
	}

	/**
	 * Set the value related to the column: account_group_desc
	 * @param accountGroupDesc the account_group_desc value
	 */
	public void setAccountGroupDesc (java.lang.String accountGroupDesc) {
		this.accountGroupDesc = accountGroupDesc;
	}



	/**
	 * Return the value associated with the column: cl_balance_cr
	 */
	public java.math.BigDecimal getClBalanceCr () {
		return clBalanceCr;
	}

	/**
	 * Set the value related to the column: cl_balance_cr
	 * @param clBalanceCr the cl_balance_cr value
	 */
	public void setClBalanceCr (java.math.BigDecimal clBalanceCr) {
		this.clBalanceCr = clBalanceCr;
	}



	/**
	 * Return the value associated with the column: cl_balance_dr
	 */
	public java.math.BigDecimal getClBalanceDr () {
		return clBalanceDr;
	}

	/**
	 * Set the value related to the column: cl_balance_dr
	 * @param clBalanceDr the cl_balance_dr value
	 */
	public void setClBalanceDr (java.math.BigDecimal clBalanceDr) {
		this.clBalanceDr = clBalanceDr;
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
	 * Return the value associated with the column: op_balance_cr
	 */
	public java.math.BigDecimal getOpBalanceCr () {
		return opBalanceCr;
	}

	/**
	 * Set the value related to the column: op_balance_cr
	 * @param opBalanceCr the op_balance_cr value
	 */
	public void setOpBalanceCr (java.math.BigDecimal opBalanceCr) {
		this.opBalanceCr = opBalanceCr;
	}



	/**
	 * Return the value associated with the column: op_balance_dr
	 */
	public java.math.BigDecimal getOpBalanceDr () {
		return opBalanceDr;
	}

	/**
	 * Set the value related to the column: op_balance_dr
	 * @param opBalanceDr the op_balance_dr value
	 */
	public void setOpBalanceDr (java.math.BigDecimal opBalanceDr) {
		this.opBalanceDr = opBalanceDr;
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
	 * Return the value associated with the column: ytd_amount_cr
	 */
	public java.math.BigDecimal getYtdAmountCr () {
		return ytdAmountCr;
	}

	/**
	 * Set the value related to the column: ytd_amount_cr
	 * @param ytdAmountCr the ytd_amount_cr value
	 */
	public void setYtdAmountCr (java.math.BigDecimal ytdAmountCr) {
		this.ytdAmountCr = ytdAmountCr;
	}



	/**
	 * Return the value associated with the column: ytd_amount_dr
	 */
	public java.math.BigDecimal getYtdAmountDr () {
		return ytdAmountDr;
	}

	/**
	 * Set the value related to the column: ytd_amount_dr
	 * @param ytdAmountDr the ytd_amount_dr value
	 */
	public void setYtdAmountDr (java.math.BigDecimal ytdAmountDr) {
		this.ytdAmountDr = ytdAmountDr;
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
	 * Return the value associated with the column: FaMasAccountSubGroups
	 */
	public java.util.Set<jkt.hms.masters.business.FaMasAccountSubGroup> getFaMasAccountSubGroups () {
		return faMasAccountSubGroups;
	}

	/**
	 * Set the value related to the column: FaMasAccountSubGroups
	 * @param faMasAccountSubGroups the FaMasAccountSubGroups value
	 */
	public void setFaMasAccountSubGroups (java.util.Set<jkt.hms.masters.business.FaMasAccountSubGroup> faMasAccountSubGroups) {
		this.faMasAccountSubGroups = faMasAccountSubGroups;
	}

	public void addToFaMasAccountSubGroups (jkt.hms.masters.business.FaMasAccountSubGroup faMasAccountSubGroup) {
		if (null == getFaMasAccountSubGroups()) setFaMasAccountSubGroups(new java.util.TreeSet<jkt.hms.masters.business.FaMasAccountSubGroup>());
		getFaMasAccountSubGroups().add(faMasAccountSubGroup);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaMasAccountGroup)) return false;
		else {
			jkt.hms.masters.business.FaMasAccountGroup faMasAccountGroup = (jkt.hms.masters.business.FaMasAccountGroup) obj;
			if (null == this.getId() || null == faMasAccountGroup.getId()) return false;
			else return (this.getId().equals(faMasAccountGroup.getId()));
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