package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHesEmptyCylinderDetail;



public class HesEmptyCylinderDetail extends BaseHesEmptyCylinderDetail {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HesEmptyCylinderDetail () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HesEmptyCylinderDetail (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HesEmptyCylinderDetail (
		java.lang.Integer id,
		jkt.hms.masters.business.HesEmptyCylinderHeader cylinderHeader,
		jkt.hms.masters.business.HesCylinderTypeMaster cylinderid,
		java.lang.Integer quantity,
		java.lang.String status) {

		super (
			id,
			cylinderHeader,
			cylinderid,
			quantity,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}