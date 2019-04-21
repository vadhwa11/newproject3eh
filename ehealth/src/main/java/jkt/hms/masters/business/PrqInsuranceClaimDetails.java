package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BasePrqInsuranceClaimDetails;



public class PrqInsuranceClaimDetails extends BasePrqInsuranceClaimDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PrqInsuranceClaimDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PrqInsuranceClaimDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PrqInsuranceClaimDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.PrqInsuranceDetails insurance) {

		super (
			id,
			insurance);
	}

/*[CONSTRUCTOR MARKER END]*/


}