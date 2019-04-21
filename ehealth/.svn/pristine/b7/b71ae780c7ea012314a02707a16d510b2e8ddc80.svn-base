package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_mas_instructor table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_mas_instructor"
 */

public abstract class BaseHrMasInstructor implements Serializable {

	public static String REF = "HrMasInstructor";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_DISTRICT = "District";
	public static String PROP_QUALIFICATION = "Qualification";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TRANSPORT = "Transport";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TRANSPORT_AMOUNT = "TransportAmount";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_INSTRUCTOR_TYPE = "InstructorType";
	public static String PROP_INSTRUCTOR_CODE = "InstructorCode";
	public static String PROP_PINCODE = "Pincode";
	public static String PROP_PHONE_NO = "PhoneNo";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ID = "Id";
	public static String PROP_INSTRUCTOR_NAME = "InstructorName";

	// constructors
	public BaseHrMasInstructor() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasInstructor(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String instructorCode;
	private java.lang.String instructorName;
	private java.lang.String instructorType;
	private java.lang.String address;
	private java.lang.String pincode;
	private java.lang.String phoneNo;
	private java.lang.String transport;
	private java.math.BigDecimal transportAmount;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hrms.masters.business.HrMasQualification qualification;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasHospital company;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="instructor_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: instructor_code
	 */
	public java.lang.String getInstructorCode() {
		return instructorCode;
	}

	/**
	 * Set the value related to the column: instructor_code
	 * 
	 * @param instructorCode
	 *            the instructor_code value
	 */
	public void setInstructorCode(java.lang.String instructorCode) {
		this.instructorCode = instructorCode;
	}

	/**
	 * Return the value associated with the column: instructor_name
	 */
	public java.lang.String getInstructorName() {
		return instructorName;
	}

	/**
	 * Set the value related to the column: instructor_name
	 * 
	 * @param instructorName
	 *            the instructor_name value
	 */
	public void setInstructorName(java.lang.String instructorName) {
		this.instructorName = instructorName;
	}

	/**
	 * Return the value associated with the column: instructor_type
	 */
	public java.lang.String getInstructorType() {
		return instructorType;
	}

	/**
	 * Set the value related to the column: instructor_type
	 * 
	 * @param instructorType
	 *            the instructor_type value
	 */
	public void setInstructorType(java.lang.String instructorType) {
		this.instructorType = instructorType;
	}

	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * 
	 * @param address
	 *            the address value
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * Return the value associated with the column: pincode
	 */
	public java.lang.String getPincode() {
		return pincode;
	}

	/**
	 * Set the value related to the column: pincode
	 * 
	 * @param pincode
	 *            the pincode value
	 */
	public void setPincode(java.lang.String pincode) {
		this.pincode = pincode;
	}

	/**
	 * Return the value associated with the column: phone_no
	 */
	public java.lang.String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Set the value related to the column: phone_no
	 * 
	 * @param phoneNo
	 *            the phone_no value
	 */
	public void setPhoneNo(java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Return the value associated with the column: transport
	 */
	public java.lang.String getTransport() {
		return transport;
	}

	/**
	 * Set the value related to the column: transport
	 * 
	 * @param transport
	 *            the transport value
	 */
	public void setTransport(java.lang.String transport) {
		this.transport = transport;
	}

	/**
	 * Return the value associated with the column: transport_amount
	 */
	public java.math.BigDecimal getTransportAmount() {
		return transportAmount;
	}

	/**
	 * Set the value related to the column: transport_amount
	 * 
	 * @param transportAmount
	 *            the transport_amount value
	 */
	public void setTransportAmount(java.math.BigDecimal transportAmount) {
		this.transportAmount = transportAmount;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: qualification_id
	 */
	public jkt.hrms.masters.business.HrMasQualification getQualification() {
		return qualification;
	}

	/**
	 * Set the value related to the column: qualification_id
	 * 
	 * @param qualification
	 *            the qualification_id value
	 */
	public void setQualification(
			jkt.hrms.masters.business.HrMasQualification qualification) {
		this.qualification = qualification;
	}

	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState() {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * 
	 * @param state
	 *            the state_id value
	 */
	public void setState(jkt.hms.masters.business.MasState state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: country_id
	 */
	public jkt.hms.masters.business.MasCountry getCountry() {
		return country;
	}

	/**
	 * Set the value related to the column: country_id
	 * 
	 * @param country
	 *            the country_id value
	 */
	public void setCountry(jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}

	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict() {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * 
	 * @param district
	 *            the district_id value
	 */
	public void setDistrict(jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}

	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany() {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * 
	 * @param company
	 *            the company_id value
	 */
	public void setCompany(jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.HrMasInstructor)) {
			return false;
		} else {
			jkt.hrms.masters.business.HrMasInstructor hrMasInstructor = (jkt.hrms.masters.business.HrMasInstructor) obj;
			if (null == this.getId() || null == hrMasInstructor.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrMasInstructor.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}