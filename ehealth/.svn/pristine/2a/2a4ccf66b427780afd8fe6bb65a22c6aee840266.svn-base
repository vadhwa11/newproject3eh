package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_project table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_project"
 */

public abstract class BaseMstrProject  implements Serializable {

	public static String REF = "MstrProject";
	public static String PROP_PROJECT_STATUS = "ProjectStatus";
	public static String PROP_PRJ_FLAG_DUPLICATE = "PrjFlagDuplicate";
	public static String PROP_BILLABLE = "Billable";
	public static String PROP_PRJ_CODE = "PrjCode";
	public static String PROP_PRJ_BILLABLE_SEQ = "PrjBillableSeq";
	public static String PROP_PURCHAS_ORDER_DATE = "PurchasOrderDate";
	public static String PROP_PRJ_STDT = "PrjStdt";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRJ_DESC = "PrjDesc";
	public static String PROP_PRJ_APP_DATE = "PrjAppDate";
	public static String PROP_PURCHASE_ORDER_NO = "PurchaseOrderNo";
	public static String PROP_PRJ_LOIDT = "PrjLoidt";
	public static String PROP_PRJ_EXPECTEDBUDGET = "PrjExpectedbudget";
	public static String PROP_PROJECT_TYPE = "ProjectType";
	public static String PROP_EXTENSION = "Extension";
	public static String PROP_PRJ_APPCMTS = "PrjAppcmts";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PRJ_NON_BILLABLE_SEQ = "PrjNonBillableSeq";
	public static String PROP_CONTRACT_DATE = "ContractDate";
	public static String PROP_PRJ_NAME = "PrjName";
	public static String PROP_THP = "Thp";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TRIAL_PHASE = "TrialPhase";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_PRJ_EDDT = "PrjEddt";
	public static String PROP_PROJECT_EXTENSION = "ProjectExtension";
	public static String PROP_SPONSOR = "Sponsor";
	public static String PROP_PRJ_PROTOCALNO = "PrjProtocalno";
	public static String PROP_PRJ_APPRID = "PrjApprid";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CONTRACT_NO = "ContractNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_PRJ_LOINO = "PrjLoino";
	public static String PROP_ID = "Id";
	public static String PROP_PRJ_APPSTATUS = "PrjAppstatus";


	// constructors
	public BaseMstrProject () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrProject (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String prjName;
	private java.lang.String prjDesc;
	private java.lang.String prjCode;
	private java.lang.String prjProtocalno;
	private java.lang.String prjLoino;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date prjLoidt;
	private java.util.Date prjStdt;
	private java.util.Date prjEddt;
	private java.lang.String prjAppcmts;
	private java.lang.String prjAppstatus;
	private java.math.BigDecimal prjExpectedbudget;
	private java.lang.String billable;
	private java.lang.String purchaseOrderNo;
	private java.util.Date purchasOrderDate;
	private java.lang.String contractNo;
	private java.util.Date contractDate;
	private java.lang.String status;
	private java.lang.String prjFlagDuplicate;
	private java.util.Date prjAppDate;
	private java.lang.Integer prjBillableSeq;
	private java.lang.Integer prjNonBillableSeq;
	private java.lang.String extension;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrTherapeutic thp;
	private jkt.hms.masters.business.MasCurrency currency;
	private jkt.hrms.masters.business.MstrSponsor sponsor;
	private jkt.hrms.masters.business.MstrProjectStatus projectStatus;
	private jkt.hrms.masters.business.MstrProject projectExtension;
	private jkt.hms.masters.business.MasEmployee prjApprid;
	private jkt.hrms.masters.business.MstrProjecttype projectType;
	private jkt.hrms.masters.business.MstrTrialphase trialPhase;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Prj_Id"
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
	 * Return the value associated with the column: Prj_Name
	 */
	public java.lang.String getPrjName () {
		return prjName;
	}

	/**
	 * Set the value related to the column: Prj_Name
	 * @param prjName the Prj_Name value
	 */
	public void setPrjName (java.lang.String prjName) {
		this.prjName = prjName;
	}



	/**
	 * Return the value associated with the column: Prj_Desc
	 */
	public java.lang.String getPrjDesc () {
		return prjDesc;
	}

	/**
	 * Set the value related to the column: Prj_Desc
	 * @param prjDesc the Prj_Desc value
	 */
	public void setPrjDesc (java.lang.String prjDesc) {
		this.prjDesc = prjDesc;
	}



	/**
	 * Return the value associated with the column: Prj_Code
	 */
	public java.lang.String getPrjCode () {
		return prjCode;
	}

	/**
	 * Set the value related to the column: Prj_Code
	 * @param prjCode the Prj_Code value
	 */
	public void setPrjCode (java.lang.String prjCode) {
		this.prjCode = prjCode;
	}



	/**
	 * Return the value associated with the column: Prj_ProtocalNo
	 */
	public java.lang.String getPrjProtocalno () {
		return prjProtocalno;
	}

	/**
	 * Set the value related to the column: Prj_ProtocalNo
	 * @param prjProtocalno the Prj_ProtocalNo value
	 */
	public void setPrjProtocalno (java.lang.String prjProtocalno) {
		this.prjProtocalno = prjProtocalno;
	}



	/**
	 * Return the value associated with the column: Prj_LOINo
	 */
	public java.lang.String getPrjLoino () {
		return prjLoino;
	}

	/**
	 * Set the value related to the column: Prj_LOINo
	 * @param prjLoino the Prj_LOINo value
	 */
	public void setPrjLoino (java.lang.String prjLoino) {
		this.prjLoino = prjLoino;
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
	 * Return the value associated with the column: Prj_LOIDt
	 */
	public java.util.Date getPrjLoidt () {
		return prjLoidt;
	}

	/**
	 * Set the value related to the column: Prj_LOIDt
	 * @param prjLoidt the Prj_LOIDt value
	 */
	public void setPrjLoidt (java.util.Date prjLoidt) {
		this.prjLoidt = prjLoidt;
	}



	/**
	 * Return the value associated with the column: Prj_StDt
	 */
	public java.util.Date getPrjStdt () {
		return prjStdt;
	}

	/**
	 * Set the value related to the column: Prj_StDt
	 * @param prjStdt the Prj_StDt value
	 */
	public void setPrjStdt (java.util.Date prjStdt) {
		this.prjStdt = prjStdt;
	}



	/**
	 * Return the value associated with the column: Prj_EdDt
	 */
	public java.util.Date getPrjEddt () {
		return prjEddt;
	}

	/**
	 * Set the value related to the column: Prj_EdDt
	 * @param prjEddt the Prj_EdDt value
	 */
	public void setPrjEddt (java.util.Date prjEddt) {
		this.prjEddt = prjEddt;
	}



	/**
	 * Return the value associated with the column: Prj_AppCmts
	 */
	public java.lang.String getPrjAppcmts () {
		return prjAppcmts;
	}

	/**
	 * Set the value related to the column: Prj_AppCmts
	 * @param prjAppcmts the Prj_AppCmts value
	 */
	public void setPrjAppcmts (java.lang.String prjAppcmts) {
		this.prjAppcmts = prjAppcmts;
	}



	/**
	 * Return the value associated with the column: Prj_AppStatus
	 */
	public java.lang.String getPrjAppstatus () {
		return prjAppstatus;
	}

	/**
	 * Set the value related to the column: Prj_AppStatus
	 * @param prjAppstatus the Prj_AppStatus value
	 */
	public void setPrjAppstatus (java.lang.String prjAppstatus) {
		this.prjAppstatus = prjAppstatus;
	}



	/**
	 * Return the value associated with the column: Prj_expectedbudget
	 */
	public java.math.BigDecimal getPrjExpectedbudget () {
		return prjExpectedbudget;
	}

	/**
	 * Set the value related to the column: Prj_expectedbudget
	 * @param prjExpectedbudget the Prj_expectedbudget value
	 */
	public void setPrjExpectedbudget (java.math.BigDecimal prjExpectedbudget) {
		this.prjExpectedbudget = prjExpectedbudget;
	}



	/**
	 * Return the value associated with the column: Billable
	 */
	public java.lang.String getBillable () {
		return billable;
	}

	/**
	 * Set the value related to the column: Billable
	 * @param billable the Billable value
	 */
	public void setBillable (java.lang.String billable) {
		this.billable = billable;
	}



	/**
	 * Return the value associated with the column: purchase_order_no
	 */
	public java.lang.String getPurchaseOrderNo () {
		return purchaseOrderNo;
	}

	/**
	 * Set the value related to the column: purchase_order_no
	 * @param purchaseOrderNo the purchase_order_no value
	 */
	public void setPurchaseOrderNo (java.lang.String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}



	/**
	 * Return the value associated with the column: purchas_order_date
	 */
	public java.util.Date getPurchasOrderDate () {
		return purchasOrderDate;
	}

	/**
	 * Set the value related to the column: purchas_order_date
	 * @param purchasOrderDate the purchas_order_date value
	 */
	public void setPurchasOrderDate (java.util.Date purchasOrderDate) {
		this.purchasOrderDate = purchasOrderDate;
	}



	/**
	 * Return the value associated with the column: contract_no
	 */
	public java.lang.String getContractNo () {
		return contractNo;
	}

	/**
	 * Set the value related to the column: contract_no
	 * @param contractNo the contract_no value
	 */
	public void setContractNo (java.lang.String contractNo) {
		this.contractNo = contractNo;
	}



	/**
	 * Return the value associated with the column: contract_date
	 */
	public java.util.Date getContractDate () {
		return contractDate;
	}

	/**
	 * Set the value related to the column: contract_date
	 * @param contractDate the contract_date value
	 */
	public void setContractDate (java.util.Date contractDate) {
		this.contractDate = contractDate;
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
	 * Return the value associated with the column: prj_flag_duplicate
	 */
	public java.lang.String getPrjFlagDuplicate () {
		return prjFlagDuplicate;
	}

	/**
	 * Set the value related to the column: prj_flag_duplicate
	 * @param prjFlagDuplicate the prj_flag_duplicate value
	 */
	public void setPrjFlagDuplicate (java.lang.String prjFlagDuplicate) {
		this.prjFlagDuplicate = prjFlagDuplicate;
	}



	/**
	 * Return the value associated with the column: prj_app_date
	 */
	public java.util.Date getPrjAppDate () {
		return prjAppDate;
	}

	/**
	 * Set the value related to the column: prj_app_date
	 * @param prjAppDate the prj_app_date value
	 */
	public void setPrjAppDate (java.util.Date prjAppDate) {
		this.prjAppDate = prjAppDate;
	}



	/**
	 * Return the value associated with the column: prj_billable_seq
	 */
	public java.lang.Integer getPrjBillableSeq () {
		return prjBillableSeq;
	}

	/**
	 * Set the value related to the column: prj_billable_seq
	 * @param prjBillableSeq the prj_billable_seq value
	 */
	public void setPrjBillableSeq (java.lang.Integer prjBillableSeq) {
		this.prjBillableSeq = prjBillableSeq;
	}



	/**
	 * Return the value associated with the column: prj_non_billable_seq
	 */
	public java.lang.Integer getPrjNonBillableSeq () {
		return prjNonBillableSeq;
	}

	/**
	 * Set the value related to the column: prj_non_billable_seq
	 * @param prjNonBillableSeq the prj_non_billable_seq value
	 */
	public void setPrjNonBillableSeq (java.lang.Integer prjNonBillableSeq) {
		this.prjNonBillableSeq = prjNonBillableSeq;
	}



	/**
	 * Return the value associated with the column: extension
	 */
	public java.lang.String getExtension () {
		return extension;
	}

	/**
	 * Set the value related to the column: extension
	 * @param extension the extension value
	 */
	public void setExtension (java.lang.String extension) {
		this.extension = extension;
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
	 * Return the value associated with the column: thp_id
	 */
	public jkt.hrms.masters.business.MstrTherapeutic getThp () {
		return thp;
	}

	/**
	 * Set the value related to the column: thp_id
	 * @param thp the thp_id value
	 */
	public void setThp (jkt.hrms.masters.business.MstrTherapeutic thp) {
		this.thp = thp;
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
	 * Return the value associated with the column: sponsor_id
	 */
	public jkt.hrms.masters.business.MstrSponsor getSponsor () {
		return sponsor;
	}

	/**
	 * Set the value related to the column: sponsor_id
	 * @param sponsor the sponsor_id value
	 */
	public void setSponsor (jkt.hrms.masters.business.MstrSponsor sponsor) {
		this.sponsor = sponsor;
	}



	/**
	 * Return the value associated with the column: project_status_id
	 */
	public jkt.hrms.masters.business.MstrProjectStatus getProjectStatus () {
		return projectStatus;
	}

	/**
	 * Set the value related to the column: project_status_id
	 * @param projectStatus the project_status_id value
	 */
	public void setProjectStatus (jkt.hrms.masters.business.MstrProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}



	/**
	 * Return the value associated with the column: project_extension_id
	 */
	public jkt.hrms.masters.business.MstrProject getProjectExtension () {
		return projectExtension;
	}

	/**
	 * Set the value related to the column: project_extension_id
	 * @param projectExtension the project_extension_id value
	 */
	public void setProjectExtension (jkt.hrms.masters.business.MstrProject projectExtension) {
		this.projectExtension = projectExtension;
	}



	/**
	 * Return the value associated with the column: Prj_ApprID
	 */
	public jkt.hms.masters.business.MasEmployee getPrjApprid () {
		return prjApprid;
	}

	/**
	 * Set the value related to the column: Prj_ApprID
	 * @param prjApprid the Prj_ApprID value
	 */
	public void setPrjApprid (jkt.hms.masters.business.MasEmployee prjApprid) {
		this.prjApprid = prjApprid;
	}



	/**
	 * Return the value associated with the column: project_type_id
	 */
	public jkt.hrms.masters.business.MstrProjecttype getProjectType () {
		return projectType;
	}

	/**
	 * Set the value related to the column: project_type_id
	 * @param projectType the project_type_id value
	 */
	public void setProjectType (jkt.hrms.masters.business.MstrProjecttype projectType) {
		this.projectType = projectType;
	}



	/**
	 * Return the value associated with the column: trial_phase_id
	 */
	public jkt.hrms.masters.business.MstrTrialphase getTrialPhase () {
		return trialPhase;
	}

	/**
	 * Set the value related to the column: trial_phase_id
	 * @param trialPhase the trial_phase_id value
	 */
	public void setTrialPhase (jkt.hrms.masters.business.MstrTrialphase trialPhase) {
		this.trialPhase = trialPhase;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrProject)) return false;
		else {
			jkt.hrms.masters.business.MstrProject mstrProject = (jkt.hrms.masters.business.MstrProject) obj;
			if (null == this.getId() || null == mstrProject.getId()) return false;
			else return (this.getId().equals(mstrProject.getId()));
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