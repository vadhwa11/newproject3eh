package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the emp_afmsf_det table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="emp_afmsf_det"
 */

public abstract class BaseEmpAfmsfDet implements Serializable {

	public static String REF = "EmpAfmsfDet";
	public static String PROP_RANK = "Rank";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_MEDICAL_CATEGORY = "MedicalCategory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AFMSF_TYPE = "AfmsfType";
	public static String PROP_NEXT_REVIEW = "NextReview";
	public static String PROP_EMP_NAME = "EmpName";
	public static String PROP_VIDE_WITH_DATE = "VideWithDate";
	public static String PROP_ID = "Id";
	public static String PROP_LETTER_NO = "LetterNo";
	public static String PROP_FMSF_DATE = "FmsfDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DOC_STATUS = "DocStatus";
	public static String PROP_POSTED_TO = "PostedTo";

	// constructors
	public BaseEmpAfmsfDet() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmpAfmsfDet(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.util.Date fmsfDate;
	private java.lang.String docStatus;
	private java.util.Date videWithDate;
	private java.lang.String postedTo;
	private java.lang.String afmsfType;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.util.Date nextReview;
	private java.lang.String empName;
	private java.lang.String letterNo;

	// many to one
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MisAnnualMedicalExam medicalCategory;
	private jkt.hms.masters.business.MasEmployee employee;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="empafmsfdet_id"
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
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo() {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * 
	 * @param serviceNo
	 *            the service_no value
	 */
	public void setServiceNo(java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}

	/**
	 * Return the value associated with the column: fmsf_date
	 */
	public java.util.Date getFmsfDate() {
		return fmsfDate;
	}

	/**
	 * Set the value related to the column: fmsf_date
	 * 
	 * @param fmsfDate
	 *            the fmsf_date value
	 */
	public void setFmsfDate(java.util.Date fmsfDate) {
		this.fmsfDate = fmsfDate;
	}

	/**
	 * Return the value associated with the column: doc_status
	 */
	public java.lang.String getDocStatus() {
		return docStatus;
	}

	/**
	 * Set the value related to the column: doc_status
	 * 
	 * @param docStatus
	 *            the doc_status value
	 */
	public void setDocStatus(java.lang.String docStatus) {
		this.docStatus = docStatus;
	}

	/**
	 * Return the value associated with the column: vide_with_date
	 */
	public java.util.Date getVideWithDate() {
		return videWithDate;
	}

	/**
	 * Set the value related to the column: vide_with_date
	 * 
	 * @param videWithDate
	 *            the vide_with_date value
	 */
	public void setVideWithDate(java.util.Date videWithDate) {
		this.videWithDate = videWithDate;
	}

	/**
	 * Return the value associated with the column: posted_to
	 */
	public java.lang.String getPostedTo() {
		return postedTo;
	}

	/**
	 * Set the value related to the column: posted_to
	 * 
	 * @param postedTo
	 *            the posted_to value
	 */
	public void setPostedTo(java.lang.String postedTo) {
		this.postedTo = postedTo;
	}

	/**
	 * Return the value associated with the column: afmsf_type
	 */
	public java.lang.String getAfmsfType() {
		return afmsfType;
	}

	/**
	 * Set the value related to the column: afmsf_type
	 * 
	 * @param afmsfType
	 *            the afmsf_type value
	 */
	public void setAfmsfType(java.lang.String afmsfType) {
		this.afmsfType = afmsfType;
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
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: next_review
	 */
	public java.util.Date getNextReview() {
		return nextReview;
	}

	/**
	 * Set the value related to the column: next_review
	 * 
	 * @param nextReview
	 *            the next_review value
	 */
	public void setNextReview(java.util.Date nextReview) {
		this.nextReview = nextReview;
	}

	/**
	 * Return the value associated with the column: emp_name
	 */
	public java.lang.String getEmpName() {
		return empName;
	}

	/**
	 * Set the value related to the column: emp_name
	 * 
	 * @param empName
	 *            the emp_name value
	 */
	public void setEmpName(java.lang.String empName) {
		this.empName = empName;
	}

	/**
	 * Return the value associated with the column: letter_no
	 */
	public java.lang.String getLetterNo() {
		return letterNo;
	}

	/**
	 * Set the value related to the column: letter_no
	 * 
	 * @param letterNo
	 *            the letter_no value
	 */
	public void setLetterNo(java.lang.String letterNo) {
		this.letterNo = letterNo;
	}

	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank() {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * 
	 * @param rank
	 *            the rank_id value
	 */
	public void setRank(jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit() {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * 
	 * @param unit
	 *            the unit_id value
	 */
	public void setUnit(jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}

	/**
	 * Return the value associated with the column: medical_category
	 */
	public jkt.hms.masters.business.MisAnnualMedicalExam getMedicalCategory() {
		return medicalCategory;
	}

	/**
	 * Set the value related to the column: medical_category
	 * 
	 * @param medicalCategory
	 *            the medical_category value
	 */
	public void setMedicalCategory(
			jkt.hms.masters.business.MisAnnualMedicalExam medicalCategory) {
		this.medicalCategory = medicalCategory;
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

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.EmpAfmsfDet)) {
			return false;
		} else {
			jkt.hms.masters.business.EmpAfmsfDet empAfmsfDet = (jkt.hms.masters.business.EmpAfmsfDet) obj;
			if (null == this.getId() || null == empAfmsfDet.getId()) {
				return false;
			} else {
				return (this.getId().equals(empAfmsfDet.getId()));
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