package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_documentsubmission table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_documentsubmission"
 */

public abstract class BaseMstrDocumentsubmission  implements Serializable {

	public static String REF = "MstrDocumentsubmission";
	public static String PROP_DS_DESC = "DsDesc";
	public static String PROP_DS_NAME = "DsName";
	public static String PROP_ID = "Id";
	public static String PROP_DS_ACTIVE = "DsActive";
	public static String PROP_DCT_ID = "DctId";


	// constructors
	public BaseMstrDocumentsubmission () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrDocumentsubmission (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMstrDocumentsubmission (
		java.lang.Integer id,
		java.lang.Integer dctId) {

		this.setId(id);
		this.setDctId(dctId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dsName;
	private java.lang.Byte dsActive;
	private java.lang.String dsDesc;
	private java.lang.Integer dctId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ds_Id"
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
	 * Return the value associated with the column: ds_Name
	 */
	public java.lang.String getDsName () {
		return dsName;
	}

	/**
	 * Set the value related to the column: ds_Name
	 * @param dsName the ds_Name value
	 */
	public void setDsName (java.lang.String dsName) {
		this.dsName = dsName;
	}



	/**
	 * Return the value associated with the column: ds_Active
	 */
	public java.lang.Byte getDsActive () {
		return dsActive;
	}

	/**
	 * Set the value related to the column: ds_Active
	 * @param dsActive the ds_Active value
	 */
	public void setDsActive (java.lang.Byte dsActive) {
		this.dsActive = dsActive;
	}



	/**
	 * Return the value associated with the column: ds_desc
	 */
	public java.lang.String getDsDesc () {
		return dsDesc;
	}

	/**
	 * Set the value related to the column: ds_desc
	 * @param dsDesc the ds_desc value
	 */
	public void setDsDesc (java.lang.String dsDesc) {
		this.dsDesc = dsDesc;
	}



	/**
	 * Return the value associated with the column: Dct_id
	 */
	public java.lang.Integer getDctId () {
		return dctId;
	}

	/**
	 * Set the value related to the column: Dct_id
	 * @param dctId the Dct_id value
	 */
	public void setDctId (java.lang.Integer dctId) {
		this.dctId = dctId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrDocumentsubmission)) return false;
		else {
			jkt.hrms.masters.business.MstrDocumentsubmission mstrDocumentsubmission = (jkt.hrms.masters.business.MstrDocumentsubmission) obj;
			if (null == this.getId() || null == mstrDocumentsubmission.getId()) return false;
			else return (this.getId().equals(mstrDocumentsubmission.getId()));
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