package jkt.hrms.recruitment.masters.business;

import jkt.hrms.recruitment.masters.business.base.BaseResumejobprofile;

public class Resumejobprofile extends BaseResumejobprofile {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Resumejobprofile() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Resumejobprofile(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Resumejobprofile(java.lang.Integer id, java.lang.String jobProfile) {

		super(id, jobProfile);
	}

	/* [CONSTRUCTOR MARKER END] */

}