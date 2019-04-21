package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_requisition_history
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_requisition_history"
 */

public abstract class BaseHrRequisitionHistory implements Serializable {

	public static String REF = "HrRequisitionHistory";
	public static String PROP_STATUS = "Status";
	public static String PROP_REQUISITION = "Requisition";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_ID = "Id";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_ACTION_DATE = "ActionDate";

	// constructors
	public BaseHrRequisitionHistory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrRequisitionHistory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrRequisitionHistory(
			java.lang.Integer id,
			jkt.hrms.recruitment.masters.business.RequestStatusMaster status,
			jkt.hrms.recruitment.masters.business.ResourceRequisition requisition,
			jkt.hms.masters.business.MasEmployee employee) {

		this.setId(id);
		this.setStatus(status);
		this.setRequisition(requisition);
		this.setEmployee(employee);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date actionDate;
	private java.lang.String comments;

	// many to one
	private jkt.hrms.recruitment.masters.business.RequestStatusMaster status;
	private jkt.hrms.recruitment.masters.business.ResourceRequisition requisition;
	private jkt.hms.masters.business.MasEmployee employee;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="requisition_history_id"
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
	 * Return the value associated with the column: status_id
	 */
	public jkt.hrms.recruitment.masters.business.RequestStatusMaster getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param status
	 *            the status_id value
	 */
	public void setStatus(
			jkt.hrms.recruitment.masters.business.RequestStatusMaster status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: requisition_id
	 */
	public jkt.hrms.recruitment.masters.business.ResourceRequisition getRequisition() {
		return requisition;
	}

	/**
	 * Set the value related to the column: requisition_id
	 * 
	 * @param requisition
	 *            the requisition_id value
	 */
	public void setRequisition(
			jkt.hrms.recruitment.masters.business.ResourceRequisition requisition) {
		this.requisition = requisition;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.HrRequisitionHistory)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.HrRequisitionHistory hrRequisitionHistory = (jkt.hrms.recruitment.masters.business.HrRequisitionHistory) obj;
			if (null == this.getId() || null == hrRequisitionHistory.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrRequisitionHistory.getId()));
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