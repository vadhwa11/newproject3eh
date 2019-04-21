package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasPassPrintReason;



public class MasPassPrintReason extends BaseMasPassPrintReason {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasPassPrintReason () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasPassPrintReason (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasPassPrintReason (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy) {

		super (
			id,
			lastChgBy);
	}

/*[CONSTRUCTOR MARKER END]*/


}