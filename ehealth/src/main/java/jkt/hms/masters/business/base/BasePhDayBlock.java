package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_day_block table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_day_block"
 */

public abstract class BasePhDayBlock  implements Serializable {

	public static String REF = "PhDayBlock";
	public static String PROP_FOR_DAY = "ForDay";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HOUSE_ID = "HouseId";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BasePhDayBlock () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhDayBlock (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer forDay;
	private java.lang.String houseId;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhDayBlockDetail> phDayBlockDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="day_id"
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
	 * Return the value associated with the column: for_day
	 */
	public java.lang.Integer getForDay () {
		return forDay;
	}

	/**
	 * Set the value related to the column: for_day
	 * @param forDay the for_day value
	 */
	public void setForDay (java.lang.Integer forDay) {
		this.forDay = forDay;
	}



	/**
	 * Return the value associated with the column: house_id
	 */
	public java.lang.String getHouseId () {
		return houseId;
	}

	/**
	 * Set the value related to the column: house_id
	 * @param houseId the house_id value
	 */
	public void setHouseId (java.lang.String houseId) {
		this.houseId = houseId;
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: PhDayBlockDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PhDayBlockDetail> getPhDayBlockDetails () {
		return phDayBlockDetails;
	}

	/**
	 * Set the value related to the column: PhDayBlockDetails
	 * @param phDayBlockDetails the PhDayBlockDetails value
	 */
	public void setPhDayBlockDetails (java.util.Set<jkt.hms.masters.business.PhDayBlockDetail> phDayBlockDetails) {
		this.phDayBlockDetails = phDayBlockDetails;
	}

	public void addToPhDayBlockDetails (jkt.hms.masters.business.PhDayBlockDetail phDayBlockDetail) {
		if (null == getPhDayBlockDetails()) setPhDayBlockDetails(new java.util.TreeSet<jkt.hms.masters.business.PhDayBlockDetail>());
		getPhDayBlockDetails().add(phDayBlockDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhDayBlock)) return false;
		else {
			jkt.hms.masters.business.PhDayBlock phDayBlock = (jkt.hms.masters.business.PhDayBlock) obj;
			if (null == this.getId() || null == phDayBlock.getId()) return false;
			else return (this.getId().equals(phDayBlock.getId()));
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