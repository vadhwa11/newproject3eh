package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreEmpanelledBillingM;



public class StoreEmpanelledBillingM extends BaseStoreEmpanelledBillingM {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public StoreEmpanelledBillingM () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreEmpanelledBillingM (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreEmpanelledBillingM (
		java.lang.Integer id,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.PatientPrescriptionHeader prescription) {

		super (
			id,
			hin,
			prescription);
	}

/*[CONSTRUCTOR MARKER END]*/


}