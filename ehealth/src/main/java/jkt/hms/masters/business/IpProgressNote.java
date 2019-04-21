package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseIpProgressNote;



public class IpProgressNote extends BaseIpProgressNote {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public IpProgressNote () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public IpProgressNote (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public IpProgressNote (
		java.lang.Integer id,
		jkt.hms.masters.business.Inpatient inpatient) {

		super (
			id,
			inpatient);
	}

/*[CONSTRUCTOR MARKER END]*/


}