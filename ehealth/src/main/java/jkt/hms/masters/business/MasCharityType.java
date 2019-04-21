package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasCharityType;



public class MasCharityType extends BaseMasCharityType {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasCharityType () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasCharityType (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasCharityType (
		java.lang.Integer id,
		java.lang.String status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}