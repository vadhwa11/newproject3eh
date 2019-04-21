package jkt.hrms.recruitment.masters.business;

import jkt.hrms.recruitment.masters.business.base.BaseResumepersonaldetails;

public class Resumepersonaldetails extends BaseResumepersonaldetails {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Resumepersonaldetails() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Resumepersonaldetails(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Resumepersonaldetails(java.lang.Integer id,
			boolean onSiteAvailability, boolean active) {

		super(id, onSiteAvailability, active);
	}

	/* [CONSTRUCTOR MARKER END] */

}