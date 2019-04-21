package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the project_vitals table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="project_vitals"
 */

public abstract class BaseProjectVitals  implements Serializable {

	public static String REF = "ProjectVitals";
	public static String PROP_ACTUAL_DATE = "ActualDate";
	public static String PROP_PLANNED_DATE = "PlannedDate";
	public static String PROP_PLANNED_VALUE = "PlannedValue";
	public static String PROP_VITAL = "Vital";
	public static String PROP_FLAG = "Flag";
	public static String PROP_REVISED_VALUE = "RevisedValue";
	public static String PROP_PRJ = "Prj";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AMOUNT_FLAG = "AmountFlag";
	public static String PROP_REMARK_ONE = "RemarkOne";
	public static String PROP_REMARK_TWO = "RemarkTwo";
	public static String PROP_ACTUAL_VALUE = "ActualValue";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REVISED_DATE = "RevisedDate";
	public static String PROP_REMARK_THREE = "RemarkThree";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CURRENCY = "Currency";


	// constructors
	public BaseProjectVitals () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProjectVitals (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date plannedDate;
	private java.lang.String remarkOne;
	private java.util.Date revisedDate;
	private java.lang.String remarkTwo;
	private java.util.Date actualDate;
	private java.lang.String remarkThree;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal plannedValue;
	private java.math.BigDecimal revisedValue;
	private java.math.BigDecimal actualValue;
	private java.lang.String flag;
	private java.lang.String amountFlag;

	// many to one
	private jkt.hms.masters.business.MasCurrency currency;
	private jkt.hrms.masters.business.MstrVitals vital;
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hms.masters.business.MasHospital company;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pvital_id"
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
	 * Return the value associated with the column: planned_date
	 */
	public java.util.Date getPlannedDate () {
		return plannedDate;
	}

	/**
	 * Set the value related to the column: planned_date
	 * @param plannedDate the planned_date value
	 */
	public void setPlannedDate (java.util.Date plannedDate) {
		this.plannedDate = plannedDate;
	}



	/**
	 * Return the value associated with the column: remark_one
	 */
	public java.lang.String getRemarkOne () {
		return remarkOne;
	}

	/**
	 * Set the value related to the column: remark_one
	 * @param remarkOne the remark_one value
	 */
	public void setRemarkOne (java.lang.String remarkOne) {
		this.remarkOne = remarkOne;
	}



	/**
	 * Return the value associated with the column: revised_date
	 */
	public java.util.Date getRevisedDate () {
		return revisedDate;
	}

	/**
	 * Set the value related to the column: revised_date
	 * @param revisedDate the revised_date value
	 */
	public void setRevisedDate (java.util.Date revisedDate) {
		this.revisedDate = revisedDate;
	}



	/**
	 * Return the value associated with the column: remark_two
	 */
	public java.lang.String getRemarkTwo () {
		return remarkTwo;
	}

	/**
	 * Set the value related to the column: remark_two
	 * @param remarkTwo the remark_two value
	 */
	public void setRemarkTwo (java.lang.String remarkTwo) {
		this.remarkTwo = remarkTwo;
	}



	/**
	 * Return the value associated with the column: actual_date
	 */
	public java.util.Date getActualDate () {
		return actualDate;
	}

	/**
	 * Set the value related to the column: actual_date
	 * @param actualDate the actual_date value
	 */
	public void setActualDate (java.util.Date actualDate) {
		this.actualDate = actualDate;
	}



	/**
	 * Return the value associated with the column: remark_three
	 */
	public java.lang.String getRemarkThree () {
		return remarkThree;
	}

	/**
	 * Set the value related to the column: remark_three
	 * @param remarkThree the remark_three value
	 */
	public void setRemarkThree (java.lang.String remarkThree) {
		this.remarkThree = remarkThree;
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
	 * Return the value associated with the column: planned_value
	 */
	public java.math.BigDecimal getPlannedValue () {
		return plannedValue;
	}

	/**
	 * Set the value related to the column: planned_value
	 * @param plannedValue the planned_value value
	 */
	public void setPlannedValue (java.math.BigDecimal plannedValue) {
		this.plannedValue = plannedValue;
	}



	/**
	 * Return the value associated with the column: revised_value
	 */
	public java.math.BigDecimal getRevisedValue () {
		return revisedValue;
	}

	/**
	 * Set the value related to the column: revised_value
	 * @param revisedValue the revised_value value
	 */
	public void setRevisedValue (java.math.BigDecimal revisedValue) {
		this.revisedValue = revisedValue;
	}



	/**
	 * Return the value associated with the column: actual_value
	 */
	public java.math.BigDecimal getActualValue () {
		return actualValue;
	}

	/**
	 * Set the value related to the column: actual_value
	 * @param actualValue the actual_value value
	 */
	public void setActualValue (java.math.BigDecimal actualValue) {
		this.actualValue = actualValue;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: amount_flag
	 */
	public java.lang.String getAmountFlag () {
		return amountFlag;
	}

	/**
	 * Set the value related to the column: amount_flag
	 * @param amountFlag the amount_flag value
	 */
	public void setAmountFlag (java.lang.String amountFlag) {
		this.amountFlag = amountFlag;
	}



	/**
	 * Return the value associated with the column: currency_id
	 */
	public jkt.hms.masters.business.MasCurrency getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency_id
	 * @param currency the currency_id value
	 */
	public void setCurrency (jkt.hms.masters.business.MasCurrency currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: vital_id
	 */
	public jkt.hrms.masters.business.MstrVitals getVital () {
		return vital;
	}

	/**
	 * Set the value related to the column: vital_id
	 * @param vital the vital_id value
	 */
	public void setVital (jkt.hrms.masters.business.MstrVitals vital) {
		this.vital = vital;
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
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.ProjectVitals)) return false;
		else {
			jkt.hrms.masters.business.ProjectVitals projectVitals = (jkt.hrms.masters.business.ProjectVitals) obj;
			if (null == this.getId() || null == projectVitals.getId()) return false;
			else return (this.getId().equals(projectVitals.getId()));
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