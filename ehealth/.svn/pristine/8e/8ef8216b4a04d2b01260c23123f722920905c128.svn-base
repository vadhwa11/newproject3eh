package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_ward table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_ward"
 */

public abstract class BaseMasWard  implements Serializable {

	public static String REF = "MasWard";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LSG = "Lsg";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_WARD_CODE = "WardCode";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_WARD_NAME = "WardName";
	public static String PROP_SUB_CENTER = "SubCenter";
	public static String PROP_ID = "Id";
	public static String PROP_WARD_NO = "WardNo";
	public static String PROP_DISTRICT = "District";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseMasWard () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasWard (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String wardCode;
	private java.lang.String wardName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Long wardNo;

	// many to one
	private jkt.hms.masters.business.MasVillage village;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasLsg lsg;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasHospital subCenter;

	// collections
	private java.util.Set<jkt.hms.masters.business.PatientAddress> patientAddress;
	private java.util.Set<jkt.hms.masters.business.MasHospital> masHospitals;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ward_id"
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
	 * Return the value associated with the column: ward_code
	 */
	public java.lang.String getWardCode () {
		return wardCode;
	}

	/**
	 * Set the value related to the column: ward_code
	 * @param wardCode the ward_code value
	 */
	public void setWardCode (java.lang.String wardCode) {
		this.wardCode = wardCode;
	}



	/**
	 * Return the value associated with the column: ward_name
	 */
	public java.lang.String getWardName () {
		return wardName;
	}

	/**
	 * Set the value related to the column: ward_name
	 * @param wardName the ward_name value
	 */
	public void setWardName (java.lang.String wardName) {
		this.wardName = wardName;
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
	 * Return the value associated with the column: ward_no
	 */
	public java.lang.Long getWardNo () {
		return wardNo;
	}

	/**
	 * Set the value related to the column: ward_no
	 * @param wardNo the ward_no value
	 */
	public void setWardNo (java.lang.Long wardNo) {
		this.wardNo = wardNo;
	}



	/**
	 * Return the value associated with the column: village_id
	 */
	public jkt.hms.masters.business.MasVillage getVillage () {
		return village;
	}

	/**
	 * Set the value related to the column: village_id
	 * @param village the village_id value
	 */
	public void setVillage (jkt.hms.masters.business.MasVillage village) {
		this.village = village;
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
	 * Return the value associated with the column: lsg_id
	 */
	public jkt.hms.masters.business.MasLsg getLsg () {
		return lsg;
	}

	/**
	 * Set the value related to the column: lsg_id
	 * @param lsg the lsg_id value
	 */
	public void setLsg (jkt.hms.masters.business.MasLsg lsg) {
		this.lsg = lsg;
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



	/**
	 * Return the value associated with the column: sub_center_id
	 */
	public jkt.hms.masters.business.MasHospital getSubCenter () {
		return subCenter;
	}

	/**
	 * Set the value related to the column: sub_center_id
	 * @param subCenter the sub_center_id value
	 */
	public void setSubCenter (jkt.hms.masters.business.MasHospital subCenter) {
		this.subCenter = subCenter;
	}



	/**
	 * Return the value associated with the column: PatientAddress
	 */
	public java.util.Set<jkt.hms.masters.business.PatientAddress> getPatientAddress () {
		return patientAddress;
	}

	/**
	 * Set the value related to the column: PatientAddress
	 * @param patientAddress the PatientAddress value
	 */
	public void setPatientAddress (java.util.Set<jkt.hms.masters.business.PatientAddress> patientAddress) {
		this.patientAddress = patientAddress;
	}

	public void addToPatientAddress (jkt.hms.masters.business.PatientAddress patientAddress) {
		if (null == getPatientAddress()) setPatientAddress(new java.util.TreeSet<jkt.hms.masters.business.PatientAddress>());
		getPatientAddress().add(patientAddress);
	}



	/**
	 * Return the value associated with the column: MasHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.MasHospital> getMasHospitals () {
		return masHospitals;
	}

	/**
	 * Set the value related to the column: MasHospitals
	 * @param masHospitals the MasHospitals value
	 */
	public void setMasHospitals (java.util.Set<jkt.hms.masters.business.MasHospital> masHospitals) {
		this.masHospitals = masHospitals;
	}

	public void addToMasHospitals (jkt.hms.masters.business.MasHospital masHospital) {
		if (null == getMasHospitals()) setMasHospitals(new java.util.TreeSet<jkt.hms.masters.business.MasHospital>());
		getMasHospitals().add(masHospital);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasWard)) return false;
		else {
			jkt.hms.masters.business.MasWard masWard = (jkt.hms.masters.business.MasWard) obj;
			if (null == this.getId() || null == masWard.getId()) return false;
			else return (this.getId().equals(masWard.getId()));
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