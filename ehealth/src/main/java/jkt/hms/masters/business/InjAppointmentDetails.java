package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseInjAppointmentDetails;



public class InjAppointmentDetails extends BaseInjAppointmentDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InjAppointmentDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InjAppointmentDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public InjAppointmentDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item) {

		super (
			id,
			item);
	}

/*[CONSTRUCTOR MARKER END]*/


}