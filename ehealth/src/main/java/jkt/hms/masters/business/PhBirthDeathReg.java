package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BasePhBirthDeathReg;



public class PhBirthDeathReg extends BasePhBirthDeathReg {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PhBirthDeathReg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PhBirthDeathReg (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PhBirthDeathReg (
		java.lang.Integer id,
		jkt.hms.masters.business.PhMemberSurvey member) {

		super (
			id,
			member);
	}

/*[CONSTRUCTOR MARKER END]*/


}