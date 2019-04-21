package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_site table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_site"
 */

public abstract class BaseMstrSite  implements Serializable {

	public static String REF = "MstrSite";
	public static String PROP_SITE_ADDRESS = "SiteAddress";
	public static String PROP_SITE_NAME = "SiteName";
	public static String PROP_SITE_BANKID = "SiteBankid";
	public static String PROP_SITE_ACCNO = "SiteAccno";
	public static String PROP_PEREVIOUS_ASSOCIATE = "PereviousAssociate";
	public static String PROP_SITE_THRPID = "SiteThrpid";
	public static String PROP_SITE_ACTIVE = "SiteActive";
	public static String PROP_EC_CONVRNAME = "EcConvrname";
	public static String PROP_EC_FAXNO = "EcFaxno";
	public static String PROP_SITE_CONTACTNO = "SiteContactno";
	public static String PROP_CREATED_AT = "CreatedAt";
	public static String PROP_SITE_ACCOUNTNO = "SiteAccountno";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_EC_EMAILID = "EcEmailid";
	public static String PROP_EC_NAME = "EcName";
	public static String PROP_EC_PANNO = "EcPanno";
	public static String PROP_MODIFIED_AT = "ModifiedAt";
	public static String PROP_SITE_WEBSITE = "SiteWebsite";
	public static String PROP_MODIFIED_BY = "ModifiedBy";
	public static String PROP_SITE_EMAILID = "SiteEmailid";
	public static String PROP_EC_ACCNO = "EcAccno";
	public static String PROP_SITE_FAXNO = "SiteFaxno";
	public static String PROP_EC_BRANCH = "EcBranch";
	public static String PROP_RATING = "Rating";
	public static String PROP_EC_CONTACTNO = "EcContactno";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_ID = "Id";
	public static String PROP_SITE_BRANCH = "SiteBranch";
	public static String PROP_EC_BANKID = "EcBankid";
	public static String PROP_SITE_PANNO = "SitePanno";


	// constructors
	public BaseMstrSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrSite (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMstrSite (
		java.lang.Integer id,
		java.lang.String siteName,
		java.lang.String siteAddress,
		java.lang.String siteAccountno,
		java.lang.String siteContactno,
		java.lang.String siteFaxno,
		java.lang.String siteEmailid,
		java.lang.String siteWebsite,
		java.lang.String siteThrpid,
		java.lang.Byte pereviousAssociate,
		java.lang.Integer rating,
		java.lang.String sitePanno,
		java.lang.Integer siteBankid,
		java.lang.String siteBranch,
		java.lang.String siteAccno,
		java.lang.String ecName,
		java.lang.String ecConvrname,
		java.lang.String ecContactno,
		java.lang.String ecEmailid,
		java.lang.String ecFaxno,
		java.lang.Integer ecBankid,
		java.lang.String ecBranch,
		java.lang.String ecAccno,
		java.lang.String ecPanno,
		java.lang.String comments,
		java.lang.Byte siteActive,
		java.lang.Integer createdBy,
		java.util.Date createdAt,
		java.lang.Integer modifiedBy,
		java.util.Date modifiedAt) {

		this.setId(id);
		this.setSiteName(siteName);
		this.setSiteAddress(siteAddress);
		this.setSiteAccountno(siteAccountno);
		this.setSiteContactno(siteContactno);
		this.setSiteFaxno(siteFaxno);
		this.setSiteEmailid(siteEmailid);
		this.setSiteWebsite(siteWebsite);
		this.setSiteThrpid(siteThrpid);
		this.setPereviousAssociate(pereviousAssociate);
		this.setRating(rating);
		this.setSitePanno(sitePanno);
		this.setSiteBankid(siteBankid);
		this.setSiteBranch(siteBranch);
		this.setSiteAccno(siteAccno);
		this.setEcName(ecName);
		this.setEcConvrname(ecConvrname);
		this.setEcContactno(ecContactno);
		this.setEcEmailid(ecEmailid);
		this.setEcFaxno(ecFaxno);
		this.setEcBankid(ecBankid);
		this.setEcBranch(ecBranch);
		this.setEcAccno(ecAccno);
		this.setEcPanno(ecPanno);
		this.setComments(comments);
		this.setSiteActive(siteActive);
		this.setCreatedBy(createdBy);
		this.setCreatedAt(createdAt);
		this.setModifiedBy(modifiedBy);
		this.setModifiedAt(modifiedAt);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String siteName;
	private java.lang.String siteAddress;
	private java.lang.String siteAccountno;
	private java.lang.String siteContactno;
	private java.lang.String siteFaxno;
	private java.lang.String siteEmailid;
	private java.lang.String siteWebsite;
	private java.lang.String siteThrpid;
	private java.lang.Byte pereviousAssociate;
	private java.lang.Integer rating;
	private java.lang.String sitePanno;
	private java.lang.Integer siteBankid;
	private java.lang.String siteBranch;
	private java.lang.String siteAccno;
	private java.lang.String ecName;
	private java.lang.String ecConvrname;
	private java.lang.String ecContactno;
	private java.lang.String ecEmailid;
	private java.lang.String ecFaxno;
	private java.lang.Integer ecBankid;
	private java.lang.String ecBranch;
	private java.lang.String ecAccno;
	private java.lang.String ecPanno;
	private java.lang.String comments;
	private java.lang.Byte siteActive;
	private java.lang.Integer createdBy;
	private java.util.Date createdAt;
	private java.lang.Integer modifiedBy;
	private java.util.Date modifiedAt;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Site_id"
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
	 * Return the value associated with the column: Site_Name
	 */
	public java.lang.String getSiteName () {
		return siteName;
	}

	/**
	 * Set the value related to the column: Site_Name
	 * @param siteName the Site_Name value
	 */
	public void setSiteName (java.lang.String siteName) {
		this.siteName = siteName;
	}



	/**
	 * Return the value associated with the column: Site_Address
	 */
	public java.lang.String getSiteAddress () {
		return siteAddress;
	}

	/**
	 * Set the value related to the column: Site_Address
	 * @param siteAddress the Site_Address value
	 */
	public void setSiteAddress (java.lang.String siteAddress) {
		this.siteAddress = siteAddress;
	}



	/**
	 * Return the value associated with the column: Site_AccountNo
	 */
	public java.lang.String getSiteAccountno () {
		return siteAccountno;
	}

	/**
	 * Set the value related to the column: Site_AccountNo
	 * @param siteAccountno the Site_AccountNo value
	 */
	public void setSiteAccountno (java.lang.String siteAccountno) {
		this.siteAccountno = siteAccountno;
	}



	/**
	 * Return the value associated with the column: Site_ContactNo
	 */
	public java.lang.String getSiteContactno () {
		return siteContactno;
	}

	/**
	 * Set the value related to the column: Site_ContactNo
	 * @param siteContactno the Site_ContactNo value
	 */
	public void setSiteContactno (java.lang.String siteContactno) {
		this.siteContactno = siteContactno;
	}



	/**
	 * Return the value associated with the column: Site_FaxNo
	 */
	public java.lang.String getSiteFaxno () {
		return siteFaxno;
	}

	/**
	 * Set the value related to the column: Site_FaxNo
	 * @param siteFaxno the Site_FaxNo value
	 */
	public void setSiteFaxno (java.lang.String siteFaxno) {
		this.siteFaxno = siteFaxno;
	}



	/**
	 * Return the value associated with the column: Site_EmailId
	 */
	public java.lang.String getSiteEmailid () {
		return siteEmailid;
	}

	/**
	 * Set the value related to the column: Site_EmailId
	 * @param siteEmailid the Site_EmailId value
	 */
	public void setSiteEmailid (java.lang.String siteEmailid) {
		this.siteEmailid = siteEmailid;
	}



	/**
	 * Return the value associated with the column: Site_Website
	 */
	public java.lang.String getSiteWebsite () {
		return siteWebsite;
	}

	/**
	 * Set the value related to the column: Site_Website
	 * @param siteWebsite the Site_Website value
	 */
	public void setSiteWebsite (java.lang.String siteWebsite) {
		this.siteWebsite = siteWebsite;
	}



	/**
	 * Return the value associated with the column: Site_ThrpId
	 */
	public java.lang.String getSiteThrpid () {
		return siteThrpid;
	}

	/**
	 * Set the value related to the column: Site_ThrpId
	 * @param siteThrpid the Site_ThrpId value
	 */
	public void setSiteThrpid (java.lang.String siteThrpid) {
		this.siteThrpid = siteThrpid;
	}



	/**
	 * Return the value associated with the column: PereviousAssociate
	 */
	public java.lang.Byte getPereviousAssociate () {
		return pereviousAssociate;
	}

	/**
	 * Set the value related to the column: PereviousAssociate
	 * @param pereviousAssociate the PereviousAssociate value
	 */
	public void setPereviousAssociate (java.lang.Byte pereviousAssociate) {
		this.pereviousAssociate = pereviousAssociate;
	}



	/**
	 * Return the value associated with the column: Rating
	 */
	public java.lang.Integer getRating () {
		return rating;
	}

	/**
	 * Set the value related to the column: Rating
	 * @param rating the Rating value
	 */
	public void setRating (java.lang.Integer rating) {
		this.rating = rating;
	}



	/**
	 * Return the value associated with the column: Site_PanNo
	 */
	public java.lang.String getSitePanno () {
		return sitePanno;
	}

	/**
	 * Set the value related to the column: Site_PanNo
	 * @param sitePanno the Site_PanNo value
	 */
	public void setSitePanno (java.lang.String sitePanno) {
		this.sitePanno = sitePanno;
	}



	/**
	 * Return the value associated with the column: Site_BankID
	 */
	public java.lang.Integer getSiteBankid () {
		return siteBankid;
	}

	/**
	 * Set the value related to the column: Site_BankID
	 * @param siteBankid the Site_BankID value
	 */
	public void setSiteBankid (java.lang.Integer siteBankid) {
		this.siteBankid = siteBankid;
	}



	/**
	 * Return the value associated with the column: Site_Branch
	 */
	public java.lang.String getSiteBranch () {
		return siteBranch;
	}

	/**
	 * Set the value related to the column: Site_Branch
	 * @param siteBranch the Site_Branch value
	 */
	public void setSiteBranch (java.lang.String siteBranch) {
		this.siteBranch = siteBranch;
	}



	/**
	 * Return the value associated with the column: Site_AccNo
	 */
	public java.lang.String getSiteAccno () {
		return siteAccno;
	}

	/**
	 * Set the value related to the column: Site_AccNo
	 * @param siteAccno the Site_AccNo value
	 */
	public void setSiteAccno (java.lang.String siteAccno) {
		this.siteAccno = siteAccno;
	}



	/**
	 * Return the value associated with the column: EC_Name
	 */
	public java.lang.String getEcName () {
		return ecName;
	}

	/**
	 * Set the value related to the column: EC_Name
	 * @param ecName the EC_Name value
	 */
	public void setEcName (java.lang.String ecName) {
		this.ecName = ecName;
	}



	/**
	 * Return the value associated with the column: EC_ConvrName
	 */
	public java.lang.String getEcConvrname () {
		return ecConvrname;
	}

	/**
	 * Set the value related to the column: EC_ConvrName
	 * @param ecConvrname the EC_ConvrName value
	 */
	public void setEcConvrname (java.lang.String ecConvrname) {
		this.ecConvrname = ecConvrname;
	}



	/**
	 * Return the value associated with the column: EC_ContactNo
	 */
	public java.lang.String getEcContactno () {
		return ecContactno;
	}

	/**
	 * Set the value related to the column: EC_ContactNo
	 * @param ecContactno the EC_ContactNo value
	 */
	public void setEcContactno (java.lang.String ecContactno) {
		this.ecContactno = ecContactno;
	}



	/**
	 * Return the value associated with the column: EC_EmailId
	 */
	public java.lang.String getEcEmailid () {
		return ecEmailid;
	}

	/**
	 * Set the value related to the column: EC_EmailId
	 * @param ecEmailid the EC_EmailId value
	 */
	public void setEcEmailid (java.lang.String ecEmailid) {
		this.ecEmailid = ecEmailid;
	}



	/**
	 * Return the value associated with the column: EC_FaxNo
	 */
	public java.lang.String getEcFaxno () {
		return ecFaxno;
	}

	/**
	 * Set the value related to the column: EC_FaxNo
	 * @param ecFaxno the EC_FaxNo value
	 */
	public void setEcFaxno (java.lang.String ecFaxno) {
		this.ecFaxno = ecFaxno;
	}



	/**
	 * Return the value associated with the column: EC_BankId
	 */
	public java.lang.Integer getEcBankid () {
		return ecBankid;
	}

	/**
	 * Set the value related to the column: EC_BankId
	 * @param ecBankid the EC_BankId value
	 */
	public void setEcBankid (java.lang.Integer ecBankid) {
		this.ecBankid = ecBankid;
	}



	/**
	 * Return the value associated with the column: EC_Branch
	 */
	public java.lang.String getEcBranch () {
		return ecBranch;
	}

	/**
	 * Set the value related to the column: EC_Branch
	 * @param ecBranch the EC_Branch value
	 */
	public void setEcBranch (java.lang.String ecBranch) {
		this.ecBranch = ecBranch;
	}



	/**
	 * Return the value associated with the column: EC_AccNo
	 */
	public java.lang.String getEcAccno () {
		return ecAccno;
	}

	/**
	 * Set the value related to the column: EC_AccNo
	 * @param ecAccno the EC_AccNo value
	 */
	public void setEcAccno (java.lang.String ecAccno) {
		this.ecAccno = ecAccno;
	}



	/**
	 * Return the value associated with the column: EC_Panno
	 */
	public java.lang.String getEcPanno () {
		return ecPanno;
	}

	/**
	 * Set the value related to the column: EC_Panno
	 * @param ecPanno the EC_Panno value
	 */
	public void setEcPanno (java.lang.String ecPanno) {
		this.ecPanno = ecPanno;
	}



	/**
	 * Return the value associated with the column: Comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: Comments
	 * @param comments the Comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
	}



	/**
	 * Return the value associated with the column: Site_Active
	 */
	public java.lang.Byte getSiteActive () {
		return siteActive;
	}

	/**
	 * Set the value related to the column: Site_Active
	 * @param siteActive the Site_Active value
	 */
	public void setSiteActive (java.lang.Byte siteActive) {
		this.siteActive = siteActive;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrSite)) return false;
		else {
			jkt.hrms.masters.business.MstrSite mstrSite = (jkt.hrms.masters.business.MstrSite) obj;
			if (null == this.getId() || null == mstrSite.getId()) return false;
			else return (this.getId().equals(mstrSite.getId()));
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