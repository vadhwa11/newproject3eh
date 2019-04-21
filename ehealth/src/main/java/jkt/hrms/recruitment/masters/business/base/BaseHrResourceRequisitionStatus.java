package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_resource_requisition_status table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="hr_resource_requisition_status"
 */

public abstract class BaseHrResourceRequisitionStatus implements Serializable {

	public static String REF = "HrResourceRequisitionStatus";
	public static String PROP_CURRENT_LEVEL = "CurrentLevel";
	public static String PROP_RESOURCE_REQUISITION = "ResourceRequisition";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_REQUEST_STATUS_MASTER = "RequestStatusMaster";
	public static String PROP_ID = "Id";
	public static String PROP_MAS_EMPLOYEE = "MasEmployee";
	public static String PROP_ACTION_DATE = "ActionDate";

	// constructors
	public BaseHrResourceRequisitionStatus() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrResourceRequisitionStatus(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer currentLevel;
	private java.util.Date actionDate;
	private java.lang.String comments;

	// one to one
	private jkt.hrms.recruitment.masters.business.ResourceRequisition resourceRequisition;

	// many to one
	private jkt.hms.masters.business.MasEmployee masEmployee;
	private jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="foreign" column="requisition_id"
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
	 * Return the value associated with the column: current_level
	 */
	public java.lang.Integer getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Set the value related to the column: current_level
	 * 
	 * @param currentLevel
	 *            the current_level value
	 */
	public void setCurrentLevel(java.lang.Integer currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * Return the value associated with the column: action_date
	 */
	public java.util.Date getActionDate() {
		return actionDate;
	}

	/**
	 * Set the value related to the column: action_date
	 * 
	 * @param actionDate
	 *            the action_date value
	 */
	public void setActionDate(java.util.Date actionDate) {
		this.actionDate = actionDate;
	}

	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments() {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * 
	 * @param comments
	 *            the comments value
	 */
	public void setComments(java.lang.String comments) {
		this.comments = comments;
	}

	/**
	 * Return the value associated with the column: ResourceRequisition
	 */
	public jkt.hrms.recruitment.masters.business.ResourceRequisition getResourceRequisition() {
		return resourceRequisition;
	}

	/**
	 * Set the value related to the column: ResourceRequisition
	 * 
	 * @param resourceRequisition
	 *            the ResourceRequisition value
	 */
	public void setResourceRequisition(
			jkt.hrms.recruitment.masters.business.ResourceRequisition resourceRequisition) {
		this.resourceRequisition = resourceRequisition;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getMasEmployee() {
		return masEmployee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param masEmployee
	 *            the employee_id value
	 */
	public void setMasEmployee(jkt.hms.masters.business.MasEmployee masEmployee) {
		this.masEmployee = masEmployee;
	}

	/**
	 * Return the value associated with the column: request_status_id
	 */
	public jkt.hrms.recruitment.masters.business.RequestStatusMaster getRequestStatusMaster() {
		return requestStatusMaster;
	}

	/**
	 * Set the value related to the column: request_status_id
	 * 
	 * @param requestStatusMaster
	 *            the request_status_id value
	 */
	public void setRequestStatusMaster(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster requestStatusMaster) {
		this.requestStatusMaster = requestStatusMaster;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus = (jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus) obj;
			if (null == this.getId()
					|| null == hrResourceRequisitionStatus.getId()) {
				return false;
			} else {
				return (this.getId()
						.equals(hrResourceRequisitionStatus.getId()));
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