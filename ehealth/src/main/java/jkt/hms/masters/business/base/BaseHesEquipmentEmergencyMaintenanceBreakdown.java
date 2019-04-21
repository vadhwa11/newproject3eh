package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_equipment_emergency_maintenance_breakdown table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_equipment_emergency_maintenance_breakdown"
 */

public abstract class BaseHesEquipmentEmergencyMaintenanceBreakdown  implements Serializable {

	public static String REF = "HesEquipmentEmergencyMaintenanceBreakdown";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_NATURE_OF_REPAIRS_CARRIED_OUT = "NatureOfRepairsCarriedOut";
	public static String PROP_TIME_OF_COMPLETE_BREAKD = "TimeOfCompleteBreakd";
	public static String PROP_SERVICED_BY = "ServicedBy";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHesEquipmentEmergencyMaintenanceBreakdown () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEquipmentEmergencyMaintenanceBreakdown (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.lang.String actionTaken;
	private java.lang.String natureOfRepairsCarriedOut;
	private java.lang.String timeOfCompleteBreakd;
	private java.lang.String servicedBy;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.HesEquipmentBreakdownEntry equipmentBreakdownEntry;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="equipment_emergency_id"
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
	 * Return the value associated with the column: time_of_complete_breakd
	 */
	public java.lang.String getTimeOfCompleteBreakd () {
		return timeOfCompleteBreakd;
	}

	/**
	 * Set the value related to the column: time_of_complete_breakd
	 * @param timeOfCompleteBreakd the time_of_complete_breakd value
	 */
	public void setTimeOfCompleteBreakd (java.lang.String timeOfCompleteBreakd) {
		this.timeOfCompleteBreakd = timeOfCompleteBreakd;
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
	 * Return the value associated with the column: equpment_break_id
	 */
	public jkt.hms.masters.business.HesEquipmentBreakdownEntry getEquipmentBreakdownEntry () {
		return equipmentBreakdownEntry;
	}

	/**
	 * Set the value related to the column: equpment_break_id
	 * @param equipmentBreakdownEntry the equpment_break_id value
	 */
	public void setEquipmentBreakdownEntry (jkt.hms.masters.business.HesEquipmentBreakdownEntry equipmentBreakdownEntry) {
		this.equipmentBreakdownEntry = equipmentBreakdownEntry;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown)) return false;
		else {
			jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown hesEquipmentEmergencyMaintenanceBreakdown = (jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown) obj;
			if (null == this.getId() || null == hesEquipmentEmergencyMaintenanceBreakdown.getId()) return false;
			else return (this.getId().equals(hesEquipmentEmergencyMaintenanceBreakdown.getId()));
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