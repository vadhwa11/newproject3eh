package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_employee_dependent table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_employee_dependent"
 */

public abstract class BaseMasEmployeeDependent  implements Serializable {

	public static String REF = "MasEmployeeDependent";
	public static String PROP_RELATION = "Relation";
	public static String PROP_STATUS = "Status";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EMPLOYEE_DEPENDENT_NAME = "EmployeeDependentName";
	public static String PROP_EMPLOYEE_DEPENDENT_CODE = "EmployeeDependentCode";
	public static String PROP_GENDER = "Gender";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BaseMasEmployeeDependent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmployeeDependent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String employeeDependentCode;
	private java.lang.String employeeDependentName;
	private java.util.Date dateOfBirth;
	private java.lang.String address;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasAdministrativeSex gender;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="employee_dependent_id"
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
	 * Return the value associated with the column: employee_dependent_code
	 */
	public java.lang.String getEmployeeDependentCode () {
		return employeeDependentCode;
	}

	/**
	 * Set the value related to the column: employee_dependent_code
	 * @param employeeDependentCode the employee_dependent_code value
	 */
	public void setEmployeeDependentCode (java.lang.String employeeDependentCode) {
		this.employeeDependentCode = employeeDependentCode;
	}



	/**
	 * Return the value associated with the column: employee_dependent_name
	 */
	public java.lang.String getEmployeeDependentName () {
		return employeeDependentName;
	}

	/**
	 * Set the value related to the column: employee_dependent_name
	 * @param employeeDependentName the employee_dependent_name value
	 */
	public void setEmployeeDependentName (java.lang.String employeeDependentName) {
		this.employeeDependentName = employeeDependentName;
	}



	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * @param dateOfBirth the date_of_birth value
	 */
	public void setDateOfBirth (java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
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
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
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
	 * Return the value associated with the column: gender
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
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
		if (!(obj instanceof jkt.hms.masters.business.MasEmployeeDependent)) return false;
		else {
			jkt.hms.masters.business.MasEmployeeDependent masEmployeeDependent = (jkt.hms.masters.business.MasEmployeeDependent) obj;
			if (null == this.getId() || null == masEmployeeDependent.getId()) return false;
			else return (this.getId().equals(masEmployeeDependent.getId()));
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