package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bld_crossmatch_bag_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bld_crossmatch_bag_detail"
 */

public abstract class BaseBldCrossmatchBagDetail  implements Serializable {

	public static String REF = "BldCrossmatchBagDetail";
	public static String PROP_BAG_NO = "BagNo";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_TUBE_NO = "TubeNo";
	public static String PROP_ID = "Id";
	public static String PROP_BLD_CROSSMATCHING_HEADER = "BldCrossmatchingHeader";


	// constructors
	public BaseBldCrossmatchBagDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBldCrossmatchBagDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bagNo;
	private java.lang.String tubeNo;
	private java.math.BigDecimal quantity;

	// many to one
	private jkt.hms.masters.business.BldCrossmatchingHeader bldCrossmatchingHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="cross_bag_id"
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
	 * Return the value associated with the column: quantity
	 */
	public java.math.BigDecimal getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.math.BigDecimal quantity) {
		this.quantity = quantity;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BldCrossmatchBagDetail)) return false;
		else {
			jkt.hms.masters.business.BldCrossmatchBagDetail bldCrossmatchBagDetail = (jkt.hms.masters.business.BldCrossmatchBagDetail) obj;
			if (null == this.getId() || null == bldCrossmatchBagDetail.getId()) return false;
			else return (this.getId().equals(bldCrossmatchBagDetail.getId()));
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