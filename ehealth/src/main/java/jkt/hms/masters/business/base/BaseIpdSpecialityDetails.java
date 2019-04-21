package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_speciality_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_speciality_details"
 */

public abstract class BaseIpdSpecialityDetails  implements Serializable {

	public static String REF = "IpdSpecialityDetails";
	public static String PROP_STUDENT = "Student";
	public static String PROP_SP_TEMPLATE = "SpTemplate";
	public static String PROP_SP_VALUES2 = "SpValues2";
	public static String PROP_SP_GROUP = "SpGroup";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SP_VALUES = "SpValues";
	public static String PROP_SP_PARAMETER = "SpParameter";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseIpdSpecialityDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdSpecialityDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String spValues;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String spValues2;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasSpecialtyTemplate spTemplate;
	private jkt.hms.masters.business.MasActionTaken actionTaken;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.PhStudentRegistration student;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasSpecialityGroup spGroup;
	private jkt.hms.masters.business.MasSpecialityParameter spParameter;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ipd_speciality_details_id"
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
	 * Return the value associated with the column: sp_values
	 */
	public java.lang.String getSpValues () {
		return spValues;
	}

	/**
	 * Set the value related to the column: sp_values
	 * @param spValues the sp_values value
	 */
	public void setSpValues (java.lang.String spValues) {
		this.spValues = spValues;
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
	 * Return the value associated with the column: sp_values2
	 */
	public java.lang.String getSpValues2 () {
		return spValues2;
	}

	/**
	 * Set the value related to the column: sp_values2
	 * @param spValues2 the sp_values2 value
	 */
	public void setSpValues2 (java.lang.String spValues2) {
		this.spValues2 = spValues2;
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
	 * Return the value associated with the column: sp_template_id
	 */
	public jkt.hms.masters.business.MasSpecialtyTemplate getSpTemplate () {
		return spTemplate;
	}

	/**
	 * Set the value related to the column: sp_template_id
	 * @param spTemplate the sp_template_id value
	 */
	public void setSpTemplate (jkt.hms.masters.business.MasSpecialtyTemplate spTemplate) {
		this.spTemplate = spTemplate;
	}



	/**
	 * Return the value associated with the column: action_taken_id
	 */
	public jkt.hms.masters.business.MasActionTaken getActionTaken () {
		return actionTaken;
	}

	/**
	 * Set the value related to the column: action_taken_id
	 * @param actionTaken the action_taken_id value
	 */
	public void setActionTaken (jkt.hms.masters.business.MasActionTaken actionTaken) {
		this.actionTaken = actionTaken;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: student_id
	 */
	public jkt.hms.masters.business.PhStudentRegistration getStudent () {
		return student;
	}

	/**
	 * Set the value related to the column: student_id
	 * @param student the student_id value
	 */
	public void setStudent (jkt.hms.masters.business.PhStudentRegistration student) {
		this.student = student;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: sp_group_id
	 */
	public jkt.hms.masters.business.MasSpecialityGroup getSpGroup () {
		return spGroup;
	}

	/**
	 * Set the value related to the column: sp_group_id
	 * @param spGroup the sp_group_id value
	 */
	public void setSpGroup (jkt.hms.masters.business.MasSpecialityGroup spGroup) {
		this.spGroup = spGroup;
	}



	/**
	 * Return the value associated with the column: sp_parameter_id
	 */
	public jkt.hms.masters.business.MasSpecialityParameter getSpParameter () {
		return spParameter;
	}

	/**
	 * Set the value related to the column: sp_parameter_id
	 * @param spParameter the sp_parameter_id value
	 */
	public void setSpParameter (jkt.hms.masters.business.MasSpecialityParameter spParameter) {
		this.spParameter = spParameter;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdSpecialityDetails)) return false;
		else {
			jkt.hms.masters.business.IpdSpecialityDetails ipdSpecialityDetails = (jkt.hms.masters.business.IpdSpecialityDetails) obj;
			if (null == this.getId() || null == ipdSpecialityDetails.getId()) return false;
			else return (this.getId().equals(ipdSpecialityDetails.getId()));
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