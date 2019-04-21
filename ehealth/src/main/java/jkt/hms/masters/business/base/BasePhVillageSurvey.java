package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_village_survey table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_village_survey"
 */

public abstract class BasePhVillageSurvey  implements Serializable {

	public static String REF = "PhVillageSurvey";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_HOSPITAL_SPECIALITY = "HospitalSpeciality";
	public static String PROP_SURVEY_UNIQUE_ID = "SurveyUniqueId";
	public static String PROP_CATEGORY_CODE = "CategoryCode";
	public static String PROP_TYPE = "Type";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TIMING24_HOURS = "Timing24Hours";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TIMING_FROM = "TimingFrom";
	public static String PROP_MEDICAL_WASTE = "MedicalWaste";
	public static String PROP_PERSON2_NAME = "Person2Name";
	public static String PROP_ELECTRICAL_SECTION = "ElectricalSection";
	public static String PROP_SYSTEM_OF_MEDICINE = "SystemOfMedicine";
	public static String PROP_FACILITY_AVALIABLE = "FacilityAvaliable";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PANCHAYAT = "Panchayat";
	public static String PROP_LOCALITY = "Locality";
	public static String PROP_TYPE_CODE = "TypeCode";
	public static String PROP_PERSON1_NAME = "Person1Name";
	public static String PROP_PERSON2_CONTACT_NO = "Person2ContactNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CURRICULUM_TYPE = "CurriculumType";
	public static String PROP_SURVEY_TYPE = "SurveyType";
	public static String PROP_LAT_LONG = "LatLong";
	public static String PROP_PERSON1_CONTACT_NO = "Person1ContactNo";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_SURVEY_DATE = "SurveyDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_SCHOOL_TYPE = "SchoolType";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_PLACE_NAME = "PlaceName";
	public static String PROP_TIMING_TO = "TimingTo";
	public static String PROP_REG_CODE_NO = "RegCodeNo";
	public static String PROP_INSTITUTE_TYPE = "InstituteType";


	// constructors
	public BasePhVillageSurvey () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhVillageSurvey (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhVillageSurvey (
		java.lang.Integer id,
		java.lang.Long surveyUniqueId) {

		this.setId(id);
		this.setSurveyUniqueId(surveyUniqueId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer surveyType;
	private java.util.Date surveyDate;
	private java.lang.String categoryCode;
	private java.lang.String placeName;
	private java.lang.String contactNo;
	private java.lang.String address;
	private java.lang.String regCodeNo;
	private java.lang.String person1Name;
	private java.lang.String person1ContactNo;
	private java.lang.String person2Name;
	private java.lang.String person2ContactNo;
	private java.lang.String facilityAvaliable;
	private java.lang.String timing24Hours;
	private java.lang.String timingFrom;
	private java.lang.String timingTo;
	private java.lang.String remarks;
	private java.lang.String hospitalSpeciality;
	private java.lang.String latLong;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Long surveyUniqueId;
	private java.lang.Long typeCode;
	private java.lang.String schoolType;
	private java.lang.String curriculumType;
	private java.lang.String type;
	private java.lang.String instituteType;
	private java.lang.String systemOfMedicine;
	private java.lang.String medicalWaste;
	private java.lang.Long hospitalId;

	// many to one
	private jkt.hms.masters.business.MasPostCode pinCode;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasVillage village;
	private jkt.hms.masters.business.PhMasElectricalSection electricalSection;
	private jkt.hms.masters.business.MasLsg panchayat;
	private jkt.hms.masters.business.PhMasLocality locality;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhVillageSurveyDetails> phVillageSurveyDetails;



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
	 * Return the value associated with the column: survey_type
	 */
	public java.lang.Integer getSurveyType () {
		return surveyType;
	}

	/**
	 * Set the value related to the column: survey_type
	 * @param surveyType the survey_type value
	 */
	public void setSurveyType (java.lang.Integer surveyType) {
		this.surveyType = surveyType;
	}



	/**
	 * Return the value associated with the column: survey_date
	 */
	public java.util.Date getSurveyDate () {
		return surveyDate;
	}

	/**
	 * Set the value related to the column: survey_date
	 * @param surveyDate the survey_date value
	 */
	public void setSurveyDate (java.util.Date surveyDate) {
		this.surveyDate = surveyDate;
	}



	/**
	 * Return the value associated with the column: category_code
	 */
	public java.lang.String getCategoryCode () {
		return categoryCode;
	}

	/**
	 * Set the value related to the column: category_code
	 * @param categoryCode the category_code value
	 */
	public void setCategoryCode (java.lang.String categoryCode) {
		this.categoryCode = categoryCode;
	}



	/**
	 * Return the value associated with the column: place_name
	 */
	public java.lang.String getPlaceName () {
		return placeName;
	}

	/**
	 * Set the value related to the column: place_name
	 * @param placeName the place_name value
	 */
	public void setPlaceName (java.lang.String placeName) {
		this.placeName = placeName;
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
	 * Return the value associated with the column: reg_code_no
	 */
	public java.lang.String getRegCodeNo () {
		return regCodeNo;
	}

	/**
	 * Set the value related to the column: reg_code_no
	 * @param regCodeNo the reg_code_no value
	 */
	public void setRegCodeNo (java.lang.String regCodeNo) {
		this.regCodeNo = regCodeNo;
	}



	/**
	 * Return the value associated with the column: person1_name
	 */
	public java.lang.String getPerson1Name () {
		return person1Name;
	}

	/**
	 * Set the value related to the column: person1_name
	 * @param person1Name the person1_name value
	 */
	public void setPerson1Name (java.lang.String person1Name) {
		this.person1Name = person1Name;
	}



	/**
	 * Return the value associated with the column: person1_contact_no
	 */
	public java.lang.String getPerson1ContactNo () {
		return person1ContactNo;
	}

	/**
	 * Set the value related to the column: person1_contact_no
	 * @param person1ContactNo the person1_contact_no value
	 */
	public void setPerson1ContactNo (java.lang.String person1ContactNo) {
		this.person1ContactNo = person1ContactNo;
	}



	/**
	 * Return the value associated with the column: person2_name
	 */
	public java.lang.String getPerson2Name () {
		return person2Name;
	}

	/**
	 * Set the value related to the column: person2_name
	 * @param person2Name the person2_name value
	 */
	public void setPerson2Name (java.lang.String person2Name) {
		this.person2Name = person2Name;
	}



	/**
	 * Return the value associated with the column: person2_contact_no
	 */
	public java.lang.String getPerson2ContactNo () {
		return person2ContactNo;
	}

	/**
	 * Set the value related to the column: person2_contact_no
	 * @param person2ContactNo the person2_contact_no value
	 */
	public void setPerson2ContactNo (java.lang.String person2ContactNo) {
		this.person2ContactNo = person2ContactNo;
	}



	/**
	 * Return the value associated with the column: facility_avaliable
	 */
	public java.lang.String getFacilityAvaliable () {
		return facilityAvaliable;
	}

	/**
	 * Set the value related to the column: facility_avaliable
	 * @param facilityAvaliable the facility_avaliable value
	 */
	public void setFacilityAvaliable (java.lang.String facilityAvaliable) {
		this.facilityAvaliable = facilityAvaliable;
	}



	/**
	 * Return the value associated with the column: timing_24_hours
	 */
	public java.lang.String getTiming24Hours () {
		return timing24Hours;
	}

	/**
	 * Set the value related to the column: timing_24_hours
	 * @param timing24Hours the timing_24_hours value
	 */
	public void setTiming24Hours (java.lang.String timing24Hours) {
		this.timing24Hours = timing24Hours;
	}



	/**
	 * Return the value associated with the column: timing_from
	 */
	public java.lang.String getTimingFrom () {
		return timingFrom;
	}

	/**
	 * Set the value related to the column: timing_from
	 * @param timingFrom the timing_from value
	 */
	public void setTimingFrom (java.lang.String timingFrom) {
		this.timingFrom = timingFrom;
	}



	/**
	 * Return the value associated with the column: timing_to
	 */
	public java.lang.String getTimingTo () {
		return timingTo;
	}

	/**
	 * Set the value related to the column: timing_to
	 * @param timingTo the timing_to value
	 */
	public void setTimingTo (java.lang.String timingTo) {
		this.timingTo = timingTo;
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
	 * Return the value associated with the column: hospital_speciality
	 */
	public java.lang.String getHospitalSpeciality () {
		return hospitalSpeciality;
	}

	/**
	 * Set the value related to the column: hospital_speciality
	 * @param hospitalSpeciality the hospital_speciality value
	 */
	public void setHospitalSpeciality (java.lang.String hospitalSpeciality) {
		this.hospitalSpeciality = hospitalSpeciality;
	}



	/**
	 * Return the value associated with the column: lat_long
	 */
	public java.lang.String getLatLong () {
		return latLong;
	}

	/**
	 * Set the value related to the column: lat_long
	 * @param latLong the lat_long value
	 */
	public void setLatLong (java.lang.String latLong) {
		this.latLong = latLong;
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
	 * Return the value associated with the column: survey_unique_id
	 */
	public java.lang.Long getSurveyUniqueId () {
		return surveyUniqueId;
	}

	/**
	 * Set the value related to the column: survey_unique_id
	 * @param surveyUniqueId the survey_unique_id value
	 */
	public void setSurveyUniqueId (java.lang.Long surveyUniqueId) {
		this.surveyUniqueId = surveyUniqueId;
	}



	/**
	 * Return the value associated with the column: type_code
	 */
	public java.lang.Long getTypeCode () {
		return typeCode;
	}

	/**
	 * Set the value related to the column: type_code
	 * @param typeCode the type_code value
	 */
	public void setTypeCode (java.lang.Long typeCode) {
		this.typeCode = typeCode;
	}



	/**
	 * Return the value associated with the column: school_type
	 */
	public java.lang.String getSchoolType () {
		return schoolType;
	}

	/**
	 * Set the value related to the column: school_type
	 * @param schoolType the school_type value
	 */
	public void setSchoolType (java.lang.String schoolType) {
		this.schoolType = schoolType;
	}



	/**
	 * Return the value associated with the column: curriculum_type
	 */
	public java.lang.String getCurriculumType () {
		return curriculumType;
	}

	/**
	 * Set the value related to the column: curriculum_type
	 * @param curriculumType the curriculum_type value
	 */
	public void setCurriculumType (java.lang.String curriculumType) {
		this.curriculumType = curriculumType;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: institute_type
	 */
	public java.lang.String getInstituteType () {
		return instituteType;
	}

	/**
	 * Set the value related to the column: institute_type
	 * @param instituteType the institute_type value
	 */
	public void setInstituteType (java.lang.String instituteType) {
		this.instituteType = instituteType;
	}



	/**
	 * Return the value associated with the column: system_of_medicine
	 */
	public java.lang.String getSystemOfMedicine () {
		return systemOfMedicine;
	}

	/**
	 * Set the value related to the column: system_of_medicine
	 * @param systemOfMedicine the system_of_medicine value
	 */
	public void setSystemOfMedicine (java.lang.String systemOfMedicine) {
		this.systemOfMedicine = systemOfMedicine;
	}



	/**
	 * Return the value associated with the column: medical_waste
	 */
	public java.lang.String getMedicalWaste () {
		return medicalWaste;
	}

	/**
	 * Set the value related to the column: medical_waste
	 * @param medicalWaste the medical_waste value
	 */
	public void setMedicalWaste (java.lang.String medicalWaste) {
		this.medicalWaste = medicalWaste;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Long getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Long hospitalId) {
		this.hospitalId = hospitalId;
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



	/**
	 * Return the value associated with the column: PhVillageSurveyDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PhVillageSurveyDetails> getPhVillageSurveyDetails () {
		return phVillageSurveyDetails;
	}

	/**
	 * Set the value related to the column: PhVillageSurveyDetails
	 * @param phVillageSurveyDetails the PhVillageSurveyDetails value
	 */
	public void setPhVillageSurveyDetails (java.util.Set<jkt.hms.masters.business.PhVillageSurveyDetails> phVillageSurveyDetails) {
		this.phVillageSurveyDetails = phVillageSurveyDetails;
	}

	public void addToPhVillageSurveyDetails (jkt.hms.masters.business.PhVillageSurveyDetails phVillageSurveyDetails) {
		if (null == getPhVillageSurveyDetails()) setPhVillageSurveyDetails(new java.util.TreeSet<jkt.hms.masters.business.PhVillageSurveyDetails>());
		getPhVillageSurveyDetails().add(phVillageSurveyDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhVillageSurvey)) return false;
		else {
			jkt.hms.masters.business.PhVillageSurvey phVillageSurvey = (jkt.hms.masters.business.PhVillageSurvey) obj;
			if (null == this.getId() || null == phVillageSurvey.getId()) return false;
			else return (this.getId().equals(phVillageSurvey.getId()));
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