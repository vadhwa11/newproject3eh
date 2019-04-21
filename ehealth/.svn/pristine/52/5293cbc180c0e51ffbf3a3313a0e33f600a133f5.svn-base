package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_speciality_dept_group_value table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_speciality_dept_group_value"
 */

public abstract class BaseMasSpecialityDeptGroupValue  implements Serializable {

	public static String REF = "MasSpecialityDeptGroupValue";
	public static String PROP_STATUS = "Status";
	public static String PROP_IMG_FILE = "ImgFile";
	public static String PROP_VALUE = "Value";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TYPE = "Type";
	public static String PROP_DEPT_GROUP = "DeptGroup";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DEFAULT_VALUE = "DefaultValue";
	public static String PROP_EXTRA_TEXT = "ExtraText";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasSpecialityDeptGroupValue () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSpecialityDeptGroupValue (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasSpecialityDeptGroupValue (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasSpecialityDeptGroup deptGroup,
		java.lang.String type,
		java.lang.String status) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDeptGroup(deptGroup);
		this.setType(type);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String type;
	private java.lang.String value;
	private byte[] imgFile;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String defaultValue;
	private java.lang.String extraText;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasSpecialityDeptGroup deptGroup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="value_id"
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
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: value
	 */
	public java.lang.String getValue () {
		return value;
	}

	/**
	 * Set the value related to the column: value
	 * @param value the value value
	 */
	public void setValue (java.lang.String value) {
		this.value = value;
	}



	/**
	 * Return the value associated with the column: img_file
	 */
	public byte[] getImgFile () {
		return imgFile;
	}

	/**
	 * Set the value related to the column: img_file
	 * @param imgFile the img_file value
	 */
	public void setImgFile (byte[] imgFile) {
		this.imgFile = imgFile;
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
	 * Return the value associated with the column: default_value
	 */
	public java.lang.String getDefaultValue () {
		return defaultValue;
	}

	/**
	 * Set the value related to the column: default_value
	 * @param defaultValue the default_value value
	 */
	public void setDefaultValue (java.lang.String defaultValue) {
		this.defaultValue = defaultValue;
	}



	/**
	 * Return the value associated with the column: extra_text
	 */
	public java.lang.String getExtraText () {
		return extraText;
	}

	/**
	 * Set the value related to the column: extra_text
	 * @param extraText the extra_text value
	 */
	public void setExtraText (java.lang.String extraText) {
		this.extraText = extraText;
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



	/**
	 * Return the value associated with the column: dept_group_id
	 */
	public jkt.hms.masters.business.MasSpecialityDeptGroup getDeptGroup () {
		return deptGroup;
	}

	/**
	 * Set the value related to the column: dept_group_id
	 * @param deptGroup the dept_group_id value
	 */
	public void setDeptGroup (jkt.hms.masters.business.MasSpecialityDeptGroup deptGroup) {
		this.deptGroup = deptGroup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSpecialityDeptGroupValue)) return false;
		else {
			jkt.hms.masters.business.MasSpecialityDeptGroupValue masSpecialityDeptGroupValue = (jkt.hms.masters.business.MasSpecialityDeptGroupValue) obj;
			if (null == this.getId() || null == masSpecialityDeptGroupValue.getId()) return false;
			else return (this.getId().equals(masSpecialityDeptGroupValue.getId()));
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