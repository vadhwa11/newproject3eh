package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_standard_allowance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_standard_allowance"
 */

public abstract class BaseMstrStandardAllowance  implements Serializable {

	public static String REF = "MstrStandardAllowance";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_RANK = "Rank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EXPENSE_TYPE = "ExpenseType";
	public static String PROP_TRIP = "Trip";
	public static String PROP_STATUS = "Status";
	public static String PROP_CITY_TYPE_FLAG = "CityTypeFlag";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_ALLOWANCE_CODE = "AllowanceCode";
	public static String PROP_ALLOWANCE_DESC = "AllowanceDesc";


	// constructors
	public BaseMstrStandardAllowance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrStandardAllowance (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String allowanceCode;
	private java.lang.String allowanceDesc;
	private java.math.BigDecimal amount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String cityTypeFlag;

	// many to one
	private jkt.hrms.masters.business.MstrCode trip;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasCurrency currency;
	private jkt.hrms.masters.business.MstrCode expenseType;
	private jkt.hms.masters.business.MasRank rank;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="standard_allowance_id"
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
	 * Return the value associated with the column: allowance_code
	 */
	public java.lang.String getAllowanceCode () {
		return allowanceCode;
	}

	/**
	 * Set the value related to the column: allowance_code
	 * @param allowanceCode the allowance_code value
	 */
	public void setAllowanceCode (java.lang.String allowanceCode) {
		this.allowanceCode = allowanceCode;
	}



	/**
	 * Return the value associated with the column: allowance_desc
	 */
	public java.lang.String getAllowanceDesc () {
		return allowanceDesc;
	}

	/**
	 * Set the value related to the column: allowance_desc
	 * @param allowanceDesc the allowance_desc value
	 */
	public void setAllowanceDesc (java.lang.String allowanceDesc) {
		this.allowanceDesc = allowanceDesc;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
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
	 * Return the value associated with the column: city_type_flag
	 */
	public java.lang.String getCityTypeFlag () {
		return cityTypeFlag;
	}

	/**
	 * Set the value related to the column: city_type_flag
	 * @param cityTypeFlag the city_type_flag value
	 */
	public void setCityTypeFlag (java.lang.String cityTypeFlag) {
		this.cityTypeFlag = cityTypeFlag;
	}



	/**
	 * Return the value associated with the column: trip_id
	 */
	public jkt.hrms.masters.business.MstrCode getTrip () {
		return trip;
	}

	/**
	 * Set the value related to the column: trip_id
	 * @param trip the trip_id value
	 */
	public void setTrip (jkt.hrms.masters.business.MstrCode trip) {
		this.trip = trip;
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
	 * Return the value associated with the column: currency_id
	 */
	public jkt.hms.masters.business.MasCurrency getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency_id
	 * @param currency the currency_id value
	 */
	public void setCurrency (jkt.hms.masters.business.MasCurrency currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: expense_type_id
	 */
	public jkt.hrms.masters.business.MstrCode getExpenseType () {
		return expenseType;
	}

	/**
	 * Set the value related to the column: expense_type_id
	 * @param expenseType the expense_type_id value
	 */
	public void setExpenseType (jkt.hrms.masters.business.MstrCode expenseType) {
		this.expenseType = expenseType;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrStandardAllowance)) return false;
		else {
			jkt.hrms.masters.business.MstrStandardAllowance mstrStandardAllowance = (jkt.hrms.masters.business.MstrStandardAllowance) obj;
			if (null == this.getId() || null == mstrStandardAllowance.getId()) return false;
			else return (this.getId().equals(mstrStandardAllowance.getId()));
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