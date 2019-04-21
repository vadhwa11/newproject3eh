package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lr_urine_analysis table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lr_urine_analysis"
 */

public abstract class BaseLrUrineAnalysis  implements Serializable {

	public static String REF = "LrUrineAnalysis";
	public static String PROP_LABOR_ROOM_TYPE = "LaborRoomType";
	public static String PROP_VOLUME = "Volume";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_GLUCOSE = "Glucose";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ALBUMIN = "Albumin";
	public static String PROP_URINE_ANALYSIS_TIME = "UrineAnalysisTime";
	public static String PROP_ID = "Id";
	public static String PROP_ACETONE = "Acetone";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_URINE_ANALYSIS_DATE = "UrineAnalysisDate";


	// constructors
	public BaseLrUrineAnalysis () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLrUrineAnalysis (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date urineAnalysisDate;
	private java.lang.String urineAnalysisTime;
	private java.lang.String volume;
	private java.lang.String albumin;
	private java.lang.String acetone;
	private java.lang.String glucose;
	private java.lang.Integer laborRoomType;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="lr_urine_analysis_id"
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
	 * Return the value associated with the column: urine_analysis_date
	 */
	public java.util.Date getUrineAnalysisDate () {
		return urineAnalysisDate;
	}

	/**
	 * Set the value related to the column: urine_analysis_date
	 * @param urineAnalysisDate the urine_analysis_date value
	 */
	public void setUrineAnalysisDate (java.util.Date urineAnalysisDate) {
		this.urineAnalysisDate = urineAnalysisDate;
	}



	/**
	 * Return the value associated with the column: urine_analysis_time
	 */
	public java.lang.String getUrineAnalysisTime () {
		return urineAnalysisTime;
	}

	/**
	 * Set the value related to the column: urine_analysis_time
	 * @param urineAnalysisTime the urine_analysis_time value
	 */
	public void setUrineAnalysisTime (java.lang.String urineAnalysisTime) {
		this.urineAnalysisTime = urineAnalysisTime;
	}



	/**
	 * Return the value associated with the column: volume
	 */
	public java.lang.String getVolume () {
		return volume;
	}

	/**
	 * Set the value related to the column: volume
	 * @param volume the volume value
	 */
	public void setVolume (java.lang.String volume) {
		this.volume = volume;
	}



	/**
	 * Return the value associated with the column: albumin
	 */
	public java.lang.String getAlbumin () {
		return albumin;
	}

	/**
	 * Set the value related to the column: albumin
	 * @param albumin the albumin value
	 */
	public void setAlbumin (java.lang.String albumin) {
		this.albumin = albumin;
	}



	/**
	 * Return the value associated with the column: acetone
	 */
	public java.lang.String getAcetone () {
		return acetone;
	}

	/**
	 * Set the value related to the column: acetone
	 * @param acetone the acetone value
	 */
	public void setAcetone (java.lang.String acetone) {
		this.acetone = acetone;
	}



	/**
	 * Return the value associated with the column: glucose
	 */
	public java.lang.String getGlucose () {
		return glucose;
	}

	/**
	 * Set the value related to the column: glucose
	 * @param glucose the glucose value
	 */
	public void setGlucose (java.lang.String glucose) {
		this.glucose = glucose;
	}



	/**
	 * Return the value associated with the column: labor_room_type
	 */
	public java.lang.Integer getLaborRoomType () {
		return laborRoomType;
	}

	/**
	 * Set the value related to the column: labor_room_type
	 * @param laborRoomType the labor_room_type value
	 */
	public void setLaborRoomType (java.lang.Integer laborRoomType) {
		this.laborRoomType = laborRoomType;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.LrUrineAnalysis)) return false;
		else {
			jkt.hms.masters.business.LrUrineAnalysis lrUrineAnalysis = (jkt.hms.masters.business.LrUrineAnalysis) obj;
			if (null == this.getId() || null == lrUrineAnalysis.getId()) return false;
			else return (this.getId().equals(lrUrineAnalysis.getId()));
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