package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_bookeddtls_attach table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_bookeddtls_attach"
 */

public abstract class BaseEtrBookeddtlsAttach  implements Serializable {

	public static String REF = "EtrBookeddtlsAttach";
	public static String PROP_SYS_FILENAME = "SysFilename";
	public static String PROP_FBDT = "Fbdt";
	public static String PROP_ID = "Id";
	public static String PROP_CMTS = "Cmts";
	public static String PROP_ORG_FILENAME = "OrgFilename";


	// constructors
	public BaseEtrBookeddtlsAttach () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrBookeddtlsAttach (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String orgFilename;
	private java.lang.String sysFilename;
	private java.lang.String cmts;

	// many to one
	private jkt.hrms.masters.business.EtrFillbookeddtls fbdt;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="at_id"
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
	 * Return the value associated with the column: ORG_filename
	 */
	public java.lang.String getOrgFilename () {
		return orgFilename;
	}

	/**
	 * Set the value related to the column: ORG_filename
	 * @param orgFilename the ORG_filename value
	 */
	public void setOrgFilename (java.lang.String orgFilename) {
		this.orgFilename = orgFilename;
	}



	/**
	 * Return the value associated with the column: SYS_filename
	 */
	public java.lang.String getSysFilename () {
		return sysFilename;
	}

	/**
	 * Set the value related to the column: SYS_filename
	 * @param sysFilename the SYS_filename value
	 */
	public void setSysFilename (java.lang.String sysFilename) {
		this.sysFilename = sysFilename;
	}



	/**
	 * Return the value associated with the column: cmts
	 */
	public java.lang.String getCmts () {
		return cmts;
	}

	/**
	 * Set the value related to the column: cmts
	 * @param cmts the cmts value
	 */
	public void setCmts (java.lang.String cmts) {
		this.cmts = cmts;
	}



	/**
	 * Return the value associated with the column: Fbdt_id
	 */
	public jkt.hrms.masters.business.EtrFillbookeddtls getFbdt () {
		return fbdt;
	}

	/**
	 * Set the value related to the column: Fbdt_id
	 * @param fbdt the Fbdt_id value
	 */
	public void setFbdt (jkt.hrms.masters.business.EtrFillbookeddtls fbdt) {
		this.fbdt = fbdt;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrBookeddtlsAttach)) return false;
		else {
			jkt.hrms.masters.business.EtrBookeddtlsAttach etrBookeddtlsAttach = (jkt.hrms.masters.business.EtrBookeddtlsAttach) obj;
			if (null == this.getId() || null == etrBookeddtlsAttach.getId()) return false;
			else return (this.getId().equals(etrBookeddtlsAttach.getId()));
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