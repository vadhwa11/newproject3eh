package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_reservation_camp_group table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_reservation_camp_group"
 */

public abstract class BaseStoreReservationCampGroup  implements Serializable {

	public static String REF = "StoreReservationCampGroup";
	public static String PROP_STATUS = "Status";
	public static String PROP_PHN = "Phn";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GROUP_NAME = "GroupName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MO = "Mo";


	// constructors
	public BaseStoreReservationCampGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreReservationCampGroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String groupName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee mo;
	private jkt.hms.masters.business.MasEmployee phn;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreReservationJphn> storeReservationJphns;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="group_id"
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
	 * Return the value associated with the column: group_name
	 */
	public java.lang.String getGroupName () {
		return groupName;
	}

	/**
	 * Set the value related to the column: group_name
	 * @param groupName the group_name value
	 */
	public void setGroupName (java.lang.String groupName) {
		this.groupName = groupName;
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
	 * Return the value associated with the column: mo_id
	 */
	public jkt.hms.masters.business.MasEmployee getMo () {
		return mo;
	}

	/**
	 * Set the value related to the column: mo_id
	 * @param mo the mo_id value
	 */
	public void setMo (jkt.hms.masters.business.MasEmployee mo) {
		this.mo = mo;
	}



	/**
	 * Return the value associated with the column: phn_id
	 */
	public jkt.hms.masters.business.MasEmployee getPhn () {
		return phn;
	}

	/**
	 * Set the value related to the column: phn_id
	 * @param phn the phn_id value
	 */
	public void setPhn (jkt.hms.masters.business.MasEmployee phn) {
		this.phn = phn;
	}



	/**
	 * Return the value associated with the column: StoreReservationJphns
	 */
	public java.util.Set<jkt.hms.masters.business.StoreReservationJphn> getStoreReservationJphns () {
		return storeReservationJphns;
	}

	/**
	 * Set the value related to the column: StoreReservationJphns
	 * @param storeReservationJphns the StoreReservationJphns value
	 */
	public void setStoreReservationJphns (java.util.Set<jkt.hms.masters.business.StoreReservationJphn> storeReservationJphns) {
		this.storeReservationJphns = storeReservationJphns;
	}

	public void addToStoreReservationJphns (jkt.hms.masters.business.StoreReservationJphn storeReservationJphn) {
		if (null == getStoreReservationJphns()) setStoreReservationJphns(new java.util.TreeSet<jkt.hms.masters.business.StoreReservationJphn>());
		getStoreReservationJphns().add(storeReservationJphn);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreReservationCampGroup)) return false;
		else {
			jkt.hms.masters.business.StoreReservationCampGroup storeReservationCampGroup = (jkt.hms.masters.business.StoreReservationCampGroup) obj;
			if (null == this.getId() || null == storeReservationCampGroup.getId()) return false;
			else return (this.getId().equals(storeReservationCampGroup.getId()));
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