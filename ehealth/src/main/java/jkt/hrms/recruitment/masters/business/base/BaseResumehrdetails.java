package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resumehrdetails table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_resumehrdetails"
 */

public abstract class BaseResumehrdetails implements Serializable {

	public static String REF = "Resumehrdetails";
	public static String PROP_APPROVAL_DIRECTOR = "ApprovalDirector";
	public static String PROP_FAMILY_DETAILS = "FamilyDetails";
	public static String PROP_MARITAL_STATUS = "MaritalStatus";
	public static String PROP_DATE = "Date";
	public static String PROP_INTERVIEWER_NAME = "InterviewerName";
	public static String PROP_RESUMEPERSONALDETAILS = "Resumepersonaldetails";
	public static String PROP_RECOMMENDED = "Recommended";
	public static String PROP_REPORTING_STRUCTURE = "ReportingStructure";
	public static String PROP_LOCATION_PREFERENCE = "LocationPreference";
	public static String PROP_REASON_TO_LEAVE = "ReasonToLeave";
	public static String PROP_HR_RATINGS = "HrRatings";
	public static String PROP_RESUME_ID = "ResumeId";
	public static String PROP_ID = "Id";
	public static String PROP_OVERALL_ASSESMENT = "OverallAssesment";

	// constructors
	public BaseResumehrdetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResumehrdetails(java.lang.Integer id) {
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
	private java.lang.String maritalStatus;
	private java.lang.String locationPreference;
	private java.lang.String familyDetails;
	private java.lang.String reportingStructure;
	private java.lang.String reasonToLeave;
	private java.lang.String hrRatings;
	private java.lang.String overallAssesment;
	private java.lang.String recommended;
	private java.lang.String interviewerName;
	private java.lang.String approvalDirector;
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
	 * Return the value associated with the column: marital_status
	 */
	public java.lang.String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * Set the value related to the column: marital_status
	 * 
	 * @param maritalStatus
	 *            the marital_status value
	 */
	public void setMaritalStatus(java.lang.String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * Return the value associated with the column: location_preference
	 */
	public java.lang.String getLocationPreference() {
		return locationPreference;
	}

	/**
	 * Set the value related to the column: location_preference
	 * 
	 * @param locationPreference
	 *            the location_preference value
	 */
	public void setLocationPreference(java.lang.String locationPreference) {
		this.locationPreference = locationPreference;
	}

	/**
	 * Return the value associated with the column: family_details
	 */
	public java.lang.String getFamilyDetails() {
		return familyDetails;
	}

	/**
	 * Set the value related to the column: family_details
	 * 
	 * @param familyDetails
	 *            the family_details value
	 */
	public void setFamilyDetails(java.lang.String familyDetails) {
		this.familyDetails = familyDetails;
	}

	/**
	 * Return the value associated with the column: reporting_structure
	 */
	public java.lang.String getReportingStructure() {
		return reportingStructure;
	}

	/**
	 * Set the value related to the column: reporting_structure
	 * 
	 * @param reportingStructure
	 *            the reporting_structure value
	 */
	public void setReportingStructure(java.lang.String reportingStructure) {
		this.reportingStructure = reportingStructure;
	}

	/**
	 * Return the value associated with the column: reason_to_leave
	 */
	public java.lang.String getReasonToLeave() {
		return reasonToLeave;
	}

	/**
	 * Set the value related to the column: reason_to_leave
	 * 
	 * @param reasonToLeave
	 *            the reason_to_leave value
	 */
	public void setReasonToLeave(java.lang.String reasonToLeave) {
		this.reasonToLeave = reasonToLeave;
	}

	/**
	 * Return the value associated with the column: hr_ratings
	 */
	public java.lang.String getHrRatings() {
		return hrRatings;
	}

	/**
	 * Set the value related to the column: hr_ratings
	 * 
	 * @param hrRatings
	 *            the hr_ratings value
	 */
	public void setHrRatings(java.lang.String hrRatings) {
		this.hrRatings = hrRatings;
	}

	/**
	 * Return the value associated with the column: overall_assesment
	 */
	public java.lang.String getOverallAssesment() {
		return overallAssesment;
	}

	/**
	 * Set the value related to the column: overall_assesment
	 * 
	 * @param overallAssesment
	 *            the overall_assesment value
	 */
	public void setOverallAssesment(java.lang.String overallAssesment) {
		this.overallAssesment = overallAssesment;
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
	 * Return the value associated with the column: approval_director
	 */
	public java.lang.String getApprovalDirector() {
		return approvalDirector;
	}

	/**
	 * Set the value related to the column: approval_director
	 * 
	 * @param approvalDirector
	 *            the approval_director value
	 */
	public void setApprovalDirector(java.lang.String approvalDirector) {
		this.approvalDirector = approvalDirector;
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
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.Resumehrdetails)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.Resumehrdetails resumehrdetails = (jkt.hrms.recruitment.masters.business.Resumehrdetails) obj;
			if (null == this.getId() || null == resumehrdetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(resumehrdetails.getId()));
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