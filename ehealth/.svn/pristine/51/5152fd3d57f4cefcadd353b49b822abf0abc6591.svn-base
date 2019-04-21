package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the applicant_personal table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="applicant_personal"
 */

public abstract class BaseApplicantPersonal implements Serializable {

	public static String REF = "ApplicantPersonal";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EMG_PERSON_NAME = "EmgPersonName";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_APPLICANT = "Applicant";
	public static String PROP_NATIONALITY = "Nationality";
	public static String PROP_LIKES = "Likes";
	public static String PROP_PASSPORT_NO = "PassportNo";
	public static String PROP_DISLIKE = "Dislike";
	public static String PROP_SPOUSE_NAME = "SpouseName";
	public static String PROP_WEEKNESS = "Weekness";
	public static String PROP_TIN_NO = "TinNo";
	public static String PROP_RELIGION = "Religion";
	public static String PROP_EDUCATION_TYPE = "EducationType";
	public static String PROP_GENERAL_INTEREST = "GeneralInterest";
	public static String PROP_NO_OF_CHILDREN = "NoOfChildren";
	public static String PROP_STRENGTH = "Strength";
	public static String PROP_TRIBE = "Tribe";
	public static String PROP_DRIVING_LICENCE_NO = "DrivingLicenceNo";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_FATHER_NAME = "FatherName";
	public static String PROP_GENDER = "Gender";
	public static String PROP_MOTHER_NAME = "MotherName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EMG_ADDRESS = "EmgAddress";
	public static String PROP_PAN_NO = "PanNo";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_MARTIAL_STATUS = "MartialStatus";
	public static String PROP_SSC_NO = "SscNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_EMG_CONTACT_NO = "EmgContactNo";
	public static String PROP_PHIC_NO = "PhicNo";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_ID = "Id";
	public static String PROP_PLACE_OF_BIRTH = "PlaceOfBirth";

	// constructors
	public BaseApplicantPersonal() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApplicantPersonal(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fatherName;
	private java.lang.String placeOfBirth;
	private java.util.Date dateOfBirth;
	private java.lang.String gender;
	private java.lang.String sscNo;
	private java.lang.String passportNo;
	private java.lang.String drivingLicenceNo;
	private java.lang.String emgPersonName;
	private java.lang.String emgContactNo;
	private java.lang.String emgAddress;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String martialStatus;
	private java.lang.String generalInterest;
	private java.lang.String dislike;
	private java.lang.String likes;
	private java.lang.String strength;
	private java.lang.String weekness;
	private java.lang.String phicNo;
	private java.lang.String tinNo;
	private java.lang.String panNo;
	private java.lang.String motherName;
	private java.lang.String spouseName;
	private java.lang.Integer noOfChildren;
	private java.lang.Float height;
	private java.lang.Float weight;
	private java.lang.String educationType;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MasTribe tribe;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hrms.masters.business.MasNationality nationality;
	private jkt.hrms.masters.business.MasApplicant applicant;
	private jkt.hms.masters.business.MasReligion religion;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: father_name
	 */
	public java.lang.String getFatherName() {
		return fatherName;
	}

	/**
	 * Set the value related to the column: father_name
	 * 
	 * @param fatherName
	 *            the father_name value
	 */
	public void setFatherName(java.lang.String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * Return the value associated with the column: place_of_birth
	 */
	public java.lang.String getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * Set the value related to the column: place_of_birth
	 * 
	 * @param placeOfBirth
	 *            the place_of_birth value
	 */
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * 
	 * @param dateOfBirth
	 *            the date_of_birth value
	 */
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender() {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * 
	 * @param gender
	 *            the gender value
	 */
	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}

	/**
	 * Return the value associated with the column: ssc_no
	 */
	public java.lang.String getSscNo() {
		return sscNo;
	}

	/**
	 * Set the value related to the column: ssc_no
	 * 
	 * @param sscNo
	 *            the ssc_no value
	 */
	public void setSscNo(java.lang.String sscNo) {
		this.sscNo = sscNo;
	}

	/**
	 * Return the value associated with the column: passport_no
	 */
	public java.lang.String getPassportNo() {
		return passportNo;
	}

	/**
	 * Set the value related to the column: passport_no
	 * 
	 * @param passportNo
	 *            the passport_no value
	 */
	public void setPassportNo(java.lang.String passportNo) {
		this.passportNo = passportNo;
	}

	/**
	 * Return the value associated with the column: driving_licence_no
	 */
	public java.lang.String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}

	/**
	 * Set the value related to the column: driving_licence_no
	 * 
	 * @param drivingLicenceNo
	 *            the driving_licence_no value
	 */
	public void setDrivingLicenceNo(java.lang.String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}

	/**
	 * Return the value associated with the column: emg_person_name
	 */
	public java.lang.String getEmgPersonName() {
		return emgPersonName;
	}

	/**
	 * Set the value related to the column: emg_person_name
	 * 
	 * @param emgPersonName
	 *            the emg_person_name value
	 */
	public void setEmgPersonName(java.lang.String emgPersonName) {
		this.emgPersonName = emgPersonName;
	}

	/**
	 * Return the value associated with the column: emg_contact_no
	 */
	public java.lang.String getEmgContactNo() {
		return emgContactNo;
	}

	/**
	 * Set the value related to the column: emg_contact_no
	 * 
	 * @param emgContactNo
	 *            the emg_contact_no value
	 */
	public void setEmgContactNo(java.lang.String emgContactNo) {
		this.emgContactNo = emgContactNo;
	}

	/**
	 * Return the value associated with the column: emg_address
	 */
	public java.lang.String getEmgAddress() {
		return emgAddress;
	}

	/**
	 * Set the value related to the column: emg_address
	 * 
	 * @param emgAddress
	 *            the emg_address value
	 */
	public void setEmgAddress(java.lang.String emgAddress) {
		this.emgAddress = emgAddress;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: martial_status
	 */
	public java.lang.String getMartialStatus() {
		return martialStatus;
	}

	/**
	 * Set the value related to the column: martial_status
	 * 
	 * @param martialStatus
	 *            the martial_status value
	 */
	public void setMartialStatus(java.lang.String martialStatus) {
		this.martialStatus = martialStatus;
	}

	/**
	 * Return the value associated with the column: general_interest
	 */
	public java.lang.String getGeneralInterest() {
		return generalInterest;
	}

	/**
	 * Set the value related to the column: general_interest
	 * 
	 * @param generalInterest
	 *            the general_interest value
	 */
	public void setGeneralInterest(java.lang.String generalInterest) {
		this.generalInterest = generalInterest;
	}

	/**
	 * Return the value associated with the column: dislike
	 */
	public java.lang.String getDislike() {
		return dislike;
	}

	/**
	 * Set the value related to the column: dislike
	 * 
	 * @param dislike
	 *            the dislike value
	 */
	public void setDislike(java.lang.String dislike) {
		this.dislike = dislike;
	}

	/**
	 * Return the value associated with the column: likes
	 */
	public java.lang.String getLikes() {
		return likes;
	}

	/**
	 * Set the value related to the column: likes
	 * 
	 * @param likes
	 *            the likes value
	 */
	public void setLikes(java.lang.String likes) {
		this.likes = likes;
	}

	/**
	 * Return the value associated with the column: strength
	 */
	public java.lang.String getStrength() {
		return strength;
	}

	/**
	 * Set the value related to the column: strength
	 * 
	 * @param strength
	 *            the strength value
	 */
	public void setStrength(java.lang.String strength) {
		this.strength = strength;
	}

	/**
	 * Return the value associated with the column: weekness
	 */
	public java.lang.String getWeekness() {
		return weekness;
	}

	/**
	 * Set the value related to the column: weekness
	 * 
	 * @param weekness
	 *            the weekness value
	 */
	public void setWeekness(java.lang.String weekness) {
		this.weekness = weekness;
	}

	/**
	 * Return the value associated with the column: phic_no
	 */
	public java.lang.String getPhicNo() {
		return phicNo;
	}

	/**
	 * Set the value related to the column: phic_no
	 * 
	 * @param phicNo
	 *            the phic_no value
	 */
	public void setPhicNo(java.lang.String phicNo) {
		this.phicNo = phicNo;
	}

	/**
	 * Return the value associated with the column: tin_no
	 */
	public java.lang.String getTinNo() {
		return tinNo;
	}

	/**
	 * Set the value related to the column: tin_no
	 * 
	 * @param tinNo
	 *            the tin_no value
	 */
	public void setTinNo(java.lang.String tinNo) {
		this.tinNo = tinNo;
	}

	/**
	 * Return the value associated with the column: pan_no
	 */
	public java.lang.String getPanNo() {
		return panNo;
	}

	/**
	 * Set the value related to the column: pan_no
	 * 
	 * @param panNo
	 *            the pan_no value
	 */
	public void setPanNo(java.lang.String panNo) {
		this.panNo = panNo;
	}

	/**
	 * Return the value associated with the column: mother_name
	 */
	public java.lang.String getMotherName() {
		return motherName;
	}

	/**
	 * Set the value related to the column: mother_name
	 * 
	 * @param motherName
	 *            the mother_name value
	 */
	public void setMotherName(java.lang.String motherName) {
		this.motherName = motherName;
	}

	/**
	 * Return the value associated with the column: spouse_name
	 */
	public java.lang.String getSpouseName() {
		return spouseName;
	}

	/**
	 * Set the value related to the column: spouse_name
	 * 
	 * @param spouseName
	 *            the spouse_name value
	 */
	public void setSpouseName(java.lang.String spouseName) {
		this.spouseName = spouseName;
	}

	/**
	 * Return the value associated with the column: no_of_children
	 */
	public java.lang.Integer getNoOfChildren() {
		return noOfChildren;
	}

	/**
	 * Set the value related to the column: no_of_children
	 * 
	 * @param noOfChildren
	 *            the no_of_children value
	 */
	public void setNoOfChildren(java.lang.Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.Float getHeight() {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * 
	 * @param height
	 *            the height value
	 */
	public void setHeight(java.lang.Float height) {
		this.height = height;
	}

	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.Float getWeight() {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * 
	 * @param weight
	 *            the weight value
	 */
	public void setWeight(java.lang.Float weight) {
		this.weight = weight;
	}

	/**
	 * Return the value associated with the column: education_type
	 */
	public java.lang.String getEducationType() {
		return educationType;
	}

	/**
	 * Set the value related to the column: education_type
	 * 
	 * @param educationType
	 *            the education_type value
	 */
	public void setEducationType(java.lang.String educationType) {
		this.educationType = educationType;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: tribe_id
	 */
	public jkt.hrms.masters.business.MasTribe getTribe() {
		return tribe;
	}

	/**
	 * Set the value related to the column: tribe_id
	 * 
	 * @param tribe
	 *            the tribe_id value
	 */
	public void setTribe(jkt.hrms.masters.business.MasTribe tribe) {
		this.tribe = tribe;
	}

	/**
	 * Return the value associated with the column: country_id
	 */
	public jkt.hms.masters.business.MasCountry getCountry() {
		return country;
	}

	/**
	 * Set the value related to the column: country_id
	 * 
	 * @param country
	 *            the country_id value
	 */
	public void setCountry(jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}

	/**
	 * Return the value associated with the column: nationality_id
	 */
	public jkt.hrms.masters.business.MasNationality getNationality() {
		return nationality;
	}

	/**
	 * Set the value related to the column: nationality_id
	 * 
	 * @param nationality
	 *            the nationality_id value
	 */
	public void setNationality(
			jkt.hrms.masters.business.MasNationality nationality) {
		this.nationality = nationality;
	}

	/**
	 * Return the value associated with the column: applicant_id
	 */
	public jkt.hrms.masters.business.MasApplicant getApplicant() {
		return applicant;
	}

	/**
	 * Set the value related to the column: applicant_id
	 * 
	 * @param applicant
	 *            the applicant_id value
	 */
	public void setApplicant(jkt.hrms.masters.business.MasApplicant applicant) {
		this.applicant = applicant;
	}

	/**
	 * Return the value associated with the column: religion_id
	 */
	public jkt.hms.masters.business.MasReligion getReligion() {
		return religion;
	}

	/**
	 * Set the value related to the column: religion_id
	 * 
	 * @param religion
	 *            the religion_id value
	 */
	public void setReligion(jkt.hms.masters.business.MasReligion religion) {
		this.religion = religion;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.ApplicantPersonal)) {
			return false;
		} else {
			jkt.hrms.masters.business.ApplicantPersonal applicantPersonal = (jkt.hrms.masters.business.ApplicantPersonal) obj;
			if (null == this.getId() || null == applicantPersonal.getId()) {
				return false;
			} else {
				return (this.getId().equals(applicantPersonal.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}