package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_experience table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_experience"
 */

public abstract class BaseHrEmployeeExperience  implements Serializable {

	public static String REF = "HrEmployeeExperience";
	public static String PROP_CITY_ID = "CityId";
	public static String PROP_EXP_MONTHS = "ExpMonths";
	public static String PROP_EXP_YRS = "ExpYrs";
	public static String PROP_SERVICE_END_DATE = "ServiceEndDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PREVIOUS_EMPLOYER = "PreviousEmployer";
	public static String PROP_PHONE_NO = "PhoneNo";
	public static String PROP_SKILLS = "Skills";
	public static String PROP_EXPERIENCE_TYPE_CODE = "ExperienceTypeCode";
	public static String PROP_STATE_ID = "StateId";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_COUNTRY_ID = "CountryId";
	public static String PROP_ID = "Id";
	public static String PROP_AWARDS = "Awards";
	public static String PROP_SERVICE_START_DATE = "ServiceStartDate";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_PREVIOUS_SERVICE_END_REASON = "PreviousServiceEndReason";


	// constructors
	public BaseHrEmployeeExperience () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeeExperience (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer expYrs;
	private java.lang.Integer expMonths;
	private java.util.Date serviceStartDate;
	private java.util.Date serviceEndDate;
	private java.lang.String previousEmployer;
	private java.lang.String designation;
	private java.lang.String awards;
	private java.lang.String previousServiceEndReason;
	private java.lang.String phoneNo;
	private java.lang.String address;
	private java.lang.Integer countryId;
	private java.lang.Integer stateId;
	private java.lang.Integer cityId;
	private java.lang.String skills;
	private java.lang.Integer experienceTypeCode;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="experience_id"
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
	 * Return the value associated with the column: exp_yrs
	 */
	public java.lang.Integer getExpYrs () {
		return expYrs;
	}

	/**
	 * Set the value related to the column: exp_yrs
	 * @param expYrs the exp_yrs value
	 */
	public void setExpYrs (java.lang.Integer expYrs) {
		this.expYrs = expYrs;
	}



	/**
	 * Return the value associated with the column: exp_months
	 */
	public java.lang.Integer getExpMonths () {
		return expMonths;
	}

	/**
	 * Set the value related to the column: exp_months
	 * @param expMonths the exp_months value
	 */
	public void setExpMonths (java.lang.Integer expMonths) {
		this.expMonths = expMonths;
	}



	/**
	 * Return the value associated with the column: service_start_date
	 */
	public java.util.Date getServiceStartDate () {
		return serviceStartDate;
	}

	/**
	 * Set the value related to the column: service_start_date
	 * @param serviceStartDate the service_start_date value
	 */
	public void setServiceStartDate (java.util.Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}



	/**
	 * Return the value associated with the column: service_end_date
	 */
	public java.util.Date getServiceEndDate () {
		return serviceEndDate;
	}

	/**
	 * Set the value related to the column: service_end_date
	 * @param serviceEndDate the service_end_date value
	 */
	public void setServiceEndDate (java.util.Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}



	/**
	 * Return the value associated with the column: previous_employer
	 */
	public java.lang.String getPreviousEmployer () {
		return previousEmployer;
	}

	/**
	 * Set the value related to the column: previous_employer
	 * @param previousEmployer the previous_employer value
	 */
	public void setPreviousEmployer (java.lang.String previousEmployer) {
		this.previousEmployer = previousEmployer;
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
	 * Return the value associated with the column: awards
	 */
	public java.lang.String getAwards () {
		return awards;
	}

	/**
	 * Set the value related to the column: awards
	 * @param awards the awards value
	 */
	public void setAwards (java.lang.String awards) {
		this.awards = awards;
	}



	/**
	 * Return the value associated with the column: previous_service_end_reason
	 */
	public java.lang.String getPreviousServiceEndReason () {
		return previousServiceEndReason;
	}

	/**
	 * Set the value related to the column: previous_service_end_reason
	 * @param previousServiceEndReason the previous_service_end_reason value
	 */
	public void setPreviousServiceEndReason (java.lang.String previousServiceEndReason) {
		this.previousServiceEndReason = previousServiceEndReason;
	}



	/**
	 * Return the value associated with the column: phone_no
	 */
	public java.lang.String getPhoneNo () {
		return phoneNo;
	}

	/**
	 * Set the value related to the column: phone_no
	 * @param phoneNo the phone_no value
	 */
	public void setPhoneNo (java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
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
	 * Return the value associated with the column: country_id
	 */
	public java.lang.Integer getCountryId () {
		return countryId;
	}

	/**
	 * Set the value related to the column: country_id
	 * @param countryId the country_id value
	 */
	public void setCountryId (java.lang.Integer countryId) {
		this.countryId = countryId;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public java.lang.Integer getStateId () {
		return stateId;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param stateId the state_id value
	 */
	public void setStateId (java.lang.Integer stateId) {
		this.stateId = stateId;
	}



	/**
	 * Return the value associated with the column: city_id
	 */
	public java.lang.Integer getCityId () {
		return cityId;
	}

	/**
	 * Set the value related to the column: city_id
	 * @param cityId the city_id value
	 */
	public void setCityId (java.lang.Integer cityId) {
		this.cityId = cityId;
	}



	/**
	 * Return the value associated with the column: skills
	 */
	public java.lang.String getSkills () {
		return skills;
	}

	/**
	 * Set the value related to the column: skills
	 * @param skills the skills value
	 */
	public void setSkills (java.lang.String skills) {
		this.skills = skills;
	}



	/**
	 * Return the value associated with the column: experience_type_code
	 */
	public java.lang.Integer getExperienceTypeCode () {
		return experienceTypeCode;
	}

	/**
	 * Set the value related to the column: experience_type_code
	 * @param experienceTypeCode the experience_type_code value
	 */
	public void setExperienceTypeCode (java.lang.Integer experienceTypeCode) {
		this.experienceTypeCode = experienceTypeCode;
	}



	/**
	 * Return the value associated with the column: employee_Id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_Id
	 * @param employee the employee_Id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrEmployeeExperience)) return false;
		else {
			jkt.hrms.masters.business.HrEmployeeExperience hrEmployeeExperience = (jkt.hrms.masters.business.HrEmployeeExperience) obj;
			if (null == this.getId() || null == hrEmployeeExperience.getId()) return false;
			else return (this.getId().equals(hrEmployeeExperience.getId()));
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