package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_house_survey table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_house_survey"
 */

public abstract class BasePhHouseSurvey  implements Serializable {

	public static String REF = "PhHouseSurvey";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_LWD_SEWAGE = "LwdSewage";
	public static String PROP_WARD = "Ward";
	public static String PROP_CATTLE_SHED = "CattleShed";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_WATER_STORAGE_TYPE = "WaterStorageType";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_OCCUPANCY_STATUS = "OccupancyStatus";
	public static String PROP_ROOF_TYPE = "RoofType";
	public static String PROP_ELECTRICAL_SECTION = "ElectricalSection";
	public static String PROP_OTHER_WATER_SOURCE = "OtherWaterSource";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PANCHAYAT = "Panchayat";
	public static String PROP_LOCALITY = "Locality";
	public static String PROP_HOUSE_SURVEY_BY = "HouseSurveyBy";
	public static String PROP_SOLID_WASTE_DISPOSAL_METHOD = "SolidWasteDisposalMethod";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HOUSE_SURVEY_DATE = "HouseSurveyDate";
	public static String PROP_KSEB_POST_NO = "KsebPostNo";
	public static String PROP_DRINKING_WATER_SOURCE = "DrinkingWaterSource";
	public static String PROP_HOUSE_TYPE = "HouseType";
	public static String PROP_LWD_SULLAGE = "LwdSullage";
	public static String PROP_COOKING_FUEL = "CookingFuel";
	public static String PROP_ELECTRIFICATION_STATUS = "ElectrificationStatus";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_OTHER_INFO = "OtherInfo";
	public static String PROP_OPEN_TANK = "OpenTank";
	public static String PROP_LONG_LAT = "LongLat";
	public static String PROP_LOCALITY_TYPE = "LocalityType";
	public static String PROP_LSG_HOUSE_NO = "LsgHouseNo";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_ELECTRICITY_CONS_NO = "ElectricityConsNo";
	public static String PROP_HOUSE_SURVEY_STATUS = "HouseSurveyStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_STREET_NAME = "StreetName";
	public static String PROP_WATER_BODIES = "WaterBodies";
	public static String PROP_WELL_TYPE_STATUS = "WellTypeStatus";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_HOUSE_HOLD_ID = "HouseHoldId";
	public static String PROP_ID = "Id";
	public static String PROP_LATRINE = "Latrine";


	// constructors
	public BasePhHouseSurvey () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhHouseSurvey (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String houseHoldId;
	private java.lang.String address;
	private java.lang.String localityType;
	private java.lang.String lsgHouseNo;
	private java.lang.String ksebPostNo;
	private java.lang.String electrificationStatus;
	private java.lang.String electricityConsNo;
	private java.lang.String houseType;
	private java.lang.String roofType;
	private java.lang.String drinkingWaterSource;
	private java.lang.String waterStorageType;
	private java.lang.String latrine;
	private java.lang.String lwdSewage;
	private java.lang.String lwdSullage;
	private java.lang.String openTank;
	private java.lang.String cattleShed;
	private java.lang.String cookingFuel;
	private java.lang.String occupancyStatus;
	private java.lang.String longLat;
	private java.lang.String remarks;
	private java.lang.String houseSurveyStatus;
	private java.util.Date houseSurveyDate;
	private java.lang.Long lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String otherWaterSource;
	private java.lang.String waterBodies;
	private java.lang.String otherInfo;
	private java.lang.String contactNo;
	private java.lang.String wellTypeStatus;
	private java.lang.String status;
	private java.lang.String solidWasteDisposalMethod;
	private java.lang.String streetName;

	// many to one
	private jkt.hms.masters.business.MasPostCode pinCode;
	private jkt.hms.masters.business.MasVillage village;
	private jkt.hms.masters.business.Users houseSurveyBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.PhMasElectricalSection electricalSection;
	private jkt.hms.masters.business.MasLsg panchayat;
	private jkt.hms.masters.business.MasWard ward;
	private jkt.hms.masters.business.PhMasLocality locality;



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
	 * Return the value associated with the column: house_hold_id
	 */
	public java.lang.String getHouseHoldId () {
		return houseHoldId;
	}

	/**
	 * Set the value related to the column: house_hold_id
	 * @param houseHoldId the house_hold_id value
	 */
	public void setHouseHoldId (java.lang.String houseHoldId) {
		this.houseHoldId = houseHoldId;
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
	 * Return the value associated with the column: locality_type
	 */
	public java.lang.String getLocalityType () {
		return localityType;
	}

	/**
	 * Set the value related to the column: locality_type
	 * @param localityType the locality_type value
	 */
	public void setLocalityType (java.lang.String localityType) {
		this.localityType = localityType;
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
	 * Return the value associated with the column: kseb_post_no
	 */
	public java.lang.String getKsebPostNo () {
		return ksebPostNo;
	}

	/**
	 * Set the value related to the column: kseb_post_no
	 * @param ksebPostNo the kseb_post_no value
	 */
	public void setKsebPostNo (java.lang.String ksebPostNo) {
		this.ksebPostNo = ksebPostNo;
	}



	/**
	 * Return the value associated with the column: electrification_status
	 */
	public java.lang.String getElectrificationStatus () {
		return electrificationStatus;
	}

	/**
	 * Set the value related to the column: electrification_status
	 * @param electrificationStatus the electrification_status value
	 */
	public void setElectrificationStatus (java.lang.String electrificationStatus) {
		this.electrificationStatus = electrificationStatus;
	}



	/**
	 * Return the value associated with the column: electricity_cons_no
	 */
	public java.lang.String getElectricityConsNo () {
		return electricityConsNo;
	}

	/**
	 * Set the value related to the column: electricity_cons_no
	 * @param electricityConsNo the electricity_cons_no value
	 */
	public void setElectricityConsNo (java.lang.String electricityConsNo) {
		this.electricityConsNo = electricityConsNo;
	}



	/**
	 * Return the value associated with the column: house_type
	 */
	public java.lang.String getHouseType () {
		return houseType;
	}

	/**
	 * Set the value related to the column: house_type
	 * @param houseType the house_type value
	 */
	public void setHouseType (java.lang.String houseType) {
		this.houseType = houseType;
	}



	/**
	 * Return the value associated with the column: roof_type
	 */
	public java.lang.String getRoofType () {
		return roofType;
	}

	/**
	 * Set the value related to the column: roof_type
	 * @param roofType the roof_type value
	 */
	public void setRoofType (java.lang.String roofType) {
		this.roofType = roofType;
	}



	/**
	 * Return the value associated with the column: drinking_water_source
	 */
	public java.lang.String getDrinkingWaterSource () {
		return drinkingWaterSource;
	}

	/**
	 * Set the value related to the column: drinking_water_source
	 * @param drinkingWaterSource the drinking_water_source value
	 */
	public void setDrinkingWaterSource (java.lang.String drinkingWaterSource) {
		this.drinkingWaterSource = drinkingWaterSource;
	}



	/**
	 * Return the value associated with the column: water_storage_type
	 */
	public java.lang.String getWaterStorageType () {
		return waterStorageType;
	}

	/**
	 * Set the value related to the column: water_storage_type
	 * @param waterStorageType the water_storage_type value
	 */
	public void setWaterStorageType (java.lang.String waterStorageType) {
		this.waterStorageType = waterStorageType;
	}



	/**
	 * Return the value associated with the column: latrine
	 */
	public java.lang.String getLatrine () {
		return latrine;
	}

	/**
	 * Set the value related to the column: latrine
	 * @param latrine the latrine value
	 */
	public void setLatrine (java.lang.String latrine) {
		this.latrine = latrine;
	}



	/**
	 * Return the value associated with the column: lwd_sewage
	 */
	public java.lang.String getLwdSewage () {
		return lwdSewage;
	}

	/**
	 * Set the value related to the column: lwd_sewage
	 * @param lwdSewage the lwd_sewage value
	 */
	public void setLwdSewage (java.lang.String lwdSewage) {
		this.lwdSewage = lwdSewage;
	}



	/**
	 * Return the value associated with the column: lwd_sullage
	 */
	public java.lang.String getLwdSullage () {
		return lwdSullage;
	}

	/**
	 * Set the value related to the column: lwd_sullage
	 * @param lwdSullage the lwd_sullage value
	 */
	public void setLwdSullage (java.lang.String lwdSullage) {
		this.lwdSullage = lwdSullage;
	}



	/**
	 * Return the value associated with the column: open_tank
	 */
	public java.lang.String getOpenTank () {
		return openTank;
	}

	/**
	 * Set the value related to the column: open_tank
	 * @param openTank the open_tank value
	 */
	public void setOpenTank (java.lang.String openTank) {
		this.openTank = openTank;
	}



	/**
	 * Return the value associated with the column: cattle_shed
	 */
	public java.lang.String getCattleShed () {
		return cattleShed;
	}

	/**
	 * Set the value related to the column: cattle_shed
	 * @param cattleShed the cattle_shed value
	 */
	public void setCattleShed (java.lang.String cattleShed) {
		this.cattleShed = cattleShed;
	}



	/**
	 * Return the value associated with the column: cooking_fuel
	 */
	public java.lang.String getCookingFuel () {
		return cookingFuel;
	}

	/**
	 * Set the value related to the column: cooking_fuel
	 * @param cookingFuel the cooking_fuel value
	 */
	public void setCookingFuel (java.lang.String cookingFuel) {
		this.cookingFuel = cookingFuel;
	}



	/**
	 * Return the value associated with the column: occupancy_status
	 */
	public java.lang.String getOccupancyStatus () {
		return occupancyStatus;
	}

	/**
	 * Set the value related to the column: occupancy_status
	 * @param occupancyStatus the occupancy_status value
	 */
	public void setOccupancyStatus (java.lang.String occupancyStatus) {
		this.occupancyStatus = occupancyStatus;
	}



	/**
	 * Return the value associated with the column: long_lat
	 */
	public java.lang.String getLongLat () {
		return longLat;
	}

	/**
	 * Set the value related to the column: long_lat
	 * @param longLat the long_lat value
	 */
	public void setLongLat (java.lang.String longLat) {
		this.longLat = longLat;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: house_survey_status
	 */
	public java.lang.String getHouseSurveyStatus () {
		return houseSurveyStatus;
	}

	/**
	 * Set the value related to the column: house_survey_status
	 * @param houseSurveyStatus the house_survey_status value
	 */
	public void setHouseSurveyStatus (java.lang.String houseSurveyStatus) {
		this.houseSurveyStatus = houseSurveyStatus;
	}



	/**
	 * Return the value associated with the column: house_survey_date
	 */
	public java.util.Date getHouseSurveyDate () {
		return houseSurveyDate;
	}

	/**
	 * Set the value related to the column: house_survey_date
	 * @param houseSurveyDate the house_survey_date value
	 */
	public void setHouseSurveyDate (java.util.Date houseSurveyDate) {
		this.houseSurveyDate = houseSurveyDate;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Long getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Long lastChgBy) {
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
	 * Return the value associated with the column: other_water_source
	 */
	public java.lang.String getOtherWaterSource () {
		return otherWaterSource;
	}

	/**
	 * Set the value related to the column: other_water_source
	 * @param otherWaterSource the other_water_source value
	 */
	public void setOtherWaterSource (java.lang.String otherWaterSource) {
		this.otherWaterSource = otherWaterSource;
	}



	/**
	 * Return the value associated with the column: water_bodies
	 */
	public java.lang.String getWaterBodies () {
		return waterBodies;
	}

	/**
	 * Set the value related to the column: water_bodies
	 * @param waterBodies the water_bodies value
	 */
	public void setWaterBodies (java.lang.String waterBodies) {
		this.waterBodies = waterBodies;
	}



	/**
	 * Return the value associated with the column: other_info
	 */
	public java.lang.String getOtherInfo () {
		return otherInfo;
	}

	/**
	 * Set the value related to the column: other_info
	 * @param otherInfo the other_info value
	 */
	public void setOtherInfo (java.lang.String otherInfo) {
		this.otherInfo = otherInfo;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: well_type_status
	 */
	public java.lang.String getWellTypeStatus () {
		return wellTypeStatus;
	}

	/**
	 * Set the value related to the column: well_type_status
	 * @param wellTypeStatus the well_type_status value
	 */
	public void setWellTypeStatus (java.lang.String wellTypeStatus) {
		this.wellTypeStatus = wellTypeStatus;
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
	 * Return the value associated with the column: solid_waste_disposal_method
	 */
	public java.lang.String getSolidWasteDisposalMethod () {
		return solidWasteDisposalMethod;
	}

	/**
	 * Set the value related to the column: solid_waste_disposal_method
	 * @param solidWasteDisposalMethod the solid_waste_disposal_method value
	 */
	public void setSolidWasteDisposalMethod (java.lang.String solidWasteDisposalMethod) {
		this.solidWasteDisposalMethod = solidWasteDisposalMethod;
	}



	/**
	 * Return the value associated with the column: street_name
	 */
	public java.lang.String getStreetName () {
		return streetName;
	}

	/**
	 * Set the value related to the column: street_name
	 * @param streetName the street_name value
	 */
	public void setStreetName (java.lang.String streetName) {
		this.streetName = streetName;
	}



	/**
	 * Return the value associated with the column: pin_code_id
	 */
	public jkt.hms.masters.business.MasPostCode getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code_id
	 * @param pinCode the pin_code_id value
	 */
	public void setPinCode (jkt.hms.masters.business.MasPostCode pinCode) {
		this.pinCode = pinCode;
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
	 * Return the value associated with the column: house_survey_by
	 */
	public jkt.hms.masters.business.Users getHouseSurveyBy () {
		return houseSurveyBy;
	}

	/**
	 * Set the value related to the column: house_survey_by
	 * @param houseSurveyBy the house_survey_by value
	 */
	public void setHouseSurveyBy (jkt.hms.masters.business.Users houseSurveyBy) {
		this.houseSurveyBy = houseSurveyBy;
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
	 * Return the value associated with the column: electrical_section_id
	 */
	public jkt.hms.masters.business.PhMasElectricalSection getElectricalSection () {
		return electricalSection;
	}

	/**
	 * Set the value related to the column: electrical_section_id
	 * @param electricalSection the electrical_section_id value
	 */
	public void setElectricalSection (jkt.hms.masters.business.PhMasElectricalSection electricalSection) {
		this.electricalSection = electricalSection;
	}



	/**
	 * Return the value associated with the column: panchayat_id
	 */
	public jkt.hms.masters.business.MasLsg getPanchayat () {
		return panchayat;
	}

	/**
	 * Set the value related to the column: panchayat_id
	 * @param panchayat the panchayat_id value
	 */
	public void setPanchayat (jkt.hms.masters.business.MasLsg panchayat) {
		this.panchayat = panchayat;
	}



	/**
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasWard getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasWard ward) {
		this.ward = ward;
	}



	/**
	 * Return the value associated with the column: locality_id
	 */
	public jkt.hms.masters.business.PhMasLocality getLocality () {
		return locality;
	}

	/**
	 * Set the value related to the column: locality_id
	 * @param locality the locality_id value
	 */
	public void setLocality (jkt.hms.masters.business.PhMasLocality locality) {
		this.locality = locality;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhHouseSurvey)) return false;
		else {
			jkt.hms.masters.business.PhHouseSurvey phHouseSurvey = (jkt.hms.masters.business.PhHouseSurvey) obj;
			if (null == this.getId() || null == phHouseSurvey.getId()) return false;
			else return (this.getId().equals(phHouseSurvey.getId()));
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