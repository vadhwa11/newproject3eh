package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_syndromic_survcillence_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_syndromic_survcillence_mapping"
 */

public abstract class BasePhSyndromicSurvcillenceMapping  implements Serializable {

	public static String REF = "PhSyndromicSurvcillenceMapping";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MAIN_GROUP_ID = "MainGroupId";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MAIN_GROUP_NAME = "MainGroupName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PARAMETER_NAME = "ParameterName";
	public static String PROP_SUB_GROUP_ID = "SubGroupId";
	public static String PROP_SUB_GROUP_NAME = "SubGroupName";


	// constructors
	public BasePhSyndromicSurvcillenceMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhSyndromicSurvcillenceMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String parameterName;
	private java.lang.String mainGroupName;
	private java.lang.String subGroupName;
	private java.lang.Integer mainGroupId;
	private java.lang.Integer subGroupId;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ph_syndromic_survcillence_mapping_id"
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
	 * Return the value associated with the column: parameter_name
	 */
	public java.lang.String getParameterName () {
		return parameterName;
	}

	/**
	 * Set the value related to the column: parameter_name
	 * @param parameterName the parameter_name value
	 */
	public void setParameterName (java.lang.String parameterName) {
		this.parameterName = parameterName;
	}



	/**
	 * Return the value associated with the column: main_group_name
	 */
	public java.lang.String getMainGroupName () {
		return mainGroupName;
	}

	/**
	 * Set the value related to the column: main_group_name
	 * @param mainGroupName the main_group_name value
	 */
	public void setMainGroupName (java.lang.String mainGroupName) {
		this.mainGroupName = mainGroupName;
	}



	/**
	 * Return the value associated with the column: sub_group_name
	 */
	public java.lang.String getSubGroupName () {
		return subGroupName;
	}

	/**
	 * Set the value related to the column: sub_group_name
	 * @param subGroupName the sub_group_name value
	 */
	public void setSubGroupName (java.lang.String subGroupName) {
		this.subGroupName = subGroupName;
	}



	/**
	 * Return the value associated with the column: main_group_id
	 */
	public java.lang.Integer getMainGroupId () {
		return mainGroupId;
	}

	/**
	 * Set the value related to the column: main_group_id
	 * @param mainGroupId the main_group_id value
	 */
	public void setMainGroupId (java.lang.Integer mainGroupId) {
		this.mainGroupId = mainGroupId;
	}



	/**
	 * Return the value associated with the column: sub_group_id
	 */
	public java.lang.Integer getSubGroupId () {
		return subGroupId;
	}

	/**
	 * Set the value related to the column: sub_group_id
	 * @param subGroupId the sub_group_id value
	 */
	public void setSubGroupId (java.lang.Integer subGroupId) {
		this.subGroupId = subGroupId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhSyndromicSurvcillenceMapping)) return false;
		else {
			jkt.hms.masters.business.PhSyndromicSurvcillenceMapping phSyndromicSurvcillenceMapping = (jkt.hms.masters.business.PhSyndromicSurvcillenceMapping) obj;
			if (null == this.getId() || null == phSyndromicSurvcillenceMapping.getId()) return false;
			else return (this.getId().equals(phSyndromicSurvcillenceMapping.getId()));
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