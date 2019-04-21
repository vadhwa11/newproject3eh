package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_hospital_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_hospital_type"
 */

public abstract class BaseMasHospitalType  implements Serializable {

	public static String REF = "MasHospitalType";
	public static String PROP_STATUS = "Status";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_TYPE_NAME = "HospitalTypeName";
	public static String PROP_HOSPITAL_TYPE_CODE = "HospitalTypeCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_Institute_Type_Short_Name = "InstituteTypeShortName";
	public static String PROP_Institute_Ph = "InstitutePh";

	// constructors
	public BaseMasHospitalType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasHospitalType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasHospitalType (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;
	private java.lang.String hospitalTypeCode;
	private java.lang.String hospitalTypeName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String instituteTypeShortName;
	private java.lang.String InstitutePh;

	



	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="hospital_type_id"
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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: hospital_type_code
	 */
	public java.lang.String getHospitalTypeCode () {
		return hospitalTypeCode;
	}

	/**
	 * Set the value related to the column: hospital_type_code
	 * @param hospitalTypeCode the hospital_type_code value
	 */
	public void setHospitalTypeCode (java.lang.String hospitalTypeCode) {
		this.hospitalTypeCode = hospitalTypeCode;
	}



	/**
	 * Return the value associated with the column: hospital_type_name
	 */
	public java.lang.String getHospitalTypeName () {
		return hospitalTypeName;
	}

	/**
	 * Set the value related to the column: hospital_type_name
	 * @param hospitalTypeName the hospital_type_name value
	 */
	public void setHospitalTypeName (java.lang.String hospitalTypeName) {
		this.hospitalTypeName = hospitalTypeName;
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



	public java.lang.String getInstituteTypeShortName() {
		return instituteTypeShortName;
	}

	public void setInstituteTypeShortName(java.lang.String instituteTypeShortName) {
		this.instituteTypeShortName = instituteTypeShortName;
	}

	public java.lang.String getInstitutePh() {
		return InstitutePh;
	}

	public void setInstitutePh(java.lang.String institutePh) {
		InstitutePh = institutePh;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasHospitalType)) return false;
		else {
			jkt.hms.masters.business.MasHospitalType masHospitalType = (jkt.hms.masters.business.MasHospitalType) obj;
			if (null == this.getId() || null == masHospitalType.getId()) return false;
			else return (this.getId().equals(masHospitalType.getId()));
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