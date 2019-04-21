package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_dcf_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_dcf_entry"
 */

public abstract class BasePrjDcfEntry  implements Serializable {

	public static String REF = "PrjDcfEntry";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_PRJ = "Prj";
	public static String PROP_ID = "Id";
	public static String PROP_SITE_HEADER = "SiteHeader";


	// constructors
	public BasePrjDcfEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjDcfEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePrjDcfEntry (
		java.lang.Integer id,
		jkt.hrms.masters.business.MstrSiteHeader siteHeader,
		jkt.hrms.masters.business.MstrProject prj) {

		this.setId(id);
		this.setSiteHeader(siteHeader);
		this.setPrj(prj);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fileName;

	// many to one
	private jkt.hrms.masters.business.MstrSiteHeader siteHeader;
	private jkt.hrms.masters.business.MstrProject prj;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
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



	/**
	 * Return the value associated with the column: Prj_Id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: Prj_Id
	 * @param prj the Prj_Id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjDcfEntry)) return false;
		else {
			jkt.hrms.masters.business.PrjDcfEntry prjDcfEntry = (jkt.hrms.masters.business.PrjDcfEntry) obj;
			if (null == this.getId() || null == prjDcfEntry.getId()) return false;
			else return (this.getId().equals(prjDcfEntry.getId()));
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