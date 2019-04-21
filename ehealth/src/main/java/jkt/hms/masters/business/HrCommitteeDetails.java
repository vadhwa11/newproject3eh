package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHrCommitteeDetails;



public class HrCommitteeDetails extends BaseHrCommitteeDetails {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HrCommitteeDetails () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrCommitteeDetails (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrCommitteeDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.HrCommitteeHeader committee) {

		super (
			id,
			lastChgBy,
			hospital,
			committee);
	}

/*[CONSTRUCTOR MARKER END]*/


}