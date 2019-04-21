package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseCssdAutoclaveRequestT;

public class CssdAutoclaveRequestT extends BaseCssdAutoclaveRequestT {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CssdAutoclaveRequestT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CssdAutoclaveRequestT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CssdAutoclaveRequestT (
		java.lang.Integer id,
		jkt.hms.masters.business.CssdInstrumentMaster instrument,
		jkt.hms.masters.business.CssdAutoclaveRequestM requestM,
		java.lang.String status) {

		super (
			id,
			instrument,
			requestM,
			status);
	}

	/* [CONSTRUCTOR MARKER END] */

}