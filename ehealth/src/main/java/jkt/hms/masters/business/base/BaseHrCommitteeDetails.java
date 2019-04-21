package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_committee_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_committee_details"
 */

public abstract class BaseHrCommitteeDetails  implements Serializable {

	public static String REF = "HrCommitteeDetails";
	public static String PROP_COMMITTEE = "Committee";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_BRIEF_BACKGROUND = "BriefBackground";
	public static String PROP_COMMITTEE_MEMBER_TYPE = "CommitteeMemberType";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_DESIGNATION_NAME = "DesignationName";
	public static String PROP_NAME = "Name";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DESIGNATION = "Designation";


	// constructors
	public BaseHrCommitteeDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrCommitteeDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrCommitteeDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.HrCommitteeHeader committee) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		this.setHospital(hospital);
		this.setCommittee(committee);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String committeeMemberType;
	private java.lang.String name;
	private java.lang.String address;
	private java.lang.String briefBackground;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String designationName;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasRank designation;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.HrCommitteeHeader committee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="committee_member_id"
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
	 * Return the value associated with the column: committee_member_type
	 */
	public java.lang.String getCommitteeMemberType () {
		return committeeMemberType;
	}

	/**
	 * Set the value related to the column: committee_member_type
	 * @param committeeMemberType the committee_member_type value
	 */
	public void setCommitteeMemberType (java.lang.String committeeMemberType) {
		this.committeeMemberType = committeeMemberType;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: brief_background
	 */
	public java.lang.String getBriefBackground () {
		return briefBackground;
	}

	/**
	 * Set the value related to the column: brief_background
	 * @param briefBackground the brief_background value
	 */
	public void setBriefBackground (java.lang.String briefBackground) {
		this.briefBackground = briefBackground;
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
	 * Return the value associated with the column: designation_name
	 */
	public java.lang.String getDesignationName () {
		return designationName;
	}

	/**
	 * Set the value related to the column: designation_name
	 * @param designationName the designation_name value
	 */
	public void setDesignationName (java.lang.String designationName) {
		this.designationName = designationName;
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
	 * Return the value associated with the column: designation_id
	 */
	public jkt.hms.masters.business.MasRank getDesignation () {
		return designation;
	}

	/**
	 * Set the value related to the column: designation_id
	 * @param designation the designation_id value
	 */
	public void setDesignation (jkt.hms.masters.business.MasRank designation) {
		this.designation = designation;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: committee_id
	 */
	public jkt.hms.masters.business.HrCommitteeHeader getCommittee () {
		return committee;
	}

	/**
	 * Set the value related to the column: committee_id
	 * @param committee the committee_id value
	 */
	public void setCommittee (jkt.hms.masters.business.HrCommitteeHeader committee) {
		this.committee = committee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrCommitteeDetails)) return false;
		else {
			jkt.hms.masters.business.HrCommitteeDetails hrCommitteeDetails = (jkt.hms.masters.business.HrCommitteeDetails) obj;
			if (null == this.getId() || null == hrCommitteeDetails.getId()) return false;
			else return (this.getId().equals(hrCommitteeDetails.getId()));
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