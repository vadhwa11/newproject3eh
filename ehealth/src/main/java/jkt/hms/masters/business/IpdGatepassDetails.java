package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseIpdGatepassDetails;



public class IpdGatepassDetails extends BaseIpdGatepassDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public IpdGatepassDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public IpdGatepassDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public IpdGatepassDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasPassPrintReason printReason,
		jkt.hms.masters.business.MasPassType passType) {

		super (
			id,
			lastChgBy,
			printReason,
			passType);
	}

/*[CONSTRUCTOR MARKER END]*/


}