package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_patvisitsch table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_patvisitsch"
 */

public abstract class BasePrjPatvisitsch  implements Serializable {

	public static String REF = "PrjPatvisitsch";
	public static String PROP_PV_INT = "PvInt";
	public static String PROP_VISIT_TYPE = "VisitType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRJ = "Prj";
	public static String PROP_ENTIRE_SCHEDULE = "EntireSchedule";
	public static String PROP_BETWEEN_VISIT = "BetweenVisit";
	public static String PROP_STATUS = "Status";
	public static String PROP_PATIENT_VISIT = "PatientVisit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_PV_NAME = "PvName";


	// constructors
	public BasePrjPatvisitsch () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjPatvisitsch (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String pvName;
	private java.lang.Integer pvInt;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer betweenVisit;
	private java.lang.Integer entireSchedule;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.MstrPtvisit patientVisit;
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hrms.masters.business.HrMasVisitType visitType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Pv_id"
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
	 * Return the value associated with the column: Pv_Name
	 */
	public java.lang.String getPvName () {
		return pvName;
	}

	/**
	 * Set the value related to the column: Pv_Name
	 * @param pvName the Pv_Name value
	 */
	public void setPvName (java.lang.String pvName) {
		this.pvName = pvName;
	}



	/**
	 * Return the value associated with the column: Pv_Int
	 */
	public java.lang.Integer getPvInt () {
		return pvInt;
	}

	/**
	 * Set the value related to the column: Pv_Int
	 * @param pvInt the Pv_Int value
	 */
	public void setPvInt (java.lang.Integer pvInt) {
		this.pvInt = pvInt;
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
	 * Return the value associated with the column: between_visit
	 */
	public java.lang.Integer getBetweenVisit () {
		return betweenVisit;
	}

	/**
	 * Set the value related to the column: between_visit
	 * @param betweenVisit the between_visit value
	 */
	public void setBetweenVisit (java.lang.Integer betweenVisit) {
		this.betweenVisit = betweenVisit;
	}



	/**
	 * Return the value associated with the column: entire_schedule
	 */
	public java.lang.Integer getEntireSchedule () {
		return entireSchedule;
	}

	/**
	 * Set the value related to the column: entire_schedule
	 * @param entireSchedule the entire_schedule value
	 */
	public void setEntireSchedule (java.lang.Integer entireSchedule) {
		this.entireSchedule = entireSchedule;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
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
	 * Return the value associated with the column: Prj_id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: Prj_id
	 * @param prj the Prj_id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}



	/**
	 * Return the value associated with the column: visit_type_id
	 */
	public jkt.hrms.masters.business.HrMasVisitType getVisitType () {
		return visitType;
	}

	/**
	 * Set the value related to the column: visit_type_id
	 * @param visitType the visit_type_id value
	 */
	public void setVisitType (jkt.hrms.masters.business.HrMasVisitType visitType) {
		this.visitType = visitType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjPatvisitsch)) return false;
		else {
			jkt.hrms.masters.business.PrjPatvisitsch prjPatvisitsch = (jkt.hrms.masters.business.PrjPatvisitsch) obj;
			if (null == this.getId() || null == prjPatvisitsch.getId()) return false;
			else return (this.getId().equals(prjPatvisitsch.getId()));
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