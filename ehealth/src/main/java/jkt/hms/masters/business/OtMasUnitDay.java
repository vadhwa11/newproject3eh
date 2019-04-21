package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseOtMasUnitDay;



public class OtMasUnitDay extends BaseOtMasUnitDay {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OtMasUnitDay () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OtMasUnitDay (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public OtMasUnitDay (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.HospitalDoctorUnitM unitM,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String status,
		java.lang.String dayName) {

		super (
			id,
			hospital,
			unitM,
			department,
			status,
			dayName);
	}

/*[CONSTRUCTOR MARKER END]*/


}