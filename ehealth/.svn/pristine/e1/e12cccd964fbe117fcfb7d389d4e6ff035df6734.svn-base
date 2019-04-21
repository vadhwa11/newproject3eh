package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * applicant_refrence_details table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="applicant_refrence_details"
 */

public abstract class BaseApplicantRefrenceDetails implements Serializable {

	public static String REF = "ApplicantRefrenceDetails";
	public static String PROP_STATE = "State";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_ZIP_CODE = "ZipCode";
	public static String PROP_CITY = "City";
	public static String PROP_APPLICANT = "Applicant";
	public static String PROP_EMAIL = "Email";
	public static String PROP_PHONE_NO = "PhoneNo";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_NAME = "Name";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY_NAME = "CompanyName";

	// constructors
	public BaseApplicantRefrenceDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApplicantRefrenceDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String address;
	private java.lang.String email;
	private java.lang.String phoneNo;
	private java.lang.String designation;
	private java.lang.String companyName;
	private java.lang.String comments;
	private java.lang.Integer srNo;
	private java.lang.String zipCode;

	// many to one
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hrms.masters.business.MasApplicant applicant;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="id"
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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * 
	 * @param name
	 *            the name value
	 */
	public void setName(java.lang.String name) {
		this.name = name;
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
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * 
	 * @param email
	 *            the email value
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
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
	 * Return the value associated with the column: designation
	 */
	public java.lang.String getDesignation() {
		return designation;
	}

	/**
	 * Set the value related to the column: designation
	 * 
	 * @param designation
	 *            the designation value
	 */
	public void setDesignation(java.lang.String designation) {
		this.designation = designation;
	}

	/**
	 * Return the value associated with the column: company_name
	 */
	public java.lang.String getCompanyName() {
		return companyName;
	}

	/**
	 * Set the value related to the column: company_name
	 * 
	 * @param companyName
	 *            the company_name value
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments() {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * 
	 * @param comments
	 *            the comments value
	 */
	public void setComments(java.lang.String comments) {
		this.comments = comments;
	}

	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: zip_code
	 */
	public java.lang.String getZipCode() {
		return zipCode;
	}

	/**
	 * Set the value related to the column: zip_code
	 * 
	 * @param zipCode
	 *            the zip_code value
	 */
	public void setZipCode(java.lang.String zipCode) {
		this.zipCode = zipCode;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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
	 * Return the value associated with the column: city_id
	 */
	public jkt.hms.masters.business.MasDistrict getCity() {
		return city;
	}

	/**
	 * Set the value related to the column: city_id
	 * 
	 * @param city
	 *            the city_id value
	 */
	public void setCity(jkt.hms.masters.business.MasDistrict city) {
		this.city = city;
	}

	/**
	 * Return the value associated with the column: applicant_id
	 */
	public jkt.hrms.masters.business.MasApplicant getApplicant() {
		return applicant;
	}

	/**
	 * Set the value related to the column: applicant_id
	 * 
	 * @param applicant
	 *            the applicant_id value
	 */
	public void setApplicant(jkt.hrms.masters.business.MasApplicant applicant) {
		this.applicant = applicant;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.ApplicantRefrenceDetails)) {
			return false;
		} else {
			jkt.hrms.masters.business.ApplicantRefrenceDetails applicantRefrenceDetails = (jkt.hrms.masters.business.ApplicantRefrenceDetails) obj;
			if (null == this.getId()
					|| null == applicantRefrenceDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(applicantRefrenceDetails.getId()));
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