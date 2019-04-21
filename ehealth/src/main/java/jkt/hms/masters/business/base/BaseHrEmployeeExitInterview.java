package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_employee_exit_interview table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_employee_exit_interview"
 */

public abstract class BaseHrEmployeeExitInterview implements Serializable {

	public static String REF = "HrEmployeeExitInterview";
	public static String PROP_ID = "Id";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_DATE_OF_RELIEVING = "DateOfRelieving";

	// constructors
	public BaseHrEmployeeExitInterview() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeeExitInterview(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfRelieving;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrExitInterviewAnswers> answers;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="exit_interview_id"
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
	 * Return the value associated with the column: date_of_relieving
	 */
	public java.util.Date getDateOfRelieving() {
		return dateOfRelieving;
	}

	/**
	 * Set the value related to the column: date_of_relieving
	 * 
	 * @param dateOfRelieving
	 *            the date_of_relieving value
	 */
	public void setDateOfRelieving(java.util.Date dateOfRelieving) {
		this.dateOfRelieving = dateOfRelieving;
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
	 * Return the value associated with the column: Answers
	 */
	public java.util.Set<jkt.hms.masters.business.HrExitInterviewAnswers> getAnswers() {
		return answers;
	}

	/**
	 * Set the value related to the column: Answers
	 * 
	 * @param answers
	 *            the Answers value
	 */
	public void setAnswers(
			java.util.Set<jkt.hms.masters.business.HrExitInterviewAnswers> answers) {
		this.answers = answers;
	}

	public void addToAnswers(
			jkt.hms.masters.business.HrExitInterviewAnswers hrExitInterviewAnswers) {
		if (null == getAnswers()) {
			setAnswers(new java.util.TreeSet<jkt.hms.masters.business.HrExitInterviewAnswers>());
		}
		getAnswers().add(hrExitInterviewAnswers);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeeExitInterview)) {
			return false;
		} else {
			jkt.hms.masters.business.HrEmployeeExitInterview hrEmployeeExitInterview = (jkt.hms.masters.business.HrEmployeeExitInterview) obj;
			if (null == this.getId() || null == hrEmployeeExitInterview.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrEmployeeExitInterview.getId()));
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