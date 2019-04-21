package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_fedoc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_fedoc"
 */

public abstract class BasePrjFedoc  implements Serializable {

	public static String REF = "PrjFedoc";
	public static String PROP_FED_DFILENAME = "FedDfilename";
	public static String PROP_FED_OFILENAME = "FedOfilename";
	public static String PROP_FED_FEID = "FedFeid";
	public static String PROP_ID = "Id";
	public static String PROP_FED_CMTS = "FedCmts";


	// constructors
	public BasePrjFedoc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjFedoc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePrjFedoc (
		java.lang.Integer id,
		jkt.hrms.masters.business.PrjFesStudyHeader fedFeid,
		java.lang.String fedOfilename,
		java.lang.String fedDfilename,
		java.lang.String fedCmts) {

		this.setId(id);
		this.setFedFeid(fedFeid);
		this.setFedOfilename(fedOfilename);
		this.setFedDfilename(fedDfilename);
		this.setFedCmts(fedCmts);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fedOfilename;
	private java.lang.String fedDfilename;
	private java.lang.String fedCmts;

	// many to one
	private jkt.hrms.masters.business.PrjFesStudyHeader fedFeid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="FED_ID"
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
	 * Return the value associated with the column: FED_OFilename
	 */
	public java.lang.String getFedOfilename () {
		return fedOfilename;
	}

	/**
	 * Set the value related to the column: FED_OFilename
	 * @param fedOfilename the FED_OFilename value
	 */
	public void setFedOfilename (java.lang.String fedOfilename) {
		this.fedOfilename = fedOfilename;
	}



	/**
	 * Return the value associated with the column: FED_DFilename
	 */
	public java.lang.String getFedDfilename () {
		return fedDfilename;
	}

	/**
	 * Set the value related to the column: FED_DFilename
	 * @param fedDfilename the FED_DFilename value
	 */
	public void setFedDfilename (java.lang.String fedDfilename) {
		this.fedDfilename = fedDfilename;
	}



	/**
	 * Return the value associated with the column: FED_Cmts
	 */
	public java.lang.String getFedCmts () {
		return fedCmts;
	}

	/**
	 * Set the value related to the column: FED_Cmts
	 * @param fedCmts the FED_Cmts value
	 */
	public void setFedCmts (java.lang.String fedCmts) {
		this.fedCmts = fedCmts;
	}



	/**
	 * Return the value associated with the column: FED_FEID
	 */
	public jkt.hrms.masters.business.PrjFesStudyHeader getFedFeid () {
		return fedFeid;
	}

	/**
	 * Set the value related to the column: FED_FEID
	 * @param fedFeid the FED_FEID value
	 */
	public void setFedFeid (jkt.hrms.masters.business.PrjFesStudyHeader fedFeid) {
		this.fedFeid = fedFeid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjFedoc)) return false;
		else {
			jkt.hrms.masters.business.PrjFedoc prjFedoc = (jkt.hrms.masters.business.PrjFedoc) obj;
			if (null == this.getId() || null == prjFedoc.getId()) return false;
			else return (this.getId().equals(prjFedoc.getId()));
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