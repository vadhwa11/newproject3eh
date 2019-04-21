package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreTemperatureMonitoringT;



public class StoreTemperatureMonitoringT extends BaseStoreTemperatureMonitoringT {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public StoreTemperatureMonitoringT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreTemperatureMonitoringT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreTemperatureMonitoringT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreTemperatureMonitoringM monitoringM) {

		super (
			id,
			monitoringM);
	}

/*[CONSTRUCTOR MARKER END]*/


}