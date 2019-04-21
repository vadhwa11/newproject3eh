package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the vwLedgerBalance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="vwLedgerBalance"
 */

public abstract class BaseVwLedgerBalance  implements Serializable {

	public static String REF = "VwLedgerBalance";
	public static String PROP_SUB_LED = "SubLed";
	public static String PROP_DR_AMOUNT = "DrAmount";
	public static String PROP_CR_AMOUNT = "CrAmount";
	public static String PROP_OPENING_AMT_CR = "OpeningAmtCr";
	public static String PROP_OPENING_AMT_DR = "OpeningAmtDr";
	public static String PROP_TOTAL_DR = "TotalDr";
	public static String PROP_TOTAL_CR = "TotalCr";
	public static String PROP_DR_BALANCE = "DrBalance";
	public static String PROP_CR_BALANCE = "CrBalance";
	public static String PROP_BRANCH = "Branch";
	public static String PROP_FINANCIAL = "Financial";


	// constructors
	public BaseVwLedgerBalance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVwLedgerBalance (java.lang.Integer account) {
		this.setAccount(account);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer account;

	// fields
	private java.lang.Integer subLed;
	private java.math.BigDecimal drAmount;
	private java.math.BigDecimal crAmount;
	private java.math.BigDecimal openingAmtCr;
	private java.math.BigDecimal openingAmtDr;
	private java.math.BigDecimal totalDr;
	private java.math.BigDecimal totalCr;
	private java.math.BigDecimal drBalance;
	private java.math.BigDecimal crBalance;
	private java.lang.Integer branch;
	private java.lang.Integer financial;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="account_id"
     */
	public java.lang.Integer getAccount () {
		return account;
	}

	/**
	 * Set the unique identifier of this class
	 * @param account the new ID
	 */
	public void setAccount (java.lang.Integer account) {
		this.account = account;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: sub_led_id
	 */
	public java.lang.Integer getSubLed () {
		return subLed;
	}

	/**
	 * Set the value related to the column: sub_led_id
	 * @param subLed the sub_led_id value
	 */
	public void setSubLed (java.lang.Integer subLed) {
		this.subLed = subLed;
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
	 * Return the value associated with the column: opening_amt_cr
	 */
	public java.math.BigDecimal getOpeningAmtCr () {
		return openingAmtCr;
	}

	/**
	 * Set the value related to the column: opening_amt_cr
	 * @param openingAmtCr the opening_amt_cr value
	 */
	public void setOpeningAmtCr (java.math.BigDecimal openingAmtCr) {
		this.openingAmtCr = openingAmtCr;
	}



	/**
	 * Return the value associated with the column: opening_amt_dr
	 */
	public java.math.BigDecimal getOpeningAmtDr () {
		return openingAmtDr;
	}

	/**
	 * Set the value related to the column: opening_amt_dr
	 * @param openingAmtDr the opening_amt_dr value
	 */
	public void setOpeningAmtDr (java.math.BigDecimal openingAmtDr) {
		this.openingAmtDr = openingAmtDr;
	}



	/**
	 * Return the value associated with the column: TotalDr
	 */
	public java.math.BigDecimal getTotalDr () {
		return totalDr;
	}

	/**
	 * Set the value related to the column: TotalDr
	 * @param totalDr the TotalDr value
	 */
	public void setTotalDr (java.math.BigDecimal totalDr) {
		this.totalDr = totalDr;
	}



	/**
	 * Return the value associated with the column: TotalCr
	 */
	public java.math.BigDecimal getTotalCr () {
		return totalCr;
	}

	/**
	 * Set the value related to the column: TotalCr
	 * @param totalCr the TotalCr value
	 */
	public void setTotalCr (java.math.BigDecimal totalCr) {
		this.totalCr = totalCr;
	}



	/**
	 * Return the value associated with the column: DrBalance
	 */
	public java.math.BigDecimal getDrBalance () {
		return drBalance;
	}

	/**
	 * Set the value related to the column: DrBalance
	 * @param drBalance the DrBalance value
	 */
	public void setDrBalance (java.math.BigDecimal drBalance) {
		this.drBalance = drBalance;
	}



	/**
	 * Return the value associated with the column: CrBalance
	 */
	public java.math.BigDecimal getCrBalance () {
		return crBalance;
	}

	/**
	 * Set the value related to the column: CrBalance
	 * @param crBalance the CrBalance value
	 */
	public void setCrBalance (java.math.BigDecimal crBalance) {
		this.crBalance = crBalance;
	}



	/**
	 * Return the value associated with the column: branch_id
	 */
	public java.lang.Integer getBranch () {
		return branch;
	}

	/**
	 * Set the value related to the column: branch_id
	 * @param branch the branch_id value
	 */
	public void setBranch (java.lang.Integer branch) {
		this.branch = branch;
	}



	/**
	 * Return the value associated with the column: f_year_id
	 */
	public java.lang.Integer getFinancial () {
		return financial;
	}

	/**
	 * Set the value related to the column: f_year_id
	 * @param financial the f_year_id value
	 */
	public void setFinancial (java.lang.Integer financial) {
		this.financial = financial;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.VwLedgerBalance)) return false;
		else {
			jkt.hms.masters.business.VwLedgerBalance vwLedgerBalance = (jkt.hms.masters.business.VwLedgerBalance) obj;
			if (null == this.getAccount() || null == vwLedgerBalance.getAccount()) return false;
			else return (this.getAccount().equals(vwLedgerBalance.getAccount()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getAccount()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getAccount().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}