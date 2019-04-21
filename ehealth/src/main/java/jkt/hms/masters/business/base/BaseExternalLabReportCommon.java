package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the external_lab_report_common table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="external_lab_report_common"
 */

public abstract class BaseExternalLabReportCommon  implements Serializable {

	public static String REF = "ExternalLabReportCommon";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_TEMPLATE_NAME = "TemplateName";
	public static String PROP_TEST_NAME = "TestName";
	public static String PROP_TEST_RESULT = "TestResult";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TEST_TIME = "TestTime";
	public static String PROP_VISIT = "Visit";
	public static String PROP_OT_PRE_ANESTHESIA_DETAILS = "OtPreAnesthesiaDetails";
	public static String PROP_INVESTIGATION_TYPE = "InvestigationType";
	public static String PROP_TEST_DATE = "TestDate";
	public static String PROP_IN_PATIENT = "InPatient";
	public static String PROP_SUB_INVESTIGATION = "SubInvestigation";
	public static String PROP_ID = "Id";
	public static String PROP_RESULT_STATUS = "ResultStatus";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseExternalLabReportCommon () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseExternalLabReportCommon (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String testName;
	private java.lang.String templateName;
	private java.lang.String testResult;
	private java.util.Date testDate;
	private java.lang.String testTime;
	private java.lang.String resultStatus;
	private java.lang.String investigationType;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OtPreAnesthesiaDetails otPreAnesthesiaDetails;
	private jkt.hms.masters.business.Inpatient inPatient;
	private jkt.hms.masters.business.DgMasInvestigation investigation;
	private jkt.hms.masters.business.DgSubMasInvestigation subInvestigation;



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
	 * Return the value associated with the column: test_date
	 */
	public java.util.Date getTestDate () {
		return testDate;
	}

	/**
	 * Set the value related to the column: test_date
	 * @param testDate the test_date value
	 */
	public void setTestDate (java.util.Date testDate) {
		this.testDate = testDate;
	}



	/**
	 * Return the value associated with the column: test_time
	 */
	public java.lang.String getTestTime () {
		return testTime;
	}

	/**
	 * Set the value related to the column: test_time
	 * @param testTime the test_time value
	 */
	public void setTestTime (java.lang.String testTime) {
		this.testTime = testTime;
	}



	/**
	 * Return the value associated with the column: result_status
	 */
	public java.lang.String getResultStatus () {
		return resultStatus;
	}

	/**
	 * Set the value related to the column: result_status
	 * @param resultStatus the result_status value
	 */
	public void setResultStatus (java.lang.String resultStatus) {
		this.resultStatus = resultStatus;
	}



	/**
	 * Return the value associated with the column: investigation_type
	 */
	public java.lang.String getInvestigationType () {
		return investigationType;
	}

	/**
	 * Set the value related to the column: investigation_type
	 * @param investigationType the investigation_type value
	 */
	public void setInvestigationType (java.lang.String investigationType) {
		this.investigationType = investigationType;
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



	/**
	 * Return the value associated with the column: ot_pre_anesthesia_details_id
	 */
	public jkt.hms.masters.business.OtPreAnesthesiaDetails getOtPreAnesthesiaDetails () {
		return otPreAnesthesiaDetails;
	}

	/**
	 * Set the value related to the column: ot_pre_anesthesia_details_id
	 * @param otPreAnesthesiaDetails the ot_pre_anesthesia_details_id value
	 */
	public void setOtPreAnesthesiaDetails (jkt.hms.masters.business.OtPreAnesthesiaDetails otPreAnesthesiaDetails) {
		this.otPreAnesthesiaDetails = otPreAnesthesiaDetails;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInPatient () {
		return inPatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inPatient the inpatient_id value
	 */
	public void setInPatient (jkt.hms.masters.business.Inpatient inPatient) {
		this.inPatient = inPatient;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigation the investigation_id value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: sub_investigation_id
	 */
	public jkt.hms.masters.business.DgSubMasInvestigation getSubInvestigation () {
		return subInvestigation;
	}

	/**
	 * Set the value related to the column: sub_investigation_id
	 * @param subInvestigation the sub_investigation_id value
	 */
	public void setSubInvestigation (jkt.hms.masters.business.DgSubMasInvestigation subInvestigation) {
		this.subInvestigation = subInvestigation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ExternalLabReportCommon)) return false;
		else {
			jkt.hms.masters.business.ExternalLabReportCommon externalLabReportCommon = (jkt.hms.masters.business.ExternalLabReportCommon) obj;
			if (null == this.getId() || null == externalLabReportCommon.getId()) return false;
			else return (this.getId().equals(externalLabReportCommon.getId()));
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