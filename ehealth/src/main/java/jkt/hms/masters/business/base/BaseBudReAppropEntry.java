package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bud_re_approp_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bud_re_approp_entry"
 */

public abstract class BaseBudReAppropEntry  implements Serializable {

	public static String REF = "BudReAppropEntry";
	public static String PROP_FINANCIAL = "Financial";
	public static String PROP_MINOR_SUB_HEAD = "MinorSubHead";
	public static String PROP_REAPPAMOUNT = "Reappamount";
	public static String PROP_TYPE = "Type";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OBJECT_HEAD = "ObjectHead";
	public static String PROP_MINOR_HEAD = "MinorHead";
	public static String PROP_BUDGET = "Budget";
	public static String PROP_STATUS = "Status";
	public static String PROP_MAJOR_SUB_HEAD = "MajorSubHead";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MAJOR_HEAD = "MajorHead";
	public static String PROP_RE_APPROP_NO = "ReAppropNo";


	// constructors
	public BaseBudReAppropEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudReAppropEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBudReAppropEntry (
		java.lang.Integer id,
		jkt.hms.masters.business.BudSubMajorHead majorSubHead,
		jkt.hms.masters.business.BudObjectHead objectHead,
		jkt.hms.masters.business.BudMinorSubHead minorSubHead,
		jkt.hms.masters.business.BudMajorHead majorHead,
		jkt.hms.masters.business.BudEstimateEntry budget,
		jkt.hms.masters.business.BudMinorHead minorHead,
		jkt.hrms.masters.business.HrMasFinancialYear financial,
		java.lang.String type) {

		this.setId(id);
		this.setMajorSubHead(majorSubHead);
		this.setObjectHead(objectHead);
		this.setMinorSubHead(minorSubHead);
		this.setMajorHead(majorHead);
		this.setBudget(budget);
		this.setMinorHead(minorHead);
		this.setFinancial(financial);
		this.setType(type);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal reappamount;
	private java.lang.String type;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String reAppropNo;

	// many to one
	private jkt.hms.masters.business.BudSubMajorHead majorSubHead;
	private jkt.hms.masters.business.BudObjectHead objectHead;
	private jkt.hms.masters.business.BudMinorSubHead minorSubHead;
	private jkt.hms.masters.business.BudMajorHead majorHead;
	private jkt.hms.masters.business.BudEstimateEntry budget;
	private jkt.hms.masters.business.BudMinorHead minorHead;
	private jkt.hrms.masters.business.HrMasFinancialYear financial;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="bud_re_id"
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
	 * Return the value associated with the column: reappamount
	 */
	public java.math.BigDecimal getReappamount () {
		return reappamount;
	}

	/**
	 * Set the value related to the column: reappamount
	 * @param reappamount the reappamount value
	 */
	public void setReappamount (java.math.BigDecimal reappamount) {
		this.reappamount = reappamount;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
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
	 * Return the value associated with the column: reAppropNo
	 */
	public java.lang.String getReAppropNo () {
		return reAppropNo;
	}

	/**
	 * Set the value related to the column: reAppropNo
	 * @param reAppropNo the reAppropNo value
	 */
	public void setReAppropNo (java.lang.String reAppropNo) {
		this.reAppropNo = reAppropNo;
	}



	/**
	 * Return the value associated with the column: major_sub_head_id
	 */
	public jkt.hms.masters.business.BudSubMajorHead getMajorSubHead () {
		return majorSubHead;
	}

	/**
	 * Set the value related to the column: major_sub_head_id
	 * @param majorSubHead the major_sub_head_id value
	 */
	public void setMajorSubHead (jkt.hms.masters.business.BudSubMajorHead majorSubHead) {
		this.majorSubHead = majorSubHead;
	}



	/**
	 * Return the value associated with the column: object_head_id
	 */
	public jkt.hms.masters.business.BudObjectHead getObjectHead () {
		return objectHead;
	}

	/**
	 * Set the value related to the column: object_head_id
	 * @param objectHead the object_head_id value
	 */
	public void setObjectHead (jkt.hms.masters.business.BudObjectHead objectHead) {
		this.objectHead = objectHead;
	}



	/**
	 * Return the value associated with the column: minor_sub_head_id
	 */
	public jkt.hms.masters.business.BudMinorSubHead getMinorSubHead () {
		return minorSubHead;
	}

	/**
	 * Set the value related to the column: minor_sub_head_id
	 * @param minorSubHead the minor_sub_head_id value
	 */
	public void setMinorSubHead (jkt.hms.masters.business.BudMinorSubHead minorSubHead) {
		this.minorSubHead = minorSubHead;
	}



	/**
	 * Return the value associated with the column: major_head_id
	 */
	public jkt.hms.masters.business.BudMajorHead getMajorHead () {
		return majorHead;
	}

	/**
	 * Set the value related to the column: major_head_id
	 * @param majorHead the major_head_id value
	 */
	public void setMajorHead (jkt.hms.masters.business.BudMajorHead majorHead) {
		this.majorHead = majorHead;
	}



	/**
	 * Return the value associated with the column: budget_id
	 */
	public jkt.hms.masters.business.BudEstimateEntry getBudget () {
		return budget;
	}

	/**
	 * Set the value related to the column: budget_id
	 * @param budget the budget_id value
	 */
	public void setBudget (jkt.hms.masters.business.BudEstimateEntry budget) {
		this.budget = budget;
	}



	/**
	 * Return the value associated with the column: minor_head_id
	 */
	public jkt.hms.masters.business.BudMinorHead getMinorHead () {
		return minorHead;
	}

	/**
	 * Set the value related to the column: minor_head_id
	 * @param minorHead the minor_head_id value
	 */
	public void setMinorHead (jkt.hms.masters.business.BudMinorHead minorHead) {
		this.minorHead = minorHead;
	}



	/**
	 * Return the value associated with the column: financial_id
	 */
	public jkt.hrms.masters.business.HrMasFinancialYear getFinancial () {
		return financial;
	}

	/**
	 * Set the value related to the column: financial_id
	 * @param financial the financial_id value
	 */
	public void setFinancial (jkt.hrms.masters.business.HrMasFinancialYear financial) {
		this.financial = financial;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudReAppropEntry)) return false;
		else {
			jkt.hms.masters.business.BudReAppropEntry budReAppropEntry = (jkt.hms.masters.business.BudReAppropEntry) obj;
			if (null == this.getId() || null == budReAppropEntry.getId()) return false;
			else return (this.getId().equals(budReAppropEntry.getId()));
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