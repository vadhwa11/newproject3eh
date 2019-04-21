package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMmRequestConfig;



public class MmRequestConfig extends BaseMmRequestConfig {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MmRequestConfig () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MmRequestConfig (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MmRequestConfig (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}