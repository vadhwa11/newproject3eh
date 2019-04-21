package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_stock_taking_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_stock_taking_m"
 */

public abstract class BaseStoreStockTakingM  implements Serializable {

	public static String REF = "StoreStockTakingM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_PHYSICAL_DATE = "PhysicalDate";
	public static String PROP_ITEM_GROUP = "ItemGroup";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_APPROVED_DATE = "ApprovedDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseStoreStockTakingM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreStockTakingM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date physicalDate;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.lang.String status;
	private java.util.Date approvedDate;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreGroup itemGroup;
	private jkt.hms.masters.business.Users lastChangedBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs;
	private java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs;



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
	 * Return the value associated with the column: physical_date
	 */
	public java.util.Date getPhysicalDate () {
		return physicalDate;
	}

	/**
	 * Set the value related to the column: physical_date
	 * @param physicalDate the physical_date value
	 */
	public void setPhysicalDate (java.util.Date physicalDate) {
		this.physicalDate = physicalDate;
	}



	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate () {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * @param lastChangedDate the last_changed_date value
	 */
	public void setLastChangedDate (java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}



	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime () {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * @param lastChangedTime the last_changed_time value
	 */
	public void setLastChangedTime (java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
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
	 * Return the value associated with the column: item_group_id
	 */
	public jkt.hms.masters.business.MasStoreGroup getItemGroup () {
		return itemGroup;
	}

	/**
	 * Set the value related to the column: item_group_id
	 * @param itemGroup the item_group_id value
	 */
	public void setItemGroup (jkt.hms.masters.business.MasStoreGroup itemGroup) {
		this.itemGroup = itemGroup;
	}



	/**
	 * Return the value associated with the column: last_changed_by
	 */
	public jkt.hms.masters.business.Users getLastChangedBy () {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * @param lastChangedBy the last_changed_by value
	 */
	public void setLastChangedBy (jkt.hms.masters.business.Users lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}



	/**
	 * Return the value associated with the column: StoreAdjustmentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> getStoreAdjustmentMs () {
		return storeAdjustmentMs;
	}

	/**
	 * Set the value related to the column: StoreAdjustmentMs
	 * @param storeAdjustmentMs the StoreAdjustmentMs value
	 */
	public void setStoreAdjustmentMs (java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs) {
		this.storeAdjustmentMs = storeAdjustmentMs;
	}

	public void addToStoreAdjustmentMs (jkt.hms.masters.business.StoreAdjustmentM storeAdjustmentM) {
		if (null == getStoreAdjustmentMs()) setStoreAdjustmentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreAdjustmentM>());
		getStoreAdjustmentMs().add(storeAdjustmentM);
	}



	/**
	 * Return the value associated with the column: StoreStockTakingTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreStockTakingT> getStoreStockTakingTs () {
		return storeStockTakingTs;
	}

	/**
	 * Set the value related to the column: StoreStockTakingTs
	 * @param storeStockTakingTs the StoreStockTakingTs value
	 */
	public void setStoreStockTakingTs (java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs) {
		this.storeStockTakingTs = storeStockTakingTs;
	}

	public void addToStoreStockTakingTs (jkt.hms.masters.business.StoreStockTakingT storeStockTakingT) {
		if (null == getStoreStockTakingTs()) setStoreStockTakingTs(new java.util.TreeSet<jkt.hms.masters.business.StoreStockTakingT>());
		getStoreStockTakingTs().add(storeStockTakingT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreStockTakingM)) return false;
		else {
			jkt.hms.masters.business.StoreStockTakingM storeStockTakingM = (jkt.hms.masters.business.StoreStockTakingM) obj;
			if (null == this.getId() || null == storeStockTakingM.getId()) return false;
			else return (this.getId().equals(storeStockTakingM.getId()));
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