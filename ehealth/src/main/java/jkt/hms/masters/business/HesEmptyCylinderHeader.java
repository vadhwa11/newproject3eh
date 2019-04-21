package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseHesEmptyCylinderHeader;



public class HesEmptyCylinderHeader extends BaseHesEmptyCylinderHeader {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public HesEmptyCylinderHeader () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public HesEmptyCylinderHeader (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public HesEmptyCylinderHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasEmployee acMen,
		java.lang.String entryNo,
		java.util.Date entryDate,
		java.lang.String challanNo,
		java.util.Date challanDate,
		java.lang.String vehicleNo,
		java.lang.String status,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		super (
			id,
			lastChgBy,
			acMen,
			entryNo,
			entryDate,
			challanNo,
			challanDate,
			vehicleNo,
			status,
			lastChgDate,
			lastChgTime);
	}

/*[CONSTRUCTOR MARKER END]*/


}