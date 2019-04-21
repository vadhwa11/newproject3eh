package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_meeting_members table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_meeting_members"
 */

public abstract class BaseHrMeetingMembers  implements Serializable {

	public static String REF = "HrMeetingMembers";
	public static String PROP_AFTER_MEETING_REMARKS = "AfterMeetingRemarks";
	public static String PROP_SCHEDULE = "Schedule";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_ATTENDANCE = "Attendance";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_MEMBER_NAME = "MemberName";


	// constructors
	public BaseHrMeetingMembers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMeetingMembers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String memberName;
	private java.lang.String designation;
	private java.lang.String remarks;
	private java.lang.String attendance;
	private java.lang.String afterMeetingRemarks;

	// many to one
	private jkt.hms.masters.business.HrMeetingSchedule schedule;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="schedule_members_id"
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
	 * Return the value associated with the column: member_name
	 */
	public java.lang.String getMemberName () {
		return memberName;
	}

	/**
	 * Set the value related to the column: member_name
	 * @param memberName the member_name value
	 */
	public void setMemberName (java.lang.String memberName) {
		this.memberName = memberName;
	}



	/**
	 * Return the value associated with the column: designation
	 */
	public java.lang.String getDesignation () {
		return designation;
	}

	/**
	 * Set the value related to the column: designation
	 * @param designation the designation value
	 */
	public void setDesignation (java.lang.String designation) {
		this.designation = designation;
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
	 * Return the value associated with the column: attendance
	 */
	public java.lang.String getAttendance () {
		return attendance;
	}

	/**
	 * Set the value related to the column: attendance
	 * @param attendance the attendance value
	 */
	public void setAttendance (java.lang.String attendance) {
		this.attendance = attendance;
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
		if (!(obj instanceof jkt.hms.masters.business.HrMeetingMembers)) return false;
		else {
			jkt.hms.masters.business.HrMeetingMembers hrMeetingMembers = (jkt.hms.masters.business.HrMeetingMembers) obj;
			if (null == this.getId() || null == hrMeetingMembers.getId()) return false;
			else return (this.getId().equals(hrMeetingMembers.getId()));
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