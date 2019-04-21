package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_patient_sick_certificate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_patient_sick_certificate"
 */

public abstract class BaseHrPatientSickCertificate  implements Serializable {

	public static String REF = "HrPatientSickCertificate";
	public static String PROP_TITLE_ID = "TitleId";
	public static String PROP_DAYS_ABSENT = "DaysAbsent";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_EFFECT_FROM_DATE = "EffectFromDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_NAME = "Name";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EFFECT_TO_DATE = "EffectToDate";
	public static String PROP_DATE = "Date";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REG_NO = "RegNo";
	public static String PROP_SUFFER_FROM_DATE = "SufferFromDate";


	// constructors
	public BaseHrPatientSickCertificate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrPatientSickCertificate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrPatientSickCertificate (
		java.lang.Integer id,
		java.lang.String entryNo,
		java.util.Date date,
		java.lang.String regNo,
		java.lang.String name,
		java.lang.String sufferFromDate,
		java.util.Date effectFromDate,
		java.util.Date effectToDate) {

		this.setId(id);
		this.setEntryNo(entryNo);
		this.setDate(date);
		this.setRegNo(regNo);
		this.setName(name);
		this.setSufferFromDate(sufferFromDate);
		this.setEffectFromDate(effectFromDate);
		this.setEffectToDate(effectToDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date date;
	private java.lang.String regNo;
	private java.lang.String name;
	private java.lang.String sufferFromDate;
	private java.util.Date effectFromDate;
	private java.util.Date effectToDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer daysAbsent;

	// many to one
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasTitle titleId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="patient_sick_certificate_id"
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
	 * Return the value associated with the column: entryNo
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entryNo
	 * @param entryNo the entryNo value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: regNo
	 */
	public java.lang.String getRegNo () {
		return regNo;
	}

	/**
	 * Set the value related to the column: regNo
	 * @param regNo the regNo value
	 */
	public void setRegNo (java.lang.String regNo) {
		this.regNo = regNo;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: suffer_from
	 */
	public java.lang.String getSufferFromDate () {
		return sufferFromDate;
	}

	/**
	 * Set the value related to the column: suffer_from
	 * @param sufferFromDate the suffer_from value
	 */
	public void setSufferFromDate (java.lang.String sufferFromDate) {
		this.sufferFromDate = sufferFromDate;
	}



	/**
	 * Return the value associated with the column: effect_from_date
	 */
	public java.util.Date getEffectFromDate () {
		return effectFromDate;
	}

	/**
	 * Set the value related to the column: effect_from_date
	 * @param effectFromDate the effect_from_date value
	 */
	public void setEffectFromDate (java.util.Date effectFromDate) {
		this.effectFromDate = effectFromDate;
	}



	/**
	 * Return the value associated with the column: effect_to_date
	 */
	public java.util.Date getEffectToDate () {
		return effectToDate;
	}

	/**
	 * Set the value related to the column: effect_to_date
	 * @param effectToDate the effect_to_date value
	 */
	public void setEffectToDate (java.util.Date effectToDate) {
		this.effectToDate = effectToDate;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: days_absent
	 */
	public java.lang.Integer getDaysAbsent () {
		return daysAbsent;
	}

	/**
	 * Set the value related to the column: days_absent
	 * @param daysAbsent the days_absent value
	 */
	public void setDaysAbsent (java.lang.Integer daysAbsent) {
		this.daysAbsent = daysAbsent;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: title_id
	 */
	public jkt.hms.masters.business.MasTitle getTitleId () {
		return titleId;
	}

	/**
	 * Set the value related to the column: title_id
	 * @param titleId the title_id value
	 */
	public void setTitleId (jkt.hms.masters.business.MasTitle titleId) {
		this.titleId = titleId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrPatientSickCertificate)) return false;
		else {
			jkt.hms.masters.business.HrPatientSickCertificate hrPatientSickCertificate = (jkt.hms.masters.business.HrPatientSickCertificate) obj;
			if (null == this.getId() || null == hrPatientSickCertificate.getId()) return false;
			else return (this.getId().equals(hrPatientSickCertificate.getId()));
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