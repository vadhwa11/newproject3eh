package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_resource_requisition table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_resource_requisition"
 */

public abstract class BaseResourceRequisition  implements Serializable {

	public static String REF = "ResourceRequisition";
	public static String PROP_TOTAL_NO_POSITION = "TotalNoPosition";
	public static String PROP_QUALIFICATION = "Qualification";
	public static String PROP_EMPLOYEE_TYPE = "EmployeeType";
	public static String PROP_JOB_DESC = "JobDesc";
	public static String PROP_REQUISITION_DATE = "RequisitionDate";
	public static String PROP_INFRAST_REQUIRMENT = "InfrastRequirment";
	public static String PROP_PROPOSED_DESIGNATION = "ProposedDesignation";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REQUIRED_SKILL = "RequiredSkill";
	public static String PROP_MARKET_CTC = "MarketCtc";
	public static String PROP_C_T_C_ANALYSED_BY = "CTCAnalysedBy";
	public static String PROP_AGE_LIMIT = "AgeLimit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REQ_ADD_BY = "ReqAddBy";
	public static String PROP_REP_MANAGER = "RepManager";
	public static String PROP_VACANCY_REASON = "VacancyReason";
	public static String PROP_POSITION_PURPOSE = "PositionPurpose";
	public static String PROP_POST_AVAIL = "PostAvail";
	public static String PROP_EXP_LOWER_RANGE = "ExpLowerRange";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_HR_RESOURCE_REQUISITION_STATUS = "HrResourceRequisitionStatus";
	public static String PROP_INITIATOR = "Initiator";
	public static String PROP_NO_OF_POSITION_OCCUPIED = "NoOfPositionOccupied";
	public static String PROP_SALARY_LOWER_RANGE = "SalaryLowerRange";
	public static String PROP_EXP_UPPER_RANGE = "ExpUpperRange";
	public static String PROP_LOCATION = "Location";
	public static String PROP_APPROVING_MANAGER = "ApprovingManager";
	public static String PROP_STATUS = "Status";
	public static String PROP_DESIRABLE_QLF = "DesirableQlf";
	public static String PROP_ID = "Id";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_SALARY_UPPER_RANGE = "SalaryUpperRange";


	// constructors
	public BaseResourceRequisition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseResourceRequisition (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date requisitionDate;
	private java.lang.String proposedDesignation;
	private java.lang.Integer totalNoPosition;
	private java.lang.Integer noOfPositionOccupied;
	private java.lang.Integer ageLimit;
	private java.lang.String positionPurpose;
	private java.lang.String jobDesc;
	private java.lang.String requiredSkill;
	private java.lang.Integer expLowerRange;
	private java.lang.Integer expUpperRange;
	private java.lang.Integer salaryLowerRange;
	private java.lang.Integer marketCtc;
	private java.lang.Integer salaryUpperRange;
	private java.lang.String infrastRequirment;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer postAvail;

	// one to one
	private jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus;

	// many to one
	private jkt.hms.masters.business.MasRank designation;
	private jkt.hms.masters.business.MasEmployee initiator;
	private jkt.hms.masters.business.MasEmployee approvingManager;
	private jkt.hrms.masters.business.MasQualification desirableQlf;
	private jkt.hrms.masters.business.MasVacancyReason vacancyReason;
	private jkt.hms.masters.business.MasEmployeeDepartment department;
	private jkt.hrms.masters.business.MasQualification qualification;
	private jkt.hms.masters.business.MasEmployee repManager;
	private jkt.hms.masters.business.MasEmployee reqAddBy;
	private jkt.hrms.masters.business.MasEmployeeType employeeType;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.MasLocation location;
	private jkt.hms.masters.business.MasEmployee cTCAnalysedBy;

	// collections
	private java.util.Set<jkt.hrms.recruitment.masters.business.HrRequisitionHistory> requisitionHistory;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="requisition_id"
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
	 * Return the value associated with the column: requisition_date
	 */
	public java.util.Date getRequisitionDate () {
		return requisitionDate;
	}

	/**
	 * Set the value related to the column: requisition_date
	 * @param requisitionDate the requisition_date value
	 */
	public void setRequisitionDate (java.util.Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}



	/**
	 * Return the value associated with the column: proposed_designation
	 */
	public java.lang.String getProposedDesignation () {
		return proposedDesignation;
	}

	/**
	 * Set the value related to the column: proposed_designation
	 * @param proposedDesignation the proposed_designation value
	 */
	public void setProposedDesignation (java.lang.String proposedDesignation) {
		this.proposedDesignation = proposedDesignation;
	}



	/**
	 * Return the value associated with the column: total_no_position
	 */
	public java.lang.Integer getTotalNoPosition () {
		return totalNoPosition;
	}

	/**
	 * Set the value related to the column: total_no_position
	 * @param totalNoPosition the total_no_position value
	 */
	public void setTotalNoPosition (java.lang.Integer totalNoPosition) {
		this.totalNoPosition = totalNoPosition;
	}



	/**
	 * Return the value associated with the column: no_of_position_occupied
	 */
	public java.lang.Integer getNoOfPositionOccupied () {
		return noOfPositionOccupied;
	}

	/**
	 * Set the value related to the column: no_of_position_occupied
	 * @param noOfPositionOccupied the no_of_position_occupied value
	 */
	public void setNoOfPositionOccupied (java.lang.Integer noOfPositionOccupied) {
		this.noOfPositionOccupied = noOfPositionOccupied;
	}



	/**
	 * Return the value associated with the column: age_limit
	 */
	public java.lang.Integer getAgeLimit () {
		return ageLimit;
	}

	/**
	 * Set the value related to the column: age_limit
	 * @param ageLimit the age_limit value
	 */
	public void setAgeLimit (java.lang.Integer ageLimit) {
		this.ageLimit = ageLimit;
	}



	/**
	 * Return the value associated with the column: position_purpose
	 */
	public java.lang.String getPositionPurpose () {
		return positionPurpose;
	}

	/**
	 * Set the value related to the column: position_purpose
	 * @param positionPurpose the position_purpose value
	 */
	public void setPositionPurpose (java.lang.String positionPurpose) {
		this.positionPurpose = positionPurpose;
	}



	/**
	 * Return the value associated with the column: job_desc
	 */
	public java.lang.String getJobDesc () {
		return jobDesc;
	}

	/**
	 * Set the value related to the column: job_desc
	 * @param jobDesc the job_desc value
	 */
	public void setJobDesc (java.lang.String jobDesc) {
		this.jobDesc = jobDesc;
	}



	/**
	 * Return the value associated with the column: required_skill
	 */
	public java.lang.String getRequiredSkill () {
		return requiredSkill;
	}

	/**
	 * Set the value related to the column: required_skill
	 * @param requiredSkill the required_skill value
	 */
	public void setRequiredSkill (java.lang.String requiredSkill) {
		this.requiredSkill = requiredSkill;
	}



	/**
	 * Return the value associated with the column: exp_lower_range
	 */
	public java.lang.Integer getExpLowerRange () {
		return expLowerRange;
	}

	/**
	 * Set the value related to the column: exp_lower_range
	 * @param expLowerRange the exp_lower_range value
	 */
	public void setExpLowerRange (java.lang.Integer expLowerRange) {
		this.expLowerRange = expLowerRange;
	}



	/**
	 * Return the value associated with the column: exp_upper_range
	 */
	public java.lang.Integer getExpUpperRange () {
		return expUpperRange;
	}

	/**
	 * Set the value related to the column: exp_upper_range
	 * @param expUpperRange the exp_upper_range value
	 */
	public void setExpUpperRange (java.lang.Integer expUpperRange) {
		this.expUpperRange = expUpperRange;
	}



	/**
	 * Return the value associated with the column: salary_lower_range
	 */
	public java.lang.Integer getSalaryLowerRange () {
		return salaryLowerRange;
	}

	/**
	 * Set the value related to the column: salary_lower_range
	 * @param salaryLowerRange the salary_lower_range value
	 */
	public void setSalaryLowerRange (java.lang.Integer salaryLowerRange) {
		this.salaryLowerRange = salaryLowerRange;
	}



	/**
	 * Return the value associated with the column: market_ctc
	 */
	public java.lang.Integer getMarketCtc () {
		return marketCtc;
	}

	/**
	 * Set the value related to the column: market_ctc
	 * @param marketCtc the market_ctc value
	 */
	public void setMarketCtc (java.lang.Integer marketCtc) {
		this.marketCtc = marketCtc;
	}



	/**
	 * Return the value associated with the column: salary_upper_range
	 */
	public java.lang.Integer getSalaryUpperRange () {
		return salaryUpperRange;
	}

	/**
	 * Set the value related to the column: salary_upper_range
	 * @param salaryUpperRange the salary_upper_range value
	 */
	public void setSalaryUpperRange (java.lang.Integer salaryUpperRange) {
		this.salaryUpperRange = salaryUpperRange;
	}



	/**
	 * Return the value associated with the column: infrastructure_requirement
	 */
	public java.lang.String getInfrastRequirment () {
		return infrastRequirment;
	}

	/**
	 * Set the value related to the column: infrastructure_requirement
	 * @param infrastRequirment the infrastructure_requirement value
	 */
	public void setInfrastRequirment (java.lang.String infrastRequirment) {
		this.infrastRequirment = infrastRequirment;
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
	 * Return the value associated with the column: post_avail
	 */
	public java.lang.Integer getPostAvail () {
		return postAvail;
	}

	/**
	 * Set the value related to the column: post_avail
	 * @param postAvail the post_avail value
	 */
	public void setPostAvail (java.lang.Integer postAvail) {
		this.postAvail = postAvail;
	}



	/**
	 * Return the value associated with the column: HrResourceRequisitionStatus
	 */
	public jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus getHrResourceRequisitionStatus () {
		return hrResourceRequisitionStatus;
	}

	/**
	 * Set the value related to the column: HrResourceRequisitionStatus
	 * @param hrResourceRequisitionStatus the HrResourceRequisitionStatus value
	 */
	public void setHrResourceRequisitionStatus (jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus hrResourceRequisitionStatus) {
		this.hrResourceRequisitionStatus = hrResourceRequisitionStatus;
	}



	/**
	 * Return the value associated with the column: designation_id
	 */
	public jkt.hms.masters.business.MasRank getDesignation () {
		return designation;
	}

	/**
	 * Set the value related to the column: designation_id
	 * @param designation the designation_id value
	 */
	public void setDesignation (jkt.hms.masters.business.MasRank designation) {
		this.designation = designation;
	}



	/**
	 * Return the value associated with the column: initiator_id
	 */
	public jkt.hms.masters.business.MasEmployee getInitiator () {
		return initiator;
	}

	/**
	 * Set the value related to the column: initiator_id
	 * @param initiator the initiator_id value
	 */
	public void setInitiator (jkt.hms.masters.business.MasEmployee initiator) {
		this.initiator = initiator;
	}



	/**
	 * Return the value associated with the column: approving_manager_id
	 */
	public jkt.hms.masters.business.MasEmployee getApprovingManager () {
		return approvingManager;
	}

	/**
	 * Set the value related to the column: approving_manager_id
	 * @param approvingManager the approving_manager_id value
	 */
	public void setApprovingManager (jkt.hms.masters.business.MasEmployee approvingManager) {
		this.approvingManager = approvingManager;
	}



	/**
	 * Return the value associated with the column: desirable_qlf_id
	 */
	public jkt.hrms.masters.business.MasQualification getDesirableQlf () {
		return desirableQlf;
	}

	/**
	 * Set the value related to the column: desirable_qlf_id
	 * @param desirableQlf the desirable_qlf_id value
	 */
	public void setDesirableQlf (jkt.hrms.masters.business.MasQualification desirableQlf) {
		this.desirableQlf = desirableQlf;
	}



	/**
	 * Return the value associated with the column: vacancy_reason_id
	 */
	public jkt.hrms.masters.business.MasVacancyReason getVacancyReason () {
		return vacancyReason;
	}

	/**
	 * Set the value related to the column: vacancy_reason_id
	 * @param vacancyReason the vacancy_reason_id value
	 */
	public void setVacancyReason (jkt.hrms.masters.business.MasVacancyReason vacancyReason) {
		this.vacancyReason = vacancyReason;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasEmployeeDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasEmployeeDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: qualification_id
	 */
	public jkt.hrms.masters.business.MasQualification getQualification () {
		return qualification;
	}

	/**
	 * Set the value related to the column: qualification_id
	 * @param qualification the qualification_id value
	 */
	public void setQualification (jkt.hrms.masters.business.MasQualification qualification) {
		this.qualification = qualification;
	}



	/**
	 * Return the value associated with the column: rep_manager_id
	 */
	public jkt.hms.masters.business.MasEmployee getRepManager () {
		return repManager;
	}

	/**
	 * Set the value related to the column: rep_manager_id
	 * @param repManager the rep_manager_id value
	 */
	public void setRepManager (jkt.hms.masters.business.MasEmployee repManager) {
		this.repManager = repManager;
	}



	/**
	 * Return the value associated with the column: req_add_by
	 */
	public jkt.hms.masters.business.MasEmployee getReqAddBy () {
		return reqAddBy;
	}

	/**
	 * Set the value related to the column: req_add_by
	 * @param reqAddBy the req_add_by value
	 */
	public void setReqAddBy (jkt.hms.masters.business.MasEmployee reqAddBy) {
		this.reqAddBy = reqAddBy;
	}



	/**
	 * Return the value associated with the column: employee_type_id
	 */
	public jkt.hrms.masters.business.MasEmployeeType getEmployeeType () {
		return employeeType;
	}

	/**
	 * Set the value related to the column: employee_type_id
	 * @param employeeType the employee_type_id value
	 */
	public void setEmployeeType (jkt.hrms.masters.business.MasEmployeeType employeeType) {
		this.employeeType = employeeType;
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
	 * Return the value associated with the column: location_id
	 */
	public jkt.hrms.masters.business.MasLocation getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location_id
	 * @param location the location_id value
	 */
	public void setLocation (jkt.hrms.masters.business.MasLocation location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: ctc_analysed_by_id
	 */
	public jkt.hms.masters.business.MasEmployee getCTCAnalysedBy () {
		return cTCAnalysedBy;
	}

	/**
	 * Set the value related to the column: ctc_analysed_by_id
	 * @param cTCAnalysedBy the ctc_analysed_by_id value
	 */
	public void setCTCAnalysedBy (jkt.hms.masters.business.MasEmployee cTCAnalysedBy) {
		this.cTCAnalysedBy = cTCAnalysedBy;
	}



	/**
	 * Return the value associated with the column: RequisitionHistory
	 */
	public java.util.Set<jkt.hrms.recruitment.masters.business.HrRequisitionHistory> getRequisitionHistory () {
		return requisitionHistory;
	}

	/**
	 * Set the value related to the column: RequisitionHistory
	 * @param requisitionHistory the RequisitionHistory value
	 */
	public void setRequisitionHistory (java.util.Set<jkt.hrms.recruitment.masters.business.HrRequisitionHistory> requisitionHistory) {
		this.requisitionHistory = requisitionHistory;
	}

	public void addToRequisitionHistory (jkt.hrms.recruitment.masters.business.HrRequisitionHistory hrRequisitionHistory) {
		if (null == getRequisitionHistory()) setRequisitionHistory(new java.util.TreeSet<jkt.hrms.recruitment.masters.business.HrRequisitionHistory>());
		getRequisitionHistory().add(hrRequisitionHistory);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.ResourceRequisition)) return false;
		else {
			jkt.hrms.recruitment.masters.business.ResourceRequisition resourceRequisition = (jkt.hrms.recruitment.masters.business.ResourceRequisition) obj;
			if (null == this.getId() || null == resourceRequisition.getId()) return false;
			else return (this.getId().equals(resourceRequisition.getId()));
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