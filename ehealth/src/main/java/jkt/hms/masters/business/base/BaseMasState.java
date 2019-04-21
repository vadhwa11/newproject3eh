package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_state table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_state"
 */

public abstract class BaseMasState  implements Serializable {

	public static String REF = "MasState";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_STATE_CODE = "StateCode";
	public static String PROP_STATE_NAME = "StateName";


	// constructors
	public BaseMasState () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasState (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String stateCode;
	private java.lang.String stateName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasCountry country;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasManufacturer> masManufacturers;
	private java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliersByLocalState;
	private java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliersByState;
	private java.util.Set<jkt.hms.masters.business.MasDistrict> masDistricts;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="state_id"
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
	 * Return the value associated with the column: state_code
	 */
	public java.lang.String getStateCode () {
		return stateCode;
	}

	/**
	 * Set the value related to the column: state_code
	 * @param stateCode the state_code value
	 */
	public void setStateCode (java.lang.String stateCode) {
		this.stateCode = stateCode;
	}



	/**
	 * Return the value associated with the column: state_name
	 */
	public java.lang.String getStateName () {
		return stateName;
	}

	/**
	 * Set the value related to the column: state_name
	 * @param stateName the state_name value
	 */
	public void setStateName (java.lang.String stateName) {
		this.stateName = stateName;
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
	 * Return the value associated with the column: MasStoreSuppliersByLocalState
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreSupplier> getMasStoreSuppliersByLocalState () {
		return masStoreSuppliersByLocalState;
	}

	/**
	 * Set the value related to the column: MasStoreSuppliersByLocalState
	 * @param masStoreSuppliersByLocalState the MasStoreSuppliersByLocalState value
	 */
	public void setMasStoreSuppliersByLocalState (java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliersByLocalState) {
		this.masStoreSuppliersByLocalState = masStoreSuppliersByLocalState;
	}

	public void addToMasStoreSuppliersByLocalState (jkt.hms.masters.business.MasStoreSupplier masStoreSupplier) {
		if (null == getMasStoreSuppliersByLocalState()) setMasStoreSuppliersByLocalState(new java.util.TreeSet<jkt.hms.masters.business.MasStoreSupplier>());
		getMasStoreSuppliersByLocalState().add(masStoreSupplier);
	}



	/**
	 * Return the value associated with the column: MasStoreSuppliersByState
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreSupplier> getMasStoreSuppliersByState () {
		return masStoreSuppliersByState;
	}

	/**
	 * Set the value related to the column: MasStoreSuppliersByState
	 * @param masStoreSuppliersByState the MasStoreSuppliersByState value
	 */
	public void setMasStoreSuppliersByState (java.util.Set<jkt.hms.masters.business.MasStoreSupplier> masStoreSuppliersByState) {
		this.masStoreSuppliersByState = masStoreSuppliersByState;
	}

	public void addToMasStoreSuppliersByState (jkt.hms.masters.business.MasStoreSupplier masStoreSupplier) {
		if (null == getMasStoreSuppliersByState()) setMasStoreSuppliersByState(new java.util.TreeSet<jkt.hms.masters.business.MasStoreSupplier>());
		getMasStoreSuppliersByState().add(masStoreSupplier);
	}



	/**
	 * Return the value associated with the column: MasDistricts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDistrict> getMasDistricts () {
		return masDistricts;
	}

	/**
	 * Set the value related to the column: MasDistricts
	 * @param masDistricts the MasDistricts value
	 */
	public void setMasDistricts (java.util.Set<jkt.hms.masters.business.MasDistrict> masDistricts) {
		this.masDistricts = masDistricts;
	}

	public void addToMasDistricts (jkt.hms.masters.business.MasDistrict masDistrict) {
		if (null == getMasDistricts()) setMasDistricts(new java.util.TreeSet<jkt.hms.masters.business.MasDistrict>());
		getMasDistricts().add(masDistrict);
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
		if (!(obj instanceof jkt.hms.masters.business.MasState)) return false;
		else {
			jkt.hms.masters.business.MasState masState = (jkt.hms.masters.business.MasState) obj;
			if (null == this.getId() || null == masState.getId()) return false;
			else return (this.getId().equals(masState.getId()));
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