package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseBudVoucherReceiptEntry;



public class BudVoucherReceiptEntry extends BaseBudVoucherReceiptEntry {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BudVoucherReceiptEntry () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BudVoucherReceiptEntry (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BudVoucherReceiptEntry (
		java.lang.Integer id,
		jkt.hms.masters.business.BudMajorHead majorHead,
		jkt.hms.masters.business.BudSubMajorHead majorSubHead,
		jkt.hms.masters.business.BudMinorHead minorbHead,
		jkt.hms.masters.business.BudMinorSubHead minorSubHead,
		jkt.hms.masters.business.BudObjectHead objectHead,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.BudEstimateEntry budgetEstimate,
		jkt.hrms.masters.business.HrMasFinancialYear financial) {

		super (
			id,
			majorHead,
			majorSubHead,
			minorbHead,
			minorSubHead,
			objectHead,
			hospital,
			budgetEstimate,
			financial);
	}

/*[CONSTRUCTOR MARKER END]*/


}