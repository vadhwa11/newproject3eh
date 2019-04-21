package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_employee_sub_caste table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_employee_sub_caste"
 */

public abstract class BaseMasEmployeeSubCaste  implements Serializable {

	public static String REF = "MasEmployeeSubCaste";
	public static String PROP_STATUS = "Status";
	public static String PROP_SUB_CASTE_NAME = "SubCasteName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CASTE_ID = "CasteId";
	public static String PROP_SUB_CASTE_CODE = "SubCasteCode";


	// constructors
	public BaseMasEmployeeSubCaste () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmployeeSubCaste (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subCasteCode;
	private java.lang.String subCasteName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployeeCaste casteId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="sub_caste_id"
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
	 * Return the value associated with the column: sub_caste_code
	 */
	public java.lang.String getSubCasteCode () {
		return subCasteCode;
	}

	/**
	 * Set the value related to the column: sub_caste_code
	 * @param subCasteCode the sub_caste_code value
	 */
	public void setSubCasteCode (java.lang.String subCasteCode) {
		this.subCasteCode = subCasteCode;
	}



	/**
	 * Return the value associated with the column: sub_caste_name
	 */
	public java.lang.String getSubCasteName () {
		return subCasteName;
	}

	/**
	 * Set the value related to the column: sub_caste_name
	 * @param subCasteName the sub_caste_name value
	 */
	public void setSubCasteName (java.lang.String subCasteName) {
		this.subCasteName = subCasteName;
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
	 * Return the value associated with the column: caste_id
	 */
	public jkt.hms.masters.business.MasEmployeeCaste getCasteId () {
		return casteId;
	}

	/**
	 * Set the value related to the column: caste_id
	 * @param casteId the caste_id value
	 */
	public void setCasteId (jkt.hms.masters.business.MasEmployeeCaste casteId) {
		this.casteId = casteId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasEmployeeSubCaste)) return false;
		else {
			jkt.hms.masters.business.MasEmployeeSubCaste masEmployeeSubCaste = (jkt.hms.masters.business.MasEmployeeSubCaste) obj;
			if (null == this.getId() || null == masEmployeeSubCaste.getId()) return false;
			else return (this.getId().equals(masEmployeeSubCaste.getId()));
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