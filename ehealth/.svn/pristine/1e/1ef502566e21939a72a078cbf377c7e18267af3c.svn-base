package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_travelreq table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_travelreq"
 */

public abstract class BaseEtrTravelreq  implements Serializable {

	public static String REF = "EtrTravelreq";
	public static String PROP_PROJECT_TRIP = "ProjectTrip";
	public static String PROP_ADVCURID = "Advcurid";
	public static String PROP_ADV_STR_STS = "AdvStrSts";
	public static String PROP_ADV_ACTS = "AdvActs";
	public static String PROP_PRJ = "Prj";
	public static String PROP_JFDATE = "Jfdate";
	public static String PROP_SUBMIT_EXPENSE_TIME = "SubmitExpenseTime";
	public static String PROP_HOTEL_DESC = "HotelDesc";
	public static String PROP_N_A_F_TICKET = "NAFTicket";
	public static String PROP_EXP_CLAIM_STS = "ExpClaimSts";
	public static String PROP_TRIP = "Trip";
	public static String PROP_AVD_REQ = "AvdReq";
	public static String PROP_DISBURSEMENT_DATE = "DisbursementDate";
	public static String PROP_EMP = "Emp";
	public static String PROP_ADVANCE_PAID_AMT = "AdvancePaidAmt";
	public static String PROP_BOOKERID = "Bookerid";
	public static String PROP_LOCAL_CAB_DESC = "LocalCabDesc";
	public static String PROP_SUBMIT_EXPENSE_DATE = "SubmitExpenseDate";
	public static String PROP_ADVANCE_PAID_TIME = "AdvancePaidTime";
	public static String PROP_ADV_DESC = "AdvDesc";
	public static String PROP_EXP_ACTSID = "ExpActsid";
	public static String PROP_CREATED_AT = "CreatedAt";
	public static String PROP_N_A_F_HOTEL = "NAFHotel";
	public static String PROP_SITE = "Site";
	public static String PROP_MODIFIED_AT = "ModifiedAt";
	public static String PROP_ADV_EXP_DATE = "AdvExpDate";
	public static String PROP_CNCL_CMTS = "CnclCmts";
	public static String PROP_TRAVEL_RESQUEST_STATUS = "TravelResquestStatus";
	public static String PROP_ADVANCE_PAID_DATE = "AdvancePaidDate";
	public static String PROP_N_A_F_LOCAL_CAB = "NAFLocalCab";
	public static String PROP_MODIFIED_BY = "ModifiedBy";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_JTDATE = "Jtdate";
	public static String PROP_TRV_STATUS = "TrvStatus";
	public static String PROP_BOOK_STATUS = "BookStatus";
	public static String PROP_MODE_OF_PAYMENT = "ModeOfPayment";
	public static String PROP_ADV_AMT = "AdvAmt";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_ADV_STATUS = "AdvStatus";
	public static String PROP_ID = "Id";
	public static String PROP_REF_NO = "RefNo";


	// constructors
	public BaseEtrTravelreq () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrTravelreq (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String refNo;
	private java.lang.String nAFTicket;
	private java.lang.String nAFHotel;
	private java.lang.String nAFLocalCab;
	private java.lang.Integer projectTrip;
	private java.lang.String modeOfPayment;
	private java.util.Date disbursementDate;
	private java.util.Date advancePaidDate;
	private java.lang.String advancePaidTime;
	private java.util.Date createdAt;
	private java.util.Date modifiedAt;
	private java.lang.String trvStatus;
	private java.lang.String advStatus;
	private java.lang.String hotelDesc;
	private java.lang.String localCabDesc;
	private java.math.BigDecimal advAmt;
	private java.lang.String advDesc;
	private java.util.Date advExpDate;
	private java.lang.String avdReq;
	private java.util.Date jfdate;
	private java.util.Date jtdate;
	private java.lang.String advStrSts;
	private java.lang.String bookStatus;
	private java.lang.String expClaimSts;
	private java.lang.String cnclCmts;
	private java.math.BigDecimal advancePaidAmt;
	private java.lang.String comment;
	private java.lang.String travelResquestStatus;
	private java.util.Date submitExpenseDate;
	private java.lang.String submitExpenseTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee bookerid;
	private jkt.hms.masters.business.MasEmployee advActs;
	private jkt.hms.masters.business.MasEmployee modifiedBy;
	private jkt.hrms.masters.business.MstrSiteHeader site;
	private jkt.hms.masters.business.MasCurrency advcurid;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.MasEmployee createdBy;
	private jkt.hms.masters.business.MasEmployee expActsid;
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hrms.masters.business.MstrCode trip;

	// collections
	private java.util.Set<jkt.hrms.masters.business.EtrTrvreqcmts> etrTrvreqcmts;
	private java.util.Set<jkt.hrms.masters.business.EtrApptbl> etrApptbls;
	private java.util.Set<jkt.hrms.masters.business.EtrFillbookeddtls> etrFillbookeddtls;
	private java.util.Set<jkt.hrms.masters.business.TempTickattach> tempTickattachs;
	private java.util.Set<jkt.hrms.masters.business.EtrTrvdetails> etrTrvdetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="Etr_id"
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
	 * Return the value associated with the column: RefNo
	 */
	public java.lang.String getRefNo () {
		return refNo;
	}

	/**
	 * Set the value related to the column: RefNo
	 * @param refNo the RefNo value
	 */
	public void setRefNo (java.lang.String refNo) {
		this.refNo = refNo;
	}



	/**
	 * Return the value associated with the column: NAFTicket
	 */
	public java.lang.String getNAFTicket () {
		return nAFTicket;
	}

	/**
	 * Set the value related to the column: NAFTicket
	 * @param nAFTicket the NAFTicket value
	 */
	public void setNAFTicket (java.lang.String nAFTicket) {
		this.nAFTicket = nAFTicket;
	}



	/**
	 * Return the value associated with the column: NAFHotel
	 */
	public java.lang.String getNAFHotel () {
		return nAFHotel;
	}

	/**
	 * Set the value related to the column: NAFHotel
	 * @param nAFHotel the NAFHotel value
	 */
	public void setNAFHotel (java.lang.String nAFHotel) {
		this.nAFHotel = nAFHotel;
	}



	/**
	 * Return the value associated with the column: NAFLocalCab
	 */
	public java.lang.String getNAFLocalCab () {
		return nAFLocalCab;
	}

	/**
	 * Set the value related to the column: NAFLocalCab
	 * @param nAFLocalCab the NAFLocalCab value
	 */
	public void setNAFLocalCab (java.lang.String nAFLocalCab) {
		this.nAFLocalCab = nAFLocalCab;
	}



	/**
	 * Return the value associated with the column: ProjectTrip
	 */
	public java.lang.Integer getProjectTrip () {
		return projectTrip;
	}

	/**
	 * Set the value related to the column: ProjectTrip
	 * @param projectTrip the ProjectTrip value
	 */
	public void setProjectTrip (java.lang.Integer projectTrip) {
		this.projectTrip = projectTrip;
	}



	/**
	 * Return the value associated with the column: mode_of_payment
	 */
	public java.lang.String getModeOfPayment () {
		return modeOfPayment;
	}

	/**
	 * Set the value related to the column: mode_of_payment
	 * @param modeOfPayment the mode_of_payment value
	 */
	public void setModeOfPayment (java.lang.String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}



	/**
	 * Return the value associated with the column: disbursement_date
	 */
	public java.util.Date getDisbursementDate () {
		return disbursementDate;
	}

	/**
	 * Set the value related to the column: disbursement_date
	 * @param disbursementDate the disbursement_date value
	 */
	public void setDisbursementDate (java.util.Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}



	/**
	 * Return the value associated with the column: advance_paid_date
	 */
	public java.util.Date getAdvancePaidDate () {
		return advancePaidDate;
	}

	/**
	 * Set the value related to the column: advance_paid_date
	 * @param advancePaidDate the advance_paid_date value
	 */
	public void setAdvancePaidDate (java.util.Date advancePaidDate) {
		this.advancePaidDate = advancePaidDate;
	}



	/**
	 * Return the value associated with the column: advance_paid_time
	 */
	public java.lang.String getAdvancePaidTime () {
		return advancePaidTime;
	}

	/**
	 * Set the value related to the column: advance_paid_time
	 * @param advancePaidTime the advance_paid_time value
	 */
	public void setAdvancePaidTime (java.lang.String advancePaidTime) {
		this.advancePaidTime = advancePaidTime;
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
	 * Return the value associated with the column: Trv_Status
	 */
	public java.lang.String getTrvStatus () {
		return trvStatus;
	}

	/**
	 * Set the value related to the column: Trv_Status
	 * @param trvStatus the Trv_Status value
	 */
	public void setTrvStatus (java.lang.String trvStatus) {
		this.trvStatus = trvStatus;
	}



	/**
	 * Return the value associated with the column: Adv_status
	 */
	public java.lang.String getAdvStatus () {
		return advStatus;
	}

	/**
	 * Set the value related to the column: Adv_status
	 * @param advStatus the Adv_status value
	 */
	public void setAdvStatus (java.lang.String advStatus) {
		this.advStatus = advStatus;
	}



	/**
	 * Return the value associated with the column: HotelDesc
	 */
	public java.lang.String getHotelDesc () {
		return hotelDesc;
	}

	/**
	 * Set the value related to the column: HotelDesc
	 * @param hotelDesc the HotelDesc value
	 */
	public void setHotelDesc (java.lang.String hotelDesc) {
		this.hotelDesc = hotelDesc;
	}



	/**
	 * Return the value associated with the column: LocalCabDesc
	 */
	public java.lang.String getLocalCabDesc () {
		return localCabDesc;
	}

	/**
	 * Set the value related to the column: LocalCabDesc
	 * @param localCabDesc the LocalCabDesc value
	 */
	public void setLocalCabDesc (java.lang.String localCabDesc) {
		this.localCabDesc = localCabDesc;
	}



	/**
	 * Return the value associated with the column: AdvAmt
	 */
	public java.math.BigDecimal getAdvAmt () {
		return advAmt;
	}

	/**
	 * Set the value related to the column: AdvAmt
	 * @param advAmt the AdvAmt value
	 */
	public void setAdvAmt (java.math.BigDecimal advAmt) {
		this.advAmt = advAmt;
	}



	/**
	 * Return the value associated with the column: AdvDesc
	 */
	public java.lang.String getAdvDesc () {
		return advDesc;
	}

	/**
	 * Set the value related to the column: AdvDesc
	 * @param advDesc the AdvDesc value
	 */
	public void setAdvDesc (java.lang.String advDesc) {
		this.advDesc = advDesc;
	}



	/**
	 * Return the value associated with the column: AdvExpDate
	 */
	public java.util.Date getAdvExpDate () {
		return advExpDate;
	}

	/**
	 * Set the value related to the column: AdvExpDate
	 * @param advExpDate the AdvExpDate value
	 */
	public void setAdvExpDate (java.util.Date advExpDate) {
		this.advExpDate = advExpDate;
	}



	/**
	 * Return the value associated with the column: AvdReq
	 */
	public java.lang.String getAvdReq () {
		return avdReq;
	}

	/**
	 * Set the value related to the column: AvdReq
	 * @param avdReq the AvdReq value
	 */
	public void setAvdReq (java.lang.String avdReq) {
		this.avdReq = avdReq;
	}



	/**
	 * Return the value associated with the column: jfdate
	 */
	public java.util.Date getJfdate () {
		return jfdate;
	}

	/**
	 * Set the value related to the column: jfdate
	 * @param jfdate the jfdate value
	 */
	public void setJfdate (java.util.Date jfdate) {
		this.jfdate = jfdate;
	}



	/**
	 * Return the value associated with the column: jtdate
	 */
	public java.util.Date getJtdate () {
		return jtdate;
	}

	/**
	 * Set the value related to the column: jtdate
	 * @param jtdate the jtdate value
	 */
	public void setJtdate (java.util.Date jtdate) {
		this.jtdate = jtdate;
	}



	/**
	 * Return the value associated with the column: AdvStrSts
	 */
	public java.lang.String getAdvStrSts () {
		return advStrSts;
	}

	/**
	 * Set the value related to the column: AdvStrSts
	 * @param advStrSts the AdvStrSts value
	 */
	public void setAdvStrSts (java.lang.String advStrSts) {
		this.advStrSts = advStrSts;
	}



	/**
	 * Return the value associated with the column: BookStatus
	 */
	public java.lang.String getBookStatus () {
		return bookStatus;
	}

	/**
	 * Set the value related to the column: BookStatus
	 * @param bookStatus the BookStatus value
	 */
	public void setBookStatus (java.lang.String bookStatus) {
		this.bookStatus = bookStatus;
	}



	/**
	 * Return the value associated with the column: ExpClaimSts
	 */
	public java.lang.String getExpClaimSts () {
		return expClaimSts;
	}

	/**
	 * Set the value related to the column: ExpClaimSts
	 * @param expClaimSts the ExpClaimSts value
	 */
	public void setExpClaimSts (java.lang.String expClaimSts) {
		this.expClaimSts = expClaimSts;
	}



	/**
	 * Return the value associated with the column: cncl_cmts
	 */
	public java.lang.String getCnclCmts () {
		return cnclCmts;
	}

	/**
	 * Set the value related to the column: cncl_cmts
	 * @param cnclCmts the cncl_cmts value
	 */
	public void setCnclCmts (java.lang.String cnclCmts) {
		this.cnclCmts = cnclCmts;
	}



	/**
	 * Return the value associated with the column: advance_paid_amt
	 */
	public java.math.BigDecimal getAdvancePaidAmt () {
		return advancePaidAmt;
	}

	/**
	 * Set the value related to the column: advance_paid_amt
	 * @param advancePaidAmt the advance_paid_amt value
	 */
	public void setAdvancePaidAmt (java.math.BigDecimal advancePaidAmt) {
		this.advancePaidAmt = advancePaidAmt;
	}



	/**
	 * Return the value associated with the column: comment
	 */
	public java.lang.String getComment () {
		return comment;
	}

	/**
	 * Set the value related to the column: comment
	 * @param comment the comment value
	 */
	public void setComment (java.lang.String comment) {
		this.comment = comment;
	}



	/**
	 * Return the value associated with the column: travel_resquest_status
	 */
	public java.lang.String getTravelResquestStatus () {
		return travelResquestStatus;
	}

	/**
	 * Set the value related to the column: travel_resquest_status
	 * @param travelResquestStatus the travel_resquest_status value
	 */
	public void setTravelResquestStatus (java.lang.String travelResquestStatus) {
		this.travelResquestStatus = travelResquestStatus;
	}



	/**
	 * Return the value associated with the column: submit_expense_date
	 */
	public java.util.Date getSubmitExpenseDate () {
		return submitExpenseDate;
	}

	/**
	 * Set the value related to the column: submit_expense_date
	 * @param submitExpenseDate the submit_expense_date value
	 */
	public void setSubmitExpenseDate (java.util.Date submitExpenseDate) {
		this.submitExpenseDate = submitExpenseDate;
	}



	/**
	 * Return the value associated with the column: submit_expense_time
	 */
	public java.lang.String getSubmitExpenseTime () {
		return submitExpenseTime;
	}

	/**
	 * Set the value related to the column: submit_expense_time
	 * @param submitExpenseTime the submit_expense_time value
	 */
	public void setSubmitExpenseTime (java.lang.String submitExpenseTime) {
		this.submitExpenseTime = submitExpenseTime;
	}



	/**
	 * Return the value associated with the column: Bookerid
	 */
	public jkt.hms.masters.business.MasEmployee getBookerid () {
		return bookerid;
	}

	/**
	 * Set the value related to the column: Bookerid
	 * @param bookerid the Bookerid value
	 */
	public void setBookerid (jkt.hms.masters.business.MasEmployee bookerid) {
		this.bookerid = bookerid;
	}



	/**
	 * Return the value associated with the column: AdvActsId
	 */
	public jkt.hms.masters.business.MasEmployee getAdvActs () {
		return advActs;
	}

	/**
	 * Set the value related to the column: AdvActsId
	 * @param advActs the AdvActsId value
	 */
	public void setAdvActs (jkt.hms.masters.business.MasEmployee advActs) {
		this.advActs = advActs;
	}



	/**
	 * Return the value associated with the column: ModifiedBy
	 */
	public jkt.hms.masters.business.MasEmployee getModifiedBy () {
		return modifiedBy;
	}

	/**
	 * Set the value related to the column: ModifiedBy
	 * @param modifiedBy the ModifiedBy value
	 */
	public void setModifiedBy (jkt.hms.masters.business.MasEmployee modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	/**
	 * Return the value associated with the column: Site_id
	 */
	public jkt.hrms.masters.business.MstrSiteHeader getSite () {
		return site;
	}

	/**
	 * Set the value related to the column: Site_id
	 * @param site the Site_id value
	 */
	public void setSite (jkt.hrms.masters.business.MstrSiteHeader site) {
		this.site = site;
	}



	/**
	 * Return the value associated with the column: advcurid
	 */
	public jkt.hms.masters.business.MasCurrency getAdvcurid () {
		return advcurid;
	}

	/**
	 * Set the value related to the column: advcurid
	 * @param advcurid the advcurid value
	 */
	public void setAdvcurid (jkt.hms.masters.business.MasCurrency advcurid) {
		this.advcurid = advcurid;
	}



	/**
	 * Return the value associated with the column: Emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp () {
		return emp;
	}

	/**
	 * Set the value related to the column: Emp_id
	 * @param emp the Emp_id value
	 */
	public void setEmp (jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}



	/**
	 * Return the value associated with the column: CreatedBy
	 */
	public jkt.hms.masters.business.MasEmployee getCreatedBy () {
		return createdBy;
	}

	/**
	 * Set the value related to the column: CreatedBy
	 * @param createdBy the CreatedBy value
	 */
	public void setCreatedBy (jkt.hms.masters.business.MasEmployee createdBy) {
		this.createdBy = createdBy;
	}



	/**
	 * Return the value associated with the column: expActsid
	 */
	public jkt.hms.masters.business.MasEmployee getExpActsid () {
		return expActsid;
	}

	/**
	 * Set the value related to the column: expActsid
	 * @param expActsid the expActsid value
	 */
	public void setExpActsid (jkt.hms.masters.business.MasEmployee expActsid) {
		this.expActsid = expActsid;
	}



	/**
	 * Return the value associated with the column: Prj_id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: Prj_id
	 * @param prj the Prj_id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}



	/**
	 * Return the value associated with the column: Trip_id
	 */
	public jkt.hrms.masters.business.MstrCode getTrip () {
		return trip;
	}

	/**
	 * Set the value related to the column: Trip_id
	 * @param trip the Trip_id value
	 */
	public void setTrip (jkt.hrms.masters.business.MstrCode trip) {
		this.trip = trip;
	}



	/**
	 * Return the value associated with the column: EtrTrvreqcmts
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrTrvreqcmts> getEtrTrvreqcmts () {
		return etrTrvreqcmts;
	}

	/**
	 * Set the value related to the column: EtrTrvreqcmts
	 * @param etrTrvreqcmts the EtrTrvreqcmts value
	 */
	public void setEtrTrvreqcmts (java.util.Set<jkt.hrms.masters.business.EtrTrvreqcmts> etrTrvreqcmts) {
		this.etrTrvreqcmts = etrTrvreqcmts;
	}

	public void addToEtrTrvreqcmts (jkt.hrms.masters.business.EtrTrvreqcmts etrTrvreqcmts) {
		if (null == getEtrTrvreqcmts()) setEtrTrvreqcmts(new java.util.TreeSet<jkt.hrms.masters.business.EtrTrvreqcmts>());
		getEtrTrvreqcmts().add(etrTrvreqcmts);
	}



	/**
	 * Return the value associated with the column: EtrApptbls
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrApptbl> getEtrApptbls () {
		return etrApptbls;
	}

	/**
	 * Set the value related to the column: EtrApptbls
	 * @param etrApptbls the EtrApptbls value
	 */
	public void setEtrApptbls (java.util.Set<jkt.hrms.masters.business.EtrApptbl> etrApptbls) {
		this.etrApptbls = etrApptbls;
	}

	public void addToEtrApptbls (jkt.hrms.masters.business.EtrApptbl etrApptbl) {
		if (null == getEtrApptbls()) setEtrApptbls(new java.util.TreeSet<jkt.hrms.masters.business.EtrApptbl>());
		getEtrApptbls().add(etrApptbl);
	}



	/**
	 * Return the value associated with the column: EtrFillbookeddtls
	 */
	public java.util.Set<jkt.hrms.masters.business.EtrFillbookeddtls> getEtrFillbookeddtls () {
		return etrFillbookeddtls;
	}

	/**
	 * Set the value related to the column: EtrFillbookeddtls
	 * @param etrFillbookeddtls the EtrFillbookeddtls value
	 */
	public void setEtrFillbookeddtls (java.util.Set<jkt.hrms.masters.business.EtrFillbookeddtls> etrFillbookeddtls) {
		this.etrFillbookeddtls = etrFillbookeddtls;
	}

	public void addToEtrFillbookeddtls (jkt.hrms.masters.business.EtrFillbookeddtls etrFillbookeddtls) {
		if (null == getEtrFillbookeddtls()) setEtrFillbookeddtls(new java.util.TreeSet<jkt.hrms.masters.business.EtrFillbookeddtls>());
		getEtrFillbookeddtls().add(etrFillbookeddtls);
	}



	/**
	 * Return the value associated with the column: TempTickattachs
	 */
	public java.util.Set<jkt.hrms.masters.business.TempTickattach> getTempTickattachs () {
		return tempTickattachs;
	}

	/**
	 * Set the value related to the column: TempTickattachs
	 * @param tempTickattachs the TempTickattachs value
	 */
	public void setTempTickattachs (java.util.Set<jkt.hrms.masters.business.TempTickattach> tempTickattachs) {
		this.tempTickattachs = tempTickattachs;
	}

	public void addToTempTickattachs (jkt.hrms.masters.business.TempTickattach tempTickattach) {
		if (null == getTempTickattachs()) setTempTickattachs(new java.util.TreeSet<jkt.hrms.masters.business.TempTickattach>());
		getTempTickattachs().add(tempTickattach);
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
		if (!(obj instanceof jkt.hrms.masters.business.EtrTravelreq)) return false;
		else {
			jkt.hrms.masters.business.EtrTravelreq etrTravelreq = (jkt.hrms.masters.business.EtrTravelreq) obj;
			if (null == this.getId() || null == etrTravelreq.getId()) return false;
			else return (this.getId().equals(etrTravelreq.getId()));
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