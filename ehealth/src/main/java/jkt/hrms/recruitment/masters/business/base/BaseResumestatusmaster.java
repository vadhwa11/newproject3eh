package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumestatusmaster
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumestatusmaster"
 */

public abstract class BaseResumestatusmaster implements Serializable {

	public static String REF = "Resumestatusmaster";
	public static String PROP_STATUS_DESC = "StatusDesc";
	public static String PROP_ID = "Id";

	// constructors
	public BaseResumestatusmaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumestatusmaster(java.lang.Integer id) {
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
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumestatusmaster)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumestatusmaster resumestatusmaster = (jkt.hrms.recruitment.masters.business.Resumestatusmaster) obj;
			if (null == this.getId() || null == resumestatusmaster.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumestatusmaster.getId()));
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