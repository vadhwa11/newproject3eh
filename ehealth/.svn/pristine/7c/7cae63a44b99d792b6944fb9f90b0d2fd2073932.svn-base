package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_employee_contract table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_employee_contract"
 */

public abstract class BaseMasEmployeeContract  implements Serializable {

	public static String REF = "MasEmployeeContract";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AGREEMENT_REMARK = "AgreementRemark";
	public static String PROP_DOCUMENTS_SUBMITTED = "DocumentsSubmitted";
	public static String PROP_AGREEMENT_TYPE = "AgreementType";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_AGREEMENT_START_DATE = "AgreementStartDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CON_SALARY = "ConSalary";
	public static String PROP_ID = "Id";
	public static String PROP_AGREEMENT_END_DATE = "AgreementEndDate";
	public static String PROP_AGREEMENT_RULES = "AgreementRules";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_AGENCY = "Agency";


	// constructors
	public BaseMasEmployeeContract () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmployeeContract (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasEmployeeContract (
		java.lang.Integer id,
		jkt.hms.masters.business.MasEmployee employee) {

		this.setId(id);
		this.setEmployee(employee);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String agency;
	private java.lang.String category;
	private java.lang.String agreementType;
	private java.util.Date agreementStartDate;
	private java.util.Date agreementEndDate;
	private java.lang.String agreementRemark;
	private java.lang.String documentsSubmitted;
	private java.lang.String agreementRules;
	private java.lang.String status;
	private int conSalary;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="employee_contract_id"
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
	 * Return the value associated with the column: agency
	 */
	public java.lang.String getAgency () {
		return agency;
	}

	/**
	 * Set the value related to the column: agency
	 * @param agency the agency value
	 */
	public void setAgency (java.lang.String agency) {
		this.agency = agency;
	}



	/**
	 * Return the value associated with the column: category
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: agreement_type
	 */
	public java.lang.String getAgreementType () {
		return agreementType;
	}

	/**
	 * Set the value related to the column: agreement_type
	 * @param agreementType the agreement_type value
	 */
	public void setAgreementType (java.lang.String agreementType) {
		this.agreementType = agreementType;
	}



	/**
	 * Return the value associated with the column: agreement_start_date
	 */
	public java.util.Date getAgreementStartDate () {
		return agreementStartDate;
	}

	/**
	 * Set the value related to the column: agreement_start_date
	 * @param agreementStartDate the agreement_start_date value
	 */
	public void setAgreementStartDate (java.util.Date agreementStartDate) {
		this.agreementStartDate = agreementStartDate;
	}



	/**
	 * Return the value associated with the column: agreement_end_date
	 */
	public java.util.Date getAgreementEndDate () {
		return agreementEndDate;
	}

	/**
	 * Set the value related to the column: agreement_end_date
	 * @param agreementEndDate the agreement_end_date value
	 */
	public void setAgreementEndDate (java.util.Date agreementEndDate) {
		this.agreementEndDate = agreementEndDate;
	}



	/**
	 * Return the value associated with the column: agreement_remark
	 */
	public java.lang.String getAgreementRemark () {
		return agreementRemark;
	}

	/**
	 * Set the value related to the column: agreement_remark
	 * @param agreementRemark the agreement_remark value
	 */
	public void setAgreementRemark (java.lang.String agreementRemark) {
		this.agreementRemark = agreementRemark;
	}



	/**
	 * Return the value associated with the column: documents_submitted
	 */
	public java.lang.String getDocumentsSubmitted () {
		return documentsSubmitted;
	}

	/**
	 * Set the value related to the column: documents_submitted
	 * @param documentsSubmitted the documents_submitted value
	 */
	public void setDocumentsSubmitted (java.lang.String documentsSubmitted) {
		this.documentsSubmitted = documentsSubmitted;
	}



	/**
	 * Return the value associated with the column: agreement_rules
	 */
	public java.lang.String getAgreementRules () {
		return agreementRules;
	}

	/**
	 * Set the value related to the column: agreement_rules
	 * @param agreementRules the agreement_rules value
	 */
	public void setAgreementRules (java.lang.String agreementRules) {
		this.agreementRules = agreementRules;
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
	 * Return the value associated with the column: consolidated_salary
	 */
	public int getConSalary () {
		return conSalary;
	}

	/**
	 * Set the value related to the column: consolidated_salary
	 * @param conSalary the consolidated_salary value
	 */
	public void setConSalary (int conSalary) {
		this.conSalary = conSalary;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MasEmployeeContract)) return false;
		else {
			jkt.hrms.masters.business.MasEmployeeContract masEmployeeContract = (jkt.hrms.masters.business.MasEmployeeContract) obj;
			if (null == this.getId() || null == masEmployeeContract.getId()) return false;
			else return (this.getId().equals(masEmployeeContract.getId()));
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