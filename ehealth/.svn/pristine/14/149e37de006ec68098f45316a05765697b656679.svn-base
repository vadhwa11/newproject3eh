package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_budget_setting table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_budget_setting"
 */

public abstract class BasePrjBudgetSetting  implements Serializable {

	public static String REF = "PrjBudgetSetting";
	public static String PROP_PJR = "Pjr";
	public static String PROP_BUDTID = "Budtid";
	public static String PROP_PRJ = "Prj";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BUDID = "Budid";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COST_PER_HR = "CostPerHr";
	public static String PROP_REQ_HR = "ReqHr";
	public static String PROP_REQ_RESOURCE_INTO_COST_PER_HR = "ReqResourceIntoCostPerHr";
	public static String PROP_TASK = "Task";
	public static String PROP_REQ_RESOURCE = "ReqResource";
	public static String PROP_ID = "Id";
	public static String PROP_TOTL_COST = "TotlCost";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TASK_TYPE = "TaskType";


	// constructors
	public BasePrjBudgetSetting () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjBudgetSetting (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal reqHr;
	private java.lang.Integer reqResource;
	private java.math.BigDecimal costPerHr;
	private java.math.BigDecimal totlCost;
	private java.math.BigDecimal reqResourceIntoCostPerHr;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrTaskType taskType;
	private jkt.hrms.masters.business.MstrBudgetType budtid;
	private jkt.hrms.masters.business.MstrTask task;
	private jkt.hrms.masters.business.MstrBudgetSubhead budid;
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hrms.masters.business.MstrProjectrole pjr;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="budget_setting_id"
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
	 * Return the value associated with the column: req_hr
	 */
	public java.math.BigDecimal getReqHr () {
		return reqHr;
	}

	/**
	 * Set the value related to the column: req_hr
	 * @param reqHr the req_hr value
	 */
	public void setReqHr (java.math.BigDecimal reqHr) {
		this.reqHr = reqHr;
	}



	/**
	 * Return the value associated with the column: req_resource
	 */
	public java.lang.Integer getReqResource () {
		return reqResource;
	}

	/**
	 * Set the value related to the column: req_resource
	 * @param reqResource the req_resource value
	 */
	public void setReqResource (java.lang.Integer reqResource) {
		this.reqResource = reqResource;
	}



	/**
	 * Return the value associated with the column: cost_per_hr
	 */
	public java.math.BigDecimal getCostPerHr () {
		return costPerHr;
	}

	/**
	 * Set the value related to the column: cost_per_hr
	 * @param costPerHr the cost_per_hr value
	 */
	public void setCostPerHr (java.math.BigDecimal costPerHr) {
		this.costPerHr = costPerHr;
	}



	/**
	 * Return the value associated with the column: totl_cost
	 */
	public java.math.BigDecimal getTotlCost () {
		return totlCost;
	}

	/**
	 * Set the value related to the column: totl_cost
	 * @param totlCost the totl_cost value
	 */
	public void setTotlCost (java.math.BigDecimal totlCost) {
		this.totlCost = totlCost;
	}



	/**
	 * Return the value associated with the column: req_resource_into_cost_per_hr
	 */
	public java.math.BigDecimal getReqResourceIntoCostPerHr () {
		return reqResourceIntoCostPerHr;
	}

	/**
	 * Set the value related to the column: req_resource_into_cost_per_hr
	 * @param reqResourceIntoCostPerHr the req_resource_into_cost_per_hr value
	 */
	public void setReqResourceIntoCostPerHr (java.math.BigDecimal reqResourceIntoCostPerHr) {
		this.reqResourceIntoCostPerHr = reqResourceIntoCostPerHr;
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
	 * Return the value associated with the column: task_type_id
	 */
	public jkt.hrms.masters.business.MstrTaskType getTaskType () {
		return taskType;
	}

	/**
	 * Set the value related to the column: task_type_id
	 * @param taskType the task_type_id value
	 */
	public void setTaskType (jkt.hrms.masters.business.MstrTaskType taskType) {
		this.taskType = taskType;
	}



	/**
	 * Return the value associated with the column: budtid
	 */
	public jkt.hrms.masters.business.MstrBudgetType getBudtid () {
		return budtid;
	}

	/**
	 * Set the value related to the column: budtid
	 * @param budtid the budtid value
	 */
	public void setBudtid (jkt.hrms.masters.business.MstrBudgetType budtid) {
		this.budtid = budtid;
	}



	/**
	 * Return the value associated with the column: task_id
	 */
	public jkt.hrms.masters.business.MstrTask getTask () {
		return task;
	}

	/**
	 * Set the value related to the column: task_id
	 * @param task the task_id value
	 */
	public void setTask (jkt.hrms.masters.business.MstrTask task) {
		this.task = task;
	}



	/**
	 * Return the value associated with the column: budid
	 */
	public jkt.hrms.masters.business.MstrBudgetSubhead getBudid () {
		return budid;
	}

	/**
	 * Set the value related to the column: budid
	 * @param budid the budid value
	 */
	public void setBudid (jkt.hrms.masters.business.MstrBudgetSubhead budid) {
		this.budid = budid;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjBudgetSetting)) return false;
		else {
			jkt.hrms.masters.business.PrjBudgetSetting prjBudgetSetting = (jkt.hrms.masters.business.PrjBudgetSetting) obj;
			if (null == this.getId() || null == prjBudgetSetting.getId()) return false;
			else return (this.getId().equals(prjBudgetSetting.getId()));
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