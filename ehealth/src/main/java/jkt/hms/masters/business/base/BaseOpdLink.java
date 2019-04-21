package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_link table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="opd_link"
 */

public abstract class BaseOpdLink implements Serializable {

	public static String REF = "OpdLink";
	public static String PROP_FLAG = "Flag";
	public static String PROP_URL = "Url";
	public static String PROP_DEPARTMENT_TYPE = "DepartmentType";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdLink() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdLink(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String url;
	private java.lang.String flag;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDepartmentType departmentType;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl() {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * 
	 * @param url
	 *            the url value
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag() {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * 
	 * @param flag
	 *            the flag value
	 */
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: department_type_id
	 */
	public jkt.hms.masters.business.MasDepartmentType getDepartmentType() {
		return departmentType;
	}

	/**
	 * Set the value related to the column: department_type_id
	 * 
	 * @param departmentType
	 *            the department_type_id value
	 */
	public void setDepartmentType(
			jkt.hms.masters.business.MasDepartmentType departmentType) {
		this.departmentType = departmentType;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.OpdLink)) {
			return false;
		} else {
			jkt.hms.masters.business.OpdLink opdLink = (jkt.hms.masters.business.OpdLink) obj;
			if (null == this.getId() || null == opdLink.getId()) {
				return false;
			} else {
				return (this.getId().equals(opdLink.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}