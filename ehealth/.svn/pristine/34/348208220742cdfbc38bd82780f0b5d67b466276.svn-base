package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_temperature_monitoring_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_temperature_monitoring_t"
 */

public abstract class BaseStoreTemperatureMonitoringT  implements Serializable {

	public static String REF = "StoreTemperatureMonitoringT";
	public static String PROP_MONITORING_M = "MonitoringM";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_ID = "Id";
	public static String PROP_MONITORING_TIME = "MonitoringTime";


	// constructors
	public BaseStoreTemperatureMonitoringT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTemperatureMonitoringT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreTemperatureMonitoringT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreTemperatureMonitoringM monitoringM) {

		this.setId(id);
		this.setMonitoringM(monitoringM);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String monitoringTime;
	private java.math.BigDecimal temperature;

	// many to one
	private jkt.hms.masters.business.StoreTemperatureMonitoringM monitoringM;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="monitoring_t_id"
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
	 * Return the value associated with the column: monitoring_time
	 */
	public java.lang.String getMonitoringTime () {
		return monitoringTime;
	}

	/**
	 * Set the value related to the column: monitoring_time
	 * @param monitoringTime the monitoring_time value
	 */
	public void setMonitoringTime (java.lang.String monitoringTime) {
		this.monitoringTime = monitoringTime;
	}



	/**
	 * Return the value associated with the column: temperature
	 */
	public java.math.BigDecimal getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * @param temperature the temperature value
	 */
	public void setTemperature (java.math.BigDecimal temperature) {
		this.temperature = temperature;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreTemperatureMonitoringT)) return false;
		else {
			jkt.hms.masters.business.StoreTemperatureMonitoringT storeTemperatureMonitoringT = (jkt.hms.masters.business.StoreTemperatureMonitoringT) obj;
			if (null == this.getId() || null == storeTemperatureMonitoringT.getId()) return false;
			else return (this.getId().equals(storeTemperatureMonitoringT.getId()));
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