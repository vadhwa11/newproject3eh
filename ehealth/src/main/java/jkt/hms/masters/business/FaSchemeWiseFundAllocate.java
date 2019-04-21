package jkt.hms.masters.business;

import jkt.hms.masters.business.base.BaseFaSchemeWiseFundAllocate;



public class FaSchemeWiseFundAllocate extends BaseFaSchemeWiseFundAllocate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FaSchemeWiseFundAllocate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FaSchemeWiseFundAllocate (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FaSchemeWiseFundAllocate (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasStoreFinancial fYear,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasScheme scheme,
		java.math.BigDecimal sanctionedAmt,
		java.math.BigDecimal spentAmt,
		java.math.BigDecimal unspentAmt,
		java.lang.String status) {

		super (
			id,
			lastChgBy,
			fYear,
			hospital,
			scheme,
			sanctionedAmt,
			spentAmt,
			unspentAmt,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}