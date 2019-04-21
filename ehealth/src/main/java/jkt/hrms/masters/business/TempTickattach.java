package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseTempTickattach;



public class TempTickattach extends BaseTempTickattach {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TempTickattach () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TempTickattach (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TempTickattach (
		java.lang.Integer id,
		jkt.hrms.masters.business.EtrTravelreq tdsaDsid,
		jkt.hms.masters.business.MasEmployee tdsaUserid,
		java.lang.String tdsaOfilename,
		java.lang.String tdsaDfilename) {

		super (
			id,
			tdsaDsid,
			tdsaUserid,
			tdsaOfilename,
			tdsaDfilename);
	}

/*[CONSTRUCTOR MARKER END]*/


}