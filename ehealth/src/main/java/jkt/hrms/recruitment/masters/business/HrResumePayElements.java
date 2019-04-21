package jkt.hrms.recruitment.masters.business;

import jkt.hrms.recruitment.masters.business.base.BaseHrResumePayElements;

public class HrResumePayElements extends BaseHrResumePayElements {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public HrResumePayElements() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HrResumePayElements(java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HrResumePayElements(java.lang.Integer id,
			jkt.hrms.masters.business.HrMasPayElement payElement,
			jkt.hrms.recruitment.masters.business.Resumepersonaldetails resume,
			java.lang.String lastChgBy) {

		super(id, payElement, resume, lastChgBy);
	}

	/* [CONSTRUCTOR MARKER END] */

}