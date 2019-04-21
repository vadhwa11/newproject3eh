package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_code"
 */

public abstract class BaseMstrCode  implements Serializable {

	public static String REF = "MstrCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_CODE_DESC = "CodeDesc";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CODE_REMARKS = "CodeRemarks";
	public static String PROP_FIFTY_PERCENT_EXPENSE_PAID = "FiftyPercentExpensePaid";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CODE_TYPE = "CodeType";
	public static String PROP_ID = "Id";
	public static String PROP_EXPENSE_CODE = "ExpenseCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMstrCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String codeType;
	private java.lang.String codeDesc;
	private java.lang.String codeRemarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String expenseCode;
	private java.lang.String fiftyPercentExpensePaid;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hrms.masters.business.EtrTravelreq> etrTravelreqs;
	private java.util.Set<jkt.hrms.masters.business.EtrTrvdetails> etrTrvdetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CodeId"
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
	 * Return the value associated with the column: CodeType
	 */
	public java.lang.String getCodeType () {
		return codeType;
	}

	/**
	 * Set the value related to the column: CodeType
	 * @param codeType the CodeType value
	 */
	public void setCodeType (java.lang.String codeType) {
		this.codeType = codeType;
	}



	/**
	 * Return the value associated with the column: CodeDesc
	 */
	public java.lang.String getCodeDesc () {
		return codeDesc;
	}

	/**
	 * Set the value related to the column: CodeDesc
	 * @param codeDesc the CodeDesc value
	 */
	public void setCodeDesc (java.lang.String codeDesc) {
		this.codeDesc = codeDesc;
	}



	/**
	 * Return the value associated with the column: CodeRemarks
	 */
	public java.lang.String getCodeRemarks () {
		return codeRemarks;
	}

	/**
	 * Set the value related to the column: CodeRemarks
	 * @param codeRemarks the CodeRemarks value
	 */
	public void setCodeRemarks (java.lang.String codeRemarks) {
		this.codeRemarks = codeRemarks;
	}



	/**
	 * Return the value associated with the column: Status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: Status
	 * @param status the Status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: expense_code
	 */
	public java.lang.String getExpenseCode () {
		return expenseCode;
	}

	/**
	 * Set the value related to the column: expense_code
	 * @param expenseCode the expense_code value
	 */
	public void setExpenseCode (java.lang.String expenseCode) {
		this.expenseCode = expenseCode;
	}



	/**
	 * Return the value associated with the column: fifty_percent_expense_paid
	 */
	public java.lang.String getFiftyPercentExpensePaid () {
		return fiftyPercentExpensePaid;
	}

	/**
	 * Set the value related to the column: fifty_percent_expense_paid
	 * @param fiftyPercentExpensePaid the fifty_percent_expense_paid value
	 */
	public void setFiftyPercentExpensePaid (java.lang.String fiftyPercentExpensePaid) {
		this.fiftyPercentExpensePaid = fiftyPercentExpensePaid;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: EtrTravelreqs
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrTravelreq> getEtrTravelreqs () {
		return etrTravelreqs;
	}

	/**
	 * Set the value related to the column: EtrTravelreqs
	 * @param etrTravelreqs the EtrTravelreqs value
	 */
	public void setEtrTravelreqs (java.util.Set<jkt.hrms.masters.business.EtrTravelreq> etrTravelreqs) {
		this.etrTravelreqs = etrTravelreqs;
	}

	public void addToEtrTravelreqs (jkt.hrms.masters.business.EtrTravelreq etrTravelreq) {
		if (null == getEtrTravelreqs()) setEtrTravelreqs(new java.util.TreeSet<jkt.hrms.masters.business.EtrTravelreq>());
		getEtrTravelreqs().add(etrTravelreq);
	}



	/**
	 * Return the value associated with the column: EtrTrvdetails
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrTrvdetails> getEtrTrvdetails () {
		return etrTrvdetails;
	}

	/**
	 * Set the value related to the column: EtrTrvdetails
	 * @param etrTrvdetails the EtrTrvdetails value
	 */
	public void setEtrTrvdetails (java.util.Set<jkt.hrms.masters.business.EtrTrvdetails> etrTrvdetails) {
		this.etrTrvdetails = etrTrvdetails;
	}

	public void addToEtrTrvdetails (jkt.hrms.masters.business.EtrTrvdetails etrTrvdetails) {
		if (null == getEtrTrvdetails()) setEtrTrvdetails(new java.util.TreeSet<jkt.hrms.masters.business.EtrTrvdetails>());
		getEtrTrvdetails().add(etrTrvdetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrCode)) return false;
		else {
			jkt.hrms.masters.business.MstrCode mstrCode = (jkt.hrms.masters.business.MstrCode) obj;
			if (null == this.getId() || null == mstrCode.getId()) return false;
			else return (this.getId().equals(mstrCode.getId()));
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