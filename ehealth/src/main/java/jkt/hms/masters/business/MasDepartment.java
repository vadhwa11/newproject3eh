package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasDepartment;

public class MasDepartment extends BaseMasDepartment {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasDepartment () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasDepartment (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasDepartment (
		java.lang.Integer id,
		java.lang.String departmentCode) {

		super (
			id,
			departmentCode);
	}

	/* [CONSTRUCTOR MARKER END] */

}