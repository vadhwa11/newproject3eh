package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasDietCombination;

public class MasDietCombination extends BaseMasDietCombination {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public MasDietCombination () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasDietCombination (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasDietCombination (
		java.lang.Integer id,
		java.lang.Float dietQuantity) {

		super (
			id,
			dietQuantity);
	}

	/* [CONSTRUCTOR MARKER END] */

}