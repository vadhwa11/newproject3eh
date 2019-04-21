package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_expsubmit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_expsubmit"
 */

public abstract class BaseEtrExpsubmit  implements Serializable {

	public static String REF = "EtrExpsubmit";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ACT = "Act";
	public static String PROP_TRV = "Trv";
	public static String PROP_EXPENSE_TOTAL_TIME = "ExpenseTotalTime";
	public static String PROP_DISBURSMENT_DATE = "DisbursmentDate";
	public static String PROP_PAID_DATE = "PaidDate";
	public static String PROP_EXPENSE_SETTLEMENT_TIME = "ExpenseSettlementTime";
	public static String PROP_EXPENSE_SETTLEMENT_DATE = "ExpenseSettlementDate";
	public static String PROP_EXPENSE_START_TIME = "ExpenseStartTime";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_ACT_DEPT_TIME = "ActDeptTime";
	public static String PROP_ACT_TODATE = "ActTodate";
	public static String PROP_MODE_PF_PAYMENT = "ModePfPayment";
	public static String PROP_EXP_PAID = "ExpPaid";
	public static String PROP_EXPENSE_END_TIME = "ExpenseEndTime";
	public static String PROP_AMOUNT_PAID = "AmountPaid";
	public static String PROP_ID = "Id";
	public static String PROP_APPROVE_EXPENSE_TIME = "ApproveExpenseTime";
	public static String PROP_ACT_FRM_DATE = "ActFrmDate";
	public static String PROP_APPROVE_EXPENSE_DATE = "ApproveExpenseDate";
	public static String PROP_ACT_RTN_TIME = "ActRtnTime";


	// constructors
	public BaseEtrExpsubmit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrExpsubmit (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEtrExpsubmit (
		java.lang.Integer id,
		jkt.hms.masters.business.MasEmployee act,
		jkt.hrms.masters.business.EtrTravelreq trv) {

		this.setId(id);
		this.setAct(act);
		this.setTrv(trv);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date actFrmDate;
	private java.util.Date actTodate;
	private java.lang.String actDeptTime;
	private java.lang.String actRtnTime;
	private java.lang.String description;
	private java.lang.String expPaid;
	private java.util.Date paidDate;
	private java.util.Date entryDate;
	private java.lang.String modePfPayment;
	private java.util.Date disbursmentDate;
	private java.math.BigDecimal amountPaid;
	private java.util.Date approveExpenseDate;
	private java.lang.String approveExpenseTime;
	private java.util.Date expenseSettlementDate;
	private java.lang.String expenseSettlementTime;
	private java.lang.String expenseStartTime;
	private java.lang.String expenseEndTime;
	private java.lang.String expenseTotalTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee act;
	private jkt.hrms.masters.business.EtrTravelreq trv;

	// collections
	private java.util.Set<jkt.hrms.masters.business.EtrTrvsubAttach> etrTrvsubAttachs;
	private java.util.Set<jkt.hrms.masters.business.EtrExpdetails> etrExpdetails;
	private java.util.Set<jkt.hrms.masters.business.EtrTrvsubapptbl> etrTrvsubapptbls;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="exp_id"
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
	 * Return the value associated with the column: ActFrmDate
	 */
	public java.util.Date getActFrmDate () {
		return actFrmDate;
	}

	/**
	 * Set the value related to the column: ActFrmDate
	 * @param actFrmDate the ActFrmDate value
	 */
	public void setActFrmDate (java.util.Date actFrmDate) {
		this.actFrmDate = actFrmDate;
	}



	/**
	 * Return the value associated with the column: ActTodate
	 */
	public java.util.Date getActTodate () {
		return actTodate;
	}

	/**
	 * Set the value related to the column: ActTodate
	 * @param actTodate the ActTodate value
	 */
	public void setActTodate (java.util.Date actTodate) {
		this.actTodate = actTodate;
	}



	/**
	 * Return the value associated with the column: ActDeptTime
	 */
	public java.lang.String getActDeptTime () {
		return actDeptTime;
	}

	/**
	 * Set the value related to the column: ActDeptTime
	 * @param actDeptTime the ActDeptTime value
	 */
	public void setActDeptTime (java.lang.String actDeptTime) {
		this.actDeptTime = actDeptTime;
	}



	/**
	 * Return the value associated with the column: ActRtnTime
	 */
	public java.lang.String getActRtnTime () {
		return actRtnTime;
	}

	/**
	 * Set the value related to the column: ActRtnTime
	 * @param actRtnTime the ActRtnTime value
	 */
	public void setActRtnTime (java.lang.String actRtnTime) {
		this.actRtnTime = actRtnTime;
	}



	/**
	 * Return the value associated with the column: Description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: Description
	 * @param description the Description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: ExpPaid
	 */
	public java.lang.String getExpPaid () {
		return expPaid;
	}

	/**
	 * Set the value related to the column: ExpPaid
	 * @param expPaid the ExpPaid value
	 */
	public void setExpPaid (java.lang.String expPaid) {
		this.expPaid = expPaid;
	}



	/**
	 * Return the value associated with the column: PaidDate
	 */
	public java.util.Date getPaidDate () {
		return paidDate;
	}

	/**
	 * Set the value related to the column: PaidDate
	 * @param paidDate the PaidDate value
	 */
	public void setPaidDate (java.util.Date paidDate) {
		this.paidDate = paidDate;
	}



	/**
	 * Return the value associated with the column: EntryDate
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: EntryDate
	 * @param entryDate the EntryDate value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: mode_pf_payment
	 */
	public java.lang.String getModePfPayment () {
		return modePfPayment;
	}

	/**
	 * Set the value related to the column: mode_pf_payment
	 * @param modePfPayment the mode_pf_payment value
	 */
	public void setModePfPayment (java.lang.String modePfPayment) {
		this.modePfPayment = modePfPayment;
	}



	/**
	 * Return the value associated with the column: disbursment_date
	 */
	public java.util.Date getDisbursmentDate () {
		return disbursmentDate;
	}

	/**
	 * Set the value related to the column: disbursment_date
	 * @param disbursmentDate the disbursment_date value
	 */
	public void setDisbursmentDate (java.util.Date disbursmentDate) {
		this.disbursmentDate = disbursmentDate;
	}



	/**
	 * Return the value associated with the column: amount_paid
	 */
	public java.math.BigDecimal getAmountPaid () {
		return amountPaid;
	}

	/**
	 * Set the value related to the column: amount_paid
	 * @param amountPaid the amount_paid value
	 */
	public void setAmountPaid (java.math.BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}



	/**
	 * Return the value associated with the column: approve_expense_date
	 */
	public java.util.Date getApproveExpenseDate () {
		return approveExpenseDate;
	}

	/**
	 * Set the value related to the column: approve_expense_date
	 * @param approveExpenseDate the approve_expense_date value
	 */
	public void setApproveExpenseDate (java.util.Date approveExpenseDate) {
		this.approveExpenseDate = approveExpenseDate;
	}



	/**
	 * Return the value associated with the column: approve_expense_time
	 */
	public java.lang.String getApproveExpenseTime () {
		return approveExpenseTime;
	}

	/**
	 * Set the value related to the column: approve_expense_time
	 * @param approveExpenseTime the approve_expense_time value
	 */
	public void setApproveExpenseTime (java.lang.String approveExpenseTime) {
		this.approveExpenseTime = approveExpenseTime;
	}



	/**
	 * Return the value associated with the column: expense_settlement_date
	 */
	public java.util.Date getExpenseSettlementDate () {
		return expenseSettlementDate;
	}

	/**
	 * Set the value related to the column: expense_settlement_date
	 * @param expenseSettlementDate the expense_settlement_date value
	 */
	public void setExpenseSettlementDate (java.util.Date expenseSettlementDate) {
		this.expenseSettlementDate = expenseSettlementDate;
	}



	/**
	 * Return the value associated with the column: expense_settlement_time
	 */
	public java.lang.String getExpenseSettlementTime () {
		return expenseSettlementTime;
	}

	/**
	 * Set the value related to the column: expense_settlement_time
	 * @param expenseSettlementTime the expense_settlement_time value
	 */
	public void setExpenseSettlementTime (java.lang.String expenseSettlementTime) {
		this.expenseSettlementTime = expenseSettlementTime;
	}



	/**
	 * Return the value associated with the column: expense_start_time
	 */
	public java.lang.String getExpenseStartTime () {
		return expenseStartTime;
	}

	/**
	 * Set the value related to the column: expense_start_time
	 * @param expenseStartTime the expense_start_time value
	 */
	public void setExpenseStartTime (java.lang.String expenseStartTime) {
		this.expenseStartTime = expenseStartTime;
	}



	/**
	 * Return the value associated with the column: expense_end_time
	 */
	public java.lang.String getExpenseEndTime () {
		return expenseEndTime;
	}

	/**
	 * Set the value related to the column: expense_end_time
	 * @param expenseEndTime the expense_end_time value
	 */
	public void setExpenseEndTime (java.lang.String expenseEndTime) {
		this.expenseEndTime = expenseEndTime;
	}



	/**
	 * Return the value associated with the column: expense_total_time
	 */
	public java.lang.String getExpenseTotalTime () {
		return expenseTotalTime;
	}

	/**
	 * Set the value related to the column: expense_total_time
	 * @param expenseTotalTime the expense_total_time value
	 */
	public void setExpenseTotalTime (java.lang.String expenseTotalTime) {
		this.expenseTotalTime = expenseTotalTime;
	}



	/**
	 * Return the value associated with the column: ActId
	 */
	public jkt.hms.masters.business.MasEmployee getAct () {
		return act;
	}

	/**
	 * Set the value related to the column: ActId
	 * @param act the ActId value
	 */
	public void setAct (jkt.hms.masters.business.MasEmployee act) {
		this.act = act;
	}



	/**
	 * Return the value associated with the column: trv_id
	 */
	public jkt.hrms.masters.business.EtrTravelreq getTrv () {
		return trv;
	}

	/**
	 * Set the value related to the column: trv_id
	 * @param trv the trv_id value
	 */
	public void setTrv (jkt.hrms.masters.business.EtrTravelreq trv) {
		this.trv = trv;
	}



	/**
	 * Return the value associated with the column: EtrTrvsubAttachs
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrTrvsubAttach> getEtrTrvsubAttachs () {
		return etrTrvsubAttachs;
	}

	/**
	 * Set the value related to the column: EtrTrvsubAttachs
	 * @param etrTrvsubAttachs the EtrTrvsubAttachs value
	 */
	public void setEtrTrvsubAttachs (java.util.Set<jkt.hrms.masters.business.EtrTrvsubAttach> etrTrvsubAttachs) {
		this.etrTrvsubAttachs = etrTrvsubAttachs;
	}

	public void addToEtrTrvsubAttachs (jkt.hrms.masters.business.EtrTrvsubAttach etrTrvsubAttach) {
		if (null == getEtrTrvsubAttachs()) setEtrTrvsubAttachs(new java.util.TreeSet<jkt.hrms.masters.business.EtrTrvsubAttach>());
		getEtrTrvsubAttachs().add(etrTrvsubAttach);
	}



	/**
	 * Return the value associated with the column: EtrExpdetails
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrExpdetails> getEtrExpdetails () {
		return etrExpdetails;
	}

	/**
	 * Set the value related to the column: EtrExpdetails
	 * @param etrExpdetails the EtrExpdetails value
	 */
	public void setEtrExpdetails (java.util.Set<jkt.hrms.masters.business.EtrExpdetails> etrExpdetails) {
		this.etrExpdetails = etrExpdetails;
	}

	public void addToEtrExpdetails (jkt.hrms.masters.business.EtrExpdetails etrExpdetails) {
		if (null == getEtrExpdetails()) setEtrExpdetails(new java.util.TreeSet<jkt.hrms.masters.business.EtrExpdetails>());
		getEtrExpdetails().add(etrExpdetails);
	}



	/**
	 * Return the value associated with the column: EtrTrvsubapptbls
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrTrvsubapptbl> getEtrTrvsubapptbls () {
		return etrTrvsubapptbls;
	}

	/**
	 * Set the value related to the column: EtrTrvsubapptbls
	 * @param etrTrvsubapptbls the EtrTrvsubapptbls value
	 */
	public void setEtrTrvsubapptbls (java.util.Set<jkt.hrms.masters.business.EtrTrvsubapptbl> etrTrvsubapptbls) {
		this.etrTrvsubapptbls = etrTrvsubapptbls;
	}

	public void addToEtrTrvsubapptbls (jkt.hrms.masters.business.EtrTrvsubapptbl etrTrvsubapptbl) {
		if (null == getEtrTrvsubapptbls()) setEtrTrvsubapptbls(new java.util.TreeSet<jkt.hrms.masters.business.EtrTrvsubapptbl>());
		getEtrTrvsubapptbls().add(etrTrvsubapptbl);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrExpsubmit)) return false;
		else {
			jkt.hrms.masters.business.EtrExpsubmit etrExpsubmit = (jkt.hrms.masters.business.EtrExpsubmit) obj;
			if (null == this.getId() || null == etrExpsubmit.getId()) return false;
			else return (this.getId().equals(etrExpsubmit.getId()));
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