package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_milestone table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_milestone"
 */

public abstract class BasePrjMilestone  implements Serializable {

	public static String REF = "PrjMilestone";
	public static String PROP_MILESTONE_AMOUNT = "MilestoneAmount";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TOTAL_AMT_PER_PATIENT = "TotalAmtPerPatient";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PRJ = "Prj";
	public static String PROP_MILESTONE_PERCENTAGE = "MilestonePercentage";
	public static String PROP_CUT_OFF_DATE = "CutOffDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_PATIENT_VISIT = "PatientVisit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MASTER = "Master";


	// constructors
	public BasePrjMilestone () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjMilestone (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal milestonePercentage;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String master;
	private java.math.BigDecimal milestoneAmount;
	private java.math.BigDecimal totalAmtPerPatient;
	private java.util.Date cutOffDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrPtvisit patientVisit;
	private jkt.hrms.masters.business.MstrProject prj;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="milestone_id"
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
	 * Return the value associated with the column: milestone_percentage
	 */
	public java.math.BigDecimal getMilestonePercentage () {
		return milestonePercentage;
	}

	/**
	 * Set the value related to the column: milestone_percentage
	 * @param milestonePercentage the milestone_percentage value
	 */
	public void setMilestonePercentage (java.math.BigDecimal milestonePercentage) {
		this.milestonePercentage = milestonePercentage;
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
	 * Return the value associated with the column: Master
	 */
	public java.lang.String getMaster () {
		return master;
	}

	/**
	 * Set the value related to the column: Master
	 * @param master the Master value
	 */
	public void setMaster (java.lang.String master) {
		this.master = master;
	}



	/**
	 * Return the value associated with the column: milestone_amount
	 */
	public java.math.BigDecimal getMilestoneAmount () {
		return milestoneAmount;
	}

	/**
	 * Set the value related to the column: milestone_amount
	 * @param milestoneAmount the milestone_amount value
	 */
	public void setMilestoneAmount (java.math.BigDecimal milestoneAmount) {
		this.milestoneAmount = milestoneAmount;
	}



	/**
	 * Return the value associated with the column: total_amt_per_patient
	 */
	public java.math.BigDecimal getTotalAmtPerPatient () {
		return totalAmtPerPatient;
	}

	/**
	 * Set the value related to the column: total_amt_per_patient
	 * @param totalAmtPerPatient the total_amt_per_patient value
	 */
	public void setTotalAmtPerPatient (java.math.BigDecimal totalAmtPerPatient) {
		this.totalAmtPerPatient = totalAmtPerPatient;
	}



	/**
	 * Return the value associated with the column: cut_off_date
	 */
	public java.util.Date getCutOffDate () {
		return cutOffDate;
	}

	/**
	 * Set the value related to the column: cut_off_date
	 * @param cutOffDate the cut_off_date value
	 */
	public void setCutOffDate (java.util.Date cutOffDate) {
		this.cutOffDate = cutOffDate;
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
	 * Return the value associated with the column: Prj_Id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: Prj_Id
	 * @param prj the Prj_Id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjMilestone)) return false;
		else {
			jkt.hrms.masters.business.PrjMilestone prjMilestone = (jkt.hrms.masters.business.PrjMilestone) obj;
			if (null == this.getId() || null == prjMilestone.getId()) return false;
			else return (this.getId().equals(prjMilestone.getId()));
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