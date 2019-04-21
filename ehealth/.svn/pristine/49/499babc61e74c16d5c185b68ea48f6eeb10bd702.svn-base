package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_projectrole table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_projectrole"
 */

public abstract class BaseMstrProjectrole  implements Serializable {

	public static String REF = "MstrProjectrole";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PJR_NAME = "PjrName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PJR_CODE = "PjrCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMstrProjectrole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrProjectrole (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String pjrName;
	private java.lang.String pjrCode;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjRoleMap> prjRoleMaps;
	private java.util.Set<jkt.hrms.masters.business.PrjResMap> prjResMaps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pjr_id"
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
	 * Return the value associated with the column: pjr_name
	 */
	public java.lang.String getPjrName () {
		return pjrName;
	}

	/**
	 * Set the value related to the column: pjr_name
	 * @param pjrName the pjr_name value
	 */
	public void setPjrName (java.lang.String pjrName) {
		this.pjrName = pjrName;
	}



	/**
	 * Return the value associated with the column: pjr_code
	 */
	public java.lang.String getPjrCode () {
		return pjrCode;
	}

	/**
	 * Set the value related to the column: pjr_code
	 * @param pjrCode the pjr_code value
	 */
	public void setPjrCode (java.lang.String pjrCode) {
		this.pjrCode = pjrCode;
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
	 * Return the value associated with the column: PrjRoleMaps
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjRoleMap> getPrjRoleMaps () {
		return prjRoleMaps;
	}

	/**
	 * Set the value related to the column: PrjRoleMaps
	 * @param prjRoleMaps the PrjRoleMaps value
	 */
	public void setPrjRoleMaps (java.util.Set<jkt.hrms.masters.business.PrjRoleMap> prjRoleMaps) {
		this.prjRoleMaps = prjRoleMaps;
	}

	public void addToPrjRoleMaps (jkt.hrms.masters.business.PrjRoleMap prjRoleMap) {
		if (null == getPrjRoleMaps()) setPrjRoleMaps(new java.util.TreeSet<jkt.hrms.masters.business.PrjRoleMap>());
		getPrjRoleMaps().add(prjRoleMap);
	}



	/**
	 * Return the value associated with the column: PrjResMaps
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjResMap> getPrjResMaps () {
		return prjResMaps;
	}

	/**
	 * Set the value related to the column: PrjResMaps
	 * @param prjResMaps the PrjResMaps value
	 */
	public void setPrjResMaps (java.util.Set<jkt.hrms.masters.business.PrjResMap> prjResMaps) {
		this.prjResMaps = prjResMaps;
	}

	public void addToPrjResMaps (jkt.hrms.masters.business.PrjResMap prjResMap) {
		if (null == getPrjResMaps()) setPrjResMaps(new java.util.TreeSet<jkt.hrms.masters.business.PrjResMap>());
		getPrjResMaps().add(prjResMap);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrProjectrole)) return false;
		else {
			jkt.hrms.masters.business.MstrProjectrole mstrProjectrole = (jkt.hrms.masters.business.MstrProjectrole) obj;
			if (null == this.getId() || null == mstrProjectrole.getId()) return false;
			else return (this.getId().equals(mstrProjectrole.getId()));
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