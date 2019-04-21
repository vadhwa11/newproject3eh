package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreSlowMovingDrugs;



public class StoreSlowMovingDrugs extends BaseStoreSlowMovingDrugs {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public StoreSlowMovingDrugs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreSlowMovingDrugs (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreSlowMovingDrugs (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasStoreItem item,
		java.lang.String itemCode,
		java.lang.String itemName) {

		super (
			id,
			hospital,
			item,
			itemCode,
			itemName);
	}

/*[CONSTRUCTOR MARKER END]*/


}