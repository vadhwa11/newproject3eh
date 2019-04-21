package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_specialty_department table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_specialty_department"
 */

public abstract class BaseMasSpecialtyDepartment  implements Serializable {

	public static String REF = "MasSpecialtyDepartment";
	public static String PROP_STATUS = "Status";
	public static String PROP_VALUE = "Value";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_PARAMETER = "Parameter";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TEXT_FIELD = "TextField";


	// constructors
	public BaseMasSpecialtyDepartment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSpecialtyDepartment (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasSpecialtyDepartment (
		java.lang.Long id,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String textField;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasSpecialityDeptGroupValue value;
	private jkt.hms.masters.business.MasSpecialityDeptGroup parameter;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="dept_speciality"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: text_field
	 */
	public java.lang.String getTextField () {
		return textField;
	}

	/**
	 * Set the value related to the column: text_field
	 * @param textField the text_field value
	 */
	public void setTextField (java.lang.String textField) {
		this.textField = textField;
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



	/**
	 * Return the value associated with the column: value
	 */
	public jkt.hms.masters.business.MasSpecialityDeptGroupValue getValue () {
		return value;
	}

	/**
	 * Set the value related to the column: value
	 * @param value the value value
	 */
	public void setValue (jkt.hms.masters.business.MasSpecialityDeptGroupValue value) {
		this.value = value;
	}



	/**
	 * Return the value associated with the column: parameter_id
	 */
	public jkt.hms.masters.business.MasSpecialityDeptGroup getParameter () {
		return parameter;
	}

	/**
	 * Set the value related to the column: parameter_id
	 * @param parameter the parameter_id value
	 */
	public void setParameter (jkt.hms.masters.business.MasSpecialityDeptGroup parameter) {
		this.parameter = parameter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSpecialtyDepartment)) return false;
		else {
			jkt.hms.masters.business.MasSpecialtyDepartment masSpecialtyDepartment = (jkt.hms.masters.business.MasSpecialtyDepartment) obj;
			if (null == this.getId() || null == masSpecialtyDepartment.getId()) return false;
			else return (this.getId().equals(masSpecialtyDepartment.getId()));
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