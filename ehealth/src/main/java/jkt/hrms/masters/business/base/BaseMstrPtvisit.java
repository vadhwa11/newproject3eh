package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_ptvisit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_ptvisit"
 */

public abstract class BaseMstrPtvisit  implements Serializable {

	public static String REF = "MstrPtvisit";
	public static String PROP_VISIT_TYPE = "VisitType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_PATIENT_VISIT_NAME = "PatientVisitName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PATIENT_VISIT_CODE = "PatientVisitCode";


	// constructors
	public BaseMstrPtvisit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrPtvisit (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patientVisitName;
	private java.lang.String status;
	private java.lang.String patientVisitCode;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.HrMasVisitType visitType;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjMilestone> prjMilestones;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="patient_visit_id"
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
	 * Return the value associated with the column: patient_visit_name
	 */
	public java.lang.String getPatientVisitName () {
		return patientVisitName;
	}

	/**
	 * Set the value related to the column: patient_visit_name
	 * @param patientVisitName the patient_visit_name value
	 */
	public void setPatientVisitName (java.lang.String patientVisitName) {
		this.patientVisitName = patientVisitName;
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
	 * Return the value associated with the column: patient_visit_code
	 */
	public java.lang.String getPatientVisitCode () {
		return patientVisitCode;
	}

	/**
	 * Set the value related to the column: patient_visit_code
	 * @param patientVisitCode the patient_visit_code value
	 */
	public void setPatientVisitCode (java.lang.String patientVisitCode) {
		this.patientVisitCode = patientVisitCode;
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
	 * Return the value associated with the column: visit_type
	 */
	public jkt.hrms.masters.business.HrMasVisitType getVisitType () {
		return visitType;
	}

	/**
	 * Set the value related to the column: visit_type
	 * @param visitType the visit_type value
	 */
	public void setVisitType (jkt.hrms.masters.business.HrMasVisitType visitType) {
		this.visitType = visitType;
	}



	/**
	 * Return the value associated with the column: PrjMilestones
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjMilestone> getPrjMilestones () {
		return prjMilestones;
	}

	/**
	 * Set the value related to the column: PrjMilestones
	 * @param prjMilestones the PrjMilestones value
	 */
	public void setPrjMilestones (java.util.Set<jkt.hrms.masters.business.PrjMilestone> prjMilestones) {
		this.prjMilestones = prjMilestones;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrPtvisit)) return false;
		else {
			jkt.hrms.masters.business.MstrPtvisit mstrPtvisit = (jkt.hrms.masters.business.MstrPtvisit) obj;
			if (null == this.getId() || null == mstrPtvisit.getId()) return false;
			else return (this.getId().equals(mstrPtvisit.getId()));
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