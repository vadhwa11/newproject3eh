package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_emp_status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_emp_status"
 */

public abstract class BaseMasEmpStatus  implements Serializable {

	public static String REF = "MasEmpStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EMP_STATUS_CODE = "EmpStatusCode";
	public static String PROP_EMP_STATUS_NAME = "EmpStatusName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasEmpStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmpStatus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String empStatusCode;
	private java.lang.String empStatusName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="emp_status_id"
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
	 * Return the value associated with the column: emp_status_code
	 */
	public java.lang.String getEmpStatusCode () {
		return empStatusCode;
	}

	/**
	 * Set the value related to the column: emp_status_code
	 * @param empStatusCode the emp_status_code value
	 */
	public void setEmpStatusCode (java.lang.String empStatusCode) {
		this.empStatusCode = empStatusCode;
	}



	/**
	 * Return the value associated with the column: emp_status_name
	 */
	public java.lang.String getEmpStatusName () {
		return empStatusName;
	}

	/**
	 * Set the value related to the column: emp_status_name
	 * @param empStatusName the emp_status_name value
	 */
	public void setEmpStatusName (java.lang.String empStatusName) {
		this.empStatusName = empStatusName;
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
		if (!(obj instanceof jkt.hms.masters.business.MasEmpStatus)) return false;
		else {
			jkt.hms.masters.business.MasEmpStatus masEmpStatus = (jkt.hms.masters.business.MasEmpStatus) obj;
			if (null == this.getId() || null == masEmpStatus.getId()) return false;
			else return (this.getId().equals(masEmpStatus.getId()));
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