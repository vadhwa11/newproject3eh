package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the external_lab_report table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="external_lab_report"
 */

public abstract class BaseExternalLabReport  implements Serializable {

	public static String REF = "ExternalLabReport";
	public static String PROP_TEMPLATE_NAME = "TemplateName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TEST_RESULT = "TestResult";
	public static String PROP_TEST_NAME = "TestName";
	public static String PROP_ID = "Id";
	public static String PROP_VISIT = "Visit";
	public static String PROP_VISIT_DATE = "VisitDate";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseExternalLabReport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseExternalLabReport (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String testName;
	private java.lang.String testResult;
	private java.lang.String templateName;
	private java.util.Date visitDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="record_id"
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
	 * Return the value associated with the column: test_name
	 */
	public java.lang.String getTestName () {
		return testName;
	}

	/**
	 * Set the value related to the column: test_name
	 * @param testName the test_name value
	 */
	public void setTestName (java.lang.String testName) {
		this.testName = testName;
	}



	/**
	 * Return the value associated with the column: test_result
	 */
	public java.lang.String getTestResult () {
		return testResult;
	}

	/**
	 * Set the value related to the column: test_result
	 * @param testResult the test_result value
	 */
	public void setTestResult (java.lang.String testResult) {
		this.testResult = testResult;
	}



	/**
	 * Return the value associated with the column: template_name
	 */
	public java.lang.String getTemplateName () {
		return templateName;
	}

	/**
	 * Set the value related to the column: template_name
	 * @param templateName the template_name value
	 */
	public void setTemplateName (java.lang.String templateName) {
		this.templateName = templateName;
	}



	/**
	 * Return the value associated with the column: visit_date
	 */
	public java.util.Date getVisitDate () {
		return visitDate;
	}

	/**
	 * Set the value related to the column: visit_date
	 * @param visitDate the visit_date value
	 */
	public void setVisitDate (java.util.Date visitDate) {
		this.visitDate = visitDate;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ExternalLabReport)) return false;
		else {
			jkt.hms.masters.business.ExternalLabReport externalLabReport = (jkt.hms.masters.business.ExternalLabReport) obj;
			if (null == this.getId() || null == externalLabReport.getId()) return false;
			else return (this.getId().equals(externalLabReport.getId()));
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