package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_medical_fitness_first table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_medical_fitness_first"
 */

public abstract class BaseHrMedicalFitnessFirst  implements Serializable {

	public static String REF = "HrMedicalFitnessFirst";
	public static String PROP_FOR_EMPLOY_IN_OFFICE = "ForEmployInOffice";
	public static String PROP_NAME = "Name";
	public static String PROP_TITLE_ID = "TitleId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE = "Date";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CONST_WEAKNESS = "ConstWeakness";
	public static String PROP_REG_NO = "RegNo";


	// constructors
	public BaseHrMedicalFitnessFirst () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMedicalFitnessFirst (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrMedicalFitnessFirst (
		java.lang.Integer id,
		java.lang.String entryNo,
		java.util.Date date,
		java.lang.String regNo,
		java.lang.String name,
		java.lang.String forEmployInOffice) {

		this.setId(id);
		this.setEntryNo(entryNo);
		this.setDate(date);
		this.setRegNo(regNo);
		this.setName(name);
		this.setForEmployInOffice(forEmployInOffice);
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
	private java.lang.String constWeakness;
	private java.lang.String forEmployInOffice;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasTitle titleId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="medical_fitness_first_id"
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
	 * Return the value associated with the column: const_weakness
	 */
	public java.lang.String getConstWeakness () {
		return constWeakness;
	}

	/**
	 * Set the value related to the column: const_weakness
	 * @param constWeakness the const_weakness value
	 */
	public void setConstWeakness (java.lang.String constWeakness) {
		this.constWeakness = constWeakness;
	}



	/**
	 * Return the value associated with the column: for_employ_in_office
	 */
	public java.lang.String getForEmployInOffice () {
		return forEmployInOffice;
	}

	/**
	 * Set the value related to the column: for_employ_in_office
	 * @param forEmployInOffice the for_employ_in_office value
	 */
	public void setForEmployInOffice (java.lang.String forEmployInOffice) {
		this.forEmployInOffice = forEmployInOffice;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMedicalFitnessFirst)) return false;
		else {
			jkt.hms.masters.business.HrMedicalFitnessFirst hrMedicalFitnessFirst = (jkt.hms.masters.business.HrMedicalFitnessFirst) obj;
			if (null == this.getId() || null == hrMedicalFitnessFirst.getId()) return false;
			else return (this.getId().equals(hrMedicalFitnessFirst.getId()));
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