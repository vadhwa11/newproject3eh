package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_site_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_site_detail"
 */

public abstract class BaseMstrSiteDetail  implements Serializable {

	public static String REF = "MstrSiteDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_ID = "Id";
	public static String PROP_THP = "Thp";
	public static String PROP_SITE_HEADER = "SiteHeader";


	// constructors
	public BaseMstrSiteDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrSiteDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hrms.masters.business.MstrTherapeutic thp;
	private jkt.hrms.masters.business.MstrSiteHeader siteHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="site_detail_id"
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
	 * Return the value associated with the column: site_header_id
	 */
	public jkt.hrms.masters.business.MstrSiteHeader getSiteHeader () {
		return siteHeader;
	}

	/**
	 * Set the value related to the column: site_header_id
	 * @param siteHeader the site_header_id value
	 */
	public void setSiteHeader (jkt.hrms.masters.business.MstrSiteHeader siteHeader) {
		this.siteHeader = siteHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrSiteDetail)) return false;
		else {
			jkt.hrms.masters.business.MstrSiteDetail mstrSiteDetail = (jkt.hrms.masters.business.MstrSiteDetail) obj;
			if (null == this.getId() || null == mstrSiteDetail.getId()) return false;
			else return (this.getId().equals(mstrSiteDetail.getId()));
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