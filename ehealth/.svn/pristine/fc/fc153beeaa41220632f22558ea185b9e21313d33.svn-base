package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_branch table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_branch"
 */

public abstract class BaseMasBranch  implements Serializable {

	public static String REF = "MasBranch";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_BRANCH_DESC = "BranchDesc";
	public static String PROP_BRANCH_CODE = "BranchCode";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasBranch () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBranch (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String branchCode;
	private java.lang.String branchDesc;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="branch_id"
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
	 * Return the value associated with the column: branch_code
	 */
	public java.lang.String getBranchCode () {
		return branchCode;
	}

	/**
	 * Set the value related to the column: branch_code
	 * @param branchCode the branch_code value
	 */
	public void setBranchCode (java.lang.String branchCode) {
		this.branchCode = branchCode;
	}



	/**
	 * Return the value associated with the column: branch_desc
	 */
	public java.lang.String getBranchDesc () {
		return branchDesc;
	}

	/**
	 * Set the value related to the column: branch_desc
	 * @param branchDesc the branch_desc value
	 */
	public void setBranchDesc (java.lang.String branchDesc) {
		this.branchDesc = branchDesc;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBranch)) return false;
		else {
			jkt.hms.masters.business.MasBranch masBranch = (jkt.hms.masters.business.MasBranch) obj;
			if (null == this.getId() || null == masBranch.getId()) return false;
			else return (this.getId().equals(masBranch.getId()));
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