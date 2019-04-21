package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_termination_process table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_termination_process"
 */

public abstract class BaseHrTerminationProcess  implements Serializable {

	public static String REF = "HrTerminationProcess";
	public static String PROP_ACTION_BY = "ActionBy";
	public static String PROP_ORDER_DATE = "OrderDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FROM_INSTITUTE = "FromInstitute";
	public static String PROP_TERMINATION_MODE = "TerminationMode";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SUSPENSION_PERIOD = "SuspensionPeriod";
	public static String PROP_STATUS = "Status";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SUSPENSION_PERIOD_UNIT = "SuspensionPeriodUnit";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";
	public static String PROP_REASON = "Reason";


	// constructors
	public BaseHrTerminationProcess () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTerminationProcess (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String terminationMode;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.String reason;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date orderDate;
	private int suspensionPeriod;
	private java.lang.String suspensionPeriodUnit;
	private java.lang.String orderNo;

	// many to one
	private jkt.hms.masters.business.MasEmployee actionBy;
	private jkt.hms.masters.business.MasEmployee employeeId;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital fromInstitute;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="process_id"
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
	 * Return the value associated with the column: termination_mode
	 */
	public java.lang.String getTerminationMode () {
		return terminationMode;
	}

	/**
	 * Set the value related to the column: termination_mode
	 * @param terminationMode the termination_mode value
	 */
	public void setTerminationMode (java.lang.String terminationMode) {
		this.terminationMode = terminationMode;
	}



	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
	}



	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
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
	 * Return the value associated with the column: order_date
	 */
	public java.util.Date getOrderDate () {
		return orderDate;
	}

	/**
	 * Set the value related to the column: order_date
	 * @param orderDate the order_date value
	 */
	public void setOrderDate (java.util.Date orderDate) {
		this.orderDate = orderDate;
	}



	/**
	 * Return the value associated with the column: suspension_period
	 */
	public int getSuspensionPeriod () {
		return suspensionPeriod;
	}

	/**
	 * Set the value related to the column: suspension_period
	 * @param suspensionPeriod the suspension_period value
	 */
	public void setSuspensionPeriod (int suspensionPeriod) {
		this.suspensionPeriod = suspensionPeriod;
	}



	/**
	 * Return the value associated with the column: suspension_period_unit
	 */
	public java.lang.String getSuspensionPeriodUnit () {
		return suspensionPeriodUnit;
	}

	/**
	 * Set the value related to the column: suspension_period_unit
	 * @param suspensionPeriodUnit the suspension_period_unit value
	 */
	public void setSuspensionPeriodUnit (java.lang.String suspensionPeriodUnit) {
		this.suspensionPeriodUnit = suspensionPeriodUnit;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.String getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.String orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: action_by
	 */
	public jkt.hms.masters.business.MasEmployee getActionBy () {
		return actionBy;
	}

	/**
	 * Set the value related to the column: action_by
	 * @param actionBy the action_by value
	 */
	public void setActionBy (jkt.hms.masters.business.MasEmployee actionBy) {
		this.actionBy = actionBy;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (jkt.hms.masters.business.MasEmployee employeeId) {
		this.employeeId = employeeId;
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
	 * Return the value associated with the column: from_institute
	 */
	public jkt.hms.masters.business.MasHospital getFromInstitute () {
		return fromInstitute;
	}

	/**
	 * Set the value related to the column: from_institute
	 * @param fromInstitute the from_institute value
	 */
	public void setFromInstitute (jkt.hms.masters.business.MasHospital fromInstitute) {
		this.fromInstitute = fromInstitute;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrTerminationProcess)) return false;
		else {
			jkt.hms.masters.business.HrTerminationProcess hrTerminationProcess = (jkt.hms.masters.business.HrTerminationProcess) obj;
			if (null == this.getId() || null == hrTerminationProcess.getId()) return false;
			else return (this.getId().equals(hrTerminationProcess.getId()));
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