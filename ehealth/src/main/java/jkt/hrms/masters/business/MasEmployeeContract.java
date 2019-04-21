package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseMasEmployeeContract;

public class MasEmployeeContract extends BaseMasEmployeeContract {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasEmployeeContract () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasEmployeeContract (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasEmployeeContract (
		java.lang.Integer id,
		jkt.hms.masters.business.MasEmployee employee) {

		super (
			id,
			employee);
	}

	/* [CONSTRUCTOR MARKER END] */

}