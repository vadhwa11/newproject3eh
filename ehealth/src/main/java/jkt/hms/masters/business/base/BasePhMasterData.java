package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_master_data table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_master_data"
 */

public abstract class BasePhMasterData  implements Serializable {

	public static String REF = "PhMasterData";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MASTER_TYPE = "MasterType";
	public static String PROP_ID = "Id";
	public static String PROP_MASTER = "Master";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DATA_NAME = "DataName";
	public static String PROP_DATA_CODE = "DataCode";


	// constructors
	public BasePhMasterData () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhMasterData (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dataCode;
	private java.lang.String dataName;
	private java.lang.String status;
	private java.lang.String masterType;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.PhMaster master;



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
	 * Return the value associated with the column: data_code
	 */
	public java.lang.String getDataCode () {
		return dataCode;
	}

	/**
	 * Set the value related to the column: data_code
	 * @param dataCode the data_code value
	 */
	public void setDataCode (java.lang.String dataCode) {
		this.dataCode = dataCode;
	}



	/**
	 * Return the value associated with the column: data_name
	 */
	public java.lang.String getDataName () {
		return dataName;
	}

	/**
	 * Set the value related to the column: data_name
	 * @param dataName the data_name value
	 */
	public void setDataName (java.lang.String dataName) {
		this.dataName = dataName;
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
	 * Return the value associated with the column: master_type
	 */
	public java.lang.String getMasterType () {
		return masterType;
	}

	/**
	 * Set the value related to the column: master_type
	 * @param masterType the master_type value
	 */
	public void setMasterType (java.lang.String masterType) {
		this.masterType = masterType;
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
	 * Return the value associated with the column: master_id
	 */
	public jkt.hms.masters.business.PhMaster getMaster () {
		return master;
	}

	/**
	 * Set the value related to the column: master_id
	 * @param master the master_id value
	 */
	public void setMaster (jkt.hms.masters.business.PhMaster master) {
		this.master = master;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhMasterData)) return false;
		else {
			jkt.hms.masters.business.PhMasterData phMasterData = (jkt.hms.masters.business.PhMasterData) obj;
			if (null == this.getId() || null == phMasterData.getId()) return false;
			else return (this.getId().equals(phMasterData.getId()));
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