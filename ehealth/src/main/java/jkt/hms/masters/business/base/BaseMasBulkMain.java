package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_bulk_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_bulk_main"
 */

public abstract class BaseMasBulkMain  implements Serializable {

	public static String REF = "MasBulkMain";
	public static String PROP_STATUS = "Status";
	public static String PROP_GROUP_TYPE = "GroupType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GROUP_NAME = "GroupName";
	public static String PROP_GROUP_CODE = "GroupCode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasBulkMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBulkMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String groupCode;
	private java.lang.String groupType;
	private java.lang.String groupName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



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
	 * Return the value associated with the column: group_type
	 */
	public java.lang.String getGroupType () {
		return groupType;
	}

	/**
	 * Set the value related to the column: group_type
	 * @param groupType the group_type value
	 */
	public void setGroupType (java.lang.String groupType) {
		this.groupType = groupType;
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
		if (!(obj instanceof jkt.hms.masters.business.MasBulkMain)) return false;
		else {
			jkt.hms.masters.business.MasBulkMain masBulkMain = (jkt.hms.masters.business.MasBulkMain) obj;
			if (null == this.getId() || null == masBulkMain.getId()) return false;
			else return (this.getId().equals(masBulkMain.getId()));
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