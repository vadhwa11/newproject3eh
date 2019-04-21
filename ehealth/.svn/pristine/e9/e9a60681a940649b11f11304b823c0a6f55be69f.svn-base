package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bld_crossmatch_bags_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bld_crossmatch_bags_detail"
 */

public abstract class BaseBldCrossmatchBagsDetail extends jkt.hms.masters.business.BldCrossmatchingHeader  implements Serializable {

	public static String REF = "BldCrossmatchBagsDetail";
	public static String PROP_BAG_NO = "BagNo";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_TUBE_NO = "TubeNo";
	public static String PROP_ID = "Id";
	public static String PROP_CROSS_BAG_ID = "CrossBagId";


	// constructors
	public BaseBldCrossmatchBagsDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBldCrossmatchBagsDetail (java.lang.Integer id) {
		super(id);
	}



	private int hashCode = Integer.MIN_VALUE;


	// fields
	private java.lang.String bagNo;
	private java.lang.String tubeNo;
	private java.math.BigDecimal quantity;
	private java.lang.Long crossBagId;






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
	 * Return the value associated with the column: cross_bag_id
	 */
	public java.lang.Long getCrossBagId () {
		return crossBagId;
	}

	/**
	 * Set the value related to the column: cross_bag_id
	 * @param crossBagId the cross_bag_id value
	 */
	public void setCrossBagId (java.lang.Long crossBagId) {
		this.crossBagId = crossBagId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BldCrossmatchBagsDetail)) return false;
		else {
			jkt.hms.masters.business.BldCrossmatchBagsDetail bldCrossmatchBagsDetail = (jkt.hms.masters.business.BldCrossmatchBagsDetail) obj;
			if (null == this.getId() || null == bldCrossmatchBagsDetail.getId()) return false;
			else return (this.getId().equals(bldCrossmatchBagsDetail.getId()));
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