package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_training_service table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_training_service"
 */

public abstract class BaseHrTrainingService  implements Serializable {

	public static String REF = "HrTrainingService";
	public static String PROP_TITLE_ID = "TitleId";
	public static String PROP_AGE = "Age";
	public static String PROP_CASE_NO = "CaseNo";
	public static String PROP_TYPE = "Type";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_ENTRY_NUMBER = "EntryNumber";
	public static String PROP_NAME = "Name";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE = "Date";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DOCTOR = "Doctor";


	// constructors
	public BaseHrTrainingService () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrTrainingService (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrTrainingService (
		java.lang.Integer id,
		java.lang.String entryNumber,
		java.util.Date date,
		java.lang.String name) {

		this.setId(id);
		this.setEntryNumber(entryNumber);
		this.setDate(date);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNumber;
	private java.util.Date date;
	private java.lang.String name;
	private java.lang.Integer age;
	private java.lang.String village;
	private java.lang.String type;
	private java.lang.String caseNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasTitle titleId;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="training_service_id"
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
	 * Return the value associated with the column: entry_number
	 */
	public java.lang.String getEntryNumber () {
		return entryNumber;
	}

	/**
	 * Set the value related to the column: entry_number
	 * @param entryNumber the entry_number value
	 */
	public void setEntryNumber (java.lang.String entryNumber) {
		this.entryNumber = entryNumber;
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
	 * Return the value associated with the column: Name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: Name
	 * @param name the Name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: Age
	 */
	public java.lang.Integer getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: Age
	 * @param age the Age value
	 */
	public void setAge (java.lang.Integer age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: village
	 */
	public java.lang.String getVillage () {
		return village;
	}

	/**
	 * Set the value related to the column: village
	 * @param village the village value
	 */
	public void setVillage (java.lang.String village) {
		this.village = village;
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
	 * Return the value associated with the column: case_no
	 */
	public java.lang.String getCaseNo () {
		return caseNo;
	}

	/**
	 * Set the value related to the column: case_no
	 * @param caseNo the case_no value
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
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroup the blood_group_id value
	 */
	public void setBloodGroup (jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrTrainingService)) return false;
		else {
			jkt.hms.masters.business.HrTrainingService hrTrainingService = (jkt.hms.masters.business.HrTrainingService) obj;
			if (null == this.getId() || null == hrTrainingService.getId()) return false;
			else return (this.getId().equals(hrTrainingService.getId()));
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