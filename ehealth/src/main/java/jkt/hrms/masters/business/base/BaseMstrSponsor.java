package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_sponsor table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_sponsor"
 */

public abstract class BaseMstrSponsor  implements Serializable {

	public static String REF = "MstrSponsor";
	public static String PROP_SPONSOR_GROUP = "SponsorGroup";
	public static String PROP_SPONSOR_ANNTRUNOVER = "SponsorAnntrunover";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SPONSOR_NAME = "SponsorName";
	public static String PROP_SPONSOR_FAX_NO = "SponsorFaxNo";
	public static String PROP_SPONSOR_OTHONGOINGPRJ = "SponsorOthongoingprj";
	public static String PROP_SPONSOR_TOT_NO_EMP = "SponsorTotNoEmp";
	public static String PROP_SPONSER_TYPE = "SponserType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SPONSOR_CNT_NO = "SponsorCntNo";
	public static String PROP_SPONSOR_WEBSITE = "SponsorWebsite";
	public static String PROP_SPONSOR_COMMENTS = "SponsorComments";
	public static String PROP_SPONSOR_ADDRESS = "SponsorAddress";
	public static String PROP_SPONSOR_EMAIL_ID = "SponsorEmailId";
	public static String PROP_SPONSOR_OTHGRPCOM = "SponsorOthgrpcom";
	public static String PROP_SPONSOR_ANN_REV = "SponsorAnnRev";
	public static String PROP_ID = "Id";
	public static String PROP_SPONSOR_ACCOUNTNO = "SponsorAccountno";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SPONSOR_CODE = "SponsorCode";


	// constructors
	public BaseMstrSponsor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrSponsor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sponsorName;
	private java.lang.String sponsorGroup;
	private java.lang.String sponsorAccountno;
	private java.lang.String sponsorCntNo;
	private java.lang.String sponsorEmailId;
	private java.lang.String sponsorWebsite;
	private java.lang.String sponsorFaxNo;
	private java.lang.String sponsorAddress;
	private java.lang.String sponsorComments;
	private java.lang.String status;
	private java.lang.String sponsorAnnRev;
	private java.lang.String sponsorOthgrpcom;
	private java.lang.Integer sponsorTotNoEmp;
	private java.lang.String sponsorOthongoingprj;
	private java.lang.String sponsorAnntrunover;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String sponsorCode;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrSponsortype sponserType;

	// collections
	private java.util.Set<jkt.hrms.masters.business.MstrTherapeutic> thp;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="sponsor_id"
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
	 * Return the value associated with the column: sponsor_name
	 */
	public java.lang.String getSponsorName () {
		return sponsorName;
	}

	/**
	 * Set the value related to the column: sponsor_name
	 * @param sponsorName the sponsor_name value
	 */
	public void setSponsorName (java.lang.String sponsorName) {
		this.sponsorName = sponsorName;
	}



	/**
	 * Return the value associated with the column: sponsor_group
	 */
	public java.lang.String getSponsorGroup () {
		return sponsorGroup;
	}

	/**
	 * Set the value related to the column: sponsor_group
	 * @param sponsorGroup the sponsor_group value
	 */
	public void setSponsorGroup (java.lang.String sponsorGroup) {
		this.sponsorGroup = sponsorGroup;
	}



	/**
	 * Return the value associated with the column: sponsor_accountNo
	 */
	public java.lang.String getSponsorAccountno () {
		return sponsorAccountno;
	}

	/**
	 * Set the value related to the column: sponsor_accountNo
	 * @param sponsorAccountno the sponsor_accountNo value
	 */
	public void setSponsorAccountno (java.lang.String sponsorAccountno) {
		this.sponsorAccountno = sponsorAccountno;
	}



	/**
	 * Return the value associated with the column: sponsor_cnt_no
	 */
	public java.lang.String getSponsorCntNo () {
		return sponsorCntNo;
	}

	/**
	 * Set the value related to the column: sponsor_cnt_no
	 * @param sponsorCntNo the sponsor_cnt_no value
	 */
	public void setSponsorCntNo (java.lang.String sponsorCntNo) {
		this.sponsorCntNo = sponsorCntNo;
	}



	/**
	 * Return the value associated with the column: sponsor_email_id
	 */
	public java.lang.String getSponsorEmailId () {
		return sponsorEmailId;
	}

	/**
	 * Set the value related to the column: sponsor_email_id
	 * @param sponsorEmailId the sponsor_email_id value
	 */
	public void setSponsorEmailId (java.lang.String sponsorEmailId) {
		this.sponsorEmailId = sponsorEmailId;
	}



	/**
	 * Return the value associated with the column: sponsor_website
	 */
	public java.lang.String getSponsorWebsite () {
		return sponsorWebsite;
	}

	/**
	 * Set the value related to the column: sponsor_website
	 * @param sponsorWebsite the sponsor_website value
	 */
	public void setSponsorWebsite (java.lang.String sponsorWebsite) {
		this.sponsorWebsite = sponsorWebsite;
	}



	/**
	 * Return the value associated with the column: sponsor_fax_no
	 */
	public java.lang.String getSponsorFaxNo () {
		return sponsorFaxNo;
	}

	/**
	 * Set the value related to the column: sponsor_fax_no
	 * @param sponsorFaxNo the sponsor_fax_no value
	 */
	public void setSponsorFaxNo (java.lang.String sponsorFaxNo) {
		this.sponsorFaxNo = sponsorFaxNo;
	}



	/**
	 * Return the value associated with the column: sponsor_address
	 */
	public java.lang.String getSponsorAddress () {
		return sponsorAddress;
	}

	/**
	 * Set the value related to the column: sponsor_address
	 * @param sponsorAddress the sponsor_address value
	 */
	public void setSponsorAddress (java.lang.String sponsorAddress) {
		this.sponsorAddress = sponsorAddress;
	}



	/**
	 * Return the value associated with the column: sponsor_comments
	 */
	public java.lang.String getSponsorComments () {
		return sponsorComments;
	}

	/**
	 * Set the value related to the column: sponsor_comments
	 * @param sponsorComments the sponsor_comments value
	 */
	public void setSponsorComments (java.lang.String sponsorComments) {
		this.sponsorComments = sponsorComments;
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
	 * Return the value associated with the column: sponsor_ann_rev
	 */
	public java.lang.String getSponsorAnnRev () {
		return sponsorAnnRev;
	}

	/**
	 * Set the value related to the column: sponsor_ann_rev
	 * @param sponsorAnnRev the sponsor_ann_rev value
	 */
	public void setSponsorAnnRev (java.lang.String sponsorAnnRev) {
		this.sponsorAnnRev = sponsorAnnRev;
	}



	/**
	 * Return the value associated with the column: sponsor_othgrpcom
	 */
	public java.lang.String getSponsorOthgrpcom () {
		return sponsorOthgrpcom;
	}

	/**
	 * Set the value related to the column: sponsor_othgrpcom
	 * @param sponsorOthgrpcom the sponsor_othgrpcom value
	 */
	public void setSponsorOthgrpcom (java.lang.String sponsorOthgrpcom) {
		this.sponsorOthgrpcom = sponsorOthgrpcom;
	}



	/**
	 * Return the value associated with the column: sponsor_tot_no_emp
	 */
	public java.lang.Integer getSponsorTotNoEmp () {
		return sponsorTotNoEmp;
	}

	/**
	 * Set the value related to the column: sponsor_tot_no_emp
	 * @param sponsorTotNoEmp the sponsor_tot_no_emp value
	 */
	public void setSponsorTotNoEmp (java.lang.Integer sponsorTotNoEmp) {
		this.sponsorTotNoEmp = sponsorTotNoEmp;
	}



	/**
	 * Return the value associated with the column: sponsor_othongoingprj
	 */
	public java.lang.String getSponsorOthongoingprj () {
		return sponsorOthongoingprj;
	}

	/**
	 * Set the value related to the column: sponsor_othongoingprj
	 * @param sponsorOthongoingprj the sponsor_othongoingprj value
	 */
	public void setSponsorOthongoingprj (java.lang.String sponsorOthongoingprj) {
		this.sponsorOthongoingprj = sponsorOthongoingprj;
	}



	/**
	 * Return the value associated with the column: sponsor_anntrunover
	 */
	public java.lang.String getSponsorAnntrunover () {
		return sponsorAnntrunover;
	}

	/**
	 * Set the value related to the column: sponsor_anntrunover
	 * @param sponsorAnntrunover the sponsor_anntrunover value
	 */
	public void setSponsorAnntrunover (java.lang.String sponsorAnntrunover) {
		this.sponsorAnntrunover = sponsorAnntrunover;
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
	 * Return the value associated with the column: sponsor_code
	 */
	public java.lang.String getSponsorCode () {
		return sponsorCode;
	}

	/**
	 * Set the value related to the column: sponsor_code
	 * @param sponsorCode the sponsor_code value
	 */
	public void setSponsorCode (java.lang.String sponsorCode) {
		this.sponsorCode = sponsorCode;
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
	 * Return the value associated with the column: sponser_type_id
	 */
	public jkt.hrms.masters.business.MstrSponsortype getSponserType () {
		return sponserType;
	}

	/**
	 * Set the value related to the column: sponser_type_id
	 * @param sponserType the sponser_type_id value
	 */
	public void setSponserType (jkt.hrms.masters.business.MstrSponsortype sponserType) {
		this.sponserType = sponserType;
	}



	/**
	 * Return the value associated with the column: Thp
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrTherapeutic> getThp () {
		return thp;
	}

	/**
	 * Set the value related to the column: Thp
	 * @param thp the Thp value
	 */
	public void setThp (java.util.Set<jkt.hrms.masters.business.MstrTherapeutic> thp) {
		this.thp = thp;
	}

	public void addToThp (jkt.hrms.masters.business.MstrTherapeutic mstrTherapeutic) {
		if (null == getThp()) setThp(new java.util.TreeSet<jkt.hrms.masters.business.MstrTherapeutic>());
		getThp().add(mstrTherapeutic);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrSponsor)) return false;
		else {
			jkt.hrms.masters.business.MstrSponsor mstrSponsor = (jkt.hrms.masters.business.MstrSponsor) obj;
			if (null == this.getId() || null == mstrSponsor.getId()) return false;
			else return (this.getId().equals(mstrSponsor.getId()));
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