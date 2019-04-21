package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_anc_survey table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_anc_survey"
 */

public abstract class BasePhAncSurvey  implements Serializable {

	public static String REF = "PhAncSurvey";
	public static String PROP_IFSC_CODE = "IfscCode";
	public static String PROP_EDC_DATE = "EdcDate";
	public static String PROP_CONSENT_TO_EHR = "ConsentToEhr";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_BANK_NAME = "BankName";
	public static String PROP_HUSBAND_NAME = "HusbandName";
	public static String PROP_VDRL = "Vdrl";
	public static String PROP_ANC_STATUS = "AncStatus";
	public static String PROP_MEMBER_ID = "MemberId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HIV_STATUS = "HivStatus";
	public static String PROP_COMPLICATION = "Complication";
	public static String PROP_BPL_CARD_NO = "BplCardNo";
	public static String PROP_HBSAG = "Hbsag";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ULTRASOUND = "Ultrasound";
	public static String PROP_JSY_FLAG = "JsyFlag";
	public static String PROP_PARITY = "Parity";
	public static String PROP_FAMILY_ID = "FamilyId";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_GRAVIDA = "Gravida";
	public static String PROP_SERVER_PK = "ServerPk";
	public static String PROP_BPL_STATUS = "BplStatus";
	public static String PROP_ACC_NO = "AccNo";
	public static String PROP_ABO_RH = "AboRh";
	public static String PROP_ABORTIONS = "Abortions";
	public static String PROP_ANC_REG_ID = "AncRegId";
	public static String PROP_TSH = "Tsh";
	public static String PROP_LIVE = "Live";
	public static String PROP_LMP_DATE = "LmpDate";
	public static String PROP_ID = "Id";
	public static String PROP_CARD_IMAGE = "CardImage";
	public static String PROP_ADHAAR_NO = "AdhaarNo";


	// constructors
	public BasePhAncSurvey () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhAncSurvey (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date regDate;
	private java.lang.Long serverPk;
	private java.lang.Long memberId;
	private java.lang.String ancRegId;
	private java.lang.Long familyId;
	private java.lang.String adhaarNo;
	private java.lang.String husbandName;
	private java.lang.String bplStatus;
	private java.lang.String bplCardNo;
	private java.lang.String cardImage;
	private java.lang.String bankName;
	private java.lang.String ifscCode;
	private java.lang.String accNo;
	private java.util.Date lmpDate;
	private java.util.Date edcDate;
	private java.lang.Long parity;
	private java.lang.Long live;
	private java.lang.Long abortions;
	private java.lang.String aboRh;
	private java.lang.String hbsag;
	private java.lang.String vdrl;
	private java.lang.String hivStatus;
	private java.lang.String tsh;
	private java.lang.String ultrasound;
	private java.lang.String complication;
	private java.lang.String consentToEhr;
	private java.lang.String remarks;
	private java.lang.String jsyFlag;
	private java.lang.String ancStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String gravida;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: bank_name
	 */
	public java.lang.String getBankName () {
		return bankName;
	}

	/**
	 * Set the value related to the column: bank_name
	 * @param bankName the bank_name value
	 */
	public void setBankName (java.lang.String bankName) {
		this.bankName = bankName;
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
	 * Return the value associated with the column: edc_date
	 */
	public java.util.Date getEdcDate () {
		return edcDate;
	}

	/**
	 * Set the value related to the column: edc_date
	 * @param edcDate the edc_date value
	 */
	public void setEdcDate (java.util.Date edcDate) {
		this.edcDate = edcDate;
	}



	/**
	 * Return the value associated with the column: parity
	 */
	public java.lang.Long getParity () {
		return parity;
	}

	/**
	 * Set the value related to the column: parity
	 * @param parity the parity value
	 */
	public void setParity (java.lang.Long parity) {
		this.parity = parity;
	}



	/**
	 * Return the value associated with the column: live
	 */
	public java.lang.Long getLive () {
		return live;
	}

	/**
	 * Set the value related to the column: live
	 * @param live the live value
	 */
	public void setLive (java.lang.Long live) {
		this.live = live;
	}



	/**
	 * Return the value associated with the column: abortions
	 */
	public java.lang.Long getAbortions () {
		return abortions;
	}

	/**
	 * Set the value related to the column: abortions
	 * @param abortions the abortions value
	 */
	public void setAbortions (java.lang.Long abortions) {
		this.abortions = abortions;
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
	 * Return the value associated with the column: consent_to_ehr
	 */
	public java.lang.String getConsentToEhr () {
		return consentToEhr;
	}

	/**
	 * Set the value related to the column: consent_to_ehr
	 * @param consentToEhr the consent_to_ehr value
	 */
	public void setConsentToEhr (java.lang.String consentToEhr) {
		this.consentToEhr = consentToEhr;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhAncSurvey)) return false;
		else {
			jkt.hms.masters.business.PhAncSurvey phAncSurvey = (jkt.hms.masters.business.PhAncSurvey) obj;
			if (null == this.getId() || null == phAncSurvey.getId()) return false;
			else return (this.getId().equals(phAncSurvey.getId()));
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