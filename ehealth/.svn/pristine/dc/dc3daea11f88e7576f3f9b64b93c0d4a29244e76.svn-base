package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_employee_education table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_employee_education"
 */

public abstract class BaseHrMasEmployeeEducation  implements Serializable {

	public static String REF = "HrMasEmployeeEducation";
	public static String PROP_QUALIFICATION = "Qualification";
	public static String PROP_SKILL_DETAILS = "SkillDetails";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PASSING_YEAR = "PassingYear";
	public static String PROP_EDUCATION_TYPE_CODE = "EducationTypeCode";
	public static String PROP_QUALIFIED_DATE = "QualifiedDate";
	public static String PROP_COURSE_DURATION = "CourseDuration";
	public static String PROP_COURSE = "Course";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_SKILL_ID = "SkillId";
	public static String PROP_ID = "Id";
	public static String PROP_AWARDS = "Awards";
	public static String PROP_COURSE_DURATION_UNIT = "CourseDurationUnit";
	public static String PROP_SPL_QUALIFICATION = "SplQualification";
	public static String PROP_INSTITUTE = "Institute";


	// constructors
	public BaseHrMasEmployeeEducation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasEmployeeEducation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer skillId;
	private java.lang.String skillDetails;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.util.Date qualifiedDate;
	private java.lang.String awards;
	private java.lang.String passingYear;
	private java.lang.String courseDurationUnit;
	private java.lang.Integer courseDuration;
	private java.lang.Integer educationTypeCode;

	// many to one
	private jkt.hrms.masters.business.HrMasQualification qualification;
	private jkt.hrms.masters.business.HrMasCourse course;
	private jkt.hrms.masters.business.HrMasSpecialQualification splQualification;
	private jkt.hrms.masters.business.HrMasInstitute institute;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="education_id"
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
	 * Return the value associated with the column: skill_id
	 */
	public java.lang.Integer getSkillId () {
		return skillId;
	}

	/**
	 * Set the value related to the column: skill_id
	 * @param skillId the skill_id value
	 */
	public void setSkillId (java.lang.Integer skillId) {
		this.skillId = skillId;
	}



	/**
	 * Return the value associated with the column: skill_details
	 */
	public java.lang.String getSkillDetails () {
		return skillDetails;
	}

	/**
	 * Set the value related to the column: skill_details
	 * @param skillDetails the skill_details value
	 */
	public void setSkillDetails (java.lang.String skillDetails) {
		this.skillDetails = skillDetails;
	}



	/**
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * @param startDate the start_date value
	 */
	public void setStartDate (java.util.Date startDate) {
		this.startDate = startDate;
	}



	/**
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
	}



	/**
	 * Return the value associated with the column: qualified_date
	 */
	public java.util.Date getQualifiedDate () {
		return qualifiedDate;
	}

	/**
	 * Set the value related to the column: qualified_date
	 * @param qualifiedDate the qualified_date value
	 */
	public void setQualifiedDate (java.util.Date qualifiedDate) {
		this.qualifiedDate = qualifiedDate;
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
	 * Return the value associated with the column: passing_year
	 */
	public java.lang.String getPassingYear () {
		return passingYear;
	}

	/**
	 * Set the value related to the column: passing_year
	 * @param passingYear the passing_year value
	 */
	public void setPassingYear (java.lang.String passingYear) {
		this.passingYear = passingYear;
	}



	/**
	 * Return the value associated with the column: cource_duration_unit
	 */
	public java.lang.String getCourseDurationUnit () {
		return courseDurationUnit;
	}

	/**
	 * Set the value related to the column: cource_duration_unit
	 * @param courseDurationUnit the cource_duration_unit value
	 */
	public void setCourseDurationUnit (java.lang.String courseDurationUnit) {
		this.courseDurationUnit = courseDurationUnit;
	}



	/**
	 * Return the value associated with the column: course_duration
	 */
	public java.lang.Integer getCourseDuration () {
		return courseDuration;
	}

	/**
	 * Set the value related to the column: course_duration
	 * @param courseDuration the course_duration value
	 */
	public void setCourseDuration (java.lang.Integer courseDuration) {
		this.courseDuration = courseDuration;
	}



	/**
	 * Return the value associated with the column: education_type_code
	 */
	public java.lang.Integer getEducationTypeCode () {
		return educationTypeCode;
	}

	/**
	 * Set the value related to the column: education_type_code
	 * @param educationTypeCode the education_type_code value
	 */
	public void setEducationTypeCode (java.lang.Integer educationTypeCode) {
		this.educationTypeCode = educationTypeCode;
	}



	/**
	 * Return the value associated with the column: qualification_id
	 */
	public jkt.hrms.masters.business.HrMasQualification getQualification () {
		return qualification;
	}

	/**
	 * Set the value related to the column: qualification_id
	 * @param qualification the qualification_id value
	 */
	public void setQualification (jkt.hrms.masters.business.HrMasQualification qualification) {
		this.qualification = qualification;
	}



	/**
	 * Return the value associated with the column: course_id
	 */
	public jkt.hrms.masters.business.HrMasCourse getCourse () {
		return course;
	}

	/**
	 * Set the value related to the column: course_id
	 * @param course the course_id value
	 */
	public void setCourse (jkt.hrms.masters.business.HrMasCourse course) {
		this.course = course;
	}



	/**
	 * Return the value associated with the column: spl_qualification_id
	 */
	public jkt.hrms.masters.business.HrMasSpecialQualification getSplQualification () {
		return splQualification;
	}

	/**
	 * Set the value related to the column: spl_qualification_id
	 * @param splQualification the spl_qualification_id value
	 */
	public void setSplQualification (jkt.hrms.masters.business.HrMasSpecialQualification splQualification) {
		this.splQualification = splQualification;
	}



	/**
	 * Return the value associated with the column: institute_id
	 */
	public jkt.hrms.masters.business.HrMasInstitute getInstitute () {
		return institute;
	}

	/**
	 * Set the value related to the column: institute_id
	 * @param institute the institute_id value
	 */
	public void setInstitute (jkt.hrms.masters.business.HrMasInstitute institute) {
		this.institute = institute;
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
		if (!(obj instanceof jkt.hrms.masters.business.HrMasEmployeeEducation)) return false;
		else {
			jkt.hrms.masters.business.HrMasEmployeeEducation hrMasEmployeeEducation = (jkt.hrms.masters.business.HrMasEmployeeEducation) obj;
			if (null == this.getId() || null == hrMasEmployeeEducation.getId()) return false;
			else return (this.getId().equals(hrMasEmployeeEducation.getId()));
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