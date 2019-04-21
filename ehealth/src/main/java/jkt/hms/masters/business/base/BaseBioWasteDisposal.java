package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bio_waste_disposal table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bio_waste_disposal"
 */

public abstract class BaseBioWasteDisposal  implements Serializable {

	public static String REF = "BioWasteDisposal";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_LAS_CHG_DATE = "LasChgDate";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_ID = "Id";
	public static String PROP_HAND_OVER = "HandOver";


	// constructors
	public BaseBioWasteDisposal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBioWasteDisposal (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lasChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasWasteDisposal disposal;
	private jkt.hms.masters.business.BioWasteHandOver handOver;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: las_chg_date
	 */
	public java.util.Date getLasChgDate () {
		return lasChgDate;
	}

	/**
	 * Set the value related to the column: las_chg_date
	 * @param lasChgDate the las_chg_date value
	 */
	public void setLasChgDate (java.util.Date lasChgDate) {
		this.lasChgDate = lasChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: disposal_id
	 */
	public jkt.hms.masters.business.MasWasteDisposal getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: disposal_id
	 * @param disposal the disposal_id value
	 */
	public void setDisposal (jkt.hms.masters.business.MasWasteDisposal disposal) {
		this.disposal = disposal;
	}



	/**
	 * Return the value associated with the column: hand_over_id
	 */
	public jkt.hms.masters.business.BioWasteHandOver getHandOver () {
		return handOver;
	}

	/**
	 * Set the value related to the column: hand_over_id
	 * @param handOver the hand_over_id value
	 */
	public void setHandOver (jkt.hms.masters.business.BioWasteHandOver handOver) {
		this.handOver = handOver;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BioWasteDisposal)) return false;
		else {
			jkt.hms.masters.business.BioWasteDisposal bioWasteDisposal = (jkt.hms.masters.business.BioWasteDisposal) obj;
			if (null == this.getId() || null == bioWasteDisposal.getId()) return false;
			else return (this.getId().equals(bioWasteDisposal.getId()));
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