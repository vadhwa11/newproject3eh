package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHrPatientFitnessCertificate;



public class HrPatientFitnessCertificate extends BaseHrPatientFitnessCertificate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HrPatientFitnessCertificate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrPatientFitnessCertificate (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrPatientFitnessCertificate (
		java.lang.Integer id,
		java.lang.String entryNo,
		java.util.Date date,
		java.lang.String regNo,
		java.lang.String name,
		java.util.Date resumeDate,
		java.lang.String caseNo) {

		super (
			id,
			entryNo,
			date,
			regNo,
			name,
			resumeDate,
			caseNo);
	}

/*[CONSTRUCTOR MARKER END]*/


}