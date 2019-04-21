package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHrStudentCertificate;



public class HrStudentCertificate extends BaseHrStudentCertificate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HrStudentCertificate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrStudentCertificate (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrStudentCertificate (
		java.lang.Integer id,
		java.lang.String entryNo,
		java.util.Date date,
		java.lang.String name,
		java.lang.Integer age,
		java.lang.String fitFor,
		java.lang.String caseNo) {

		super (
			id,
			entryNo,
			date,
			name,
			age,
			fitFor,
			caseNo);
	}

/*[CONSTRUCTOR MARKER END]*/


}