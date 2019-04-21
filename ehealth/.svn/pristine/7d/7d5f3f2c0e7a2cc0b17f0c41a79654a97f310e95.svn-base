package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_emergency_equipment_breakdown table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_emergency_equipment_breakdown"
 */

public abstract class BaseHesEmergencyEquipmentBreakdown  implements Serializable {

	public static String REF = "HesEmergencyEquipmentBreakdown";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_TIME_OF_COMPLETE_BREAKDOWN = "TimeOfCompleteBreakdown";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_EMPLOYEE_TO = "EmployeeTo";
	public static String PROP_EQUIPMENT_MASTER = "EquipmentMaster";
	public static String PROP_NATURE_OF_BREAKDOWN = "NatureOfBreakdown";
	public static String PROP_NATURE_OF_REPAIRS_CARRIED_OUT = "NatureOfRepairsCarriedOut";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TIME_OF_BREAKDOWN = "TimeOfBreakdown";
	public static String PROP_DATE = "Date";
	public static String PROP_EMPLOYEE_FROM = "EmployeeFrom";
	public static String PROP_SERVICED_BY = "ServicedBy";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_BREAKDOWN = "DateOfBreakdown";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHesEmergencyEquipmentBreakdown () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEmergencyEquipmentBreakdown (java.lang.Integer id) {
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
	private java.lang.String natureOfBreakdown;
	private java.util.Date dateOfBreakdown;
	private java.lang.String timeOfBreakdown;
	private java.lang.String remarks;
	private java.lang.String actionTaken;
	private java.lang.String natureOfRepairsCarriedOut;
	private java.util.Date timeOfCompleteBreakdown;
	private java.lang.String servicedBy;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.HesEquipmentMaster equipmentMaster;
	private jkt.hms.masters.business.MasEmployee employeeTo;
	private jkt.hms.masters.business.MasEmployee employeeFrom;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="equpment_emergency_id"
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
	 * Return the value associated with the column: action_taken
	 */
	public java.lang.String getActionTaken () {
		return actionTaken;
	}

	/**
	 * Set the value related to the column: action_taken
	 * @param actionTaken the action_taken value
	 */
	public void setActionTaken (java.lang.String actionTaken) {
		this.actionTaken = actionTaken;
	}



	/**
	 * Return the value associated with the column: nature_of_repairs_carried_out
	 */
	public java.lang.String getNatureOfRepairsCarriedOut () {
		return natureOfRepairsCarriedOut;
	}

	/**
	 * Set the value related to the column: nature_of_repairs_carried_out
	 * @param natureOfRepairsCarriedOut the nature_of_repairs_carried_out value
	 */
	public void setNatureOfRepairsCarriedOut (java.lang.String natureOfRepairsCarriedOut) {
		this.natureOfRepairsCarriedOut = natureOfRepairsCarriedOut;
	}



	/**
	 * Return the value associated with the column: time_of_complete_breakdown
	 */
	public java.util.Date getTimeOfCompleteBreakdown () {
		return timeOfCompleteBreakdown;
	}

	/**
	 * Set the value related to the column: time_of_complete_breakdown
	 * @param timeOfCompleteBreakdown the time_of_complete_breakdown value
	 */
	public void setTimeOfCompleteBreakdown (java.util.Date timeOfCompleteBreakdown) {
		this.timeOfCompleteBreakdown = timeOfCompleteBreakdown;
	}



	/**
	 * Return the value associated with the column: serviced_by
	 */
	public java.lang.String getServicedBy () {
		return servicedBy;
	}

	/**
	 * Set the value related to the column: serviced_by
	 * @param servicedBy the serviced_by value
	 */
	public void setServicedBy (java.lang.String servicedBy) {
		this.servicedBy = servicedBy;
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
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.HesEquipmentMaster getEquipmentMaster () {
		return equipmentMaster;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * @param equipmentMaster the equipment_id value
	 */
	public void setEquipmentMaster (jkt.hms.masters.business.HesEquipmentMaster equipmentMaster) {
		this.equipmentMaster = equipmentMaster;
	}



	/**
	 * Return the value associated with the column: employee_id_to
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeTo () {
		return employeeTo;
	}

	/**
	 * Set the value related to the column: employee_id_to
	 * @param employeeTo the employee_id_to value
	 */
	public void setEmployeeTo (jkt.hms.masters.business.MasEmployee employeeTo) {
		this.employeeTo = employeeTo;
	}



	/**
	 * Return the value associated with the column: employee_id_from
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeFrom () {
		return employeeFrom;
	}

	/**
	 * Set the value related to the column: employee_id_from
	 * @param employeeFrom the employee_id_from value
	 */
	public void setEmployeeFrom (jkt.hms.masters.business.MasEmployee employeeFrom) {
		this.employeeFrom = employeeFrom;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesEmergencyEquipmentBreakdown)) return false;
		else {
			jkt.hms.masters.business.HesEmergencyEquipmentBreakdown hesEmergencyEquipmentBreakdown = (jkt.hms.masters.business.HesEmergencyEquipmentBreakdown) obj;
			if (null == this.getId() || null == hesEmergencyEquipmentBreakdown.getId()) return false;
			else return (this.getId().equals(hesEmergencyEquipmentBreakdown.getId()));
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