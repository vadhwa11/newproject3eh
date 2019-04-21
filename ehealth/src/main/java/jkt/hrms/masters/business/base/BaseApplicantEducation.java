package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the applicant_education table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="applicant_education"
 */

public abstract class BaseApplicantEducation  implements Serializable {

	public static String REF = "ApplicantEducation";
	public static String PROP_QUALIFICATION = "Qualification";
	public static String PROP_DURATION_TYPE = "DurationType";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_GRADE_PERCENTAGE = "GradePercentage";
	public static String PROP_APPLICANT = "Applicant";
	public static String PROP_QUALIFIED_DATE = "QualifiedDate";
	public static String PROP_SKILLS = "Skills";
	public static String PROP_COURSE = "Course";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_EDUCATION_TYPE = "EducationType";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_AWARDS = "Awards";
	public static String PROP_SPL_QUALIFICATION = "SplQualification";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INSTITUTE = "Institute";
	public static String PROP_SR_NO = "SrNo";


	// constructors
	public BaseApplicantEducation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApplicantEducation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.Float duration;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.lang.String awards;
	private java.lang.String skills;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date qualifiedDate;
	private java.lang.Float gradePercentage;
	private java.lang.String educationType;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MasSplQualification splQualification;
	private jkt.hrms.masters.business.MasDurationType durationType;
	private jkt.hrms.masters.business.MasQualification qualification;
	private jkt.hrms.masters.business.MasCourse course;
	private jkt.hrms.masters.business.MasApplicant applicant;
	private jkt.hrms.masters.business.MasInstitute institute;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.Float getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.Float duration) {
		this.duration = duration;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: grade_percentage
	 */
	public java.lang.Float getGradePercentage () {
		return gradePercentage;
	}

	/**
	 * Set the value related to the column: grade_percentage
	 * @param gradePercentage the grade_percentage value
	 */
	public void setGradePercentage (java.lang.Float gradePercentage) {
		this.gradePercentage = gradePercentage;
	}



	/**
	 * Return the value associated with the column: education_type
	 */
	public java.lang.String getEducationType () {
		return educationType;
	}

	/**
	 * Set the value related to the column: education_type
	 * @param educationType the education_type value
	 */
	public void setEducationType (java.lang.String educationType) {
		this.educationType = educationType;
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
	 * Return the value associated with the column: spl_qualification_id
	 */
	public jkt.hrms.masters.business.MasSplQualification getSplQualification () {
		return splQualification;
	}

	/**
	 * Set the value related to the column: spl_qualification_id
	 * @param splQualification the spl_qualification_id value
	 */
	public void setSplQualification (jkt.hrms.masters.business.MasSplQualification splQualification) {
		this.splQualification = splQualification;
	}



	/**
	 * Return the value associated with the column: duration_type_id
	 */
	public jkt.hrms.masters.business.MasDurationType getDurationType () {
		return durationType;
	}

	/**
	 * Set the value related to the column: duration_type_id
	 * @param durationType the duration_type_id value
	 */
	public void setDurationType (jkt.hrms.masters.business.MasDurationType durationType) {
		this.durationType = durationType;
	}



	/**
	 * Return the value associated with the column: qualification_id
	 */
	public jkt.hrms.masters.business.MasQualification getQualification () {
		return qualification;
	}

	/**
	 * Set the value related to the column: qualification_id
	 * @param qualification the qualification_id value
	 */
	public void setQualification (jkt.hrms.masters.business.MasQualification qualification) {
		this.qualification = qualification;
	}



	/**
	 * Return the value associated with the column: course_id
	 */
	public jkt.hrms.masters.business.MasCourse getCourse () {
		return course;
	}

	/**
	 * Set the value related to the column: course_id
	 * @param course the course_id value
	 */
	public void setCourse (jkt.hrms.masters.business.MasCourse course) {
		this.course = course;
	}



	/**
	 * Return the value associated with the column: applicant_id
	 */
	public jkt.hrms.masters.business.MasApplicant getApplicant () {
		return applicant;
	}

	/**
	 * Set the value related to the column: applicant_id
	 * @param applicant the applicant_id value
	 */
	public void setApplicant (jkt.hrms.masters.business.MasApplicant applicant) {
		this.applicant = applicant;
	}



	/**
	 * Return the value associated with the column: institute_id
	 */
	public jkt.hrms.masters.business.MasInstitute getInstitute () {
		return institute;
	}

	/**
	 * Set the value related to the column: institute_id
	 * @param institute the institute_id value
	 */
	public void setInstitute (jkt.hrms.masters.business.MasInstitute institute) {
		this.institute = institute;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.ApplicantEducation)) return false;
		else {
			jkt.hrms.masters.business.ApplicantEducation applicantEducation = (jkt.hrms.masters.business.ApplicantEducation) obj;
			if (null == this.getId() || null == applicantEducation.getId()) return false;
			else return (this.getId().equals(applicantEducation.getId()));
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