package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_meeting_agenda_point table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_meeting_agenda_point"
 */

public abstract class BaseHrMeetingAgendaPoint  implements Serializable {

	public static String REF = "HrMeetingAgendaPoint";
	public static String PROP_AFTER_MEETING_REMARKS = "AfterMeetingRemarks";
	public static String PROP_SCHEDULE = "Schedule";
	public static String PROP_ACTION = "Action";
	public static String PROP_DECISION = "Decision";
	public static String PROP_AGENDA_POINT = "AgendaPoint";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_INFO = "Info";
	public static String PROP_REFERENCE = "Reference";


	// constructors
	public BaseHrMeetingAgendaPoint () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMeetingAgendaPoint (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String agendaPoint;
	private java.lang.String reference;
	private java.lang.String remarks;
	private java.lang.String decision;
	private java.lang.String action;
	private java.lang.String info;
	private java.lang.String afterMeetingRemarks;

	// many to one
	private jkt.hms.masters.business.HrMeetingSchedule schedule;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="agenda_point_id"
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
	 * Return the value associated with the column: agenda_point
	 */
	public java.lang.String getAgendaPoint () {
		return agendaPoint;
	}

	/**
	 * Set the value related to the column: agenda_point
	 * @param agendaPoint the agenda_point value
	 */
	public void setAgendaPoint (java.lang.String agendaPoint) {
		this.agendaPoint = agendaPoint;
	}



	/**
	 * Return the value associated with the column: reference
	 */
	public java.lang.String getReference () {
		return reference;
	}

	/**
	 * Set the value related to the column: reference
	 * @param reference the reference value
	 */
	public void setReference (java.lang.String reference) {
		this.reference = reference;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: decision
	 */
	public java.lang.String getDecision () {
		return decision;
	}

	/**
	 * Set the value related to the column: decision
	 * @param decision the decision value
	 */
	public void setDecision (java.lang.String decision) {
		this.decision = decision;
	}



	/**
	 * Return the value associated with the column: action
	 */
	public java.lang.String getAction () {
		return action;
	}

	/**
	 * Set the value related to the column: action
	 * @param action the action value
	 */
	public void setAction (java.lang.String action) {
		this.action = action;
	}



	/**
	 * Return the value associated with the column: info
	 */
	public java.lang.String getInfo () {
		return info;
	}

	/**
	 * Set the value related to the column: info
	 * @param info the info value
	 */
	public void setInfo (java.lang.String info) {
		this.info = info;
	}



	/**
	 * Return the value associated with the column: after_meeting_remarks
	 */
	public java.lang.String getAfterMeetingRemarks () {
		return afterMeetingRemarks;
	}

	/**
	 * Set the value related to the column: after_meeting_remarks
	 * @param afterMeetingRemarks the after_meeting_remarks value
	 */
	public void setAfterMeetingRemarks (java.lang.String afterMeetingRemarks) {
		this.afterMeetingRemarks = afterMeetingRemarks;
	}



	/**
	 * Return the value associated with the column: schedule_id
	 */
	public jkt.hms.masters.business.HrMeetingSchedule getSchedule () {
		return schedule;
	}

	/**
	 * Set the value related to the column: schedule_id
	 * @param schedule the schedule_id value
	 */
	public void setSchedule (jkt.hms.masters.business.HrMeetingSchedule schedule) {
		this.schedule = schedule;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMeetingAgendaPoint)) return false;
		else {
			jkt.hms.masters.business.HrMeetingAgendaPoint hrMeetingAgendaPoint = (jkt.hms.masters.business.HrMeetingAgendaPoint) obj;
			if (null == this.getId() || null == hrMeetingAgendaPoint.getId()) return false;
			else return (this.getId().equals(hrMeetingAgendaPoint.getId()));
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