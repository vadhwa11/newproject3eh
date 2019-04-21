package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_performance_review_ratings table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_performance_review_ratings"
 */

public abstract class BaseHrPerformanceReviewRatings implements Serializable {

	public static String REF = "HrPerformanceReviewRatings";
	public static String PROP_RATING_DESC = "RatingDesc";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RATING_CODE = "RatingCode";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseHrPerformanceReviewRatings() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrPerformanceReviewRatings(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrPerformanceReviewRatings(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital company) {

		this.setId(id);
		this.setCompany(company);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ratingCode;
	private java.lang.String ratingDesc;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital company;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> hrEmployeePerformanceReviewsByOverallAssesment;
	private java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> hrEmployeePerformanceReviewsByAssesmentBehaviour;
	private java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> hrEmployeePerformanceReviewsByAssesmentPerformanceGoals;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="rating_id"
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
	 * Return the value associated with the column: rating_code
	 */
	public java.lang.String getRatingCode() {
		return ratingCode;
	}

	/**
	 * Set the value related to the column: rating_code
	 * 
	 * @param ratingCode
	 *            the rating_code value
	 */
	public void setRatingCode(java.lang.String ratingCode) {
		this.ratingCode = ratingCode;
	}

	/**
	 * Return the value associated with the column: rating_desc
	 */
	public java.lang.String getRatingDesc() {
		return ratingDesc;
	}

	/**
	 * Set the value related to the column: rating_desc
	 * 
	 * @param ratingDesc
	 *            the rating_desc value
	 */
	public void setRatingDesc(java.lang.String ratingDesc) {
		this.ratingDesc = ratingDesc;
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
	 * Return the value associated with the column:
	 * HrEmployeePerformanceReviewsByOverallAssesment
	 */
	public java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> getHrEmployeePerformanceReviewsByOverallAssesment() {
		return hrEmployeePerformanceReviewsByOverallAssesment;
	}

	/**
	 * Set the value related to the column:
	 * HrEmployeePerformanceReviewsByOverallAssesment
	 * 
	 * @param hrEmployeePerformanceReviewsByOverallAssesment
	 *            the HrEmployeePerformanceReviewsByOverallAssesment value
	 */
	public void setHrEmployeePerformanceReviewsByOverallAssesment(
			java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> hrEmployeePerformanceReviewsByOverallAssesment) {
		this.hrEmployeePerformanceReviewsByOverallAssesment = hrEmployeePerformanceReviewsByOverallAssesment;
	}

	public void addToHrEmployeePerformanceReviewsByOverallAssesment(
			jkt.hms.masters.business.HrEmployeePerformanceReview hrEmployeePerformanceReview) {
		if (null == getHrEmployeePerformanceReviewsByOverallAssesment()) {
			setHrEmployeePerformanceReviewsByOverallAssesment(new java.util.TreeSet<jkt.hms.masters.business.HrEmployeePerformanceReview>());
		}
		getHrEmployeePerformanceReviewsByOverallAssesment().add(
				hrEmployeePerformanceReview);
	}

	/**
	 * Return the value associated with the column:
	 * HrEmployeePerformanceReviewsByAssesmentBehaviour
	 */
	public java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> getHrEmployeePerformanceReviewsByAssesmentBehaviour() {
		return hrEmployeePerformanceReviewsByAssesmentBehaviour;
	}

	/**
	 * Set the value related to the column:
	 * HrEmployeePerformanceReviewsByAssesmentBehaviour
	 * 
	 * @param hrEmployeePerformanceReviewsByAssesmentBehaviour
	 *            the HrEmployeePerformanceReviewsByAssesmentBehaviour value
	 */
	public void setHrEmployeePerformanceReviewsByAssesmentBehaviour(
			java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> hrEmployeePerformanceReviewsByAssesmentBehaviour) {
		this.hrEmployeePerformanceReviewsByAssesmentBehaviour = hrEmployeePerformanceReviewsByAssesmentBehaviour;
	}

	public void addToHrEmployeePerformanceReviewsByAssesmentBehaviour(
			jkt.hms.masters.business.HrEmployeePerformanceReview hrEmployeePerformanceReview) {
		if (null == getHrEmployeePerformanceReviewsByAssesmentBehaviour()) {
			setHrEmployeePerformanceReviewsByAssesmentBehaviour(new java.util.TreeSet<jkt.hms.masters.business.HrEmployeePerformanceReview>());
		}
		getHrEmployeePerformanceReviewsByAssesmentBehaviour().add(
				hrEmployeePerformanceReview);
	}

	/**
	 * Return the value associated with the column:
	 * HrEmployeePerformanceReviewsByAssesmentPerformanceGoals
	 */
	public java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> getHrEmployeePerformanceReviewsByAssesmentPerformanceGoals() {
		return hrEmployeePerformanceReviewsByAssesmentPerformanceGoals;
	}

	/**
	 * Set the value related to the column:
	 * HrEmployeePerformanceReviewsByAssesmentPerformanceGoals
	 * 
	 * @param hrEmployeePerformanceReviewsByAssesmentPerformanceGoals
	 *            the HrEmployeePerformanceReviewsByAssesmentPerformanceGoals
	 *            value
	 */
	public void setHrEmployeePerformanceReviewsByAssesmentPerformanceGoals(
			java.util.Set<jkt.hms.masters.business.HrEmployeePerformanceReview> hrEmployeePerformanceReviewsByAssesmentPerformanceGoals) {
		this.hrEmployeePerformanceReviewsByAssesmentPerformanceGoals = hrEmployeePerformanceReviewsByAssesmentPerformanceGoals;
	}

	public void addToHrEmployeePerformanceReviewsByAssesmentPerformanceGoals(
			jkt.hms.masters.business.HrEmployeePerformanceReview hrEmployeePerformanceReview) {
		if (null == getHrEmployeePerformanceReviewsByAssesmentPerformanceGoals()) {
			setHrEmployeePerformanceReviewsByAssesmentPerformanceGoals(new java.util.TreeSet<jkt.hms.masters.business.HrEmployeePerformanceReview>());
		}
		getHrEmployeePerformanceReviewsByAssesmentPerformanceGoals().add(
				hrEmployeePerformanceReview);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.HrPerformanceReviewRatings)) {
			return false;
		} else {
			jkt.hms.masters.business.HrPerformanceReviewRatings hrPerformanceReviewRatings = (jkt.hms.masters.business.HrPerformanceReviewRatings) obj;
			if (null == this.getId()
					|| null == hrPerformanceReviewRatings.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrPerformanceReviewRatings.getId()));
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