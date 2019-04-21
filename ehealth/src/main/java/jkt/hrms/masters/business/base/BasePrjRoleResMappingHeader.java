package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_role_res_mapping_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_role_res_mapping_header"
 */

public abstract class BasePrjRoleResMappingHeader  implements Serializable {

	public static String REF = "PrjRoleResMappingHeader";
	public static String PROP_PJR = "Pjr";
	public static String PROP_STATUS = "Status";
	public static String PROP_REQUIRED_RESOURCE = "RequiredResource";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PRJ = "Prj";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE = "Employee";


	// constructors
	public BasePrjRoleResMappingHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjRoleResMappingHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer requiredResource;

	// many to one
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hrms.masters.business.MstrProjectrole pjr;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjRoleResMappingDetail> prjRoleResMappingDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="role_res_mapping_header_id"
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
	 * Return the value associated with the column: required_resource
	 */
	public java.lang.Integer getRequiredResource () {
		return requiredResource;
	}

	/**
	 * Set the value related to the column: required_resource
	 * @param requiredResource the required_resource value
	 */
	public void setRequiredResource (java.lang.Integer requiredResource) {
		this.requiredResource = requiredResource;
	}



	/**
	 * Return the value associated with the column: prj_id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: prj_id
	 * @param prj the prj_id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
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
	 * Return the value associated with the column: pjr_id
	 */
	public jkt.hrms.masters.business.MstrProjectrole getPjr () {
		return pjr;
	}

	/**
	 * Set the value related to the column: pjr_id
	 * @param pjr the pjr_id value
	 */
	public void setPjr (jkt.hrms.masters.business.MstrProjectrole pjr) {
		this.pjr = pjr;
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
	 * Return the value associated with the column: PrjRoleResMappingDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjRoleResMappingDetail> getPrjRoleResMappingDetails () {
		return prjRoleResMappingDetails;
	}

	/**
	 * Set the value related to the column: PrjRoleResMappingDetails
	 * @param prjRoleResMappingDetails the PrjRoleResMappingDetails value
	 */
	public void setPrjRoleResMappingDetails (java.util.Set<jkt.hrms.masters.business.PrjRoleResMappingDetail> prjRoleResMappingDetails) {
		this.prjRoleResMappingDetails = prjRoleResMappingDetails;
	}

	public void addToPrjRoleResMappingDetails (jkt.hrms.masters.business.PrjRoleResMappingDetail prjRoleResMappingDetail) {
		if (null == getPrjRoleResMappingDetails()) setPrjRoleResMappingDetails(new java.util.TreeSet<jkt.hrms.masters.business.PrjRoleResMappingDetail>());
		getPrjRoleResMappingDetails().add(prjRoleResMappingDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjRoleResMappingHeader)) return false;
		else {
			jkt.hrms.masters.business.PrjRoleResMappingHeader prjRoleResMappingHeader = (jkt.hrms.masters.business.PrjRoleResMappingHeader) obj;
			if (null == this.getId() || null == prjRoleResMappingHeader.getId()) return false;
			else return (this.getId().equals(prjRoleResMappingHeader.getId()));
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