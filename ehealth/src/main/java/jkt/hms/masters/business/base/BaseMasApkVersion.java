package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_apk_version table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_apk_version"
 */

public abstract class BaseMasApkVersion  implements Serializable {

	public static String REF = "MasApkVersion";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_APK_VERSION_TYPE = "ApkVersionType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VERSION_CODE = "VersionCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VERSION_NAME = "VersionName";


	// constructors
	public BaseMasApkVersion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasApkVersion (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String versionCode;
	private java.lang.String versionName;
	private java.lang.String status;
	private java.lang.String apkVersionType;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="version_id"
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
	 * Return the value associated with the column: version_code
	 */
	public java.lang.String getVersionCode () {
		return versionCode;
	}

	/**
	 * Set the value related to the column: version_code
	 * @param versionCode the version_code value
	 */
	public void setVersionCode (java.lang.String versionCode) {
		this.versionCode = versionCode;
	}



	/**
	 * Return the value associated with the column: version_name
	 */
	public java.lang.String getVersionName () {
		return versionName;
	}

	/**
	 * Set the value related to the column: version_name
	 * @param versionName the version_name value
	 */
	public void setVersionName (java.lang.String versionName) {
		this.versionName = versionName;
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
	 * Return the value associated with the column: apk_version_type
	 */
	public java.lang.String getApkVersionType () {
		return apkVersionType;
	}

	/**
	 * Set the value related to the column: apk_version_type
	 * @param apkVersionType the apk_version_type value
	 */
	public void setApkVersionType (java.lang.String apkVersionType) {
		this.apkVersionType = apkVersionType;
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
		if (!(obj instanceof jkt.hms.masters.business.MasApkVersion)) return false;
		else {
			jkt.hms.masters.business.MasApkVersion masApkVersion = (jkt.hms.masters.business.MasApkVersion) obj;
			if (null == this.getId() || null == masApkVersion.getId()) return false;
			else return (this.getId().equals(masApkVersion.getId()));
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