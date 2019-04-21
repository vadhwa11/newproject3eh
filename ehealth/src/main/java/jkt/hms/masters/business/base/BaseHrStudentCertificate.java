package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_student_certificate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_student_certificate"
 */

public abstract class BaseHrStudentCertificate  implements Serializable {

	public static String REF = "HrStudentCertificate";
	public static String PROP_TITLE_ID = "TitleId";
	public static String PROP_AGE = "Age";
	public static String PROP_CASE_NO = "CaseNo";
	public static String PROP_FIT_FOR = "FitFor";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_NAME = "Name";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE = "Date";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_RESIDENCE = "Residence";
	public static String PROP_DOCTOR = "Doctor";


	// constructors
	public BaseHrStudentCertificate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrStudentCertificate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrStudentCertificate (
		java.lang.Integer id,
		java.lang.String entryNo,
		java.util.Date date,
		java.lang.String name,
		java.lang.Integer age,
		java.lang.String fitFor,
		java.lang.String caseNo) {

		this.setId(id);
		this.setEntryNo(entryNo);
		this.setDate(date);
		this.setName(name);
		this.setAge(age);
		this.setFitFor(fitFor);
		this.setCaseNo(caseNo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date date;
	private java.lang.String name;
	private java.lang.Integer age;
	private java.lang.String residence;
	private java.lang.String fitFor;
	private java.lang.String caseNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasTitle titleId;
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasEmployee doctor;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="student_certificate_id"
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
	 * Return the value associated with the column: age
	 */
	public java.lang.Integer getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.Integer age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: residence
	 */
	public java.lang.String getResidence () {
		return residence;
	}

	/**
	 * Set the value related to the column: residence
	 * @param residence the residence value
	 */
	public void setResidence (java.lang.String residence) {
		this.residence = residence;
	}



	/**
	 * Return the value associated with the column: fitFor
	 */
	public java.lang.String getFitFor () {
		return fitFor;
	}

	/**
	 * Set the value related to the column: fitFor
	 * @param fitFor the fitFor value
	 */
	public void setFitFor (java.lang.String fitFor) {
		this.fitFor = fitFor;
	}



	/**
	 * Return the value associated with the column: caseNo
	 */
	public java.lang.String getCaseNo () {
		return caseNo;
	}

	/**
	 * Set the value related to the column: caseNo
	 * @param caseNo the caseNo value
	 */
	public void setCaseNo (java.lang.String caseNo) {
		this.caseNo = caseNo;
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
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrStudentCertificate)) return false;
		else {
			jkt.hms.masters.business.HrStudentCertificate hrStudentCertificate = (jkt.hms.masters.business.HrStudentCertificate) obj;
			if (null == this.getId() || null == hrStudentCertificate.getId()) return false;
			else return (this.getId().equals(hrStudentCertificate.getId()));
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