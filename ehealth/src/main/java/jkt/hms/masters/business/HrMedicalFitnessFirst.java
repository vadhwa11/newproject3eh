package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHrMedicalFitnessFirst;



public class HrMedicalFitnessFirst extends BaseHrMedicalFitnessFirst {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HrMedicalFitnessFirst () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrMedicalFitnessFirst (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrMedicalFitnessFirst (
		java.lang.Integer id,
		java.lang.String entryNo,
		java.util.Date date,
		java.lang.String regNo,
		java.lang.String name,
		java.lang.String forEmployInOffice) {

		super (
			id,
			entryNo,
			date,
			regNo,
			name,
			forEmployInOffice);
	}

/*[CONSTRUCTOR MARKER END]*/


}