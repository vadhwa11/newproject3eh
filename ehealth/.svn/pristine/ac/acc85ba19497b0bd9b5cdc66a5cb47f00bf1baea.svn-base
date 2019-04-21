package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_budget_subhead table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_budget_subhead"
 */

public abstract class BaseMstrBudgetSubhead  implements Serializable {

	public static String REF = "MstrBudgetSubhead";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BUD_NAME = "BudName";
	public static String PROP_BUD_SUBHEAD_CODE = "BudSubheadCode";


	// constructors
	public BaseMstrBudgetSubhead () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrBudgetSubhead (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String budName;
	private java.lang.String budSubheadCode;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjBudgetSet> prjBudgetSets;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="budid"
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
	 * Return the value associated with the column: bud_name
	 */
	public java.lang.String getBudName () {
		return budName;
	}

	/**
	 * Set the value related to the column: bud_name
	 * @param budName the bud_name value
	 */
	public void setBudName (java.lang.String budName) {
		this.budName = budName;
	}



	/**
	 * Return the value associated with the column: bud_subhead_code
	 */
	public java.lang.String getBudSubheadCode () {
		return budSubheadCode;
	}

	/**
	 * Set the value related to the column: bud_subhead_code
	 * @param budSubheadCode the bud_subhead_code value
	 */
	public void setBudSubheadCode (java.lang.String budSubheadCode) {
		this.budSubheadCode = budSubheadCode;
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
	 * Return the value associated with the column: PrjBudgetSets
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjBudgetSet> getPrjBudgetSets () {
		return prjBudgetSets;
	}

	/**
	 * Set the value related to the column: PrjBudgetSets
	 * @param prjBudgetSets the PrjBudgetSets value
	 */
	public void setPrjBudgetSets (java.util.Set<jkt.hrms.masters.business.PrjBudgetSet> prjBudgetSets) {
		this.prjBudgetSets = prjBudgetSets;
	}

	public void addToPrjBudgetSets (jkt.hrms.masters.business.PrjBudgetSet prjBudgetSet) {
		if (null == getPrjBudgetSets()) setPrjBudgetSets(new java.util.TreeSet<jkt.hrms.masters.business.PrjBudgetSet>());
		getPrjBudgetSets().add(prjBudgetSet);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrBudgetSubhead)) return false;
		else {
			jkt.hrms.masters.business.MstrBudgetSubhead mstrBudgetSubhead = (jkt.hrms.masters.business.MstrBudgetSubhead) obj;
			if (null == this.getId() || null == mstrBudgetSubhead.getId()) return false;
			else return (this.getId().equals(mstrBudgetSubhead.getId()));
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