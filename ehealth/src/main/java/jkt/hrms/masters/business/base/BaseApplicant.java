package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the applicant table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="applicant"
 */

public abstract class BaseApplicant implements Serializable {

	public static String REF = "Applicant";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ZIP_CODE = "ZipCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CITY = "City";
	public static String PROP_APPLICANT_CODE = "ApplicantCode";
	public static String PROP_TELEPHONE_NO = "TelephoneNo";
	public static String PROP_EMAIL = "Email";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_CELL_NO = "CellNo";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_COMPANY = "Company";
	public static String PROP_TITLE = "Title";
	public static String PROP_APPLIED_DATE = "AppliedDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_LAST_NAME = "LastName";

	// constructors
	public BaseApplicant() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApplicant(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseApplicant(java.lang.Integer id, java.lang.String firstName,
			java.lang.Integer applicantCode) {

		this.setId(id);
		this.setFirstName(firstName);
		this.setApplicantCode(applicantCode);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String firstName;
	private java.lang.String middleName;
	private java.lang.String lastName;
	private java.lang.Integer cellNo;
	private java.lang.String email;
	private java.lang.String city;
	private java.lang.String state;
	private java.lang.String country;
	private java.lang.String status;
	private java.lang.Integer telephoneNo;
	private java.lang.Integer zipCode;
	private java.lang.Integer applicantCode;
	private java.lang.String address;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.util.Date appliedDate;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasTitle title;
	private jkt.hms.masters.business.MasHospital company;

	// collections
	private java.util.Set<jkt.hrms.masters.business.ApplicantRefrenceDetails> applicantRefrenceDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: first_name
	 */
	public java.lang.String getFirstName() {
		return firstName;
	}

	/**
	 * Set the value related to the column: first_name
	 * 
	 * @param firstName
	 *            the first_name value
	 */
	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Return the value associated with the column: middle_name
	 */
	public java.lang.String getMiddleName() {
		return middleName;
	}

	/**
	 * Set the value related to the column: middle_name
	 * 
	 * @param middleName
	 *            the middle_name value
	 */
	public void setMiddleName(java.lang.String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Return the value associated with the column: last_name
	 */
	public java.lang.String getLastName() {
		return lastName;
	}

	/**
	 * Set the value related to the column: last_name
	 * 
	 * @param lastName
	 *            the last_name value
	 */
	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return the value associated with the column: cell_no
	 */
	public java.lang.Integer getCellNo() {
		return cellNo;
	}

	/**
	 * Set the value related to the column: cell_no
	 * 
	 * @param cellNo
	 *            the cell_no value
	 */
	public void setCellNo(java.lang.Integer cellNo) {
		this.cellNo = cellNo;
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
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity() {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * 
	 * @param city
	 *            the city value
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * Return the value associated with the column: state
	 */
	public java.lang.String getState() {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * 
	 * @param state
	 *            the state value
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: country
	 */
	public java.lang.String getCountry() {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * 
	 * @param country
	 *            the country value
	 */
	public void setCountry(java.lang.String country) {
		this.country = country;
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
	 * Return the value associated with the column: telephone_no
	 */
	public java.lang.Integer getTelephoneNo() {
		return telephoneNo;
	}

	/**
	 * Set the value related to the column: telephone_no
	 * 
	 * @param telephoneNo
	 *            the telephone_no value
	 */
	public void setTelephoneNo(java.lang.Integer telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	/**
	 * Return the value associated with the column: zip_code
	 */
	public java.lang.Integer getZipCode() {
		return zipCode;
	}

	/**
	 * Set the value related to the column: zip_code
	 * 
	 * @param zipCode
	 *            the zip_code value
	 */
	public void setZipCode(java.lang.Integer zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Return the value associated with the column: applicant_code
	 */
	public java.lang.Integer getApplicantCode() {
		return applicantCode;
	}

	/**
	 * Set the value related to the column: applicant_code
	 * 
	 * @param applicantCode
	 *            the applicant_code value
	 */
	public void setApplicantCode(java.lang.Integer applicantCode) {
		this.applicantCode = applicantCode;
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
	 * Return the value associated with the column: applied_date
	 */
	public java.util.Date getAppliedDate() {
		return appliedDate;
	}

	/**
	 * Set the value related to the column: applied_date
	 * 
	 * @param appliedDate
	 *            the applied_date value
	 */
	public void setAppliedDate(java.util.Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: title_id
	 */
	public jkt.hms.masters.business.MasTitle getTitle() {
		return title;
	}

	/**
	 * Set the value related to the column: title_id
	 * 
	 * @param title
	 *            the title_id value
	 */
	public void setTitle(jkt.hms.masters.business.MasTitle title) {
		this.title = title;
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

	/**
	 * Return the value associated with the column: ApplicantRefrenceDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.ApplicantRefrenceDetails> getApplicantRefrenceDetails() {
		return applicantRefrenceDetails;
	}

	/**
	 * Set the value related to the column: ApplicantRefrenceDetails
	 * 
	 * @param applicantRefrenceDetails
	 *            the ApplicantRefrenceDetails value
	 */
	public void setApplicantRefrenceDetails(
			java.util.Set<jkt.hrms.masters.business.ApplicantRefrenceDetails> applicantRefrenceDetails) {
		this.applicantRefrenceDetails = applicantRefrenceDetails;
	}

	public void addToApplicantRefrenceDetails(
			jkt.hrms.masters.business.ApplicantRefrenceDetails applicantRefrenceDetails) {
		if (null == getApplicantRefrenceDetails()) {
			setApplicantRefrenceDetails(new java.util.TreeSet<jkt.hrms.masters.business.ApplicantRefrenceDetails>());
		}
		getApplicantRefrenceDetails().add(applicantRefrenceDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.Applicant)) {
			return false;
		} else {
			jkt.hrms.masters.business.Applicant applicant = (jkt.hrms.masters.business.Applicant) obj;
			if (null == this.getId() || null == applicant.getId()) {
				return false;
			} else {
				return (this.getId().equals(applicant.getId()));
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