package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BasePhVillageSurvey;



public class PhVillageSurvey extends BasePhVillageSurvey {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PhVillageSurvey () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PhVillageSurvey (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PhVillageSurvey (
		java.lang.Integer id,
		java.lang.Long surveyUniqueId) {

		super (
			id,
			surveyUniqueId);
	}

/*[CONSTRUCTOR MARKER END]*/


}