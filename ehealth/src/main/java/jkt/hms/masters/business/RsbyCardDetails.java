package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseRsbyCardDetails;



public class RsbyCardDetails extends BaseRsbyCardDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public RsbyCardDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public RsbyCardDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public RsbyCardDetails (
		java.lang.Integer id,
		java.lang.String rsbyCardNo,
		java.math.BigDecimal balanceUtilized,
		java.lang.String status) {

		super (
			id,
			rsbyCardNo,
			balanceUtilized,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}