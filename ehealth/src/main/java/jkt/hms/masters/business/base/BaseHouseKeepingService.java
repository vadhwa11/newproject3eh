package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the house_keeping_service table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="house_keeping_service"
 */

public abstract class BaseHouseKeepingService  implements Serializable {

	public static String REF = "HouseKeepingService";
	public static String PROP_STATUS = "Status";
	public static String PROP_SERVICE_DATE = "ServiceDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOUSE_KEEPING = "HouseKeeping";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_TIME = "ServiceTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_HOUSE_KEEPING_SETUP = "HouseKeepingSetup";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHouseKeepingService () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHouseKeepingService (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHouseKeepingService (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date serviceDate;
	private java.lang.String serviceTime;
	private java.lang.String status;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.HouseKeepingSetup houseKeepingSetup;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHouseKeeping houseKeeping;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="service_id"
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
	 * Return the value associated with the column: service_date
	 */
	public java.util.Date getServiceDate () {
		return serviceDate;
	}

	/**
	 * Set the value related to the column: service_date
	 * @param serviceDate the service_date value
	 */
	public void setServiceDate (java.util.Date serviceDate) {
		this.serviceDate = serviceDate;
	}



	/**
	 * Return the value associated with the column: service_time
	 */
	public java.lang.String getServiceTime () {
		return serviceTime;
	}

	/**
	 * Set the value related to the column: service_time
	 * @param serviceTime the service_time value
	 */
	public void setServiceTime (java.lang.String serviceTime) {
		this.serviceTime = serviceTime;
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
	 * Return the value associated with the column: house_keeping_setup_id
	 */
	public jkt.hms.masters.business.HouseKeepingSetup getHouseKeepingSetup () {
		return houseKeepingSetup;
	}

	/**
	 * Set the value related to the column: house_keeping_setup_id
	 * @param houseKeepingSetup the house_keeping_setup_id value
	 */
	public void setHouseKeepingSetup (jkt.hms.masters.business.HouseKeepingSetup houseKeepingSetup) {
		this.houseKeepingSetup = houseKeepingSetup;
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
	 * Return the value associated with the column: house_keeping_id
	 */
	public jkt.hms.masters.business.MasHouseKeeping getHouseKeeping () {
		return houseKeeping;
	}

	/**
	 * Set the value related to the column: house_keeping_id
	 * @param houseKeeping the house_keeping_id value
	 */
	public void setHouseKeeping (jkt.hms.masters.business.MasHouseKeeping houseKeeping) {
		this.houseKeeping = houseKeeping;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HouseKeepingService)) return false;
		else {
			jkt.hms.masters.business.HouseKeepingService houseKeepingService = (jkt.hms.masters.business.HouseKeepingService) obj;
			if (null == this.getId() || null == houseKeepingService.getId()) return false;
			else return (this.getId().equals(houseKeepingService.getId()));
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