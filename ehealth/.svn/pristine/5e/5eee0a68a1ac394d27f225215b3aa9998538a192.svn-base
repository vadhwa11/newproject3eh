package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_schedule_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_schedule_detail"
 */

public abstract class BasePrjScheduleDetail  implements Serializable {

	public static String REF = "PrjScheduleDetail";
	public static String PROP_PV = "Pv";
	public static String PROP_ACTUAL_DATE = "ActualDate";
	public static String PROP_PLANNED_DATE = "PlannedDate";
	public static String PROP_PATIENT_VISIT = "PatientVisit";
	public static String PROP_SCHEDULE_HEADER = "ScheduleHeader";
	public static String PROP_SCHEDULE_STATUS = "ScheduleStatus";
	public static String PROP_VISIT_INTERVAL = "VisitInterval";
	public static String PROP_REVISED_DATE = "RevisedDate";
	public static String PROP_COMMENT = "Comment";
	public static String PROP_VARIATION = "Variation";
	public static String PROP_ID = "Id";


	// constructors
	public BasePrjScheduleDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjScheduleDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date plannedDate;
	private java.util.Date revisedDate;
	private java.util.Date actualDate;
	private java.lang.Integer visitInterval;
	private java.lang.String scheduleStatus;
	private java.lang.String comment;
	private java.lang.Integer variation;

	// many to one
	private jkt.hrms.masters.business.PrjPatvisitsch pv;
	private jkt.hrms.masters.business.MstrPtvisit patientVisit;
	private jkt.hrms.masters.business.PrjScheduleHeader scheduleHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="schedule_detail_id"
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
	 * Return the value associated with the column: planned_date
	 */
	public java.util.Date getPlannedDate () {
		return plannedDate;
	}

	/**
	 * Set the value related to the column: planned_date
	 * @param plannedDate the planned_date value
	 */
	public void setPlannedDate (java.util.Date plannedDate) {
		this.plannedDate = plannedDate;
	}



	/**
	 * Return the value associated with the column: revised_date
	 */
	public java.util.Date getRevisedDate () {
		return revisedDate;
	}

	/**
	 * Set the value related to the column: revised_date
	 * @param revisedDate the revised_date value
	 */
	public void setRevisedDate (java.util.Date revisedDate) {
		this.revisedDate = revisedDate;
	}



	/**
	 * Return the value associated with the column: actual_date
	 */
	public java.util.Date getActualDate () {
		return actualDate;
	}

	/**
	 * Set the value related to the column: actual_date
	 * @param actualDate the actual_date value
	 */
	public void setActualDate (java.util.Date actualDate) {
		this.actualDate = actualDate;
	}



	/**
	 * Return the value associated with the column: visit_interval
	 */
	public java.lang.Integer getVisitInterval () {
		return visitInterval;
	}

	/**
	 * Set the value related to the column: visit_interval
	 * @param visitInterval the visit_interval value
	 */
	public void setVisitInterval (java.lang.Integer visitInterval) {
		this.visitInterval = visitInterval;
	}



	/**
	 * Return the value associated with the column: schedule_status
	 */
	public java.lang.String getScheduleStatus () {
		return scheduleStatus;
	}

	/**
	 * Set the value related to the column: schedule_status
	 * @param scheduleStatus the schedule_status value
	 */
	public void setScheduleStatus (java.lang.String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}



	/**
	 * Return the value associated with the column: comment
	 */
	public java.lang.String getComment () {
		return comment;
	}

	/**
	 * Set the value related to the column: comment
	 * @param comment the comment value
	 */
	public void setComment (java.lang.String comment) {
		this.comment = comment;
	}



	/**
	 * Return the value associated with the column: variation
	 */
	public java.lang.Integer getVariation () {
		return variation;
	}

	/**
	 * Set the value related to the column: variation
	 * @param variation the variation value
	 */
	public void setVariation (java.lang.Integer variation) {
		this.variation = variation;
	}



	/**
	 * Return the value associated with the column: Pv_id
	 */
	public jkt.hrms.masters.business.PrjPatvisitsch getPv () {
		return pv;
	}

	/**
	 * Set the value related to the column: Pv_id
	 * @param pv the Pv_id value
	 */
	public void setPv (jkt.hrms.masters.business.PrjPatvisitsch pv) {
		this.pv = pv;
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
	 * Return the value associated with the column: schedule_header_id
	 */
	public jkt.hrms.masters.business.PrjScheduleHeader getScheduleHeader () {
		return scheduleHeader;
	}

	/**
	 * Set the value related to the column: schedule_header_id
	 * @param scheduleHeader the schedule_header_id value
	 */
	public void setScheduleHeader (jkt.hrms.masters.business.PrjScheduleHeader scheduleHeader) {
		this.scheduleHeader = scheduleHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjScheduleDetail)) return false;
		else {
			jkt.hrms.masters.business.PrjScheduleDetail prjScheduleDetail = (jkt.hrms.masters.business.PrjScheduleDetail) obj;
			if (null == this.getId() || null == prjScheduleDetail.getId()) return false;
			else return (this.getId().equals(prjScheduleDetail.getId()));
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