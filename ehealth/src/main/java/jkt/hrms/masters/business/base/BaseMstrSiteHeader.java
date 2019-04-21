package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_site_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_site_header"
 */

public abstract class BaseMstrSiteHeader  implements Serializable {

	public static String REF = "MstrSiteHeader";
	public static String PROP_EC_FAX_NO = "EcFaxNo";
	public static String PROP_SITE_EMAIL_ID = "SiteEmailId";
	public static String PROP_SITE_FAX_NO = "SiteFaxNo";
	public static String PROP_SITE_ADDRESS = "SiteAddress";
	public static String PROP_EC_BANK = "EcBank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SITE_NAME = "SiteName";
	public static String PROP_EC_EMAIL_ID = "EcEmailId";
	public static String PROP_PEREVIOUS_ASSOCIATE = "PereviousAssociate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SITE_CODE = "SiteCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EC_PAN_NO = "EcPanNo";
	public static String PROP_EC_CONTACT_NO = "EcContactNo";
	public static String PROP_EC_CONVR_NAME = "EcConvrName";
	public static String PROP_SITE_CONTACT_NO = "SiteContactNo";
	public static String PROP_EC_AC_NO = "EcAcNo";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_EC_NAME = "EcName";
	public static String PROP_SITE_WEBSITE = "SiteWebsite";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SITE_PAN_NO = "SitePanNo";
	public static String PROP_BANK = "Bank";
	public static String PROP_STATUS = "Status";
	public static String PROP_EC_BRANCH = "EcBranch";
	public static String PROP_RATING = "Rating";
	public static String PROP_ID = "Id";
	public static String PROP_SITE_ACCOUNT_NO = "SiteAccountNo";
	public static String PROP_SITE_BRANCH = "SiteBranch";


	// constructors
	public BaseMstrSiteHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrSiteHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String siteName;
	private java.lang.String siteAddress;
	private java.lang.String siteAccountNo;
	private java.lang.String siteContactNo;
	private java.lang.String siteFaxNo;
	private java.lang.String siteEmailId;
	private java.lang.String siteWebsite;
	private java.lang.String pereviousAssociate;
	private java.lang.String sitePanNo;
	private java.lang.String siteBranch;
	private java.lang.String ecName;
	private java.lang.String ecConvrName;
	private java.lang.String ecContactNo;
	private java.lang.String ecEmailId;
	private java.lang.String ecFaxNo;
	private java.lang.String ecBranch;
	private java.lang.String ecAcNo;
	private java.lang.String ecPanNo;
	private java.lang.String comments;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String siteCode;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.MasBankMaster ecBank;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrRating rating;

	// collections
	private java.util.Set<jkt.hrms.masters.business.MstrSiteDetail> mstrSiteDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="site_header_id"
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
	 * Return the value associated with the column: site_name
	 */
	public java.lang.String getSiteName () {
		return siteName;
	}

	/**
	 * Set the value related to the column: site_name
	 * @param siteName the site_name value
	 */
	public void setSiteName (java.lang.String siteName) {
		this.siteName = siteName;
	}



	/**
	 * Return the value associated with the column: site_address
	 */
	public java.lang.String getSiteAddress () {
		return siteAddress;
	}

	/**
	 * Set the value related to the column: site_address
	 * @param siteAddress the site_address value
	 */
	public void setSiteAddress (java.lang.String siteAddress) {
		this.siteAddress = siteAddress;
	}



	/**
	 * Return the value associated with the column: site_account_no
	 */
	public java.lang.String getSiteAccountNo () {
		return siteAccountNo;
	}

	/**
	 * Set the value related to the column: site_account_no
	 * @param siteAccountNo the site_account_no value
	 */
	public void setSiteAccountNo (java.lang.String siteAccountNo) {
		this.siteAccountNo = siteAccountNo;
	}



	/**
	 * Return the value associated with the column: site_contact_no
	 */
	public java.lang.String getSiteContactNo () {
		return siteContactNo;
	}

	/**
	 * Set the value related to the column: site_contact_no
	 * @param siteContactNo the site_contact_no value
	 */
	public void setSiteContactNo (java.lang.String siteContactNo) {
		this.siteContactNo = siteContactNo;
	}



	/**
	 * Return the value associated with the column: site_fax_no
	 */
	public java.lang.String getSiteFaxNo () {
		return siteFaxNo;
	}

	/**
	 * Set the value related to the column: site_fax_no
	 * @param siteFaxNo the site_fax_no value
	 */
	public void setSiteFaxNo (java.lang.String siteFaxNo) {
		this.siteFaxNo = siteFaxNo;
	}



	/**
	 * Return the value associated with the column: site_email_id
	 */
	public java.lang.String getSiteEmailId () {
		return siteEmailId;
	}

	/**
	 * Set the value related to the column: site_email_id
	 * @param siteEmailId the site_email_id value
	 */
	public void setSiteEmailId (java.lang.String siteEmailId) {
		this.siteEmailId = siteEmailId;
	}



	/**
	 * Return the value associated with the column: site_website
	 */
	public java.lang.String getSiteWebsite () {
		return siteWebsite;
	}

	/**
	 * Set the value related to the column: site_website
	 * @param siteWebsite the site_website value
	 */
	public void setSiteWebsite (java.lang.String siteWebsite) {
		this.siteWebsite = siteWebsite;
	}



	/**
	 * Return the value associated with the column: perevious_associate
	 */
	public java.lang.String getPereviousAssociate () {
		return pereviousAssociate;
	}

	/**
	 * Set the value related to the column: perevious_associate
	 * @param pereviousAssociate the perevious_associate value
	 */
	public void setPereviousAssociate (java.lang.String pereviousAssociate) {
		this.pereviousAssociate = pereviousAssociate;
	}



	/**
	 * Return the value associated with the column: site_pan_no
	 */
	public java.lang.String getSitePanNo () {
		return sitePanNo;
	}

	/**
	 * Set the value related to the column: site_pan_no
	 * @param sitePanNo the site_pan_no value
	 */
	public void setSitePanNo (java.lang.String sitePanNo) {
		this.sitePanNo = sitePanNo;
	}



	/**
	 * Return the value associated with the column: site_branch
	 */
	public java.lang.String getSiteBranch () {
		return siteBranch;
	}

	/**
	 * Set the value related to the column: site_branch
	 * @param siteBranch the site_branch value
	 */
	public void setSiteBranch (java.lang.String siteBranch) {
		this.siteBranch = siteBranch;
	}



	/**
	 * Return the value associated with the column: ec_name
	 */
	public java.lang.String getEcName () {
		return ecName;
	}

	/**
	 * Set the value related to the column: ec_name
	 * @param ecName the ec_name value
	 */
	public void setEcName (java.lang.String ecName) {
		this.ecName = ecName;
	}



	/**
	 * Return the value associated with the column: ec_convr_name
	 */
	public java.lang.String getEcConvrName () {
		return ecConvrName;
	}

	/**
	 * Set the value related to the column: ec_convr_name
	 * @param ecConvrName the ec_convr_name value
	 */
	public void setEcConvrName (java.lang.String ecConvrName) {
		this.ecConvrName = ecConvrName;
	}



	/**
	 * Return the value associated with the column: ec_contact_no
	 */
	public java.lang.String getEcContactNo () {
		return ecContactNo;
	}

	/**
	 * Set the value related to the column: ec_contact_no
	 * @param ecContactNo the ec_contact_no value
	 */
	public void setEcContactNo (java.lang.String ecContactNo) {
		this.ecContactNo = ecContactNo;
	}



	/**
	 * Return the value associated with the column: ec_email_id
	 */
	public java.lang.String getEcEmailId () {
		return ecEmailId;
	}

	/**
	 * Set the value related to the column: ec_email_id
	 * @param ecEmailId the ec_email_id value
	 */
	public void setEcEmailId (java.lang.String ecEmailId) {
		this.ecEmailId = ecEmailId;
	}



	/**
	 * Return the value associated with the column: ec_fax_no
	 */
	public java.lang.String getEcFaxNo () {
		return ecFaxNo;
	}

	/**
	 * Set the value related to the column: ec_fax_no
	 * @param ecFaxNo the ec_fax_no value
	 */
	public void setEcFaxNo (java.lang.String ecFaxNo) {
		this.ecFaxNo = ecFaxNo;
	}



	/**
	 * Return the value associated with the column: ec_branch
	 */
	public java.lang.String getEcBranch () {
		return ecBranch;
	}

	/**
	 * Set the value related to the column: ec_branch
	 * @param ecBranch the ec_branch value
	 */
	public void setEcBranch (java.lang.String ecBranch) {
		this.ecBranch = ecBranch;
	}



	/**
	 * Return the value associated with the column: ec_ac_no
	 */
	public java.lang.String getEcAcNo () {
		return ecAcNo;
	}

	/**
	 * Set the value related to the column: ec_ac_no
	 * @param ecAcNo the ec_ac_no value
	 */
	public void setEcAcNo (java.lang.String ecAcNo) {
		this.ecAcNo = ecAcNo;
	}



	/**
	 * Return the value associated with the column: ec_pan_no
	 */
	public java.lang.String getEcPanNo () {
		return ecPanNo;
	}

	/**
	 * Set the value related to the column: ec_pan_no
	 * @param ecPanNo the ec_pan_no value
	 */
	public void setEcPanNo (java.lang.String ecPanNo) {
		this.ecPanNo = ecPanNo;
	}



	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param comments the comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
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
	 * Return the value associated with the column: site_code
	 */
	public java.lang.String getSiteCode () {
		return siteCode;
	}

	/**
	 * Set the value related to the column: site_code
	 * @param siteCode the site_code value
	 */
	public void setSiteCode (java.lang.String siteCode) {
		this.siteCode = siteCode;
	}



	/**
	 * Return the value associated with the column: bank_id
	 */
	public jkt.hms.masters.business.MasBankMaster getBank () {
		return bank;
	}

	/**
	 * Set the value related to the column: bank_id
	 * @param bank the bank_id value
	 */
	public void setBank (jkt.hms.masters.business.MasBankMaster bank) {
		this.bank = bank;
	}



	/**
	 * Return the value associated with the column: ec_bank_id
	 */
	public jkt.hms.masters.business.MasBankMaster getEcBank () {
		return ecBank;
	}

	/**
	 * Set the value related to the column: ec_bank_id
	 * @param ecBank the ec_bank_id value
	 */
	public void setEcBank (jkt.hms.masters.business.MasBankMaster ecBank) {
		this.ecBank = ecBank;
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
	 * Return the value associated with the column: rating_id
	 */
	public jkt.hrms.masters.business.MstrRating getRating () {
		return rating;
	}

	/**
	 * Set the value related to the column: rating_id
	 * @param rating the rating_id value
	 */
	public void setRating (jkt.hrms.masters.business.MstrRating rating) {
		this.rating = rating;
	}



	/**
	 * Return the value associated with the column: MstrSiteDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrSiteDetail> getMstrSiteDetails () {
		return mstrSiteDetails;
	}

	/**
	 * Set the value related to the column: MstrSiteDetails
	 * @param mstrSiteDetails the MstrSiteDetails value
	 */
	public void setMstrSiteDetails (java.util.Set<jkt.hrms.masters.business.MstrSiteDetail> mstrSiteDetails) {
		this.mstrSiteDetails = mstrSiteDetails;
	}

	public void addToMstrSiteDetails (jkt.hrms.masters.business.MstrSiteDetail mstrSiteDetail) {
		if (null == getMstrSiteDetails()) setMstrSiteDetails(new java.util.TreeSet<jkt.hrms.masters.business.MstrSiteDetail>());
		getMstrSiteDetails().add(mstrSiteDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrSiteHeader)) return false;
		else {
			jkt.hrms.masters.business.MstrSiteHeader mstrSiteHeader = (jkt.hrms.masters.business.MstrSiteHeader) obj;
			if (null == this.getId() || null == mstrSiteHeader.getId()) return false;
			else return (this.getId().equals(mstrSiteHeader.getId()));
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