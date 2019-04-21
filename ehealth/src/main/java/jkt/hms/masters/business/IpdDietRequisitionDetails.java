package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseIpdDietRequisitionDetails;



public class IpdDietRequisitionDetails extends BaseIpdDietRequisitionDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public IpdDietRequisitionDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public IpdDietRequisitionDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public IpdDietRequisitionDetails (
		java.lang.Integer id,
		java.lang.String issueStatus) {

		super (
			id,
			issueStatus);
	}

/*[CONSTRUCTOR MARKER END]*/


}