package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_survey_target_status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_survey_target_status"
 */

public abstract class BaseMasSurveyTargetStatus  implements Serializable {

	public static String REF = "MasSurveyTargetStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_TARGET = "Target";
	public static String PROP_CREATED_TIME = "CreatedTime";
	public static String PROP_VARIFIED_BY = "VarifiedBy";
	public static String PROP_CREATED_DATE = "CreatedDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_INSTITUTION_TYPE_ID = "InstitutionTypeId";

	// constructors
	public BaseMasSurveyTargetStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSurveyTargetStatus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.lang.String varifiedBy;
	private java.util.Date createdDate;
	private java.lang.String createdTime;
	private java.lang.Integer institutionTypeId;
	// many to one
	private jkt.hms.masters.business.MasSurveyTarget target;
	private jkt.hms.masters.business.Users lastChangeBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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

	

	public java.lang.Integer getInstitutionTypeId() {
		return institutionTypeId;
	}

	public void setInstitutionTypeId(java.lang.Integer institutionTypeId) {
		this.institutionTypeId = institutionTypeId;
	}

	/**
	 * Return the value associated with the column: varified_by
	 */
	public java.lang.String getVarifiedBy () {
		return varifiedBy;
	}

	/**
	 * Set the value related to the column: varified_by
	 * @param varifiedBy the varified_by value
	 */
	public void setVarifiedBy (java.lang.String varifiedBy) {
		this.varifiedBy = varifiedBy;
	}



	/**
	 * Return the value associated with the column: created_date
	 */
	public java.util.Date getCreatedDate () {
		return createdDate;
	}

	/**
	 * Set the value related to the column: created_date
	 * @param createdDate the created_date value
	 */
	public void setCreatedDate (java.util.Date createdDate) {
		this.createdDate = createdDate;
	}



	/**
	 * Return the value associated with the column: created_time
	 */
	public java.lang.String getCreatedTime () {
		return createdTime;
	}

	/**
	 * Set the value related to the column: created_time
	 * @param createdTime the created_time value
	 */
	public void setCreatedTime (java.lang.String createdTime) {
		this.createdTime = createdTime;
	}



	/**
	 * Return the value associated with the column: target_id
	 */
	public jkt.hms.masters.business.MasSurveyTarget getTarget () {
		return target;
	}

	/**
	 * Set the value related to the column: target_id
	 * @param target the target_id value
	 */
	public void setTarget (jkt.hms.masters.business.MasSurveyTarget target) {
		this.target = target;
	}



	/**
	 * Return the value associated with the column: last_change_by
	 */
	public jkt.hms.masters.business.Users getLastChangeBy () {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: last_change_by
	 * @param lastChangeBy the last_change_by value
	 */
	public void setLastChangeBy (jkt.hms.masters.business.Users lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSurveyTargetStatus)) return false;
		else {
			jkt.hms.masters.business.MasSurveyTargetStatus masSurveyTargetStatus = (jkt.hms.masters.business.MasSurveyTargetStatus) obj;
			if (null == this.getId() || null == masSurveyTargetStatus.getId()) return false;
			else return (this.getId().equals(masSurveyTargetStatus.getId()));
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