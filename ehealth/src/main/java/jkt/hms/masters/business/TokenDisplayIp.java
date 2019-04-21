package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseTokenDisplayIp;



public class TokenDisplayIp extends BaseTokenDisplayIp {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TokenDisplayIp () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TokenDisplayIp (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TokenDisplayIp (
		java.lang.Integer id,
		java.lang.String displayName) {

		super (
			id,
			displayName);
	}

/*[CONSTRUCTOR MARKER END]*/


}