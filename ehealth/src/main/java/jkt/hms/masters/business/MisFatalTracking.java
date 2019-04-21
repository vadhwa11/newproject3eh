package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMisFatalTracking;

public class MisFatalTracking extends BaseMisFatalTracking {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MisFatalTracking() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MisFatalTracking(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MisFatalTracking(java.lang.Integer id,
			jkt.hms.masters.business.Inpatient inpatient,
			jkt.hms.masters.business.Patient hin) {

		super(id, inpatient, hin);
	}

	/* [CONSTRUCTOR MARKER END] */

}