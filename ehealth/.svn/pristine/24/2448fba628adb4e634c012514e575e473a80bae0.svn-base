package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_add_pt_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_add_pt_header"
 */

public abstract class BasePrjAddPtHeader  implements Serializable {

	public static String REF = "PrjAddPtHeader";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PRJ = "Prj";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DOB = "Dob";
	public static String PROP_RANDOMIZATION_NO = "RandomizationNo";
	public static String PROP_RANDOMIZATION_DATE = "RandomizationDate";
	public static String PROP_INITIAL_VISIT_DATE = "InitialVisitDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_ICD_DATE = "IcdDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SCREENING_DATE = "ScreeningDate";
	public static String PROP_ENROLLMENT_NO = "EnrollmentNo";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SITE_HEADER = "SiteHeader";
	public static String PROP_SCREENING_NO = "ScreeningNo";
	public static String PROP_PATIENT_INITIALS = "PatientInitials";


	// constructors
	public BasePrjAddPtHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjAddPtHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String screeningNo;
	private java.util.Date screeningDate;
	private java.lang.String enrollmentNo;
	private java.lang.String patientInitials;
	private java.lang.String randomizationNo;
	private java.util.Date randomizationDate;
	private java.util.Date icdDate;
	private java.util.Date initialVisitDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.util.Date dob;

	// many to one
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrSiteHeader siteHeader;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjAddPtDetail> prjAddPtDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="add_pt_header_id"
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
	 * Return the value associated with the column: screening_no
	 */
	public java.lang.String getScreeningNo () {
		return screeningNo;
	}

	/**
	 * Set the value related to the column: screening_no
	 * @param screeningNo the screening_no value
	 */
	public void setScreeningNo (java.lang.String screeningNo) {
		this.screeningNo = screeningNo;
	}



	/**
	 * Return the value associated with the column: screening_date
	 */
	public java.util.Date getScreeningDate () {
		return screeningDate;
	}

	/**
	 * Set the value related to the column: screening_date
	 * @param screeningDate the screening_date value
	 */
	public void setScreeningDate (java.util.Date screeningDate) {
		this.screeningDate = screeningDate;
	}



	/**
	 * Return the value associated with the column: enrollment_no
	 */
	public java.lang.String getEnrollmentNo () {
		return enrollmentNo;
	}

	/**
	 * Set the value related to the column: enrollment_no
	 * @param enrollmentNo the enrollment_no value
	 */
	public void setEnrollmentNo (java.lang.String enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}



	/**
	 * Return the value associated with the column: patient_initials
	 */
	public java.lang.String getPatientInitials () {
		return patientInitials;
	}

	/**
	 * Set the value related to the column: patient_initials
	 * @param patientInitials the patient_initials value
	 */
	public void setPatientInitials (java.lang.String patientInitials) {
		this.patientInitials = patientInitials;
	}



	/**
	 * Return the value associated with the column: randomization_no
	 */
	public java.lang.String getRandomizationNo () {
		return randomizationNo;
	}

	/**
	 * Set the value related to the column: randomization_no
	 * @param randomizationNo the randomization_no value
	 */
	public void setRandomizationNo (java.lang.String randomizationNo) {
		this.randomizationNo = randomizationNo;
	}



	/**
	 * Return the value associated with the column: randomization_date
	 */
	public java.util.Date getRandomizationDate () {
		return randomizationDate;
	}

	/**
	 * Set the value related to the column: randomization_date
	 * @param randomizationDate the randomization_date value
	 */
	public void setRandomizationDate (java.util.Date randomizationDate) {
		this.randomizationDate = randomizationDate;
	}



	/**
	 * Return the value associated with the column: icd_date
	 */
	public java.util.Date getIcdDate () {
		return icdDate;
	}

	/**
	 * Set the value related to the column: icd_date
	 * @param icdDate the icd_date value
	 */
	public void setIcdDate (java.util.Date icdDate) {
		this.icdDate = icdDate;
	}



	/**
	 * Return the value associated with the column: initial_visit_date
	 */
	public java.util.Date getInitialVisitDate () {
		return initialVisitDate;
	}

	/**
	 * Set the value related to the column: initial_visit_date
	 * @param initialVisitDate the initial_visit_date value
	 */
	public void setInitialVisitDate (java.util.Date initialVisitDate) {
		this.initialVisitDate = initialVisitDate;
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
	 * Return the value associated with the column: dob
	 */
	public java.util.Date getDob () {
		return dob;
	}

	/**
	 * Set the value related to the column: dob
	 * @param dob the dob value
	 */
	public void setDob (java.util.Date dob) {
		this.dob = dob;
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
	 * Return the value associated with the column: PrjAddPtDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjAddPtDetail> getPrjAddPtDetails () {
		return prjAddPtDetails;
	}

	/**
	 * Set the value related to the column: PrjAddPtDetails
	 * @param prjAddPtDetails the PrjAddPtDetails value
	 */
	public void setPrjAddPtDetails (java.util.Set<jkt.hrms.masters.business.PrjAddPtDetail> prjAddPtDetails) {
		this.prjAddPtDetails = prjAddPtDetails;
	}

	public void addToPrjAddPtDetails (jkt.hrms.masters.business.PrjAddPtDetail prjAddPtDetail) {
		if (null == getPrjAddPtDetails()) setPrjAddPtDetails(new java.util.TreeSet<jkt.hrms.masters.business.PrjAddPtDetail>());
		getPrjAddPtDetails().add(prjAddPtDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjAddPtHeader)) return false;
		else {
			jkt.hrms.masters.business.PrjAddPtHeader prjAddPtHeader = (jkt.hrms.masters.business.PrjAddPtHeader) obj;
			if (null == this.getId() || null == prjAddPtHeader.getId()) return false;
			else return (this.getId().equals(prjAddPtHeader.getId()));
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