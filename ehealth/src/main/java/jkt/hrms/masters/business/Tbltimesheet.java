package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseTbltimesheet;



public class Tbltimesheet extends BaseTbltimesheet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Tbltimesheet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Tbltimesheet (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Tbltimesheet (
		java.lang.Integer id,
		java.math.BigDecimal hrsWorked,
		java.lang.Integer totalMin) {

		super (
			id,
			hrsWorked,
			totalMin);
	}

/*[CONSTRUCTOR MARKER END]*/


}