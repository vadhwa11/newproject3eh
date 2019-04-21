package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_therapeutic table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_therapeutic"
 */

public abstract class BaseMstrTherapeutic  implements Serializable {

	public static String REF = "MstrTherapeutic";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_THP_DESC = "ThpDesc";
	public static String PROP_ID = "Id";
	public static String PROP_THP_CODE = "ThpCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMstrTherapeutic () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrTherapeutic (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String thpDesc;
	private java.lang.String status;
	private java.lang.String thpCode;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hrms.masters.business.MstrSiteDetail> mstrSiteDetails;
	private java.util.Set<jkt.hrms.masters.business.MstrProject> mstrProjects;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="thp_id"
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
	 * Return the value associated with the column: thp_desc
	 */
	public java.lang.String getThpDesc () {
		return thpDesc;
	}

	/**
	 * Set the value related to the column: thp_desc
	 * @param thpDesc the thp_desc value
	 */
	public void setThpDesc (java.lang.String thpDesc) {
		this.thpDesc = thpDesc;
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
	 * Return the value associated with the column: thp_code
	 */
	public java.lang.String getThpCode () {
		return thpCode;
	}

	/**
	 * Set the value related to the column: thp_code
	 * @param thpCode the thp_code value
	 */
	public void setThpCode (java.lang.String thpCode) {
		this.thpCode = thpCode;
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
	 * Return the value associated with the column: MstrSiteDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrSiteDetail> getMstrSiteDetails () {
		return mstrSiteDetails;
	}

	/**
	 * Set the value related to the column: MstrSiteDetails
	 * @param mstrSiteDetails the MstrSiteDetails value
	 */
	public void setMstrSiteDetails (java.util.Set<jkt.hrms.masters.business.MstrSiteDetail> mstrSiteDetails) {
		this.mstrSiteDetails = mstrSiteDetails;
	}

	public void addToMstrSiteDetails (jkt.hrms.masters.business.MstrSiteDetail mstrSiteDetail) {
		if (null == getMstrSiteDetails()) setMstrSiteDetails(new java.util.TreeSet<jkt.hrms.masters.business.MstrSiteDetail>());
		getMstrSiteDetails().add(mstrSiteDetail);
	}



	/**
	 * Return the value associated with the column: MstrProjects
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrProject> getMstrProjects () {
		return mstrProjects;
	}

	/**
	 * Set the value related to the column: MstrProjects
	 * @param mstrProjects the MstrProjects value
	 */
	public void setMstrProjects (java.util.Set<jkt.hrms.masters.business.MstrProject> mstrProjects) {
		this.mstrProjects = mstrProjects;
	}

	public void addToMstrProjects (jkt.hrms.masters.business.MstrProject mstrProject) {
		if (null == getMstrProjects()) setMstrProjects(new java.util.TreeSet<jkt.hrms.masters.business.MstrProject>());
		getMstrProjects().add(mstrProject);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrTherapeutic)) return false;
		else {
			jkt.hrms.masters.business.MstrTherapeutic mstrTherapeutic = (jkt.hrms.masters.business.MstrTherapeutic) obj;
			if (null == this.getId() || null == mstrTherapeutic.getId()) return false;
			else return (this.getId().equals(mstrTherapeutic.getId()));
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