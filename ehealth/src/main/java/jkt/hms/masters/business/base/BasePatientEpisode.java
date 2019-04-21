package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_episode table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_episode"
 */

public abstract class BasePatientEpisode  implements Serializable {

	public static String REF = "PatientEpisode";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_EPISODE_DESC = "EpisodeDesc";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_EPISODE_NAME = "EpisodeName";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_EPISODE_NUMBER = "EpisodeNumber";


	// constructors
	public BasePatientEpisode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientEpisode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long episodeNumber;
	private java.lang.String hinNo;
	private java.lang.String episodeName;
	private java.lang.String episodeDesc;
	private java.util.Date startDate;
	private java.util.Date endDate;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="episode_id"
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
	 * Return the value associated with the column: episode_number
	 */
	public java.lang.Long getEpisodeNumber () {
		return episodeNumber;
	}

	/**
	 * Set the value related to the column: episode_number
	 * @param episodeNumber the episode_number value
	 */
	public void setEpisodeNumber (java.lang.Long episodeNumber) {
		this.episodeNumber = episodeNumber;
	}



	/**
	 * Return the value associated with the column: hin_no
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: hin_no
	 * @param hinNo the hin_no value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: episode_name
	 */
	public java.lang.String getEpisodeName () {
		return episodeName;
	}

	/**
	 * Set the value related to the column: episode_name
	 * @param episodeName the episode_name value
	 */
	public void setEpisodeName (java.lang.String episodeName) {
		this.episodeName = episodeName;
	}



	/**
	 * Return the value associated with the column: episode_desc
	 */
	public java.lang.String getEpisodeDesc () {
		return episodeDesc;
	}

	/**
	 * Set the value related to the column: episode_desc
	 * @param episodeDesc the episode_desc value
	 */
	public void setEpisodeDesc (java.lang.String episodeDesc) {
		this.episodeDesc = episodeDesc;
	}



	/**
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * @param startDate the start_date value
	 */
	public void setStartDate (java.util.Date startDate) {
		this.startDate = startDate;
	}



	/**
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientEpisode)) return false;
		else {
			jkt.hms.masters.business.PatientEpisode patientEpisode = (jkt.hms.masters.business.PatientEpisode) obj;
			if (null == this.getId() || null == patientEpisode.getId()) return false;
			else return (this.getId().equals(patientEpisode.getId()));
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