package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_application_level table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_application_level"
 */

public abstract class BaseHrMasApplicationLevel  implements Serializable {

	public static String REF = "HrMasApplicationLevel";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CC_LIST = "CcList";
	public static String PROP_ID = "Id";
	public static String PROP_APPROVING_LEVEL = "ApprovingLevel";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INTERMEDIATE_APPROVER_DESIGNATION = "IntermediateApproverDesignation";
	public static String PROP_FINAL_APPROVER_DESIGNATION = "FinalApproverDesignation";
	public static String PROP_APPLICATION_ID = "ApplicationId";


	// constructors
	public BaseHrMasApplicationLevel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasApplicationLevel (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrMasApplicationLevel (
		java.lang.Integer id,
		java.lang.String applicationId) {

		this.setId(id);
		this.setApplicationId(applicationId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String applicationId;
	private java.lang.Long approvingLevel;
	private java.lang.String ccList;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasRank intermediateApproverDesignation;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasRank finalApproverDesignation;



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
	 * Return the value associated with the column: application_id
	 */
	public java.lang.String getApplicationId () {
		return applicationId;
	}

	/**
	 * Set the value related to the column: application_id
	 * @param applicationId the application_id value
	 */
	public void setApplicationId (java.lang.String applicationId) {
		this.applicationId = applicationId;
	}



	/**
	 * Return the value associated with the column: approving_level
	 */
	public java.lang.Long getApprovingLevel () {
		return approvingLevel;
	}

	/**
	 * Set the value related to the column: approving_level
	 * @param approvingLevel the approving_level value
	 */
	public void setApprovingLevel (java.lang.Long approvingLevel) {
		this.approvingLevel = approvingLevel;
	}



	/**
	 * Return the value associated with the column: cc_list
	 */
	public java.lang.String getCcList () {
		return ccList;
	}

	/**
	 * Set the value related to the column: cc_list
	 * @param ccList the cc_list value
	 */
	public void setCcList (java.lang.String ccList) {
		this.ccList = ccList;
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
	 * Return the value associated with the column: intermediate_approver_designation_id
	 */
	public jkt.hms.masters.business.MasRank getIntermediateApproverDesignation () {
		return intermediateApproverDesignation;
	}

	/**
	 * Set the value related to the column: intermediate_approver_designation_id
	 * @param intermediateApproverDesignation the intermediate_approver_designation_id value
	 */
	public void setIntermediateApproverDesignation (jkt.hms.masters.business.MasRank intermediateApproverDesignation) {
		this.intermediateApproverDesignation = intermediateApproverDesignation;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: final_approver_designation_id
	 */
	public jkt.hms.masters.business.MasRank getFinalApproverDesignation () {
		return finalApproverDesignation;
	}

	/**
	 * Set the value related to the column: final_approver_designation_id
	 * @param finalApproverDesignation the final_approver_designation_id value
	 */
	public void setFinalApproverDesignation (jkt.hms.masters.business.MasRank finalApproverDesignation) {
		this.finalApproverDesignation = finalApproverDesignation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrMasApplicationLevel)) return false;
		else {
			jkt.hrms.masters.business.HrMasApplicationLevel hrMasApplicationLevel = (jkt.hrms.masters.business.HrMasApplicationLevel) obj;
			if (null == this.getId() || null == hrMasApplicationLevel.getId()) return false;
			else return (this.getId().equals(hrMasApplicationLevel.getId()));
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