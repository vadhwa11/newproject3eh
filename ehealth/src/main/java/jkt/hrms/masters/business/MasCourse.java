package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseMasCourse;

public class MasCourse extends BaseMasCourse {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasCourse() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasCourse(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasCourse(java.lang.Integer id, java.lang.String courseCode) {

		super(id, courseCode);
	}

	/* [CONSTRUCTOR MARKER END] */

}