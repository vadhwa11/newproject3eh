package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHospitalDoctorUnitT;



public class HospitalDoctorUnitT extends BaseHospitalDoctorUnitT {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HospitalDoctorUnitT () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HospitalDoctorUnitT (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HospitalDoctorUnitT (
		java.lang.Integer id,
		jkt.hms.masters.business.HospitalDoctorUnitM unitM,
		jkt.hms.masters.business.MasEmployee employee,
		java.lang.String status) {

		super (
			id,
			unitM,
			employee,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}