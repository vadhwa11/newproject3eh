package jkt.hms.masters.business;


import jkt.hms.masters.business.base.BaseCssdTemplateInstrument;



public class CssdTemplateInstrument extends BaseCssdTemplateInstrument {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CssdTemplateInstrument () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CssdTemplateInstrument (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CssdTemplateInstrument (
		java.lang.Integer id,
		jkt.hms.masters.business.CssdInstrumentMaster instrument,
		jkt.hms.masters.business.OpdTemplate template) {

		super (
			id,
			instrument,
			template);
	}

/*[CONSTRUCTOR MARKER END]*/


}