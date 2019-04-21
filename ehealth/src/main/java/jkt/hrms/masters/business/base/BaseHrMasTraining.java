package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_mas_training table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_mas_training"
 */

public abstract class BaseHrMasTraining implements Serializable {

	public static String REF = "HrMasTraining";
	public static String PROP_STATUS = "Status";
	public static String PROP_TRAINING_NAME = "TrainingName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_FEES_CHARGED = "FeesCharged";
	public static String PROP_DISTRICT = "District";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TRAINING_INSTITUTE = "TrainingInstitute";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COURSE_ID = "CourseId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PINCODE = "Pincode";
	public static String PROP_PHONE_NO = "PhoneNo";
	public static String PROP_TRAINING_CODE = "TrainingCode";
	public static String PROP_TOPICS_COVERED = "TopicsCovered";
	public static String PROP_TRAINING_SKILLS = "TrainingSkills";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_COMPANY = "Company";
	public static String PROP_SEAT_AVAILABLE = "SeatAvailable";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_SKILL_REQUIRED = "SkillRequired";
	public static String PROP_ID = "Id";

	// constructors
	public BaseHrMasTraining() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasTraining(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String trainingCode;
	private java.lang.String trainingName;
	private java.lang.String trainingInstitute;
	private java.lang.String trainingSkills;
	private java.lang.Integer courseId;
	private java.lang.String topicsCovered;
	private java.lang.Integer seatAvailable;
	private java.lang.String address;
	private java.lang.String pincode;
	private java.lang.String phoneNo;
	private java.math.BigDecimal feesCharged;
	private java.lang.String skillRequired;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasHospital company;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="training_id"
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
	 * Return the value associated with the column: training_code
	 */
	public java.lang.String getTrainingCode() {
		return trainingCode;
	}

	/**
	 * Set the value related to the column: training_code
	 * 
	 * @param trainingCode
	 *            the training_code value
	 */
	public void setTrainingCode(java.lang.String trainingCode) {
		this.trainingCode = trainingCode;
	}

	/**
	 * Return the value associated with the column: training_name
	 */
	public java.lang.String getTrainingName() {
		return trainingName;
	}

	/**
	 * Set the value related to the column: training_name
	 * 
	 * @param trainingName
	 *            the training_name value
	 */
	public void setTrainingName(java.lang.String trainingName) {
		this.trainingName = trainingName;
	}

	/**
	 * Return the value associated with the column: training_institute
	 */
	public java.lang.String getTrainingInstitute() {
		return trainingInstitute;
	}

	/**
	 * Set the value related to the column: training_institute
	 * 
	 * @param trainingInstitute
	 *            the training_institute value
	 */
	public void setTrainingInstitute(java.lang.String trainingInstitute) {
		this.trainingInstitute = trainingInstitute;
	}

	/**
	 * Return the value associated with the column: training_skills
	 */
	public java.lang.String getTrainingSkills() {
		return trainingSkills;
	}

	/**
	 * Set the value related to the column: training_skills
	 * 
	 * @param trainingSkills
	 *            the training_skills value
	 */
	public void setTrainingSkills(java.lang.String trainingSkills) {
		this.trainingSkills = trainingSkills;
	}

	/**
	 * Return the value associated with the column: course_id
	 */
	public java.lang.Integer getCourseId() {
		return courseId;
	}

	/**
	 * Set the value related to the column: course_id
	 * 
	 * @param courseId
	 *            the course_id value
	 */
	public void setCourseId(java.lang.Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * Return the value associated with the column: topics_covered
	 */
	public java.lang.String getTopicsCovered() {
		return topicsCovered;
	}

	/**
	 * Set the value related to the column: topics_covered
	 * 
	 * @param topicsCovered
	 *            the topics_covered value
	 */
	public void setTopicsCovered(java.lang.String topicsCovered) {
		this.topicsCovered = topicsCovered;
	}

	/**
	 * Return the value associated with the column: seat_available
	 */
	public java.lang.Integer getSeatAvailable() {
		return seatAvailable;
	}

	/**
	 * Set the value related to the column: seat_available
	 * 
	 * @param seatAvailable
	 *            the seat_available value
	 */
	public void setSeatAvailable(java.lang.Integer seatAvailable) {
		this.seatAvailable = seatAvailable;
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
	 * Return the value associated with the column: fees_charged
	 */
	public java.math.BigDecimal getFeesCharged() {
		return feesCharged;
	}

	/**
	 * Set the value related to the column: fees_charged
	 * 
	 * @param feesCharged
	 *            the fees_charged value
	 */
	public void setFeesCharged(java.math.BigDecimal feesCharged) {
		this.feesCharged = feesCharged;
	}

	/**
	 * Return the value associated with the column: skill_required
	 */
	public java.lang.String getSkillRequired() {
		return skillRequired;
	}

	/**
	 * Set the value related to the column: skill_required
	 * 
	 * @param skillRequired
	 *            the skill_required value
	 */
	public void setSkillRequired(java.lang.String skillRequired) {
		this.skillRequired = skillRequired;
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
		if (!(obj instanceof jkt.hrms.masters.business.HrMasTraining)) {
			return false;
		} else {
			jkt.hrms.masters.business.HrMasTraining hrMasTraining = (jkt.hrms.masters.business.HrMasTraining) obj;
			if (null == this.getId() || null == hrMasTraining.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrMasTraining.getId()));
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