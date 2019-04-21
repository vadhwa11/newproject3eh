package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseStoreOpPatientIssueT;

public class StoreOpPatientIssueT extends BaseStoreOpPatientIssueT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public StoreOpPatientIssueT() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public StoreOpPatientIssueT(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public StoreOpPatientIssueT(java.lang.Integer id,
			jkt.hms.masters.business.MasStoreItem itemIdRequire,
			jkt.hms.masters.business.MasStoreItem itemIdIssue,
			jkt.hms.masters.business.StoreOpPatientIssueM opIssue,
			jkt.hms.masters.business.MasStoreBrand brand,
			java.lang.String batchNo, java.util.Date expiryDate,
			java.math.BigDecimal qtyIssued) {

		super(id, itemIdRequire, itemIdIssue, opIssue, brand, batchNo,
				expiryDate, qtyIssued);
	}

	/* [CONSTRUCTOR MARKER END] */

}