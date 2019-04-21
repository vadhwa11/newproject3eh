package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_employee_performance_review table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="hr_employee_performance_review"
 */

public abstract class BaseHrEmployeePerformanceReview implements Serializable {

	public static String REF = "HrEmployeePerformanceReview";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_INCREMENT_PERCENTAGE = "IncrementPercentage";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_ASSESMENT_BEHAVIOUR = "AssesmentBehaviour";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PROMOTION = "Promotion";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_YEAR = "Year";
	public static String PROP_ASSESMENT_PERFORMANCE_GOALS = "AssesmentPerformanceGoals";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ID = "Id";
	public static String PROP_OVERALL_ASSESMENT = "OverallAssesment";
	public static String PROP_INCREMENT_AMOUNT = "IncrementAmount";

	// constructors
	public BaseHrEmployeePerformanceReview() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeePerformanceReview(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrEmployeePerformanceReview(
			java.lang.Integer id,
			jkt.hms.masters.business.MasEmployee employee,
			jkt.hms.masters.business.MasHospital company,
			jkt.hms.masters.business.HrPerformanceReviewRatings assesmentBehaviour,
			jkt.hms.masters.business.HrPerformanceReviewRatings assesmentPerformanceGoals,
			jkt.hms.masters.business.HrPerformanceReviewRatings overallAssesment) {

		this.setId(id);
		this.setEmployee(employee);
		this.setCompany(company);
		this.setAssesmentBehaviour(assesmentBehaviour);
		this.setAssesmentPerformanceGoals(assesmentPerformanceGoals);
		this.setOverallAssesment(overallAssesment);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer year;
	private java.lang.Float incrementPercentage;
	private java.lang.Float incrementAmount;
	private java.lang.String promotion;
	private java.lang.String comments;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.HrPerformanceReviewRatings assesmentBehaviour;
	private jkt.hms.masters.business.HrPerformanceReviewRatings assesmentPerformanceGoals;
	private jkt.hms.masters.business.HrPerformanceReviewRatings overallAssesment;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="performance_review_id"
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
	 * Return the value associated with the column: year
	 */
	public java.lang.Integer getYear() {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * 
	 * @param year
	 *            the year value
	 */
	public void setYear(java.lang.Integer year) {
		this.year = year;
	}

	/**
	 * Return the value associated with the column: increment_percentage
	 */
	public java.lang.Float getIncrementPercentage() {
		return incrementPercentage;
	}

	/**
	 * Set the value related to the column: increment_percentage
	 * 
	 * @param incrementPercentage
	 *            the increment_percentage value
	 */
	public void setIncrementPercentage(java.lang.Float incrementPercentage) {
		this.incrementPercentage = incrementPercentage;
	}

	/**
	 * Return the value associated with the column: increment_amount
	 */
	public java.lang.Float getIncrementAmount() {
		return incrementAmount;
	}

	/**
	 * Set the value related to the column: increment_amount
	 * 
	 * @param incrementAmount
	 *            the increment_amount value
	 */
	public void setIncrementAmount(java.lang.Float incrementAmount) {
		this.incrementAmount = incrementAmount;
	}

	/**
	 * Return the value associated with the column: promotion
	 */
	public java.lang.String getPromotion() {
		return promotion;
	}

	/**
	 * Set the value related to the column: promotion
	 * 
	 * @param promotion
	 *            the promotion value
	 */
	public void setPromotion(java.lang.String promotion) {
		this.promotion = promotion;
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
	public java.lang.String getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.lang.String lastChgDate) {
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
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
	 * Return the value associated with the column: assesment_behaviour
	 */
	public jkt.hms.masters.business.HrPerformanceReviewRatings getAssesmentBehaviour() {
		return assesmentBehaviour;
	}

	/**
	 * Set the value related to the column: assesment_behaviour
	 * 
	 * @param assesmentBehaviour
	 *            the assesment_behaviour value
	 */
	public void setAssesmentBehaviour(
			jkt.hms.masters.business.HrPerformanceReviewRatings assesmentBehaviour) {
		this.assesmentBehaviour = assesmentBehaviour;
	}

	/**
	 * Return the value associated with the column: assesment_performance_goals
	 */
	public jkt.hms.masters.business.HrPerformanceReviewRatings getAssesmentPerformanceGoals() {
		return assesmentPerformanceGoals;
	}

	/**
	 * Set the value related to the column: assesment_performance_goals
	 * 
	 * @param assesmentPerformanceGoals
	 *            the assesment_performance_goals value
	 */
	public void setAssesmentPerformanceGoals(
			jkt.hms.masters.business.HrPerformanceReviewRatings assesmentPerformanceGoals) {
		this.assesmentPerformanceGoals = assesmentPerformanceGoals;
	}

	/**
	 * Return the value associated with the column: overall_assesment
	 */
	public jkt.hms.masters.business.HrPerformanceReviewRatings getOverallAssesment() {
		return overallAssesment;
	}

	/**
	 * Set the value related to the column: overall_assesment
	 * 
	 * @param overallAssesment
	 *            the overall_assesment value
	 */
	public void setOverallAssesment(
			jkt.hms.masters.business.HrPerformanceReviewRatings overallAssesment) {
		this.overallAssesment = overallAssesment;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeePerformanceReview)) {
			return false;
		} else {
			jkt.hms.masters.business.HrEmployeePerformanceReview hrEmployeePerformanceReview = (jkt.hms.masters.business.HrEmployeePerformanceReview) obj;
			if (null == this.getId()
					|| null == hrEmployeePerformanceReview.getId()) {
				return false;
			} else {
				return (this.getId()
						.equals(hrEmployeePerformanceReview.getId()));
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