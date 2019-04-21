package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BasePrjBudgetSet;



public class PrjBudgetSet extends BasePrjBudgetSet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PrjBudgetSet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PrjBudgetSet (java.lang.Integer budId) {
		super(budId);
	}

	/**
	 * Constructor for required fields
	 */
	public PrjBudgetSet (
		java.lang.Integer budId,
		java.lang.Integer budPrjId,
		java.lang.Integer budTypeId,
		java.lang.Integer budSubhId,
		java.lang.Integer budTaskId,
		java.lang.Float reqHours,
		java.lang.Integer reqResource,
		java.math.BigDecimal costPerHour,
		java.lang.Integer curId,
		java.lang.Integer createdBy,
		java.util.Date createdAt,
		java.lang.Integer modifiedBy,
		java.util.Date modifiedAt,
		java.math.BigDecimal totCost,
		java.math.BigDecimal totResHours) {

		super (
			budId,
			budPrjId,
			budTypeId,
			budSubhId,
			budTaskId,
			reqHours,
			reqResource,
			costPerHour,
			curId,
			createdBy,
			createdAt,
			modifiedBy,
			modifiedAt,
			totCost,
			totResHours);
	}

/*[CONSTRUCTOR MARKER END]*/


}