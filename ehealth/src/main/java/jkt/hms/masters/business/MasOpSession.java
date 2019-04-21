package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasOpSession;



public class MasOpSession extends BaseMasOpSession {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasOpSession () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasOpSession (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasOpSession (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}