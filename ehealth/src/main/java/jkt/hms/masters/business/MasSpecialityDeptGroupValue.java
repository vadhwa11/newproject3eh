package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseMasSpecialityDeptGroupValue;



public class MasSpecialityDeptGroupValue extends BaseMasSpecialityDeptGroupValue {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasSpecialityDeptGroupValue () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasSpecialityDeptGroupValue (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasSpecialityDeptGroupValue (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasSpecialityDeptGroup deptGroup,
		java.lang.String type,
		java.lang.String status) {

		super (
			id,
			hospital,
			deptGroup,
			type,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}