package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseHrMasApplicationLevel;

public class HrMasApplicationLevel extends BaseHrMasApplicationLevel {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public HrMasApplicationLevel () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrMasApplicationLevel (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrMasApplicationLevel (
		java.lang.Integer id,
		java.lang.String applicationId) {

		super (
			id,
			applicationId);
	}

	/* [CONSTRUCTOR MARKER END] */

}