package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bld_crossmatch_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bld_crossmatch_detail"
 */

public abstract class BaseBldCrossmatchDetail  implements Serializable {

	public static String REF = "BldCrossmatchDetail";
	public static String PROP_BAG_NO = "BagNo";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_BLD_CROSS_BAG = "BldCrossBag";
	public static String PROP_INVESTIGATION_RESULT = "InvestigationResult";
	public static String PROP_TUBE_NO = "TubeNo";
	public static String PROP_ID = "Id";
	public static String PROP_STOCK_DETAIL = "StockDetail";
	public static String PROP_BLD_CROSSMATCHING_HEADER = "BldCrossmatchingHeader";


	// constructors
	public BaseBldCrossmatchDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBldCrossmatchDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String investigationResult;
	private java.lang.String bagNo;
	private java.lang.String tubeNo;

	// many to one
	private jkt.hms.masters.business.BldCrossmatchingHeader bldCrossmatchingHeader;
	private jkt.hms.masters.business.DgMasInvestigation investigation;
	private jkt.hms.masters.business.BldCrossmatchBagDetail bldCrossBag;
	private jkt.hms.masters.business.BloodStockDetail stockDetail;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="cross_match_detail_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: investigation_result
	 */
	public java.lang.String getInvestigationResult () {
		return investigationResult;
	}

	/**
	 * Set the value related to the column: investigation_result
	 * @param investigationResult the investigation_result value
	 */
	public void setInvestigationResult (java.lang.String investigationResult) {
		this.investigationResult = investigationResult;
	}



	/**
	 * Return the value associated with the column: bag_no
	 */
	public java.lang.String getBagNo () {
		return bagNo;
	}

	/**
	 * Set the value related to the column: bag_no
	 * @param bagNo the bag_no value
	 */
	public void setBagNo (java.lang.String bagNo) {
		this.bagNo = bagNo;
	}



	/**
	 * Return the value associated with the column: tube_no
	 */
	public java.lang.String getTubeNo () {
		return tubeNo;
	}

	/**
	 * Set the value related to the column: tube_no
	 * @param tubeNo the tube_no value
	 */
	public void setTubeNo (java.lang.String tubeNo) {
		this.tubeNo = tubeNo;
	}



	/**
	 * Return the value associated with the column: bld_crossmatching_header_id
	 */
	public jkt.hms.masters.business.BldCrossmatchingHeader getBldCrossmatchingHeader () {
		return bldCrossmatchingHeader;
	}

	/**
	 * Set the value related to the column: bld_crossmatching_header_id
	 * @param bldCrossmatchingHeader the bld_crossmatching_header_id value
	 */
	public void setBldCrossmatchingHeader (jkt.hms.masters.business.BldCrossmatchingHeader bldCrossmatchingHeader) {
		this.bldCrossmatchingHeader = bldCrossmatchingHeader;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigation the investigation_id value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: bld_cross_bag_id
	 */
	public jkt.hms.masters.business.BldCrossmatchBagDetail getBldCrossBag () {
		return bldCrossBag;
	}

	/**
	 * Set the value related to the column: bld_cross_bag_id
	 * @param bldCrossBag the bld_cross_bag_id value
	 */
	public void setBldCrossBag (jkt.hms.masters.business.BldCrossmatchBagDetail bldCrossBag) {
		this.bldCrossBag = bldCrossBag;
	}



	/**
	 * Return the value associated with the column: stock_detail_id
	 */
	public jkt.hms.masters.business.BloodStockDetail getStockDetail () {
		return stockDetail;
	}

	/**
	 * Set the value related to the column: stock_detail_id
	 * @param stockDetail the stock_detail_id value
	 */
	public void setStockDetail (jkt.hms.masters.business.BloodStockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BldCrossmatchDetail)) return false;
		else {
			jkt.hms.masters.business.BldCrossmatchDetail bldCrossmatchDetail = (jkt.hms.masters.business.BldCrossmatchDetail) obj;
			if (null == this.getId() || null == bldCrossmatchDetail.getId()) return false;
			else return (this.getId().equals(bldCrossmatchDetail.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}