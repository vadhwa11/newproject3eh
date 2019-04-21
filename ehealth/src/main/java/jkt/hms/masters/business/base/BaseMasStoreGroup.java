package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_group table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_group"
 */

public abstract class BaseMasStoreGroup  implements Serializable {

	public static String REF = "MasStoreGroup";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GROUP_NAME = "GroupName";
	public static String PROP_GROUP_CODE = "GroupCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasStoreGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreGroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String groupCode;
	private java.lang.String groupName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> storeTenderInvitaLetterToVenders;
	private java.util.Set<jkt.hms.masters.business.StorePoHeader> storePoHeaders;
	private java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs;
	private java.util.Set<jkt.hms.masters.business.MasStoreSupplierGroup> masStoreSupplierGroups;
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;
	private java.util.Set<jkt.hms.masters.business.StoreTenderToSupplier> storeTenderToSuppliers;
	private java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> storeTenderTechnicalBidMs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="group_id"
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
	 * Return the value associated with the column: group_code
	 */
	public java.lang.String getGroupCode () {
		return groupCode;
	}

	/**
	 * Set the value related to the column: group_code
	 * @param groupCode the group_code value
	 */
	public void setGroupCode (java.lang.String groupCode) {
		this.groupCode = groupCode;
	}



	/**
	 * Return the value associated with the column: group_name
	 */
	public java.lang.String getGroupName () {
		return groupName;
	}

	/**
	 * Set the value related to the column: group_name
	 * @param groupName the group_name value
	 */
	public void setGroupName (java.lang.String groupName) {
		this.groupName = groupName;
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
	 * Return the value associated with the column: StoreTenderInvitaLetterToVenders
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> getStoreTenderInvitaLetterToVenders () {
		return storeTenderInvitaLetterToVenders;
	}

	/**
	 * Set the value related to the column: StoreTenderInvitaLetterToVenders
	 * @param storeTenderInvitaLetterToVenders the StoreTenderInvitaLetterToVenders value
	 */
	public void setStoreTenderInvitaLetterToVenders (java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> storeTenderInvitaLetterToVenders) {
		this.storeTenderInvitaLetterToVenders = storeTenderInvitaLetterToVenders;
	}

	public void addToStoreTenderInvitaLetterToVenders (jkt.hms.masters.business.StoreTenderInvitaLetterToVender storeTenderInvitaLetterToVender) {
		if (null == getStoreTenderInvitaLetterToVenders()) setStoreTenderInvitaLetterToVenders(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderInvitaLetterToVender>());
		getStoreTenderInvitaLetterToVenders().add(storeTenderInvitaLetterToVender);
	}



	/**
	 * Return the value associated with the column: StorePoHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoHeader> getStorePoHeaders () {
		return storePoHeaders;
	}

	/**
	 * Set the value related to the column: StorePoHeaders
	 * @param storePoHeaders the StorePoHeaders value
	 */
	public void setStorePoHeaders (java.util.Set<jkt.hms.masters.business.StorePoHeader> storePoHeaders) {
		this.storePoHeaders = storePoHeaders;
	}

	public void addToStorePoHeaders (jkt.hms.masters.business.StorePoHeader storePoHeader) {
		if (null == getStorePoHeaders()) setStorePoHeaders(new java.util.TreeSet<jkt.hms.masters.business.StorePoHeader>());
		getStorePoHeaders().add(storePoHeader);
	}



	/**
	 * Return the value associated with the column: StoreTenderCommBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> getStoreTenderCommBidMs () {
		return storeTenderCommBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderCommBidMs
	 * @param storeTenderCommBidMs the StoreTenderCommBidMs value
	 */
	public void setStoreTenderCommBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs) {
		this.storeTenderCommBidMs = storeTenderCommBidMs;
	}

	public void addToStoreTenderCommBidMs (jkt.hms.masters.business.StoreTenderCommBidM storeTenderCommBidM) {
		if (null == getStoreTenderCommBidMs()) setStoreTenderCommBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderCommBidM>());
		getStoreTenderCommBidMs().add(storeTenderCommBidM);
	}



	/**
	 * Return the value associated with the column: MasStoreSupplierGroups
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreSupplierGroup> getMasStoreSupplierGroups () {
		return masStoreSupplierGroups;
	}

	/**
	 * Set the value related to the column: MasStoreSupplierGroups
	 * @param masStoreSupplierGroups the MasStoreSupplierGroups value
	 */
	public void setMasStoreSupplierGroups (java.util.Set<jkt.hms.masters.business.MasStoreSupplierGroup> masStoreSupplierGroups) {
		this.masStoreSupplierGroups = masStoreSupplierGroups;
	}

	public void addToMasStoreSupplierGroups (jkt.hms.masters.business.MasStoreSupplierGroup masStoreSupplierGroup) {
		if (null == getMasStoreSupplierGroups()) setMasStoreSupplierGroups(new java.util.TreeSet<jkt.hms.masters.business.MasStoreSupplierGroup>());
		getMasStoreSupplierGroups().add(masStoreSupplierGroup);
	}



	/**
	 * Return the value associated with the column: MasStoreItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItem> getMasStoreItems () {
		return masStoreItems;
	}

	/**
	 * Set the value related to the column: MasStoreItems
	 * @param masStoreItems the MasStoreItems value
	 */
	public void setMasStoreItems (java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems) {
		this.masStoreItems = masStoreItems;
	}

	public void addToMasStoreItems (jkt.hms.masters.business.MasStoreItem masStoreItem) {
		if (null == getMasStoreItems()) setMasStoreItems(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItem>());
		getMasStoreItems().add(masStoreItem);
	}



	/**
	 * Return the value associated with the column: StoreTenderToSuppliers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderToSupplier> getStoreTenderToSuppliers () {
		return storeTenderToSuppliers;
	}

	/**
	 * Set the value related to the column: StoreTenderToSuppliers
	 * @param storeTenderToSuppliers the StoreTenderToSuppliers value
	 */
	public void setStoreTenderToSuppliers (java.util.Set<jkt.hms.masters.business.StoreTenderToSupplier> storeTenderToSuppliers) {
		this.storeTenderToSuppliers = storeTenderToSuppliers;
	}

	public void addToStoreTenderToSuppliers (jkt.hms.masters.business.StoreTenderToSupplier storeTenderToSupplier) {
		if (null == getStoreTenderToSuppliers()) setStoreTenderToSuppliers(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderToSupplier>());
		getStoreTenderToSuppliers().add(storeTenderToSupplier);
	}



	/**
	 * Return the value associated with the column: StoreTenderTechnicalBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> getStoreTenderTechnicalBidMs () {
		return storeTenderTechnicalBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderTechnicalBidMs
	 * @param storeTenderTechnicalBidMs the StoreTenderTechnicalBidMs value
	 */
	public void setStoreTenderTechnicalBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidM> storeTenderTechnicalBidMs) {
		this.storeTenderTechnicalBidMs = storeTenderTechnicalBidMs;
	}

	public void addToStoreTenderTechnicalBidMs (jkt.hms.masters.business.StoreTenderTechnicalBidM storeTenderTechnicalBidM) {
		if (null == getStoreTenderTechnicalBidMs()) setStoreTenderTechnicalBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderTechnicalBidM>());
		getStoreTenderTechnicalBidMs().add(storeTenderTechnicalBidM);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreGroup)) return false;
		else {
			jkt.hms.masters.business.MasStoreGroup masStoreGroup = (jkt.hms.masters.business.MasStoreGroup) obj;
			if (null == this.getId() || null == masStoreGroup.getId()) return false;
			else return (this.getId().equals(masStoreGroup.getId()));
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