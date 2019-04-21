package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_training_effective table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_training_effective"
 */

public abstract class BaseHrTrainingEffective  implements Serializable {

	public static String REF = "HrTrainingEffective";
	public static String PROP_AVERAGE_POINTS = "AveragePoints";
	public static String PROP_REVIEW_D = "ReviewD";
	public static String PROP_REVIEW_B = "ReviewB";
	public static String PROP_HELD_ON_DATE = "HeldOnDate";
	public static String PROP_REVIEW_C = "ReviewC";
	public static String PROP_REVIEW_A = "ReviewA";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COURSE_EXPLAINB = "CourseExplainb";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_INSTRUCTOR = "Instructor";
	public static String PROP_COURSE_EXPLAINA = "CourseExplaina";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_EVALUATION_DATE = "EvaluationDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_COURSE = "Course";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COURSE_MATERIAL = "CourseMaterial";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INSTITUTE = "Institute";


	// constructors
	public BaseHrTrainingEffective () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTrainingEffective (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date evaluationDate;
	private java.util.Date heldOnDate;
	private java.lang.String courseExplaina;
	private java.lang.String courseExplainb;
	private java.lang.String courseMaterial;
	private java.lang.Integer reviewA;
	private java.lang.Integer reviewB;
	private java.lang.Integer reviewC;
	private java.lang.Integer reviewD;
	private java.lang.Integer averagePoints;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hrms.masters.business.HrMasInstructor instructor;
	private jkt.hrms.masters.business.HrMasCourse course;
	private jkt.hrms.masters.business.HrMasInstitute institute;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="trainig_effective_id"
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
	 * Return the value associated with the column: evaluation_date
	 */
	public java.util.Date getEvaluationDate () {
		return evaluationDate;
	}

	/**
	 * Set the value related to the column: evaluation_date
	 * @param evaluationDate the evaluation_date value
	 */
	public void setEvaluationDate (java.util.Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}



	/**
	 * Return the value associated with the column: held_on_date
	 */
	public java.util.Date getHeldOnDate () {
		return heldOnDate;
	}

	/**
	 * Set the value related to the column: held_on_date
	 * @param heldOnDate the held_on_date value
	 */
	public void setHeldOnDate (java.util.Date heldOnDate) {
		this.heldOnDate = heldOnDate;
	}



	/**
	 * Return the value associated with the column: course_explainA
	 */
	public java.lang.String getCourseExplaina () {
		return courseExplaina;
	}

	/**
	 * Set the value related to the column: course_explainA
	 * @param courseExplaina the course_explainA value
	 */
	public void setCourseExplaina (java.lang.String courseExplaina) {
		this.courseExplaina = courseExplaina;
	}



	/**
	 * Return the value associated with the column: course_explainB
	 */
	public java.lang.String getCourseExplainb () {
		return courseExplainb;
	}

	/**
	 * Set the value related to the column: course_explainB
	 * @param courseExplainb the course_explainB value
	 */
	public void setCourseExplainb (java.lang.String courseExplainb) {
		this.courseExplainb = courseExplainb;
	}



	/**
	 * Return the value associated with the column: course_material
	 */
	public java.lang.String getCourseMaterial () {
		return courseMaterial;
	}

	/**
	 * Set the value related to the column: course_material
	 * @param courseMaterial the course_material value
	 */
	public void setCourseMaterial (java.lang.String courseMaterial) {
		this.courseMaterial = courseMaterial;
	}



	/**
	 * Return the value associated with the column: reviewA
	 */
	public java.lang.Integer getReviewA () {
		return reviewA;
	}

	/**
	 * Set the value related to the column: reviewA
	 * @param reviewA the reviewA value
	 */
	public void setReviewA (java.lang.Integer reviewA) {
		this.reviewA = reviewA;
	}



	/**
	 * Return the value associated with the column: reviewB
	 */
	public java.lang.Integer getReviewB () {
		return reviewB;
	}

	/**
	 * Set the value related to the column: reviewB
	 * @param reviewB the reviewB value
	 */
	public void setReviewB (java.lang.Integer reviewB) {
		this.reviewB = reviewB;
	}



	/**
	 * Return the value associated with the column: reviewC
	 */
	public java.lang.Integer getReviewC () {
		return reviewC;
	}

	/**
	 * Set the value related to the column: reviewC
	 * @param reviewC the reviewC value
	 */
	public void setReviewC (java.lang.Integer reviewC) {
		this.reviewC = reviewC;
	}



	/**
	 * Return the value associated with the column: reviewD
	 */
	public java.lang.Integer getReviewD () {
		return reviewD;
	}

	/**
	 * Set the value related to the column: reviewD
	 * @param reviewD the reviewD value
	 */
	public void setReviewD (java.lang.Integer reviewD) {
		this.reviewD = reviewD;
	}



	/**
	 * Return the value associated with the column: average_points
	 */
	public java.lang.Integer getAveragePoints () {
		return averagePoints;
	}

	/**
	 * Set the value related to the column: average_points
	 * @param averagePoints the average_points value
	 */
	public void setAveragePoints (java.lang.Integer averagePoints) {
		this.averagePoints = averagePoints;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: instructor_id
	 */
	public jkt.hrms.masters.business.HrMasInstructor getInstructor () {
		return instructor;
	}

	/**
	 * Set the value related to the column: instructor_id
	 * @param instructor the instructor_id value
	 */
	public void setInstructor (jkt.hrms.masters.business.HrMasInstructor instructor) {
		this.instructor = instructor;
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
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrTrainingEffective)) return false;
		else {
			jkt.hrms.masters.business.HrTrainingEffective hrTrainingEffective = (jkt.hrms.masters.business.HrTrainingEffective) obj;
			if (null == this.getId() || null == hrTrainingEffective.getId()) return false;
			else return (this.getId().equals(hrTrainingEffective.getId()));
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