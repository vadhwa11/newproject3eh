package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_post_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_post_code"
 */

public abstract class BaseMasPostCode  implements Serializable {

	public static String REF = "MasPostCode";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_POST_CODE = "PostCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_ID = "Id";
	public static String PROP_DISTRICT_ID = "DistrictId";
	public static String PROP_POST_CODE_NAME = "PostCodeName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasPostCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPostCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String postCode;
	private java.lang.String postCodeName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer pinCode;
	private jkt.hms.masters.business.MasDistrict districtId;
	
	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasVillage village;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="post_code_id"
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
	 * Return the value associated with the column: post_code
	 */
	public java.lang.String getPostCode () {
		return postCode;
	}

	/**
	 * Set the value related to the column: post_code
	 * @param postCode the post_code value
	 */
	public void setPostCode (java.lang.String postCode) {
		this.postCode = postCode;
	}



	/**
	 * Return the value associated with the column: post_code_name
	 */
	public java.lang.String getPostCodeName () {
		return postCodeName;
	}

	/**
	 * Set the value related to the column: post_code_name
	 * @param postCodeName the post_code_name value
	 */
	public void setPostCodeName (java.lang.String postCodeName) {
		this.postCodeName = postCodeName;
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
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.Integer getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * @param pinCode the pin_code value
	 */
	public void setPinCode (java.lang.Integer pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrictId () {
		return districtId;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param districtId the district_id value
	 */
	public void setDistrictId (jkt.hms.masters.business.MasDistrict districtId) {
		this.districtId = districtId;
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
	 * Return the value associated with the column: village_id
	 */
	public jkt.hms.masters.business.MasVillage getVillage () {
		return village;
	}

	/**
	 * Set the value related to the column: village_id
	 * @param village the village_id value
	 */
	public void setVillage (jkt.hms.masters.business.MasVillage village) {
		this.village = village;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPostCode)) return false;
		else {
			jkt.hms.masters.business.MasPostCode masPostCode = (jkt.hms.masters.business.MasPostCode) obj;
			if (null == this.getId() || null == masPostCode.getId()) return false;
			else return (this.getId().equals(masPostCode.getId()));
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