package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_account_schedule table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_account_schedule"
 */

public abstract class BaseMasAccountSchedule  implements Serializable {

	public static String REF = "MasAccountSchedule";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_SCHEDULE_NO = "ScheduleNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_SCHEDULE_CODE = "ScheduleCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SCHEDULE_NAME = "ScheduleName";


	// constructors
	public BaseMasAccountSchedule () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAccountSchedule (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer scheduleCode;
	private java.lang.String scheduleNo;
	private java.lang.String scheduleName;
	private java.lang.Integer orderNo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.FaMasAccount> faMasAccounts;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="schedule_id"
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
	 * Return the value associated with the column: schedule_code
	 */
	public java.lang.Integer getScheduleCode () {
		return scheduleCode;
	}

	/**
	 * Set the value related to the column: schedule_code
	 * @param scheduleCode the schedule_code value
	 */
	public void setScheduleCode (java.lang.Integer scheduleCode) {
		this.scheduleCode = scheduleCode;
	}



	/**
	 * Return the value associated with the column: schedule_no
	 */
	public java.lang.String getScheduleNo () {
		return scheduleNo;
	}

	/**
	 * Set the value related to the column: schedule_no
	 * @param scheduleNo the schedule_no value
	 */
	public void setScheduleNo (java.lang.String scheduleNo) {
		this.scheduleNo = scheduleNo;
	}



	/**
	 * Return the value associated with the column: schedule_name
	 */
	public java.lang.String getScheduleName () {
		return scheduleName;
	}

	/**
	 * Set the value related to the column: schedule_name
	 * @param scheduleName the schedule_name value
	 */
	public void setScheduleName (java.lang.String scheduleName) {
		this.scheduleName = scheduleName;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
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
	 * Return the value associated with the column: FaMasAccounts
	 */
	public java.util.Set<jkt.hms.masters.business.FaMasAccount> getFaMasAccounts () {
		return faMasAccounts;
	}

	/**
	 * Set the value related to the column: FaMasAccounts
	 * @param faMasAccounts the FaMasAccounts value
	 */
	public void setFaMasAccounts (java.util.Set<jkt.hms.masters.business.FaMasAccount> faMasAccounts) {
		this.faMasAccounts = faMasAccounts;
	}

	public void addToFaMasAccounts (jkt.hms.masters.business.FaMasAccount faMasAccount) {
		if (null == getFaMasAccounts()) setFaMasAccounts(new java.util.TreeSet<jkt.hms.masters.business.FaMasAccount>());
		getFaMasAccounts().add(faMasAccount);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAccountSchedule)) return false;
		else {
			jkt.hms.masters.business.MasAccountSchedule masAccountSchedule = (jkt.hms.masters.business.MasAccountSchedule) obj;
			if (null == this.getId() || null == masAccountSchedule.getId()) return false;
			else return (this.getId().equals(masAccountSchedule.getId()));
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