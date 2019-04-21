package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_maintenance_job_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_maintenance_job_master"
 */

public abstract class BaseHesMaintenanceJobMaster  implements Serializable {

	public static String REF = "HesMaintenanceJobMaster";
	public static String PROP_MAINTENANCE_CODE = "MaintenanceCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_MAINTENANCE_NAME = "MaintenanceName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHesMaintenanceJobMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesMaintenanceJobMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String maintenanceCode;
	private java.lang.String maintenanceName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="maintenance_id"
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
	 * Return the value associated with the column: maintenance_code
	 */
	public java.lang.String getMaintenanceCode () {
		return maintenanceCode;
	}

	/**
	 * Set the value related to the column: maintenance_code
	 * @param maintenanceCode the maintenance_code value
	 */
	public void setMaintenanceCode (java.lang.String maintenanceCode) {
		this.maintenanceCode = maintenanceCode;
	}



	/**
	 * Return the value associated with the column: maintenance_name
	 */
	public java.lang.String getMaintenanceName () {
		return maintenanceName;
	}

	/**
	 * Set the value related to the column: maintenance_name
	 * @param maintenanceName the maintenance_name value
	 */
	public void setMaintenanceName (java.lang.String maintenanceName) {
		this.maintenanceName = maintenanceName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesMaintenanceJobMaster)) return false;
		else {
			jkt.hms.masters.business.HesMaintenanceJobMaster hesMaintenanceJobMaster = (jkt.hms.masters.business.HesMaintenanceJobMaster) obj;
			if (null == this.getId() || null == hesMaintenanceJobMaster.getId()) return false;
			else return (this.getId().equals(hesMaintenanceJobMaster.getId()));
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