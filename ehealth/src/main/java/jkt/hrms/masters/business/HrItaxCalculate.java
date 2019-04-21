package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseHrItaxCalculate;



public class HrItaxCalculate extends BaseHrItaxCalculate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HrItaxCalculate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrItaxCalculate (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrItaxCalculate (
		java.lang.Integer id,
		jkt.hrms.masters.business.HrMasFinancialYear finYear,
		jkt.hms.masters.business.MasEmployee employee,
		java.math.BigDecimal totalEarning,
		java.math.BigDecimal totalDeduction) {

		super (
			id,
			finYear,
			employee,
			totalEarning,
			totalDeduction);
	}

/*[CONSTRUCTOR MARKER END]*/


}