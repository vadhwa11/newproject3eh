package jkt.hrms.recruitment.masters.business;

import jkt.hrms.recruitment.masters.business.base.BaseResumeprojectsdetail;

public class Resumeprojectsdetail extends BaseResumeprojectsdetail {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Resumeprojectsdetail() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Resumeprojectsdetail(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Resumeprojectsdetail(java.lang.Integer id,
			jkt.hrms.recruitment.masters.business.Resumedudetail du,
			java.lang.String projectName) {

		super(id, du, projectName);
	}

	/* [CONSTRUCTOR MARKER END] */

}