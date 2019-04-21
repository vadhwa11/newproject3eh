package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * patient_store_indent_header table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="patient_store_indent_header"
 */

public abstract class BasePatientStoreIndentHeader implements Serializable {

	public static String REF = "PatientStoreIndentHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DEMAND_NO = "DemandNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_TO_STORE = "ToStore";
	public static String PROP_REQUESTED_BY = "RequestedBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEMAND_DATE = "DemandDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_VISIT ="Visit";

	// constructors
	public BasePatientStoreIndentHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientStoreIndentHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String demandNo;
	private java.util.Date demandDate;
	private java.util.Date lastChgDate;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee requestedBy;
	private jkt.hms.masters.business.MasDepartment toStore;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Visit visit;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="patient_store_indent_header_id"
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
	 * Return the value associated with the column: demand_no
	 */
	public java.lang.String getDemandNo() {
		return demandNo;
	}

	/**
	 * Set the value related to the column: demand_no
	 * 
	 * @param demandNo
	 *            the demand_no value
	 */
	public void setDemandNo(java.lang.String demandNo) {
		this.demandNo = demandNo;
	}

	/**
	 * Return the value associated with the column: demand_date
	 */
	public java.util.Date getDemandDate() {
		return demandDate;
	}

	/**
	 * Set the value related to the column: demand_date
	 * 
	 * @param demandDate
	 *            the demand_date value
	 */
	public void setDemandDate(java.util.Date demandDate) {
		this.demandDate = demandDate;
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * 
	 * @param approvedBy
	 *            the approved_by value
	 */
	public void setApprovedBy(jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: requested_by
	 */
	public jkt.hms.masters.business.MasEmployee getRequestedBy() {
		return requestedBy;
	}

	/**
	 * Set the value related to the column: requested_by
	 * 
	 * @param requestedBy
	 *            the requested_by value
	 */
	public void setRequestedBy(jkt.hms.masters.business.MasEmployee requestedBy) {
		this.requestedBy = requestedBy;
	}

	/**
	 * Return the value associated with the column: to_store
	 */
	public jkt.hms.masters.business.MasDepartment getToStore() {
		return toStore;
	}

	/**
	 * Set the value related to the column: to_store
	 * 
	 * @param toStore
	 *            the to_store value
	 */
	public void setToStore(jkt.hms.masters.business.MasDepartment toStore) {
		this.toStore = toStore;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	
	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param hin
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}

	
	
	
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.PatientStoreIndentHeader)) {
			return false;
		} else {
			jkt.hms.masters.business.PatientStoreIndentHeader patientStoreIndentHeader = (jkt.hms.masters.business.PatientStoreIndentHeader) obj;
			if (null == this.getId()
					|| null == patientStoreIndentHeader.getId()) {
				return false;
			} else {
				return (this.getId().equals(patientStoreIndentHeader.getId()));
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