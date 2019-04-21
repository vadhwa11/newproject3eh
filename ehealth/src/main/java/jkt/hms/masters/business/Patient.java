package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BasePatient;

public class Patient extends BasePatient {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Patient () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Patient (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Patient (
		java.lang.Integer id,
		java.lang.String hinNo) {

		super (
			id,
			hinNo);
	}

	/* [CONSTRUCTOR MARKER END] */

}