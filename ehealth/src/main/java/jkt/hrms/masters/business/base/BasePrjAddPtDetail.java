package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_add_pt_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_add_pt_detail"
 */

public abstract class BasePrjAddPtDetail  implements Serializable {

	public static String REF = "PrjAddPtDetail";
	public static String PROP_PV = "Pv";
	public static String PROP_ACTUAL_DATE = "ActualDate";
	public static String PROP_ADD_PT_HEADER = "AddPtHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_PLANNED_DATE = "PlannedDate";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_SCHEDULE_STATUS = "ScheduleStatus";
	public static String PROP_REVISED_DATE = "RevisedDate";
	public static String PROP_VISIT_INTERVAL = "VisitInterval";
	public static String PROP_VARIATION = "Variation";
	public static String PROP_ID = "Id";
	public static String PROP_PV_ID = "PvId";


	// constructors
	public BasePrjAddPtDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjAddPtDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date plannedDate;
	private java.lang.Integer visitInterval;
	private java.util.Date actualDate;
	private java.lang.String status;
	private java.lang.Integer pvId;
	private java.util.Date revisedDate;
	private java.lang.String scheduleStatus;
	private java.lang.String comments;
	private java.lang.Integer variation;

	// many to one
	private jkt.hrms.masters.business.PrjPatvisitsch pv;
	private jkt.hrms.masters.business.PrjAddPtHeader addPtHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ad_pt_detail"
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
	 * Return the value associated with the column: Pv_id
	 */
	public java.lang.Integer getPvId () {
		return pvId;
	}

	/**
	 * Set the value related to the column: Pv_id
	 * @param pvId the Pv_id value
	 */
	public void setPvId (java.lang.Integer pvId) {
		this.pvId = pvId;
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
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param comments the comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
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
	 * Return the value associated with the column: add_pt_header_id
	 */
	public jkt.hrms.masters.business.PrjAddPtHeader getAddPtHeader () {
		return addPtHeader;
	}

	/**
	 * Set the value related to the column: add_pt_header_id
	 * @param addPtHeader the add_pt_header_id value
	 */
	public void setAddPtHeader (jkt.hrms.masters.business.PrjAddPtHeader addPtHeader) {
		this.addPtHeader = addPtHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjAddPtDetail)) return false;
		else {
			jkt.hrms.masters.business.PrjAddPtDetail prjAddPtDetail = (jkt.hrms.masters.business.PrjAddPtDetail) obj;
			if (null == this.getId() || null == prjAddPtDetail.getId()) return false;
			else return (this.getId().equals(prjAddPtDetail.getId()));
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