package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreWorkOrderM;

public class StoreWorkOrderM extends BaseStoreWorkOrderM {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreWorkOrderM() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreWorkOrderM(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreWorkOrderM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String workOrderNo, java.util.Date workOrderDate,
			java.lang.String repairingCell, java.lang.String authorityNo,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime, java.lang.String status) {

		super(id, hospital, department, workOrderNo, workOrderDate,
				repairingCell, authorityNo, lastChgBy, lastChgDate,
				lastChgTime, status);
	}

	/* [CONSTRUCTOR MARKER END] */

}