package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_physiotherapy_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_physiotherapy_header"
 */

public abstract class BaseMasPhysiotherapyHeader  implements Serializable {

	public static String REF = "MasPhysiotherapyHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_PHYSIOTHERAPIST_ID = "PhysiotherapistId";
	public static String PROP_PROGNOSIS_REPORTS = "PrognosisReports";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VISIT_ID = "VisitId";
	public static String PROP_HOEXAMINATION = "Hoexamination";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PATIENT = "Patient";
	public static String PROP_ID = "Id";
	public static String PROP_PLAN_GOALS = "PlanGoals";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseMasPhysiotherapyHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPhysiotherapyHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasPhysiotherapyHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.MasEmployee physiotherapistId) {

		this.setId(id);
		this.setPhysiotherapistId(physiotherapistId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String hoexamination;
	private java.lang.String planGoals;
	private java.lang.String prognosisReports;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Patient patient;
	private jkt.hms.masters.business.Visit visitId;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee physiotherapistId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="mp_id"
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
	 * Return the value associated with the column: hoexamination
	 */
	public java.lang.String getHoexamination () {
		return hoexamination;
	}

	/**
	 * Set the value related to the column: hoexamination
	 * @param hoexamination the hoexamination value
	 */
	public void setHoexamination (java.lang.String hoexamination) {
		this.hoexamination = hoexamination;
	}



	/**
	 * Return the value associated with the column: plan_goals
	 */
	public java.lang.String getPlanGoals () {
		return planGoals;
	}

	/**
	 * Set the value related to the column: plan_goals
	 * @param planGoals the plan_goals value
	 */
	public void setPlanGoals (java.lang.String planGoals) {
		this.planGoals = planGoals;
	}



	/**
	 * Return the value associated with the column: prognosis_reports
	 */
	public java.lang.String getPrognosisReports () {
		return prognosisReports;
	}

	/**
	 * Set the value related to the column: prognosis_reports
	 * @param prognosisReports the prognosis_reports value
	 */
	public void setPrognosisReports (java.lang.String prognosisReports) {
		this.prognosisReports = prognosisReports;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getPatient () {
		return patient;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param patient the hin_id value
	 */
	public void setPatient (jkt.hms.masters.business.Patient patient) {
		this.patient = patient;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisitId () {
		return visitId;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visitId the visit_id value
	 */
	public void setVisitId (jkt.hms.masters.business.Visit visitId) {
		this.visitId = visitId;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: physiotherapist_id
	 */
	public jkt.hms.masters.business.MasEmployee getPhysiotherapistId () {
		return physiotherapistId;
	}

	/**
	 * Set the value related to the column: physiotherapist_id
	 * @param physiotherapistId the physiotherapist_id value
	 */
	public void setPhysiotherapistId (jkt.hms.masters.business.MasEmployee physiotherapistId) {
		this.physiotherapistId = physiotherapistId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPhysiotherapyHeader)) return false;
		else {
			jkt.hms.masters.business.MasPhysiotherapyHeader masPhysiotherapyHeader = (jkt.hms.masters.business.MasPhysiotherapyHeader) obj;
			if (null == this.getId() || null == masPhysiotherapyHeader.getId()) return false;
			else return (this.getId().equals(masPhysiotherapyHeader.getId()));
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