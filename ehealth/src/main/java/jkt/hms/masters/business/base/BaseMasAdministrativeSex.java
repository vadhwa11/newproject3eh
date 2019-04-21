package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_administrative_sex table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_administrative_sex"
 */

public abstract class BaseMasAdministrativeSex  implements Serializable {

	public static String REF = "MasAdministrativeSex";
	public static String PROP_ADMINISTRATIVE_SEX_CODE = "AdministrativeSexCode";
	public static String PROP_ADMINISTRATIVE_SEX_NAME = "AdministrativeSexName";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasAdministrativeSex () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAdministrativeSex (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String administrativeSexCode;
	private java.lang.String administrativeSexName;
	private java.lang.String status;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set birthdeathregs;
	private java.util.Set patients;
	private java.util.Set attachInpatients;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="administrative_sex_id"
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
	 * Return the value associated with the column: administrative_sex_code
	 */
	public java.lang.String getAdministrativeSexCode () {
		return administrativeSexCode;
	}

	/**
	 * Set the value related to the column: administrative_sex_code
	 * @param administrativeSexCode the administrative_sex_code value
	 */
	public void setAdministrativeSexCode (java.lang.String administrativeSexCode) {
		this.administrativeSexCode = administrativeSexCode;
	}



	/**
	 * Return the value associated with the column: administrative_sex_name
	 */
	public java.lang.String getAdministrativeSexName () {
		return administrativeSexName;
	}

	/**
	 * Set the value related to the column: administrative_sex_name
	 * @param administrativeSexName the administrative_sex_name value
	 */
	public void setAdministrativeSexName (java.lang.String administrativeSexName) {
		this.administrativeSexName = administrativeSexName;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
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
	 * Return the value associated with the column: Birthdeathregs
	 */
	public java.util.Set getBirthdeathregs () {
		return birthdeathregs;
	}

	/**
	 * Set the value related to the column: Birthdeathregs
	 * @param birthdeathregs the Birthdeathregs value
	 */
	public void setBirthdeathregs (java.util.Set birthdeathregs) {
		this.birthdeathregs = birthdeathregs;
	}

	public void addToBirthdeathregs (jkt.hms.masters.business.Birthdeathreg birthdeathreg) {
		if (null == getBirthdeathregs()) setBirthdeathregs(new java.util.HashSet());
		getBirthdeathregs().add(birthdeathreg);
	}



	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.HashSet());
		getPatients().add(patient);
	}



	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set getAttachInpatients () {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * @param attachInpatients the AttachInpatients value
	 */
	public void setAttachInpatients (java.util.Set attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients (jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients()) setAttachInpatients(new java.util.HashSet());
		getAttachInpatients().add(attachInpatient);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAdministrativeSex)) return false;
		else {
			jkt.hms.masters.business.MasAdministrativeSex masAdministrativeSex = (jkt.hms.masters.business.MasAdministrativeSex) obj;
			if (null == this.getId() || null == masAdministrativeSex.getId()) return false;
			else return (this.getId().equals(masAdministrativeSex.getId()));
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