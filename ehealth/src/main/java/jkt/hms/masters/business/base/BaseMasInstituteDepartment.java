package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_institute_department table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_institute_department"
 */

public abstract class BaseMasInstituteDepartment  implements Serializable {

	public static String REF = "MasInstituteDepartment";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_OPD_FREQUENCY = "OpdFrequency";
	public static String PROP_FREQUENCY_DAYS = "FrequencyDays";
	public static String PROP_ROOM_NO = "RoomNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ALTERNATIVE_NAME = "AlternativeName";
	public static String PROP_AVG_NO_OF_PATIENTS = "AvgNoOfPatients";
	public static String PROP_OPENING_TIME = "OpeningTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TOKEN_DISPLAY_IP = "TokenDisplayIp";
	public static String PROP_LATITUDE = "Latitude";
	public static String PROP_ID = "Id";
	public static String PROP_LONGITUDE = "Longitude";
	public static String PROP_CLOSING_TIME = "ClosingTime";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INSTITUTE = "Institute";


	// constructors
	public BaseMasInstituteDepartment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasInstituteDepartment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String alternativeName;
	private java.lang.String description;
	private java.util.Date lastChgDate;
	private java.lang.String status;
	private java.lang.String roomNo;
	private java.lang.String longitude;
	private java.lang.String latitude;
	private java.lang.String openingTime;
	private java.lang.String closingTime;
	private java.lang.String frequency;
	private java.lang.String frequencyDays;
	private java.lang.Integer avgNoOfPatients;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital institute;
	private jkt.hms.masters.business.TokenDisplayIp tokenDisplayIp;
	private jkt.hms.masters.business.MasOpdFrequency opdFrequency;

	// collections
	private java.util.Set<jkt.hms.masters.business.MultiDepartmentMapping> multiDepartmentMappings;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="inst_dept_id"
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
	 * Return the value associated with the column: alternative_name
	 */
	public java.lang.String getAlternativeName () {
		return alternativeName;
	}

	/**
	 * Set the value related to the column: alternative_name
	 * @param alternativeName the alternative_name value
	 */
	public void setAlternativeName (java.lang.String alternativeName) {
		this.alternativeName = alternativeName;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
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
	 * Return the value associated with the column: room_no
	 */
	public java.lang.String getRoomNo () {
		return roomNo;
	}

	/**
	 * Set the value related to the column: room_no
	 * @param roomNo the room_no value
	 */
	public void setRoomNo (java.lang.String roomNo) {
		this.roomNo = roomNo;
	}



	/**
	 * Return the value associated with the column: longitude
	 */
	public java.lang.String getLongitude () {
		return longitude;
	}

	/**
	 * Set the value related to the column: longitude
	 * @param longitude the longitude value
	 */
	public void setLongitude (java.lang.String longitude) {
		this.longitude = longitude;
	}



	/**
	 * Return the value associated with the column: latitude
	 */
	public java.lang.String getLatitude () {
		return latitude;
	}

	/**
	 * Set the value related to the column: latitude
	 * @param latitude the latitude value
	 */
	public void setLatitude (java.lang.String latitude) {
		this.latitude = latitude;
	}



	/**
	 * Return the value associated with the column: opening_time
	 */
	public java.lang.String getOpeningTime () {
		return openingTime;
	}

	/**
	 * Set the value related to the column: opening_time
	 * @param openingTime the opening_time value
	 */
	public void setOpeningTime (java.lang.String openingTime) {
		this.openingTime = openingTime;
	}



	/**
	 * Return the value associated with the column: closing_time
	 */
	public java.lang.String getClosingTime () {
		return closingTime;
	}

	/**
	 * Set the value related to the column: closing_time
	 * @param closingTime the closing_time value
	 */
	public void setClosingTime (java.lang.String closingTime) {
		this.closingTime = closingTime;
	}



	/**
	 * Return the value associated with the column: frequency
	 */
	public java.lang.String getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency
	 * @param frequency the frequency value
	 */
	public void setFrequency (java.lang.String frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: frequency_days
	 */
	public java.lang.String getFrequencyDays () {
		return frequencyDays;
	}

	/**
	 * Set the value related to the column: frequency_days
	 * @param frequencyDays the frequency_days value
	 */
	public void setFrequencyDays (java.lang.String frequencyDays) {
		this.frequencyDays = frequencyDays;
	}



	/**
	 * Return the value associated with the column: avg_no_of_patients
	 */
	public java.lang.Integer getAvgNoOfPatients () {
		return avgNoOfPatients;
	}

	/**
	 * Set the value related to the column: avg_no_of_patients
	 * @param avgNoOfPatients the avg_no_of_patients value
	 */
	public void setAvgNoOfPatients (java.lang.Integer avgNoOfPatients) {
		this.avgNoOfPatients = avgNoOfPatients;
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
	 * Return the value associated with the column: institute_id
	 */
	public jkt.hms.masters.business.MasHospital getInstitute () {
		return institute;
	}

	/**
	 * Set the value related to the column: institute_id
	 * @param institute the institute_id value
	 */
	public void setInstitute (jkt.hms.masters.business.MasHospital institute) {
		this.institute = institute;
	}



	/**
	 * Return the value associated with the column: token_display_ip_id
	 */
	public jkt.hms.masters.business.TokenDisplayIp getTokenDisplayIp () {
		return tokenDisplayIp;
	}

	/**
	 * Set the value related to the column: token_display_ip_id
	 * @param tokenDisplayIp the token_display_ip_id value
	 */
	public void setTokenDisplayIp (jkt.hms.masters.business.TokenDisplayIp tokenDisplayIp) {
		this.tokenDisplayIp = tokenDisplayIp;
	}



	/**
	 * Return the value associated with the column: opd_frequency_id
	 */
	public jkt.hms.masters.business.MasOpdFrequency getOpdFrequency () {
		return opdFrequency;
	}

	/**
	 * Set the value related to the column: opd_frequency_id
	 * @param opdFrequency the opd_frequency_id value
	 */
	public void setOpdFrequency (jkt.hms.masters.business.MasOpdFrequency opdFrequency) {
		this.opdFrequency = opdFrequency;
	}



	/**
	 * Return the value associated with the column: MultiDepartmentMappings
	 */
	public java.util.Set<jkt.hms.masters.business.MultiDepartmentMapping> getMultiDepartmentMappings () {
		return multiDepartmentMappings;
	}

	/**
	 * Set the value related to the column: MultiDepartmentMappings
	 * @param multiDepartmentMappings the MultiDepartmentMappings value
	 */
	public void setMultiDepartmentMappings (java.util.Set<jkt.hms.masters.business.MultiDepartmentMapping> multiDepartmentMappings) {
		this.multiDepartmentMappings = multiDepartmentMappings;
	}

	public void addToMultiDepartmentMappings (jkt.hms.masters.business.MultiDepartmentMapping multiDepartmentMapping) {
		if (null == getMultiDepartmentMappings()) setMultiDepartmentMappings(new java.util.TreeSet<jkt.hms.masters.business.MultiDepartmentMapping>());
		getMultiDepartmentMappings().add(multiDepartmentMapping);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasInstituteDepartment)) return false;
		else {
			jkt.hms.masters.business.MasInstituteDepartment masInstituteDepartment = (jkt.hms.masters.business.MasInstituteDepartment) obj;
			if (null == this.getId() || null == masInstituteDepartment.getId()) return false;
			else return (this.getId().equals(masInstituteDepartment.getId()));
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