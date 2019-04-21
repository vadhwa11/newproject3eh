package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseInjAppointmentHeader;



public class InjAppointmentHeader extends BaseInjAppointmentHeader {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public InjAppointmentHeader () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InjAppointmentHeader (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public InjAppointmentHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.Visit visit,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.InpatientPrescriptionHeader inpatientPrescriptionHeader,
		jkt.hms.masters.business.Inpatient inpatient) {

		super (
			id,
			visit,
			hin,
			inpatientPrescriptionHeader,
			inpatient);
	}

/*[CONSTRUCTOR MARKER END]*/


}