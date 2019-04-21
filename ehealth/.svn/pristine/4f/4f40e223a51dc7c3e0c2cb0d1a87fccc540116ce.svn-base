package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_employee_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_employee_history"
 */

public abstract class BaseMasEmployeeHistory  implements Serializable {

	public static String REF = "MasEmployeeHistory";
	public static String PROP_DESIGNATION_FROM_DATE = "DesignationFromDate";
	public static String PROP_RANK = "Rank";
	public static String PROP_EMPLOYEE_STATUS = "EmployeeStatus";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_TRANSFER_DATE = "TransferDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_MODE = "Mode";
	public static String PROP_DESIGNATION_TO_DATE = "DesignationToDate";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseMasEmployeeHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmployeeHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date appointmentDate;
	private java.util.Date designationFromDate;
	private java.util.Date designationToDate;
	private java.util.Date transferDate;
	private java.lang.String mode;

	// many to one
	private jkt.hms.masters.business.MasEmpStatus employeeStatus;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="emp_his_id"
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
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * @param appointmentDate the appointment_date value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	/**
	 * Return the value associated with the column: designation_from_date
	 */
	public java.util.Date getDesignationFromDate () {
		return designationFromDate;
	}

	/**
	 * Set the value related to the column: designation_from_date
	 * @param designationFromDate the designation_from_date value
	 */
	public void setDesignationFromDate (java.util.Date designationFromDate) {
		this.designationFromDate = designationFromDate;
	}



	/**
	 * Return the value associated with the column: designation_to_date
	 */
	public java.util.Date getDesignationToDate () {
		return designationToDate;
	}

	/**
	 * Set the value related to the column: designation_to_date
	 * @param designationToDate the designation_to_date value
	 */
	public void setDesignationToDate (java.util.Date designationToDate) {
		this.designationToDate = designationToDate;
	}



	/**
	 * Return the value associated with the column: transfer_date
	 */
	public java.util.Date getTransferDate () {
		return transferDate;
	}

	/**
	 * Set the value related to the column: transfer_date
	 * @param transferDate the transfer_date value
	 */
	public void setTransferDate (java.util.Date transferDate) {
		this.transferDate = transferDate;
	}



	/**
	 * Return the value associated with the column: history_mode
	 */
	public java.lang.String getMode () {
		return mode;
	}

	/**
	 * Set the value related to the column: history_mode
	 * @param mode the history_mode value
	 */
	public void setMode (java.lang.String mode) {
		this.mode = mode;
	}



	/**
	 * Return the value associated with the column: employee_status_id
	 */
	public jkt.hms.masters.business.MasEmpStatus getEmployeeStatus () {
		return employeeStatus;
	}

	/**
	 * Set the value related to the column: employee_status_id
	 * @param employeeStatus the employee_status_id value
	 */
	public void setEmployeeStatus (jkt.hms.masters.business.MasEmpStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasEmployeeHistory)) return false;
		else {
			jkt.hms.masters.business.MasEmployeeHistory masEmployeeHistory = (jkt.hms.masters.business.MasEmployeeHistory) obj;
			if (null == this.getId() || null == masEmployeeHistory.getId()) return false;
			else return (this.getId().equals(masEmployeeHistory.getId()));
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