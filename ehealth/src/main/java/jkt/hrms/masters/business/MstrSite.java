package jkt.hrms.masters.business;

import jkt.hrms.masters.business.base.BaseMstrSite;



public class MstrSite extends BaseMstrSite {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MstrSite () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MstrSite (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MstrSite (
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

		super (
			id,
			siteName,
			siteAddress,
			siteAccountno,
			siteContactno,
			siteFaxno,
			siteEmailid,
			siteWebsite,
			siteThrpid,
			pereviousAssociate,
			rating,
			sitePanno,
			siteBankid,
			siteBranch,
			siteAccno,
			ecName,
			ecConvrname,
			ecContactno,
			ecEmailid,
			ecFaxno,
			ecBankid,
			ecBranch,
			ecAccno,
			ecPanno,
			comments,
			siteActive,
			createdBy,
			createdAt,
			modifiedBy,
			modifiedAt);
	}

/*[CONSTRUCTOR MARKER END]*/


}