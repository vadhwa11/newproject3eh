package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_site_milestone table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_site_milestone"
 */

public abstract class BasePrjSiteMilestone  implements Serializable {

	public static String REF = "PrjSiteMilestone";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PRJ = "Prj";
	public static String PROP_STATUS = "Status";
	public static String PROP_PATIENT_VISIT = "PatientVisit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CUT_OF_DATE = "CutOfDate";
	public static String PROP_MILES_STONE_AMOUNT = "MilesStoneAmount";
	public static String PROP_MILES_STONE_PERCENTAGE = "MilesStonePercentage";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TOTAL_AMOUNT_PER_PATIENT = "TotalAmountPerPatient";
	public static String PROP_SITE_HEADER = "SiteHeader";


	// constructors
	public BasePrjSiteMilestone () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjSiteMilestone (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal milesStoneAmount;
	private java.math.BigDecimal milesStonePercentage;
	private java.math.BigDecimal totalAmountPerPatient;
	private java.util.Date cutOfDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrSiteHeader siteHeader;
	private jkt.hrms.masters.business.MstrPtvisit patientVisit;
	private jkt.hrms.masters.business.MstrProject prj;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="site_miles_stone_id"
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
	 * Return the value associated with the column: miles_stone_amount
	 */
	public java.math.BigDecimal getMilesStoneAmount () {
		return milesStoneAmount;
	}

	/**
	 * Set the value related to the column: miles_stone_amount
	 * @param milesStoneAmount the miles_stone_amount value
	 */
	public void setMilesStoneAmount (java.math.BigDecimal milesStoneAmount) {
		this.milesStoneAmount = milesStoneAmount;
	}



	/**
	 * Return the value associated with the column: miles_stone_percentage
	 */
	public java.math.BigDecimal getMilesStonePercentage () {
		return milesStonePercentage;
	}

	/**
	 * Set the value related to the column: miles_stone_percentage
	 * @param milesStonePercentage the miles_stone_percentage value
	 */
	public void setMilesStonePercentage (java.math.BigDecimal milesStonePercentage) {
		this.milesStonePercentage = milesStonePercentage;
	}



	/**
	 * Return the value associated with the column: total_amount_per_patient
	 */
	public java.math.BigDecimal getTotalAmountPerPatient () {
		return totalAmountPerPatient;
	}

	/**
	 * Set the value related to the column: total_amount_per_patient
	 * @param totalAmountPerPatient the total_amount_per_patient value
	 */
	public void setTotalAmountPerPatient (java.math.BigDecimal totalAmountPerPatient) {
		this.totalAmountPerPatient = totalAmountPerPatient;
	}



	/**
	 * Return the value associated with the column: cut_of_date
	 */
	public java.util.Date getCutOfDate () {
		return cutOfDate;
	}

	/**
	 * Set the value related to the column: cut_of_date
	 * @param cutOfDate the cut_of_date value
	 */
	public void setCutOfDate (java.util.Date cutOfDate) {
		this.cutOfDate = cutOfDate;
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
	 * Return the value associated with the column: patient_visit_id
	 */
	public jkt.hrms.masters.business.MstrPtvisit getPatientVisit () {
		return patientVisit;
	}

	/**
	 * Set the value related to the column: patient_visit_id
	 * @param patientVisit the patient_visit_id value
	 */
	public void setPatientVisit (jkt.hrms.masters.business.MstrPtvisit patientVisit) {
		this.patientVisit = patientVisit;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjSiteMilestone)) return false;
		else {
			jkt.hrms.masters.business.PrjSiteMilestone prjSiteMilestone = (jkt.hrms.masters.business.PrjSiteMilestone) obj;
			if (null == this.getId() || null == prjSiteMilestone.getId()) return false;
			else return (this.getId().equals(prjSiteMilestone.getId()));
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