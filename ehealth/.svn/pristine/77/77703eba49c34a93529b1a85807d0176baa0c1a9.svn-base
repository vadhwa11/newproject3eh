package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_contact_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_contact_details"
 */

public abstract class BasePhContactDetails  implements Serializable {

	public static String REF = "PhContactDetails";
	public static String PROP_MEMBER = "Member";
	public static String PROP_REGISTRATION_DATE = "RegistrationDate";
	public static String PROP_CONTACT_STATUS = "ContactStatus";
	public static String PROP_ID = "Id";
	public static String PROP_REGISTRATION_TIME = "RegistrationTime";
	public static String PROP_REGISTRATED_NO = "RegistratedNo";
	public static String PROP_REGISTRATION_BY = "RegistrationBy";
	public static String PROP_CONTECT_TYPE = "ContectType";
	public static String PROP_CONTACT_NO = "ContactNo";


	// constructors
	public BasePhContactDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhContactDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String contactNo;
	private java.lang.String contectType;
	private java.lang.String contactStatus;
	private java.lang.String registratedNo;
	private java.util.Date registrationDate;
	private java.lang.String registrationTime;

	// many to one
	private jkt.hms.masters.business.Users registrationBy;
	private jkt.hms.masters.business.PhFamilySurvey member;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="contact_details_id"
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
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: contect_type
	 */
	public java.lang.String getContectType () {
		return contectType;
	}

	/**
	 * Set the value related to the column: contect_type
	 * @param contectType the contect_type value
	 */
	public void setContectType (java.lang.String contectType) {
		this.contectType = contectType;
	}



	/**
	 * Return the value associated with the column: contact_status
	 */
	public java.lang.String getContactStatus () {
		return contactStatus;
	}

	/**
	 * Set the value related to the column: contact_status
	 * @param contactStatus the contact_status value
	 */
	public void setContactStatus (java.lang.String contactStatus) {
		this.contactStatus = contactStatus;
	}



	/**
	 * Return the value associated with the column: registrated_no
	 */
	public java.lang.String getRegistratedNo () {
		return registratedNo;
	}

	/**
	 * Set the value related to the column: registrated_no
	 * @param registratedNo the registrated_no value
	 */
	public void setRegistratedNo (java.lang.String registratedNo) {
		this.registratedNo = registratedNo;
	}



	/**
	 * Return the value associated with the column: registration_date
	 */
	public java.util.Date getRegistrationDate () {
		return registrationDate;
	}

	/**
	 * Set the value related to the column: registration_date
	 * @param registrationDate the registration_date value
	 */
	public void setRegistrationDate (java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
	}



	/**
	 * Return the value associated with the column: registration_time
	 */
	public java.lang.String getRegistrationTime () {
		return registrationTime;
	}

	/**
	 * Set the value related to the column: registration_time
	 * @param registrationTime the registration_time value
	 */
	public void setRegistrationTime (java.lang.String registrationTime) {
		this.registrationTime = registrationTime;
	}



	/**
	 * Return the value associated with the column: registration_by
	 */
	public jkt.hms.masters.business.Users getRegistrationBy () {
		return registrationBy;
	}

	/**
	 * Set the value related to the column: registration_by
	 * @param registrationBy the registration_by value
	 */
	public void setRegistrationBy (jkt.hms.masters.business.Users registrationBy) {
		this.registrationBy = registrationBy;
	}



	/**
	 * Return the value associated with the column: member_id
	 */
	public jkt.hms.masters.business.PhFamilySurvey getMember () {
		return member;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param member the member_id value
	 */
	public void setMember (jkt.hms.masters.business.PhFamilySurvey member) {
		this.member = member;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhContactDetails)) return false;
		else {
			jkt.hms.masters.business.PhContactDetails phContactDetails = (jkt.hms.masters.business.PhContactDetails) obj;
			if (null == this.getId() || null == phContactDetails.getId()) return false;
			else return (this.getId().equals(phContactDetails.getId()));
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