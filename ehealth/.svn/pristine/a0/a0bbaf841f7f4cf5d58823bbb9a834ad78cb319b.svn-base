package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_intra_operative_time_out table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_intra_operative_time_out"
 */

public abstract class BaseOtIntraOperativeTimeOut  implements Serializable {

	public static String REF = "OtIntraOperativeTimeOut";
	public static String PROP_ANESTHETIC = "Anesthetic";
	public static String PROP_PROC_SITE_CONFRM = "ProcSiteConfrm";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NURSE = "Nurse";
	public static String PROP_CRITICAL_STEPS = "CriticalSteps";
	public static String PROP_CONFIRM_ALL = "ConfirmAll";
	public static String PROP_OT_BOOKING = "OtBooking";
	public static String PROP_SIGN_OUT_STATUS = "SignOutStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SURGICAL_POS = "SurgicalPos";
	public static String PROP_SITE_MARK = "SiteMark";
	public static String PROP_ANTIBIOTIC_PROPHYLAXIS = "AntibioticProphylaxis";
	public static String PROP_SURGEON = "Surgeon";
	public static String PROP_ASSISSTANT = "Assisstant";
	public static String PROP_EQUIP_CONCERN = "EquipConcern";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ANTICIPATED_CRITICAL_EVENT = "AnticipatedCriticalEvent";
	public static String PROP_IDENTITY_CONFIRM = "IdentityConfirm";
	public static String PROP_RALAVANT_IMAGE = "RalavantImage";
	public static String PROP_ADDITIONAL_CONCERN = "AdditionalConcern";
	public static String PROP_CONSENT_CONFRM = "ConsentConfrm";
	public static String PROP_STER_ADDITIONAL_CONCERN = "SterAdditionalConcern";
	public static String PROP_ID = "Id";
	public static String PROP_STERLIZATION_INDICATOR = "SterlizationIndicator";
	public static String PROP_BLOOD_LOSS = "BloodLoss";
	public static String PROP_CASE_DURATION = "CaseDuration";
	public static String PROP_PROCEDURE_CONFIRM = "ProcedureConfirm";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOtIntraOperativeTimeOut () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtIntraOperativeTimeOut (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String identityConfirm;
	private java.lang.String procedureConfirm;
	private java.lang.String procSiteConfrm;
	private java.lang.String consentConfrm;
	private java.lang.String siteMark;
	private java.lang.String ralavantImage;
	private java.lang.String surgicalPos;
	private java.lang.String equipConcern;
	private java.lang.String anticipatedCriticalEvent;
	private java.lang.String criticalSteps;
	private java.lang.String caseDuration;
	private java.lang.String bloodLoss;
	private java.lang.String antibioticProphylaxis;
	private java.lang.String additionalConcern;
	private java.lang.String sterlizationIndicator;
	private java.lang.String sterAdditionalConcern;
	private java.lang.String confirmAll;
	private java.lang.String signOutStatus;
	private java.util.Date lastChgDate;

	// many to one
	private jkt.hms.masters.business.MasEmployee surgeon;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee nurse;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OtBooking otBooking;
	private jkt.hms.masters.business.MasEmployee assisstant;
	private jkt.hms.masters.business.MasEmployee anesthetic;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="intra_op_id"
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
	 * Return the value associated with the column: identity_confirm
	 */
	public java.lang.String getIdentityConfirm () {
		return identityConfirm;
	}

	/**
	 * Set the value related to the column: identity_confirm
	 * @param identityConfirm the identity_confirm value
	 */
	public void setIdentityConfirm (java.lang.String identityConfirm) {
		this.identityConfirm = identityConfirm;
	}



	/**
	 * Return the value associated with the column: procedure_confirm
	 */
	public java.lang.String getProcedureConfirm () {
		return procedureConfirm;
	}

	/**
	 * Set the value related to the column: procedure_confirm
	 * @param procedureConfirm the procedure_confirm value
	 */
	public void setProcedureConfirm (java.lang.String procedureConfirm) {
		this.procedureConfirm = procedureConfirm;
	}



	/**
	 * Return the value associated with the column: proc_site_confrm
	 */
	public java.lang.String getProcSiteConfrm () {
		return procSiteConfrm;
	}

	/**
	 * Set the value related to the column: proc_site_confrm
	 * @param procSiteConfrm the proc_site_confrm value
	 */
	public void setProcSiteConfrm (java.lang.String procSiteConfrm) {
		this.procSiteConfrm = procSiteConfrm;
	}



	/**
	 * Return the value associated with the column: consent_confrm
	 */
	public java.lang.String getConsentConfrm () {
		return consentConfrm;
	}

	/**
	 * Set the value related to the column: consent_confrm
	 * @param consentConfrm the consent_confrm value
	 */
	public void setConsentConfrm (java.lang.String consentConfrm) {
		this.consentConfrm = consentConfrm;
	}



	/**
	 * Return the value associated with the column: site_mark
	 */
	public java.lang.String getSiteMark () {
		return siteMark;
	}

	/**
	 * Set the value related to the column: site_mark
	 * @param siteMark the site_mark value
	 */
	public void setSiteMark (java.lang.String siteMark) {
		this.siteMark = siteMark;
	}



	/**
	 * Return the value associated with the column: ralavant_image
	 */
	public java.lang.String getRalavantImage () {
		return ralavantImage;
	}

	/**
	 * Set the value related to the column: ralavant_image
	 * @param ralavantImage the ralavant_image value
	 */
	public void setRalavantImage (java.lang.String ralavantImage) {
		this.ralavantImage = ralavantImage;
	}



	/**
	 * Return the value associated with the column: surgical_pos
	 */
	public java.lang.String getSurgicalPos () {
		return surgicalPos;
	}

	/**
	 * Set the value related to the column: surgical_pos
	 * @param surgicalPos the surgical_pos value
	 */
	public void setSurgicalPos (java.lang.String surgicalPos) {
		this.surgicalPos = surgicalPos;
	}



	/**
	 * Return the value associated with the column: equip_concern
	 */
	public java.lang.String getEquipConcern () {
		return equipConcern;
	}

	/**
	 * Set the value related to the column: equip_concern
	 * @param equipConcern the equip_concern value
	 */
	public void setEquipConcern (java.lang.String equipConcern) {
		this.equipConcern = equipConcern;
	}



	/**
	 * Return the value associated with the column: anticipated_critical_event
	 */
	public java.lang.String getAnticipatedCriticalEvent () {
		return anticipatedCriticalEvent;
	}

	/**
	 * Set the value related to the column: anticipated_critical_event
	 * @param anticipatedCriticalEvent the anticipated_critical_event value
	 */
	public void setAnticipatedCriticalEvent (java.lang.String anticipatedCriticalEvent) {
		this.anticipatedCriticalEvent = anticipatedCriticalEvent;
	}



	/**
	 * Return the value associated with the column: critical_steps
	 */
	public java.lang.String getCriticalSteps () {
		return criticalSteps;
	}

	/**
	 * Set the value related to the column: critical_steps
	 * @param criticalSteps the critical_steps value
	 */
	public void setCriticalSteps (java.lang.String criticalSteps) {
		this.criticalSteps = criticalSteps;
	}



	/**
	 * Return the value associated with the column: case_duration
	 */
	public java.lang.String getCaseDuration () {
		return caseDuration;
	}

	/**
	 * Set the value related to the column: case_duration
	 * @param caseDuration the case_duration value
	 */
	public void setCaseDuration (java.lang.String caseDuration) {
		this.caseDuration = caseDuration;
	}



	/**
	 * Return the value associated with the column: blood_loss
	 */
	public java.lang.String getBloodLoss () {
		return bloodLoss;
	}

	/**
	 * Set the value related to the column: blood_loss
	 * @param bloodLoss the blood_loss value
	 */
	public void setBloodLoss (java.lang.String bloodLoss) {
		this.bloodLoss = bloodLoss;
	}



	/**
	 * Return the value associated with the column: antibiotic_prophylaxis
	 */
	public java.lang.String getAntibioticProphylaxis () {
		return antibioticProphylaxis;
	}

	/**
	 * Set the value related to the column: antibiotic_prophylaxis
	 * @param antibioticProphylaxis the antibiotic_prophylaxis value
	 */
	public void setAntibioticProphylaxis (java.lang.String antibioticProphylaxis) {
		this.antibioticProphylaxis = antibioticProphylaxis;
	}



	/**
	 * Return the value associated with the column: additional_concern
	 */
	public java.lang.String getAdditionalConcern () {
		return additionalConcern;
	}

	/**
	 * Set the value related to the column: additional_concern
	 * @param additionalConcern the additional_concern value
	 */
	public void setAdditionalConcern (java.lang.String additionalConcern) {
		this.additionalConcern = additionalConcern;
	}



	/**
	 * Return the value associated with the column: sterlization_indicator
	 */
	public java.lang.String getSterlizationIndicator () {
		return sterlizationIndicator;
	}

	/**
	 * Set the value related to the column: sterlization_indicator
	 * @param sterlizationIndicator the sterlization_indicator value
	 */
	public void setSterlizationIndicator (java.lang.String sterlizationIndicator) {
		this.sterlizationIndicator = sterlizationIndicator;
	}



	/**
	 * Return the value associated with the column: ster_additional_concern
	 */
	public java.lang.String getSterAdditionalConcern () {
		return sterAdditionalConcern;
	}

	/**
	 * Set the value related to the column: ster_additional_concern
	 * @param sterAdditionalConcern the ster_additional_concern value
	 */
	public void setSterAdditionalConcern (java.lang.String sterAdditionalConcern) {
		this.sterAdditionalConcern = sterAdditionalConcern;
	}



	/**
	 * Return the value associated with the column: confirm_all
	 */
	public java.lang.String getConfirmAll () {
		return confirmAll;
	}

	/**
	 * Set the value related to the column: confirm_all
	 * @param confirmAll the confirm_all value
	 */
	public void setConfirmAll (java.lang.String confirmAll) {
		this.confirmAll = confirmAll;
	}



	/**
	 * Return the value associated with the column: sign_out_status
	 */
	public java.lang.String getSignOutStatus () {
		return signOutStatus;
	}

	/**
	 * Set the value related to the column: sign_out_status
	 * @param signOutStatus the sign_out_status value
	 */
	public void setSignOutStatus (java.lang.String signOutStatus) {
		this.signOutStatus = signOutStatus;
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
	 * Return the value associated with the column: surgeon_id
	 */
	public jkt.hms.masters.business.MasEmployee getSurgeon () {
		return surgeon;
	}

	/**
	 * Set the value related to the column: surgeon_id
	 * @param surgeon the surgeon_id value
	 */
	public void setSurgeon (jkt.hms.masters.business.MasEmployee surgeon) {
		this.surgeon = surgeon;
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
	 * Return the value associated with the column: nurse_id
	 */
	public jkt.hms.masters.business.MasEmployee getNurse () {
		return nurse;
	}

	/**
	 * Set the value related to the column: nurse_id
	 * @param nurse the nurse_id value
	 */
	public void setNurse (jkt.hms.masters.business.MasEmployee nurse) {
		this.nurse = nurse;
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
	 * Return the value associated with the column: ot_booking_id
	 */
	public jkt.hms.masters.business.OtBooking getOtBooking () {
		return otBooking;
	}

	/**
	 * Set the value related to the column: ot_booking_id
	 * @param otBooking the ot_booking_id value
	 */
	public void setOtBooking (jkt.hms.masters.business.OtBooking otBooking) {
		this.otBooking = otBooking;
	}



	/**
	 * Return the value associated with the column: assisstant_id
	 */
	public jkt.hms.masters.business.MasEmployee getAssisstant () {
		return assisstant;
	}

	/**
	 * Set the value related to the column: assisstant_id
	 * @param assisstant the assisstant_id value
	 */
	public void setAssisstant (jkt.hms.masters.business.MasEmployee assisstant) {
		this.assisstant = assisstant;
	}



	/**
	 * Return the value associated with the column: anesthetic_id
	 */
	public jkt.hms.masters.business.MasEmployee getAnesthetic () {
		return anesthetic;
	}

	/**
	 * Set the value related to the column: anesthetic_id
	 * @param anesthetic the anesthetic_id value
	 */
	public void setAnesthetic (jkt.hms.masters.business.MasEmployee anesthetic) {
		this.anesthetic = anesthetic;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtIntraOperativeTimeOut)) return false;
		else {
			jkt.hms.masters.business.OtIntraOperativeTimeOut otIntraOperativeTimeOut = (jkt.hms.masters.business.OtIntraOperativeTimeOut) obj;
			if (null == this.getId() || null == otIntraOperativeTimeOut.getId()) return false;
			else return (this.getId().equals(otIntraOperativeTimeOut.getId()));
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