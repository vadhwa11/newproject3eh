package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasActionTaken;



public class MasActionTaken extends BaseMasActionTaken {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasActionTaken () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasActionTaken (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasActionTaken (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}