package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_requeststatusmaster
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_requeststatusmaster"
 */

public abstract class BaseRequestStatusMaster implements Serializable {

	public static String REF = "RequestStatusMaster";
	public static String PROP_STATUS_DESC = "StatusDesc";
	public static String PROP_ID = "Id";

	// constructors
	public BaseRequestStatusMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRequestStatusMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String statusDesc;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="status_id"
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
	 * Return the value associated with the column: status_desc
	 */
	public java.lang.String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * Set the value related to the column: status_desc
	 * 
	 * @param statusDesc
	 *            the status_desc value
	 */
	public void setStatusDesc(java.lang.String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.RequestStatusMaster)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster = (jkt.hrms.recruitment.masters.business.RequestStatusMaster) obj;
			if (null == this.getId() || null == requestStatusMaster.getId()) {
				return false;
			} else {
				return (this.getId().equals(requestStatusMaster.getId()));
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