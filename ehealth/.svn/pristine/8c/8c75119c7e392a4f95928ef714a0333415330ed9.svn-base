package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_trvsub_attach table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_trvsub_attach"
 */

public abstract class BaseEtrTrvsubAttach  implements Serializable {

	public static String REF = "EtrTrvsubAttach";
	public static String PROP_DS_DESC = "DsDesc";
	public static String PROP_DS_DFILENAME = "DsDfilename";
	public static String PROP_DS_OFILENAME = "DsOfilename";
	public static String PROP_DS_EXPID = "DsExpid";
	public static String PROP_ID = "Id";


	// constructors
	public BaseEtrTrvsubAttach () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrTrvsubAttach (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEtrTrvsubAttach (
		java.lang.Integer id,
		java.lang.Integer dsExpid,
		java.lang.String dsOfilename,
		java.lang.String dsDfilename,
		java.lang.String dsDesc) {

		this.setId(id);
		this.setDsExpid(dsExpid);
		this.setDsOfilename(dsOfilename);
		this.setDsDfilename(dsDfilename);
		this.setDsDesc(dsDesc);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer dsExpid;
	private java.lang.String dsOfilename;
	private java.lang.String dsDfilename;
	private java.lang.String dsDesc;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="DS_ID"
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
	 * Return the value associated with the column: DS_expid
	 */
	public java.lang.Integer getDsExpid () {
		return dsExpid;
	}

	/**
	 * Set the value related to the column: DS_expid
	 * @param dsExpid the DS_expid value
	 */
	public void setDsExpid (java.lang.Integer dsExpid) {
		this.dsExpid = dsExpid;
	}



	/**
	 * Return the value associated with the column: DS_Ofilename
	 */
	public java.lang.String getDsOfilename () {
		return dsOfilename;
	}

	/**
	 * Set the value related to the column: DS_Ofilename
	 * @param dsOfilename the DS_Ofilename value
	 */
	public void setDsOfilename (java.lang.String dsOfilename) {
		this.dsOfilename = dsOfilename;
	}



	/**
	 * Return the value associated with the column: DS_Dfilename
	 */
	public java.lang.String getDsDfilename () {
		return dsDfilename;
	}

	/**
	 * Set the value related to the column: DS_Dfilename
	 * @param dsDfilename the DS_Dfilename value
	 */
	public void setDsDfilename (java.lang.String dsDfilename) {
		this.dsDfilename = dsDfilename;
	}



	/**
	 * Return the value associated with the column: DS_Desc
	 */
	public java.lang.String getDsDesc () {
		return dsDesc;
	}

	/**
	 * Set the value related to the column: DS_Desc
	 * @param dsDesc the DS_Desc value
	 */
	public void setDsDesc (java.lang.String dsDesc) {
		this.dsDesc = dsDesc;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrTrvsubAttach)) return false;
		else {
			jkt.hrms.masters.business.EtrTrvsubAttach etrTrvsubAttach = (jkt.hrms.masters.business.EtrTrvsubAttach) obj;
			if (null == this.getId() || null == etrTrvsubAttach.getId()) return false;
			else return (this.getId().equals(etrTrvsubAttach.getId()));
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