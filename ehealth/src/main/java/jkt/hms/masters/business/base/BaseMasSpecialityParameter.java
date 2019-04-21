package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_speciality_parameter table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_speciality_parameter"
 */

public abstract class BaseMasSpecialityParameter  implements Serializable {

	public static String REF = "MasSpecialityParameter";
	public static String PROP_STATUS = "Status";
	public static String PROP_IMAGE_REQ = "ImageReq";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VALUE_TYPE = "ValueType";
	public static String PROP_SP_PARAMETER_CODE = "SpParameterCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SP_PARAMETER_NAME = "SpParameterName";
	public static String PROP_ID = "Id";
	public static String PROP_COMMON = "Common";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasSpecialityParameter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSpecialityParameter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String spParameterCode;
	private java.lang.String spParameterName;
	private java.lang.String valueType;
	private java.lang.String imageReq;
	private java.lang.String common;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="sp_parameter_id"
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
	 * Return the value associated with the column: sp_parameter_code
	 */
	public java.lang.String getSpParameterCode () {
		return spParameterCode;
	}

	/**
	 * Set the value related to the column: sp_parameter_code
	 * @param spParameterCode the sp_parameter_code value
	 */
	public void setSpParameterCode (java.lang.String spParameterCode) {
		this.spParameterCode = spParameterCode;
	}



	/**
	 * Return the value associated with the column: sp_parameter_name
	 */
	public java.lang.String getSpParameterName () {
		return spParameterName;
	}

	/**
	 * Set the value related to the column: sp_parameter_name
	 * @param spParameterName the sp_parameter_name value
	 */
	public void setSpParameterName (java.lang.String spParameterName) {
		this.spParameterName = spParameterName;
	}



	/**
	 * Return the value associated with the column: value_type
	 */
	public java.lang.String getValueType () {
		return valueType;
	}

	/**
	 * Set the value related to the column: value_type
	 * @param valueType the value_type value
	 */
	public void setValueType (java.lang.String valueType) {
		this.valueType = valueType;
	}



	/**
	 * Return the value associated with the column: image_req
	 */
	public java.lang.String getImageReq () {
		return imageReq;
	}

	/**
	 * Set the value related to the column: image_req
	 * @param imageReq the image_req value
	 */
	public void setImageReq (java.lang.String imageReq) {
		this.imageReq = imageReq;
	}



	/**
	 * Return the value associated with the column: common
	 */
	public java.lang.String getCommon () {
		return common;
	}

	/**
	 * Set the value related to the column: common
	 * @param common the common value
	 */
	public void setCommon (java.lang.String common) {
		this.common = common;
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
		if (!(obj instanceof jkt.hms.masters.business.MasSpecialityParameter)) return false;
		else {
			jkt.hms.masters.business.MasSpecialityParameter masSpecialityParameter = (jkt.hms.masters.business.MasSpecialityParameter) obj;
			if (null == this.getId() || null == masSpecialityParameter.getId()) return false;
			else return (this.getId().equals(masSpecialityParameter.getId()));
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