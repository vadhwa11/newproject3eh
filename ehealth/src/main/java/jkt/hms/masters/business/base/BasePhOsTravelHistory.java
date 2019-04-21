package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_os_travel_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_os_travel_history"
 */

public abstract class BasePhOsTravelHistory  implements Serializable {

	public static String REF = "PhOsTravelHistory";
	public static String PROP_DATE_OF_ARRIVAL = "DateOfArrival";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SERVER_PK = "ServerPk";
	public static String PROP_UNIQUE_ID = "UniqueId";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_DATE_OF_DEPARTURE = "DateOfDeparture";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_DISTRICT = "District";
	public static String PROP_ID = "Id";
	public static String PROP_UHID = "Uhid";
	public static String PROP_REMARK = "Remark";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePhOsTravelHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhOsTravelHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhOsTravelHistory (
		java.lang.Integer id,
		java.lang.Long memberId) {

		this.setId(id);
		this.setMemberId(memberId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long memberId;
	private java.lang.String uhid;
	private java.lang.String uniqueId;
	private java.util.Date dateOfDeparture;
	private java.util.Date dateOfArrival;
	private java.util.Date lastChgDate;
	private java.lang.String remark;
	private java.lang.String lastChgTime;
	private java.lang.Long serverPk;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasDistrict district;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="survey_id"
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
	 * Return the value associated with the column: member_id
	 */
	public java.lang.Long getMemberId () {
		return memberId;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param memberId the member_id value
	 */
	public void setMemberId (java.lang.Long memberId) {
		this.memberId = memberId;
	}



	/**
	 * Return the value associated with the column: uhid
	 */
	public java.lang.String getUhid () {
		return uhid;
	}

	/**
	 * Set the value related to the column: uhid
	 * @param uhid the uhid value
	 */
	public void setUhid (java.lang.String uhid) {
		this.uhid = uhid;
	}



	/**
	 * Return the value associated with the column: unique_id
	 */
	public java.lang.String getUniqueId () {
		return uniqueId;
	}

	/**
	 * Set the value related to the column: unique_id
	 * @param uniqueId the unique_id value
	 */
	public void setUniqueId (java.lang.String uniqueId) {
		this.uniqueId = uniqueId;
	}



	/**
	 * Return the value associated with the column: date_of_departure
	 */
	public java.util.Date getDateOfDeparture () {
		return dateOfDeparture;
	}

	/**
	 * Set the value related to the column: date_of_departure
	 * @param dateOfDeparture the date_of_departure value
	 */
	public void setDateOfDeparture (java.util.Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}



	/**
	 * Return the value associated with the column: date_of_arrival
	 */
	public java.util.Date getDateOfArrival () {
		return dateOfArrival;
	}

	/**
	 * Set the value related to the column: date_of_arrival
	 * @param dateOfArrival the date_of_arrival value
	 */
	public void setDateOfArrival (java.util.Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
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
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
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
	 * Return the value associated with the column: server_pk
	 */
	public java.lang.Long getServerPk () {
		return serverPk;
	}

	/**
	 * Set the value related to the column: server_pk
	 * @param serverPk the server_pk value
	 */
	public void setServerPk (java.lang.Long serverPk) {
		this.serverPk = serverPk;
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
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param state the state_id value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: country_id
	 */
	public jkt.hms.masters.business.MasCountry getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country_id
	 * @param country the country_id value
	 */
	public void setCountry (jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhOsTravelHistory)) return false;
		else {
			jkt.hms.masters.business.PhOsTravelHistory phOsTravelHistory = (jkt.hms.masters.business.PhOsTravelHistory) obj;
			if (null == this.getId() || null == phOsTravelHistory.getId()) return false;
			else return (this.getId().equals(phOsTravelHistory.getId()));
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