package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_district table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_district"
 */

public abstract class BaseMasDistrict  implements Serializable {

	public static String REF = "MasDistrict";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DISTRICT_NAME = "DistrictName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DISTRICT_CODE = "DistrictCode";


	// constructors
	public BaseMasDistrict () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDistrict (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String districtCode;
	private java.lang.String districtName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasState state;

	// collections
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.MasManufacturer> masManufacturers;
	private java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliersByLocalCity;
	private java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliersByCity;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="district_id"
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
	 * Return the value associated with the column: district_code
	 */
	public java.lang.String getDistrictCode () {
		return districtCode;
	}

	/**
	 * Set the value related to the column: district_code
	 * @param districtCode the district_code value
	 */
	public void setDistrictCode (java.lang.String districtCode) {
		this.districtCode = districtCode;
	}



	/**
	 * Return the value associated with the column: district_name
	 */
	public java.lang.String getDistrictName () {
		return districtName;
	}

	/**
	 * Set the value related to the column: district_name
	 * @param districtName the district_name value
	 */
	public void setDistrictName (java.lang.String districtName) {
		this.districtName = districtName;
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
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}



	/**
	 * Return the value associated with the column: MasManufacturers
	 */
	public java.util.Set<jkt.hms.masters.business.MasManufacturer> getMasManufacturers () {
		return masManufacturers;
	}

	/**
	 * Set the value related to the column: MasManufacturers
	 * @param masManufacturers the MasManufacturers value
	 */
	public void setMasManufacturers (java.util.Set<jkt.hms.masters.business.MasManufacturer> masManufacturers) {
		this.masManufacturers = masManufacturers;
	}

	public void addToMasManufacturers (jkt.hms.masters.business.MasManufacturer masManufacturer) {
		if (null == getMasManufacturers()) setMasManufacturers(new java.util.TreeSet<jkt.hms.masters.business.MasManufacturer>());
		getMasManufacturers().add(masManufacturer);
	}



	/**
	 * Return the value associated with the column: MasStoreSuppliersByLocalCity
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreSupplier> getMasStoreSuppliersByLocalCity () {
		return masStoreSuppliersByLocalCity;
	}

	/**
	 * Set the value related to the column: MasStoreSuppliersByLocalCity
	 * @param masStoreSuppliersByLocalCity the MasStoreSuppliersByLocalCity value
	 */
	public void setMasStoreSuppliersByLocalCity (java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliersByLocalCity) {
		this.masStoreSuppliersByLocalCity = masStoreSuppliersByLocalCity;
	}

	public void addToMasStoreSuppliersByLocalCity (jkt.hms.masters.business.MasStoreSupplier masStoreSupplier) {
		if (null == getMasStoreSuppliersByLocalCity()) setMasStoreSuppliersByLocalCity(new java.util.TreeSet<jkt.hms.masters.business.MasStoreSupplier>());
		getMasStoreSuppliersByLocalCity().add(masStoreSupplier);
	}



	/**
	 * Return the value associated with the column: MasStoreSuppliersByCity
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreSupplier> getMasStoreSuppliersByCity () {
		return masStoreSuppliersByCity;
	}

	/**
	 * Set the value related to the column: MasStoreSuppliersByCity
	 * @param masStoreSuppliersByCity the MasStoreSuppliersByCity value
	 */
	public void setMasStoreSuppliersByCity (java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliersByCity) {
		this.masStoreSuppliersByCity = masStoreSuppliersByCity;
	}

	public void addToMasStoreSuppliersByCity (jkt.hms.masters.business.MasStoreSupplier masStoreSupplier) {
		if (null == getMasStoreSuppliersByCity()) setMasStoreSuppliersByCity(new java.util.TreeSet<jkt.hms.masters.business.MasStoreSupplier>());
		getMasStoreSuppliersByCity().add(masStoreSupplier);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDistrict)) return false;
		else {
			jkt.hms.masters.business.MasDistrict masDistrict = (jkt.hms.masters.business.MasDistrict) obj;
			if (null == this.getId() || null == masDistrict.getId()) return false;
			else return (this.getId().equals(masDistrict.getId()));
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