package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BasePhStudentRegistration;



public class PhStudentRegistration extends BasePhStudentRegistration {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PhStudentRegistration () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PhStudentRegistration (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PhStudentRegistration (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital) {

		super (
			id,
			hospital);
	}

/*[CONSTRUCTOR MARKER END]*/


}