package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_defective_drug_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_defective_drug_m"
 */

public abstract class BaseStoreDefectiveDrugM  implements Serializable {

	public static String REF = "StoreDefectiveDrugM";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DESC3 = "Desc3";
	public static String PROP_DESC1 = "Desc1";
	public static String PROP_DESC2 = "Desc2";
	public static String PROP_STATUS = "Status";
	public static String PROP_COPY_TO = "CopyTo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_APPROVED_DATE = "ApprovedDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_TO_PLACE = "ToPlace";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseStoreDefectiveDrugM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreDefectiveDrugM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date entryDate;
	private java.lang.String toPlace;
	private java.lang.String desc1;
	private java.lang.String desc2;
	private java.lang.String desc3;
	private java.lang.String copyTo;
	private java.lang.String status;
	private java.lang.String entryNo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.util.Date approvedDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Users approvedBy;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="defect_m_id"
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
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * @param entryDate the entry_date value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: to_place
	 */
	public java.lang.String getToPlace () {
		return toPlace;
	}

	/**
	 * Set the value related to the column: to_place
	 * @param toPlace the to_place value
	 */
	public void setToPlace (java.lang.String toPlace) {
		this.toPlace = toPlace;
	}



	/**
	 * Return the value associated with the column: desc1
	 */
	public java.lang.String getDesc1 () {
		return desc1;
	}

	/**
	 * Set the value related to the column: desc1
	 * @param desc1 the desc1 value
	 */
	public void setDesc1 (java.lang.String desc1) {
		this.desc1 = desc1;
	}



	/**
	 * Return the value associated with the column: desc2
	 */
	public java.lang.String getDesc2 () {
		return desc2;
	}

	/**
	 * Set the value related to the column: desc2
	 * @param desc2 the desc2 value
	 */
	public void setDesc2 (java.lang.String desc2) {
		this.desc2 = desc2;
	}



	/**
	 * Return the value associated with the column: desc3
	 */
	public java.lang.String getDesc3 () {
		return desc3;
	}

	/**
	 * Set the value related to the column: desc3
	 * @param desc3 the desc3 value
	 */
	public void setDesc3 (java.lang.String desc3) {
		this.desc3 = desc3;
	}



	/**
	 * Return the value associated with the column: copy_to
	 */
	public java.lang.String getCopyTo () {
		return copyTo;
	}

	/**
	 * Set the value related to the column: copy_to
	 * @param copyTo the copy_to value
	 */
	public void setCopyTo (java.lang.String copyTo) {
		this.copyTo = copyTo;
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: approved_date
	 */
	public java.util.Date getApprovedDate () {
		return approvedDate;
	}

	/**
	 * Set the value related to the column: approved_date
	 * @param approvedDate the approved_date value
	 */
	public void setApprovedDate (java.util.Date approvedDate) {
		this.approvedDate = approvedDate;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.Users getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.Users approvedBy) {
		this.approvedBy = approvedBy;
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
	 * Return the value associated with the column: StoreDefectiveDrugTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> getStoreDefectiveDrugTs () {
		return storeDefectiveDrugTs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugTs
	 * @param storeDefectiveDrugTs the StoreDefectiveDrugTs value
	 */
	public void setStoreDefectiveDrugTs (java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs) {
		this.storeDefectiveDrugTs = storeDefectiveDrugTs;
	}

	public void addToStoreDefectiveDrugTs (jkt.hms.masters.business.StoreDefectiveDrugT storeDefectiveDrugT) {
		if (null == getStoreDefectiveDrugTs()) setStoreDefectiveDrugTs(new java.util.TreeSet<jkt.hms.masters.business.StoreDefectiveDrugT>());
		getStoreDefectiveDrugTs().add(storeDefectiveDrugT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreDefectiveDrugM)) return false;
		else {
			jkt.hms.masters.business.StoreDefectiveDrugM storeDefectiveDrugM = (jkt.hms.masters.business.StoreDefectiveDrugM) obj;
			if (null == this.getId() || null == storeDefectiveDrugM.getId()) return false;
			else return (this.getId().equals(storeDefectiveDrugM.getId()));
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