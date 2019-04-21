package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_equipment_maintenance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_equipment_maintenance"
 */

public abstract class BaseHesEquipmentMaintenance  implements Serializable {

	public static String REF = "HesEquipmentMaintenance";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_MAINTENANCE = "Maintenance";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE = "Date";
	public static String PROP_SCHEDULE_DATE = "ScheduleDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_SCHEDULE_TIME = "ScheduleTime";


	// constructors
	public BaseHesEquipmentMaintenance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEquipmentMaintenance (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date date;
	private java.util.Date scheduleDate;
	private java.lang.String scheduleTime;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.HesMaintenanceJobMaster maintenance;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.HesEquipmentMaster equipment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="hes_maintenance_id"
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: schedule_date
	 */
	public java.util.Date getScheduleDate () {
		return scheduleDate;
	}

	/**
	 * Set the value related to the column: schedule_date
	 * @param scheduleDate the schedule_date value
	 */
	public void setScheduleDate (java.util.Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}



	/**
	 * Return the value associated with the column: schedule_time
	 */
	public java.lang.String getScheduleTime () {
		return scheduleTime;
	}

	/**
	 * Set the value related to the column: schedule_time
	 * @param scheduleTime the schedule_time value
	 */
	public void setScheduleTime (java.lang.String scheduleTime) {
		this.scheduleTime = scheduleTime;
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
	 * Return the value associated with the column: maintenance_id
	 */
	public jkt.hms.masters.business.HesMaintenanceJobMaster getMaintenance () {
		return maintenance;
	}

	/**
	 * Set the value related to the column: maintenance_id
	 * @param maintenance the maintenance_id value
	 */
	public void setMaintenance (jkt.hms.masters.business.HesMaintenanceJobMaster maintenance) {
		this.maintenance = maintenance;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.HesEquipmentMaster getEquipment () {
		return equipment;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * @param equipment the equipment_id value
	 */
	public void setEquipment (jkt.hms.masters.business.HesEquipmentMaster equipment) {
		this.equipment = equipment;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesEquipmentMaintenance)) return false;
		else {
			jkt.hms.masters.business.HesEquipmentMaintenance hesEquipmentMaintenance = (jkt.hms.masters.business.HesEquipmentMaintenance) obj;
			if (null == this.getId() || null == hesEquipmentMaintenance.getId()) return false;
			else return (this.getId().equals(hesEquipmentMaintenance.getId()));
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