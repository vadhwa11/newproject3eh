package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the department_refset table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="department_refset"
 */

public abstract class BaseDepartmentRefset  implements Serializable {

	public static String REF = "DepartmentRefset";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_REFSET_ID = "RefsetId";
	public static String PROP_REFSET_DESC = "RefsetDesc";


	// constructors
	public BaseDepartmentRefset () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDepartmentRefset (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long refsetId;
	private java.lang.String refsetDesc;

	// many to one
	private jkt.hms.masters.business.MasEmployeeDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: refset_id
	 */
	public java.lang.Long getRefsetId () {
		return refsetId;
	}

	/**
	 * Set the value related to the column: refset_id
	 * @param refsetId the refset_id value
	 */
	public void setRefsetId (java.lang.Long refsetId) {
		this.refsetId = refsetId;
	}



	/**
	 * Return the value associated with the column: refset_desc
	 */
	public java.lang.String getRefsetDesc () {
		return refsetDesc;
	}

	/**
	 * Set the value related to the column: refset_desc
	 * @param refsetDesc the refset_desc value
	 */
	public void setRefsetDesc (java.lang.String refsetDesc) {
		this.refsetDesc = refsetDesc;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasEmployeeDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasEmployeeDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DepartmentRefset)) return false;
		else {
			jkt.hms.masters.business.DepartmentRefset departmentRefset = (jkt.hms.masters.business.DepartmentRefset) obj;
			if (null == this.getId() || null == departmentRefset.getId()) return false;
			else return (this.getId().equals(departmentRefset.getId()));
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