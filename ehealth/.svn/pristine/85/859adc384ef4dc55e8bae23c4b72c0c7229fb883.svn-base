package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_cylinder_usage_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_cylinder_usage_master"
 */

public abstract class BaseHesCylinderUsageMaster  implements Serializable {

	public static String REF = "HesCylinderUsageMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CYLINDER_USAGE_CODE = "CylinderUsageCode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_CYLINDER_USAGE_NAME = "CylinderUsageName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHesCylinderUsageMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesCylinderUsageMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String cylinderUsageCode;
	private java.lang.String cylinderUsageName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="cylinder_id"
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
	 * Return the value associated with the column: cylinder_usage_code
	 */
	public java.lang.String getCylinderUsageCode () {
		return cylinderUsageCode;
	}

	/**
	 * Set the value related to the column: cylinder_usage_code
	 * @param cylinderUsageCode the cylinder_usage_code value
	 */
	public void setCylinderUsageCode (java.lang.String cylinderUsageCode) {
		this.cylinderUsageCode = cylinderUsageCode;
	}



	/**
	 * Return the value associated with the column: cylinder_usage_name
	 */
	public java.lang.String getCylinderUsageName () {
		return cylinderUsageName;
	}

	/**
	 * Set the value related to the column: cylinder_usage_name
	 * @param cylinderUsageName the cylinder_usage_name value
	 */
	public void setCylinderUsageName (java.lang.String cylinderUsageName) {
		this.cylinderUsageName = cylinderUsageName;
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
		if (!(obj instanceof jkt.hms.masters.business.HesCylinderUsageMaster)) return false;
		else {
			jkt.hms.masters.business.HesCylinderUsageMaster hesCylinderUsageMaster = (jkt.hms.masters.business.HesCylinderUsageMaster) obj;
			if (null == this.getId() || null == hesCylinderUsageMaster.getId()) return false;
			else return (this.getId().equals(hesCylinderUsageMaster.getId()));
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