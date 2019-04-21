package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_jphn_jhi_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_jphn_jhi_header"
 */

public abstract class BasePhJphnJhiHeader  implements Serializable {

	public static String REF = "PhJphnJhiHeader";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_JPHN_JHI_MONTHS = "JphnJhiMonths";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ASHA_WORKER = "AshaWorker";


	// constructors
	public BasePhJphnJhiHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhJphnJhiHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer jphnJhiMonths;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee ashaWorker;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="jphn_jhi_header_id"
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
	 * Return the value associated with the column: jphn_jhi_months
	 */
	public java.lang.Integer getJphnJhiMonths () {
		return jphnJhiMonths;
	}

	/**
	 * Set the value related to the column: jphn_jhi_months
	 * @param jphnJhiMonths the jphn_jhi_months value
	 */
	public void setJphnJhiMonths (java.lang.Integer jphnJhiMonths) {
		this.jphnJhiMonths = jphnJhiMonths;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: asha_worker
	 */
	public jkt.hms.masters.business.MasEmployee getAshaWorker () {
		return ashaWorker;
	}

	/**
	 * Set the value related to the column: asha_worker
	 * @param ashaWorker the asha_worker value
	 */
	public void setAshaWorker (jkt.hms.masters.business.MasEmployee ashaWorker) {
		this.ashaWorker = ashaWorker;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhJphnJhiHeader)) return false;
		else {
			jkt.hms.masters.business.PhJphnJhiHeader phJphnJhiHeader = (jkt.hms.masters.business.PhJphnJhiHeader) obj;
			if (null == this.getId() || null == phJphnJhiHeader.getId()) return false;
			else return (this.getId().equals(phJphnJhiHeader.getId()));
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