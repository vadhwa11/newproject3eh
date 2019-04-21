package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_work_order_m table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_work_order_m"
 */

public abstract class BaseStoreWorkOrderM implements Serializable {

	public static String REF = "StoreWorkOrderM";
	public static String PROP_STATUS = "Status";
	public static String PROP_AUTHORITY_NO = "AuthorityNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REPAIRING_CELL = "RepairingCell";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_WORK_ORDER_DATE = "WorkOrderDate";
	public static String PROP_WORK_ORDER_NO = "WorkOrderNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreWorkOrderM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreWorkOrderM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreWorkOrderM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String workOrderNo, java.util.Date workOrderDate,
			java.lang.String repairingCell, java.lang.String authorityNo,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime, java.lang.String status) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setWorkOrderNo(workOrderNo);
		this.setWorkOrderDate(workOrderDate);
		this.setRepairingCell(repairingCell);
		this.setAuthorityNo(authorityNo);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		this.setStatus(status);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String workOrderNo;
	private java.util.Date workOrderDate;
	private java.lang.String repairingCell;
	private java.lang.String authorityNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> storeWorkOrderTs;
	private java.util.Set<jkt.hms.masters.business.StoreCondemnationM> storeCondemnationMs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: work_order_no
	 */
	public java.lang.String getWorkOrderNo() {
		return workOrderNo;
	}

	/**
	 * Set the value related to the column: work_order_no
	 * 
	 * @param workOrderNo
	 *            the work_order_no value
	 */
	public void setWorkOrderNo(java.lang.String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	/**
	 * Return the value associated with the column: work_order_date
	 */
	public java.util.Date getWorkOrderDate() {
		return workOrderDate;
	}

	/**
	 * Set the value related to the column: work_order_date
	 * 
	 * @param workOrderDate
	 *            the work_order_date value
	 */
	public void setWorkOrderDate(java.util.Date workOrderDate) {
		this.workOrderDate = workOrderDate;
	}

	/**
	 * Return the value associated with the column: repairing_cell
	 */
	public java.lang.String getRepairingCell() {
		return repairingCell;
	}

	/**
	 * Set the value related to the column: repairing_cell
	 * 
	 * @param repairingCell
	 *            the repairing_cell value
	 */
	public void setRepairingCell(java.lang.String repairingCell) {
		this.repairingCell = repairingCell;
	}

	/**
	 * Return the value associated with the column: authority_no
	 */
	public java.lang.String getAuthorityNo() {
		return authorityNo;
	}

	/**
	 * Set the value related to the column: authority_no
	 * 
	 * @param authorityNo
	 *            the authority_no value
	 */
	public void setAuthorityNo(java.lang.String authorityNo) {
		this.authorityNo = authorityNo;
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
	 * Return the value associated with the column: StoreWorkOrderTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> getStoreWorkOrderTs() {
		return storeWorkOrderTs;
	}

	/**
	 * Set the value related to the column: StoreWorkOrderTs
	 * 
	 * @param storeWorkOrderTs
	 *            the StoreWorkOrderTs value
	 */
	public void setStoreWorkOrderTs(
			java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> storeWorkOrderTs) {
		this.storeWorkOrderTs = storeWorkOrderTs;
	}

	public void addToStoreWorkOrderTs(
			jkt.hms.masters.business.StoreWorkOrderT storeWorkOrderT) {
		if (null == getStoreWorkOrderTs()) {
			setStoreWorkOrderTs(new java.util.TreeSet<jkt.hms.masters.business.StoreWorkOrderT>());
		}
		getStoreWorkOrderTs().add(storeWorkOrderT);
	}

	/**
	 * Return the value associated with the column: StoreCondemnationMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreCondemnationM> getStoreCondemnationMs() {
		return storeCondemnationMs;
	}

	/**
	 * Set the value related to the column: StoreCondemnationMs
	 * 
	 * @param storeCondemnationMs
	 *            the StoreCondemnationMs value
	 */
	public void setStoreCondemnationMs(
			java.util.Set<jkt.hms.masters.business.StoreCondemnationM> storeCondemnationMs) {
		this.storeCondemnationMs = storeCondemnationMs;
	}

	public void addToStoreCondemnationMs(
			jkt.hms.masters.business.StoreCondemnationM storeCondemnationM) {
		if (null == getStoreCondemnationMs()) {
			setStoreCondemnationMs(new java.util.TreeSet<jkt.hms.masters.business.StoreCondemnationM>());
		}
		getStoreCondemnationMs().add(storeCondemnationM);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.StoreWorkOrderM)) {
			return false;
		} else {
			jkt.hms.masters.business.StoreWorkOrderM storeWorkOrderM = (jkt.hms.masters.business.StoreWorkOrderM) obj;
			if (null == this.getId() || null == storeWorkOrderM.getId()) {
				return false;
			} else {
				return (this.getId().equals(storeWorkOrderM.getId()));
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