package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseMasJob;

public class MasJob extends BaseMasJob {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasJob() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasJob(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasJob(java.lang.Integer id, java.lang.String jobCode) {

		super(id, jobCode);
	}

	/* [CONSTRUCTOR MARKER END] */

}