package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_lsg_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_lsg_type"
 */

public abstract class BaseMasLsgType  implements Serializable {

	public static String REF = "MasLsgType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LSG_TYPE_NAME = "LsgTypeName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LSG_TYPE_CODE = "LsgTypeCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasLsgType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasLsgType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String lsgTypeCode;
	private java.lang.String lsgTypeName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="lsg_type_id"
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
	 * Return the value associated with the column: lsg_type_code
	 */
	public java.lang.String getLsgTypeCode () {
		return lsgTypeCode;
	}

	/**
	 * Set the value related to the column: lsg_type_code
	 * @param lsgTypeCode the lsg_type_code value
	 */
	public void setLsgTypeCode (java.lang.String lsgTypeCode) {
		this.lsgTypeCode = lsgTypeCode;
	}



	/**
	 * Return the value associated with the column: lsg_type_name
	 */
	public java.lang.String getLsgTypeName () {
		return lsgTypeName;
	}

	/**
	 * Set the value related to the column: lsg_type_name
	 * @param lsgTypeName the lsg_type_name value
	 */
	public void setLsgTypeName (java.lang.String lsgTypeName) {
		this.lsgTypeName = lsgTypeName;
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
		if (!(obj instanceof jkt.hms.masters.business.MasLsgType)) return false;
		else {
			jkt.hms.masters.business.MasLsgType masLsgType = (jkt.hms.masters.business.MasLsgType) obj;
			if (null == this.getId() || null == masLsgType.getId()) return false;
			else return (this.getId().equals(masLsgType.getId()));
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