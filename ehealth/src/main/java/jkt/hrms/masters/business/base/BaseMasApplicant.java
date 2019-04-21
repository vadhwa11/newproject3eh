package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_applicant table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_applicant"
 */

public abstract class BaseMasApplicant implements Serializable {

	public static String REF = "MasApplicant";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_ZIP_CODE = "ZipCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CITY = "City";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_APPLICANT_CODE = "ApplicantCode";
	public static String PROP_JOB = "Job";
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
	public BaseMasApplicant() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasApplicant(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasApplicant(java.lang.Integer id, java.lang.String firstName,
			java.lang.String applicantCode) {

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
	private java.lang.String cellNo;
	private java.lang.String email;
	private java.lang.String status;
	private java.lang.String telephoneNo;
	private java.lang.String zipCode;
	private java.lang.String applicantCode;
	private java.lang.String address;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.util.Date appliedDate;

	// many to one
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hrms.masters.business.MasJob job;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDistrict city;
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
	public java.lang.String getCellNo() {
		return cellNo;
	}

	/**
	 * Set the value related to the column: cell_no
	 * 
	 * @param cellNo
	 *            the cell_no value
	 */
	public void setCellNo(java.lang.String cellNo) {
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
	public java.lang.String getTelephoneNo() {
		return telephoneNo;
	}

	/**
	 * Set the value related to the column: telephone_no
	 * 
	 * @param telephoneNo
	 *            the telephone_no value
	 */
	public void setTelephoneNo(java.lang.String telephoneNo) {
		this.telephoneNo = telephoneNo;
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
	 * Return the value associated with the column: applicant_code
	 */
	public java.lang.String getApplicantCode() {
		return applicantCode;
	}

	/**
	 * Set the value related to the column: applicant_code
	 * 
	 * @param applicantCode
	 *            the applicant_code value
	 */
	public void setApplicantCode(java.lang.String applicantCode) {
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
	 * Return the value associated with the column: job_id
	 */
	public jkt.hrms.masters.business.MasJob getJob() {
		return job;
	}

	/**
	 * Set the value related to the column: job_id
	 * 
	 * @param job
	 *            the job_id value
	 */
	public void setJob(jkt.hrms.masters.business.MasJob job) {
		this.job = job;
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
		if (!(obj instanceof jkt.hrms.masters.business.MasApplicant)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasApplicant masApplicant = (jkt.hrms.masters.business.MasApplicant) obj;
			if (null == this.getId() || null == masApplicant.getId()) {
				return false;
			} else {
				return (this.getId().equals(masApplicant.getId()));
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