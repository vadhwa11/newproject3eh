package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the birthdeathreg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="birthdeathreg"
 */

public abstract class BaseBirthdeathreg  implements Serializable {

	public static String REF = "Birthdeathreg";
	public static String PROP_FINAL_DIAGNOSIS = "FinalDiagnosis";
	public static String PROP_DOD = "Dod";
	public static String PROP_NO_OF_COPIES = "NoOfCopies";
	public static String PROP_ANTENATAL_CHECKUP = "AntenatalCheckup";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_CONDITION_ATDISCHARGE = "ConditionAtdischarge";
	public static String PROP_ANY_CONG_ABNORMALITY = "AnyCongAbnormality";
	public static String PROP_DATE_OF_ADM_OF_MOTHER = "DateOfAdmOfMother";
	public static String PROP_DOB = "Dob";
	public static String PROP_ADDRESS_DEATH = "AddressDeath";
	public static String PROP_BIRTH_CERTIFICATE_NO = "BirthCertificateNo";
	public static String PROP_EMP = "Emp";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TIME = "Time";
	public static String PROP_DATE_OF_ISSUE = "DateOfIssue";
	public static String PROP_CRY = "Cry";
	public static String PROP_BIRTH_WEIGHT = "BirthWeight";
	public static String PROP_BABY_DELIVERY_DATE = "BabyDeliveryDate";
	public static String PROP_ADDRESS_PERMANENT = "AddressPermanent";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_BDTYPE = "Bdtype";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_BABY_DELIVERY_TIME = "BabyDeliveryTime";
	public static String PROP_INJURY_OCCUR = "InjuryOccur";
	public static String PROP_OTHER_SIGNIFICANT_CONDITION = "OtherSignificantCondition";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DECEASED_FEMALE_PREGNANCY_DELIVERY = "DeceasedFemalePregnancyDelivery";
	public static String PROP_EXPIRY_DETAILS = "ExpiryDetails";
	public static String PROP_COLOR = "Color";
	public static String PROP_MNAME = "Mname";
	public static String PROP_NAME = "Name";
	public static String PROP_ANTECEDENT_CAUSE = "AntecedentCause";
	public static String PROP_DECEASED_FEMALE_PREGNANCY_DEATH = "DeceasedFemalePregnancyDeath";
	public static String PROP_DELIVERY_TYPE = "DeliveryType";
	public static String PROP_FNAME = "Fname";
	public static String PROP_APGAR_SCORE_AT_BIRTH = "ApgarScoreAtBirth";
	public static String PROP_IMMEDIATE_CAUSE = "ImmediateCause";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_ADMINISTRATIVE_SEX = "AdministrativeSex";
	public static String PROP_DISCHARGE_DATE = "DischargeDate";
	public static String PROP_DOR = "Dor";
	public static String PROP_REGNO = "Regno";
	public static String PROP_RESUSCITATINO = "Resuscitatino";
	public static String PROP_BABY_STATUS = "BabyStatus";


	// constructors
	public BaseBirthdeathreg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBirthdeathreg (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String regno;
	private java.lang.String name;
	private java.lang.String fname;
	private java.lang.String mname;
	private java.util.Date dob;
	private java.util.Date dor;
	private java.lang.String bdtype;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date dod;
	private java.util.Date dateOfIssue;
	private java.lang.String remarks;
	private java.lang.String addressDeath;
	private java.lang.String addressPermanent;
	private java.lang.Integer noOfCopies;
	private java.lang.Integer amount;
	private java.lang.String time;
	private java.lang.String antenatalCheckup;
	private java.util.Date dateOfAdmOfMother;
	private java.util.Date babyDeliveryDate;
	private java.lang.String babyDeliveryTime;
	private java.lang.String deliveryType;
	private java.lang.String babyStatus;
	private java.lang.String cry;
	private java.lang.String color;
	private java.lang.String resuscitatino;
	private java.lang.String anyCongAbnormality;
	private java.lang.String apgarScoreAtBirth;
	private java.math.BigDecimal birthWeight;
	private java.lang.String finalDiagnosis;
	private java.util.Date dischargeDate;
	private java.lang.String conditionAtdischarge;
	private java.lang.Integer birthCertificateNo;
	private java.lang.String immediateCause;
	private java.lang.String antecedentCause;
	private java.lang.String otherSignificantCondition;
	private java.lang.String injuryOccur;
	private java.lang.String deceasedFemalePregnancyDeath;
	private java.lang.String deceasedFemalePregnancyDelivery;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.ExpiryDetails expiryDetails;
	private jkt.hms.masters.business.MasAdministrativeSex administrativeSex;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="birthdeath_id"
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
	 * Return the value associated with the column: regno
	 */
	public java.lang.String getRegno () {
		return regno;
	}

	/**
	 * Set the value related to the column: regno
	 * @param regno the regno value
	 */
	public void setRegno (java.lang.String regno) {
		this.regno = regno;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: fname
	 */
	public java.lang.String getFname () {
		return fname;
	}

	/**
	 * Set the value related to the column: fname
	 * @param fname the fname value
	 */
	public void setFname (java.lang.String fname) {
		this.fname = fname;
	}



	/**
	 * Return the value associated with the column: mname
	 */
	public java.lang.String getMname () {
		return mname;
	}

	/**
	 * Set the value related to the column: mname
	 * @param mname the mname value
	 */
	public void setMname (java.lang.String mname) {
		this.mname = mname;
	}



	/**
	 * Return the value associated with the column: dob
	 */
	public java.util.Date getDob () {
		return dob;
	}

	/**
	 * Set the value related to the column: dob
	 * @param dob the dob value
	 */
	public void setDob (java.util.Date dob) {
		this.dob = dob;
	}



	/**
	 * Return the value associated with the column: dor
	 */
	public java.util.Date getDor () {
		return dor;
	}

	/**
	 * Set the value related to the column: dor
	 * @param dor the dor value
	 */
	public void setDor (java.util.Date dor) {
		this.dor = dor;
	}



	/**
	 * Return the value associated with the column: bdtype
	 */
	public java.lang.String getBdtype () {
		return bdtype;
	}

	/**
	 * Set the value related to the column: bdtype
	 * @param bdtype the bdtype value
	 */
	public void setBdtype (java.lang.String bdtype) {
		this.bdtype = bdtype;
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
	 * Return the value associated with the column: dod
	 */
	public java.util.Date getDod () {
		return dod;
	}

	/**
	 * Set the value related to the column: dod
	 * @param dod the dod value
	 */
	public void setDod (java.util.Date dod) {
		this.dod = dod;
	}



	/**
	 * Return the value associated with the column: date_of_issue
	 */
	public java.util.Date getDateOfIssue () {
		return dateOfIssue;
	}

	/**
	 * Set the value related to the column: date_of_issue
	 * @param dateOfIssue the date_of_issue value
	 */
	public void setDateOfIssue (java.util.Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
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
	 * Return the value associated with the column: address_death
	 */
	public java.lang.String getAddressDeath () {
		return addressDeath;
	}

	/**
	 * Set the value related to the column: address_death
	 * @param addressDeath the address_death value
	 */
	public void setAddressDeath (java.lang.String addressDeath) {
		this.addressDeath = addressDeath;
	}



	/**
	 * Return the value associated with the column: address_permanent
	 */
	public java.lang.String getAddressPermanent () {
		return addressPermanent;
	}

	/**
	 * Set the value related to the column: address_permanent
	 * @param addressPermanent the address_permanent value
	 */
	public void setAddressPermanent (java.lang.String addressPermanent) {
		this.addressPermanent = addressPermanent;
	}



	/**
	 * Return the value associated with the column: no_of_copies
	 */
	public java.lang.Integer getNoOfCopies () {
		return noOfCopies;
	}

	/**
	 * Set the value related to the column: no_of_copies
	 * @param noOfCopies the no_of_copies value
	 */
	public void setNoOfCopies (java.lang.Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.lang.Integer getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.lang.Integer amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getTime () {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * @param time the time value
	 */
	public void setTime (java.lang.String time) {
		this.time = time;
	}



	/**
	 * Return the value associated with the column: antenatal_checkup
	 */
	public java.lang.String getAntenatalCheckup () {
		return antenatalCheckup;
	}

	/**
	 * Set the value related to the column: antenatal_checkup
	 * @param antenatalCheckup the antenatal_checkup value
	 */
	public void setAntenatalCheckup (java.lang.String antenatalCheckup) {
		this.antenatalCheckup = antenatalCheckup;
	}



	/**
	 * Return the value associated with the column: date_of_adm_of_mother
	 */
	public java.util.Date getDateOfAdmOfMother () {
		return dateOfAdmOfMother;
	}

	/**
	 * Set the value related to the column: date_of_adm_of_mother
	 * @param dateOfAdmOfMother the date_of_adm_of_mother value
	 */
	public void setDateOfAdmOfMother (java.util.Date dateOfAdmOfMother) {
		this.dateOfAdmOfMother = dateOfAdmOfMother;
	}



	/**
	 * Return the value associated with the column: baby_delivery_date
	 */
	public java.util.Date getBabyDeliveryDate () {
		return babyDeliveryDate;
	}

	/**
	 * Set the value related to the column: baby_delivery_date
	 * @param babyDeliveryDate the baby_delivery_date value
	 */
	public void setBabyDeliveryDate (java.util.Date babyDeliveryDate) {
		this.babyDeliveryDate = babyDeliveryDate;
	}



	/**
	 * Return the value associated with the column: baby_delivery_time
	 */
	public java.lang.String getBabyDeliveryTime () {
		return babyDeliveryTime;
	}

	/**
	 * Set the value related to the column: baby_delivery_time
	 * @param babyDeliveryTime the baby_delivery_time value
	 */
	public void setBabyDeliveryTime (java.lang.String babyDeliveryTime) {
		this.babyDeliveryTime = babyDeliveryTime;
	}



	/**
	 * Return the value associated with the column: delivery_Type
	 */
	public java.lang.String getDeliveryType () {
		return deliveryType;
	}

	/**
	 * Set the value related to the column: delivery_Type
	 * @param deliveryType the delivery_Type value
	 */
	public void setDeliveryType (java.lang.String deliveryType) {
		this.deliveryType = deliveryType;
	}



	/**
	 * Return the value associated with the column: baby_status
	 */
	public java.lang.String getBabyStatus () {
		return babyStatus;
	}

	/**
	 * Set the value related to the column: baby_status
	 * @param babyStatus the baby_status value
	 */
	public void setBabyStatus (java.lang.String babyStatus) {
		this.babyStatus = babyStatus;
	}



	/**
	 * Return the value associated with the column: cry
	 */
	public java.lang.String getCry () {
		return cry;
	}

	/**
	 * Set the value related to the column: cry
	 * @param cry the cry value
	 */
	public void setCry (java.lang.String cry) {
		this.cry = cry;
	}



	/**
	 * Return the value associated with the column: color
	 */
	public java.lang.String getColor () {
		return color;
	}

	/**
	 * Set the value related to the column: color
	 * @param color the color value
	 */
	public void setColor (java.lang.String color) {
		this.color = color;
	}



	/**
	 * Return the value associated with the column: resuscitatino
	 */
	public java.lang.String getResuscitatino () {
		return resuscitatino;
	}

	/**
	 * Set the value related to the column: resuscitatino
	 * @param resuscitatino the resuscitatino value
	 */
	public void setResuscitatino (java.lang.String resuscitatino) {
		this.resuscitatino = resuscitatino;
	}



	/**
	 * Return the value associated with the column: any_cong_abnormality
	 */
	public java.lang.String getAnyCongAbnormality () {
		return anyCongAbnormality;
	}

	/**
	 * Set the value related to the column: any_cong_abnormality
	 * @param anyCongAbnormality the any_cong_abnormality value
	 */
	public void setAnyCongAbnormality (java.lang.String anyCongAbnormality) {
		this.anyCongAbnormality = anyCongAbnormality;
	}



	/**
	 * Return the value associated with the column: apgar_score_atbirth
	 */
	public java.lang.String getApgarScoreAtBirth () {
		return apgarScoreAtBirth;
	}

	/**
	 * Set the value related to the column: apgar_score_atbirth
	 * @param apgarScoreAtBirth the apgar_score_atbirth value
	 */
	public void setApgarScoreAtBirth (java.lang.String apgarScoreAtBirth) {
		this.apgarScoreAtBirth = apgarScoreAtBirth;
	}



	/**
	 * Return the value associated with the column: birth_weight
	 */
	public java.math.BigDecimal getBirthWeight () {
		return birthWeight;
	}

	/**
	 * Set the value related to the column: birth_weight
	 * @param birthWeight the birth_weight value
	 */
	public void setBirthWeight (java.math.BigDecimal birthWeight) {
		this.birthWeight = birthWeight;
	}



	/**
	 * Return the value associated with the column: final_diagnosis
	 */
	public java.lang.String getFinalDiagnosis () {
		return finalDiagnosis;
	}

	/**
	 * Set the value related to the column: final_diagnosis
	 * @param finalDiagnosis the final_diagnosis value
	 */
	public void setFinalDiagnosis (java.lang.String finalDiagnosis) {
		this.finalDiagnosis = finalDiagnosis;
	}



	/**
	 * Return the value associated with the column: dischargeDate
	 */
	public java.util.Date getDischargeDate () {
		return dischargeDate;
	}

	/**
	 * Set the value related to the column: dischargeDate
	 * @param dischargeDate the dischargeDate value
	 */
	public void setDischargeDate (java.util.Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}



	/**
	 * Return the value associated with the column: condition_atdischarge
	 */
	public java.lang.String getConditionAtdischarge () {
		return conditionAtdischarge;
	}

	/**
	 * Set the value related to the column: condition_atdischarge
	 * @param conditionAtdischarge the condition_atdischarge value
	 */
	public void setConditionAtdischarge (java.lang.String conditionAtdischarge) {
		this.conditionAtdischarge = conditionAtdischarge;
	}



	/**
	 * Return the value associated with the column: birth_certificate_no
	 */
	public java.lang.Integer getBirthCertificateNo () {
		return birthCertificateNo;
	}

	/**
	 * Set the value related to the column: birth_certificate_no
	 * @param birthCertificateNo the birth_certificate_no value
	 */
	public void setBirthCertificateNo (java.lang.Integer birthCertificateNo) {
		this.birthCertificateNo = birthCertificateNo;
	}



	/**
	 * Return the value associated with the column: immediate_cause
	 */
	public java.lang.String getImmediateCause () {
		return immediateCause;
	}

	/**
	 * Set the value related to the column: immediate_cause
	 * @param immediateCause the immediate_cause value
	 */
	public void setImmediateCause (java.lang.String immediateCause) {
		this.immediateCause = immediateCause;
	}



	/**
	 * Return the value associated with the column: antecedent_cause
	 */
	public java.lang.String getAntecedentCause () {
		return antecedentCause;
	}

	/**
	 * Set the value related to the column: antecedent_cause
	 * @param antecedentCause the antecedent_cause value
	 */
	public void setAntecedentCause (java.lang.String antecedentCause) {
		this.antecedentCause = antecedentCause;
	}



	/**
	 * Return the value associated with the column: other_significant_condition
	 */
	public java.lang.String getOtherSignificantCondition () {
		return otherSignificantCondition;
	}

	/**
	 * Set the value related to the column: other_significant_condition
	 * @param otherSignificantCondition the other_significant_condition value
	 */
	public void setOtherSignificantCondition (java.lang.String otherSignificantCondition) {
		this.otherSignificantCondition = otherSignificantCondition;
	}



	/**
	 * Return the value associated with the column: injury_occur
	 */
	public java.lang.String getInjuryOccur () {
		return injuryOccur;
	}

	/**
	 * Set the value related to the column: injury_occur
	 * @param injuryOccur the injury_occur value
	 */
	public void setInjuryOccur (java.lang.String injuryOccur) {
		this.injuryOccur = injuryOccur;
	}



	/**
	 * Return the value associated with the column: deceased_female_pregnancy_death
	 */
	public java.lang.String getDeceasedFemalePregnancyDeath () {
		return deceasedFemalePregnancyDeath;
	}

	/**
	 * Set the value related to the column: deceased_female_pregnancy_death
	 * @param deceasedFemalePregnancyDeath the deceased_female_pregnancy_death value
	 */
	public void setDeceasedFemalePregnancyDeath (java.lang.String deceasedFemalePregnancyDeath) {
		this.deceasedFemalePregnancyDeath = deceasedFemalePregnancyDeath;
	}



	/**
	 * Return the value associated with the column: deceased_female_pregnancy_delivery
	 */
	public java.lang.String getDeceasedFemalePregnancyDelivery () {
		return deceasedFemalePregnancyDelivery;
	}

	/**
	 * Set the value related to the column: deceased_female_pregnancy_delivery
	 * @param deceasedFemalePregnancyDelivery the deceased_female_pregnancy_delivery value
	 */
	public void setDeceasedFemalePregnancyDelivery (java.lang.String deceasedFemalePregnancyDelivery) {
		this.deceasedFemalePregnancyDelivery = deceasedFemalePregnancyDelivery;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp () {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param emp the emp_id value
	 */
	public void setEmp (jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}



	/**
	 * Return the value associated with the column: expiry_details_id
	 */
	public jkt.hms.masters.business.ExpiryDetails getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: expiry_details_id
	 * @param expiryDetails the expiry_details_id value
	 */
	public void setExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		this.expiryDetails = expiryDetails;
	}



	/**
	 * Return the value associated with the column: administrative_sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getAdministrativeSex () {
		return administrativeSex;
	}

	/**
	 * Set the value related to the column: administrative_sex_id
	 * @param administrativeSex the administrative_sex_id value
	 */
	public void setAdministrativeSex (jkt.hms.masters.business.MasAdministrativeSex administrativeSex) {
		this.administrativeSex = administrativeSex;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Birthdeathreg)) return false;
		else {
			jkt.hms.masters.business.Birthdeathreg birthdeathreg = (jkt.hms.masters.business.Birthdeathreg) obj;
			if (null == this.getId() || null == birthdeathreg.getId()) return false;
			else return (this.getId().equals(birthdeathreg.getId()));
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