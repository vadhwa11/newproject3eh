package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the multi_department_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="multi_department_mapping"
 */

public abstract class BaseMultiDepartmentMapping  implements Serializable {

	public static String REF = "MultiDepartmentMapping";
	public static String PROP_STATUS = "Status";
	public static String PROP_ID = "Id";
	public static String PROP_SERVICE_CENTER = "ServiceCenter";
	public static String PROP_PARENT_SERVICE_CENTER = "ParentServiceCenter";


	// constructors
	public BaseMultiDepartmentMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMultiDepartmentMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasInstituteDepartment parentServiceCenter;
	private jkt.hms.masters.business.MasInstituteDepartment serviceCenter;



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
	 * Return the value associated with the column: parent_service_center_id
	 */
	public jkt.hms.masters.business.MasInstituteDepartment getParentServiceCenter () {
		return parentServiceCenter;
	}

	/**
	 * Set the value related to the column: parent_service_center_id
	 * @param parentServiceCenter the parent_service_center_id value
	 */
	public void setParentServiceCenter (jkt.hms.masters.business.MasInstituteDepartment parentServiceCenter) {
		this.parentServiceCenter = parentServiceCenter;
	}



	/**
	 * Return the value associated with the column: service_center_id
	 */
	public jkt.hms.masters.business.MasInstituteDepartment getServiceCenter () {
		return serviceCenter;
	}

	/**
	 * Set the value related to the column: service_center_id
	 * @param serviceCenter the service_center_id value
	 */
	public void setServiceCenter (jkt.hms.masters.business.MasInstituteDepartment serviceCenter) {
		this.serviceCenter = serviceCenter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MultiDepartmentMapping)) return false;
		else {
			jkt.hms.masters.business.MultiDepartmentMapping multiDepartmentMapping = (jkt.hms.masters.business.MultiDepartmentMapping) obj;
			if (null == this.getId() || null == multiDepartmentMapping.getId()) return false;
			else return (this.getId().equals(multiDepartmentMapping.getId()));
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