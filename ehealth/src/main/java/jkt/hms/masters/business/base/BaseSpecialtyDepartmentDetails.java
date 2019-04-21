package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the specialty_department_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="specialty_department_details"
 */

public abstract class BaseSpecialtyDepartmentDetails  implements Serializable {

	public static String REF = "SpecialtyDepartmentDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_TEXT_VALUE = "TextValue";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FIELD_VALUE = "FieldValue";
	public static String PROP_DEPT_GROUP = "DeptGroup";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_VALUE_ID = "ValueId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseSpecialtyDepartmentDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSpecialtyDepartmentDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String textValue;
	private java.lang.String fieldValue;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String valueId;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasSpecialityDeptGroup deptGroup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="dept_details_id"
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
	 * Return the value associated with the column: text_value
	 */
	public java.lang.String getTextValue () {
		return textValue;
	}

	/**
	 * Set the value related to the column: text_value
	 * @param textValue the text_value value
	 */
	public void setTextValue (java.lang.String textValue) {
		this.textValue = textValue;
	}



	/**
	 * Return the value associated with the column: field_value
	 */
	public java.lang.String getFieldValue () {
		return fieldValue;
	}

	/**
	 * Set the value related to the column: field_value
	 * @param fieldValue the field_value value
	 */
	public void setFieldValue (java.lang.String fieldValue) {
		this.fieldValue = fieldValue;
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
	 * Return the value associated with the column: value_id
	 */
	public java.lang.String getValueId () {
		return valueId;
	}

	/**
	 * Set the value related to the column: value_id
	 * @param valueId the value_id value
	 */
	public void setValueId (java.lang.String valueId) {
		this.valueId = valueId;
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
		if (!(obj instanceof jkt.hms.masters.business.SpecialtyDepartmentDetails)) return false;
		else {
			jkt.hms.masters.business.SpecialtyDepartmentDetails specialtyDepartmentDetails = (jkt.hms.masters.business.SpecialtyDepartmentDetails) obj;
			if (null == this.getId() || null == specialtyDepartmentDetails.getId()) return false;
			else return (this.getId().equals(specialtyDepartmentDetails.getId()));
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