package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the house_keeping_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="house_keeping_setup"
 */

public abstract class BaseHouseKeepingSetup  implements Serializable {

	public static String REF = "HouseKeepingSetup";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOUSE_KEEPING = "HouseKeeping";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_HOUSE_KEEPING_FREQUENCY = "HouseKeepingFrequency";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHouseKeepingSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHouseKeepingSetup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHouseKeepingFrequency houseKeepingFrequency;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHouseKeeping houseKeeping;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="house_keeping_setup_id"
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: house_keeping_frequency_id
	 */
	public jkt.hms.masters.business.MasHouseKeepingFrequency getHouseKeepingFrequency () {
		return houseKeepingFrequency;
	}

	/**
	 * Set the value related to the column: house_keeping_frequency_id
	 * @param houseKeepingFrequency the house_keeping_frequency_id value
	 */
	public void setHouseKeepingFrequency (jkt.hms.masters.business.MasHouseKeepingFrequency houseKeepingFrequency) {
		this.houseKeepingFrequency = houseKeepingFrequency;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: house_keeping_id
	 */
	public jkt.hms.masters.business.MasHouseKeeping getHouseKeeping () {
		return houseKeeping;
	}

	/**
	 * Set the value related to the column: house_keeping_id
	 * @param houseKeeping the house_keeping_id value
	 */
	public void setHouseKeeping (jkt.hms.masters.business.MasHouseKeeping houseKeeping) {
		this.houseKeeping = houseKeeping;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HouseKeepingSetup)) return false;
		else {
			jkt.hms.masters.business.HouseKeepingSetup houseKeepingSetup = (jkt.hms.masters.business.HouseKeepingSetup) obj;
			if (null == this.getId() || null == houseKeepingSetup.getId()) return false;
			else return (this.getId().equals(houseKeepingSetup.getId()));
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