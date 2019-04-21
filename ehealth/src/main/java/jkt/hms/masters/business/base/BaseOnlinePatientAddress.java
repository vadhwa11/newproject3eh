package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the online_patient_address table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="online_patient_address"
 */

public abstract class BaseOnlinePatientAddress  implements Serializable {

	public static String REF = "OnlinePatientAddress";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_HOUSE_NO = "HouseNo";
	public static String PROP_TALUK_ID = "TalukId";
	public static String PROP_HEALTH_HOUSE_ID = "HealthHouseId";
	public static String PROP_LOCALITY = "Locality";
	public static String PROP_NATIONALITY_ID = "NationalityId";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_STATE_ID = "StateId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_POST_OFFICE = "PostOffice";
	public static String PROP_BLOCK = "Block";
	public static String PROP_LAND_MARK = "LandMark";
	public static String PROP_POLICE_STATION = "PoliceStation";
	public static String PROP_STREET_ROAD = "StreetRoad";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_LSG_HOUSE_NO = "LsgHouseNo";
	public static String PROP_WARD_NAME = "WardName";
	public static String PROP_WARD_NO = "WardNo";
	public static String PROP_CITY = "City";
	public static String PROP_AREA_SECTOR = "AreaSector";
	public static String PROP_LSG_NAME = "LsgName";
	public static String PROP_DISTRICT = "District";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_COUNTRY_ID = "CountryId";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_ADDRESS_TYPE_ID = "AddressTypeId";


	// constructors
	public BaseOnlinePatientAddress () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOnlinePatientAddress (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hospitalId;
	private java.lang.String address;
	private java.lang.Integer village;
	private java.lang.Integer block;
	private java.lang.Integer district;
	private java.lang.Integer stateId;
	private java.lang.Integer nationalityId;
	private java.lang.String city;
	private java.lang.String policeStation;
	private java.lang.Integer postOffice;
	private java.lang.Integer pinCode;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;
	private java.lang.String houseNo;
	private java.lang.String streetRoad;
	private java.lang.String areaSector;
	private java.lang.String landMark;
	private java.lang.Long lsgName;
	private java.lang.String wardName;
	private java.lang.Integer wardNo;
	private java.lang.Integer addressTypeId;
	private java.lang.Integer countryId;
	private java.lang.String lsgHouseNo;
	private java.lang.Integer locality;
	private java.lang.String healthHouseId;
	private java.lang.Integer talukId;

	// many to one
	private jkt.hms.masters.business.OnlinePatientPortal hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="patient_address_id"
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
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: village
	 */
	public java.lang.Integer getVillage () {
		return village;
	}

	/**
	 * Set the value related to the column: village
	 * @param village the village value
	 */
	public void setVillage (java.lang.Integer village) {
		this.village = village;
	}



	/**
	 * Return the value associated with the column: block
	 */
	public java.lang.Integer getBlock () {
		return block;
	}

	/**
	 * Set the value related to the column: block
	 * @param block the block value
	 */
	public void setBlock (java.lang.Integer block) {
		this.block = block;
	}



	/**
	 * Return the value associated with the column: district
	 */
	public java.lang.Integer getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district
	 * @param district the district value
	 */
	public void setDistrict (java.lang.Integer district) {
		this.district = district;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public java.lang.Integer getStateId () {
		return stateId;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param stateId the state_id value
	 */
	public void setStateId (java.lang.Integer stateId) {
		this.stateId = stateId;
	}



	/**
	 * Return the value associated with the column: nationality_id
	 */
	public java.lang.Integer getNationalityId () {
		return nationalityId;
	}

	/**
	 * Set the value related to the column: nationality_id
	 * @param nationalityId the nationality_id value
	 */
	public void setNationalityId (java.lang.Integer nationalityId) {
		this.nationalityId = nationalityId;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: police_station
	 */
	public java.lang.String getPoliceStation () {
		return policeStation;
	}

	/**
	 * Set the value related to the column: police_station
	 * @param policeStation the police_station value
	 */
	public void setPoliceStation (java.lang.String policeStation) {
		this.policeStation = policeStation;
	}



	/**
	 * Return the value associated with the column: post_office
	 */
	public java.lang.Integer getPostOffice () {
		return postOffice;
	}

	/**
	 * Set the value related to the column: post_office
	 * @param postOffice the post_office value
	 */
	public void setPostOffice (java.lang.Integer postOffice) {
		this.postOffice = postOffice;
	}



	/**
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.Integer getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * @param pinCode the pin_code value
	 */
	public void setPinCode (java.lang.Integer pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public java.lang.Integer getAddEditById () {
		return addEditById;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditById the add_edit_by_id value
	 */
	public void setAddEditById (java.lang.Integer addEditById) {
		this.addEditById = addEditById;
	}



	/**
	 * Return the value associated with the column: add_edit_date_time
	 */
	public java.util.Date getAddEditDateTime () {
		return addEditDateTime;
	}

	/**
	 * Set the value related to the column: add_edit_date_time
	 * @param addEditDateTime the add_edit_date_time value
	 */
	public void setAddEditDateTime (java.util.Date addEditDateTime) {
		this.addEditDateTime = addEditDateTime;
	}



	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId () {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * @param statusId the status_id value
	 */
	public void setStatusId (java.lang.Integer statusId) {
		this.statusId = statusId;
	}



	/**
	 * Return the value associated with the column: house_no
	 */
	public java.lang.String getHouseNo () {
		return houseNo;
	}

	/**
	 * Set the value related to the column: house_no
	 * @param houseNo the house_no value
	 */
	public void setHouseNo (java.lang.String houseNo) {
		this.houseNo = houseNo;
	}



	/**
	 * Return the value associated with the column: street_road
	 */
	public java.lang.String getStreetRoad () {
		return streetRoad;
	}

	/**
	 * Set the value related to the column: street_road
	 * @param streetRoad the street_road value
	 */
	public void setStreetRoad (java.lang.String streetRoad) {
		this.streetRoad = streetRoad;
	}



	/**
	 * Return the value associated with the column: area_sector
	 */
	public java.lang.String getAreaSector () {
		return areaSector;
	}

	/**
	 * Set the value related to the column: area_sector
	 * @param areaSector the area_sector value
	 */
	public void setAreaSector (java.lang.String areaSector) {
		this.areaSector = areaSector;
	}



	/**
	 * Return the value associated with the column: land_mark
	 */
	public java.lang.String getLandMark () {
		return landMark;
	}

	/**
	 * Set the value related to the column: land_mark
	 * @param landMark the land_mark value
	 */
	public void setLandMark (java.lang.String landMark) {
		this.landMark = landMark;
	}



	/**
	 * Return the value associated with the column: lsg_name
	 */
	public java.lang.Long getLsgName () {
		return lsgName;
	}

	/**
	 * Set the value related to the column: lsg_name
	 * @param lsgName the lsg_name value
	 */
	public void setLsgName (java.lang.Long lsgName) {
		this.lsgName = lsgName;
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
	 * Return the value associated with the column: ward_no
	 */
	public java.lang.Integer getWardNo () {
		return wardNo;
	}

	/**
	 * Set the value related to the column: ward_no
	 * @param wardNo the ward_no value
	 */
	public void setWardNo (java.lang.Integer wardNo) {
		this.wardNo = wardNo;
	}



	/**
	 * Return the value associated with the column: address_type_id
	 */
	public java.lang.Integer getAddressTypeId () {
		return addressTypeId;
	}

	/**
	 * Set the value related to the column: address_type_id
	 * @param addressTypeId the address_type_id value
	 */
	public void setAddressTypeId (java.lang.Integer addressTypeId) {
		this.addressTypeId = addressTypeId;
	}



	/**
	 * Return the value associated with the column: country_id
	 */
	public java.lang.Integer getCountryId () {
		return countryId;
	}

	/**
	 * Set the value related to the column: country_id
	 * @param countryId the country_id value
	 */
	public void setCountryId (java.lang.Integer countryId) {
		this.countryId = countryId;
	}



	/**
	 * Return the value associated with the column: lsg_house_no
	 */
	public java.lang.String getLsgHouseNo () {
		return lsgHouseNo;
	}

	/**
	 * Set the value related to the column: lsg_house_no
	 * @param lsgHouseNo the lsg_house_no value
	 */
	public void setLsgHouseNo (java.lang.String lsgHouseNo) {
		this.lsgHouseNo = lsgHouseNo;
	}



	/**
	 * Return the value associated with the column: locality
	 */
	public java.lang.Integer getLocality () {
		return locality;
	}

	/**
	 * Set the value related to the column: locality
	 * @param locality the locality value
	 */
	public void setLocality (java.lang.Integer locality) {
		this.locality = locality;
	}



	/**
	 * Return the value associated with the column: health_house_id
	 */
	public java.lang.String getHealthHouseId () {
		return healthHouseId;
	}

	/**
	 * Set the value related to the column: health_house_id
	 * @param healthHouseId the health_house_id value
	 */
	public void setHealthHouseId (java.lang.String healthHouseId) {
		this.healthHouseId = healthHouseId;
	}



	/**
	 * Return the value associated with the column: taluk_id
	 */
	public java.lang.Integer getTalukId () {
		return talukId;
	}

	/**
	 * Set the value related to the column: taluk_id
	 * @param talukId the taluk_id value
	 */
	public void setTalukId (java.lang.Integer talukId) {
		this.talukId = talukId;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.OnlinePatientPortal getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.OnlinePatientPortal hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OnlinePatientAddress)) return false;
		else {
			jkt.hms.masters.business.OnlinePatientAddress onlinePatientAddress = (jkt.hms.masters.business.OnlinePatientAddress) obj;
			if (null == this.getId() || null == onlinePatientAddress.getId()) return false;
			else return (this.getId().equals(onlinePatientAddress.getId()));
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