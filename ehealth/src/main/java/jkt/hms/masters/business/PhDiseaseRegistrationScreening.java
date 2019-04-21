package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BasePhDiseaseRegistrationScreening;



public class PhDiseaseRegistrationScreening extends BasePhDiseaseRegistrationScreening {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PhDiseaseRegistrationScreening () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PhDiseaseRegistrationScreening (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PhDiseaseRegistrationScreening (
		java.lang.Integer id,
		java.util.Date followDate) {

		super (
			id,
			followDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}