package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_schedule_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_schedule_header"
 */

public abstract class BasePrjScheduleHeader  implements Serializable {

	public static String REF = "PrjScheduleHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_SITE = "Site";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PRJ = "Prj";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SITE_INITIATION_DATE = "SiteInitiationDate";


	// constructors
	public BasePrjScheduleHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjScheduleHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date siteInitiationDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.HrMasVisitType visit;
	private jkt.hrms.masters.business.MstrSiteHeader site;
	private jkt.hrms.masters.business.MstrProject prj;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjScheduleDetail> prjScheduleDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="schedule_header_id"
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
	 * Return the value associated with the column: site_initiation_date
	 */
	public java.util.Date getSiteInitiationDate () {
		return siteInitiationDate;
	}

	/**
	 * Set the value related to the column: site_initiation_date
	 * @param siteInitiationDate the site_initiation_date value
	 */
	public void setSiteInitiationDate (java.util.Date siteInitiationDate) {
		this.siteInitiationDate = siteInitiationDate;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hrms.masters.business.HrMasVisitType getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hrms.masters.business.HrMasVisitType visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: site_id
	 */
	public jkt.hrms.masters.business.MstrSiteHeader getSite () {
		return site;
	}

	/**
	 * Set the value related to the column: site_id
	 * @param site the site_id value
	 */
	public void setSite (jkt.hrms.masters.business.MstrSiteHeader site) {
		this.site = site;
	}



	/**
	 * Return the value associated with the column: prj_id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: prj_id
	 * @param prj the prj_id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}



	/**
	 * Return the value associated with the column: PrjScheduleDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjScheduleDetail> getPrjScheduleDetails () {
		return prjScheduleDetails;
	}

	/**
	 * Set the value related to the column: PrjScheduleDetails
	 * @param prjScheduleDetails the PrjScheduleDetails value
	 */
	public void setPrjScheduleDetails (java.util.Set<jkt.hrms.masters.business.PrjScheduleDetail> prjScheduleDetails) {
		this.prjScheduleDetails = prjScheduleDetails;
	}

	public void addToPrjScheduleDetails (jkt.hrms.masters.business.PrjScheduleDetail prjScheduleDetail) {
		if (null == getPrjScheduleDetails()) setPrjScheduleDetails(new java.util.TreeSet<jkt.hrms.masters.business.PrjScheduleDetail>());
		getPrjScheduleDetails().add(prjScheduleDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjScheduleHeader)) return false;
		else {
			jkt.hrms.masters.business.PrjScheduleHeader prjScheduleHeader = (jkt.hrms.masters.business.PrjScheduleHeader) obj;
			if (null == this.getId() || null == prjScheduleHeader.getId()) return false;
			else return (this.getId().equals(prjScheduleHeader.getId()));
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