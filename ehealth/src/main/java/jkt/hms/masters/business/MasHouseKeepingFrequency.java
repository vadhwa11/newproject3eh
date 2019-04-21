package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasHouseKeepingFrequency;



public class MasHouseKeepingFrequency extends BaseMasHouseKeepingFrequency {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasHouseKeepingFrequency () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasHouseKeepingFrequency (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasHouseKeepingFrequency (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}