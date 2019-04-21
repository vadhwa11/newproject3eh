package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the daily_charge_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="daily_charge_setup"
 */

public abstract class BaseDailyChargeSetup  implements Serializable {

	public static String REF = "DailyChargeSetup";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DAILY_CHARGE_STATUS = "DailyChargeStatus";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseDailyChargeSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDailyChargeSetup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer quantity;
	private java.lang.String dailyChargeStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="daily_charge_setup"
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
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: daily_charge_status
	 */
	public java.lang.String getDailyChargeStatus () {
		return dailyChargeStatus;
	}

	/**
	 * Set the value related to the column: daily_charge_status
	 * @param dailyChargeStatus the daily_charge_status value
	 */
	public void setDailyChargeStatus (java.lang.String dailyChargeStatus) {
		this.dailyChargeStatus = dailyChargeStatus;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DailyChargeSetup)) return false;
		else {
			jkt.hms.masters.business.DailyChargeSetup dailyChargeSetup = (jkt.hms.masters.business.DailyChargeSetup) obj;
			if (null == this.getId() || null == dailyChargeSetup.getId()) return false;
			else return (this.getId().equals(dailyChargeSetup.getId()));
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