package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_temperature_monitoring_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_temperature_monitoring_m"
 */

public abstract class BaseStoreTemperatureMonitoringM  implements Serializable {

	public static String REF = "StoreTemperatureMonitoringM";
	public static String PROP_MAX_TEMP = "MaxTemp";
	public static String PROP_MIN_TEMP = "MinTemp";
	public static String PROP_MONITORING_DATE = "MonitoringDate";
	public static String PROP_REFRIGERATOR = "Refrigerator";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TRANSFER = "Transfer";
	public static String PROP_POTENCY_CHECK = "PotencyCheck";
	public static String PROP_REF_BATCH_NO = "RefBatchNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STORED_QTY = "StoredQty";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseStoreTemperatureMonitoringM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTemperatureMonitoringM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreTemperatureMonitoringM (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasHospital hospital,
		java.math.BigDecimal storedQty,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		this.setHospital(hospital);
		this.setStoredQty(storedQty);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal storedQty;
	private java.math.BigDecimal minTemp;
	private java.math.BigDecimal maxTemp;
	private java.lang.String potencyCheck;
	private java.lang.String transfer;
	private java.util.Date monitoringDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String refBatchNo;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem refrigerator;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreTemperatureMonitoringT> storeTemperatureMonitoringTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="monitoring_m_id"
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
	 * Return the value associated with the column: stored_qty
	 */
	public java.math.BigDecimal getStoredQty () {
		return storedQty;
	}

	/**
	 * Set the value related to the column: stored_qty
	 * @param storedQty the stored_qty value
	 */
	public void setStoredQty (java.math.BigDecimal storedQty) {
		this.storedQty = storedQty;
	}



	/**
	 * Return the value associated with the column: min_temp
	 */
	public java.math.BigDecimal getMinTemp () {
		return minTemp;
	}

	/**
	 * Set the value related to the column: min_temp
	 * @param minTemp the min_temp value
	 */
	public void setMinTemp (java.math.BigDecimal minTemp) {
		this.minTemp = minTemp;
	}



	/**
	 * Return the value associated with the column: max_temp
	 */
	public java.math.BigDecimal getMaxTemp () {
		return maxTemp;
	}

	/**
	 * Set the value related to the column: max_temp
	 * @param maxTemp the max_temp value
	 */
	public void setMaxTemp (java.math.BigDecimal maxTemp) {
		this.maxTemp = maxTemp;
	}



	/**
	 * Return the value associated with the column: potency_check
	 */
	public java.lang.String getPotencyCheck () {
		return potencyCheck;
	}

	/**
	 * Set the value related to the column: potency_check
	 * @param potencyCheck the potency_check value
	 */
	public void setPotencyCheck (java.lang.String potencyCheck) {
		this.potencyCheck = potencyCheck;
	}



	/**
	 * Return the value associated with the column: transfer
	 */
	public java.lang.String getTransfer () {
		return transfer;
	}

	/**
	 * Set the value related to the column: transfer
	 * @param transfer the transfer value
	 */
	public void setTransfer (java.lang.String transfer) {
		this.transfer = transfer;
	}



	/**
	 * Return the value associated with the column: monitoring_date
	 */
	public java.util.Date getMonitoringDate () {
		return monitoringDate;
	}

	/**
	 * Set the value related to the column: monitoring_date
	 * @param monitoringDate the monitoring_date value
	 */
	public void setMonitoringDate (java.util.Date monitoringDate) {
		this.monitoringDate = monitoringDate;
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
	 * Return the value associated with the column: ref_batch_no
	 */
	public java.lang.String getRefBatchNo () {
		return refBatchNo;
	}

	/**
	 * Set the value related to the column: ref_batch_no
	 * @param refBatchNo the ref_batch_no value
	 */
	public void setRefBatchNo (java.lang.String refBatchNo) {
		this.refBatchNo = refBatchNo;
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
	 * Return the value associated with the column: refrigerator_id
	 */
	public jkt.hms.masters.business.MasStoreItem getRefrigerator () {
		return refrigerator;
	}

	/**
	 * Set the value related to the column: refrigerator_id
	 * @param refrigerator the refrigerator_id value
	 */
	public void setRefrigerator (jkt.hms.masters.business.MasStoreItem refrigerator) {
		this.refrigerator = refrigerator;
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
	 * Return the value associated with the column: StoreTemperatureMonitoringTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTemperatureMonitoringT> getStoreTemperatureMonitoringTs () {
		return storeTemperatureMonitoringTs;
	}

	/**
	 * Set the value related to the column: StoreTemperatureMonitoringTs
	 * @param storeTemperatureMonitoringTs the StoreTemperatureMonitoringTs value
	 */
	public void setStoreTemperatureMonitoringTs (java.util.Set<jkt.hms.masters.business.StoreTemperatureMonitoringT> storeTemperatureMonitoringTs) {
		this.storeTemperatureMonitoringTs = storeTemperatureMonitoringTs;
	}

	public void addToStoreTemperatureMonitoringTs (jkt.hms.masters.business.StoreTemperatureMonitoringT storeTemperatureMonitoringT) {
		if (null == getStoreTemperatureMonitoringTs()) setStoreTemperatureMonitoringTs(new java.util.TreeSet<jkt.hms.masters.business.StoreTemperatureMonitoringT>());
		getStoreTemperatureMonitoringTs().add(storeTemperatureMonitoringT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTemperatureMonitoringM)) return false;
		else {
			jkt.hms.masters.business.StoreTemperatureMonitoringM storeTemperatureMonitoringM = (jkt.hms.masters.business.StoreTemperatureMonitoringM) obj;
			if (null == this.getId() || null == storeTemperatureMonitoringM.getId()) return false;
			else return (this.getId().equals(storeTemperatureMonitoringM.getId()));
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