package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_antenatal_registration_survey table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_antenatal_registration_survey"
 */

public abstract class BasePhAntenatalRegistrationSurvey  implements Serializable {

	public static String REF = "PhAntenatalRegistrationSurvey";
	public static String PROP_BANKNAME = "Bankname";
	public static String PROP_IFSC_CODE = "IfscCode";
	public static String PROP_AGE = "Age";
	public static String PROP_BLOOD_PRESSURE = "BloodPressure";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PHC_NAME = "PhcName";
	public static String PROP_VDRL = "Vdrl";
	public static String PROP_HUSBAND_NAME = "HusbandName";
	public static String PROP_ANC_STATUS = "AncStatus";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_NAME_SUBCENTER = "NameSubcenter";
	public static String PROP_HIV_STATUS = "HivStatus";
	public static String PROP_COMPLICATION = "Complication";
	public static String PROP_BPL_CARD_NO = "BplCardNo";
	public static String PROP_HBSAG = "Hbsag";
	public static String PROP_HB = "Hb";
	public static String PROP_HOUSE_ID = "HouseId";
	public static String PROP_ULTRASOUND = "Ultrasound";
	public static String PROP_JSY_FLAG = "JsyFlag";
	public static String PROP_PARITY = "Parity";
	public static String PROP_SUB_CENTRE = "SubCentre";
	public static String PROP_FAMILY_ID = "FamilyId";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_GRAVIDA = "Gravida";
	public static String PROP_SERVER_PK = "ServerPk";
	public static String PROP_BPL_STATUS = "BplStatus";
	public static String PROP_ACC_NO = "AccNo";
	public static String PROP_URINE_SUGAR = "UrineSugar";
	public static String PROP_ABO_RH = "AboRh";
	public static String PROP_ABORTIONS = "Abortions";
	public static String PROP_STATUS = "Status";
	public static String PROP_EDC = "Edc";
	public static String PROP_ANC_REG_ID = "AncRegId";
	public static String PROP_PALLOR = "Pallor";
	public static String PROP_TSH = "Tsh";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_LMP_DATE = "LmpDate";
	public static String PROP_NAME_PHC = "NamePhc";
	public static String PROP_ID = "Id";
	public static String PROP_URINE_ALBUMIN = "UrineAlbumin";
	public static String PROP_NAME_OF_PREGNANT = "NameOfPregnant";
	public static String PROP_CARD_IMAGE = "CardImage";
	public static String PROP_ADHAAR_NO = "AdhaarNo";
	public static String PROP_MEMBER_NAME = "MemberName";


	// constructors
	public BasePhAntenatalRegistrationSurvey () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhAntenatalRegistrationSurvey (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.util.Date regDate;
	private java.lang.Long serverPk;
	private java.lang.Long memberId;
	private java.lang.Long houseId;
	private java.lang.String ancRegId;
	private java.lang.Long familyId;
	private java.lang.Long subCentre;
	private java.lang.String phcName;
	private java.lang.String adhaarNo;
	private java.lang.String memberName;
	private java.lang.String nameSubcenter;
	private java.lang.String namePhc;
	private java.lang.String nameOfPregnant;
	private java.lang.String husbandName;
	private java.lang.String address;
	private java.lang.String bplStatus;
	private java.lang.String bplCardNo;
	private java.lang.String cardImage;
	private java.lang.String bankname;
	private java.lang.String ifscCode;
	private java.lang.String accNo;
	private java.lang.Long age;
	private java.util.Date lmpDate;
	private java.lang.String edc;
	private java.lang.String gravida;
	private java.lang.String parity;
	private java.lang.String abortions;
	private java.lang.String pallor;
	private java.lang.String height;
	private java.lang.String weight;
	private java.lang.String bloodPressure;
	private java.math.BigDecimal hb;
	private java.lang.String urineSugar;
	private java.lang.String urineAlbumin;
	private java.lang.String aboRh;
	private java.lang.String hbsag;
	private java.lang.String vdrl;
	private java.lang.String hivStatus;
	private java.lang.String tsh;
	private java.lang.String ultrasound;
	private java.lang.String complication;
	private java.lang.String ancStatus;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgDate;
	private java.lang.String jsyFlag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
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
	 * Return the value associated with the column: house_id
	 */
	public java.lang.Long getHouseId () {
		return houseId;
	}

	/**
	 * Set the value related to the column: house_id
	 * @param houseId the house_id value
	 */
	public void setHouseId (java.lang.Long houseId) {
		this.houseId = houseId;
	}



	/**
	 * Return the value associated with the column: anc_reg_id
	 */
	public java.lang.String getAncRegId () {
		return ancRegId;
	}

	/**
	 * Set the value related to the column: anc_reg_id
	 * @param ancRegId the anc_reg_id value
	 */
	public void setAncRegId (java.lang.String ancRegId) {
		this.ancRegId = ancRegId;
	}



	/**
	 * Return the value associated with the column: family_id
	 */
	public java.lang.Long getFamilyId () {
		return familyId;
	}

	/**
	 * Set the value related to the column: family_id
	 * @param familyId the family_id value
	 */
	public void setFamilyId (java.lang.Long familyId) {
		this.familyId = familyId;
	}



	/**
	 * Return the value associated with the column: sub_centre
	 */
	public java.lang.Long getSubCentre () {
		return subCentre;
	}

	/**
	 * Set the value related to the column: sub_centre
	 * @param subCentre the sub_centre value
	 */
	public void setSubCentre (java.lang.Long subCentre) {
		this.subCentre = subCentre;
	}



	/**
	 * Return the value associated with the column: phc_name
	 */
	public java.lang.String getPhcName () {
		return phcName;
	}

	/**
	 * Set the value related to the column: phc_name
	 * @param phcName the phc_name value
	 */
	public void setPhcName (java.lang.String phcName) {
		this.phcName = phcName;
	}



	/**
	 * Return the value associated with the column: adhaar_no
	 */
	public java.lang.String getAdhaarNo () {
		return adhaarNo;
	}

	/**
	 * Set the value related to the column: adhaar_no
	 * @param adhaarNo the adhaar_no value
	 */
	public void setAdhaarNo (java.lang.String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}



	/**
	 * Return the value associated with the column: member_name
	 */
	public java.lang.String getMemberName () {
		return memberName;
	}

	/**
	 * Set the value related to the column: member_name
	 * @param memberName the member_name value
	 */
	public void setMemberName (java.lang.String memberName) {
		this.memberName = memberName;
	}



	/**
	 * Return the value associated with the column: name_subcenter
	 */
	public java.lang.String getNameSubcenter () {
		return nameSubcenter;
	}

	/**
	 * Set the value related to the column: name_subcenter
	 * @param nameSubcenter the name_subcenter value
	 */
	public void setNameSubcenter (java.lang.String nameSubcenter) {
		this.nameSubcenter = nameSubcenter;
	}



	/**
	 * Return the value associated with the column: name_phc
	 */
	public java.lang.String getNamePhc () {
		return namePhc;
	}

	/**
	 * Set the value related to the column: name_phc
	 * @param namePhc the name_phc value
	 */
	public void setNamePhc (java.lang.String namePhc) {
		this.namePhc = namePhc;
	}



	/**
	 * Return the value associated with the column: name_of_pregnant
	 */
	public java.lang.String getNameOfPregnant () {
		return nameOfPregnant;
	}

	/**
	 * Set the value related to the column: name_of_pregnant
	 * @param nameOfPregnant the name_of_pregnant value
	 */
	public void setNameOfPregnant (java.lang.String nameOfPregnant) {
		this.nameOfPregnant = nameOfPregnant;
	}



	/**
	 * Return the value associated with the column: husband_name
	 */
	public java.lang.String getHusbandName () {
		return husbandName;
	}

	/**
	 * Set the value related to the column: husband_name
	 * @param husbandName the husband_name value
	 */
	public void setHusbandName (java.lang.String husbandName) {
		this.husbandName = husbandName;
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
	 * Return the value associated with the column: bpl_status
	 */
	public java.lang.String getBplStatus () {
		return bplStatus;
	}

	/**
	 * Set the value related to the column: bpl_status
	 * @param bplStatus the bpl_status value
	 */
	public void setBplStatus (java.lang.String bplStatus) {
		this.bplStatus = bplStatus;
	}



	/**
	 * Return the value associated with the column: bpl_card_no
	 */
	public java.lang.String getBplCardNo () {
		return bplCardNo;
	}

	/**
	 * Set the value related to the column: bpl_card_no
	 * @param bplCardNo the bpl_card_no value
	 */
	public void setBplCardNo (java.lang.String bplCardNo) {
		this.bplCardNo = bplCardNo;
	}



	/**
	 * Return the value associated with the column: card_image
	 */
	public java.lang.String getCardImage () {
		return cardImage;
	}

	/**
	 * Set the value related to the column: card_image
	 * @param cardImage the card_image value
	 */
	public void setCardImage (java.lang.String cardImage) {
		this.cardImage = cardImage;
	}



	/**
	 * Return the value associated with the column: bankname
	 */
	public java.lang.String getBankname () {
		return bankname;
	}

	/**
	 * Set the value related to the column: bankname
	 * @param bankname the bankname value
	 */
	public void setBankname (java.lang.String bankname) {
		this.bankname = bankname;
	}



	/**
	 * Return the value associated with the column: ifsc_code
	 */
	public java.lang.String getIfscCode () {
		return ifscCode;
	}

	/**
	 * Set the value related to the column: ifsc_code
	 * @param ifscCode the ifsc_code value
	 */
	public void setIfscCode (java.lang.String ifscCode) {
		this.ifscCode = ifscCode;
	}



	/**
	 * Return the value associated with the column: acc_no
	 */
	public java.lang.String getAccNo () {
		return accNo;
	}

	/**
	 * Set the value related to the column: acc_no
	 * @param accNo the acc_no value
	 */
	public void setAccNo (java.lang.String accNo) {
		this.accNo = accNo;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.Long getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.Long age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: lmp_date
	 */
	public java.util.Date getLmpDate () {
		return lmpDate;
	}

	/**
	 * Set the value related to the column: lmp_date
	 * @param lmpDate the lmp_date value
	 */
	public void setLmpDate (java.util.Date lmpDate) {
		this.lmpDate = lmpDate;
	}



	/**
	 * Return the value associated with the column: edc
	 */
	public java.lang.String getEdc () {
		return edc;
	}

	/**
	 * Set the value related to the column: edc
	 * @param edc the edc value
	 */
	public void setEdc (java.lang.String edc) {
		this.edc = edc;
	}



	/**
	 * Return the value associated with the column: gravida
	 */
	public java.lang.String getGravida () {
		return gravida;
	}

	/**
	 * Set the value related to the column: gravida
	 * @param gravida the gravida value
	 */
	public void setGravida (java.lang.String gravida) {
		this.gravida = gravida;
	}



	/**
	 * Return the value associated with the column: parity
	 */
	public java.lang.String getParity () {
		return parity;
	}

	/**
	 * Set the value related to the column: parity
	 * @param parity the parity value
	 */
	public void setParity (java.lang.String parity) {
		this.parity = parity;
	}



	/**
	 * Return the value associated with the column: abortions
	 */
	public java.lang.String getAbortions () {
		return abortions;
	}

	/**
	 * Set the value related to the column: abortions
	 * @param abortions the abortions value
	 */
	public void setAbortions (java.lang.String abortions) {
		this.abortions = abortions;
	}



	/**
	 * Return the value associated with the column: pallor
	 */
	public java.lang.String getPallor () {
		return pallor;
	}

	/**
	 * Set the value related to the column: pallor
	 * @param pallor the pallor value
	 */
	public void setPallor (java.lang.String pallor) {
		this.pallor = pallor;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.String height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.String getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.String weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: blood_pressure
	 */
	public java.lang.String getBloodPressure () {
		return bloodPressure;
	}

	/**
	 * Set the value related to the column: blood_pressure
	 * @param bloodPressure the blood_pressure value
	 */
	public void setBloodPressure (java.lang.String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}



	/**
	 * Return the value associated with the column: hb
	 */
	public java.math.BigDecimal getHb () {
		return hb;
	}

	/**
	 * Set the value related to the column: hb
	 * @param hb the hb value
	 */
	public void setHb (java.math.BigDecimal hb) {
		this.hb = hb;
	}



	/**
	 * Return the value associated with the column: urine_sugar
	 */
	public java.lang.String getUrineSugar () {
		return urineSugar;
	}

	/**
	 * Set the value related to the column: urine_sugar
	 * @param urineSugar the urine_sugar value
	 */
	public void setUrineSugar (java.lang.String urineSugar) {
		this.urineSugar = urineSugar;
	}



	/**
	 * Return the value associated with the column: urine_albumin
	 */
	public java.lang.String getUrineAlbumin () {
		return urineAlbumin;
	}

	/**
	 * Set the value related to the column: urine_albumin
	 * @param urineAlbumin the urine_albumin value
	 */
	public void setUrineAlbumin (java.lang.String urineAlbumin) {
		this.urineAlbumin = urineAlbumin;
	}



	/**
	 * Return the value associated with the column: abo_rh
	 */
	public java.lang.String getAboRh () {
		return aboRh;
	}

	/**
	 * Set the value related to the column: abo_rh
	 * @param aboRh the abo_rh value
	 */
	public void setAboRh (java.lang.String aboRh) {
		this.aboRh = aboRh;
	}



	/**
	 * Return the value associated with the column: hbsag
	 */
	public java.lang.String getHbsag () {
		return hbsag;
	}

	/**
	 * Set the value related to the column: hbsag
	 * @param hbsag the hbsag value
	 */
	public void setHbsag (java.lang.String hbsag) {
		this.hbsag = hbsag;
	}



	/**
	 * Return the value associated with the column: vdrl
	 */
	public java.lang.String getVdrl () {
		return vdrl;
	}

	/**
	 * Set the value related to the column: vdrl
	 * @param vdrl the vdrl value
	 */
	public void setVdrl (java.lang.String vdrl) {
		this.vdrl = vdrl;
	}



	/**
	 * Return the value associated with the column: hiv_status
	 */
	public java.lang.String getHivStatus () {
		return hivStatus;
	}

	/**
	 * Set the value related to the column: hiv_status
	 * @param hivStatus the hiv_status value
	 */
	public void setHivStatus (java.lang.String hivStatus) {
		this.hivStatus = hivStatus;
	}



	/**
	 * Return the value associated with the column: tsh
	 */
	public java.lang.String getTsh () {
		return tsh;
	}

	/**
	 * Set the value related to the column: tsh
	 * @param tsh the tsh value
	 */
	public void setTsh (java.lang.String tsh) {
		this.tsh = tsh;
	}



	/**
	 * Return the value associated with the column: ultrasound
	 */
	public java.lang.String getUltrasound () {
		return ultrasound;
	}

	/**
	 * Set the value related to the column: ultrasound
	 * @param ultrasound the ultrasound value
	 */
	public void setUltrasound (java.lang.String ultrasound) {
		this.ultrasound = ultrasound;
	}



	/**
	 * Return the value associated with the column: complication
	 */
	public java.lang.String getComplication () {
		return complication;
	}

	/**
	 * Set the value related to the column: complication
	 * @param complication the complication value
	 */
	public void setComplication (java.lang.String complication) {
		this.complication = complication;
	}



	/**
	 * Return the value associated with the column: anc_status
	 */
	public java.lang.String getAncStatus () {
		return ancStatus;
	}

	/**
	 * Set the value related to the column: anc_status
	 * @param ancStatus the anc_status value
	 */
	public void setAncStatus (java.lang.String ancStatus) {
		this.ancStatus = ancStatus;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.lang.String getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.lang.String lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: jsy_flag
	 */
	public java.lang.String getJsyFlag () {
		return jsyFlag;
	}

	/**
	 * Set the value related to the column: jsy_flag
	 * @param jsyFlag the jsy_flag value
	 */
	public void setJsyFlag (java.lang.String jsyFlag) {
		this.jsyFlag = jsyFlag;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhAntenatalRegistrationSurvey)) return false;
		else {
			jkt.hms.masters.business.PhAntenatalRegistrationSurvey phAntenatalRegistrationSurvey = (jkt.hms.masters.business.PhAntenatalRegistrationSurvey) obj;
			if (null == this.getId() || null == phAntenatalRegistrationSurvey.getId()) return false;
			else return (this.getId().equals(phAntenatalRegistrationSurvey.getId()));
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