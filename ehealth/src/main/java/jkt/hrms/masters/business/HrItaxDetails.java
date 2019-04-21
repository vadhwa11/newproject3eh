package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseHrItaxDetails;



public class HrItaxDetails extends BaseHrItaxDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HrItaxDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrItaxDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrItaxDetails (
		java.lang.Integer id,
		jkt.hrms.masters.business.HrItaxHeader itaxHeader) {

		super (
			id,
			itaxHeader);
	}

/*[CONSTRUCTOR MARKER END]*/


}