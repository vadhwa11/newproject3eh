package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseInpatient;



public class Inpatient extends BaseInpatient {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Inpatient () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Inpatient (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Inpatient (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.Patient hin) {

		super (
			id,
			department,
			hospital,
			hin);
	}

/*[CONSTRUCTOR MARKER END]*/


}