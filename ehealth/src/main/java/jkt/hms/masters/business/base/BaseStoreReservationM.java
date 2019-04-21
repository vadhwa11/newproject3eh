package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_reservation_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_reservation_m"
 */

public abstract class BaseStoreReservationM  implements Serializable {

	public static String REF = "StoreReservationM";
	public static String PROP_RESERVATION_NO = "ReservationNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_GROUP = "Group";


	// constructors
	public BaseStoreReservationM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreReservationM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String reservationNo;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StoreReservationCampGroup group;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreReservationT> storeReservationTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="reservation_id"
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
	 * Return the value associated with the column: reservation_no
	 */
	public java.lang.String getReservationNo () {
		return reservationNo;
	}

	/**
	 * Set the value related to the column: reservation_no
	 * @param reservationNo the reservation_no value
	 */
	public void setReservationNo (java.lang.String reservationNo) {
		this.reservationNo = reservationNo;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.StoreReservationCampGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param group the group_id value
	 */
	public void setGroup (jkt.hms.masters.business.StoreReservationCampGroup group) {
		this.group = group;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: StoreReservationTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreReservationT> getStoreReservationTs () {
		return storeReservationTs;
	}

	/**
	 * Set the value related to the column: StoreReservationTs
	 * @param storeReservationTs the StoreReservationTs value
	 */
	public void setStoreReservationTs (java.util.Set<jkt.hms.masters.business.StoreReservationT> storeReservationTs) {
		this.storeReservationTs = storeReservationTs;
	}

	public void addToStoreReservationTs (jkt.hms.masters.business.StoreReservationT storeReservationT) {
		if (null == getStoreReservationTs()) setStoreReservationTs(new java.util.TreeSet<jkt.hms.masters.business.StoreReservationT>());
		getStoreReservationTs().add(storeReservationT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreReservationM)) return false;
		else {
			jkt.hms.masters.business.StoreReservationM storeReservationM = (jkt.hms.masters.business.StoreReservationM) obj;
			if (null == this.getId() || null == storeReservationM.getId()) return false;
			else return (this.getId().equals(storeReservationM.getId()));
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