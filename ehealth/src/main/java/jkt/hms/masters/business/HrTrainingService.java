package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHrTrainingService;



public class HrTrainingService extends BaseHrTrainingService {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HrTrainingService () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrTrainingService (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrTrainingService (
		java.lang.Integer id,
		java.lang.String entryNumber,
		java.util.Date date,
		java.lang.String name) {

		super (
			id,
			entryNumber,
			date,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}