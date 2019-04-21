package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_meeting_schedule table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_meeting_schedule"
 */

public abstract class BaseHrMeetingSchedule  implements Serializable {

	public static String REF = "HrMeetingSchedule";
	public static String PROP_AFTER_MEETING_REMARKS = "AfterMeetingRemarks";
	public static String PROP_ACTUAL_DATE = "ActualDate";
	public static String PROP_MEETING_NO = "MeetingNo";
	public static String PROP_SCHEDULED_TIME_FROM = "ScheduledTimeFrom";
	public static String PROP_ACTUAL_TIME_TO = "ActualTimeTo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LOCATION = "Location";
	public static String PROP_SCHEDULED_DATE = "ScheduledDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_AFTER_MEETING_DATE = "AfterMeetingDate";
	public static String PROP_MEETING_TYPE = "MeetingType";
	public static String PROP_MEETING_MEMBER_TYPE = "MeetingMemberType";
	public static String PROP_SCHEDULED_TIME_TO = "ScheduledTimeTo";
	public static String PROP_STATUS = "Status";
	public static String PROP_CHAIRED_BY = "ChairedBy";
	public static String PROP_MEETING_ID = "MeetingId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VENUE = "Venue";
	public static String PROP_ACTUAL_CHAIRED_BY = "ActualChairedBy";
	public static String PROP_DATE = "Date";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ACTUAL_TIME_FROM = "ActualTimeFrom";


	// constructors
	public BaseHrMeetingSchedule () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMeetingSchedule (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String meetingId;
	private java.lang.String meetingNo;
	private java.util.Date date;
	private java.util.Date afterMeetingDate;
	private java.lang.String meetingType;
	private java.util.Date scheduledDate;
	private java.lang.String scheduledTimeFrom;
	private java.lang.String scheduledTimeTo;
	private java.lang.String venue;
	private java.lang.String chairedBy;
	private java.lang.String meetingMemberType;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date actualDate;
	private java.lang.String actualTimeFrom;
	private java.lang.String actualTimeTo;
	private java.lang.String actualChairedBy;
	private java.lang.String afterMeetingRemarks;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital location;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrMeetingAgendaPoint> hrMeetingAgendaPoints;
	private java.util.Set<jkt.hms.masters.business.HrMeetingMembers> hrMeetingMembers;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="schedule_id"
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
	 * Return the value associated with the column: meeting_id
	 */
	public java.lang.String getMeetingId () {
		return meetingId;
	}

	/**
	 * Set the value related to the column: meeting_id
	 * @param meetingId the meeting_id value
	 */
	public void setMeetingId (java.lang.String meetingId) {
		this.meetingId = meetingId;
	}



	/**
	 * Return the value associated with the column: meeting_no
	 */
	public java.lang.String getMeetingNo () {
		return meetingNo;
	}

	/**
	 * Set the value related to the column: meeting_no
	 * @param meetingNo the meeting_no value
	 */
	public void setMeetingNo (java.lang.String meetingNo) {
		this.meetingNo = meetingNo;
	}



	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: after_meeting_date
	 */
	public java.util.Date getAfterMeetingDate () {
		return afterMeetingDate;
	}

	/**
	 * Set the value related to the column: after_meeting_date
	 * @param afterMeetingDate the after_meeting_date value
	 */
	public void setAfterMeetingDate (java.util.Date afterMeetingDate) {
		this.afterMeetingDate = afterMeetingDate;
	}



	/**
	 * Return the value associated with the column: meeting_type
	 */
	public java.lang.String getMeetingType () {
		return meetingType;
	}

	/**
	 * Set the value related to the column: meeting_type
	 * @param meetingType the meeting_type value
	 */
	public void setMeetingType (java.lang.String meetingType) {
		this.meetingType = meetingType;
	}



	/**
	 * Return the value associated with the column: scheduled_date
	 */
	public java.util.Date getScheduledDate () {
		return scheduledDate;
	}

	/**
	 * Set the value related to the column: scheduled_date
	 * @param scheduledDate the scheduled_date value
	 */
	public void setScheduledDate (java.util.Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}



	/**
	 * Return the value associated with the column: scheduled_time_from
	 */
	public java.lang.String getScheduledTimeFrom () {
		return scheduledTimeFrom;
	}

	/**
	 * Set the value related to the column: scheduled_time_from
	 * @param scheduledTimeFrom the scheduled_time_from value
	 */
	public void setScheduledTimeFrom (java.lang.String scheduledTimeFrom) {
		this.scheduledTimeFrom = scheduledTimeFrom;
	}



	/**
	 * Return the value associated with the column: scheduled_time_to
	 */
	public java.lang.String getScheduledTimeTo () {
		return scheduledTimeTo;
	}

	/**
	 * Set the value related to the column: scheduled_time_to
	 * @param scheduledTimeTo the scheduled_time_to value
	 */
	public void setScheduledTimeTo (java.lang.String scheduledTimeTo) {
		this.scheduledTimeTo = scheduledTimeTo;
	}



	/**
	 * Return the value associated with the column: venue
	 */
	public java.lang.String getVenue () {
		return venue;
	}

	/**
	 * Set the value related to the column: venue
	 * @param venue the venue value
	 */
	public void setVenue (java.lang.String venue) {
		this.venue = venue;
	}



	/**
	 * Return the value associated with the column: chaired_by
	 */
	public java.lang.String getChairedBy () {
		return chairedBy;
	}

	/**
	 * Set the value related to the column: chaired_by
	 * @param chairedBy the chaired_by value
	 */
	public void setChairedBy (java.lang.String chairedBy) {
		this.chairedBy = chairedBy;
	}



	/**
	 * Return the value associated with the column: meeting_member_type
	 */
	public java.lang.String getMeetingMemberType () {
		return meetingMemberType;
	}

	/**
	 * Set the value related to the column: meeting_member_type
	 * @param meetingMemberType the meeting_member_type value
	 */
	public void setMeetingMemberType (java.lang.String meetingMemberType) {
		this.meetingMemberType = meetingMemberType;
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
	 * Return the value associated with the column: actual_time_from
	 */
	public java.lang.String getActualTimeFrom () {
		return actualTimeFrom;
	}

	/**
	 * Set the value related to the column: actual_time_from
	 * @param actualTimeFrom the actual_time_from value
	 */
	public void setActualTimeFrom (java.lang.String actualTimeFrom) {
		this.actualTimeFrom = actualTimeFrom;
	}



	/**
	 * Return the value associated with the column: actual_time_to
	 */
	public java.lang.String getActualTimeTo () {
		return actualTimeTo;
	}

	/**
	 * Set the value related to the column: actual_time_to
	 * @param actualTimeTo the actual_time_to value
	 */
	public void setActualTimeTo (java.lang.String actualTimeTo) {
		this.actualTimeTo = actualTimeTo;
	}



	/**
	 * Return the value associated with the column: actual_chaired_by
	 */
	public java.lang.String getActualChairedBy () {
		return actualChairedBy;
	}

	/**
	 * Set the value related to the column: actual_chaired_by
	 * @param actualChairedBy the actual_chaired_by value
	 */
	public void setActualChairedBy (java.lang.String actualChairedBy) {
		this.actualChairedBy = actualChairedBy;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: location_id
	 */
	public jkt.hms.masters.business.MasHospital getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location_id
	 * @param location the location_id value
	 */
	public void setLocation (jkt.hms.masters.business.MasHospital location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: HrMeetingAgendaPoints
	 */
	public java.util.Set<jkt.hms.masters.business.HrMeetingAgendaPoint> getHrMeetingAgendaPoints () {
		return hrMeetingAgendaPoints;
	}

	/**
	 * Set the value related to the column: HrMeetingAgendaPoints
	 * @param hrMeetingAgendaPoints the HrMeetingAgendaPoints value
	 */
	public void setHrMeetingAgendaPoints (java.util.Set<jkt.hms.masters.business.HrMeetingAgendaPoint> hrMeetingAgendaPoints) {
		this.hrMeetingAgendaPoints = hrMeetingAgendaPoints;
	}

	public void addToHrMeetingAgendaPoints (jkt.hms.masters.business.HrMeetingAgendaPoint hrMeetingAgendaPoint) {
		if (null == getHrMeetingAgendaPoints()) setHrMeetingAgendaPoints(new java.util.TreeSet<jkt.hms.masters.business.HrMeetingAgendaPoint>());
		getHrMeetingAgendaPoints().add(hrMeetingAgendaPoint);
	}



	/**
	 * Return the value associated with the column: HrMeetingMembers
	 */
	public java.util.Set<jkt.hms.masters.business.HrMeetingMembers> getHrMeetingMembers () {
		return hrMeetingMembers;
	}

	/**
	 * Set the value related to the column: HrMeetingMembers
	 * @param hrMeetingMembers the HrMeetingMembers value
	 */
	public void setHrMeetingMembers (java.util.Set<jkt.hms.masters.business.HrMeetingMembers> hrMeetingMembers) {
		this.hrMeetingMembers = hrMeetingMembers;
	}

	public void addToHrMeetingMembers (jkt.hms.masters.business.HrMeetingMembers hrMeetingMembers) {
		if (null == getHrMeetingMembers()) setHrMeetingMembers(new java.util.TreeSet<jkt.hms.masters.business.HrMeetingMembers>());
		getHrMeetingMembers().add(hrMeetingMembers);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMeetingSchedule)) return false;
		else {
			jkt.hms.masters.business.HrMeetingSchedule hrMeetingSchedule = (jkt.hms.masters.business.HrMeetingSchedule) obj;
			if (null == this.getId() || null == hrMeetingSchedule.getId()) return false;
			else return (this.getId().equals(hrMeetingSchedule.getId()));
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