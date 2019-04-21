package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_store_air_force_depot
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_store_air_force_depot"
 */

public abstract class BaseMasStoreAirForceDepot implements Serializable {

	public static String REF = "MasStoreAirForceDepot";
	public static String PROP_STATUS = "Status";
	public static String PROP_AIR_FORCE_DEPOT_NAME = "AirForceDepotName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AIR_FORCE_DEPOT_TYPE = "AirForceDepotType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasStoreAirForceDepot() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreAirForceDepot(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String airForceDepotName;
	private java.lang.String airForceDepotType;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> storeQuaterReturnTs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs;
	private java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="air_force_depot_id"
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
	 * Return the value associated with the column: air_force_depot_name
	 */
	public java.lang.String getAirForceDepotName() {
		return airForceDepotName;
	}

	/**
	 * Set the value related to the column: air_force_depot_name
	 * 
	 * @param airForceDepotName
	 *            the air_force_depot_name value
	 */
	public void setAirForceDepotName(java.lang.String airForceDepotName) {
		this.airForceDepotName = airForceDepotName;
	}

	/**
	 * Return the value associated with the column: air_force_depot_type
	 */
	public java.lang.String getAirForceDepotType() {
		return airForceDepotType;
	}

	/**
	 * Set the value related to the column: air_force_depot_type
	 * 
	 * @param airForceDepotType
	 *            the air_force_depot_type value
	 */
	public void setAirForceDepotType(java.lang.String airForceDepotType) {
		this.airForceDepotType = airForceDepotType;
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
	 * Return the value associated with the column: StoreQuaterReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> getStoreQuaterReturnTs() {
		return storeQuaterReturnTs;
	}

	/**
	 * Set the value related to the column: StoreQuaterReturnTs
	 * 
	 * @param storeQuaterReturnTs
	 *            the StoreQuaterReturnTs value
	 */
	public void setStoreQuaterReturnTs(
			java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> storeQuaterReturnTs) {
		this.storeQuaterReturnTs = storeQuaterReturnTs;
	}

	public void addToStoreQuaterReturnTs(
			jkt.hms.masters.business.StoreQuaterReturnT storeQuaterReturnT) {
		if (null == getStoreQuaterReturnTs()) {
			setStoreQuaterReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuaterReturnT>());
		}
		getStoreQuaterReturnTs().add(storeQuaterReturnT);
	}

	/**
	 * Return the value associated with the column: StoreIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMs() {
		return storeIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIssueMs
	 * 
	 * @param storeIssueMs
	 *            the StoreIssueMs value
	 */
	public void setStoreIssueMs(
			java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs) {
		this.storeIssueMs = storeIssueMs;
	}

	public void addToStoreIssueMs(
			jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMs()) {
			setStoreIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		}
		getStoreIssueMs().add(storeIssueM);
	}

	/**
	 * Return the value associated with the column: StoreIndentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentM> getStoreIndentMs() {
		return storeIndentMs;
	}

	/**
	 * Set the value related to the column: StoreIndentMs
	 * 
	 * @param storeIndentMs
	 *            the StoreIndentMs value
	 */
	public void setStoreIndentMs(
			java.util.Set<jkt.hms.masters.business.StoreIndentM> storeIndentMs) {
		this.storeIndentMs = storeIndentMs;
	}

	public void addToStoreIndentMs(
			jkt.hms.masters.business.StoreIndentM storeIndentM) {
		if (null == getStoreIndentMs()) {
			setStoreIndentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentM>());
		}
		getStoreIndentMs().add(storeIndentM);
	}

	/**
	 * Return the value associated with the column: StoreGrnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnM> getStoreGrnMs() {
		return storeGrnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnMs
	 * 
	 * @param storeGrnMs
	 *            the StoreGrnMs value
	 */
	public void setStoreGrnMs(
			java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs) {
		this.storeGrnMs = storeGrnMs;
	}

	public void addToStoreGrnMs(jkt.hms.masters.business.StoreGrnM storeGrnM) {
		if (null == getStoreGrnMs()) {
			setStoreGrnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnM>());
		}
		getStoreGrnMs().add(storeGrnM);
	}

	/**
	 * Return the value associated with the column: StoreLoaninMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninM> getStoreLoaninMs() {
		return storeLoaninMs;
	}

	/**
	 * Set the value related to the column: StoreLoaninMs
	 * 
	 * @param storeLoaninMs
	 *            the StoreLoaninMs value
	 */
	public void setStoreLoaninMs(
			java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs) {
		this.storeLoaninMs = storeLoaninMs;
	}

	public void addToStoreLoaninMs(
			jkt.hms.masters.business.StoreLoaninM storeLoaninM) {
		if (null == getStoreLoaninMs()) {
			setStoreLoaninMs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninM>());
		}
		getStoreLoaninMs().add(storeLoaninM);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.MasStoreAirForceDepot)) {
			return false;
		} else {
			jkt.hms.masters.business.MasStoreAirForceDepot masStoreAirForceDepot = (jkt.hms.masters.business.MasStoreAirForceDepot) obj;
			if (null == this.getId() || null == masStoreAirForceDepot.getId()) {
				return false;
			} else {
				return (this.getId().equals(masStoreAirForceDepot.getId()));
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