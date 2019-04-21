package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_temperature_validation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_temperature_validation"
 */

public abstract class BaseStoreTemperatureValidation  implements Serializable {

	public static String REF = "StoreTemperatureValidation";
	public static String PROP_MONITORING_M = "MonitoringM";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_VALIDATION_DATE = "ValidationDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VALIDATION_REMARKS = "ValidationRemarks";


	// constructors
	public BaseStoreTemperatureValidation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTemperatureValidation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreTemperatureValidation (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date validationDate;
	private java.lang.String validationRemarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StoreTemperatureMonitoringM monitoringM;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="validation_id"
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
	 * Return the value associated with the column: validation_date
	 */
	public java.util.Date getValidationDate () {
		return validationDate;
	}

	/**
	 * Set the value related to the column: validation_date
	 * @param validationDate the validation_date value
	 */
	public void setValidationDate (java.util.Date validationDate) {
		this.validationDate = validationDate;
	}



	/**
	 * Return the value associated with the column: validation_remarks
	 */
	public java.lang.String getValidationRemarks () {
		return validationRemarks;
	}

	/**
	 * Set the value related to the column: validation_remarks
	 * @param validationRemarks the validation_remarks value
	 */
	public void setValidationRemarks (java.lang.String validationRemarks) {
		this.validationRemarks = validationRemarks;
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
	 * Return the value associated with the column: monitoring_m_id
	 */
	public jkt.hms.masters.business.StoreTemperatureMonitoringM getMonitoringM () {
		return monitoringM;
	}

	/**
	 * Set the value related to the column: monitoring_m_id
	 * @param monitoringM the monitoring_m_id value
	 */
	public void setMonitoringM (jkt.hms.masters.business.StoreTemperatureMonitoringM monitoringM) {
		this.monitoringM = monitoringM;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTemperatureValidation)) return false;
		else {
			jkt.hms.masters.business.StoreTemperatureValidation storeTemperatureValidation = (jkt.hms.masters.business.StoreTemperatureValidation) obj;
			if (null == this.getId() || null == storeTemperatureValidation.getId()) return false;
			else return (this.getId().equals(storeTemperatureValidation.getId()));
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