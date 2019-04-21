package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseEtrTrvsubAttach;



public class EtrTrvsubAttach extends BaseEtrTrvsubAttach {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EtrTrvsubAttach () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public EtrTrvsubAttach (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public EtrTrvsubAttach (
		java.lang.Integer id,
		java.lang.Integer dsExpid,
		java.lang.String dsOfilename,
		java.lang.String dsDfilename,
		java.lang.String dsDesc) {

		super (
			id,
			dsExpid,
			dsOfilename,
			dsDfilename,
			dsDesc);
	}

/*[CONSTRUCTOR MARKER END]*/


}