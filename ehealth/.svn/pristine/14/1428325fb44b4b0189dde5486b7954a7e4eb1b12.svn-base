package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_equipment_breakdown_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_equipment_breakdown_entry"
 */

public abstract class BaseHesEquipmentBreakdownEntry  implements Serializable {

	public static String REF = "HesEquipmentBreakdownEntry";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_EMPLOYEE_ID_FROM = "EmployeeIdFrom";
	public static String PROP_NATURE_OF_BREAKDOWN = "NatureOfBreakdown";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TIME_OF_BREAKDOWN = "TimeOfBreakdown";
	public static String PROP_DATE = "Date";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_BREAKDOWN = "DateOfBreakdown";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE_ID_TO = "EmployeeIdTo";


	// constructors
	public BaseHesEquipmentBreakdownEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEquipmentBreakdownEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHesEquipmentBreakdownEntry (
		java.lang.Integer id,
		jkt.hms.masters.business.MasEmployee employeeIdTo,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasEmployee employeeIdFrom,
		jkt.hms.masters.business.HesEquipmentMaster equipment) {

		this.setId(id);
		this.setEmployeeIdTo(employeeIdTo);
		this.setDepartment(department);
		this.setEmployeeIdFrom(employeeIdFrom);
		this.setEquipment(equipment);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date date;
	private java.lang.String natureOfBreakdown;
	private java.util.Date dateOfBreakdown;
	private java.lang.String timeOfBreakdown;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee employeeIdTo;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee employeeIdFrom;
	private jkt.hms.masters.business.HesEquipmentMaster equipment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="equpment_break_id"
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
	 * Return the value associated with the column: nature_of_breakdown
	 */
	public java.lang.String getNatureOfBreakdown () {
		return natureOfBreakdown;
	}

	/**
	 * Set the value related to the column: nature_of_breakdown
	 * @param natureOfBreakdown the nature_of_breakdown value
	 */
	public void setNatureOfBreakdown (java.lang.String natureOfBreakdown) {
		this.natureOfBreakdown = natureOfBreakdown;
	}



	/**
	 * Return the value associated with the column: date_of_breakdown
	 */
	public java.util.Date getDateOfBreakdown () {
		return dateOfBreakdown;
	}

	/**
	 * Set the value related to the column: date_of_breakdown
	 * @param dateOfBreakdown the date_of_breakdown value
	 */
	public void setDateOfBreakdown (java.util.Date dateOfBreakdown) {
		this.dateOfBreakdown = dateOfBreakdown;
	}



	/**
	 * Return the value associated with the column: time_of_breakdown
	 */
	public java.lang.String getTimeOfBreakdown () {
		return timeOfBreakdown;
	}

	/**
	 * Set the value related to the column: time_of_breakdown
	 * @param timeOfBreakdown the time_of_breakdown value
	 */
	public void setTimeOfBreakdown (java.lang.String timeOfBreakdown) {
		this.timeOfBreakdown = timeOfBreakdown;
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
	 * Return the value associated with the column: employee_id_to
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeIdTo () {
		return employeeIdTo;
	}

	/**
	 * Set the value related to the column: employee_id_to
	 * @param employeeIdTo the employee_id_to value
	 */
	public void setEmployeeIdTo (jkt.hms.masters.business.MasEmployee employeeIdTo) {
		this.employeeIdTo = employeeIdTo;
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
	 * Return the value associated with the column: employee_id_from
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeIdFrom () {
		return employeeIdFrom;
	}

	/**
	 * Set the value related to the column: employee_id_from
	 * @param employeeIdFrom the employee_id_from value
	 */
	public void setEmployeeIdFrom (jkt.hms.masters.business.MasEmployee employeeIdFrom) {
		this.employeeIdFrom = employeeIdFrom;
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
		if (!(obj instanceof jkt.hms.masters.business.HesEquipmentBreakdownEntry)) return false;
		else {
			jkt.hms.masters.business.HesEquipmentBreakdownEntry hesEquipmentBreakdownEntry = (jkt.hms.masters.business.HesEquipmentBreakdownEntry) obj;
			if (null == this.getId() || null == hesEquipmentBreakdownEntry.getId()) return false;
			else return (this.getId().equals(hesEquipmentBreakdownEntry.getId()));
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