package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp_tickattach table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp_tickattach"
 */

public abstract class BaseTempTickattach  implements Serializable {

	public static String REF = "TempTickattach";
	public static String PROP_TDSA_CMTS = "TdsaCmts";
	public static String PROP_TDSA_OFILENAME = "TdsaOfilename";
	public static String PROP_TDSA_DFILENAME = "TdsaDfilename";
	public static String PROP_ID = "Id";
	public static String PROP_TDSA_DSID = "TdsaDsid";
	public static String PROP_TDSA_USERID = "TdsaUserid";


	// constructors
	public BaseTempTickattach () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempTickattach (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTempTickattach (
		java.lang.Integer id,
		jkt.hrms.masters.business.EtrTravelreq tdsaDsid,
		jkt.hms.masters.business.MasEmployee tdsaUserid,
		java.lang.String tdsaOfilename,
		java.lang.String tdsaDfilename) {

		this.setId(id);
		this.setTdsaDsid(tdsaDsid);
		this.setTdsaUserid(tdsaUserid);
		this.setTdsaOfilename(tdsaOfilename);
		this.setTdsaDfilename(tdsaDfilename);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tdsaOfilename;
	private java.lang.String tdsaDfilename;
	private java.lang.String tdsaCmts;

	// many to one
	private jkt.hrms.masters.business.EtrTravelreq tdsaDsid;
	private jkt.hms.masters.business.MasEmployee tdsaUserid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="TDSA_ID"
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
	 * Return the value associated with the column: TDSA_OFilename
	 */
	public java.lang.String getTdsaOfilename () {
		return tdsaOfilename;
	}

	/**
	 * Set the value related to the column: TDSA_OFilename
	 * @param tdsaOfilename the TDSA_OFilename value
	 */
	public void setTdsaOfilename (java.lang.String tdsaOfilename) {
		this.tdsaOfilename = tdsaOfilename;
	}



	/**
	 * Return the value associated with the column: TDSA_DFilename
	 */
	public java.lang.String getTdsaDfilename () {
		return tdsaDfilename;
	}

	/**
	 * Set the value related to the column: TDSA_DFilename
	 * @param tdsaDfilename the TDSA_DFilename value
	 */
	public void setTdsaDfilename (java.lang.String tdsaDfilename) {
		this.tdsaDfilename = tdsaDfilename;
	}



	/**
	 * Return the value associated with the column: TDSA_Cmts
	 */
	public java.lang.String getTdsaCmts () {
		return tdsaCmts;
	}

	/**
	 * Set the value related to the column: TDSA_Cmts
	 * @param tdsaCmts the TDSA_Cmts value
	 */
	public void setTdsaCmts (java.lang.String tdsaCmts) {
		this.tdsaCmts = tdsaCmts;
	}



	/**
	 * Return the value associated with the column: TDSA_DSID
	 */
	public jkt.hrms.masters.business.EtrTravelreq getTdsaDsid () {
		return tdsaDsid;
	}

	/**
	 * Set the value related to the column: TDSA_DSID
	 * @param tdsaDsid the TDSA_DSID value
	 */
	public void setTdsaDsid (jkt.hrms.masters.business.EtrTravelreq tdsaDsid) {
		this.tdsaDsid = tdsaDsid;
	}



	/**
	 * Return the value associated with the column: TDSA_UserID
	 */
	public jkt.hms.masters.business.MasEmployee getTdsaUserid () {
		return tdsaUserid;
	}

	/**
	 * Set the value related to the column: TDSA_UserID
	 * @param tdsaUserid the TDSA_UserID value
	 */
	public void setTdsaUserid (jkt.hms.masters.business.MasEmployee tdsaUserid) {
		this.tdsaUserid = tdsaUserid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.TempTickattach)) return false;
		else {
			jkt.hrms.masters.business.TempTickattach tempTickattach = (jkt.hrms.masters.business.TempTickattach) obj;
			if (null == this.getId() || null == tempTickattach.getId()) return false;
			else return (this.getId().equals(tempTickattach.getId()));
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