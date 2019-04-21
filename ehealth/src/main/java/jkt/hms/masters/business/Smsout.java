package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseSmsout;



public class Smsout extends BaseSmsout {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Smsout () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Smsout (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Smsout (
		java.lang.Integer id,
		java.lang.String message,
		java.lang.String status,
		java.lang.String sentTime,
		java.util.Date sentDate,
		java.lang.String mobileNo) {

		super (
			id,
			message,
			status,
			sentTime,
			sentDate,
			mobileNo);
	}

/*[CONSTRUCTOR MARKER END]*/


}