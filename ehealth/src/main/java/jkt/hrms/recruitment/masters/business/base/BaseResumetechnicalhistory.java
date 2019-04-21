package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumetechnicalhistory
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumetechnicalhistory"
 */

public abstract class BaseResumetechnicalhistory implements Serializable {

	public static String REF = "Resumetechnicalhistory";
	public static String PROP_STATUS = "Status";
	public static String PROP_MAJOR_WEAKNESS = "MajorWeakness";
	public static String PROP_RELEVANT_EXPERIENCE = "RelevantExperience";
	public static String PROP_REL_EXPERIENCE_YEARS = "RelExperienceYears";
	public static String PROP_DATE_OF_INTERVIEW = "DateOfInterview";
	public static String PROP_DATE = "Date";
	public static String PROP_MAJOR_STRENGTH = "MajorStrength";
	public static String PROP_REASON_HOLD = "ReasonHold";
	public static String PROP_AREA_PROBED = "AreaProbed";
	public static String PROP_INTERVIEWER_NAME = "InterviewerName";
	public static String PROP_RESUMEPERSONALDETAILS = "Resumepersonaldetails";
	public static String PROP_RECOMMENDED = "Recommended";
	public static String PROP_TECHNICAL_KNOWLEDGE = "TechnicalKnowledge";
	public static String PROP_REL_EXPERIENCE_MONTHS = "RelExperienceMonths";
	public static String PROP_RESUME_ID = "ResumeId";
	public static String PROP_ID = "Id";

	// constructors
	public BaseResumetechnicalhistory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumetechnicalhistory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer resumeId;
	private java.lang.String dateOfInterview;
	private java.lang.String technicalKnowledge;
	private java.lang.String relevantExperience;
	private java.lang.Integer relExperienceYears;
	private java.lang.Integer relExperienceMonths;
	private java.lang.String majorStrength;
	private java.lang.String majorWeakness;
	private java.lang.String areaProbed;
	private java.lang.String status;
	private java.lang.String reasonHold;
	private java.lang.String recommended;
	private java.lang.String interviewerName;
	private java.util.Date date;

	// many to one
	private jkt.hrms.recruitment.masters.business.Resumepersonaldetails resumepersonaldetails;

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
	 * Return the value associated with the column: resume_id
	 */
	public java.lang.Integer getResumeId() {
		return resumeId;
	}

	/**
	 * Set the value related to the column: resume_id
	 * 
	 * @param resumeId
	 *            the resume_id value
	 */
	public void setResumeId(java.lang.Integer resumeId) {
		this.resumeId = resumeId;
	}

	/**
	 * Return the value associated with the column: date_of_interview
	 */
	public java.lang.String getDateOfInterview() {
		return dateOfInterview;
	}

	/**
	 * Set the value related to the column: date_of_interview
	 * 
	 * @param dateOfInterview
	 *            the date_of_interview value
	 */
	public void setDateOfInterview(java.lang.String dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}

	/**
	 * Return the value associated with the column: technical_knowledge
	 */
	public java.lang.String getTechnicalKnowledge() {
		return technicalKnowledge;
	}

	/**
	 * Set the value related to the column: technical_knowledge
	 * 
	 * @param technicalKnowledge
	 *            the technical_knowledge value
	 */
	public void setTechnicalKnowledge(java.lang.String technicalKnowledge) {
		this.technicalKnowledge = technicalKnowledge;
	}

	/**
	 * Return the value associated with the column: relevant_experience
	 */
	public java.lang.String getRelevantExperience() {
		return relevantExperience;
	}

	/**
	 * Set the value related to the column: relevant_experience
	 * 
	 * @param relevantExperience
	 *            the relevant_experience value
	 */
	public void setRelevantExperience(java.lang.String relevantExperience) {
		this.relevantExperience = relevantExperience;
	}

	/**
	 * Return the value associated with the column: rel_experience_years
	 */
	public java.lang.Integer getRelExperienceYears() {
		return relExperienceYears;
	}

	/**
	 * Set the value related to the column: rel_experience_years
	 * 
	 * @param relExperienceYears
	 *            the rel_experience_years value
	 */
	public void setRelExperienceYears(java.lang.Integer relExperienceYears) {
		this.relExperienceYears = relExperienceYears;
	}

	/**
	 * Return the value associated with the column: rel_experience_months
	 */
	public java.lang.Integer getRelExperienceMonths() {
		return relExperienceMonths;
	}

	/**
	 * Set the value related to the column: rel_experience_months
	 * 
	 * @param relExperienceMonths
	 *            the rel_experience_months value
	 */
	public void setRelExperienceMonths(java.lang.Integer relExperienceMonths) {
		this.relExperienceMonths = relExperienceMonths;
	}

	/**
	 * Return the value associated with the column: major_strength
	 */
	public java.lang.String getMajorStrength() {
		return majorStrength;
	}

	/**
	 * Set the value related to the column: major_strength
	 * 
	 * @param majorStrength
	 *            the major_strength value
	 */
	public void setMajorStrength(java.lang.String majorStrength) {
		this.majorStrength = majorStrength;
	}

	/**
	 * Return the value associated with the column: major_weakness
	 */
	public java.lang.String getMajorWeakness() {
		return majorWeakness;
	}

	/**
	 * Set the value related to the column: major_weakness
	 * 
	 * @param majorWeakness
	 *            the major_weakness value
	 */
	public void setMajorWeakness(java.lang.String majorWeakness) {
		this.majorWeakness = majorWeakness;
	}

	/**
	 * Return the value associated with the column: area_probed
	 */
	public java.lang.String getAreaProbed() {
		return areaProbed;
	}

	/**
	 * Set the value related to the column: area_probed
	 * 
	 * @param areaProbed
	 *            the area_probed value
	 */
	public void setAreaProbed(java.lang.String areaProbed) {
		this.areaProbed = areaProbed;
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
	 * Return the value associated with the column: reason_hold
	 */
	public java.lang.String getReasonHold() {
		return reasonHold;
	}

	/**
	 * Set the value related to the column: reason_hold
	 * 
	 * @param reasonHold
	 *            the reason_hold value
	 */
	public void setReasonHold(java.lang.String reasonHold) {
		this.reasonHold = reasonHold;
	}

	/**
	 * Return the value associated with the column: recommended
	 */
	public java.lang.String getRecommended() {
		return recommended;
	}

	/**
	 * Set the value related to the column: recommended
	 * 
	 * @param recommended
	 *            the recommended value
	 */
	public void setRecommended(java.lang.String recommended) {
		this.recommended = recommended;
	}

	/**
	 * Return the value associated with the column: interviewer_name
	 */
	public java.lang.String getInterviewerName() {
		return interviewerName;
	}

	/**
	 * Set the value related to the column: interviewer_name
	 * 
	 * @param interviewerName
	 *            the interviewer_name value
	 */
	public void setInterviewerName(java.lang.String interviewerName) {
		this.interviewerName = interviewerName;
	}

	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: resume_id
	 */
	public jkt.hrms.recruitment.masters.business.Resumepersonaldetails getResumepersonaldetails() {
		return resumepersonaldetails;
	}

	/**
	 * Set the value related to the column: resume_id
	 * 
	 * @param resumepersonaldetails
	 *            the resume_id value
	 */
	public void setResumepersonaldetails(
			jkt.hrms.recruitment.masters.business.Resumepersonaldetails resumepersonaldetails) {
		this.resumepersonaldetails = resumepersonaldetails;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumetechnicalhistory)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumetechnicalhistory resumetechnicalhistory = (jkt.hrms.recruitment.masters.business.Resumetechnicalhistory) obj;
			if (null == this.getId() || null == resumetechnicalhistory.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumetechnicalhistory.getId()));
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