package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_minor_routine_work table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_minor_routine_work"
 */

public abstract class BaseHesMinorRoutineWork  implements Serializable {

	public static String REF = "HesMinorRoutineWork";
	public static String PROP_STATUS = "Status";
	public static String PROP_WORK_PARTICULAR_NAME = "WorkParticularName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EMP_WORK_COMPLETED = "EmpWorkCompleted";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHesMinorRoutineWork () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesMinorRoutineWork (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date entryDate;
	private java.lang.String entryNo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee empWorkCompleted;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.HesWorkParticularMaster workParticularName;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="minorid"
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
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * @param entryDate the entry_date value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
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
	 * Return the value associated with the column: emp_work_completed_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmpWorkCompleted () {
		return empWorkCompleted;
	}

	/**
	 * Set the value related to the column: emp_work_completed_id
	 * @param empWorkCompleted the emp_work_completed_id value
	 */
	public void setEmpWorkCompleted (jkt.hms.masters.business.MasEmployee empWorkCompleted) {
		this.empWorkCompleted = empWorkCompleted;
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
	 * Return the value associated with the column: work_particular_name_id
	 */
	public jkt.hms.masters.business.HesWorkParticularMaster getWorkParticularName () {
		return workParticularName;
	}

	/**
	 * Set the value related to the column: work_particular_name_id
	 * @param workParticularName the work_particular_name_id value
	 */
	public void setWorkParticularName (jkt.hms.masters.business.HesWorkParticularMaster workParticularName) {
		this.workParticularName = workParticularName;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesMinorRoutineWork)) return false;
		else {
			jkt.hms.masters.business.HesMinorRoutineWork hesMinorRoutineWork = (jkt.hms.masters.business.HesMinorRoutineWork) obj;
			if (null == this.getId() || null == hesMinorRoutineWork.getId()) return false;
			else return (this.getId().equals(hesMinorRoutineWork.getId()));
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