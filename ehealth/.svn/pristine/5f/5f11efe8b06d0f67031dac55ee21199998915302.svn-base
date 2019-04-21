package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_waste_disposal table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_waste_disposal"
 */

public abstract class BaseMasWasteDisposal  implements Serializable {

	public static String REF = "MasWasteDisposal";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAS_CHG_DATE = "LasChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_WASTE_DISPOSAL_NAME = "WasteDisposalName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_WASTE_DISPOSAL_CODE = "WasteDisposalCode";


	// constructors
	public BaseMasWasteDisposal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasWasteDisposal (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String wasteDisposalCode;
	private java.lang.String wasteDisposalName;
	private java.lang.String status;
	private java.util.Date lasChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



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
	 * Return the value associated with the column: waste_disposal_code
	 */
	public java.lang.String getWasteDisposalCode () {
		return wasteDisposalCode;
	}

	/**
	 * Set the value related to the column: waste_disposal_code
	 * @param wasteDisposalCode the waste_disposal_code value
	 */
	public void setWasteDisposalCode (java.lang.String wasteDisposalCode) {
		this.wasteDisposalCode = wasteDisposalCode;
	}



	/**
	 * Return the value associated with the column: waste_disposal_name
	 */
	public java.lang.String getWasteDisposalName () {
		return wasteDisposalName;
	}

	/**
	 * Set the value related to the column: waste_disposal_name
	 * @param wasteDisposalName the waste_disposal_name value
	 */
	public void setWasteDisposalName (java.lang.String wasteDisposalName) {
		this.wasteDisposalName = wasteDisposalName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasWasteDisposal)) return false;
		else {
			jkt.hms.masters.business.MasWasteDisposal masWasteDisposal = (jkt.hms.masters.business.MasWasteDisposal) obj;
			if (null == this.getId() || null == masWasteDisposal.getId()) return false;
			else return (this.getId().equals(masWasteDisposal.getId()));
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