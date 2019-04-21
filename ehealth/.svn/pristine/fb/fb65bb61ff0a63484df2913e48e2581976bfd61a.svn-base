package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_mas_locality table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_mas_locality"
 */

public abstract class BasePhMasLocality  implements Serializable {

	public static String REF = "PhMasLocality";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WARD = "Ward";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_LOCALITY_NAME = "LocalityName";
	public static String PROP_LSG = "Lsg";//govind code 12-72016


	// constructors
	public BasePhMasLocality () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhMasLocality (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String localityName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasWard ward;
	private jkt.hms.masters.business.MasLsg lsg;//govind code



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="locality_id"
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
	 * Return the value associated with the column: locality_name
	 */
	public java.lang.String getLocalityName () {
		return localityName;
	}

	/**
	 * Set the value related to the column: locality_name
	 * @param localityName the locality_name value
	 */
	public void setLocalityName (java.lang.String localityName) {
		this.localityName = localityName;
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
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
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
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasWard getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasWard ward) {
		this.ward = ward;
	}
//govind code 12-7-2016
	/**
	 * Return the value associated with the column: lsg_id
	 */
	public jkt.hms.masters.business.MasLsg getLsg () {
		return lsg;
	}

	/**
	 * Set the value related to the column: lsg_id
	 * @param lsg the lsg_id value
	 */
	public void setLsg (jkt.hms.masters.business.MasLsg lsg) {
		this.lsg = lsg;
	}
	//end code 12-7-2016


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhMasLocality)) return false;
		else {
			jkt.hms.masters.business.PhMasLocality phMasLocality = (jkt.hms.masters.business.PhMasLocality) obj;
			if (null == this.getId() || null == phMasLocality.getId()) return false;
			else return (this.getId().equals(phMasLocality.getId()));
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