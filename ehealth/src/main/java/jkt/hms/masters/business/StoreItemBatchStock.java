package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreItemBatchStock;



public class StoreItemBatchStock extends BaseStoreItemBatchStock {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public StoreItemBatchStock () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreItemBatchStock (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreItemBatchStock (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item) {

		super (
			id,
			item);
	}

/*[CONSTRUCTOR MARKER END]*/


}