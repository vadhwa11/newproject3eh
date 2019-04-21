package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreEmpanelledBillingT;



public class StoreEmpanelledBillingT extends BaseStoreEmpanelledBillingT {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public StoreEmpanelledBillingT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreEmpanelledBillingT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreEmpanelledBillingT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item,
		jkt.hms.masters.business.StoreEmpanelledBillingM emBillingM) {

		super (
			id,
			item,
			emBillingM);
	}

/*[CONSTRUCTOR MARKER END]*/


}