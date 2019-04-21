package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_birth_death_reg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_birth_death_reg"
 */

public abstract class BasePhBirthDeathReg  implements Serializable {

	public static String REF = "PhBirthDeathReg";
	public static String PROP_BABY_NAME = "BabyName";
	public static String PROP_MEMBER = "Member";
	public static String PROP_DISEASE_AT_DEATH_TIME = "DiseaseAtDeathTime";
	public static String PROP_BABY_UHID = "BabyUhid";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AT_DISTRICT = "AtDistrict";
	public static String PROP_AT_STATE = "AtState";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REG_TYPE = "RegType";
	public static String PROP_DELIVERY_PLACE = "DeliveryPlace";
	public static String PROP_LAT_LONG = "LatLong";
	public static String PROP_AT_LSG = "AtLsg";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_BIRTH_WEIGTH = "BirthWeigth";
	public static String PROP_CERTIFICATE_NO = "CertificateNo";
	public static String PROP_TERM = "Term";
	public static String PROP_DOB_DEATH_DATE = "DobDeathDate";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_DELIVERY_TYPE = "DeliveryType";
	public static String PROP_GENDER = "Gender";
	public static String PROP_ID = "Id";
	public static String PROP_CAUSE_OF_DEATH = "CauseOfDeath";
	public static String PROP_STASUS = "Stasus";
	public static String PROP_BABY_CONDITION = "BabyCondition";


	// constructors
	public BasePhBirthDeathReg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhBirthDeathReg (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhBirthDeathReg (
		java.lang.Integer id,
		jkt.hms.masters.business.PhMemberSurvey member) {

		this.setId(id);
		this.setMember(member);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date regDate;
	private java.lang.String regType;
	private java.lang.String certificateNo;
	private java.util.Date dobDeathDate;
	private java.lang.Long atState;
	private java.lang.Long atDistrict;
	private java.lang.Long atLsg;
	private java.lang.Long gender;
	private java.lang.String causeOfDeath;
	private java.lang.String diseaseAtDeathTime;
	private java.lang.String remarks;
	private java.lang.String stasus;
	private java.lang.String latLong;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String babyName;
	private java.lang.Long babyUhid;
	private java.lang.String term;
	private java.lang.String hospitalName;
	private java.lang.String babyCondition;
	private java.math.BigDecimal birthWeigth;
	private java.lang.String deliveryPlace;

	// many to one
	private jkt.hms.masters.business.MasDeliveryType deliveryType;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.PhMemberSurvey member;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="reg_id"
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
	 * Return the value associated with the column: reg_date
	 */
	public java.util.Date getRegDate () {
		return regDate;
	}

	/**
	 * Set the value related to the column: reg_date
	 * @param regDate the reg_date value
	 */
	public void setRegDate (java.util.Date regDate) {
		this.regDate = regDate;
	}



	/**
	 * Return the value associated with the column: reg_type
	 */
	public java.lang.String getRegType () {
		return regType;
	}

	/**
	 * Set the value related to the column: reg_type
	 * @param regType the reg_type value
	 */
	public void setRegType (java.lang.String regType) {
		this.regType = regType;
	}



	/**
	 * Return the value associated with the column: certificate_no
	 */
	public java.lang.String getCertificateNo () {
		return certificateNo;
	}

	/**
	 * Set the value related to the column: certificate_no
	 * @param certificateNo the certificate_no value
	 */
	public void setCertificateNo (java.lang.String certificateNo) {
		this.certificateNo = certificateNo;
	}



	/**
	 * Return the value associated with the column: dob_death_date
	 */
	public java.util.Date getDobDeathDate () {
		return dobDeathDate;
	}

	/**
	 * Set the value related to the column: dob_death_date
	 * @param dobDeathDate the dob_death_date value
	 */
	public void setDobDeathDate (java.util.Date dobDeathDate) {
		this.dobDeathDate = dobDeathDate;
	}



	/**
	 * Return the value associated with the column: at_state
	 */
	public java.lang.Long getAtState () {
		return atState;
	}

	/**
	 * Set the value related to the column: at_state
	 * @param atState the at_state value
	 */
	public void setAtState (java.lang.Long atState) {
		this.atState = atState;
	}



	/**
	 * Return the value associated with the column: at_district
	 */
	public java.lang.Long getAtDistrict () {
		return atDistrict;
	}

	/**
	 * Set the value related to the column: at_district
	 * @param atDistrict the at_district value
	 */
	public void setAtDistrict (java.lang.Long atDistrict) {
		this.atDistrict = atDistrict;
	}



	/**
	 * Return the value associated with the column: at_lsg
	 */
	public java.lang.Long getAtLsg () {
		return atLsg;
	}

	/**
	 * Set the value related to the column: at_lsg
	 * @param atLsg the at_lsg value
	 */
	public void setAtLsg (java.lang.Long atLsg) {
		this.atLsg = atLsg;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.Long getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (java.lang.Long gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: cause_of_death
	 */
	public java.lang.String getCauseOfDeath () {
		return causeOfDeath;
	}

	/**
	 * Set the value related to the column: cause_of_death
	 * @param causeOfDeath the cause_of_death value
	 */
	public void setCauseOfDeath (java.lang.String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}



	/**
	 * Return the value associated with the column: disease_at_death_time
	 */
	public java.lang.String getDiseaseAtDeathTime () {
		return diseaseAtDeathTime;
	}

	/**
	 * Set the value related to the column: disease_at_death_time
	 * @param diseaseAtDeathTime the disease_at_death_time value
	 */
	public void setDiseaseAtDeathTime (java.lang.String diseaseAtDeathTime) {
		this.diseaseAtDeathTime = diseaseAtDeathTime;
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
	 * Return the value associated with the column: stasus
	 */
	public java.lang.String getStasus () {
		return stasus;
	}

	/**
	 * Set the value related to the column: stasus
	 * @param stasus the stasus value
	 */
	public void setStasus (java.lang.String stasus) {
		this.stasus = stasus;
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
	 * Return the value associated with the column: baby_name
	 */
	public java.lang.String getBabyName () {
		return babyName;
	}

	/**
	 * Set the value related to the column: baby_name
	 * @param babyName the baby_name value
	 */
	public void setBabyName (java.lang.String babyName) {
		this.babyName = babyName;
	}



	/**
	 * Return the value associated with the column: baby_uhid
	 */
	public java.lang.Long getBabyUhid () {
		return babyUhid;
	}

	/**
	 * Set the value related to the column: baby_uhid
	 * @param babyUhid the baby_uhid value
	 */
	public void setBabyUhid (java.lang.Long babyUhid) {
		this.babyUhid = babyUhid;
	}



	/**
	 * Return the value associated with the column: term
	 */
	public java.lang.String getTerm () {
		return term;
	}

	/**
	 * Set the value related to the column: term
	 * @param term the term value
	 */
	public void setTerm (java.lang.String term) {
		this.term = term;
	}



	/**
	 * Return the value associated with the column: hospital_name
	 */
	public java.lang.String getHospitalName () {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: hospital_name
	 * @param hospitalName the hospital_name value
	 */
	public void setHospitalName (java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
	}



	/**
	 * Return the value associated with the column: baby_condition
	 */
	public java.lang.String getBabyCondition () {
		return babyCondition;
	}

	/**
	 * Set the value related to the column: baby_condition
	 * @param babyCondition the baby_condition value
	 */
	public void setBabyCondition (java.lang.String babyCondition) {
		this.babyCondition = babyCondition;
	}



	/**
	 * Return the value associated with the column: birth_weigth
	 */
	public java.math.BigDecimal getBirthWeigth () {
		return birthWeigth;
	}

	/**
	 * Set the value related to the column: birth_weigth
	 * @param birthWeigth the birth_weigth value
	 */
	public void setBirthWeigth (java.math.BigDecimal birthWeigth) {
		this.birthWeigth = birthWeigth;
	}



	/**
	 * Return the value associated with the column: delivery_place
	 */
	public java.lang.String getDeliveryPlace () {
		return deliveryPlace;
	}

	/**
	 * Set the value related to the column: delivery_place
	 * @param deliveryPlace the delivery_place value
	 */
	public void setDeliveryPlace (java.lang.String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}



	/**
	 * Return the value associated with the column: delivery_type
	 */
	public jkt.hms.masters.business.MasDeliveryType getDeliveryType () {
		return deliveryType;
	}

	/**
	 * Set the value related to the column: delivery_type
	 * @param deliveryType the delivery_type value
	 */
	public void setDeliveryType (jkt.hms.masters.business.MasDeliveryType deliveryType) {
		this.deliveryType = deliveryType;
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
	 * Return the value associated with the column: member_id
	 */
	public jkt.hms.masters.business.PhMemberSurvey getMember () {
		return member;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param member the member_id value
	 */
	public void setMember (jkt.hms.masters.business.PhMemberSurvey member) {
		this.member = member;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhBirthDeathReg)) return false;
		else {
			jkt.hms.masters.business.PhBirthDeathReg phBirthDeathReg = (jkt.hms.masters.business.PhBirthDeathReg) obj;
			if (null == this.getId() || null == phBirthDeathReg.getId()) return false;
			else return (this.getId().equals(phBirthDeathReg.getId()));
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