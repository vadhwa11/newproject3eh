package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_budget_set table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_budget_set"
 */

public abstract class BasePrjBudgetSet  implements Serializable {

	public static String REF = "PrjBudgetSet";
	public static String PROP_TOT_RES_HOURS = "TotResHours";
	public static String PROP_TOT_COST = "TotCost";
	public static String PROP_MODIFIED_AT = "ModifiedAt";
	public static String PROP_MODIFIED_BY = "ModifiedBy";
	public static String PROP_REQ_HOURS = "ReqHours";
	public static String PROP_BUD_SUBH_ID = "BudSubhId";
	public static String PROP_CUR_ID = "CurId";
	public static String PROP_BUD_ID = "BudId";
	public static String PROP_BUD_TASK_ID = "BudTaskId";
	public static String PROP_BUD_TYPE_ID = "BudTypeId";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_REQ_RESOURCE = "ReqResource";
	public static String PROP_COST_PER_HOUR = "CostPerHour";
	public static String PROP_BUD_PRJ_ID = "BudPrjId";
	public static String PROP_CREATED_AT = "CreatedAt";


	// constructors
	public BasePrjBudgetSet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjBudgetSet (java.lang.Integer budId) {
		this.setBudId(budId);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePrjBudgetSet (
		java.lang.Integer budId,
		java.lang.Integer budPrjId,
		java.lang.Integer budTypeId,
		java.lang.Integer budSubhId,
		java.lang.Integer budTaskId,
		java.lang.Float reqHours,
		java.lang.Integer reqResource,
		java.math.BigDecimal costPerHour,
		java.lang.Integer curId,
		java.lang.Integer createdBy,
		java.util.Date createdAt,
		java.lang.Integer modifiedBy,
		java.util.Date modifiedAt,
		java.math.BigDecimal totCost,
		java.math.BigDecimal totResHours) {

		this.setBudId(budId);
		this.setBudPrjId(budPrjId);
		this.setBudTypeId(budTypeId);
		this.setBudSubhId(budSubhId);
		this.setBudTaskId(budTaskId);
		this.setReqHours(reqHours);
		this.setReqResource(reqResource);
		this.setCostPerHour(costPerHour);
		this.setCurId(curId);
		this.setCreatedBy(createdBy);
		this.setCreatedAt(createdAt);
		this.setModifiedBy(modifiedBy);
		this.setModifiedAt(modifiedAt);
		this.setTotCost(totCost);
		this.setTotResHours(totResHours);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer budId;

	// fields
	private java.lang.Integer budPrjId;
	private java.lang.Integer budTypeId;
	private java.lang.Integer budSubhId;
	private java.lang.Integer budTaskId;
	private java.lang.Float reqHours;
	private java.lang.Integer reqResource;
	private java.math.BigDecimal costPerHour;
	private java.lang.Integer curId;
	private java.lang.Integer createdBy;
	private java.util.Date createdAt;
	private java.lang.Integer modifiedBy;
	private java.util.Date modifiedAt;
	private java.math.BigDecimal totCost;
	private java.math.BigDecimal totResHours;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Bud_Id"
     */
	public java.lang.Integer getBudId () {
		return budId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param budId the new ID
	 */
	public void setBudId (java.lang.Integer budId) {
		this.budId = budId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: Bud_Prj_Id
	 */
	public java.lang.Integer getBudPrjId () {
		return budPrjId;
	}

	/**
	 * Set the value related to the column: Bud_Prj_Id
	 * @param budPrjId the Bud_Prj_Id value
	 */
	public void setBudPrjId (java.lang.Integer budPrjId) {
		this.budPrjId = budPrjId;
	}



	/**
	 * Return the value associated with the column: Bud_Type_id
	 */
	public java.lang.Integer getBudTypeId () {
		return budTypeId;
	}

	/**
	 * Set the value related to the column: Bud_Type_id
	 * @param budTypeId the Bud_Type_id value
	 */
	public void setBudTypeId (java.lang.Integer budTypeId) {
		this.budTypeId = budTypeId;
	}



	/**
	 * Return the value associated with the column: Bud_Subh_id
	 */
	public java.lang.Integer getBudSubhId () {
		return budSubhId;
	}

	/**
	 * Set the value related to the column: Bud_Subh_id
	 * @param budSubhId the Bud_Subh_id value
	 */
	public void setBudSubhId (java.lang.Integer budSubhId) {
		this.budSubhId = budSubhId;
	}



	/**
	 * Return the value associated with the column: Bud_Task_id
	 */
	public java.lang.Integer getBudTaskId () {
		return budTaskId;
	}

	/**
	 * Set the value related to the column: Bud_Task_id
	 * @param budTaskId the Bud_Task_id value
	 */
	public void setBudTaskId (java.lang.Integer budTaskId) {
		this.budTaskId = budTaskId;
	}



	/**
	 * Return the value associated with the column: Req_Hours
	 */
	public java.lang.Float getReqHours () {
		return reqHours;
	}

	/**
	 * Set the value related to the column: Req_Hours
	 * @param reqHours the Req_Hours value
	 */
	public void setReqHours (java.lang.Float reqHours) {
		this.reqHours = reqHours;
	}



	/**
	 * Return the value associated with the column: Req_Resource
	 */
	public java.lang.Integer getReqResource () {
		return reqResource;
	}

	/**
	 * Set the value related to the column: Req_Resource
	 * @param reqResource the Req_Resource value
	 */
	public void setReqResource (java.lang.Integer reqResource) {
		this.reqResource = reqResource;
	}



	/**
	 * Return the value associated with the column: CostPerHour
	 */
	public java.math.BigDecimal getCostPerHour () {
		return costPerHour;
	}

	/**
	 * Set the value related to the column: CostPerHour
	 * @param costPerHour the CostPerHour value
	 */
	public void setCostPerHour (java.math.BigDecimal costPerHour) {
		this.costPerHour = costPerHour;
	}



	/**
	 * Return the value associated with the column: Cur_Id
	 */
	public java.lang.Integer getCurId () {
		return curId;
	}

	/**
	 * Set the value related to the column: Cur_Id
	 * @param curId the Cur_Id value
	 */
	public void setCurId (java.lang.Integer curId) {
		this.curId = curId;
	}



	/**
	 * Return the value associated with the column: CreatedBy
	 */
	public java.lang.Integer getCreatedBy () {
		return createdBy;
	}

	/**
	 * Set the value related to the column: CreatedBy
	 * @param createdBy the CreatedBy value
	 */
	public void setCreatedBy (java.lang.Integer createdBy) {
		this.createdBy = createdBy;
	}



	/**
	 * Return the value associated with the column: CreatedAt
	 */
	public java.util.Date getCreatedAt () {
		return createdAt;
	}

	/**
	 * Set the value related to the column: CreatedAt
	 * @param createdAt the CreatedAt value
	 */
	public void setCreatedAt (java.util.Date createdAt) {
		this.createdAt = createdAt;
	}



	/**
	 * Return the value associated with the column: ModifiedBy
	 */
	public java.lang.Integer getModifiedBy () {
		return modifiedBy;
	}

	/**
	 * Set the value related to the column: ModifiedBy
	 * @param modifiedBy the ModifiedBy value
	 */
	public void setModifiedBy (java.lang.Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	/**
	 * Return the value associated with the column: ModifiedAt
	 */
	public java.util.Date getModifiedAt () {
		return modifiedAt;
	}

	/**
	 * Set the value related to the column: ModifiedAt
	 * @param modifiedAt the ModifiedAt value
	 */
	public void setModifiedAt (java.util.Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}



	/**
	 * Return the value associated with the column: tot_cost
	 */
	public java.math.BigDecimal getTotCost () {
		return totCost;
	}

	/**
	 * Set the value related to the column: tot_cost
	 * @param totCost the tot_cost value
	 */
	public void setTotCost (java.math.BigDecimal totCost) {
		this.totCost = totCost;
	}



	/**
	 * Return the value associated with the column: tot_res_hours
	 */
	public java.math.BigDecimal getTotResHours () {
		return totResHours;
	}

	/**
	 * Set the value related to the column: tot_res_hours
	 * @param totResHours the tot_res_hours value
	 */
	public void setTotResHours (java.math.BigDecimal totResHours) {
		this.totResHours = totResHours;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjBudgetSet)) return false;
		else {
			jkt.hrms.masters.business.PrjBudgetSet prjBudgetSet = (jkt.hrms.masters.business.PrjBudgetSet) obj;
			if (null == this.getBudId() || null == prjBudgetSet.getBudId()) return false;
			else return (this.getBudId().equals(prjBudgetSet.getBudId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getBudId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getBudId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}